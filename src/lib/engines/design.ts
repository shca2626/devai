import { chatJson } from '@/lib/ai'
import type { Requirement } from '@/lib/types'
import type { ProjectContext } from '@/lib/engines/context'
import { contextToPrompt } from '@/lib/engines/context'

// ============================================================
// Engines 3, 7, 8, 9 — Business process analysis, Data design,
// API contracts, UX/UI specification, Architecture.
// All outputs reference confirmed requirement codes; anything
// referencing non-confirmed requirements is flagged.
// Principle: simplest architecture that satisfies validated
// requirements — no premature complexity.
// ============================================================

function requirementsDigest(requirements: Requirement[], onlyConfirmed = true): string {
  const list = onlyConfirmed ? requirements.filter((r) => r.status === 'confirmed') : requirements
  if (!list.length) return '(no confirmed requirements yet)'
  return list.map((r) => `- ${r.code} [${r.type === 'functional' ? 'FR' : 'NFR'}${r.category ? `:${r.category}` : ''}] ${r.title}`).join('\n')
}

// Client feedback from a rejection — the generator MUST address it.
function feedbackBlock(feedback?: string): string {
  const f = feedback?.trim()
  if (!f) return ''
  return `\n\nCLIENT FEEDBACK — the client rejected the previous proposal. You MUST change the recommendation to address these notes:\n"""\n${f}\n"""`
}

// Names of previously rejected items — do not re-propose them unchanged.
function rejectedBlock(rejected: string[]): string {
  if (!rejected.length) return ''
  return `\n\nThe client explicitly REJECTED these previous proposals (do not re-propose them as-is; produce materially better alternatives):\n${rejected.map((r) => `- ${r}`).join('\n')}`
}

// ------------------------------------------------------------
// Business Process Analysis
// ------------------------------------------------------------

export interface ProcessDraft {
  name: string
  nameAr: string | null
  trigger: string | null
  actors: string[]
  steps: Array<{ n: number; actor: string; action: string; input?: string; output?: string; decision?: string; exception?: string }>
  businessRules: Array<{ rule: string; linkedRequirements: string[] }>
  exceptions: string[]
  linkedRequirements: string[]
  rationale: string | null
}

const PROCESS_PROMPT = `You are the Business Process Analysis engine of an AI software engineer platform.
Derive the core business processes from the approved baseline and confirmed requirements.

Rules:
- Produce 4-8 processes covering the main workflows (registration/onboarding, the primary value flow, secondary flows, and administrative/exception handling where relevant). Fit THIS product — do not force generic processes.
- "steps": 4-9 steps each, with the acting role, the action, inputs, outputs, decision points and inline exception paths. Number steps 1..n.
- Cover success, failure, cancellation and modification paths across the set (as steps' "exception" or entries in "exceptions").
- "businessRules": each rule references the requirement codes it implements (only from the provided list).
- "linkedRequirements": requirement codes this process realizes (from the provided list only).
- "actors": role names consistent with the roles matrix provided.
- Names in English + Arabic ("nameAr", professional MSA).

Return STRICT JSON only:
{"processes": [{"name": "...", "nameAr": "...", "trigger": "...", "actors": ["..."], "steps": [{"n": 1, "actor": "...", "action": "...", "input": "...", "output": "...", "decision": "...", "exception": "..."}], "businessRules": [{"rule": "...", "linkedRequirements": ["FR-001"]}], "exceptions": ["..."], "linkedRequirements": ["FR-001"], "rationale": "..."}]}`

