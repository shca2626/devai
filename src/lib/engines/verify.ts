import { db } from '@/lib/db'
import { chatJson } from '@/lib/ai'
import { buildIdeaDetail, logDecision } from '@/lib/payload'
import { listRules } from '@/lib/engines/context-pack'
import type {
  VerificationCheck,
  VerificationCounts,
  VerificationResult,
  VerificationRunItem,
} from '@/lib/types'

// ============================================================
// Traceability Verifier — the vibe-coding reality check.
//
// The user pastes code that an AI builder (Bolt, Cursor, v0,
// Claude, ChatGPT…) produced from their engineering package.
// This engine verifies the code, item by item, against the
// project's confirmed requirements (or, before the requirements
// stage, the accepted feature baseline) plus every enabled
// constitution rule.
//
// Honesty rules:
//   - A pass REQUIRES concrete evidence cited from the code.
//   - Mocked/hardcoded data is partial, never pass.
//   - Absent relevant files => "unknown", not "fail".
// The coverage score is computed deterministically by the
// application from the verdicts — never trusted to the model.

export class VerifyError extends Error {
  code: 'NOT_FOUND' | 'NOTHING_TO_VERIFY' | 'CODE_TOO_SHORT'
  constructor(code: VerifyError['code'], message: string) {
    super(message)
    this.code = code
  }
}

// ---------- Prompt ----------

const VERIFY_CHUNK_PROMPT = `You are the Traceability Verifier skill of an engineering platform. The user pastes code that an AI builder generated from their approved engineering package. Your job: verify the code, ITEM BY ITEM, against every requirement and constitution rule listed below, and return an honest verdict for each.

Verdict rules (STRICT):
- "pass": the provided code contains CONCRETE evidence that the item's core behavior is implemented (a route, a component, a query, a validation, a state, a test...). You must name that evidence.
- "partial": some of it exists, but acceptance criteria are not all met. Name exactly which parts are missing.
- "fail": no trace of it in the provided code, AND the relevant files are clearly part of what was pasted (e.g. the screens exist but the feature is absent from them).
- "unknown": cannot be judged from the provided code — the item would live in files/areas that were NOT pasted. Say that in the gap field.

Honesty rules (NON-NEGOTIABLE):
- NEVER give "pass" without naming concrete evidence found in the code (quote the symbol, route, component or query).
- A UI shell with no data wiring does NOT satisfy a functional requirement that needs data — call it "partial" and say what is missing.
- Hardcoded/mock data counts as "partial" for anything requiring real persistence or real flows.
- If the code contradicts the item, it is "fail" — describe the contradiction.
- Constitution rules: "pass" = followed in the pasted code, "fail" = violated (cite the violating code), "unknown" = not assessable from this code.
- Do not soften verdicts to please the user. A pretty UI with half the requirements missing gets a low score and a clear statement of it.
- Keep evidence/gap/fix to ONE sentence each — terse, factual, no filler.

Return STRICT JSON only — no markdown fences, no commentary — with exactly one key:
- "checks": an array with ONE object for EVERY item listed below, no exceptions. Each object: { "code": the item's CODE token ONLY (e.g. "FR-001" or "RULE-3" — copy it verbatim, never the title or the full item text), "status": "pass"|"partial"|"fail"|"unknown", "evidence": "one sentence citing the concrete evidence, or what you looked for", "gap": "for partial/fail/unknown: exactly what is missing or which files are absent; empty string for pass", "fix": "one concrete, minimal instruction to close the gap; empty string for pass" }.

Write evidence/gap/fix in the SAME LANGUAGE as the UI language specified below.`

const VERIFY_SUMMARY_PROMPT = `You are the Traceability Verifier skill of an engineering platform. The per-item verification of an AI-generated build has just completed. You are given the verdict table (code, verdict, gap) and the project line. Write the overall verdict.

Rules:
- Be honest and specific: name what the build actually delivers vs what was asked, led by the must-priority gaps.
- 2-4 sentences for "summary"; 2-4 short strings each for "strengths" (what the code genuinely does well) and "risks" (real risks: security, data loss, broken flows — not generic advice).
- If every must item failed or is absent, say so plainly — do not sugarcoat.
- Write everything in the SAME LANGUAGE as the UI language specified below.

Return STRICT JSON only — no markdown fences — with exactly these keys: "summary", "strengths", "risks".`

// Backwards-compatible export (debug tooling)
const VERIFY_PROMPT = VERIFY_CHUNK_PROMPT
export { VERIFY_PROMPT, VERIFY_CHUNK_PROMPT, VERIFY_SUMMARY_PROMPT }

// ---------- Target assembly ----------

interface VerifyTarget {
  kind: VerificationCheck['kind']
  code: string
  title: string
  priority: VerificationCheck['priority']
  spec: string
}

