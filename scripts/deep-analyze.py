#!/usr/bin/env python3
"""Deep static analysis for App Intelligence.

Turns the acquired bundle (base.apk + splits) and the jadx source pass into
structured, expert-level intelligence:

  1. endpoint classification  — every URL gets a kind + a purpose + evidence
  2. local database intel     — SQLite schema from asset .db files + CREATE
                                TABLE strings recovered from Dart AOT / sources
  3. sync architecture        — offline/online strategy signals (queues, FCM,
                                workmanager, websockets, connectivity checks)
  4. API surface              — REST paths, HTTP clients, auth methods, models
  5. module map               — Controllers/Services/Repositories/Screens from
                                Dart AOT / JVM class names (what the app IS)

Generalizes across Flutter (libapp.so), React Native (index.android.bundle),
Cordova (assets/www) and native Java/Kotlin (jadx sources).

Usage:
  python3 deep-analyze.py --dir <workdir> [--developer-domain example.com]
                          [--json out.json]

Reads  : <dir>/unpacked/*.apk, <dir>/jadx/sources/**
Writes : deep-intel JSON to stdout (or --json path)
"""

import argparse
import collections
import glob
import io
import json
import os
import re
import sqlite3
import sys
import tempfile
import zipfile

# --------------------------------------------------------------------------
# classification knowledge
# --------------------------------------------------------------------------

# hosts that are part of frameworks/toolchains — never the app's own backend.
# each entry: reason a senior engineer would give.
FRAMEWORK_NOISE = {
    'pub.dev': 'Dart package registry — dependency metadata baked into the release build, not a runtime call',
    'flutter.dev': 'Flutter framework documentation link (engine/ LICENSE or about strings)',
    'dart.dev': 'Dart SDK documentation link (engine strings)',
    'api.flutter.dev': 'Flutter API documentation reference',
    'github.com/flutter': 'Flutter framework issue tracker link embedded in engine license text — framework noise, not app code',
    'www.ibm.com': 'XHTML transitional DTD fallback bundled inside XML parser stacks — parser boilerplate, never fetched',
    'www.w3.org': 'W3C DTD/XML-schema namespace referenced by XML parsers — parser boilerplate',
    'schemas.android.com': 'Android manifest XML namespace — static manifest reference',
    'xml.org': 'XML catalog reference from bundled parsers',
    'www.apache.org': 'Apache license text reference (bundled OSS licenses)',
    'openssl.org': 'OpenSSL license/repository reference (bundled crypto stack)',
    'sqlite.org': 'SQLite documentation reference (bundled database engine)',
    'www.sqlite.org': 'SQLite documentation reference (bundled database engine)',
    'chromium.org': 'Chromium/webview license references',
    'mozilla.org': 'Bundled Mozilla license text',
    'unicode.org': 'Unicode data references (text stack licenses/copyright)',
    'ietf.org': 'RFC references in protocol implementations',
    'tools.ietf.org': 'RFC references in protocol implementations',
    'www.rfc-editor.org': 'RFC references in protocol implementations',
    'example.com': 'Placeholder domain from documentation strings',
    'localhost': 'Development placeholder',
    'json-schema.org': 'JSON schema namespace (validation boilerplate)',
    'googleapis.com': 'Google API endpoints pulled in by SDK dependencies (not the app backend)',
    'google.com': 'Google SDK endpoints (auth/ads/update checks pulled in by dependencies)',
    'gstatic.com': 'Google static infrastructure (SDK dependencies)',
    'firebaseio.com': 'Firebase SDK endpoints (if no firebase_* package is present it is SDK residue)',
    'crashlytics.com': 'Crashlytics SDK endpoint (dependency residue)',
    'android.com': 'Android SDK documentation/play-services references',
    'play.google.com': 'Google Play deep link (store/about page)',
    'ns.adobe.com': 'XMP metadata namespace (image metadata parser)',
    'purl.org': 'Dublin Core metadata namespace',
    'www.purl.org': 'Dublin Core metadata namespace',
}

