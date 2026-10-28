import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision, parseInterpretation } from '@/lib/payload'
import { compileDiscoverySummary, type AnsweredItem } from '@/lib/engines/discover'

type Params = { params: Promise<{ id: string }> }

const MIN_ANSWERED = 5

// Compile the discovery summary and move to the features stage.
// Requires a minimum of real answers — the gate is app-enforced.
export async function POST(_req: Request, { params }: Params) {
  try {
    const { id } = await params
    const idea = await db.idea.findUnique({ where: { id } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }
    if (idea.stage !== 'discovery') {
      return NextResponse.json({ error: 'Not in the discovery stage.' }, { status: 409 })
    }

    const answered = await db.question.findMany({
      where: { ideaId: id, status: 'answered' },
      orderBy: [{ order: 'asc' }, { createdAt: 'asc' }],
    })
    if (answered.length < MIN_ANSWERED) {
      return NextResponse.json(
        { error: `Answer at least ${MIN_ANSWERED} questions before finishing discovery (${answered.length} answered so far).` },
        { status: 409 }
      )
    }

    const interpretation = parseInterpretation(idea.interpretation)
    if (!interpretation) {
      return NextResponse.json({ error: 'No interpretation available.' }, { status: 409 })
    }

    const items: AnsweredItem[] = answered.map((q) => ({
      area: q.area,
      questionEn: q.questionEn,
      answer: q.answer ?? '',
    }))

    // Real AI call — compile the structured summary
    const summary = await compileDiscoverySummary({ interpretation, answered: items })

    // Open risks become "uncertain" assumptions; suggestions become "suggested"
    for (const risk of summary.openRisks) {
      await db.assumption.create({
        data: { ideaId: id, text: risk, kind: 'uncertain', status: 'open', source: 'discovery' },
      })
    }
    for (const s of summary.suggestedAssumptions) {
      await db.assumption.create({
        data: { ideaId: id, text: s, kind: 'suggested', status: 'open', source: 'discovery' },
      })
    }

    await db.idea.update({
      where: { id },
      data: { stage: 'features', summary: JSON.stringify(summary) },
    })
    await logDecision(id, 'Discovery finished — summary compiled', `${answered.length} questions answered`, 'discovery')

    const payload = await buildIdeaDetail(id)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/ideas/[id]/finish-discovery POST]', error)
    return NextResponse.json(
      { error: 'The AI service could not compile the discovery summary. Please try again.' },
      { status: 502 }
    )
  }
}
