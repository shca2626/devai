import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision } from '@/lib/payload'
import { buildProjectContext } from '@/lib/engines/context'
import {
  generateTradeStudy,
  generateAdrs,
  generateThreatModel,
  generateScaleReport,
} from '@/lib/engines/architect'
import type { Requirement } from '@/lib/types'

// ============================================================
// Architect Lab engines — trade-off study, ADRs, STRIDE threat
// model, scale simulation. NO LIMITS: every kind can be
// generated from ANY stage, any number of times — even after
// confirmation (regeneration is logged to the decision history).
// Rejected proposals are passed back to the engine so it never
// repeats them unchanged; client feedback MUST be addressed.
// ============================================================

type Params = { params: Promise<{ id: string }> }

const KINDS = ['tradeoffs', 'adrs', 'threats', 'scale'] as const
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

export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json().catch(() => ({}))) as { kind?: string; feedback?: string }
    const kind = KINDS.find((k) => k === body.kind)
    if (!kind) {
      return NextResponse.json({ error: 'Unknown architect kind.' }, { status: 400 })
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

    // Shared design surface the architect engines reason over
    const architecture = await db.architectureDoc.findUnique({ where: { ideaId: id } })
    const entities = await db.dataEntity.findMany({ where: { ideaId: id, status: 'confirmed' } })
    let components: string[] = []
    let stackChoices: string[] = []
    let currentStack: Array<{ area: string; choice: string }> | undefined
    if (architecture) {
      try {
        const comps = architecture.components ? JSON.parse(architecture.components) : []
        if (Array.isArray(comps)) {
          components = comps
            .map((c: { name?: unknown }) => (typeof c?.name === 'string' ? c.name : ''))
            .filter(Boolean)
        }
      } catch {
        components = []
      }
      try {
        const stack = architecture.techStack ? JSON.parse(architecture.techStack) : []
        if (Array.isArray(stack)) {
          const rows = stack
            .filter((s: { area?: unknown; choice?: unknown }) => typeof s?.area === 'string' && typeof s?.choice === 'string')
            .map((s: { area: string; choice: string }) => ({ area: s.area, choice: s.choice }))
          stackChoices = rows.map((r: { area: string; choice: string }) => `${r.area}: ${r.choice}`)
          currentStack = rows
        }
      } catch {
        stackChoices = []
      }
    }

    let count = 0

    if (kind === 'tradeoffs') {
      const existing = await db.archTradeStudy.findUnique({ where: { ideaId: id } })
      if (existing?.status === 'confirmed') {
        await logDecision(id, 'Trade-off study regenerated', 'Previously confirmed — regeneration forced in no-limits mode', 'design')
      }
      const draft = await generateTradeStudy({ ctx, requirements, currentStack, feedback })
      const data = {
        candidates: JSON.stringify(draft.candidates),
        recommended: draft.recommended,
        rationale: draft.rationale,
        linkedRequirements: JSON.stringify(draft.linkedRequirements),
        status: 'proposed',
      }
      if (existing) {
        await db.archTradeStudy.update({ where: { ideaId: id }, data })
      } else {
        await db.archTradeStudy.create({ data: { ideaId: id, ...data } })
      }
      count = draft.candidates.length
      await logDecision(
        id,
        'Architecture trade-off study generated',
        `${count} candidates compared — recommended: ${draft.recommended}${feedback ? ' — addressing client feedback' : ''}`,
        'design'
      )
    } else if (kind === 'adrs') {
      const rejectedRows = await db.archDecisionRecord.findMany({
        where: { ideaId: id, status: 'rejected' },
        select: { title: true },
      })
      const standing = await db.decisionEntry.findMany({
        where: { ideaId: id, status: 'active' },
        select: { choice: true },
      })
      const drafts = await generateAdrs({
        ctx,
        requirements,
        existingChoices: standing.map((s) => s.choice),
        rejectedTitles: rejectedRows.map((r) => r.title),
        feedback,
      })
      if (drafts.length === 0) throw new Error('No ADRs returned')
      await db.archDecisionRecord.deleteMany({
        where: { ideaId: id, status: { in: ['proposed', 'rejected'] } },
      })
      const keptRows = await db.archDecisionRecord.findMany({ where: { ideaId: id }, select: { code: true } })
      let maxCode = 0
      for (const row of keptRows) {
        const n = parseInt(row.code.replace(/^ADR-/, ''), 10)
        if (Number.isInteger(n) && n > maxCode) maxCode = n
      }
      let order = keptRows.length
      for (const d of drafts) {
        await db.archDecisionRecord.create({
          data: {
            ideaId: id,
            code: `ADR-${String(++maxCode).padStart(2, '0')}`,
            title: d.title,
            titleAr: d.titleAr,
            context: d.context,
            decision: d.decision,
            alternatives: JSON.stringify(d.alternatives),
            consequences: JSON.stringify(d.consequences),
            linkedRequirements: JSON.stringify(d.linkedRequirements),
            status: 'proposed',
            order: order++,
          },
        })
      }
      await logDecision(id, 'Architecture decision records drafted', `${count} ADRs proposed${feedback ? ' — addressing client feedback' : ''}`, 'design')
    } else if (kind === 'threats') {
      const existing = await db.threatModelDoc.findUnique({ where: { ideaId: id } })
      if (existing?.status === 'confirmed') {
        await logDecision(id, 'Threat model regenerated', 'Previously confirmed — regeneration forced in no-limits mode', 'design')
      }
      const draft = await generateThreatModel({
        ctx,
        requirements,
        components,
        entityNames: entities.map((e) => e.name),
        feedback,
      })
      const data = {
        findings: JSON.stringify(draft.findings),
        summary: draft.summary,
        residual: draft.residual,
        status: 'proposed',
      }
      if (existing) {
        await db.threatModelDoc.update({ where: { ideaId: id }, data })
      } else {
        await db.threatModelDoc.create({ data: { ideaId: id, ...data } })
      }
      count = draft.findings.length
      await logDecision(
        id,
        'STRIDE threat model generated',
        `${count} findings across ${new Set(draft.findings.map((f) => f.category)).size} STRIDE categories${feedback ? ' — addressing client feedback' : ''}`,
        'design'
      )
    } else {
      // scale
      const existing = await db.scaleReport.findUnique({ where: { ideaId: id } })
      if (existing?.status === 'confirmed') {
        await logDecision(id, 'Scale report regenerated', 'Previously confirmed — regeneration forced in no-limits mode', 'design')
      }
      const draft = await generateScaleReport({ ctx, requirements, components, stackChoices, feedback })
      const data = {
        assumptions: JSON.stringify(draft.assumptions),
        bottlenecks: JSON.stringify(draft.bottlenecks),
        scenarios: JSON.stringify(draft.scenarios),
        plan: draft.plan,
        status: 'proposed',
      }
      if (existing) {
        await db.scaleReport.update({ where: { ideaId: id }, data })
      } else {
        await db.scaleReport.create({ data: { ideaId: id, ...data } })
      }
      count = draft.bottlenecks.length
      await logDecision(
        id,
        'Scale simulation generated',
        `${draft.bottlenecks.length} bottlenecks mapped; scenarios: ${draft.scenarios.map((s) => s.label).join(', ')}${feedback ? ' — addressing client feedback' : ''}`,
        'design'
      )
    }

    const payload = await buildIdeaDetail(id)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/ideas/[id]/architect/generate POST]', error)
    return NextResponse.json(
      { error: 'The AI service failed while running this architect engine. Please try again.' },
      { status: 502 }
    )
  }
}
