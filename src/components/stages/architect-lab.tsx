'use client'

import { useState } from 'react'
import { Button } from '@/components/ui/button'
import { Badge } from '@/components/ui/badge'
import { useApp } from '@/components/app/context'
import { CodeChip, ReviewBadge, WorkingPanel } from '@/components/app/bits'
import type {
  AdrAlternative,
  AdrConsequences,
  ArchDecisionRecord,
  IdeaDetail,
  ScaleReport,
  ThreatFinding,
  ThreatModelDoc,
  TradeCandidate,
  TradeStudy,
} from '@/lib/types'
import type { DictKey } from '@/lib/i18n'
import {
  ArrowUpRight,
  BookMarked,
  Check,
  ChevronDown,
  ChevronUp,
  Gauge,
  GitCompareArrows,
  Loader2,
  MessageSquareWarning,
  ScrollText,
  ShieldAlert,
  X,
} from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Architect Lab — the complete Architect toolset inside the
// design stage:
//   1. Trade-off study  — 3 candidate architectures, honest
//      pros/cons/cost/complexity/teamFit/risks + a reasoned pick.
//   2. ADRs             — context → decision → consequences;
//      promotable to the standing decision log (Drift Detector
//      then guards it).
//   3. STRIDE threat model — findings with attack paths and
//      concrete mitigations, plus the honest residual risk.
//   4. Scale simulation — bottlenecks ordered by what breaks
//      first + 10x/100x what-if scenarios.
// NO LIMITS: every engine runs at ANY stage; regeneration is
// always allowed and logged; feedback MUST be addressed.
// ============================================================

type ArchKind = 'tradeoffs' | 'adrs' | 'threats' | 'scale'

const GENERATE_LABELS: Record<ArchKind, DictKey> = {
  tradeoffs: 'generateTradeoffs',
  adrs: 'generateAdrs',
  threats: 'generateThreats',
  scale: 'generateScale',
}

const WORKING_STEPS: Record<ArchKind, [DictKey, DictKey]> = {
  tradeoffs: ['genTrade1', 'genTrade2'],
  adrs: ['genAdrs1', 'genAdrs2'],
  threats: ['genThreats1', 'genThreats2'],
  scale: ['genScale1', 'genScale2'],
}

const STRIDE_LABELS: Record<string, string> = {
  spoofing: 'Spoofing',
  tampering: 'Tampering',
  repudiation: 'Repudiation',
  information_disclosure: 'Info disclosure',
  denial_of_service: 'Denial of service',
  elevation_of_privilege: 'Elevation of privilege',
}

const RISK_STYLES: Record<string, string> = {
  low: 'bg-emerald-50 text-emerald-700 border-emerald-200',
  medium: 'bg-amber-50 text-amber-700 border-amber-200',
  high: 'bg-orange-50 text-orange-700 border-orange-200',
  critical: 'bg-red-50 text-red-600 border-red-200',
}

const ADR_STATUS_STYLES: Record<string, string> = {
  proposed: 'bg-slate-50 text-slate-600 border-slate-200',
  confirmed: 'bg-emerald-50 text-emerald-700 border-emerald-200',
  superseded: 'bg-violet-50 text-violet-700 border-violet-200',
  rejected: 'bg-red-50 text-red-600 border-red-200',
}

function RiskBadge({ level, label }: { level: string; label?: string }) {
  return (
    <Badge variant="outline" className={`text-[10px] font-medium whitespace-nowrap ${RISK_STYLES[level] ?? RISK_STYLES.medium}`}>
      {label ?? level}
    </Badge>
  )
}

