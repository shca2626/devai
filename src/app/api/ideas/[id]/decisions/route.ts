import { NextResponse } from 'next/server'
import { createDecision, DriftError, listDecisions } from '@/lib/engines/drift'

// ============================================================
// Decision Log — the project's standing approved decisions.
//
//   GET            -> list all entries (active + superseded)
//   POST {…}       -> log a new decision (auto-coded DEC-xx)
// ============================================================

type Params = { params: Promise<{ id: string }> }

export async function GET(_req: Request, { params }: Params) {
  try {
    const { id } = await params
    const decisions = await listDecisions(id)
    return NextResponse.json({ decisions })
  } catch (error) {
    console.error('[api/ideas/[id]/decisions GET]', error)
    return NextResponse.json({ error: 'DECISIONS_FAILED' }, { status: 502 })
  }
}

export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json()) as {
      title?: unknown
      titleAr?: unknown
      choice?: unknown
      rationale?: unknown
      alternatives?: unknown
      category?: unknown
    }
    const title = typeof body.title === 'string' ? body.title : ''
    const choice = typeof body.choice === 'string' ? body.choice : ''

    if (title.trim().length < 2 || choice.trim().length < 3) {
      return NextResponse.json({ error: 'DECISION_INVALID' }, { status: 400 })
    }

    const decision = await createDecision({
      ideaId: id,
      title,
      titleAr: typeof body.titleAr === 'string' ? body.titleAr : undefined,
      choice,
      rationale: typeof body.rationale === 'string' ? body.rationale : undefined,
      alternatives: typeof body.alternatives === 'string' ? body.alternatives : undefined,
      category: typeof body.category === 'string' ? body.category : undefined,
    })
    return NextResponse.json({ decision })
  } catch (error) {
    if (error instanceof DriftError) {
      const status = error.code === 'NOT_FOUND' ? 404 : error.code === 'INVALID' ? 400 : 502
      return NextResponse.json({ error: error.code }, { status })
    }
    console.error('[api/ideas/[id]/decisions POST]', error)
    return NextResponse.json({ error: 'DECISION_FAILED' }, { status: 502 })
  }
}
