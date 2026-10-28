import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision } from '@/lib/payload'

// ============================================================
// Reopen a locked engineering package for changes. The full
// history is preserved — nothing restarts. The reason is
// recorded in the decision log; downstream gates must be
// passed again after the edits (change control, not deletion).
// ============================================================

type Params = { params: Promise<{ id: string }> }

const TARGETS = ['readiness', 'design', 'planning'] as const

export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json().catch(() => ({}))) as { to?: string; reason?: string }

    const idea = await db.idea.findUnique({ where: { id } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }
    if (idea.stage !== 'package') {
      return NextResponse.json({ error: 'Only a locked package can be reopened.' }, { status: 409 })
    }

    const to = TARGETS.find((t) => t === body.to)
    if (!to) {
      return NextResponse.json({ error: 'Invalid reopen target.' }, { status: 400 })
    }
    const reason = typeof body.reason === 'string' ? body.reason.trim().slice(0, 500) : ''

    await db.idea.update({ where: { id }, data: { stage: to } })
    await logDecision(
      id,
      `Package reopened → ${to} stage`,
      reason ? `Client reason: ${reason}` : 'No reason provided — all previous artifacts and history are preserved',
      to
    )

    const payload = await buildIdeaDetail(id)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/ideas/[id]/reopen POST]', error)
    return NextResponse.json({ error: 'Failed to reopen the package.' }, { status: 500 })
  }
}
