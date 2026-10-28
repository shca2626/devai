import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision, parseInterpretation } from '@/lib/payload'
import { reinterpretIdea } from '@/lib/engines/understand'

// Re-interpret with user corrections — only allowed before the
// interpretation approval gate has been passed.
type Params = { params: Promise<{ id: string }> }

export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json()) as { corrections?: string }
    const corrections = (body.corrections ?? '').trim()
    if (corrections.length < 3) {
      return NextResponse.json({ error: 'Please describe what should be corrected.' }, { status: 400 })
    }

    const idea = await db.idea.findUnique({ where: { id } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }
    if (idea.stage !== 'understanding') {
      return NextResponse.json(
        { error: 'The interpretation was already approved and is locked for this idea.' },
        { status: 409 }
      )
    }

    const previous = parseInterpretation(idea.interpretation)
    if (!previous) {
      return NextResponse.json({ error: 'No previous interpretation to correct.' }, { status: 409 })
    }

    const updated = await reinterpretIdea(idea.originalText, previous, corrections)

    await db.idea.update({
      where: { id },
      data: { title: updated.title, interpretation: JSON.stringify(updated) },
    })

    // Reset understanding-stage assumptions to match the new interpretation
    await db.assumption.deleteMany({ where: { ideaId: id, source: 'understanding' } })
    for (const a of updated.assumed) {
      await db.assumption.create({
        data: { ideaId: id, text: a, kind: 'suggested', status: 'open', source: 'understanding' },
      })
    }

    await logDecision(id, 'Interpretation corrected by user', corrections.slice(0, 500), 'understanding')

    const payload = await buildIdeaDetail(id)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/ideas/[id]/reinterpret POST]', error)
    return NextResponse.json(
      { error: 'The AI service could not re-interpret the idea. Please try again.' },
      { status: 502 }
    )
  }
}
