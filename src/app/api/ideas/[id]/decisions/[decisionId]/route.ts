import { NextResponse } from 'next/server'
import { deleteDecision, DriftError, updateDecision } from '@/lib/engines/drift'

// ============================================================
// Decision Log — single entry.
//
//   PATCH  {…}       -> edit fields / change status (retire, reactivate)
//   DELETE           -> remove the entry
// ============================================================

type Params = { params: Promise<{ id: string; decisionId: string }> }

export async function PATCH(req: Request, { params }: Params) {
  try {
    const { id, decisionId } = await params
    const body = (await req.json()) as {
      title?: unknown
      titleAr?: unknown
      choice?: unknown
      rationale?: unknown
      alternatives?: unknown
      category?: unknown
      status?: unknown
    }

    const decision = await updateDecision(id, decisionId, {
      title: typeof body.title === 'string' ? body.title : undefined,
      titleAr: body.titleAr === undefined ? undefined : typeof body.titleAr === 'string' ? body.titleAr : null,
      choice: typeof body.choice === 'string' ? body.choice : undefined,
      rationale: body.rationale === undefined ? undefined : typeof body.rationale === 'string' ? body.rationale : null,
      alternatives:
        body.alternatives === undefined ? undefined : typeof body.alternatives === 'string' ? body.alternatives : null,
      category: typeof body.category === 'string' ? body.category : undefined,
      status: typeof body.status === 'string' ? body.status : undefined,
    })
    if (!decision) return NextResponse.json({ error: 'DECISION_NOT_FOUND' }, { status: 404 })
    return NextResponse.json({ decision })
  } catch (error) {
    if (error instanceof DriftError) {
      const status = error.code === 'NOT_FOUND' ? 404 : error.code === 'INVALID' ? 400 : 502
      return NextResponse.json({ error: error.code }, { status })
    }
    console.error('[api/ideas/[id]/decisions/[decisionId] PATCH]', error)
    return NextResponse.json({ error: 'DECISION_FAILED' }, { status: 502 })
  }
}

export async function DELETE(_req: Request, { params }: Params) {
  try {
    const { id, decisionId } = await params
    const ok = await deleteDecision(id, decisionId)
    if (!ok) return NextResponse.json({ error: 'DECISION_NOT_FOUND' }, { status: 404 })
    return NextResponse.json({ ok: true })
  } catch (error) {
    if (error instanceof DriftError) {
      const status = error.code === 'NOT_FOUND' ? 404 : 502
      return NextResponse.json({ error: error.code }, { status })
    }
    console.error('[api/ideas/[id]/decisions/[decisionId] DELETE]', error)
    return NextResponse.json({ error: 'DECISION_FAILED' }, { status: 502 })
  }
}
