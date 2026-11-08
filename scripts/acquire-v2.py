#!/usr/bin/env python3
"""apkcube acquisition v2 — exact hold timing from live token + turnstile + download."""
import hashlib, json, os, re, time

from camoufox.sync_api import Camoufox

PKG = os.environ.get('PKG', 'com.arkanprotailor.arkan_tailor')
SLUG = os.environ.get('SLUG', 'quroosh-tailor-pos')
OUT = os.environ.get('OUT_DIR', '/tmp/acquired')
os.makedirs(OUT, exist_ok=True)
URL = f'https://apkcube.com/{SLUG}/{PKG}/download'

state = {'token_hold_ms': None, 'dl': None}

with Camoufox(headless=True, humanize=True, executable_path='/tmp/camoufox/camoufox', i_know_what_im_doing=True) as browser:
    page = browser.new_page()

    def on_resp(r):
        if '/api/apps/' in r.url and 'download-token' in r.url:
            try:
                d = r.json()
                h = d.get('hold') or {}
                if h.get('requiredMs'):
                    state['token_hold_ms'] = h['requiredMs']
                    print(f"[token] requiredMs={h['requiredMs']}")
            except Exception: pass
        if '/api/downloads/request' in r.url:
            try: state['dl'] = r.json()
            except Exception: state['dl'] = {'raw': '<parse fail>'}
    page.on('response', on_resp)

    page.goto(URL, wait_until='domcontentloaded', timeout=90000)
    for _ in range(40):
        if 'Just a moment' not in page.title():
            break
        time.sleep(1)

    btn = None
    for _ in range(30):
        for sel in ['button:has-text("Download APKS")', 'button:has-text("Download")']:
            try:
                b = page.query_selector(sel)
                if b and b.is_visible(): btn = b; break
            except Exception: pass
        if btn: break
        time.sleep(2)
    if not btn: raise SystemExit('no button')

    print('[1] clicking download…')
    btn.click()
    time.sleep(2.5)

    # hold up to 3 attempts with exact timing
    for attempt in range(3):
        if state['dl']: break
        hold = None
        for _ in range(8):
            try:
                b = page.query_selector('button:has-text("Hold to verify")')
                if b and b.is_visible(): hold = b; break
            except Exception: pass
            time.sleep(1)
        if not hold:
            print('   no hold button (maybe already verified)')
            break
        ms = state['token_hold_ms'] or 2000
        dur = ms / 1000 + 0.12
        box = hold.bounding_box()
        page.mouse.move(box['x'] + box['width'] / 2, box['y'] + box['height'] / 2)
        page.mouse.down()
        time.sleep(dur)
        page.mouse.up()
        print(f'[2] hold #{attempt+1}: {dur*1000:.0f}ms (required {ms}ms)')
        # wait for turnstile + downloads/request
        turnstile_clicked = False
        for t in range(70):
            if state['dl']: break
            if not turnstile_clicked:
                # click the turnstile checkbox precisely (left side of the iframe)
                el = page.query_selector('iframe[src*="challenges.cloudflare.com"]') or page.query_selector('iframe[title*="Widget"]') or page.query_selector('iframe[title*="cloudflare"]')
                frames = [f for f in page.frames if 'challenges.cloudflare.com' in (f.url or '')]
                if el:
                    try:
                        b = el.bounding_box()
                        if b and b['width'] > 40:
                            page.mouse.move(b['x'] + 28, b['y'] + b['height'] / 2)
                            time.sleep(0.4)
                            page.mouse.click(b['x'] + 28, b['y'] + b['height'] / 2)
                            print('   turnstile coord-click')
                            turnstile_clicked = True
                    except Exception as e:
                        print('   coord click err:', str(e)[:60])
                elif frames:
                    tf = frames[0]
                    try:
                        loc = tf.locator('body').first
                        loc.click(timeout=3000)
                        print('   turnstile body click')
                        turnstile_clicked = True
                    except Exception: pass
            # if "press again" appears, get NEW requiredMs and re-hold
            try:
                txt = page.evaluate("""(() => { const b=[...document.querySelectorAll('button')].find(x=>/hold/i.test(x.textContent)); return b? b.textContent.trim() : ''; })()""")
                if 'again' in txt.lower():
                    print('   overshoot — retrying hold')
                    break
            except Exception: pass
            time.sleep(1.5)

    if not state['dl']:
        page.screenshot(path=f'{OUT}/fail2.png')
        raise SystemExit('no downloads/request')

    dl = state['dl']
    file_url = dl.get('url')
    print('[3] R2 URL acquired!')
    json.dump(dl, open(f'{OUT}/dl-response.json', 'w'), indent=1)

from curl_cffi import requests as cr
r = cr.get(file_url, impersonate='chrome131', timeout=600)
print(f'[4] downloaded: {r.status_code} {len(r.content)/1e6:.1f}MB')
fname = f'{OUT}/{PKG}.apks'
open(fname, 'wb').write(r.content)
sha = hashlib.sha256(r.content).hexdigest()
print('[5] sha256:', sha[:16], '…')

import zipfile
with zipfile.ZipFile(fname) as z:
    names = z.namelist()
    print('[6] bundle:', names)
    z.extractall(f'{OUT}/unpacked')
json.dump({'pkg': PKG, 'sha256': sha, 'bundle': names}, open(f'{OUT}/meta.json', 'w'), indent=1)
print('[✓] COMPLETE —', OUT)
