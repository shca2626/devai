'use client'

import { Button } from '@/components/ui/button'
import { Textarea } from '@/components/ui/textarea'
import { Badge } from '@/components/ui/badge'
import { Alert, AlertDescription, AlertTitle } from '@/components/ui/alert'
import { Collapsible, CollapsibleContent, CollapsibleTrigger } from '@/components/ui/collapsible'
import { Progress } from '@/components/ui/progress'
import { useApp } from '@/components/app/context'
import { AreaBadge, WorkingPanel } from '@/components/app/bits'
import { AREA_LABELS } from '@/lib/i18n'
import type { IdeaDetail, Question } from '@/lib/types'
import { AREAS } from '@/lib/types'
import { cn } from '@/lib/utils'
import { CheckCircle2, ChevronDown, Flag, Info, SkipForward, Sparkles } from 'lucide-react'
import { useEffect, useMemo, useState } from 'react'
import { useToast } from '@/hooks/use-toast'
import ReactMarkdown from 'react-markdown'

// ============================================================
// Stage 2 — Discover: adaptive Q&A with honest consequences,
// coverage tracking across the 9 discovery areas, and the
// "compile summary" gate. Answers drive what gets asked next.
// ============================================================

interface NextResponse extends IdeaDetail {
  suggestDone?: boolean
  coverage?: { answered: number; total: number; uncovered: string[] }
}