SOCIAL_HOSTS = {
    'facebook.com': 'Facebook page link (about/share/developer profile)',
    'm.facebook.com': 'Facebook page link (about/share/developer profile)',
    'twitter.com': 'Twitter/X profile link (about/share/developer profile)',
    'x.com': 'Twitter/X profile link (about/share/developer profile)',
    'instagram.com': 'Instagram profile link (about/share/developer profile)',
    'youtube.com': 'YouTube channel link (about/share/developer profile)',
    't.me': 'Telegram channel link (about/support)',
    'linkedin.com': 'LinkedIn profile link (about/share)',
    'tiktok.com': 'TikTok profile link (about/share)',
    'wa.me': 'WhatsApp deep link (support channel)',
    'api.whatsapp.com': 'WhatsApp click-to-chat link (support/sales channel)',
    'ko-fi.com': 'donation/support page (fundraising link, not a runtime integration)',
    'patreon.com': 'donation/support page (fundraising link, not a runtime integration)',
    'liberapay.com': 'donation/support page (fundraising link, not a runtime integration)',
}

# documentation / protocol-spec hosts — informative but not runtime endpoints
DOCS_HOSTS = {
    'spec.matrix.org': 'Matrix protocol specification reference (the app speaks the Matrix protocol)',
    'matrix.org': 'Matrix protocol homepage (protocol reference)',
    'developer.android.com': 'Android developer documentation reference',
    'developers.google.com': 'Google developer documentation reference',
    'docs.flutter.dev': 'Flutter documentation reference',
    'api.dart.dev': 'Dart API documentation reference',
    'microg.org': 'microG integration reference (FOSS Google-services replacement)',
    'unifiedpush.org': 'UnifiedPush integration reference (FOSS push notifications)',
    'openstreetmap.org': 'OpenStreetMap map/location link (geo feature)',
    'osm.org': 'OpenStreetMap map/location link (geo feature)',
}

# words that make a path look like a REST route
API_WORDS = re.compile(
    r'^/?v?\d?/?(api|auth|login|logout|register|signup|token|refresh|user|users|profile|account|'
    r'product|products|item|items|category|categories|stock|inventory|warehouse|'
    r'order|orders|invoice|invoices|receipt|receipts|sale|sales|purchase|purchases|refund|refunds|payment|payments|'
    r'customer|customers|client|clients|supplier|suppliers|branch|branches|store|stores|shop|shops|'
    r'expense|expenses|report|reports|statistics|stats|dashboard|setting|settings|config|'
    r'sync|upload|download|export|import|backup|restore|push|pull|'
    r'notification|notifications|message|messages|chat|otp|verify|forgot|reset|password|'
    r'coupon|coupons|offer|offers|discount|tax|currency|role|permission|audit|log)(/|$|_|-)'
)

SQL_SELECT_RE = re.compile(
    r'(SELECT\s+[^;{}]{5,300}?\s+FROM\s+[a-zA-Z_][a-zA-Z0-9_]{1,40}|'
    r'INSERT\s+INTO\s+[a-zA-Z_][a-zA-Z0-9_]{1,40}|'
    r'UPDATE\s+[a-zA-Z_][a-zA-Z0-9_]{1,40}\s+SET|'
    r'DELETE\s+FROM\s+[a-zA-Z_][a-zA-Z0-9_]{1,40})', re.I)
CREATE_TABLE_RE = re.compile(
    r'CREATE\s+TABLE\s+(?:IF\s+NOT\s+EXISTS\s+)?["`]?([a-zA-Z_][a-zA-Z0-9_]*)["`]?\s*\(([^)]{10,600})', re.I)

CLASS_SUFFIX_RE = re.compile(
    r'\b([A-Z][A-Za-z0-9]{2,28}(?:Controller|Service|Repository|Provider|Bloc|Cubit|Adapter|Handler|Manager|Helper|Utils?|Model|Entity|Dto|DTO|Response|Request|Screen|Page|View|Fragment|Dialog|Widget|Api|Client|Interceptor|Delegate|DataSource|UseCase))\b')

