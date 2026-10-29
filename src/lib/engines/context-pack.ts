import { db } from '@/lib/db'
import { chatJson } from '@/lib/ai'
import { buildIdeaDetail, logDecision } from '@/lib/payload'
import { listDecisions } from '@/lib/engines/drift'
import type {
  ConstitutionCategory,
  ConstitutionRule,
  ContextPackOptions,
  ContextPackResult,
  DecisionEntry,
  IdeaDetail,
} from '@/lib/types'

// ============================================================
// Context Pack — the vibe-coding handoff armor.
//
// Two capabilities live here:
//
//   1. draftConstitution() : AI skill that reads the project's
//      approved context and drafts project-specific non-negotiable
//      rules (the "AI Constitution") that get injected into every
//      AI interaction from now on.
//
//   2. buildContextPack()  : DETERMINISTIC compiler (no AI, no
//      latency, no hallucination) that merges the project brief,
//      the merged constitution (global + project rules), and the
//      engineering artifacts into one tool-framed Markdown brief
//      ready to paste into Bolt / Cursor / Claude / ChatGPT.
//
// Design rule: AI drafts rules, but the pack itself is compiled
// from verified data only — an AI never rewrites the spec on its
// way out the door.
// ============================================================

// ---------- Target-tool framings ----------

const TARGET_FRAMING: Record<ContextPackOptions['target'], Record<'en' | 'ar', string>> = {
  bolt: {
    en: `You are an expert senior full-stack engineer working inside Bolt.new.
Build this project EXACTLY as specified below. The "AI Constitution" section lists NON-NEGOTIABLE rules: violating any of them makes the deliverable unacceptable. If something is genuinely ambiguous, ask one focused question instead of guessing or silently adding scope.`,
    ar: `أنت مهندس برمجيات خبير يعمل داخل Bolt.new.
ابنِ هذا المشروع تمامًا كما هو محدد أدناه. قسم "دستور الذكاء الاصطناعي" يحتوي قواعد غير قابلة للتفاوض: خرق أي منها يجعل التسليم غير مقبول. إذا وجدت غموضًا حقيقيًا فاسأل سؤالًا واحدًا مركّزًا بدلًا من التخمين أو إضافة نطاق بصمت.`,
  },
  cursor: {
    en: `CONTEXT BRIEF for Cursor (or any in-repo AI coding agent).
You are working inside an existing codebase. Treat this document as the source of truth for the project's intent, data model, and constraints. Follow the "AI Constitution" section as hard rules for every edit, refactor, and new file. Never rename public APIs, routes, or entities without explicitly asking first.`,
    ar: `ملف سياق لموجه Cursor (أو أي وكيل برمجة يعمل داخل مستودع موجود).
أنت تعمل داخل قاعدة كود قائمة. اعتبر هذا المستند هو مصدر الحقيقة لنوايا المشروع ونموذج بياناته وقيوده. التزم بقسم "دستور الذكاء الاصطناعي" كقواعد صارمة في كل تعديل وإعادة هيكلة وملف جديد. لا تعد تسمية أي API أو مسار أو كيان دون سؤال صريح أولًا.`,
  },
  claude: {
    en: `You are an expert senior software engineer and system architect. A developer is handing you the complete, approved engineering package below and expects you to implement or review against it with full fidelity.
The "AI Constitution" section overrides convenience: these are the developer's standing rules. Before writing code, confirm your plan respects every rule; while coding, reference requirement codes (FR-xxx / NFR-xxx) in comments and commit messages.`,
    ar: `أنت مهندس برمجيات خبير ومعماري أنظمة. يسلّمك المطوّر الحزمة الهندسية الكاملة المعتمدة أدناه ويتوقع منك التنفيذ أو المراجعة بأمانة كاملة.
قسم "دستور الذكاء الاصطناعي" يتفوق على عامل الراحة: هذه قواعد المطوّر الثابتة. قبل كتابة الكود أكّد أن خطتك تحترم كل قاعدة؛ وأثناء البرمجة أشر إلى رموز المتطلبات (FR-xxx / NFR-xxx) في التعليقات ورسائل الالتزام.`,
  },
  chatgpt: {
    en: `You are acting as a senior software engineer. Below is the complete approved specification for a project, followed by hard rules ("AI Constitution") and the engineering details. Work strictly within this spec: answer questions from it, implement against it, and flag anything that contradicts it rather than improvising.`,
    ar: `أنت تؤدي دور مهندس برمجيات خبير. أدناه المواصفة الكاملة المعتمدة لمشروع، تليها قواعد صارمة ("دستور الذكاء الاصطناعي") ثم التفاصيل الهندسية. اعمل داخل حدود هذه المواصفة فقط: أجب منها، ونفّذ وفقها، وأبرز أي تعارض تجده بدلًا من الارتجال.`,
  },
  generic: {
    en: `PROJECT BRIEF — approved engineering specification. Read fully before responding. The "AI Constitution" section contains non-negotiable constraints.`,
    ar: `ملخص المشروع — مواصفة هندسية معتمدة. اقرأه كاملًا قبل الرد. قسم "دستور الذكاء الاصطناعي" يحتوي قيودًا غير قابلة للتفاوض.`,
  },
}

