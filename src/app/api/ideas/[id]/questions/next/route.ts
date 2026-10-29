import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, parseInterpretation } from '@/lib/payload'
import { generateQuestions, type AnsweredItem } from '@/lib/engines/discover'
import { AREAS } from '@/lib/types'

type Params = { params: Promise<{ id: string }> }

const MAX_QUESTIONS = 14
const STRONG_COVERAGE = 8

// Fetch the next discovery question(s). Pending questions are
// returned without an AI call. When coverage is strong or the
// cap is reached, the app suggests finishing instead — the user
// always decides.
export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json().catch(() => ({}))) as { force?: boolean }

    const idea = await db.idea.findUnique({ where: { id } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }
    if (idea.stage !== 'discovery') {
      return NextResponse.json({ error: 'Not in the discovery stage.' }, { status: 409 })
    }

    // Return existing pending questions first (no AI call)
    const pending = await db.question.findMany({
      where: { ideaId: id, status: 'pending' },
      orderBy: [{ order: 'asc' }, { createdAt: 'asc' }],
    })
    if (pending.length > 0) {
      const payload = await buildIdeaDetail(id)
      return NextResponse.json({ ...payload, suggestDone: false })
    }

    const all = await db.question.findMany({ where: { ideaId: id } })
    const answered = all.filter((q) => q.status === 'answered')
    const answeredAreas = new Set(answered.map((q) => q.area))
    const uncovered = [...AREAS].filter((a) => !answeredAreas.has(a))

    const reachedCap = all.length >= MAX_QUESTIONS
    const strongCoverage = answeredAreas.size >= STRONG_COVERAGE

    if (!body.force && (reachedCap || strongCoverage)) {
      const payload = await buildIdeaDetail(id)
      return NextResponse.json({
        ...payload,
        suggestDone: true,
        coverage: { answered: answeredAreas.size, total: AREAS.length, uncovered },
      })
    }

    // Generate the next batch (adaptive — real AI call)
    const interpretation = parseInterpretation(idea.interpretation)
    if (!interpretation) {
      return NextResponse.json({ error: 'No interpretation available.' }, { status: 409 })
    }
    const answeredItems: AnsweredItem[] = answered
      .sort((a, b) => a.order - b.order)
      .map((q) => ({ area: q.area, questionEn: q.questionEn, answer: q.answer ?? '' }))

    const weakAreas = [...AREAS].filter(
      (a) => answeredAreas.has(a) && answered.filter((q) => q.area === a).length === 1
    )

    const drafts = await generateQuestions({
      interpretation,
      answered: answeredItems,
      uncoveredAreas: uncovered,
      weakAreas,
    })

    let order = all.length
    for (const draft of drafts) {
      await db.question.create({
        data: {
          ideaId: id,
          area: draft.area,
          questionEn: draft.questionEn,
          questionAr: draft.questionAr,
          whyItMatters: draft.whyItMatters,
          options: JSON.stringify(draft.options),
          status: 'pending',
          order: order++,
        },
      })
    }

    const noProgress = drafts.length === 0
    const payload = await buildIdeaDetail(id)
    return NextResponse.json({
      ...payload,
      suggestDone: noProgress || (answeredAreas.size >= STRONG_COVERAGE && drafts.length === 0),
      coverage: { answered: answeredAreas.size, total: AREAS.length, uncovered },
    })
  } catch (error) {
    console.error('[api/ideas/[id]/questions/next POST]', error)
    return NextResponse.json(
      { error: 'The AI service could not generate the next question. Please try again.' },
      { status: 502 }
    )
  }
}
