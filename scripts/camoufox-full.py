#!/usr/bin/env python3
"""Camoufox apkcube — FINAL: hold + Turnstile click + download."""
import json, re, time

from camoufox.sync_api import Camoufox

PKG = 'com.arkanprotailor.arkan_tailor'
URL = f'https://apkcube.com/quroosh-tailor-pos/{PKG}/download'
reqs, resps = [], []
saved = None

with Camoufox(headless=True, humanize=True, executable_path='/tmp/camoufox/camoufox', i_know_what_im_doing=True) as browser:
    page = browser.new_page()

    def on_req(r):
        if any(k in r.url for k in ['/api/', '.apks', 'dl.']):
            reqs.append({'m': r.method, 'u': r.url[:400], 'post': (r.post_data or '')[:350] if r.method == 'POST' else ''})
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

    # --- stage 1: hold-to-verify (if present) ---
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
        time.sleep(3)

    # --- stage 2: Turnstile checkbox (if present) ---
    for attempt in range(25):
        tf_iframe = None
        for f in page.frames:
            if 'challenges.cloudflare.com' in (f.url or ''):
                tf_iframe = f; break
        if tf_iframe:
            print('turnstile frame found:', tf_iframe.url[:80])
            try:
                # the checkbox area: input, label, or the widget body
                clicked = False
                for click_sel in ['input[type=checkbox]', 'label', '#challenge-stage', 'body', '.ctp-checkbox-label']:
                    try:
                        loc = tf_iframe.locator(click_sel).first
                        if loc.count() > 0 and loc.is_visible():
                            loc.click(timeout=5000)
                            print('clicked turnstile:', click_sel)
                            clicked = True
                            break
                    except Exception:
                        continue
                if not clicked:
                    # fallback: click at the iframe's coordinates
                    el = page.query_selector('iframe[src*="challenges.cloudflare.com"]')
                    if el:
                        b = el.bounding_box()
                        page.mouse.click(b['x'] + 28, b['y'] + b['height'] / 2)
                        print('clicked turnstile by coords')
                        clicked = True
                if clicked:
                    time.sleep(6)
            except Exception as e:
                print('turnstile click err:', str(e)[:80])
        # check verified / modal gone
        modal_open = page.evaluate("""!![...document.querySelectorAll('[role=dialog], [class*=modal]')].find(m => m.offsetParent && /verify/i.test(m.textContent||''))""")
        if not modal_open:
            print('modal closed — verified!')
            break
        time.sleep(2)

    # --- stage 3: download ---
    try:
        with page.expect_download(timeout=45000) as dl_info:
            btn = page.query_selector('button:has-text("Download APKS")') or page.query_selector('button:has-text("Download")')
            if btn: btn.click()
        dl = dl_info.value
        print('DOWNLOAD URL:', dl.url[:250])
        print('filename:', dl.suggested_filename)
        saved = '/tmp/' + (dl.suggested_filename or 'app.apks')
        dl.save_as(saved)
        print('SAVED:', saved)
    except Exception as e:
        print('no download yet:', str(e)[:100])
        page.screenshot(path='/tmp/final-state.png')

print('=== api ===')
for r in resps: print(r['status'], r['u'][:110], '->', (r['body'] or '')[:220].replace('\n', ' '))
print('=== requests ===')
for r in reqs: print(r['m'], r['u'][:150], ('| post: ' + r['post'][:180]) if r.get('post') else '')
json.dump({'reqs': reqs, 'resps': resps, 'saved': saved}, open('/tmp/apkcube-final4.json', 'w'), indent=1)
