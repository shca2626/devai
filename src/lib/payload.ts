import { db } from '@/lib/db'
import { safeParseJson, isProbablyArabic } from '@/lib/json-utils'
import { computeReadiness } from '@/lib/readiness'
import type {
  ApiEndpoint,
  Architecture,
  Assumption,
  BaselineSnapshot,
  ConsistencyIssue,
  DataEntity,
  Decision,
  Feature,
  FeatureStatus,
  IdeaDetail,
  IdeaListItem,
  IdeaRecord,
  IdeaSummaryData,
  ImplTask,
  Interpretation,
  Priority,
  ProcessFlow,
  ProjectType,
  Question,
  Requirement,
  RiskItem,
  Role,
  ScreenSpec,
  Stage,
  FeaturesMeta,
} from '@/lib/types'

// ============================================================
// Server-side payload builders — parse stored JSON columns
// into typed API responses, with defensive fallbacks.
// ============================================================

export function parseInterpretation(raw: string | null): Interpretation | null {
  if (!raw) return null
  try {
    const v = safeParseJson<Interpretation>(raw)
    return {
      title: v.title ?? 'Untitled idea',
      englishInterpretation: v.englishInterpretation ?? '',
      problemStatement: v.problemStatement ?? '',
      understood: Array.isArray(v.understood) ? v.understood : [],
      unclear: Array.isArray(v.unclear) ? v.unclear : [],
      assumed: Array.isArray(v.assumed) ? v.assumed : [],
    }
  } catch {
    return null
  }
}

export function parseSummary(raw: string | null): IdeaSummaryData | null {
  if (!raw) return null
  try {
    const v = safeParseJson<IdeaSummaryData>(raw)
    return {
      summaryMarkdown: v.summaryMarkdown ?? '',
      openRisks: Array.isArray(v.openRisks) ? v.openRisks : [],
    }
  } catch {
    return null
  }
}

export function parseFeaturesMeta(raw: string | null): FeaturesMeta | null {
  if (!raw) return null
  try {
    const v = safeParseJson<FeaturesMeta>(raw)
    return {
      missingFeatures: Array.isArray(v.missingFeatures) ? v.missingFeatures : [],
      dependencies: Array.isArray(v.dependencies) ? v.dependencies : [],
      releaseNote: v.releaseNote ?? '',
    }
  } catch {
    return null
  }
}

export function parseBaseline(raw: string | null): BaselineSnapshot | null {
  if (!raw) return null
  try {
    return safeParseJson<BaselineSnapshot>(raw)
  } catch {
    return null
  }
}

