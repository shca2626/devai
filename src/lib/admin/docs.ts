// ============================================================
// Admin panel documentation data — describes every feature,
// engine and API endpoint of the platform so the admin can
// understand the whole system from /admin.
// ============================================================

export interface StageDoc {
  key: string
  n: number
  title: string
  titleAr: string
  what: string
  engine: string
  apis: string[]
}

export const STAGE_DOCS: StageDoc[] = [
  {
    key: 'understanding',
    n: 1,
    title: 'Understand',
    titleAr: 'الفهم',
    what: 'The raw idea text (Arabic or English) is interpreted by AI into: title, English interpretation, problem statement, what was understood, what is unclear, and tentative assumptions. The user can correct it any number of times.',
    engine: 'engines/understand.ts — interpretIdea / reinterpretIdea',
    apis: ['POST /api/ideas (creates + interprets)', 'POST /api/ideas/[id]/reinterpret', 'POST /api/ideas/[id]/gate { gate: interpretation }'],
  },
  {
    key: 'discovery',
    n: 2,
    title: 'Discover',
    titleAr: 'الاستكشاف',
    what: 'Adaptive interview: AI generates questions across 9 business areas (problem, users, format, model, journeys, scope, constraints, success criteria, unknowns). Answers drive the next questions. No question cap in no-limits mode.',
    engine: 'engines/discover.ts — generateQuestions / compileDiscoverySummary',
    apis: ['POST /api/ideas/[id]/questions/next', 'POST /api/ideas/[id]/questions/answer', 'POST /api/ideas/[id]/finish-discovery'],
  },
  {
    key: 'features',
    n: 3,
    title: 'Features',
    titleAr: 'الميزات',
    what: 'A structured feature inventory (module / feature / user / priority) generated from the interpretation + answers. Every feature gets an explicit decision: accept, defer or reject. Features can also be added manually.',
    engine: 'engines/features.ts — generateFeatureInventory',
    apis: ['POST /api/ideas/[id]/features/generate', 'POST /api/features', 'PATCH|DELETE /api/features/[id]'],
  },
  {
    key: 'baseline',
    n: 4,
    title: 'Baseline',
    titleAr: 'خط الأساس',
    what: 'The approved P0 blueprint: a frozen snapshot of interpretation + summary + decided features + open questions. Exportable as Markdown/JSON. The assumption register and full audit trail live here.',
    engine: 'lib/payload.ts — buildBaselineSnapshot',
    apis: ['POST /api/ideas/[id]/gate { gate: baseline }', 'GET /api/ideas/[id]/export?format=md|json', 'PATCH /api/assumptions/[id]'],
  },
  {
    key: 'requirements',
    n: 5,
    title: 'Requirements',
    titleAr: 'المتطلبات',
    what: 'The Project Contract: functional + non-functional requirements (FR-xxx / NFR-xxx), each with testable acceptance criteria, provenance (client vs AI) and priority. Confirmed requirements drive all downstream stages.',
    engine: 'engines/requirements.ts — generateRequirements; engines/context.ts — buildProjectContext',
    apis: ['POST /api/ideas/[id]/requirements/generate', 'PATCH /api/artifacts/requirement/[id]', 'POST /api/ideas/[id]/impact'],
  },
  {
    key: 'design',
    n: 6,
    title: 'Design',
    titleAr: 'التصميم',
    what: 'Five design engines produce business processes (PF), the data model (ENT with fields/relationships), API contracts (API), screen specs (SCR with RTL notes) and the architecture recommendation. Each set is reviewed item by item.',
    engine: 'engines/design.ts — generateProcesses/Entities/Apis/Screens/Architecture',
    apis: ['POST /api/ideas/[id]/design/generate { kind }', 'PATCH /api/artifacts/{process|entity|api|screen|architecture}/[id]'],
  },
  {
    key: 'planning',
    n: 7,
    title: 'Planning',
    titleAr: 'التخطيط',
    what: 'Dependency-ordered implementation tasks (phased, each self-contained with acceptance criteria + deliverable + requirement traceability) and the risk register (category, likelihood, impact, mitigation decision).',
    engine: 'engines/plan.ts — generateTasks / generateRisks',
    apis: ['POST /api/ideas/[id]/plan/generate { kind: tasks|risks }', 'PATCH /api/artifacts/{task|risk}/[id]'],
  },
  {
    key: 'readiness',
    n: 8,
    title: 'Readiness',
    titleAr: 'الجاهزية',
    what: 'The honest completeness gate: a weighted 0-100 score from 10 real checks (reviewed requirements, FR acceptance criteria, process/screen/task coverage, design approved, no critical issues, no unresolved musts, risks reviewed). The consistency engine + AI cross-artifact review detect contradictions, omissions and broken links. In no-limits mode the lock button is always enabled.',
    engine: 'lib/readiness.ts — computeReadiness; engines/consistency.ts — runConsistencyCheck',
    apis: ['POST /api/ideas/[id]/consistency', 'POST /api/ideas/[id]/gate { gate: package }', 'PATCH /api/artifacts/issue/[id]'],
  },
  {
    key: 'package',
    n: 9,
    title: 'Package',
    titleAr: 'الحزمة',
    what: 'The final engineering package: 6 sections (product definition, functional analysis, data & API design, UI/UX spec, quality & operations, implementation plan) + traceability appendix, exportable as Markdown or JSON at any stage. Reopenable to any stage without losing history.',
    engine: 'api/ideas/[id]/package/export — assembles from confirmed artifacts',
    apis: ['GET /api/ideas/[id]/package/export?format=md|json', 'POST /api/ideas/[id]/reopen { to, reason }'],
  },
]

