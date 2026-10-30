import { db } from '@/lib/db'
import { chatJson } from '@/lib/ai'
import { logDecision } from '@/lib/payload'
import type {
  DecisionCategory,
  DecisionEntry,
  DecisionStatus,
  DriftCheckItem,
  DriftCheckRunItem,
  DriftCheckSummary,
  DriftCounts,
  DriftResult,
  DriftStatus,
} from '@/lib/types'
import { DECISION_CATEGORIES } from '@/lib/types'

// ============================================================
// Decision Log + Drift Detector — the anti-drift pair.
//
//   1. Decision CRUD : the project's standing approved choices
//      ("SQLite via Prisma, no other ORM", "Arabic-first RTL").
//      Active entries are injected into the Context Pack and
//      become the check targets here.
//
//   2. runDriftCheck() : the user pastes a build their AI tool
//      produced; every ACTIVE decision gets an honest verdict:
//      respected / partial / drift / unknown, with the exact
//      point of contradiction and a realign instruction.
//
// Honesty rules (same spirit as the Verifier):
//   - "respected" REQUIRES concrete evidence cited from the code.
//   - A contradiction in one visible place is still a verdict —
//     it is never averaged away.
//   - Decisions about files that were not pasted => "unknown".
// The alignment score and drift count are computed by the
// application from the verdicts — never trusted to the model.
// ============================================================

export class DriftError extends Error {
  code: 'NOT_FOUND' | 'NOTHING_TO_CHECK' | 'CODE_TOO_SHORT' | 'INVALID'
  constructor(code: DriftError['code'], message: string) {
    super(message)
    this.code = code
  }
}

// ============================================================
// 1. Decision log — persistence + helpers
// ============================================================

const VALID_DECISION_STATUSES: DecisionStatus[] = ['active', 'superseded']

function serializeEntry(row: {
  id: string
  code: string
  title: string
  titleAr: string | null
  choice: string
  rationale: string | null
  alternatives: string | null
  category: string
  status: string
  origin: string
  createdAt: Date
  updatedAt: Date
}): DecisionEntry {
  return {
    id: row.id,
    code: row.code,
    title: row.title,
    titleAr: row.titleAr,
    choice: row.choice,
    rationale: row.rationale,
    alternatives: row.alternatives,
    category: (DECISION_CATEGORIES as readonly string[]).includes(row.category)
      ? (row.category as DecisionCategory)
      : 'architecture',
    status: row.status === 'superseded' ? 'superseded' : 'active',
    origin: row.origin === 'ai' ? 'ai' : 'user',
    createdAt: row.createdAt.toISOString(),
    updatedAt: row.updatedAt.toISOString(),
  }
}

function nextCode(rows: Array<{ code: string }>): string {
  let max = 0
  for (const row of rows) {
    const m = row.code.match(/DEC-(\d+)/i)
    if (m) max = Math.max(max, parseInt(m[1], 10))
  }
  return `DEC-${String(max + 1).padStart(2, '0')}`
}

export async function listDecisions(ideaId: string): Promise<DecisionEntry[]> {
  const rows = await db.decisionEntry.findMany({
    where: { ideaId },
    orderBy: [{ status: 'asc' }, { createdAt: 'asc' }],
  })
  return rows.map(serializeEntry)
}

export async function createDecision(args: {
  ideaId: string
  title: string
  titleAr?: string
  choice: string
  rationale?: string
  alternatives?: string
  category?: string
}): Promise<DecisionEntry> {
  const title = args.title.trim()
  const choice = args.choice.trim()
  if (title.length < 2 || choice.length < 3) {
    throw new DriftError('INVALID', 'A decision needs a title and a choice.')
  }
  const category = (DECISION_CATEGORIES as readonly string[]).includes(args.category ?? '')
    ? (args.category as DecisionCategory)
    : 'architecture'

  const existing = await db.decisionEntry.findMany({ where: { ideaId: args.ideaId }, select: { code: true } })
  const code = nextCode(existing)
  const count = await db.decisionEntry.count({ where: { ideaId: args.ideaId } })

  const row = await db.decisionEntry.create({
    data: {
      ideaId: args.ideaId,
      code,
      title,
      titleAr: args.titleAr?.trim() || null,
      choice,
      rationale: args.rationale?.trim() || null,
      alternatives: args.alternatives?.trim() || null,
      category,
      status: 'active',
      origin: 'user',
      order: count,
    },
  })

  await logDecision(args.ideaId, 'Decision logged', `${code} — ${title}: ${choice.slice(0, 120)}`)
  return serializeEntry(row)
}

