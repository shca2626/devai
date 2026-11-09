#!/usr/bin/env python3
"""Diagnose apkcube modal state over time for a package (fetch-in-progress theory)."""
import json
import sys
import time

from camoufox.sync_api import Camoufox

PKG = sys.argv[1] if len(sys.argv) > 1 else 'com.arkanpro.arkan_cpe_beta'
WATCH_S = int(sys.argv[2]) if len(sys.argv) > 2 else 150

from curl_cffi import requests as cr
r = cr.get(f'https://apkcube.com/whatever/{PKG}/download', impersonate='chrome131', timeout=40, allow_redirects=True)
url = r.url if f'/{PKG}' in (r.url or '') else f'https://apkcube.com/apk-downloader?url={PKG}'
print('entry ->', url)

with Camoufox(headless=True, humanize=True) as browser:
    page = browser.new_page()
    api = []
    page.on('response', lambda resp: api.append({'u': resp.url[:110], 's': resp.status})
            if '/api/' in resp.url else None)
    page.goto(url, wait_until='domcontentloaded', timeout=90000)
    for _ in range(45):
        if 'just a moment' not in page.title().lower():
            break
        time.sleep(1)

    btn = None
    for _ in range(30):
        for sel in ['button:has-text("Download APKS")', 'button:has-text("Download")']:
            b = page.query_selector(sel)
            if b and b.is_visible():
                btn = b
                break
        if btn:
            break
        time.sleep(2)
    if not btn:
        print('NO BUTTON'); sys.exit(1)
    print('button text:', btn.text_content())
    btn.click()

    import random
    # wait for hold widget
    hold = None
    for _ in range(25):
        h = page.query_selector('button:has-text("Hold to verify")')
        if h and h.is_visible():
            hold = h
            break
        time.sleep(1)
    if hold:
        box = hold.bounding_box()
        cx, cy = box['x'] + box['width'] / 2, box['y'] + box['height'] / 2
        page.mouse.move(cx, cy); time.sleep(0.25); page.mouse.down()
        t0 = time.time()
        while time.time() - t0 < 16:
            page.mouse.move(cx + random.uniform(-1.5, 1.5), cy + random.uniform(-1.2, 1.2))
            txt = ' '.join(page.evaluate("""(() => {
                const m = document.querySelector('[role="dialog"]') || document.body;
                return [...m.querySelectorAll('h1,h2,h3,h4,p,span,button')]
                  .filter(e => e.offsetParent && e.textContent).map(e => e.textContent.trim());
            })()""")).lower()
            if 'let go now' in txt:
                page.mouse.up()
                print(f'hold released @ {int((time.time()-t0)*1000)}ms')
                break
            time.sleep(0.03)
        else:
            page.mouse.up()
            print('hold timeout')

    # watch the modal evolve for WATCH_S seconds, logging text transitions
    last = ''
    t0 = time.time()
    while time.time() - t0 < WATCH_S:
        try:
            txt = ' '.join(page.evaluate("""(() => {
                const m = document.querySelector('[role="dialog"]') || document.body;
                return [...m.querySelectorAll('h1,h2,h3,h4,p,span,button')]
                  .filter(e => e.offsetParent && e.textContent).map(e => e.textContent.trim());
            })()"""))
        except Exception:
            txt = '(eval failed)'
        key = ' '.join(txt.lower().split())[:160]
        if key != last:
            print(f'[{int(time.time()-t0):3d}s] {key}')
            last = key
        # dump api hits
        while api:
            print('   API:', api.pop(0))
        time.sleep(2)

    page.screenshot(path='/tmp/diag-final.png')
    html = page.content()
    open('/tmp/diag-modal.html', 'w').write(html)
    print('final screenshot + html saved')
