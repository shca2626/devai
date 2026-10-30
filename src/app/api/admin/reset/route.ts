import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { listAdminTables } from '@/lib/admin/registry'

// ============================================================
// POST /api/admin/reset — wipe data. Body scopes:
//   { scope: 'all' }                      -> every model (full wipe)
//   { scope: 'ideas' }                    -> every idea + cascading children
//   { scope: 'playbooks' }                -> prompt templates
//   { scope: 'constitution' }             -> constitution rules
//   { scope: 'runs' }                     -> verification/drift/site runs
// Deletion order respects FKs: children first, then ideas.
// ============================================================

const IDEA_CHILDREN = [
  'Question',
  'Feature',
  'Assumption',
  'Decision',
  'Requirement',
  'ProcessFlow',
  'DataEntity',
  'ApiEndpoint',
  'ScreenSpec',
  'ImplTask',
  'RiskItem',
  'ConsistencyIssue',
  'ArchitectureDoc',
  'VerificationRun',
  'DecisionEntry',
  'DriftCheck',
  'SiteAnalysis',
  'Idea',
]

export async function POST(req: Request) {
  try {
    const body = (await req.json().catch(() => ({}))) as { scope?: string }
    const scope = body.scope ?? 'all'

    let order: string[]
    switch (scope) {
      case 'ideas':
        order = IDEA_CHILDREN
        break
      case 'playbooks':
        order = ['PromptTemplate']
        break
      case 'constitution':
        order = ['ConstitutionRule']
        break
      case 'runs':
        order = ['VerificationRun', 'DriftCheck', 'SiteAnalysis']
        break
      case 'all':
      default:
        // children first, then Idea, then standalone tables
        order = [
          ...IDEA_CHILDREN,
          'PromptTemplate',
          'ConstitutionRule',
        ]
        break
    }

    const deleted: Record<string, number> = {}
    for (const name of order) {
      const table = listAdminTables().find((t) => t.name === name)
      if (!table) continue
      const result = await table.delegate.deleteMany()
      deleted[name] = result.count
    }

    return NextResponse.json({ ok: true, scope, deleted })
  } catch (error) {
    console.error('[api/admin/reset POST]', error)
    return NextResponse.json({ error: 'Failed to reset the data.' }, { status: 500 })
  }
}