// ---------- Bilingual section labels ----------

const L = (lang: 'ar' | 'en') => ({
  framing: lang === 'ar' ? 'التعريف' : 'Framing',
  project: lang === 'ar' ? 'تعريف المشروع' : 'Project definition',
  constitution: lang === 'ar' ? 'دستور الذكاء الاصطناعي — قواعد غير قابلة للتفاوض' : 'AI Constitution — non-negotiable rules',
  globalRules: lang === 'ar' ? 'قواعد عامة (كل المشاريع)' : 'Global rules (all projects)',
  projectRules: lang === 'ar' ? 'قواعد خاصة بهذا المشروع' : 'Project-specific rules',
  requirements: lang === 'ar' ? 'المتطلبات المعتمدة' : 'Approved requirements',
  architecture: lang === 'ar' ? 'المعمارية والتقنيات' : 'Architecture & tech stack',
  dataModel: lang === 'ar' ? 'نموذج البيانات والواجهات البرمجية' : 'Data model & API surface',
  screens: lang === 'ar' ? 'الشاشات' : 'Screens',
  tasks: lang === 'ar' ? 'خطة التنفيذ' : 'Implementation plan',
  risks: lang === 'ar' ? 'المخاطر والتخفيفات' : 'Risks & mitigations',
  activity: lang === 'ar' ? 'سجل النشاط' : 'Activity log',
  approvedDecisions: lang === 'ar' ? 'القرارات المعتمدة — اختيارات ثابتة' : 'Approved decisions — standing choices',
  agreements: lang === 'ar' ? 'اتفاقيات العمل — كيف نتعامل معًا' : 'Working agreements — how we work together',
  problem: lang === 'ar' ? 'المشكلة' : 'Problem',
  concept: lang === 'ar' ? 'الفكرة' : 'Concept',
  type: lang === 'ar' ? 'نوع المشروع' : 'Build target',
  users: lang === 'ar' ? 'المستخدمون' : 'Target users',
  none: lang === 'ar' ? 'لا يوجد' : 'None',
  phase: lang === 'ar' ? 'المرحلة' : 'Phase',
  depends: lang === 'ar' ? 'يعتمد على' : 'depends on',
  priority: lang === 'ar' ? 'الأولوية' : 'priority',
  must: lang === 'ar' ? 'إلزامي' : 'MUST',
  should: lang === 'ar' ? 'مهم' : 'SHOULD',
  could: lang === 'ar' ? 'تحسين' : 'COULD',
  entities: lang === 'ar' ? 'الكيانات' : 'Entities',
  endpoints: lang === 'ar' ? 'نقاط النهاية' : 'Endpoints',
  fields: lang === 'ar' ? 'الحقول' : 'fields',
  auth: lang === 'ar' ? 'الصلاحية' : 'auth',
  roles: lang === 'ar' ? 'الأدوار' : 'Roles',
  techStack: lang === 'ar' ? 'مكدس التقنيات' : 'Tech stack',
  components: lang === 'ar' ? 'المكونات' : 'Components',
  integrations: lang === 'ar' ? 'التكاملات' : 'Integrations',
  likelihood: lang === 'ar' ? 'الاحتمالية' : 'likelihood',
  impact: lang === 'ar' ? 'الأثر' : 'impact',
  mitigation: lang === 'ar' ? 'التخفيف' : 'mitigation',
  rtl: 'RTL',
})

const CATEGORY_LABEL: Record<ConstitutionCategory, Record<'ar' | 'en', string>> = {
  stack: { en: 'Stack', ar: 'التقنيات' },
  coding: { en: 'Coding', ar: 'البرمجة' },
  security: { en: 'Security', ar: 'الأمان' },
  design: { en: 'Design', ar: 'التصميم' },
  quality: { en: 'Quality', ar: 'الجودة' },
  workflow: { en: 'Workflow', ar: 'سير العمل' },
}

