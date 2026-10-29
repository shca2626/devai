'use client'

import { useRef, useState } from 'react'
import { Button } from '@/components/ui/button'
import { useApp } from '@/components/app/context'
import type { IdeaDetail } from '@/lib/types'
import { AlertCircle, Check, CircleStop, Loader2, PackageCheck, Zap } from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Express autopilot UI — the client explicitly DELEGATES the
// remaining workflow. Every step is shown live, can be stopped
// at any moment, and every delegated decision is recorded and
// reversible (artifacts stay editable; the package can be
// reopened). Nothing here bypasses the decision history.
// ============================================================

interface ExpressState {
  status: 'running' | 'done' | 'blocked'
  step: string
  next?: string
  reason?: string
  blockers?: string[]
}

export function ExpressRun({ detail }: { detail: IdeaDetail }) {
  const { t, setDetail, refreshIdeas, setView } = useApp()
  const { toast } = useToast()
  const [open, setOpen] = useState(false)
  const [running, setRunning] = useState(false)
  const [steps, setSteps] = useState<string[]>([])
  const [current, setCurrent] = useState('')
  const [result, setResult] = useState<ExpressState | null>(null)
  const cancelRef = useRef(false)

  const stage = detail.idea.stage
  if (stage === 'package' && !running && !result) return null

  async function run() {
    cancelRef.current = false
    setRunning(true)
    setOpen(true)
    setSteps([])
    setResult(null)
    setCurrent(t('expressWorking'))
    try {
      let consecutiveFailures = 0
      for (;;) {
        if (cancelRef.current) break
        const res = await fetch(`/api/ideas/${detail.idea.id}/express`, { method: 'POST' })
        const data = (await res.json()) as { express?: ExpressState; detail?: IdeaDetail; error?: string }
        if (!res.ok || !data.express) {
          // Transient AI hiccups (e.g. an unreadable model response) are
          // retried automatically before surfacing the error.
          consecutiveFailures++
          if (consecutiveFailures <= 2) {
            setCurrent(t('expressWorking'))
            await new Promise((r) => setTimeout(r, 2500))
            continue
          }
          toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
          setResult({ status: 'blocked', step: '', reason: data.error ?? t('aiError') })
          break
        }
        consecutiveFailures = 0
        if (data.detail) setDetail(data.detail)
        const ex = data.express
        if (ex.status === 'running') {
          if (ex.step) setSteps((s) => [...s, ex.step])
          setCurrent(ex.next ?? t('expressWorking'))
          continue
        }
        if (ex.status === 'done') {
          if (ex.step) setSteps((s) => [...s, ex.step])
          setResult(ex)
          refreshIdeas()
          // Land on the final package so the user receives the deliverable immediately.
          setTimeout(() => setView('package'), 1400)
          break
        }
        // blocked
        setResult(ex)
        refreshIdeas()
        break
      }
    } catch {
      toast({ description: t('aiError'), variant: 'destructive' })
    } finally {
      setRunning(false)
      setCurrent('')
    }
  }

  function stop() {
    cancelRef.current = true
    setRunning(false)
    setCurrent('')
  }

  const done = result?.status === 'done'
  const blocked = result?.status === 'blocked'

  return (
    <div className="rounded-xl border border-primary/25 bg-primary/[0.03] p-3 sm:p-4 space-y-3">
      <div className="flex flex-wrap items-start gap-2">
        <span className="flex h-8 w-8 shrink-0 items-center justify-center rounded-lg bg-primary/10 border border-primary/20">
          <Zap className="h-4 w-4 text-primary" />
        </span>
        <div className="flex-1 min-w-[220px]">
          <div className="text-sm font-semibold">{t('expressTitle')}</div>
          <p className="text-xs text-muted-foreground leading-6 mt-0.5">{t('expressBody')}</p>
        </div>
        {!running && !done && (
          <Button size="sm" className="gap-1.5" onClick={run}>
            <Zap className="h-3.5 w-3.5" />
            {t('expressStart')}
          </Button>
        )}
        {running && (
          <Button size="sm" variant="outline" className="gap-1.5" onClick={stop}>
            <CircleStop className="h-3.5 w-3.5" />
            {t('expressStop')}
          </Button>
        )}
      </div>

      {open && (running || steps.length > 0 || result) && (
        <div className="rounded-lg border bg-card p-3 space-y-2">
          <div className="max-h-52 overflow-y-auto nice-scroll space-y-1.5">
            {steps.map((s, i) => (
              <div key={i} className="flex items-start gap-2 text-xs leading-6">
                <Check className="h-3.5 w-3.5 text-emerald-600 shrink-0 mt-1" />
                <span>{s}</span>
              </div>
            ))}
            {running && (
              <div className="flex items-start gap-2 text-xs leading-6">
                <Loader2 className="h-3.5 w-3.5 animate-spin text-primary shrink-0 mt-1" />
                <span>{current}</span>
              </div>
            )}
            {done && (
              <div className="flex items-start gap-2 text-xs leading-6 font-medium text-emerald-700">
                <PackageCheck className="h-3.5 w-3.5 shrink-0 mt-1" />
                <span>{t('expressDone')}</span>
              </div>
            )}
          </div>

          {blocked && (
            <div className="rounded-lg border border-amber-300 bg-amber-50 p-3 space-y-1.5">
              <div className="flex items-start gap-2">
                <AlertCircle className="h-4 w-4 text-amber-600 shrink-0 mt-0.5" />
                <p className="text-xs text-amber-900 leading-6">{result?.reason}</p>
              </div>
              {result?.blockers && result.blockers.length > 0 && (
                <ul className="text-[11px] text-amber-800 leading-6 ps-6 list-disc">
                  {result.blockers.slice(0, 6).map((b, i) => (
                    <li key={i}>{b}</li>
                  ))}
                </ul>
              )}
              <p className="text-[11px] text-amber-700 ps-6">{t('expressResolveHint')}</p>
              <div className="ps-6">
                <Button size="sm" variant="outline" onClick={() => setResult(null)}>
                  {t('expressContinueManually')}
                </Button>
              </div>
            </div>
          )}
        </div>
      )}
    </div>
  )
}
