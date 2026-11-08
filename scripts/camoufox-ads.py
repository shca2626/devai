#!/usr/bin/env python3
"""Camoufox apkcube: block ads, click Download APKS, capture file."""
import json, time

from camoufox.sync_api import Camoufox

PKG = 'com.arkanprotailor.arkan_tailor'
URL = f'https://apkcube.com/quroosh-tailor-pos/{PKG}/download'
reqs, resps = [], []
saved = None
AD_DOMAINS = ('rapidadexchange', 'googlesyndication', 'doubleclick', 'adsbygoogle', 'adcash', 'acscdn', 'popads', 'propellerads')

with Camoufox(headless=True, humanize=True, executable_path='/tmp/camoufox/camoufox', i_know_what_im_doing=True) as browser:
    page = browser.new_page()

    def route(r):
        if any(d in r.request.url for d in AD_DOMAINS):
            return r.abort()
        return r.continue_()
    page.route('**/*', route)

    def on_req(r):
        if any(k in r.url for k in ['/api/downloads', '/api/apps', '.apks', 'dl.', 'file']):
            reqs.append({'m': r.method, 'u': r.url[:400], 'post': (r.post_data or '')[:300] if r.method == 'POST' else ''})
    def on_resp(r):
        if '/api/' in r.url:
            try: body = r.text()[:800]
            except Exception: body = '<err>'
            resps.append({'u': r.url[:200], 'status': r.status, 'body': body})
    page.on('request', on_req)
    page.on('response', on_resp)

    page.goto(URL, wait_until='domcontentloaded', timeout=90000)
    for _ in range(30):
        if 'Just a moment' not in page.title():
            break
        time.sleep(1)
    time.sleep(4)

    btn = page.query_selector('button:has-text("Download APKS")') or page.query_selector('button:has-text("Download")')
    print('btn visible initially:', btn.is_visible())

    try:
        with page.expect_download(timeout=45000) as dl_info:
            btn.click()
        dl = dl_info.value
        print('DOWNLOAD URL:', dl.url[:250])
        print('filename:', dl.suggested_filename)
        saved = '/tmp/' + (dl.suggested_filename or 'app.apks')
        dl.save_as(saved)
        print('SAVED:', saved)
    except Exception as e:
        print('first click no download:', str(e)[:100])
        time.sleep(3)
        # re-query button (state may have changed) and force click
        b2 = page.query_selector('button:has-text("Download APKS")') or page.query_selector('button:has-text("Download")')
        if b2:
            print('btn exists, visible:', b2.is_visible())
            try:
                with page.expect_download(timeout=45000) as dl_info2:
                    b2.dispatch_event('click')
                dl = dl_info2.value
                print('DOWNLOAD URL:', dl.url[:250])
                saved = '/tmp/' + (dl.suggested_filename or 'app.apks')
                dl.save_as(saved)
                print('SAVED:', saved)
            except Exception as e2:
                print('force click no download:', str(e2)[:100])
                page.screenshot(path='/tmp/camoufox-blocked-ads.png')
                els = page.eval_on_selector_all('button, a', """els => els.filter(e => e.offsetParent).map(e => (e.textContent||'').trim().slice(0,40)).filter(x => x).slice(0,20)""")
                print('visible now:', els)

print('--- requests ---')
for r in reqs: print(r['m'], r['u'][:150], ('| post: ' + r['post'][:140]) if r.get('post') else '')
print('--- api responses ---')
for r in resps: print(r['status'], r['u'][:110], '->', (r['body'] or '')[:350].replace('\n', ' '))
json.dump({'reqs': reqs, 'resps': resps, 'saved': saved}, open('/tmp/apkcube-final2.json', 'w'), indent=1)