const WORKING_AGREEMENTS: Record<'ar' | 'en', string[]> = {
  en: [
    'Stay inside the specified scope — never add unrequested features, pages, or dependencies; if you believe something is missing, propose it as a question instead of building it.',
    'Never silently rename, remove, or repurpose existing entities, routes, fields, or files — ask first.',
    'When a requirement code (FR-xxx / NFR-xxx) exists for what you are building, mention it in the relevant comment or commit message.',
    'If anything in this brief is ambiguous or contradictory, stop and ask one focused question instead of guessing.',
    'Prefer the simplest implementation that satisfies the requirement; do not introduce abstractions without justification.',
    'If you cannot satisfy a constitution rule with the chosen stack, say so explicitly instead of quietly violating it.',
  ],
  ar: [
    'ابقَ داخل النطاق المحدد — لا تضف ميزات أو صفحات أو تبعيات غير مطلوبة أبدًا؛ إذا رأيت نقصًا فاقترحه كسؤال بدلًا من بنائه.',
    'لا تعد تسمية أو تحذف أو تعيد توظيف أي كيان أو مسار أو حقل أو ملف موجود بصمت — اسأل أولًا.',
    'إذا وُجد رمز متطلب (FR-xxx / NFR-xxx) لما تبنيه، فاذكره في التعليق أو رسالة الالتزام ذات الصلة.',
    'إذا وجدت غموضًا أو تعارضًا في هذا الملف فتوقف واسأل سؤالًا مركزًا واحدًا بدلًا من التخمين.',
    'فضّل أبسط تنفيذ يحقق المتطلب؛ لا تُدخل تجريدات بلا مبرر.',
    'إذا تعذّر الالتزام بقاعدة من الدستور مع المكدس المختار فقل ذلك صراحةً بدلًا من خرقها بصمت.',
  ],
}

// ============================================================
// 1. Constitution drafting skill (AI)
// ============================================================

const DRAFT_PROMPT = `You are the Constitution Drafter skill of a software product discovery platform. Your users are developers who hand approved specs to AI coding tools (Bolt, Replit, Cursor, Claude, ChatGPT) and need protection from the ways those tools typically fail: context drift, scope creep, silent renames, stack swaps, and skipped edge cases.

Analyze the project context below and draft a PROJECT-SPECIFIC "AI Constitution": the set of non-negotiable rules that, when injected into every AI interaction, prevents the most likely ways an AI builder could ruin THIS project.

Return STRICT JSON only — no markdown fences, no commentary — with exactly this key:
- "rules": array of 6-12 objects { "category": one of "stack" | "coding" | "security" | "design" | "quality" | "workflow", "text": the rule }.

Rule-writing rules:
- Each rule is ONE imperative sentence, directly enforceable by a coding agent ("Use Prisma with SQLite; do not introduce another ORM", not "Use good tools").
- stack: lock technology decisions already made or implied (framework, database, styling, language); forbid silent swaps or additions.
- coding: naming conventions, file/folder structure, patterns to follow or avoid, error-handling policy, typed inputs/outputs.
- security: concrete to THIS project's features — input validation on the exact entities, auth guards on the exact routes, secrets handling, injection and XSS prevention.
- design: UI consistency, RTL support when Arabic users are implied, responsive behavior, loading/empty/error states, accessibility basics.
- quality: type safety, tests for core flows, no placeholder/TODO code in deliverables, definition of done.
- workflow: how the AI must behave — ask before adding scope, no renames without approval, flag contradictions with the spec, never delete existing behavior silently.
- Ground every rule in ACTUAL facts from the context (features, entities, screens, stack, risks, requirements). Never invent a constraint that contradicts the spec.
- Write each rule's text in the SAME LANGUAGE as the project brief below (Arabic brief -> Arabic rules, English brief -> English rules).`

