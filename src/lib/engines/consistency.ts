import { chatJson } from '@/lib/ai'
import { db } from '@/lib/db'
import type { ProjectContext } from '@/lib/engines/context'
import { contextToPrompt } from '@/lib/engines/context'
import type { ConsistencyIssue } from '@/lib/types'

// ============================================================
// Engine 12 — Documentation & Validation: consistency layer.
// Two detectors run together:
//   1. Deterministic coverage/link checks (engine) — cheap, exact
//   2. LLM cross-artifact review (ai) — finds contradictions,
//      omissions and duplicate capabilities the rules can't see.
// ============================================================

export interface DetectedIssue {
  kind: 'contradiction' | 'omission' | 'duplicate' | 'broken_link' | 'incomplete'
  severity: 'critical' | 'major' | 'minor'
  description: string
  affected: string[]
  suggestion: string
  detectedBy: 'engine' | 'ai'
}

const AI_CHECK_PROMPT = `You are the consistency validation engine of an AI software engineer platform.
You receive a digest of all approved specification artifacts. Find REAL problems only:

- contradiction: two artifacts that cannot both be true (a rule vs a data model, an API that breaks a business rule…)
- omission: a confirmed requirement with no realizing process/task, or a process step referencing data no entity holds
- duplicate: two artifacts doing the same thing under different names
- broken_link: references to codes/entities that do not exist
- incomplete: an artifact missing a mandatory piece (e.g. an endpoint with no error cases)

Rules:
- Report only issues you are confident about. Do NOT pad the list — an empty issues array is a valid answer.
- severity: "critical" = would cause rebuilding work if built as specified; "major" = must fix before implementation; "minor" = polish.
- "affected": the artifact codes involved (FR-001, PF-01, ENT-01, API-01, SCR-01, T-01…).

Return STRICT JSON only:
{"issues": [{"kind": "contradiction", "severity": "major", "description": "...", "affected": ["FR-001", "ENT-02"], "suggestion": "..."}]}`

function parseCodes(raw: string | null | undefined): string[] {
  if (!raw) return []
  try {
    const v = JSON.parse(raw)
    return Array.isArray(v) ? v.filter((c): c is string => typeof c === 'string') : []
  } catch {
    return []
  }
}

