import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, buildBaselineSnapshot, logDecision, parseInterpretation } from '@/lib/payload'
import { generateQuestions, type AnsweredItem } from '@/lib/engines/discover'
import { AREAS } from '@/lib/types'

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
      gate?: 'interpretation' | 'baseline' | 'engineering_start' | 'requirements' | 'design' | 'planning' | 'package'
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

      const snapshot = await buildBaselineSnapshot(id)

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

    // ---------- Gate 3: start the engineering track ----------
    if (body.gate === 'engineering_start' && body.action === 'approve') {
      if (idea.stage !== 'baseline') {
        return NextResponse.json({ error: 'The engineering track starts from an approved baseline.' }, { status: 409 })
      }
      await db.idea.update({ where: { id }, data: { stage: 'requirements' } })
      await logDecision(
        id,
        'Engineering track started',
        'The client moved from the discovery baseline to requirements engineering',
        'baseline'
      )
      const payload = await buildIdeaDetail(id)
      return NextResponse.json(payload)
    }

    // ---------- Gate 4: requirements approved ----------
    if (body.gate === 'requirements' && body.action === 'approve') {
      if (idea.stage !== 'requirements') {
        return NextResponse.json({ error: 'This gate was already passed.' }, { status: 409 })
      }
      const requirements = await db.requirement.findMany({ where: { ideaId: id } })
      if (requirements.length === 0) {
        return NextResponse.json({ error: 'Generate the requirements specification first.' }, { status: 409 })
      }

      const unreviewed = requirements.filter((r) => r.status === 'proposed')
      if (unreviewed.length > 0 && !body.unreviewedAction) {
        return NextResponse.json(
          {
            error: `${unreviewed.length} requirement(s) are still unreviewed. Decide what to do with them before approving.`,
            unreviewedCount: unreviewed.length,
          },
          { status: 409 }
        )
      }
      const map: Record<string, string> = { accept: 'confirmed', defer: 'unresolved', reject: 'rejected' }
      if (unreviewed.length > 0 && body.unreviewedAction && map[body.unreviewedAction]) {
        await db.requirement.updateMany({
          where: { ideaId: id, status: 'proposed' },
          data: { status: map[body.unreviewedAction] },
        })
      }

      // Re-read AFTER the bulk decision so the confirmation check is accurate
      const finalRequirements = await db.requirement.findMany({ where: { ideaId: id } })
      const confirmed = finalRequirements.filter((r) => r.status === 'confirmed').length
      if (confirmed === 0) {
        return NextResponse.json(
          { error: 'At least one requirement must be confirmed before design can start.' },
          { status: 409 }
        )
      }

      await db.idea.update({ where: { id }, data: { stage: 'design' } })
      await logDecision(
        id,
        'Requirements specification approved',
        `${confirmed} confirmed, ${finalRequirements.filter((r) => r.status === 'unresolved').length} unresolved (tracked), ${finalRequirements.filter((r) => r.status === 'rejected').length} rejected`,
        'requirements'
      )
      const payload = await buildIdeaDetail(id)
      return NextResponse.json(payload)
    }

    // ---------- Gate 5: system design approved ----------
    if (body.gate === 'design' && body.action === 'approve') {
      if (idea.stage !== 'design') {
        return NextResponse.json({ error: 'This gate was already passed.' }, { status: 409 })
      }
      const [processes, entities, apis, screens, architecture] = await Promise.all([
        db.processFlow.findMany({ where: { ideaId: id } }),
        db.dataEntity.findMany({ where: { ideaId: id } }),
        db.apiEndpoint.findMany({ where: { ideaId: id } }),
        db.screenSpec.findMany({ where: { ideaId: id } }),
        db.architectureDoc.findUnique({ where: { ideaId: id } }),
      ])

      const checks = [
        { list: processes, label: 'business processes' },
        { list: entities, label: 'data entities' },
        { list: apis, label: 'API endpoints' },
        { list: screens, label: 'screens' },
      ]
      for (const { list, label } of checks) {
        if (list.length === 0) {
          return NextResponse.json({ error: `Generate the ${label} first.` }, { status: 409 })
        }
        const unreviewed = list.filter((x) => x.status === 'proposed' || x.status === 'needs_revision')
        if (unreviewed.length > 0) {
          return NextResponse.json(
            { error: `${unreviewed.length} ${label} still unreviewed — every design artifact needs an explicit decision.` },
            { status: 409 }
          )
        }
      }
      if (!architecture) {
        return NextResponse.json({ error: 'Generate the architecture recommendation first.' }, { status: 409 })
      }
      if (architecture.status !== 'confirmed') {
        return NextResponse.json({ error: 'The architecture recommendation must be confirmed.' }, { status: 409 })
      }

      await db.idea.update({ where: { id }, data: { stage: 'planning' } })
      await logDecision(
        id,
        'System design approved',
        `${processes.filter((p) => p.status === 'confirmed').length} processes, ${entities.filter((e) => e.status === 'confirmed').length} entities, ${apis.filter((a) => a.status === 'confirmed').length} APIs, ${screens.filter((s) => s.status === 'confirmed').length} screens confirmed`,
        'design'
      )
      const payload = await buildIdeaDetail(id)
      return NextResponse.json(payload)
    }

    // ---------- Gate 6: implementation plan approved ----------
    if (body.gate === 'planning' && body.action === 'approve') {
      if (idea.stage !== 'planning') {
        return NextResponse.json({ error: 'This gate was already passed.' }, { status: 409 })
      }
      const [tasks, risks] = await Promise.all([
        db.implTask.findMany({ where: { ideaId: id } }),
        db.riskItem.findMany({ where: { ideaId: id } }),
      ])
      if (tasks.length === 0) {
        return NextResponse.json({ error: 'Generate the implementation plan first.' }, { status: 409 })
      }
      const unreviewedTasks = tasks.filter((t) => t.status === 'proposed' || t.status === 'needs_revision')
      if (unreviewedTasks.length > 0) {
        return NextResponse.json(
          { error: `${unreviewedTasks.length} task(s) still unreviewed — every task needs an explicit decision.` },
          { status: 409 }
        )
      }
      if (risks.length === 0) {
        return NextResponse.json({ error: 'Generate the risk register first.' }, { status: 409 })
      }
      const unreviewedRisks = risks.filter((r) => r.status === 'proposed')
      if (unreviewedRisks.length > 0) {
        return NextResponse.json(
          { error: `${unreviewedRisks.length} risk(s) still unreviewed — decide mitigate or accept for each.` },
          { status: 409 }
        )
      }

      await db.idea.update({ where: { id }, data: { stage: 'readiness' } })
      await logDecision(
        id,
        'Implementation plan approved',
        `${tasks.filter((t) => t.status === 'confirmed').length} tasks, ${risks.length} risks reviewed`,
        'planning'
      )
      const payload = await buildIdeaDetail(id)
      return NextResponse.json(payload)
    }

    // ---------- Gate 7: readiness gate — lock the package ----------
    if (body.gate === 'package' && body.action === 'approve') {
      if (idea.stage !== 'readiness') {
        return NextResponse.json({ error: 'This gate was already passed.' }, { status: 409 })
      }
      const { computeReadiness } = await import('@/lib/readiness')
      const report = await computeReadiness(id)
      if (!report.lockable) {
        return NextResponse.json(
          {
            error: 'The engineering package cannot be locked while critical issues remain unresolved.',
            blockers: report.blockers,
            score: report.score,
          },
          { status: 409 }
        )
      }
      await db.idea.update({ where: { id }, data: { stage: 'package' } })
      await logDecision(
        id,
        'Readiness gate passed — engineering package locked',
        `Readiness score ${report.score}% with all hard blockers cleared`,
        'readiness'
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