export async function draftConstitution(ideaId: string): Promise<ConstitutionRule[]> {
  const detail = await buildIdeaDetail(ideaId)
  if (!detail) throw new Error('Idea not found')

  const digest = projectDigest(detail)
  const result = await chatJson<{ rules?: Array<{ category?: string; text?: string }> }>(
    DRAFT_PROMPT,
    `Project context (approved artifacts only):\n"""\n${digest}\n"""\n\nDraft the project constitution now.`
  )

  const rules = Array.isArray(result?.rules)
    ? result.rules
        .filter((r) => typeof r?.text === 'string' && r.text.trim().length > 8)
        .map((r) => ({
          category: (['stack', 'coding', 'security', 'design', 'quality', 'workflow'].includes(String(r.category))
            ? String(r.category)
            : 'coding') as ConstitutionCategory,
          text: (r.text as string).trim(),
        }))
        .slice(0, 12)
    : []
  if (rules.length < 3) throw new Error('Constitution skill returned too few rules')

  // Persist as project-scoped, AI-origin rules appended after existing ones
  const existing = await db.constitutionRule.count({ where: { ideaId } })
  const created = await db.constitutionRule.createMany({
    data: rules.map((r, i) => ({
      ideaId,
      category: r.category,
      text: r.text,
      origin: 'ai',
      enabled: true,
      order: existing + i,
    })),
  })
  if (!created.count) throw new Error('Failed to save constitution rules')

  await logDecision(ideaId, 'AI constitution drafted', `${rules.length} project rules from approved context`, 'package')

  return listRules(ideaId)
}

// ============================================================
// 2. Rule helpers (shared by API routes)
// ============================================================

export async function listRules(ideaId: string | null): Promise<ConstitutionRule[]> {
  const rows = ideaId
    ? await db.constitutionRule.findMany({
        where: { OR: [{ ideaId }, { ideaId: null }] },
        orderBy: [{ ideaId: 'desc' }, { order: 'asc' }, { createdAt: 'asc' }],
      })
    : await db.constitutionRule.findMany({
        where: { ideaId: null },
        orderBy: [{ order: 'asc' }, { createdAt: 'asc' }],
      })
  return rows.map((r) => ({
    id: r.id,
    scope: r.ideaId === null ? ('global' as const) : ('project' as const),
    category: r.category as ConstitutionCategory,
    text: r.text,
    origin: r.origin === 'ai' ? ('ai' as const) : ('user' as const),
    enabled: r.enabled,
    order: r.order,
  }))
}

// ============================================================
// 3. Context Pack compiler (deterministic — no AI)
// ============================================================

// Compact, fact-only digest of the project used for AI drafting
function projectDigest(d: IdeaDetail): string {
  const parts: string[] = []
  parts.push(`Title: ${d.idea.title}`)
  parts.push(`Build target: ${d.idea.projectType ?? 'app'}`)
  if (d.idea.interpretation) {
    parts.push(`Problem: ${d.idea.interpretation.problemStatement}`)
    parts.push(`Interpretation: ${d.idea.interpretation.englishInterpretation}`)
  }
  const confirmedFeatures = d.features.filter((f) => f.status === 'accepted')
  if (confirmedFeatures.length)
    parts.push(
      `Approved features:\n${confirmedFeatures.map((f) => `- [${f.priority}] ${f.module} / ${f.feature} (for: ${f.user})`).join('\n')}`
    )
  const confirmedReqs = d.requirements.filter((r) => r.status === 'confirmed')
  if (confirmedReqs.length)
    parts.push(
      `Confirmed requirements:\n${confirmedReqs.slice(0, 30).map((r) => `- ${r.code} (${r.type === 'functional' ? 'FR' : 'NFR'}, ${r.priority}): ${r.title} — ${r.description}`).join('\n')}`
    )
  if (d.entities.length)
    parts.push(
      `Data entities:\n${d.entities.slice(0, 15).map((e) => `- ${e.name}: ${e.fields.map((f) => f.name).join(', ')}`).join('\n')}`
    )
  if (d.screens.length)
    parts.push(`Screens: ${d.screens.map((s) => s.name).join(', ')}`)
  if (d.architecture?.techStack?.length)
    parts.push(
      `Tech stack: ${d.architecture.techStack.map((t) => `${t.area}=${t.choice}`).join('; ')}`
    )
  const topRisks = d.risks.filter((r) => r.impact === 'high' || r.impact === 'critical').slice(0, 6)
  if (topRisks.length)
    parts.push(`Top risks:\n${topRisks.map((r) => `- ${r.description}`).join('\n')}`)
  if (d.idea.sourceLang === 'ar' || d.screens.some((s) => s.rtlNote))
    parts.push(`Localization note: Arabic users / RTL interface implied`)
  return parts.join('\n\n')
}

