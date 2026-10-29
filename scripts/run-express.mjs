// Drive the express autopilot exactly like the UI does — loop until done/blocked.
const IDEA = 'cmvsk37i100bgv5rzd4x1btr4'
const BASE = 'http://localhost:3000'

let n = 0
for (;;) {
  const res = await fetch(`${BASE}/api/ideas/${IDEA}/express`, { method: 'POST' })
  const data = await res.json()
  if (!res.ok) {
    console.log(`ERROR: ${data.error}`)
    break
  }
  const ex = data.express
  if (ex.status === 'running') {
    console.log(`[${String(++n).padStart(2, '0')}] ${ex.step}`)
    console.log(`     next: ${ex.next ?? '-'}`)
    continue
  }
  if (ex.status === 'done') {
    console.log(`[${String(++n).padStart(2, '0')}] ${ex.step}`)
    console.log('\n=== DONE — final stage:', data.detail.idea.stage, '===')
    break
  }
  console.log(`\nBLOCKED: ${ex.reason}`)
  for (const b of ex.blockers ?? []) console.log(`  - ${b}`)
  console.log('current stage:', data.detail.idea.stage)
  break
}
