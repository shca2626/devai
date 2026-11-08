#!/usr/bin/env python3
"""apkcube acquisition v3 — state-driven hold, based on reverse-engineered widget.

Reverse-engineered state machine (from apkcube's own JS):
  holdToVerify "Hold to verify" -> (press) holdHolding "Keep holding…"
  -> [ring fills] holdKeepHolding "Hold a little longer" / holdRelease "Let go now"
  -> (release NOW, within releaseMs window) holdVerified "Verified"
  -> powWorking "Checking your browser…" (proof of work, automatic)
  -> preparing "Preparing your download…" (downloads/request fires)
  -> signed URL in response, or adblockCountdown "Your download starts in {n}s"
  Overshoot window: holdTooLong "Held too long — press again" = retry hold.

Google Play originality: when Play has a newer version than their cache, the
UI says "Google Play has version {v} — we're fetching it for you now" and the
backend pulls it fresh from Google Play (see fetch-status polling).
"""
import hashlib, json, os, re, sys, time

from camoufox.sync_api import Camoufox

PKG = os.environ.get('PKG', 'com.arkanprotailor.arkan_tailor')
OUT = os.environ.get('OUT_DIR', '/tmp/acquired')
os.makedirs(OUT, exist_ok=True)

RELEASE_CUES = ('let go now', 'hold a little longer', 'a little longer')
FAIL_CUES = ('held too long', 'press again', 'too many requests', 'expired',
             'no longer available', 'went wrong', 'failed')
URL_RE = re.compile(r'https?://[^\s"\']+\.apks[^\s"\']*|https?://[^\s"\']+/[^\s"\']*\.apks[^\s"\']*')

state = {'log': [], 'dl': None, 'fetch_status': {}, 'token': None}


def note(tag, obj):
    state['log'].append({'t': round(time.time(), 1), 'tag': tag, 'obj': obj})
    print(f'  [{tag}]', json.dumps(obj, ensure_ascii=False)[:400], flush=True)


def modal_text(page):
    """All visible text inside the verify modal (or whole page if no modal)."""
    try:
        return ' '.join(w.strip().lower() for w in page.evaluate("""(() => {
            const m = document.querySelector('[role="dialog"]') || document.body;
            return [...m.querySelectorAll('h1,h2,h3,h4,p,span,button,div[aria-live]')]
              .filter(e => e.offsetParent && e.textContent)
              .map(e => e.textContent.trim());
        })()"""))[:2000]
    except Exception:
        return ''


def resolve_real_url():
    """Pre-resolve the real slug URL via curl (follows redirects server-side)."""
    from curl_cffi import requests as cr
    r = cr.get(f'https://apkcube.com/whatever/{PKG}/download', impersonate='chrome131',
               timeout=40, allow_redirects=True)
    if r.url and f'/{PKG}' in r.url and '/apk-downloader' not in r.url:
        return r.url
    # fallback: the official downloader entry page
    return f'https://apkcube.com/apk-downloader?url={PKG}'