export async function generateProcesses(params: {
  ctx: ProjectContext
  roles: Array<{ name: string; description: string; permissions: string[] }>
  requirements: Requirement[]
  feedback?: string
  rejected?: string[]
}): Promise<ProcessDraft[]> {
  const { ctx, roles, requirements } = params
  const raw = await chatJson<{ processes?: Array<Record<string, unknown>> }>(
    PROCESS_PROMPT,
    `${contextToPrompt(ctx)}\n\nRoles matrix:\n${roles.map((r) => `- ${r.name}: ${r.description} [${r.permissions.join(', ')}]`).join('\n') || '(none)'}\n\nConfirmed requirements (valid codes):\n${requirementsDigest(requirements)}${rejectedBlock(params.rejected ?? [])}${feedbackBlock(params.feedback)}`
  )

  const validCodes = new Set(requirements.filter((r) => r.status === 'confirmed').map((r) => r.code))
  const clean = (codes: unknown): string[] =>
    Array.isArray(codes) ? codes.filter((c): c is string => typeof c === 'string' && validCodes.has(c)) : []

  return (Array.isArray(raw?.processes) ? raw.processes : [])
    .map((p): ProcessDraft | null => {
      const name = typeof p.name === 'string' ? p.name.trim() : ''
      if (!name) return null
      const steps = (Array.isArray(p.steps) ? p.steps : [])
        .map((s, i): ProcessDraft['steps'][number] | null => {
          const sm = s as Record<string, unknown>
          const action = typeof sm.action === 'string' ? sm.action.trim() : ''
          if (!action) return null
          return {
            n: typeof sm.n === 'number' ? sm.n : i + 1,
            actor: typeof sm.actor === 'string' ? sm.actor.trim() : '',
            action,
            input: typeof sm.input === 'string' ? sm.input.trim() : undefined,
            output: typeof sm.output === 'string' ? sm.output.trim() : undefined,
            decision: typeof sm.decision === 'string' && sm.decision.trim() ? sm.decision.trim() : undefined,
            exception: typeof sm.exception === 'string' && sm.exception.trim() ? sm.exception.trim() : undefined,
          }
        })
        .filter((s): s is ProcessDraft['steps'][number] => s !== null)
        .slice(0, 10)
      if (steps.length < 2) return null
      const actors = Array.isArray(p.actors) ? p.actors.filter((a): a is string => typeof a === 'string').slice(0, 5) : []
      const businessRules = (Array.isArray(p.businessRules) ? p.businessRules : [])
        .map((b): ProcessDraft['businessRules'][number] | null => {
          const bm = b as Record<string, unknown>
          const rule = typeof bm.rule === 'string' ? bm.rule.trim() : ''
          if (!rule) return null
          return { rule, linkedRequirements: clean(bm.linkedRequirements) }
        })
        .filter((b): b is ProcessDraft['businessRules'][number] => b !== null)
        .slice(0, 10)
      return {
        name,
        nameAr: typeof p.nameAr === 'string' && p.nameAr.trim() ? p.nameAr.trim() : null,
        trigger: typeof p.trigger === 'string' && p.trigger.trim() ? p.trigger.trim() : null,
        actors,
        steps,
        businessRules,
        exceptions: Array.isArray(p.exceptions) ? p.exceptions.filter((e): e is string => typeof e === 'string' && e.trim().length > 0).slice(0, 8) : [],
        linkedRequirements: clean(p.linkedRequirements),
        rationale: typeof p.rationale === 'string' && p.rationale.trim() ? p.rationale.trim() : null,
      } satisfies ProcessDraft
    })
    .filter((p): p is ProcessDraft => p !== null)
    .slice(0, 8)
}

// ------------------------------------------------------------
// Data Design (ERD)
// ------------------------------------------------------------

export interface EntityDraft {
  name: string
  nameAr: string | null
  description: string | null
  fields: Array<{ name: string; type: string; required: boolean; unique: boolean; description: string; refEntity?: string }>
  relationships: Array<{ target: string; type: string; description: string }>
  constraints: string[]
  rationale: string | null
}

const ENTITY_PROMPT = `You are the Data Design engine of an AI software engineer platform.
Design the data model for the product based on the approved baseline and confirmed requirements.

Rules:
- Produce 6-14 entities that the confirmed requirements actually need — no speculative tables.
- Each entity: 4-12 fields with concrete types (string, text, integer, decimal, boolean, datetime, enum, json). Mark required and unique. Reference other entities by exact entity name in "refEntity" for foreign keys.
- Include an id primary key implicitly (do not list it) and created_at/updated_at implicitly (do not list them).
- "relationships": link entities with type one-to-one | one-to-many | many-to-many and a short description.
- "constraints": business constraints as short statements (e.g. "a quotation must reference exactly one supplier").
- Names in English (singular, e.g. "Quotation") + Arabic ("nameAr").

Return STRICT JSON only:
{"entities": [{"name": "...", "nameAr": "...", "description": "...", "fields": [{"name": "...", "type": "string", "required": true, "unique": false, "description": "...", "refEntity": "... or null"}], "relationships": [{"target": "...", "type": "one-to-many", "description": "..."}], "constraints": ["..."], "rationale": "..."}]}`

