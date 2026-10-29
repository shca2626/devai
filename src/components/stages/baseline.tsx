'use client'

import { Button } from '@/components/ui/button'
import { Badge } from '@/components/ui/badge'
import { Alert, AlertDescription, AlertTitle } from '@/components/ui/alert'
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from '@/components/ui/table'
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs'
import { useApp } from '@/components/app/context'
import {
  AssumptionStatusBadge,
  KindBadge,
  PriorityBadge,
  StatusBadge,
} from '@/components/app/bits'
import type { IdeaDetail } from '@/lib/types'
import { Check, CheckCircle2, FileJson, FileText, History, Lock, ScrollText, Telescope, X } from 'lucide-react'
import ReactMarkdown from 'react-markdown'
import { useToast } from '@/hooks/use-toast'
import { useState } from 'react'

// ============================================================
// Stage 4 — Baseline: the approved P0 blueprint. Export as
// Markdown / JSON, manage the assumption register, review
// the full decision history (the audit trail), and continue
// into the engineering track (requirements → design → plan
// → readiness → package).
// ============================================================

export function BaselineStage({ detail }: { detail: IdeaDetail }) {
  const { t, setDetail, refreshIdeas, setView } = useApp()
  const { toast } = useToast()
  const { idea, features, assumptions, decisions } = detail
  const approved = idea.stage === 'baseline'
  const engineeringStarted = ['requirements', 'design', 'planning', 'readiness', 'package'].includes(idea.stage)
  const [starting, setStarting] = useState(false)

  async function startEngineering() {
    setStarting(true)
    const res = await fetch(`/api/ideas/${idea.id}/gate`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ gate: 'engineering_start', action: 'approve' }),
    })
    const data = await res.json()
    setStarting(false)
    if (!res.ok) {
      toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
      return
    }
    setDetail(data as IdeaDetail)
    refreshIdeas()
    setView('requirements')
  }

  async function setAssumption(id: string, status: 'confirmed' | 'rejected') {
    const res = await fetch(`/api/assumptions/${id}`, {
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

  function exportFile(format: 'md' | 'json') {
    const url = `/api/ideas/${idea.id}/export?format=${format}`
    const a = document.createElement('a')
    a.href = url
    a.rel = 'noopener'
    document.body.appendChild(a)
    a.click()
    a.remove()
  }

  if (!approved && !engineeringStarted) {
    return (
      <div className="rounded-xl border border-dashed p-8 text-center space-y-3">
        <Lock className="h-8 w-8 text-muted-foreground mx-auto" />
        <p className="text-sm text-muted-foreground max-w-sm mx-auto leading-6">{t('lockedBaselineTeaser')}</p>
      </div>
    )
  }

  if (engineeringStarted && !approved) {
    return (
      <div className="space-y-4">
        <Alert className="border-emerald-300 bg-emerald-50/70">
          <CheckCircle2 className="h-4 w-4 text-emerald-600" />
          <AlertTitle className="text-sm font-semibold text-emerald-800">{t('baselineApprovedTitle')}</AlertTitle>
          <AlertDescription className="text-xs text-emerald-700 leading-6">{t('phaseEngineering')} ✓ — {t('startEngineeringBody')}</AlertDescription>
          <div className="mt-3 flex flex-wrap gap-2">
            <Button size="sm" onClick={() => exportFile('md')} className="gap-1.5">
              <FileText className="h-3.5 w-3.5" />
              {t('exportMarkdown')}
            </Button>
            <Button size="sm" variant="outline" onClick={() => exportFile('json')} className="gap-1.5">
              <FileJson className="h-3.5 w-3.5" />
              {t('exportJson')}
            </Button>
          </div>
        </Alert>
      </div>
    )
  }

  const accepted = features.filter((f) => f.status === 'accepted')
  const deferred = features.filter((f) => f.status === 'deferred')
  const openAssumptions = assumptions.filter((a) => a.status === 'open')
  const settledAssumptions = assumptions.filter((a) => a.status !== 'open')

  return (
    <div className="space-y-4">
      {/* P0 exports + engineering track entry */}
      <Alert className="border-emerald-300 bg-emerald-50/70">
        <CheckCircle2 className="h-4 w-4 text-emerald-600" />
        <AlertTitle className="text-sm font-semibold text-emerald-800">{t('baselineApprovedTitle')}</AlertTitle>
        <AlertDescription className="text-xs text-emerald-700 leading-6">{t('baselineApprovedBody')}</AlertDescription>
        <div className="mt-3 flex flex-wrap gap-2">
          <Button size="sm" onClick={() => exportFile('md')} className="gap-1.5">
            <FileText className="h-3.5 w-3.5" />
            {t('exportMarkdown')}
          </Button>
          <Button size="sm" variant="outline" onClick={() => exportFile('json')} className="gap-1.5">
            <FileJson className="h-3.5 w-3.5" />
            {t('exportJson')}
          </Button>
        </div>
        {!engineeringStarted && (
          <div className="mt-4 border-t border-emerald-200 pt-3 space-y-2">
            <p className="text-xs text-emerald-800 leading-6">{t('startEngineeringBody')}</p>
            <Button size="sm" onClick={startEngineering} disabled={starting} className="gap-1.5">
              <Telescope className="h-3.5 w-3.5" />
              {t('startEngineering')}
            </Button>
          </div>
        )}
        {engineeringStarted && (
          <div className="mt-3 border-t border-emerald-200 pt-2 text-[11px] text-emerald-700 flex items-center gap-1.5">
            <CheckCircle2 className="h-3.5 w-3.5" />
            {t('phaseEngineering')} ✓
          </div>
        )}
      </Alert>

      {/* Discovery summary */}
      {idea.summary && (
        <div className="rounded-xl border p-4" dir="ltr">
          <div className="mb-2 text-sm font-semibold">{t('discoverySummaryTitle')}</div>
          <div className="md-body text-sm text-foreground/90">
            <ReactMarkdown>{idea.summary.summaryMarkdown}</ReactMarkdown>
          </div>
        </div>
      )}

      {/* Approved feature table */}
      <div className="rounded-xl border overflow-hidden">
        <div className="border-b bg-muted/50 px-4 py-2.5 text-sm font-semibold">{t('approveBaseline')} ✓</div>
        <div className="overflow-x-auto nice-scroll">
          <Table>
            <TableHeader>
              <TableRow className="bg-muted/30">
                <TableHead className="text-xs">{t('colModule')}</TableHead>
                <TableHead className="text-xs">{t('colFeature')}</TableHead>
                <TableHead className="text-xs">{t('colUser')}</TableHead>
                <TableHead className="text-xs">{t('colPriority')}</TableHead>
                <TableHead className="text-xs">{t('colStatus')}</TableHead>
              </TableRow>
            </TableHeader>
            <TableBody dir="ltr">
              {[...accepted, ...deferred].map((f) => (
                <TableRow key={f.id}>
                  <TableCell className="text-xs font-medium whitespace-nowrap">{f.module}</TableCell>
                  <TableCell className="text-[13px] max-w-[300px]">
                    {f.feature}
                    {f.rationale && <div className="text-[11px] text-muted-foreground mt-0.5">{f.rationale}</div>}
                  </TableCell>
                  <TableCell className="text-xs whitespace-nowrap">{f.user}</TableCell>
                  <TableCell>
                    <PriorityBadge priority={f.priority} />
                  </TableCell>
                  <TableCell>
                    <StatusBadge status={f.status} />
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </div>
      </div>

      {/* Registers */}
      <Tabs defaultValue="assumptions">
        <TabsList className="w-full justify-start overflow-x-auto nice-scroll h-auto p-1">
          <TabsTrigger value="assumptions" className="gap-1.5 text-xs">
            <ScrollText className="h-3.5 w-3.5" />
            {t('assumptionRegister')} ({assumptions.length})
          </TabsTrigger>
          <TabsTrigger value="decisions" className="gap-1.5 text-xs">
            <History className="h-3.5 w-3.5" />
            {t('decisionHistory')} ({decisions.length})
          </TabsTrigger>
        </TabsList>

        {/* Assumption register */}
        <TabsContent value="assumptions" className="space-y-3 mt-2">
          {assumptions.length === 0 && (
            <p className="text-center text-sm text-muted-foreground py-4">{t('noAssumptions')}</p>
          )}
          {openAssumptions.length > 0 && (
            <div className="space-y-2">
              {openAssumptions.map((a) => (
                <div
                  key={a.id}
                  className="flex flex-col sm:flex-row sm:items-center gap-2 rounded-xl border p-3 bg-card"
                >
                  <div className="flex-1 min-w-0">
                    <p className="text-[13px] leading-6" dir="ltr">
                      {a.text}
                    </p>
                    <div className="mt-1 flex items-center gap-1.5">
                      <KindBadge kind={a.kind} />
                      <AssumptionStatusBadge status={a.status} />
                    </div>
                  </div>
                  <div className="flex gap-1.5 shrink-0 self-stretch sm:self-center">
                    <Button
                      size="sm"
                      variant="outline"
                      className="gap-1 flex-1 border-emerald-300 text-emerald-700 hover:bg-emerald-50"
                      onClick={() => setAssumption(a.id, 'confirmed')}
                    >
                      <Check className="h-3.5 w-3.5" />
                      {t('confirm')}
                    </Button>
                    <Button
                      size="sm"
                      variant="outline"
                      className="gap-1 flex-1 border-red-200 text-red-600 hover:bg-red-50"
                      onClick={() => setAssumption(a.id, 'rejected')}
                    >
                      <X className="h-3.5 w-3.5" />
                      {t('delete') === 'حذف' ? 'رفض' : 'Reject'}
                    </Button>
                  </div>
                </div>
              ))}
            </div>
          )}
          {settledAssumptions.length > 0 && (
            <div className="rounded-xl border bg-muted/20 p-3 space-y-2">
              {settledAssumptions.map((a) => (
                <div key={a.id} className="flex items-center gap-2 flex-wrap">
                  <span className={a.status === 'rejected' ? 'line-through text-muted-foreground' : ''} dir="ltr">
                    <span className="text-[13px]">{a.text}</span>
                  </span>
                  <AssumptionStatusBadge status={a.status} />
                </div>
              ))}
            </div>
          )}
        </TabsContent>

        {/* Decision history */}
        <TabsContent value="decisions" className="mt-2">
          <div className="rounded-xl border p-4">
            {decisions.length === 0 ? (
              <p className="text-center text-sm text-muted-foreground py-4">{t('noDecisions')}</p>
            ) : (
              <ol className="relative border-s-2 border-primary/20 ms-3 space-y-4 max-h-96 overflow-y-auto nice-scroll py-1 pe-1">
                {decisions.map((d) => (
                  <li key={d.id} className="ps-4 relative">
                    <span className="absolute -start-[5.5px] top-1.5 h-2.5 w-2.5 rounded-full bg-primary/50 border-2 border-background" />
                    <div className="text-[13px] font-medium leading-5" dir="auto">
                      {d.action}
                    </div>
                    {d.detail && (
                      <div className="text-xs text-muted-foreground leading-5 mt-0.5 line-clamp-2" dir="auto">
                        {d.detail}
                      </div>
                    )}
                    <div className="text-[10px] text-muted-foreground/70 mt-0.5 font-mono">
                      {new Date(d.createdAt).toLocaleString(langLocale())}
                    </div>
                  </li>
                ))}
              </ol>
            )}
          </div>
        </TabsContent>
      </Tabs>
    </div>
  )

  function langLocale(): string {
    return t('loading') === 'Loading…' ? 'en-GB' : 'ar'
  }
}
