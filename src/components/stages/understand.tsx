'use client'

import { Button } from '@/components/ui/button'
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog'
import { Textarea } from '@/components/ui/textarea'
import { Badge } from '@/components/ui/badge'
import { AppWindow, FlaskConical, Globe } from 'lucide-react'
import { Alert, AlertDescription, AlertTitle } from '@/components/ui/alert'
import { useApp } from '@/components/app/context'
import { WorkingPanel } from '@/components/app/bits'
import type { IdeaDetail } from '@/lib/types'
import { isLaterStage } from '@/lib/types'
import { AlertCircle, ArrowRight, CheckCircle2, HelpCircle, Lightbulb, Lock, RefreshCw } from 'lucide-react'
import { useState } from 'react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Stage 1 — Understand: bilingual interpretation card with the
// first approval gate. Facts / open questions / assumptions are
// visually separated; assumptions are never shown as decisions.
// ============================================================

export function UnderstandStage({ detail }: { detail: IdeaDetail }) {
  const { t, setDetail, refreshIdeas, setView } = useApp()
  const { toast } = useToast()
  const [correcting, setCorrecting] = useState(false)
  const [corrections, setCorrections] = useState('')
  const [busy, setBusy] = useState<null | 'gate' | 'reinterpret'>(null)

  const { idea } = detail
  const interpretation = idea.interpretation
  const locked = isLaterStage(idea.stage, 'understanding')

  async function approveGate() {
    setBusy('gate')
    try {
      const res = await fetch(`/api/ideas/${idea.id}/gate`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ gate: 'interpretation', action: 'approve' }),
      })
      const data = await res.json()
      if (!res.ok) {
        toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
        return
      }
      setDetail(data as IdeaDetail)
      refreshIdeas()
      setView('discover')
    } catch {
      toast({ description: t('aiError'), variant: 'destructive' })
    } finally {
      setBusy(null)
    }
  }

  async function reinterpret() {
    if (corrections.trim().length < 3) return
    setBusy('reinterpret')
    try {
      const res = await fetch(`/api/ideas/${idea.id}/reinterpret`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ corrections: corrections.trim() }),
      })
      const data = await res.json()
      if (!res.ok) {
        toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
        return
      }
      setDetail(data as IdeaDetail)
      refreshIdeas()
      setCorrecting(false)
      setCorrections('')
    } catch {
      toast({ description: t('aiError'), variant: 'destructive' })
    } finally {
      setBusy(null)
    }
  }

  if (!interpretation) {
    return <WorkingPanel steps={[t('understanding1'), t('understanding2')]} className="mt-4" />
  }

  return (
    <div className="space-y-4">
      {locked && (
        <Alert className="border-emerald-200 dark:border-emerald-500/25 bg-emerald-50/60 dark:bg-emerald-500/10">
          <Lock className="h-4 w-4 text-emerald-600 dark:text-emerald-400" />
          <AlertDescription className="text-emerald-800 dark:text-emerald-300">{t('lockedNote')}</AlertDescription>
        </Alert>
      )}

      {/* Original + interpretation, side by side */}
      <div className="grid gap-4 md:grid-cols-2">
        <div className="rounded-xl sm:rounded-2xl border bg-muted/30 p-3.5 sm:p-5" dir="rtl">
          <div className="mb-2 flex items-center gap-2">
            <span className="text-xs font-semibold text-muted-foreground font-arabic">{t('originalIdea')}</span>
            <Badge variant="outline" className="text-[10px] font-arabic bg-background">
              {idea.sourceLang === 'ar' ? 'العربية' : 'English'}
            </Badge>
            {idea.projectType && (
              <Badge variant="outline" className="text-[10px] bg-background gap-1">
                {idea.projectType === 'website' ? (
                  <Globe className="h-3 w-3" />
                ) : idea.projectType === 'prototype' ? (
                  <FlaskConical className="h-3 w-3" />
                ) : (
                  <AppWindow className="h-3 w-3" />
                )}
                {t(
                  idea.projectType === 'website'
                    ? 'typeWebsite'
                    : idea.projectType === 'prototype'
                      ? 'typePrototype'
                      : 'typeApp'
                )}
              </Badge>
            )}
          </div>
          <p className="font-arabic text-[15px] leading-8 text-foreground whitespace-pre-wrap">
            {idea.originalText}
          </p>
        </div>
        <div className="rounded-xl sm:rounded-2xl border bg-card p-3.5 sm:p-5" dir="ltr">
          <div className="mb-2 text-xs font-semibold text-muted-foreground">{t('englishInterpretation')}</div>
          <p className="text-[15px] leading-7 text-foreground">{interpretation.englishInterpretation}</p>
          <div className="mt-4 rounded-lg bg-primary/[0.05] border border-primary/15 p-3">
            <div className="text-xs font-semibold text-primary mb-1">{t('problemStatement')}</div>
            <p className="text-sm leading-6 text-foreground/90">{interpretation.problemStatement}</p>
          </div>
        </div>
      </div>

      {/* Facts / unclear / assumed */}
      <div className="grid gap-4 md:grid-cols-3">
        <div className="rounded-xl sm:rounded-2xl border p-3.5 sm:p-5">
          <div className="mb-2 flex items-center gap-1.5 text-sm font-semibold text-emerald-700">
            <CheckCircle2 className="h-4 w-4" />
            {t('understoodTitle')}
          </div>
          <ul className="space-y-1.5" dir="ltr">
            {interpretation.understood.map((fact) => (
              <li key={fact} className="text-[13px] leading-6 text-foreground/85 flex gap-1.5">
                <span className="mt-2 h-1 w-1 shrink-0 rounded-full bg-emerald-500" />
                {fact}
              </li>
            ))}
          </ul>
        </div>
        <div className="rounded-xl sm:rounded-2xl border p-3.5 sm:p-5">
          <div className="mb-2 flex items-center gap-1.5 text-sm font-semibold text-amber-600">
            <HelpCircle className="h-4 w-4" />
            {t('unclearTitle')}
          </div>
          <ul className="space-y-1.5" dir="ltr">
            {interpretation.unclear.map((q) => (
              <li key={q} className="text-[13px] leading-6 text-foreground/85 flex gap-1.5">
                <span className="mt-2 h-1 w-1 shrink-0 rounded-full bg-amber-500" />
                {q}
              </li>
            ))}
          </ul>
          <p className="mt-2 text-[11px] text-muted-foreground">{t('unclearNote')}</p>
        </div>
        <div className="rounded-xl sm:rounded-2xl border p-3.5 sm:p-5">
          <div className="mb-2 flex items-center gap-1.5 text-sm font-semibold text-violet-700">
            <Lightbulb className="h-4 w-4" />
            {t('assumedTitle')}
          </div>
          <ul className="space-y-1.5" dir="ltr">
            {interpretation.assumed.map((a) => (
              <li key={a} className="text-[13px] leading-6 text-foreground/85 flex gap-1.5">
                <span className="mt-2 h-1 w-1 shrink-0 rounded-full bg-violet-500" />
                {a}
              </li>
            ))}
          </ul>
          <p className="mt-2 text-[11px] text-muted-foreground">{t('assumedNote')}</p>
        </div>
      </div>

      {/* Gate actions — NO LIMITS: always available, even after approval */}
      <div className="flex flex-col sm:flex-row items-stretch sm:items-center gap-2">
        {locked && (
          <Badge variant="outline" className="gap-1 bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200 dark:border-emerald-500/25 self-start">
            <CheckCircle2 className="h-3 w-3" />
            {t('approvedBadge')}
          </Badge>
        )}
        <Button onClick={approveGate} disabled={busy !== null} className="gap-1.5 flex-1 sm:flex-none" size="lg">
          {busy === 'gate' ? <RefreshCw className="h-4 w-4 animate-spin" /> : <ArrowRight className="h-4 w-4" />}
          {busy === 'gate' ? t('loading') : t('approveInterpretation')}
        </Button>
        <Button
          variant="outline"
          onClick={() => setCorrecting(true)}
          disabled={busy !== null}
          className="gap-1.5"
          size="lg"
        >
          <RefreshCw className="h-4 w-4" />
          {t('correctInterpretation')}
        </Button>
        <p className="text-xs text-muted-foreground sm:ms-2">{t('reinterpretationNote')}</p>
      </div>

      {/* Corrections dialog */}
      <Dialog open={correcting} onOpenChange={(v) => !busy && setCorrecting(v)}>
        <DialogContent className="sm:max-w-lg">
          {busy === 'reinterpret' ? (
            <WorkingPanel steps={[t('understanding2'), t('understanding3')]} />
          ) : (
            <>
              <DialogHeader>
                <DialogTitle>{t('correctInterpretation')}</DialogTitle>
                <DialogDescription>{t('reinterpretationNote')}</DialogDescription>
              </DialogHeader>
              <Textarea
                value={corrections}
                onChange={(e) => setCorrections(e.target.value)}
                placeholder={t('correctPlaceholder')}
                rows={5}
                dir="auto"
              />
              <DialogFooter>
                <Button variant="outline" onClick={() => setCorrecting(false)}>
                  {t('cancel')}
                </Button>
                <Button onClick={reinterpret} disabled={corrections.trim().length < 3}>
                  {t('submitCorrections')}
                </Button>
              </DialogFooter>
            </>
          )}
        </DialogContent>
      </Dialog>

      <Alert className="border-primary/20 bg-primary/[0.03]">
        <AlertCircle className="h-4 w-4 text-primary" />
        <AlertTitle className="text-sm">{t('assumedTitle')}</AlertTitle>
        <AlertDescription className="text-xs">
          {interpretation.assumed.length > 0
            ? t('assumedNote')
            : t('unclearNote')}
        </AlertDescription>
      </Alert>
    </div>
  )
}
