// E2E test: full engineering track with the real LLM
// Run: bun scripts/engineering-e2e.ts
const BASE = 'http://localhost:3000'

async function j(url: string, method = 'GET', body?: unknown) {
  const res = await fetch(BASE + url, {
    method,
    headers: body ? { 'Content-Type': 'application/json' } : undefined,
    body: body ? JSON.stringify(body) : undefined,
  })
  const data = await res.json()
  return { status: res.status, data }
}

function log(...args: unknown[]) {
  console.log(`[${new Date().toISOString().slice(11, 19)}]`, ...args)
}

async function main() {
  // 1. Find the demo idea (resumable across the whole engineering track)
  const { data: list } = await j('/api/ideas')
  const idea = list.ideas.find((i: { stage: string }) =>
    ['baseline', 'requirements', 'design', 'planning', 'readiness', 'package'].includes(i.stage)
  )
  if (!idea) {
    console.error('No idea in the engineering track found. Ideas:', list.ideas.map((i: { title: string; stage: string }) => `${i.title} (${i.stage})`))
    process.exit(1)
  }
  const stage = idea.stage as 'baseline' | 'requirements' | 'design' | 'planning' | 'readiness' | 'package'
  log(`Testing engineering track on: ${idea.title} (${idea.id}) — currently at: ${stage}`)

  // 2. Start engineering (skip if already started)
  if (stage === 'baseline') {
    let r = await j(`/api/ideas/${idea.id}/gate`, 'POST', { gate: 'engineering_start', action: 'approve' })
    if (r.status !== 200) throw new Error(`engineering_start failed: ${JSON.stringify(r.data)}`)
    log(`✓ Engineering started — stage: ${r.data.idea.stage}`)
  }

  // 3. Generate requirements (skip if already present)
  let detail = (await j(`/api/ideas/${idea.id}`)).data
  let r: { status: number; data: any }
  if (detail.requirements.length === 0 && detail.idea.stage === 'requirements') {
    r = await j(`/api/ideas/${idea.id}/requirements/generate`, 'POST')
    if (r.status !== 200) throw new Error(`requirements/generate failed: ${JSON.stringify(r.data).slice(0, 300)}`)
    detail = r.data as typeof detail
    log(`✓ Requirements generated: ${detail.requirements.length}`)
  }
  const d1 = detail
  log(`  Requirements: ${d1.requirements.length} (${d1.requirements.filter((x: { type: string }) => x.type === 'functional').length} FR, ${d1.requirements.filter((x: { type: string }) => x.type === 'non_functional').length} NFR), roles: ${d1.roles?.length}`)
  const sampleReq = d1.requirements.find((x: { provenance: string }) => x.provenance === 'client')
  log(`  sample client-provenance: ${sampleReq?.code} "${sampleReq?.title}" evidence="${sampleReq?.evidence?.slice(0, 80)}"`)
  const withCriteria = d1.requirements.filter((x: { acceptanceCriteria: string[] }) => x.acceptanceCriteria.length > 0).length
  log(`  acceptance criteria coverage: ${withCriteria}/${d1.requirements.length}`)

  // 4. Approve requirements (bulk-confirm unreviewed, keep unresolved as-is)
  if (d1.idea.stage === 'requirements' && d1.requirements.some((x: { status: string }) => x.status === 'proposed')) {
    const unreviewedReqs = d1.requirements.filter((x: { status: string }) => x.status === 'proposed').length
    r = await j(`/api/ideas/${idea.id}/gate`, 'POST', { gate: 'requirements', action: 'approve', unreviewedAction: 'accept' })
    if (r.status !== 200) throw new Error(`requirements gate failed (${unreviewedReqs} unreviewed): ${JSON.stringify(r.data).slice(0, 300)}`)
    log(`✓ Requirements approved (bulk-confirmed ${unreviewedReqs}) — stage: ${r.data.idea.stage}`)
    log(`  confirmed: ${r.data.requirements.filter((x) => x.status === 'confirmed').length}, unresolved: ${r.data.requirements.filter((x) => x.status === 'unresolved').length}`)
  } else {
    log(`  requirements gate already passed`)
  }

  // 5. Design engines — generate each kind, then confirm it before the next
  //    (APIs derive from CONFIRMED entities — the approval discipline is real)
  async function confirmAllOf(kind: string, items: Array<{ id: string }>) {
    for (const item of items) {
      const cr = await j(`/api/artifacts/${kind}/${item.id}`, 'PATCH', { status: 'confirmed' })
      if (cr.status !== 200) throw new Error(`confirm ${kind} failed: ${JSON.stringify(cr.data).slice(0, 200)}`)
    }
  }

  const gen = async (kind: 'processes' | 'entities' | 'apis' | 'screens' | 'architecture') => {
    r = await j(`/api/ideas/${idea.id}/design/generate`, 'POST', { kind })
    if (r.status !== 200) throw new Error(`design/${kind} failed: ${JSON.stringify(r.data).slice(0, 300)}`)
    return r.data
  }

  let d: any = {}
  if (detail.idea.stage === 'design' && detail.apis.length === 0) {
    d = await gen('processes')
    log(`✓ design/processes: ${d.processes.length}`)
    await confirmAllOf('process', d.processes)

    d = await gen('entities')
    log(`✓ design/entities: ${d.entities.length}`)
    await confirmAllOf('entity', d.entities)

    d = await gen('apis')
    log(`✓ design/apis: ${d.apis.length}`)
    await confirmAllOf('api', d.apis)

    d = await gen('screens')
    log(`✓ design/screens: ${d.screens.length}`)
    await confirmAllOf('screen', d.screens)

    d = await gen('architecture')
    log(`✓ design/architecture: ${d.architecture ? 'generated' : 'MISSING'}`)
    if (d.architecture) {
      const ar = await j(`/api/artifacts/architecture/${d.architecture.id}`, 'PATCH', { status: 'confirmed' })
      if (ar.status !== 200) throw new Error(`confirm architecture failed: ${JSON.stringify(ar.data).slice(0, 200)}`)
    }
  } else if (detail.idea.stage === 'design') {
    // resume: confirm any leftover unreviewed design artifacts
    const c = detail
    await confirmAllOf('process', c.processes.filter((x: { status: string }) => x.status !== 'confirmed' && x.status !== 'rejected'))
    await confirmAllOf('entity', c.entities.filter((x: { status: string }) => x.status !== 'confirmed' && x.status !== 'rejected'))
    await confirmAllOf('api', c.apis.filter((x: { status: string }) => x.status !== 'confirmed' && x.status !== 'rejected'))
    await confirmAllOf('screen', c.screens.filter((x: { status: string }) => x.status !== 'confirmed' && x.status !== 'rejected'))
    if (c.architecture && c.architecture.status === 'proposed') {
      const ar = await j(`/api/artifacts/architecture/${c.architecture.id}`, 'PATCH', { status: 'confirmed' })
      if (ar.status !== 200) throw new Error(`confirm architecture failed: ${JSON.stringify(ar.data).slice(0, 200)}`)
    }
    log(`✓ design artifacts resumed & confirmed`)
  }

  // 6. Linkage sanity check
  let current = (await j(`/api/ideas/${idea.id}`)).data
  const linkedProcesses = current.processes.filter((p: { linkedRequirements: string[] }) => p.linkedRequirements.length > 0).length
  const linkedApis = current.apis.filter((a: { linkedRequirements: string[] }) => a.linkedRequirements.length > 0).length
  const linkedScreens = current.screens.filter((s: { linkedRequirements: string[] }) => s.linkedRequirements.length > 0).length
  log(`  linkage: ${linkedProcesses}/${current.processes.length} processes, ${linkedApis}/${current.apis.length} apis, ${linkedScreens}/${current.screens.length} screens linked to requirements`)

  // 7. Design gate
  if (detail.idea.stage === 'design') {
    r = await j(`/api/ideas/${idea.id}/gate`, 'POST', { gate: 'design', action: 'approve' })
    if (r.status !== 200) throw new Error(`design gate failed: ${JSON.stringify(r.data).slice(0, 300)}`)
    log(`✓ Design approved — stage: ${r.data.idea.stage}`)
  } else {
    log(`  design gate already passed`)
  }

  // 8. Planning: tasks + risks
  detail = (await j(`/api/ideas/${idea.id}`)).data
  if (detail.idea.stage === 'planning' && detail.tasks.length === 0) {
    r = await j(`/api/ideas/${idea.id}/plan/generate`, 'POST', { kind: 'tasks' })
    if (r.status !== 200) throw new Error(`plan/tasks failed: ${JSON.stringify(r.data).slice(0, 300)}`)
    log(`✓ Tasks: ${r.data.tasks.length} across phases ${[...new Set(r.data.tasks.map((t: { phase: number }) => t.phase))].join(',')}`)
    const withDeps = r.data.tasks.filter((t: { dependsOn: string[] }) => t.dependsOn.length > 0).length
    const withReqLinks = r.data.tasks.filter((t: { requirementCodes: string[] }) => t.requirementCodes.length > 0).length
    log(`  ${withDeps}/${r.data.tasks.length} have dependencies, ${withReqLinks}/${r.data.tasks.length} trace to requirements`)
  }

  detail = (await j(`/api/ideas/${idea.id}`)).data
  if (detail.idea.stage === 'planning' && detail.risks.length === 0) {
    r = await j(`/api/ideas/${idea.id}/plan/generate`, 'POST', { kind: 'risks' })
    if (r.status !== 200) throw new Error(`plan/risks failed: ${JSON.stringify(r.data).slice(0, 300)}`)
    log(`✓ Risks: ${r.data.risks.length} (${[...new Set(r.data.risks.map((x: { category: string }) => x.category))].join(', ')})`)
  }

  // 9. Review all tasks + risks + planning gate
  detail = (await j(`/api/ideas/${idea.id}`)).data
  if (detail.idea.stage === 'planning') {
    for (const t of detail.tasks) {
      if (t.status === 'proposed' || t.status === 'needs_revision') {
        r = await j(`/api/artifacts/task/${t.id}`, 'PATCH', { status: 'confirmed' })
        if (r.status !== 200) throw new Error(`confirm task failed: ${JSON.stringify(r.data).slice(0, 200)}`)
      }
    }
    for (const rk of detail.risks) {
      if (rk.status === 'proposed') {
        r = await j(`/api/artifacts/risk/${rk.id}`, 'PATCH', { status: 'mitigated' })
        if (r.status !== 200) throw new Error(`confirm risk failed: ${JSON.stringify(r.data).slice(0, 200)}`)
      }
    }
    log(`✓ Confirmed ${detail.tasks.length} tasks + ${detail.risks.length} risks`)

    r = await j(`/api/ideas/${idea.id}/gate`, 'POST', { gate: 'planning', action: 'approve' })
    if (r.status !== 200) throw new Error(`planning gate failed: ${JSON.stringify(r.data).slice(0, 300)}`)
    log(`✓ Planning approved — stage: ${r.data.idea.stage}`)
  } else {
    log(`  planning gate already passed`)
  }

  // 10. Consistency check
  detail = (await j(`/api/ideas/${idea.id}`)).data
  if (['planning', 'readiness'].includes(detail.idea.stage)) {
    r = await j(`/api/ideas/${idea.id}/consistency`, 'POST')
    if (r.status !== 200) throw new Error(`consistency failed: ${JSON.stringify(r.data).slice(0, 300)}`)
    const issues = r.data.issues.filter((i: { status: string }) => i.status === 'open')
    log(`✓ Consistency check: ${issues.length} open issues (${issues.filter((i: { severity: string }) => i.severity === 'critical').length} critical, ${issues.filter((i: { severity: string }) => i.severity === 'major').length} major)`)
    for (const i of issues.slice(0, 8)) log(`   [${i.severity}/${i.kind}] ${i.description.slice(0, 110)}`)

    // Resolve/dismiss open issues (simulating the client working the list)
    for (const i of issues) {
      r = await j(`/api/artifacts/issue/${i.id}`, 'PATCH', { status: i.severity === 'minor' ? 'dismissed' : 'resolved' })
      if (r.status !== 200) throw new Error(`resolve issue failed: ${JSON.stringify(r.data).slice(0, 200)}`)
    }
    if (issues.length) log(`✓ Worked through ${issues.length} issues`)
  }

  // 11. Readiness report
  current = (await j(`/api/ideas/${idea.id}`)).data
  const readiness = current.readiness
  log(`Readiness: score=${readiness.score}% lockable=${readiness.lockable}`)
  for (const m of readiness.metrics.filter((m2: { pass: boolean }) => !m2.pass)) {
    log(`  ✗ [${m.blocker ? 'BLOCKER' : 'warn'}] ${m.label}: ${m.detail}`)
  }

  // 12. Attempt package lock (may legitimately fail if blockers remain)
  if (current.idea.stage !== 'package') {
    if (!current.readiness.lockable) {
      log(`✗ Package NOT lockable — blockers remain (this is the honest gate working):`)
      for (const b of current.readiness.blockers) log(`   - ${b}`)
      log('  (For the E2E test, exiting here — lock requires real coverage fixes.)')
      return
    }
    r = await j(`/api/ideas/${idea.id}/gate`, 'POST', { gate: 'package', action: 'approve' })
    if (r.status !== 200) throw new Error(`package lock failed: ${JSON.stringify(r.data).slice(0, 400)}`)
    log(`✓ PACKAGE LOCKED — stage: ${r.data.idea.stage}, score ${r.data.readiness.score}%`)
  } else {
    log(`  package already locked`)
  }

  // 13. Export both formats
  const mdRes = await fetch(`${BASE}/api/ideas/${idea.id}/package/export?format=md`)
  const md = await mdRes.text()
  const jsonRes = await fetch(`${BASE}/api/ideas/${idea.id}/package/export?format=json`)
  const pkg = await jsonRes.json()
  log(`✓ Export MD: ${md.length} chars, sections: ${['01 — Product Definition', '02 — Functional Analysis', '03 — Data & API Design', '04 — UI/UX Specification', '05 — Quality & Operations', '06 — Implementation Plan', 'Appendix A', 'Appendix B', 'Appendix C'].filter((s) => md.includes(s)).length}/9`)
  log(`  mermaid ERD present: ${md.includes('erDiagram')}, traceability rows: ${pkg.traceability?.length}`)
  log(`✓ Export JSON: ${JSON.stringify(pkg).length} chars`)

  // 14. Change impact preview (read-only demo)
  const firstConfirmed = current.requirements.find((x: { status: string; type: string }) => x.status === 'confirmed' && x.type === 'functional')
  r = await j(`/api/ideas/${idea.id}/impact`, 'POST', { requirementId: firstConfirmed.id, change: 'hypothetical change' })
  log(`✓ Impact preview for ${firstConfirmed.code}: ${r.data.affected?.length ?? 0} affected artifacts`)

  log('\nALL E2E STEPS PASSED')
}

main().catch((e) => {
  console.error('E2E FAILED:', e.message)
  process.exit(1)
})
