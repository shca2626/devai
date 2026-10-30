import { chatJson } from '@/lib/ai'
import type { Requirement } from '@/lib/types'
import type { ProjectContext } from '@/lib/engines/context'
import { contextToPrompt } from '@/lib/engines/context'
import type {
  AdrAlternative,
  AdrConsequences,
  ScaleAssumption,
  ScaleBottleneck,
  ScaleScenario,
  ThreatFinding,
  TradeCandidate,
} from '@/lib/types'

// ============================================================
// The Architect Lab engines — the complete Architect toolset.
//   1. Trade-off study  — candidate architectures compared
//      honestly (pros/cons/cost/complexity/teamFit/risks) with
//      a reasoned recommendation, never a single answer.
//   2. ADR generator     — Architecture Decision Records in the
//      classic Context → Decision → Consequences discipline.
//   3. STRIDE threat model — systematic security analysis across
//      the six STRIDE categories, grounded in this design.
//   4. Scale simulation  — what breaks at 10x/100x, bottleneck
//      by bottleneck, with the first fix for each.
// All outputs reference confirmed requirement codes only; every
// engine can be re-run with client feedback it MUST address.
// NO LIMITS: all four run from ANY stage, any number of times.
// ============================================================

function requirementsDigest(requirements: Requirement[], onlyConfirmed = true): string {
  const list = onlyConfirmed ? requirements.filter((r) => r.status === 'confirmed') : requirements
  if (!list.length) return '(no confirmed requirements yet — base the analysis on the idea context)'
  return list.map((r) => `- ${r.code} [${r.type === 'functional' ? 'FR' : 'NFR'}${r.category ? `:${r.category}` : ''}] ${r.title}`).join('\n')
}

function feedbackBlock(feedback?: string): string {
  const f = feedback?.trim()
  if (!f) return ''
  return `\n\nCLIENT FEEDBACK — the client rejected or wants to steer the previous output. You MUST change the analysis to address these notes:\n"""\n${f}\n"""`
}

const asStrings = (v: unknown, max: number): string[] =>
  Array.isArray(v) ? v.filter((s): s is string => typeof s === 'string' && s.trim().length > 0).slice(0, max) : []

const asTrimmed = (v: unknown): string | null => (typeof v === 'string' && v.trim() ? v.trim() : null)

// ------------------------------------------------------------
// 1. Trade-off study — candidate architectures + recommendation
// ------------------------------------------------------------

export interface TradeStudyDraft {
  candidates: TradeCandidate[]
  recommended: string
  rationale: string | null
  linkedRequirements: string[]
}

const TRADEOFF_PROMPT = `You are the Architecture Trade-off engine of an AI software engineer platform.
Compare REAL candidate architectures for this product honestly, then recommend one with reasons.

Rules:
- Produce exactly 3 materially different candidates (e.g. simplest-first monolith, mainstream stack, and a more distributed/managed option). Different in substance, not in naming.
- Each candidate: one-line "summary", the architectural "style" (e.g. "Modular monolith on a single server"), 2-4 "pros", 2-4 "cons", "cost" (e.g. "low — one $20 VPS"), "complexity" (low/medium/high + one clause), "teamFit" (what team it assumes), 1-3 "risks", and "fit" (one honest sentence: how well it satisfies the confirmed requirements).
- NEVER pad: if a candidate is a poor fit, say so in "fit" and "cons".
- "recommended" must be the exact "name" of the winning candidate. Prefer the simplest candidate that satisfies the confirmed requirements — but say honestly when a heavier option is genuinely needed.
- "rationale": why the winner wins, and the specific signals (load, team, budget, requirements) that would change the pick.
- "linkedRequirements": the requirement codes that drive the choice (from the provided list only).

Return STRICT JSON only:
{"candidates": [{"name": "...", "style": "...", "summary": "...", "pros": ["..."], "cons": ["..."], "cost": "...", "complexity": "...", "teamFit": "...", "risks": ["..."], "fit": "..."}], "recommended": "...", "rationale": "...", "linkedRequirements": ["FR-001"]}`