export async function updateDecision(
  ideaId: string,
  decisionId: string,
  patch: {
    title?: string
    titleAr?: string | null
    choice?: string
    rationale?: string | null
    alternatives?: string | null
    category?: string
    status?: string
  }
): Promise<DecisionEntry | null> {
  const found = await db.decisionEntry.findFirst({ where: { id: decisionId, ideaId } })
  if (!found) throw new DriftError('NOT_FOUND', 'Decision not found')

  const data: Record<string, unknown> = {}
  if (typeof patch.title === 'string' && patch.title.trim().length >= 2) data.title = patch.title.trim()
  if (patch.titleAr !== undefined) data.titleAr = patch.titleAr?.trim() || null
  if (typeof patch.choice === 'string' && patch.choice.trim().length >= 3) data.choice = patch.choice.trim()
  if (patch.rationale !== undefined) data.rationale = patch.rationale?.trim() || null
  if (patch.alternatives !== undefined) data.alternatives = patch.alternatives?.trim() || null
  if (patch.category && (DECISION_CATEGORIES as readonly string[]).includes(patch.category)) data.category = patch.category
  if (patch.status && VALID_DECISION_STATUSES.includes(patch.status as DecisionStatus)) {
    data.status = patch.status
    if (patch.status !== found.status) {
      await logDecision(
        ideaId,
        patch.status === 'active' ? 'Decision reactivated' : 'Decision retired',
        `${found.code} — ${found.title}`
      )
    }
  }
  if (Object.keys(data).length === 0) return serializeEntry(found)

  const row = await db.decisionEntry.update({ where: { id: decisionId }, data })
  return serializeEntry(row)
}

export async function deleteDecision(ideaId: string, decisionId: string): Promise<boolean> {
  const found = await db.decisionEntry.findFirst({ where: { id: decisionId, ideaId } })
  if (!found) throw new DriftError('NOT_FOUND', 'Decision not found')
  await db.decisionEntry.delete({ where: { id: decisionId } })
  await logDecision(ideaId, 'Decision removed from log', `${found.code} — ${found.title}`)
  return true
}

// ============================================================
// 2. Drift skill — prompt + target assembly
// ============================================================

const DRIFT_CHUNK_PROMPT = `You are the Drift Detector skill of an engineering platform. The user pastes code that an AI builder generated from their project brief. Below is the project's list of APPROVED DECISIONS — standing choices the developer made deliberately (stack, data model, naming, scope, UX…). Your job: check the pasted build, DECISION BY DECISION, and return an honest verdict for each.

Verdict rules (STRICT):
- "respected": the provided code visibly FOLLOWS the decision — name the evidence (an import, a config, a pattern, a file, a naming, a route, a guard).
- "partial": the code follows the decision in some places but contradicts or misses it in others — name exactly where it breaks.
- "drift": the code visibly CONTRADICTS the decision (a different stack, a renamed entity, extra scope, a broken convention). Cite the contradicting point in the code.
- "unknown": cannot be judged from the provided code — the decision concerns files/areas that were NOT pasted. Say that in the drift field.

Honesty rules (NON-NEGOTIABLE):
- NEVER give "respected" without naming concrete evidence found in the code (quote the symbol, config, file or pattern).
- A decision contradicted anywhere visible is NEVER "respected" — at best it is "partial", at worst "drift".
- Scope decisions work both ways: missing scope the decision forbids is fine, but ADDED scope the decision excludes is "drift".
- Do not soften verdicts to please the user. Silent overrides of the developer's choices are exactly what this check exists to catch.
- Keep evidence/drift/realign to ONE sentence each — terse, factual, no filler.

Return STRICT JSON only — no markdown fences, no commentary — with exactly one key:
- "checks": an array with ONE object for EVERY decision listed below, no exceptions. Each object: { "code": the decision's CODE token ONLY (e.g. "DEC-01" — copy it verbatim, never the title), "status": "respected"|"partial"|"drift"|"unknown", "evidence": "one sentence citing the concrete evidence, or what you looked for", "drift": "for partial/drift/unknown: the exact point of contradiction or which files are absent; empty string for respected", "realign": "one concrete, minimal instruction to bring the build back in line; empty string for respected" }.

Write evidence/drift/realign in the SAME LANGUAGE as the UI language specified below.`