PATH_TOKEN_RE = re.compile(
    r'(?<![A-Za-z0-9_/.])/(api|v[12]|auth|login|register|token|users?|products?|items?|categories|stock|inventory|orders?|invoices?|receipts?|sales?|purchases?|refunds?|payments?|customers?|clients?|suppliers?|branches|stores?|shops?|expenses?|reports?|statistics|dashboard|settings?|config|sync|upload|download|export|import|backup|notifications?|messages?|chat|otp|verify|password|coupons?|offers?|discounts?|taxes|currencies|roles?|permissions?|audits?|logs?)((/[A-Za-z0-9_\-{}.]{1,30}){0,3})')

DART_PKG_RE = re.compile(r'package:([a-z0-9_]+)/')

# technology signals → what they mean for the sync/offline story
SYNC_SIGNALS = {
    # storage engines
    'sqflite': ('local SQLite database (Flutter sqflite)', 'offline storage'),
    'drift': ('Drift (Moor) reactive SQLite layer', 'offline storage'),
    'sqlite_flutter_libs': ('SQLite native bindings', 'offline storage'),
    'floor': ('Floor (Room-like SQLite ORM)', 'offline storage'),
    'hive': ('Hive lightweight NoSQL box store', 'offline storage'),
    'isar': ('Isar NoSQL embedded database', 'offline storage'),
    'shared_preferences': ('key-value preferences store', 'offline storage'),
    'flutter_secure_storage': ('encrypted key-value store (Keystore-backed)', 'offline storage / token storage'),
    'objectbox': ('ObjectBox embedded NoSQL database', 'offline storage'),
    'realm': ('Realm embedded database', 'offline storage'),
    'couchbase': ('Couchbase Lite embedded sync database', 'offline storage + sync engine'),
    # connectivity / sync
    'connectivity_plus': ('network reachability checks (drives online/offline switching)', 'sync orchestration'),
    'internet_connection_checker': ('network reachability checks', 'sync orchestration'),
    'workmanager': ('background job scheduler (deferred sync queues)', 'sync orchestration'),
    'background_fetch': ('periodic background fetch (sync heartbeat)', 'sync orchestration'),
    'firebase_messaging': ('Firebase Cloud Messaging push channel (server-initiated sync triggers)', 'realtime/push'),
    'socket_io_client': ('Socket.IO realtime channel', 'realtime/push'),
    'web_socket_channel': ('WebSocket realtime channel', 'realtime/push'),
    'graphql': ('GraphQL client (queries/mutations/subscriptions)', 'api client'),
    'dio': ('Dart dio HTTP client (interceptors, retries)', 'api client'),
    'http': ('Dart http client', 'api client'),
    'retrofit': ('Retrofit-typed REST layer', 'api client'),
    'okhttp': ('OkHttp network stack', 'api client'),
    'cachemanager': ('cached_network_image cache manager', 'caching'),
    'flutter_cache_manager': ('file cache manager', 'caching'),
}

# JVM-side signals (native / RN apps, from jadx sources)
JVM_SIGNALS = {
    'WorkManager': ('WorkManager background jobs (deferred sync queues)', 'sync orchestration'),
    'JobScheduler': ('JobScheduler background jobs', 'sync orchestration'),
    'FirebaseMessagingService': ('FCM push receiver (server-initiated sync triggers)', 'realtime/push'),
    'WebSocket': ('WebSocket realtime channel', 'realtime/push'),
    'SyncAdapter': ('Android SyncAdapter framework', 'sync orchestration'),
    'ContentProvider': ('ContentProvider data layer', 'offline storage'),
    'RoomDatabase': ('Room persistence (SQLite ORM)', 'offline storage'),
    'androidx.room': ('Room persistence (SQLite ORM)', 'offline storage'),
    'SQLiteDatabase': ('raw SQLite storage', 'offline storage'),
    'Retrofit': ('Retrofit-typed REST layer', 'api client'),
    'OkHttpClient': ('OkHttp network stack', 'api client'),
    'Volley': ('Volley request queue', 'api client'),
    'Jwt': ('JWT token handling', 'auth'),
    'OAuth': ('OAuth flow', 'auth'),
}

AUTH_SIGNALS = {
    'firebase_auth': 'Firebase Authentication',
    'google_sign_in': 'Google Sign-In',
    'sign_in_with_apple': 'Sign in with Apple',
    'local_auth': 'biometric / device-credential unlock',
    'flutter_secure_storage': 'encrypted token storage',
    'jwt': 'JWT bearer tokens',
    'oauth': 'OAuth 2.0 flow',
    'refresh_token': 'refresh-token rotation',
    'access_token': 'bearer access tokens',
}


