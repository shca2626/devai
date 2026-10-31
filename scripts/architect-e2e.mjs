// Architect Lab E2E — runs against a live dev server on :3000
// Usage: bun scripts/architect-e2e.mjs
const BASE = 'http://localhost:3000'
let failures = 0

function check(name, cond, extra = '') {
  if (cond) {
    console.log(`  ✅ ${name}${extra ? ' — ' + extra : ''}`)
  } else {
    failures++
    console.log(`  ❌ ${name}${extra ? ' — ' + extra : ''}`)
  }
}

async function post(path, body) {
  const res = await fetch(BASE + path, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(body),
  })
  return { status: res.status, data: await res.json().catch(() => ({})) }
}

async function patch(path, body) {
  const res = await fetch(BASE + path, {
    method: 'PATCH',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(body),
  })
  return { status: res.status, data: await res.json().catch(() => ({})) }
}

async function get(path) {
  const res = await fetch(BASE + path)
  return { status: res.status, data: await res.json().catch(() => null) }
}

// ---------- find the test idea ----------
const list = await get('/api/ideas')
const solar = list.data.ideas.find((i) => i.title === 'Solar Clone Platform')
if (!solar) {
  console.log('❌ Test idea "Solar Clone Platform" not found')
  process.exit(1)
}
const ID = solar.id
console.log(`\n== Idea: ${solar.title} (${ID}) — stage: ${solar.stage} ==`)

// ---------- detail includes new fields ----------
const detail0 = await get(`/api/ideas/${ID}`)
check('GET /api/ideas/[id] ok', detail0.status === 200)
check('detail has tradeStudy field', 'tradeStudy' in detail0.data)
check('detail has adrs field', 'adrs' in detail0.data)
check('detail has threatModel field', 'threatModel' in detail0.data)
check('detail has scaleReport field', 'scaleReport' in detail0.data)

// ---------- 1. trade-off study ----------
console.log('\n== 1. Trade-off study ==')
const t0 = Date.now()
const trade = await post(`/api/ideas/${ID}/architect/generate`, { kind: 'tradeoffs' })
check('generate tradeoffs 200', trade.status === 200, `${((Date.now() - t0) / 1000).toFixed(1)}s`)
const ts = trade.data.tradeStudy
check('tradeStudy present', !!ts)
check('3 candidates', ts?.candidates?.length === 3, `got ${ts?.candidates?.length}`)
check('recommended matches a candidate', !!ts?.candidates?.some((c) => c.name === ts?.recommended), ts?.recommended)
check('candidates have pros+cons', ts?.candidates?.every((c) => Array.isArray(c.pros) && c.pros.length > 0 && Array.isArray(c.cons) && c.cons.length > 0))
check('status proposed', ts?.status === 'proposed')

// ---------- 2. ADRs ----------
console.log('\n== 2. ADRs ==')
const t1 = Date.now()
const adrRes = await post(`/api/ideas/${ID}/architect/generate`, { kind: 'adrs' })
check('generate adrs 200', adrRes.status === 200, `${((Date.now() - t1) / 1000).toFixed(1)}s`)
const adrs = adrRes.data.adrs
check('ADRs generated', Array.isArray(adrs) && adrs.length >= 3, `got ${adrs?.length}`)
check('ADR codes ADR-01..', adrs?.[0]?.code === 'ADR-01')
check('ADRs have context+decision+consequences', adrs?.every((a) => a.context && a.decision && a.consequences))

// ---------- 3. STRIDE threat model ----------
console.log('\n== 3. STRIDE threat model ==')
const t2 = Date.now()
const thr = await post(`/api/ideas/${ID}/architect/generate`, { kind: 'threats' })
check('generate threats 200', thr.status === 200, `${((Date.now() - t2) / 1000).toFixed(1)}s`)
const tm = thr.data.threatModel
check('threatModel present', !!tm)
const cats = new Set(tm?.findings?.map((f) => f.category))
check('4+ findings', (tm?.findings?.length ?? 0) >= 4, `got ${tm?.findings?.length}`)
check('4+ distinct STRIDE categories', cats.size >= 4, [...cats].join(', '))

// ---------- 4. scale simulation ----------
console.log('\n== 4. Scale simulation ==')
const t3 = Date.now()
const sc = await post(`/api/ideas/${ID}/architect/generate`, { kind: 'scale' })
check('generate scale 200', sc.status === 200, `${((Date.now() - t3) / 1000).toFixed(1)}s`)
const sr = sc.data.scaleReport
check('scaleReport present', !!sr)
check('bottlenecks 3+', (sr?.bottlenecks?.length ?? 0) >= 3, `got ${sr?.bottlenecks?.length}`)
check('2 scenarios (10x/100x)', (sr?.scenarios?.length ?? 0) === 2, sr?.scenarios?.map((s) => s.label).join(' | '))

// ---------- 5. review flow ----------
console.log('\n== 5. Review & promote ==')
const rev = await patch(`/api/artifacts/tradeStudy/${ts.id}`, { status: 'confirmed' })
check('tradeStudy confirmed', rev.status === 200 && rev.data.tradeStudy?.status === 'confirmed')
const adr1 = adrs[0]
const revAdr = await patch(`/api/artifacts/adr/${adr1.id}`, { status: 'confirmed' })
check('ADR-01 confirmed', revAdr.status === 200 && revAdr.data.adrs?.some((a) => a.id === adr1.id && a.status === 'confirmed'))
const decBefore = await get(`/api/ideas/${ID}/decisions`)
const promote = await post(`/api/ideas/${ID}/decisions`, {
  title: adr1.title,
  choice: adr1.decision,
  rationale: adr1.context,
  category: 'architecture',
})
check('ADR promoted to standing decision', promote.status === 200)
const decAfter = await get(`/api/ideas/${ID}/decisions`)
check('decision appears in log', (decAfter.data?.decisions?.length ?? 0) > (decBefore.data?.decisions?.length ?? 0))

// ---------- 6. package export ----------
console.log('\n== 6. Package export ==')
const mdRes = await fetch(`${BASE}/api/ideas/${ID}/package/export?format=md`)
const md = await mdRes.text()
check('export 200', mdRes.status === 200, `${(md.length / 1024).toFixed(1)}KB`)
check('export contains trade-off study', md.includes('Architecture trade-off study'))
check('export contains ADRs', md.includes('Architecture decision records'))
check('export contains STRIDE', md.includes('STRIDE threat model'))
check('export contains scale section', md.includes('Scale simulation'))

// ---------- 7. admin ----------
console.log('\n== 7. Admin ==')
const ov = await get('/api/admin/overview')
check('overview 200', ov.status === 200)
check('28 models', ov.data?.database?.models === 28, `got ${ov.data?.database?.models}`)
check('ArchTradeStudy counted', typeof ov.data?.counts?.ArchTradeStudy === 'number')
check('ArchDecisionRecord counted', typeof ov.data?.counts?.ArchDecisionRecord === 'number')
check('ThreatModelDoc counted', typeof ov.data?.counts?.ThreatModelDoc === 'number')
check('ScaleReport counted', typeof ov.data?.counts?.ScaleReport === 'number')
const tbl = await get('/api/admin/table/ArchTradeStudy?pageSize=5')
check('admin table browser sees ArchTradeStudy', tbl.status === 200)

console.log(`\n${failures === 0 ? '🎉 ALL CHECKS PASSED' : `⚠️  ${failures} CHECK(S) FAILED`}`)
process.exit(failures === 0 ? 0 : 1)
