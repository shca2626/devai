import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision } from '@/lib/payload'

type Params = { params: Promise<{ id: string }> }

// Answer or skip a discovery question. Allowed only while the
// idea is in the discovery stage.
export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json()) as {
      questionId?: string
      answer?: string
      kind?: 'choice' | 'custom' | 'skip'
    }

    const idea = await db.idea.findUnique({ where: { id } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }
    if (idea.stage !== 'discovery') {
      return NextResponse.json(
        { error: 'Answers can only be submitted during the discovery stage.' },
        { status: 409 }
      )
    }

    const question = await db.question.findUnique({ where: { id: body.questionId ?? '' } })
    if (!question || question.ideaId !== id) {
      return NextResponse.json({ error: 'Question not found' }, { status: 404 })
    }
    if (question.status !== 'pending') {
      return NextResponse.json({ error: 'This question was already answered.' }, { status: 409 })
    }

    if (body.kind === 'skip') {
      await db.question.update({ where: { id: question.id }, data: { status: 'skipped' } })
      await logDecision(id, `Skipped question (${question.area})`, question.questionEn.slice(0, 300), 'discovery')
    } else {
      const answer = (body.answer ?? '').trim()
      if (!answer) {
        return NextResponse.json({ error: 'Answer cannot be empty.' }, { status: 400 })
      }
      await db.question.update({
        where: { id: question.id },
        data: { answer, answerKind: body.kind === 'choice' ? 'choice' : 'custom', status: 'answered' },
      })
      await logDecision(
        id,
        `Answered question (${question.area})`,
        `${question.questionEn.slice(0, 160)} → ${answer.slice(0, 160)}`,
        'discovery'
      )
    }

    const payload = await buildIdeaDetail(id)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/ideas/[id]/questions/answer POST]', error)
    return NextResponse.json({ error: 'Failed to save the answer.' }, { status: 500 })
  }
}