def classify_url(url, developer_domain):
    """Return (kind, purpose) for a URL — the 'so what does it DO' answer."""
    try:
        m = re.match(r'https?://([^/]+)(/[^?#]*)?', url)
        if not m:
            return ('review', 'unparseable URL fragment')
        host, path = m.group(1).lower(), (m.group(2) or '').lower()
    except Exception:
        return ('review', 'unparseable URL fragment')

    # 0. documentation / protocol-spec hosts
    for doc_host, reason in DOCS_HOSTS.items():
        if host == doc_host or host.endswith('.' + doc_host):
            return ('docs', reason)
    # 1. framework / toolchain noise (exact host or suffix match)
    for noise_host, reason in FRAMEWORK_NOISE.items():
        if host == noise_host or host.endswith('.' + noise_host):
            return ('framework-noise', reason)
    # github.com special case: framework issue links are noise, but an app's
    # own repo link is a social/developer link
    if host in ('github.com', 'raw.githubusercontent.com'):
        if '/flutter/' in path or '/dart-lang/' in path or '/google/' in path:
            return ('framework-noise', 'framework/engine repository link from bundled license text — not app code')
        return ('social', 'developer repository link (about/support page)')

    # 2. social profiles — but an api.* subdomain or /api/ path is an API, not a profile
    for social, reason in SOCIAL_HOSTS.items():
        if (host == social or host.endswith('.' + social)) and not (host.startswith('api.') or path.startswith('/api')):
            return ('social', reason)

    # 3. developer's own domain (from the store listing website / privacy policy)
    is_dev_domain = False
    if developer_domain:
        dev = developer_domain.lower().strip('/')
        dev_host = dev.split('//')[-1].split('/')[0]
        if dev_host and (host == dev_host or host.endswith('.' + dev_host)):
            is_dev_domain = True
    if is_dev_domain:
        if '/upload' in path or '/assets/' in path or '/cdn' in path or '/img' in path or '/files/' in path:
            return ('asset-cdn', "developer's own file/upload CDN — where user content and media are stored")
        if host.startswith('api.') or path.startswith('/api') or API_WORDS.match(path):
            return ('api-base', "developer's own REST backend — primary API origin for the app")
        if path in ('', '/'):
            return ('app-site', "developer's website root (about/support/landing page)")
        return ('app-site', "developer's own site — app backend origin (REST calls most likely originate here)")

    # 4. generic API shapes
    if host.startswith('api.') or path.startswith('/api') or API_WORDS.match(path):
        if '/upload' in path or '/assets/' in path:
            return ('asset-cdn', 'third-party file/upload CDN for user content')
        return ('third-party-api', 'API host (REST origin) — integrated third-party or app backend; treat as the backend until decompiled call sites prove otherwise')
    if '/upload' in path or '/cdn' in path or path.endswith(('.jpg', '.png', '.webp', '.pdf')):
        return ('asset-cdn', 'static/file hosting for media or uploads')

    return ('review', 'possible app resource — verify against decompiled call sites before treating as a backend')


# --------------------------------------------------------------------------
# harvesting
# --------------------------------------------------------------------------

def read_zip_member(apk_path, member):
    try:
        with zipfile.ZipFile(apk_path) as z:
            return z.read(member)
    except Exception:
        return None