function buildTargets(
  detail: NonNullable<Awaited<ReturnType<typeof buildIdeaDetail>>>,
  rules: Array<{ text: string }>,
  lang: 'ar' | 'en'
): { targets: VerifyTarget[]; source: 'requirements' | 'features' } {
  const targets: VerifyTarget[] = []
  const confirmedReqs = detail.requirements.filter((r) => r.status === 'confirmed')
  const source: 'requirements' | 'features' = confirmedReqs.length > 0 ? 'requirements' : 'features'

  if (source === 'requirements') {
    for (const r of confirmedReqs) {
      const title = (lang === 'ar' && r.titleAr) || r.title
      const criteria = r.acceptanceCriteria.length
        ? `\nAcceptance criteria:\n${r.acceptanceCriteria.map((c) => `- ${c}`).join('\n')}`
        : ''
      targets.push({
        kind: 'requirement',
        code: r.code,
        title,
        priority: r.priority,
        spec: `[${r.type === 'functional' ? 'Functional' : 'Non-functional'}${r.category ? `, ${r.category}` : ''}] ${r.description}${criteria}`,
      })
    }
  } else {
    detail.features
      .filter((f) => f.status === 'accepted')
      .forEach((f, i) => {
        targets.push({
          kind: 'feature',
          code: `AF-${i + 1}`,
          title: f.feature,
          priority: f.priority,
          spec: `Approved feature (module: ${f.module}) for ${f.user}.${f.rationale ? ` Rationale: ${f.rationale}` : ''}`,
        })
      })
  }

  rules.forEach((r, i) => {
    targets.push({
      kind: 'rule',
      code: `RULE-${i + 1}`,
      title: r.text,
      priority: 'rule',
      spec: `Constitution rule (non-negotiable): ${r.text}`,
    })
  })

  return { targets, source }
}

function targetsToPrompt(targets: VerifyTarget[]): string {
  const groups: Record<string, string[]> = { requirement: [], feature: [], rule: [] }
  for (const t of targets) {
    const label =
      t.kind === 'rule' ? 'Constitution rule' : t.kind === 'feature' ? 'Approved feature' : 'Requirement'
    groups[t.kind].push(
      `CODE: ${t.code}\nPRIORITY: ${t.priority.toUpperCase()}\nTYPE: ${label}\nTITLE: ${t.title}\n${t.spec}`
    )
  }
  return [...groups.requirement, ...groups.feature, ...groups.rule].join('\n\n---\n\n')
}

export { buildTargets, targetsToPrompt }
export type { VerifyTarget }

// ---------- Normalization + deterministic scoring ----------

const VALID_STATUSES = ['pass', 'partial', 'fail', 'unknown'] as const

// Model-facing synonyms — models drift on vocabulary; verdicts must not.
const STATUS_SYNONYMS: Record<string, VerificationCheck['status']> = {
  pass: 'pass', passed: 'pass', ok: 'pass', yes: 'pass', implemented: 'pass',
  complete: 'pass', completed: 'pass', done: 'pass', satisfied: 'pass', full: 'pass',
  partial: 'partial', partly: 'partial', partially: 'partial', incomplete: 'partial',
  warning: 'partial', warn: 'partial', half: 'partial', mostly: 'partial',
  fail: 'fail', failed: 'fail', missing: 'fail', absent: 'fail', no: 'fail',
  violated: 'fail', not_implemented: 'fail', 'not implemented': 'fail', none: 'fail',
  unknown: 'unknown', na: 'unknown', 'n/a': 'unknown', not_applicable: 'unknown',
  cannot_assess: 'unknown', not_assessable: 'unknown', unverifiable: 'unknown', skipped: 'unknown',
}

type RawCheck = Record<string, unknown>

function normalizeStatus(raw: unknown): VerificationCheck['status'] {
  const s = String(raw ?? '').toLowerCase().trim().replace(/[\s-]+/g, '_')
  if ((VALID_STATUSES as readonly string[]).includes(s)) return s as VerificationCheck['status']
  return STATUS_SYNONYMS[s] ?? 'unknown'
}

function str(v: unknown): string {
  return typeof v === 'string' ? v.trim() : ''
}

// Deep-search the response for the checks collection. The model is asked for
// { checks: [...] } but may drift: array under another key, object keyed by
// code, or a stringified JSON array. We accept all honest shapes.
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
  // Stringified JSON: "checks": "[{...}]"
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

  // Object-keyed map: { "FR-001": { status: ... }, ... }
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

// Code normalization: case-insensitive, punctuation-free, leading zeros stripped
// so FR-001 / fr001 / FR1 / fr-1 all collide to fr1.
function normCode(raw: string): string {
  const compact = raw.toLowerCase().replace(/[^a-z0-9]/g, '')
  return compact.replace(/0+(\d)/g, '$1')
}

