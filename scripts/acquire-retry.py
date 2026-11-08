#!/usr/bin/env python3
"""apkcube acquisition — the exact sequence of the successful run, with retries."""
import hashlib, json, os, time

from camoufox.sync_api import Camoufox

PKG = os.environ.get('PKG', 'com.arkanprotailor.arkan_tailor')
SLUG = os.environ.get('SLUG', 'quroosh-tailor-pos')
OUT = os.environ.get('OUT_DIR', '/tmp/acquired')
os.makedirs(OUT, exist_ok=True)
URL = f'https://apkcube.com/{SLUG}/{PKG}/download'

state = {'ms': None, 'dl': None, 'download_event': None}

def attempt_flow(browser, try_idx):
    """One full attempt. Returns the file URL or None."""
    state['ms'] = None; state['dl'] = None; state['download_event'] = None
    page = browser.new_page()

    def on_resp(r):
        if 'download-token' in r.url:
            try:
                h = r.json().get('hold') or {}
                if h.get('requiredMs'):
                    state['ms'] = h['requiredMs']
            except Exception: pass
        if '/api/downloads/request' in r.url:
            try: state['dl'] = r.json()
            except Exception: state['dl'] = {'error': 'parse'}
    page.on('response', on_resp)
    page.on('download', lambda d: state.update(download_event=d))

    page.goto(URL, wait_until='domcontentloaded', timeout=90000)
    for _ in range(40):
        if 'Just a moment' not in page.title():
            break
        time.sleep(1)

    btn = None
    for _ in range(30):
        try:
            b = page.query_selector('button:has-text("Download APKS")') or page.query_selector('button:has-text("Download")')
            if b and b.is_visible(): btn = b; break
        except Exception: pass
        time.sleep(2)
    if not btn:
        page.close(); return None

    btn.click()
    time.sleep(2.5)

    # hold exactly
    hold = None
    for _ in range(10):
        try:
            h = page.query_selector('button:has-text("Hold to verify")')
            if h and h.is_visible(): hold = h; break
        except Exception: pass
        time.sleep(1)
    if not hold:
        page.close(); return None
    ms = state['ms'] or 2200
    box = hold.bounding_box()
    page.mouse.move(box['x'] + box['width'] / 2, box['y'] + box['height'] / 2)
    page.mouse.down()
    time.sleep(ms / 1000 + 0.15)
    page.mouse.up()
    print(f'  [try {try_idx}] held {ms + 150}ms')

    # wait ~3s, then ONE body click on the turnstile frame if present (the successful pattern)
    time.sleep(3)
    frames = [f for f in page.frames if 'challenges.cloudflare.com' in (f.url or '')]
    if frames:
        try:
            frames[0].locator('body').first.click(timeout=3000)
            print(f'  [try {try_idx}] turnstile body click')
        except Exception:
            pass

    # stillness — up to 120s for either the API response or the download event
    t0 = time.time()
    while time.time() - t0 < 120:
        if state['dl'] or state['download_event']:
            break
        time.sleep(2)

    if state['dl'] and state['dl'].get('url'):
        url = state['dl']['url']
        page.close()
        return url
    if state['download_event']:
        d = state['download_event']
        url = d.url
        path = f'{OUT}/{d.suggested_filename or PKG + ".apks"}'
        d.save_as(path)
        print(f'  [try {try_idx}] saved via browser download:', path)
        page.close()
        return 'FILE_SAVED:' + path
    page.screenshot(path=f'{OUT}/try{try_idx}-fail.png')
    page.close()
    return None

with Camoufox(headless=True, humanize=True) as browser:
    file_url = None
    for i in range(3):
        print(f'[attempt {i + 1}]')
        file_url = attempt_flow(browser, i + 1)
        if file_url:
            break
        time.sleep(4)

if not file_url:
    raise SystemExit('all attempts failed')

if not file_url.startswith('FILE_SAVED:'):
    from curl_cffi import requests as cr
    r = cr.get(file_url, impersonate='chrome131', timeout=600)
    print(f'[download] {r.status_code} {len(r.content) / 1e6:.1f} MB magic={r.content[:2]}')
    fname = f'{OUT}/{PKG}.apks'
    open(fname, 'wb').write(r.content)
else:
    fname = file_url.split('FILE_SAVED:')[1]

sha = hashlib.sha256(open(fname, 'rb').read()).hexdigest()
print('[sha256]', sha)

import zipfile
with zipfile.ZipFile(fname) as z:
    names = z.namelist()
    print('[bundle]', names)
    z.extractall(f'{OUT}/unpacked')
json.dump({'pkg': PKG, 'sha256': sha, 'bundle': names, 'file': fname}, open(f'{OUT}/meta.json', 'w'), indent=1)
print('[✓] COMPLETE —', fname)
