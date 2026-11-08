#!/usr/bin/env python3
"""Camoufox apkcube — robust: wait for CF clear, poll for button, block only ads, click, save."""
import json, time

from camoufox.sync_api import Camoufox

PKG = 'com.arkanprotailor.arkan_tailor'
URL = f'https://apkcube.com/quroosh-tailor-pos/{PKG}/download'
reqs, resps = [], []
saved = None
AD = ('rapidadexchange', 'googlesyndication', 'doubleclick', 'adcash', 'acscdn', 'popads', 'propellerads')

with Camoufox(headless=True, humanize=True, executable_path='/tmp/camoufox/camoufox', i_know_what_im_doing=True) as browser:
    page = browser.new_page()
    for d in AD:
        try: page.route(f'**/*{d}*/*', lambda r: r.abort())
        except Exception: pass

    def on_req(r):
        if any(k in r.url for k in ['/api/downloads', '/api/apps', '.apks', 'dl.apkcube']):
            reqs.append({'m': r.method, 'u': r.url[:400], 'post': (r.post_data or '')[:300] if r.method == 'POST' else ''})
    def on_resp(r):
        if '/api/' in r.url:
            try: body = r.text()[:800]
            except Exception: body = '<err>'
            resps.append({'u': r.url[:200], 'status': r.status, 'body': body})
    page.on('request', on_req)
    page.on('response', on_resp)

    page.goto(URL, wait_until='domcontentloaded', timeout=90000)
    for _ in range(40):
        if 'Just a moment' not in page.title():
            break
        time.sleep(1)
    print('title:', repr(page.title()[:60]))

    btn = None
    for attempt in range(30):
        for sel in ['button:has-text("Download APKS")', 'button:has-text("Download")']:
            try:
                b = page.query_selector(sel)
                if b and b.is_visible():
                    btn = b; break
            except Exception: pass
        if btn: break
        time.sleep(2)
    if not btn:
        page.screenshot(path='/tmp/cf-nobtn.png')
        els = page.eval_on_selector_all('button, a', """els => els.filter(e => e.offsetParent).map(e => (e.textContent||'').trim().slice(0,45)).filter(x=>x).slice(0,20)""")
        print('NO BUTTON. visible:', els)
        raise SystemExit(1)
    print('button ready after ~%ds' % (attempt * 2))

    try:
        with page.expect_download(timeout=60000) as dl_info:
            btn.click()
        dl = dl_info.value
        print('DOWNLOAD URL:', dl.url[:250])
        print('filename:', dl.suggested_filename)
        saved = '/tmp/' + (dl.suggested_filename or 'app.apks')
        dl.save_as(saved)
        print('SAVED:', saved)
    except Exception as e:
        print('click1 no download:', str(e)[:90])
        time.sleep(3)
        b2 = None
        for sel in ['button:has-text("Download APKS")', 'button:has-text("Download")', 'a:has-text("Download")']:
            try:
                b2 = page.query_selector(sel)
                if b2: break
            except Exception: pass
        if b2:
            try:
                with page.expect_download(timeout=60000) as d2:
                    b2.dispatch_event('click')
                dl = d2.value
                print('DOWNLOAD URL:', dl.url[:250])
                saved = '/tmp/' + (dl.suggested_filename or 'app.apks')
                dl.save_as(saved)
                print('SAVED:', saved)
            except Exception as e2:
                print('click2 no download:', str(e2)[:90])
                page.screenshot(path='/tmp/cf-state2.png')

print('--- requests ---')
for r in reqs: print(r['m'], r['u'][:160], ('| post: ' + r['post'][:150]) if r.get('post') else '')
print('--- api responses ---')
for r in resps: print(r['status'], r['u'][:110], '->', (r['body'] or '')[:300].replace('\n', ' '))
json.dump({'reqs': reqs, 'resps': resps, 'saved': saved}, open('/tmp/apkcube-final3.json', 'w'), indent=1)
