// Generates src/lib/admin/schema-meta.ts from prisma/schema.prisma
// so the admin panel has static, reliable model metadata (no runtime fs).
import fs from 'node:fs'
import path from 'node:path'

const schemaPath = path.join(process.cwd(), 'prisma/schema.prisma')
const outPath = path.join(process.cwd(), 'src/lib/admin/schema-meta.ts')
const raw = fs.readFileSync(schemaPath, 'utf8')

// Strip comments
const src = raw
  .split('\n')
  .map((l) => l.replace(/\/\/.*$/, ''))
  .join('\n')

const models = []
const modelRe = /model\s+(\w+)\s*\{([\s\S]*?)\n\}/g
let m
while ((m = modelRe.exec(src)) !== null) {
  const name = m[1]
  const body = m[2]
  const fields = []
  const relations = []
  for (const line of body.split('\n')) {
    const t = line.trim()
    if (!t || t.startsWith('@@')) continue
    const fm = t.match(/^(\w+)\s+([\w\[\]]+)(.*)$/)
    if (!fm) continue
    const [, fname, ftype, rest] = fm
    if (/^\s*$/.test(rest) || rest.trim() === '') {
      // could be scalar or relation without attributes
    }
    const attrs = rest
    const isId = /\bid\b/.test(attrs) && fname === 'id'
    const isUnique = /@unique/.test(attrs) || /@@unique/.test(attrs)
    const hasDefault = /@default/.test(attrs)
    const isRelation = /@relation/.test(attrs)
    const isJsonComment = /JSON/.test(attrs)
    if (isRelation) {
      relations.push({ name: fname, type: ftype })
      continue
    }
    // Heuristic: relation fields have a model-case type with no scalar attrs
    const scalarTypes = ['String', 'Int', 'BigInt', 'Float', 'Decimal', 'Boolean', 'DateTime', 'Json', 'Bytes']
    const baseType = ftype.replace(/\[\]$/, '').replace(/\?$/, '')
    if (!scalarTypes.includes(baseType)) {
      relations.push({ name: fname, type: ftype })
      continue
    }
    fields.push({
      name: fname,
      type: ftype,
      id: isId,
      unique: isUnique,
      hasDefault,
      json: isJsonComment || baseType === 'Json',
      optional: ftype.endsWith('?'),
      list: ftype.endsWith('[]'),
    })
  }
  models.push({ name, fields, relations })
}

// Human descriptions for the admin UI
const DESCRIPTIONS = {
  Idea: 'The root entity — one product idea with its stage (understanding → package), interpretation, summary, featuresMeta, baseline snapshot and roles.',
  Question: 'Discovery interview questions (9 areas). Each row: bilingual question, options JSON, answer, status pending/answered/skipped.',
  Feature: 'Feature inventory rows (module/feature/user/priority) with review status proposed → accepted/rejected/deferred.',
  Assumption: 'The assumption register — every tentative assumption, its kind (suggested/uncertain) and open/confirmed/rejected status.',
  Decision: 'The audit trail — every action that ever happened on an idea (gates, reviews, express delegation…).',
  Requirement: 'The Project Contract — FR/NFR rows with acceptance criteria JSON, provenance and proposed/confirmed/rejected/unresolved status.',
  ProcessFlow: 'Business process flows: steps JSON, actors, business rules, linked requirements.',
  DataEntity: 'Data model entities: fields JSON, relationships, constraints.',
  ApiEndpoint: 'API contracts: method, path, request/response/errors JSON, linked requirements/entities.',
  ScreenSpec: 'UI screen specs: elements, states, roles, RTL notes, linked requirements.',
  ImplTask: 'Implementation plan tasks: phase, dependencies, acceptance criteria, requirement traceability.',
  RiskItem: 'The risk register: category, likelihood, impact, mitigation, status.',
  ConsistencyIssue: 'Issues found by the consistency engine/AI: contradiction, omission, broken link… with severity and open/resolved/dismissed status.',
  ArchitectureDoc: 'One per idea: components, integrations, tech stack JSON and notes.',
  ArchTradeStudy: 'Architect Lab — trade-off study: 2-3 candidate architectures (pros/cons/cost/complexity/teamFit/risks) + the reasoned recommendation.',
  ArchDecisionRecord: 'Architect Lab — Architecture Decision Records (ADR-01…): context → decision → consequences, with rejected alternatives and requirement traceability.',
  ThreatModelDoc: 'Architect Lab — STRIDE threat model: findings per category (Spoofing/Tampering/Repudiation/Info disclosure/DoS/Elevation) with attack path, risk and mitigation.',
  ScaleReport: 'Architect Lab — scale report: load assumptions, bottlenecks ordered by what breaks first, and 10x/100x what-if scenarios with actions.',
  ConstitutionRule: 'AI Constitution — global (ideaId null) or per-project non-negotiable rules injected into every Context Pack.',
  PromptTemplate: 'Prompt Playbook templates with {{variables}}; builtin or user-authored, useCount, favorite.',
  VerificationRun: 'Traceability Verifier runs: pasted code snapshot, per-check verdicts JSON, deterministic score 0-100.',
  DecisionEntry: 'Standing APPROVED decisions (DEC-01…) checked by the Drift Detector and injected into Context Packs.',
  DriftCheck: 'Drift Detector runs: pasted build snapshot, per-decision verdicts JSON, alignment score.',
  SiteAnalysis: 'Site Intelligence analyses: 7 gated stages, evidence, unknowns, clone pack, completeness score.',
}

const out = `// AUTO-GENERATED from prisma/schema.prisma by scripts/gen-schema-meta.mjs — do not edit by hand.
// Static model metadata for the admin panel (tables, fields, relations).

export interface SchemaField {
  name: string
  type: string
  id: boolean
  unique: boolean
  hasDefault: boolean
  json: boolean
  optional: boolean
  list: boolean
}

export interface SchemaModel {
  name: string
  fields: SchemaField[]
  relations: Array<{ name: string; type: string }>
  description: string
}

export const SCHEMA_MODELS: SchemaModel[] = ${JSON.stringify(
  models.map((m) => ({ ...m, description: DESCRIPTIONS[m.name] ?? '' })),
  null,
  2
)}

export const MODEL_NAMES = [${models.map((m) => `'${m.name}'`).join(', ')}] as const
export type ModelName = (typeof MODEL_NAMES)[number]

export function getModelMeta(name: string): SchemaModel | undefined {
  return SCHEMA_MODELS.find((m) => m.name === name)
}
`

fs.mkdirSync(path.dirname(outPath), { recursive: true })
fs.writeFileSync(outPath, out)
console.log(`Generated ${outPath} with ${models.length} models: ${models.map((m) => m.name).join(', ')}`)