export async function generateTradeStudy(params: {
  ctx: ProjectContext
  requirements: Requirement[]
  currentStack?: Array<{ area: string; choice: string }>
  feedback?: string
}): Promise<TradeStudyDraft> {
  const { ctx, requirements } = params
  const stackBlock = params.currentStack?.length
    ? `\n\nThe client already confirmed this tech stack — the candidates must respect it where sensible:\n${params.currentStack.map((s) => `- ${s.area}: ${s.choice}`).join('\n')}`
    : ''
  const raw = await chatJson<Record<string, unknown>>(
    TRADEOFF_PROMPT,
    `${contextToPrompt(ctx)}\n\nConfirmed requirements (valid codes):\n${requirementsDigest(requirements)}${stackBlock}${feedbackBlock(params.feedback)}`
  )

  const validCodes = new Set(requirements.filter((r) => r.status === 'confirmed').map((r) => r.code))
  const candidates: TradeCandidate[] = (Array.isArray(raw?.candidates) ? raw.candidates : [])
    .map((c): TradeCandidate | null => {
      const m = c as Record<string, unknown>
      const name = typeof m.name === 'string' ? m.name.trim() : ''
      if (!name) return null
      return {
        name,
        style: asTrimmed(m.style) ?? '',
        summary: asTrimmed(m.summary) ?? '',
        pros: asStrings(m.pros, 4),
        cons: asStrings(m.cons, 4),
        cost: asTrimmed(m.cost) ?? '',
        complexity: asTrimmed(m.complexity) ?? '',
        teamFit: asTrimmed(m.teamFit) ?? '',
        risks: asStrings(m.risks, 3),
        fit: asTrimmed(m.fit) ?? '',
      }
    })
    .filter((c): c is TradeCandidate => c !== null)
    .slice(0, 3)

  if (candidates.length < 2) throw new Error('Fewer than 2 candidates returned')

  const recommendedRaw = typeof raw?.recommended === 'string' ? raw.recommended.trim() : ''
  const recommended =
    candidates.find((c) => c.name === recommendedRaw)?.name ?? candidates[0].name

  return {
    candidates,
    recommended,
    rationale: asTrimmed(raw?.rationale as unknown),
    linkedRequirements: asStrings(raw?.linkedRequirements, 10).filter((c) => validCodes.has(c)),
  }
}

// ------------------------------------------------------------
// 2. ADR generator — Architecture Decision Records
// ------------------------------------------------------------

export interface AdrDraft {
  title: string
  titleAr: string | null
  context: string
  decision: string
  alternatives: AdrAlternative[]
  consequences: AdrConsequences
  linkedRequirements: string[]
}

const ADR_PROMPT = `You are the Architecture Decision Record engine of an AI software engineer platform.
Write the ADRs this project actually needs — the significant, hard-to-reverse choices.

Rules:
- Produce 3-6 ADRs covering the significant choices: data storage, architecture style, authentication approach, integration style, and any choice the confirmed requirements force (only ones this project genuinely faces).
- Each ADR follows the classic discipline:
  - "context": the forces at play — the requirements, constraints, team and cost realities that make this decision necessary (2-4 sentences).
  - "decision": ONE imperative statement of what was chosen (e.g. "Use SQLite via Prisma as the only database; no separate DB server in v1.").
  - "alternatives": 1-3 rejected options, each with the honest "whyNot".
  - "consequences": {positive[], negative[], risks[]} — 1-3 each, concrete and specific to THIS product, never generic filler.
- Titles in English + Arabic ("titleAr", professional MSA).
- "linkedRequirements": the requirement codes driving this decision (from the provided list only).
- Do NOT write ADRs for trivial or reversible choices.

Return STRICT JSON only:
{"adrs": [{"title": "...", "titleAr": "...", "context": "...", "decision": "...", "alternatives": [{"option": "...", "whyNot": "..."}], "consequences": {"positive": ["..."], "negative": ["..."], "risks": ["..."]}, "linkedRequirements": ["FR-001"]}]}`

