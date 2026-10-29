import { db } from '@/lib/db'
import { chatJson } from '@/lib/ai'
import { buildBaselineSnapshot, logDecision, parseInterpretation } from '@/lib/payload'
import { buildProjectContext, type ProjectContext } from '@/lib/engines/context'
import { generateQuestions, compileDiscoverySummary, type AnsweredItem } from '@/lib/engines/discover'
import { generateFeatureInventory } from '@/lib/engines/features'
import { generateRequirements } from '@/lib/engines/requirements'
import {
  generateProcesses,
  generateEntities,
  generateApis,
  generateScreens,
  generateArchitecture,
} from '@/lib/engines/design'
import { generateTasks, generateRisks } from '@/lib/engines/plan'
import { runConsistencyCheck } from '@/lib/engines/consistency'
import { computeReadiness } from '@/lib/readiness'
import { AREAS } from '@/lib/types'
import type { Requirement } from '@/lib/types'

// ============================================================
// Express autopilot — the client's explicit DELEGATION of the
// remaining workflow to the virtual engineer. One unit of work
// per call; the UI drives the loop and shows live progress.
//
// Philosophy preserved:
// - Delegation is itself an explicit, logged act (never silence).
// - Every auto-decision is written to the decision history with
//   an Express marker and can be changed afterwards — the
//   package can be reopened, artifacts edited, nothing restarts.
// - The autopilot STOPS on genuine human decisions: critical
//   consistency issues, readiness hard blockers, missing input.
// ============================================================

export interface ExpressStepResult {
  status: 'running' | 'done' | 'blocked'
  step: string
  next?: string
  reason?: string
  blockers?: string[]
}

const running = (step: string, next?: string): ExpressStepResult => ({ status: 'running', step, next })
const blocked = (reason: string, blockers?: string[]): ExpressStepResult => ({
  status: 'blocked',
  step: '',
  reason,
  blockers,
})

// ---------- shared helpers ----------

function safeArr(raw: string | null): string[] {
  try {
    const v = raw ? JSON.parse(raw) : []
    return Array.isArray(v) ? v : []
  } catch {
    return []
  }
}

async function loadRequirements(ideaId: string): Promise<Requirement[]> {
  const rows = await db.requirement.findMany({ where: { ideaId }, orderBy: [{ order: 'asc' }] })
  return rows.map((r) => ({
    id: r.id,
    code: r.code,
    type: r.type === 'non_functional' ? 'non_functional' : 'functional',
    category: r.category,
    title: r.title,
    titleAr: r.titleAr,
    description: r.description,
    acceptanceCriteria: safeArr(r.acceptanceCriteria),
    provenance: r.provenance === 'client' ? 'client' : 'ai',
    evidence: r.evidence,
    featureId: r.featureId,
    priority: r.priority as Requirement['priority'],
    status: r.status as Requirement['status'],
    order: r.order,
  }))
}

function loadRoles(idea: { roles: string | null }): Array<{ name: string; description: string; permissions: string[] }> {
  if (!idea.roles) return []
  try {
    const parsed = JSON.parse(idea.roles)
    return Array.isArray(parsed) ? parsed : []
  } catch {
    return []
  }
}

async function answeredItems(ideaId: string): Promise<AnsweredItem[]> {
  const questions = await db.question.findMany({
    where: { ideaId, status: 'answered' },
    orderBy: [{ order: 'asc' }, { createdAt: 'asc' }],
  })
  return questions.map((q) => ({ area: q.area, questionEn: q.questionEn, answer: q.answer ?? '' }))
}

// ---------- auto-answer engine (express interview) ----------

const AUTO_ANSWER_PROMPT = `You are the discovery engine of an AI software engineer platform, running in EXPRESS mode: the client delegated the interview to you.
For every pending question, pick the most sensible option for a lean, launchable MVP and justify it in one short sentence.

Rules:
- "choice" MUST be the exact label of one of the question's options whenever any option fits.
- If no option fits, write a short custom answer instead (max 12 words).
- Prefer the simplest option that unblocks building; avoid options whose consequence implies heavy operations, cost or compliance unless the question clearly demands it.

Return STRICT JSON only:
{"answers": [{"n": 1, "choice": "...", "why": "..."}]}`