export async function generateEntities(params: { ctx: ProjectContext; requirements: Requirement[]; feedback?: string; rejected?: string[] }): Promise<EntityDraft[]> {
  const { ctx, requirements } = params
  const raw = await chatJson<{ entities?: Array<Record<string, unknown>> }>(
    ENTITY_PROMPT,
    `${contextToPrompt(ctx)}\n\nConfirmed requirements:\n${requirementsDigest(requirements)}${rejectedBlock(params.rejected ?? [])}${feedbackBlock(params.feedback)}`
  )

  return (Array.isArray(raw?.entities) ? raw.entities : [])
    .map((e): EntityDraft | null => {
      const name = typeof e.name === 'string' ? e.name.trim() : ''
      if (!name) return null
      const fields = (Array.isArray(e.fields) ? e.fields : [])
        .map((f): EntityDraft['fields'][number] | null => {
          const fm = f as Record<string, unknown>
          const fname = typeof fm.name === 'string' ? fm.name.trim() : ''
          if (!fname) return null
          return {
            name: fname,
            type: typeof fm.type === 'string' && fm.type.trim() ? fm.type.trim() : 'string',
            required: fm.required === true,
            unique: fm.unique === true,
            description: typeof fm.description === 'string' ? fm.description.trim() : '',
            refEntity: typeof fm.refEntity === 'string' && fm.refEntity.trim() ? fm.refEntity.trim() : undefined,
          }
        })
        .filter((f): f is EntityDraft['fields'][number] => f !== null)
        .slice(0, 14)
      if (fields.length < 2) return null
      return {
        name,
        nameAr: typeof e.nameAr === 'string' && e.nameAr.trim() ? e.nameAr.trim() : null,
        description: typeof e.description === 'string' && e.description.trim() ? e.description.trim() : null,
        fields,
        relationships: (Array.isArray(e.relationships) ? e.relationships : [])
          .map((r): EntityDraft['relationships'][number] | null => {
            const rm = r as Record<string, unknown>
            const target = typeof rm.target === 'string' ? rm.target.trim() : ''
            if (!target) return null
            return {
              target,
              type: typeof rm.type === 'string' ? rm.type.trim() : 'one-to-many',
              description: typeof rm.description === 'string' ? rm.description.trim() : '',
            }
          })
          .filter((r): r is EntityDraft['relationships'][number] => r !== null)
          .slice(0, 8),
        constraints: Array.isArray(e.constraints) ? e.constraints.filter((c): c is string => typeof c === 'string' && c.trim().length > 0).slice(0, 6) : [],
        rationale: typeof e.rationale === 'string' && e.rationale.trim() ? e.rationale.trim() : null,
      } satisfies EntityDraft
    })
    .filter((e): e is EntityDraft => e !== null)
    .slice(0, 14)
}

// ------------------------------------------------------------
// API Contracts
// ------------------------------------------------------------

export interface ApiDraft {
  method: string
  path: string
  purpose: string
  auth: string | null
  request: Array<{ field: string; type: string; required: boolean; notes: string }>
  errors: Array<{ code: string; when: string }>
  linkedRequirements: string[]
  linkedEntities: string[]
}

const API_PROMPT = `You are the Architecture / API contract engine of an AI software engineer platform.
Define the REST API contracts needed to realize the confirmed requirements, consistent with the data model and business processes.

Rules:
- Produce 8-16 endpoints covering CRUD for the core entities plus the workflow endpoints (state-changing actions from the processes, e.g. request quotation, respond, cancel).
- "method" one of GET, POST, PATCH, DELETE. "path" in kebab-case starting with /api/v1.
- "auth": which role can call it (e.g. "merchant", "any authenticated user").
- "request": up to 8 fields with type, required and notes (validation rules, e.g. "min 8 chars", "must be a future date").
- "errors": 2-4 error codes with when they occur (e.g. 409 QUOTATION_ALREADY_RESPONDED).
- "linkedRequirements": requirement codes this endpoint serves (from the provided list only).
- "linkedEntities": entity names involved (from the provided list only).

Return STRICT JSON only:
{"endpoints": [{"method": "POST", "path": "/api/v1/quotations", "purpose": "...", "auth": "merchant", "request": [{"field": "...", "type": "string", "required": true, "notes": "..."}], "errors": [{"code": "400 VALIDATION", "when": "..."}], "linkedRequirements": ["FR-001"], "linkedEntities": ["Quotation"]}]}`

