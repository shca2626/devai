import { NextResponse } from 'next/server'
import {
  advanceAppAnalysis,
  AppIntelError,
  deleteAppAnalysis,
  getAppAnalysis,
  listAppAnalyses,
  resumeAppAnalysis,
  resumeOrphanedAnalyses,
  startAppAnalysis,
} from '@/lib/engines/app-intel'

// ============================================================
// App Intelligence — STANDALONE mode (same pattern as
// /api/site-intel). Study any Android app from a Play Store
// URL or package name — no idea required. Analyses live in
// the workspace scope (ideaId = null) unless attached to an
// idea via the idea-scoped route.
//
//   POST { input, lang? }          -> create analysis; the ENGINE then
//                                    drives stages 2..7 server-side
//                                    (autopilot) — the UI just polls
//   POST { analysisId, lang? }     -> advance ONE stage (manual/legacy)
//   POST { analysisId, resume: true, lang? } -> resume a stalled run
//   GET                            -> list standalone analyses
//   GET    ?analysisId=...         -> one full analysis (+ pack)
//   DELETE ?analysisId=...         -> delete an analysis (+ files)
// ============================================================

export async function POST(req: Request) {
  try {
    const body = (await req.json()) as { input?: unknown; analysisId?: unknown; lang?: unknown; resume?: unknown }
    const lang = body.lang === 'en' || body.lang === 'ar' ? body.lang : 'ar'

    // Advance an existing analysis by one stage (manual/legacy — the
    // autopilot normally drives this; kept for fine-grained control)
    if (typeof body.analysisId === 'string' && body.analysisId) {
      if (body.resume === true) {
        const ok = await resumeAppAnalysis(body.analysisId, lang)
        if (!ok) return NextResponse.json({ error: 'NOT_FOUND', message: 'Analysis not found or not resumable' }, { status: 404 })
        const analysis = await getAppAnalysis(null, body.analysisId)
        return NextResponse.json({ analysis })
      }
      const analysis = await advanceAppAnalysis(null, body.analysisId, lang)
      return NextResponse.json({ analysis })
    }

    // Start a new analysis — no idea needed, just a Play URL / package.
    // The engine's autopilot takes it from here, server-side.
    const input = typeof body.input === 'string' ? body.input : ''
    if (!input.trim()) {
      return NextResponse.json({ error: 'INVALID_INPUT' }, { status: 400 })
    }
    const analysis = await startAppAnalysis(null, input, lang)
    return NextResponse.json({ analysis })
  } catch (error) {
    if (error instanceof AppIntelError) {
      const status =
        error.code === 'NOT_FOUND'
          ? 404
          : error.code === 'APP_NOT_FOUND' || error.code === 'INVALID_INPUT'
            ? 400
            : error.code === 'ACQUISITION_FAILED'
              ? 502
              : 400
      return NextResponse.json({ error: error.code, message: error.message }, { status })
    }
    console.error('[api/app-intel POST]', error)
    return NextResponse.json({ error: 'APP_INTEL_FAILED' }, { status: 502 })
  }
}

export async function GET(req: Request) {
  try {
    // any poll also self-heals runs orphaned by a server restart
    void resumeOrphanedAnalyses()
    const analysisId = new URL(req.url).searchParams.get('analysisId')

    if (analysisId) {
      const analysis = await getAppAnalysis(null, analysisId)
      if (!analysis) return NextResponse.json({ error: 'ANALYSIS_NOT_FOUND' }, { status: 404 })
      return NextResponse.json({ analysis })
    }

    const analyses = await listAppAnalyses(null)
    return NextResponse.json({ analyses })
  } catch (error) {
    console.error('[api/app-intel GET]', error)
    return NextResponse.json({ error: 'APP_INTEL_FAILED' }, { status: 502 })
  }
}

export async function DELETE(req: Request) {
  try {
    const analysisId = new URL(req.url).searchParams.get('analysisId')
    if (!analysisId) return NextResponse.json({ error: 'ANALYSIS_NOT_FOUND' }, { status: 400 })
    const ok = await deleteAppAnalysis(null, analysisId)
    if (!ok) return NextResponse.json({ error: 'ANALYSIS_NOT_FOUND' }, { status: 404 })
    return NextResponse.json({ ok: true })
  } catch (error) {
    console.error('[api/app-intel DELETE]', error)
    return NextResponse.json({ error: 'APP_INTEL_FAILED' }, { status: 502 })
  }
}
