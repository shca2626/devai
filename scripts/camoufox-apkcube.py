#!/usr/bin/env python3
"""Camoufox vs apkcube /download CF + Turnstile — click the real button, capture the real file URL."""
import json, sys, time

from camoufox.sync_api import Camoufox

PKG = 'com.arkanprotailor.arkan_tailor'
URL = f'https://apkcube.com/quroosh-tailor-pos/{PKG}/download'
OUT = '/tmp/apkcube-capture.json'

capture = {'requests': [], 'downloads': [], 'final_title': None}

with Camoufox(headless=True, humanize=True) as browser:
    page = browser.new_page()
    page.on('request', lambda r: capture['requests'].append({'url': r.url[:300], 'method': r.method})
            if any(k in r.url for k in ['/api/', '.apk', '.xapk', 'download', 'turnstile']) else None)

    page.goto(URL, wait_until='domcontentloaded', timeout=90000)

    # wait for CF to clear
    for i in range(60):
        try:
            t = page.title()
        except Exception:
            t = ''
        if t and 'Just a moment' not in t and 'moment' not in t.lower():
            break
        time.sleep(1)
    capture['final_title'] = page.title()
    print(f'title after {i+1}s: {page.title()!r}')
    print('CF cleared:', 'Just a moment' not in page.title())

    if 'Just a moment' not in page.title():
        # let turnstile settle
        time.sleep(5)
        # find the download button
        btn = None
        for sel in ['button:has-text("Download")', 'a:has-text("Download")', 'button:has-text("APK")',
                    'a:has-text("APK")', '[data-testid*=download]', 'button:has-text("Start")']:
            try:
                btn = page.query_selector(sel)
                if btn and btn.is_visible():
                    print('button found:', sel)
                    break
                btn = None
            except Exception:
                btn = None
        if not btn:
            # dump interactive elements for inspection
            els = page.eval_on_selector_all('a,button', """els => els.filter(e => e.offsetParent).map(e => ({t: e.tagName, x: (e.textContent||'').trim().slice(0,40), h: (e.getAttribute('href')||'').slice(0,80)})).slice(0,30)""")
            print('VISIBLE ELEMENTS:', json.dumps(els, ensure_ascii=False)[:1500])
        else:
            btn.click()
            print('clicked; waiting for download request...')
            time.sleep(15)
        page.screenshot(path='/tmp/camoufox-apkcube.png')
    else:
        page.screenshot(path='/tmp/camoufox-cf-stuck.png')

    # dump interesting captured requests
    for r in capture['requests'][-25:]:
        print('REQ:', r['method'], r['url'][:160])

json.dump(capture, open(OUT, 'w'), indent=1)
print('saved', OUT)
