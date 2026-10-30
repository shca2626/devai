import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision } from '@/lib/payload'
import { buildProjectContext } from '@/lib/engines/context'
import { generateRequirements } from '@/lib/engines/requirements'

// ============================================================
// Requirements Engineering — generate the SRS. NO LIMITS:
// works from ANY stage and with ANY feature state — the engine
// uses whatever context exists (interpretation + answers +
// features). Replaces previous proposed requirements;
// confirmed / rejected / unresolved ones are preserved.
// ============================================================

type Params = { params: Promise<{ id: string }> }

export async function POST(_req: Request, { params }: Params) {
  try {
    const { id } = await params
    const idea = await db.idea.findUnique({ where: { id } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }

    const ctx = await buildProjectContext(id)
    if (!ctx) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }

    const result = await generateRequirements(ctx)

    // Keep prior decisions; regenerate only what was never reviewed
    await db.requirement.deleteMany({ where: { ideaId: id, status: 'proposed' } })

    const features = await db.feature.findMany({ where: { ideaId: id, status: 'accepted' } })
    const matchFeature = (ref: string | null): string | null => {
      if (!ref) return null
      const norm = (s: string) => s.toLowerCase().replace(/[^a-z0-9\u0600-\u06FF]/g, '')
      const target = norm(ref)
      const exact = features.find((f) => norm(f.feature) === target)
      if (exact) return exact.id
      const partial = features.find((f) => norm(f.feature).includes(target) || target.includes(norm(f.feature)))
      return partial?.id ?? null
    }

    let frCount = 0
    let nfrCount = 0
    let order = 0
    for (const draft of [...result.functional, ...result.nonFunctional]) {
      const code = draft.type === 'functional' ? `FR-${String(++frCount).padStart(3, '0')}` : `NFR-${String(++nfrCount).padStart(3, '0')}`
      await db.requirement.create({
        data: {
          ideaId: id,
          code,
          type: draft.type,
          category: draft.category,
          title: draft.title,
          titleAr: draft.titleAr,
          description: draft.description,
          acceptanceCriteria: JSON.stringify(draft.acceptanceCriteria),
          provenance: draft.provenance,
          evidence: draft.evidence,
          featureId: draft.provenance === 'client' ? matchFeature(draft.featureRef) : null,
          priority: draft.priority,
          status: draft.status,
          order: order++,
        },
      })
    }

    if (result.roles.length > 0) {
      await db.idea.update({ where: { id }, data: { roles: JSON.stringify(result.roles) } })
    }

    await logDecision(
      id,
      'Requirements specification generated',
      `${frCount} functional + ${nfrCount} non-functional requirements proposed; ${result.roles.length} roles defined`,
      'requirements'
    )

    const payload = await buildIdeaDetail(id)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/ideas/[id]/requirements/generate POST]', error)
    return NextResponse.json(
      { error: 'The AI service failed while generating the requirements. Please try again.' },
      { status: 502 }
    )
  }
}
