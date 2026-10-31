import { chatJson } from '@/lib/ai'
import type { Feature, ProcessFlow, Requirement, ScreenSpec } from '@/lib/types'
import type { ProjectContext } from '@/lib/engines/context'
import { contextToPrompt } from '@/lib/engines/context'

// ============================================================
// The QA Lab engines — the complete Tester toolset.
//   1. Test Suite    — unit/integration cases derived from the
//      confirmed requirements and their acceptance criteria:
//      happy path, negative, boundary and security cases, each
//      traced to a requirement code and (when it targets one) a
//      specific criterion. Reviewed case by case.
//   2. Edge cases    — the adversarial brainstorm the happy path
//      always forgets, grouped by feature, with concrete
//      how-to-test instructions and honest risk ratings.
//   3. E2E scenarios — critical user journeys written as
//      Given/When/Then with a persona, the screens they pass
//      through, and smoke priority for the money path.
// Discipline shared with the rest of the platform: every case
// references confirmed requirement codes only; rejected output
// is fed back so the engine never repeats it; the coverage
// score is computed by the APPLICATION from stored cases, never
// by the model. NO LIMITS: all three run from ANY stage.
// ============================================================

const asStrings = (v: unknown, max: number): string[] =>
  Array.isArray(v) ? v.filter((s): s is string => typeof s === 'string' && s.trim().length > 0).slice(0, max) : []

const asTrimmed = (v: unknown): string | null => (typeof v === 'string' && v.trim() ? v.trim() : null)

function feedbackBlock(feedback?: string): string {
  const f = feedback?.trim()
  if (!f) return ''
  return `\n\nCLIENT FEEDBACK — the client rejected or wants to steer the previous output. You MUST change the analysis to address these notes:\n"""\n${f}\n"""`
}

function requirementsBlock(requirements: Requirement[]): string {
  const confirmed = requirements.filter((r) => r.status === 'confirmed')
  if (!confirmed.length) return '(no confirmed requirements yet — base the cases on the idea context)'
  return confirmed
    .map((r) => {
      const head = `- ${r.code} [${r.type === 'functional' ? 'FR' : 'NFR'}${r.category ? `:${r.category}` : ''}] ${r.title} — ${r.description}`
      const ac = r.acceptanceCriteria.length
        ? `\n  Acceptance criteria (index: text):\n${r.acceptanceCriteria.map((c, i) => `  ${i + 1}: ${c}`).join('\n')}`
        : ''
      return head + ac
    })
    .join('\n')
}

// ------------------------------------------------------------
// 1. Test Suite — cases derived from requirements + criteria
// ------------------------------------------------------------

export interface TestCaseDraft {
  title: string
  level: 'unit' | 'integration'
  kind: 'happy' | 'negative' | 'boundary' | 'security'
  linkedRequirement: string
  linkedCriterion: number | null
  preconditions: string[]
  steps: string[]
  expected: string
  priority: 'high' | 'medium' | 'low'
}

const SUITE_PROMPT = `You are the Test Suite engine of an AI software engineer platform.
Derive the test suite from the confirmed requirements and their acceptance criteria — every case must verify a real commitment the client approved.

Rules:
- Produce 8-16 test cases. Every "linkedRequirement" MUST be a code from the provided list; nothing else.
- For each functional requirement with acceptance criteria, cover its criteria: a happy-path case per requirement, plus negative/boundary cases where the criterion describes limits, formats, or permissions. When a case targets one specific criterion, set "linkedCriterion" to its 1-based index; when it covers the requirement as a whole, set it to null.
- Include 1-3 "security" cases (injection, privilege escalation, data exposure) tied to the requirements that create the risk — but ONLY where this product's design genuinely faces them; no textbook filler.
- "level": "unit" for a single function/rule/validation in isolation; "integration" for a flow across components (API + storage + UI state).
- "kind" is exactly one of: happy, negative, boundary, security.
- "preconditions": 0-3 concrete setup facts. "steps": 1-5 concrete actions a tester performs. "expected": the observable, verifiable outcome — never "works correctly"; say exactly what is observed.
- "priority": high for the core value path and money/data integrity, medium for common flows, low for rare ones.
- NEVER duplicate the rejected cases listed below, and never invent requirements.

Return STRICT JSON only:
{"cases": [{"title": "...", "level": "unit", "kind": "happy", "linkedRequirement": "FR-001", "linkedCriterion": 1, "preconditions": ["..."], "steps": ["..."], "expected": "...", "priority": "high"}]}`

