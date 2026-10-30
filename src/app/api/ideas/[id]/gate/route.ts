import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, buildBaselineSnapshot, logDecision, parseInterpretation } from '@/lib/payload'
import { generateQuestions, type AnsweredItem } from '@/lib/engines/discover'
import { AREAS, STAGES, stageIndex, type Stage } from '@/lib/types'

// ============================================================
// Approval gates — NO LIMITS MODE.
// Gates are stage ADVANCERS, never blockers:
//   - They succeed from ANY current stage (forward or re-run).
//   - Unreviewed items are auto-accepted by default (the client
//     can still pass unreviewedAction to defer/reject in bulk).
//   - Missing artifacts never block — the snapshot is built from
//     whatever exists.
//   - The readiness score is computed and logged for honesty,
//     but it can never block locking the package.
// Every transition is still logged to the decision history.
// ============================================================

type Params = { params: Promise<{ id: string }> }

async function answeredItems(ideaId: string): Promise<AnsweredItem[]> {
  const questions = await db.question.findMany({
    where: { ideaId, status: 'answered' },
    orderBy: [{ order: 'asc' }, { createdAt: 'asc' }],
  })
  return questions.map((q) => ({ area: q.area, questionEn: q.questionEn, answer: q.answer ?? '' }))
}

// Move the idea FORWARD to the target stage only; never move it back.
async function advanceStage(id: string, current: string, target: Stage): Promise<string> {
  if (stageIndex(current as Stage) < stageIndex(target)) {
    await db.idea.update({ where: { id }, data: { stage: target } })
    return target
  }
  return current
}

