import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision } from '@/lib/payload'
import { STAGES, type Stage } from '@/lib/types'

// ============================================================
// Reopen / move an idea to ANY stage. NO LIMITS:
//   - works from ANY current stage (not only a locked package)
//   - the target can be ANY of the 9 workflow stages
// The full history is preserved — nothing restarts. The move is
// recorded in the decision log.
// ============================================================

type Params = { params: Promise<{ id: string }> }

export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json().catch(() => ({}))) as { to?: string; reason?: string }

    const idea = await db.idea.findUnique({ where: { id } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }

    const to = STAGES.find((s) => s === body.to) as Stage | undefined
    if (!to) {
      return NextResponse.json(
        { error: `Invalid target stage. Use one of: ${STAGES.join(', ')}.` },
        { status: 400 }
      )
    }
    const reason = typeof body.reason === 'string' ? body.reason.trim().slice(0, 500) : ''

    await db.idea.update({ where: { id }, data: { stage: to } })
    await logDecision(
      id,
      `Stage moved: ${idea.stage} → ${to}`,
      reason ? `Reason: ${reason}` : 'No reason provided — all artifacts and history are preserved',
      to
    )

    const payload = await buildIdeaDetail(id)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/ideas/[id]/reopen POST]', error)
    return NextResponse.json({ error: 'Failed to move the idea to the requested stage.' }, { status: 500 })
  }
}
