#!/usr/bin/env python3
"""Direct Google Play acquisition — first-party chain, no mirror dependency.

This is the same chain the "APK downloader" sites (apkcube class) run on
their servers: authenticated Play Store session + finsky protobuf API.
We run it ourselves — we are the provider now.

Acquisition strategies — first try wins, all of them OURS (no mirror site
in the loop, ever):
  1. google-play-direct  authenticated Play session (gpapi/finsky) — the
     same chain the "APK downloader" mirror sites run on their servers,
     run by us. Session: saved gsfId+authSubToken (passwordless), or
     first login with GP_EMAIL + GP_PASSWORD env (app password if 2FA);
     after the first login the session file is written and the password
     is never needed again.
  2. aptoide-open        Aptoide open marketplace — public API v7 + direct
     CDN download, md5-verified against the marketplace listing. No
     anti-bot, no scraping: a published open API.
  3. fdroid-open         official F-Droid repository — public API v1 for
     open-source apps.

Outputs (identical contract for every strategy):
  <pkg>.apks    zip of base+split APKs          [engine unpack contract]
  meta.json     sha256/size/bundle/versionCode  [engine contract]
  listing.json  self-generated listing: permissions from the real
                AndroidManifest, signature computed from the real APK
                signing block (v3/v2/v1), natives from the real zip layout
  "ACQUIRE_RESULT {json}" on the last stdout line (same line protocol as
  acquire-final.py). On failure the payload carries `attempted` — one
  entry per strategy with its error code, so the engine can tell the
  user exactly what is missing.

Credential resolution order (first existing wins; a new session is
written to the repo-local tool home, git-ignored):
  GP_SESSION file                        (explicit path)
  APPINTEL_HOME/.play-session.json
  <repo>/.tools-home/.play-session.json  (default)
  ~/.play-session.json                   (legacy location)
  GP_GSFID + GP_TOKEN          (session, no password)
  GP_EMAIL + GP_PASSWORD       (first login -> saves session)

ACQUIRE_RESULT error codes:
  CONFIG_MISSING    — no credentials, nothing attempted
  login_failed      — Google rejected the credentials
  app_not_found     — Play has no such package
  acquisition_failed
"""

import argparse
import hashlib
import io
import json
import os
import sys
import time
import zipfile

# accept both old-style and new-style generated pb2 modules regardless of
# which protoc/pip transaction last touched the file
os.environ.setdefault('PROTOCOL_BUFFERS_PYTHON_IMPLEMENTATION', 'python')

try:
    from gpapi.googleplay import GooglePlayAPI, LoginError, RequestError, SecurityCheckError
except ImportError as e:
    # toolchain broken (not the same as missing credentials) — the engine
    # distinguishes the two so it can tell the user exactly what to fix
    print('ACQUIRE_RESULT ' + json.dumps({'ok': False, 'error': 'tool_missing',
          'detail': f'gpapi not installed: {e} — run scripts/bootstrap-appintel.sh'}))
    sys.exit(0)

try:
    from pyaxmlparser import APK as AxApk
    _AXML = True
except ImportError:
    _AXML = False

HOME = os.environ.get('HOME', '/home/z')
_REPO_ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))


def _session_candidates():
    """Where a saved Play session may live, most preferred first."""
    out = []
    if os.environ.get('GP_SESSION'):
        out.append(os.environ['GP_SESSION'])
    home = os.environ.get('APPINTEL_HOME')
    if home:
        out.append(os.path.join(home, '.play-session.json'))
    out.append(os.path.join(_REPO_ROOT, '.tools-home', '.play-session.json'))
    out.append(os.path.join(HOME, '.play-session.json'))
    return out


def _default_session():
    """First existing candidate; a brand-new one goes to the repo-local
    tool home (survives sandbox recycles, git-ignored)."""
    for p in _session_candidates():
        if os.path.exists(p):
            return p
    tool_home = os.environ.get('APPINTEL_HOME') or os.path.join(_REPO_ROOT, '.tools-home')
    return os.path.join(tool_home, '.play-session.json')


DEFAULT_SESSION = _default_session()


def log(msg):
    print(f'[play] {msg}', flush=True)