export async function generateAdrs(params: {
  ctx: ProjectContext
  requirements: Requirement[]
  existingChoices?: string[]
  rejectedTitles?: string[]
  feedback?: string
}): Promise<AdrDraft[]> {
  const { ctx, requirements } = params
  const existingBlock = params.existingChoices?.length
    ? `\n\nThe client already holds these standing decisions — do not contradict them, and do not restate them as ADRs unless the ADR adds real analysis:\n${params.existingChoices.map((c) => `- ${c}`).join('\n')}`
    : ''
  const rejectedBlock = params.rejectedTitles?.length
    ? `\n\nThe client REJECTED these previous ADR titles (produce materially better ones, not renamed repeats):\n${params.rejectedTitles.map((r) => `- ${r}`).join('\n')}`
    : ''
  const raw = await chatJson<{ adrs?: Array<Record<string, unknown>> }>(
    ADR_PROMPT,
    `${contextToPrompt(ctx)}\n\nConfirmed requirements (valid codes):\n${requirementsDigest(requirements)}${existingBlock}${rejectedBlock}${feedbackBlock(params.feedback)}`
  )

  const validCodes = new Set(requirements.filter((r) => r.status === 'confirmed').map((r) => r.code))
  const clean = (codes: unknown): string[] =>
    Array.isArray(codes) ? codes.filter((c): c is string => typeof c === 'string' && validCodes.has(c)) : []

  return (Array.isArray(raw?.adrs) ? raw.adrs : [])
    .map((a): AdrDraft | null => {
      const title = typeof a.title === 'string' ? a.title.trim() : ''
      const decision = typeof a.decision === 'string' ? a.decision.trim() : ''
      const context = typeof a.context === 'string' ? a.context.trim() : ''
      if (!title || !decision || !context) return null
      const conseqRaw = (a.consequences ?? {}) as Record<string, unknown>
      const alternatives = (Array.isArray(a.alternatives) ? a.alternatives : [])
        .map((alt): AdrAlternative | null => {
          const am = alt as Record<string, unknown>
          const option = typeof am.option === 'string' ? am.option.trim() : ''
          if (!option) return null
          return { option, whyNot: asTrimmed(am.whyNot) ?? '' }
        })
        .filter((alt): alt is AdrAlternative => alt !== null)
        .slice(0, 3)
      return {
        title,
        titleAr: asTrimmed(a.titleAr),
        context,
        decision,
        alternatives,
        consequences: {
          positive: asStrings(conseqRaw.positive, 3),
          negative: asStrings(conseqRaw.negative, 3),
          risks: asStrings(conseqRaw.risks, 3),
        },
        linkedRequirements: clean(a.linkedRequirements),
      }
    })
    .filter((a): a is AdrDraft => a !== null)
    .slice(0, 6)
}

// ------------------------------------------------------------
// 3. STRIDE threat model
// ------------------------------------------------------------

const STRIDE_KEYS = ['spoofing', 'tampering', 'repudiation', 'information_disclosure', 'denial_of_service', 'elevation_of_privilege'] as const
type StrideKey = (typeof STRIDE_KEYS)[number]

export interface ThreatModelDraft {
  findings: ThreatFinding[]
  summary: string | null
  residual: string | null
}

const THREAT_PROMPT = `You are the STRIDE Threat Modeling engine of an AI software engineer platform.
Build the threat model for this product across the six STRIDE categories.

Rules:
- "category" must be exactly one of: spoofing, tampering, repudiation, information_disclosure, denial_of_service, elevation_of_privilege.
- Produce 4-9 findings total, spread across at least 4 different STRIDE categories. Only include threats THIS product's design actually faces (grounded in the roles, entities, processes and requirements provided) — no textbook filler.
- Each finding: "threat" (one line), "component" (the part of THIS system at risk, e.g. "Merchant login", "Quotation API"), "attackPath" (how the attack would actually happen, concretely), "likelihood" (low/medium/high), "impact" (low/medium/high/critical), "risk" (the combined honest rating: low/medium/high/critical), "mitigation" (the concrete countermeasure to build, not a platitude).
- "linkedRequirements": related requirement codes (from the provided list only), especially NFR:security ones.
- "summary": the overall security posture in 2-3 honest sentences.
- "residual": what risk remains AFTER the mitigations — be honest.

Return STRICT JSON only:
{"findings": [{"category": "spoofing", "threat": "...", "component": "...", "attackPath": "...", "likelihood": "medium", "impact": "high", "risk": "high", "mitigation": "...", "linkedRequirements": ["NFR-001"]}], "summary": "...", "residual": "..."}`

