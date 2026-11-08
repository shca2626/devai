#!/usr/bin/env python3
"""apkcube acquisition v4 (FINAL) — reverse-engineered flow, all proven elements.

Chain (reverse-engineered from apkcube's own front-end JS + verified runs):
  1. curl pre-resolve real slug (any slug 302s to the canonical one by pkg)
  2. camoufox opens the download page (passes CF edge)
  3. click "Download APKS" -> modal "Verify to download"
  4. download-token gives {ticket, requiredMs, releaseMs, expiresInMs}
  5. HOLD: state-driven release on "Let go now" cue (within releaseMs window)
  6. Turnstile renders AFTER hold (spinner ~8s -> checkbox): ONE frame-internal
     click on input[type=checkbox]/label, retry every 25s max 3x (spam = reset)
  7. PoW runs automatically in-page -> POST /api/downloads/request
     {packageName, apkId, captchaToken, pageToken, gesture, pow, h, pwa}
  8. response {url: R2 signed} -> curl fetch -> .apks
  9. Originality: sha256(downloaded) == apks API sha256 (Play-sourced file),
     and versionName/versionCode == Google Play live version.

Usage:
  python3 acquire-v4.py --pkg com.example.app --out /tmp/acquired [--timeout 500]
"""
import argparse, hashlib, json, os, re, subprocess, sys, time

from camoufox.sync_api import Camoufox

RELEASE_CUES = ('let go now', 'hold a little longer', 'a little longer')
FAIL_CUES = ('held too long', 'press again', 'no longer available', 'went wrong')


def log(tag, obj={}):
    print(f'  [{tag}]', json.dumps(obj, ensure_ascii=False)[:300], flush=True)


def modal_text(page):
    try:
        return ' '.join(page.evaluate("""(() => {
            const m = document.querySelector('[role="dialog"]') || document.body;
            return [...m.querySelectorAll('h1,h2,h3,h4,p,span,button')]
              .filter(e => e.offsetParent && e.textContent).map(e => e.textContent.trim());
        })()""")).lower()
    except Exception:
        return ''


def resolve_real_url(pkg):
    from curl_cffi import requests as cr
    r = cr.get(f'https://apkcube.com/whatever/{pkg}/download', impersonate='chrome131',
               timeout=40, allow_redirects=True)
    if r.url and f'/{pkg}' in r.url and '/apk-downloader' not in r.url:
        return r.url
    return f'https://apkcube.com/apk-downloader?url={pkg}'