export interface ToolDoc {
  name: string
  icon: string
  what: string
  details: string[]
  apis: string[]
}

export const TOOL_DOCS: ToolDoc[] = [
  {
    name: 'Express Autopilot',
    icon: 'Zap',
    what: 'Delegates the entire remaining workflow to the virtual engineer. One unit of work per call; the UI drives the loop with live progress.',
    details: [
      'Auto-answers interview questions (each recorded as an open assumption)',
      'Auto-accepts unreviewed features / requirements / tasks, auto-decides risks',
      'Auto-fixes critical consistency issues; in no-limits mode it dismisses what it cannot fix (logged)',
      'Never blocks on readiness blockers anymore — the score is logged, the package locks',
    ],
    apis: ['POST /api/ideas/[id]/express'],
  },
  {
    name: 'AI Constitution',
    icon: 'ScrollText',
    what: 'The developer\'s non-negotiable rules for vibe-coding handoffs: global (workspace-wide) or per-project rules in 6 categories (stack, coding, security, design, quality, workflow).',
    details: [
      'Injected at the top of every generated Context Pack',
      'Checked by the Traceability Verifier (RULE-xxx rows)',
      'AI can draft project-specific rules from the current artifacts',
    ],
    apis: ['GET|POST /api/constitution', 'PATCH|DELETE /api/constitution/[id]', 'POST /api/ideas/[id]/constitution/draft'],
  },
  {
    name: 'Context Pack',
    icon: 'Package',
    what: 'Compiles the whole project into one paste-ready brief for AI builders (Bolt, Cursor, Claude, ChatGPT, generic) — constitution rules first, then the selected artifact sections.',
    details: [
      'Per-target framing so the brief reads natively in each tool',
      'Selectable sections: requirements, architecture, data model, screens, tasks, risks, decisions',
      'Stats (characters / words / sections / rules applied) computed deterministically',
    ],
    apis: ['POST /api/ideas/[id]/context-pack'],
  },
  {
    name: 'Prompt Playbook',
    icon: 'BookOpen',
    what: 'Saved reusable prompt templates with {{variables}}, categorized (new feature, bug fix, refactor, tests, review, planning, general).',
    details: [
      'Built-in templates seeded once; user templates unlimited',
      'AI can draft a template from a title + description',
      'useCount tracks what actually gets reused; favorites supported',
    ],
    apis: ['GET|POST /api/playbook', 'PATCH|DELETE /api/playbook/[id]', 'POST /api/playbook/[id]/use', 'POST /api/playbook/draft'],
  },
  {
    name: 'Traceability Verifier',
    icon: 'FileSearch',
    what: 'Paste AI-generated code → an honest ✅/🟡/❌/⚪ matrix against the confirmed requirements (or accepted features) + enabled constitution rules.',
    details: [
      'Per-check verdicts with evidence, gap and a concrete fix instruction',
      'The 0-100 coverage score is computed by the app, never the model',
      'Any non-empty code can be verified (no-limits mode)',
    ],
    apis: ['POST /api/ideas/[id]/verify', 'GET /api/ideas/[id]/verify[?runId]', 'DELETE /api/ideas/[id]/verify?runId'],
  },
  {
    name: 'Decision Log',
    icon: 'Scale',
    what: 'The project\'s standing APPROVED decisions (DEC-01…): what was chosen and must hold — stack, data, API style, UX, scope, naming, process.',
    details: [
      'Active entries are injected into the Context Pack',
      'They become the targets of the Drift Detector',
      'Different from the audit trail (Decision model) which records what happened',
    ],
    apis: ['GET|POST /api/ideas/[id]/decisions', 'PATCH|DELETE /api/ideas/[id]/decisions/[decisionId]'],
  },
  {
    name: 'Drift Detector',
    icon: 'GitBranch',
    what: 'Paste an AI build → per-decision verdicts: ✅ respected / 🟡 partial / ❌ drift / ⚪ not in code, against the active decision log.',
    details: [
      'Deterministic alignment score 0-100 + drift count (app-computed)',
      'Concrete realignment instructions per drifted decision',
    ],
    apis: ['POST /api/ideas/[id]/drift', 'GET /api/ideas/[id]/drift[?checkId]', 'DELETE /api/ideas/[id]/drift?checkId'],
  },
  {
    name: 'Site Intelligence',
    icon: 'Radar',
    what: 'Deep static analysis of any live website from a single URL: 7 gated stages (recon → surface → bundles → APIs → data models → audit → synthesis) producing a downloadable clone pack.',
    details: [
      'Robots-aware crawling, NO JavaScript execution of the target',
      'Every claim carries evidence + method; unknowns are reported honestly',
      'Deterministic completeness score 0-100; anti-bot walls are detected and reported',
    ],
    apis: ['POST /api/ideas/[id]/site-intel', 'GET /api/ideas/[id]/site-intel[?analysisId]', 'DELETE /api/ideas/[id]/site-intel?analysisId'],
  },
  {
    name: 'Prompt Lab (Enhance / Translate)',
    icon: 'Sparkles',
    what: 'Bolt-style "Plan" utilities: turn a raw idea into a structured professional build prompt, and translate any text Arabic ↔ English.',
    details: ['Pure utilities — they never touch the database', 'Steered by the build target (website / app / prototype)'],
    apis: ['POST /api/tools/enhance', 'POST /api/tools/translate'],
  },
]

