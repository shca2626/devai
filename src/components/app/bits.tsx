'use client'

import { Badge } from '@/components/ui/badge'
import { useApp } from '@/components/app/context'
import { AREA_LABELS } from '@/lib/i18n'
import type { FeatureStatus, Priority, ReqStatus, ReviewStatus, Stage } from '@/lib/types'
import { cn } from '@/lib/utils'

// ============================================================
// Small shared pieces: bilingual text wrapper, status badges,
// area badges, stage badges, working indicator.
// ============================================================

export function ArabicText({ children, className }: { children: React.ReactNode; className?: string }) {
  return (
    <div dir="rtl" className={cn('font-arabic text-right leading-relaxed', className)}>
      {children}
    </div>
  )
}

export function EnglishText({ children, className }: { children: React.ReactNode; className?: string }) {
  return (
    <div dir="ltr" className={cn('text-left leading-relaxed', className)}>
      {children}
    </div>
  )
}

export function StageBadge({ stage }: { stage: Stage }) {
  const { t } = useApp()
  const keys: Record<Stage, string> = {
    understanding: t('stageUnderstanding'),
    discovery: t('stageDiscovery'),
    features: t('stageFeatures'),
    baseline: t('stageBaseline'),
    requirements: t('stageRequirements'),
    design: t('stageDesign'),
    planning: t('stagePlanning'),
    readiness: t('stageReadiness'),
    package: t('stagePackage'),
  }
  const label = keys[stage] ?? stage
  const tone =
    stage === 'package'
      ? 'bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200 dark:border-emerald-500/25'
      : ['requirements', 'design', 'planning', 'readiness'].includes(stage)
        ? 'bg-teal-50 dark:bg-teal-500/10 text-teal-700 dark:text-teal-300 border-teal-200 dark:border-teal-500/25'
        : 'bg-violet-50 dark:bg-violet-500/10 text-violet-700 dark:text-violet-300 border-violet-200 dark:border-violet-500/25'
  return (
    <Badge variant="outline" className={cn('text-[11px] font-medium', tone)}>
      {label}
    </Badge>
  )
}

export function AreaBadge({ area, active }: { area: string; active?: boolean }) {
  const { lang } = useApp()
  return (
    <Badge
      variant="outline"
      className={cn(
        'text-[11px] font-medium max-w-[160px] truncate',
        active ? 'bg-primary text-primary-foreground border-primary' : 'bg-muted/60 text-muted-foreground'
      )}
    >
      {AREA_LABELS[lang][area] ?? area}
    </Badge>
  )
}

const STATUS_STYLES: Record<FeatureStatus, string> = {
  proposed: 'bg-slate-50 dark:bg-slate-500/10 text-slate-600 dark:text-slate-400 border-slate-200 dark:border-slate-500/25',
  needs_confirmation: 'bg-amber-50 dark:bg-amber-500/10 text-amber-700 dark:text-amber-300 border-amber-200 dark:border-amber-500/25',
  accepted: 'bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200 dark:border-emerald-500/25',
  rejected: 'bg-red-50 dark:bg-red-500/10 text-red-600 dark:text-red-400 border-red-200 dark:border-red-500/25',
  deferred: 'bg-sky-50 dark:bg-sky-500/10 text-sky-700 dark:text-sky-300 border-sky-200 dark:border-sky-500/25',
}

const STATUS_KEYS: Record<FeatureStatus, Parameters<ReturnType<typeof useApp>['t']>[0]> = {
  proposed: 'statusProposed',
  needs_confirmation: 'statusNeedsConfirmation',
  accepted: 'statusAccepted',
  rejected: 'statusRejected',
  deferred: 'statusDeferred',
}

export function StatusBadge({ status }: { status: FeatureStatus }) {
  const { t } = useApp()
  return (
    <Badge variant="outline" className={cn('text-[11px] font-medium whitespace-nowrap', STATUS_STYLES[status])}>
      {t(STATUS_KEYS[status])}
    </Badge>
  )
}