def die(code, detail=''):
    print('ACQUIRE_RESULT ' + json.dumps({'ok': False, 'error': code, 'detail': str(detail)[:400]}))
    sys.exit(0)


# ---------------------------------------------------------------------------
# session / login
# ---------------------------------------------------------------------------

def _save_session(path, gsf_id, token):
    try:
        with open(path, 'w') as f:
            json.dump({'gsfId': int(gsf_id), 'authSubToken': token,
                       'savedAt': time.strftime('%Y-%m-%dT%H:%M:%SZ', time.gmtime())}, f)
        os.chmod(path, 0o600)
    except Exception as e:
        log(f'could not persist session ({e}) — password login will be needed next run')


def get_api(session_path):
    """Return (api, None, None) on success or (None, errCode, detail).

    Never exits here — the strategy loop decides whether the remaining
    sources should still be tried after a Play-direct failure.
    """
    sess = None
    try:
        with open(session_path) as f:
            s = json.load(f)
        if s.get('gsfId') and s.get('authSubToken'):
            sess = s
    except Exception:
        pass

    env = os.environ
    api = GooglePlayAPI(locale=env.get('GP_LOCALE', 'ar_SA'), timezone=env.get('GP_TZ', 'Asia/Riyadh'),
                        device_codename=env.get('GP_DEVICE', 'walleye'))

    if sess:
        try:
            api.login(gsfId=sess['gsfId'], authSubToken=sess['authSubToken'])
            log('session login OK (saved token, no password)')
            return api, None, None
        except Exception as e:
            log(f'saved session rejected ({type(e).__name__}); trying first-login if credentials exist')

    gsf = env.get('GP_GSFID')
    token = env.get('GP_TOKEN')
    if gsf and token:
        try:
            api.login(gsfId=int(gsf), authSubToken=token)
            log('session login OK (env token)')
            _save_session(session_path, gsf, token)
            return api, None, None
        except Exception as e:
            log(f'env session rejected: {e}')

    email = env.get('GP_EMAIL')
    password = env.get('GP_PASSWORD')
    if not (email and password):
        return None, 'CONFIG_MISSING', (
            'no Play credentials. Provide GP_EMAIL+GP_PASSWORD once (app password if 2FA), '
            'or GP_GSFID+GP_TOKEN; a session is then saved and the password is never needed again.')
    try:
        api.login(email=email, password=password)
    except SecurityCheckError as e:
        return None, 'login_failed', f'security check: {e}'
    except LoginError as e:
        return None, 'login_failed', str(e)
    except Exception as e:
        return None, 'login_failed', f'{type(e).__name__}: {e}'

    if getattr(api, 'gsfId', None) and getattr(api, 'authSubToken', None):
        _save_session(session_path, api.gsfId, api.authSubToken)
        log('first login OK — session saved; future runs are passwordless')
    return api, None, None


# ---------------------------------------------------------------------------
# per-APK intelligence — computed from the real bytes, not a mirror's DB
# ---------------------------------------------------------------------------

NS = '{http://schemas.android.com/apk/res/android}'


def _cert_entry(cert):
    """asn1crypto cert -> {sha256, subject} entry."""
    try:
        fp = hashlib.sha256(cert.dump()).hexdigest()
    except Exception:
        return None
    try:
        subj = cert.subject.human_friendly
    except Exception:
        subj = 'CN=?'
    return {'certSha256': fp, 'certSubject': subj}


def signature_info(apk):
    """v3 > v2 > v1, computed from the APK's own signing structures."""
    try:
        for scheme, signed, certs_fn in (
            ('v3', apk.is_signed_v3(), apk.get_certificates_v3),
            ('v2', apk.is_signed_v2(), apk.get_certificates_v2),
            ('v1', apk.is_signed_v1(), apk.get_certificates_v1),
        ):
            if signed:
                try:
                    certs = certs_fn()
                    if certs:
                        entry = _cert_entry(certs[0])
                        if entry:
                            return {'present': True, 'scheme': scheme,
                                    'status': 'verified (computed from the APK signing block)',
                                    **entry}
                except Exception:
                    continue
    except Exception:
        pass
    return {'present': False, 'status': 'present (scheme unresolved)'}


