#!/usr/bin/env python3
"""COMPLETE apkcube acquisition: full flow -> R2 URL -> download -> verify -> unpack -> jadx."""
import hashlib, json, os, re, subprocess, time

from camoufox.sync_api import Camoufox

PKG = os.environ.get('PKG', 'com.arkanprotailor.arkan_tailor')
SLUG = os.environ.get('SLUG', 'quroosh-tailor-pos')
OUT_DIR = os.environ.get('OUT_DIR', '/tmp/acquired')
os.makedirs(OUT_DIR, exist_ok=True)

URL = f'https://apkcube.com/{SLUG}/{PKG}/download'
reqs = []
dl_response = None

def modal_visible(page):
    try:
        return page.evaluate("!![...document.querySelectorAll('div,section')].find(m => m.offsetParent && /Verify to download/i.test(m.textContent||''))")
    except Exception:
        return False

with Camoufox(headless=True, humanize=True, executable_path='/tmp/camoufox/camoufox', i_know_what_im_doing=True) as browser:
    page = browser.new_page()

    def on_resp(r):
        global dl_response
        if '/api/downloads/request' in r.url:
            try: dl_response = r.json()
            except Exception: dl_response = None
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
                if b and b.is_visible():
                    btn = b; break
            except Exception: pass
        if btn: break
        time.sleep(2)
    if not btn:
        raise SystemExit('no download button')

    btn.click()
    time.sleep(2)

    # hold-to-verify
    hold = None
    for _ in range(10):
        try:
            b = page.query_selector('button:has-text("Hold to verify")')
            if b and b.is_visible():
                hold = b; break
        except Exception: pass
        time.sleep(1)
    if hold:
        box = hold.bounding_box()
        page.mouse.move(box['x'] + box['width'] / 2, box['y'] + box['height'] / 2)
        page.mouse.down()
        time.sleep(2.7)
        page.mouse.up()
        print('[+] hold done')
        time.sleep(4)

    # turnstile
    for attempt in range(45):
        if dl_response:
            break
        frames = [f for f in page.frames if 'challenges.cloudflare.com' in (f.url or '')]
        if frames:
            tf = frames[0]
            for sel in ['input[type=checkbox]', 'label', '#challenge-stage > div', 'body']:
                try:
                    loc = tf.locator(sel).first
                    if loc.count() > 0:
                        loc.click(timeout=4000)
                        print(f'[+] turnstile clicked ({sel}) attempt {attempt}')
                        break
                except Exception:
                    continue
            time.sleep(3.5)
        else:
            time.sleep(1.5)

    if not dl_response:
        page.screenshot(path=OUT_DIR + '/fail.png')
        raise SystemExit('downloads/request never returned')

    file_url = dl_response.get('url')
    print('[+] FILE URL:', file_url[:120], '...')
    json.dump(dl_response, open(f'{OUT_DIR}/dl-response.json', 'w'), indent=1)

# --- download via plain HTTP (R2 signed URL) ---
from curl_cffi import requests as cr
r = cr.get(file_url, impersonate='chrome131', timeout=600)
print('[+] download:', r.status_code, f'{len(r.content)/1e6:.1f} MB')
fname = f'{OUT_DIR}/{PKG}.apks'
open(fname, 'wb').write(r.content)

sha = hashlib.sha256(r.content).hexdigest()
print('[+] sha256:', sha)
print('[+] match expected:', sha == '9d02189dc8d7d77c05179189e120cea612ed0559362b2ca04d068f2ad938fc36')

# --- unpack .apks (zip of split apks) ---
import zipfile
with zipfile.ZipFile(fname) as z:
    names = z.namelist()
    print('[+] bundle contents:', names)
    z.extractall(f'{OUT_DIR}/unpacked')
json.dump({'pkg': PKG, 'file': fname, 'sha256': sha, 'bundle': names}, open(f'{OUT_DIR}/meta.json', 'w'), indent=1)
print('[+] DONE — files in', OUT_DIR)
