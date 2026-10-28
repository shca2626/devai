import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision } from '@/lib/payload'
import { FEATURE_STATUSES, PRIORITIES } from '@/lib/types'
import type { FeatureStatus, Priority } from '@/lib/types'

type Params = { params: Promise<{ id: string }> }

const ACTION_LABELS: Record<string, string> = {
  accepted: 'Accepted',
  rejected: 'Rejected',
  deferred: 'Deferred',
  proposed: 'Reset to proposed',
  needs_confirmation: 'Reset to needs confirmation',
}

// Update a feature (status decision, inline edit) or delete it.
// Locked once the baseline was approved.
export async function PATCH(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json()) as {
      status?: string
      module?: string
      feature?: string
      user?: string
      priority?: string
      rationale?: string
    }

    const existing = await db.feature.findUnique({ where: { id } })
    if (!existing) {
      return NextResponse.json({ error: 'Feature not found' }, { status: 404 })
    }
    const idea = await db.idea.findUnique({ where: { id: existing.ideaId } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }
    if (idea.stage === 'baseline') {
      return NextResponse.json(
        { error: 'The baseline was approved — the feature list is locked.' },
        { status: 409 }
      )
    }

    const updates: Record<string, unknown> = {}
    if (body.status !== undefined) {
      if (!FEATURE_STATUSES.includes(body.status as FeatureStatus)) {
        return NextResponse.json({ error: 'Invalid status.' }, { status: 400 })
      }
      updates.status = body.status
    }
    if (body.module !== undefined && body.module.trim()) updates.module = body.module.trim().slice(0, 60)
    if (body.feature !== undefined && body.feature.trim()) updates.feature = body.feature.trim().slice(0, 160)
    if (body.user !== undefined && body.user.trim()) updates.user = body.user.trim().slice(0, 60)
    if (body.priority !== undefined && PRIORITIES.includes(body.priority as Priority)) {
      updates.priority = body.priority
    }
    if (body.rationale !== undefined) updates.rationale = body.rationale.trim().slice(0, 300) || null

    await db.feature.update({ where: { id }, data: updates })

    if (updates.status && updates.status !== existing.status) {
      await logDecision(
        existing.ideaId,
        `${ACTION_LABELS[updates.status as string] ?? 'Updated'} feature: ${existing.feature}`,
        `Priority: ${String(updates.priority ?? existing.priority)}`,
        'features'
      )
    } else if (Object.keys(updates).length > 0 && updates.status === undefined) {
      await logDecision(existing.ideaId, `Edited feature: ${existing.feature}`, undefined, 'features')
    }

    const payload = await buildIdeaDetail(existing.ideaId)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/features/[id] PATCH]', error)
    return NextResponse.json({ error: 'Failed to update the feature.' }, { status: 500 })
  }
}

export async function DELETE(_req: Request, { params }: Params) {
  try {
    const { id } = await params
    const existing = await db.feature.findUnique({ where: { id } })
    if (!existing) {
      return NextResponse.json({ error: 'Feature not found' }, { status: 404 })
    }
    const idea = await db.idea.findUnique({ where: { id: existing.ideaId } })
    if (idea?.stage === 'baseline') {
      return NextResponse.json(
        { error: 'The baseline was approved — the feature list is locked.' },
        { status: 409 }
      )
    }
    await db.feature.delete({ where: { id } })
    await logDecision(existing.ideaId, `Removed feature: ${existing.feature}`, undefined, 'features')
    const payload = await buildIdeaDetail(existing.ideaId)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/features/[id] DELETE]', error)
    return NextResponse.json({ error: 'Failed to delete the feature.' }, { status: 500 })
  }
}
