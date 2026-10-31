'use client'

import { useApp } from '@/components/app/context'
import { cn } from '@/lib/utils'
import { STAGES, stageIndex, type Stage } from '@/lib/types'
import { Check, ChevronLeft, ChevronRight, Wrench } from 'lucide-react'
import { useEffect, useRef } from 'react'

const STAGE_KEYS = {
  understanding: 'stageUnderstanding',
  discovery: 'stageDiscovery',
  features: 'stageFeatures',
  baseline: 'stageBaseline',
  requirements: 'stageRequirements',
  design: 'stageDesign',
  planning: 'stagePlanning',
  readiness: 'stageReadiness',
  package: 'stagePackage',
} as const

const VIEW_BY_STAGE: Record<Stage, string> = {
  understanding: 'understand',
  discovery: 'discover',
  features: 'features',
  baseline: 'baseline',
  requirements: 'requirements',
  design: 'design',
  planning: 'planning',
  readiness: 'readiness',
  package: 'package',
}

function viewStageIndex(view: string): number {
  const idx = STAGES.findIndex((s) => VIEW_BY_STAGE[s] === view)
  return idx < 0 ? 0 : idx
}

export function Stepper({ currentStage, view }: { currentStage: Stage; view: string }) {
  const { t, setView } = useApp()
  const currentIdx = stageIndex(currentStage)
  const viewIdx = viewStageIndex(view)
  // NO LIMITS: every stage is always navigable — the stepper is a
  // navigation bar, not a lock. The workflow badge stays for context.

  // Keep the active chip visible when the bar scrolls horizontally (desktop).
  const activeRef = useRef<HTMLButtonElement | null>(null)
  useEffect(() => {
    activeRef.current?.scrollIntoView({ inline: 'nearest', block: 'nearest', behavior: 'smooth' })
  }, [view])

  function goTo(idx: number) {
    const next = Math.min(STAGES.length - 1, Math.max(0, idx))
    setView(VIEW_BY_STAGE[STAGES[next]] as never)
  }

  return (
    <nav aria-label="Workflow stages">
      {/* ── Mobile: compact stage pill — short width, centered, tappable ── */}
      <div className="flex flex-col items-center gap-1.5 md:hidden">
        <div className="inline-flex max-w-full items-center gap-0.5 rounded-full border bg-card p-1 shadow-sm">
          <button
            type="button"
            onClick={() => goTo(viewIdx - 1)}
            disabled={viewIdx === 0}
            aria-label={t('prevStage')}
            className="flex h-8 w-8 shrink-0 items-center justify-center rounded-full text-muted-foreground transition-colors hover:bg-muted active:scale-95 disabled:pointer-events-none disabled:opacity-35"
          >
            <ChevronLeft className="h-4 w-4 rtl:-scale-x-100" />
          </button>

          <div className="flex items-center">
            {STAGES.map((stage, idx) => {
              const label = `${idx + 1}. ${t(STAGE_KEYS[stage])}`
              const active = idx === viewIdx
              const done = idx < currentIdx
              const isCurrent = idx === currentIdx
              return (
                <span key={stage} className="flex items-center">
                  {idx === 4 && <span aria-hidden className="mx-1 h-3.5 w-px bg-border" />}
                  <button
                    type="button"
                    onClick={() => goTo(idx)}
                    title={label}
                    aria-label={label}
                    aria-current={active ? 'step' : undefined}
                    className="flex h-7 items-center justify-center px-[3px]"
                  >
                    <span
                      className={cn(
                        'block h-2 rounded-full transition-all duration-300',
                        active
                          ? 'w-6 bg-primary shadow-sm shadow-primary/40'
                          : isCurrent
                            ? 'w-2 bg-primary'
                            : done
                              ? 'w-2 bg-primary/45 hover:bg-primary/70'
                              : 'w-2 bg-border hover:bg-muted-foreground/40'
                      )}
                    />
                  </button>
                </span>
              )
            })}
          </div>

          <button
            type="button"
            onClick={() => goTo(viewIdx + 1)}
            disabled={viewIdx === STAGES.length - 1}
            aria-label={t('nextStage')}
            className="flex h-8 w-8 shrink-0 items-center justify-center rounded-full text-muted-foreground transition-colors hover:bg-muted active:scale-95 disabled:pointer-events-none disabled:opacity-35"
          >
            <ChevronRight className="h-4 w-4 rtl:-scale-x-100" />
          </button>
        </div>

        <div className="flex items-center gap-1.5 text-[11px] leading-none text-muted-foreground">
          {viewIdx >= 4 && <Wrench aria-hidden className="h-3 w-3 text-teal-600 dark:text-teal-400" />}
          <span className="font-semibold text-foreground">{t(STAGE_KEYS[STAGES[viewIdx]])}</span>
          <span className="tabular-nums opacity-75">
            {viewIdx + 1}/{STAGES.length}
          </span>
        </div>
      </div>

      {/* ── Desktop: full chips bar with connectors ── */}
      <div className="hidden items-center gap-2 overflow-x-auto nice-scroll py-1 md:flex">
        {STAGES.map((stage, idx) => {
          const done = idx < currentIdx
          const isCurrent = idx === currentIdx
          const active = view === VIEW_BY_STAGE[stage]
          const isEngineering = idx >= 4
          return (
            <div key={stage} className="flex shrink-0 items-center gap-2">
              {idx > 0 &&
                (idx === 4 ? (
                  <span className="mx-1 hidden items-center gap-1 border-s-2 ps-2 text-[10px] font-semibold h-4 text-muted-foreground/80 sm:inline-flex lg:inline-flex">
                    <Wrench className="h-3 w-3" />
                    {currentIdx >= 4 ? t('phaseEngineering') : '...'}
                  </span>
                ) : (
                  <div className={cn('h-px w-8', done ? 'bg-primary/50' : 'bg-border')} />
                ))}
              <button
                ref={active ? activeRef : undefined}
                type="button"
                onClick={() => setView(VIEW_BY_STAGE[stage] as never)}
                className={cn(
                  'flex min-h-9 items-center gap-1.5 rounded-full border px-2.5 py-1 text-xs font-medium whitespace-nowrap transition-all',
                  active
                    ? 'border-primary bg-primary text-primary-foreground shadow-sm shadow-primary/30'
                    : done
                      ? isEngineering
                        ? 'border-teal-300 dark:border-teal-500/30 bg-teal-50 dark:bg-teal-500/10 text-teal-700 dark:text-teal-300 hover:bg-teal-100 dark:hover:bg-teal-500/15'
                        : 'border-primary/30 bg-primary/[0.06] text-primary hover:bg-primary/10'
                      : isCurrent
                        ? isEngineering
                          ? 'border-teal-400 dark:border-teal-500/30 text-teal-700 dark:text-teal-300'
                          : 'border-primary/40 text-primary'
                        : 'border-border text-muted-foreground hover:bg-muted/70 hover:border-border'
                )}
                aria-current={isCurrent ? 'step' : undefined}
              >
                <span
                  className={cn(
                    'flex h-4.5 w-4.5 items-center justify-center rounded-full text-[10px] font-semibold',
                    active
                      ? 'bg-primary-foreground/20'
                      : done
                        ? isEngineering
                          ? 'bg-teal-100 dark:bg-teal-500/15'
                          : 'bg-primary/15'
                        : isCurrent
                          ? isEngineering
                            ? 'bg-teal-50 dark:bg-teal-500/10'
                            : 'bg-primary/10'
                          : 'bg-muted'
                  )}
                >
                  {done ? <Check className="h-3 w-3" /> : idx + 1}
                </span>
                {t(STAGE_KEYS[stage])}
              </button>
            </div>
          )
        })}
      </div>
    </nav>
  )
}
