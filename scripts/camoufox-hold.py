#!/usr/bin/env python3
"""Camoufox apkcube — click Download, HOLD the verify button for requiredMs, get the file."""
import json, time

from camoufox.sync_api import Camoufox

PKG = 'com.arkanprotailor.arkan_tailor'
URL = f'https://apkcube.com/quroosh-tailor-pos/{PKG}/download'
reqs, resps = [], []
saved = None

with Camoufox(headless=True, humanize=True, executable_path='/tmp/camoufox/camoufox', i_know_what_im_doing=True) as browser:
    page = browser.new_page()

    def on_req(r):
        if any(k in r.url for k in ['/api/downloads', '/api/apps', '.apks', 'dl.']):
            reqs.append({'m': r.method, 'u': r.url[:400], 'post': (r.post_data or '')[:350] if r.method == 'POST' else ''})
    def on_resp(r):
        if '/api/' in r.url:
            try: body = r.text()[:900]
            except Exception: body = '<err>'
            resps.append({'u': r.url[:220], 'status': r.status, 'body': body})
    page.on('request', on_req)
    page.on('response', on_resp)

    page.goto(URL, wait_until='domcontentloaded', timeout=90000)
    for _ in range(40):
        if 'Just a moment' not in page.title():
            break
        time.sleep(1)
    # wait for hydration + button
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
    print('download button ready')

    btn.click()
    time.sleep(2)

    # find the "Hold to verify" button in the modal
    hold = None
    for _ in range(20):
        for sel in ['button:has-text("Hold to verify")', 'button:has-text("Hold")', '[class*=hold]']:
            try:
                b = page.query_selector(sel)
                if b and b.is_visible():
                    hold = b; break
            except Exception: pass
        if hold: break
        time.sleep(1)
    if not hold:
        page.screenshot(path='/tmp/no-hold.png')
        print('no hold button found')
        raise SystemExit(1)
    print('hold button found')

    # get requiredMs from the latest token response if captured
    required_ms = 2500
    for r in resps:
        if 'download-token' in r['u'] and 'hold' in (r['body'] or ''):
            try:
                import re
                m = re.search(r'"requiredMs":(\d+)', r['body'])
                if m: required_ms = min(int(m.group(1)) + 800, 6000)
            except Exception: pass

    box = hold.bounding_box()
    cx, cy = box['x'] + box['width'] / 2, box['y'] + box['height'] / 2
    print(f'holding at ({cx:.0f},{cy:.0f}) for {required_ms}ms')
    page.mouse.move(cx, cy)
    page.mouse.down()
    time.sleep(required_ms / 1000)
    page.mouse.up()
    print('released; waiting for download...')
    time.sleep(4)

    try:
        with page.expect_download(timeout=60000) as dl_info:
            pass  # download may have already started; if not, click main btn again
        dl = dl_info.value
    except Exception:
        btn2 = page.query_selector('button:has-text("Download APKS")') or page.query_selector('button:has-text("Download")')
        if btn2:
            try:
                with page.expect_download(timeout=60000) as dl_info2:
                    btn2.click()
                dl = dl_info2.value
            except Exception as e:
                print('still no download:', str(e)[:100])
                page.screenshot(path='/tmp/after-hold.png')
                raise SystemExit(1)
        else:
            raise SystemExit('no button and no download')

    print('DOWNLOAD URL:', dl.url[:250])
    print('filename:', dl.suggested_filename)
    saved = '/tmp/' + (dl.suggested_filename or 'app.apks')
    dl.save_as(saved)
    print('SAVED:', saved)

print('--- requests ---')
for r in reqs: print(r['m'], r['u'][:160], ('| post: ' + r['post'][:170]) if r.get('post') else '')
json.dump({'reqs': reqs, 'resps': resps, 'saved': saved}, open('/tmp/apkcube-hold.json', 'w'), indent=1)
