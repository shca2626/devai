'use client'

import { useEffect, useMemo, useState } from 'react'
import { Button } from '@/components/ui/button'
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog'
import { Input } from '@/components/ui/input'
import { Badge } from '@/components/ui/badge'
import { useApp } from '@/components/app/context'
import type { DictKey } from '@/lib/i18n'
import type { SiteAnalysisItem, SiteAnalysisSummary } from '@/lib/types'
import {
  ChevronDown,
  Copy,
  Download,
  Eye,
  Globe,
  History,
  Loader2,
  Radar,
  RotateCcw,
  ShieldAlert,
  Trash2,
} from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Site Intelligence — provide a URL, watch seven gated stages
// run (recon → surface → bundles → APIs → models → audit →
// synthesis), get the study pack as downloadable files. Static
// analysis only; the target is never executed.
// ============================================================

const STAGE_KEYS: DictKey[] = [
  'siteStageRecon',
  'siteStageSurface',
  'siteStageBundles',
  'siteStageApis',
  'siteStageModels',
  'siteStageAudit',
  'siteStageSynthesis',
]

function scoreTone(score: number): { text: string; bar: string } {
  if (score >= 70) return { text: 'text-emerald-600 dark:text-emerald-400', bar: 'bg-emerald-500' }
  if (score >= 40) return { text: 'text-amber-600 dark:text-amber-400', bar: 'bg-amber-500' }
  return { text: 'text-red-600 dark:text-red-400', bar: 'bg-red-500' }
}

function buildMarkdownBundle(analysis: SiteAnalysisItem, t: (k: DictKey) => string): string {
  const lines: string[] = []
  lines.push(`# Site study — ${analysis.domain}`)
  lines.push('')
  lines.push(`- Target: ${analysis.url}`)
  lines.push(`- ${t('completenessScore')}: **${analysis.score}%**`)
  lines.push(`- Stages completed: ${analysis.stageDone}/7`)
  lines.push(`- ${t('evidenceTitle')}: ${analysis.data.evidence.length} ${t('evidenceCount')}`)
  lines.push(`- ${t('downloadPackMd')} · ${new Date(analysis.createdAt).toLocaleString()}`)
  lines.push('')
  lines.push('---')
  for (const file of analysis.data.pack) {
    lines.push('')
    lines.push(`<!-- ===== FILE: ${file.name} ===== -->`)
    lines.push('')
    lines.push(file.content)
    lines.push('')
    lines.push('---')
  }
  return lines.join('\n')
}

function downloadFile(filename: string, content: string, mime: string) {
  const blob = new Blob([content], { type: `${mime};charset=utf-8` })
  const url = URL.createObjectURL(blob)
  const a = document.createElement('a')
  a.href = url
  a.download = filename
  document.body.appendChild(a)
  a.click()
  a.remove()
  URL.revokeObjectURL(url)
}

function StageStepper({ analysis, running }: { analysis: SiteAnalysisItem; running: boolean }) {
  const { t } = useApp()
  const failed = analysis.status === 'failed'
  return (
    <div className="space-y-1">
      {STAGE_KEYS.map((key, i) => {
        const done = i < analysis.stageDone
        const isCurrent = i === analysis.stageDone
        const isFailedHere = failed && i === analysis.stageDone
        return (
          <div
            key={key}
            className={`flex items-center gap-2 rounded-lg border px-2.5 py-1.5 ${
              isFailedHere
                ? 'border-red-300 dark:border-red-500/30 bg-red-50/50 dark:bg-red-500/10 dark:border-red-900:border-red-500/30 dark:bg-red-950/20'
                : done
                  ? 'border-emerald-200 dark:border-emerald-500/25 bg-emerald-50/40 dark:bg-emerald-500/10 dark:border-emerald-900:border-emerald-500/30 dark:bg-emerald-950/20'
                  : isCurrent && running
                    ? 'border-primary/40 bg-primary/[0.04]'
                    : 'border-border bg-card'
            }`}
          >
            <span className="w-4 text-center shrink-0" aria-hidden>
              {isFailedHere ? '✕' : done ? '✓' : isCurrent && running ? <Loader2 className="h-3.5 w-3.5 animate-spin text-primary" /> : i + 1}
            </span>
            <span className={`text-[12px] flex-1 ${done ? 'text-foreground' : 'text-muted-foreground'}`}>{t(key)}</span>
            {done && <span className="text-[10px] text-muted-foreground" />}
          </div>
        )
      })}
    </div>
  )
}

