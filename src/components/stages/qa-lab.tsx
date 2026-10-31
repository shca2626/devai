'use client'

import { useState } from 'react'
import { Button } from '@/components/ui/button'
import { Badge } from '@/components/ui/badge'
import { useApp } from '@/components/app/context'
import { CodeChip, ReviewBadge, WorkingPanel } from '@/components/app/bits'
import type {
  E2eScenarioRecord,
  EdgeCaseDoc,
  EdgeCaseGroup,
  IdeaDetail,
  TestCaseRecord,
  TestCoverageDoc,
} from '@/lib/types'
import type { DictKey } from '@/lib/i18n'
import {
  BrainCircuit,
  Check,
  ChevronDown,
  ChevronUp,
  FlaskConical,
  Loader2,
  MessageSquareWarning,
  Route,
  X,
} from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// QA Lab — the complete Tester toolset inside the readiness
// stage:
//   1. Test Suite    — unit/integration cases derived from the
//      confirmed requirements and their acceptance criteria
//      (happy, negative, boundary, security), each traced to a
//      requirement + criterion, with the honest app-computed
//      acceptance-criteria coverage.
//   2. Edge cases    — the adversarial brainstorm the happy
//      path forgets, grouped by feature, with concrete
//      how-to-test steps.
//   3. E2E scenarios — critical journeys as Given/When/Then
//      with personas, screens and a smoke test first.
// NO LIMITS: every engine runs at ANY stage; regeneration
// keeps confirmed cases and MUST address feedback.
// ============================================================

type QaKind = 'suite' | 'edge' | 'e2e'

const GENERATE_LABELS: Record<QaKind, DictKey> = {
  suite: 'generateSuite',
  edge: 'generateEdge',
  e2e: 'generateE2e',
}

const WORKING_STEPS: Record<QaKind, [DictKey, DictKey]> = {
  suite: ['genSuite1', 'genSuite2'],
  edge: ['genEdge1', 'genEdge2'],
  e2e: ['genE2e1', 'genE2e2'],
}

const LEVEL_STYLES: Record<string, string> = {
  unit: 'bg-sky-50 dark:bg-sky-500/10 text-sky-700 dark:text-sky-300 border-sky-200 dark:border-sky-500/25',
  integration: 'bg-violet-50 dark:bg-violet-500/10 text-violet-700 dark:text-violet-300 border-violet-200 dark:border-violet-500/25',
}

const KIND_STYLES: Record<string, string> = {
  happy: 'bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200 dark:border-emerald-500/25',
  negative: 'bg-amber-50 dark:bg-amber-500/10 text-amber-700 dark:text-amber-300 border-amber-200 dark:border-amber-500/25',
  boundary: 'bg-orange-50 dark:bg-orange-500/10 text-orange-700 dark:text-orange-300 border-orange-200 dark:border-orange-500/25',
  security: 'bg-red-50 dark:bg-red-500/10 text-red-600 dark:text-red-400 border-red-200 dark:border-red-500/25',
}

const PRIORITY_STYLES: Record<string, string> = {
  high: 'bg-red-50 dark:bg-red-500/10 text-red-600 dark:text-red-400 border-red-200 dark:border-red-500/25',
  medium: 'bg-amber-50 dark:bg-amber-500/10 text-amber-700 dark:text-amber-300 border-amber-200 dark:border-amber-500/25',
  low: 'bg-slate-50 dark:bg-slate-500/10 text-slate-600 dark:text-slate-400 border-slate-200 dark:border-slate-500/25',
  smoke: 'bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200 dark:border-emerald-500/25',
}

const EDGE_RISK_STYLES: Record<string, string> = {
  low: 'bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200 dark:border-emerald-500/25',
  medium: 'bg-amber-50 dark:bg-amber-500/10 text-amber-700 dark:text-amber-300 border-amber-200 dark:border-amber-500/25',
  high: 'bg-red-50 dark:bg-red-500/10 text-red-600 dark:text-red-400 border-red-200 dark:border-red-500/25',
}

function SmallBadge({ children, className }: { children: React.ReactNode; className?: string }) {
  return (
    <Badge variant="outline" className={`text-[10px] font-medium whitespace-nowrap ${className ?? ''}`}>
      {children}
    </Badge>
  )
}