export function ArchitectLab({ detail }: { detail: IdeaDetail }) {
  const { t, setDetail, refreshIdeas } = useApp()
  const { toast } = useToast()
  const { idea, tradeStudy, adrs, threatModel, scaleReport } = detail
  // NO LIMITS: the lab runs at every stage
  const active = true
  const [busyKind, setBusyKind] = useState<ArchKind | null>(null)
  const [busyPromote, setBusyPromote] = useState<string | null>(null)
  const [expanded, setExpanded] = useState<string | null>(null)
  const [feedback, setFeedback] = useState<Record<ArchKind, string>>({
    tradeoffs: '',
    adrs: '',
    threats: '',
    scale: '',
  })

  async function generate(kind: ArchKind, kindFeedback?: string) {
    setBusyKind(kind)
    const res = await fetch(`/api/ideas/${idea.id}/architect/generate`, {
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

  async function confirmAllAdrs() {
    setBusyKind('adrs')
    for (const adr of adrs) {
      if (adr.status === 'proposed') {
        const res = await fetch(`/api/artifacts/adr/${adr.id}`, {
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

  // Promote a confirmed ADR into the standing decision log — from
  // then on the Drift Detector guards it in every AI build.
  async function promoteAdr(adr: ArchDecisionRecord) {
    setBusyPromote(adr.id)
    const res = await fetch(`/api/ideas/${idea.id}/decisions`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        title: adr.title,
        titleAr: adr.titleAr ?? undefined,
        choice: adr.decision,
        rationale: adr.context,
        alternatives: adr.alternatives.map((a) => `${a.option} — ${a.whyNot}`).join(' | ') || undefined,
        category: 'architecture',
      }),
    })
    const data = await res.json()
    setBusyPromote(null)
    if (!res.ok) {
      toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
      return
    }
    toast({ description: t('adrPromoted') })
    const fresh = await fetch(`/api/ideas/${idea.id}`)
    if (fresh.ok) setDetail((await fresh.json()) as IdeaDetail)
    refreshIdeas()
  }

  const adrUnreviewed = adrs.filter((a) => a.status === 'proposed').length
  const adrRejected = adrs.filter((a) => a.status === 'rejected').length

  return (
    <div className="space-y-4">
      <p className="text-xs text-muted-foreground leading-6">{t('architectIntro')}</p>

      {/* ---------- 1. Trade-off study ---------- */}
      <section className="rounded-xl border bg-card p-3 sm:p-4 space-y-3">
        <SectionHeader
          icon={<GitCompareArrows className="h-4.5 w-4.5 text-primary" />}
          title={t('generateTradeoffs')}
          count={tradeStudy ? tradeStudy.candidates.length : 0}
          rejected={tradeStudy?.status === 'rejected'}
          badge={tradeStudy ? <ReviewBadge status={tradeStudy.status} /> : undefined}
        />
        <GenerateRow
          kind="tradeoffs"
          hasContent={!!tradeStudy}
          busy={busyKind === 'tradeoffs'}
          active={active}
          t={t}
          onGenerate={() => generate('tradeoffs', feedback.tradeoffs)}
          onConfirmAll={null}
          unreviewed={0}
          rejectedCount={0}
        />
        <FeedbackBox
          active={active && !!tradeStudy}
          busy={busyKind === 'tradeoffs'}
          value={feedback.tradeoffs}
          onChange={(v) => setFeedback((f) => ({ ...f, tradeoffs: v }))}
          t={t}
          onRun={() => generate('tradeoffs', feedback.tradeoffs)}
        />
        {busyKind === 'tradeoffs' && <WorkingPanel steps={[t(WORKING_STEPS.tradeoffs[0]), t(WORKING_STEPS.tradeoffs[1])]} />}
        {tradeStudy && <TradeStudyView study={tradeStudy} t={t} active={active} onReview={(id, status) => review('tradeStudy', id, status)} />}
      </section>

      {/* ---------- 2. ADRs ---------- */}
      <section className="rounded-xl border bg-card p-3 sm:p-4 space-y-3">
        <SectionHeader
          icon={<ScrollText className="h-4.5 w-4.5 text-primary" />}
          title={t('generateAdrs')}
          count={adrs.length}
          rejected={adrRejected > 0 && adrUnreviewed === 0 && adrs.length > 0 && adrs.every((a) => a.status === 'rejected')}
          badge={undefined}
        />
        <GenerateRow
          kind="adrs"
          hasContent={adrs.length > 0}
          busy={busyKind === 'adrs'}
          active={active}
          t={t}
          onGenerate={() => generate('adrs', feedback.adrs)}
          onConfirmAll={adrUnreviewed > 0 ? confirmAllAdrs : null}
          unreviewed={adrUnreviewed}
          rejectedCount={adrRejected}
        />
        <FeedbackBox
          active={active && adrs.length > 0}
          busy={busyKind === 'adrs'}
          value={feedback.adrs}
          onChange={(v) => setFeedback((f) => ({ ...f, adrs: v }))}
          t={t}
          onRun={() => generate('adrs', feedback.adrs)}
        />
        {busyKind === 'adrs' && <WorkingPanel steps={[t(WORKING_STEPS.adrs[0]), t(WORKING_STEPS.adrs[1])]} />}
        {adrs.map((adr) => (
          <AdrCard
            key={adr.id}
            adr={adr}
            expanded={expanded}
            setExpanded={setExpanded}
            t={t}
            active={active}
            busyPromote={busyPromote === adr.id}
            onReview={(id, status) => review('adr', id, status)}
            onPromote={() => promoteAdr(adr)}
          />
        ))}
      </section>

      {/* ---------- 3. STRIDE threat model ---------- */}
      <section className="rounded-xl border bg-card p-3 sm:p-4 space-y-3">
        <SectionHeader
          icon={<ShieldAlert className="h-4.5 w-4.5 text-primary" />}
          title={t('generateThreats')}
          count={threatModel ? threatModel.findings.length : 0}
          rejected={threatModel?.status === 'rejected'}
          badge={threatModel ? <ReviewBadge status={threatModel.status} /> : undefined}
        />
        <GenerateRow
          kind="threats"
          hasContent={!!threatModel}
          busy={busyKind === 'threats'}
          active={active}
          t={t}
          onGenerate={() => generate('threats', feedback.threats)}
          onConfirmAll={null}
          unreviewed={0}
          rejectedCount={0}
        />
        <FeedbackBox
          active={active && !!threatModel}
          busy={busyKind === 'threats'}
          value={feedback.threats}
          onChange={(v) => setFeedback((f) => ({ ...f, threats: v }))}
          t={t}
          onRun={() => generate('threats', feedback.threats)}
        />
        {busyKind === 'threats' && <WorkingPanel steps={[t(WORKING_STEPS.threats[0]), t(WORKING_STEPS.threats[1])]} />}
        {threatModel && <ThreatModelView model={threatModel} t={t} active={active} onReview={(id, status) => review('threatModel', id, status)} />}
      </section>

      {/* ---------- 4. Scale simulation ---------- */}
      <section className="rounded-xl border bg-card p-3 sm:p-4 space-y-3">
        <SectionHeader
          icon={<Gauge className="h-4.5 w-4.5 text-primary" />}
          title={t('generateScale')}
          count={scaleReport ? scaleReport.bottlenecks.length : 0}
          rejected={scaleReport?.status === 'rejected'}
          badge={scaleReport ? <ReviewBadge status={scaleReport.status} /> : undefined}
        />
        <GenerateRow
          kind="scale"
          hasContent={!!scaleReport}
          busy={busyKind === 'scale'}
          active={active}
          t={t}
          onGenerate={() => generate('scale', feedback.scale)}
          onConfirmAll={null}
          unreviewed={0}
          rejectedCount={0}
        />
        <FeedbackBox
          active={active && !!scaleReport}
          busy={busyKind === 'scale'}
          value={feedback.scale}
          onChange={(v) => setFeedback((f) => ({ ...f, scale: v }))}
          t={t}
          onRun={() => generate('scale', feedback.scale)}
        />
        {busyKind === 'scale' && <WorkingPanel steps={[t(WORKING_STEPS.scale[0]), t(WORKING_STEPS.scale[1])]} />}
        {scaleReport && <ScaleReportView report={scaleReport} t={t} active={active} onReview={(id, status) => review('scaleReport', id, status)} />}
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
  kind,
  hasContent,
  busy,
  active,
  t,
  onGenerate,
  onConfirmAll,
  unreviewed,
  rejectedCount,
}: {
  kind: ArchKind
  hasContent: boolean
  busy: boolean
  active: boolean
  t: TFunc
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
            {hasContent ? t('regenerate') : t(GENERATE_LABELS[kind])}
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
    <details className="rounded-xl border border-amber-300/70 bg-amber-50/60">
      <summary className="flex cursor-pointer items-center gap-2 px-3.5 py-2.5 text-xs font-semibold text-amber-900 min-h-11">
        <MessageSquareWarning className="h-4 w-4 text-amber-600" />
        {t('feedbackLabel')}
      </summary>
      <div className="px-3.5 pb-3.5 space-y-2.5">
        <p className="text-[11px] text-amber-800 leading-5">{t('feedbackForTab')}</p>
        <textarea
          rows={2}
          value={value}
          onChange={(ev) => onChange(ev.target.value)}
          placeholder={t('feedbackPlaceholder')}
          className="w-full rounded-lg border border-amber-300 bg-white p-2.5 text-sm leading-6 outline-none focus:ring-2 focus:ring-amber-400/40"
        />
        <div className="flex flex-wrap items-center gap-2">
          <Button size="sm" className="gap-1.5" onClick={onRun} disabled={busy}>
            {busy ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <MessageSquareWarning className="h-3.5 w-3.5" />}
            {t('regenerateWithFeedback')}
          </Button>
          <span className="text-[11px] text-amber-800">{t('regenReplacesRejected')}</span>
        </div>
      </div>
    </details>
  )
}

function ReviewRow({
  kind,
  id,
  status,
  active,
  t,
  onReview,
  extra,
}: {
  kind: string
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
      {status !== 'confirmed' && status !== 'superseded' && (
        <Button size="sm" variant="outline" className="gap-1 border-emerald-300 text-emerald-700 hover:bg-emerald-50" onClick={() => onReview(id, 'confirmed')}>
          <Check className="h-3.5 w-3.5" />
          {t('confirmArtifact')}
        </Button>
      )}
      {status !== 'rejected' && (
        <Button size="sm" variant="outline" className="gap-1 border-red-200 text-red-600 hover:bg-red-50" onClick={() => onReview(id, 'rejected')}>
          <X className="h-3.5 w-3.5" />
          {t('rejectArtifact')}
        </Button>
      )}
      {extra}
    </div>
  )
}

// ---------- 1. Trade-off study view ----------

function TradeStudyView({
  study,
  t,
  active,
  onReview,
}: {
  study: TradeStudy
  t: TFunc
  active: boolean
  onReview: (id: string, status: string) => void
}) {
  return (
    <div className={`space-y-3 ${study.status === 'rejected' ? 'opacity-60' : ''}`}>
      {study.rationale && (
        <p className="text-xs leading-6 text-muted-foreground bg-muted/30 rounded-lg p-3">
          <span className="font-semibold text-foreground">{t('archRecommended')}: </span>
          {study.rationale}
        </p>
      )}
      {study.candidates.map((c) => (
        <TradeCandidateCard key={c.name} candidate={c} recommended={c.name === study.recommended} t={t} />
      ))}
      <ReviewRow kind="tradeStudy" id={study.id} status={study.status} active={active} t={t} onReview={onReview} />
    </div>
  )
}

function TradeCandidateCard({ candidate, recommended, t }: { candidate: TradeCandidate; recommended: boolean; t: TFunc }) {
  return (
    <div
      className={`rounded-xl border p-3 sm:p-4 ${
        recommended ? 'border-emerald-300 bg-emerald-50/30' : 'bg-background'
      }`}
      dir="ltr"
    >
      <div className="flex items-start gap-2 flex-wrap">
        <div className="flex-1 min-w-[200px]">
          <div className="text-sm font-semibold">{candidate.name}</div>
          {candidate.style && <div className="text-[11px] text-muted-foreground mt-0.5">{candidate.style}</div>}
        </div>
        {recommended && (
          <Badge variant="outline" className="text-[10px] font-semibold bg-emerald-50 text-emerald-700 border-emerald-300">
            ★ {t('archRecommended')}
          </Badge>
        )}
      </div>
      {candidate.summary && <p className="text-xs leading-6 text-muted-foreground mt-2">{candidate.summary}</p>}
      <div className="grid sm:grid-cols-2 gap-2 mt-2.5">
        {candidate.pros.length > 0 && (
          <div className="rounded-lg border border-emerald-200/70 bg-emerald-50/40 p-2.5">
            <div className="text-[10px] font-semibold text-emerald-700 mb-1">+ {t('archPros')}</div>
            <ul className="text-[11px] leading-5 text-emerald-900/80 space-y-0.5">
              {candidate.pros.map((p) => (
                <li key={p}>• {p}</li>
              ))}
            </ul>
          </div>
        )}
        {candidate.cons.length > 0 && (
          <div className="rounded-lg border border-red-200/70 bg-red-50/40 p-2.5">
            <div className="text-[10px] font-semibold text-red-600 mb-1">− {t('archCons')}</div>
            <ul className="text-[11px] leading-5 text-red-900/80 space-y-0.5">
              {candidate.cons.map((c) => (
                <li key={c}>• {c}</li>
              ))}
            </ul>
          </div>
        )}
      </div>
      <div className="flex flex-wrap gap-1.5 mt-2.5 text-[10px]">
        {candidate.cost && <Badge variant="outline" className="bg-muted/40 whitespace-nowrap">{t('archCost')}: {candidate.cost}</Badge>}
        {candidate.complexity && <Badge variant="outline" className="bg-muted/40 whitespace-nowrap">{t('archComplexity')}: {candidate.complexity}</Badge>}
        {candidate.teamFit && <Badge variant="outline" className="bg-muted/40 max-w-full whitespace-normal h-auto py-1">{t('archTeamFit')}: {candidate.teamFit}</Badge>}
      </div>
      {candidate.risks.length > 0 && (
        <div className="mt-2 text-[11px] leading-5 text-muted-foreground">
          <span className="font-semibold">{t('archRisksLabel')}: </span>
          {candidate.risks.join(' · ')}
        </div>
      )}
      {candidate.fit && (
        <div className="mt-1.5 text-[11px] leading-5 italic text-muted-foreground border-t pt-1.5">
          {t('archFit')}: {candidate.fit}
        </div>
      )}
    </div>
  )
}

// ---------- 2. ADR view ----------

function AdrCard({
  adr,
  expanded,
  setExpanded,
  t,
  active,
  busyPromote,
  onReview,
  onPromote,
}: {
  adr: ArchDecisionRecord
  expanded: string | null
  setExpanded: (v: string | null) => void
  t: TFunc
  active: boolean
  busyPromote: boolean
  onReview: (id: string, status: string) => void
  onPromote: () => void
}) {
  const open = expanded === adr.id
  const conseq = adr.consequences ?? { positive: [], negative: [], risks: [] }
  return (
    <div className={`rounded-xl border bg-background p-3 sm:p-4 ${adr.status === 'rejected' ? 'opacity-60' : ''}`} dir="ltr">
      <div className="flex items-start gap-2 flex-wrap">
        <CodeChip code={adr.code} className="mt-0.5" />
        <div className="flex-1 min-w-[200px]">
          <div className="text-sm font-medium">
            {adr.title}
            {adr.titleAr && <span className="text-muted-foreground font-arabic ms-2" dir="rtl">· {adr.titleAr}</span>}
          </div>
          <p className="text-xs leading-6 text-foreground mt-1">
            <span className="font-semibold">{t('adrDecision')}: </span>
            {adr.decision}
          </p>
        </div>
        <Badge variant="outline" className={`text-[11px] font-medium whitespace-nowrap ${ADR_STATUS_STYLES[adr.status] ?? ADR_STATUS_STYLES.proposed}`}>
          {adr.status}
        </Badge>
      </div>
      <button
        type="button"
        onClick={() => setExpanded(open ? null : adr.id)}
        className="mt-1 text-[11px] text-primary hover:underline inline-flex items-center gap-1 min-h-9"
      >
        {open ? <ChevronUp className="h-3 w-3" /> : <ChevronDown className="h-3 w-3" />}
        {open ? t('viewLess') : t('viewMore')}
      </button>
      {open && (
        <div className="mt-2 border-t pt-3 space-y-3">
          <div>
            <div className="text-[10px] font-semibold text-muted-foreground uppercase tracking-wide mb-1">{t('adrContext')}</div>
            <p className="text-xs leading-6 text-muted-foreground">{adr.context}</p>
          </div>
          {adr.alternatives.length > 0 && (
            <div>
              <div className="text-[10px] font-semibold text-muted-foreground uppercase tracking-wide mb-1">{t('adrAlternatives')}</div>
              <ul className="text-xs leading-6 text-muted-foreground space-y-0.5">
                {adr.alternatives.map((a: AdrAlternative, i) => (
                  <li key={i}>
                    <span className="font-medium text-foreground">{a.option}</span>
                    {a.whyNot ? ` — ${a.whyNot}` : ''}
                  </li>
                ))}
              </ul>
            </div>
          )}
          {(conseq.positive.length > 0 || conseq.negative.length > 0 || conseq.risks.length > 0) && (
            <div>
              <div className="text-[10px] font-semibold text-muted-foreground uppercase tracking-wide mb-1">{t('adrConsequences')}</div>
              <div className="grid sm:grid-cols-3 gap-2">
                {conseq.positive.length > 0 && (
                  <ul className="text-[11px] leading-5 text-emerald-800/90 space-y-0.5 rounded-lg bg-emerald-50/50 border border-emerald-200/60 p-2">
                    {conseq.positive.map((p: string, i: number) => (
                      <li key={i}>+ {p}</li>
                    ))}
                  </ul>
                )}
                {conseq.negative.length > 0 && (
                  <ul className="text-[11px] leading-5 text-red-800/90 space-y-0.5 rounded-lg bg-red-50/50 border border-red-200/60 p-2">
                    {conseq.negative.map((n: string, i: number) => (
                      <li key={i}>− {n}</li>
                    ))}
                  </ul>
                )}
                {conseq.risks.length > 0 && (
                  <ul className="text-[11px] leading-5 text-amber-800/90 space-y-0.5 rounded-lg bg-amber-50/50 border border-amber-200/60 p-2">
                    {conseq.risks.map((r: string, i: number) => (
                      <li key={i}>! {r}</li>
                    ))}
                  </ul>
                )}
              </div>
            </div>
          )}
          {adr.linkedRequirements.length > 0 && (
            <div className="flex flex-wrap gap-1">
              {adr.linkedRequirements.map((c) => (
                <CodeChip key={c} code={c} />
              ))}
            </div>
          )}
        </div>
      )}
      <ReviewRow
        kind="adr"
        id={adr.id}
        status={adr.status}
        active={active}
        t={t}
        onReview={onReview}
        extra={
          adr.status === 'confirmed' ? (
            <Button size="sm" variant="outline" className="gap-1 border-violet-300 text-violet-700 hover:bg-violet-50" onClick={onPromote} disabled={busyPromote}>
              {busyPromote ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <ArrowUpRight className="h-3.5 w-3.5" />}
              {t('adrPromote')}
            </Button>
          ) : undefined
        }
      />
    </div>
  )
}

// ---------- 3. Threat model view ----------

function ThreatModelView({
  model,
  t,
  active,
  onReview,
}: {
  model: ThreatModelDoc
  t: TFunc
  active: boolean
  onReview: (id: string, status: string) => void
}) {
  return (
    <div className={`space-y-3 ${model.status === 'rejected' ? 'opacity-60' : ''}`} dir="ltr">
      {model.summary && (
        <p className="text-xs leading-6 text-muted-foreground bg-muted/30 rounded-lg p-3">
          <span className="font-semibold text-foreground">{t('threatsSummary')}: </span>
          {model.summary}
        </p>
      )}
      {model.findings.map((f: ThreatFinding, i: number) => (
        <div key={i} className="rounded-xl border bg-background p-3">
          <div className="flex items-start gap-2 flex-wrap">
            <Badge variant="outline" className="text-[10px] font-semibold bg-violet-50 text-violet-700 border-violet-200 whitespace-nowrap">
              {STRIDE_LABELS[f.category] ?? f.category}
            </Badge>
            <div className="flex-1 min-w-[200px]">
              <div className="text-sm font-medium">{f.threat}</div>
              <div className="text-[11px] text-muted-foreground mt-0.5">
                {t('threatComponent')}: <span className="font-medium text-foreground">{f.component}</span>
              </div>
            </div>
            <RiskBadge level={f.risk} label={`${t('riskLabel')}: ${f.risk}`} />
          </div>
          <div className="mt-2 grid sm:grid-cols-2 gap-2 text-[11px] leading-5">
            {f.attackPath && (
              <div className="rounded-lg bg-muted/30 p-2">
                <div className="font-semibold text-muted-foreground mb-0.5">{t('threatAttackPath')}</div>
                <div className="text-foreground/90">{f.attackPath}</div>
              </div>
            )}
            {f.mitigation && (
              <div className="rounded-lg bg-emerald-50/50 border border-emerald-200/60 p-2">
                <div className="font-semibold text-emerald-700 mb-0.5">{t('threatMitigation')}</div>
                <div className="text-emerald-900/80">{f.mitigation}</div>
              </div>
            )}
          </div>
          {f.linkedRequirements.length > 0 && (
            <div className="flex flex-wrap gap-1 mt-2">
              {f.linkedRequirements.map((c) => (
                <CodeChip key={c} code={c} />
              ))}
            </div>
          )}
        </div>
      ))}
      {model.residual && (
        <p className="text-xs leading-6 text-amber-800 bg-amber-50/60 border border-amber-200/70 rounded-lg p-3">
          <span className="font-semibold">{t('threatsResidual')}: </span>
          {model.residual}
        </p>
      )}
      <ReviewRow kind="threatModel" id={model.id} status={model.status} active={active} t={t} onReview={onReview} />
    </div>
  )
}

// ---------- 4. Scale report view ----------

function ScaleReportView({
  report,
  t,
  active,
  onReview,
}: {
  report: ScaleReport
  t: TFunc
  active: boolean
  onReview: (id: string, status: string) => void
}) {
  return (
    <div className={`space-y-3 ${report.status === 'rejected' ? 'opacity-60' : ''}`} dir="ltr">
      {report.assumptions.length > 0 && (
        <div>
          <div className="text-[10px] font-semibold text-muted-foreground uppercase tracking-wide mb-1.5">{t('scaleAssumptions')}</div>
          <div className="space-y-1">
            {report.assumptions.map((a, i) => (
              <div key={i} className="text-[11px] leading-5">
                <span className="font-medium text-foreground">{a.assumption}</span>
                <span className="text-muted-foreground"> — {a.basis}</span>
              </div>
            ))}
          </div>
        </div>
      )}
      {report.bottlenecks.length > 0 && (
        <div>
          <div className="text-[10px] font-semibold text-muted-foreground uppercase tracking-wide mb-1.5">{t('scaleBottlenecks')}</div>
          <div className="overflow-x-auto nice-scroll">
            <table className="w-full text-xs">
              <thead>
                <tr className="text-muted-foreground border-b">
                  <th className="py-1.5 text-start font-medium pe-2">#</th>
                  <th className="py-1.5 text-start font-medium pe-2">Component</th>
                  <th className="py-1.5 text-start font-medium pe-2">{t('scaleLimit')}</th>
                  <th className="py-1.5 text-start font-medium pe-2">{t('scaleWhy')}</th>
                  <th className="py-1.5 text-start font-medium pe-2">{t('scaleSymptom')}</th>
                  <th className="py-1.5 text-start font-medium">{t('scaleFirstFix')}</th>
                </tr>
              </thead>
              <tbody>
                {report.bottlenecks.map((b, i) => (
                  <tr key={i} className="border-b last:border-0 align-top">
                    <td className="py-1.5 pe-2 text-muted-foreground tabular-nums">{i + 1}</td>
                    <td className="py-1.5 pe-2 font-medium whitespace-nowrap">{b.component}</td>
                    <td className="py-1.5 pe-2 text-orange-700">{b.limit}</td>
                    <td className="py-1.5 pe-2 text-muted-foreground">{b.why}</td>
                    <td className="py-1.5 pe-2 text-muted-foreground">{b.symptom}</td>
                    <td className="py-1.5 text-emerald-700">{b.firstFix}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      )}
      {report.scenarios.length > 0 && (
        <div>
          <div className="text-[10px] font-semibold text-muted-foreground uppercase tracking-wide mb-1.5">{t('scaleScenarios')}</div>
          <div className="grid sm:grid-cols-2 gap-2.5">
            {report.scenarios.map((s, i) => (
              <div key={i} className="rounded-xl border bg-background p-3 space-y-1.5">
                <div className="flex items-center gap-2">
                  <Gauge className="h-3.5 w-3.5 text-primary" />
                  <div className="text-sm font-semibold">{s.label}</div>
                </div>
                {s.load && <div className="text-[11px] text-muted-foreground">{t('scaleLoad')}: <span className="font-medium text-foreground">{s.load}</span></div>}
                {s.expected && <div className="text-[11px] leading-5 text-emerald-800">✓ {t('scaleExpected')}: {s.expected}</div>}
                {s.breaks && <div className="text-[11px] leading-5 text-orange-800">✗ {t('scaleBreaks')}: {s.breaks}</div>}
                {s.actions.length > 0 && (
                  <ol className="text-[11px] leading-5 text-muted-foreground space-y-0.5 mt-1 border-t pt-1.5">
                    {s.actions.map((a, j) => (
                      <li key={j}>
                        <span className="font-semibold text-foreground tabular-nums">{j + 1}. </span>
                        {a}
                      </li>
                    ))}
                  </ol>
                )}
              </div>
            ))}
          </div>
        </div>
      )}
      {report.plan && (
        <p className="text-xs leading-6 text-muted-foreground bg-muted/30 rounded-lg p-3">
          <span className="font-semibold text-foreground">{t('scalePlan')}: </span>
          {report.plan}
        </p>
      )}
      <ReviewRow kind="scaleReport" id={report.id} status={report.status} active={active} t={t} onReview={onReview} />
    </div>
  )
}
