'use client'

import { useCallback, useEffect, useState } from 'react'
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
import type { AppAnalysisItem, AppAnalysisSummary } from '@/lib/types'
import {
  ChevronDown,
  Copy,
  Download,
  Eye,
  History,
  Loader2,
  RotateCcw,
  Smartphone,
  Trash2,
} from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// App Intelligence — give a Play Store URL or package name,
// watch seven gated stages run (store → acquire original APK
// → deep intel → unpack → decompile → fingerprint → clone
// pack), get the study pack as downloadable files. Static
// analysis only; the binary is never executed.
// ============================================================

const STAGE_KEYS: DictKey[] = [
  'appStageStore',
  'appStageAcquire',
  'appStageDeep',
  'appStageUnpack',
  'appStageDecompile',
  'appStageFingerprint',
  'appStageSynthesis',
]

const SCOPE = '/api/app-intel'

function scoreTone(score: number): { text: string; bar: string } {
  if (score >= 70) return { text: 'text-emerald-600 dark:text-emerald-400', bar: 'bg-emerald-500' }
  if (score >= 40) return { text: 'text-amber-600 dark:text-amber-400', bar: 'bg-amber-500' }
  return { text: 'text-red-600 dark:text-red-400', bar: 'bg-red-500' }
}

function downloadFile(filename: string, content: string, mime: string) {
  const blob = new Blob([content], { type: `${mime};charset=utf-8` })
  const url = URL.createObjectURL(blob)
  const a = document.createElement('a')
  a.href = url
  a.download = filename
  a.click()
  URL.revokeObjectURL(url)
}