const prettyCategory = (c: string) => c.replace(/_/g, ' ')

export function QaLab({ detail }: { detail: IdeaDetail }) {
  const { t, setDetail, refreshIdeas } = useApp()
  const { toast } = useToast()
  const { idea, testCases, testCoverage, edgeCases, e2eScenarios } = detail
  // NO LIMITS: the lab runs at every stage
  const active = true
  const [busyKind, setBusyKind] = useState<QaKind | null>(null)
  const [expanded, setExpanded] = useState<string | null>(null)
  const [feedback, setFeedback] = useState<Record<QaKind, string>>({ suite: '', edge: '', e2e: '' })

  async function generate(kind: QaKind, kindFeedback?: string) {
    setBusyKind(kind)
    const res = await fetch(`/api/ideas/${idea.id}/qa/generate`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ kind, feedback: kindFeedback }),
    })
    const data = await res.json()
    setBusyKind(null)
    if (!res.ok) {
      toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
      return
    }
    setFeedback((f) => ({ ...f, [kind]: '' }))
    setDetail(data as IdeaDetail)
    refreshIdeas()
  }

  async function review(kind: string, id: string, status: string) {
    const res = await fetch(`/api/artifacts/${kind}/${id}`, {
      method: 'PATCH',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ status }),
    })
    const data = await res.json()
    if (!res.ok) {
      toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
      return
    }
    setDetail(data as IdeaDetail)
    refreshIdeas()
  }

  async function confirmAll(kind: 'testCase' | 'e2eScenario', items: Array<{ id: string; status: string }>) {
    setBusyKind(kind === 'testCase' ? 'suite' : 'e2e')
    for (const item of items) {
      if (item.status === 'proposed') {
        const res = await fetch(`/api/artifacts/${kind}/${item.id}`, {
          method: 'PATCH',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({ status: 'confirmed' }),
        })
        if (res.ok) setDetail((await res.json()) as IdeaDetail)
      }
    }
    setBusyKind(null)
    refreshIdeas()
  }

  const tcUnreviewed = testCases.filter((c) => c.status === 'proposed').length
  const tcRejected = testCases.filter((c) => c.status === 'rejected').length
  const e2eUnreviewed = e2eScenarios.filter((s) => s.status === 'proposed').length
  const e2eRejected = e2eScenarios.filter((s) => s.status === 'rejected').length

  return (
    <div className="space-y-4">
      <p className="text-xs text-muted-foreground leading-6">{t('qaIntro')}</p>

      {/* ---------- 1. Test suite ---------- */}
      <section className="rounded-xl border bg-card p-3 sm:p-4 space-y-3">
        <SectionHeader
          icon={<FlaskConical className="h-4.5 w-4.5 text-primary" />}
          title={t('generateSuite')}
          count={testCases.length}
          rejected={tcRejected > 0 && tcUnreviewed === 0 && testCases.length > 0 && testCases.every((c) => c.status === 'rejected')}
        />
        <GenerateRow
          hasContent={testCases.length > 0}
          busy={busyKind === 'suite'}
          active={active}
          t={t}
          label={testCases.length > 0 ? t('regenerate') : t('generateSuite')}
          onGenerate={() => generate('suite', feedback.suite)}
          onConfirmAll={tcUnreviewed > 0 ? () => confirmAll('testCase', testCases) : null}
          unreviewed={tcUnreviewed}
          rejectedCount={tcRejected}
        />
        <FeedbackBox
          active={active && testCases.length > 0}
          busy={busyKind === 'suite'}
          value={feedback.suite}
          onChange={(v) => setFeedback((f) => ({ ...f, suite: v }))}
          t={t}
          onRun={() => generate('suite', feedback.suite)}
        />
        {busyKind === 'suite' && <WorkingPanel steps={[t(WORKING_STEPS.suite[0]), t(WORKING_STEPS.suite[1])]} />}
        {testCoverage && (
          <CoveragePanel coverage={testCoverage} t={t} active={active} onReview={(id, status) => review('testCoverage', id, status)} />
        )}
        {testCases.map((tc) => (
          <TestCaseCard
            key={tc.id}
            tc={tc}
            expanded={expanded}
            setExpanded={setExpanded}
            t={t}
            active={active}
            onReview={(id, status) => review('testCase', id, status)}
          />
        ))}
      </section>

      {/* ---------- 2. Edge cases ---------- */}
      <section className="rounded-xl border bg-card p-3 sm:p-4 space-y-3">
        <SectionHeader
          icon={<BrainCircuit className="h-4.5 w-4.5 text-primary" />}
          title={t('generateEdge')}
          count={edgeCases ? edgeCases.groups.reduce((n, g) => n + g.cases.length, 0) : 0}
          rejected={edgeCases?.status === 'rejected'}
          badge={edgeCases ? <ReviewBadge status={edgeCases.status} /> : undefined}
        />
        <GenerateRow
          hasContent={!!edgeCases}
          busy={busyKind === 'edge'}
          active={active}
          t={t}
          label={edgeCases ? t('regenerate') : t('generateEdge')}
          onGenerate={() => generate('edge', feedback.edge)}
          onConfirmAll={null}
          unreviewed={0}
          rejectedCount={0}
        />
        <FeedbackBox
          active={active && !!edgeCases}
          busy={busyKind === 'edge'}
          value={feedback.edge}
          onChange={(v) => setFeedback((f) => ({ ...f, edge: v }))}
          t={t}
          onRun={() => generate('edge', feedback.edge)}
        />
        {busyKind === 'edge' && <WorkingPanel steps={[t(WORKING_STEPS.edge[0]), t(WORKING_STEPS.edge[1])]} />}
        {edgeCases && <EdgeCaseView doc={edgeCases} t={t} active={active} onReview={(id, status) => review('edgeCase', id, status)} />}
      </section>

      {/* ---------- 3. E2E scenarios ---------- */}
      <section className="rounded-xl border bg-card p-3 sm:p-4 space-y-3">
        <SectionHeader
          icon={<Route className="h-4.5 w-4.5 text-primary" />}
          title={t('generateE2e')}
          count={e2eScenarios.length}
          rejected={e2eRejected > 0 && e2eUnreviewed === 0 && e2eScenarios.length > 0 && e2eScenarios.every((s) => s.status === 'rejected')}
        />
        <GenerateRow
          hasContent={e2eScenarios.length > 0}
          busy={busyKind === 'e2e'}
          active={active}
          t={t}
          label={e2eScenarios.length > 0 ? t('regenerate') : t('generateE2e')}
          onGenerate={() => generate('e2e', feedback.e2e)}
          onConfirmAll={e2eUnreviewed > 0 ? () => confirmAll('e2eScenario', e2eScenarios) : null}
          unreviewed={e2eUnreviewed}
          rejectedCount={e2eRejected}
        />
        <FeedbackBox
          active={active && e2eScenarios.length > 0}
          busy={busyKind === 'e2e'}
          value={feedback.e2e}
          onChange={(v) => setFeedback((f) => ({ ...f, e2e: v }))}
          t={t}
          onRun={() => generate('e2e', feedback.e2e)}
        />
        {busyKind === 'e2e' && <WorkingPanel steps={[t(WORKING_STEPS.e2e[0]), t(WORKING_STEPS.e2e[1])]} />}
        {e2eScenarios.map((s) => (
          <E2eCard
            key={s.id}
            scenario={s}
            t={t}
            active={active}
            onReview={(id, status) => review('e2eScenario', id, status)}
          />
        ))}
      </section>
    </div>
  )
}

