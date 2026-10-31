import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision } from '@/lib/payload'
import { buildProjectContext } from '@/lib/engines/context'
import {
  generateTestSuite,
  generateEdgeCases,
  generateE2eScenarios,
} from '@/lib/engines/qa'
import type { CoverageGap, CoverageRow, Feature, Requirement } from '@/lib/types'

// ============================================================
// QA Lab engines — test suite (from requirements + acceptance
// criteria), edge case brainstorm, E2E scenarios. NO LIMITS:
// every kind can be generated from ANY stage, any number of
// times — regeneration keeps CONFIRMED cases and replaces the
// rest. The coverage score is computed HERE, deterministically
// from the cases actually stored — never trusted to the model.
// Rejected cases/scenarios are passed back to the engine so it
// never repeats them; client feedback MUST be addressed.
// ============================================================

type Params = { params: Promise<{ id: string }> }

const KINDS = ['suite', 'edge', 'e2e'] as const
type Kind = (typeof KINDS)[number]

async function getRequirements(ideaId: string): Promise<Requirement[]> {
  const rows = await db.requirement.findMany({ where: { ideaId }, orderBy: [{ order: 'asc' }] })
  return rows.map((r) => ({
    id: r.id,
    code: r.code,
    type: r.type === 'non_functional' ? 'non_functional' : 'functional',
    category: r.category,
    title: r.title,
    titleAr: r.titleAr,
    description: r.description,
    acceptanceCriteria: safeArr(r.acceptanceCriteria),
    provenance: r.provenance === 'client' ? 'client' : 'ai',
    evidence: r.evidence,
    featureId: r.featureId,
    priority: r.priority as Requirement['priority'],
    status: r.status as Requirement['status'],
    order: r.order,
  }))
}

function safeArr(raw: string | null): string[] {
  try {
    const v = raw ? JSON.parse(raw) : []
    return Array.isArray(v) ? v : []
  } catch {
    return []
  }
}

// ------------------------------------------------------------
// Deterministic coverage — the app computes which acceptance
// criteria of which confirmed requirements are actually
// covered by stored (non-rejected) cases. The model never
// touches this number.
// ------------------------------------------------------------
async function recomputeCoverage(ideaId: string, requirements: Requirement[]) {
  const cases = await db.testCaseRecord.findMany({
    where: { ideaId, status: { not: 'rejected' } },
    select: { code: true, linkedRequirement: true, linkedCriterion: true },
  })

  const confirmed = requirements.filter((r) => r.status === 'confirmed')
  const covered: CoverageRow[] = []
  const uncovered: CoverageGap[] = []
  let criteriaTotal = 0
  let criteriaCovered = 0

  for (const r of confirmed) {
    const total = r.acceptanceCriteria.length
    const linked = cases.filter((c) => c.linkedRequirement === r.code)
    if (total > 0) {
      const hitIndices = new Set(
        linked.filter((c) => c.linkedCriterion && c.linkedCriterion >= 1 && c.linkedCriterion <= total).map((c) => c.linkedCriterion)
      )
      criteriaTotal += total
      criteriaCovered += hitIndices.size
      covered.push({
        requirement: r.code,
        criteriaTotal: total,
        criteriaCovered: hitIndices.size,
        caseCodes: linked.map((c) => c.code),
      })
      if (hitIndices.size === 0) {
        uncovered.push({
          requirement: r.code,
          reason: `none of its ${total} acceptance ${total === 1 ? 'criterion is' : 'criteria are'} targeted by a case`,
        })
      } else if (hitIndices.size < total) {
        const missing: number[] = []
        for (let i = 1; i <= total; i++) if (!hitIndices.has(i)) missing.push(i)
        uncovered.push({
          requirement: r.code,
          reason: `criterion ${missing.map((i) => `#${i}`).join(', ')} of ${total} not yet targeted`,
        })
      }
    } else {
      // Requirement without acceptance criteria — coverage = has any case at all
      covered.push({ requirement: r.code, criteriaTotal: 0, criteriaCovered: linked.length > 0 ? 1 : 0, caseCodes: linked.map((c) => c.code) })
      if (linked.length === 0) uncovered.push({ requirement: r.code, reason: 'no test case references it (and it has no acceptance criteria to target)' })
    }
  }

  let score = 0
  if (criteriaTotal > 0) {
    score = Math.round((criteriaCovered / criteriaTotal) * 100)
  } else if (covered.length > 0) {
    const hit = covered.filter((c) => c.criteriaCovered > 0).length
    score = Math.round((hit / covered.length) * 100)
  }

  const data = {
    covered: JSON.stringify(covered),
    uncovered: JSON.stringify(uncovered),
    score,
    note:
      criteriaTotal > 0
        ? `${criteriaCovered}/${criteriaTotal} acceptance criteria of confirmed requirements are targeted by non-rejected cases.`
        : confirmed.length > 0
          ? 'No acceptance criteria exist yet — coverage counts requirements with at least one case.'
          : 'No confirmed requirements yet — nothing to cover.',
    status: 'proposed',
  }

  const existing = await db.testCoverageDoc.findUnique({ where: { ideaId } })
  if (existing) {
    await db.testCoverageDoc.update({ where: { ideaId }, data })
  } else {
    await db.testCoverageDoc.create({ data: { ideaId, ...data } })
  }
  return { covered, uncovered, score }
}

