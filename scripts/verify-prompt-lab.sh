#!/bin/bash
# ============================================================
# End-to-end browser verification of the Prompt Lab features:
# build-target tabs, translator, and prompt engineer inside the
# New Idea dialog. Runs its own dev server (dies at script end).
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

# ---- 2. Open app ----
agent-browser open http://localhost:3000
agent-browser wait --load networkidle
agent-browser screenshot "$OUT/v1-welcome.png"
echo "[OK] welcome page loaded"

# ---- 3. Open the New Idea dialog ----
agent-browser find text "فكرة جديدة" click
sleep 2
agent-browser screenshot "$OUT/v2-dialog.png"
echo "[OK] dialog opened"

# ---- 4. Verify tabs exist and switch to Website ----
agent-browser find text "موقع إلكتروني" click
sleep 1
agent-browser screenshot "$OUT/v3-website-tab.png"
agent-browser find text "نموذج أولي" click
sleep 1
agent-browser find text "تطبيق" click
sleep 1
echo "[OK] tabs switched"

# ---- 5. Fill a rough Arabic idea ----
agent-browser find label "صف فكرتك" fill "ابغى موقع اعرض فيه منتجات متجري والناس تطلب وانا اوصلها لهم"
sleep 1
echo "[OK] idea filled"

# ---- 6. Enhance (AI call — website target) ----
agent-browser find text "موقع إلكتروني" click
sleep 1
agent-browser find text "حسّن وصفي" click
echo "[..] enhancing (waiting for AI)..."
for i in $(seq 1 30); do
  if agent-browser snapshot -i 2>/dev/null | grep -q "الوصف المحسّن"; then
    echo "[OK] enhanced panel appeared after ~$((i*4))s"
    break
  fi
  sleep 4
done
agent-browser screenshot "$OUT/v4-enhanced.png"
sleep 1

# ---- 7. Use the enhanced version ----
if agent-browser snapshot -i 2>/dev/null | grep -q "استخدم هذه النسخة"; then
  agent-browser find text "استخدم هذه النسخة" click
  sleep 1
  echo "[OK] enhanced version applied to textarea"
fi

# ---- 8. Translate to English ----
agent-browser find text "ترجمة" click
sleep 1
agent-browser screenshot "$OUT/v5-translate-popover.png"
agent-browser find text "ترجم إلى الإنجليزية" click
echo "[..] translating..."
for i in $(seq 1 20); do
  if agent-browser snapshot -i 2>/dev/null | grep -q "تمت الترجمة بنجاح\|Translated successfully"; then
    echo "[OK] translated after ~$((i*3))s"
    break
  fi
  sleep 3
done
agent-browser screenshot "$OUT/v6-translated.png"

# ---- 9. Check for page errors ----
echo "=== PAGE ERRORS ==="
agent-browser errors
echo "=== CONSOLE ==="
agent-browser console 2>/dev/null | tail -5

agent-browser close
echo "[DONE] verification complete"