async function autoAnswerQuestions(ideaId: string): Promise<number> {
  const pending = await db.question.findMany({
    where: { ideaId, status: 'pending' },
    orderBy: [{ order: 'asc' }, { createdAt: 'asc' }],
  })
  if (pending.length === 0) return 0

  const idea = await db.idea.findUnique({ where: { id: ideaId } })
  const interpretation = parseInterpretation(idea?.interpretation ?? null)
  const ctx: ProjectContext | null = await buildProjectContext(ideaId)

  const lines = pending.map((q, i) => {
    const options = safeArr(q.options).length > 0 ? safeArr(q.options) : []
    const optStr = options
      .map((o) => {
        const m = o as { label?: string; consequence?: string }
        return `  - "${m.label ?? ''}"${m.consequence ? ` (consequence: ${m.consequence})` : ''}`
      })
      .join('\n')
    return `Q${i + 1} [${q.area}] ${q.questionEn}\nwhy it matters: ${q.whyItMatters ?? '-'}\noptions:\n${optStr || '  (no predefined options — answer freely, max 12 words)'}`
  })

  const answered = await answeredItems(ideaId)
  const answeredBlock =
    answered.length > 0
      ? `\nAlready answered by the client earlier (respect these as facts):\n${answered.map((a) => `- ${a.questionEn} → ${a.answer}`).join('\n')}`
      : ''

  const raw = await chatJson<{ answers?: Array<{ n?: number; choice?: string; why?: string }> }>(
    AUTO_ANSWER_PROMPT,
    `${ctx ? '' : ''}${interpretation ? `Product interpretation:\n${interpretation.englishInterpretation}\nProblem: ${interpretation.problemStatement}\n\n` : ''}Pending questions:\n${lines.join('\n\n')}${answeredBlock}`
  )

  const answers = Array.isArray(raw?.answers) ? raw.answers : []
  let count = 0
  for (let i = 0; i < pending.length; i++) {
    const match = answers.find((a) => Number(a.n) === i + 1)
    const fallbackOptions = safeArr(pending[i].options)
    const fallbackLabel =
      (fallbackOptions[0] as { label?: string } | undefined)?.label ?? 'Decided by the engineer (express)'
    const answer = typeof match?.choice === 'string' && match.choice.trim() ? match.choice.trim() : fallbackLabel
    await db.question.update({
      where: { id: pending[i].id },
      data: { answer, answerKind: 'choice', status: 'answered' },
    })
    // Every auto-answer is recorded as an OPEN assumption — never a silent fact.
    await db.assumption.create({
      data: {
        ideaId,
        text: `Express auto-answer — Q: ${pending[i].questionEn} → A: ${answer}`,
        kind: 'suggested',
        status: 'open',
        source: 'express',
      },
    })
    count++
  }
  return count
}

// ---------- auto-fix engine (critical consistency issues) ----------

const AUTOFIX_PROMPT = `You are the consistency auto-fix engine of an AI software engineer platform, running in EXPRESS mode: the client delegated the fixes to you.
For every critical consistency issue, propose the MINIMAL fix that makes the artifacts consistent. Prefer ADDING a missing field over removing a collected one (losing user data is worse than storing it).

Allowed operations (use ONLY these):
- {"op": "add_entity_field", "entity": "<entity name or code>", "field": {"name": "...", "type": "string", "required": true, "unique": false, "description": "..."}}
- {"op": "remove_entity_field", "entity": "<entity name or code>", "field": "<field name>"}
- {"op": "add_api_request_field", "api": "<api code like API-01>", "field": {"field": "...", "type": "string", "required": true, "notes": "..."}}
- {"op": "remove_api_request_field", "api": "<api code>", "field": "<field name>"}

If an issue cannot be fixed with these operations, return no fix for it (it will be escalated to the client).

Return STRICT JSON only:
{"fixes": [{"op": "...", "entity": "...", "api": "...", "field": {}, "issueIndex": 0, "note": "one sentence"}]}`

