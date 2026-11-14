#!/usr/bin/env python3
"""Full final report of a site-intel analysis — the v2 depth metrics."""
import json
import sys
import urllib.request

BASE = "http://localhost:3000/api/site-intel"
analysis_id = sys.argv[1]
with urllib.request.urlopen(f"{BASE}?analysisId={analysis_id}", timeout=60) as r:
    d = json.load(r)["analysis"]

data = d.get("data", {})
r_ = data.get("recon") or {}
s = data.get("surface") or {}
b = data.get("bundles") or {}
m = data.get("mined") or {}
a = data.get("apis") or {}
mo = data.get("models") or {}
au = data.get("audit") or {}

print(f"status={d['status']} stages={d['stageDone']}/7 score={d['score']}")
print(f"recon: blocked={r_.get('blocked')} server={r_.get('server')} robots_disallow={len((r_.get('robots') or {}).get('disallows', []))}")
print(f"surface: pages={len(s.get('pages', []))} routePatterns={len(s.get('routePatterns', []))} sitemapUrls={s.get('sitemapUrls')} privateAreas={len(s.get('privateAreas') or [])} probedAlive={sum(1 for p in (s.get('probedPaths') or []) if p['status'] not in (404, 410))}/{len(s.get('probedPaths') or [])} crawledPrivate={s.get('crawledPrivate')}")
print(f"bundles: js={len(b.get('js', []))} ({b.get('totalJsKb')}KB) css={len(b.get('css', []))} chunks={b.get('chunkUrlsFound')} buildId={bool(b.get('buildId'))} buildManifestPages={len(b.get('buildManifestPages') or [])} rendering={b.get('renderingModel')}")
print(f"decompile: sourceMapsRecovered={len(b.get('sourceMapsRecovered') or [])} recoveredKb={b.get('recoveredSourceKb')} modelDefs={len(m.get('modelDefs') or [])}")
print(f"mined: apiCalls={len(m.get('apiCalls', []))} secrets={len(m.get('secrets', []))} envVars={len(m.get('envVars') or [])} i18nKeys={(m.get('i18n') or {}).get('keys', 0)} storageKeys={len(m.get('storageKeys') or [])} thirdParty={len(m.get('thirdPartyDomains') or [])}")
gql = m.get("graphql") or {}
oa = m.get("openApi") or {}
print(f"probes: responseSchemas={len(m.get('responseSchemas') or [])} graphql={gql.get('reachable', False)}(q={len(gql.get('queries', []))},m={len(gql.get('mutations', []))},t={len(gql.get('types', []))}) openApiOps={len(oa.get('paths', []))}")
print(f"apis: endpoints={len(a.get('endpoints', []))} graphqlOps={len(a.get('graphqlOps', []))}")
print(f"models: entities={len(mo.get('entities', []))} -> {[e['name'] for e in mo.get('entities', [])][:12]}")
print(f"audit: sec={len(au.get('security', []))} seo={len(au.get('seo', []))} a11y={len(au.get('a11y', []))} perf={len(au.get('performance', []))}")
print(f"evidence={len(data.get('evidence', []))} unknowns={len(data.get('unknowns', []))} packFiles={len(data.get('pack', []))}")
print()
print("--- evidence claims (first 16) ---")
for e in data.get("evidence", [])[:16]:
    print(f"  [{e['confidence']}] {e['claim'][:150]}")
print()
print("--- endpoints (first 15) ---")
for e in a.get("endpoints", [])[:15]:
    print(f"  {e['method']:7} {e['path'][:70]:72} {e['purpose'][:60]}")
print()
print("--- entities (first 8, with types where available) ---")
for e in mo.get("entities", [])[:8]:
    ft = e.get("fieldTypes") or []
    if ft:
        pairs = ", ".join("{}:{}".format(f["name"], f["type"]) for f in ft[:10])
        print("  {}: {}".format(e["name"], pairs))
    else:
        print("  {}: {}".format(e["name"], ", ".join(e.get("fields", [])[:12])))
print()
print("--- unknowns ---")
for u in data.get("unknowns", [])[:10]:
    print(f"  - {u[:170]}")
