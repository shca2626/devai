// QA Lab E2E — runs against a live dev server on :3000
// Usage: bun scripts/qa-lab-e2e.mjs
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

// ---------- find a test idea with confirmed requirements ----------
const list = await get('/api/ideas')
if (!list.data?.ideas?.length) {
  console.log('❌ No ideas in the database — create one first')
  process.exit(1)
}
let target = null
let detail = null
for (const idea of list.data.ideas) {
  const d = await get(`/api/ideas/${idea.id}`)
  const confirmed = d.data?.requirements?.filter((r) => r.status === 'confirmed') ?? []
  if (confirmed.length >= 2) {
    target = idea
    detail = d.data
    break
  }
}
if (!target) {
  console.log('❌ No idea with 2+ confirmed requirements — run scripts/architect-e2e.mjs setup or the express flow first')
  process.exit(1)
}
const ID = target.id
const confirmedReqs = detail.requirements.filter((r) => r.status === 'confirmed')
console.log(`\n== Idea: ${target.title} (${ID}) — stage: ${target.stage}, confirmed reqs: ${confirmedReqs.length} ==`)

// ---------- detail includes new fields ----------
const detail0 = await get(`/api/ideas/${ID}`)
check('GET /api/ideas/[id] ok', detail0.status === 200)
check('detail has testCases field', 'testCases' in detail0.data)
check('detail has testCoverage field', 'testCoverage' in detail0.data)
check('detail has edgeCases field', 'edgeCases' in detail0.data)
check('detail has e2eScenarios field', 'e2eScenarios' in detail0.data)

// ---------- 1. test suite ----------
console.log('\n== 1. Test suite ==')
const t0 = Date.now()
const suite = await post(`/api/ideas/${ID}/qa/generate`, { kind: 'suite' })
check('generate suite 200', suite.status === 200, `${((Date.now() - t0) / 1000).toFixed(1)}s`)
const cases = suite.data.testCases
check('cases generated', Array.isArray(cases) && cases.length >= 6, `got ${cases?.length}`)
check('codes TC-01..', cases?.[0]?.code === 'TC-01')
check('every case links a confirmed requirement', cases?.every((c) => confirmedReqs.some((r) => r.code === c.linkedRequirement)))
check('levels valid', cases?.every((c) => c.level === 'unit' || c.level === 'integration'))
check('kinds valid', cases?.every((c) => ['happy', 'negative', 'boundary', 'security'].includes(c.kind)))
check('cases have steps + expected', cases?.every((c) => c.steps?.length > 0 && c.expected?.length > 3))
const kinds = new Set(cases?.map((c) => c.kind))
check('2+ distinct kinds (not only happy path)', kinds.size >= 2, [...kinds].join(', '))

// ---------- 2. coverage is app-computed ----------
console.log('\n== 2. Coverage (deterministic) ==')
const cov = suite.data.testCoverage
check('coverage doc present', !!cov)
check('score is a number 0-100', typeof cov?.score === 'number' && cov.score >= 0 && cov.score <= 100, `score: ${cov?.score}`)
const criteriaTotal = confirmedReqs.reduce((n, r) => n + (r.acceptanceCriteria?.length ?? 0), 0)
if (criteriaTotal > 0) {
  // recompute independently and compare — the score must match exactly
  const caseRows = cases.filter((c) => c.status !== 'rejected')
  let coveredCount = 0
  for (const r of confirmedReqs) {
    const hits = new Set(
      caseRows.filter((c) => c.linkedRequirement === r.code && c.linkedCriterion >= 1 && c.linkedCriterion <= r.acceptanceCriteria.length).map((c) => c.linkedCriterion)
    )
    coveredCount += hits.size
  }
  const expectedScore = Math.round((coveredCount / criteriaTotal) * 100)
  check('score matches independent recomputation', cov.score === expectedScore, `app: ${cov.score}, recomputed: ${expectedScore}`)
  check('covered rows reference real requirements', cov.covered.every((row) => confirmedReqs.some((r) => r.code === row.requirement)))
}
check('coverage status proposed', cov?.status === 'proposed')

// ---------- 3. edge cases ----------
console.log('\n== 3. Edge cases ==')
const t2 = Date.now()
const edge = await post(`/api/ideas/${ID}/qa/generate`, { kind: 'edge' })
check('generate edge 200', edge.status === 200, `${((Date.now() - t2) / 1000).toFixed(1)}s`)
const ec = edge.data.edgeCases
check('edgeCases present', !!ec)
check('3+ groups', (ec?.groups?.length ?? 0) >= 3, `got ${ec?.groups?.length}`)
const allCases = ec?.groups?.flatMap((g) => g.cases) ?? []
check('every case has scenario + howToTest', allCases.every((c) => c.scenario && c.howToTest))
check('risks valid', allCases.every((c) => ['low', 'medium', 'high'].includes(c.risk)))
check('linked requirements valid only', allCases.every((c) => !c.linkedRequirement || confirmedReqs.some((r) => r.code === c.linkedRequirement)))
const categories = new Set(allCases.map((c) => c.category))
check('3+ distinct categories', categories.size >= 3, [...categories].join(', '))

