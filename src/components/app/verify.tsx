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
import { Textarea } from '@/components/ui/textarea'
import { Input } from '@/components/ui/input'
import { Badge } from '@/components/ui/badge'
import { useApp } from '@/components/app/context'
import { CodeChip, WorkingPanel } from '@/components/app/bits'
import type { DictKey } from '@/lib/i18n'
import type {
  VerificationCheck,
  VerificationRunItem,
  VerificationRunSummary,
  VerifyCheckKind,
  VerifyStatus,
} from '@/lib/types'
import {
  ChevronDown,
  ClipboardCheck,
  Copy,
  Download,
  FileSearch,
  History,
  Loader2,
  RotateCcw,
  ShieldCheck,
  Trash2,
} from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Traceability Verifier — paste the code your AI builder made,
// get an honest per-requirement verdict matrix with evidence,
// gaps and copy-ready fix prompts. Runs are persisted so
// progress between builds can be compared.
// ============================================================

const STATUS_META: Record<VerifyStatus, { icon: string; key: DictKey; chip: string; bar: string }> = {
  pass: { icon: '✅', key: 'statusPass', chip: 'bg-emerald-50 text-emerald-700 border-emerald-200', bar: 'bg-emerald-500' },
  partial: { icon: '🟡', key: 'statusPartial', chip: 'bg-amber-50 text-amber-700 border-amber-200', bar: 'bg-amber-500' },
  fail: { icon: '❌', key: 'statusFail', chip: 'bg-red-50 text-red-700 border-red-200', bar: 'bg-red-500' },
  unknown: { icon: '⚪', key: 'statusUnknown', chip: 'bg-slate-50 text-slate-600 border-slate-200', bar: 'bg-slate-400' },
}

const KIND_KEYS: Record<VerifyCheckKind, DictKey> = {
  requirement: 'kindRequirement',
  feature: 'kindFeature',
  rule: 'kindRule',
}

function scoreTone(score: number): { text: string; bar: string } {
  if (score >= 80) return { text: 'text-emerald-600', bar: 'bg-emerald-500' }
  if (score >= 50) return { text: 'text-amber-600', bar: 'bg-amber-500' }
  return { text: 'text-red-600', bar: 'bg-red-500' }
}

// Ready-to-paste fix prompt (English scaffold — AI builders
// perform best in English; the check content stays as-is).
function buildFixPrompt(check: VerificationCheck): string {
  if (check.kind === 'rule') {
    return [
      `Constitution rule check "${check.code}" came back ${check.status.toUpperCase()}.`,
      ``,
      `Rule: ${check.title}`,
      check.evidence ? `Evidence in current code: ${check.evidence}` : '',
      check.gap ? `Problem: ${check.gap}` : '',
      check.fix ? `Required fix: ${check.fix}` : '',
      ``,
      `This rule is non-negotiable for this project. Fix it now, following the existing stack and file structure, without breaking existing behavior. When done, list exactly what changed.`,
    ]
      .filter((l) => l !== '')
      .join('\n')
  }
  return [
    `Requirement ${check.code} (${check.priority.toUpperCase()}) — "${check.title}" is ${check.status.toUpperCase()} in the current build.`,
    ``,
    check.gap ? `What is missing: ${check.gap}` : '',
    check.evidence ? `Evidence found so far: ${check.evidence}` : '',
    check.fix ? `Required fix: ${check.fix}` : '',
    ``,
    `Implement exactly this requirement now — follow the existing stack, naming and file structure. Do not refactor unrelated code. When done, list exactly what changed.`,
  ]
    .filter((l) => l !== '')
    .join('\n')
}

