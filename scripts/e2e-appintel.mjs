// E2E driver — paste a mobile app URL, poll until the server-side autopilot
// finishes, print the final verdict. Mirrors exactly what the UI does.
const BASE = 'http://localhost:3000'
const input = process.argv[2]
const lang = process.argv[3] ?? 'ar'
const maxMs = Number(process.argv[4] ?? 20 * 60_000)

if (!input) {
  console.error('usage: bun run scripts/e2e-appintel.mjs <url-or-pkg> [lang] [maxMs]')
  process.exit(1)
}

const t0 = Date.now()
function elapsed() {
  return `${Math.round((Date.now() - t0) / 1000)}s`
}

// 1. start — exactly like the UI's start()
const res = await fetch(`${BASE}/api/app-intel`, {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({ input, lang }),
})
const created = (await res.json())
if (!res.ok || !created.analysis) {
  console.error('START FAILED', res.status, JSON.stringify(created).slice(0, 400))
  process.exit(2)
}
const id = created.analysis.id
console.log(`[${elapsed()}] STARTED ${created.analysis.pkg} id=${id} stage=${created.analysis.stageDone} score=${created.analysis.score}`)

// 2. poll — exactly like the UI's pollUntilDone()
let current = created.analysis
while (Date.now() - t0 < maxMs) {
  await new Promise((r) => setTimeout(r, 5000))
  try {
    const r = await fetch(`${BASE}/api/app-intel?analysisId=${id}`)
    const d = (await r.json())
    if (d.analysis) {
      const a = d.analysis
      if (a.stageDone !== current.stageDone || a.status !== current.status) {
        console.log(`[${elapsed()}] stage ${a.stageDone}/7 status=${a.status} score=${a.score}`)
      }
      current = a
    }
  } catch {
    /* transient — keep polling */
  }
  if (current.status !== 'running') break
}

// 3. verdict
console.log(`\n[${elapsed()}] FINAL: ${current.status} stage=${current.stageDone}/7 score=${current.score}`)
console.log(`evidence=${current.data.evidence?.length ?? 0} unknowns=${current.data.unknowns?.length ?? 0} pack=${current.data.pack?.length ?? 0}`)
if (current.data.unknowns?.length) console.log('unknowns:', current.data.unknowns.slice(0, 6).join(' | '))
if (current.error) console.log('error:', current.error)
const art = current.data.artifacts
if (art) console.log('artifacts:', JSON.stringify(art))
process.exit(current.status === 'complete' && current.stageDone === 7 ? 0 : 3)