def attempt(browser, idx):
    page = browser.new_page()

    def on_resp(r):
        u = r.url
        if '/api/' not in u:
            return
        try:
            body = r.json()
        except Exception:
            body = None
        if '/fetch-status' in u:
            if body: state['fetch_status'] = body
        elif 'download-token' in u:
            state['token'] = body
            note('download-token', {'hold': (body or {}).get('hold'),
                                    'expiresInMs': (body or {}).get('expiresInMs')})
        elif '/api/downloads/request' in u:
            state['dl'] = body
            note('downloads/request', {'status': r.status,
                                       'url': ((body or {}).get('url') or '')[:80],
                                       'err': (body or {}).get('error')})
        elif body is not None:
            note('api', {'u': u.split('apkcube.com')[-1][:80], 'status': r.status,
                         'keys': list(body.keys())[:8] if isinstance(body, dict) else str(body)[:60]})

    page.on('response', on_resp)

    # pre-resolved real slug URL (server-side redirect)
    real_url = resolve_real_url()
    note('entry', {'url': real_url})
    page.goto(real_url, wait_until='domcontentloaded', timeout=90000)
    if 'apk-downloader' in page.url:
        # entry page: submit the package to navigate to the app page
        try:
            page.fill('input[type="text"], input[type="search"], input[name="url"]', PKG, timeout=5000)
            page.keyboard.press('Enter')
            page.wait_for_load_state('domcontentloaded', timeout=30000)
        except Exception as e:
            note('entry-fill-err', {'e': str(e)[:100]})

    # wait for CF "Just a moment" to clear
    for _ in range(45):
        if 'just a moment' not in page.title().lower():
            break
        time.sleep(1)

    # find the download trigger button
    btn = None
    for _ in range(30):
        try:
            for sel in ['button:has-text("Download APKS")', 'button:has-text("Download APK")',
                        'button:has-text("Get APK")', 'button:has-text("تحميل APK")',
                        'button:has-text("Download")']:
                b = page.query_selector(sel)
                if b and b.is_visible():
                    btn = b
                    break
            if btn:
                break
        except Exception:
            pass
        time.sleep(2)
    if not btn:
        note('fail', {'stage': 'no-download-button', 'title': page.title()[:80]})
        page.screenshot(path=f'{OUT}/try{idx}-nobtn.png')
        page.close()
        return None

    btn.click()
    note('clicked', {'btn': (btn.text_content() or '').strip()[:40]})

    # wait for the hold widget to appear
    hold = None
    for _ in range(20):
        try:
            h = page.query_selector('button:has-text("Hold to verify")')
            if h and h.is_visible():
                hold = h
                break
        except Exception:
            pass
        time.sleep(1)
    if not hold:
        # maybe no hold needed this time; wait for direct download/url
        t0 = time.time()
        while time.time() - t0 < 90:
            if state['dl'] or URL_RE.search(page.content()):
                break
            time.sleep(2)
        return finish(page, idx)

    for round_ in range(6):
        if state['dl']:
            return finish(page, idx)
        # fresh hold button each round (widget resets)
        hold = page.query_selector('button:has-text("Hold to verify")') or \
               page.query_selector('button:has-text("Hold to verify") >> visible=true')
        if not hold:
            try:
                cand = page.evaluate("""[...document.querySelectorAll('button')]
                    .find(b => b.offsetParent && /hold/i.test(b.textContent))""")
                if cand:
                    hold = page.query_selector('button:has-text("Hold to verify")')
            except Exception:
                pass
        if not hold or not hold.is_visible():
            time.sleep(3)
            continue

        box = hold.bounding_box()
        if not box:
            time.sleep(2)
            continue
        cx, cy = box['x'] + box['width'] / 2, box['y'] + box['height'] / 2
        page.mouse.move(cx, cy)
        time.sleep(0.3)
        page.mouse.down()
        note('hold-down', {'round': round_})

        # poll modal text; release exactly when the release cue appears
        released = False
        t0 = time.time()
        while time.time() - t0 < 15:
            txt = modal_text(page)
            if any(c in txt for c in RELEASE_CUES):
                page.mouse.up()
                released = True
                note('hold-release', {'round': round_, 'after_ms': int((time.time() - t0) * 1000),
                                      'cue': [c for c in RELEASE_CUES if c in txt][0]})
                break
            if any(c in txt for c in ('verified',)):
                page.mouse.up()
                released = True
                note('hold-release', {'round': round_, 'cue': 'verified (auto)'})
                break
            time.sleep(0.05)
        if not released:
            page.mouse.up()
            note('hold-release', {'round': round_, 'cue': 'timeout-15s'})

        # post-hold: PoW + turnstile (ONE patient click, never spam) + downloads/request
        t0 = time.time()
        clicked_at = None
        while time.time() - t0 < 150:
            if state['dl']:
                return finish(page, idx)
            txt = modal_text(page)
            if any(c in txt for c in FAIL_CUES):
                if 'too many requests' in txt:
                    m = re.search(r'(\d+)\s*s', txt)
                    wait_s = min(int(m.group(1)) + 3, 90) if m else 30
                    note('rate-limited', {'wait': wait_s})
                    time.sleep(wait_s)
                break  # re-hold next round
            # turnstile: single precise click at the checkbox position, then patience
            ts = None
            try:
                ts = page.query_selector('iframe[src*="challenges.cloudflare.com"]')
            except Exception:
                pass
            if ts:
                box = ts.bounding_box()
                if box and box['width'] > 4:
                    # auto/managed mode may pass silently: wait 6s before first click
                    if clicked_at is None and time.time() - t0 > 6:
                        page.mouse.move(box['x'] + 28, box['y'] + box['height'] / 2)
                        page.mouse.click(box['x'] + 28, box['y'] + box['height'] / 2)
                        clicked_at = time.time()
                        note('turnstile-click', {'x': round(box['x'] + 28), 'y': round(box['y'] + box['height'] / 2)})
                    # re-click only if nothing happened for 25s (widget may have reset)
                    elif clicked_at and time.time() - clicked_at > 25:
                        page.mouse.click(box['x'] + 28, box['y'] + box['height'] / 2)
                        clicked_at = time.time()
                        note('turnstile-retry', {})
            time.sleep(2)

    # last chance sweep
    t0 = time.time()
    while time.time() - t0 < 60:
        if state['dl']:
            return finish(page, idx)
        time.sleep(2)
    page.screenshot(path=f'{OUT}/try{idx}-fail.png')
    note('fail', {'stage': 'end', 'title': page.title()[:60],
                  'modal': modal_text(page)[:200]})
    page.close()
    return None