export async function generateTestSuite(params: {
  ctx: ProjectContext
  requirements: Requirement[]
  focusGaps?: Array<{ requirement: string; reason: string }>
  rejectedTitles?: string[]
  feedback?: string
}): Promise<TestCaseDraft[]> {
  const { ctx, requirements } = params
  const gapBlock = params.focusGaps?.length
    ? `\n\nCurrent coverage GAPS — prioritize new cases for these (existing cases already cover the rest):\n${params.focusGaps
        .slice(0, 12)
        .map((g) => `- ${g.requirement}: ${g.reason}`)
        .join('\n')}`
    : ''
  const rejectedBlock = params.rejectedTitles?.length
    ? `\n\nThe client REJECTED these previous test cases (produce materially different ones, not renamed repeats):\n${params.rejectedTitles.slice(0, 12).map((r) => `- ${r}`).join('\n')}`
    : ''
  const raw = await chatJson<{ cases?: Array<Record<string, unknown>> }>(
    SUITE_PROMPT,
    `${contextToPrompt(ctx)}\n\nConfirmed requirements with acceptance criteria (valid codes):\n${requirementsBlock(requirements)}${gapBlock}${rejectedBlock}${feedbackBlock(params.feedback)}`
  )

  const confirmed = new Set(requirements.filter((r) => r.status === 'confirmed').map((r) => r.code))
  const levels = new Set(['unit', 'integration'])
  const kinds = new Set(['happy', 'negative', 'boundary', 'security'])
  const priorities = new Set(['high', 'medium', 'low'])

  return (Array.isArray(raw?.cases) ? raw.cases : [])
    .map((c): TestCaseDraft | null => {
      const title = typeof c.title === 'string' ? c.title.trim() : ''
      const linkedRequirement = typeof c.linkedRequirement === 'string' ? c.linkedRequirement.trim() : ''
      const expected = typeof c.expected === 'string' ? c.expected.trim() : ''
      if (!title || !expected || !confirmed.has(linkedRequirement)) return null
      const level = levels.has(String(c.level)) ? (c.level as TestCaseDraft['level']) : 'integration'
      const kind = kinds.has(String(c.kind)) ? (c.kind as TestCaseDraft['kind']) : 'happy'
      const priority = priorities.has(String(c.priority)) ? (c.priority as TestCaseDraft['priority']) : 'medium'
      const criterionRaw = typeof c.linkedCriterion === 'number' ? c.linkedCriterion : parseInt(String(c.linkedCriterion), 10)
      const linkedCriterion = Number.isInteger(criterionRaw) && criterionRaw >= 1 && criterionRaw <= 12 ? criterionRaw : null
      const steps = asStrings(c.steps, 5)
      if (steps.length === 0) return null
      return {
        title,
        level,
        kind,
        linkedRequirement,
        linkedCriterion,
        preconditions: asStrings(c.preconditions, 3),
        steps,
        expected,
        priority,
      }
    })
    .filter((c): c is TestCaseDraft => c !== null)
    .slice(0, 16)
}

// ------------------------------------------------------------
// 2. Edge case brainstorm — what the happy path forgets
// ------------------------------------------------------------

export interface EdgeCaseDraft {
  scenario: string
  category: string
  risk: 'low' | 'medium' | 'high'
  howToTest: string
  linkedRequirement: string | null
}

export interface EdgeCaseGroupDraft {
  feature: string
  cases: EdgeCaseDraft[]
}

const EDGE_CATEGORIES = [
  'boundary_input',
  'empty_state',
  'permissions',
  'concurrency',
  'network_failure',
  'data_volume',
  'arabic_rtl',
  'payment_failure',
  'time_timezone',
  'adversarial',
] as const

