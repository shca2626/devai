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
// Site Intelligence — provide a URL, get a deep static study of
// any live web platform as a downloadable file pack.
//
//   POST { url, lang? }          -> create analysis + run recon
//   POST { analysisId, lang? }   -> run the NEXT stage (2..7)
//   GET                          -> list analyses (summaries)
//   GET    ?analysisId=...       -> one full analysis (+ pack)
//   DELETE ?analysisId=...       -> delete an analysis
//
// The target's code is never executed; robots.txt is respected;
// every claim carries evidence. The completeness score is
// computed by the application, never by the model.
// ============================================================

type Params = { params: Promise<{ id: string }> }

export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json()) as { url?: unknown; analysisId?: unknown; lang?: unknown }
    const lang = body.lang === 'en' || body.lang === 'ar' ? body.lang : 'ar'

    // Advance an existing analysis by one stage
    if (typeof body.analysisId === 'string' && body.analysisId) {
      const analysis = await advanceSiteAnalysis(id, body.analysisId, lang)
      return NextResponse.json({ analysis })
    }

    // Start a new analysis
    const url = typeof body.url === 'string' ? body.url : ''
    if (!url.trim()) {
      return NextResponse.json({ error: 'INVALID_URL' }, { status: 400 })
    }
    const analysis = await startSiteAnalysis(id, url)
    return NextResponse.json({ analysis })
  } catch (error) {
    if (error instanceof SiteIntelError) {
      const status =
        error.code === 'NOT_FOUND' ? 404 : error.code === 'UNREACHABLE' || error.code === 'BLOCKED' ? 502 : 400
      return NextResponse.json({ error: error.code, message: error.message }, { status })
    }
    console.error('[api/ideas/[id]/site-intel POST]', error)
    return NextResponse.json({ error: 'SITE_INTEL_FAILED' }, { status: 502 })
  }
}

export async function GET(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const analysisId = new URL(req.url).searchParams.get('analysisId')

    if (analysisId) {
      const analysis = await getAnalysis(id, analysisId)
      if (!analysis) return NextResponse.json({ error: 'ANALYSIS_NOT_FOUND' }, { status: 404 })
      return NextResponse.json({ analysis })
    }

    const analyses = await listAnalyses(id)
    return NextResponse.json({ analyses })
  } catch (error) {
    console.error('[api/ideas/[id]/site-intel GET]', error)
    return NextResponse.json({ error: 'SITE_INTEL_FAILED' }, { status: 502 })
  }
}

export async function DELETE(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const analysisId = new URL(req.url).searchParams.get('analysisId')
    if (!analysisId) return NextResponse.json({ error: 'ANALYSIS_NOT_FOUND' }, { status: 400 })
    const ok = await deleteAnalysis(id, analysisId)
    if (!ok) return NextResponse.json({ error: 'ANALYSIS_NOT_FOUND' }, { status: 404 })
    return NextResponse.json({ ok: true })
  } catch (error) {
    console.error('[api/ideas/[id]/site-intel DELETE]', error)
    return NextResponse.json({ error: 'SITE_INTEL_FAILED' }, { status: 502 })
  }
}
