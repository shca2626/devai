import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision } from '@/lib/payload'
import { buildProjectContext } from '@/lib/engines/context'
import { generateTasks, generateRisks } from '@/lib/engines/plan'
import type { Requirement } from '@/lib/types'

function safeArr(raw: string | null): string[] {
  try {
    const v = raw ? JSON.parse(raw) : []
    return Array.isArray(v) ? v : []
  } catch {
    return []
  }
}

// ============================================================
// Engineering planning — dependency-ordered implementation
// tasks and the risk register. NO LIMITS: works from ANY stage;
// tasks trace to whatever requirements exist.
// ============================================================

type Params = { params: Promise<{ id: string }> }

export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json().catch(() => ({}))) as { kind?: string }
    const kind = body.kind === 'risks' ? 'risks' : 'tasks'

    const idea = await db.idea.findUnique({ where: { id } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }

    const ctx = await buildProjectContext(id)
    if (!ctx) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }

    const requirements = await db.requirement.findMany({ where: { ideaId: id }, orderBy: [{ order: 'asc' }] })

    const typedRequirements: Requirement[] = requirements.map((r) => ({
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

    if (kind === 'tasks') {
      const [entities, apis, screens] = await Promise.all([
        db.dataEntity.findMany({ where: { ideaId: id, status: 'confirmed' } }),
        db.apiEndpoint.findMany({ where: { ideaId: id, status: 'confirmed' } }),
        db.screenSpec.findMany({ where: { ideaId: id, status: 'confirmed' } }),
      ])

      const drafts = await generateTasks({
        ctx,
        requirements: typedRequirements,
        entityNames: entities.map((e) => e.name),
        apiPaths: apis.map((a) => `${a.method} ${a.path}`),
        screenNames: screens.map((s) => s.name),
      })
      if (drafts.length === 0) throw new Error('No tasks returned')

      // Rejected tasks are replaced too — a rejection is not a dead end.
      await db.implTask.deleteMany({ where: { ideaId: id, status: { in: ['proposed', 'needs_revision', 'rejected'] } } })

      // Map the LLM's internal ids (T1, T2…) to stable codes (T-01…)
      const existing = await db.implTask.findMany({ where: { ideaId: id } })
      let order = existing.length
      const idToCode = new Map<string, string>()
      for (const d of drafts) {
        idToCode.set(d.id, `T-${String(idToCode.size + 1).padStart(2, '0')}`)
      }

      for (const d of drafts) {
        await db.implTask.create({
          data: {
            ideaId: id,
            code: idToCode.get(d.id)!,
            title: d.title,
            titleAr: d.titleAr,
            description: d.description,
            phase: d.phase,
            priority: d.priority,
            dependsOn: JSON.stringify(d.dependsOn.map((dep) => idToCode.get(dep)).filter((c): c is string => !!c)),
            acceptanceCriteria: JSON.stringify(d.acceptanceCriteria),
            deliverable: d.deliverable,
            requirementCodes: JSON.stringify(d.requirementCodes),
            estimate: d.estimate,
            status: 'proposed',
            order: order++,
          },
        })
      }

      await logDecision(id, 'Implementation plan drafted', `${drafts.length} dependency-ordered tasks across phases`, 'planning')
    } else {
      const drafts = await generateRisks({
        ctx,
        requirements: typedRequirements,
      })
      if (drafts.length === 0) throw new Error('No risks returned')

      await db.riskItem.deleteMany({ where: { ideaId: id, status: 'proposed' } })
      const existing = await db.riskItem.findMany({ where: { ideaId: id } })
      let order = existing.length
      let count = 0
      for (const d of drafts) {
        await db.riskItem.create({
          data: {
            ideaId: id,
            code: `RSK-${String(++count).padStart(2, '0')}`,
            category: d.category,
            description: d.description,
            likelihood: d.likelihood,
            impact: d.impact,
            mitigation: d.mitigation,
            basis: d.basis,
            status: 'proposed',
            order: order++,
          },
        })
      }
      await logDecision(id, 'Risk register generated', `${count} risks identified across categories`, 'planning')
    }

    const payload = await buildIdeaDetail(id)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/ideas/[id]/plan/generate POST]', error)
    return NextResponse.json(
      { error: 'The AI service failed while planning. Please try again.' },
      { status: 502 }
    )
  }
}
