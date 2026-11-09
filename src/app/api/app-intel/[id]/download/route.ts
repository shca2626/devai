import { promises as fs } from 'node:fs'
import path from 'node:path'
import { NextResponse } from 'next/server'
import { getAppAnalysis } from '@/lib/engines/app-intel'

// ============================================================
// Direct artifact downloads for App Intelligence:
//   GET /api/app-intel/[id]/download?type=apk|source|report|deep
//
// Serves the acquired ORIGINAL APK bundle, the decompiled source
// zip, the full report or the structured deep intel straight from
// the analysis workdir. Falls back to the durable copy in the
// repo folder app-intel/<pkg>/ when the workdir was recycled.
// ============================================================

const WORK_ROOT = path.join(process.cwd(), '.app-intel')
const REPO_INTEL_DIR = path.join(process.cwd(), 'app-intel')

function safeName(name: string) {
  return name.replace(/[^a-zA-Z0-9._-]/g, '')
}

async function resolveFile(analysisId: string, pkg: string, type: string): Promise<{ file: string; mime: string } | null> {
  const work = path.join(WORK_ROOT, analysisId)
  const repo = path.join(REPO_INTEL_DIR, pkg)

  if (type === 'apk') {
    const candidates = [
      path.join(work, `${pkg}.apks`),
      path.join(work, 'unpacked', 'base.apk'),
    ]
    // durable repo copy: app-intel/<pkg>/apk/<pkg>-<version>.apks
    try {
      const apkDir = path.join(repo, 'apk')
      for (const f of (await fs.readdir(apkDir)).filter((x) => x.endsWith('.apks'))) candidates.push(path.join(apkDir, f))
    } catch { /* none */ }
    for (const c of candidates) {
      try {
        await fs.access(c)
        return { file: c, mime: 'application/octet-stream' }
      } catch { /* next */ }
    }
    return null
  }

  if (type === 'source') {
    const candidates = [path.join(work, 'jadx-source.zip'), path.join(repo, 'source', 'jadx-source.zip')]
    for (const c of candidates) {
      try {
        await fs.access(c)
        return { file: c, mime: 'application/zip' }
      } catch { /* next */ }
    }
    return null
  }

  if (type === 'report' || type === 'deep') {
    const ext = type === 'report' ? '.md' : '.json'
    const prefix = type === 'report' ? 'report-' : 'deep-intel-'
    const candidates = [path.join(work, type === 'report' ? 'report.md' : 'deep-intel.json')]
    try {
      for (const f of (await fs.readdir(repo)).sort().reverse()) {
        if (f.startsWith(prefix) && f.endsWith(ext)) candidates.push(path.join(repo, f))
      }
    } catch { /* none */ }
    for (const c of candidates) {
      try {
        await fs.access(c)
        return { file: c, mime: type === 'report' ? 'text/markdown; charset=utf-8' : 'application/json' }
      } catch { /* next */ }
    }
    return null
  }

  return null
}

export async function GET(req: Request, { params }: { params: Promise<{ id: string }> }) {
  try {
    const { id } = await params
    const analysisId = safeName(id)
    const type = new URL(req.url).searchParams.get('type') ?? 'report'

    const analysis = await getAppAnalysis(null, analysisId)
    if (!analysis) return NextResponse.json({ error: 'ANALYSIS_NOT_FOUND' }, { status: 404 })

    const resolved = await resolveFile(analysisId, analysis.pkg, type)
    if (!resolved) {
      return NextResponse.json({ error: 'ARTIFACT_NOT_FOUND', message: `No ${type} artifact stored for this analysis.` }, { status: 404 })
    }

    const buf = await fs.readFile(resolved.file)
    const ext = resolved.file.endsWith('.apks') ? '.apks' : resolved.file.endsWith('.zip') ? '.zip' : resolved.file.endsWith('.json') ? '.json' : '.md'
    const base = safeName(analysis.pkg || 'app')
    return new NextResponse(new Uint8Array(buf), {
      headers: {
        'Content-Type': resolved.mime,
        'Content-Length': String(buf.length),
        'Content-Disposition': `attachment; filename="${base}-${type}${ext}"`,
        'Cache-Control': 'private, max-age=3600',
      },
    })
  } catch (error) {
    console.error('[api/app-intel/download GET]', error)
    return NextResponse.json({ error: 'DOWNLOAD_FAILED' }, { status: 502 })
  }
}