export async function generateThreatModel(params: {
  ctx: ProjectContext
  requirements: Requirement[]
  components?: string[]
  entityNames?: string[]
  feedback?: string
}): Promise<ThreatModelDraft> {
  const { ctx, requirements } = params
  const surfaceBlock = [
    params.components?.length ? `Architecture components:\n${params.components.map((c) => `- ${c}`).join('\n')}` : '',
    params.entityNames?.length ? `Data entities (sensitive data surface):\n${params.entityNames.map((e) => `- ${e}`).join('\n')}` : '',
  ]
    .filter(Boolean)
    .join('\n\n')

  const raw = await chatJson<Record<string, unknown>>(
    THREAT_PROMPT,
    `${contextToPrompt(ctx)}${surfaceBlock ? '\n\n' + surfaceBlock : ''}\n\nConfirmed requirements (valid codes):\n${requirementsDigest(requirements)}${feedbackBlock(params.feedback)}`
  )

  const validCodes = new Set(requirements.filter((r) => r.status === 'confirmed').map((r) => r.code))
  const ratings = new Set(['low', 'medium', 'high', 'critical'])
  const likelihoods = new Set(['low', 'medium', 'high'])
  const norm = (v: unknown, allowed: Set<string>, fallback: string): string => {
    const s = typeof v === 'string' ? v.trim().toLowerCase().replace(/\s+/g, '_') : ''
    return allowed.has(s) ? s : fallback
  }

  const findings: ThreatFinding[] = (Array.isArray(raw?.findings) ? raw.findings : [])
    .map((f): ThreatFinding | null => {
      const m = f as Record<string, unknown>
      const threat = typeof m.threat === 'string' ? m.threat.trim() : ''
      if (!threat) return null
      const categoryRaw = typeof m.category === 'string' ? m.category.trim().toLowerCase().replace(/[\s-]+/g, '_') : ''
      const category = (STRIDE_KEYS as readonly string[]).includes(categoryRaw) ? (categoryRaw as StrideKey) : null
      if (!category) return null
      const impact = norm(m.impact, ratings, 'medium')
      return {
        category,
        threat,
        component: asTrimmed(m.component) ?? 'the system',
        attackPath: asTrimmed(m.attackPath) ?? '',
        likelihood: norm(m.likelihood, likelihoods, 'medium') as ThreatFinding['likelihood'],
        impact: impact as ThreatFinding['impact'],
        risk: norm(m.risk, ratings, 'medium') as ThreatFinding['risk'],
        mitigation: asTrimmed(m.mitigation) ?? '',
        linkedRequirements: Array.isArray(m.linkedRequirements)
          ? m.linkedRequirements.filter((c): c is string => typeof c === 'string' && validCodes.has(c))
          : [],
      }
    })
    .filter((f): f is ThreatFinding => f !== null)
    .slice(0, 9)

  if (findings.length === 0) throw new Error('No threat findings returned')

  return {
    findings,
    summary: asTrimmed(raw?.summary),
    residual: asTrimmed(raw?.residual),
  }
}

// ------------------------------------------------------------
// 4. Scale simulation — what breaks at 10x / 100x
// ------------------------------------------------------------

export interface ScaleReportDraft {
  assumptions: ScaleAssumption[]
  bottlenecks: ScaleBottleneck[]
  scenarios: ScaleScenario[]
  plan: string | null
}

