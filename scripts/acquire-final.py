#!/usr/bin/env python3
"""apkcube acquisition FINAL — hold exactly, then stay still while turnstile auto-verifies."""
import hashlib, json, os, time

from camoufox.sync_api import Camoufox

PKG = os.environ.get('PKG', 'com.arkanprotailor.arkan_tailor')
SLUG = os.environ.get('SLUG', 'quroosh-tailor-pos')
OUT = os.environ.get('OUT_DIR', '/tmp/acquired')
os.makedirs(OUT, exist_ok=True)
URL = f'https://apkcube.com/{SLUG}/{PKG}/download'

state = {'ms': None, 'ms_ts': 0, 'dl': None}

with Camoufox(headless=True, humanize=True, executable_path='/tmp/camoufox/camoufox', i_know_what_im_doing=True) as browser:
    page = browser.new_page()

    def on_resp(r):
        if 'download-token' in r.url:
            try:
                h = r.json().get('hold') or {}
                if h.get('requiredMs'):
                    state['ms'] = h['requiredMs']; state['ms_ts'] = time.time()
                    print(f"  [token] requiredMs={h['requiredMs']}")
            except Exception: pass
        if '/api/downloads/request' in r.url:
            try: state['dl'] = r.json()
            except Exception: state['dl'] = {'error': 'parse'}
            print('  [downloads/request] RECEIVED')
    page.on('response', on_resp)

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
    if not btn: raise SystemExit('no download button')

    print('[1] click download')
    btn.click()
    time.sleep(2.5)

    for attempt in range(4):
        if state['dl']: break
        hold = None
        for _ in range(10):
            try:
                h = page.query_selector('button:has-text("Hold to verify")')
                if h and h.is_visible(): hold = h; break
            except Exception: pass
            time.sleep(1)
        if not hold:
            print('  no hold button — waiting for auto-verify…')
        else:
            ms = state['ms'] or 2000
            box = hold.bounding_box()
            page.mouse.move(box['x'] + box['width'] / 2, box['y'] + box['height'] / 2)
            page.mouse.down()
            time.sleep(ms / 1000 + 0.12)
            page.mouse.up()
            print(f'[2] hold #{attempt + 1}: {ms + 120}ms')
        # BE STILL — wait for auto verification + downloads/request (up to 150s)
        still = time.time()
        while time.time() - still < 150:
            if state['dl']: break
            # only re-hold if an explicit "press again" state appears
            try:
                txt = page.evaluate("(() => { const b=[...document.querySelectorAll('button')].find(x=>/hold/i.test(x.textContent)); return b? b.textContent.trim().toLowerCase() : ''; })()")
                if 'again' in txt:
                    print('  press-again detected — re-hold')
                    break
            except Exception: pass
            time.sleep(2)

    if not state['dl']:
        page.screenshot(path=f'{OUT}/fail3.png')
        raise SystemExit('verification never completed')

    dl = state['dl']
    file_url = dl.get('url')
    print('[3] SIGNED URL:', file_url[:100], '…')
    json.dump(dl, open(f'{OUT}/dl-response.json', 'w'), indent=1)

from curl_cffi import requests as cr
r = cr.get(file_url, impersonate='chrome131', timeout=600)
print(f'[4] file downloaded: {r.status_code} {len(r.content) / 1e6:.1f} MB magic={r.content[:2]}')
fname = f'{OUT}/{PKG}.apks'
open(fname, 'wb').write(r.content)
sha = hashlib.sha256(r.content).hexdigest()
print('[5] sha256:', sha)

import zipfile
with zipfile.ZipFile(fname) as z:
    names = z.namelist()
    print('[6] bundle contents:', names)
    z.extractall(f'{OUT}/unpacked')
json.dump({'pkg': PKG, 'sha256': sha, 'bundle': names}, open(f'{OUT}/meta.json', 'w'), indent=1)
print('[✓] COMPLETE')
