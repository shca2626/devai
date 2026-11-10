#!/usr/bin/env bash
# Retry the Quroosh (com.arkanprotailor.arkan_tailor) acquisition after the
# Cloudflare IP-fatigue window clears, then run the FULL 7-stage analysis.
# Success = APK + 2085-file jadx sources + report published to GitHub
# (app-intel/com.arkanprotailor.arkan_tailor/) — all automatic.
set -u
cd /home/z/my-project
LOG=/tmp/quroosh-retry.log
echo "[retry $(date)] starting" >> "$LOG"

# 1. server up?
if ! curl -s -o /dev/null -w "%{http_code}" http://localhost:3000 --max-time 5 | grep -q 200; then
  pkill -f "next dev" 2>/dev/null; pkill -f next-server 2>/dev/null; sleep 1
  rm -rf .next
  setsid nohup bun run dev > /tmp/dev-server.log 2>&1 < /dev/null &
  for i in $(seq 1 40); do
    sleep 2
    if curl -s -o /dev/null -w "%{http_code}" http://localhost:3000 --max-time 5 | grep -q 200; then break; fi
  done
fi
curl -s -o /dev/null -w "%{http_code}" http://localhost:3000 --max-time 5 | grep -q 200 || { echo "[retry] server down" >> "$LOG"; exit 1; }

# 2. fresh analysis (autopilot drives it server-side)
RESP=$(curl -s -X POST http://localhost:3000/api/app-intel -H 'Content-Type: application/json' \
  -d '{"input":"com.arkanprotailor.arkan_tailor","lang":"ar"}' --max-time 120)
ID=$(echo "$RESP" | bun -e "const d=JSON.parse(await new Response(Bun.stdin.stream()).text()); console.log(d.analysis?.id ?? 'FAILED')" 2>/dev/null)
[ -z "$ID" ] || [ "$ID" = "FAILED" ] && { echo "[retry] start failed: $RESP" >> "$LOG"; exit 2; }
echo "[retry $(date)] analysis $ID started" >> "$LOG"

# 3. poll up to 25 min
for i in $(seq 1 150); do
  sleep 10
  J=$(curl -s "http://localhost:3000/api/app-intel?analysisId=$ID" --max-time 20 2>/dev/null)
  LINE=$(echo "$J" | bun -e "const d=JSON.parse(await new Response(Bun.stdin.stream()).text()); const a=d.analysis; if(!a){console.log('ERR');process.exit(0)} console.log(\`\${a.stageDone}/7 \${a.status} score=\${a.score} acquired=\${!!a.data?.acquire}\`)" 2>/dev/null)
  echo "[retry $(date +%H:%M)] $LINE" >> "$LOG"
  case "$LINE" in
    *complete*|*failed*) break ;;
  esac
done

# 4. verdict
echo "$J" | bun -e "const d=JSON.parse(await new Response(Bun.stdin.stream()).text()); const a=d.analysis; console.log('FINAL', a.status, a.stageDone, 'score', a.score, 'acquired', !!a.data?.acquire, a.data?.artifacts?.githubUrl ?? '')" >> "$LOG"
tail -3 "$LOG"
