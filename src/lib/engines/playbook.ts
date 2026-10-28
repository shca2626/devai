import { db } from '@/lib/db'
import { chatJson } from '@/lib/ai'
import { safeParseJson } from '@/lib/json-utils'
import { expandTemplate, templateVariables } from '@/lib/prompt-utils'
import type { PromptTemplate } from '@/lib/types'

export { expandTemplate, templateVariables }

// ============================================================
// Prompt Playbook — reusable prompt templates with variables.
//
// Three capabilities:
//
//   1. seedBuiltins() : one-time seeding of 8 expert built-in
//      templates covering the recurring vibe-coding tasks.
//   2. expandTemplate() : {{variable}} substitution.
//   3. draftTemplate() : AI skill that converts a short
//      description into a new reusable template.
//
// Built-in bodies are written in English (AI coding tools
// perform best in English); user/AI templates can be any
// language.
// ============================================================

// ---------- Types (mirror lib/types.ts) ----------

type BuiltinSeed = {
  title: string
  titleAr: string
  description: string
  descriptionAr: string
  category: string
  tags: string[]
  body: string
}

// ---------- Built-in templates (seeded once) ----------

const BUILTINS: BuiltinSeed[] = [
  {
    title: 'New feature — full specification',
    titleAr: 'ميزة جديدة — مواصفة كاملة',
    description: 'Turn a one-line feature wish into a complete, buildable spec before any code is written.',
    descriptionAr: 'حوّل رغبة من سطر واحد إلى مواصفة كاملة قابلة للبناء قبل كتابة أي كود.',
    category: 'new_feature',
    tags: ['spec', 'feature'],
    body: `I want to add a new feature to my project.

FEATURE: {{feature_name}}
WHY I NEED IT: {{why}}
WHO WILL USE IT: {{users}}

Before writing any code:
1. Restate the feature in one sentence and list what you will NOT build (out of scope).
2. List the data/entities it needs, the API endpoints it touches, and the screens affected.
3. Propose the smallest implementation that fully satisfies the feature — no extra abstractions.
4. List edge cases (empty state, error state, permissions, RTL if relevant) and how you will handle each.
5. Wait for my approval of the plan before implementing.

Constraints: follow the project's existing conventions and stack exactly. If anything is ambiguous, ask me one focused question instead of guessing.`,
  },
  {
    title: 'Bug fix — guided root-cause analysis',
    titleAr: 'إصلاح خلل — تحليل سبب جذري موجّه',
    description: 'Stop the paste-error-guess-fix ping-pong. Force a root-cause hypothesis and verification before any fix.',
    descriptionAr: 'أوقف لعبة لصق الخطأ والتخمين. افرض فرضية سبب جذري والتحقق منها قبل أي إصلاح.',
    category: 'bug_fix',
    tags: ['debug', 'root-cause'],
    body: `I have a bug. Do NOT jump to a fix — walk me through root-cause analysis first.

WHAT I EXPECTED: {{expected}}
WHAT ACTUALLY HAPPENS: {{actual}}
ERROR MESSAGE / STACK TRACE:
{{error}}
RELEVANT CODE (or describe where it lives):
{{code}}

Work in this order:
1. Explain in plain language what the error means.
2. List 2-3 possible root causes, ranked by likelihood, and say what evidence supports each.
3. Tell me the ONE cheapest test/probe that would confirm or kill the top hypothesis (a console.log, a unit test, a network check — whatever is fastest).
4. After I confirm the root cause, propose the minimal fix and explain what else it might affect.
5. Finally, suggest how to prevent this class of bug from recurring.

Do not rewrite unrelated code. Do not add try/catch just to hide the symptom.`,
  },
  {
    title: 'Code review — senior engineer pass',
    titleAr: 'مراجعة كود — بند مهندس أول',
    description: 'Get a structured, severity-ranked review instead of vague "looks good".',
    descriptionAr: 'احصل على مراجعة منظمة مرتبة حسب الخطورة بدلًا من "يبدو جيدًا" الغامضة.',
    category: 'review',
    tags: ['review', 'quality'],
    body: `Act as a senior engineer reviewing this code as if it were a pull request to production.

CODE TO REVIEW:
{{code}}
CONTEXT (what it is supposed to do):
{{context}}

Review in this structure, ranked by severity:
1. 🔴 BLOCKERS — bugs, security holes, data-loss risks (must fix before merge).
2. 🟠 MAJOR — logic errors, missing error handling, performance traps.
3. 🟡 MINOR — naming, readability, dead code, style inconsistencies.
4. 🟢 SUGGESTIONS — better approaches, with a one-line rationale each.

Rules: cite the exact line/piece you are commenting on; for every issue, show the minimal corrected version; never say "looks good" without naming at least one concrete improvement or explicitly confirming you checked X, Y, Z.`,
  },
  {
    title: 'Write tests — behavior-first',
    titleAr: 'كتابة اختبارات — السلوك أولًا',
    description: 'Tests that verify behavior users care about, not implementation details.',
    descriptionAr: 'اختبارات تتحقق من سلوك يهم المستخدم، لا تفاصيل التنفيذ.',
    category: 'tests',
    tags: ['testing', 'quality'],
    body: `Write tests for the following code/feature.

WHAT TO TEST (feature or code):
{{target}}
FRAMEWORK TO USE (or "suggest one"):
{{framework}}

Approach:
1. First list the behaviors worth testing: the happy path, the 3 most important edge cases, and the failure modes — each as a one-line "Given / When / Then".
2. Wait for me to confirm the list (or tell me to proceed).
3. Then write the tests: behavior-first, minimal mocks (only for true boundaries like network/DB), clear arrange-act-assert structure.
4. Do not test private implementation details. Do not write snapshot tests unless I ask.
5. End with coverage of what is intentionally NOT tested and why.`,
  },
  {
    title: 'Refactor — safe, step-by-step',
    titleAr: 'إعادة هيكلة — آمنة وخطوة بخطوة',
    description: 'Refactor without breaking behavior: inventory, plan, small safe steps, verification each step.',
    descriptionAr: 'أعد الهيكلة دون كسر السلوك: جرد، خطة، خطوات صغيرة آمنة، وتحقق بعد كل خطوة.',
    category: 'refactor',
    tags: ['refactor', 'clean-code'],
    body: `I want to refactor this code. Behavior must stay EXACTLY the same.

CODE OR AREA TO REFACTOR:
{{code}}
WHAT BOTHERS ME ABOUT IT (optional):
{{pain}}
TESTS THAT PROTECT IT (or "none — help me add some first"):
{{tests}}

Rules of engagement:
1. First: describe the current behavior precisely so we can verify nothing breaks.
2. If there are no tests, propose the minimum safety-net tests BEFORE refactoring.
3. Present the refactor as a numbered sequence of SMALL steps, each independently verifiable.
4. Do ONE step at a time — show me the change and wait for my OK before the next.
5. No new dependencies, no renaming public APIs, no "improvements" beyond the stated scope.`,
  },
  {
    title: 'Explain code — 3 depths',
    titleAr: 'شرح الكود — ثلاثة مستويات',
    description: 'Understand any code at junior, senior, or architect depth. Learn, don\'t just copy.',
    descriptionAr: 'افهم أي كود بعمق مبتدئ أو خبير أو معماري. تعلّم بدل النسخ فقط.',
    category: 'general',
    tags: ['learn', 'explain'],
    body: `Explain this code to me at three depths.

CODE:
{{code}}
WHAT I ALREADY KNOW (language/frameworks I'm comfortable with):
{{level}}

1. 🟢 JUNIOR: what it does, line by line for the tricky parts, plain language, one good analogy.
2. 🔵 SENIOR: the patterns and trade-offs used, why it is written this way, what would break if changed naively.
3. 🟣 ARCHITECT: how it fits the bigger system, its failure modes at scale, and where this design would stop working.

End with: "Check your understanding" — 2-3 questions I should be able to answer if I truly understood this.`,
  },
  {
    title: 'Plan implementation — phased',
    titleAr: 'تخطيط التنفيذ — بمراحل',
    description: 'Break any task into dependency-ordered phases with acceptance criteria before coding starts.',
    descriptionAr: 'قسّم أي مهمة إلى مراحل مرتبة بالاعتماديات مع معايير قبول قبل بدء البرمجة.',
    category: 'planning',
    tags: ['plan', 'roadmap'],
    body: `Help me plan the implementation of:

GOAL:
{{goal}}
CONSTRAINTS (deadline, stack, skills):
{{constraints}}

Produce:
1. A phased plan (Phase 1 = smallest end-to-end usable slice, not horizontal layers).
2. For each phase: tasks with dependencies, estimated size (S/M/L), and a testable acceptance criterion.
3. The riskiest unknowns — what could force the plan to change, and the cheapest way to de-risk each early.
4. What to deliberately DESCOPE for v1.

Rules: no task without an acceptance criterion; no phase without a demo-able outcome; ask me before assuming anything about the stack.`,
  },
  {
    title: 'AI handoff — continue my project',
    titleAr: 'تسليم للذكاء الاصطناعي — أكمل مشروعي',
    description: 'Paste into a NEW chat with any AI tool so it picks up your project without starting from zero.',
    descriptionAr: 'الصقه في محادثة جديدة مع أي أداة ذكاء اصطناعي ليلتقط مشروعك دون البدء من الصفر.',
    category: 'planning',
    tags: ['handoff', 'context'],
    body: `You are taking over an in-progress project. Do not start from zero and do not re-plan what is already built.

PROJECT SUMMARY:
{{summary}}
STACK & CONVENTIONS (must follow exactly):
{{stack}}
CURRENT STATE (what works, what is in progress):
{{state}}
YOUR TASK NOW:
{{task}}

Rules:
1. First, restate your understanding of the current state in 3 bullets so I can confirm you have the right context.
2. Follow the existing stack, naming, and file structure — no swaps, no renames.
3. Before each non-trivial change, state what you will change and why in one sentence.
4. If my task conflicts with something already built, STOP and tell me instead of working around it silently.
5. When done, list exactly what changed so I can review it.`,
  },
]