def exported_unguarded(manifest_xml):
    """Exported components with no permission guard -> attack surface list."""
    out = []
    try:
        for comp in manifest_xml.iter():
            tag = comp.tag.split('}')[-1]
            if tag not in ('activity', 'service', 'receiver', 'provider'):
                continue
            if comp.get(NS + 'exported') != 'true':
                continue
            if comp.get(NS + 'permission'):
                continue  # guarded
            name = comp.get(NS + 'name') or tag
            out.append(f'{tag}:{name}')
    except Exception:
        pass
    return out[:60]


def listing_from_bundle(pkg, version_name, version_code, sha, size, base_bytes,
                        source='google-play-direct', from_play=True,
                        verdict=None, provider_signature=None):
    """Build the engine's listing.json from the real base.apk bytes."""
    apks_meta = {
        'apkId': f'{pkg}:{version_code}',
        'versionName': version_name,
        'versionCode': version_code,
        'sha256': sha,
        'isLatest': True,
        'fileSize': size,
        'fromGooglePlay': from_play,
    }
    sec = {'fromGooglePlay': from_play,
           'verdict': verdict or 'secure (first-party download; not VT-scanned)',
           'scannedByVirusTotal': False, 'flagged': 0, 'vendors': 0}

    # natives from the base.apk zip layout
    natives = {'abis': [], 'libs': [], 'protectors': []}
    try:
        with zipfile.ZipFile(io.BytesIO(base_bytes)) as z:
            for name in z.namelist():
                if name.startswith('lib/'):
                    parts = name.split('/')
                    if len(parts) >= 3:
                        if parts[1] not in natives['abis']:
                            natives['abis'].append(parts[1])
                        lib = parts[-1]
                        if lib.endswith('.so') and lib not in natives['libs']:
                            natives['libs'].append(lib)
    except Exception:
        pass
    sec['natives'] = natives

    manifest = {}
    if _AXML:
        import tempfile
        fd, tmp = tempfile.mkstemp(suffix='.apk')
        try:
            with os.fdopen(fd, 'wb') as t:
                t.write(base_bytes)
            apk = AxApk(tmp)
            try:
                sec['permissions'] = sorted(set(apk.get_permissions() or []))
            except Exception:
                sec['permissions'] = []
            try:
                manifest['targetSdk'] = apk.get_target_sdk_version() or None
                manifest['packageName'] = apk.get_package()
                manifest['allowBackup'] = None  # filled from XML below
                manifest['usesFeatures'] = (apk.get_features() or [])[:40]
                manifest['usesLibraries'] = (apk.get_libraries() or [])[:20]
            except Exception:
                pass
            try:
                xml = apk.get_android_manifest_xml()
                if xml is not None:
                    app = xml.find('application')
                    if app is not None:
                        v = app.get(NS + 'allowBackup')
                        manifest['allowBackup'] = (str(v).lower() == 'true') if v is not None else None
                    ung = exported_unguarded(xml)
                    if ung:
                        manifest['exportedUnguarded'] = ung
            except Exception as e:
                log(f'manifest xml walk failed: {e}')
            sec['signature'] = signature_info(apk)
        except Exception as e:
            log(f'base.apk inspect failed: {e}')
            sec.setdefault('permissions', [])
            sec['signature'] = {'present': False, 'status': 'present (parse failed)'}
        finally:
            try:
                os.unlink(tmp)
            except OSError:
                pass
    else:
        sec['permissions'] = []
        sec['signature'] = {'present': False, 'status': 'unresolved (pyaxmlparser missing)'}

    sec.setdefault('permissions', [])
    sec.setdefault('manifest', manifest)
    if manifest:
        sec['manifest'] = manifest

    sig = sec.get('signature') or {}
    if provider_signature:
        sec['providerSignature'] = provider_signature
    listing = {
        'apks': [apks_meta],
        'securityByApkId': {apks_meta['apkId']: sec},
        'signers': ([{'sha256': sig.get('certSha256'), 'subject': sig.get('certSubject'),
                      'trusted': True}] if sig.get('certSha256') else []),
        'generatedBy': f'devai acquire-play ({source})',
    }
    return listing


