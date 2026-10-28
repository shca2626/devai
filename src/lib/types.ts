// ============================================================
// Blueprint Assistant P0 — shared types (mirrors API payloads)
// ============================================================

export const STAGES = [
  'understanding',
  'discovery',
  'features',
  'baseline',
  'requirements',
  'design',
  'planning',
  'readiness',
  'package',
] as const
export type Stage = (typeof STAGES)[number]

// Engineering-track stage names (post-baseline)
export const ENGINEERING_STAGES = ['requirements', 'design', 'planning', 'readiness', 'package'] as const

// Review states for engineering artifacts (processes, entities, APIs, screens, tasks, architecture)
export const REVIEW_STATUSES = ['proposed', 'confirmed', 'rejected', 'needs_revision'] as const
export type ReviewStatus = (typeof REVIEW_STATUSES)[number]

// Requirement approval states — the Project Contract core
export const REQ_STATUSES = ['proposed', 'confirmed', 'rejected', 'unresolved'] as const
export type ReqStatus = (typeof REQ_STATUSES)[number]

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
  // Engineering track
  roles: Role[] | null
  requirements: Requirement[]
  processes: ProcessFlow[]
  entities: DataEntity[]
  apis: ApiEndpoint[]
  screens: ScreenSpec[]
  tasks: ImplTask[]
  risks: RiskItem[]
  issues: ConsistencyIssue[]
  architecture: Architecture | null
  readiness: ReadinessReport | null
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

// ============================================================
// Engineering track — artifact types (Project Contract registry)
// ============================================================

export interface Role {
  name: string
  description: string
  permissions: string[]
}

export interface Requirement {
  id: string
  code: string
  type: 'functional' | 'non_functional'
  category: string | null
  title: string
  titleAr: string | null
  description: string
  acceptanceCriteria: string[]
  provenance: 'client' | 'ai'
  evidence: string | null
  featureId: string | null
  priority: Priority
  status: ReqStatus
  order: number
}

export interface ProcessStep {
  n: number
  actor: string
  action: string
  input?: string
  output?: string
  decision?: string
  exception?: string
}

export interface BusinessRule {
  rule: string
  linkedRequirements: string[]
}

export interface ProcessFlow {
  id: string
  code: string
  name: string
  nameAr: string | null
  trigger: string | null
  actors: string[]
  steps: ProcessStep[]
  businessRules: BusinessRule[]
  exceptions: string[]
  linkedRequirements: string[]
  rationale: string | null
  status: ReviewStatus
  order: number
}

export interface EntityField {
  name: string
  type: string
  required: boolean
  unique: boolean
  description: string
  refEntity?: string
}

export interface EntityRelationship {
  target: string
  type: string
  description: string
}

export interface DataEntity {
  id: string
  code: string
  name: string
  nameAr: string | null
  description: string | null
  fields: EntityField[]
  relationships: EntityRelationship[]
  constraints: string[]
  rationale: string | null
  status: ReviewStatus
  order: number
}

export interface ApiRequestField {
  field: string
  type: string
  required: boolean
  notes: string
}

export interface ApiError {
  code: string
  when: string
}

export interface ApiEndpoint {
  id: string
  code: string
  method: string
  path: string
  purpose: string
  auth: string | null
  request: ApiRequestField[]
  errors: ApiError[]
  linkedRequirements: string[]
  linkedEntities: string[]
  status: ReviewStatus
  order: number
}

export interface ScreenElement {
  element: string
  behavior: string
}

export interface ScreenSpec {
  id: string
  code: string
  name: string
  nameAr: string | null
  route: string | null
  purpose: string | null
  roles: string[]
  elements: ScreenElement[]
  states: { loading: string; empty: string; error: string }
  rtlNote: string | null
  linkedRequirements: string[]
  status: ReviewStatus
  order: number
}

export interface ImplTask {
  id: string
  code: string
  title: string
  titleAr: string | null
  description: string
  phase: number
  priority: Priority
  dependsOn: string[]
  acceptanceCriteria: string[]
  deliverable: string | null
  requirementCodes: string[]
  estimate: string | null
  status: ReviewStatus
  order: number
}

export type RiskCategory =
  | 'security'
  | 'privacy'
  | 'performance'
  | 'operational'
  | 'financial'
  | 'scalability'
  | 'business'

export interface RiskItem {
  id: string
  code: string
  category: RiskCategory
  description: string
  likelihood: 'low' | 'medium' | 'high'
  impact: 'low' | 'medium' | 'high' | 'critical'
  mitigation: string | null
  basis: 'verified_fact' | 'professional_judgment'
  status: 'proposed' | 'mitigated' | 'accepted'
  order: number
}

export type IssueKind = 'contradiction' | 'omission' | 'duplicate' | 'broken_link' | 'incomplete' | 'change_impact'

export interface ConsistencyIssue {
  id: string
  kind: IssueKind
  severity: 'critical' | 'major' | 'minor'
  description: string
  affected: string[]
  suggestion: string | null
  detectedBy: 'engine' | 'ai'
  status: 'open' | 'resolved' | 'dismissed'
  createdAt: string
}

export interface TechChoice {
  area: string
  choice: string
  rationale: string
  tradeOffs: string
  simplestOption: boolean
}

export interface Architecture {
  id: string
  components: Array<{ name: string; responsibility: string }>
  integrations: Array<{ system: string; purpose: string; necessity: string }>
  techStack: TechChoice[]
  notes: string | null
  basis: 'verified_fact' | 'professional_judgment'
  status: ReviewStatus
}

// ---------- Readiness gate (honest, non-cosmetic) ----------

export interface ReadinessMetric {
  id: string
  label: string
  labelAr: string
  weight: number
  pass: boolean
  blocker: boolean
  detail: string
}

export interface ReadinessReport {
  score: number // 0-100, weighted — shown with breakdown, never cosmetic
  lockable: boolean // hard blockers all cleared
  metrics: ReadinessMetric[]
  blockers: string[]
  warnings: string[]
}

export interface TraceRow {
  code: string
  title: string
  titleAr: string | null
  status: string
  processes: string[]
  entities: string[]
  apis: string[]
  screens: string[]
  tasks: string[]
}

export interface ImpactPreview {
  requirementCode: string
  requirementTitle: string
  change: string
  affected: Array<{ kind: string; code: string; name: string; why: string }>
  openIssues: number
}
