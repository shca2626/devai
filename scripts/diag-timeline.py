#!/usr/bin/env python3
"""Definitive timeline experiment: what happens after a successful long hold."""
import json, time

from camoufox.sync_api import Camoufox
from curl_cffi import requests as cr

PKG = 'com.arkanprotailor.arkan_tailor'
r0 = cr.get(f'https://apkcube.com/whatever/{PKG}/download', impersonate='chrome131',
            timeout=40, allow_redirects=True)

with Camoufox(headless=True, humanize=True) as browser:
    page = browser.new_page()
    reqs = []
    dl = []
    token = {}

    def on_resp(r):
        u = r.url
        if 'challenges.cloudflare.com' in u or '/api/downloads' in u or 'download-token' in u:
            reqs.append({'t': round(time.time() % 1000, 1), 'u': u[:130], 's': r.status})
        if '/api/downloads/request' in u:
            try:
                dl.append(r.text())
            except Exception:
                pass
        if 'download-token' in u:
            try:
                token.update(r.json())
            except Exception:
                pass

    page.on('response', on_resp)
    page.goto(r0.url, wait_until='domcontentloaded', timeout=90000)
    for _ in range(40):
        if 'just a moment' not in page.title().lower():
            break
        time.sleep(1)
    btn = None
    for _ in range(30):
        try:
            b = page.query_selector('button:has-text("Download APKS")')
            if b and b.is_visible():
                btn = b
                break
        except Exception:
            pass
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
                const m = document.querySelector('[role=dialog]') || document.body;
                return [...m.querySelectorAll('h1,h2,h3,h4,p,span,button')]
                  .filter(e => e.offsetParent && e.textContent).map(e => e.textContent.trim());
            })()""")).lower()
        except Exception:
            return ''

    # HOLD with human-like micro-movements (moves counter must be > 0)
    box = hold.bounding_box()
    cx, cy = box['x'] + box['width'] / 2, box['y'] + box['height'] / 2
    page.mouse.move(cx, cy)
    time.sleep(0.3)
    page.mouse.down()
    t0 = time.time()
    moves = 0
    while time.time() - t0 < 16:
        # micro-drift like a real thumb
        import random
        dx, dy = random.uniform(-1.5, 1.5), random.uniform(-1.2, 1.2)
        page.mouse.move(cx + dx, cy + dy)
        moves += 1
        txt = modal_text()
        if 'let go now' in txt:
            page.mouse.up()
            print(f'released @{int((time.time()-t0)*1000)}ms moves={moves}', flush=True)
            break
        time.sleep(0.03)
    else:
        page.mouse.up()
        print(f'released timeout moves={moves}', flush=True)

    # timeline: every 5s for 90s — frames, shadow iframes, screenshots
    t0 = time.time()
    clicked = False
    while time.time() - t0 < 90 and not dl:
        el = round(time.time() - t0)
        frames = [f.url[:60] for f in page.frames if f.url and f.url != 'about:blank']
        cf_frames = [f for f in frames if 'cloudflare' in f]
        probe = page.evaluate("""(() => {
            const out = [];
            const collect = (root, inShadow) => {
                for (const el of root.querySelectorAll('iframe')) {
                    const r = el.getBoundingClientRect();
                    if (r.width > 40 && r.height > 20)
                        out.push({src: (el.src||'')slice(0,50), x: Math.round(r.x), y: Math.round(r.y), w: Math.round(r.width), h: Math.round(r.height), sh: inShadow});
                }
                for (const el of root.querySelectorAll('*')) if (el.shadowRoot) collect(el.shadowRoot, true);
            };
            collect(document, false);
            return out;
        })()""") if False else page.evaluate("""(() => {
            const out = [];
            const collect = (root, inShadow) => {
                for (const el of root.querySelectorAll('iframe')) {
                    const r = el.getBoundingClientRect();
                    if (r.width > 40 && r.height > 20)
                        out.push({src: (el.src||'').slice(0,50), x: Math.round(r.x), y: Math.round(r.y), w: Math.round(r.width), h: Math.round(r.height), sh: inShadow});
                }
                for (const el of root.querySelectorAll('*')) if (el.shadowRoot) collect(el.shadowRoot, true);
            };
            collect(document, false);
            return out;
        })()""")
        print(f't={el}s cf_frames={len(cf_frames)} iframes={json.dumps(probe)[:220]}', flush=True)
        if not clicked and probe:
            f = probe[0]
            page.mouse.move(f['x'] + 28, f['y'] + f['h'] / 2, steps=5)
            time.sleep(0.4)
            page.mouse.click(f['x'] + 28, f['y'] + f['h'] / 2)
            clicked = True
            print(f'  *** CLICKED ({f["x"]+28},{f["y"]+f["h"]//2}) ***', flush=True)
        page.screenshot(path=f'/tmp/tl-{el:03d}.png')
        time.sleep(5)

    print('dl fired:', len(dl), flush=True)
    if dl:
        print('RESP:', dl[0][:250], flush=True)
        open('/tmp/dl-resp.json', 'w').write(dl[0])
    print('=== CF/API requests ===', flush=True)
    for r in reqs[-20:]:
        print(' ', r, flush=True)