export async function generateApis(params: {
  ctx: ProjectContext
  requirements: Requirement[]
  entityNames: string[]
  processNames: string[]
  feedback?: string
  rejected?: string[]
}): Promise<ApiDraft[]> {
  const { ctx, requirements, entityNames, processNames } = params
  const raw = await chatJson<{ endpoints?: Array<Record<string, unknown>> }>(
    API_PROMPT,
    `${contextToPrompt(ctx)}\n\nConfirmed requirements (valid codes):\n${requirementsDigest(requirements)}\n\nApproved data entities (valid names): ${entityNames.join(', ') || '(none)'}\n\nBusiness processes: ${processNames.join(', ') || '(none)'}${rejectedBlock(params.rejected ?? [])}${feedbackBlock(params.feedback)}`
  )

  const validCodes = new Set(requirements.filter((r) => r.status === 'confirmed').map((r) => r.code))
  const validEntities = new Set(entityNames)
  const METHODS = new Set(['GET', 'POST', 'PATCH', 'PUT', 'DELETE'])

  return (Array.isArray(raw?.endpoints) ? raw.endpoints : [])
    .map((e): ApiDraft | null => {
      const path = typeof e.path === 'string' ? e.path.trim() : ''
      const purpose = typeof e.purpose === 'string' ? e.purpose.trim() : ''
      if (!path || !purpose) return null
      return {
        method: METHODS.has(String(e.method).toUpperCase()) ? String(e.method).toUpperCase() : 'GET',
        path,
        purpose,
        auth: typeof e.auth === 'string' && e.auth.trim() ? e.auth.trim() : null,
        request: (Array.isArray(e.request) ? e.request : [])
          .map((r): ApiDraft['request'][number] | null => {
            const rm = r as Record<string, unknown>
            const field = typeof rm.field === 'string' ? rm.field.trim() : ''
            if (!field) return null
            return {
              field,
              type: typeof rm.type === 'string' ? rm.type.trim() : 'string',
              required: rm.required === true,
              notes: typeof rm.notes === 'string' ? rm.notes.trim() : '',
            }
          })
          .filter((r): r is ApiDraft['request'][number] => r !== null)
          .slice(0, 8),
        errors: (Array.isArray(e.errors) ? e.errors : [])
          .map((r): ApiDraft['errors'][number] | null => {
            const rm = r as Record<string, unknown>
            const code = typeof rm.code === 'string' ? rm.code.trim() : ''
            if (!code) return null
            return { code, when: typeof rm.when === 'string' ? rm.when.trim() : '' }
          })
          .filter((r): r is ApiDraft['errors'][number] => r !== null)
          .slice(0, 5),
        linkedRequirements: Array.isArray(e.linkedRequirements)
          ? e.linkedRequirements.filter((c): c is string => typeof c === 'string' && validCodes.has(c))
          : [],
        linkedEntities: Array.isArray(e.linkedEntities)
          ? e.linkedEntities.filter((c): c is string => typeof c === 'string' && validEntities.has(c))
          : [],
      } satisfies ApiDraft
    })
    .filter((e): e is ApiDraft => e !== null)
    .slice(0, 16)
}

// ------------------------------------------------------------
// UX/UI Specification
// ------------------------------------------------------------

export interface ScreenDraft {
  name: string
  nameAr: string | null
  route: string | null
  purpose: string | null
  roles: string[]
  elements: Array<{ element: string; behavior: string }>
  states: { loading: string; empty: string; error: string }
  rtlNote: string | null
  linkedRequirements: string[]
}