export interface EngineDoc {
  file: string
  what: string
}

export const ENGINE_DOCS: EngineDoc[] = [
  { file: 'src/lib/ai.ts', what: 'The shared AI gateway — one ZAI instance, chatText/chatJson with retries and JSON-first parsing. No workflow rules live here.' },
  { file: 'src/lib/engines/understand.ts', what: 'Engine 1 — bilingual idea interpretation (title, English interpretation, problem, understood/unclear/assumed).' },
  { file: 'src/lib/engines/discover.ts', what: 'Engine 2 — adaptive interview: question generation across 9 areas + discovery summary compilation.' },
  { file: 'src/lib/engines/features.ts', what: 'Engine 3 — feature inventory generation (module/feature/user/priority + meta: missing, dependencies, release note).' },
  { file: 'src/lib/engines/requirements.ts', what: 'Engine 4 — the SRS generator (FR/NFR with acceptance criteria, provenance, roles matrix).' },
  { file: 'src/lib/engines/design.ts', what: 'Engines 5a-5e — processes, data entities, API contracts, screen specs, architecture recommendation.' },
  { file: 'src/lib/engines/plan.ts', what: 'Engines 6a-6b — dependency-ordered implementation tasks + the risk register.' },
  { file: 'src/lib/engines/consistency.ts', what: 'Engine 7 — deterministic coverage checks + AI cross-artifact consistency review (contradiction, omission, duplicate, broken link).' },
  { file: 'src/lib/engines/verify.ts', what: 'Traceability Verifier — per-check verdicts + deterministic coverage score.' },
  { file: 'src/lib/engines/drift.ts', what: 'Drift Detector — per-decision verdicts + deterministic alignment score.' },
  { file: 'src/lib/engines/context.ts', what: 'Project context builder — merges interpretation, answers, features, requirements for every engine.' },
  { file: 'src/lib/engines/context-pack.ts', what: 'Context Pack compiler — the paste-ready brief with per-target framing (bolt/cursor/claude/chatgpt/generic).' },
  { file: 'src/lib/engines/site-intel.ts', what: 'Site Intelligence — robots-aware static crawler + 7-stage analysis pipeline + clone pack builder.' },
  { file: 'src/lib/engines/playbook.ts', what: 'Playbook store — built-in seeds, CRUD, use-count tracking, AI drafting.' },
  { file: 'src/lib/engines/prompt-lab.ts', what: 'Prompt engineering pass (Enhance) + Arabic↔English translation.' },
  { file: 'src/lib/express.ts', what: 'Express autopilot — the step machine that delegates the whole workflow (auto-answer, auto-accept, auto-fix, auto-decide).' },
  { file: 'src/lib/readiness.ts', what: 'The readiness gate — 10 weighted real checks, honest 0-100 score, blockers list (advisory in no-limits mode).' },
  { file: 'src/lib/payload.ts', what: 'Server payload builders — typed API responses, baseline snapshot, decision logging.' },
  { file: 'src/lib/impact.ts', what: 'Change-impact preview — what breaks downstream when a confirmed requirement changes.' },
]

