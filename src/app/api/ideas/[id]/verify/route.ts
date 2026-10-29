import { NextResponse } from 'next/server'
import { deleteRun, getRun, listRuns, runVerification, VerifyError } from '@/lib/engines/verify'

// ============================================================
// Traceability Verifier — paste AI-generated code, verify it
// against the project's confirmed requirements (or accepted
// features) + enabled constitution rules.
//
//   POST   { code, label?, lang? }  -> run verification
//   GET                        -> list past runs (summaries)
//   GET    ?runId=...          -> one full run (result matrix)
//   DELETE ?runId=...          -> delete a run
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

    const run = await runVerification({ ideaId: id, code, label, lang })
    return NextResponse.json({ run })
  } catch (error) {
    if (error instanceof VerifyError) {
      const status = error.code === 'NOT_FOUND' ? 404 : error.code === 'NOTHING_TO_VERIFY' ? 409 : 400
      return NextResponse.json({ error: error.code }, { status })
    }
    console.error('[api/ideas/[id]/verify POST]', error)
    return NextResponse.json({ error: 'VERIFY_FAILED' }, { status: 502 })
  }
}

export async function GET(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const runId = new URL(req.url).searchParams.get('runId')

    if (runId) {
      const run = await getRun(id, runId)
      if (!run) return NextResponse.json({ error: 'RUN_NOT_FOUND' }, { status: 404 })
      return NextResponse.json({ run })
    }

    const runs = (await listRuns(id)).map((r) => ({
      id: r.id,
      label: r.label,
      codeChars: r.codeChars,
      score: r.score,
      counts: r.counts,
      createdAt: r.createdAt,
    }))
    return NextResponse.json({ runs })
  } catch (error) {
    console.error('[api/ideas/[id]/verify GET]', error)
    return NextResponse.json({ error: 'VERIFY_FAILED' }, { status: 502 })
  }
}

export async function DELETE(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const runId = new URL(req.url).searchParams.get('runId')
    if (!runId) return NextResponse.json({ error: 'RUN_NOT_FOUND' }, { status: 400 })
    const ok = await deleteRun(id, runId)
    if (!ok) return NextResponse.json({ error: 'RUN_NOT_FOUND' }, { status: 404 })
    return NextResponse.json({ ok: true })
  } catch (error) {
    console.error('[api/ideas/[id]/verify DELETE]', error)
    return NextResponse.json({ error: 'VERIFY_FAILED' }, { status: 502 })
  }
}