async function autoFixCriticalIssues(
  ideaId: string,
  issues: Array<{ id: string; description: string; affected: string | null }>
): Promise<number> {
  const [entities, apis] = await Promise.all([
    db.dataEntity.findMany({ where: { ideaId } }),
    db.apiEndpoint.findMany({ where: { ideaId } }),
  ])

  const issueBlock = issues
    .map((i, idx) => `Issue #${idx}: ${i.description}${i.affected ? ` (affected: ${i.affected})` : ''}`)
    .join('\n')
  const entityBlock = entities
    .map((e) => `- ${e.code} "${e.name}": fields = ${e.fields}`)
    .join('\n')
  const apiBlock = apis
    .map((a) => `- ${a.code} ${a.method} ${a.path}: request = ${a.request ?? '[]'}`)
    .join('\n')

  const raw = await chatJson<{ fixes?: Array<Record<string, unknown>> }>(
    AUTOFIX_PROMPT,
    `Critical issues:\n${issueBlock}\n\nCurrent data entities:\n${entityBlock}\n\nCurrent API endpoints:\n${apiBlock}`
  )

  const fixes = Array.isArray(raw?.fixes) ? raw.fixes : []
  const parseJsonArr = (s: string | null): Array<Record<string, unknown>> => {
    try {
      const v = s ? JSON.parse(s) : []
      return Array.isArray(v) ? v : []
    } catch {
      return []
    }
  }

  let applied = 0
  const appliedNotes: string[] = []
  const norm = (s: string) => s.trim().toLowerCase()

  for (const f of fixes) {
    const op = typeof f.op === 'string' ? f.op : ''
    const note = typeof f.note === 'string' ? f.note : ''
    const issueIndex = typeof f.issueIndex === 'number' ? f.issueIndex : -1
    const issue = issueIndex >= 0 && issueIndex < issues.length ? issues[issueIndex] : null

    try {
      if (op === 'add_entity_field' || op === 'remove_entity_field') {
        const ref = String(f.entity ?? '')
        const target = entities.find((e) => norm(e.name) === norm(ref) || norm(e.code) === norm(ref))
        if (!target) continue
        const fields = parseJsonArr(target.fields)
        let next: Array<Record<string, unknown>>
        if (op === 'add_entity_field') {
          const fm = (f.field ?? {}) as Record<string, unknown>
          const name = typeof fm.name === 'string' ? fm.name.trim() : ''
          if (!name) continue
          if (fields.some((x) => x.name === name)) {
            // The data is already consistent — the issue row is stale.
            if (issue) await db.consistencyIssue.update({ where: { id: issue.id }, data: { status: 'resolved' } })
            applied++
            appliedNotes.push(`${target.code}: field "${name}" already present — stale issue resolved`)
            continue
          }
          next = [...fields, {
            name,
            type: typeof fm.type === 'string' && fm.type.trim() ? fm.type.trim() : 'string',
            required: fm.required === true,
            unique: fm.unique === true,
            description: typeof fm.description === 'string' ? fm.description : '',
          }]
        } else {
          const fname = String(f.field ?? '').trim()
          next = fields.filter((x) => x.name !== fname)
          if (next.length === fields.length) {
            if (issue) await db.consistencyIssue.update({ where: { id: issue.id }, data: { status: 'resolved' } })
            applied++
            appliedNotes.push(`${target.code}: field "${fname}" already absent — stale issue resolved`)
            continue
          }
        }
        await db.dataEntity.update({
          where: { id: target.id },
          data: {
            fields: JSON.stringify(next),
            status: target.status === 'confirmed' ? 'confirmed' : target.status,
          },
        })
        applied++
        appliedNotes.push(`${target.code}: ${op === 'add_entity_field' ? 'added' : 'removed'} field — ${note}`)
        if (issue) await db.consistencyIssue.update({ where: { id: issue.id }, data: { status: 'resolved' } })
      } else if (op === 'add_api_request_field' || op === 'remove_api_request_field') {
        const ref = String(f.api ?? '')
        const target = apis.find(
          (a) => norm(a.code) === norm(ref) || norm(a.path) === norm(ref) || norm(`${a.method} ${a.path}`) === norm(ref)
        )
        if (!target) continue
        const request = parseJsonArr(target.request)
        let next: Array<Record<string, unknown>>
        if (op === 'add_api_request_field') {
          const fm = (f.field ?? {}) as Record<string, unknown>
          const field = typeof fm.field === 'string' ? fm.field.trim() : ''
          if (!field) continue
          if (request.some((x) => x.field === field)) {
            // Already consistent — the issue row is stale.
            if (issue) await db.consistencyIssue.update({ where: { id: issue.id }, data: { status: 'resolved' } })
            applied++
            appliedNotes.push(`${target.code}: request field "${field}" already present — stale issue resolved`)
            continue
          }
          next = [...request, {
            field,
            type: typeof fm.type === 'string' && fm.type.trim() ? fm.type.trim() : 'string',
            required: fm.required === true,
            notes: typeof fm.notes === 'string' ? fm.notes : '',
          }]
        } else {
          const fname = String(f.field ?? '').trim()
          next = request.filter((x) => x.field !== fname)
          if (next.length === request.length) {
            if (issue) await db.consistencyIssue.update({ where: { id: issue.id }, data: { status: 'resolved' } })
            applied++
            appliedNotes.push(`${target.code}: request field "${fname}" already absent — stale issue resolved`)
            continue
          }
        }
        await db.apiEndpoint.update({
          where: { id: target.id },
          data: {
            request: JSON.stringify(next),
            status: target.status === 'confirmed' ? 'confirmed' : target.status,
          },
        })
        applied++
        appliedNotes.push(`${target.code}: ${op === 'add_api_request_field' ? 'added' : 'removed'} request field — ${note}`)
        if (issue) await db.consistencyIssue.update({ where: { id: issue.id }, data: { status: 'resolved' } })
      }
    } catch {
      // a single malformed fix must not abort the others
    }
  }

  if (applied > 0) {
    await logDecision(
      ideaId,
      'Express: critical issues auto-fixed',
      appliedNotes.slice(0, 5).join(' | '),
      'readiness'
    )
  }
  return applied
}

const RESOLVE_MUST_PROMPT = `You are the requirements engineer of an AI software engineer platform, running in EXPRESS mode: the client delegated the final call on open must-have requirements.
For each unresolved must-priority requirement, decide confirm or reject for the lean, launchable MVP.

Rules:
- CONFIRM when the requirement is needed by the accepted feature baseline and does not contradict the confirmed set or the architecture.
- REJECT when it contradicts confirmed requirements, duplicates one, or is not needed for the MVP.
- Never invent new requirements; only decide the listed ones.

Return STRICT JSON only:
{"decisions": [{"code": "FR-001", "decision": "confirmed", "why": "one sentence"}]}`

async function resolveUnresolvedMusts(ideaId: string): Promise<number> {
  const rows = await db.requirement.findMany({ where: { ideaId, status: 'unresolved', priority: 'must' } })
  if (rows.length === 0) return 0

  const confirmed = await db.requirement.findMany({
    where: { ideaId, status: 'confirmed' },
    select: { code: true, title: true },
  })

  let decisions: Array<{ code?: string; decision?: string; why?: string }> = []
  try {
    const raw = await chatJson<{ decisions?: Array<{ code?: string; decision?: string; why?: string }> }>(
      RESOLVE_MUST_PROMPT,
      `Unresolved must-have requirements:
${rows.map((r) => `- ${r.code}: ${r.title}\n  ${r.description}\n  evidence: ${r.evidence ?? '-'}`).join('\n')}

Confirmed requirements (facts):
${confirmed.map((c) => `- ${c.code}: ${c.title}`).join('\n')}`
    )
    decisions = Array.isArray(raw?.decisions) ? raw.decisions : []
  } catch {
    decisions = []
  }

  let resolved = 0
  for (const r of rows) {
    const d = decisions.find((x) => x.code === r.code)
    const decision = d?.decision === 'rejected' ? 'rejected' : 'confirmed'
    const why = typeof d?.why === 'string' ? d.why : 'delegated fallback — confirmed to keep the must-have scope explicit'
    await db.requirement.update({ where: { id: r.id }, data: { status: decision } })
    await logDecision(ideaId, `Express: must-have ${r.code} → ${decision}`, why, 'readiness')
    resolved++
  }
  return resolved
}

