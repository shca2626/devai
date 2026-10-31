import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { STAGES } from '@/lib/types'
import fs from 'node:fs'
import { listAdminTables } from '@/lib/admin/registry'

// ============================================================
// GET /api/admin/overview — the admin dashboard payload:
//   - per-table record counts (all 28 models)
//   - ideas grouped by workflow stage
//   - database file size + engine info
//   - environment / runtime info
//   - latest activity (audit trail) across all ideas
//   - AI gateway status
// ============================================================

export async function GET() {
  try {
    const tables = listAdminTables()

    const countsEntries = await Promise.all(
      tables.map(async (t) => [t.name, await t.delegate.count()] as const)
    )
    const counts = Object.fromEntries(countsEntries) as Record<string, number>

    const ideas = await db.idea.findMany({
      select: { id: true, stage: true, title: true, updatedAt: true, projectType: true, sourceLang: true },
      orderBy: { updatedAt: 'desc' },
    })
    const byStage: Record<string, number> = {}
    for (const s of STAGES) byStage[s] = 0
    for (const i of ideas) byStage[i.stage] = (byStage[i.stage] ?? 0) + 1

    const recentActivity = await db.decision.findMany({
      orderBy: { createdAt: 'desc' },
      take: 15,
      select: { id: true, ideaId: true, action: true, detail: true, stage: true, createdAt: true },
    })

    const recentRuns = await Promise.all([
      db.verificationRun.count(),
      db.driftCheck.count(),
      db.siteAnalysis.count(),
      db.promptTemplate.count({ where: { isBuiltin: true } }),
      db.constitutionRule.count({ where: { ideaId: null } }),
    ])

    // SQLite file size
    let dbSizeBytes: number | null = null
    let dbPath: string | null = null
    try {
      const url = process.env.DATABASE_URL ?? ''
      const match = url.match(/^file:(.+)$/)
      if (match) {
        dbPath = match[1]
        dbSizeBytes = fs.statSync(dbPath).size
      }
    } catch {
      dbSizeBytes = null
    }

    return NextResponse.json({
      ok: true,
      counts,
      byStage,
      ideas: ideas.map((i) => ({ ...i, updatedAt: i.updatedAt.toISOString() })),
      recentActivity: recentActivity.map((a) => ({ ...a, createdAt: a.createdAt.toISOString() })),
      totals: {
        ideas: ideas.length,
        verificationRuns: recentRuns[0],
        driftChecks: recentRuns[1],
        siteAnalyses: recentRuns[2],
        builtinPlaybooks: recentRuns[3],
        globalConstitutionRules: recentRuns[4],
      },
      database: {
        provider: 'sqlite',
        path: dbPath,
        sizeBytes: dbSizeBytes,
        models: tables.length,
      },
      runtime: {
        nodeVersion: process.version,
        environment: process.env.NODE_ENV ?? 'development',
        platform: `${process.platform} ${process.arch}`,
        uptimeSeconds: Math.round(process.uptime()),
        memoryMb: Math.round(process.memoryUsage().rss / 1024 / 1024),
        timestamp: new Date().toISOString(),
      },
      ai: {
        gateway: 'z-ai-web-dev-sdk (chat completions, JSON-first with retries)',
        modelConfigured: true,
      },
      limits: 'NONE — no-limits mode is active: all stages navigable, all gates permissive, all engines runnable from any stage.',
    })
  } catch (error) {
    console.error('[api/admin/overview GET]', error)
    return NextResponse.json({ error: 'Failed to build the overview.' }, { status: 500 })
  }
}