def harvest(workdir):
    """Collect every text surface: libapp.so strings, JS bundles, jadx sources, assets."""
    out = {
        'dartPackages': collections.Counter(),
        'urls': {},           # url -> set(sources)
        'paths': collections.Counter(),
        'classes': collections.Counter(),
        'sql': collections.Counter(),
        'assets': [],
        'assetDbs': [],
        'jvmSignals': collections.Counter(),
        'jvmFiles': 0,
        'nativeLibs': set(),
        'sourcesByHost': {},  # host -> set(source files) for evidence
    }

    apks = sorted(glob.glob(os.path.join(workdir, 'unpacked', '*.apk')))
    libapp_blob = None
    js_blobs = []
    www_files = []

    for apk in apks:
        try:
            with zipfile.ZipFile(apk) as z:
                names = z.namelist()
                for n in names:
                    if n.startswith('lib/') and n.endswith('.so'):
                        out['nativeLibs'].add(n.rsplit('/', 1)[1])
                    if n.startswith('assets/'):
                        out['assets'].append(n)
                        if n.endswith(('.db', '.sqlite', '.sqlite3')):
                            out['assetDbs'].append((apk, n))
                        if apk.endswith('base.apk') and n.startswith('assets/www/') and n.endswith(('.js', '.html', '.json')):
                            www_files.append((apk, n))
                libapp = next((n for n in names if n.endswith('libapp.so')), None)
                if libapp:
                    libapp_blob = z.read(libapp)
                rn_bundle = next((n for n in names if n == 'assets/index.android.bundle'), None)
                if rn_bundle:
                    js_blobs.append(z.read(rn_bundle))
        except zipfile.BadZipFile:
            continue

    URL_RE = re.compile(r'https?://[A-Za-z0-9._~:/?#@!$&*+,;=%-]{6,120}')

    def clean_aot_url(u):
        """Strip Dart AOT symbol residue glued onto URLs."""
        u = re.split(r'[@]|init:|StackOverflow|GrowableList|_literal|_Scroll|Dart_|\x00', u)[0].rstrip('.,;)"\'')
        m = re.match(r'(https?://[^/]+)(/[^?]*)?(\?.*)?', u)
        if not m:
            return u
        host, path, query = m.group(1), m.group(2) or '', m.group(3) or ''
        segs = path.split('/')
        clean = []
        for i, s in enumerate(segs):
            # first segment with an uppercase letter or glue-like length = residue -> cut
            if s and i > 0 and (re.search(r'[A-Z]', s) or (len(s) > 24 and not s.endswith(('.jpg', '.png', '.json', '.html')))):
                break
            clean.append(s)
        # drop a glued lowercase tail on the last segment (e.g. 'privacyapplication')
        if clean and clean[-1]:
            last = clean[-1]
            for marker in ('application', 'init', 'Settings', 'Controller'):
                if marker in last and len(last) > len(marker) + 3:
                    last = last.split(marker)[0] or last
                    break
            clean[-1] = last
        # queries glued with symbols -> drop query if it contains uppercase glue
        if query and re.search(r'[A-Z][a-z]+[A-Z]', query):
            query = ''
        return host + ('/'.join(clean) if len(clean) > 1 else '') + query

    def note_urls(text, source):
        for u in URL_RE.findall(text):
            if len(u) < 12:
                continue
            u = clean_aot_url(u)
            if len(u) < 12:
                continue
            out['urls'].setdefault(u, set()).add(source)
            host = u.split('//', 1)[1].split('/', 1)[0].lower()
            out['sourcesByHost'].setdefault(host, set()).add(source)

    # --- Flutter Dart AOT string table ---
    if libapp_blob:
        txt = libapp_blob.decode('utf-8', 'ignore')
        out['dartPackages'].update(DART_PKG_RE.findall(txt))
        note_urls(txt, 'libapp.so (Dart AOT string table)')
        out['classes'].update(CLASS_SUFFIX_RE.findall(txt))
        for m in SQL_SELECT_RE.findall(txt):
            out['sql'][m[:160]] += 1
        for m in PATH_TOKEN_RE.findall(txt):
            token = m[0] + (m[1] or '')
            out['paths']['/' + token.lstrip('/')] += 1

    # --- React Native bundle ---
    for blob in js_blobs:
        txt = blob.decode('utf-8', 'ignore')
        note_urls(txt, 'index.android.bundle (React Native)')
        out['classes'].update(CLASS_SUFFIX_RE.findall(txt))
        for m in SQL_SELECT_RE.findall(txt):
            out['sql'][m[:160]] += 1
        for m in PATH_TOKEN_RE.findall(txt):
            token = m[0] + (m[1] or '')
            out['paths']['/' + token.lstrip('/')] += 1

    # --- Cordova www ---
    for apk, member in www_files[:40]:
        blob = read_zip_member(apk, member)
        if blob:
            txt = blob.decode('utf-8', 'ignore')
            note_urls(txt, member)
            for m in PATH_TOKEN_RE.findall(txt):
                token = m[0] + (m[1] or '')
                out['paths']['/' + token.lstrip('/')] += 1

    # --- jadx decompiled sources ---
    src_root = os.path.join(workdir, 'jadx', 'sources')
    budget = 1_600_000
    seen = 0
    if os.path.isdir(src_root):
        for dirpath, _, filenames in os.walk(src_root):
            for f in filenames:
                if not f.endswith(('.java', '.kt')):
                    continue
                p = os.path.join(dirpath, f)
                rel = os.path.relpath(p, src_root)
                try:
                    with open(p, encoding='utf-8', errors='ignore') as fh:
                        text = fh.read()
                except OSError:
                    continue
                out['jvmFiles'] += 1
                if seen > budget:
                    continue
                seen += len(text)
                note_urls(text, f'sources/{rel}')
                # retrofit-style annotations
                for m in re.findall(r'@(?:GET|POST|PUT|DELETE|PATCH)\(\s*"([^"]{2,80})"\s*\)', text):
                    if not m.startswith('http'):
                        out['paths']['/' + m.lstrip('/')] += 1
                for m in SQL_SELECT_RE.findall(text):
                    out['sql'][m[:160]] += 1
                out['classes'].update(CLASS_SUFFIX_RE.findall(text))
                for sig, (jmeaning, jcat) in JVM_SIGNALS.items():
                    if sig in text:
                        out['jvmSignals'][(sig, jmeaning, jcat)] += 1
                for m in PATH_TOKEN_RE.findall(text):
                    token = m[0] + (m[1] or '')
                    out['paths']['/' + token.lstrip('/')] += 1

    # --- asset databases: dump real schema with sqlite3 ---
    tables = []
    for apk, member in out['assetDbs'][:4]:
        blob = read_zip_member(apk, member)
        if not blob:
            continue
        try:
            with tempfile.NamedTemporaryFile(suffix='.db', delete=False) as tf:
                tf.write(blob)
                tmp = tf.name
            con = sqlite3.connect(f'file:{tmp}?mode=ro', uri=True)
            rows = con.execute("SELECT name, sql FROM sqlite_master WHERE type='table' AND name NOT LIKE 'sqlite_%'").fetchall()
            for name, sql in rows:
                cols = [r[1] for r in con.execute(f'PRAGMA table_info("{name}")').fetchall()]
                tables.append({'name': name, 'columns': cols, 'source': f'{member} (bundled SQLite file)'})
            con.close()
            os.unlink(tmp)
        except Exception:
            continue

    out['assetDbTables'] = tables
    return out