const CODE_KEYS = ['code', 'requirement', 'requirementCode', 'item', 'id', 'ref', 'key']

// Models sometimes paste the whole item heading into the code field
// ("FR-001 (MUST) — Requirement\nTitle: ..."). Pull the leading code token.
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

export function normalizeChecks(raw: { checks?: unknown }, targets: VerifyTarget[]): VerificationCheck[] {
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

  const checks: VerificationCheck[] = []
  for (const target of targets) {
    const found = byCode.get(normCode(target.code)) ?? byTitle.get(target.title.toLowerCase()) ?? null
    const status = found ? normalizeStatus(found.status ?? found.verdict ?? found.result) : 'unknown'
    checks.push({
      kind: target.kind,
      code: target.code,
      title: target.title,
      priority: target.priority,
      status,
      evidence: found ? str(found.evidence) : '',
      gap: found ? str(found.gap) : '',
      fix: found ? str(found.fix) || str(found.suggestion) : '',
    })
  }
  // Requirement checks first (must -> should -> could), then features, then rules
  const order: Record<string, number> = { must: 0, should: 1, could: 2, rule: 3 }
  return checks.sort((a, b) => {
    if (a.kind !== b.kind) return a.kind === 'rule' ? 1 : b.kind === 'rule' ? -1 : a.kind === 'requirement' ? -1 : 1
    return (order[a.priority] ?? 2) - (order[b.priority] ?? 2)
  })
}

// ---------- Deterministic scoring (application-owned) ----------

const WEIGHT = { must: 3, should: 2, could: 1, rule: 1 } as const
const VALUE: Record<VerificationCheck['status'], number> = { pass: 1, partial: 0.5, fail: 0, unknown: 0 }

export function computeScore(checks: VerificationCheck[]): number {
  let earned = 0
  let total = 0
  for (const c of checks) {
    const w = WEIGHT[c.priority] ?? 1
    total += w
    earned += w * VALUE[c.status]
  }
  return total === 0 ? 0 : Math.round((earned / total) * 100)
}

export function countStatuses(checks: VerificationCheck[]): VerificationCounts {
  const counts: VerificationCounts = { pass: 0, partial: 0, fail: 0, unknown: 0 }
  for (const c of checks) counts[c.status] += 1
  return counts
}

// ---------- Serialization ----------

function parseResult(raw: string): VerificationResult {
  try {
    const parsed = JSON.parse(raw) as VerificationResult
    return {
      source: parsed.source === 'features' ? 'features' : 'requirements',
      checks: Array.isArray(parsed.checks) ? parsed.checks : [],
      summary: typeof parsed.summary === 'string' ? parsed.summary : '',
      strengths: Array.isArray(parsed.strengths) ? parsed.strengths.filter((s) => typeof s === 'string') : [],
      risks: Array.isArray(parsed.risks) ? parsed.risks.filter((s) => typeof s === 'string') : [],
    }
  } catch {
    return { source: 'requirements', checks: [], summary: '', strengths: [], risks: [] }
  }
}

export function serializeRun(run: {
  id: string
  label: string | null
  codeChars: number
  score: number
  result: string
  createdAt: Date
}): VerificationRunItem {
  const result = parseResult(run.result)
  return {
    id: run.id,
    label: run.label,
    codeChars: run.codeChars,
    score: run.score,
    counts: countStatuses(result.checks),
    result,
    createdAt: run.createdAt.toISOString(),
  }
}

export function runSummary(run: VerificationRunItem): VerificationRunItem {
  return run
}

// ---------- Main ----------

function chunkArray<T>(items: T[], size: number): T[][] {
  const chunks: T[][] = []
  for (let i = 0; i < items.length; i += size) chunks.push(items.slice(i, i + size))
  return chunks
}

// Max targets per AI call. Long matrices overflow the model's output limit and
// come back truncated mid-JSON; 10 terse checks stay comfortably inside it.
const CHUNK_SIZE = 10