const DRIFT_SUMMARY_PROMPT = `You are the Drift Detector skill of an engineering platform. The per-decision check of an AI-generated build has just completed. You are given the verdict table (code, verdict, drift point) and the project line. Write the overall drift report.

Rules:
- Be honest and specific: name which approved decisions the build silently overrode, and what that means for the project.
- 2-4 sentences for "summary"; 2-4 short strings each for "violations" (the worst contradictions and their consequences) and "realignments" (concrete, minimal steps to bring the build back in line).
- If the build respects every decision, say so plainly — no invented drama.
- Write everything in the SAME LANGUAGE as the UI language specified below.

Return STRICT JSON only — no markdown fences — with exactly these keys: "summary", "violations", "realignments".`

interface DriftTarget {
  code: string
  title: string
  category: string
  spec: string
}

function buildTargets(entries: DecisionEntry[], lang: 'ar' | 'en'): DriftTarget[] {
  return entries
    .filter((e) => e.status === 'active')
    .map((e) => {
      const title = (lang === 'ar' && e.titleAr) || e.title
      const parts = [`DECISION: ${e.choice}`]
      if (e.rationale) parts.push(`WHY: ${e.rationale}`)
      if (e.alternatives) parts.push(`REJECTED ALTERNATIVES: ${e.alternatives} — do not accept these instead`)
      return {
        code: e.code,
        title,
        category: e.category,
        spec: parts.join('\n'),
      }
    })
}

function targetsToPrompt(targets: DriftTarget[]): string {
  return targets
    .map((t) => `CODE: ${t.code}\nCATEGORY: ${t.category}\nTITLE: ${t.title}\n${t.spec}`)
    .join('\n\n---\n\n')
}

// ---------- Normalization + deterministic scoring ----------

const VALID_STATUSES: readonly DriftStatus[] = ['respected', 'partial', 'drift', 'unknown']

// Model-facing synonyms — models drift on vocabulary; verdicts must not.
const STATUS_SYNONYMS: Record<string, DriftStatus> = {
  respected: 'respected', respected_: 'respected', aligned: 'respected', ok: 'respected',
  yes: 'respected', followed: 'respected', honored: 'respected', consistent: 'respected',
  compliant: 'respected', adhered: 'respected', pass: 'respected', passed: 'respected',
  implemented: 'respected', true: 'respected', held: 'respected', intact: 'respected',
  partial: 'partial', partly: 'partial', partially: 'partial', mixed: 'partial',
  inconsistent: 'partial', half: 'partial',
  mostly: 'partial', some: 'partial',
  drift: 'drift', drifted: 'drift', violated: 'drift', violation: 'drift',
  contradiction: 'drift', contradicted: 'drift', contradicts: 'drift', diverged: 'drift',
  broken: 'drift', not_followed: 'drift', 'not followed': 'drift', overridden: 'drift',
  silently_overridden: 'drift', swapped: 'drift', no: 'drift', false: 'drift',
  fail: 'drift', failed: 'drift', missing: 'drift', absent: 'drift', off: 'drift',
  unknown: 'unknown', na: 'unknown', 'n/a': 'unknown', not_applicable: 'unknown',
  cannot_assess: 'unknown', not_assessable: 'unknown', unverifiable: 'unknown',
  skipped: 'unknown', not_visible: 'unknown', not_in_code: 'unknown', none: 'unknown',
}

type RawCheck = Record<string, unknown>

function normalizeStatus(raw: unknown): DriftStatus {
  const s = String(raw ?? '').toLowerCase().trim().replace(/[\s-]+/g, '_')
  if ((VALID_STATUSES as readonly string[]).includes(s)) return s as DriftStatus
  return STATUS_SYNONYMS[s] ?? 'unknown'
}

