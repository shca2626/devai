import { db } from '@/lib/db'
import type { ImpactPreview } from '@/lib/types'

// ============================================================
// Change impact analysis — the Project Contract's answer to
// "the client changed one sentence". When a confirmed
// requirement changes, the platform refuses to just edit a
// sentence in a document: it identifies every process, entity,
// API endpoint, screen, task and open issue the change touches,
// so the affected artifacts are explicitly re-reviewed.
// ============================================================

function parseCodes(raw: string | null | undefined): string[] {
  if (!raw) return []
  try {
    const v = JSON.parse(raw)
    return Array.isArray(v) ? v.filter((c): c is string => typeof c === 'string') : []
  } catch {
    return []
  }
}

export async function previewImpact(ideaId: string, requirementId: string, change: string): Promise<ImpactPreview | null> {
  const req = await db.requirement.findFirst({ where: { id: requirementId, ideaId } })
  if (!req) return null

  const [processes, entities, apis, screens, tasks, issues] = await Promise.all([
    db.processFlow.findMany({ where: { ideaId, status: { not: 'rejected' } } }),
    db.dataEntity.findMany({ where: { ideaId, status: { not: 'rejected' } } }),
    db.apiEndpoint.findMany({ where: { ideaId, status: { not: 'rejected' } } }),
    db.screenSpec.findMany({ where: { ideaId, status: { not: 'rejected' } } }),
    db.implTask.findMany({ where: { ideaId, status: { not: 'rejected' } } }),
    db.consistencyIssue.findMany({ where: { ideaId, status: 'open' } }),
  ])

  const code = req.code
  const affected: ImpactPreview['affected'] = []

  for (const p of processes) {
    const links = parseCodes(p.linkedRequirements)
    const ruleLinks = (() => {
      try {
        const rules = p.businessRules ? (JSON.parse(p.businessRules) as Array<{ linkedRequirements?: string[] }>) : []
        return rules.flatMap((r) => (Array.isArray(r.linkedRequirements) ? r.linkedRequirements : []))
      } catch {
        return []
      }
    })()
    if (links.includes(code) || ruleLinks.includes(code)) {
      affected.push({ kind: 'process', code: p.code, name: p.name, why: 'Realizes or enforces this requirement in its business rules.' })
    }
  }
  for (const e of entities) {
    const rationale = `${e.rationale ?? ''} ${e.constraints ?? ''} ${e.fields ?? ''}`
    const titleWords = req.title.toLowerCase().split(/\s+/).filter((w) => w.length > 3)
    if (titleWords.some((w) => rationale.toLowerCase().includes(w))) {
      affected.push({ kind: 'entity', code: e.code, name: e.name, why: 'Data model appears derived from this requirement — verify fields and constraints still hold.' })
    }
  }
  for (const a of apis) {
    if (parseCodes(a.linkedRequirements).includes(code)) {
      affected.push({ kind: 'api', code: a.code, name: `${a.method} ${a.path}`, why: 'Serves this requirement — request/response or errors may change.' })
    }
  }
  for (const s of screens) {
    if (parseCodes(s.linkedRequirements).includes(code)) {
      affected.push({ kind: 'screen', code: s.code, name: s.name, why: 'Screen implements this requirement — elements and states may change.' })
    }
  }
  for (const t of tasks) {
    if (parseCodes(t.requirementCodes).includes(code)) {
      affected.push({ kind: 'task', code: t.code, name: t.title, why: 'Task implements this requirement — its scope and acceptance criteria may change.' })
    }
  }

  const openIssues = issues.filter(
    (i) => (i.affected ? parseCodes(i.affected).includes(code) : false) || affected.some((x) => parseCodes(i.affected).includes(x.code))
  ).length

  return {
    requirementCode: code,
    requirementTitle: req.title,
    change,
    affected,
    openIssues,
  }
}

// Apply the impact: mark affected artifacts for revision and register the issue
export async function applyImpact(ideaId: string, requirementId: string, change: string): Promise<number> {
  const preview = await previewImpact(ideaId, requirementId, change)
  if (!preview) return 0

  const kinds: Array<{ kind: string; table: 'processFlow' | 'apiEndpoint' | 'screenSpec' | 'implTask' }> = [
    { kind: 'process', table: 'processFlow' },
    { kind: 'api', table: 'apiEndpoint' },
    { kind: 'screen', table: 'screenSpec' },
    { kind: 'task', table: 'implTask' },
  ]

  let marked = 0
  for (const { kind, table } of kinds) {
    const items = preview.affected.filter((a) => a.kind === kind)
    for (const item of items) {
      if (table === 'processFlow') {
        await db.processFlow.updateMany({ where: { ideaId, code: item.code, status: 'confirmed' }, data: { status: 'needs_revision' } })
      } else if (table === 'apiEndpoint') {
        await db.apiEndpoint.updateMany({ where: { ideaId, code: item.code, status: 'confirmed' }, data: { status: 'needs_revision' } })
      } else if (table === 'screenSpec') {
        await db.screenSpec.updateMany({ where: { ideaId, code: item.code, status: 'confirmed' }, data: { status: 'needs_revision' } })
      } else {
        await db.implTask.updateMany({ where: { ideaId, code: item.code, status: 'confirmed' }, data: { status: 'needs_revision' } })
      }
      marked++
    }
  }

  if (preview.affected.length > 0) {
    await db.consistencyIssue.create({
      data: {
        ideaId,
        kind: 'change_impact',
        severity: 'major',
        description: `Requirement ${preview.requirementCode} was changed (${change}). ${preview.affected.length} downstream artifact(s) were marked for revision and must be re-reviewed.`,
        affected: JSON.stringify(preview.affected.map((a) => a.code)),
        suggestion: 'Re-review the marked artifacts (regenerate or re-confirm them) so the package stays consistent.',
        detectedBy: 'engine',
        status: 'open',
      },
    })
  }

  return marked
}