# --------------------------------------------------------------------------
# database intel (schema reconstruction)
# --------------------------------------------------------------------------

def lookup_signal(pkg):
    """exact match first, then family prefixes (sqflite*, sqlite*, firebase_*, flutter_local_*)"""
    if pkg in SYNC_SIGNALS:
        return SYNC_SIGNALS[pkg]
    for prefix, sig in (('sqflite', ('local SQLite database (Flutter sqflite)', 'offline storage')),
                        ('sqlite', ('SQLite native bindings', 'offline storage')),
                        ('firebase_messaging', ('Firebase Cloud Messaging push channel', 'realtime/push')),
                        ('flutter_local_notifications', ('local notifications', 'realtime/push'))):
        if pkg.startswith(prefix):
            return sig
    return None


def build_database_intel(h, dart_pkgs, jvm_text_signals):
    engines = []
    for pkg in dart_pkgs:
        sig = lookup_signal(pkg)
        if sig and sig[1] in ('offline storage', 'offline storage / token storage', 'offline storage + sync engine'):
            engines.append({'name': sig[0], 'evidence': f'package:{pkg} in libapp.so'})
    for (sig, meaning, cat), _ in jvm_text_signals.items():
        if cat in ('offline storage',):
            engines.append({'name': meaning, 'evidence': f'{sig} in decompiled sources'})
    engines = [dict(t) for t in {tuple(sorted(e.items())) for e in engines}][:6]

    tables = list(h['assetDbTables'])
    # CREATE TABLE recovery from strings
    seen_names = {t['name'].lower() for t in tables}
    for txt in list(h['sql'].keys())[:600]:
        for m in CREATE_TABLE_RE.finditer(txt):
            name, body = m.group(1), m.group(2)
            if name.lower() in seen_names:
                continue
            cols = []
            for part in body.split(','):
                token = part.strip().split(' ')[0].strip('"`[]')
                if re.match(r'^[a-zA-Z_][a-zA-Z0-9_]*$', token) and token.upper() not in ('PRIMARY', 'FOREIGN', 'UNIQUE', 'CONSTRAINT', 'CHECK'):
                    cols.append(token)
            if cols:
                seen_names.add(name.lower())
                tables.append({'name': name, 'columns': cols[:20], 'source': 'CREATE TABLE string recovered from compiled code'})
    tables = tables[:24]

    return {
        'engines': engines,
        'tables': tables,
        'sqlEvidence': [s for s in list(h['sql'].keys())[:12]],
        'assetDatabases': [m for _, m in h['assetDbs']][:6],
    }