// ---------- the step machine ----------

export async function runExpressStep(ideaId: string): Promise<ExpressStepResult> {
  const idea = await db.idea.findUnique({ where: { id: ideaId } })
  if (!idea) return blocked('Idea not found.')
  const id = ideaId

  // ===== Stage: understanding =====
  if (idea.stage === 'understanding') {
    const interpretation = parseInterpretation(idea.interpretation)
    if (!interpretation) {
      return blocked('There is no interpretation yet — describe the idea and run the understanding step first.')
    }
    const drafts = await generateQuestions({ interpretation, answered: [], uncoveredAreas: [...AREAS], weakAreas: [] })
    let order = 0
    for (const draft of drafts) {
      await db.question.create({
        data: {
          ideaId: id,
          area: draft.area,
          questionEn: draft.questionEn,
          questionAr: draft.questionAr,
          whyItMatters: draft.whyItMatters,
          options: JSON.stringify(draft.options),
          status: 'pending',
          order: order++,
        },
      })
    }
    await db.idea.update({ where: { id }, data: { stage: 'discovery' } })
    await logDecision(id, 'Express: interpretation approved — discovery started', `${drafts.length} questions generated`, 'understanding')
    return running('Interpretation approved — discovery questions generated', 'Auto-answering the interview questions')
  }

  // ===== Stage: discovery =====
  if (idea.stage === 'discovery') {
    const pending = await db.question.count({ where: { ideaId: id, status: 'pending' } })
    if (pending > 0) {
      const n = await autoAnswerQuestions(id)
      await logDecision(id, 'Express: interview auto-answered', `${n} answers chosen by the engineer — every answer recorded as an open assumption`, 'discovery')
      return running(`Auto-answered ${n} interview questions (each recorded as an open assumption)`, 'Compiling the discovery summary')
    }

    const answered = await db.question.count({ where: { ideaId: id, status: 'answered' } })
    if (answered < 5) {
      return blocked('Not enough answered questions to compile a discovery summary (minimum 5).')
    }

    const interpretation = parseInterpretation(idea.interpretation)
    if (!interpretation) return blocked('No interpretation available.')
    const summary = await compileDiscoverySummary({ interpretation, answered: await answeredItems(id) })
    for (const risk of summary.openRisks) {
      await db.assumption.create({ data: { ideaId: id, text: risk, kind: 'uncertain', status: 'open', source: 'discovery' } })
    }
    for (const s of summary.suggestedAssumptions) {
      await db.assumption.create({ data: { ideaId: id, text: s, kind: 'suggested', status: 'open', source: 'discovery' } })
    }
    await db.idea.update({ where: { id }, data: { stage: 'features', summary: JSON.stringify(summary) } })
    await logDecision(id, 'Express: discovery finished — summary compiled', `${answered} questions answered`, 'discovery')
    return running('Discovery summary compiled', 'Generating the feature inventory')
  }

  // ===== Stage: features =====
  if (idea.stage === 'features') {
    const features = await db.feature.findMany({ where: { ideaId: id } })
    if (features.length === 0) {
      const interpretation = parseInterpretation(idea.interpretation)
      if (!interpretation) return blocked('No interpretation available.')
      const inventory = await generateFeatureInventory({ interpretation, answered: await answeredItems(id) })
      let order = 0
      for (const f of inventory.features) {
        await db.feature.create({
          data: {
            ideaId: id,
            module: f.module,
            feature: f.feature,
            user: f.user,
            priority: f.priority,
            status: f.status,
            rationale: f.rationale,
            origin: 'ai',
            order: order++,
          },
        })
      }
      await db.idea.update({
        where: { id },
        data: {
          featuresMeta: JSON.stringify({
            missingFeatures: inventory.missingFeatures,
            dependencies: inventory.dependencies,
            releaseNote: inventory.releaseNote,
          }),
        },
      })
      await logDecision(id, 'Express: feature inventory generated', `${inventory.features.length} features proposed`, 'features')
      return running(`Feature inventory generated (${inventory.features.length} features)`, 'Accepting the feature baseline')
    }

    const unreviewed = features.filter((f) => f.status === 'proposed' || f.status === 'needs_confirmation')
    if (unreviewed.length > 0) {
      await db.feature.updateMany({
        where: { ideaId: id, status: { in: ['proposed', 'needs_confirmation'] } },
        data: { status: 'accepted' },
      })
      await logDecision(id, 'Express: unreviewed features accepted', `${unreviewed.length} features bulk-accepted by delegation`, 'features')
      return running(`Accepted ${unreviewed.length} unreviewed features`, 'Approving the feature baseline')
    }

    const snapshot = await buildBaselineSnapshot(id)
    await db.idea.update({ where: { id }, data: { stage: 'baseline', baseline: JSON.stringify(snapshot) } })
    await logDecision(id, 'Express: feature baseline approved', 'Snapshot stored; delegation recorded', 'features')
    return running('Feature baseline approved', 'Starting the engineering track')
  }

  // ===== Stage: baseline =====
  if (idea.stage === 'baseline') {
    await db.idea.update({ where: { id }, data: { stage: 'requirements' } })
    await logDecision(id, 'Express: engineering track started', 'Delegated transition', 'baseline')
    return running('Engineering track started', 'Generating the requirements specification')
  }

  // ===== Stage: requirements =====
  if (idea.stage === 'requirements') {
    const requirements = await db.requirement.findMany({ where: { ideaId: id } })
    if (requirements.length === 0) {
      const ctx = await buildProjectContext(id)
      if (!ctx || ctx.acceptedFeatures.length === 0) {
        return blocked('The feature baseline must be approved before requirements can be generated.')
      }
      const result = await generateRequirements(ctx)
      await db.requirement.deleteMany({ where: { ideaId: id, status: 'proposed' } })
      const featureRows = await db.feature.findMany({ where: { ideaId: id, status: 'accepted' } })
      const matchFeature = (ref: string | null): string | null => {
        if (!ref) return null
        const norm = (s: string) => s.toLowerCase().replace(/[^a-z0-9\u0600-\u06FF]/g, '')
        const target = norm(ref)
        const exact = featureRows.find((f) => norm(f.feature) === target)
        if (exact) return exact.id
        const partial = featureRows.find((f) => norm(f.feature).includes(target) || target.includes(norm(f.feature)))
        return partial?.id ?? null
      }
      let fr = 0
      let nfr = 0
      let order = 0
      for (const draft of [...result.functional, ...result.nonFunctional]) {
        const code = draft.type === 'functional' ? `FR-${String(++fr).padStart(3, '0')}` : `NFR-${String(++nfr).padStart(3, '0')}`
        await db.requirement.create({
          data: {
            ideaId: id,
            code,
            type: draft.type,
            category: draft.category,
            title: draft.title,
            titleAr: draft.titleAr,
            description: draft.description,
            acceptanceCriteria: JSON.stringify(draft.acceptanceCriteria),
            provenance: draft.provenance,
            evidence: draft.evidence,
            featureId: draft.provenance === 'client' ? matchFeature(draft.featureRef) : null,
            priority: draft.priority,
            status: draft.status,
            order: order++,
          },
        })
      }
      if (result.roles.length > 0) {
        await db.idea.update({ where: { id }, data: { roles: JSON.stringify(result.roles) } })
      }
      await logDecision(id, 'Express: requirements generated', `${fr} functional + ${nfr} non-functional proposed`, 'requirements')
      return running(`Requirements generated (${fr} FR + ${nfr} NFR)`, 'Confirming the requirements')
    }

    const proposed = requirements.filter((r) => r.status === 'proposed')
    if (proposed.length > 0) {
      await db.requirement.updateMany({ where: { ideaId: id, status: 'proposed' }, data: { status: 'confirmed' } })
      await logDecision(id, 'Express: requirements confirmed', `${proposed.length} requirements confirmed by delegation`, 'requirements')
      return running(`Confirmed ${proposed.length} requirements`, 'Approving requirements & starting design')
    }

    const confirmed = requirements.filter((r) => r.status === 'confirmed').length
    if (confirmed === 0) return blocked('No confirmed requirements — the specification needs at least one.')
    await db.idea.update({ where: { id }, data: { stage: 'design' } })
    await logDecision(id, 'Express: requirements approved', `${confirmed} confirmed`, 'requirements')
    return running('Requirements approved — design started', 'Designing the business processes')
  }

  // ===== Stage: design =====
  if (idea.stage === 'design') {
    const [processes, entities, apis, screens, arch] = await Promise.all([
      db.processFlow.findMany({ where: { ideaId: id } }),
      db.dataEntity.findMany({ where: { ideaId: id } }),
      db.apiEndpoint.findMany({ where: { ideaId: id } }),
      db.screenSpec.findMany({ where: { ideaId: id } }),
      db.architectureDoc.findUnique({ where: { ideaId: id } }),
    ])
    const requirements = await loadRequirements(id)
    const roles = loadRoles(idea)

    if (processes.length === 0) {
      const drafts = await generateProcesses({ ctx: (await buildProjectContext(id))!, roles, requirements })
      let count = 0
      for (const d of drafts) {
        await db.processFlow.create({
          data: {
            ideaId: id,
            code: `PF-${String(++count).padStart(2, '0')}`,
            name: d.name,
            nameAr: d.nameAr,
            trigger: d.trigger,
            actors: JSON.stringify(d.actors),
            steps: JSON.stringify(d.steps),
            businessRules: JSON.stringify(d.businessRules),
            exceptions: JSON.stringify(d.exceptions),
            linkedRequirements: JSON.stringify(d.linkedRequirements),
            rationale: d.rationale,
            status: 'proposed',
            order: count - 1,
          },
        })
      }
      await logDecision(id, 'Express: business processes generated', `${count} processes`, 'design')
      return running(`Business processes generated (${count})`, 'Confirming the processes')
    }
    const procUnreviewed = processes.filter((p) => p.status === 'proposed' || p.status === 'needs_revision')
    if (procUnreviewed.length > 0) {
      await db.processFlow.updateMany({
        where: { ideaId: id, status: { in: ['proposed', 'needs_revision'] } },
        data: { status: 'confirmed' },
      })
      await logDecision(id, 'Express: processes confirmed', `${procUnreviewed.length} confirmed by delegation`, 'design')
      return running(`Confirmed ${procUnreviewed.length} processes`, 'Designing the data model')
    }

    if (entities.length === 0) {
      const drafts = await generateEntities({ ctx: (await buildProjectContext(id))!, requirements })
      let count = 0
      for (const d of drafts) {
        await db.dataEntity.create({
          data: {
            ideaId: id,
            code: `ENT-${String(++count).padStart(2, '0')}`,
            name: d.name,
            nameAr: d.nameAr,
            description: d.description,
            fields: JSON.stringify(d.fields),
            relationships: JSON.stringify(d.relationships),
            constraints: JSON.stringify(d.constraints),
            rationale: d.rationale,
            status: 'proposed',
            order: count - 1,
          },
        })
      }
      await logDecision(id, 'Express: data model generated', `${count} entities`, 'design')
      return running(`Data model generated (${count} entities)`, 'Confirming the data model')
    }
    const entUnreviewed = entities.filter((e) => e.status === 'proposed' || e.status === 'needs_revision')
    if (entUnreviewed.length > 0) {
      await db.dataEntity.updateMany({
        where: { ideaId: id, status: { in: ['proposed', 'needs_revision'] } },
        data: { status: 'confirmed' },
      })
      await logDecision(id, 'Express: entities confirmed', `${entUnreviewed.length} confirmed by delegation`, 'design')
      return running(`Confirmed ${entUnreviewed.length} entities`, 'Defining the API contracts')
    }

    if (apis.length === 0) {
      const drafts = await generateApis({
        ctx: (await buildProjectContext(id))!,
        requirements,
        entityNames: entities.filter((e) => e.status === 'confirmed').map((e) => e.name),
        processNames: processes.filter((p) => p.status === 'confirmed').map((p) => p.name),
      })
      let count = 0
      for (const d of drafts) {
        await db.apiEndpoint.create({
          data: {
            ideaId: id,
            code: `API-${String(++count).padStart(2, '0')}`,
            method: d.method,
            path: d.path,
            purpose: d.purpose,
            auth: d.auth,
            request: JSON.stringify(d.request),
            errors: JSON.stringify(d.errors),
            linkedRequirements: JSON.stringify(d.linkedRequirements),
            linkedEntities: JSON.stringify(d.linkedEntities),
            status: 'proposed',
            order: count - 1,
          },
        })
      }
      await logDecision(id, 'Express: API contracts generated', `${count} endpoints`, 'design')
      return running(`API contracts generated (${count} endpoints)`, 'Confirming the API contracts')
    }
    const apiUnreviewed = apis.filter((a) => a.status === 'proposed' || a.status === 'needs_revision')
    if (apiUnreviewed.length > 0) {
      await db.apiEndpoint.updateMany({
        where: { ideaId: id, status: { in: ['proposed', 'needs_revision'] } },
        data: { status: 'confirmed' },
      })
      await logDecision(id, 'Express: API contracts confirmed', `${apiUnreviewed.length} confirmed by delegation`, 'design')
      return running(`Confirmed ${apiUnreviewed.length} API contracts`, 'Specifying the screens')
    }

    if (screens.length === 0) {
      const drafts = await generateScreens({ ctx: (await buildProjectContext(id))!, roles, requirements })
      let count = 0
      for (const d of drafts) {
        await db.screenSpec.create({
          data: {
            ideaId: id,
            code: `SCR-${String(++count).padStart(2, '0')}`,
            name: d.name,
            nameAr: d.nameAr,
            route: d.route,
            purpose: d.purpose,
            roles: JSON.stringify(d.roles),
            elements: JSON.stringify(d.elements),
            states: JSON.stringify(d.states),
            rtlNote: d.rtlNote,
            linkedRequirements: JSON.stringify(d.linkedRequirements),
            status: 'proposed',
            order: count - 1,
          },
        })
      }
      await logDecision(id, 'Express: screens generated', `${count} screens`, 'design')
      return running(`Screens specified (${count})`, 'Confirming the screens')
    }
    const scrUnreviewed = screens.filter((s) => s.status === 'proposed' || s.status === 'needs_revision')
    if (scrUnreviewed.length > 0) {
      await db.screenSpec.updateMany({
        where: { ideaId: id, status: { in: ['proposed', 'needs_revision'] } },
        data: { status: 'confirmed' },
      })
      await logDecision(id, 'Express: screens confirmed', `${scrUnreviewed.length} confirmed by delegation`, 'design')
      return running(`Confirmed ${scrUnreviewed.length} screens`, 'Recommending the architecture')
    }

    if (!arch) {
      const draft = await generateArchitecture({ ctx: (await buildProjectContext(id))!, requirements })
      await db.architectureDoc.create({
        data: {
          ideaId: id,
          components: JSON.stringify(draft.components),
          integrations: JSON.stringify(draft.integrations),
          techStack: JSON.stringify(draft.techStack),
          notes: draft.notes,
          status: 'proposed',
        },
      })
      await logDecision(id, 'Express: architecture recommended', 'Simplest-first proposal', 'design')
      return running('Architecture recommendation drafted', 'Confirming the architecture')
    }
    if (arch.status !== 'confirmed') {
      await db.architectureDoc.update({ where: { ideaId: id }, data: { status: 'confirmed' } })
      await logDecision(id, 'Express: architecture confirmed', `Previous status ${arch.status} → confirmed by delegation`, 'design')
      return running('Architecture confirmed (delegated)', 'Approving the system design')
    }

    await db.idea.update({ where: { id }, data: { stage: 'planning' } })
    await logDecision(id, 'Express: system design approved', 'All five design sets confirmed', 'design')
    return running('System design approved', 'Drafting the implementation plan')
  }

  // ===== Stage: planning =====
  if (idea.stage === 'planning') {
    const [tasks, risks] = await Promise.all([
      db.implTask.findMany({ where: { ideaId: id } }),
      db.riskItem.findMany({ where: { ideaId: id } }),
    ])

    if (tasks.length === 0) {
      const ctx = await buildProjectContext(id)
      if (!ctx) return blocked('Idea not found.')
      const [entities, apis, screens] = await Promise.all([
        db.dataEntity.findMany({ where: { ideaId: id, status: 'confirmed' } }),
        db.apiEndpoint.findMany({ where: { ideaId: id, status: 'confirmed' } }),
        db.screenSpec.findMany({ where: { ideaId: id, status: 'confirmed' } }),
      ])
      const drafts = await generateTasks({
        ctx,
        requirements: await loadRequirements(id),
        entityNames: entities.map((e) => e.name),
        apiPaths: apis.map((a) => `${a.method} ${a.path}`),
        screenNames: screens.map((s) => s.name),
      })
      const idToCode = new Map<string, string>()
      for (const d of drafts) idToCode.set(d.id, `T-${String(idToCode.size + 1).padStart(2, '0')}`)
      let order = 0
      for (const d of drafts) {
        await db.implTask.create({
          data: {
            ideaId: id,
            code: idToCode.get(d.id)!,
            title: d.title,
            titleAr: d.titleAr,
            description: d.description,
            phase: d.phase,
            priority: d.priority,
            dependsOn: JSON.stringify(d.dependsOn.map((dep) => idToCode.get(dep)).filter((c): c is string => !!c)),
            acceptanceCriteria: JSON.stringify(d.acceptanceCriteria),
            deliverable: d.deliverable,
            requirementCodes: JSON.stringify(d.requirementCodes),
            estimate: d.estimate,
            status: 'proposed',
            order: order++,
          },
        })
      }
      await logDecision(id, 'Express: implementation plan drafted', `${drafts.length} dependency-ordered tasks`, 'planning')
      return running(`Implementation plan drafted (${drafts.length} tasks)`, 'Confirming the tasks')
    }

    const taskUnreviewed = tasks.filter((t) => t.status === 'proposed' || t.status === 'needs_revision')
    if (taskUnreviewed.length > 0) {
      await db.implTask.updateMany({
        where: { ideaId: id, status: { in: ['proposed', 'needs_revision'] } },
        data: { status: 'confirmed' },
      })
      await logDecision(id, 'Express: tasks confirmed', `${taskUnreviewed.length} confirmed by delegation`, 'planning')
      return running(`Confirmed ${taskUnreviewed.length} tasks`, 'Identifying the risks')
    }

    if (risks.length === 0) {
      const ctx = await buildProjectContext(id)
      if (!ctx) return blocked('Idea not found.')
      const drafts = await generateRisks({ ctx, requirements: await loadRequirements(id) })
      let count = 0
      for (const d of drafts) {
        await db.riskItem.create({
          data: {
            ideaId: id,
            code: `RSK-${String(++count).padStart(2, '0')}`,
            category: d.category,
            description: d.description,
            likelihood: d.likelihood,
            impact: d.impact,
            mitigation: d.mitigation,
            basis: d.basis,
            status: 'proposed',
            order: count - 1,
          },
        })
      }
      await logDecision(id, 'Express: risk register generated', `${count} risks`, 'planning')
      return running(`Risk register generated (${count} risks)`, 'Deciding the risk mitigations')
    }

    const riskOpen = risks.filter((r) => r.status === 'proposed')
    if (riskOpen.length > 0) {
      await db.riskItem.updateMany({ where: { ideaId: id, status: 'proposed' }, data: { status: 'mitigated' } })
      await logDecision(id, 'Express: risks mitigated', `${riskOpen.length} mitigated by delegation`, 'planning')
      return running(`Mitigated ${riskOpen.length} risks`, 'Approving the plan & checking readiness')
    }

    await db.idea.update({ where: { id }, data: { stage: 'readiness' } })
    await logDecision(id, 'Express: implementation plan approved', 'Tasks and risks reviewed', 'planning')
    return running('Implementation plan approved', 'Running the consistency validation')
  }

  // ===== Stage: readiness =====
  if (idea.stage === 'readiness') {
    // Run consistency once (detected via the decision history)
    const decisions = await db.decision.findMany({
      where: { ideaId: id, action: { in: ['Consistency validation executed', 'Express: consistency validation executed'] } },
      select: { id: true },
    })
    if (decisions.length === 0) {
      const ctx = await buildProjectContext(id)
      if (!ctx) return blocked('Idea not found.')
      const detected = await runConsistencyCheck({ ideaId: id, ctx })
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
        'Express: consistency validation executed',
        detected.length === 0 ? 'No issues found' : `${detected.length} issue(s) detected (${critical} critical, ${major} major)`,
        'readiness'
      )
      return running(
        `Consistency validation done — ${detected.length} issue(s) found (${critical} critical)`,
        'Handling consistency issues'
      )
    }

    // Critical issues: the engineer FIRST tries to fix them himself
    // (delegated authority); only what is genuinely unfixable is
    // escalated to the client.
    const openCritical = await db.consistencyIssue.findMany({ where: { ideaId: id, status: 'open', severity: 'critical' } })
    if (openCritical.length > 0) {
      const fixed = await autoFixCriticalIssues(
        id,
        openCritical.map((i) => ({ id: i.id, description: i.description, affected: i.affected }))
      )
      if (fixed > 0) {
        return running(
          `Auto-fixed ${fixed} critical consistency issue(s) — the artifacts were updated and the fix is logged`,
          'Re-checking critical issues'
        )
      }
      return blocked(
        'Critical consistency issues need a human decision before the package can be locked. Resolve or dismiss them in the readiness stage, then re-run express.',
        openCritical.map((i) => i.description)
      )
    }

    // Minor issues are dismissed by delegation; major ones stay visible as warnings.
    const openMinor = await db.consistencyIssue.findMany({ where: { ideaId: id, status: 'open', severity: 'minor' } })
    if (openMinor.length > 0) {
      await db.consistencyIssue.updateMany({ where: { ideaId: id, status: 'open', severity: 'minor' }, data: { status: 'dismissed' } })
      await logDecision(id, 'Express: minor issues dismissed', `${openMinor.length} dismissed by delegation (major issues stay visible)`, 'readiness')
      return running(`Dismissed ${openMinor.length} minor consistency issues`, 'Checking the readiness gate')
    }

    // Unresolved must-have requirements are decided by the engineer
    // under delegation — each decision is logged with its reasoning.
    const unresolvedMust = await db.requirement.count({
      where: { ideaId: id, status: 'unresolved', priority: 'must' },
    })
    if (unresolvedMust > 0) {
      const n = await resolveUnresolvedMusts(id)
      return running(
        `Decided ${n} open must-have requirement(s) — each decision logged with its reasoning`,
        'Checking the readiness gate'
      )
    }

    // Coverage gap: confirmed FRs without a confirmed task (typically
    // requirements confirmed after the plan was drafted). The engineer
    // drafts targeted tasks for exactly the uncovered requirements.
    const [confirmedTasks, confirmedFRs, confirmedEntities, confirmedApis, confirmedScreens] = await Promise.all([
      db.implTask.findMany({ where: { ideaId: id, status: 'confirmed' } }),
      db.requirement.findMany({ where: { ideaId: id, status: 'confirmed', type: 'functional' } }),
      db.dataEntity.findMany({ where: { ideaId: id, status: 'confirmed' } }),
      db.apiEndpoint.findMany({ where: { ideaId: id, status: 'confirmed' } }),
      db.screenSpec.findMany({ where: { ideaId: id, status: 'confirmed' } }),
    ])
    const taskLinks = new Set(confirmedTasks.flatMap((t) => safeArr(t.requirementCodes)))
    const uncovered = confirmedFRs.filter((r) => !taskLinks.has(r.code))
    if (uncovered.length > 0) {
      const ctx = await buildProjectContext(id)
      if (!ctx) return blocked('Idea not found.')
      const uncoveredSet = new Set(uncovered.map((u) => u.code))
      const drafts = await generateTasks({
        ctx,
        requirements: await loadRequirements(id),
        entityNames: confirmedEntities.map((e) => e.name),
        apiPaths: confirmedApis.map((a) => `${a.method} ${a.path}`),
        screenNames: confirmedScreens.map((s) => s.name),
      })
      const targeted = drafts.filter((d) => d.requirementCodes.some((c) => uncoveredSet.has(c))).slice(0, 8)
      if (targeted.length === 0) {
        return blocked(
          'These confirmed requirements have no implementation task and the engineer could not draft one automatically:',
          uncovered.map((u) => `${u.code}: ${u.title}`)
        )
      }
      const existingCount = await db.implTask.count({ where: { ideaId: id } })
      let n = 0
      const idToCode = new Map<string, string>()
      for (const d of targeted) idToCode.set(d.id, `T-${String(existingCount + idToCode.size + 1).padStart(2, '0')}`)
      for (const d of targeted) {
        await db.implTask.create({
          data: {
            ideaId: id,
            code: idToCode.get(d.id)!,
            title: d.title,
            titleAr: d.titleAr,
            description: d.description,
            phase: d.phase,
            priority: d.priority,
            dependsOn: JSON.stringify(d.dependsOn.map((dep) => idToCode.get(dep)).filter((c): c is string => !!c)),
            acceptanceCriteria: JSON.stringify(d.acceptanceCriteria),
            deliverable: d.deliverable,
            requirementCodes: JSON.stringify(d.requirementCodes),
            estimate: d.estimate,
            status: 'confirmed',
            order: existingCount + n,
          },
        })
        n++
      }
      await logDecision(
        id,
        'Express: coverage tasks added',
        `${n} task(s) drafted and confirmed by delegation to cover ${uncovered.map((u) => u.code).join(', ')}`,
        'readiness'
      )
      return running(
        `Drafted ${n} task(s) to cover the newly confirmed requirements (${uncovered.map((u) => u.code).join(', ')})`,
        'Checking the readiness gate'
      )
    }

    const report = await computeReadiness(id)
    if (!report.lockable) {
      return blocked(
        'The readiness gate still has hard blockers. Fix them in the readiness stage, then re-run express.',
        report.blockers
      )
    }

    await db.idea.update({ where: { id }, data: { stage: 'package' } })
    await logDecision(id, 'Express: readiness gate passed — package locked', `Readiness score ${report.score}%`, 'readiness')
    return running(`Readiness gate passed (${report.score}%) — package locked`, 'Done')
  }

  // ===== Stage: package =====
  return { status: 'done', step: 'Engineering package ready' }
}