function str(v: unknown): string {
  return typeof v === 'string' ? v.trim() : ''
}

// Deep-search the response for the checks collection (same tolerant
// strategy as the Verifier: array under any key, object keyed by
// code, or a stringified JSON array — we accept all honest shapes).
function extractChecks(node: unknown, depth = 0): RawCheck[] | null {
  if (depth > 4 || node == null || typeof node !== 'object') return null

  if (Array.isArray(node)) {
    const objs = node.filter((x): x is RawCheck => !!x && typeof x === 'object' && !Array.isArray(x))
    if (objs.length > 0 && objs.length >= Math.floor(node.length * 0.8)) {
      const withStatus = objs.filter((o) => 'status' in o || 'verdict' in o || 'result' in o)
      if (withStatus.length >= Math.max(1, Math.floor(objs.length * 0.5))) return objs
    }
    return null
  }

  const record = node as RawCheck
  for (const value of Object.values(record)) {
    if (typeof value === 'string' && value.trim().startsWith('[')) {
      try {
        const inner = JSON.parse(value)
        const found = extractChecks(inner, depth + 1)
        if (found) return found
      } catch {
        // not JSON — ignore
      }
    }
  }

  for (const value of Object.values(record)) {
    if (value && typeof value === 'object' && !Array.isArray(value)) {
      const entries = Object.entries(value as RawCheck)
      if (entries.length > 0) {
        const objs = entries
          .filter(([, v]) => !!v && typeof v === 'object' && !Array.isArray(v) && ('status' in (v as object) || 'verdict' in (v as object)))
          .map(([k, v]) => ({ code: k, ...(v as RawCheck) }) as RawCheck)
        if (objs.length === entries.length && objs.length > 0) return objs
      }
    }
  }

  for (const value of Object.values(record)) {
    const found = extractChecks(value, depth + 1)
    if (found) return found
  }
  return null
}

// Code normalization: DEC-01 / dec01 / DEC1 all collide to dec1.
function normCode(raw: string): string {
  const compact = raw.toLowerCase().replace(/[^a-z0-9]/g, '')
  return compact.replace(/0+(\d)/g, '$1')
}

const CODE_KEYS = ['code', 'decision', 'decisionCode', 'item', 'id', 'ref', 'key']
const CODE_TOKEN = /^([A-Za-z]{1,8}[\s-]?\d{1,4})/

function extractCodeToken(value: string): string {
  const m = value.match(CODE_TOKEN)
  return m ? m[1].replace(/\s+/g, '') : value
}

function checkCode(item: RawCheck): string {
  for (const key of CODE_KEYS) {
    const v = item[key]
    if (typeof v === 'string' && v.trim()) return extractCodeToken(v.trim())
  }
  return ''
}

export function normalizeChecks(raw: { checks?: unknown }, targets: DriftTarget[]): DriftCheckItem[] {
  const rawChecks = extractChecks(raw) ?? []

  const byCode = new Map<string, RawCheck>()
  const byTitle = new Map<string, RawCheck>()
  for (const item of rawChecks) {
    const code = checkCode(item)
    if (code) {
      const key = normCode(code)
      if (!byCode.has(key)) byCode.set(key, item)
    }
    const title = str(item.title) || str(item.name)
    if (title && !byTitle.has(title.toLowerCase())) byTitle.set(title.toLowerCase(), item)
  }

  const checks: DriftCheckItem[] = []
  for (const target of targets) {
    const found = byCode.get(normCode(target.code)) ?? byTitle.get(target.title.toLowerCase()) ?? null
    const status = found ? normalizeStatus(found.status ?? found.verdict ?? found.result) : 'unknown'
    checks.push({
      code: target.code,
      title: target.title,
      category: target.category,
      status,
      evidence: found ? str(found.evidence) : '',
      drift: found ? str(found.drift) || str(found.gap) : '',
      realign: found ? str(found.realign) || str(found.fix) || str(found.suggestion) : '',
    })
  }
  // Drift verdicts first, then partial — the dangerous ones lead.
  const order: Record<DriftStatus, number> = { drift: 0, partial: 1, unknown: 2, respected: 3 }
  return checks.sort((a, b) => order[a.status] - order[b.status])
}

