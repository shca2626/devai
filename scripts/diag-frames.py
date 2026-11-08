#!/usr/bin/env python3
"""Focused: after hold, what frames exist and what's in the turnstile frame?"""
import json, re, time

from camoufox.sync_api import Camoufox

PKG = 'com.arkanprotailor.arkan_tailor'
from curl_cffi import requests as cr
r0 = cr.get(f'https://apkcube.com/whatever/{PKG}/download', impersonate='chrome131',
            timeout=40, allow_redirects=True)
URL = r0.url
print('entry:', URL, flush=True)

with Camoufox(headless=True, humanize=True) as browser:
    page = browser.new_page()
    page.goto(URL, wait_until='domcontentloaded', timeout=90000)
    for _ in range(40):
        if 'just a moment' not in page.title().lower():
            break
        time.sleep(1)

    btn = None
    for _ in range(30):
        for sel in ['button:has-text("Download APKS")', 'button:has-text("Download")']:
            try:
                b = page.query_selector(sel)
                if b and b.is_visible():
                    btn = b
                    break
            except Exception:
                pass
        if btn:
            break
        time.sleep(2)
    btn.click()

    hold = None
    for _ in range(20):
        try:
            h = page.query_selector('button:has-text("Hold to verify")')
            if h and h.is_visible():
                hold = h
                break
        except Exception:
            pass
        time.sleep(1)

    def modal_text():
        try:
            return ' '.join(page.evaluate("""(() => {
                const m = document.querySelector('[role="dialog"]') || document.body;
                return [...m.querySelectorAll('h1,h2,h3,h4,p,span,button')]
                  .filter(e => e.offsetParent && e.textContent).map(e => e.textContent.trim());
            })()""")).lower()
        except Exception:
            return ''

    box = hold.bounding_box()
    page.mouse.move(box['x'] + box['width'] / 2, box['y'] + box['height'] / 2)
    time.sleep(0.25)
    page.mouse.down()
    t0 = time.time()
    while time.time() - t0 < 15:
        txt = modal_text()
        if 'let go now' in txt or 'verified' in txt or 'a little longer' in txt:
            page.mouse.up()
            print(f'released @ {int((time.time()-t0)*1000)}ms', flush=True)
            break
        time.sleep(0.04)
    else:
        page.mouse.up()
        print('released timeout', flush=True)

    # now dump frames every 5s for 40s + try turnstile DOM from page context
    for i in range(8):
        time.sleep(5)
        frames = [(f.url or '')[:90] for f in page.frames]
        cf = [f for f in frames if 'cloudflare' in f]
        print(f'--- t={5*(i+1)}s frames={len(frames)} cf={len(cf)}', flush=True)
        for f in frames:
            print('   F:', f, flush=True)
        # iframe elements in DOM
        try:
            iframes = page.evaluate("""[...document.querySelectorAll('iframe')]
                .map(f => ({src: (f.src||'')[:90], w: f.offsetWidth, h: f.offsetHeight, 
                            name: f.name, title: f.title}))""")
            for f in iframes:
                print('   IFRAME:', json.dumps(f), flush=True)
        except Exception as e:
            print('   iframe-dump-err:', str(e)[:80], flush=True)
        page.screenshot(path=f'/tmp/acq4diag/t-{5*(i+1)}s.png')

    # finally: try frame-internal click on the CF frame with ALL selectors
    cf_frames = [f for f in page.frames if 'challenges.cloudflare.com' in (f.url or '')]
    if cf_frames:
        tf = cf_frames[0]
        print('CF frame found:', tf.url[:80], flush=True)
        for sel in ['input[type=checkbox]', 'label', 'mark', '#challenge-stage', 'body']:
            try:
                loc = tf.locator(sel).first
                n = loc.count()
                print(f'  sel {sel}: count={n}', flush=True)
                if n > 0:
                    loc.click(timeout=3000)
                    print(f'  CLICKED {sel}', flush=True)
                    break
            except Exception as e:
                print(f'  sel {sel}: err {str(e)[:90]}', flush=True)
        time.sleep(10)
        page.screenshot(path='/tmp/acq4diag/after-click.png')
        # any downloads request?
        print('downloads fired:', any('/api/downloads/request' in (r.url) for r in []), flush=True)
    else:
        print('NO CF FRAME FOUND', flush=True)
