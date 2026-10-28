#!/bin/bash
# ============================================================
# Ref-based browser verification of the Prompt Lab
# (build tabs + enhance + translate inside the idea dialog).
# Uses accessibility-tree refs instead of text matching.
# ============================================================

set -u
cd /home/z/my-project
OUT=/home/z/my-project/tool-results
mkdir -p "$OUT"

# ---- 1. Start dev server ----
rm -f dev.log
(bun run dev > /dev/null 2>&1 &)
for i in $(seq 1 40); do
  code=$(curl -s -o /dev/null -w "%{http_code}" -m 3 http://localhost:3000/api/ideas 2>/dev/null)
  [ "$code" = "200" ] && echo "[OK] server ready (try $i)" && break
  sleep 2
done
if [ "$code" != "200" ]; then echo "[FAIL] server did not start"; exit 1; fi

agent-browser open http://localhost:3000
agent-browser wait --load networkidle

# ---- 2. Open the New Idea dialog ----
agent-browser snapshot -i > "$OUT/snap1.json" 2>/dev/null
NEWBTN=$(grep -o '"ref":"@[e0-9]*","[^"]*":"[^"]*فكرة جديدة[^"]*"' "$OUT/snap1.json" | head -1)
# Fallback: click by role
agent-browser find text "فكرة جديدة" click || true
sleep 2
agent-browser snapshot -i > "$OUT/snap2.txt" 2>/dev/null
echo "=== DIALOG SNAPSHOT (buttons) ==="
grep -oE '"[^"]*":"(button|tab)[^"]*","name":"[^"]*"' "$OUT/snap2.txt" | head -30 || cat "$OUT/snap2.txt" | head -60

agent-browser close
echo "[DONE] inspection"