// Deterministic checks — the coverage validation backbone
export async function deterministicChecks(ideaId: string): Promise<DetectedIssue[]> {
  const [requirements, processes, entities, apis, screens, tasks, risks, issues] = await Promise.all([
    db.requirement.findMany({ where: { ideaId } }),
    db.processFlow.findMany({ where: { ideaId } }),
    db.dataEntity.findMany({ where: { ideaId } }),
    db.apiEndpoint.findMany({ where: { ideaId } }),
    db.screenSpec.findMany({ where: { ideaId } }),
    db.implTask.findMany({ where: { ideaId } }),
    db.riskItem.findMany({ where: { ideaId } }),
    db.consistencyIssue.findMany({ where: { ideaId, status: 'open' } }),
  ])

  const out: DetectedIssue[] = []
  const confirmed = requirements.filter((r) => r.status === 'confirmed' && r.type === 'functional')
  const confirmedTasks = tasks.filter((t) => t.status === 'confirmed')
  const confirmedProcesses = processes.filter((p) => p.status === 'confirmed')
  const confirmedScreens = screens.filter((s) => s.status === 'confirmed')
  const confirmedEntities = entities.filter((e) => e.status === 'confirmed')
  const entityNames = new Set(entities.filter((e) => e.status !== 'rejected').map((e) => e.name))
  const taskCodes = new Set(tasks.filter((t) => t.status !== 'rejected').map((t) => t.code))

  const procLinks = new Set(confirmedProcesses.flatMap((p) => parseCodes(p.linkedRequirements)))
  const screenLinks = new Set(confirmedScreens.flatMap((s) => parseCodes(s.linkedRequirements)))
  const taskLinks = new Set(confirmedTasks.flatMap((t) => parseCodes(t.requirementCodes)))

  for (const r of confirmed) {
    if (r.acceptanceCriteria === '[]') {
      out.push({
        kind: 'incomplete',
        severity: 'major',
        description: `${r.code} (${r.title}) has no acceptance criteria — it cannot be verified after implementation.`,
        affected: [r.code],
        suggestion: 'Add at least one testable acceptance criterion before locking the package.',
        detectedBy: 'engine',
      })
    }
    if (!procLinks.has(r.code)) {
      out.push({
        kind: 'omission',
        severity: 'major',
        description: `Confirmed requirement ${r.code} (${r.title}) is not realized by any confirmed business process.`,
        affected: [r.code],
        suggestion: 'Link it to a process (or confirm a process that covers it).',
        detectedBy: 'engine',
      })
    }
    if (!screenLinks.has(r.code) && !r.code.startsWith('NFR')) {
      out.push({
        kind: 'omission',
        severity: 'minor',
        description: `Requirement ${r.code} has no confirmed screen covering its user-facing surface.`,
        affected: [r.code],
        suggestion: 'Check whether a screen should reference it.',
        detectedBy: 'engine',
      })
    }
    if (!taskLinks.has(r.code)) {
      out.push({
        kind: 'omission',
        severity: 'major',
        description: `Confirmed requirement ${r.code} has no confirmed implementation task — it would be silently skipped.`,
        affected: [r.code],
        suggestion: 'Add or confirm a task that implements it.',
        detectedBy: 'engine',
      })
    }
  }

  for (const e of entities) {
    if (e.status === 'rejected') continue
    try {
      const rels = e.relationships ? (JSON.parse(e.relationships) as Array<{ target: string }>) : []
      for (const rel of rels) {
        if (rel.target && !entityNames.has(rel.target)) {
          out.push({
            kind: 'broken_link',
            severity: 'major',
            description: `Entity ${e.code} (${e.name}) references unknown entity "${rel.target}".`,
            affected: [e.code],
            suggestion: `Fix the relationship target — approved entities are: ${[...entityNames].join(', ')}.`,
            detectedBy: 'engine',
          })
        }
      }
    } catch {
      // ignore parse errors here
    }
    if (e.fields === '[]') {
      out.push({
        kind: 'incomplete',
        severity: 'major',
        description: `Entity ${e.code} (${e.name}) has no fields defined.`,
        affected: [e.code],
        suggestion: 'Define its fields before locking the package.',
        detectedBy: 'engine',
      })
    }
  }

  for (const t of tasks) {
    if (t.status === 'rejected') continue
    for (const dep of parseCodes(t.dependsOn)) {
      if (!taskCodes.has(dep)) {
        out.push({
          kind: 'broken_link',
          severity: 'minor',
          description: `Task ${t.code} depends on unknown task "${dep}".`,
          affected: [t.code],
          suggestion: 'Remove or fix the dependency reference.',
          detectedBy: 'engine',
        })
      }
    }
  }

  const proposedRisks = risks.filter((r) => r.status === 'proposed').length
  if (proposedRisks > 0 && tasks.length > 0) {
    out.push({
      kind: 'incomplete',
      severity: 'minor',
      description: `${proposedRisks} risk(s) are still unreviewed — every risk needs a mitigation decision (mitigate or accept).`,
      affected: risks.filter((r) => r.status === 'proposed').map((r) => r.code),
      suggestion: 'Review each risk and decide mitigate / accept.',
      detectedBy: 'engine',
    })
  }

  const openCritical = issues.filter((i) => i.severity === 'critical' && i.status === 'open').length
  if (openCritical > 0) {
    out.push({
      kind: 'contradiction',
      severity: 'critical',
      description: `${openCritical} critical consistency issue(s) from previous checks are still open.`,
      affected: [],
      suggestion: 'Resolve or dismiss them in the readiness view.',
      detectedBy: 'engine',
    })
  }

  // Deduplicate by description
  const seen = new Set<string>()
  return out.filter((i) => (seen.has(i.description) ? false : (seen.add(i.description), true)))
}