export function DiscoverStage({ detail }: { detail: IdeaDetail }) {
  const { t, lang, setDetail, refreshIdeas, setView } = useApp()
  const { toast } = useToast()

  const [selected, setSelected] = useState<string | null>(null)
  const [custom, setCustom] = useState('')
  const [busy, setBusy] = useState<null | 'answer' | 'next' | 'finish'>(null)
  const [suggestDone, setSuggestDone] = useState(false)

  const { idea, questions } = detail
  // NO LIMITS: the interview stays live at every stage — questions
  // can be answered, skipped and generated whenever they exist.
  const locked = false
  const answeredQuestions = useMemo(() => questions.filter((q) => q.status === 'answered'), [questions])
  const answeredAreas = useMemo(() => new Set(answeredQuestions.map((q) => q.area)), [answeredQuestions])
  const pending = useMemo(() => questions.filter((q) => q.status === 'pending'), [questions])
  const current: Question | null = pending[0] ?? null

  // Reset selection when the current question changes
  useEffect(() => {
    setSelected(null)
    setCustom('')
  }, [current?.id])

  async function answer(kind: 'choice' | 'custom' | 'skip') {
    if (!current) return
    if (kind === 'choice' && !selected) return
    if (kind === 'custom' && custom.trim().length < 1) return
    setBusy('answer')
    try {
      const res = await fetch(`/api/ideas/${idea.id}/questions/answer`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          questionId: current.id,
          answer: kind === 'choice' ? selected : kind === 'custom' ? custom.trim() : undefined,
          kind: kind === 'skip' ? 'skip' : kind,
        }),
      })
      const data = await res.json()
      if (!res.ok) {
        toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
        return
      }
      setDetail(data as IdeaDetail)
      // Auto-fetch the next question
      if (!locked) fetchNext()
    } catch {
      toast({ description: t('aiError'), variant: 'destructive' })
    } finally {
      setBusy(null)
    }
  }

  async function fetchNext(force = false) {
    setBusy('next')
    try {
      const res = await fetch(`/api/ideas/${idea.id}/questions/next`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ force }),
      })
      const data = (await res.json()) as { error?: string; suggestDone?: boolean } & IdeaDetail
      if (!res.ok) {
        toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
        return
      }
      setDetail({ idea: data.idea, questions: data.questions, features: data.features, assumptions: data.assumptions, decisions: data.decisions, roles: data.roles ?? null, requirements: data.requirements ?? [], processes: data.processes ?? [], entities: data.entities ?? [], apis: data.apis ?? [], screens: data.screens ?? [], tasks: data.tasks ?? [], risks: data.risks ?? [], issues: data.issues ?? [], architecture: data.architecture ?? null, tradeStudy: data.tradeStudy ?? null, adrs: data.adrs ?? [], threatModel: data.threatModel ?? null, scaleReport: data.scaleReport ?? null, testCases: data.testCases ?? [], testCoverage: data.testCoverage ?? null, edgeCases: data.edgeCases ?? null, e2eScenarios: data.e2eScenarios ?? [], readiness: data.readiness ?? null })
      setSuggestDone(Boolean(data.suggestDone))
    } catch {
      toast({ description: t('aiError'), variant: 'destructive' })
    } finally {
      setBusy(null)
    }
  }

  async function finish() {
    setBusy('finish')
    try {
      const res = await fetch(`/api/ideas/${idea.id}/finish-discovery`, { method: 'POST' })
      const data = await res.json()
      if (!res.ok) {
        toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
        return
      }
      setDetail(data as IdeaDetail)
      refreshIdeas()
      setView('features')
    } catch {
      toast({ description: t('aiError'), variant: 'destructive' })
    } finally {
      setBusy(null)
    }
  }

  const progress = Math.round((answeredAreas.size / AREAS.length) * 100)

  return (
    <div className="space-y-4">
      {/* Coverage panel */}
      <div className="rounded-xl sm:rounded-2xl border p-3.5 sm:p-5">
        <div className="flex items-center justify-between gap-3 mb-2">
          <span className="text-sm font-semibold">{t('coverage')}</span>
          <span className="text-xs text-muted-foreground">
            {answeredAreas.size}/{AREAS.length} {t('areasAnswered')}
          </span>
        </div>
        <Progress value={progress} className="h-1.5 mb-3" aria-label={t('coverage')} />
        <div className="flex flex-wrap gap-1.5">
          {AREAS.map((area) => (
            <AreaBadge key={area} area={area} active={answeredAreas.has(area)} />
          ))}
        </div>
      </div>

      {/* Current question or done suggestion */}
      {current && !locked ? (
        <div className="rounded-xl border-2 border-primary/25 bg-card p-4 sm:p-5 shadow-sm">
          <div className="flex items-start justify-between gap-2 mb-3">
            <AreaBadge area={current.area} active />
            {busy === 'answer' && <span className="text-xs text-muted-foreground soft-pulse">{t('loading')}</span>}
          </div>
          <p className="text-base font-semibold leading-7" dir="ltr">
            {current.questionEn}
          </p>
          {current.questionAr && (
            <p className="font-arabic text-sm text-muted-foreground leading-7 mt-1" dir="rtl">
              {current.questionAr}
            </p>
          )}
          {current.whyItMatters && (
            <div className="mt-2 flex items-start gap-1.5 text-xs text-muted-foreground" dir="ltr">
              <Info className="h-3.5 w-3.5 mt-0.5 shrink-0" />
              <span>
                <span className="font-medium">{t('questionWhy')}: </span>
                {current.whyItMatters}
              </span>
            </div>
          )}

          {/* Options with consequences */}
          <div className="mt-4 space-y-2" role="radiogroup" aria-label={t('chooseAnswer')}>
            <div className="text-xs font-medium text-muted-foreground">{t('chooseAnswer')}</div>
            {current.options.map((opt) => (
              <button
                key={opt.label}
                type="button"
                role="radio"
                aria-checked={selected === opt.label}
                disabled={busy !== null}
                onClick={() => setSelected(opt.label)}
                className={cn(
                  'w-full rounded-lg border p-3 text-start transition-all min-h-[44px]',
                  selected === opt.label
                    ? 'border-primary bg-primary/[0.06] ring-1 ring-primary/30'
                    : 'border-border hover:border-primary/40 hover:bg-muted/40'
                )}
                dir="ltr"
              >
                <div className="flex items-start gap-2">
                  <span
                    className={cn(
                      'mt-0.5 h-4 w-4 shrink-0 rounded-full border-2 flex items-center justify-center',
                      selected === opt.label ? 'border-primary' : 'border-muted-foreground/40'
                    )}
                  >
                    {selected === opt.label && <span className="h-2 w-2 rounded-full bg-primary" />}
                  </span>
                  <div className="flex-1">
                    <div className="text-sm font-medium leading-6">{opt.label}</div>
                    {opt.consequence && (
                      <div className="text-xs text-muted-foreground leading-5 mt-0.5">→ {opt.consequence}</div>
                    )}
                  </div>
                </div>
              </button>
            ))}
          </div>

          <div className="mt-3 flex flex-wrap items-center gap-2">
            <Button size="sm" disabled={!selected || busy !== null} onClick={() => answer('choice')} className="gap-1.5">
              <CheckCircle2 className="h-3.5 w-3.5" />
              {t('submitAnswer')}
            </Button>
            <Button
              size="sm"
              variant="ghost"
              disabled={busy !== null}
              onClick={() => answer('skip')}
              className="gap-1.5 text-muted-foreground"
            >
              <SkipForward className="h-3.5 w-3.5" />
              {t('skipQuestion')}
            </Button>
          </div>

          {/* Own words */}
          <div className="mt-4 border-t pt-3">
            <div className="text-xs font-medium text-muted-foreground mb-1.5">{t('orOwnWords')}</div>
            <div className="flex flex-col sm:flex-row gap-2">
              <Textarea
                value={custom}
                onChange={(e) => setCustom(e.target.value)}
                placeholder={t('ownWordsPlaceholder')}
                rows={2}
                dir="auto"
                className="resize-none"
              />
              <Button
                size="sm"
                variant="outline"
                disabled={custom.trim().length < 1 || busy !== null}
                onClick={() => answer('custom')}
                className="self-end gap-1.5 shrink-0"
              >
                <Sparkles className="h-3.5 w-3.5" />
                {t('submitAnswer')}
              </Button>
            </div>
          </div>
        </div>
      ) : !locked ? (
        <div className="space-y-4">
          {busy === 'next' ? (
            <WorkingPanel steps={[t('generatingQuestion')]} />
          ) : suggestDone || answeredQuestions.length >= 5 ? (
            <Alert className="border-primary/30 bg-primary/[0.04]">
              <Flag className="h-4 w-4 text-primary" />
              <AlertTitle className="text-sm">{t('suggestDoneTitle')}</AlertTitle>
              <AlertDescription className="text-xs leading-6">{t('suggestDoneBody')}</AlertDescription>
              <div className="mt-3 flex flex-wrap gap-2">
                <Button size="sm" onClick={finish} disabled={busy !== null} className="gap-1.5">
                  <CheckCircle2 className="h-3.5 w-3.5" />
                  {busy === 'finish' ? t('compiling') : t('finishDiscovery')}
                </Button>
                <Button size="sm" variant="outline" onClick={() => fetchNext(true)} disabled={busy !== null}>
                  {t('askMore')}
                </Button>
              </div>
            </Alert>
          ) : (
            <div className="flex justify-center py-2">
              <Button variant="outline" onClick={() => fetchNext(false)} disabled={busy !== null} className="gap-1.5">
                <Sparkles className="h-3.5 w-3.5" />
                {t('askMore')}
              </Button>
            </div>
          )}
        </div>
      ) : null}

      {/* Summary (when finished) */}
      {idea.summary && (
        <div className="rounded-xl sm:rounded-2xl border p-3.5 sm:p-5" dir="ltr">
          <div className="mb-2 text-sm font-semibold">{t('discoverySummaryTitle')}</div>
          <div className="md-body text-sm text-foreground/90">
            <ReactMarkdown>{idea.summary.summaryMarkdown}</ReactMarkdown>
          </div>
          {idea.summary.openRisks.length > 0 && (
            <div className="mt-3 rounded-lg border border-amber-200 dark:border-amber-500/25 bg-amber-50/60 dark:bg-amber-500/10 p-3">
              <div className="text-xs font-semibold text-amber-700 dark:text-amber-300 mb-1">{t('openRisks')}</div>
              <ul className="space-y-1">
                {idea.summary.openRisks.map((r) => (
                  <li key={r} className="text-xs text-amber-800 dark:text-amber-300 leading-5 flex gap-1.5">
                    <span className="mt-1.5 h-1 w-1 shrink-0 rounded-full bg-amber-500" />
                    {r}
                  </li>
                ))}
              </ul>
            </div>
          )}
        </div>
      )}

      {/* Answered log */}
      {answeredQuestions.length > 0 && (
        <Collapsible defaultOpen={false}>
          <CollapsibleTrigger className="flex w-full items-center justify-between rounded-xl border p-3 hover:bg-muted/40 transition-colors">
            <span className="text-sm font-medium">
              {t('answeredLog')} ({answeredQuestions.length})
            </span>
            <ChevronDown className="h-4 w-4 text-muted-foreground" />
          </CollapsibleTrigger>
          <CollapsibleContent>
            <div className="mt-2 max-h-96 overflow-y-auto nice-scroll rounded-xl border p-3 space-y-3" dir="ltr">
              {answeredQuestions.map((q) => (
                <div key={q.id} className="border-b last:border-0 pb-3 last:pb-0">
                  <div className="flex flex-wrap items-center gap-2 mb-1">
                    <Badge variant="outline" className="text-[10px] bg-muted/60">
                      {AREA_LABELS[lang][q.area] ?? q.area}
                    </Badge>
                    <span className="text-[13px] font-medium leading-6">{q.questionEn}</span>
                  </div>
                  <div className="ps-2 border-s-2 border-primary/30 text-[13px] text-foreground/85 leading-6" dir="auto">
                    {q.answer}
                  </div>
                </div>
              ))}
            </div>
          </CollapsibleContent>
        </Collapsible>
      )}

      {answeredQuestions.length === 0 && !current && !locked && (
        <p className="text-center text-sm text-muted-foreground py-4">{t('noQuestionsYet')}</p>
      )}
    </div>
  )
}