// ---------- Section chrome ----------

function SectionHeader({
  icon,
  title,
  count,
  rejected,
  badge,
}: {
  icon: React.ReactNode
  title: string
  count: number
  rejected?: boolean
  badge?: React.ReactNode
}) {
  return (
    <div className={`flex items-center gap-2 flex-wrap ${rejected ? 'opacity-60' : ''}`}>
      {icon}
      <div className="text-sm font-semibold flex-1">{title}</div>
      <span className="text-[11px] text-muted-foreground tabular-nums">{count}</span>
      {badge}
    </div>
  )
}

type TFunc = (key: DictKey) => string

function GenerateRow({
  hasContent,
  busy,
  active,
  t,
  label,
  onGenerate,
  onConfirmAll,
  unreviewed,
  rejectedCount,
}: {
  hasContent: boolean
  busy: boolean
  active: boolean
  t: TFunc
  label: string
  onGenerate: () => void
  onConfirmAll: (() => void) | null
  unreviewed: number
  rejectedCount: number
}) {
  if (busy) return null
  return (
    <div className="flex flex-wrap items-center gap-2">
      {active && (
        <>
          <Button size="sm" onClick={onGenerate} className="gap-1.5">
            {label}
          </Button>
          {onConfirmAll && unreviewed > 0 && (
            <Button size="sm" variant="outline" onClick={onConfirmAll}>
              {t('confirmAllKind')} ({unreviewed})
            </Button>
          )}
        </>
      )}
      <span className="text-xs text-muted-foreground">
        {rejectedCount > 0 ? `${rejectedCount} ${t('rejectedShort')}` : ''}
      </span>
      {!hasContent && <span className="text-xs text-muted-foreground">{t('qaEmptyHint')}</span>}
    </div>
  )
}