export async function runVerification(args: {
  ideaId: string
  code: string
  label?: string
  lang: 'ar' | 'en'
}): Promise<VerificationRunItem> {
  const code = args.code.trim()
  if (code.length < 30) throw new VerifyError('CODE_TOO_SHORT', 'The pasted code is too short to verify.')

  const detail = await buildIdeaDetail(args.ideaId)
  if (!detail) throw new VerifyError('NOT_FOUND', 'Idea not found')

  const rules = (await listRules(args.ideaId)).filter((r) => r.enabled)
  const { targets, source } = buildTargets(detail, rules, args.lang)
  if (targets.length === 0) {
    throw new VerifyError(
      'NOTHING_TO_VERIFY',
      'Nothing to verify against — confirm requirements or accept features first.'
    )
  }

  const projectLine = [
    `Project: ${detail.idea.title}`,
    detail.idea.interpretation ? `Problem: ${detail.idea.interpretation.problemStatement}` : '',
    detail.idea.projectType ? `Build target: ${detail.idea.projectType}` : '',
  ]
    .filter(Boolean)
    .join('\n')

  const chunks = chunkArray(targets, CHUNK_SIZE)
  const chunkResults = await Promise.all(
    chunks.map((chunk) => {
      const user = [
        `UI language for your verdict texts: ${args.lang === 'ar' ? 'Arabic' : 'English'}.`,
        projectLine,
        '',
        `ITEMS TO VERIFY (${chunk.length} in this batch — return one check object for EACH):\n\n${targetsToPrompt(chunk)}`,
        '',
        `AI-GENERATED CODE TO VERIFY (pasted by the user; it may be a partial codebase):\n"""\n${code}\n"""`,
        '',
        'Verify now. Remember: pass requires cited evidence; missing relevant files => unknown; honest verdicts only; one sentence per field.',
      ].join('\n')
      return chatJson<{ checks?: unknown }>(VERIFY_CHUNK_PROMPT, user, 2)
    })
  )

  // Merge every chunk's raw checks, tolerating shape drift per chunk
  const allRaw: RawCheck[] = []
  for (const chunkResult of chunkResults) {
    const found = extractChecks(chunkResult as unknown)
    if (found) allRaw.push(...found)
  }
  if (allRaw.length === 0) {
    throw new Error('Verification skill returned an unreadable matrix')
  }

  const checks = normalizeChecks({ checks: allRaw }, targets)
  const score = computeScore(checks)
  const counts = countStatuses(checks)

  // Overall verdict — a short, safe call over the verdict table. Falls back to
  // a deterministic summary if the model fails; the matrix itself is already
  // complete and the score is application-computed.
  let summary = ''
  let strengths: string[] = []
  let risks: string[] = []
  try {
    const verdictTable = checks
      .map((c) => `${c.code} [${c.priority}] ${c.status}${c.gap ? ` — ${c.gap.slice(0, 140)}` : ''}`)
      .join('\n')
    const summaryRaw = await chatJson<{ summary?: unknown; strengths?: unknown; risks?: unknown }>(
      VERIFY_SUMMARY_PROMPT,
      [
        `UI language: ${args.lang === 'ar' ? 'Arabic' : 'English'}.`,
        projectLine,
        '',
        `VERDICT TABLE (${checks.length} checks, coverage score ${score}%):\n${verdictTable}`,
        '',
        'Write the overall verdict now.',
      ].join('\n'),
      1
    )
    summary = str(summaryRaw?.summary)
    strengths = Array.isArray(summaryRaw?.strengths)
      ? summaryRaw.strengths.filter((s): s is string => typeof s === 'string').slice(0, 4)
      : []
    risks = Array.isArray(summaryRaw?.risks)
      ? summaryRaw.risks.filter((s): s is string => typeof s === 'string').slice(0, 4)
      : []
  } catch {
    summary =
      args.lang === 'ar'
        ? `درجة التغطية ${score}% — ${counts.pass} بند منفذ بالكامل، ${counts.partial} جزئي، ${counts.fail} مفقود، ${counts.unknown} غير قابل للتقييم من الكود الملصق. ابدأ بسد فجوات المتطلبات الإلزامية (MUST) ثم أعد الفحص.`
        : `Coverage score ${score}% — ${counts.pass} fully implemented, ${counts.partial} partial, ${counts.fail} missing, ${counts.unknown} not assessable from the pasted code. Close the MUST-priority gaps first, then re-verify.`
  }

  const result: VerificationResult = { source, checks, summary, strengths, risks }

  const run = await db.verificationRun.create({
    data: {
      ideaId: args.ideaId,
      label: args.label?.trim() || null,
      code,
      codeChars: code.length,
      result: JSON.stringify(result),
      score,
    },
  })

  await logDecision(
    args.ideaId,
    'Traceability verification executed',
    `Score ${score}% — ${counts.pass} pass, ${counts.partial} partial, ${counts.fail} fail, ${counts.unknown} unknown (${checks.length} checks)`,
    detail.idea.stage
  )

  return serializeRun(run)
}

export async function getRun(ideaId: string, runId: string): Promise<VerificationRunItem | null> {
  const run = await db.verificationRun.findFirst({ where: { id: runId, ideaId } })
  return run ? serializeRun(run) : null
}

export async function listRuns(ideaId: string): Promise<VerificationRunItem[]> {
  const runs = await db.verificationRun.findMany({ where: { ideaId }, orderBy: { createdAt: 'desc' } })
  return runs.map(serializeRun)
}

export async function deleteRun(ideaId: string, runId: string): Promise<boolean> {
  const res = await db.verificationRun.deleteMany({ where: { id: runId, ideaId } })
  return res.count > 0
}