// ---------- Seed on first use ----------

export async function seedBuiltins(): Promise<void> {
  const count = await db.promptTemplate.count({ where: { isBuiltin: true } })
  if (count >= BUILTINS.length) return
  const existingTitles = new Set(
    (await db.promptTemplate.findMany({ where: { isBuiltin: true }, select: { title: true } })).map((t) => t.title)
  )
  const toCreate = BUILTINS.filter((b) => !existingTitles.has(b.title))
  if (!toCreate.length) return
  await db.promptTemplate.createMany({
    data: toCreate.map((b) => ({
      title: b.title,
      titleAr: b.titleAr,
      description: b.description,
      descriptionAr: b.descriptionAr,
      category: b.category,
      body: b.body,
      tags: JSON.stringify(b.tags),
      isBuiltin: true,
    })),
  })
}

// ---------- Serialization ----------

export function serializeTemplate(t: {
  id: string
  title: string
  titleAr: string | null
  description: string
  descriptionAr: string | null
  category: string
  body: string
  tags: string | null
  isBuiltin: boolean
  useCount: number
  isFavorite: boolean
  updatedAt: Date
}): PromptTemplate {
  let tags: string[] = []
  try {
    tags = t.tags ? safeParseJson<string[]>(t.tags) : []
  } catch {
    tags = []
  }
  const VALID_CATEGORIES = ['new_feature', 'bug_fix', 'refactor', 'tests', 'review', 'planning', 'general'] as const
  const category = (VALID_CATEGORIES as readonly string[]).includes(t.category)
    ? (t.category as PromptTemplate['category'])
    : 'general'
  return {
    id: t.id,
    title: t.title,
    titleAr: t.titleAr,
    description: t.description,
    descriptionAr: t.descriptionAr,
    category,
    body: t.body,
    tags: Array.isArray(tags) ? tags : [],
    isBuiltin: t.isBuiltin,
    useCount: t.useCount,
    isFavorite: t.isFavorite,
    updatedAt: t.updatedAt.toISOString(),
  }
}