function FeedbackBox({
  active,
  busy,
  value,
  onChange,
  t,
  onRun,
}: {
  active: boolean
  busy: boolean
  value: string
  onChange: (v: string) => void
  t: TFunc
  onRun: () => void
}) {
  if (!active) return null
  return (
    <details className="rounded-xl border border-amber-300/70 dark:border-amber-500/30 bg-amber-50/60">
      <summary className="flex cursor-pointer items-center gap-2 px-3.5 py-2.5 text-xs font-semibold text-amber-900 dark:text-amber-300 min-h-11">
        <MessageSquareWarning className="h-4 w-4 text-amber-600 dark:text-amber-400" />
        {t('feedbackLabel')}
      </summary>
      <div className="px-3.5 pb-3.5 space-y-2.5">
        <p className="text-[11px] text-amber-800 dark:text-amber-300 leading-5">{t('feedbackForTab')}</p>
        <textarea
          rows={2}
          value={value}
          onChange={(ev) => onChange(ev.target.value)}
          placeholder={t('feedbackPlaceholder')}
          className="w-full rounded-lg border border-amber-300 dark:border-amber-500/30 bg-white dark:bg-transparent p-2.5 text-sm leading-6 outline-none focus:ring-2 focus:ring-amber-400/40"
        />
        <div className="flex flex-wrap items-center gap-2">
          <Button size="sm" className="gap-1.5" onClick={onRun} disabled={busy}>
            {busy ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <MessageSquareWarning className="h-3.5 w-3.5" />}
            {t('regenerateWithFeedback')}
          </Button>
          <span className="text-[11px] text-amber-800 dark:text-amber-300">{t('regenKeepsConfirmed')}</span>
        </div>
      </div>
    </details>
  )
}

function ReviewRow({
  id,
  status,
  active,
  t,
  onReview,
  extra,
}: {
  id: string
  status: string
  active: boolean
  t: TFunc
  onReview: (id: string, status: string) => void
  extra?: React.ReactNode
}) {
  if (!active || status === 'rejected') return null
  return (
    <div className="mt-2 flex flex-wrap gap-1.5 border-t pt-2">
      {status !== 'confirmed' && (
        <Button size="sm" variant="outline" className="gap-1 border-emerald-300 dark:border-emerald-500/30 text-emerald-700 dark:text-emerald-300 hover:bg-emerald-50 dark:hover:bg-emerald-500/10" onClick={() => onReview(id, 'confirmed')}>
          <Check className="h-3.5 w-3.5" />
          {t('confirmArtifact')}
        </Button>
      )}
      {status !== 'rejected' && (
        <Button size="sm" variant="outline" className="gap-1 border-red-200 dark:border-red-500/25 text-red-600 dark:text-red-400 hover:bg-red-50 dark:hover:bg-red-500/10" onClick={() => onReview(id, 'rejected')}>
          <X className="h-3.5 w-3.5" />
          {t('rejectArtifact')}
        </Button>
      )}
      {extra}
    </div>
  )
}