export async function runConsistencyCheck(params: { ideaId: string; ctx: ProjectContext }): Promise<DetectedIssue[]> {
  const [requirements, processes, entities, apis, screens, tasks, risks] = await Promise.all([
    db.requirement.findMany({ where: { ideaId: params.ideaId } }),
    db.processFlow.findMany({ where: { ideaId: params.ideaId } }),
    db.dataEntity.findMany({ where: { ideaId: params.ideaId } }),
    db.apiEndpoint.findMany({ where: { ideaId: params.ideaId } }),
    db.screenSpec.findMany({ where: { ideaId: params.ideaId } }),
    db.implTask.findMany({ where: { ideaId: params.ideaId } }),
    db.riskItem.findMany({ where: { ideaId: params.ideaId } }),
  ])

  const visible = <T extends { status: string }>(list: T[]) => list.filter((x) => x.status !== 'rejected')

  const digest = [
    `Requirements:\n${visible(requirements)
      .map((r) => `- ${r.code} [${r.status}${r.provenance === 'client' ? ',client' : ',ai'}]: ${r.title} — ${r.description}`)
      .join('\n')}`,
    `Business processes:\n${visible(processes)
      .map(
        (p) =>
          `- ${p.code} [${p.status}]: ${p.name} (rules: ${p.businessRules ? 'see JSON' : 'none'}; linked: ${p.linkedRequirements ?? '[]'})`
      )
      .join('\n')}`,
    `Data entities:\n${visible(entities)
      .map((e) => `- ${e.code} [${e.status}]: ${e.name} (${e.fields})`)
      .join('\n')}`,
    `API endpoints:\n${visible(apis)
      .map((a) => `- ${a.code} [${a.status}]: ${a.method} ${a.path} — ${a.purpose} (req: ${a.request ?? '[]'}; errors: ${a.errors ?? '[]'}; entities: ${a.linkedEntities ?? '[]'})`)
      .join('\n')}`,
    `Screens:\n${visible(screens)
      .map((s) => `- ${s.code} [${s.status}]: ${s.name} (${s.route ?? ''}; states: ${s.states ?? '{}'}; linked: ${s.linkedRequirements ?? '[]'})`)
      .join('\n')}`,
    `Tasks:\n${visible(tasks)
      .map((t) => `- ${t.code} [${t.status}]: ${t.title} (depends: ${t.dependsOn ?? '[]'}; reqs: ${t.requirementCodes ?? '[]'})`)
      .join('\n')}`,
    `Risks:\n${visible(risks).map((r) => `- ${r.code} [${r.status}]: ${r.description}`).join('\n')}`,
  ].join('\n\n')

  let aiIssues: DetectedIssue[] = []
  try {
    const raw = await chatJson<{ issues?: Array<Record<string, unknown>> }>(
      AI_CHECK_PROMPT,
      `${contextToPrompt(params.ctx)}\n\n=== SPECIFICATION DIGEST ===\n${digest}`
    )
    const KINDS = ['contradiction', 'omission', 'duplicate', 'broken_link', 'incomplete']
    const SEVS = ['critical', 'major', 'minor']
    aiIssues = (Array.isArray(raw?.issues) ? raw.issues : [])
      .map((i): DetectedIssue | null => {
        const description = typeof i.description === 'string' ? i.description.trim() : ''
        if (!description) return null
        return {
          kind: (KINDS.includes(String(i.kind)) ? String(i.kind) : 'contradiction') as DetectedIssue['kind'],
          severity: (SEVS.includes(String(i.severity)) ? String(i.severity) : 'major') as DetectedIssue['severity'],
          description,
          affected: Array.isArray(i.affected) ? i.affected.filter((c): c is string => typeof c === 'string').slice(0, 6) : [],
          suggestion: typeof i.suggestion === 'string' ? i.suggestion.trim() : '',
          detectedBy: 'ai' as const,
        }
      })
      .filter((i): i is DetectedIssue => i !== null)
      .slice(0, 12)
  } catch {
    // The deterministic layer still produces its report if the LLM call fails
  }

  const engineIssues = await deterministicChecks(params.ideaId)
  return [...engineIssues, ...aiIssues]
}