function buildReport(run: VerificationRunItem, projectTitle: string, t: (k: DictKey) => string): string {
  const lines: string[] = []
  lines.push(`# ${t('verifierTitle')} — ${projectTitle}`)
  lines.push('')
  lines.push(
    `- ${t('runVerification')}: ${run.label ?? new Date(run.createdAt).toLocaleString()}`
  )
  lines.push(`- ${t('coverageScore')}: **${run.score}%**`)
  lines.push(
    `- ${t('verifiedAgainst')}: ${
      run.result.source === 'requirements' ? t('againstRequirements') : t('againstFeatures')
    } (${run.result.checks.filter((c) => c.kind !== 'rule').length}) + ${t('kindRule')} (${
      run.result.checks.filter((c) => c.kind === 'rule').length
    })`
  )
  lines.push(`- ${run.codeChars.toLocaleString()} ${t('charsPasted')} · ${run.result.checks.length} ${t('checksCount')}`)
  lines.push('')
  if (run.result.summary) {
    lines.push(`## ${t('summaryLabel')}`)
    lines.push('')
    lines.push(run.result.summary)
    lines.push('')
  }
  lines.push(`## ${t('checksTitle')}`)
  lines.push('')
  lines.push(
    `- ${STATUS_META.pass.icon} ${t('statusPass')}: ${run.counts.pass}`
  )
  lines.push(`- ${STATUS_META.partial.icon} ${t('statusPartial')}: ${run.counts.partial}`)
  lines.push(`- ${STATUS_META.fail.icon} ${t('statusFail')}: ${run.counts.fail}`)
  lines.push(`- ${STATUS_META.unknown.icon} ${t('statusUnknown')}: ${run.counts.unknown}`)
  lines.push('')
  for (const c of run.result.checks) {
    const kindLabel = t(KIND_KEYS[c.kind])
    lines.push(`### ${STATUS_META[c.status].icon} ${c.code} — ${c.title}`)
    lines.push('')
    lines.push(`*${kindLabel} · ${c.priority.toUpperCase()} · ${t(STATUS_META[c.status].key)}*`)
    lines.push('')
    if (c.evidence) lines.push(`- **${t('evidenceLabel')}:** ${c.evidence}`)
    if (c.gap) lines.push(`- **${t('gapLabel')}:** ${c.gap}`)
    if (c.fix) lines.push(`- **${t('fixLabel')}:** ${c.fix}`)
    lines.push('')
  }
  if (run.result.strengths.length) {
    lines.push(`## ${t('strengthsLabel')}`)
    lines.push('')
    for (const s of run.result.strengths) lines.push(`- ${s}`)
    lines.push('')
  }
  if (run.result.risks.length) {
    lines.push(`## ${t('risksLabel')}`)
    lines.push('')
    for (const r of run.result.risks) lines.push(`- ${r}`)
    lines.push('')
  }
  return lines.join('\n')
}

function CheckRow({ check }: { check: VerificationCheck }) {
  const { t, lang } = useApp()
  const { toast } = useToast()
  const [open, setOpen] = useState(false)
  const meta = STATUS_META[check.status]

  async function copyFix() {
    await navigator.clipboard.writeText(buildFixPrompt(check))
    toast({ description: t('fixCopied') })
  }

  return (
    <div className={`rounded-lg border ${open ? 'border-primary/40' : 'border-border'} bg-card overflow-hidden`}>
      <button
        type="button"
        onClick={() => setOpen((v) => !v)}
        className="w-full flex items-center gap-2.5 px-3 py-2.5 text-start hover:bg-muted/40 transition-colors"
        aria-expanded={open}
      >
        <span className="text-sm shrink-0" aria-hidden>
          {meta.icon}
        </span>
        <CodeChip code={check.code} className="shrink-0" />
        <span className="text-[13px] font-medium leading-snug flex-1 min-w-0 line-clamp-2" dir="auto">
          {check.title}
        </span>
        <Badge variant="outline" className={`text-[10px] shrink-0 ${meta.chip}`}>
          {t(meta.key)}
        </Badge>
        {check.priority !== 'rule' && (
          <span className="hidden sm:inline text-[10px] font-mono uppercase text-muted-foreground shrink-0" dir="ltr">
            {check.priority}
          </span>
        )}
        <ChevronDown
          className={`h-3.5 w-3.5 shrink-0 text-muted-foreground transition-transform ${open ? 'rotate-180' : ''}`}
        />
      </button>
      {open && (
        <div className="border-t bg-muted/20 px-3 py-2.5 space-y-2">
          <div className="flex items-center gap-1.5 flex-wrap">
            <Badge variant="outline" className="text-[10px]">
              {t(KIND_KEYS[check.kind])}
            </Badge>
            <Badge variant="outline" className={`text-[10px] ${meta.chip}`}>
              {t(meta.key)}
            </Badge>
          </div>
          {check.evidence && (
            <div className="text-xs leading-6" dir="auto">
              <span className="font-semibold text-muted-foreground">{t('evidenceLabel')}: </span>
              {check.evidence}
            </div>
          )}
          {check.gap && (
            <div className="text-xs leading-6" dir="auto">
              <span className="font-semibold text-muted-foreground">{t('gapLabel')}: </span>
              {check.gap}
            </div>
          )}
          {check.fix && (
            <div className="text-xs leading-6" dir="auto">
              <span className="font-semibold text-muted-foreground">{t('fixLabel')}: </span>
              {check.fix}
            </div>
          )}
          {check.status !== 'pass' && (
            <div className="flex justify-end pt-0.5">
              <Button size="sm" variant="outline" onClick={copyFix} className="gap-1.5 h-7 text-[11px]">
                <Copy className="h-3 w-3" />
                {t('copyFixPrompt')}
              </Button>
            </div>
          )}
        </div>
      )}
    </div>
  )
}