def finish(page, idx):
    """Wait a bit more then extract URL from state or page."""
    time.sleep(2)
    if state['dl'] and state['dl'].get('url'):
        page.close()
        return state['dl']['url']
    content = page.content()
    m = URL_RE.search(content)
    if m:
        page.close()
        return m.group(0)
    # maybe a browser download event fired
    page.close()
    return None


def main():
    with Camoufox(headless=True, humanize=True) as browser:
        for i in range(4):
            print(f'[attempt {i + 1}]', flush=True)
            state['dl'] = None
            state['token'] = None
            state['fetch_status'] = {}
            url = attempt(browser, i + 1)
            if url:
                break
            time.sleep(5)
    if not url:
        json.dump(state['log'], open(f'{OUT}/flow-log.json', 'w'), indent=1)
        raise SystemExit('ALL ATTEMPTS FAILED — see flow-log.json')

    from curl_cffi import requests as cr
    r = cr.get(url, impersonate='chrome131', timeout=900)
    print(f'[fetch] {r.status_code} {len(r.content) / 1e6:.2f} MB magic={r.content[:2]}')
    if r.status_code != 200 or not r.content[:2] == b'PK':
        json.dump(state['log'], open(f'{OUT}/flow-log.json', 'w'), indent=1)
        raise SystemExit(f'download failed: {r.status_code}')
    fname = f'{OUT}/{PKG}.apks'
    open(fname, 'wb').write(r.content)
    sha = hashlib.sha256(r.content).hexdigest()
    print('[sha256]', sha)

    import zipfile
    with zipfile.ZipFile(fname) as z:
        names = z.namelist()
        print('[bundle]', names)
        z.extractall(f'{OUT}/unpacked')
    json.dump({'pkg': PKG, 'sha256': sha, 'bundle': names, 'file': fname,
               'log': state['log'], 'token': state['token'], 'fetch_status': state['fetch_status']},
              open(f'{OUT}/meta.json', 'w'), indent=1)
    print('[✓] COMPLETE —', fname)


if __name__ == '__main__':
    main()