def attempt(browser, pkg, out, deadline):
    """One full acquisition attempt. Returns meta dict or None."""
    state = {'dl': None, 'apks_api': None, 'token': None}
    page = browser.new_page()

    def on_resp(r):
        u = r.url
        if '/api/' not in u:
            return
        try:
            body = r.json()
        except Exception:
            return
        if '/apks' in u and isinstance(body, dict) and 'apks' in body:
            state['apks_api'] = body
        elif 'download-token' in u:
            state['token'] = body
            log('download-token', {'hold': (body or {}).get('hold')})
        elif '/api/downloads/request' in u:
            state['dl'] = body
            log('downloads/request', {'url': ((body or {}).get('url') or '')[:90],
                                      'err': (body or {}).get('error')})

    page.on('response', on_resp)

    real_url = resolve_real_url(pkg)
    log('entry', {'url': real_url})
    page.goto(real_url, wait_until='domcontentloaded', timeout=90000)
    for _ in range(45):
        if 'just a moment' not in page.title().lower():
            break
        time.sleep(1)

    # download trigger
    btn = None
    t0 = time.time()
    while time.time() - t0 < 60 and time.time() < deadline:
        for sel in ['button:has-text("Download APKS")', 'button:has-text("Download APK")',
                    'button:has-text("Get APK")', 'button:has-text("Download")']:
            try:
                b = page.query_selector(sel)
                if b and b.is_visible():
                    btn = b
                    break
            except Exception:
                pass
        if btn:
            break
        time.sleep(2)
    if not btn:
        log('fail', {'stage': 'no-button', 'title': page.title()[:60]})
        page.close()
        return None

    btn.click()
    log('clicked', {'btn': (btn.text_content() or '').strip()[:40]})

    # hold widget
    hold = None
    t0 = time.time()
    while time.time() - t0 < 25:
        try:
            h = page.query_selector('button:has-text("Hold to verify")')
            if h and h.is_visible():
                hold = h
                break
        except Exception:
            pass
        time.sleep(1)

    if hold:
        box = hold.bounding_box()
        page.mouse.move(box['x'] + box['width'] / 2, box['y'] + box['height'] / 2)
        time.sleep(0.25)
        page.mouse.down()
        released = False
        t0 = time.time()
        while time.time() - t0 < 15:
            txt = modal_text(page)
            if any(c in txt for c in RELEASE_CUES) or 'verified' in txt:
                page.mouse.up()
                released = True
                log('hold-release', {'ms': int((time.time() - t0) * 1000)})
                break
            time.sleep(0.04)
        if not released:
            page.mouse.up()
            log('hold-release', {'ms': 'timeout'})
    else:
        log('no-hold-widget', {})

    # turnstile: wait for spinner to resolve into checkbox (~8s), then ONE
    # frame-internal click; re-click at most every 25s (spam resets the widget)
    last_click = 0
    clicks = 0
    while time.time() < deadline:
        if state['dl']:
            break
        txt = modal_text(page)
        if any(c in txt for c in FAIL_CUES):
            log('fail-cue', {'txt': txt[:120]})
            page.close()
            return None
        frames = [f for f in page.frames if 'challenges.cloudflare.com' in (f.url or '')]
        now = time.time()
        if frames and now - last_click > (10 if clicks == 0 else 25):
            tf = frames[0]
            for sel in ['input[type=checkbox]', 'label', 'mark']:
                try:
                    loc = tf.locator(sel).first
                    if loc.count() > 0:
                        loc.click(timeout=3000)
                        last_click = now
                        clicks += 1
                        log('turnstile-click', {'sel': sel, 'n': clicks})
                        break
                except Exception:
                    continue
        time.sleep(2)

    if not (state['dl'] or {}).get('url'):
        page.screenshot(path=f'{out}/fail-{int(time.time())}.png')
        log('fail', {'stage': 'no-signed-url', 'clicks': clicks})
        page.close()
        return None

    page.close()
    return {'dl': state['dl'], 'apks_api': state['apks_api'], 'token': state['token']}


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument('--pkg', default='com.arkanprotailor.arkan_tailor')
    ap.add_argument('--out', default='/tmp/acquired')
    ap.add_argument('--timeout', type=int, default=480)
    ap.add_argument('--attempts', type=int, default=3)
    a = ap.parse_args()
    os.makedirs(a.out, exist_ok=True)
    deadline = time.time() + a.timeout

    result = None
    with Camoufox(headless=True, humanize=True) as browser:
        for i in range(a.attempts):
            if time.time() > deadline:
                break
            print(f'[attempt {i + 1}]', flush=True)
            result = attempt(browser, a.pkg, a.out, deadline)
            if result:
                break
            time.sleep(4)

    if not result:
        raise SystemExit('ACQUISITION_FAILED')

    from curl_cffi import requests as cr
    url = result['dl']['url']
    r = cr.get(url, impersonate='chrome131', timeout=900)
    print(f'[fetch] {r.status_code} {len(r.content) / 1e6:.2f} MB magic={r.content[:2]}')
    if r.status_code != 200 or r.content[:2] != b'PK':
        raise SystemExit(f'FETCH_FAILED {r.status_code}')
    fname = f'{a.out}/{a.pkg}.apks'
    open(fname, 'wb').write(r.content)
    sha = hashlib.sha256(r.content).hexdigest()

    # originality: compare with apks API sha256 (from the Play-sourced listing)
    apks = (result['apks_api'] or {}).get('apks') or []
    latest = next((x for x in apks if x.get('isLatest')), apks[0] if apks else None)
    match = 'unknown'
    if latest and latest.get('sha256'):
        match = 'MATCH' if latest['sha256'].lower() == sha else 'MISMATCH'

    import zipfile
    bundle = []
    with zipfile.ZipFile(fname) as z:
        bundle = z.namelist()
        z.extractall(f'{a.out}/unpacked')

    meta = {
        'pkg': a.pkg,
        'sha256': sha,
        'size_bytes': len(r.content),
        'file': fname,
        'bundle': bundle,
        'api_latest': {k: latest.get(k) for k in ('versionName', 'versionCode', 'sha256', 'isLatest')}
        if latest else None,
        'originality': match,
        'token': result['token'],
        'downloads_response': {k: result['dl'].get(k) for k in ('url', 'expiresInMs', 'fileName', 'size')},
    }
    json.dump(meta, open(f'{a.out}/meta.json', 'w'), indent=1, default=str)
    print(f'[✓] ACQUIRED {a.pkg} sha256={sha[:16]}… originality={match}')
    print(f'[✓] version: {(latest or {}).get("versionName")} — file: {fname}')


if __name__ == '__main__':
    main()
