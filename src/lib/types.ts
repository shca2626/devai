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

// Build targets — Bolt-style tabs shown when describing a new idea.
// They steer prompt enhancement and the understanding engine.
export const PROJECT_TYPES = ['website', 'app', 'prototype'] as const
export type ProjectType = (typeof PROJECT_TYPES)[number]

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
  projectType: ProjectType | null
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
  // Architect Lab
  tradeStudy: TradeStudy | null
  adrs: ArchDecisionRecord[]
  threatModel: ThreatModelDoc | null
  scaleReport: ScaleReport | null
  // QA Lab
  testCases: TestCaseRecord[]
  testCoverage: TestCoverageDoc | null
  edgeCases: EdgeCaseDoc | null
  e2eScenarios: E2eScenarioRecord[]
  readiness: ReadinessReport | null
}

export interface IdeaListItem {
  id: string
  title: string
  stage: Stage
  projectType: ProjectType | null
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

export interface ApiResponseField {
  field: string
  type: string
  description: string
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
  response: ApiResponseField[]
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

// ---------- Architect Lab (the complete Architect toolset) ----------

export interface TradeCandidate {
  name: string
  style: string
  summary: string
  pros: string[]
  cons: string[]
  cost: string
  complexity: string
  teamFit: string
  risks: string[]
  fit: string
}

export interface TradeStudy {
  id: string
  candidates: TradeCandidate[]
  recommended: string
  rationale: string | null
  linkedRequirements: string[]
  status: ReviewStatus
}

export interface AdrAlternative {
  option: string
  whyNot: string
}

export interface AdrConsequences {
  positive: string[]
  negative: string[]
  risks: string[]
}

export type AdrStatus = 'proposed' | 'confirmed' | 'superseded' | 'rejected'

export interface ArchDecisionRecord {
  id: string
  code: string
  title: string
  titleAr: string | null
  context: string
  decision: string
  alternatives: AdrAlternative[]
  consequences: AdrConsequences
  linkedRequirements: string[]
  status: AdrStatus
  order: number
}

export type StrideCategory = 'spoofing' | 'tampering' | 'repudiation' | 'information_disclosure' | 'denial_of_service' | 'elevation_of_privilege'

export const STRIDE_CATEGORIES: StrideCategory[] = [
  'spoofing',
  'tampering',
  'repudiation',
  'information_disclosure',
  'denial_of_service',
  'elevation_of_privilege',
]

export interface ThreatFinding {
  category: StrideCategory
  threat: string
  component: string
  attackPath: string
  likelihood: 'low' | 'medium' | 'high'
  impact: 'low' | 'medium' | 'high' | 'critical'
  risk: 'low' | 'medium' | 'high' | 'critical'
  mitigation: string
  linkedRequirements: string[]
}

export interface ThreatModelDoc {
  id: string
  findings: ThreatFinding[]
  summary: string | null
  residual: string | null
  status: ReviewStatus
}

export interface ScaleAssumption {
  assumption: string
  basis: string
}

export interface ScaleBottleneck {
  component: string
  limit: string
  why: string
  symptom: string
  firstFix: string
}

export interface ScaleScenario {
  label: string
  load: string
  expected: string
  breaks: string
  actions: string[]
}

export interface ScaleReport {
  id: string
  assumptions: ScaleAssumption[]
  bottlenecks: ScaleBottleneck[]
  scenarios: ScaleScenario[]
  plan: string | null
  status: ReviewStatus
}

// ---------- QA Lab (the complete Tester toolset) ----------

export type TestLevel = 'unit' | 'integration'
export type TestKind = 'happy' | 'negative' | 'boundary' | 'security'
export type TestPriority = 'high' | 'medium' | 'low'
export type TcStatus = 'proposed' | 'confirmed' | 'rejected'

export interface TestCaseRecord {
  id: string
  code: string
  title: string
  level: TestLevel
  kind: TestKind
  linkedRequirement: string
  linkedCriterion: number | null
  preconditions: string[]
  steps: string[]
  expected: string
  priority: TestPriority
  status: TcStatus
  order: number
}

export interface CoverageRow {
  requirement: string
  criteriaTotal: number
  criteriaCovered: number
  caseCodes: string[]
}

export interface CoverageGap {
  requirement: string
  reason: string
}

export interface TestCoverageDoc {
  id: string
  covered: CoverageRow[]
  uncovered: CoverageGap[]
  score: number // deterministic 0-100 — computed by the app from stored cases, never the model
  note: string | null
  status: ReviewStatus
}

export type EdgeRisk = 'low' | 'medium' | 'high'

export interface EdgeCase {
  scenario: string
  category: string
  risk: EdgeRisk
  howToTest: string
  linkedRequirement: string | null
}

export interface EdgeCaseGroup {
  feature: string
  cases: EdgeCase[]
}

export interface EdgeCaseDoc {
  id: string
  groups: EdgeCaseGroup[]
  note: string | null
  status: ReviewStatus
}

export type E2ePriority = 'smoke' | 'high' | 'medium'

export interface E2eScenarioRecord {
  id: string
  code: string
  title: string
  persona: string
  given: string[]
  when: string[]
  then: string[]
  screens: string[]
  priority: E2ePriority
  linkedRequirements: string[]
  status: TcStatus
  order: number
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

// Result of the AI prompt-engineering pass (Enhance button)
export interface EnhancedPrompt {
  enhanced: string
  improvements: string[]
  lang: 'ar' | 'en'
}

// Result of the AI translation pass (Translate button)
export interface TranslationResult {
  text: string
  detectedLanguage: string
  alreadyInTarget: boolean
}

// ============================================================
// AI Constitution + Context Pack (vibe-coding handoff armor)
// ============================================================

export const CONSTITUTION_CATEGORIES = [
  'stack',
  'coding',
  'security',
  'design',
  'quality',
  'workflow',
] as const
export type ConstitutionCategory = (typeof CONSTITUTION_CATEGORIES)[number]

export interface ConstitutionRule {
  id: string
  scope: 'global' | 'project'
  category: ConstitutionCategory
  text: string
  origin: 'ai' | 'user'
  enabled: boolean
  order: number
}

// Context Pack target tools — each gets its own framing so the
// brief reads natively in the AI builder it is pasted into.
export const CONTEXT_TARGETS = ['bolt', 'cursor', 'claude', 'chatgpt', 'generic'] as const
export type ContextTarget = (typeof CONTEXT_TARGETS)[number]

export interface ContextPackOptions {
  target: ContextTarget
  lang: 'ar' | 'en'
  includeConstitution: boolean
  includeRequirements: boolean
  includeProcesses: boolean
  includeArchitecture: boolean
  includeDataModel: boolean
  includeScreens: boolean
  includeTasks: boolean
  includeQa: boolean
  includeRisks: boolean
  includeDecisions: boolean
}

export interface ContextPackResult {
  markdown: string
  stats: {
    characters: number
    words: number
    lines: number
    sections: number
    rulesApplied: number
  }
  generatedAt: string
}

// ============================================================
// Prompt Playbook — reusable prompt templates
// ============================================================

export const PLAYBOOK_CATEGORIES = [
  'new_feature',
  'bug_fix',
  'refactor',
  'tests',
  'review',
  'planning',
  'general',
] as const
export type PlaybookCategory = (typeof PLAYBOOK_CATEGORIES)[number]

export interface PromptTemplate {
  id: string
  title: string
  titleAr: string | null
  description: string
  descriptionAr: string | null
  category: PlaybookCategory
  body: string
  tags: string[]
  isBuiltin: boolean
  useCount: number
  isFavorite: boolean
  updatedAt: string
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

// ============================================================
// Traceability Verifier — paste AI code, verify it against the
// Project Contract. Verdicts are per-check; the score is
// computed by the application, never by the model.
// ============================================================

export type VerifyStatus = 'pass' | 'partial' | 'fail' | 'unknown'
export type VerifyCheckKind = 'requirement' | 'feature' | 'rule'

export interface VerificationCheck {
  kind: VerifyCheckKind
  code: string // FR-001 | AF-1 | RULE-<ruleId suffix>
  title: string
  priority: 'must' | 'should' | 'could' | 'rule'
  status: VerifyStatus
  evidence: string // what in the code proves it (or its absence)
  gap: string // exactly what is missing (partial/fail)
  fix: string // one concrete instruction to close the gap
}

export interface VerificationResult {
  source: 'requirements' | 'features' // what the code was verified against
  checks: VerificationCheck[]
  summary: string
  strengths: string[]
  risks: string[]
}

export interface VerificationCounts {
  pass: number
  partial: number
  fail: number
  unknown: number
}

export interface VerificationRunItem {
  id: string
  label: string | null
  codeChars: number
  score: number
  counts: VerificationCounts
  result: VerificationResult
  createdAt: string
}

export interface VerificationRunSummary {
  id: string
  label: string | null
  codeChars: number
  score: number
  counts: VerificationCounts
  createdAt: string
}

// ============================================================
// Decision Log — standing approved decisions per project.
// Active entries are injected into the Context Pack and become
// the targets of the Drift Detector.
// ============================================================

export const DECISION_CATEGORIES = [
  'architecture',
  'stack',
  'data',
  'api',
  'ux',
  'scope',
  'naming',
  'process',
] as const
export type DecisionCategory = (typeof DECISION_CATEGORIES)[number]

export type DecisionStatus = 'active' | 'superseded'

export interface DecisionEntry {
  id: string
  code: string // DEC-01
  title: string
  titleAr: string | null
  choice: string // the standing choice
  rationale: string | null
  alternatives: string | null
  category: DecisionCategory
  status: DecisionStatus
  origin: 'user' | 'ai'
  createdAt: string
  updatedAt: string
}

// ============================================================
// Drift Detector — paste AI code, check it against the active
// decision log. Verdicts are per-decision; the alignment score
// and drift count are computed by the application, never by the
// model.
// ============================================================

export type DriftStatus = 'respected' | 'partial' | 'drift' | 'unknown'

export interface DriftCheckItem {
  code: string // DEC-01
  title: string
  category: string
  status: DriftStatus
  evidence: string // what in the code proves the decision was honored
  drift: string // where the build contradicts the decision (partial/drift)
  realign: string // one concrete instruction to bring the build back in line
}

export interface DriftResult {
  checks: DriftCheckItem[]
  summary: string
  violations: string[] // the worst contradictions and their consequences
  realignments: string[] // concrete steps to realign the build
}

export interface DriftCounts {
  respected: number
  partial: number
  drift: number
  unknown: number
}

export interface DriftCheckRunItem {
  id: string
  label: string | null
  codeChars: number
  drifts: number
  alignment: number
  counts: DriftCounts
  result: DriftResult
  createdAt: string
}

export interface DriftCheckSummary {
  id: string
  label: string | null
  codeChars: number
  drifts: number
  alignment: number
  counts: DriftCounts
  createdAt: string
}

// ============================================================
// Site Intelligence — deep static analysis of a live web
// platform from a URL. Seven gated stages; the target's code is
// NEVER executed (fetch + static analysis only). Every claim
// carries evidence; what could not be determined lands in
// unknowns instead of being guessed. The completeness score is
// computed by the application, never by the model.
// ============================================================

export type SiteIntelStage = 'recon' | 'surface' | 'bundles' | 'apis' | 'models' | 'audit' | 'synthesis'

export const SITE_INTEL_STAGES: readonly SiteIntelStage[] = [
  'recon',
  'surface',
  'bundles',
  'apis',
  'models',
  'audit',
  'synthesis',
]

export interface SiteEvidence {
  claim: string // what we assert
  source: string // URL / header / file it came from
  method: string // how it was determined
  confidence: 'high' | 'medium' | 'low'
}

export interface SiteRecon {
  finalUrl: string
  httpStatus: number
  redirected: boolean
  https: boolean
  server: string | null
  poweredBy: string | null
  title: string | null
  description: string | null
  generator: string | null
  headers: Record<string, string>
  robots: { found: boolean; sitemaps: string[]; disallows: string[] }
  techSignals: string[] // raw fingerprints observed in headers + HTML
  blocked: boolean // anti-bot wall / 403 / challenge detected
  blockedReason: string | null
  fetchMs: number
}

export interface SitePageForm {
  action: string
  method: string
}

export interface SitePageInfo {
  url: string
  status: number
  title: string | null
  description: string | null
  h1: string[]
  forms: SitePageForm[]
  linkCount: number
  imgCount: number
  imgNoAlt: number
  hasJsonLd: boolean
  jsonLdTypes: string[]
  canonical: string | null
  ogTitle: string | null
}

export interface SiteSurface {
  pages: SitePageInfo[]
  routePatterns: string[] // normalized /users/:id style patterns
  sitemapUrls: number
  skippedByRobots: number
  failedPages: string[]
}

export interface SiteAssetInfo {
  url: string
  sizeKb: number
}

export interface SiteBundles {
  js: SiteAssetInfo[]
  css: SiteAssetInfo[]
  frameworks: { name: string; evidence: string }[]
  libraries: string[]
  routesInBundles: string[]
  designTokens: {
    colors: { hex: string; count: number }[]
    fonts: string[]
    spacingVars: string[]
    radiusVars: string[]
    breakpoints: string[]
  }
  sourceMaps: string[]
  renderingModel: string // static | spa | ssr | ssg-hybrid — deterministic verdict
  renderingEvidence: string
  totalJsKb: number
  totalCssKb: number
}

export interface SiteEndpointFound {
  method: string
  path: string
  kind: 'rest' | 'graphql' | 'ws' | 'sse'
  evidence: string
  purpose: string
}

export interface SiteApiSurface {
  endpoints: SiteEndpointFound[]
  graphqlOps: string[]
  websockets: string[]
  authPattern: string
}

export interface SiteEntityFound {
  name: string
  fields: string[]
  relations: string[]
}

export interface SiteModels {
  markdown: string
  entities: SiteEntityFound[]
}

export interface SiteAuditFinding {
  finding: string
  severity: 'critical' | 'major' | 'minor' | 'good'
  evidence: string
}

export interface SiteAudit {
  security: SiteAuditFinding[]
  seo: SiteAuditFinding[]
  a11y: SiteAuditFinding[]
  performance: SiteAuditFinding[]
  notes: string
}

export interface SiteSynthesis {
  overview: string // markdown
  architecture: string // markdown
  componentMap: string // markdown
  techStack: string // markdown
  summary: string
}

export interface SitePackFile {
  name: string
  content: string
}

// Raw, pre-AI material statically mined from bundles + inline
// scripts during the bundles stage. Kept so the APIs stage can
// structure it without re-fetching assets.
export interface SiteMinedData {
  apiCalls: { method: string; url: string; kind: 'rest' | 'graphql' | 'ws' | 'sse'; snippet: string; file: string }[]
  secrets: { pattern: string; snippet: string; file: string }[]
  inlineScriptChars: number
}

export interface SiteIntelData {
  recon?: SiteRecon
  surface?: SiteSurface
  bundles?: SiteBundles
  mined?: SiteMinedData
  apis?: SiteApiSurface
  models?: SiteModels
  audit?: SiteAudit
  synthesis?: SiteSynthesis
  evidence: SiteEvidence[]
  unknowns: string[]
  pack: SitePackFile[]
  // Internal handoff fields (surface stage → bundles stage); persisted
  // with the row so the stage-by-stage pipeline can pass them along.
  assetJsUrls?: string[]
  assetCssUrls?: string[]
  inlineScriptsText?: string
}

export interface SiteAnalysisItem {
  id: string
  url: string
  domain: string
  status: 'running' | 'complete' | 'failed'
  stageDone: number // 0..7
  score: number // deterministic completeness 0-100
  error: string | null
  data: SiteIntelData
  createdAt: string
}

export interface SiteAnalysisSummary {
  id: string
  url: string
  domain: string
  status: 'running' | 'complete' | 'failed'
  stageDone: number
  score: number
  pagesCrawled: number
  createdAt: string
}

// ============================================================
// App Intelligence (Android / Play Store)
// ============================================================

export interface AppStoreIntel {
  appId: string
  title: string
  developer?: string
  genre?: string
  contentRating?: string
  version?: string
  androidVersion?: string
  installs?: string
  score?: number
  ratings?: number
  reviews?: number
  price?: string
  released?: string
  updated?: number
  description: string
  screenshots: string[]
  video?: string
}

export interface AppAcquireIntel {
  file: string
  sha256: string
  sizeBytes: number
  bundle: string[]
  versionName?: string
  versionCode?: number
  apiSha256?: string
  originality: 'match' | 'mismatch' | 'unknown'
}

export interface AppDeepIntel {
  versions: { versionName?: string; versionCode?: number; sha256?: string; isLatest: boolean; sizeBytes?: number }[]
  permissions: string[]
  signature: {
    present: boolean
    scheme?: string
    status?: string
    certSha256?: string
    certSubject?: string
    signerSubjects?: string[]
    trusted?: boolean
  }
  virusTotal: { verdict?: string; scannedByVirusTotal?: boolean; flagged?: number; vendors?: number }
  fromGooglePlay?: boolean
  manifest?: {
    targetSdk?: number
    compileSdk?: number
    allowBackup?: boolean
    usesFeatures?: string[]
    exportedUnguarded?: string[]
  }
  natives: { abis: string[]; nativeLibs: string[]; protectors: string[] }
  pairipProtected?: boolean
}

export interface AppUnpackIntel {
  baseApkPresent: boolean
  splits: number
  abis: string[]
  languages: string[]
  totalFiles: number
}

export interface AppDecompileIntel {
  javaFiles: number
  topPackages: { name: string; files: number }[]
  endpoints: string[]
  keyPatterns: string[]
}

export interface AppFingerprintIntel {
  stack: { name: string; confidence: 'high' | 'medium'; because: string }[]
  nativeLibs: string[]
  dartPackages: { name: string; refs: number }[]
  featureMap: { feature: string; package: string; refs: number }[]
  assetsSample: string[]
}

export interface AppSynthesis {
  overview: string
  features: string
  architecture: string
  clonePlan: string
}

export interface AppPackFile {
  name: string
  content: string
}

export interface AppIntelData {
  store?: AppStoreIntel
  acquire?: AppAcquireIntel
  deep?: AppDeepIntel
  unpack?: AppUnpackIntel
  decompile?: AppDecompileIntel
  fingerprint?: AppFingerprintIntel
  synthesis?: AppSynthesis
  evidence: { claim: string; source: string; method: string; confidence: 'high' | 'medium' | 'low' }[]
  unknowns: string[]
  pack: AppPackFile[]
}

export interface AppAnalysisItem {
  id: string
  inputUrl: string
  pkg: string
  appName?: string
  status: 'running' | 'complete' | 'failed'
  stageDone: number // 0..7
  score: number // deterministic completeness 0-100
  error: string | null
  data: AppIntelData
  createdAt: string
}

export interface AppAnalysisSummary {
  id: string
  pkg: string
  appName?: string
  status: 'running' | 'complete' | 'failed'
  stageDone: number
  score: number
  createdAt: string
}