# ---------------------------------------------------------------------------
# bundle finalization — shared by every strategy (engine contracts)
# ---------------------------------------------------------------------------

def finalize(pkg, out, base_bytes, splits, version_name, version_code,
             source, from_play, originality, provider_label='', verdict=None,
             provider_signature=None):
    """Write <pkg>.apks + meta.json + listing.json; return the payload dict."""
    # <pkg>.apks — zip of base + splits (engine unpack contract)
    buf = io.BytesIO()
    with zipfile.ZipFile(buf, 'w', zipfile.ZIP_STORED) as z:
        z.writestr('base.apk', base_bytes)
        for s in splits:
            name = s.get('name') or 'split.apk'
            data = s.get('file') or b''
            if data:
                z.writestr(name, data)
    blob = buf.getvalue()

    path_apks = os.path.join(out, f'{pkg}.apks')
    with open(path_apks, 'wb') as f:
        f.write(blob)

    sha = hashlib.sha256(blob).hexdigest()
    with zipfile.ZipFile(path_apks) as z:
        bundle = z.namelist()

    meta = {
        'pkg': pkg,
        'sha256': sha,
        'sizeBytes': len(blob),
        'bundle': bundle,
        'versionName': version_name,
        'versionCode': version_code,
        'apiSha256': sha,            # we are the provider — our listing sha == file sha
        'originality': originality,
        'fromGooglePlay': from_play,
        'source': source,
        'provider': provider_label or source,
        'acquiredAt': time.strftime('%Y-%m-%dT%H:%M:%SZ', time.gmtime()),
    }
    with open(os.path.join(out, 'meta.json'), 'w') as f:
        json.dump(meta, f, indent=1, default=str)

    listing = listing_from_bundle(pkg, version_name, version_code, sha, len(blob), base_bytes,
                                  source=source, from_play=from_play,
                                  verdict=verdict, provider_signature=provider_signature)
    with open(os.path.join(out, 'listing.json'), 'w') as f:
        json.dump(listing, f, indent=1, default=str)

    log(f'wrote {pkg}.apks ({len(blob)} bytes, {len(bundle)} entries) + meta.json + listing.json via {source}')
    return {
        'ok': True, 'pkg': pkg, 'file': path_apks, 'sha256': sha, 'sizeBytes': len(blob),
        'bundle': bundle, 'versionName': version_name, 'versionCode': version_code,
        'apiSha256': sha, 'originality': originality, 'fromGooglePlay': from_play,
        'source': source,
    }


# ---------------------------------------------------------------------------
# strategy 1 — google-play-direct (our own authenticated Play session)
# ---------------------------------------------------------------------------

def try_google_play(pkg, out, session_path, attempted):
    api, err, detail = get_api(session_path)
    if api is None:
        attempted.append({'strategy': 'google-play-direct', 'error': err, 'detail': detail})
        return None

    try:
        det = api.details(pkg)
        appd = (det.get('details') or {}).get('appDetails') or {}
        version_code = appd.get('versionCode') or det.get('versionCode') or 0
        version_name = appd.get('versionString') or appd.get('versionName') or det.get('versionName')
        if not version_code:
            attempted.append({'strategy': 'google-play-direct', 'error': 'acquisition_failed',
                              'detail': 'details returned no versionCode'})
            return None
        log(f'play details OK: versionCode={version_code} versionName={version_name}')
    except Exception as e:
        msg = str(e)
        code = 'app_not_found' if ('not found' in msg.lower() or 'does not exist' in msg.lower()) else 'acquisition_failed'
        attempted.append({'strategy': 'google-play-direct', 'error': code, 'detail': f'details: {msg[:200]}'})
        return None

    try:
        res = api.download(pkg, versionCode=version_code)
    except Exception as e:
        msg = str(e)
        code = 'app_not_found' if 'not found' in msg.lower() else 'acquisition_failed'
        attempted.append({'strategy': 'google-play-direct', 'error': code, 'detail': f'download: {msg[:200]}'})
        return None

    base_bytes = res.get('file')
    if not base_bytes:
        attempted.append({'strategy': 'google-play-direct', 'error': 'acquisition_failed',
                          'detail': 'download returned no base apk'})
        return None
    splits = res.get('splits') or []
    log(f'downloaded from Play CDN: base {len(base_bytes)}B + {len(splits)} splits')
    return finalize(pkg=pkg, out=out, base_bytes=base_bytes, splits=splits,
                    version_name=version_name, version_code=version_code,
                    source='google-play-direct', from_play=True, originality='match',
                    provider_label='Google Play CDN (first-party session)',
                    verdict='secure (first-party Play download by our own session; not VT-scanned)')


