'use client'

import { useState } from 'react'
import { Button } from '@/components/ui/button'
import { Badge } from '@/components/ui/badge'
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs'
import { useApp } from '@/components/app/context'
import { CodeChip, PriorityBadge, ReviewBadge, WorkingPanel } from '@/components/app/bits'
import type { IdeaDetail, RiskItem } from '@/lib/types'
import { Check, ChevronDown, ChevronUp, ClipboardList, ShieldCheck, X } from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Stage 7 — Engineering planning: dependency-ordered tasks
// (self-contained for a programmer who never saw the client
// conversation) plus the risk register with mitigation
// decisions.
// ============================================================

export function PlanningStage({ detail }: { detail: IdeaDetail }) {
  const { t, setDetail, refreshIdeas } = useApp()
  const { toast } = useToast()
  const { idea, tasks, risks } = detail
  // NO LIMITS: tasks and risks can be generated, reviewed and approved at ANY stage
  const active = true
  const [busy, setBusy] = useState<'tasks' | 'risks' | 'gate' | null>(null)
  const [expanded, setExpanded] = useState<string | null>(null)

  const phases = [...new Set(tasks.map((t2) => t2.phase))].sort((a, b) => a - b)
  const unreviewedTasks = tasks.filter((x) => x.status === 'proposed' || x.status === 'needs_revision')
  const unreviewedRisks = risks.filter((r) => r.status === 'proposed')

  async function generate(kind: 'tasks' | 'risks') {
    setBusy(kind)
    const res = await fetch(`/api/ideas/${idea.id}/plan/generate`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ kind }),
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

  async function passGate() {
    setBusy('gate')
    const res = await fetch(`/api/ideas/${idea.id}/gate`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ gate: 'planning', action: 'approve' }),
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

  const riskTone = (r: RiskItem) =>
    r.impact === 'critical' || (r.impact === 'high' && r.likelihood === 'high')
      ? 'border-red-200 bg-red-50/60'
      : r.impact === 'high' || r.likelihood === 'high'
        ? 'border-amber-200 bg-amber-50/50'
        : ''

  return (
    <div className="space-y-4">
      <p className="text-xs text-muted-foreground leading-6">{t('planningIntro')}</p>

      <Tabs defaultValue="tasks">
        <TabsList className="w-full justify-start overflow-x-auto nice-scroll h-auto p-1">
          <TabsTrigger value="tasks" className="gap-1.5 text-xs">
            <ClipboardList className="h-3.5 w-3.5" />
            {t('tasksTitle')} ({tasks.length})
          </TabsTrigger>
          <TabsTrigger value="risks" className="gap-1.5 text-xs">
            <ShieldCheck className="h-3.5 w-3.5" />
            {t('riskRegister')} ({risks.length})
          </TabsTrigger>
        </TabsList>

        {/* ---------- Tasks ---------- */}
        <TabsContent value="tasks" className="mt-3 space-y-4">
          {active && (
            <div className="flex flex-wrap items-center gap-2">
              {busy === 'tasks' ? (
                <WorkingPanel steps={[t('genTasks1'), t('genTasks2')]} className="flex-1" />
              ) : (
                <>
                  <Button size="sm" onClick={() => generate('tasks')} className="gap-1.5">
                    {tasks.length === 0 ? t('generateTasks') : t('regenerate')}
                  </Button>
                  <span className="text-xs text-muted-foreground">
                    {unreviewedTasks.length} {t('unreviewed')}
                  </span>
                </>
              )}
            </div>
          )}

          {phases.map((phase) => (
            <div key={phase} className="space-y-2">
              <div className="flex items-center gap-2">
                <span className="text-xs font-bold uppercase tracking-wide text-primary">
                  {t('phaseLabel')} {phase}
                </span>
                <span className="h-px flex-1 bg-border" />
                <span className="text-[10px] text-muted-foreground">
                  {tasks.filter((x) => x.phase === phase && x.status === 'confirmed').length}/{tasks.filter((x) => x.phase === phase).length}
                </span>
              </div>
              {tasks
                .filter((x) => x.phase === phase)
                .map((task) => (
                  <div key={task.id} className={`rounded-xl border bg-card p-3 sm:p-4 ${task.status === 'rejected' ? 'opacity-60' : ''}`}>
                    <div className="flex items-start gap-2 flex-wrap">
                      <CodeChip code={task.code} className="mt-0.5" />
                      <div className="flex-1 min-w-[200px]">
                        <div className="text-sm font-medium leading-6" dir="ltr">
                          {task.status === 'rejected' ? <s>{task.title}</s> : task.title}
                          {task.titleAr && <span className="text-muted-foreground font-arabic ms-2" dir="rtl">· {task.titleAr}</span>}
                        </div>
                        <div className="flex flex-wrap items-center gap-1.5 mt-1.5">
                          <PriorityBadge priority={task.priority} />
                          {task.estimate && <Badge variant="outline" className="text-[10px] bg-muted/40">{task.estimate}</Badge>}
                          {task.dependsOn.length > 0 && (
                            <span className="text-[10px] text-muted-foreground">
                              {t('dependsOn')}: {task.dependsOn.map((d) => <CodeChip key={d} code={d} className="ms-0.5" />)}
                            </span>
                          )}
                          {task.requirementCodes.map((c) => (
                            <CodeChip key={c} code={c} className="bg-teal-50 border-teal-200 text-teal-700" />
                          ))}
                        </div>
                      </div>
                      <ReviewBadge status={task.status} />
                    </div>
                    {expanded === task.id && (
                      <div className="mt-3 border-t pt-3 space-y-2" dir="ltr">
                        <p className="text-xs leading-6 text-muted-foreground">{task.description}</p>
                        {task.deliverable && (
                          <p className="text-xs">
                            <span className="font-semibold">{t('deliverableLabel')}: </span>
                            {task.deliverable}
                          </p>
                        )}
                        {task.acceptanceCriteria.length > 0 && (
                          <div>
                            <div className="text-[11px] font-semibold text-muted-foreground mb-1">{t('doneWhen')}</div>
                            <ul className="space-y-0.5">
                              {task.acceptanceCriteria.map((c, i) => (
                                <li key={i} className="text-xs leading-6 flex gap-1.5">
                                  <Check className="h-3.5 w-3.5 text-emerald-600 shrink-0 mt-1" />
                                  {c}
                                </li>
                              ))}
                            </ul>
                          </div>
                        )}
                      </div>
                    )}
                    <button
                      type="button"
                      onClick={() => setExpanded(expanded === task.id ? null : task.id)}
                      className="mt-1 text-[11px] text-primary hover:underline inline-flex items-center gap-1 min-h-9"
                    >
                      {expanded === task.id ? <ChevronUp className="h-3 w-3" /> : <ChevronDown className="h-3 w-3" />}
                      {expanded === task.id ? t('viewLess') : t('viewMore')}
                    </button>
                    {(active || task.status === 'needs_revision') && task.status !== 'rejected' && (
                      <div className="mt-2 flex gap-1.5 border-t pt-2">
                        {task.status !== 'confirmed' && (
                          <Button size="sm" variant="outline" className="gap-1 border-emerald-300 text-emerald-700 hover:bg-emerald-50" onClick={() => review('task', task.id, 'confirmed')}>
                            <Check className="h-3.5 w-3.5" />
                            {t('confirmArtifact')}
                          </Button>
                        )}
                        <Button size="sm" variant="outline" className="gap-1 border-red-200 text-red-600 hover:bg-red-50" onClick={() => review('task', task.id, 'rejected')}>
                          <X className="h-3.5 w-3.5" />
                          {t('rejectArtifact')}
                        </Button>
                      </div>
                    )}
                  </div>
                ))}
            </div>
          ))}
        </TabsContent>

        {/* ---------- Risks ---------- */}
        <TabsContent value="risks" className="mt-3 space-y-3">
          {active && (
            <div className="flex flex-wrap items-center gap-2">
              {busy === 'risks' ? (
                <WorkingPanel steps={[t('genRisks1')]} className="flex-1" />
              ) : (
                <>
                  <Button size="sm" onClick={() => generate('risks')} className="gap-1.5">
                    {risks.length === 0 ? t('generateRisks') : t('regenerate')}
                  </Button>
                  <span className="text-xs text-muted-foreground">
                    {unreviewedRisks.length} {t('unreviewed')}
                  </span>
                </>
              )}
            </div>
          )}
          {risks.map((r) => (
            <div key={r.id} className={`rounded-xl border bg-card p-3 sm:p-4 ${riskTone(r)}`}>
              <div className="flex items-start gap-2 flex-wrap">
                <CodeChip code={r.code} className="mt-0.5" />
                <div className="flex-1 min-w-[200px]">
                  <p className="text-[13px] leading-6" dir="ltr">
                    {r.description}
                  </p>
                  <div className="flex flex-wrap items-center gap-1.5 mt-1.5">
                    <Badge variant="outline" className="text-[10px] bg-muted/40">{r.category}</Badge>
                    <span className="text-[10px] text-muted-foreground">
                      {t('likelihood')}: {r.likelihood} · {t('impactLabel')}: {r.impact}
                    </span>
                    <Badge variant="outline" className={`text-[10px] ${r.basis === 'verified_fact' ? 'bg-teal-50 text-teal-700 border-teal-200' : 'bg-violet-50 text-violet-700 border-violet-200'}`}>
                      {r.basis === 'verified_fact' ? t('basedOnFact') : t('basedOnJudgment')}
                    </Badge>
                  </div>
                  {r.mitigation && (
                    <p className="text-xs text-muted-foreground leading-6 mt-1.5" dir="ltr">
                      <span className="font-semibold">{t('mitigation')}: </span>
                      {r.mitigation}
                    </p>
                  )}
                </div>
                <Badge variant="outline" className={`text-[10px] whitespace-nowrap ${r.status === 'mitigated' ? 'bg-emerald-50 text-emerald-700 border-emerald-200' : r.status === 'accepted' ? 'bg-slate-50 text-slate-600 border-slate-200' : 'bg-amber-50 text-amber-700 border-amber-200'}`}>
                  {r.status === 'mitigated' ? t('statusMitigated') : r.status === 'accepted' ? t('statusAccepted') : t('statusProposed')}
                </Badge>
              </div>
              {active && r.status === 'proposed' && (
                <div className="mt-2 flex gap-1.5 border-t pt-2">
                  <Button size="sm" variant="outline" className="gap-1 border-emerald-300 text-emerald-700 hover:bg-emerald-50" onClick={() => review('risk', r.id, 'mitigated')}>
                    <Check className="h-3.5 w-3.5" />
                    {t('mitigate')}
                  </Button>
                  <Button size="sm" variant="outline" className="gap-1" onClick={() => review('risk', r.id, 'accepted')}>
                    {t('acceptRisk')}
                  </Button>
                </div>
              )}
            </div>
          ))}
        </TabsContent>
      </Tabs>

      {/* Gate */}
      {active && (
        <div className="rounded-xl border border-primary/25 bg-primary/[0.03] p-4">
          <Button className="gap-2" onClick={passGate} disabled={busy !== null}>
            <Check className="h-4 w-4" />
            {t('approvePlanning')}
          </Button>
        </div>
      )}
    </div>
  )
}
