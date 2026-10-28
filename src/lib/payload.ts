import { db } from '@/lib/db'
import { safeParseJson, isProbablyArabic } from '@/lib/json-utils'
import type {
  Assumption,
  BaselineSnapshot,
  Decision,
  Feature,
  FeatureStatus,
  IdeaDetail,
  IdeaListItem,
  IdeaRecord,
  IdeaSummaryData,
  Interpretation,
  Priority,
  Question,
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
    },
  })
  if (!idea) return null

  const record: IdeaRecord = {
    id: idea.id,
    title: idea.title,
    originalText: idea.originalText,
    sourceLang: idea.sourceLang === 'en' || isProbablyArabic(idea.originalText) ? (idea.sourceLang as 'ar' | 'en') : 'ar',
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

  return { idea: record, questions, features, assumptions, decisions }
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