function buildMarkdownBundle(analysis: AppAnalysisItem, t: (k: DictKey) => string): string {
  const lines: string[] = []
  lines.push(`# App study — ${analysis.appName ?? analysis.pkg} (${analysis.pkg})`)
  lines.push('')
  lines.push(`- Target: ${analysis.inputUrl}`)
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

function StageStepper({ analysis, running }: { analysis: AppAnalysisItem; running: boolean }) {
  const { t } = useApp()
  const failed = analysis.status === 'failed'
  return (
    <div className="grid grid-cols-2 sm:grid-cols-4 gap-1.5">
      {STAGE_KEYS.map((key, i) => {
        const done = i < analysis.stageDone
        const isCurrent = i === analysis.stageDone
        const isFailedHere = failed && i === analysis.stageDone
        return (
          <div
            key={key}
            className={`flex items-center gap-2 rounded-lg border px-2.5 py-1.5 ${
              isFailedHere
                ? 'border-red-300 dark:border-red-500/30 bg-red-50/50 dark:bg-red-500/10'
                : done
                  ? 'border-emerald-200 dark:border-emerald-500/25 bg-emerald-50/40 dark:bg-emerald-500/10'
                  : isCurrent && running
                    ? 'border-primary/40 bg-primary/[0.04]'
                    : 'border-border bg-card'
            }`}
          >
            <span className="w-4 text-center shrink-0" aria-hidden>
              {isFailedHere ? '✕' : done ? '✓' : isCurrent && running ? <Loader2 className="h-3.5 w-3.5 animate-spin text-primary" /> : i + 1}
            </span>
            <span className={`text-[12px] flex-1 ${done ? 'text-foreground' : 'text-muted-foreground'}`}>{t(key)}</span>
          </div>
        )
      })}
    </div>
  )
}

function EvidenceLedger({ analysis }: { analysis: AppAnalysisItem }) {
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

function PackViewer({ analysis }: { analysis: AppAnalysisItem }) {
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

const ENDPOINT_KIND_TONE: Record<string, string> = {
  'api-base': 'bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200',
  'third-party-api': 'bg-sky-50 dark:bg-sky-500/10 text-sky-700 dark:text-sky-300 border-sky-200',
  'asset-cdn': 'bg-violet-50 dark:bg-violet-500/10 text-violet-700 dark:text-violet-300 border-violet-200',
  'app-site': 'bg-cyan-50 dark:bg-cyan-500/10 text-cyan-700 dark:text-cyan-300 border-cyan-200',
  social: 'bg-pink-50 dark:bg-pink-500/10 text-pink-700 dark:text-pink-300 border-pink-200',
  docs: 'bg-amber-50 dark:bg-amber-500/10 text-amber-700 dark:text-amber-300 border-amber-200',
  'framework-noise': 'bg-muted text-muted-foreground border-border',
  review: 'bg-orange-50 dark:bg-orange-500/10 text-orange-700 dark:text-orange-300 border-orange-200',
}

function EndpointKindBadge({ kind }: { kind: string }) {
  return (
    <Badge variant="outline" className={`text-[9px] px-1.5 shrink-0 ${ENDPOINT_KIND_TONE[kind] ?? ''}`} dir="ltr">
      {kind}
    </Badge>
  )
}

function DeepIntelSection({ analysis }: { analysis: AppAnalysisItem }) {
  const { t } = useApp()
  const cb = analysis.data.codebase
  if (!cb) return null

  return (
    <>
      {/* Classified endpoints — every URL with its purpose */}
      {cb.endpoints.length > 0 && (
        <div className="rounded-xl border overflow-hidden">
          <details>
            <summary className="cursor-pointer px-3 py-2.5 text-[13px] font-semibold hover:bg-muted/40">
              {t('appEndpointsClassified')} · {cb.endpoints.length}
            </summary>
            <div className="border-t bg-muted/20 px-3 py-2 max-h-72 overflow-y-auto space-y-2">
              {cb.endpoints.map((e, i) => (
                <div key={i} className="rounded-lg border bg-card px-2.5 py-2 space-y-1">
                  <div className="flex items-start gap-2">
                    <EndpointKindBadge kind={e.kind} />
                    <span className="text-[11px] font-mono break-all min-w-0 flex-1" dir="ltr">
                      {e.url}
                    </span>
                  </div>
                  <div className="text-[11px] text-muted-foreground leading-5" dir="auto">
                    {e.purpose}
                  </div>
                  <div className="text-[10px] text-muted-foreground/70" dir="ltr">
                    ⌕ {e.evidence}
                  </div>
                </div>
              ))}
            </div>
          </details>
        </div>
      )}

      {/* Sync architecture */}
      <div className="rounded-xl border p-3 space-y-2">
        <div className="text-[13px] font-semibold">{t('appSyncTitle')}</div>
        <p className="text-[12px] leading-6 text-muted-foreground" dir="auto">
          {cb.sync.offlineStrategy}
        </p>
        {cb.sync.signals.length > 0 && (
          <div className="flex flex-wrap gap-1.5 pt-1">
            {cb.sync.signals.slice(0, 10).map((s, i) => (
              <Badge key={i} variant="outline" className="text-[10px]" dir="ltr">
                {s.signal}
              </Badge>
            ))}
          </div>
        )}
      </div>

      {/* Database */}
      <div className="rounded-xl border overflow-hidden">
        <details>
          <summary className="cursor-pointer px-3 py-2.5 text-[13px] font-semibold hover:bg-muted/40">
            {t('appDbTitle')}
            {cb.database.tables.length > 0 ? ` · ${cb.database.tables.length} ${t('appTablesLabel')}` : ''}
          </summary>
          <div className="border-t bg-muted/20 px-3 py-2 space-y-2 max-h-72 overflow-y-auto">
            {cb.database.engines.length > 0 && (
              <div className="flex flex-wrap gap-1.5">
                {cb.database.engines.map((e, i) => (
                  <Badge key={i} variant="outline" className="text-[10px]" dir="auto">
                    {e.name}
                  </Badge>
                ))}
              </div>
            )}
            {cb.database.tables.map((tb, i) => (
              <div key={i} className="rounded-lg border bg-card px-2.5 py-2">
                <div className="text-[12px] font-mono font-semibold" dir="ltr">
                  {tb.name}
                </div>
                <div className="text-[10px] text-muted-foreground font-mono break-all pt-0.5" dir="ltr">
                  {tb.columns.join(', ')}
                </div>
                <div className="text-[10px] text-muted-foreground/70 pt-0.5" dir="auto">
                  {tb.source}
                </div>
              </div>
            ))}
            {cb.database.tables.length === 0 && (
              <div className="text-[11px] text-muted-foreground" dir="auto">
                {t('appNoTables')}
              </div>
            )}
          </div>
        </details>
      </div>

      {/* API surface */}
      <div className="rounded-xl border overflow-hidden">
        <details>
          <summary className="cursor-pointer px-3 py-2.5 text-[13px] font-semibold hover:bg-muted/40">
            {t('appApiTitle')} · {cb.api.paths.length} {t('appPathsLabel')}
          </summary>
          <div className="border-t bg-muted/20 px-3 py-2 space-y-2 max-h-72 overflow-y-auto">
            {cb.api.bases.length > 0 && (
              <div className="space-y-1">
                <div className="text-[10px] font-semibold text-muted-foreground uppercase tracking-wide">{t('appBasesLabel')}</div>
                {cb.api.bases.map((b, i) => (
                  <div key={i} className="text-[11px] font-mono break-all" dir="ltr">
                    {b}
                  </div>
                ))}
              </div>
            )}
            {cb.api.auth.length > 0 && (
              <div className="space-y-1">
                <div className="text-[10px] font-semibold text-muted-foreground uppercase tracking-wide">{t('appAuthLabel')}</div>
                <div className="flex flex-wrap gap-1.5">
                  {cb.api.auth.map((a, i) => (
                    <Badge key={i} variant="outline" className="text-[10px]" dir="auto">
                      {a.method}
                    </Badge>
                  ))}
                </div>
              </div>
            )}
            {cb.api.paths.length > 0 && (
              <div className="space-y-1">
                <div className="text-[10px] font-semibold text-muted-foreground uppercase tracking-wide">{t('appPathsLabel')}</div>
                <div className="flex flex-wrap gap-1">
                  {cb.api.paths.map((p, i) => (
                    <code key={i} className="text-[10px] rounded bg-card border px-1.5 py-0.5" dir="ltr">
                      {p}
                    </code>
                  ))}
                </div>
              </div>
            )}
            {cb.api.screens.length > 0 && (
              <div className="space-y-1">
                <div className="text-[10px] font-semibold text-muted-foreground uppercase tracking-wide">{t('appScreensLabel')}</div>
                <div className="flex flex-wrap gap-1">
                  {cb.api.screens.map((s, i) => (
                    <code key={i} className="text-[10px] rounded bg-card border px-1.5 py-0.5" dir="ltr">
                      {s}
                    </code>
                  ))}
                </div>
              </div>
            )}
          </div>
        </details>
      </div>
    </>
  )
}

function DownloadsRow({ analysis }: { analysis: AppAnalysisItem }) {
  const { t } = useApp()
  const art = analysis.data.artifacts
  const href = (type: string) => `${SCOPE}/${analysis.id}/download?type=${type}`
  return (
    <div className="rounded-xl border p-3 space-y-2">
      <div className="text-[13px] font-semibold">{t('appIntelDownloads')}</div>
      <div className="flex flex-wrap gap-2">
        {(analysis.data.acquire || art?.apkFile) && (
          <a href={href('apk')} className="text-[11px] rounded-lg border px-2.5 py-1.5 hover:bg-muted/40 font-semibold" dir="ltr">
            ⬇ {t('appDlApk')}{art?.apkBytes ? ` (${(art.apkBytes / 1e6).toFixed(1)} MB)` : ''}
          </a>
        )}
        {(analysis.data.decompile?.javaFiles ?? 0) > 0 && (
          <a href={href('source')} className="text-[11px] rounded-lg border px-2.5 py-1.5 hover:bg-muted/40 font-semibold" dir="ltr">
            ⬇ {t('appDlSource')}{art?.sourceFiles ? ` (${art.sourceFiles})` : ''}
          </a>
        )}
        <a href={href('report')} className="text-[11px] rounded-lg border px-2.5 py-1.5 hover:bg-muted/40 font-semibold" dir="ltr">
          ⬇ {t('appDlReport')}
        </a>
        {art?.githubUrl && (
          <a href={art.githubUrl} target="_blank" rel="noreferrer" className="text-[11px] rounded-lg border px-2.5 py-1.5 hover:bg-muted/40 font-semibold" dir="ltr">
            ↗ {t('appGithubFolder')}
          </a>
        )}
      </div>
      {art && (
        <div className="text-[10px] text-muted-foreground" dir="ltr">
          {art.repoFolder}
        </div>
      )}
    </div>
  )
}

function AnalysisResult({ analysis }: { analysis: AppAnalysisItem }) {
  const { t } = useApp()
  const tone = scoreTone(analysis.score)
  const store = analysis.data.store
  const acquire = analysis.data.acquire
  const deep = analysis.data.deep
  const fingerprint = analysis.data.fingerprint
  const decompile = analysis.data.decompile

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
                {analysis.appName ?? analysis.pkg}
              </span>
              <span className="text-[11px] text-muted-foreground shrink-0" dir="ltr">
                {analysis.stageDone}/7
              </span>
            </div>
            <div className="h-2 rounded-full bg-muted overflow-hidden" dir="ltr">
              <div className={`h-full rounded-full transition-all ${tone.bar}`} style={{ width: `${analysis.score}%` }} />
            </div>
            <div className="flex flex-wrap items-center gap-x-2.5 gap-y-1 text-[11px] text-muted-foreground">
              {store?.installs && <span>{store.installs}</span>}
              {store?.score !== undefined && <span dir="ltr">★ {store.score.toFixed(1)}</span>}
              {(acquire?.versionName || store?.version) && (
                <span dir="ltr">
                  {t('versionLabel')}: {acquire?.versionName ?? store?.version}
                </span>
              )}
              {acquire && (
                <Badge
                  variant="outline"
                  className={`text-[9px] ${
                    acquire.originality === 'match'
                      ? 'bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200'
                      : 'bg-amber-50 dark:bg-amber-500/10 text-amber-700 dark:text-amber-300 border-amber-200'
                  }`}
                >
                  {acquire.originality === 'match' ? t('originalityMatch') : t('originalityUnknown')}
                </Badge>
              )}
            </div>
          </div>
        </div>
        {store?.developer && (
          <div className="text-xs text-muted-foreground leading-6" dir="auto">
            {store.developer}
            {store.genre ? ` · ${store.genre}` : ''} · <span dir="ltr">{analysis.pkg}</span>
          </div>
        )}
      </div>

      {/* Downloads — direct APK / sources / report */}
      {(analysis.status === 'complete' || analysis.data.acquire) && <DownloadsRow analysis={analysis} />}

      {/* Tech stack */}
      {fingerprint && fingerprint.stack.length > 0 && (
        <div className="rounded-xl border p-3 space-y-2">
          <div className="text-[13px] font-semibold">{t('appStageFingerprint')}</div>
          <div className="flex flex-wrap gap-1.5">
            {fingerprint.stack.map((s, i) => (
              <Badge key={i} variant="outline" className="text-[10px] gap-1" dir="ltr">
                {s.name}
              </Badge>
            ))}
          </div>
          {fingerprint.featureMap.length > 0 && (
            <div className="flex flex-wrap gap-x-3 gap-y-1 text-[11px] text-muted-foreground pt-1">
              <span className="font-semibold text-foreground">
                {fingerprint.featureMap.length} {t('featuresLabel')}:
              </span>
              {fingerprint.featureMap.slice(0, 14).map((f, i) => (
                <span key={i} dir="auto">
                  {f.feature}
                </span>
              ))}
            </div>
          )}
        </div>
      )}

      {/* Key numbers grid */}
      <div className="grid grid-cols-2 sm:grid-cols-4 gap-2">
        <div className="rounded-xl border px-3 py-2.5 text-center">
          <div className="text-lg font-bold tabular-nums" dir="ltr">{deep?.permissions.length ?? 0}</div>
          <div className="text-[10px] text-muted-foreground">{t('permissionsLabel')}</div>
        </div>
        <div className="rounded-xl border px-3 py-2.5 text-center">
          <div className="text-lg font-bold tabular-nums" dir="ltr">{fingerprint?.featureMap.length ?? 0}</div>
          <div className="text-[10px] text-muted-foreground">{t('featuresLabel')}</div>
        </div>
        <div className="rounded-xl border px-3 py-2.5 text-center">
          <div className="text-lg font-bold tabular-nums" dir="ltr">{decompile?.endpoints.length ?? 0}</div>
          <div className="text-[10px] text-muted-foreground">{t('endpointsFoundLabel')}</div>
        </div>
        <div className="rounded-xl border px-3 py-2.5 text-center">
          <div className="text-lg font-bold tabular-nums" dir="ltr">{decompile?.javaFiles ?? 0}</div>
          <div className="text-[10px] text-muted-foreground">{t('javaFilesLabel')}</div>
        </div>
      </div>

      {/* Permissions */}
      {deep && deep.permissions.length > 0 && (
        <div className="rounded-xl border overflow-hidden">
          <details>
            <summary className="cursor-pointer px-3 py-2.5 text-[13px] font-semibold hover:bg-muted/40">
              {t('permissionsLabel')} · {deep.permissions.length}
            </summary>
            <div className="border-t bg-muted/20 px-3 py-2 max-h-40 overflow-y-auto">
              <div className="flex flex-wrap gap-1">
                {deep.permissions.map((p) => (
                  <code key={p} className="text-[10px] rounded bg-card border px-1.5 py-0.5" dir="ltr">
                    {p}
                  </code>
                ))}
              </div>
            </div>
          </details>
        </div>
      )}

      {/* Endpoints (raw list, pre-deep-analysis) */}
      {!analysis.data.codebase && decompile && decompile.endpoints.length > 0 && (
        <div className="rounded-xl border overflow-hidden">
          <details>
            <summary className="cursor-pointer px-3 py-2.5 text-[13px] font-semibold hover:bg-muted/40">
              {t('endpointsFoundLabel')} · {decompile.endpoints.length}
            </summary>
            <div className="border-t bg-muted/20 px-3 py-2 max-h-48 overflow-y-auto space-y-1">
              {decompile.endpoints.map((u, i) => (
                <div key={i} className="text-[11px] font-mono break-all" dir="ltr">
                  {u}
                </div>
              ))}
            </div>
          </details>
        </div>
      )}

      {/* Deep codebase intel: classified endpoints + sync + database + API */}
      <DeepIntelSection analysis={analysis} />

      {/* Evidence + unknowns */}
      <EvidenceLedger analysis={analysis} />
      {analysis.data.unknowns.length > 0 && (
        <div className="rounded-xl border border-dashed p-3 space-y-1">
          <div className="text-[11px] font-semibold text-muted-foreground uppercase tracking-wide">
            {t('unknownsTitle')} · {analysis.data.unknowns.length}
          </div>
          {analysis.data.unknowns.slice(0, 6).map((u, i) => (
            <div key={i} className="text-[11px] text-muted-foreground leading-5" dir="auto">
              • {u}
            </div>
          ))}
        </div>
      )}
    </div>
  )
}

export function AppIntelDialog({ open, onOpenChange }: { open: boolean; onOpenChange: (v: boolean) => void }) {
  const { t, lang, selectedId } = useApp()
  const { toast } = useToast()
  const [input, setInput] = useState('')
  const [analysis, setAnalysis] = useState<AppAnalysisItem | null>(null)
  const [analyses, setAnalyses] = useState<AppAnalysisSummary[]>([])
  const [running, setRunning] = useState(false)
  const [busyId, setBusyId] = useState<string | null>(null)
  const [loadingList, setLoadingList] = useState(false)

  const canStart = input.trim().length >= 5 && !running

  const refreshList = useCallback(async () => {
    setLoadingList(true)
    try {
      const res = await fetch(SCOPE)
      const data = (await res.json()) as { analyses?: AppAnalysisSummary[] }
      setAnalyses(data.analyses ?? [])
    } catch {
      /* silent */
    } finally {
      setLoadingList(false)
    }
  }, [])

  useEffect(() => {
    if (open) void refreshList()
  }, [open, refreshList])

  function errorText(code?: string): string {
    if (code === 'APP_NOT_FOUND') return t('appNotFound')
    if (code === 'INVALID_INPUT' || code === 'INVALID_URL') return t('invalidAppInput')
    return t('toolsError')
  }

  async function advance(id: string): Promise<AppAnalysisItem | null> {
    try {
      const res = await fetch(SCOPE, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ analysisId: id, lang }),
      })
      const data = (await res.json()) as { analysis?: AppAnalysisItem; error?: string }
      if (!res.ok || !data.analysis) {
        toast({ description: errorText(data.error), variant: 'destructive' })
        return null
      }
      setAnalysis(data.analysis)
      return data.analysis
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
      return null
    }
  }

  async function start() {
    if (!canStart) return
    setRunning(true)
    setAnalysis(null)
    try {
      const res = await fetch(SCOPE, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ input, lang }),
      })
      const data = (await res.json()) as { analysis?: AppAnalysisItem; error?: string }
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
          pkg: current.pkg,
          appName: current.appName,
          status: current.status,
          stageDone: current.stageDone,
          score: current.score,
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
    setBusyId(id)
    try {
      const res = await fetch(`${SCOPE}?analysisId=${id}`)
      const data = (await res.json()) as { analysis?: AppAnalysisItem; error?: string }
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
    setBusyId(id)
    try {
      const res = await fetch(`${SCOPE}?analysisId=${id}`, { method: 'DELETE' })
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
    downloadFile(`app-study-${analysis.pkg.replace(/[^a-z0-9.-]/gi, '-')}.md`, buildMarkdownBundle(analysis, t), 'text/markdown')
  }

  function downloadJson() {
    if (!analysis) return
    const payload = {
      target: analysis.inputUrl,
      pkg: analysis.pkg,
      appName: analysis.appName,
      createdAt: analysis.createdAt,
      completenessScore: analysis.score,
      stagesCompleted: analysis.stageDone,
      evidenceCount: analysis.data.evidence.length,
      files: analysis.data.pack,
    }
    downloadFile(`app-study-${analysis.pkg.replace(/[^a-z0-9.-]/gi, '-')}.json`, JSON.stringify(payload, null, 2), 'application/json')
  }

  return (
    <Dialog open={open} onOpenChange={onOpenChange}>
      <DialogContent className="sm:max-w-3xl max-h-[90vh] overflow-y-auto">
        <DialogHeader>
          <DialogTitle className="flex items-center gap-2">
            <Smartphone className="h-4 w-4 text-primary" />
            {t('appIntelTitle')}
          </DialogTitle>
          <DialogDescription>{t('appIntelBody')}</DialogDescription>
        </DialogHeader>

        {/* Standalone mode notice — public tool, no idea required */}
        {!selectedId && (
          <div className="flex items-start gap-2 rounded-lg border border-primary/25 bg-primary/[0.05] px-3 py-2">
            <Smartphone className="mt-0.5 h-3.5 w-3.5 shrink-0 text-primary" />
            <p className="text-[11px] leading-5 text-muted-foreground">{t('appIntelStandalone')}</p>
          </div>
        )}

        {/* ---------- Input entry ---------- */}
        <div className="space-y-2">
          <div className="flex flex-wrap items-center gap-2">
            <Input
              value={input}
              onChange={(e) => setInput(e.target.value)}
              placeholder={t('appIntelInputPlaceholder')}
              aria-label={t('appIntelInputLabel')}
              className="h-9 text-xs flex-1 min-w-52"
              dir="ltr"
              onKeyDown={(e) => e.key === 'Enter' && start()}
              disabled={running}
              maxLength={300}
            />
            <Button size="sm" onClick={start} disabled={!canStart} className="gap-1.5">
              {running ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <Smartphone className="h-3.5 w-3.5" />}
              {t('appIntelStart')}
            </Button>
          </div>
          <p className="text-[10px] text-muted-foreground leading-4">{t('appIntelNote')}</p>
        </div>

        {/* ---------- Live stepper ---------- */}
        {analysis && (running || analysis.stageDone < 7 || analysis.status !== 'running') && (
          <StageStepper analysis={analysis} running={running} />
        )}
        {running && !analysis && (
          <div className="flex items-center justify-center gap-2 py-4 text-xs text-muted-foreground">
            <Loader2 className="h-4 w-4 animate-spin" />
            {t('appIntelWorking')}
          </div>
        )}
        {running && analysis?.stageDone === 1 && (
          <p className="text-[10px] text-muted-foreground text-center">{t('appIntelAcquireNote')}</p>
        )}

        {/* ---------- Result ---------- */}
        {analysis && !running && (
          <div className="space-y-3">
            <div className="flex items-center justify-between gap-2">
              <div className="text-sm font-semibold truncate" dir="ltr">
                {analysis.appName ?? analysis.pkg}
              </div>
              <Button
                size="sm"
                variant="ghost"
                onClick={() => {
                  setAnalysis(null)
                  setInput('')
                }}
                className="gap-1.5 h-7 text-[11px]"
              >
                <RotateCcw className="h-3 w-3" />
                {t('newAppStudy')}
              </Button>
            </div>
            <AnalysisResult analysis={analysis} />
            {analysis.data.pack.length > 0 && (
              <>
                <PackViewer analysis={analysis} />
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
              </>
            )}
          </div>
        )}

        {/* ---------- History ---------- */}
        {analyses.length > 0 && (
          <div className="space-y-1.5 pt-1 border-t">
            <div className="flex items-center gap-1.5 text-[11px] font-medium uppercase tracking-wide text-muted-foreground pt-2">
              <History className="h-3.5 w-3.5" />
              {t('appIntelHistory')} · {analyses.length}
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
                        {a.appName ?? a.pkg}
                      </span>
                      <span className="hidden sm:inline text-[10px] text-muted-foreground shrink-0" dir="ltr">
                        {a.stageDone}/7
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
          <p className="text-center text-[11px] text-muted-foreground py-2">{t('noAppAnalyses')}</p>
        )}
      </DialogContent>
    </Dialog>
  )
}
