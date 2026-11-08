#!/usr/bin/env python3
"""Camoufox apkcube — hold with DOM feedback: release exactly when the ring completes."""
import json, re, time

from camoufox.sync_api import Camoufox

PKG = 'com.arkanprotailor.arkan_tailor'
URL = f'https://apkcube.com/quroosh-tailor-pos/{PKG}/download'
reqs, resps = [], []
saved = None

with Camoufox(headless=True, humanize=True, executable_path='/tmp/camoufox/camoufox', i_know_what_im_doing=True) as browser:
    page = browser.new_page()

    def on_req(r):
        if any(k in r.url for k in ['/api/', '.apks', 'dl.', 'cdn-cgi']):
            reqs.append({'m': r.method, 'u': r.url[:300], 'post': (r.post_data or '')[:200] if r.method == 'POST' else ''})
    def on_resp(r):
        if '/api/' in r.url:
            try: body = r.text()[:700]
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

    hold = None
    for _ in range(20):
        for sel in ['button:has-text("Hold to verify")', 'button:has-text("Hold")']:
            try:
                b = page.query_selector(sel)
                if b and b.is_visible():
                    hold = b; break
            except Exception: pass
        if hold: break
        time.sleep(1)
    print('hold button present:', bool(hold))

    required_ms = None
    for r in resps:
        if 'download-token' in r['u']:
            m = re.search(r'"requiredMs":(\d+)', r['body'] or '')
            if m: required_ms = int(m.group(1))
    print('requiredMs from token:', required_ms)

    box = hold.bounding_box()
    cx, cy = box['x'] + box['width'] / 2, box['y'] + box['height'] / 2
    page.mouse.move(cx, cy)
    page.mouse.down()

    # poll for completion signal: aria attributes, classes, svg dashoffset, disabled state
    t0 = time.time()
    released = False
    while time.time() - t0 < 8:
        elapsed_ms = (time.time() - t0) * 1000
        state = page.evaluate("""(() => {
            const btn = [...document.querySelectorAll('button')].find(b => /hold/i.test(b.textContent));
            if (!btn) return 'NOBTN';
            const cls = btn.className || '';
            const aria = btn.getAttribute('aria-valuenow') || btn.getAttribute('aria-disabled') || '';
            const svg = btn.querySelector('circle[stroke-dashoffset], circle[class*=progress]');
            const dash = svg ? svg.getAttribute('stroke-dashoffset') : '';
            return JSON.stringify({txt: btn.textContent.trim().slice(0,40), cls: cls.toString().slice(0,80), aria, dash});
        })()""")
        if 'NOBTN' in str(state):
            break
        # completion heuristics
        if any(k in str(state) for k in ['complete', 'success', 'Verified', 'done', 'aria-disabled="false"']):
            page.mouse.up(); released = True
            print(f'RELEASED on signal at {elapsed_ms:.0f}ms: {state[:120]}')
            break
        # svg dashoffset near 0 = ring full
        m = re.search(r'"dash":\\?"(-?[\\d.]+)', str(state))
        if m:
            try:
                if abs(float(m.group(1))) < 5:
                    page.mouse.up(); released = True
                    print(f'RELEASED ring-full at {elapsed_ms:.0f}ms')
                    break
            except Exception: pass
        # fallback: exact requiredMs timing
        if required_ms and elapsed_ms >= required_ms + 120:
            page.mouse.up(); released = True
            print(f'RELEASED on timer at {elapsed_ms:.0f}ms')
            break
        if 'again' in str(state) or 'too long' in str(state).lower():
            print(f'OVERSHOT at {elapsed_ms:.0f}ms: {state[:100]}')
            page.mouse.up(); released = True
            break
        time.sleep(0.06)
    if not released:
        page.mouse.up()
    time.sleep(5)
    page.screenshot(path='/tmp/hold-result.png')

    # check if download link/button appeared
    try:
        with page.expect_download(timeout=30000) as dl_info:
            page.keyboard.press(' ')  # space also triggers
        dl = dl_info.value
        print('DOWNLOAD URL:', dl.url[:250])
        saved = '/tmp/' + (dl.suggested_filename or 'app.apks')
        dl.save_as(saved)
        print('SAVED:', saved)
    except Exception:
        # maybe downloads/request already gave a URL — check responses
        print('--- state after hold ---')
        for r in resps[-6:]: print(r['status'], r['u'][:100], '->', (r['body'] or '')[:200].replace('\n', ' '))
        for r in reqs[-8:]: print(r['m'], r['u'][:130])
        page.screenshot(path='/tmp/hold-final.png')

print('=== captured api ===')
for r in resps: print(r['status'], r['u'][:110], '->', (r['body'] or '')[:250].replace('\n', ' '))
json.dump({'reqs': reqs, 'resps': resps, 'saved': saved}, open('/tmp/apkcube-hold2.json', 'w'), indent=1)
