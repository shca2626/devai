'use client'

import { useApp } from '@/components/app/context'
import { cn } from '@/lib/utils'
import { STAGES, stageIndex, type Stage } from '@/lib/types'
import { Check } from 'lucide-react'

const STAGE_KEYS = {
  understanding: 'stageUnderstanding',
  discovery: 'stageDiscovery',
  features: 'stageFeatures',
  baseline: 'stageBaseline',
} as const

export function Stepper({ currentStage, view }: { currentStage: Stage; view: string }) {
  const { t, setView } = useApp()
  const currentIdx = stageIndex(currentStage)

  return (
    <nav
      aria-label="Workflow stages"
      className="flex items-center gap-1 sm:gap-2 overflow-x-auto nice-scroll py-1"
    >
      {STAGES.map((stage, idx) => {
        const done = idx < currentIdx
        const isCurrent = idx === currentIdx
        const accessible = idx <= currentIdx
        const active = view === stage
        return (
          <div key={stage} className="flex items-center gap-1 sm:gap-2 shrink-0">
            {idx > 0 && <div className={cn('h-px w-4 sm:w-8', done ? 'bg-primary/50' : 'bg-border')} />}
            <button
              type="button"
              disabled={!accessible}
              onClick={() => accessible && setView(stage)}
              className={cn(
                'flex items-center gap-1.5 rounded-full border px-2.5 py-1 text-xs font-medium transition-colors min-h-9',
                active
                  ? 'border-primary bg-primary text-primary-foreground'
                  : done
                    ? 'border-primary/30 bg-primary/[0.06] text-primary hover:bg-primary/10'
                    : isCurrent
                      ? 'border-primary/40 text-primary'
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
                      ? 'bg-primary/15'
                      : isCurrent
                        ? 'bg-primary/10'
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
