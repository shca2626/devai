import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision, parseInterpretation } from '@/lib/payload'
import { generateFeatureInventory } from '@/lib/engines/features'
import type { AnsweredItem } from '@/lib/engines/discover'

type Params = { params: Promise<{ id: string }> }

// Engine 3 — generate the feature inventory. NO LIMITS: can be
// (re)generated from ANY stage, any number of times.
export async function POST(_req: Request, { params }: Params) {
  try {
    const { id } = await params
    const idea = await db.idea.findUnique({ where: { id } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }

    const interpretation = parseInterpretation(idea.interpretation)
    if (!interpretation) {
      return NextResponse.json({ error: 'No interpretation available.' }, { status: 409 })
    }

    const answered = await db.question.findMany({
      where: { ideaId: id, status: 'answered' },
      orderBy: [{ order: 'asc' }, { createdAt: 'asc' }],
    })
    const items: AnsweredItem[] = answered.map((q) => ({
      area: q.area,
      questionEn: q.questionEn,
      answer: q.answer ?? '',
    }))

    // Real AI call — the feature inventory
    const inventory = await generateFeatureInventory({ interpretation, answered: items })

    // Fresh generation: clear any leftover undecided rows
    await db.feature.deleteMany({ where: { ideaId: id } })
    let order = 0
    for (const f of inventory.features) {
      await db.feature.create({
        data: {
          ideaId: id,
          module: f.module,
          feature: f.feature,
          user: f.user,
          priority: f.priority,
          status: f.status,
          rationale: f.rationale,
          origin: 'ai',
          order: order++,
        },
      })
    }

    await db.idea.update({
      where: { id },
      data: {
        featuresMeta: JSON.stringify({
          missingFeatures: inventory.missingFeatures,
          dependencies: inventory.dependencies,
          releaseNote: inventory.releaseNote,
        }),
      },
    })
    await logDecision(
      id,
      'Feature inventory generated',
      `${inventory.features.length} features proposed by AI — none are accepted until the user decides.`,
      'features'
    )

    const payload = await buildIdeaDetail(id)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/ideas/[id]/features/generate POST]', error)
    return NextResponse.json(
      { error: 'The AI service could not generate the feature inventory. Please try again.' },
      { status: 502 }
    )
  }
}
