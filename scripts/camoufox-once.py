#!/usr/bin/env python3
"""Camoufox apkcube: one click on Download APKS, capture request AND response bodies."""
import json, time

from camoufox.sync_api import Camoufox

PKG = 'com.arkanprotailor.arkan_tailor'
URL = f'https://apkcube.com/quroosh-tailor-pos/{PKG}/download'
reqs, resps = [], []

with Camoufox(headless=True, humanize=True, executable_path='/tmp/camoufox/camoufox', i_know_what_im_doing=True) as browser:
    page = browser.new_page()

    def on_req(r):
        if any(k in r.url for k in ['/api/', '.apks', '.apk', '/dl', 'download', 'cdn']):
            reqs.append({'m': r.method, 'u': r.url[:400], 'post': (r.post_data or '')[:300] if r.method == 'POST' else ''})
    def on_resp(r):
        if any(k in r.url for k in ['/api/downloads', '/api/apps', 'dl.', '.apks']):
            try:
                resps.append({'u': r.url[:200], 'status': r.status, 'body': r.text()[:600]})
            except Exception:
                resps.append({'u': r.url[:200], 'status': r.status, 'body': '<binary or error>'})
    page.on('request', on_req)
    page.on('response', on_resp)

    page.goto(URL, wait_until='domcontentloaded', timeout=90000)
    for _ in range(30):
        if 'Just a moment' not in page.title():
            break
        time.sleep(1)
    time.sleep(4)

    print('clicking Download APKS...')
    btn = page.query_selector('button:has-text("Download APKS")') or page.query_selector('button:has-text("Download")')
    btn.click()
    time.sleep(12)  # let the api flow + possible redirect happen
    page.screenshot(path='/tmp/camoufox-dlstate.png')

    # did a download start? check again quickly
    print('--- REQUESTS ---')
    for r in reqs: print(r['m'], r['u'][:150], ('| post: ' + r['post'][:130]) if r.get('post') else '')
    print('--- RESPONSES ---')
    for r in resps: print(r['status'], r['u'][:130], '->', (r['body'] or '')[:250].replace('\n', ' '))

json.dump({'reqs': reqs, 'resps': resps}, open('/tmp/apkcube-flow.json', 'w'), indent=1)
print('saved /tmp/apkcube-flow.json')