// ---------- 1. Coverage panel (app-computed) ----------

function CoveragePanel({
  coverage,
  t,
  active,
  onReview,
}: {
  coverage: TestCoverageDoc
  t: TFunc
  active: boolean
  onReview: (id: string, status: string) => void
}) {
  const criteriaTotal = coverage.covered.reduce((n, r) => n + r.criteriaTotal, 0)
  const criteriaCovered = coverage.covered.reduce((n, r) => n + r.criteriaCovered, 0)
  const scoreColor = coverage.score >= 90 ? 'text-emerald-600 dark:text-emerald-400' : coverage.score >= 60 ? 'text-amber-600 dark:text-amber-400' : 'text-red-500'
  const barColor = coverage.score >= 90 ? 'bg-emerald-500' : coverage.score >= 60 ? 'bg-amber-500' : 'bg-red-400'
  return (
    <div className={`rounded-xl border bg-background p-3 sm:p-4 space-y-3 ${coverage.status === 'rejected' ? 'opacity-60' : ''}`}>
      <div className="flex items-center gap-3 flex-wrap">
        <div className="flex-1 min-w-[180px]">
          <div className="flex items-baseline gap-2">
            <span className={`text-2xl font-bold tabular-nums ${scoreColor}`}>{coverage.score}</span>
            <span className="text-xs text-muted-foreground">
              / 100 · {t('tcCoverage')} {criteriaTotal > 0 ? `(${criteriaCovered}/${criteriaTotal})` : ''}
            </span>
          </div>
          <div className="mt-1.5 h-1.5 rounded-full overflow-hidden bg-muted">
            <div className={`h-full rounded-full transition-all ${barColor}`} style={{ width: `${coverage.score}%` }} />
          </div>
        </div>
        <ReviewBadge status={coverage.status} />
      </div>

      {coverage.covered.length > 0 && (
        <div className="flex flex-wrap gap-1.5">
          {coverage.covered.map((row) => {
            const full = row.criteriaTotal === 0 ? row.criteriaCovered > 0 : row.criteriaCovered === row.criteriaTotal
            const partial = row.criteriaTotal > 0 && row.criteriaCovered > 0 && row.criteriaCovered < row.criteriaTotal
            return (
              <span
                key={row.requirement}
                title={row.caseCodes.length ? `${row.caseCodes.join(', ')}` : row.requirement}
                className={`inline-flex items-center gap-1 rounded-md border px-1.5 py-0.5 text-[10px] font-medium ${
                  full
                    ? 'bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200 dark:border-emerald-500/25'
                    : partial
                      ? 'bg-amber-50 dark:bg-amber-500/10 text-amber-700 dark:text-amber-300 border-amber-200 dark:border-amber-500/25'
                      : 'bg-red-50 dark:bg-red-500/10 text-red-600 dark:text-red-400 border-red-200 dark:border-red-500/25'
                }`}
              >
                {row.requirement}
                {row.criteriaTotal > 0 ? ` ${row.criteriaCovered}/${row.criteriaTotal}` : row.criteriaCovered > 0 ? ' ✓' : ' —'}
              </span>
            )
          })}
        </div>
      )}

      {coverage.uncovered.length > 0 && (
        <div className="rounded-lg border border-amber-200/70 dark:border-amber-500/25 bg-amber-50/50 dark:bg-amber-500/10 p-2.5">
          <div className="text-[10px] font-semibold text-amber-800 dark:text-amber-300 mb-1">{t('tcUncovered')}</div>
          <ul className="text-[11px] leading-5 text-amber-900/85 dark:text-amber-300 space-y-0.5">
            {coverage.uncovered.map((g) => (
              <li key={g.requirement}>
                <span className="font-medium font-mono">{g.requirement}</span> — {g.reason}
              </li>
            ))}
          </ul>
        </div>
      )}

      <ReviewRow id={coverage.id} status={coverage.status} active={active} t={t} onReview={onReview} />
    </div>
  )
}

// ---------- 1. Test case card ----------