const PRIORITY_STYLES: Record<Priority, string> = {
  must: 'bg-violet-50 dark:bg-violet-500/10 text-violet-700 dark:text-violet-300 border-violet-200 dark:border-violet-500/25',
  should: 'bg-slate-50 dark:bg-slate-500/10 text-slate-600 dark:text-slate-400 border-slate-200 dark:border-slate-500/25',
  could: 'bg-slate-50 dark:bg-slate-500/10 text-slate-400 border-slate-200 dark:border-slate-500/25',
}

const PRIORITY_KEYS: Record<Priority, Parameters<ReturnType<typeof useApp>['t']>[0]> = {
  must: 'prioMust',
  should: 'prioShould',
  could: 'prioCould',
}

export function PriorityBadge({ priority }: { priority: Priority }) {
  const { t } = useApp()
  return (
    <Badge variant="outline" className={cn('text-[11px] font-medium whitespace-nowrap', PRIORITY_STYLES[priority])}>
      {t(PRIORITY_KEYS[priority])}
    </Badge>
  )
}

const ASSUMPTION_STATUS_STYLES = {
  open: 'bg-slate-50 dark:bg-slate-500/10 text-slate-600 dark:text-slate-400 border-slate-200 dark:border-slate-500/25',
  confirmed: 'bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200 dark:border-emerald-500/25',
  rejected: 'bg-red-50 dark:bg-red-500/10 text-red-600 dark:text-red-400 border-red-200 dark:border-red-500/25',
}

export function AssumptionStatusBadge({ status }: { status: 'open' | 'confirmed' | 'rejected' }) {
  const { t } = useApp()
  const key = status === 'open' ? 'statusOpen' : status === 'confirmed' ? 'statusConfirmed' : 'statusRejectedA'
  return (
    <Badge variant="outline" className={cn('text-[11px] font-medium', ASSUMPTION_STATUS_STYLES[status])}>
      {t(key)}
    </Badge>
  )
}

const KIND_STYLES = {
  suggested: 'bg-violet-50 dark:bg-violet-500/10 text-violet-700 dark:text-violet-300 border-violet-200 dark:border-violet-500/25',
  uncertain: 'bg-amber-50 dark:bg-amber-500/10 text-amber-700 dark:text-amber-300 border-amber-200 dark:border-amber-500/25',
}

export function KindBadge({ kind }: { kind: 'suggested' | 'uncertain' }) {
  const { t } = useApp()
  return (
    <Badge variant="outline" className={cn('text-[11px] font-medium', KIND_STYLES[kind])}>
      {kind === 'suggested' ? t('kindSuggested') : t('kindUncertain')}
    </Badge>
  )
}

// Animated multi-step "AI is working" panel
export function WorkingPanel({ steps, className }: { steps: string[]; className?: string }) {
  const { lang } = useApp()
  return (
    <div
      className={cn(
        'rounded-xl border border-dashed border-primary/40 bg-primary/[0.03] p-6 flex flex-col items-center gap-3 text-center',
        className
      )}
      dir={lang === 'ar' ? 'rtl' : 'ltr'}
    >
      <div className="flex items-center gap-1.5" aria-hidden>
        <span className="h-2 w-2 rounded-full bg-primary soft-pulse" />
        <span className="h-2 w-2 rounded-full bg-primary soft-pulse [animation-delay:0.3s]" />
        <span className="h-2 w-2 rounded-full bg-primary soft-pulse [animation-delay:0.6s]" />
      </div>
      <div className="space-y-1.5">
        {steps.map((step, i) => (
          <p key={step} className="text-sm text-muted-foreground soft-pulse" style={{ animationDelay: `${i * 0.45}s` }}>
            {step}
          </p>
        ))}
      </div>
    </div>
  )
}

// ============================================================
// Engineering track badges
// ============================================================

const REVIEW_STYLES: Record<ReviewStatus, string> = {
  proposed: 'bg-slate-50 dark:bg-slate-500/10 text-slate-600 dark:text-slate-400 border-slate-200 dark:border-slate-500/25',
  confirmed: 'bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200 dark:border-emerald-500/25',
  rejected: 'bg-red-50 dark:bg-red-500/10 text-red-600 dark:text-red-400 border-red-200 dark:border-red-500/25',
  needs_revision: 'bg-amber-50 dark:bg-amber-500/10 text-amber-700 dark:text-amber-300 border-amber-200 dark:border-amber-500/25',
}

