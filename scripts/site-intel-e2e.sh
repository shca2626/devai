#!/usr/bin/env bash
# Site Intelligence v2 — full-chain acceptance driver
# Usage: bash scripts/site-intel-e2e.sh <url> [analysisId]
set -u
BASE="http://localhost:3000/api/site-intel"
URL="${1:?need a target URL}"
ID="${2:-}"

echo "[e2e] target: $URL"

if [ -z "$ID" ]; then
  RESP=$(curl -s -m 120 -X POST "$BASE" -H 'Content-Type: application/json' -d "{\"url\":\"$URL\",\"lang\":\"en\"}")
  ID=$(echo "$RESP" | python3 -c 'import json,sys; d=json.load(sys.stdin); print(d.get("analysis",{}).get("id",""))' 2>/dev/null)
  if [ -z "$ID" ]; then
    echo "[e2e] START FAILED: $RESP" | head -c 600
    exit 1
  fi
fi
echo "[e2e] analysisId: $ID"

for i in $(seq 1 20); do
  STATUS=$(python3 "$(dirname "$0")/site-intel-status.py" "$ID" 2>/dev/null)
  echo "[e2e] poll $i → $STATUS"
  case "$STATUS" in
    "complete 7"*) break ;;
    "failed"*) break ;;
  esac
  RESP=$(curl -s -m 300 -X POST "$BASE" -H 'Content-Type: application/json' -d "{\"analysisId\":\"$ID\",\"lang\":\"en\"}")
  STATUS=$(python3 "$(dirname "$0")/site-intel-status.py" "$ID" 2>/dev/null)
  echo "[e2e] stage $i → $STATUS"
  case "$STATUS" in
    "complete 7"*) break ;;
    "failed"*) break ;;
  esac
done

echo "===== FINAL ====="
python3 "$(dirname "$0")/site-intel-report.py" "$ID"