const EDGE_PROMPT = `You are the Edge Case engine of an AI software engineer platform.
Brainstorm the edge cases the happy path always forgets — the ones that break real products — grouped by feature.

Rules:
- Produce 3-6 groups. "feature" is a feature/module name from the provided list (or a close, existing one — never invent features).
- Each group has 2-4 cases. Each case: "scenario" (one concrete sentence describing the situation), "category" (exactly one of: ${EDGE_CATEGORIES.join(', ')}), "risk" (low/medium/high — honest: how bad is it if it ships broken), "howToTest" (the concrete way to reproduce it — steps or inputs, not a platitude), and "linkedRequirement" (a requirement code from the provided list when the case stresses a specific commitment, else null).
- Ground every case in THIS product's realities (its roles, its data, its money flows, its Arabic-first UI). No generic textbook cases.
- Prefer fewer, sharper cases over padding. If a category does not apply to this product, skip it.

Return STRICT JSON only:
{"groups": [{"feature": "...", "cases": [{"scenario": "...", "category": "boundary_input", "risk": "high", "howToTest": "...", "linkedRequirement": "FR-002"}]}], "note": "..."}`

export interface EdgeCaseDocDraft {
  groups: EdgeCaseGroupDraft[]
  note: string | null
}

export async function generateEdgeCases(params: {
  ctx: ProjectContext
  features: Feature[]
  requirements: Requirement[]
  feedback?: string
}): Promise<EdgeCaseDocDraft> {
  const { ctx, requirements } = params
  const featureList = params.features.length
    ? params.features.map((f) => `- ${f.module} / ${f.feature} (user: ${f.user}, priority: ${f.priority})`).join('\n')
    : '(no accepted features yet — group by the product\'s core capabilities from the context)'
  const raw = await chatJson<Record<string, unknown>>(
    EDGE_PROMPT,
    `${contextToPrompt(ctx)}\n\nFeatures:\n${featureList}\n\nConfirmed requirements (valid codes):\n${requirementsBlock(requirements)}${feedbackBlock(params.feedback)}`
  )

  const confirmed = new Set(requirements.filter((r) => r.status === 'confirmed').map((r) => r.code))
  const risks = new Set(['low', 'medium', 'high'])
  const categories = new Set<string>(EDGE_CATEGORIES)

  const groups: EdgeCaseGroupDraft[] = (Array.isArray(raw?.groups) ? raw.groups : [])
    .map((g): EdgeCaseGroupDraft | null => {
      const m = g as Record<string, unknown>
      const feature = typeof m.feature === 'string' ? m.feature.trim() : ''
      if (!feature) return null
      const cases = (Array.isArray(m.cases) ? m.cases : [])
        .map((c): EdgeCaseDraft | null => {
          const cm = c as Record<string, unknown>
          const scenario = typeof cm.scenario === 'string' ? cm.scenario.trim() : ''
          const howToTest = typeof cm.howToTest === 'string' ? cm.howToTest.trim() : ''
          if (!scenario || !howToTest) return null
          const risk = risks.has(String(cm.risk)) ? (cm.risk as EdgeCaseDraft['risk']) : 'medium'
          const categoryRaw = typeof cm.category === 'string' ? cm.category.trim().toLowerCase().replace(/[\s-]+/g, '_') : ''
          const linked = typeof cm.linkedRequirement === 'string' ? cm.linkedRequirement.trim() : ''
          return {
            scenario,
            category: categories.has(categoryRaw) ? categoryRaw : 'adversarial',
            risk,
            howToTest,
            linkedRequirement: confirmed.has(linked) ? linked : null,
          }
        })
        .filter((c): c is EdgeCaseDraft => c !== null)
        .slice(0, 4)
      if (cases.length === 0) return null
      return { feature, cases }
    })
    .filter((g): g is EdgeCaseGroupDraft => g !== null)
    .slice(0, 6)

  if (groups.length === 0) throw new Error('No edge case groups returned')

  return { groups, note: asTrimmed(raw?.note) }
}

// ------------------------------------------------------------
// 3. E2E scenarios — critical journeys as Given/When/Then
// ------------------------------------------------------------

export interface E2eScenarioDraft {
  title: string
  persona: string
  given: string[]
  when: string[]
  then: string[]
  screens: string[]
  priority: 'smoke' | 'high' | 'medium'
  linkedRequirements: string[]
}

