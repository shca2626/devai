import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision } from '@/lib/payload'

type Params = { params: Promise<{ id: string }> }

// Confirm or reject an assumption in the register.
export async function PATCH(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json()) as { status?: 'confirmed' | 'rejected' }

    const existing = await db.assumption.findUnique({ where: { id } })
    if (!existing) {
      return NextResponse.json({ error: 'Assumption not found' }, { status: 404 })
    }
    if (body.status !== 'confirmed' && body.status !== 'rejected') {
      return NextResponse.json({ error: 'Invalid status.' }, { status: 400 })
    }

    await db.assumption.update({ where: { id }, data: { status: body.status } })
    await logDecision(
      existing.ideaId,
      body.status === 'confirmed' ? `Assumption confirmed: ${existing.text}` : `Assumption rejected: ${existing.text}`,
      existing.kind === 'uncertain' ? 'Open risk from discovery' : 'Tentative interpretation',
      undefined
    )

    const payload = await buildIdeaDetail(existing.ideaId)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/assumptions/[id] PATCH]', error)
    return NextResponse.json({ error: 'Failed to update the assumption.' }, { status: 500 })
  }
}
