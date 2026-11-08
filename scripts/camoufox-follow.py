#!/usr/bin/env python3
"""Camoufox apkcube: click Download, follow any modal/popup until the file starts."""
import json, time

from camoufox.sync_api import Camoufox

PKG = 'com.arkanprotailor.arkan_tailor'
URL = f'https://apkcube.com/quroosh-tailor-pos/{PKG}/download'
reqs = []
popups = []

with Camoufox(headless=True, humanize=True, executable_path='/tmp/camoufox/camoufox', i_know_what_im_doing=True) as browser:
    page = browser.new_page()

    def on_req(r):
        if any(k in r.url for k in ['/api/', '.apks', '.apk', '/dl/', '/file/', 'download', 'cdn']):
            reqs.append({'m': r.method, 'u': r.url[:400], 'post': (r.post_data or '')[:250] if r.method == 'POST' else ''})
    page.on('request', on_req)
    page.on('popup', lambda p: popups.append(p.url[:200]))

    page.goto(URL, wait_until='domcontentloaded', timeout=90000)
    for _ in range(30):
        if 'Just a moment' not in page.title():
            break
        time.sleep(1)
    time.sleep(4)

    btn = page.query_selector('button:has-text("Download")')
    btn.click()
    time.sleep(8)
    page.screenshot(path='/tmp/camoufox-afterclick.png')

    # what changed? modal? new button?
    els = page.eval_on_selector_all('a,button', """els => els.filter(e => e.offsetParent).map(e => ({t: e.tagName, x: (e.textContent||'').trim().slice(0,45), h: (e.getAttribute('href')||'').slice(0,100)})).filter(e => e.x && /down|start|get|install|begin|continue|confirm|click/i.test(e.x + e.h)).slice(0,15)""")
    print('AFTER-CLICK download-ish elements:', json.dumps(els, ensure_ascii=False)[:1200])
    print('popups:', popups)
    page.screenshot(path='/tmp/camoufox-modal.png')

    # try clicking any newly appeared download-ish button, expect download
    for sel_spec in els:
        try:
            b = page.query_selector(f'{sel_spec["t"].lower()}:has-text("{sel_spec["x"][:20]}")')
            if not b or not b.is_visible():
                continue
            print('clicking:', sel_spec['x'][:40], sel_spec['h'][:60])
            try:
                with page.expect_download(timeout=25000) as dl:
                    b.click()
                d = dl.value
                print('DOWNLOAD URL:', d.url[:250])
                print('filename:', d.suggested_filename)
                path = '/tmp/' + (d.suggested_filename or 'app.apks')
                d.save_as(path)
                print('SAVED:', path)
                break
            except Exception:
                time.sleep(6)
                page.screenshot(path=f'/tmp/camoufox-step-{len(reqs)}.png')
        except Exception as e:
            print('step exc:', str(e)[:80])

print('--- captured requests ---')
for r in reqs:
    print(r['m'], r['u'][:140], ('| post: ' + r['post'][:110]) if r.get('post') else '')
json.dump(reqs, open('/tmp/apkcube-reqs.json', 'w'), indent=1)