function EvidenceLedger({ analysis }: { analysis: SiteAnalysisItem }) {
  const { t } = useApp()
  const [open, setOpen] = useState(false)
  const tone: Record<string, string> = {
    high: 'bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200 dark:border-emerald-500/25',
    medium: 'bg-amber-50 dark:bg-amber-500/10 text-amber-700 dark:text-amber-300 border-amber-200 dark:border-amber-500/25',
    low: 'bg-slate-50 dark:bg-slate-500/10 text-slate-600 dark:text-slate-400 border-slate-200 dark:border-slate-500/25',
  }
  if (analysis.data.evidence.length === 0) return null
  return (
    <div className="rounded-xl border overflow-hidden">
      <button
        type="button"
        onClick={() => setOpen((v) => !v)}
        className="w-full flex items-center gap-2 px-3 py-2.5 text-start hover:bg-muted/40 transition-colors"
        aria-expanded={open}
      >
        <span className="text-[13px] font-semibold flex-1">
          {t('evidenceTitle')} · {analysis.data.evidence.length}
        </span>
        <ChevronDown className={`h-3.5 w-3.5 text-muted-foreground transition-transform ${open ? 'rotate-180' : ''}`} />
      </button>
      {open && (
        <div className="border-t bg-muted/20 px-3 py-2.5 space-y-2 max-h-64 overflow-y-auto">
          {analysis.data.evidence.map((e, i) => (
            <div key={i} className="text-xs leading-6 space-y-0.5">
              <div className="flex items-start gap-1.5">
                <Badge variant="outline" className={`text-[9px] shrink-0 mt-1 ${tone[e.confidence] ?? tone.low}`}>
                  {e.confidence}
                </Badge>
                <span className="flex-1" dir="auto">
                  {e.claim}
                </span>
              </div>
              <div className="text-[10px] text-muted-foreground ps-1" dir="auto">
                {e.method} — {e.source}
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  )
}

function PackViewer({ analysis }: { analysis: SiteAnalysisItem }) {
  const { t } = useApp()
  const { toast } = useToast()
  const [selected, setSelected] = useState<string | null>(null)
  const file = analysis.data.pack.find((f) => f.name === selected) ?? null

  if (analysis.data.pack.length === 0) return null

  async function copy() {
    if (!file) return
    await navigator.clipboard.writeText(file.content)
    toast({ description: t('fileCopied') })
  }

  return (
    <div className="space-y-2">
      <div className="text-[13px] font-semibold">
        {t('packFilesTitle')} · {analysis.data.pack.length}
      </div>
      <div className="flex flex-wrap gap-1.5">
        {analysis.data.pack.map((f) => (
          <button
            key={f.name}
            type="button"
            onClick={() => setSelected(f.name === selected ? null : f.name)}
            className={`inline-flex items-center gap-1 rounded-md border px-2 py-1 text-[11px] font-mono transition-colors ${
              f.name === selected ? 'border-primary/50 bg-primary/10' : 'border-border bg-card hover:bg-muted/50'
            }`}
            dir="ltr"
          >
            <Eye className="h-3 w-3 opacity-60" />
            {f.name}
          </button>
        ))}
      </div>
      {file && (
        <div className="rounded-xl border overflow-hidden">
          <div className="flex items-center justify-between gap-2 border-b bg-muted/40 px-3 py-1.5">
            <span className="text-[11px] font-mono" dir="ltr">
              {file.name}
            </span>
            <Button size="sm" variant="ghost" onClick={copy} className="h-6 gap-1 text-[10px] px-2">
              <Copy className="h-3 w-3" />
              {t('copyFile')}
            </Button>
          </div>
          <pre className="max-h-72 overflow-auto bg-card px-3 py-2.5 text-[11px] leading-5 font-mono whitespace-pre-wrap break-words" dir="auto">
            {file.content}
          </pre>
        </div>
      )}
    </div>
  )
}

function AnalysisResult({ analysis }: { analysis: SiteAnalysisItem }) {
  const { t } = useApp()
  const tone = scoreTone(analysis.score)
  const recon = analysis.data.recon
  const surface = analysis.data.surface
  const bundles = analysis.data.bundles
  const apis = analysis.data.apis
  const models = analysis.data.models

  return (
    <div className="space-y-3">
      {/* Score header */}
      <div className="rounded-xl border p-3.5 space-y-3">
        <div className="flex items-center gap-3.5">
          <div className={`text-3xl font-bold tabular-nums shrink-0 ${tone.text}`} dir="ltr">
            {analysis.score}%
          </div>
          <div className="flex-1 min-w-0 space-y-1.5">
            <div className="flex items-center justify-between gap-2">
              <span className="text-[13px] font-semibold truncate" dir="ltr">
                {analysis.domain}
              </span>
              <span className="text-[11px] text-muted-foreground shrink-0" dir="ltr">
                {analysis.stageDone}/7
              </span>
            </div>
            <div className="h-2 rounded-full bg-muted overflow-hidden" dir="ltr">
              <div className={`h-full rounded-full transition-all ${tone.bar}`} style={{ width: `${analysis.score}%` }} />
            </div>
            <div className="flex flex-wrap items-center gap-x-2.5 gap-y-1 text-[11px] text-muted-foreground">
              <span>
                {surface?.pages.length ?? 0} {t('pagesCrawledLabel')}
              </span>
              <span>
                {bundles?.js.length ?? 0} {t('bundlesLabel')}
              </span>
              <span>
                {apis?.endpoints.length ?? 0} {t('endpointsLabel')}
              </span>
              <span>
                {models?.entities.length ?? 0} {t('entitiesLabel')}
              </span>
              {recon?.blocked && (
                <Badge variant="outline" className="text-[9px] bg-amber-50 dark:bg-amber-500/10 text-amber-700 dark:text-amber-300 border-amber-200">
                  {t('blockedBadge')}
                </Badge>
              )}
            </div>
          </div>
        </div>
        {recon?.title && (
          <div className="text-xs text-muted-foreground leading-6" dir="auto">
            <Globe className="inline h-3 w-3 me-1" />
            {recon.title}
            {bundles ? ` · ${bundles.renderingModel}` : ''}
          </div>
        )}
      </div>

      {/* Failure — honest, with what survived */}
      {analysis.status === 'failed' && (
        <div className="rounded-xl border border-red-200 dark:border-red-500/25 bg-red-50/50 dark:bg-red-500/10 dark:border-red-900:border-red-500/30 dark:bg-red-950/20 p-3 space-y-1.5">
          <div className="flex items-center gap-1.5 text-[13px] font-semibold text-red-700 dark:text-red-300 dark:text-red-400">
            <ShieldAlert className="h-3.5 w-3.5" />
            {t('siteIntelFailedTitle')} — {t('stageFailedAt')} {STAGE_KEYS[Math.min(analysis.stageDone, 6)] && t(STAGE_KEYS[Math.min(analysis.stageDone, 6)])}
          </div>
          {analysis.error && (
            <p className="text-[11px] leading-5 text-red-700/80 dark:text-red-300 dark:text-red-400/80" dir="auto">
              {analysis.error}
            </p>
          )}
        </div>
      )}

      {/* Unknowns — the honesty section */}
      {analysis.data.unknowns.length > 0 && (
        <div className="rounded-xl border border-amber-200 dark:border-amber-500/25 bg-amber-50/40 dark:bg-amber-500/10 dark:border-amber-900:border-amber-500/30 dark:bg-amber-950/20 p-3 space-y-1.5">
          <div className="text-[13px] font-semibold">{t('unknownsTitle')}</div>
          <ul className="text-[11px] leading-6 text-muted-foreground list-disc ps-4" dir="auto">
            {analysis.data.unknowns.slice(0, 10).map((u, i) => (
              <li key={i}>{u}</li>
            ))}
          </ul>
        </div>
      )}

      <PackViewer key={analysis.id} analysis={analysis} />
      <EvidenceLedger analysis={analysis} />
    </div>
  )
}

export function SiteIntelDialog({ open, onOpenChange }: { open: boolean; onOpenChange: (open: boolean) => void }) {
  const { t, lang, selectedId } = useApp()
  const { toast } = useToast()

  const [url, setUrl] = useState('')
  const [running, setRunning] = useState(false)
  const [analysis, setAnalysis] = useState<SiteAnalysisItem | null>(null)
  const [analyses, setAnalyses] = useState<SiteAnalysisSummary[]>([])
  const [loadingList, setLoadingList] = useState(false)
  const [busyId, setBusyId] = useState<string | null>(null)

  useEffect(() => {
    if (!open || !selectedId) return
    setLoadingList(true)
    fetch(`/api/ideas/${selectedId}/site-intel`)
      .then((r) => r.json())
      .then((d: { analyses?: SiteAnalysisSummary[] }) => {
        if (d.analyses) setAnalyses(d.analyses)
      })
      .catch(() => {})
      .finally(() => setLoadingList(false))
  }, [open, selectedId])

  const canStart = useMemo(() => url.trim().length >= 4 && !running && !!selectedId, [url, running, selectedId])

  function errorText(err: string | undefined): string {
    if (err === 'INVALID_URL') return t('invalidUrl')
    if (err === 'UNREACHABLE' || err === 'BLOCKED') return t('unreachableUrl')
    return t('toolsError')
  }

  async function advance(id: string): Promise<SiteAnalysisItem | null> {
    const res = await fetch(`/api/ideas/${selectedId}/site-intel`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ analysisId: id, lang }),
    })
    const data = (await res.json()) as { analysis?: SiteAnalysisItem; error?: string }
    if (!res.ok || !data.analysis) {
      toast({ description: errorText(data.error), variant: 'destructive' })
      return null
    }
    setAnalysis(data.analysis)
    return data.analysis
  }

  async function start() {
    if (!selectedId || !canStart) return
    setRunning(true)
    setAnalysis(null)
    try {
      const res = await fetch(`/api/ideas/${selectedId}/site-intel`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ url, lang }),
      })
      const data = (await res.json()) as { analysis?: SiteAnalysisItem; error?: string }
      if (!res.ok || !data.analysis) {
        toast({ description: errorText(data.error), variant: 'destructive' })
        return
      }
      let current = data.analysis
      setAnalysis(current)
      // Drive stages 2..7 sequentially — the stepper updates live
      while (current.status === 'running' && current.stageDone < 7) {
        const next = await advance(current.id)
        if (!next) break
        current = next
      }
      setAnalyses((prev) => [
        {
          id: current.id,
          url: current.url,
          domain: current.domain,
          status: current.status,
          stageDone: current.stageDone,
          score: current.score,
          pagesCrawled: current.data.surface?.pages.length ?? 0,
          createdAt: current.createdAt,
        },
        ...prev.filter((a) => a.id !== current.id),
      ])
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setRunning(false)
    }
  }

  async function openAnalysis(id: string) {
    if (!selectedId) return
    setBusyId(id)
    try {
      const res = await fetch(`/api/ideas/${selectedId}/site-intel?analysisId=${id}`)
      const data = (await res.json()) as { analysis?: SiteAnalysisItem; error?: string }
      if (!res.ok || !data.analysis) {
        toast({ description: t('toolsError'), variant: 'destructive' })
        return
      }
      setAnalysis(data.analysis)
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusyId(null)
    }
  }

  async function removeAnalysis(id: string) {
    if (!selectedId) return
    setBusyId(id)
    try {
      const res = await fetch(`/api/ideas/${selectedId}/site-intel?analysisId=${id}`, { method: 'DELETE' })
      if (!res.ok) {
        toast({ description: t('toolsError'), variant: 'destructive' })
        return
      }
      setAnalyses((prev) => prev.filter((a) => a.id !== id))
      if (analysis?.id === id) setAnalysis(null)
      toast({ description: t('analysisDeleted') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusyId(null)
    }
  }

  function downloadMd() {
    if (!analysis) return
    downloadFile(`site-study-${analysis.domain.replace(/[^a-z0-9.-]/gi, '-')}.md`, buildMarkdownBundle(analysis, t), 'text/markdown')
  }

  function downloadJson() {
    if (!analysis) return
    const payload = {
      target: analysis.url,
      domain: analysis.domain,
      createdAt: analysis.createdAt,
      completenessScore: analysis.score,
      stagesCompleted: analysis.stageDone,
      evidenceCount: analysis.data.evidence.length,
      files: analysis.data.pack,
    }
    downloadFile(`site-study-${analysis.domain.replace(/[^a-z0-9.-]/gi, '-')}.json`, JSON.stringify(payload, null, 2), 'application/json')
  }

  return (
    <Dialog open={open} onOpenChange={onOpenChange}>
      <DialogContent className="sm:max-w-3xl max-h-[90vh] overflow-y-auto">
        <DialogHeader>
          <DialogTitle className="flex items-center gap-2">
            <Radar className="h-4 w-4 text-primary" />
            {t('siteIntelTitle')}
          </DialogTitle>
          <DialogDescription>{t('siteIntelBody')}</DialogDescription>
        </DialogHeader>

        {/* ---------- URL entry ---------- */}
        <div className="space-y-2">
          <div className="flex flex-wrap items-center gap-2">
            <Input
              value={url}
              onChange={(e) => setUrl(e.target.value)}
              placeholder={t('siteIntelUrlPlaceholder')}
              aria-label={t('siteIntelUrlLabel')}
              className="h-9 text-xs flex-1 min-w-52"
              dir="ltr"
              onKeyDown={(e) => e.key === 'Enter' && start()}
              disabled={running}
              maxLength={300}
            />
            <Button size="sm" onClick={start} disabled={!canStart} className="gap-1.5">
              {running ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <Radar className="h-3.5 w-3.5" />}
              {t('siteIntelStart')}
            </Button>
          </div>
          <p className="text-[10px] text-muted-foreground leading-4">{t('siteIntelNote')}</p>
        </div>

        {/* ---------- Live stepper ---------- */}
        {analysis && (running || analysis.stageDone < 7 || analysis.status !== 'running') && (
          <StageStepper analysis={analysis} running={running} />
        )}
        {running && !analysis && (
          <div className="flex items-center justify-center gap-2 py-4 text-xs text-muted-foreground">
            <Loader2 className="h-4 w-4 animate-spin" />
            {t('siteIntelWorking')}
          </div>
        )}

        {/* ---------- Result ---------- */}
        {analysis && !running && (
          <div className="space-y-3">
            <div className="flex items-center justify-between gap-2">
              <div className="text-sm font-semibold truncate" dir="ltr">
                {analysis.domain}
              </div>
              <Button
                size="sm"
                variant="ghost"
                onClick={() => {
                  setAnalysis(null)
                  setUrl('')
                }}
                className="gap-1.5 h-7 text-[11px]"
              >
                <RotateCcw className="h-3 w-3" />
                {t('newSiteStudy')}
              </Button>
            </div>
            <AnalysisResult analysis={analysis} />
            {analysis.data.pack.length > 0 && (
              <div className="flex flex-wrap justify-end gap-1.5 pt-1">
                <Button size="sm" variant="outline" onClick={downloadMd} className="gap-1.5">
                  <Download className="h-3.5 w-3.5" />
                  {t('downloadPackMd')}
                </Button>
                <Button size="sm" variant="outline" onClick={downloadJson} className="gap-1.5">
                  <Download className="h-3.5 w-3.5" />
                  {t('downloadPackJson')}
                </Button>
              </div>
            )}
          </div>
        )}

        {/* ---------- History ---------- */}
        {analyses.length > 0 && (
          <div className="space-y-1.5 pt-1 border-t">
            <div className="flex items-center gap-1.5 text-[11px] font-medium uppercase tracking-wide text-muted-foreground pt-2">
              <History className="h-3.5 w-3.5" />
              {t('siteIntelHistory')} · {analyses.length}
            </div>
            <div className="space-y-1">
              {analyses.map((a) => {
                const active = analysis?.id === a.id
                const tone = scoreTone(a.score)
                return (
                  <div
                    key={a.id}
                    className={`flex items-center gap-2 rounded-lg border px-2.5 py-1.5 ${
                      active ? 'border-primary/40 bg-primary/[0.04]' : 'border-border bg-card'
                    }`}
                  >
                    <button
                      type="button"
                      onClick={() => openAnalysis(a.id)}
                      className="flex flex-1 items-center gap-2 min-w-0 text-start"
                      disabled={busyId === a.id}
                    >
                      {busyId === a.id ? (
                        <Loader2 className="h-3.5 w-3.5 shrink-0 animate-spin text-muted-foreground" />
                      ) : (
                        <span className={`text-xs font-bold tabular-nums shrink-0 ${tone.text}`} dir="ltr">
                          {a.score}%
                        </span>
                      )}
                      <span className="text-[12px] truncate flex-1" dir="ltr">
                        {a.domain}
                      </span>
                      <span className="hidden sm:inline text-[10px] text-muted-foreground shrink-0" dir="ltr">
                        {a.stageDone}/7 · {a.pagesCrawled} {t('pagesCrawledLabel')}
                        {a.status === 'failed' ? ' · ✕' : a.status === 'complete' ? ' · ✓' : ''}
                      </span>
                      <span className="text-[10px] text-muted-foreground shrink-0">
                        {new Date(a.createdAt).toLocaleDateString()}
                      </span>
                    </button>
                    <Button
                      variant="ghost"
                      size="icon"
                      className="h-6 w-6 shrink-0 text-red-600 dark:text-red-400 hover:text-red-700 dark:hover:text-red-300"
                      onClick={() => removeAnalysis(a.id)}
                      disabled={busyId === a.id}
                      aria-label={t('delete')}
                    >
                      <Trash2 className="h-3 w-3" />
                    </Button>
                  </div>
                )
              })}
            </div>
          </div>
        )}

        {loadingList && analyses.length === 0 && (
          <div className="flex items-center justify-center py-4">
            <Loader2 className="h-4 w-4 animate-spin text-muted-foreground" />
          </div>
        )}
        {!loadingList && analyses.length === 0 && !analysis && !running && (
          <p className="text-center text-[11px] text-muted-foreground py-2">{t('noAnalyses')}</p>
        )}
      </DialogContent>
    </Dialog>
  )
}
