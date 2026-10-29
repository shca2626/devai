import { NextResponse } from 'next/server'
import { deleteCheck, DriftError, getCheck, listChecks, runDriftCheck } from '@/lib/engines/drift'

// ============================================================
// Drift Detector — paste AI-generated code, check it against the
// project's active approved decisions.
//
//   POST   { code, label?, lang? }  -> run drift check
//   GET                        -> list past checks (summaries)
//   GET    ?checkId=...        -> one full check (result matrix)
//   DELETE ?checkId=...        -> delete a check
// ============================================================

type Params = { params: Promise<{ id: string }> }

export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json()) as { code?: unknown; label?: unknown; lang?: unknown }
    const code = typeof body.code === 'string' ? body.code : ''
    const label = typeof body.label === 'string' ? body.label : undefined
    const lang = body.lang === 'ar' || body.lang === 'en' ? body.lang : 'ar'

    if (code.trim().length < 30) {
      return NextResponse.json({ error: 'CODE_TOO_SHORT' }, { status: 400 })
    }

    const check = await runDriftCheck({ ideaId: id, code, label, lang })
    return NextResponse.json({ check })
  } catch (error) {
    if (error instanceof DriftError) {
      const status =
        error.code === 'NOT_FOUND' ? 404 : error.code === 'NOTHING_TO_CHECK' ? 409 : error.code === 'INVALID' ? 400 : 400
      return NextResponse.json({ error: error.code }, { status })
    }
    console.error('[api/ideas/[id]/drift POST]', error)
    return NextResponse.json({ error: 'DRIFT_FAILED' }, { status: 502 })
  }
}

export async function GET(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const checkId = new URL(req.url).searchParams.get('checkId')

    if (checkId) {
      const check = await getCheck(id, checkId)
      if (!check) return NextResponse.json({ error: 'CHECK_NOT_FOUND' }, { status: 404 })
      return NextResponse.json({ check })
    }

    const checks = (await listChecks(id)).map((c) => ({
      id: c.id,
      label: c.label,
      codeChars: c.codeChars,
      drifts: c.drifts,
      alignment: c.alignment,
      counts: c.counts,
      createdAt: c.createdAt,
    }))
    return NextResponse.json({ checks })
  } catch (error) {
    console.error('[api/ideas/[id]/drift GET]', error)
    return NextResponse.json({ error: 'DRIFT_FAILED' }, { status: 502 })
  }
}

export async function DELETE(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const checkId = new URL(req.url).searchParams.get('checkId')
    if (!checkId) return NextResponse.json({ error: 'CHECK_NOT_FOUND' }, { status: 400 })
    const ok = await deleteCheck(id, checkId)
    if (!ok) return NextResponse.json({ error: 'CHECK_NOT_FOUND' }, { status: 404 })
    return NextResponse.json({ ok: true })
  } catch (error) {
    console.error('[api/ideas/[id]/drift DELETE]', error)
    return NextResponse.json({ error: 'DRIFT_FAILED' }, { status: 502 })
  }
}
