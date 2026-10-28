import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision } from '@/lib/payload'
import { buildProjectContext } from '@/lib/engines/context'
import { runConsistencyCheck } from '@/lib/engines/consistency'

// ============================================================
// Consistency validation — deterministic coverage checks plus
// an AI cross-artifact review. Every run replaces the previous
// OPEN auto-detected issues; user-dismissed/resolved decisions
// are preserved.
// ============================================================

type Params = { params: Promise<{ id: string }> }

export async function POST(_req: Request, { params }: Params) {
  try {
    const { id } = await params
    const idea = await db.idea.findUnique({ where: { id } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }
    if (!['readiness', 'planning', 'package'].includes(idea.stage)) {
      return NextResponse.json({ error: 'The consistency check runs in the readiness stage.' }, { status: 409 })
    }

    const ctx = await buildProjectContext(id)
    if (!ctx) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }

    const detected = await runConsistencyCheck({ ideaId: id, ctx })

    // Replace previous OPEN auto-detected issues (keep resolved/dismissed history)
    await db.consistencyIssue.deleteMany({ where: { ideaId: id, status: 'open', detectedBy: { in: ['engine', 'ai'] } } })
    for (const issue of detected) {
      await db.consistencyIssue.create({
        data: {
          ideaId: id,
          kind: issue.kind,
          severity: issue.severity,
          description: issue.description,
          affected: JSON.stringify(issue.affected),
          suggestion: issue.suggestion,
          detectedBy: issue.detectedBy,
          status: 'open',
        },
      })
    }

    const critical = detected.filter((i) => i.severity === 'critical').length
    const major = detected.filter((i) => i.severity === 'major').length
    await logDecision(
      id,
      'Consistency validation executed',
      detected.length === 0
        ? 'No contradictions, omissions or broken links found'
        : `${detected.length} issue(s) detected (${critical} critical, ${major} major)`,
      'readiness'
    )

    const payload = await buildIdeaDetail(id)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/ideas/[id]/consistency POST]', error)
    return NextResponse.json(
      { error: 'The consistency check failed. Please try again.' },
      { status: 502 }
    )
  }
}
