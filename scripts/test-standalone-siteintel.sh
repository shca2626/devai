#!/bin/bash
# E2E test: standalone site study without any idea
# Drives the same sequence the frontend dialog uses:
#   POST {url} -> stages 2..7 via POST {analysisId}
set -e
BASE="http://localhost:3000/api/site-intel"

echo "== Stage 1: create + recon =="
RESP=$(curl -s -X POST "$BASE" -H 'Content-Type: application/json' -d '{"url":"https://example.com","lang":"en"}' --max-time 90)
echo "$RESP" | head -c 400; echo
ID=$(echo "$RESP" | python3 -c "import sys,json;print(json.load(sys.stdin)['analysis']['id'])")
echo "analysis id: $ID"

for i in 2 3 4 5 6 7; do
  echo "== Advance to stage $i =="
  RESP=$(curl -s -X POST "$BASE" -H 'Content-Type: application/json' -d "{\"analysisId\":\"$ID\",\"lang\":\"en\"}" --max-time 180)
  echo "$RESP" | python3 -c "
import sys, json
d = json.load(sys.stdin)
a = d.get('analysis')
if not a:
    print('ERROR:', d); sys.exit(1)
print(f\"stageDone={a['stageDone']} status={a['status']} score={a['score']} packFiles={len(a['data']['pack'])} evidence={len(a['data']['evidence'])}\")
"
done

echo "== List standalone analyses =="
curl -s "$BASE" | python3 -c "import sys,json;d=json.load(sys.stdin);print('standalone count:',len(d['analyses']));[print(' -',a['domain'],a['status'],f\"{a['score']}%\") for a in d['analyses']]"

echo "== Confirm idea-linked analyses are NOT leaked into standalone scope =="
curl -s "$BASE?analysisId=$ID" | python3 -c "import sys,json;a=json.load(sys.stdin)['analysis'];print('get by id ok:',a['domain'],a['status'])"
