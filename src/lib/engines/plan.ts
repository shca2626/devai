import { chatJson } from '@/lib/ai'
import type { Priority, Requirement } from '@/lib/types'
import type { ProjectContext } from '@/lib/engines/context'
import { contextToPrompt } from '@/lib/engines/context'

// ============================================================
// Engines 10 & 11 — Engineering Planning + Quality & Security.
// Tasks are dependency-ordered, traceable to requirements, and
// each has acceptance criteria so another programmer can pick
// them up without re-reading the original conversation.
// ============================================================

export interface TaskDraft {
  id: string // LLM-internal reference (T1, T2…) used for dependency mapping
  title: string
  titleAr: string | null
  description: string
  phase: number
  priority: Priority
  dependsOn: string[] // ids from this same batch (T1, T2…)
  acceptanceCriteria: string[]
  deliverable: string
  requirementCodes: string[]
  estimate: string
}

const TASK_PROMPT = `You are the Engineering Planning engine of an AI software engineer platform.
Break the confirmed scope into small, dependency-ordered implementation tasks.

Rules:
- Produce 14-24 tasks across 3-5 phases. Phase 1 = foundations (project setup, data model, auth), middle phases = core value flows, later phases = secondary features, hardening and launch preparation.
- Give each task an "id": "T1", "T2", … and reference dependencies via those ids in "dependsOn" (a task must not start before its dependencies complete). Order tasks so dependencies come first.
- Each task description must be self-contained: another programmer should execute it WITHOUT access to the original client conversation. Say exactly what to build and reference the relevant artifacts (requirement codes, entity names, API paths, screen names) inside the description.
- "requirementCodes": the confirmed requirement codes this task implements (traceability) — from the provided list only.
- "acceptanceCriteria": 2-3 verifiable completion criteria for the task itself (not the requirement).
- "deliverable": the concrete outcome (e.g. "migrations + model tests", "working /api/v1/quotations endpoint with validation and error codes").
- "estimate": "S" (<0.5d), "M" (0.5-2d), "L" (>2d).
- Titles in English + Arabic ("titleAr").

Return STRICT JSON only:
{"tasks": [{"id": "T1", "title": "...", "titleAr": "...", "description": "...", "phase": 1, "priority": "must", "dependsOn": [], "acceptanceCriteria": ["..."], "deliverable": "...", "requirementCodes": ["FR-001"], "estimate": "M"}]}`

export async function generateTasks(params: {
  ctx: ProjectContext
  requirements: Requirement[]
  entityNames: string[]
  apiPaths: string[]
  screenNames: string[]
}): Promise<TaskDraft[]> {
  const { ctx, requirements, entityNames, apiPaths, screenNames } = params
  const raw = await chatJson<{ tasks?: Array<Record<string, unknown>> }>(
    TASK_PROMPT,
    `${contextToPrompt(ctx)}\n\nConfirmed requirements (valid codes):\n${requirements
      .filter((r) => r.status === 'confirmed')
      .map((r) => `- ${r.code}: ${r.title}`)
      .join('\n')}\n\nApproved data entities: ${entityNames.join(', ') || '(none)'}\nApproved API endpoints: ${apiPaths.join(', ') || '(none)'}\nApproved screens: ${screenNames.join(', ') || '(none)'}`
  )

  const validCodes = new Set(requirements.filter((r) => r.status === 'confirmed').map((r) => r.code))
  const PRIORITIES: Priority[] = ['must', 'should', 'could']
  const ids = new Set<string>()

  return (Array.isArray(raw?.tasks) ? raw.tasks : [])
    .map((t) => {
      const id = typeof t.id === 'string' ? t.id.trim() : ''
      const title = typeof t.title === 'string' ? t.title.trim() : ''
      const description = typeof t.description === 'string' ? t.description.trim() : ''
      if (!id || !title || !description) return null
      ids.add(id)
      const criteria = Array.isArray(t.acceptanceCriteria)
        ? t.acceptanceCriteria.filter((c): c is string => typeof c === 'string' && c.trim().length > 0).slice(0, 4)
        : []
      return {
        id,
        title,
        titleAr: typeof t.titleAr === 'string' && t.titleAr.trim() ? t.titleAr.trim() : null,
        description,
        phase: typeof t.phase === 'number' && t.phase >= 1 && t.phase <= 5 ? Math.floor(t.phase) : 1,
        priority: PRIORITIES.includes(t.priority as Priority) ? (t.priority as Priority) : 'should',
        dependsOn: Array.isArray(t.dependsOn)
          ? t.dependsOn.filter((d): d is string => typeof d === 'string' && d.trim().length > 0 && d.trim() !== id)
          : [],
        acceptanceCriteria: criteria.length ? criteria : [`Task "${title}" is complete and verified`],
        deliverable: typeof t.deliverable === 'string' && t.deliverable.trim() ? t.deliverable.trim() : title,
        requirementCodes: Array.isArray(t.requirementCodes)
          ? t.requirementCodes.filter((c): c is string => typeof c === 'string' && validCodes.has(c))
          : [],
        estimate: ['S', 'M', 'L'].includes(String(t.estimate)) ? String(t.estimate) : 'M',
      } satisfies TaskDraft
    })
    .filter((t): t is TaskDraft => t !== null)
    .slice(0, 24)
}

