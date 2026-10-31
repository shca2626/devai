import { NextResponse } from 'next/server'
import {
  advanceSiteAnalysis,
  deleteAnalysis,
  getAnalysis,
  listAnalyses,
  SiteIntelError,
  startSiteAnalysis,
} from '@/lib/engines/site-intel'

// ============================================================
// Site Intelligence — STANDALONE mode.
//
// Same engine and stages as /api/ideas/[id]/site-intel, but no
// idea is required: anyone can study any public site by URL the
// moment the app opens. Analyses live in the workspace scope
// (ideaId = null) so they never collide with idea-linked studies.
//
//   POST { url, lang? }          -> create analysis + run recon
//   POST { analysisId, lang? }   -> run the NEXT stage (2..7)
//   GET                          -> list standalone analyses
//   GET    ?analysisId=...       -> one full analysis (+ pack)
//   DELETE ?analysisId=...       -> delete an analysis
// ============================================================

export async function POST(req: Request) {
  try {
    const body = (await req.json()) as { url?: unknown; analysisId?: unknown; lang?: unknown }
    const lang = body.lang === 'en' || body.lang === 'ar' ? body.lang : 'ar'

    // Advance an existing analysis by one stage
    if (typeof body.analysisId === 'string' && body.analysisId) {
      const analysis = await advanceSiteAnalysis(null, body.analysisId, lang)
      return NextResponse.json({ analysis })
    }

    // Start a new analysis — no idea needed, just a URL
    const url = typeof body.url === 'string' ? body.url : ''
    if (!url.trim()) {
      return NextResponse.json({ error: 'INVALID_URL' }, { status: 400 })
    }
    const analysis = await startSiteAnalysis(null, url)
    return NextResponse.json({ analysis })
  } catch (error) {
    if (error instanceof SiteIntelError) {
      const status =
        error.code === 'NOT_FOUND' ? 404 : error.code === 'UNREACHABLE' || error.code === 'BLOCKED' ? 502 : 400
      return NextResponse.json({ error: error.code, message: error.message }, { status })
    }
    console.error('[api/site-intel POST]', error)
    return NextResponse.json({ error: 'SITE_INTEL_FAILED' }, { status: 502 })
  }
}

export async function GET(req: Request) {
  try {
    const analysisId = new URL(req.url).searchParams.get('analysisId')

    if (analysisId) {
      const analysis = await getAnalysis(null, analysisId)
      if (!analysis) return NextResponse.json({ error: 'ANALYSIS_NOT_FOUND' }, { status: 404 })
      return NextResponse.json({ analysis })
    }

    const analyses = await listAnalyses(null)
    return NextResponse.json({ analyses })
  } catch (error) {
    console.error('[api/site-intel GET]', error)
    return NextResponse.json({ error: 'SITE_INTEL_FAILED' }, { status: 502 })
  }
}

export async function DELETE(req: Request) {
  try {
    const analysisId = new URL(req.url).searchParams.get('analysisId')
    if (!analysisId) return NextResponse.json({ error: 'ANALYSIS_NOT_FOUND' }, { status: 400 })
    const ok = await deleteAnalysis(null, analysisId)
    if (!ok) return NextResponse.json({ error: 'ANALYSIS_NOT_FOUND' }, { status: 404 })
    return NextResponse.json({ ok: true })
  } catch (error) {
    console.error('[api/site-intel DELETE]', error)
    return NextResponse.json({ error: 'SITE_INTEL_FAILED' }, { status: 502 })
  }
}