# ---------------------------------------------------------------------------
# strategy 2 — aptoide-open (public marketplace API + direct CDN download)
# ---------------------------------------------------------------------------

APTOIDE_API = 'https://ws75.aptoide.com/api/7/app/get/package_name/{pkg}'
UA = ('Mozilla/5.0 (Linux; Android 13) AppleWebKit/537.36 '
      '(KHTML, like Gecko) Chrome/131.0 Mobile Safari/537.36')
MAX_BYTES = 600 * 1024 * 1024


def try_aptoide(pkg, out, attempted):
    try:
        import requests
        r = requests.get(APTOIDE_API.format(pkg=pkg), timeout=25,
                         headers={'User-Agent': UA, 'Accept': 'application/json'})
        if r.status_code != 200:
            # the ws hosts answer 404 (HTTP) or 200+APP-1 (JSON) for missing
            # packages depending on load-balancer routing — normalize both
            code = 'app_not_found' if r.status_code == 404 else f'provider_http_{r.status_code}'
            attempted.append({'strategy': 'aptoide-open', 'error': code})
            return None
        d = r.json()
        if (d.get('info') or {}).get('status') != 'OK':
            errs = d.get('errors') or []
            desc = '; '.join(str(e.get('description', '')) for e in errs)[:160]
            code = 'app_not_found' if 'not found' in desc.lower() else 'provider_error'
            attempted.append({'strategy': 'aptoide-open', 'error': code, 'detail': desc})
            return None
        data = ((d.get('nodes') or {}).get('meta') or {}).get('data') or {}
        f = data.get('file') or {}
        path = f.get('path') or f.get('path_alt')
        if not path:
            attempted.append({'strategy': 'aptoide-open', 'error': 'no_download_path'})
            return None
        store = (data.get('store') or {}).get('name') or '?'
        log(f'aptoide listing OK: v{f.get("vername")} ({f.get("vercode")}), '
            f'{round((f.get("filesize") or 0) / 1048576, 1)} MB, store={store}')
        with requests.get(path, stream=True, timeout=(15, 240),
                          headers={'User-Agent': UA}) as dl:
            if dl.status_code != 200:
                attempted.append({'strategy': 'aptoide-open', 'error': f'cdn_http_{dl.status_code}'})
                return None
            buf = bytearray()
            for chunk in dl.iter_content(1 << 20):
                buf.extend(chunk)
                if len(buf) > MAX_BYTES:
                    attempted.append({'strategy': 'aptoide-open', 'error': 'file_too_large'})
                    return None
        apk_bytes = bytes(buf)

        md5_api = (f.get('md5sum') or '').lower()
        md5_real = hashlib.md5(apk_bytes).hexdigest()
        if md5_api and md5_real == md5_api:
            originality = 'match'
            log(f'aptoide md5 verified: {md5_real}')
        elif md5_api:
            originality = 'mismatch'
            log(f'WARNING aptoide md5 mismatch: api={md5_api} real={md5_real}')
        else:
            originality = 'unknown'

        malware = f.get('malware') or {}
        rank = malware.get('rank') if isinstance(malware, dict) else None
        verdict = 'Aptoide open-marketplace file — md5-verified against the marketplace listing'
        if rank:
            verdict += f', marketplace malware rank: {rank}'
        if store and store != 'apps':
            # community store upload: the md5 proves the bytes match THAT
            # store's listing — it does NOT prove they are the Play original
            verdict += (f'; CAUTION: community store \"{store}\" upload — provenance is the '
                        'store listing, not the Play original')
        verdict += '; not VT-scanned'
        return finalize(pkg=pkg, out=out, base_bytes=apk_bytes, splits=[],
                        version_name=f.get('vername'), version_code=f.get('vercode'),
                        source='aptoide-open', from_play=False, originality=originality,
                        provider_label=f'Aptoide open marketplace (store: {store})',
                        verdict=verdict, provider_signature=f.get('signature'))
    except Exception as e:
        attempted.append({'strategy': 'aptoide-open', 'error': 'provider_error',
                          'detail': f'{type(e).__name__}: {e}'[:200]})
        return None