// ---------- Deterministic scoring (application-owned) ----------

const VALUE: Record<DriftStatus, number> = { respected: 1, partial: 0.5, drift: 0, unknown: 0 }

export function computeAlignment(checks: DriftCheckItem[]): number {
  if (checks.length === 0) return 0
  let earned = 0
  for (const c of checks) earned += VALUE[c.status]
  return Math.round((earned / checks.length) * 100)
}

export function countStatuses(checks: DriftCheckItem[]): DriftCounts {
  const counts: DriftCounts = { respected: 0, partial: 0, drift: 0, unknown: 0 }
  for (const c of checks) counts[c.status] += 1
  return counts
}

// ---------- Serialization ----------

function parseResult(raw: string): DriftResult {
  try {
    const parsed = JSON.parse(raw) as DriftResult
    return {
      checks: Array.isArray(parsed.checks) ? parsed.checks : [],
      summary: typeof parsed.summary === 'string' ? parsed.summary : '',
      violations: Array.isArray(parsed.violations) ? parsed.violations.filter((s) => typeof s === 'string') : [],
      realignments: Array.isArray(parsed.realignments) ? parsed.realignments.filter((s) => typeof s === 'string') : [],
    }
  } catch {
    return { checks: [], summary: '', violations: [], realignments: [] }
  }
}

export function serializeCheck(run: {
  id: string
  label: string | null
  codeChars: number
  drifts: number
  alignment: number
  result: string
  createdAt: Date
}): DriftCheckRunItem {
  const result = parseResult(run.result)
  return {
    id: run.id,
    label: run.label,
    codeChars: run.codeChars,
    drifts: run.drifts,
    alignment: run.alignment,
    counts: countStatuses(result.checks),
    result,
    createdAt: run.createdAt.toISOString(),
  }
}

// ---------- Main ----------

function chunkArray<T>(items: T[], size: number): T[][] {
  const chunks: T[][] = []
  for (let i = 0; i < items.length; i += size) chunks.push(items.slice(i, i + size))
  return chunks
}

// Max decisions per AI call — same ceiling as the Verifier: long
// matrices overflow the model's output limit and come back
// truncated mid-JSON; 10 terse checks stay comfortably inside it.
const CHUNK_SIZE = 10