export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json().catch(() => ({}))) as { kind?: string; feedback?: string }
    const kind = KINDS.find((k) => k === body.kind)
    if (!kind) {
      return NextResponse.json({ error: 'Unknown QA kind.' }, { status: 400 })
    }
    // Optional client feedback steering the regeneration
    const feedback = typeof body.feedback === 'string' ? body.feedback.trim() : ''

    const idea = await db.idea.findUnique({ where: { id } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }

    const ctx = await buildProjectContext(id)
    if (!ctx) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }

    const requirements = await getRequirements(id)
    let count = 0

    if (kind === 'suite') {
      // Regeneration keeps CONFIRMED cases; proposed/rejected are replaced
      const existing = await db.testCoverageDoc.findUnique({ where: { ideaId: id } })
      if (existing?.status === 'confirmed') {
        await logDecision(id, 'Test suite regenerated', 'Previously confirmed coverage — regeneration forced in no-limits mode', 'readiness')
      }
      const rejectedRows = await db.testCaseRecord.findMany({
        where: { ideaId: id, status: 'rejected' },
        select: { title: true },
      })
      // Focus the engine on the current gaps (from existing coverage)
      let focusGaps: Array<{ requirement: string; reason: string }> | undefined
      if (existing) {
        try {
          const parsed = JSON.parse(existing.uncovered)
          if (Array.isArray(parsed) && parsed.length) focusGaps = parsed.slice(0, 12)
        } catch {
          focusGaps = undefined
        }
      }
      const drafts = await generateTestSuite({
        ctx,
        requirements,
        focusGaps,
        rejectedTitles: rejectedRows.map((r) => r.title),
        feedback,
      })
      if (drafts.length === 0) throw new Error('No test cases returned')
      await db.testCaseRecord.deleteMany({ where: { ideaId: id, status: { in: ['proposed', 'rejected'] } } })
      const keptCases = await db.testCaseRecord.findMany({ where: { ideaId: id }, select: { code: true } })
      let maxCode = 0
      for (const row of keptCases) {
        const n = parseInt(row.code.replace(/^TC-/, ''), 10)
        if (Number.isInteger(n) && n > maxCode) maxCode = n
      }
      let order = keptCases.length
      for (const d of drafts) {
        await db.testCaseRecord.create({
          data: {
            ideaId: id,
            code: `TC-${String(++maxCode).padStart(2, '0')}`,
            title: d.title,
            level: d.level,
            kind: d.kind,
            linkedRequirement: d.linkedRequirement,
            linkedCriterion: d.linkedCriterion,
            preconditions: JSON.stringify(d.preconditions),
            steps: JSON.stringify(d.steps),
            expected: d.expected,
            priority: d.priority,
            status: 'proposed',
            order: order++,
          },
        })
      }
      const coverage = await recomputeCoverage(id, requirements)
      await logDecision(
        id,
        'Test suite generated',
        `${count} cases proposed; acceptance-criteria coverage ${coverage.score}%${feedback ? ' — addressing client feedback' : ''}`,
        'readiness'
      )
    } else if (kind === 'edge') {
      const existing = await db.edgeCaseDoc.findUnique({ where: { ideaId: id } })
      if (existing?.status === 'confirmed') {
        await logDecision(id, 'Edge case brainstorm regenerated', 'Previously confirmed — regeneration forced in no-limits mode', 'readiness')
      }
      const features = await db.feature.findMany({
        where: { ideaId: id, status: 'accepted' },
        orderBy: [{ order: 'asc' }],
      })
      const draft = await generateEdgeCases({
        ctx,
        requirements,
        features: features.map((f) => ({
          id: f.id,
          module: f.module,
          feature: f.feature,
          user: f.user,
          priority: f.priority as Feature['priority'],
          status: 'accepted',
          rationale: f.rationale,
          origin: 'ai' as const,
          order: f.order,
        })),
        feedback,
      })
      const data = {
        groups: JSON.stringify(draft.groups),
        note: draft.note,
        status: 'proposed',
      }
      if (existing) {
        await db.edgeCaseDoc.update({ where: { ideaId: id }, data })
      } else {
        await db.edgeCaseDoc.create({ data: { ideaId: id, ...data } })
      }
      count = draft.groups.reduce((n, g) => n + g.cases.length, 0)
      await logDecision(
        id,
        'Edge case brainstorm generated',
        `${count} edge cases across ${draft.groups.length} feature groups${feedback ? ' — addressing client feedback' : ''}`,
        'readiness'
      )
    } else {
      // e2e
      const rejectedRows = await db.e2eScenarioRecord.findMany({
        where: { ideaId: id, status: 'rejected' },
        select: { title: true },
      })
      const processes = await db.processFlow.findMany({ where: { ideaId: id, status: 'confirmed' } })
      const screens = await db.screenSpec.findMany({ where: { ideaId: id, status: 'confirmed' } })
      const drafts = await generateE2eScenarios({
        ctx,
        requirements,
        processes: processes.map((p) => ({
          id: p.id,
          code: p.code,
          name: p.name,
          nameAr: p.nameAr,
          trigger: p.trigger,
          actors: safeArr(p.actors),
          steps: [],
          businessRules: [],
          exceptions: [],
          linkedRequirements: safeArr(p.linkedRequirements),
          rationale: p.rationale,
          status: 'confirmed' as const,
          order: p.order,
        })),
        screens: screens.map((s) => ({
          id: s.id,
          code: s.code,
          name: s.name,
          nameAr: s.nameAr,
          route: s.route,
          purpose: s.purpose,
          roles: safeArr(s.roles),
          elements: [],
          states: { loading: '', empty: '', error: '' },
          rtlNote: s.rtlNote,
          linkedRequirements: safeArr(s.linkedRequirements),
          status: 'confirmed' as const,
          order: s.order,
        })),
        rejectedTitles: rejectedRows.map((r) => r.title),
        feedback,
      })
      await db.e2eScenarioRecord.deleteMany({ where: { ideaId: id, status: { in: ['proposed', 'rejected'] } } })
      const keptScenarios = await db.e2eScenarioRecord.findMany({ where: { ideaId: id }, select: { code: true } })
      let maxCode = 0
      for (const row of keptScenarios) {
        const n = parseInt(row.code.replace(/^E2E-/, ''), 10)
        if (Number.isInteger(n) && n > maxCode) maxCode = n
      }
      let order = keptScenarios.length
      for (const d of drafts) {
        await db.e2eScenarioRecord.create({
          data: {
            ideaId: id,
            code: `E2E-${String(++maxCode).padStart(2, '0')}`,
            title: d.title,
            persona: d.persona,
            given: JSON.stringify(d.given),
            when: JSON.stringify(d.when),
            then: JSON.stringify(d.then),
            screens: JSON.stringify(d.screens),
            priority: d.priority,
            linkedRequirements: JSON.stringify(d.linkedRequirements),
            status: 'proposed',
            order: order++,
          },
        })
      }
      const smoke = drafts.filter((d) => d.priority === 'smoke').length
      await logDecision(
        id,
        'E2E scenarios generated',
        `${count} journeys (${smoke} smoke)${feedback ? ' — addressing client feedback' : ''}`,
        'readiness'
      )
    }

    const payload = await buildIdeaDetail(id)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/ideas/[id]/qa/generate POST]', error)
    return NextResponse.json(
      { error: 'The AI service failed while running this QA engine. Please try again.' },
      { status: 502 }
    )
  }
}
