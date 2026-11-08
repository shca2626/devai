#!/usr/bin/env python3
"""Diagnostic: what happens between hold-done and downloads/request."""
import json, os, re, sys, time

from camoufox.sync_api import Camoufox

PKG = os.environ.get('PKG', 'com.arkanprotailor.arkan_tailor')
OUT = '/tmp/acquired-diag'
os.makedirs(OUT, exist_ok=True)

from curl_cffi import requests as cr
r0 = cr.get(f'https://apkcube.com/whatever/{PKG}/download', impersonate='chrome131',
            timeout=40, allow_redirects=True)
URL = r0.url if f'/{PKG}' in r0.url else f'https://apkcube.com/apk-downloader?url={PKG}'
print('entry:', URL, flush=True)

events = []


def log(tag, obj={}):
    events.append({'t': round(time.time() % 10000, 2), 'tag': tag, **obj})
    print(' ', tag, json.dumps(obj, ensure_ascii=False)[:240], flush=True)


with Camoufox(headless=True, humanize=True) as browser:
    page = browser.new_page()
    page.on('console', lambda m: log('console', {'type': m.type, 'text': m.text[:200]})
            if m.type in ('error', 'warning') else None)
    page.on('pageerror', lambda e: log('pageerror', {'e': str(e)[:200]}))

    def on_req(req):
        u = req.url
        if any(k in u for k in ['challenges.cloudflare.com', '61723', 'turnstile', '/api/downloads']):
            log('req', {'u': u[:160], 'm': req.method})

    def on_resp(r):
        u = r.url
        if 'challenges.cloudflare.com' in u or '61723' in u:
            log('resp', {'u': u[:140], 's': r.status})
        elif '/api/downloads/request' in u:
            try:
                log('downloads-request', {'s': r.status, 'body': r.text()[:250]})
            except Exception:
                pass

    page.on('request', on_req)
    page.on('response', on_resp)
    dl_seen = []
    page.on('response', lambda r: dl_seen.append(r) if '/api/downloads/request' in r.url else None)

    page.goto(URL, wait_until='domcontentloaded', timeout=90000)
    for _ in range(40):
        if 'just a moment' not in page.title().lower():
            break
        time.sleep(1)

    btn = None
    for _ in range(30):
        for sel in ['button:has-text("Download APKS")', 'button:has-text("Get APK")']:
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
    if not btn:
        raise SystemExit('no button')
    btn.click()
    log('clicked-download')

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
    if not hold:
        raise SystemExit('no hold widget')

    box = hold.bounding_box()
    page.mouse.move(box['x'] + box['width'] / 2, box['y'] + box['height'] / 2)
    time.sleep(0.3)
    page.mouse.down()
    log('mouse-down')

    def modal_text():
        try:
            return ' '.join(page.evaluate("""(() => {
                const m = document.querySelector('[role="dialog"]') || document.body;
                return [...m.querySelectorAll('h1,h2,h3,h4,p,span,button')]
                  .filter(e => e.offsetParent && e.textContent)
                  .map(e => e.textContent.trim());
            })()""")).lower()
        except Exception:
            return ''

    t0 = time.time()
    while time.time() - t0 < 15:
        txt = modal_text()
        if 'let go now' in txt or 'verified' in txt:
            page.mouse.up()
            log('released', {'cue': 'let go now' if 'let go now' in txt else 'verified',
                             'ms': int((time.time() - t0) * 1000)})
            break
        time.sleep(0.04)
    else:
        page.mouse.up()
        log('released', {'cue': 'timeout'})

    # watch the modal closely for 60s: state text + DOM changes + screenshots
    prev = ''
    for i in range(60):
        time.sleep(1)
        txt = modal_text()
        if txt != prev:
            log('modal', {'txt': txt[:300]})
            prev = txt
        if i in (2, 5, 10, 20, 40):
            page.screenshot(path=f'{OUT}/post-release-{i}s.png')
        if dl_seen:
            log('DONE', {})
            break

    # dump modal HTML for exact structure
    try:
        html = page.evaluate("""(() => {
            const m = document.querySelector('[role="dialog"]');
            return m ? m.outerHTML : document.body.outerHTML.slice(0, 5000);
        })()""")
        open(f'{OUT}/modal.html', 'w').write(html)
        log('modal-html-saved', {'len': len(html)})
    except Exception as e:
        log('modal-html-err', {'e': str(e)[:100]})

json.dump(events, open(f'{OUT}/events.json', 'w'), indent=1)
print('events saved')
