#!/usr/bin/env python3
"""Site Intelligence E2E — runs the full 7-stage pipeline against the
fixture site (http://localhost:4599) and asserts the study pack's
honesty guarantees. Usage: python3 scripts/site-intel-e2e.py [url]"""
import json
import sys
import urllib.request

BASE = 'http://localhost:3000'
TARGET = sys.argv[1] if len(sys.argv) > 1 else 'http://localhost:4599'
FIXTURE = 'localhost:4599' in TARGET  # fixture-specific assertions only apply there


def api(path, body=None, method=None):
    if body is not None:
        req = urllib.request.Request(
            BASE + path,
            data=json.dumps(body).encode(),
            headers={'Content-Type': 'application/json'},
            method=method or 'POST',
        )
    else:
        req = urllib.request.Request(BASE + path, method=method or 'GET')
    with urllib.request.urlopen(req, timeout=600) as r:
        return json.loads(r.read().decode())


def main():
    ideas = api('/api/ideas')['ideas']
    assert ideas, 'no ideas exist in the workspace'
    idea_id = ideas[0]['id']
    print(f'[e2e] idea: {idea_id}')
    print(f'[e2e] target: {TARGET}')

    # Stage 1: recon (create)
    res = api(f'/api/ideas/{idea_id}/site-intel', {'url': TARGET, 'lang': 'en'})
    a = res['analysis']
    print(f"[e2e] stage 1 recon: HTTP {a['data']['recon']['httpStatus']}, blocked={a['data']['recon']['blocked']}, "
          f"robots disallows={len(a['data']['recon']['robots']['disallows'])}")
    assert a['stageDone'] == 1, f"expected stageDone=1, got {a['stageDone']}"
    assert a['data']['recon']['httpStatus'] == 200

    # Stages 2..7: advance one at a time
    stage_names = ['recon', 'surface', 'bundles', 'apis', 'models', 'audit', 'synthesis']
    while a['status'] == 'running' and a['stageDone'] < 7:
        a = api(f'/api/ideas/{idea_id}/site-intel', {'analysisId': a['id'], 'lang': 'en'})['analysis']
        done = a['stageDone']
        print(f"[e2e] stage {done}/7 ({stage_names[done-1]}) done — score {a['score']}%")
        if a['status'] == 'failed':
            print(f"[e2e] FAILED at stage {done}: {a['error']}")
            sys.exit(1)

    assert a['status'] == 'complete', f"final status: {a['status']} ({a['error']})"
    d = a['data']

    # --- Assertions: the honesty contract ---
    print('\n=== VERDICTS ===')
    print(f"score: {a['score']}%  |  evidence: {len(d['evidence'])}  |  unknowns: {len(d['unknowns'])}")
    print(f"pages crawled: {len(d['surface']['pages'])}  |  route patterns: {d['surface']['routePatterns']}")
    print(f"js bundles: {len(d['bundles']['js'])}  |  frameworks: {[f['name'] for f in d['bundles']['frameworks']][:8]}")
    print(f"endpoints: {len(d['apis']['endpoints'])}  |  graphql: {d['apis']['graphqlOps']}  |  ws: {d['apis']['websockets']}")
    print(f"entities: {[e['name'] for e in d['models']['entities']]}")
    print(f"audit: sec {len(d['audit']['security'])} / seo {len(d['audit']['seo'])} / a11y {len(d['audit']['a11y'])} / perf {len(d['audit']['performance'])}")
    print(f"pack files ({len(d['pack'])}): {[f['name'] for f in d['pack']]}")

    checks = []
    def check(name, ok, fixture_only=False):
        if fixture_only and not FIXTURE:
            return
        checks.append((name, ok))
        print(('  PASS  ' if ok else '  FAIL  ') + name)

    check('7/7 stages completed', a['stageDone'] == 7)
    check('completeness score is plausible (0-100)', 0 <= a['score'] <= 100)
    check('completeness score is honest (fixture >=40 / real site any)', (a['score'] >= 40) if FIXTURE else True)
    check('16 pack files produced', len(d['pack']) == 16)

    urls = [p['url'] for p in d['surface']['pages']]
    check('crawled >= 6 pages', len(urls) >= 6, fixture_only=True)
    check('at least the homepage was crawled', len(urls) >= 1)
    check('robots-disallowed /admin NEVER crawled', all('/admin' not in u for u in urls), fixture_only=True)
    check('/admin skip recorded (robots evidence or unknowns)', a['data']['surface']['skippedByRobots'] >= 1, fixture_only=True)

    pats = d['surface']['routePatterns']
    check('route pattern /products/:id inferred', '/products/:id' in pats, fixture_only=True)
    check('route pattern /blog/:slug inferred', '/blog/:slug' in pats, fixture_only=True)

    fw = [f['name'] for f in d['bundles']['frameworks']]
    check('React fingerprint detected', any('React' in x for x in fw), fixture_only=True)
    check('source map in production flagged', len(d['bundles']['sourceMaps']) >= 1, fixture_only=True)

    tokens = d['bundles']['designTokens']
    check('design tokens: #0ea5e9 among top colors', any(c['hex'] == '#0ea5e9' for c in tokens['colors']), fixture_only=True)
    check('design tokens: Inter font detected', any('Inter' in f for f in tokens['fonts']), fixture_only=True)
    check('design tokens: breakpoint 768px', any('768' in b for b in tokens['breakpoints']), fixture_only=True)

    eps = {(e['method'], e['path']) for e in d['apis']['endpoints']}
    check('mined GET /api/products', ('GET', '/api/products') in eps or any('/api/products' in p for _, p in eps), fixture_only=True)
    check('mined POST /api/cart', ('POST', '/api/cart') in eps or any('/api/cart' in p for _, p in eps), fixture_only=True)
    check('GraphQL ops captured', len(d['apis']['graphqlOps']) >= 1, fixture_only=True)
    check('WebSocket captured', len(d['apis']['websockets']) >= 1, fixture_only=True)

    secrets = d['mined']['secrets']
    check('AWS key pattern found + redacted', any(s['pattern'] == 'AWS access key' and 'EXAMPLE' not in s['snippet'] for s in secrets), fixture_only=True)

    ent_names = [e['name'].lower() for e in d['models']['entities']]
    check('data entities inferred (>=2)', len(d['models']['entities']) >= 2, fixture_only=True)

    audit_sec = json.dumps(d['audit']['security'])
    check('audit: missing CSP flagged', 'CSP' in audit_sec or 'content-security' in audit_sec.lower())
    check('audit: hardcoded secret finding', 'AWS' in audit_sec or 'secret' in audit_sec.lower() or 'key' in audit_sec.lower(), fixture_only=True)

    man = json.loads(next(f['content'] for f in d['pack'] if f['name'] == 'manifest.json'))
    check('manifest: static-only method note', 'static analysis only' in man['method'])
    ev = json.loads(next(f['content'] for f in d['pack'] if f['name'] == 'evidence.json'))
    check('evidence ledger exported with entries', ev['count'] >= 5 and len(ev['evidence']) == ev['count'])
    unknowns_md = next(f['content'] for f in d['pack'] if f['name'] == 'unknowns.md')
    check('unknowns.md lists limitations', 'static' in unknowns_md.lower() or len(d['unknowns']) >= 1)

    over = next(f['content'] for f in d['pack'] if f['name'] == 'overview.md')
    check('overview.md substantive (>200 chars)', len(over) > 200)

    failed = [n for n, ok in checks if not ok]
    print(f"\n{'='*40}\n[site-intel-e2e] {len(checks)-len(failed)}/{len(checks)} checks passed")
    if failed:
        print('[site-intel-e2e] FAILED CHECKS:')
        for n in failed:
            print('  - ' + n)
        sys.exit(1)
    print('[site-intel-e2e] ALL CHECKS PASSED ✔')


if __name__ == '__main__':
    main()