function TestCaseCard({
  tc,
  expanded,
  setExpanded,
  t,
  active,
  onReview,
}: {
  tc: TestCaseRecord
  expanded: string | null
  setExpanded: (v: string | null) => void
  t: TFunc
  active: boolean
  onReview: (id: string, status: string) => void
}) {
  const open = expanded === tc.id
  return (
    <div className={`rounded-xl border bg-background p-3 sm:p-4 ${tc.status === 'rejected' ? 'opacity-60' : ''}`} dir="ltr">
      <div className="flex items-start gap-2 flex-wrap">
        <CodeChip code={tc.code} className="mt-0.5" />
        <div className="flex-1 min-w-[200px]">
          <div className="text-sm font-medium leading-6">{tc.title}</div>
          <div className="flex flex-wrap gap-1 mt-1.5">
            <CodeChip code={tc.linkedRequirement} />
            {tc.linkedCriterion != null && (
              <SmallBadge className="bg-muted/40">
                {t('tcCriterion')} #{tc.linkedCriterion}
              </SmallBadge>
            )}
          </div>
        </div>
        <div className="flex flex-wrap gap-1 justify-end">
          <SmallBadge className={LEVEL_STYLES[tc.level] ?? LEVEL_STYLES.integration}>{tc.level}</SmallBadge>
          <SmallBadge className={KIND_STYLES[tc.kind] ?? KIND_STYLES.happy}>{tc.kind}</SmallBadge>
          <SmallBadge className={PRIORITY_STYLES[tc.priority] ?? PRIORITY_STYLES.medium}>{tc.priority}</SmallBadge>
        </div>
      </div>

      <p className="text-xs leading-6 mt-2">
        <span className="font-semibold">{t('tcExpected')}: </span>
        {tc.expected}
      </p>

      <button
        type="button"
        onClick={() => setExpanded(open ? null : tc.id)}
        className="mt-1 text-[11px] text-primary hover:underline inline-flex items-center gap-1 min-h-9"
      >
        {open ? <ChevronUp className="h-3 w-3" /> : <ChevronDown className="h-3 w-3" />}
        {open ? t('viewLess') : t('viewMore')}
      </button>

      {open && (
        <div className="mt-2 border-t pt-3 space-y-3">
          {tc.preconditions.length > 0 && (
            <div>
              <div className="text-[10px] font-semibold text-muted-foreground uppercase tracking-wide mb-1">{t('tcPreconditions')}</div>
              <ul className="text-xs leading-6 text-muted-foreground space-y-0.5">
                {tc.preconditions.map((p, i) => (
                  <li key={i}>• {p}</li>
                ))}
              </ul>
            </div>
          )}
          <div>
            <div className="text-[10px] font-semibold text-muted-foreground uppercase tracking-wide mb-1">{t('tcSteps')}</div>
            <ol className="text-xs leading-6 text-muted-foreground space-y-0.5 list-decimal list-inside">
              {tc.steps.map((s, i) => (
                <li key={i}>{s}</li>
              ))}
            </ol>
          </div>
        </div>
      )}

      <ReviewRow id={tc.id} status={tc.status} active={active} t={t} onReview={onReview} />
    </div>
  )
}

// ---------- 2. Edge case view ----------

