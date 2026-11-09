#!/usr/bin/env python3
"""Screenshot the App Intelligence dialog with a completed analysis."""
import asyncio
import sys

from playwright.async_api import async_playwright

ANALYSIS_ID = sys.argv[1] if len(sys.argv) > 1 else 'cmw9st6ut0005ksvlzovvp0a1'

async def main():
    async with async_playwright() as p:
        browser = await p.chromium.launch()
        page = await browser.new_page(viewport={'width': 900, 'height': 1100})
        await page.goto('http://localhost:3000/', wait_until='domcontentloaded', timeout=60000)
        await page.wait_for_timeout(2500)
        # open the App Intelligence dialog (header button, aria-label in ar or en)
        btn = page.locator('button[aria-label*="استخبارات"], button[aria-label*="App Intelligence"]').first
        await btn.click()
        await page.wait_for_timeout(1500)
        # click the history entry for the analysis (last studied app)
        entry = page.locator(f'text={ANALYSIS_ID[:0]}')  # noop; find by app name instead
        # find the history item by app name
        for name in ('FluffyChat', 'Quroosh'):
            loc = page.locator(f'button:has-text("{name}"), [role="button"]:has-text("{name}")').first
            if await loc.count():
                await loc.click()
                break
        await page.wait_for_timeout(2000)
        await page.screenshot(path='/tmp/ui-appintel-1.png', full_page=False)
        # scroll down to deep intel sections
        dlg = page.locator('[role="dialog"]').first
        for _ in range(6):
            await dlg.evaluate('el => el.scrollBy(0, 700)')
            await page.wait_for_timeout(250)
        await page.screenshot(path='/tmp/ui-appintel-2.png', full_page=False)
        # scroll more (downloads + db + api)
        for _ in range(6):
            await dlg.evaluate('el => el.scrollBy(0, 700)')
            await page.wait_for_timeout(250)
        await page.screenshot(path='/tmp/ui-appintel-3.png', full_page=False)
        # expand first details (endpoints) if present
        await dlg.locator('summary').first.click()
        await page.wait_for_timeout(600)
        await page.screenshot(path='/tmp/ui-appintel-4.png', full_page=False)
        await browser.close()
        print('screenshots saved')

asyncio.run(main())