// ------------------------------------------------------------
// Quality & Security — risk register
// ------------------------------------------------------------

export interface RiskDraft {
  category: 'security' | 'privacy' | 'performance' | 'operational' | 'financial' | 'scalability' | 'business'
  description: string
  likelihood: 'low' | 'medium' | 'high'
  impact: 'low' | 'medium' | 'high' | 'critical'
  mitigation: string
  basis: 'verified_fact' | 'professional_judgment'
}

const RISK_PROMPT = `You are the Quality & Security engine of an AI software engineer platform.
Identify the significant risks for this product across: security, privacy, performance, operational, financial, scalability and business.

Rules:
- Produce 6-10 risks. Identify them EARLY, be specific to THIS product (e.g. "suppliers may enter misleading prices" is a real business risk for a price-comparison marketplace — say what mitigation the spec needs).
- "basis": "verified_fact" when the risk follows directly from the approved scope/answers; "professional_judgment" for your professional assessment.
- "mitigation": one concrete mitigation the specification should adopt (a rule, a control, a test, a process).
- Rate likelihood and impact honestly — do not inflate.

Return STRICT JSON only:
{"risks": [{"category": "security", "description": "...", "likelihood": "medium", "impact": "high", "mitigation": "...", "basis": "professional_judgment"}]}`

export async function generateRisks(params: { ctx: ProjectContext; requirements: Requirement[] }): Promise<RiskDraft[]> {
  const { ctx, requirements } = params
  const raw = await chatJson<{ risks?: Array<Record<string, unknown>> }>(
    RISK_PROMPT,
    `${contextToPrompt(ctx)}\n\nConfirmed requirements:\n${requirements
      .filter((r) => r.status === 'confirmed')
      .map((r) => `- ${r.code} [${r.type}${r.category ? ':' + r.category : ''}]: ${r.title}`)
      .join('\n')}`
  )

  const CATEGORIES = ['security', 'privacy', 'performance', 'operational', 'financial', 'scalability', 'business']
  const LEVELS = ['low', 'medium', 'high']
  const IMPACTS = ['low', 'medium', 'high', 'critical']

  return (Array.isArray(raw?.risks) ? raw.risks : [])
    .map((r) => {
      const description = typeof r.description === 'string' ? r.description.trim() : ''
      if (!description) return null
      return {
        category: (CATEGORIES.includes(String(r.category)) ? String(r.category) : 'business') as RiskDraft['category'],
        description,
        likelihood: (LEVELS.includes(String(r.likelihood)) ? String(r.likelihood) : 'medium') as RiskDraft['likelihood'],
        impact: (IMPACTS.includes(String(r.impact)) ? String(r.impact) : 'medium') as RiskDraft['impact'],
        mitigation: typeof r.mitigation === 'string' && r.mitigation.trim() ? r.mitigation.trim() : '',
        basis: r.basis === 'verified_fact' ? 'verified_fact' : 'professional_judgment',
      } satisfies RiskDraft
    })
    .filter((r): r is RiskDraft => r !== null)
    .slice(0, 10)
}