const REVIEW_KEYS: Record<ReviewStatus, Parameters<ReturnType<typeof useApp>['t']>[0]> = {
  proposed: 'statusProposed',
  confirmed: 'statusConfirmed',
  rejected: 'statusRejected',
  needs_revision: 'statusNeedsRevision',
}

export function ReviewBadge({ status }: { status: ReviewStatus }) {
  const { t } = useApp()
  return (
    <Badge variant="outline" className={cn('text-[11px] font-medium whitespace-nowrap', REVIEW_STYLES[status])}>
      {t(REVIEW_KEYS[status])}
    </Badge>
  )
}

const REQ_STYLES: Record<ReqStatus, string> = {
  proposed: 'bg-slate-50 dark:bg-slate-500/10 text-slate-600 dark:text-slate-400 border-slate-200 dark:border-slate-500/25',
  confirmed: 'bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200 dark:border-emerald-500/25',
  rejected: 'bg-red-50 dark:bg-red-500/10 text-red-600 dark:text-red-400 border-red-200 dark:border-red-500/25',
  unresolved: 'bg-amber-50 dark:bg-amber-500/10 text-amber-700 dark:text-amber-300 border-amber-200 dark:border-amber-500/25',
}

const REQ_KEYS: Record<ReqStatus, Parameters<ReturnType<typeof useApp>['t']>[0]> = {
  proposed: 'statusProposed',
  confirmed: 'statusConfirmed',
  rejected: 'statusRejected',
  unresolved: 'statusUnresolved',
}

export function ReqStatusBadge({ status }: { status: ReqStatus }) {
  const { t } = useApp()
  return (
    <Badge variant="outline" className={cn('text-[11px] font-medium whitespace-nowrap', REQ_STYLES[status])}>
      {t(REQ_KEYS[status])}
    </Badge>
  )
}

export function ProvenanceBadge({ provenance }: { provenance: 'client' | 'ai' }) {
  const { t } = useApp()
  return (
    <Badge
      variant="outline"
      className={cn(
        'text-[10px] font-medium whitespace-nowrap',
        provenance === 'client' ? 'bg-teal-50 dark:bg-teal-500/10 text-teal-700 dark:text-teal-300 border-teal-200 dark:border-teal-500/25' : 'bg-violet-50 dark:bg-violet-500/10 text-violet-700 dark:text-violet-300 border-violet-200 dark:border-violet-500/25'
      )}
    >
      {provenance === 'client' ? t('provenanceClient') : t('provenanceAi')}
    </Badge>
  )
}

export function CodeChip({ code, className }: { code: string; className?: string }) {
  return (
    <span
      dir="ltr"
      className={cn(
        'inline-flex items-center rounded-md bg-muted/70 border px-1.5 py-0.5 font-mono text-[10px] font-semibold text-muted-foreground whitespace-nowrap',
        className
      )}
    >
      {code}
    </span>
  )
}

export function SeverityBadge({ severity }: { severity: 'critical' | 'major' | 'minor' }) {
  const { t } = useApp()
  const key = severity === 'critical' ? 'severityCritical' : severity === 'major' ? 'severityMajor' : 'severityMinor'
  const style =
    severity === 'critical'
      ? 'bg-red-50 dark:bg-red-500/10 text-red-600 dark:text-red-400 border-red-200 dark:border-red-500/25'
      : severity === 'major'
        ? 'bg-amber-50 dark:bg-amber-500/10 text-amber-700 dark:text-amber-300 border-amber-200 dark:border-amber-500/25'
        : 'bg-slate-50 dark:bg-slate-500/10 text-slate-600 dark:text-slate-400 border-slate-200 dark:border-slate-500/25'
  return (
    <Badge variant="outline" className={cn('text-[10px] font-medium whitespace-nowrap', style)}>
      {t(key)}
    </Badge>
  )
}
