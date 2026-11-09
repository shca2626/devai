#!/usr/bin/env python3
"""Capture download-token + apks API bodies for a package (compare valid vs failing)."""
import json
import sys
import time

from camoufox.sync_api import Camoufox

PKG = sys.argv[1] if len(sys.argv) > 1 else 'com.arkanpro.arkan_cpe_beta'

from curl_cffi import requests as cr
r = cr.get(f'https://apkcube.com/whatever/{PKG}/download', impersonate='chrome131', timeout=40, allow_redirects=True)
url = r.url if f'/{PKG}' in (r.url or '') else f'https://apkcube.com/apk-downloader?url={PKG}'

with Camoufox(headless=True, humanize=True) as browser:
    page = browser.new_page()
    bodies = {}
    def on_resp(resp):
        u = resp.url
        if '/api/' not in u:
            return
        try:
            bodies[u.split('?')[0]] = resp.json()
        except Exception:
            bodies[u.split('?')[0]] = '(non-json)'
    page.on('response', on_resp)
    page.goto(url, wait_until='domcontentloaded', timeout=90000)
    for _ in range(45):
        if 'just a moment' not in page.title().lower():
            break
        time.sleep(1)
    # give the page time to load its own API calls
    time.sleep(8)
    btn = None
    for _ in range(20):
        for sel in ['button:has-text("Download APKS")', 'button:has-text("Download")']:
            b = page.query_selector(sel)
            if b and b.is_visible():
                btn = b
                break
        if btn:
            break
        time.sleep(2)
    if btn:
        btn.click()
        time.sleep(10)
    for k, v in bodies.items():
        if 'download-token' in k:
            print('DOWNLOAD-TOKEN BODY:', json.dumps(v)[:800])
        if 'downloads/request' in k:
            print('DOWNLOADS-REQUEST BODY:', json.dumps(v)[:800])
    page.close()