def build_sync_intel(h, dart_pkgs, jvm_signals):
    signals = []
    realtime = []
    for pkg in dart_pkgs:
        sig = lookup_signal(pkg)
        if sig:
            meaning, cat = sig
            signals.append({'signal': f'package:{pkg}', 'meaning': meaning, 'category': cat, 'evidence': 'libapp.so Dart AOT string table'})
            if cat == 'realtime/push' and meaning not in realtime:
                realtime.append(meaning)
    for (sig, meaning, cat), n in jvm_signals.items():
        signals.append({'signal': f'{sig} (×{n} refs)', 'meaning': meaning, 'category': cat, 'evidence': 'decompiled JVM sources'})
        if cat == 'realtime/push' and meaning not in realtime:
            realtime.append(meaning)
    # dedupe by signal
    seen = set()
    uniq = []
    for s in signals:
        if s['signal'] not in seen:
            seen.add(s['signal'])
            uniq.append(s)

    storage = [s for s in uniq if s['category'].startswith('offline storage')]
    orchestration = [s for s in uniq if s['category'] == 'sync orchestration']
    clients = [s for s in uniq if s['category'] == 'api client']

    # lead with the real database engine, not a key-value store
    def storage_rank(s):
        n = s['meaning'].lower()
        if any(k in n for k in ('sqlite', 'room', 'drift', 'realm', 'objectbox', 'couchbase')):
            return 0
        if any(k in n for k in ('hive', 'isar', 'nosql')):
            return 1
        if 'encrypted' in n:
            return 2
        return 3
    storage.sort(key=storage_rank)

    # channels = actual server->client transports; the rest are display mechanisms
    channels = [r for r in realtime if any(k in r.lower() for k in ('push channel', 'websocket', 'socket.io', 'fcm', 'firebase', 'realtime'))]
    display = [r for r in realtime if r not in channels]

    if storage and (orchestration or channels):
        strategy = (f"Offline-capable: {storage[0]['meaning']} holds data locally; "
                    + (f"{orchestration[0]['meaning']} drives when sync happens" if orchestration else 'app-level code drives sync')
                    + (f"; {', '.join(dict.fromkeys(channels))} for server-initiated updates" if channels else '')
                    + (f"; local notifications announce events while backgrounded" if display else '')
                    + '. Read paths hit local storage first; writes queue and flush to the REST backend when a connection is available.')
    elif storage:
        strategy = f"Local-first storage ({', '.join(s['meaning'] for s in storage[:3])}) with REST calls to the backend — a classic store-then-sync pattern; no background scheduler detected, so sync happens while the app is open."
    elif clients:
        strategy = "Online-only pattern detected: network clients without a local database engine — every screen likely requires connectivity. Cloning should add an offline layer as an improvement."
    else:
        strategy = 'No definitive sync signals — inspect the decompiled sources around the API client calls.'

    return {'signals': uniq[:18], 'realtime': list(dict.fromkeys(realtime)), 'offlineStrategy': strategy}