export async function buildIdeaDetail(ideaId: string): Promise<IdeaDetail | null> {
  const idea = await db.idea.findUnique({
    where: { id: ideaId },
    include: {
      questions: { orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] },
      features: { orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] },
      assumptions: { orderBy: { createdAt: 'asc' } },
      decisions: { orderBy: { createdAt: 'desc' } },
      requirements: { orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] },
      processes: { orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] },
      entities: { orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] },
      apiEndpoints: { orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] },
      screens: { orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] },
      tasks: { orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] },
      risks: { orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] },
      issues: { orderBy: { createdAt: 'desc' } },
      architecture: true,
    },
  })
  if (!idea) return null

  const record: IdeaRecord = {
    id: idea.id,
    title: idea.title,
    originalText: idea.originalText,
    sourceLang: idea.sourceLang === 'en' || isProbablyArabic(idea.originalText) ? (idea.sourceLang as 'ar' | 'en') : 'ar',
    projectType:
      idea.projectType === 'website' || idea.projectType === 'app' || idea.projectType === 'prototype'
        ? (idea.projectType as ProjectType)
        : null,
    stage: idea.stage as Stage,
    interpretation: parseInterpretation(idea.interpretation),
    summary: parseSummary(idea.summary),
    featuresMeta: parseFeaturesMeta(idea.featuresMeta),
    baseline: parseBaseline(idea.baseline),
    createdAt: idea.createdAt.toISOString(),
    updatedAt: idea.updatedAt.toISOString(),
  }

  const questions: Question[] = idea.questions.map((q) => ({
    id: q.id,
    area: q.area as Question['area'],
    questionEn: q.questionEn,
    questionAr: q.questionAr,
    whyItMatters: q.whyItMatters,
    options: (() => {
      try {
        return q.options ? safeParseJson<Question['options']>(q.options) : []
      } catch {
        return []
      }
    })(),
    answer: q.answer,
    answerKind: q.answerKind,
    status: q.status as Question['status'],
    order: q.order,
  }))

  const features: Feature[] = idea.features.map((f) => ({
    id: f.id,
    module: f.module,
    feature: f.feature,
    user: f.user,
    priority: f.priority as Priority,
    status: f.status as FeatureStatus,
    rationale: f.rationale,
    origin: f.origin as 'ai' | 'user',
    order: f.order,
  }))

  const assumptions: Assumption[] = idea.assumptions.map((a) => ({
    id: a.id,
    text: a.text,
    kind: a.kind as Assumption['kind'],
    status: a.status as Assumption['status'],
    source: a.source as Assumption['source'],
    createdAt: a.createdAt.toISOString(),
  }))

  const decisions: Decision[] = idea.decisions.map((d) => ({
    id: d.id,
    action: d.action,
    detail: d.detail,
    stage: d.stage,
    createdAt: d.createdAt.toISOString(),
  }))

  // ---------- Engineering track ----------
  const parseJsonArray = <T>(raw: string | null | undefined, fallback: T): T => {
    if (!raw) return fallback
    try {
      return safeParseJson<T>(raw)
    } catch {
      return fallback
    }
  }

  let roles: Role[] | null = null
  if (idea.roles) {
    try {
      const parsed = safeParseJson<Role[]>(idea.roles)
      roles = Array.isArray(parsed) ? parsed : null
    } catch {
      roles = null
    }
  }

  const requirements: Requirement[] = idea.requirements.map((r) => ({
    id: r.id,
    code: r.code,
    type: r.type === 'non_functional' ? 'non_functional' : 'functional',
    category: r.category,
    title: r.title,
    titleAr: r.titleAr,
    description: r.description,
    acceptanceCriteria: parseJsonArray<string[]>(r.acceptanceCriteria, []),
    provenance: r.provenance === 'client' ? 'client' : 'ai',
    evidence: r.evidence,
    featureId: r.featureId,
    priority: r.priority as Priority,
    status: r.status as Requirement['status'],
    order: r.order,
  }))

  const processes: ProcessFlow[] = idea.processes.map((p) => ({
    id: p.id,
    code: p.code,
    name: p.name,
    nameAr: p.nameAr,
    trigger: p.trigger,
    actors: parseJsonArray<string[]>(p.actors, []),
    steps: parseJsonArray<ProcessFlow['steps']>(p.steps, []),
    businessRules: parseJsonArray<ProcessFlow['businessRules']>(p.businessRules, []),
    exceptions: parseJsonArray<string[]>(p.exceptions, []),
    linkedRequirements: parseJsonArray<string[]>(p.linkedRequirements, []),
    rationale: p.rationale,
    status: p.status as ProcessFlow['status'],
    order: p.order,
  }))

  const entities: DataEntity[] = idea.entities.map((e) => ({
    id: e.id,
    code: e.code,
    name: e.name,
    nameAr: e.nameAr,
    description: e.description,
    fields: parseJsonArray<DataEntity['fields']>(e.fields, []),
    relationships: parseJsonArray<DataEntity['relationships']>(e.relationships, []),
    constraints: parseJsonArray<string[]>(e.constraints, []),
    rationale: e.rationale,
    status: e.status as DataEntity['status'],
    order: e.order,
  }))

  const apis: ApiEndpoint[] = idea.apiEndpoints.map((a) => ({
    id: a.id,
    code: a.code,
    method: a.method,
    path: a.path,
    purpose: a.purpose,
    auth: a.auth,
    request: parseJsonArray<ApiEndpoint['request']>(a.request, []),
    errors: parseJsonArray<ApiEndpoint['errors']>(a.errors, []),
    linkedRequirements: parseJsonArray<string[]>(a.linkedRequirements, []),
    linkedEntities: parseJsonArray<string[]>(a.linkedEntities, []),
    status: a.status as ApiEndpoint['status'],
    order: a.order,
  }))

  const screens: ScreenSpec[] = idea.screens.map((s) => ({
    id: s.id,
    code: s.code,
    name: s.name,
    nameAr: s.nameAr,
    route: s.route,
    purpose: s.purpose,
    roles: parseJsonArray<string[]>(s.roles, []),
    elements: parseJsonArray<ScreenSpec['elements']>(s.elements, []),
    states: parseJsonArray<ScreenSpec['states']>(s.states, { loading: '', empty: '', error: '' }),
    rtlNote: s.rtlNote,
    linkedRequirements: parseJsonArray<string[]>(s.linkedRequirements, []),
    status: s.status as ScreenSpec['status'],
    order: s.order,
  }))

  const tasks: ImplTask[] = idea.tasks.map((t) => ({
    id: t.id,
    code: t.code,
    title: t.title,
    titleAr: t.titleAr,
    description: t.description,
    phase: t.phase,
    priority: t.priority as Priority,
    dependsOn: parseJsonArray<string[]>(t.dependsOn, []),
    acceptanceCriteria: parseJsonArray<string[]>(t.acceptanceCriteria, []),
    deliverable: t.deliverable,
    requirementCodes: parseJsonArray<string[]>(t.requirementCodes, []),
    estimate: t.estimate,
    status: t.status as ImplTask['status'],
    order: t.order,
  }))

  const risks: RiskItem[] = idea.risks.map((r) => ({
    id: r.id,
    code: r.code,
    category: r.category as RiskItem['category'],
    description: r.description,
    likelihood: r.likelihood as RiskItem['likelihood'],
    impact: r.impact as RiskItem['impact'],
    mitigation: r.mitigation,
    basis: r.basis === 'verified_fact' ? 'verified_fact' : 'professional_judgment',
    status: r.status as RiskItem['status'],
    order: r.order,
  }))

  const issues: ConsistencyIssue[] = idea.issues.map((i) => ({
    id: i.id,
    kind: i.kind as ConsistencyIssue['kind'],
    severity: i.severity as ConsistencyIssue['severity'],
    description: i.description,
    affected: parseJsonArray<string[]>(i.affected, []),
    suggestion: i.suggestion,
    detectedBy: i.detectedBy === 'ai' ? 'ai' : 'engine',
    status: i.status as ConsistencyIssue['status'],
    createdAt: i.createdAt.toISOString(),
  }))

  const architecture: Architecture | null = idea.architecture
    ? {
        id: idea.architecture.id,
        components: parseJsonArray<Architecture['components']>(idea.architecture.components, []),
        integrations: parseJsonArray<Architecture['integrations']>(idea.architecture.integrations, []),
        techStack: parseJsonArray<Architecture['techStack']>(idea.architecture.techStack, []),
        notes: idea.architecture.notes,
        basis: idea.architecture.basis === 'verified_fact' ? 'verified_fact' : 'professional_judgment',
        status: idea.architecture.status as Architecture['status'],
      }
    : null

  const readiness = await computeReadiness(ideaId)

  return {
    idea: record,
    questions,
    features,
    assumptions,
    decisions,
    roles,
    requirements,
    processes,
    entities,
    apis,
    screens,
    tasks,
    risks,
    issues,
    architecture,
    readiness,
  }
}

