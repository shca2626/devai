#!/bin/bash
# Start dev server, wait for ready, run standalone site-intel E2E, then shut down.
cd /home/z/my-project
rm -f dev.log
bun run dev > /dev/null 2>&1 &
SERVER_PID=$!

# Wait for readiness (up to 90s)
for i in $(seq 1 45); do
  CODE=$(curl -s -o /dev/null -w "%{http_code}" http://localhost:3000 --max-time 4 2>/dev/null || echo 000)
  if [ "$CODE" = "200" ]; then echo "[server ready after ~$((i*2))s]"; break; fi
  sleep 2
done
if [ "$CODE" != "200" ]; then echo "[SERVER FAILED TO START]"; kill $SERVER_PID 2>/dev/null; exit 1; fi

bash scripts/test-standalone-siteintel.sh
TEST_RC=$?

kill $SERVER_PID 2>/dev/null
echo "[server stopped, test rc=$TEST_RC]"
exit $TEST_RC