const SCALE_PROMPT = `You are the Scale Simulation engine of an AI software engineer platform.
Simulate what happens to this product under 10x and 100x load, and what to fix first.

Rules:
- "assumptions": 2-4 explicit load assumptions the analysis stands on (e.g. "~500 daily active users at launch", "peak = 3x average") each with its "basis" (where the estimate comes from — stated honestly as an assumption when there is no data).
- "bottlenecks": 3-6 components of THIS architecture ordered by what breaks FIRST (e.g. SQLite write lock, single VPS, background job queue). Each: "component", "limit" (the concrete ceiling, e.g. "~1 write at a time; degrades past ~100 concurrent writers"), "why" it hits that limit, "symptom" (what users would actually experience), "firstFix" (the cheapest next step that moves the ceiling — not a rewrite).
- "scenarios": exactly 2 what-if scenarios — "10x load" and "100x load". Each: "load" (concrete numbers, e.g. "5,000 DAU / ~50 req/s peak"), "expected" (what still works fine), "breaks" (which bottlenecks actually break and in what order), "actions" (2-4 concrete steps, in priority order).
- "plan": the short/mid-term scaling plan in 3-5 sentences — what to do NOW vs what to deliberately defer.
- Be honest: if the product is fine at 10x with zero changes, say exactly that.

Return STRICT JSON only:
{"assumptions": [{"assumption": "...", "basis": "..."}], "bottlenecks": [{"component": "...", "limit": "...", "why": "...", "symptom": "...", "firstFix": "..."}], "scenarios": [{"label": "10x load", "load": "...", "expected": "...", "breaks": "...", "actions": ["..."]}], "plan": "..."}`

export async function generateScaleReport(params: {
  ctx: ProjectContext
  requirements: Requirement[]
  components?: string[]
  stackChoices?: string[]
  feedback?: string
}): Promise<ScaleReportDraft> {
  const { ctx, requirements } = params
  const stackBlock = [
    params.components?.length ? `Architecture components:\n${params.components.map((c) => `- ${c}`).join('\n')}` : '',
    params.stackChoices?.length ? `Confirmed tech choices:\n${params.stackChoices.map((s) => `- ${s}`).join('\n')}` : '',
  ]
    .filter(Boolean)
    .join('\n\n')

  const raw = await chatJson<Record<string, unknown>>(
    SCALE_PROMPT,
    `${contextToPrompt(ctx)}${stackBlock ? '\n\n' + stackBlock : ''}\n\nConfirmed requirements (valid codes):\n${requirementsDigest(requirements)}${feedbackBlock(params.feedback)}`
  )

  const assumptions: ScaleAssumption[] = (Array.isArray(raw?.assumptions) ? raw.assumptions : [])
    .map((a): ScaleAssumption | null => {
      const m = a as Record<string, unknown>
      const assumption = typeof m.assumption === 'string' ? m.assumption.trim() : ''
      if (!assumption) return null
      return { assumption, basis: asTrimmed(m.basis) ?? 'stated assumption' }
    })
    .filter((a): a is ScaleAssumption => a !== null)
    .slice(0, 4)

  const bottlenecks: ScaleBottleneck[] = (Array.isArray(raw?.bottlenecks) ? raw.bottlenecks : [])
    .map((b): ScaleBottleneck | null => {
      const m = b as Record<string, unknown>
      const component = typeof m.component === 'string' ? m.component.trim() : ''
      if (!component) return null
      return {
        component,
        limit: asTrimmed(m.limit) ?? '',
        why: asTrimmed(m.why) ?? '',
        symptom: asTrimmed(m.symptom) ?? '',
        firstFix: asTrimmed(m.firstFix) ?? '',
      }
    })
    .filter((b): b is ScaleBottleneck => b !== null)
    .slice(0, 6)

  const scenarios: ScaleScenario[] = (Array.isArray(raw?.scenarios) ? raw.scenarios : [])
    .map((s): ScaleScenario | null => {
      const m = s as Record<string, unknown>
      const label = typeof m.label === 'string' ? m.label.trim() : ''
      if (!label) return null
      return {
        label,
        load: asTrimmed(m.load) ?? '',
        expected: asTrimmed(m.expected) ?? '',
        breaks: asTrimmed(m.breaks) ?? '',
        actions: asStrings(m.actions, 4),
      }
    })
    .filter((s): s is ScaleScenario => s !== null)
    .slice(0, 3)

  if (bottlenecks.length === 0 || scenarios.length === 0) throw new Error('Incomplete scale report returned')

  return { assumptions, bottlenecks, scenarios, plan: asTrimmed(raw?.plan) }
}
