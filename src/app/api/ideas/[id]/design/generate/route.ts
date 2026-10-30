import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision } from '@/lib/payload'
import { buildProjectContext } from '@/lib/engines/context'
import { generateProcesses, generateEntities, generateApis, generateScreens, generateArchitecture } from '@/lib/engines/design'
import type { Requirement } from '@/lib/types'

// ============================================================
// System design engines — processes, data model, API contracts,
// screens, architecture. NO LIMITS: every kind can be generated
// from ANY stage, any number of times — even after confirmation
// (the regeneration is logged to the decision history).
// Confirmed artifacts are preserved unless regeneration replaces
// them; rejected artifacts are never a dead end.
// ============================================================

type Params = { params: Promise<{ id: string }> }

const KINDS = ['processes', 'entities', 'apis', 'screens', 'architecture'] as const
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
      return NextResponse.json({ error: 'Unknown design kind.' }, { status: 400 })
    }
    // Optional client feedback steering the regeneration (e.g. "use SQLite, not PostgreSQL")
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

    let roles: Array<{ name: string; description: string; permissions: string[] }> = []
    if (idea.roles) {
      try {
        const parsed = JSON.parse(idea.roles)
        if (Array.isArray(parsed)) roles = parsed
      } catch {
        roles = []
      }
    }

    let order = 0
    let count = 0
    const nextOrder = async (table: 'processFlow' | 'dataEntity' | 'apiEndpoint' | 'screenSpec') => {
      const rows = await (table === 'processFlow'
        ? db.processFlow.findMany({ where: { ideaId: id } })
        : table === 'dataEntity'
          ? db.dataEntity.findMany({ where: { ideaId: id } })
          : table === 'apiEndpoint'
            ? db.apiEndpoint.findMany({ where: { ideaId: id } })
            : db.screenSpec.findMany({ where: { ideaId: id } }))
      return rows.length
    }

    if (kind === 'processes') {
      const rejectedRows = await db.processFlow.findMany({ where: { ideaId: id, status: 'rejected' }, select: { name: true } })
      const drafts = await generateProcesses({ ctx, roles, requirements, feedback, rejected: rejectedRows.map((r) => r.name) })
      if (drafts.length === 0) throw new Error('No processes returned')
      await db.processFlow.deleteMany({ where: { ideaId: id, status: { in: ['proposed', 'needs_revision', 'rejected'] } } })
      order = await nextOrder('processFlow')
      for (const d of drafts) {
        await db.processFlow.create({
          data: {
            ideaId: id,
            code: `PF-${String(++count).padStart(2, '0')}`,
            name: d.name,
            nameAr: d.nameAr,
            trigger: d.trigger,
            actors: JSON.stringify(d.actors),
            steps: JSON.stringify(d.steps),
            businessRules: JSON.stringify(d.businessRules),
            exceptions: JSON.stringify(d.exceptions),
            linkedRequirements: JSON.stringify(d.linkedRequirements),
            rationale: d.rationale,
            status: 'proposed',
            order: order++,
          },
        })
      }
      await logDecision(id, 'Business processes analyzed', `${count} process flows proposed${feedback ? ' — addressing client feedback' : ''}`, 'design')
    } else if (kind === 'entities') {
      const rejectedRows = await db.dataEntity.findMany({ where: { ideaId: id, status: 'rejected' }, select: { name: true } })
      const drafts = await generateEntities({ ctx, requirements, feedback, rejected: rejectedRows.map((r) => r.name) })
      if (drafts.length === 0) throw new Error('No entities returned')
      await db.dataEntity.deleteMany({ where: { ideaId: id, status: { in: ['proposed', 'needs_revision', 'rejected'] } } })
      order = await nextOrder('dataEntity')
      for (const d of drafts) {
        await db.dataEntity.create({
          data: {
            ideaId: id,
            code: `ENT-${String(++count).padStart(2, '0')}`,
            name: d.name,
            nameAr: d.nameAr,
            description: d.description,
            fields: JSON.stringify(d.fields),
            relationships: JSON.stringify(d.relationships),
            constraints: JSON.stringify(d.constraints),
            rationale: d.rationale,
            status: 'proposed',
            order: order++,
          },
        })
      }
      await logDecision(id, 'Data model designed', `${count} entities proposed${feedback ? ' — addressing client feedback' : ''}`, 'design')
    } else if (kind === 'apis') {
      const entities = await db.dataEntity.findMany({ where: { ideaId: id, status: 'confirmed' } })
      const processes = await db.processFlow.findMany({ where: { ideaId: id, status: 'confirmed' } })
      const rejectedRows = await db.apiEndpoint.findMany({ where: { ideaId: id, status: 'rejected' }, select: { method: true, path: true } })
      const drafts = await generateApis({
        ctx,
        requirements,
        entityNames: entities.map((e) => e.name),
        processNames: processes.map((p) => p.name),
        feedback,
        rejected: rejectedRows.map((r) => `${r.method} ${r.path}`),
      })
      if (drafts.length === 0) throw new Error('No endpoints returned')
      await db.apiEndpoint.deleteMany({ where: { ideaId: id, status: { in: ['proposed', 'needs_revision', 'rejected'] } } })
      order = await nextOrder('apiEndpoint')
      for (const d of drafts) {
        await db.apiEndpoint.create({
          data: {
            ideaId: id,
            code: `API-${String(++count).padStart(2, '0')}`,
            method: d.method,
            path: d.path,
            purpose: d.purpose,
            auth: d.auth,
            request: JSON.stringify(d.request),
            errors: JSON.stringify(d.errors),
            linkedRequirements: JSON.stringify(d.linkedRequirements),
            linkedEntities: JSON.stringify(d.linkedEntities),
            status: 'proposed',
            order: order++,
          },
        })
      }
      await logDecision(id, 'API contracts defined', `${count} endpoints proposed${feedback ? ' — addressing client feedback' : ''}`, 'design')
    } else if (kind === 'screens') {
      const rejectedRows = await db.screenSpec.findMany({ where: { ideaId: id, status: 'rejected' }, select: { name: true } })
      const drafts = await generateScreens({ ctx, roles, requirements, feedback, rejected: rejectedRows.map((r) => r.name) })
      if (drafts.length === 0) throw new Error('No screens returned')
      await db.screenSpec.deleteMany({ where: { ideaId: id, status: { in: ['proposed', 'needs_revision', 'rejected'] } } })
      order = await nextOrder('screenSpec')
      for (const d of drafts) {
        await db.screenSpec.create({
          data: {
            ideaId: id,
            code: `SCR-${String(++count).padStart(2, '0')}`,
            name: d.name,
            nameAr: d.nameAr,
            route: d.route,
            purpose: d.purpose,
            roles: JSON.stringify(d.roles),
            elements: JSON.stringify(d.elements),
            states: JSON.stringify(d.states),
            rtlNote: d.rtlNote,
            linkedRequirements: JSON.stringify(d.linkedRequirements),
            status: 'proposed',
            order: order++,
          },
        })
      }
      await logDecision(id, 'UX/UI specification drafted', `${count} screens proposed${feedback ? ' — addressing client feedback' : ''}`, 'design')
    } else {
      // architecture — NO LIMITS: regeneration is always allowed,
      // even when confirmed (the previous confirmed state is logged).
      const existing = await db.architectureDoc.findUnique({ where: { ideaId: id } })
      if (existing?.status === 'confirmed') {
        await logDecision(id, 'Architecture regenerated', 'Previously confirmed — regeneration forced in no-limits mode', 'design')
      }

      // When regenerating after a rejection, pass the rejected proposal so the
      // engine does not repeat it and steers by the client's feedback.
      let previousStack: Array<{ area: string; choice: string }> | undefined
      if (existing?.status === 'rejected' && existing.techStack) {
        try {
          const parsed = JSON.parse(existing.techStack)
          if (Array.isArray(parsed)) {
            previousStack = parsed
              .filter((t): t is { area: string; choice: string } =>
                typeof t?.area === 'string' && typeof t?.choice === 'string')
              .map((t) => ({ area: t.area, choice: t.choice }))
          }
        } catch {
          previousStack = undefined
        }
      }

      const draft = await generateArchitecture({ ctx, requirements, feedback, previousStack })
      if (existing) {
        await db.architectureDoc.update({
          where: { ideaId: id },
          data: {
            components: JSON.stringify(draft.components),
            integrations: JSON.stringify(draft.integrations),
            techStack: JSON.stringify(draft.techStack),
            notes: draft.notes,
            status: 'proposed',
          },
        })
      } else {
        await db.architectureDoc.create({
          data: {
            ideaId: id,
            components: JSON.stringify(draft.components),
            integrations: JSON.stringify(draft.integrations),
            techStack: JSON.stringify(draft.techStack),
            notes: draft.notes,
            status: 'proposed',
          },
        })
      }
      count = 1
      await logDecision(
        id,
        'Architecture recommendation regenerated',
        existing?.status === 'rejected'
          ? `Previous rejected proposal replaced${feedback ? ' — client feedback: ' + feedback.slice(0, 200) : ''}`
          : 'Simplest-first recommendation with trade-offs',
        'design'
      )
    }

    const payload = await buildIdeaDetail(id)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/ideas/[id]/design/generate POST]', error)
    return NextResponse.json(
      { error: 'The AI service failed while designing this artifact set. Please try again.' },
      { status: 502 }
    )
  }
}