export async function runDriftCheck(args: {
  ideaId: string
  code: string
  label?: string
  lang: 'ar' | 'en'
}): Promise<DriftCheckRunItem> {
  const code = args.code.trim()
  if (code.length < 30) throw new DriftError('CODE_TOO_SHORT', 'The pasted code is too short to check.')

  const entries = await listDecisions(args.ideaId)
  const targets = buildTargets(entries, args.lang)
  if (targets.length === 0) {
    throw new DriftError('NOTHING_TO_CHECK', 'No active decisions to check against.')
  }

  const idea = await db.idea.findUnique({ where: { id: args.ideaId }, select: { title: true, stage: true, projectType: true } })
  if (!idea) throw new DriftError('NOT_FOUND', 'Idea not found')

  const projectLine = [`Project: ${idea.title}`, idea.projectType ? `Build target: ${idea.projectType}` : '']
    .filter(Boolean)
    .join('\n')

  const chunks = chunkArray(targets, CHUNK_SIZE)
  const chunkResults = await Promise.all(
    chunks.map((chunk) => {
      const user = [
        `UI language for your verdict texts: ${args.lang === 'ar' ? 'Arabic' : 'English'}.`,
        projectLine,
        '',
        `APPROVED DECISIONS TO CHECK (${chunk.length} in this batch — return one check object for EACH):\n\n${targetsToPrompt(chunk)}`,
        '',
        `AI-GENERATED CODE TO CHECK (pasted by the user; it may be a partial codebase):\n"""\n${code}\n"""`,
        '',
        'Check now. Remember: respected requires cited evidence; decisions about files not pasted => unknown; honest verdicts only; one sentence per field.',
      ].join('\n')
      return chatJson<{ checks?: unknown }>(DRIFT_CHUNK_PROMPT, user, 2)
    })
  )

  // Merge every chunk's raw checks, tolerating shape drift per chunk
  const allRaw: RawCheck[] = []
  for (const chunkResult of chunkResults) {
    const found = extractChecks(chunkResult as unknown)
    if (found) allRaw.push(...found)
  }
  if (allRaw.length === 0) {
    throw new Error('Drift skill returned an unreadable matrix')
  }

  const checks = normalizeChecks({ checks: allRaw }, targets)
  const alignment = computeAlignment(checks)
  const counts = countStatuses(checks)

  // Overall drift report — short, safe call over the verdict table.
  // Falls back to a deterministic summary if the model fails; the
  // matrix is already complete and the score is app-computed.
  let summary = ''
  let violations: string[] = []
  let realignments: string[] = []
  try {
    const verdictTable = checks
      .map((c) => `${c.code} [${c.category}] ${c.status}${c.drift ? ` — ${c.drift.slice(0, 140)}` : ''}`)
      .join('\n')
    const summaryRaw = await chatJson<{ summary?: unknown; violations?: unknown; realignments?: unknown }>(
      DRIFT_SUMMARY_PROMPT,
      [
        `UI language: ${args.lang === 'ar' ? 'Arabic' : 'English'}.`,
        projectLine,
        '',
        `VERDICT TABLE (${checks.length} decisions, alignment ${alignment}%, ${counts.drift} drift):\n${verdictTable}`,
        '',
        'Write the overall drift report now.',
      ].join('\n'),
      1
    )
    summary = str(summaryRaw?.summary)
    violations = Array.isArray(summaryRaw?.violations)
      ? summaryRaw.violations.filter((s): s is string => typeof s === 'string').slice(0, 4)
      : []
    realignments = Array.isArray(summaryRaw?.realignments)
      ? summaryRaw.realignments.filter((s): s is string => typeof s === 'string').slice(0, 4)
      : []
  } catch {
    summary =
      args.lang === 'ar'
        ? `التوافق مع القرارات ${alignment}% — ${counts.respected} قرار مُلتزم به، ${counts.partial} جزئي، ${counts.drift} منتهكًا، ${counts.unknown} غير قابل للتقييم من الكود الملصق. ابدأ بإصلاح الانحرافات ❌ ثم أعد الفحص.`
        : `Decision alignment ${alignment}% — ${counts.respected} respected, ${counts.partial} partial, ${counts.drift} violated, ${counts.unknown} not assessable from the pasted code. Fix the ❌ drifts first, then re-check.`
  }

  const result: DriftResult = { checks, summary, violations, realignments }

  const run = await db.driftCheck.create({
    data: {
      ideaId: args.ideaId,
      label: args.label?.trim() || null,
      code,
      codeChars: code.length,
      result: JSON.stringify(result),
      drifts: counts.drift,
      alignment,
    },
  })

  await logDecision(
    args.ideaId,
    'Drift check executed',
    `Alignment ${alignment}% — ${counts.respected} respected, ${counts.partial} partial, ${counts.drift} drift, ${counts.unknown} unknown (${checks.length} decisions)`,
    idea.stage
  )

  return serializeCheck(run)
}

export async function getCheck(ideaId: string, checkId: string): Promise<DriftCheckRunItem | null> {
  const run = await db.driftCheck.findFirst({ where: { id: checkId, ideaId } })
  return run ? serializeCheck(run) : null
}

export async function listChecks(ideaId: string): Promise<DriftCheckSummary[]> {
  const runs = await db.driftCheck.findMany({ where: { ideaId }, orderBy: { createdAt: 'desc' } })
  return runs.map((r) => {
    const full = serializeCheck(r)
    return {
      id: full.id,
      label: full.label,
      codeChars: full.codeChars,
      drifts: full.drifts,
      alignment: full.alignment,
      counts: full.counts,
      createdAt: full.createdAt,
    }
  })
}

export async function deleteCheck(ideaId: string, checkId: string): Promise<boolean> {
  const res = await db.driftCheck.deleteMany({ where: { id: checkId, ideaId } })
  return res.count > 0
}
