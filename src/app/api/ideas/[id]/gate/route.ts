import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision, parseInterpretation, parseSummary, parseBaseline } from '@/lib/payload'
import { generateQuestions, type AnsweredItem } from '@/lib/engines/discover'
import { AREAS } from '@/lib/types'
import type { BaselineSnapshot } from '@/lib/types'

// ============================================================
// Approval gates — the ONLY way to advance stages.
// The model never advances anything by itself; silence is
// never treated as approval. All transitions are explicit.
// ============================================================

type Params = { params: Promise<{ id: string }> }

async function answeredItems(ideaId: string): Promise<AnsweredItem[]> {
  const questions = await db.question.findMany({
    where: { ideaId, status: 'answered' },
    orderBy: [{ order: 'asc' }, { createdAt: 'asc' }],
  })
  return questions.map((q) => ({ area: q.area, questionEn: q.questionEn, answer: q.answer ?? '' }))
}

export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json()) as {
      gate?: 'interpretation' | 'baseline'
      action?: 'approve'
      unreviewedAction?: 'accept' | 'defer' | 'reject'
    }

    const idea = await db.idea.findUnique({ where: { id } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }

    // ---------- Gate 1: interpretation approval ----------
    if (body.gate === 'interpretation' && body.action === 'approve') {
      if (idea.stage !== 'understanding') {
        return NextResponse.json({ error: 'This gate was already passed.' }, { status: 409 })
      }
      const interpretation = parseInterpretation(idea.interpretation)
      if (!interpretation) {
        return NextResponse.json({ error: 'No interpretation to approve yet.' }, { status: 409 })
      }

      // Generate the first discovery questions
      const drafts = await generateQuestions({
        interpretation,
        answered: [],
        uncoveredAreas: [...AREAS],
        weakAreas: [],
      })

      let order = 0
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

      await db.idea.update({ where: { id }, data: { stage: 'discovery' } })
      await logDecision(id, 'Interpretation approved — discovery started', undefined, 'understanding')

      const payload = await buildIdeaDetail(id)
      return NextResponse.json(payload)
    }

    // ---------- Gate 2: feature baseline approval ----------
    if (body.gate === 'baseline' && body.action === 'approve') {
      if (idea.stage !== 'features') {
        return NextResponse.json({ error: 'This gate was already passed.' }, { status: 409 })
      }

      const features = await db.feature.findMany({ where: { ideaId: id } })
      if (features.length === 0) {
        return NextResponse.json({ error: 'Generate the feature inventory first.' }, { status: 409 })
      }

      const unreviewed = features.filter(
        (f) => f.status === 'proposed' || f.status === 'needs_confirmation'
      )
      if (unreviewed.length > 0 && !body.unreviewedAction) {
        return NextResponse.json(
          {
            error: `${unreviewed.length} feature(s) are still unreviewed. Decide what to do with them before approving.`,
            unreviewedCount: unreviewed.length,
          },
          { status: 409 }
        )
      }

      const map: Record<string, string> = { accept: 'accepted', defer: 'deferred', reject: 'rejected' }
      if (unreviewed.length > 0 && body.unreviewedAction && map[body.unreviewedAction]) {
        await db.feature.updateMany({
          where: { ideaId: id, status: { in: ['proposed', 'needs_confirmation'] } },
          data: { status: map[body.unreviewedAction] },
        })
      }

      const finalFeatures = await db.feature.findMany({
        where: { ideaId: id },
        orderBy: [{ order: 'asc' }, { createdAt: 'asc' }],
      })
      const openQuestions = await db.question.findMany({
        where: { ideaId: id, status: { not: 'answered' } },
        select: { questionEn: true },
      })

      const snapshot: BaselineSnapshot = {
        approvedAt: new Date().toISOString(),
        interpretation: parseInterpretation(idea.interpretation),
        summary: parseSummary(idea.summary),
        features: finalFeatures.map((f) => ({
          module: f.module,
          feature: f.feature,
          user: f.user,
          priority: f.priority as BaselineSnapshot['features'][number]['priority'],
          status: f.status as BaselineSnapshot['features'][number]['status'],
          rationale: f.rationale,
        })),
        openQuestions: openQuestions.map((q) => q.questionEn),
      }

      const counts = {
        accepted: finalFeatures.filter((f) => f.status === 'accepted').length,
        deferred: finalFeatures.filter((f) => f.status === 'deferred').length,
        rejected: finalFeatures.filter((f) => f.status === 'rejected').length,
      }

      await db.idea.update({
        where: { id },
        data: { stage: 'baseline', baseline: JSON.stringify(snapshot) },
      })
      await logDecision(
        id,
        'Feature baseline approved',
        `Accepted ${counts.accepted}, deferred ${counts.deferred}, rejected ${counts.rejected}${
          unreviewed.length > 0 && body.unreviewedAction ? `. Unreviewed features were bulk-${body.unreviewedAction}ed.` : ''
        }`,
        'features'
      )

      const payload = await buildIdeaDetail(id)
      return NextResponse.json(payload)
    }

    return NextResponse.json({ error: 'Unknown gate or action.' }, { status: 400 })
  } catch (error) {
    console.error('[api/ideas/[id]/gate POST]', error)
    return NextResponse.json(
      { error: 'The AI service failed while opening the next stage. Please try again.' },
      { status: 502 }
    )
  }
}