export async function listTemplates(): Promise<PromptTemplate[]> {
  await seedBuiltins()
  const rows = await db.promptTemplate.findMany({
    orderBy: [{ isFavorite: 'desc' }, { useCount: 'desc' }, { updatedAt: 'desc' }],
  })
  return rows.map(serializeTemplate)
}

// ---------- AI drafting skill ----------

const DRAFT_PROMPT = `You are the Prompt Playbook skill of a developer platform. The user describes a recurring task they do with AI coding tools (Bolt, Cursor, Claude, ChatGPT), and you turn it into a REUSABLE PROMPT TEMPLATE with variables.

Return STRICT JSON only — no markdown fences — with exactly these keys:
- "title": short template name (max 60 chars), same language as the user's description.
- "titleAr": Arabic translation of the title (always provide, even for English input).
- "description": one sentence (max 140 chars) saying when to use it, same language as the description.
- "descriptionAr": Arabic translation of the description.
- "category": one of "new_feature" | "bug_fix" | "refactor" | "tests" | "review" | "planning" | "general".
- "tags": 2-4 short tags.
- "body": the full template. Use {{snake_case_variables}} for every user-specific slot (2-6 variables). The body must embed STRUCTURE: numbered steps, explicit constraints, and a "wait for approval" or verification step when the task is non-trivial. Write the body in the SAME LANGUAGE as the user's description.

Template-writing rules:
- The body is a ready-to-paste prompt: imperative, addressed to the AI tool ("You are...", "Do X before Y"), never a form with blank lines only.
- Convert the user's intent into guardrails: force root-cause analysis for bugs, force plan-then-approve for features, force severity ranking for reviews.
- Every variable must be genuinely user-specific; anything universal stays as literal text.
- 120-400 words for the body.`

export async function draftTemplate(description: string): Promise<PromptTemplate> {
  const result = await chatJson<{
    title?: string
    titleAr?: string
    description?: string
    descriptionAr?: string
    category?: string
    tags?: string[]
    body?: string
  }>(DRAFT_PROMPT, `The recurring task I want a template for:\n"""\n${description}\n"""`)

  const body = (result?.body ?? '').trim()
  if (body.length < 80) throw new Error('Template skill returned an unusable body')
  const category = ['new_feature', 'bug_fix', 'refactor', 'tests', 'review', 'planning', 'general'].includes(
    String(result?.category)
  )
    ? String(result?.category)
    : 'general'

  const created = await db.promptTemplate.create({
    data: {
      title: (result?.title ?? 'Untitled template').trim().slice(0, 120),
      titleAr: result?.titleAr?.trim() || null,
      description: (result?.description ?? '').trim().slice(0, 300) || 'AI-drafted template',
      descriptionAr: result?.descriptionAr?.trim() || null,
      category,
      body,
      tags: JSON.stringify(Array.isArray(result?.tags) ? result.tags.filter((t) => typeof t === 'string').slice(0, 4) : []),
      isBuiltin: false,
    },
  })
  return serializeTemplate(created)
}
