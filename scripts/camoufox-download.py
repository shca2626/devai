#!/usr/bin/env python3
"""Camoufox: click Download APKS on apkcube, capture the real file URL, save the .apks bundle."""
import json, time

from camoufox.sync_api import Camoufox

PKG = 'com.arkanprotailor.arkan_tailor'
URL = f'https://apkcube.com/quroosh-tailor-pos/{PKG}/download'
reqs = []

with Camoufox(headless=True, humanize=True, executable_path='/tmp/camoufox/camoufox', i_know_what_im_doing=True) as browser:
    page = browser.new_page()

    def on_req(r):
        if any(k in r.url for k in ['/api/', '.apks', '.apk', '/dl/', '/file/', 'download']):
            reqs.append({'m': r.method, 'u': r.url[:400], 'post': (r.post_data or '')[:300] if r.method == 'POST' else ''})
    page.on('request', on_req)

    page.goto(URL, wait_until='domcontentloaded', timeout=90000)
    for _ in range(30):
        if 'Just a moment' not in page.title():
            break
        time.sleep(1)
    print('title:', repr(page.title()))
    time.sleep(4)

    btn = None
    for sel in ['button:has-text("Download APKS")', 'button:has-text("Download")']:
        try:
            b = page.query_selector(sel)
            if b and b.is_visible():
                btn = b; print('button:', sel); break
        except Exception:
            pass
    if not btn:
        raise SystemExit('download button not found')

    # click and accept the download
    with page.expect_download(timeout=90000) as dl_info:
        btn.click()
    dl = dl_info.value
    print('DOWNLOAD STARTED:', dl.url[:200])
    print('suggested filename:', dl.suggested_filename)
    path = f"/tmp/{dl.suggested_filename or PKG + '.apks'}"
    dl.save_as(path)
    print('SAVED:', path)

json.dump({'requests': reqs, 'url': dl.url, 'file': path}, open('/tmp/apkcube-dl-meta.json', 'w'), indent=1)
print('--- interesting requests ---')
for r in reqs:
    print(r['m'], r['u'][:130], ('| post: ' + r['post'][:100]) if r.get('post') else '')