export interface ApiDocEntry {
  method: 'GET' | 'POST' | 'PATCH' | 'DELETE'
  path: string
  desc: string
  tryable?: boolean
}

export interface ApiDocGroup {
  group: string
  entries: ApiDocEntry[]
}

export const API_DOCS: ApiDocGroup[] = [
  {
    group: 'Ideas & workflow',
    entries: [
      { method: 'GET', path: '/api/ideas', desc: 'List all ideas with counts (answered questions, accepted features).', tryable: true },
      { method: 'POST', path: '/api/ideas', desc: 'Create an idea: { text, projectType? } → AI interpretation + assumptions. Any non-empty text accepted.' },
      { method: 'GET', path: '/api/ideas/[id]', desc: 'Full idea detail: all artifacts + readiness report.', tryable: true },
      { method: 'PATCH', path: '/api/ideas/[id]', desc: 'Rename { title }.' },
      { method: 'DELETE', path: '/api/ideas/[id]', desc: 'Delete the idea and every child row (cascade).' },
      { method: 'POST', path: '/api/ideas/[id]/gate', desc: 'Approval gates { gate, action, unreviewedAction? } — interpretation | baseline | engineering_start | requirements | design | planning | package. NO LIMITS: always passes, auto-accepts unreviewed items.' },
      { method: 'POST', path: '/api/ideas/[id]/reopen', desc: 'Move the idea to ANY stage { to, reason? } — works from any current stage.' },
      { method: 'POST', path: '/api/ideas/[id]/reinterpret', desc: 'Correct the interpretation { corrections } — allowed at any stage.' },
      { method: 'POST', path: '/api/ideas/[id]/express', desc: 'Express autopilot — run one delegated step; loop until status done.' },
      { method: 'GET', path: '/api/ideas/[id]/export', desc: 'P0 baseline export ?format=md|json — available at any stage.', tryable: true },
      { method: 'GET', path: '/api/ideas/[id]/package/export', desc: 'Final engineering package ?format=md|json — available at any stage.', tryable: true },
    ],
  },
  {
    group: 'Discovery interview',
    entries: [
      { method: 'POST', path: '/api/ideas/[id]/questions/next', desc: 'Generate/return the next question { force? } — no cap, any stage.' },
      { method: 'POST', path: '/api/ideas/[id]/questions/answer', desc: 'Answer or skip { questionId, answer, kind: choice|custom|skip }.' },
      { method: 'POST', path: '/api/ideas/[id]/finish-discovery', desc: 'Compile the summary → features stage. No minimum answers.' },
    ],
  },
  {
    group: 'Features & assumptions',
    entries: [
      { method: 'POST', path: '/api/ideas/[id]/features/generate', desc: '(Re)generate the feature inventory — any stage, any number of times.' },
      { method: 'POST', path: '/api/features', desc: 'Add a feature manually { ideaId, module, feature, user, priority, rationale }.' },
      { method: 'PATCH', path: '/api/features/[id]', desc: 'Decide/edit a feature { status | module | feature | user | priority | rationale }.' },
      { method: 'DELETE', path: '/api/features/[id]', desc: 'Remove a feature.' },
      { method: 'PATCH', path: '/api/assumptions/[id]', desc: 'Confirm / reject an assumption { status }.' },
    ],
  },
  {
    group: 'Engineering track',
    entries: [
      { method: 'POST', path: '/api/ideas/[id]/requirements/generate', desc: 'Generate the SRS — any stage, uses whatever context exists.' },
      { method: 'PATCH', path: '/api/artifacts/requirement/[id]', desc: 'Decide/edit a requirement; changing a confirmed one triggers the change-impact flow (confirmImpact).' },
      { method: 'POST', path: '/api/ideas/[id]/impact', desc: 'Preview what a requirement change affects { requirementId, change }.' },
      { method: 'POST', path: '/api/ideas/[id]/design/generate', desc: 'Generate design artifacts { kind: processes|entities|apis|screens|architecture, feedback? } — any stage.' },
      { method: 'PATCH', path: '/api/artifacts/[kind]/[id]', desc: 'Review decisions for process|entity|api|screen|architecture|task|risk|issue artifacts { status } or architecture edits.' },
      { method: 'POST', path: '/api/ideas/[id]/plan/generate', desc: 'Generate { kind: tasks|risks } — any stage.' },
      { method: 'POST', path: '/api/ideas/[id]/consistency', desc: 'Run the consistency validation — any stage.' },
    ],
  },
  {
    group: 'Vibe-coding armor',
    entries: [
      { method: 'GET', path: '/api/constitution', desc: 'List constitution rules (global + optional ?ideaId).', tryable: true },
      { method: 'POST', path: '/api/constitution', desc: 'Create a rule { category, text, ideaId? }.' },
      { method: 'PATCH', path: '/api/constitution/[id]', desc: 'Edit / enable / disable / reorder a rule.' },
      { method: 'DELETE', path: '/api/constitution/[id]', desc: 'Delete a rule.' },
      { method: 'POST', path: '/api/ideas/[id]/constitution/draft', desc: 'AI drafts project rules from the current artifacts.' },
      { method: 'POST', path: '/api/ideas/[id]/context-pack', desc: 'Compile the Context Pack { target, lang, include* } → markdown + stats.' },
      { method: 'POST', path: '/api/ideas/[id]/verify', desc: 'Verify pasted code { code, label?, lang? } → per-check matrix + score.' },
      { method: 'GET', path: '/api/ideas/[id]/verify', desc: 'List verification runs (or ?runId for one).', tryable: true },
      { method: 'DELETE', path: '/api/ideas/[id]/verify', desc: 'Delete a run ?runId.' },
      { method: 'POST', path: '/api/ideas/[id]/drift', desc: 'Drift-check pasted code { code, label?, lang? } → per-decision verdicts + alignment.' },
      { method: 'GET', path: '/api/ideas/[id]/drift', desc: 'List drift checks (or ?checkId).', tryable: true },
      { method: 'DELETE', path: '/api/ideas/[id]/drift', desc: 'Delete a check ?checkId.' },
      { method: 'GET', path: '/api/ideas/[id]/decisions', desc: 'List standing decisions.', tryable: true },
      { method: 'POST', path: '/api/ideas/[id]/decisions', desc: 'Create a decision entry { title, choice, category, … }.' },
      { method: 'PATCH', path: '/api/ideas/[id]/decisions/[decisionId]', desc: 'Edit / supersede a decision.' },
      { method: 'DELETE', path: '/api/ideas/[id]/decisions/[decisionId]', desc: 'Delete a decision.' },
      { method: 'POST', path: '/api/ideas/[id]/site-intel', desc: 'Start a site study { url } → 7-stage analysis + clone pack.' },
      { method: 'GET', path: '/api/ideas/[id]/site-intel', desc: 'List analyses (or ?analysisId).', tryable: true },
      { method: 'DELETE', path: '/api/ideas/[id]/site-intel', desc: 'Delete an analysis ?analysisId.' },
    ],
  },
  {
    group: 'Playbook & tools',
    entries: [
      { method: 'GET', path: '/api/playbook', desc: 'List prompt templates.', tryable: true },
      { method: 'POST', path: '/api/playbook', desc: 'Create a template { title, description, category, body, … }.' },
      { method: 'PATCH', path: '/api/playbook/[id]', desc: 'Edit a template (builtin protected from delete only).' },
      { method: 'DELETE', path: '/api/playbook/[id]', desc: 'Delete a template (not builtin).' },
      { method: 'POST', path: '/api/playbook/[id]/use', desc: 'Mark a template used (useCount++) and return the rendered body.' },
      { method: 'POST', path: '/api/playbook/draft', desc: 'AI drafts a template { title, description, category }.' },
      { method: 'POST', path: '/api/tools/enhance', desc: 'Prompt-engineering pass { text, projectType }.' },
      { method: 'POST', path: '/api/tools/translate', desc: 'Translate { text, target: ar|en }.' },
    ],
  },
  {
    group: 'Admin (this panel)',
    entries: [
      { method: 'GET', path: '/api/admin/overview', desc: 'Dashboard payload: counts per model, ideas by stage, runtime info, latest activity.', tryable: true },
      { method: 'GET', path: '/api/admin/table/[model]', desc: 'Browse any table ?page&pageSize&q&schema — all 20 models.', tryable: true },
      { method: 'DELETE', path: '/api/admin/table/[model]', desc: 'Clear every row of a table.' },
      { method: 'PATCH', path: '/api/admin/record/[model]/[id]', desc: 'Edit a record\'s scalar fields (type-cast by schema).' },
      { method: 'DELETE', path: '/api/admin/record/[model]/[id]', desc: 'Delete a single record.' },
      { method: 'GET', path: '/api/admin/export', desc: 'Download the full database as JSON.', tryable: true },
      { method: 'POST', path: '/api/admin/reset', desc: 'Wipe data { scope: all|ideas|playbooks|constitution|runs }.' },
    ],
  },
]
