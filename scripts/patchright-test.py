#!/usr/bin/env python3
"""Patchright vs Cloudflare on APKPure — the decisive test."""
import sys
from patchright.sync_api import sync_playwright

url = sys.argv[1] if len(sys.argv) > 1 else 'https://apkpure.com/quroosh-tailor-pos/com.arkanprotailor.arkan_tailor'
site = url.split('/')[2]

with sync_playwright() as p:
    browser = p.chromium.launch(headless=True, args=['--disable-blink-features=AutomationControlled'])
    ctx = browser.new_context(locale='en-US', viewport={'width': 1366, 'height': 768})
    page = ctx.new_page()
    page.goto(url, wait_until='domcontentloaded', timeout=60000)

    # wait for CF challenge to clear
    for i in range(40):
        try:
            title = page.title()
        except Exception:
            title = ''
        if title and 'Just a moment' not in title and 'Attention' not in title:
            break
        page.wait_for_timeout(1000)
    print(f'[{site}] title after ~{i+1}s: {page.title()!r}')
    html = page.content()
    print(f'[{site}] html length: {len(html)}')
    ok = len(html) > 20000 and 'Just a moment' not in page.title()
    print(f'[{site}] CF BYPASSED: {ok}')

    if ok:
        # find download link / button on app page
        for sel in ['a[href*="/download"]', '[data-dt-app-id]', 'a.download', '[class*=download]']:
            el = page.query_selector(sel)
            if el:
                href = el.get_attribute('href') or ''
                print(f'  download element {sel!r}: href={href[:90]}')
        page.screenshot(path=f'/tmp/patchright-{site.split(".")[0]}.png')
        # dump cookies for reuse in curl_cffi
        cookies = ctx.cookies()
        import json
        open(f'/tmp/cf-cookies-{site.split(".")[0]}.json', 'w').write(json.dumps(cookies, indent=1))
        cf = [c for c in cookies if c['name'] == 'cf_clearance']
        print(f'  cookies: {len(cookies)}, cf_clearance: {bool(cf)}')
    browser.close()