function RunResult({ run, projectTitle }: { run: VerificationRunItem; projectTitle: string }) {
  const { t } = useApp()
  const tone = scoreTone(run.score)

  const items = run.result.checks.filter((c) => c.kind !== 'rule')
  const rules = run.result.checks.filter((c) => c.kind === 'rule')
  const musts = items.filter((c) => c.priority === 'must')
  const mustsPass = musts.filter((c) => c.status === 'pass').length

  function download() {
    const md = buildReport(run, projectTitle, t)
    const blob = new Blob([md], { type: 'text/markdown;charset=utf-8' })
    const url = URL.createObjectURL(blob)
    const a = document.createElement('a')
    a.href = url
    a.download = `verification-${run.label ? run.label.replace(/\s+/g, '-').toLowerCase() : run.id}.md`
    document.body.appendChild(a)
    a.click()
    a.remove()
    URL.revokeObjectURL(url)
  }

  return (
    <div className="space-y-3">
      {/* Score header */}
      <div className="rounded-xl border p-3.5 space-y-3">
        <div className="flex items-center gap-3.5">
          <div className={`text-3xl font-bold tabular-nums shrink-0 ${tone.text}`} dir="ltr">
            {run.score}%
          </div>
          <div className="flex-1 min-w-0 space-y-1.5">
            <div className="flex items-center justify-between gap-2">
              <span className="text-[13px] font-semibold">{t('coverageScore')}</span>
              <span className="text-[11px] text-muted-foreground" dir="ltr">
                {run.codeChars.toLocaleString()} {t('charsPasted')} · {run.result.checks.length} {t('checksCount')}
              </span>
            </div>
            <div className="h-2 rounded-full bg-muted overflow-hidden" dir="ltr">
              <div className={`h-full rounded-full transition-all ${tone.bar}`} style={{ width: `${run.score}%` }} />
            </div>
            <div className="flex flex-wrap items-center gap-x-2.5 gap-y-1 text-[11px] text-muted-foreground">
              <span>✅ {run.counts.pass}</span>
              <span>🟡 {run.counts.partial}</span>
              <span>❌ {run.counts.fail}</span>
              <span>⚪ {run.counts.unknown}</span>
              {musts.length > 0 && (
                <span className="font-medium text-foreground" dir="auto">
                  · {mustsPass}/{musts.length} {t('mustCoverage')}
                </span>
              )}
            </div>
          </div>
        </div>
        <div className="flex flex-wrap items-center gap-1.5">
          <span className="text-[11px] text-muted-foreground">{t('verifiedAgainst')}:</span>
          {items.length > 0 && (
            <Badge variant="outline" className="text-[10px] bg-primary/[0.06]">
              {run.result.source === 'requirements' ? t('againstRequirements') : t('againstFeatures')} ·{' '}
              {items.length}
            </Badge>
          )}
          {rules.length > 0 && (
            <Badge variant="outline" className="text-[10px] bg-primary/[0.06]">
              {t('kindRule')} · {rules.length}
            </Badge>
          )}
          {run.label && (
            <Badge variant="outline" className="text-[10px]" dir="auto">
              {run.label}
            </Badge>
          )}
        </div>
      </div>

      {/* Verdict */}
      {run.result.summary && (
        <div className="rounded-xl border border-primary/25 bg-primary/[0.03] p-3 space-y-2">
          <div className="flex items-center gap-1.5 text-[13px] font-semibold">
            <ShieldCheck className="h-3.5 w-3.5 text-primary" />
            {t('summaryLabel')}
          </div>
          <p className="text-xs leading-6" dir="auto">
            {run.result.summary}
          </p>
          {run.result.strengths.length > 0 && (
            <div className="text-xs leading-6" dir="auto">
              <span className="font-semibold">{t('strengthsLabel')}: </span>
              {run.result.strengths.join(' · ')}
            </div>
          )}
          {run.result.risks.length > 0 && (
            <div className="text-xs leading-6 text-red-700 dark:text-red-400" dir="auto">
              <span className="font-semibold">{t('risksLabel')}: </span>
              {run.result.risks.join(' · ')}
            </div>
          )}
        </div>
      )}

      {/* Matrix */}
      {items.length > 0 && (
        <div className="space-y-1.5">
          <div className="text-[13px] font-semibold">{t('checksTitle')}</div>
          <div className="space-y-1.5">
            {items.map((c) => (
              <CheckRow key={c.code} check={c} />
            ))}
          </div>
        </div>
      )}

      {/* Rules */}
      {rules.length > 0 && (
        <div className="space-y-1.5">
          <div className="text-[13px] font-semibold">{t('kindRule')}</div>
          <div className="space-y-1.5">
            {rules.map((c) => (
              <CheckRow key={c.code} check={c} />
            ))}
          </div>
        </div>
      )}

      <div className="flex flex-wrap justify-end gap-1.5 pt-1">
        <Button size="sm" variant="outline" onClick={download} className="gap-1.5">
          <Download className="h-3.5 w-3.5" />
          {t('downloadReport')}
        </Button>
      </div>
    </div>
  )
}

