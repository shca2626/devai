// ============================================================
// Blueprint Assistant P0 — shared types (mirrors API payloads)
// ============================================================

export const STAGES = ['understanding', 'discovery', 'features', 'baseline'] as const
export type Stage = (typeof STAGES)[number]

export const AREAS = [
  'business_problem',
  'target_users',
  'product_format',
  'business_model',
  'user_journeys',
  'scope',
  'constraints',
  'success_criteria',
  'unknowns',
] as const
export type Area = (typeof AREAS)[number]

export const FEATURE_STATUSES = [
  'proposed',
  'needs_confirmation',
  'accepted',
  'rejected',
  'deferred',
] as const
export type FeatureStatus = (typeof FEATURE_STATUSES)[number]

export const PRIORITIES = ['must', 'should', 'could'] as const
export type Priority = (typeof PRIORITIES)[number]

export interface Interpretation {
  title: string
  englishInterpretation: string
  problemStatement: string
  understood: string[]
  unclear: string[]
  assumed: string[]
}

export interface QuestionOption {
  label: string
  consequence: string
}

export interface Question {
  id: string
  area: Area
  questionEn: string
  questionAr: string | null
  whyItMatters: string | null
  options: QuestionOption[]
  answer: string | null
  answerKind: string | null
  status: 'pending' | 'answered' | 'skipped'
  order: number
}

export interface Feature {
  id: string
  module: string
  feature: string
  user: string
  priority: Priority
  status: FeatureStatus
  rationale: string | null
  origin: 'ai' | 'user'
  order: number
}

export interface Assumption {
  id: string
  text: string
  kind: 'suggested' | 'uncertain'
  status: 'open' | 'confirmed' | 'rejected'
  source: 'understanding' | 'discovery'
  createdAt: string
}

export interface Decision {
  id: string
  action: string
  detail: string | null
  stage: string | null
  createdAt: string
}

export interface IdeaSummaryData {
  summaryMarkdown: string
  openRisks: string[]
}

export interface FeaturesMeta {
  missingFeatures: string[]
  dependencies: string[]
  releaseNote: string
}

export interface BaselineSnapshot {
  approvedAt: string
  interpretation: Interpretation | null
  summary: IdeaSummaryData | null
  features: Array<Pick<Feature, 'module' | 'feature' | 'user' | 'priority' | 'status' | 'rationale'>>
  openQuestions: string[]
}

export interface IdeaRecord {
  id: string
  title: string
  originalText: string
  sourceLang: 'ar' | 'en'
  stage: Stage
  interpretation: Interpretation | null
  summary: IdeaSummaryData | null
  featuresMeta: FeaturesMeta | null
  baseline: BaselineSnapshot | null
  createdAt: string
  updatedAt: string
}

export interface IdeaDetail {
  idea: IdeaRecord
  questions: Question[]
  features: Feature[]
  assumptions: Assumption[]
  decisions: Decision[]
}

export interface IdeaListItem {
  id: string
  title: string
  stage: Stage
  updatedAt: string
  counts: {
    answered: number
    totalQuestions: number
    acceptedFeatures: number
    totalFeatures: number
  }
}

export function stageIndex(stage: Stage): number {
  return STAGES.indexOf(stage)
}

export function isLaterStage(a: Stage, b: Stage): boolean {
  return stageIndex(a) > stageIndex(b)
}