function EdgeCaseView({
  doc,
  t,
  active,
  onReview,
}: {
  doc: EdgeCaseDoc
  t: TFunc
  active: boolean
  onReview: (id: string, status: string) => void
}) {
  return (
    <div className={`space-y-3 ${doc.status === 'rejected' ? 'opacity-60' : ''}`}>
      {doc.note && (
        <p className="text-xs leading-6 text-muted-foreground bg-muted/30 rounded-lg p-3">{doc.note}</p>
      )}
      {doc.groups.map((g: EdgeCaseGroup) => (
        <div key={g.feature} className="rounded-xl border bg-background p-3 sm:p-4">
          <div className="text-sm font-semibold border-b pb-2">{g.feature}</div>
          <div className="mt-2 space-y-2.5">
            {g.cases.map((c, i) => (
              <div key={i} className="rounded-lg border bg-card p-2.5">
                <div className="flex items-start gap-2 flex-wrap">
                  <SmallBadge className={EDGE_RISK_STYLES[c.risk] ?? EDGE_RISK_STYLES.medium}>{c.risk}</SmallBadge>
                  <SmallBadge className="bg-muted/40">{prettyCategory(c.category)}</SmallBadge>
                  {c.linkedRequirement && <CodeChip code={c.linkedRequirement} />}
                  <div className="flex-1 min-w-[180px]">
                    <p className="text-[13px] font-medium leading-6">{c.scenario}</p>
                    <p className="text-[11px] leading-5 text-muted-foreground mt-0.5">
                      <span className="font-semibold">{t('edgeHowToTest')}: </span>
                      {c.howToTest}
                    </p>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
      ))}
      <ReviewRow id={doc.id} status={doc.status} active={active} t={t} onReview={onReview} />
    </div>
  )
}

// ---------- 3. E2E scenario card ----------

function E2eCard({
  scenario,
  t,
  active,
  onReview,
}: {
  scenario: E2eScenarioRecord
  t: TFunc
  active: boolean
  onReview: (id: string, status: string) => void
}) {
  return (
    <div className={`rounded-xl border bg-background p-3 sm:p-4 ${scenario.status === 'rejected' ? 'opacity-60' : ''}`} dir="ltr">
      <div className="flex items-start gap-2 flex-wrap">
        <CodeChip code={scenario.code} className="mt-0.5" />
        <div className="flex-1 min-w-[200px]">
          <div className="text-sm font-medium leading-6">{scenario.title}</div>
          <div className="text-[11px] text-muted-foreground mt-0.5">
            <span className="font-semibold">{t('e2ePersona')}: </span>
            {scenario.persona}
          </div>
        </div>
        <SmallBadge className={PRIORITY_STYLES[scenario.priority] ?? PRIORITY_STYLES.high}>
          {scenario.priority === 'smoke' ? '🔥 ' : ''}
          {scenario.priority}
        </SmallBadge>
      </div>

      <div className="grid sm:grid-cols-3 gap-2 mt-2.5">
        {scenario.given.length > 0 && (
          <div className="rounded-lg border border-sky-200/70 dark:border-sky-500/25 bg-sky-50/40 dark:bg-sky-500/10 p-2.5">
            <div className="text-[10px] font-semibold text-sky-700 dark:text-sky-300 mb-1">Given</div>
            <ul className="text-[11px] leading-5 text-sky-900/80 dark:text-sky-300 space-y-0.5">
              {scenario.given.map((g, i) => (
                <li key={i}>• {g}</li>
              ))}
            </ul>
          </div>
        )}
        {scenario.when.length > 0 && (
          <div className="rounded-lg border border-violet-200/70 dark:border-violet-500/25 bg-violet-50/40 dark:bg-violet-500/10 p-2.5">
            <div className="text-[10px] font-semibold text-violet-700 dark:text-violet-300 mb-1">When</div>
            <ul className="text-[11px] leading-5 text-violet-900/80 dark:text-violet-300 space-y-0.5">
              {scenario.when.map((w, i) => (
                <li key={i}>• {w}</li>
              ))}
            </ul>
          </div>
        )}
        {scenario.then.length > 0 && (
          <div className="rounded-lg border border-emerald-200/70 dark:border-emerald-500/25 bg-emerald-50/40 dark:bg-emerald-500/10 p-2.5">
            <div className="text-[10px] font-semibold text-emerald-700 dark:text-emerald-300 mb-1">Then</div>
            <ul className="text-[11px] leading-5 text-emerald-900/80 dark:text-emerald-300 space-y-0.5">
              {scenario.then.map((th, i) => (
                <li key={i}>• {th}</li>
              ))}
            </ul>
          </div>
        )}
      </div>

      {(scenario.screens.length > 0 || scenario.linkedRequirements.length > 0) && (
        <div className="flex flex-wrap gap-1 mt-2.5">
          {scenario.screens.map((s) => (
            <SmallBadge key={s} className="bg-muted/40">
              {s}
            </SmallBadge>
          ))}
          {scenario.linkedRequirements.map((c) => (
            <CodeChip key={c} code={c} />
          ))}
        </div>
      )}

      <ReviewRow id={scenario.id} status={scenario.status} active={active} t={t} onReview={onReview} />
    </div>
  )
}
