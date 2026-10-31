#!/bin/bash
# UI E2E: Site Intelligence usable WITHOUT any idea (standalone mode)
cd /home/z/my-project
mkdir -p /tmp/ui-shots
rm -f dev.log
bun run dev > /dev/null 2>&1 &
SERVER_PID=$!
for i in $(seq 1 45); do
  CODE=$(curl -s -o /dev/null -w "%{http_code}" http://localhost:3000 --max-time 4 2>/dev/null || echo 000)
  [ "$CODE" = "200" ] && { echo "[server ready]"; break; }
  sleep 2
done
[ "$CODE" != "200" ] && { echo "[SERVER FAILED]"; exit 1; }

IDEA_ID=$(curl -s http://localhost:3000/api/ideas | python3 -c "import sys,json;d=json.load(sys.stdin);ideas=d.get('ideas',d) if isinstance(d,dict) else d;print(ideas[0]['id'] if ideas else '')")
echo "[first idea id: $IDEA_ID]"

echo "=================== 1) DESKTOP 1440 — welcome (no idea) ==================="
agent-browser set viewport 1440 900
agent-browser open http://localhost:3000
agent-browser wait --load networkidle
agent-browser screenshot /tmp/ui-shots/01-desktop-welcome.png

echo "--- header Site-study button state (should be visible+enabled, no idea) ---"
agent-browser eval "
(() => {
  const btns = [...document.querySelectorAll('header button')];
  const site = btns.find(b => (b.getAttribute('aria-label')||'').includes('تحليل موقع') || (b.getAttribute('aria-label')||'').includes('Site study'));
  const hero = [...document.querySelectorAll('main button, div button')].find(b => b.textContent.includes('استخبارات المواقع'));
  return JSON.stringify({
    headerSiteBtn: site ? {visible: site.offsetParent !== null, disabled: site.disabled, label: site.getAttribute('aria-label')} : null,
    heroSiteIntelBtn: hero ? {visible: hero.offsetParent !== null, text: hero.textContent.trim().slice(0,40)} : null,
    noIdeaSelected: !document.querySelector('nav[aria-label=\"Workflow stages\"]')
  });
})()"

echo "=================== 2) Open dialog from header — standalone notice ==================="
agent-browser find role button click --name "تحليل موقع" || agent-browser snapshot -i
agent-browser wait 800
agent-browser screenshot /tmp/ui-shots/02-standalone-dialog.png
agent-browser eval "
(() => {
  const dlg = document.querySelector('[role=dialog]');
  const notice = [...(dlg?.querySelectorAll('p')||[])].find(p => p.textContent.includes('أداة عامة'));
  const input = dlg?.querySelector('input');
  return JSON.stringify({ dialogOpen: !!dlg, standaloneNoticeShown: !!notice, urlInputPresent: !!input });
})()"

echo "=================== 3) Run study from UI without idea ==================="
agent-browser find role textbox fill "https://www.iana.org/help/example-domains" || true
agent-browser snapshot -i | rg -i "button" | head -12
agent-browser eval "
(() => {
  const dlg = document.querySelector('[role=dialog]');
  const input = dlg.querySelector('input');
  const set = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype,'value').set;
  set.call(input, 'https://www.iana.org/help/example-domains');
  input.dispatchEvent(new Event('input', {bubbles:true}));
  return 'filled';
})()"
agent-browser wait 400
agent-browser eval "
(() => {
  const dlg = document.querySelector('[role=dialog]');
  const btn = [...dlg.querySelectorAll('button')].find(b => b.textContent.includes('حلّل الموقع') || b.textContent.includes('Analyze'));
  return JSON.stringify({ analyzeBtnFound: !!btn, analyzeDisabled: btn?.disabled });
})()"
agent-browser find role button click --name "حلّل الموقع" || agent-browser eval "
(() => { const dlg=document.querySelector('[role=dialog]'); [...dlg.querySelectorAll('button')].find(b=>b.textContent.includes('حلّل')||b.textContent.includes('Analyze'))?.click(); return 'clicked'; })()"
sleep 12
agent-browser screenshot /tmp/ui-shots/03-analysis-running.png
agent-browser eval "
(() => {
  const dlg = document.querySelector('[role=dialog]');
  const txt = dlg?.textContent || '';
  return JSON.stringify({
    stepperOrResultVisible: /1|2|3/.test(txt),
    stillRunning: txt.includes('جارٍ') || txt.includes('working') || !!dlg.querySelector('.animate-spin'),
  });
})()"
agent-browser press Escape
agent-browser wait 600

echo "=================== 4) MOBILE 390 — tool strip enabled ==================="
agent-browser set viewport 390 844
agent-browser reload
agent-browser wait --load networkidle
agent-browser screenshot /tmp/ui-shots/04-mobile-welcome.png
agent-browser eval "
(() => {
  const strip = document.querySelector('div[role=toolbar]');
  const chips = [...strip.querySelectorAll('button')].map(b => ({label: b.textContent.trim(), disabled: b.disabled}));
  const overflow = document.documentElement.scrollWidth - document.documentElement.clientWidth;
  return JSON.stringify({ chips, horizontalOverflowPx: overflow }, null, 1);
})()"

echo "=================== 5) Idea scope isolation (API) ==================="
if [ -n "$IDEA_ID" ]; then
  curl -s "http://localhost:3000/api/ideas/$IDEA_ID/site-intel" | python3 -c "
import sys,json
d=json.load(sys.stdin)
doms=[a['domain'] for a in d.get('analyses',[])]
print('idea-scoped domains:', doms)
print('standalone leaked into idea scope:', any(x in doms for x in ['example.com','iana.org']))"
fi
curl -s "http://localhost:3000/api/site-intel" | python3 -c "
import sys,json
d=json.load(sys.stdin)
doms=[a['domain'] for a in d.get('analyses',[])]
print('standalone workspace domains:', doms)"

echo "=================== 6) With idea selected — Site study still in header ==================="
agent-browser set viewport 1440 900
agent-browser reload
agent-browser wait --load networkidle
agent-browser find text "AI Software Engineer" click || agent-browser snapshot -i
agent-browser wait 2500
agent-browser screenshot /tmp/ui-shots/05-idea-view.png
agent-browser eval "
(() => {
  const btns=[...document.querySelectorAll('header button')];
  const site=btns.find(b=>(b.getAttribute('aria-label')||'').includes('تحليل موقع'));
  const ideaOpen=!!document.querySelector('nav[aria-label=\"Workflow stages\"]');
  return JSON.stringify({ideaViewOpen:ideaOpen, headerSiteBtnVisible: site? site.offsetParent!==null : false});
})()"

echo "=================== done ==================="
agent-browser close
kill $SERVER_PID 2>/dev/null
ls -la /tmp/ui-shots/
