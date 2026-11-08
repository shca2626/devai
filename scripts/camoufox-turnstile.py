#!/usr/bin/env python3
"""Camoufox apkcube — hold + TURNSTLE CLICK (fixed) + download."""
import json, re, time

from camoufox.sync_api import Camoufox

PKG = 'com.arkanprotailor.arkan_tailor'
URL = f'https://apkcube.com/quroosh-tailor-pos/{PKG}/download'
reqs, resps = [], []
saved = None

def modal_visible(page):
    try:
        return page.evaluate("""!![...document.querySelectorAll('div,section,[role=dialog]')].find(m => m.offsetParent && /Verify to download/i.test(m.textContent||''))""")
    except Exception:
        return False

with Camoufox(headless=True, humanize=True, executable_path='/tmp/camoufox/camoufox', i_know_what_im_doing=True) as browser:
    page = browser.new_page()

    def on_req(r):
        if any(k in r.url for k in ['/api/', '.apks', 'dl.']):
            reqs.append({'m': r.method, 'u': r.url[:400], 'post': (r.post_data or '')[:400] if r.method == 'POST' else ''})
    def on_resp(r):
        if '/api/' in r.url:
            try: body = r.text()[:900]
            except Exception: body = '<err>'
            resps.append({'u': r.url[:200], 'status': r.status, 'body': body})
    page.on('request', on_req)
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

    btn.click()
    time.sleep(2)

    # --- hold ---
    hold = None
    for _ in range(10):
        try:
            b = page.query_selector('button:has-text("Hold to verify")')
            if b and b.is_visible():
                hold = b; break
        except Exception: pass
        time.sleep(1)
    if hold:
        required_ms = None
        for r in resps:
            if 'download-token' in r['u']:
                m = re.search(r'"requiredMs":(\d+)', r['body'] or '')
                if m: required_ms = int(m.group(1))
        dur = (required_ms or 2200) / 1000 + 0.15
        box = hold.bounding_box()
        page.mouse.move(box['x'] + box['width'] / 2, box['y'] + box['height'] / 2)
        page.mouse.down()
        time.sleep(dur)
        page.mouse.up()
        print(f'held {dur*1000:.0f}ms')
        time.sleep(4)

    # --- TURNSTILE: wait for iframe, click checkbox, wait for pass ---
    turnstile_done = False
    for attempt in range(40):
        frames = [f for f in page.frames if 'challenges.cloudflare.com' in (f.url or '')]
        if frames:
            tf = frames[0]
            try:
                # try clicking the checkbox/label inside the turnstile iframe
                for sel in ['input[type=checkbox]', 'label', '#challenge-stage > div', 'body']:
                    try:
                        loc = tf.locator(sel).first
                        if loc.count() > 0:
                            loc.click(timeout=4000)
                            print(f'turnstile clicked: {sel} (attempt {attempt})')
                            break
                    except Exception:
                        continue
            except Exception as e:
                print('tf err:', str(e)[:60])
            time.sleep(4)
            # verified? modal should vanish or requests fire
            if any('downloads/request' in r['u'] for r in reqs):
                print('downloads/request FIRED')
                turnstile_done = True
                break
        if not modal_visible(page) and attempt > 4:
            print('modal gone at attempt', attempt)
            turnstile_done = True
            break
        time.sleep(1.5)

    print('turnstile phase done:', turnstile_done)
    time.sleep(3)
    page.screenshot(path='/tmp/post-turnstile.png')

    # --- download ---
    try:
        with page.expect_download(timeout=50000) as dl_info:
            b2 = page.query_selector('button:has-text("Download APKS")') or page.query_selector('button:has-text("Download")')
            if b2 and b2.is_visible():
                b2.click()
        dl = dl_info.value
        print('DOWNLOAD URL:', dl.url[:250])
        print('filename:', dl.suggested_filename)
        saved = '/tmp/' + (dl.suggested_filename or 'app.apks')
        dl.save_as(saved)
        print('SAVED:', saved)
    except Exception as e:
        print('download attempt:', str(e)[:110])
        # maybe already downloading via api url — dump
        page.screenshot(path='/tmp/post-turnstile-final.png')

print('=== api ===')
for r in resps: print(r['status'], r['u'][:110], '->', (r['body'] or '')[:250].replace('\n', ' '))
print('=== requests ===')
for r in reqs: print(r['m'], r['u'][:150], ('| post: ' + r['post'][:200]) if r.get('post') else '')
json.dump({'reqs': reqs, 'resps': resps, 'saved': saved}, open('/tmp/apkcube-final5.json', 'w'), indent=1)
