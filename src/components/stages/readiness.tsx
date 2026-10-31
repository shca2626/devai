'use client'

import { useState } from 'react'
import { Button } from '@/components/ui/button'
import { Badge } from '@/components/ui/badge'
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs'
import { useApp } from '@/components/app/context'
import { CodeChip, SeverityBadge, WorkingPanel } from '@/components/app/bits'
import { QaLab } from '@/components/stages/qa-lab'
import type { IdeaDetail, IssueKind } from '@/lib/types'
import type { DictKey } from '@/lib/i18n'
import { AlertTriangle, Check, CheckCircle2, FlaskConical, Lock, Radar, ShieldCheck, X } from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Stage 8 — Readiness gate: the honest completeness measure.
// Score comes from real coverage checks; locking requires all
// hard blockers cleared. No cosmetic 100%.
// ============================================================

const ISSUE_KEYS: Record<IssueKind, DictKey> = {
  contradiction: 'issueContradiction',
  omission: 'issueOmission',
  duplicate: 'issueDuplicate',
  broken_link: 'issueBrokenLink',
  incomplete: 'issueIncomplete',
  change_impact: 'issueChangeImpact',
}

export function ReadinessStage({ detail }: { detail: IdeaDetail }) {
  const { t, lang, setDetail, refreshIdeas } = useApp()
  const { toast } = useToast()
  const { idea, readiness, issues, requirements, processes, apis, screens, tasks } = detail
  // NO LIMITS: the readiness check and the package lock are available at ANY stage
  const active = true
  const [busy, setBusy] = useState<'check' | 'lock' | null>(null)
  const [showTrace, setShowTrace] = useState(false)
  const [tab, setTab] = useState('gate')

  const openIssues = issues.filter((i) => i.status === 'open')
  const confirmedReqs = requirements.filter((r) => r.status === 'confirmed')

  async function runCheck() {
    setBusy('check')
    const res = await fetch(`/api/ideas/${idea.id}/consistency`, { method: 'POST' })
    const data = await res.json()
    setBusy(null)
    if (!res.ok) {
      toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
      return
    }
    setDetail(data as IdeaDetail)
    refreshIdeas()
  }

  async function resolveIssue(id: string, status: 'resolved' | 'dismissed') {
    const res = await fetch(`/api/artifacts/issue/${id}`, {
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

  async function lock() {
    setBusy('lock')
    const res = await fetch(`/api/ideas/${idea.id}/gate`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ gate: 'package', action: 'approve' }),
    })
    const data = await res.json()
    setBusy(null)
    if (!res.ok) {
      toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
      return
    }
    setDetail(data as IdeaDetail)
    refreshIdeas()
  }

  // readiness is always computed by the API — no locked teaser here.
  if (!readiness) {
    return (
      <div className="rounded-xl border border-dashed p-8 text-center space-y-3">
        <Radar className="h-8 w-8 text-muted-foreground mx-auto" />
        <p className="text-sm text-muted-foreground max-w-sm mx-auto leading-6">{t('readinessIntro')}</p>
      </div>
    )
  }

  const scoreColor = readiness.score >= 90 ? 'text-emerald-600' : readiness.score >= 60 ? 'text-amber-600' : 'text-red-500'

  // Traceability rows
  const traceRows = confirmedReqs.map((r) => ({
    code: r.code,
    title: r.title,
    processes: processes.filter((p) => p.status === 'confirmed' && p.linkedRequirements.includes(r.code)).map((p) => p.code),
    apis: apis.filter((a) => a.status === 'confirmed' && a.linkedRequirements.includes(r.code)).map((a) => a.code),
    screens: screens.filter((s) => s.status === 'confirmed' && s.linkedRequirements.includes(r.code)).map((s) => s.code),
    tasks: tasks.filter((tk) => tk.status === 'confirmed' && tk.requirementCodes.includes(r.code)).map((tk) => tk.code),
  }))

  return (
    <div className="space-y-4">
      <p className="text-xs text-muted-foreground leading-6">{t('readinessIntro')}</p>

      <Tabs value={tab} onValueChange={setTab}>
        <TabsList className="w-full justify-start overflow-x-auto nice-scroll h-auto p-1">
          <TabsTrigger value="gate" className="gap-1.5 text-xs">
            <ShieldCheck className="h-3.5 w-3.5" />
            {t('tabReadinessGate')}
          </TabsTrigger>
          <TabsTrigger value="qa" className="gap-1.5 text-xs">
            <FlaskConical className="h-3.5 w-3.5" />
            {t('tabQaLab')}
          </TabsTrigger>
        </TabsList>

        {/* ---------- Readiness gate ---------- */}
        <TabsContent value="gate" className="mt-3">
          <div className="space-y-4">
      {/* Score card */}
      <div className="rounded-xl border bg-card p-4 sm:p-5">
        <div className="flex items-center gap-4 flex-wrap">
          <div className="flex-1 min-w-[220px]">
            <div className="flex items-baseline gap-2">
              <span className={`text-4xl font-bold tabular-nums ${scoreColor}`}>{readiness.score}</span>
              <span className="text-sm text-muted-foreground">/ 100 · {t('readinessScore')}</span>
            </div>
            <div className="mt-2 h-2 rounded-full overflow-hidden bg-muted">
              <div
                className={`h-full rounded-full transition-all ${readiness.score >= 90 ? 'bg-emerald-500' : readiness.score >= 60 ? 'bg-amber-500' : 'bg-red-400'}`}
                style={{ width: `${readiness.score}%` }}
              />
            </div>
            {readiness.lockable ? (
              <p className="mt-3 text-xs text-emerald-700 font-medium flex items-center gap-1.5">
                <CheckCircle2 className="h-4 w-4" />
                {lang === 'ar' ? 'كل المانعات الصارمة مجتازة — يمكن قفل الحزمة' : 'All hard blockers cleared — the package can be locked'}
              </p>
            ) : (
              <p className="mt-3 text-xs text-amber-700 leading-6">
                {lang === 'ar'
                  ? 'بعض الفحوصات الصارمة لم تُجتز بعد — يمكنك مع ذلك قفل الحزمة (وضع بلا حدود)، وسيُسجَّل الوقت الحالي في سجل القرارات.'
                  : 'Some hard checks are not cleared yet — you can still lock the package (no-limits mode); the current score will be recorded in the decision log.'}
              </p>
            )}
          </div>
          <div className="flex flex-col gap-2">
            {active && (
              <>
                <Button onClick={runCheck} disabled={busy !== null} className="gap-1.5" variant={openIssues.length > 0 ? 'default' : 'outline'}>
                  <Radar className="h-4 w-4" />
                  {t('runConsistency')}
                </Button>
                {/* NO LIMITS: the package can be locked regardless of the score */}
                <Button onClick={lock} disabled={busy !== null} className="gap-1.5">
                  <Lock className="h-4 w-4" />
                  {t('lockPackage')}
                </Button>
              </>
            )}
          </div>
        </div>
        {busy === 'check' && (
          <WorkingPanel steps={[t('runningChecks1'), t('runningChecks2')]} className="mt-4" />
        )}
      </div>

      {/* Metric checklist */}
      <div className="rounded-xl border overflow-hidden">
        <div className="border-b bg-muted/50 px-4 py-2.5 text-sm font-semibold flex items-center gap-2">
          <ShieldCheck className="h-4 w-4 text-primary" />
          {t('readinessScore')} — {readiness.metrics.filter((m) => m.pass).length}/{readiness.metrics.length}
        </div>
        <div className="divide-y">
          {readiness.metrics.map((m) => (
            <div key={m.id} className="flex items-start gap-2.5 px-4 py-2.5">
              <span
                className={`mt-0.5 flex h-4.5 w-4.5 shrink-0 items-center justify-center rounded-full ${
                  m.pass ? 'bg-emerald-100 text-emerald-700' : m.blocker ? 'bg-red-100 text-red-600' : 'bg-amber-100 text-amber-700'
                }`}
              >
                {m.pass ? <Check className="h-3 w-3" /> : <AlertTriangle className="h-3 w-3" />}
              </span>
              <div className="min-w-0">
                <div className="text-[13px] font-medium leading-5">{lang === 'ar' ? m.labelAr : m.label}</div>
                <div className={`text-[11px] leading-5 mt-0.5 ${m.pass ? 'text-muted-foreground' : m.blocker ? 'text-red-600' : 'text-amber-700'}`} dir="auto">
                  {m.detail}
                </div>
              </div>
              {m.blocker && !m.pass && (
                <Badge variant="outline" className="text-[9px] bg-red-50 text-red-600 border-red-200 shrink-0">
                  {t('blockersTitle')}
                </Badge>
              )}
            </div>
          ))}
        </div>
      </div>

      {/* Warnings */}
      {readiness.warnings.length > 0 && (
        <div className="rounded-xl border border-amber-200 bg-amber-50/60 p-4 space-y-1.5">
          <div className="text-xs font-semibold text-amber-800">{t('warningsTitle')}</div>
          {readiness.warnings.map((w, i) => (
            <p key={i} className="text-xs text-amber-800 leading-6">
              ⚠ {w}
            </p>
          ))}
        </div>
      )}

      {/* Consistency issues */}
      <div className="rounded-xl border overflow-hidden">
        <div className="border-b bg-muted/50 px-4 py-2.5 text-sm font-semibold flex items-center gap-2">
          <Radar className="h-4 w-4 text-primary" />
          {t('issuesTitle')} ({openIssues.length})
        </div>
        {issues.length === 0 ? (
          <p className="px-4 py-4 text-sm text-muted-foreground text-center">{t('noIssuesFound')}</p>
        ) : (
          <div className="divide-y">
            {issues.map((i) => (
              <div key={i.id} className={`px-4 py-3 ${i.status !== 'open' ? 'opacity-55' : ''}`}>
                <div className="flex items-start gap-2 flex-wrap">
                  <Badge variant="outline" className="text-[10px] bg-muted/40 shrink-0">
                    {t(ISSUE_KEYS[i.kind] ?? 'issueIncomplete')}
                  </Badge>
                  <SeverityBadge severity={i.severity} />
                  <Badge variant="outline" className="text-[9px] shrink-0 text-muted-foreground">
                    {i.detectedBy === 'ai' ? 'AI' : '⚙'}
                  </Badge>
                  <div className="flex-1 min-w-[180px]">
                    <p className="text-[13px] leading-6" dir="auto">
                      {i.description}
                    </p>
                    {i.affected.length > 0 && (
                      <div className="flex flex-wrap gap-1 mt-1">
                        {i.affected.map((c) => (
                          <CodeChip key={c} code={c} />
                        ))}
                      </div>
                    )}
                    {i.suggestion && <p className="text-[11px] text-muted-foreground leading-5 mt-1">↳ {i.suggestion}</p>}
                  </div>
                  {i.status === 'open' && active && (
                    <div className="flex gap-1.5 shrink-0">
                      <Button size="sm" variant="outline" className="gap-1 border-emerald-300 text-emerald-700 hover:bg-emerald-50 min-h-9" onClick={() => resolveIssue(i.id, 'resolved')}>
                        <Check className="h-3.5 w-3.5" />
                        {t('resolve')}
                      </Button>
                      <Button size="sm" variant="ghost" className="min-h-9" onClick={() => resolveIssue(i.id, 'dismissed')}>
                        <X className="h-3.5 w-3.5" />
                        {t('dismiss')}
                      </Button>
                    </div>
                  )}
                  {i.status !== 'open' && (
                    <Badge variant="outline" className="text-[10px] shrink-0">
                      {i.status === 'resolved' ? t('resolve') : t('statusDismissed')}
                    </Badge>
                  )}
                </div>
              </div>
            ))}
          </div>
        )}
      </div>

      {/* Traceability matrix */}
      <div className="rounded-xl border overflow-hidden">
        <button
          type="button"
          onClick={() => setShowTrace(!showTrace)}
          className="w-full border-b bg-muted/50 px-4 py-2.5 text-sm font-semibold flex items-center gap-2 hover:bg-muted/70 transition-colors"
        >
          <Radar className="h-4 w-4 text-primary" />
          {t('traceabilityTitle')} ({traceRows.length})
        </button>
        {showTrace && (
          <div className="overflow-x-auto nice-scroll">
            <table className="w-full text-xs" dir="ltr">
              <thead>
                <tr className="bg-muted/30 text-muted-foreground border-b">
                  <th className="py-2 px-3 text-start font-medium">Requirement</th>
                  <th className="py-2 px-2 text-start font-medium">PF</th>
                  <th className="py-2 px-2 text-start font-medium">API</th>
                  <th className="py-2 px-2 text-start font-medium">SCR</th>
                  <th className="py-2 px-2 text-start font-medium">T</th>
                </tr>
              </thead>
              <tbody>
                {traceRows.map((row) => (
                  <tr key={row.code} className="border-b last:border-0">
                    <td className="py-2 px-3">
                      <CodeChip code={row.code} />
                      <span className="ms-1.5">{row.title}</span>
                    </td>
                    <td className="py-2 px-2">{row.processes.length ? row.processes.join(', ') : <span className="text-red-400">—</span>}</td>
                    <td className="py-2 px-2">{row.apis.length ? row.apis.join(', ') : <span className="text-red-400">—</span>}</td>
                    <td className="py-2 px-2">{row.screens.length ? row.screens.join(', ') : <span className="text-amber-500">—</span>}</td>
                    <td className="py-2 px-2">{row.tasks.length ? row.tasks.join(', ') : <span className="text-red-400">—</span>}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
          </div>
        </TabsContent>

        {/* ---------- QA Lab (test suite · edge cases · E2E) ---------- */}
        <TabsContent value="qa" className="mt-3">
          <QaLab detail={detail} />
        </TabsContent>
      </Tabs>
    </div>
  )
}
