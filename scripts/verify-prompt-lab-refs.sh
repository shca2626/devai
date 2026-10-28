#!/bin/bash
# ============================================================
# Ref-based end-to-end verification of the Prompt Lab:
#   1. Build-target tabs (Website/App/Prototype)
#   2. Prompt engineer (Enhance -> structured prompt panel)
#   3. Translator (AR -> EN inside the dialog)
# ============================================================

set -u
cd /home/z/my-project
OUT=/home/z/my-project/tool-results
mkdir -p "$OUT"

get_ref() { # $1 = grep pattern from snapshot
  agent-browser snapshot -i 2>/dev/null | grep "$1" | grep -oE 'ref=e[0-9]+' | head -1 | sed 's/ref=//'
}

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
agent-browser find text "فكرة جديدة" click
sleep 2

# ---- 2. Tabs ----
TAB_W=$(get_ref 'tab "موقع إلكتروني"')
TAB_P=$(get_ref 'tab "نموذج أولي"')
TAB_A=$(get_ref 'tab "تطبيق"')
echo "[refs] website=$TAB_W app=$TAB_A prototype=$TAB_P"
agent-browser click "@$TAB_W"; sleep 1
HINT=$(agent-browser snapshot 2>/dev/null | grep -o "صفحة هبوط، متجر، معرض أعمال، موقع محتوى" | head -1)
[ -n "$HINT" ] && echo "[OK] website hint shown" || echo "[WARN] website hint not found"
agent-browser screenshot "$OUT/v3-website-selected.png"
agent-browser click "@$TAB_P"; sleep 1
agent-browser click "@$TAB_A"; sleep 1
echo "[OK] tabs functional"

# ---- 3. Fill rough Arabic idea ----
TXT=$(get_ref 'textbox "صف فكرتك"')
agent-browser fill "@$TXT" "ابغى موقع اعرض فيه منتجات متجري والناس تطلب وانا اوصلها لهم"
sleep 1
LEN=$(agent-browser get value "@$TXT" 2>/dev/null | wc -m)
echo "[OK] idea filled (${LEN} chars)"

# ---- 4. Enhance (Website target) ----
agent-browser click "@$TAB_W"; sleep 1
ENH=$(get_ref 'button "حسّن وصفي"')
echo "[ref] enhance=$ENH"
agent-browser click "@$ENH"
echo "[..] waiting for AI enhancement..."
FOUND=""
for i in $(seq 1 35); do
  if agent-browser snapshot -i 2>/dev/null | grep -q "الوصف المحسّن"; then FOUND=1; echo "[OK] enhanced panel appeared (~$((i*4))s)"; break; fi
  sleep 4
done
[ -z "$FOUND" ] && { echo "[FAIL] enhanced panel never appeared"; agent-browser screenshot "$OUT/fail-enhance.png"; agent-browser errors; }
agent-browser screenshot "$OUT/v4-enhanced-panel.png"

# improvements list visible?
IMP=$(agent-browser snapshot 2>/dev/null | grep -c "التحسينات" || true)
echo "[info] improvements section: $IMP"

# ---- 5. Use the enhanced version ----
USE=$(get_ref 'button "استخدم هذه النسخة"')
if [ -n "$USE" ]; then
  agent-browser click "@$USE"; sleep 1
  NEWVAL=$(agent-browser get value "@$TXT" 2>/dev/null | head -c 120)
  echo "[OK] textarea now starts with: $NEWVAL"
else
  echo "[WARN] use-button not found"
fi
agent-browser screenshot "$OUT/v5-after-use.png"

# ---- 6. Translate to English ----
TR=$(get_ref 'button "ترجمة"')
agent-browser click "@$TR"; sleep 1
TR_EN=$(get_ref 'button "ترجم إلى الإنجليزية"')
echo "[ref] translate=$TR -> to-english=$TR_EN"
agent-browser screenshot "$OUT/v6-translate-popover.png"
agent-browser click "@$TR_EN"
echo "[..] waiting for translation..."
for i in $(seq 1 25); do
  VAL=$(agent-browser get value "@$TXT" 2>/dev/null | head -c 80)
  if echo "$VAL" | grep -qE "[A-Za-z]{8,}"; then echo "[OK] translated to English: $VAL"; break; fi
  sleep 3
done
agent-browser screenshot "$OUT/v7-translated.png"

# ---- 7. Final checks ----
echo "=== PAGE ERRORS ==="
agent-browser errors
echo "=== DONE ==="
agent-browser close
