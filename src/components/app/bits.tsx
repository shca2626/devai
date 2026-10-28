'use client'

import { Badge } from '@/components/ui/badge'
import { useApp } from '@/components/app/context'
import { AREA_LABELS } from '@/lib/i18n'
import type { FeatureStatus, Priority, Stage } from '@/lib/types'
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
  const label =
    stage === 'understanding'
      ? t('stageUnderstanding')
      : stage === 'discovery'
        ? t('stageDiscovery')
        : stage === 'features'
          ? t('stageFeatures')
          : t('stageBaseline')
  const tone =
    stage === 'baseline'
      ? 'bg-emerald-50 text-emerald-700 border-emerald-200'
      : 'bg-violet-50 text-violet-700 border-violet-200'
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
  proposed: 'bg-slate-50 text-slate-600 border-slate-200',
  needs_confirmation: 'bg-amber-50 text-amber-700 border-amber-200',
  accepted: 'bg-emerald-50 text-emerald-700 border-emerald-200',
  rejected: 'bg-red-50 text-red-600 border-red-200',
  deferred: 'bg-sky-50 text-sky-700 border-sky-200',
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
  must: 'bg-violet-50 text-violet-700 border-violet-200',
  should: 'bg-slate-50 text-slate-600 border-slate-200',
  could: 'bg-slate-50 text-slate-400 border-slate-200',
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
  open: 'bg-slate-50 text-slate-600 border-slate-200',
  confirmed: 'bg-emerald-50 text-emerald-700 border-emerald-200',
  rejected: 'bg-red-50 text-red-600 border-red-200',
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
  suggested: 'bg-violet-50 text-violet-700 border-violet-200',
  uncertain: 'bg-amber-50 text-amber-700 border-amber-200',
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
