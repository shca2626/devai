#!/usr/bin/env bash
# E2E driver chunk — idempotent. Each invocation:
#   1. ensures the dev server is up (restarts if the sandbox reaped it)
#   2. resumes the in-flight analysis via the resume endpoint (self-heal path)
#      or starts a fresh one from the input URL
#   3. polls for up to ~7 minutes, then exits
# State persists in .app-intel/e2e-state.json so chunks chain.
set -u
cd /home/z/my-project
INPUT="${1:?usage: e2e-drive.sh <play-url-or-pkg> [lang]}"
LANG_="${2:-ar}"
STATE=.app-intel/e2e-state.json
LOG=/tmp/e2e-drive.log

ensure_server() {
  if curl -s -o /dev/null -w "%{http_code}" http://localhost:3000 --max-time 5 | grep -q 200; then
    return 0
  fi
  echo "[drive $(date +%H:%M:%S)] (re)starting dev server…" >> "$LOG"
  pkill -f "next dev" 2>/dev/null; pkill -f next-server 2>/dev/null; sleep 1
  setsid nohup bun run dev > /tmp/dev-server.log 2>&1 < /dev/null &
  for i in $(seq 1 30); do
    sleep 2
    if curl -s -o /dev/null -w "%{http_code}" http://localhost:3000 --max-time 5 | grep -q 200; then
      return 0
    fi
  done
  # turbopack cache corruption from unclean kills — clear and retry once
  echo "[drive $(date +%H:%M:%S)] retrying with cleared .next cache…" >> "$LOG"
  pkill -f "next dev" 2>/dev/null; pkill -f next-server 2>/dev/null; sleep 1
  rm -rf .next
  setsid nohup bun run dev > /tmp/dev-server.log 2>&1 < /dev/null &
  for i in $(seq 1 40); do
    sleep 2
    if curl -s -o /dev/null -w "%{http_code}" http://localhost:3000 --max-time 5 | grep -q 200; then
      return 0
    fi
  done
  echo "[drive] server failed to start" >> "$LOG"
  return 1
}

ensure_server || exit 1

# start-or-resume
if [ -f "$STATE" ]; then
  ID=$(bun -e "console.log(JSON.parse(require('fs').readFileSync('$STATE','utf8')).id)" 2>/dev/null)
  STATUS=$(bun -e "console.log(JSON.parse(require('fs').readFileSync('$STATE','utf8')).status)" 2>/dev/null)
  if [ -n "$ID" ] && [ "$STATUS" = "running" ]; then
    echo "[drive $(date +%H:%M:%S)] resuming $ID" >> "$LOG"
    curl -s -X POST http://localhost:3000/api/app-intel -H 'Content-Type: application/json' \
      -d "{\"analysisId\":\"$ID\",\"resume\":true,\"lang\":\"$LANG_\"}" --max-time 30 > /dev/null
  fi
else
  RESP=$(curl -s -X POST http://localhost:3000/api/app-intel -H 'Content-Type: application/json' \
    -d "{\"input\":\"$INPUT\",\"lang\":\"$LANG_\"}" --max-time 120)
  ID=$(echo "$RESP" | bun -e "const d=JSON.parse(await new Response(Bun.stdin.stream()).text()); console.log(d.analysis?.id ?? 'FAILED')" 2>/dev/null)
  if [ -z "$ID" ] || [ "$ID" = "FAILED" ]; then
    echo "[drive] START FAILED: $RESP" | head -c 500 >> "$LOG"
    exit 2
  fi
  echo "{\"id\":\"$ID\",\"status\":\"running\",\"pkg\":\"$INPUT\"}" > "$STATE"
  echo "[drive $(date +%H:%M:%S)] started $ID for $INPUT" >> "$LOG"
fi

# poll chunk (7 min)
DEADLINE=$((SECONDS + 420))
LAST=""
while [ $SECONDS -lt $DEADLINE ]; do
  sleep 10
  JSON=$(curl -s "http://localhost:3000/api/app-intel?analysisId=$ID" --max-time 20 2>/dev/null)
  if [ -z "$JSON" ]; then
    ensure_server || true
    curl -s -X POST http://localhost:3000/api/app-intel -H 'Content-Type: application/json' \
      -d "{\"analysisId\":\"$ID\",\"resume\":true,\"lang\":\"$LANG_\"}" --max-time 30 > /dev/null 2>&1
    continue
  fi
  LINE=$(echo "$JSON" | bun -e "
const d=JSON.parse(await new Response(Bun.stdin.stream()).text());
const a=d.analysis; if(!a){console.log('POLL_ERROR');process.exit(0)}
console.log(\`\${a.stageDone}/7 \${a.status} score=\${a.score} ev=\${a.data?.evidence?.length ?? 0}\`)" 2>/dev/null)
  if [ "$LINE" != "$LAST" ] && [ -n "$LINE" ]; then
    echo "[drive $(date +%H:%M:%S)] $LINE" >> "$LOG"
    LAST="$LINE"
  fi
  STATUS=$(echo "$LINE" | awk '{print $2}')
  if [ "$STATUS" = "complete" ] || [ "$STATUS" = "failed" ]; then
    bun -e "const fs=require('fs');const s=JSON.parse(fs.readFileSync('$STATE','utf8'));s.status='$STATUS';fs.writeFileSync('$STATE',JSON.stringify(s))"
    echo "[drive $(date +%H:%M:%S)] DONE: $LINE" >> "$LOG"
    exit 0
  fi
done
echo "[drive $(date +%H:%M:%S)] chunk ended, still running: $LAST" >> "$LOG"
exit 4
