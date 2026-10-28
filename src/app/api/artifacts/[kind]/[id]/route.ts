import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision } from '@/lib/payload'
import { previewImpact, applyImpact } from '@/lib/impact'

// ============================================================
// Artifact review — the ONLY way an artifact changes status.
// Approval is always explicit; silence never counts.
//
// When a previously CONFIRMED requirement is changed (edited,
// rejected or marked unresolved) AFTER downstream design exists,
// the route refuses to silently edit documents: it first returns
// the change-impact preview (409) and requires an explicit
// confirmation, then marks every affected artifact for revision.
// ============================================================

type Params = { params: Promise<{ kind: string; id: string }> }

const REQ_STATUSES = ['proposed', 'confirmed', 'rejected', 'unresolved']
const REVIEW_STATUSES = ['proposed', 'confirmed', 'rejected', 'needs_revision']
const RISK_STATUSES = ['proposed', 'mitigated', 'accepted']
const ISSUE_STATUSES = ['open', 'resolved', 'dismissed']

export async function PATCH(req: Request, { params }: Params) {
  try {
    const { kind, id } = await params
    const body = (await req.json().catch(() => ({}))) as {
      status?: string
      edits?: { title?: string; description?: string; priority?: string; acceptanceCriteria?: string[] }
      confirmImpact?: boolean
    }

    // ---------- Requirements (with change-impact control) ----------
    if (kind === 'requirement') {
      const req = await db.requirement.findUnique({ where: { id } })
      if (!req) return NextResponse.json({ error: 'Requirement not found' }, { status: 404 })
      const idea = await db.idea.findUnique({ where: { id: req.ideaId } })
      if (!idea) return NextResponse.json({ error: 'Idea not found' }, { status: 404 })

      const hasEdits = body.edits && Object.values(body.edits).some((v) => v !== undefined)
      const statusChanged = body.status && body.status !== req.status
      if (!statusChanged && !hasEdits) {
        return NextResponse.json({ error: 'Nothing to update.' }, { status: 400 })
      }
      if (body.status && !REQ_STATUSES.includes(body.status)) {
        return NextResponse.json({ error: 'Invalid requirement status.' }, { status: 400 })
      }

      const wasConfirmed = req.status === 'confirmed'
      const downstreamExists = ['design', 'planning', 'readiness', 'package'].includes(idea.stage)
      const [downstreams] = await Promise.all([db.processFlow.count({ where: { ideaId: req.ideaId } })])
      const changeDescription =
        statusChanged && body.status !== 'confirmed'
          ? `status ${req.status} → ${body.status}`
          : hasEdits
            ? 'content edited'
            : `status → ${body.status}`

      // A confirmed requirement being changed while downstream artifacts exist → impact control
      if (wasConfirmed && downstreamExists && downstreams > 0 && (statusChanged || hasEdits) && !body.confirmImpact) {
        const preview = await previewImpact(req.ideaId, id, changeDescription)
        if (preview && preview.affected.length > 0) {
          return NextResponse.json(
            {
              error: 'This requirement is confirmed and downstream artifacts derive from it. Review the impact before applying.',
              impact: preview,
            },
            { status: 409 }
          )
        }
      }

      if (wasConfirmed && (statusChanged || hasEdits) && body.confirmImpact) {
        const marked = await applyImpact(req.ideaId, id, changeDescription)
        await logDecision(
          req.ideaId,
          `Confirmed requirement ${req.code} changed`,
          `${changeDescription} — ${marked} downstream artifact(s) marked for revision`,
          idea.stage
        )
      }

      const data: Record<string, string | null> = {}
      if (body.status) data.status = body.status
      if (body.edits?.title) data.title = body.edits.title
      if (body.edits?.description) data.description = body.edits.description
      if (body.edits?.priority && ['must', 'should', 'could'].includes(body.edits.priority)) data.priority = body.edits.priority
      if (body.edits?.acceptanceCriteria) data.acceptanceCriteria = JSON.stringify(body.edits.acceptanceCriteria)
      await db.requirement.update({ where: { id }, data })

      if (!wasConfirmed || !body.confirmImpact) {
        await logDecision(
          req.ideaId,
          `Requirement ${req.code} ${body.status ? `→ ${body.status}` : 'edited'}`,
          hasEdits ? 'Content updated by the client' : undefined,
          idea.stage
        )
      }

      const payload = await buildIdeaDetail(req.ideaId)
      return NextResponse.json(payload)
    }

    // ---------- Design & planning artifacts ----------
    if (['process', 'entity', 'api', 'screen', 'task'].includes(kind)) {
      const record =
        kind === 'process'
          ? await db.processFlow.findUnique({ where: { id } })
          : kind === 'entity'
            ? await db.dataEntity.findUnique({ where: { id } })
            : kind === 'api'
              ? await db.apiEndpoint.findUnique({ where: { id } })
              : kind === 'screen'
                ? await db.screenSpec.findUnique({ where: { id } })
                : await db.implTask.findUnique({ where: { id } })
      if (!record) return NextResponse.json({ error: 'Artifact not found' }, { status: 404 })
      const ideaId = (record as { ideaId: string }).ideaId
      const code = (record as { code: string }).code
      if (!body.status || !REVIEW_STATUSES.includes(body.status)) {
        return NextResponse.json({ error: 'Invalid status.' }, { status: 400 })
      }
      if (kind === 'process') await db.processFlow.update({ where: { id }, data: { status: body.status } })
      else if (kind === 'entity') await db.dataEntity.update({ where: { id }, data: { status: body.status } })
      else if (kind === 'api') await db.apiEndpoint.update({ where: { id }, data: { status: body.status } })
      else if (kind === 'screen') await db.screenSpec.update({ where: { id }, data: { status: body.status } })
      else await db.implTask.update({ where: { id }, data: { status: body.status } })

      const label = kind === 'process' ? 'Process' : kind === 'entity' ? 'Entity' : kind === 'api' ? 'API endpoint' : kind === 'screen' ? 'Screen' : 'Task'
      await logDecision(ideaId, `${label} ${code} → ${body.status}`, undefined, undefined)
      const payload = await buildIdeaDetail(ideaId)
      return NextResponse.json(payload)
    }

    // ---------- Risks ----------
    if (kind === 'risk') {
      const risk = await db.riskItem.findUnique({ where: { id } })
      if (!risk) return NextResponse.json({ error: 'Risk not found' }, { status: 404 })
      if (!body.status || !RISK_STATUSES.includes(body.status)) {
        return NextResponse.json({ error: 'Invalid risk status.' }, { status: 400 })
      }
      await db.riskItem.update({ where: { id }, data: { status: body.status } })
      await logDecision(risk.ideaId, `Risk ${risk.code} → ${body.status}`, risk.description.slice(0, 120), undefined)
      const payload = await buildIdeaDetail(risk.ideaId)
      return NextResponse.json(payload)
    }

    // ---------- Consistency issues ----------
    if (kind === 'issue') {
      const issue = await db.consistencyIssue.findUnique({ where: { id } })
      if (!issue) return NextResponse.json({ error: 'Issue not found' }, { status: 404 })
      if (!body.status || !ISSUE_STATUSES.includes(body.status)) {
        return NextResponse.json({ error: 'Invalid issue status.' }, { status: 400 })
      }
      await db.consistencyIssue.update({ where: { id }, data: { status: body.status } })
      await logDecision(issue.ideaId, `Consistency issue ${issue.kind} → ${body.status}`, issue.description.slice(0, 140), 'readiness')
      const payload = await buildIdeaDetail(issue.ideaId)
      return NextResponse.json(payload)
    }

    // ---------- Architecture ----------
    if (kind === 'architecture') {
      const arch = await db.architectureDoc.findUnique({ where: { id } })
      if (!arch) return NextResponse.json({ error: 'Architecture not found' }, { status: 404 })
      if (!body.status || !REVIEW_STATUSES.includes(body.status)) {
        return NextResponse.json({ error: 'Invalid status.' }, { status: 400 })
      }
      await db.architectureDoc.update({ where: { id }, data: { status: body.status } })
      await logDecision(arch.ideaId, `Architecture recommendation → ${body.status}`, undefined, 'design')
      const payload = await buildIdeaDetail(arch.ideaId)
      return NextResponse.json(payload)
    }

    return NextResponse.json({ error: 'Unknown artifact kind.' }, { status: 400 })
  } catch (error) {
    console.error('[api/artifacts/[kind]/[id] PATCH]', error)
    return NextResponse.json({ error: 'Failed to update the artifact.' }, { status: 500 })
  }
}