export async function buildContextPack(ideaId: string, options: ContextPackOptions): Promise<ContextPackResult> {
  const detail = await buildIdeaDetail(ideaId)
  if (!detail) throw new Error('Idea not found')

  const rules = options.includeConstitution ? await listRules(ideaId) : []
  const activeRules = rules.filter((r) => r.enabled)
  const decisions = (await listDecisions(ideaId)).filter((d) => d.status === 'active')
  const markdown = compilePack(detail, activeRules, decisions, options)

  return {
    markdown,
    stats: {
      characters: markdown.length,
      words: markdown.split(/\s+/).filter(Boolean).length,
      lines: markdown.split('\n').length,
      sections: (markdown.match(/^## /gm) ?? []).length,
      rulesApplied: activeRules.length,
    },
    generatedAt: new Date().toISOString(),
  }
}

function compilePack(d: IdeaDetail, rules: ConstitutionRule[], decisions: DecisionEntry[], o: ContextPackOptions): string {
  const s = L(o.lang)
  const out: string[] = []
  const h2 = (title: string) => out.push('', `## ${title}`, '')
  const h3 = (title: string) => out.push('', `### ${title}`, '')

  // ---------- Header + framing ----------
  out.push(`# ${d.idea.title}`)
  out.push('', `> ${TARGET_FRAMING[o.target][o.lang]}`)

  // ---------- Project definition ----------
  h2(s.project)
  out.push(`- **${s.type}:** ${d.idea.projectType ?? 'app'}`)
  if (d.idea.interpretation) {
    out.push(`- **${s.concept}:** ${d.idea.interpretation.englishInterpretation}`)
    out.push(`- **${s.problem}:** ${d.idea.interpretation.problemStatement}`)
  }
  const roles = d.roles?.map((r) => r.name).join(', ')
  if (roles) out.push(`- **${s.users} / ${s.roles}:** ${roles}`)

  // ---------- Constitution ----------
  if (rules.length > 0) {
    h2(s.constitution)
    const global = rules.filter((r) => r.scope === 'global')
    const project = rules.filter((r) => r.scope === 'project')
    const emit = (list: ConstitutionRule[], title: string) => {
      h3(title)
      for (const cat of Object.keys(CATEGORY_LABEL) as ConstitutionCategory[]) {
        const group = list.filter((r) => r.category === cat)
        if (!group.length) continue
        out.push('', `**${CATEGORY_LABEL[cat][o.lang]}**`)
        group.forEach((r, i) => out.push(`${i + 1}. ${r.text}`))
      }
    }
    if (global.length) emit(global, s.globalRules)
    if (project.length) emit(project, s.projectRules)
  }

  // ---------- Approved decisions (standing choices) ----------
  if (decisions.length > 0) {
    h2(s.approvedDecisions)
    out.push(
      o.lang === 'ar'
        ? 'هذه اختيارات معتمدة لا يجوز لأي أداة بناء تجاوزها أو تغييرها بصمت. تعديل أي منها يتطلب موافقة صريحة من المطوّر.'
        : 'These are approved choices no AI builder may silently override or change. Revising any of them requires explicit approval from the developer.'
    )
    for (const dec of decisions) {
      out.push(`- \`${dec.code}\` **${dec.title}:** ${dec.choice}`)
      if (dec.rationale) out.push(`  - ${o.lang === 'ar' ? 'لماذا' : 'Why'}: ${dec.rationale}`)
      if (dec.alternatives) out.push(`  - ${o.lang === 'ar' ? 'مرفوض' : 'Rejected'}: ${dec.alternatives}`)
    }
  }

  // ---------- Requirements ----------
  if (o.includeRequirements) {
    const confirmed = d.requirements.filter((r) => r.status === 'confirmed')
    if (confirmed.length) {
      h2(s.requirements)
      const frs = confirmed.filter((r) => r.type === 'functional')
      const nfrs = confirmed.filter((r) => r.type === 'non_functional')
      if (frs.length) {
        for (const p of ['must', 'should', 'could'] as const) {
          const group = frs.filter((r) => r.priority === p)
          if (!group.length) continue
          out.push('', `**${s.priority}: ${L(o.lang)[p]}**`)
          for (const r of group) {
            out.push(`- \`${r.code}\` **${r.title}** — ${r.description}`)
            if (r.acceptanceCriteria.length)
              out.push(`  - ${o.lang === 'ar' ? 'معايير القبول' : 'Acceptance'}: ${r.acceptanceCriteria.join(' · ')}`)
          }
        }
      }
      if (nfrs.length) {
        h3(o.lang === 'ar' ? 'متطلبات غير وظيفية' : 'Non-functional requirements')
        for (const r of nfrs)
          out.push(`- \`${r.code}\` **${r.title}** (${r.category ?? 'general'}) — ${r.description}`)
      }
    }
  }

  // ---------- Architecture ----------
  if (o.includeArchitecture && d.architecture) {
    h2(s.architecture)
    if (d.architecture.techStack.length) {
      out.push(`**${s.techStack}:**`)
      for (const t of d.architecture.techStack) out.push(`- **${t.area}:** ${t.choice}${t.rationale ? ` — ${t.rationale}` : ''}`)
    }
    if (d.architecture.components?.length) {
      out.push('', `**${s.components}:**`)
      for (const c of d.architecture.components) out.push(`- **${c.name}:** ${c.responsibility}`)
    }
    if (d.architecture.integrations?.length) {
      out.push('', `**${s.integrations}:**`)
      for (const i of d.architecture.integrations) out.push(`- **${i.system}:** ${i.purpose} (${i.necessity})`)
    }
    if (d.architecture.notes) out.push('', d.architecture.notes)
  }

  // ---------- Data model + APIs ----------
  if (o.includeDataModel) {
    const ents = d.entities.filter((e) => e.status === 'confirmed' || e.status === 'proposed')
    const apis = d.apis.filter((a) => a.status === 'confirmed' || a.status === 'proposed')
    if (ents.length || apis.length) {
      h2(s.dataModel)
      if (ents.length) {
        h3(s.entities)
        for (const e of ents) {
          out.push(`- **${e.name}** (${e.fields.length} ${s.fields}): ${e.fields.map((f) => f.name).join(', ')}`)
          for (const rel of e.relationships) out.push(`  - ${rel.type} → ${rel.target}${rel.description ? ` (${rel.description})` : ''}`)
        }
      }
      if (apis.length) {
        h3(s.endpoints)
        for (const a of apis)
          out.push(`- \`${a.method} ${a.path}\` — ${a.purpose}${a.auth ? ` · ${s.auth}: ${a.auth}` : ''}`)
      }
    }
  }

  // ---------- Screens ----------
  if (o.includeScreens) {
    const screens = d.screens.filter((x) => x.status === 'confirmed' || x.status === 'proposed')
    if (screens.length) {
      h2(s.screens)
      for (const sc of screens) {
        out.push(`- **${sc.name}**${sc.route ? ` (\`${sc.route}\`)` : ''} — ${sc.purpose ?? ''}`)
        if (sc.roles.length) out.push(`  - ${s.roles}: ${sc.roles.join(', ')}`)
        if (sc.rtlNote) out.push(`  - ${s.rtl}: ${sc.rtlNote}`)
      }
    }
  }

  // ---------- Tasks ----------
  if (o.includeTasks) {
    const tasks = d.tasks.filter((t) => t.status === 'confirmed' || t.status === 'proposed')
    if (tasks.length) {
      h2(s.tasks)
      const phases = [...new Set(tasks.map((t) => t.phase))].sort((a, b) => a - b)
      for (const phase of phases) {
        out.push('', `**${s.phase} ${phase}**`)
        for (const t of tasks.filter((x) => x.phase === phase))
          out.push(`- \`${t.code}\` **${t.title}** (${L(o.lang)[t.priority]})${t.dependsOn.length ? ` — ${s.depends}: ${t.dependsOn.join(', ')}` : ''}`)
      }
    }
  }

  // ---------- Risks ----------
  if (o.includeRisks) {
    const risks = d.risks.filter((r) => r.status !== 'proposed' || r.impact === 'critical')
    if (risks.length) {
      h2(s.risks)
      for (const r of risks)
        out.push(
          `- \`${r.code}\` **${r.category}** — ${r.description} (${s.likelihood}: ${r.likelihood}, ${s.impact}: ${r.impact})${r.mitigation ? ` → ${s.mitigation}: ${r.mitigation}` : ''}`
        )
    }
  }

  // ---------- Activity log (audit trail) ----------
  if (o.includeDecisions && d.decisions.length) {
    h2(s.activity)
    for (const dec of d.decisions.slice(0, 25))
      out.push(`- ${dec.createdAt.slice(0, 10)} — **${dec.action}**${dec.detail ? `: ${dec.detail}` : ''}`)
  }

  // ---------- Working agreements ----------
  h2(s.agreements)
  for (const a of WORKING_AGREEMENTS[o.lang]) out.push(`- ${a}`)

  out.push('')
  return out.join('\n')
}
