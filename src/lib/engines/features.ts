import { chatJson } from '@/lib/ai'
import type { Interpretation, Priority, FeatureStatus } from '@/lib/types'
import type { AnsweredItem } from '@/lib/engines/discover'

// ============================================================
// Engine 3 — Feature Discovery & Product Scope
// Builds the feature inventory from the APPROVED understanding
// and discovery answers. Crucial rule: the model's own
// suggestions are marked needs_confirmation — they never
// silently become the user's decisions.
// ============================================================

export interface FeatureDraft {
  module: string
  feature: string
  user: string
  priority: Priority
  status: FeatureStatus
  rationale: string
}

export interface InventoryResult {
  features: FeatureDraft[]
  missingFeatures: string[]
  dependencies: string[]
  releaseNote: string
}

const SYSTEM_PROMPT = `You are the Feature Discovery & Product Scope engine of a software product discovery platform.
Given an approved idea interpretation and the discovery Q&A, produce an MVP feature inventory.

Rules:
- Produce 12-20 features grouped by module. Module names must be short (e.g. "Authentication", domain-specific modules, "Notifications", "Administration"). Fit the modules to THIS product — do not force generic categories where they do not apply.
- "user": the role that uses the feature (from the discovered user types; use "All users" only when true).
- "priority": "must" (MVP-critical, product fails without it), "should" (important but not launch-blocking), "could" (nice-to-have, later release).
- "status": "proposed" when the feature follows directly from the idea or from confirmed answers; "needs_confirmation" when the feature depends on an unanswered question OR is your own suggestion beyond the stated scope. NEVER present your suggestions as confirmed decisions — that is exactly what needs_confirmation marks.
- "rationale": one short sentence linking the feature to the idea or a specific answer.
- Every feature name must be concrete and testable (e.g. "Request quotations from multiple suppliers", not "Quotation management").

Also return:
- "missingFeatures": 3-6 gaps a professional product manager would flag — things the founder did not mention but the product likely needs (e.g. onboarding, content moderation, order history).
- "dependencies": 3-6 short notes of the form "X depends on Y".
- "releaseNote": 1-3 sentences on what is clearly v1 versus what should be deferred to later versions.

Return STRICT JSON only:
{"features": [{"module": "...", "feature": "...", "user": "...", "priority": "must", "status": "proposed", "rationale": "..."}], "missingFeatures": ["..."], "dependencies": ["..."], "releaseNote": "..."}`

interface RawResult {
  features?: Array<Record<string, unknown>>
  missingFeatures?: unknown
  dependencies?: unknown
  releaseNote?: unknown
}

const PRIORITIES: Priority[] = ['must', 'should', 'could']
const STATUSES: FeatureStatus[] = ['proposed', 'needs_confirmation']

export async function generateFeatureInventory(params: {
  interpretation: Interpretation
  answered: AnsweredItem[]
}): Promise<InventoryResult> {
  const { interpretation, answered } = params
  const raw = await chatJson<RawResult>(
    SYSTEM_PROMPT,
    `Approved idea interpretation:\n${JSON.stringify(interpretation, null, 2)}\n\nDiscovery Q&A:\n${
      answered.length
        ? answered.map((a, i) => `${i + 1}. [${a.area}] ${a.questionEn}\n   Answer: ${a.answer}`).join('\n')
        : '(no discovery answers — rely on the interpretation and mark uncertain items needs_confirmation)'
    }`
  )

  const arr = (v: unknown): string[] =>
    Array.isArray(v) ? v.filter((x): x is string => typeof x === 'string' && x.trim().length > 0).map((s) => s.trim()) : []

  const features: FeatureDraft[] = (Array.isArray(raw?.features) ? raw.features : [])
    .map((f) => {
      const moduleName = typeof f.module === 'string' ? f.module.trim() : ''
      const feature = typeof f.feature === 'string' ? f.feature.trim() : ''
      if (!moduleName || !feature) return null
      return {
        module: moduleName,
        feature,
        user: typeof f.user === 'string' && f.user.trim() ? f.user.trim() : 'All users',
        priority: PRIORITIES.includes(f.priority as Priority) ? (f.priority as Priority) : 'should',
        status: STATUSES.includes(f.status as FeatureStatus) ? (f.status as FeatureStatus) : 'proposed',
        rationale: typeof f.rationale === 'string' ? f.rationale.trim() : '',
      } satisfies FeatureDraft
    })
    .filter((f): f is FeatureDraft => f !== null)
    .slice(0, 25)

  if (features.length < 5) {
    throw new Error('AI returned too few features — please retry')
  }

  return {
    features,
    missingFeatures: arr(raw?.missingFeatures).slice(0, 8),
    dependencies: arr(raw?.dependencies).slice(0, 8),
    releaseNote: typeof raw?.releaseNote === 'string' ? raw.releaseNote.trim() : '',
  }
}