const SCREEN_PROMPT = `You are the UX/UI Specification engine of an AI software engineer platform.
Define the screen inventory and interaction specification for the product.

Rules:
- Produce 6-12 screens covering every confirmed functional requirement's user-facing surface (auth, onboarding, the primary flows, management/list screens, profile/settings, and an admin screen if an admin role exists).
- "elements": 3-7 key UI elements with concrete behavior (what happens on click, what loads, validations).
- "states": mandatory loading / empty / error states per screen — one short sentence each, specific to this screen.
- "rtlNote": one sentence on the Arabic RTL consideration for this screen (layout mirroring, numerals, mixed-direction text…).
- "linkedRequirements": requirement codes this screen serves (from the provided list only).
- Names in English + Arabic ("nameAr").

Return STRICT JSON only:
{"screens": [{"name": "...", "nameAr": "...", "route": "/quotations", "purpose": "...", "roles": ["merchant"], "elements": [{"element": "...", "behavior": "..."}], "states": {"loading": "...", "empty": "...", "error": "..."}, "rtlNote": "...", "linkedRequirements": ["FR-001"]}]}`

export async function generateScreens(params: {
  ctx: ProjectContext
  roles: Array<{ name: string }>
  requirements: Requirement[]
  feedback?: string
  rejected?: string[]
}): Promise<ScreenDraft[]> {
  const { ctx, roles, requirements } = params
  const raw = await chatJson<{ screens?: Array<Record<string, unknown>> }>(
    SCREEN_PROMPT,
    `${contextToPrompt(ctx)}\n\nRoles: ${roles.map((r) => r.name).join(', ') || '(none)'}\n\nConfirmed requirements (valid codes):\n${requirementsDigest(requirements)}${rejectedBlock(params.rejected ?? [])}${feedbackBlock(params.feedback)}`
  )

  const validCodes = new Set(requirements.filter((r) => r.status === 'confirmed').map((r) => r.code))

  return (Array.isArray(raw?.screens) ? raw.screens : [])
    .map((s): ScreenDraft | null => {
      const name = typeof s.name === 'string' ? s.name.trim() : ''
      if (!name) return null
      const st = (s.states ?? {}) as Record<string, unknown>
      return {
        name,
        nameAr: typeof s.nameAr === 'string' && s.nameAr.trim() ? s.nameAr.trim() : null,
        route: typeof s.route === 'string' && s.route.trim() ? s.route.trim() : null,
        purpose: typeof s.purpose === 'string' && s.purpose.trim() ? s.purpose.trim() : null,
        roles: Array.isArray(s.roles) ? s.roles.filter((r): r is string => typeof r === 'string').slice(0, 5) : [],
        elements: (Array.isArray(s.elements) ? s.elements : [])
          .map((e): ScreenDraft['elements'][number] | null => {
            const em = e as Record<string, unknown>
            const element = typeof em.element === 'string' ? em.element.trim() : ''
            if (!element) return null
            return { element, behavior: typeof em.behavior === 'string' ? em.behavior.trim() : '' }
          })
          .filter((e): e is ScreenDraft['elements'][number] => e !== null)
          .slice(0, 8),
        states: {
          loading: typeof st.loading === 'string' ? st.loading.trim() : 'Skeleton placeholders while data loads',
          empty: typeof st.empty === 'string' ? st.empty.trim() : 'Friendly empty state with a call to action',
          error: typeof st.error === 'string' ? st.error.trim() : 'Error message with retry',
        },
        rtlNote: typeof s.rtlNote === 'string' && s.rtlNote.trim() ? s.rtlNote.trim() : null,
        linkedRequirements: Array.isArray(s.linkedRequirements)
          ? s.linkedRequirements.filter((c): c is string => typeof c === 'string' && validCodes.has(c))
          : [],
      } satisfies ScreenDraft
    })
    .filter((s): s is ScreenDraft => s !== null)
    .slice(0, 12)
}

// ------------------------------------------------------------
// Architecture (simplest-first, evidence-based)
// ------------------------------------------------------------

export interface ArchitectureDraft {
  components: Array<{ name: string; responsibility: string }>
  integrations: Array<{ system: string; purpose: string; necessity: string }>
  techStack: Array<{ area: string; choice: string; rationale: string; tradeOffs: string; simplestOption: boolean }>
  notes: string
}

