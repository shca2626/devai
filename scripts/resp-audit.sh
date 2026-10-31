#!/bin/bash
# Responsive audit for DevAI — checks every stage view at multiple viewports
# Reports: document horizontal overflow + elements rendered off-screen
set -u

NAV_JS='document.querySelector("nav[aria-label=\"Workflow stages\"]") ? document.querySelectorAll("nav[aria-label=\"Workflow stages\"] button").length : -1'
CLICK_JS='(function(){ const btns=document.querySelectorAll("nav[aria-label=\"Workflow stages\"] button"); if(btns[NTH]){btns[NTH].click(); return "clicked-"+NTH;} return "no-btn";})()'

CHECK_JS='JSON.stringify((function(){
  var d=document.documentElement;
  var issues=[];
  var vw=window.innerWidth;
  document.querySelectorAll("body *").forEach(function(el){
    var r=el.getBoundingClientRect();
    var st=getComputedStyle(el);
    if(st.position==="fixed") return;
    if(r.width>0 && r.height>0 && (r.right>vw+2 || r.left<-2)){
      var cls=(el.className&&typeof el.className==="string")?el.className.split(" ").slice(0,5).join(" "):"";
      issues.push({tag:el.tagName.toLowerCase(),cls:cls.slice(0,80),L:Math.round(r.left),R:Math.round(r.right)});
    }
  });
  // unique by cls
  var seen={}; var uniq=[];
  issues.forEach(function(i){var k=i.tag+"|"+i.cls;if(!seen[k]){seen[k]=1;uniq.push(i);}});
  return {vw:vw,scrollW:d.scrollWidth,clientW:d.clientWidth,overflow:d.scrollWidth>d.clientWidth,issues:uniq.slice(0,10)};
})())'

run_check() {
  local label="$1"
  agent-browser wait 900 >/dev/null 2>&1
  local out
  out=$(agent-browser eval "$CHECK_JS" 2>/dev/null | tail -1)
  # unescape the JSON string if needed
  if command -v python3 >/dev/null 2>&1; then
    out=$(python3 -c "
import sys, json
s = sys.argv[1].strip()
try:
    v = json.loads(s)
    if isinstance(v, str): v = json.loads(v)
    print(json.dumps(v, ensure_ascii=False))
except Exception:
    print(s)
" "$out" 2>/dev/null || echo "$out")
  fi
  echo "  [$label] $out"
}

echo "=== IDEA: opening richest idea (package stage, all stages have data) ==="
agent-browser open http://localhost:3000 >/dev/null 2>&1
agent-browser wait 1500 >/dev/null 2>&1

# Select idea via sidebar (mobile: open sheet first). Use desktop viewport for selection simplicity
agent-browser set viewport 1440 900 >/dev/null 2>&1
agent-browser wait 800 >/dev/null 2>&1
# Click the idea titled "AI Software Engineer"
agent-browser find text "AI Software Engineer" click >/dev/null 2>&1
agent-browser wait 2000 >/dev/null 2>&1
n=$(agent-browser eval "$NAV_JS" 2>/dev/null | tail -1)
echo "Stepper buttons found: $n"

VIEWS=("1-Understand" "2-Discover" "3-Features" "4-Baseline" "5-Requirements" "6-Design" "7-Planning" "8-Readiness" "9-Package")
VIEWPORTS=("320 568" "375 667" "390 844" "768 1024" "1024 768" "1440 900" "1920 1080")

for VP in "${VIEWPORTS[@]}"; do
  set -- $VP
  W=$1; H=$2
  echo ""
  echo "===== VIEWPORT ${W}x${H} ====="
  agent-browser set viewport $W $H >/dev/null 2>&1
  agent-browser wait 600 >/dev/null 2>&1
  for i in "${!VIEWS[@]}"; do
    NTH=$i
    J=$(echo "$CLICK_JS" | sed "s/NTH/$NTH/g")
    agent-browser eval "$J" >/dev/null 2>&1
    run_check "${VIEWS[$i]}"
  done
done

echo ""
echo "===== ADMIN PAGE ====="
agent-browser open http://localhost:3000/admin >/dev/null 2>&1
agent-browser wait 2000 >/dev/null 2>&1
for VP in "${VIEWPORTS[@]}"; do
  set -- $VP
  W=$1; H=$2
  agent-browser set viewport $W $H >/dev/null 2>&1
  run_check "admin-${W}"
done

echo ""
echo "===== HOME / WELCOME + NEW IDEA DIALOG (375) ====="
agent-browser open http://localhost:3000 >/dev/null 2>&1
agent-browser set viewport 375 667 >/dev/null 2>&1
agent-browser wait 1500 >/dev/null 2>&1
run_check "welcome-375"
agent-browser open http://localhost:3000 >/dev/null 2>&1
agent-browser wait 1200 >/dev/null 2>&1
run_check "welcome-390"
agent-browser open http://localhost:3000 >/dev/null 2>&1
agent-browser set viewport 768 1024 >/dev/null 2>&1
agent-browser wait 1200 >/dev/null 2>&1
run_check "welcome-768"

echo "DONE"