export async function buildIdeaList(): Promise<IdeaListItem[]> {
  const ideas = await db.idea.findMany({
    orderBy: { updatedAt: 'desc' },
    include: {
      _count: { select: { questions: true, features: true } },
      questions: { where: { status: 'answered' }, select: { id: true } },
      features: { where: { status: 'accepted' }, select: { id: true } },
    },
  })
  return ideas.map((idea) => ({
    id: idea.id,
    title: idea.title,
    stage: idea.stage as Stage,
    projectType:
      idea.projectType === 'website' || idea.projectType === 'app' || idea.projectType === 'prototype'
        ? (idea.projectType as ProjectType)
        : null,
    updatedAt: idea.updatedAt.toISOString(),
    counts: {
      answered: idea.questions.length,
      totalQuestions: idea._count.questions,
      acceptedFeatures: idea.features.length,
      totalFeatures: idea._count.features,
    },
  }))
}

export async function logDecision(ideaId: string, action: string, detail?: string, stage?: string) {
  await db.decision.create({
    data: { ideaId, action, detail: detail ?? null, stage: stage ?? null },
  })
}

// ------------------------------------------------------------
// Baseline snapshot — single source of truth for the baseline
// gate (manual approval) and the express autopilot.
// ------------------------------------------------------------
export async function buildBaselineSnapshot(ideaId: string): Promise<BaselineSnapshot> {
  const idea = await db.idea.findUnique({ where: { id: ideaId } })
  if (!idea) throw new Error('Idea not found')

  const [finalFeatures, openQuestions] = await Promise.all([
    db.feature.findMany({ where: { ideaId }, orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] }),
    db.question.findMany({ where: { ideaId, status: { not: 'answered' } }, select: { questionEn: true } }),
  ])

  return {
    approvedAt: new Date().toISOString(),
    interpretation: parseInterpretation(idea.interpretation),
    summary: parseSummary(idea.summary),
    features: finalFeatures.map((f) => ({
      module: f.module,
      feature: f.feature,
      user: f.user,
      priority: f.priority as BaselineSnapshot['features'][number]['priority'],
      status: f.status as BaselineSnapshot['features'][number]['status'],
      rationale: f.rationale,
    })),
    openQuestions: openQuestions.map((q) => q.questionEn),
  }
}
