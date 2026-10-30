import { db } from '@/lib/db'
import { getModelMeta, type SchemaModel } from '@/lib/admin/schema-meta'

// ============================================================
// Admin model registry — the bridge between the static schema
// metadata (generated from prisma/schema.prisma) and the live
// Prisma delegates. Powers the admin database browser, record
// editing and the reset/export tools. Admin-only surface: never
// exposed through the client app bundle.
// ============================================================

export interface AdminTable {
  name: string
  label: string
  description: string
  hasIdeaId: boolean
  scalarFields: string[]
  dateFields: string[]
  intFields: string[]
  boolFields: string[]
  labelField: string
  meta: SchemaModel
  delegate: AdminDelegate
}

// A minimal structural view of a Prisma delegate — enough for
// list/count/find/delete/update/deleteMany, nothing more.
export interface AdminDelegate {
  findMany: (args?: Record<string, unknown>) => Promise<Record<string, unknown>[]>
  findUnique: (args: { where: Record<string, unknown> }) => Promise<Record<string, unknown> | null>
  count: (args?: Record<string, unknown>) => Promise<number>
  create: (args: { data: Record<string, unknown> }) => Promise<Record<string, unknown>>
  update: (args: { where: Record<string, unknown>; data: Record<string, unknown> }) => Promise<Record<string, unknown>>
  delete: (args: { where: Record<string, unknown> }) => Promise<Record<string, unknown>>
  deleteMany: (args?: Record<string, unknown>) => Promise<{ count: number }>
}

// Delegate accessor map — Prisma property per model name.
const DELEGATE_KEYS: Record<string, string> = {
  Idea: 'idea',
  Question: 'question',
  Feature: 'feature',
  Assumption: 'assumption',
  Decision: 'decision',
  Requirement: 'requirement',
  ProcessFlow: 'processFlow',
  DataEntity: 'dataEntity',
  ApiEndpoint: 'apiEndpoint',
  ScreenSpec: 'screenSpec',
  ImplTask: 'implTask',
  RiskItem: 'riskItem',
  ConsistencyIssue: 'consistencyIssue',
  ArchitectureDoc: 'architectureDoc',
  ConstitutionRule: 'constitutionRule',
  PromptTemplate: 'promptTemplate',
  VerificationRun: 'verificationRun',
  DecisionEntry: 'decisionEntry',
  DriftCheck: 'driftCheck',
  SiteAnalysis: 'siteAnalysis',
}

// Which column to show as the human label of a record.
const LABEL_FIELDS: Record<string, string> = {
  Idea: 'title',
  Question: 'questionEn',
  Feature: 'feature',
  Assumption: 'text',
  Decision: 'action',
  Requirement: 'title',
  ProcessFlow: 'name',
  DataEntity: 'name',
  ApiEndpoint: 'path',
  ScreenSpec: 'name',
  ImplTask: 'title',
  RiskItem: 'description',
  ConsistencyIssue: 'description',
  ArchitectureDoc: 'id',
  ConstitutionRule: 'text',
  PromptTemplate: 'title',
  VerificationRun: 'label',
  DecisionEntry: 'title',
  DriftCheck: 'label',
  SiteAnalysis: 'url',
}

export function getAdminTable(name: string): AdminTable | null {
  const meta = getModelMeta(name)
  const key = DELEGATE_KEYS[name]
  if (!meta || !key) return null
  const delegate = (db as unknown as Record<string, AdminDelegate>)[key]
  if (!delegate) return null

  const scalarFields = meta.fields.map((f) => f.name)
  const dateFields = meta.fields.filter((f) => f.type.startsWith('DateTime')).map((f) => f.name)
  const intFields = meta.fields.filter((f) => f.type.startsWith('Int')).map((f) => f.name)
  const boolFields = meta.fields.filter((f) => f.type.startsWith('Boolean')).map((f) => f.name)

  return {
    name,
    label: name,
    description: meta.description,
    hasIdeaId: scalarFields.includes('ideaId'),
    scalarFields,
    dateFields,
    intFields,
    boolFields,
    labelField: LABEL_FIELDS[name] ?? 'id',
    meta,
    delegate,
  }
}

export function listAdminTables(): AdminTable[] {
  return Object.keys(DELEGATE_KEYS)
    .map((name) => getAdminTable(name))
    .filter((t): t is AdminTable => t !== null)
}

// Turn a raw Prisma row into a JSON-safe record (Dates → ISO strings).
export function serializeRow(row: Record<string, unknown>): Record<string, unknown> {
  const out: Record<string, unknown> = {}
  for (const [k, v] of Object.entries(row)) {
    out[k] = v instanceof Date ? v.toISOString() : v
  }
  return out
}

// Cast an incoming JSON value to the column's Prisma type.
export function castValue(table: AdminTable, field: string, value: unknown): unknown {
  if (value === null || value === undefined) return null
  if (table.dateFields.includes(field)) {
    const d = new Date(String(value))
    return isNaN(d.getTime()) ? new Date() : d
  }
  if (table.intFields.includes(field)) {
    const n = Number(value)
    return isNaN(n) ? 0 : Math.trunc(n)
  }
  if (table.boolFields.includes(field)) {
    return value === true || value === 'true' || value === 1 || value === '1'
  }
  return String(value)
}
