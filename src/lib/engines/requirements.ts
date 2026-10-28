import { chatJson } from '@/lib/ai'
import type { Priority, ReqStatus, Role } from '@/lib/types'
import type { ProjectContext } from '@/lib/engines/context'
import { contextToPrompt } from '@/lib/engines/context'

// ============================================================
// Engine 6 — Requirements Engineering
// Converts the approved baseline into testable functional and
// non-functional requirements with explicit provenance:
// "client" (traceable to an approved feature or answer) vs
// "ai" (professional suggestion that needs explicit approval).
// ============================================================

export interface RequirementDraft {
  type: 'functional' | 'non_functional'
  category: string | null
  title: string
  titleAr: string | null
  description: string
  acceptanceCriteria: string[]
  provenance: 'client' | 'ai'
  evidence: string | null
  featureRef: string | null // exact feature text it derives from
  priority: Priority
  status: ReqStatus
}

export interface RequirementsResult {
  roles: Role[]
  functional: RequirementDraft[]
  nonFunctional: RequirementDraft[]
  notes: string
}

const SYSTEM_PROMPT_FR = `You are the Requirements Engineering engine of an AI software engineer platform.
Convert the approved product baseline into testable FUNCTIONAL requirements plus the roles matrix.

Rules:
- Derive FUNCTIONAL requirements (FR) from the approved features and discovery answers. One feature may map to one or several FRs; keep each FR atomic and testable.
- "provenance": "client" ONLY when the requirement follows directly from an approved feature or a discovery answer (set "evidence" to that feature text or answer summary). Use "ai" for anything you add as professional judgment.
- "featureRef": when derived from a feature, repeat that feature text EXACTLY as given (for matching); otherwise null.
- "acceptanceCriteria": 2-3 criteria per requirement, each written as a verifiable statement (Given/When/Then style or measurable condition). Never vague ("easy to use" is forbidden; "a merchant completes a quotation request in under 3 minutes with 5 fields" is acceptable).
- "status": "proposed" normally; "unresolved" ONLY when the requirement depends on a decision the client has not made (say which decision in "evidence").
- "priority": must | should | could, consistent with the feature baseline.
- Titles in English only (concise, testable phrasing).
- Also output "roles": every user type with a short description and its key permissions, derived from the answers/features. Include an admin/operator role if operations need one.

Return STRICT JSON only:
{"roles": [{"name": "...", "description": "...", "permissions": ["..."]}], "functional": [{"title": "...", "description": "...", "acceptanceCriteria": ["..."], "provenance": "client", "evidence": "...", "featureRef": "... or null", "priority": "must", "status": "proposed"}]}`

const SYSTEM_PROMPT_NFR = `You are the Requirements Engineering engine of an AI software engineer platform.
Derive the NON-FUNCTIONAL requirements (NFR) for this product.

Rules:
- Produce 6-9 NFRs covering: security, privacy, performance, usability (including Arabic RTL support), availability, and maintainability. Fit them to THIS product.
- "category": one of security | privacy | performance | usability | availability | maintainability.
- "acceptanceCriteria": 2-3 measurable/verifiable criteria per NFR (specific numbers where possible).
- "provenance": "ai" (these are professional judgment) unless directly stated by the client.
- "priority": must | should | could.
- Titles in English only (concise).

Return STRICT JSON only:
{"nonFunctional": [{"title": "...", "category": "security", "description": "...", "acceptanceCriteria": ["..."], "provenance": "ai", "evidence": null, "featureRef": null, "priority": "should", "status": "proposed"}]}`

interface RawResult {
  roles?: Array<Record<string, unknown>>
  functional?: Array<Record<string, unknown>>
  nonFunctional?: Array<Record<string, unknown>>
  notes?: unknown
}

const PRIORITIES: Priority[] = ['must', 'should', 'could']
const STATUSES: ReqStatus[] = ['proposed', 'unresolved']

function strs(v: unknown, max: number): string[] {
  return Array.isArray(v)
    ? v.filter((x): x is string => typeof x === 'string' && x.trim().length > 0).map((s) => s.trim()).slice(0, max)
    : []
}

function normalizeDraft(raw: Record<string, unknown>, type: 'functional' | 'non_functional', defaults: { category: string | null; priority: Priority }): RequirementDraft | null {
  const title = typeof raw.title === 'string' ? raw.title.trim() : ''
  const description = typeof raw.description === 'string' ? raw.description.trim() : ''
  if (!title || !description) return null
  const criteria = strs(raw.acceptanceCriteria, 5)
  const priority = PRIORITIES.includes(raw.priority as Priority) ? (raw.priority as Priority) : defaults.priority
  const status = STATUSES.includes(raw.status as ReqStatus) ? (raw.status as ReqStatus) : 'proposed'
  const provenance = raw.provenance === 'client' ? 'client' : 'ai'
  return {
    type,
    category: type === 'non_functional' && typeof raw.category === 'string' ? raw.category.trim() : null,
    title,
    titleAr: typeof raw.titleAr === 'string' && raw.titleAr.trim() ? raw.titleAr.trim() : null,
    description,
    acceptanceCriteria: criteria.length > 0 ? criteria : [`Verify that: ${title}`],
    provenance,
    evidence: typeof raw.evidence === 'string' && raw.evidence.trim() ? raw.evidence.trim() : null,
    featureRef: typeof raw.featureRef === 'string' && raw.featureRef.trim() ? raw.featureRef.trim() : null,
    priority,
    status,
  }
}

export async function generateRequirements(ctx: ProjectContext): Promise<RequirementsResult> {
  const [rawFr, rawNfr] = await Promise.all([
    chatJson<RawResult>(SYSTEM_PROMPT_FR, contextToPrompt(ctx)),
    chatJson<RawResult>(SYSTEM_PROMPT_NFR, contextToPrompt(ctx)),
  ])

  const roles: Role[] = (Array.isArray(rawFr?.roles) ? rawFr.roles : [])
    .map((r) => {
      const name = typeof r.name === 'string' ? r.name.trim() : ''
      if (!name) return null
      return {
        name,
        description: typeof r.description === 'string' ? r.description.trim() : '',
        permissions: strs(r.permissions, 10),
      } satisfies Role
    })
    .filter((r): r is Role => r !== null)
    .slice(0, 8)

  const functional = (Array.isArray(rawFr?.functional) ? rawFr.functional : [])
    .map((r) => normalizeDraft(r, 'functional', { category: null, priority: 'must' }))
    .filter((r): r is RequirementDraft => r !== null)
    .slice(0, 30)

  const nonFunctional = (Array.isArray(rawNfr?.nonFunctional) ? rawNfr.nonFunctional : [])
    .map((r) => normalizeDraft(r, 'non_functional', { category: 'general', priority: 'should' }))
    .filter((r): r is RequirementDraft => r !== null)
    .slice(0, 12)

  if (functional.length < 4) {
    throw new Error('AI returned too few functional requirements — please retry')
  }

  return {
    roles,
    functional,
    nonFunctional,
    notes: '',
  }
}