export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json().catch(() => ({}))) as {
      gate?: 'interpretation' | 'baseline' | 'engineering_start' | 'requirements' | 'design' | 'planning' | 'package'
      action?: 'approve'
      unreviewedAction?: 'accept' | 'defer' | 'reject'
    }

    const idea = await db.idea.findUnique({ where: { id } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }

    const unreviewedChoice = body.unreviewedAction ?? 'accept'

    // ---------- Gate 1: interpretation approval ----------
    if (body.gate === 'interpretation' && body.action === 'approve') {
      // Generate discovery questions if none exist yet
      const existing = await db.question.count({ where: { ideaId: id } })
      if (existing === 0) {
        const interpretation = parseInterpretation(idea.interpretation)
        if (interpretation) {
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
        }
      }

      await advanceStage(id, idea.stage, 'discovery')
      await logDecision(id, 'Interpretation approved — discovery started', 'No-limits mode: gate always passes', 'understanding')

      const payload = await buildIdeaDetail(id)
      return NextResponse.json(payload)
    }

    // ---------- Gate 2: feature baseline approval ----------
    if (body.gate === 'baseline' && body.action === 'approve') {
      const features = await db.feature.findMany({ where: { ideaId: id } })

      // Auto-decide unreviewed features (default: accept)
      const map: Record<string, string> = { accept: 'accepted', defer: 'deferred', reject: 'rejected' }
      const unreviewed = features.filter((f) => f.status === 'proposed' || f.status === 'needs_confirmation')
      if (unreviewed.length > 0 && map[unreviewedChoice]) {
        await db.feature.updateMany({
          where: { ideaId: id, status: { in: ['proposed', 'needs_confirmation'] } },
          data: { status: map[unreviewedChoice] },
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

      // Never move a project backwards — only forward to 'baseline'
      const nextStage = stageIndex(idea.stage as Stage) < stageIndex('baseline') ? 'baseline' : (idea.stage as Stage)
      await db.idea.update({
        where: { id },
        data: { stage: nextStage, baseline: JSON.stringify(snapshot) },
      })
      await logDecision(
        id,
        'Feature baseline approved',
        `Accepted ${counts.accepted}, deferred ${counts.deferred}, rejected ${counts.rejected}${
          unreviewed.length > 0 ? `. Unreviewed features were bulk-${unreviewedChoice}ed.` : ''
        }`,
        'features'
      )

      const payload = await buildIdeaDetail(id)
      return NextResponse.json(payload)
    }

    // ---------- Gate 3: start the engineering track ----------
    if (body.gate === 'engineering_start' && body.action === 'approve') {
      const stage = await advanceStage(id, idea.stage, 'requirements')
      await logDecision(
        id,
        'Engineering track started',
        'The client moved from the discovery baseline to requirements engineering',
        stage === 'requirements' ? 'baseline' : idea.stage
      )
      const payload = await buildIdeaDetail(id)
      return NextResponse.json(payload)
    }

    // ---------- Gate 4: requirements approved ----------
    if (body.gate === 'requirements' && body.action === 'approve') {
      const requirements = await db.requirement.findMany({ where: { ideaId: id } })

      // Auto-decide unreviewed requirements (default: confirm)
      const map: Record<string, string> = { accept: 'confirmed', defer: 'unresolved', reject: 'rejected' }
      const unreviewed = requirements.filter((r) => r.status === 'proposed')
      if (unreviewed.length > 0 && map[unreviewedChoice]) {
        await db.requirement.updateMany({
          where: { ideaId: id, status: 'proposed' },
          data: { status: map[unreviewedChoice] },
        })
      }

      const finalRequirements = await db.requirement.findMany({ where: { ideaId: id } })
      await advanceStage(id, idea.stage, 'design')
      await logDecision(
        id,
        'Requirements specification approved',
        `${finalRequirements.filter((r) => r.status === 'confirmed').length} confirmed, ${finalRequirements.filter((r) => r.status === 'unresolved').length} unresolved (tracked), ${finalRequirements.filter((r) => r.status === 'rejected').length} rejected`,
        'requirements'
      )
      const payload = await buildIdeaDetail(id)
      return NextResponse.json(payload)
    }

    // ---------- Gate 5: system design approved ----------
    if (body.gate === 'design' && body.action === 'approve') {
      // Auto-confirm every unreviewed design artifact
      await db.processFlow.updateMany({ where: { ideaId: id, status: { in: ['proposed', 'needs_revision'] } }, data: { status: 'confirmed' } })
      await db.dataEntity.updateMany({ where: { ideaId: id, status: { in: ['proposed', 'needs_revision'] } }, data: { status: 'confirmed' } })
      await db.apiEndpoint.updateMany({ where: { ideaId: id, status: { in: ['proposed', 'needs_revision'] } }, data: { status: 'confirmed' } })
      await db.screenSpec.updateMany({ where: { ideaId: id, status: { in: ['proposed', 'needs_revision'] } }, data: { status: 'confirmed' } })
      const arch = await db.architectureDoc.findUnique({ where: { ideaId: id } })
      if (arch && arch.status !== 'confirmed') {
        await db.architectureDoc.update({ where: { ideaId: id }, data: { status: 'confirmed' } })
      }

      const [processes, entities, apis, screens] = await Promise.all([
        db.processFlow.findMany({ where: { ideaId: id } }),
        db.dataEntity.findMany({ where: { ideaId: id } }),
        db.apiEndpoint.findMany({ where: { ideaId: id } }),
        db.screenSpec.findMany({ where: { ideaId: id } }),
      ])

      await advanceStage(id, idea.stage, 'planning')
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
      // Auto-confirm unreviewed tasks; auto-decide unreviewed risks
      await db.implTask.updateMany({ where: { ideaId: id, status: { in: ['proposed', 'needs_revision'] } }, data: { status: 'confirmed' } })
      const riskStatus = unreviewedChoice === 'reject' ? 'accepted' : 'mitigated'
      await db.riskItem.updateMany({ where: { ideaId: id, status: 'proposed' }, data: { status: riskStatus } })

      const [tasks, risks] = await Promise.all([
        db.implTask.findMany({ where: { ideaId: id } }),
        db.riskItem.findMany({ where: { ideaId: id } }),
      ])

      await advanceStage(id, idea.stage, 'readiness')
      await logDecision(
        id,
        'Implementation plan approved',
        `${tasks.filter((t) => t.status === 'confirmed').length} tasks, ${risks.length} risks reviewed (auto-${riskStatus})`,
        'planning'
      )
      const payload = await buildIdeaDetail(id)
      return NextResponse.json(payload)
    }

    // ---------- Gate 7: readiness gate — lock the package ----------
    if (body.gate === 'package' && body.action === 'approve') {
      const { computeReadiness } = await import('@/lib/readiness')
      const report = await computeReadiness(id)
      // NO LIMITS: the score is logged for honesty, but never blocks.
      await db.idea.update({ where: { id }, data: { stage: 'package' } })
      await logDecision(
        id,
        'Readiness gate passed — engineering package locked',
        `No-limits mode: locked at readiness score ${report.score}%${report.blockers.length > 0 ? ` (blockers bypassed: ${report.blockers.length})` : ' with all hard blockers cleared'}`,
        'readiness'
      )
      const payload = await buildIdeaDetail(id)
      return NextResponse.json(payload)
    }

    return NextResponse.json({ error: 'Unknown gate or action.', status: 400 }, { status: 400 })
  } catch (error) {
    console.error('[api/ideas/[id]/gate POST]', error)
    return NextResponse.json(
      { error: 'The AI service failed while opening the next stage. Please try again.' },
      { status: 502 }
    )
  }
}