const ARCH_PROMPT = `You are the Architecture Design engine of an AI software engineer platform.
Recommend the system architecture for this product.

Rules:
- NO PREMATURE COMPLEXITY: recommend the simplest architecture that satisfies the validated requirements and foreseeable constraints. Do not introduce microservices, queues, or caches unless a confirmed requirement demands it. For each technology area, mark "simplestOption": true when your recommendation is deliberately the simplest adequate choice and say what you consciously did NOT add and why.
- EVIDENCE-BASED: every choice must have a "rationale" grounded in the confirmed requirements. Distinguish verified needs from professional judgment in "tradeOffs" (e.g. "judgment: monolith keeps ops simple; revisit if >10k DAU").
- "components": 4-8 components of the recommended system (e.g. web client, API server, database, file storage, notification service) with single responsibilities.
- "integrations": external systems actually needed (payments, SMS, maps…) with necessity ("required by FR-xxx" or "deferred").
- "techStack": cover frontend, backend, database, hosting, auth, notifications at minimum. Generic capability descriptions (e.g. "Postgres-compatible relational database") are fine; do not invent hosting vendors.

Return STRICT JSON only:
{"components": [{"name": "...", "responsibility": "..."}], "integrations": [{"system": "...", "purpose": "...", "necessity": "..."}], "techStack": [{"area": "database", "choice": "...", "rationale": "...", "tradeOffs": "...", "simplestOption": true}], "notes": "2-4 sentences: the overall shape, what was consciously kept simple, and when to revisit."}`

export async function generateArchitecture(params: {
  ctx: ProjectContext
  requirements: Requirement[]
  feedback?: string
  previousStack?: Array<{ area: string; choice: string }>
}): Promise<ArchitectureDraft> {
  const { ctx, requirements } = params
  const rejectedStack = params.previousStack?.length
    ? `\n\nThe client REJECTED this previous recommendation:\n${params.previousStack.map((s) => `- ${s.area}: ${s.choice}`).join('\n')}\nDo NOT repeat it. Produce a materially different recommendation that respects the client feedback.`
    : ''
  const raw = await chatJson<Record<string, unknown>>(
    ARCH_PROMPT,
    `${contextToPrompt(ctx)}\n\nConfirmed requirements:\n${requirementsDigest(requirements)}\n\nNon-functional requirements (all statuses):\n${requirementsDigest(requirements, false)}${rejectedStack}${feedbackBlock(params.feedback)}`
  )

  const mapPairs = (v: unknown, keys: [string, string, string]) =>
    (Array.isArray(v) ? v : [])
      .map((item) => {
        const m = item as Record<string, unknown>
        const a = typeof m[keys[0]] === 'string' ? (m[keys[0]] as string).trim() : ''
        if (!a) return null
        return {
          [keys[0]]: a,
          [keys[1]]: typeof m[keys[1]] === 'string' ? (m[keys[1]] as string).trim() : '',
          [keys[2]]: typeof m[keys[2]] === 'string' ? (m[keys[2]] as string).trim() : '',
        }
      })
      .filter((x) => x !== null)
      .slice(0, 10) as Array<Record<string, string>>

  return {
    components: mapPairs(raw?.components, ['name', 'responsibility', 'x']).map(({ name, responsibility }) => ({ name, responsibility })),
    integrations: mapPairs(raw?.integrations, ['system', 'purpose', 'necessity']).map((i) => ({
      system: i.system,
      purpose: i.purpose,
      necessity: i.necessity,
    })),
    techStack: (Array.isArray(raw?.techStack) ? raw.techStack : [])
      .map((t) => {
        const m = t as Record<string, unknown>
        const area = typeof m.area === 'string' ? m.area.trim() : ''
        const choice = typeof m.choice === 'string' ? m.choice.trim() : ''
        if (!area || !choice) return null
        return {
          area,
          choice,
          rationale: typeof m.rationale === 'string' ? m.rationale.trim() : '',
          tradeOffs: typeof m.tradeOffs === 'string' ? m.tradeOffs.trim() : '',
          simplestOption: m.simplestOption === true,
        }
      })
      .filter((t): t is ArchitectureDraft['techStack'][number] => t !== null)
      .slice(0, 10),
    notes: typeof raw?.notes === 'string' ? raw.notes.trim() : '',
  }
}