def build_api_intel(h, dart_pkgs, jvm_signals, urls_classified):
    clients = []
    for pkg in dart_pkgs:
        if pkg in ('dio', 'http', 'chopper', 'retrofit', 'graphql', 'socket_io_client', 'web_socket_channel') or pkg.startswith('http'):
            clients.append(f'package:{pkg}')
    for (sig, meaning, cat), _ in jvm_signals.items():
        if cat == 'api client':
            clients.append(meaning)
    clients = list(dict.fromkeys(clients))[:6]

    paths = [p for p, n in h['paths'].most_common(60) if n >= 1][:48]

    auth = []
    blob_txt = ' '.join([p for p, _ in h['paths'].most_common(200)]).lower()
    for sig, meaning in AUTH_SIGNALS.items():
        if sig in dart_pkgs or sig in blob_txt:
            auth.append({'method': meaning, 'evidence': f'package:{sig} present' if sig in dart_pkgs else f'"{sig}" strings in compiled code'})

    # models / modules from class-name mining
    models = []
    screens = []
    for name, n in h['classes'].most_common(400):
        if name.endswith(('Model', 'Entity', 'Dto', 'DTO', 'Response', 'Request')):
            models.append(name)
        elif name.endswith(('Screen', 'Page', 'View', 'Fragment', 'Dialog')):
            screens.append(name)
    models = list(dict.fromkeys(models))[:30]
    screens = list(dict.fromkeys(screens))[:30]

    api_bases = [e for e in urls_classified if e['kind'] in ('api-base', 'third-party-api')]

    return {
        'clients': clients,
        'bases': [e['url'] for e in api_bases][:8],
        'paths': paths,
        'auth': auth[:6],
        'models': models,
        'screens': screens,
    }


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument('--dir', required=True, help='analysis workdir (contains unpacked/ and jadx/)')
    ap.add_argument('--developer-domain', default='')
    ap.add_argument('--json', default='')
    a = ap.parse_args()

    workdir = a.dir
    if not os.path.isdir(os.path.join(workdir, 'unpacked')):
        print(json.dumps({'error': 'no unpacked/ directory'}))
        sys.exit(1)

    h = harvest(workdir)
    dart_pkgs = set(h['dartPackages'].keys())
    jvm_signals = h['jvmSignals']

    # --- endpoints ---
    by_key = {}
    for url, sources in h['urls'].items():
        kind, purpose = classify_url(url, a.developer_domain)
        # dedupe by host + first path segment, keeping the shortest url
        try:
            m = re.match(r'https?://([^/]+)(/[a-z0-9_{}.-]+)?', url)
            key = (m.group(1).lower(), (m.group(2) or '').rstrip('/'), kind) if m else (url, '', kind)
        except Exception:
            key = (url, '', kind)
        prev = by_key.get(key)
        if prev is None or len(url) < len(prev[0]):
            by_key[key] = (url, sources, kind, purpose)
    endpoints = [
        {'url': u[:200], 'kind': kind, 'purpose': purpose, 'evidence': '; '.join(sorted(sources)[:2])}
        for u, sources, kind, purpose in by_key.values()
    ]
    # rank: interesting kinds first, then by evidence count
    order = {'api-base': 0, 'third-party-api': 1, 'asset-cdn': 2, 'app-site': 3, 'review': 4, 'social': 5, 'docs': 6, 'framework-noise': 7}
    endpoints.sort(key=lambda e: (order.get(e['kind'], 9), -len(e['evidence'])))
    endpoints = endpoints[:70]

    database = build_database_intel(h, dart_pkgs, jvm_signals)
    sync = build_sync_intel(h, dart_pkgs, jvm_signals)
    api = build_api_intel(h, dart_pkgs, jvm_signals, endpoints)

    result = {
        'endpoints': endpoints,
        'database': database,
        'sync': sync,
        'api': api,
        'modules': [c for c, _ in h['classes'].most_common(40)],
        'stats': {
            'urlsTotal': len(h['urls']),
            'jvmFiles': h['jvmFiles'],
            'assetCount': len(h['assets']),
            'nativeLibs': sorted(h['nativeLibs'])[:30],
        },
    }

    payload = json.dumps(result, indent=1, ensure_ascii=False)
    if a.json:
        with open(a.json, 'w', encoding='utf-8') as f:
            f.write(payload)
    print(payload)


if __name__ == '__main__':
    main()