export function VerifyDialog({ open, onOpenChange }: { open: boolean; onOpenChange: (open: boolean) => void }) {
  const { t, lang, selectedId, detail } = useApp()
  const { toast } = useToast()

  const [code, setCode] = useState('')
  const [label, setLabel] = useState('')
  const [verifying, setVerifying] = useState(false)
  const [run, setRun] = useState<VerificationRunItem | null>(null)
  const [runs, setRuns] = useState<VerificationRunSummary[]>([])
  const [loadingRuns, setLoadingRuns] = useState(false)
  const [busyId, setBusyId] = useState<string | null>(null)

  useEffect(() => {
    if (!open || !selectedId) return
    setLoadingRuns(true)
    fetch(`/api/ideas/${selectedId}/verify`)
      .then((r) => r.json())
      .then((d: { runs?: VerificationRunSummary[] }) => {
        if (d.runs) setRuns(d.runs)
      })
      .catch(() => {})
      .finally(() => setLoadingRuns(false))
  }, [open, selectedId])

  const canVerify = useMemo(() => code.trim().length >= 30 && !verifying && !!selectedId, [code, verifying, selectedId])

  function errorText(err: string | undefined): string {
    if (err === 'CODE_TOO_SHORT') return t('codeTooShort')
    if (err === 'NOTHING_TO_VERIFY') return t('verifyNothingToVerify')
    return t('toolsError')
  }

  async function verify() {
    if (!selectedId || !canVerify) return
    setVerifying(true)
    try {
      const res = await fetch(`/api/ideas/${selectedId}/verify`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ code, label, lang }),
      })
      const data = (await res.json()) as { run?: VerificationRunItem; error?: string }
      if (!res.ok || !data.run) {
        toast({ description: errorText(data.error), variant: 'destructive' })
        return
      }
      setRun(data.run)
      setRuns((prev) => [
        { id: data.run!.id, label: data.run!.label, codeChars: data.run!.codeChars, score: data.run!.score, counts: data.run!.counts, createdAt: data.run!.createdAt },
        ...prev,
      ])
      // keep the pasted code for iteration; scroll handled by dialog
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setVerifying(false)
    }
  }

  async function openRun(id: string) {
    if (!selectedId) return
    setBusyId(id)
    try {
      const res = await fetch(`/api/ideas/${selectedId}/verify?runId=${id}`)
      const data = (await res.json()) as { run?: VerificationRunItem; error?: string }
      if (!res.ok || !data.run) {
        toast({ description: t('toolsError'), variant: 'destructive' })
        return
      }
      setRun(data.run)
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusyId(null)
    }
  }

  async function removeRun(id: string) {
    if (!selectedId) return
    setBusyId(id)
    try {
      const res = await fetch(`/api/ideas/${selectedId}/verify?runId=${id}`, { method: 'DELETE' })
      if (!res.ok) {
        toast({ description: t('toolsError'), variant: 'destructive' })
        return
      }
      setRuns((prev) => prev.filter((r) => r.id !== id))
      if (run?.id === id) setRun(null)
      toast({ description: t('runDeleted') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusyId(null)
    }
  }

  return (
    <Dialog open={open} onOpenChange={onOpenChange}>
      <DialogContent className="sm:max-w-3xl max-h-[90vh] overflow-y-auto">
        <DialogHeader>
          <DialogTitle className="flex items-center gap-2">
            <FileSearch className="h-4 w-4 text-primary" />
            {t('verifierTitle')}
          </DialogTitle>
          <DialogDescription>{t('verifierBody')}</DialogDescription>
        </DialogHeader>

        {/* ---------- Paste area ---------- */}
        <div className="space-y-2">
          <Textarea
            value={code}
            onChange={(e) => setCode(e.target.value)}
            placeholder={t('verifierPastePlaceholder')}
            rows={6}
            dir="ltr"
            className="text-[12px] font-mono leading-5"
          />
          <div className="flex flex-wrap items-center gap-2">
            <Input
              value={label}
              onChange={(e) => setLabel(e.target.value)}
              placeholder={t('verifierLabelPlaceholder')}
              aria-label={t('verifierLabel')}
              className="h-8 text-xs flex-1 min-w-40"
              dir="auto"
              maxLength={80}
            />
            <span className="text-[10px] text-muted-foreground tabular-nums" dir="ltr">
              {code.length.toLocaleString()} {t('charsPasted')}
            </span>
            <Button size="sm" onClick={verify} disabled={!canVerify} className="gap-1.5">
              {verifying ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <ClipboardCheck className="h-3.5 w-3.5" />}
              {t('runVerification')}
            </Button>
          </div>
          <p className="text-[10px] text-muted-foreground leading-4">{t('verifyHonestNote')}</p>
        </div>

        {/* ---------- Working ---------- */}
        {verifying && (
          <WorkingPanel steps={[t('verifying1'), t('verifying2'), t('verifying3')]} />
        )}

        {/* ---------- Result ---------- */}
        {run && !verifying && (
          <div className="space-y-3">
            <div className="flex items-center justify-between gap-2">
              <div className="text-sm font-semibold" dir="auto">
                {run.label ?? new Date(run.createdAt).toLocaleString()}
              </div>
              <Button
                size="sm"
                variant="ghost"
                onClick={() => {
                  setRun(null)
                  setCode('')
                  setLabel('')
                }}
                className="gap-1.5 h-7 text-[11px]"
              >
                <RotateCcw className="h-3 w-3" />
                {t('newVerification')}
              </Button>
            </div>
            <RunResult run={run} projectTitle={detail?.idea.title ?? ''} />
          </div>
        )}

        {/* ---------- History ---------- */}
        {runs.length > 0 && (
          <div className="space-y-1.5 pt-1 border-t">
            <div className="flex items-center gap-1.5 text-[11px] font-medium uppercase tracking-wide text-muted-foreground pt-2">
              <History className="h-3.5 w-3.5" />
              {t('verifyHistory')} · {runs.length}
            </div>
            <div className="space-y-1">
              {runs.map((r) => {
                const active = run?.id === r.id
                const tone = scoreTone(r.score)
                return (
                  <div
                    key={r.id}
                    className={`flex items-center gap-2 rounded-lg border px-2.5 py-1.5 ${
                      active ? 'border-primary/40 bg-primary/[0.04]' : 'border-border bg-card'
                    }`}
                  >
                    <button
                      type="button"
                      onClick={() => openRun(r.id)}
                      className="flex flex-1 items-center gap-2 min-w-0 text-start"
                      disabled={busyId === r.id}
                    >
                      {busyId === r.id ? (
                        <Loader2 className="h-3.5 w-3.5 shrink-0 animate-spin text-muted-foreground" />
                      ) : (
                        <span className={`text-xs font-bold tabular-nums shrink-0 ${tone.text}`} dir="ltr">
                          {r.score}%
                        </span>
                      )}
                      <span className="text-[12px] truncate flex-1" dir="auto">
                        {r.label ?? new Date(r.createdAt).toLocaleString()}
                      </span>
                      <span className="hidden sm:flex items-center gap-1.5 text-[10px] text-muted-foreground shrink-0" dir="ltr">
                        <span>✅{r.counts.pass}</span>
                        <span>🟡{r.counts.partial}</span>
                        <span>❌{r.counts.fail}</span>
                        <span>⚪{r.counts.unknown}</span>
                      </span>
                      <span className="text-[10px] text-muted-foreground shrink-0" dir="ltr">
                        {r.codeChars.toLocaleString()}
                      </span>
                    </button>
                    <Button
                      variant="ghost"
                      size="icon"
                      className="h-6 w-6 shrink-0 text-red-600 hover:text-red-700"
                      onClick={() => removeRun(r.id)}
                      disabled={busyId === r.id}
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

        {loadingRuns && runs.length === 0 && (
          <div className="flex items-center justify-center py-4">
            <Loader2 className="h-4 w-4 animate-spin text-muted-foreground" />
          </div>
        )}
        {!loadingRuns && runs.length === 0 && !run && !verifying && (
          <p className="text-center text-[11px] text-muted-foreground py-2">{t('noRuns')}</p>
        )}
      </DialogContent>
    </Dialog>
  )
}