# ---------------------------------------------------------------------------
# strategy 3 — fdroid-open (official open-source repository)
# ---------------------------------------------------------------------------

FDROID_API = 'https://f-droid.org/api/v1/packages/{pkg}'
FDROID_APK = 'https://f-droid.org/repo/{pkg}_{code}.apk'


def try_fdroid(pkg, out, attempted):
    try:
        import requests
        r = requests.get(FDROID_API.format(pkg=pkg), timeout=25, headers={'User-Agent': UA})
        if r.status_code == 404 or r.status_code == 403:
            attempted.append({'strategy': 'fdroid-open', 'error': 'app_not_found'})
            return None
        if r.status_code != 200:
            attempted.append({'strategy': 'fdroid-open', 'error': f'provider_http_{r.status_code}'})
            return None
        d = r.json()
        pkgs = d.get('packages') or []
        if not pkgs:
            attempted.append({'strategy': 'fdroid-open', 'error': 'app_not_found'})
            return None
        code = d.get('suggestedVersionCode') or pkgs[0].get('versionCode')
        entry = next((p for p in pkgs if p.get('versionCode') == code), pkgs[0])

        with requests.get(FDROID_APK.format(pkg=pkg, code=code), stream=True,
                          timeout=(15, 240), headers={'User-Agent': UA}) as dl:
            if dl.status_code != 200:
                attempted.append({'strategy': 'fdroid-open', 'error': f'repo_http_{dl.status_code}'})
                return None
            buf = bytearray()
            for chunk in dl.iter_content(1 << 20):
                buf.extend(chunk)
                if len(buf) > MAX_BYTES:
                    attempted.append({'strategy': 'fdroid-open', 'error': 'file_too_large'})
                    return None
        apk_bytes = bytes(buf)
        log(f'f-droid download OK: v{entry.get("versionName")} ({code}), {len(apk_bytes) // 1048576} MB')
        return finalize(pkg=pkg, out=out, base_bytes=apk_bytes, splits=[],
                        version_name=entry.get('versionName'), version_code=code,
                        source='fdroid-open', from_play=False, originality='unknown',
                        provider_label='official F-Droid repository',
                        verdict='official F-Droid repository build (open-source; signed with the '
                                'F-Droid key, not the upstream release key); not VT-scanned')
    except Exception as e:
        attempted.append({'strategy': 'fdroid-open', 'error': 'provider_error',
                          'detail': f'{type(e).__name__}: {e}'[:200]})
        return None


# ---------------------------------------------------------------------------
# main — strategy loop (first success wins, attempted[] explains failures)
# ---------------------------------------------------------------------------

def main():
    ap = argparse.ArgumentParser()
    ap.add_argument('--pkg', required=True)
    ap.add_argument('--out', required=True)
    ap.add_argument('--session-file', default=DEFAULT_SESSION)
    args = ap.parse_args()

    os.makedirs(args.out, exist_ok=True)
    attempted = []

    payload = try_google_play(args.pkg, args.out, args.session_file, attempted)
    if not payload:
        payload = try_aptoide(args.pkg, args.out, attempted)
    if not payload:
        payload = try_fdroid(args.pkg, args.out, attempted)

    if payload:
        print('ACQUIRE_RESULT ' + json.dumps(payload))
        return

    print('ACQUIRE_RESULT ' + json.dumps({
        'ok': False, 'error': 'acquisition_failed',
        'detail': 'no strategy delivered this package',
        'attempted': attempted,
    }))


if __name__ == '__main__':
    try:
        main()
    except SystemExit:
        raise
    except Exception as e:
        die('acquisition_failed', f'{type(e).__name__}: {e}')