// ---------- 4. E2E scenarios ----------
console.log('\n== 4. E2E scenarios ==')
const t3 = Date.now()
const e2e = await post(`/api/ideas/${ID}/qa/generate`, { kind: 'e2e' })
check('generate e2e 200', e2e.status === 200, `${((Date.now() - t3) / 1000).toFixed(1)}s`)
const scenarios = e2e.data.e2eScenarios
check('scenarios generated', Array.isArray(scenarios) && scenarios.length >= 3, `got ${scenarios?.length}`)
check('codes E2E-01..', scenarios?.[0]?.code === 'E2E-01')
check('every scenario has when + then', scenarios?.every((s) => s.when?.length > 0 && s.then?.length > 0))
check('smoke first if present', !scenarios?.some((s) => s.priority === 'smoke') || scenarios[0].priority === 'smoke')
check('linked requirements valid only', scenarios?.every((s) => s.linkedRequirements.every((c) => confirmedReqs.some((r) => r.code === c))))

// ---------- 5. review flow ----------
console.log('\n== 5. Review flow ==')
const tc1 = cases[0]
const revTc = await patch(`/api/artifacts/testCase/${tc1.id}`, { status: 'confirmed' })
check('TC-01 confirmed', revTc.status === 200 && revTc.data.testCases?.some((c) => c.id === tc1.id && c.status === 'confirmed'))
const revCov = await patch(`/api/artifacts/testCoverage/${cov.id}`, { status: 'confirmed' })
check('coverage confirmed', revCov.status === 200 && revCov.data.testCoverage?.status === 'confirmed')
const s1 = scenarios[0]
const revE2e = await patch(`/api/artifacts/e2eScenario/${s1.id}`, { status: 'confirmed' })
check('E2E-01 confirmed', revE2e.status === 200 && revE2e.data.e2eScenarios?.some((x) => x.id === s1.id && x.status === 'confirmed'))
const revEdge = await patch(`/api/artifacts/edgeCase/${ec.id}`, { status: 'confirmed' })
check('edgeCases confirmed', revEdge.status === 200 && revEdge.data.edgeCases?.status === 'confirmed')

// ---------- 6. regeneration keeps confirmed ----------
console.log('\n== 6. Regeneration keeps confirmed cases ==')
const suite2 = await post(`/api/ideas/${ID}/qa/generate`, { kind: 'suite' })
check('regenerate suite 200', suite2.status === 200)
const cases2 = suite2.data.testCases
check('confirmed TC kept after regeneration', cases2.some((c) => c.id === tc1.id && c.status === 'confirmed'))
check('new proposed cases added', cases2.filter((c) => c.status === 'proposed').length > 0)
check('coverage recomputed', typeof suite2.data.testCoverage?.score === 'number', `score: ${suite2.data.testCoverage?.score}`)
const codes2 = cases2.map((c) => c.code)
check('all TC codes unique after regeneration', new Set(codes2).size === codes2.length, codes2.slice(0, 5).join(',') + '…')

// ---------- 7. decision log ----------
console.log('\n== 7. Decision log ==')
const d = await get(`/api/ideas/${ID}`)
const logged = d.data?.decisions?.filter((x) => x.action.includes('Test suite') || x.action.includes('E2E') || x.action.includes('Edge case'))
check('QA decisions logged', (logged?.length ?? 0) >= 3, `${logged?.length} QA entries`)

// ---------- 8. package export ----------
console.log('\n== 8. Package export ==')
const mdRes = await fetch(`${BASE}/api/ideas/${ID}/package/export?format=md`)
const md = await mdRes.text()
check('export 200', mdRes.status === 200, `${(md.length / 1024).toFixed(1)}KB`)
check('export contains test suite', md.includes('Test suite'))
check('export contains E2E scenarios', md.includes('E2E scenarios'))
const jsonRes = await fetch(`${BASE}/api/ideas/${ID}/package/export?format=json`)
const json = await jsonRes.json()
check('json export has qaLab', !!json.qualityAndOperations?.qaLab)
check('json qaLab has confirmed cases', (json.qualityAndOperations?.qaLab?.testCases?.length ?? 0) >= 1)

// ---------- 9. admin ----------
console.log('\n== 9. Admin ==')
const ov = await get('/api/admin/overview')
check('overview 200', ov.status === 200)
check('28 models', ov.data?.database?.models === 28, `got ${ov.data?.database?.models}`)
check('TestCaseRecord counted', typeof ov.data?.counts?.TestCaseRecord === 'number')
check('TestCoverageDoc counted', typeof ov.data?.counts?.TestCoverageDoc === 'number')
check('EdgeCaseDoc counted', typeof ov.data?.counts?.EdgeCaseDoc === 'number')
check('E2eScenarioRecord counted', typeof ov.data?.counts?.E2eScenarioRecord === 'number')
for (const m of ['TestCaseRecord', 'TestCoverageDoc', 'EdgeCaseDoc', 'E2eScenarioRecord']) {
  const tbl = await get(`/api/admin/table/${m}?pageSize=5`)
  check(`admin table browser sees ${m}`, tbl.status === 200)
}

console.log(`\n${failures === 0 ? '🎉 ALL CHECKS PASSED' : `⚠️  ${failures} CHECK(S) FAILED`}`)
process.exit(failures === 0 ? 0 : 1)
