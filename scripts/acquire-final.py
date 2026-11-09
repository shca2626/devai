#!/usr/bin/env python3
"""apkcube acquisition — PRODUCTION ACQUIRER (fully reverse-engineered).

Verified mechanics:
  - entry: any-slug URL 302-resolves by package name (curl pre-resolve)
  - click "Download APKS" -> verify modal
  - download-token -> {ticket, requiredMs, releaseMs} (widget may use its own
    local requiredMs fallback — always release on the "Let go now" TEXT CUE,
    never on token math)
  - hold with human micro-movements (moves counter must be > 0)
  - turnstile renders in <div id="cf-turnstile"> (light DOM, ~300x65 centered):
    checkbox = (container.x + 28, container.y + h/2). ONE click, re-click
    every 25s max 4 (spam resets the widget)
  - PoW auto-runs -> POST /api/downloads/request -> {url: R2 signed}
  - curl_cffi fetch -> .apks; sha256 vs listing = originality proof

Output: single JSON line "ACQUIRE_RESULT {...}" for the Node engine.
"""
import argparse, hashlib, json, os, random, time

from camoufox.sync_api import Camoufox

RELEASE_CUE = 'let go now'
FAIL_CUES = ('held too long', 'press again', 'no longer available', 'went wrong')


def log(tag, obj={}):
    print(f'  [{tag}]', json.dumps(obj, ensure_ascii=False)[:240], flush=True)


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


def attempt(browser, pkg, deadline):
    state = {'dl': None, 'apks_api': None}
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
        elif '/api/downloads/request' in u:
            state['dl'] = body
            log('downloads/request', {'url': ((body or {}).get('url') or '')[:90],
                                      'err': (body or {}).get('error')})

    page.on('response', on_resp)

    page.goto(resolve_real_url(pkg), wait_until='domcontentloaded', timeout=90000)
    for _ in range(45):
        if 'just a moment' not in page.title().lower():
            break
        time.sleep(1)

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
        log('fail', {'stage': 'no-button'})
        page.close()
        return None
    btn.click()
    log('clicked')

    # ---- hold: text-cue release + human micro-movements ----
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
        cx, cy = box['x'] + box['width'] / 2, box['y'] + box['height'] / 2
        page.mouse.move(cx, cy)
        time.sleep(0.25)
        page.mouse.down()
        released = False
        t0 = time.time()
        while time.time() - t0 < 16:
            page.mouse.move(cx + random.uniform(-1.5, 1.5), cy + random.uniform(-1.2, 1.2))
            if RELEASE_CUE in modal_text(page):
                page.mouse.up()
                released = True
                log('hold-release', {'ms': int((time.time() - t0) * 1000)})
                break
            time.sleep(0.03)
        if not released:
            page.mouse.up()
            log('hold-release', {'ms': 'timeout'})
            page.close()
            return None
    else:
        log('no-hold-widget', {})

    # ---- turnstile: #cf-turnstile container (light DOM) -> checkbox click ----
    clicked = 0
    reloads = 0
    last_click = 0.0
    t0 = time.time()
    while time.time() < deadline and not state['dl']:
        txt = modal_text(page)
        # widget failed to load (error 600010 & friends) -> hit "Try again"
        # to re-render the challenge, then re-click the checkbox
        if ('failed to load' in txt or 'try again' in txt or 'error 600' in txt) and reloads < 6:
            try:
                again = page.query_selector('button:has-text("Try again")')
                if again and again.is_visible():
                    again.click()
                    reloads += 1
                    clicked = 0          # widget is fresh: allow a new first click
                    t0 = time.time()
                    log('try-again', {'n': reloads})
                    time.sleep(3.5)
                    continue
            except Exception:
                pass
        if any(c in txt for c in FAIL_CUES):
            log('fail-cue', {'txt': txt[:120]})
            break
        try:
            el = page.query_selector('#cf-turnstile')
        except Exception:
            el = None
        if el:
            try:
                bb = el.bounding_box()
            except Exception:
                bb = None
            if bb and bb['width'] > 40:
                now = time.time()
                if (clicked == 0 and now - t0 > 4) or (clicked and now - last_click > 25 and clicked < 4):
                    page.mouse.move(bb['x'] + 28, bb['y'] + bb['height'] / 2, steps=6)
                    time.sleep(0.4)
                    page.mouse.click(bb['x'] + 28, bb['y'] + bb['height'] / 2)
                    clicked += 1
                    last_click = now
                    log('turnstile-click', {'n': clicked,
                                            'box': f'{bb["width"]:.0f}x{bb["height"]:.0f}'})
        time.sleep(2)

    if not (state['dl'] or {}).get('url'):
        try:
            page.screenshot(path=f'/tmp/acquire-fail-{int(time.time())}.png')
        except Exception:
            pass
        log('fail', {'stage': 'no-signed-url', 'clicks': clicked})
        page.close()
        return None

    page.close()
    return {'dl': state['dl'], 'apks_api': state['apks_api']}


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument('--pkg', required=True)
    ap.add_argument('--out', default='/tmp/acquired')
    ap.add_argument('--timeout', type=int, default=480)
    ap.add_argument('--attempts', type=int, default=3)
    a = ap.parse_args()
    os.makedirs(a.out, exist_ok=True)
    deadline = time.time() + a.timeout

    result = None
    with Camoufox(headless=True, humanize=True) as browser:
        for i in range(a.attempts):
            if time.time() > deadline - 40:
                break
            print(f'[attempt {i + 1}]', flush=True)
            result = attempt(browser, a.pkg, deadline)
            if result:
                break
            time.sleep(4)

    if not result:
        print('ACQUIRE_RESULT ' + json.dumps({'ok': False, 'error': 'acquisition_failed'}))
        raise SystemExit(1)

    from curl_cffi import requests as cr
    url = result['dl']['url']
    r = cr.get(url, impersonate='chrome131', timeout=900)
    if r.status_code != 200 or r.content[:2] != b'PK':
        print('ACQUIRE_RESULT ' + json.dumps({'ok': False, 'error': f'fetch_{r.status_code}'}))
        raise SystemExit(1)
    fname = f'{a.out}/{a.pkg}.apks'
    open(fname, 'wb').write(r.content)
    sha = hashlib.sha256(r.content).hexdigest()

    apks = (result['apks_api'] or {}).get('apks') or []
    latest = next((x for x in apks if x.get('isLatest')), apks[0] if apks else None)
    match = 'unknown'
    if latest and latest.get('sha256'):
        match = 'match' if latest['sha256'].lower() == sha else 'mismatch'

    import zipfile
    bundle = []
    with zipfile.ZipFile(fname) as z:
        bundle = z.namelist()
        z.extractall(f'{a.out}/unpacked')

    out = {
        'ok': True,
        'pkg': a.pkg,
        'file': fname,
        'sha256': sha,
        'sizeBytes': len(r.content),
        'bundle': bundle,
        'versionName': (latest or {}).get('versionName'),
        'versionCode': (latest or {}).get('versionCode'),
        'apiSha256': (latest or {}).get('sha256'),
        'originality': match,
    }
    json.dump(out, open(f'{a.out}/meta.json', 'w'), indent=1, default=str)
    # also persist the full browser-captured listing (permissions/signature/VT)
    if result.get('apks_api'):
        json.dump(result['apks_api'], open(f'{a.out}/listing.json', 'w'), indent=1, default=str)
    print('ACQUIRE_RESULT ' + json.dumps(out))


if __name__ == '__main__':
    main()