const E2E_PROMPT = `You are the E2E Scenario engine of an AI software engineer platform.
Write the end-to-end test scenarios that must pass before this product ships — the critical user journeys.

Rules:
- Produce 3-6 scenarios. The FIRST must be the smoke test: the shortest journey that proves the product's core value works end to end (the "money path" or equivalent).
- Each scenario: "title" (imperative, e.g. "Merchant requests quotes from three suppliers"), "persona" (a role from this product — use its real role names), "given" (1-3 pre-state facts), "when" (1-4 user actions in order), "then" (1-4 observable outcomes — include the verifiable assertion, e.g. "the quotation appears with all three supplier offers sorted by price"), "screens" (the screen names from the provided list the journey passes through — never invent screens), "priority" (smoke | high | medium), "linkedRequirements" (the confirmed requirement codes this journey proves).
- Ground every scenario in THIS product's processes and screens. If no screens are provided, use the journey's logical steps instead and say so in the title.
- No filler: a scenario that does not protect real value should not exist.

Return STRICT JSON only:
{"scenarios": [{"title": "...", "persona": "...", "given": ["..."], "when": ["..."], "then": ["..."], "screens": ["..."], "priority": "smoke", "linkedRequirements": ["FR-001"]}]}`

export async function generateE2eScenarios(params: {
  ctx: ProjectContext
  processes: ProcessFlow[]
  screens: ScreenSpec[]
  requirements: Requirement[]
  rejectedTitles?: string[]
  feedback?: string
}): Promise<E2eScenarioDraft[]> {
  const { ctx, requirements } = params
  const surfaceBlock = [
    params.processes.length
      ? `Business processes:\n${params.processes.map((p) => `- ${p.code} ${p.name} (${p.actors.join(', ')})`).join('\n')}`
      : '',
    params.screens.length ? `Screens (use these exact names):\n${params.screens.map((s) => `- ${s.name}`).join('\n')}` : '',
  ]
    .filter(Boolean)
    .join('\n\n')
  const rejectedBlock = params.rejectedTitles?.length
    ? `\n\nThe client REJECTED these previous scenarios (produce materially better ones, not renamed repeats):\n${params.rejectedTitles.slice(0, 8).map((r) => `- ${r}`).join('\n')}`
    : ''
  const raw = await chatJson<{ scenarios?: Array<Record<string, unknown>> }>(
    E2E_PROMPT,
    `${contextToPrompt(ctx)}${surfaceBlock ? '\n\n' + surfaceBlock : ''}\n\nConfirmed requirements (valid codes):\n${requirementsBlock(requirements)}${rejectedBlock}${feedbackBlock(params.feedback)}`
  )

  const confirmed = new Set(requirements.filter((r) => r.status === 'confirmed').map((r) => r.code))
  const priorities = new Set(['smoke', 'high', 'medium'])

  const scenarios = (Array.isArray(raw?.scenarios) ? raw.scenarios : [])
    .map((s): E2eScenarioDraft | null => {
      const m = s as Record<string, unknown>
      const title = typeof m.title === 'string' ? m.title.trim() : ''
      if (!title) return null
      const when = asStrings(m.when, 4)
      const then = asStrings(m.then, 4)
      if (when.length === 0 || then.length === 0) return null
      const priority = priorities.has(String(m.priority)) ? (m.priority as E2eScenarioDraft['priority']) : 'high'
      return {
        title,
        persona: asTrimmed(m.persona) ?? 'the user',
        given: asStrings(m.given, 3),
        when,
        then,
        screens: asStrings(m.screens, 5),
        priority,
        linkedRequirements: asStrings(m.linkedRequirements, 6).filter((c) => confirmed.has(c)),
      }
    })
    .filter((s): s is E2eScenarioDraft => s !== null)
    .slice(0, 6)

  if (scenarios.length === 0) throw new Error('No E2E scenarios returned')

  // The smoke case, if any, is always first
  scenarios.sort((a, b) => {
    const rank = (p: E2eScenarioDraft['priority']) => (p === 'smoke' ? 0 : p === 'high' ? 1 : 2)
    return rank(a.priority) - rank(b.priority)
  })
  return scenarios
}
