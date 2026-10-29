'use client'

import { useApp } from '@/components/app/context'
import { cn } from '@/lib/utils'
import { STAGES, stageIndex, type Stage } from '@/lib/types'
import { Check, Wrench } from 'lucide-react'

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

export function Stepper({ currentStage, view }: { currentStage: Stage; view: string }) {
  const { t, setView } = useApp()
  const currentIdx = stageIndex(currentStage)
  const engineeringStarted = currentIdx >= 4

  return (
    <nav
      aria-label="Workflow stages"
      className="flex items-center gap-1 sm:gap-2 overflow-x-auto nice-scroll py-1"
    >
      {STAGES.map((stage, idx) => {
        const done = idx < currentIdx
        const isCurrent = idx === currentIdx
        const accessible = idx <= currentIdx
        const active = view === VIEW_BY_STAGE[stage]
        const isEngineering = idx >= 4
        return (
          <div key={stage} className="flex items-center gap-1 sm:gap-2 shrink-0">
            {idx > 0 &&
              (idx === 4 ? (
                <span className="mx-1 hidden sm:inline-flex items-center gap-1 text-[10px] font-semibold text-muted-foreground/80 border-s-2 ps-2 h-4">
                  <Wrench className="h-3 w-3" />
                  {engineeringStarted ? t('phaseEngineering') : '...'}
                </span>
              ) : (
                <div className={cn('h-px w-4 sm:w-8', done ? 'bg-primary/50' : 'bg-border')} />
              ))}
            <button
              type="button"
              disabled={!accessible}
              onClick={() => accessible && setView(VIEW_BY_STAGE[stage] as never)}
              className={cn(
                'flex items-center gap-1.5 rounded-full border px-2.5 py-1 text-xs font-medium transition-colors min-h-9',
                active
                  ? 'border-primary bg-primary text-primary-foreground'
                  : done
                    ? isEngineering
                      ? 'border-teal-300 bg-teal-50 text-teal-700 hover:bg-teal-100'
                      : 'border-primary/30 bg-primary/[0.06] text-primary hover:bg-primary/10'
                    : isCurrent
                      ? isEngineering
                        ? 'border-teal-400 text-teal-700'
                        : 'border-primary/40 text-primary'
                      : 'border-border text-muted-foreground opacity-60 cursor-not-allowed'
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
                        ? 'bg-teal-100'
                        : 'bg-primary/15'
                      : isCurrent
                        ? isEngineering
                          ? 'bg-teal-50'
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
    </nav>
  )
}
