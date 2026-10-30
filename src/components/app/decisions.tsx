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
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs'
import { Textarea } from '@/components/ui/textarea'
import { Input } from '@/components/ui/input'
import { Badge } from '@/components/ui/badge'
import { useApp } from '@/components/app/context'
import { CodeChip, WorkingPanel } from '@/components/app/bits'
import type { DictKey } from '@/lib/i18n'
import type {
  DecisionCategory,
  DecisionEntry,
  DriftCheckItem,
  DriftCheckRunItem,
  DriftCheckSummary,
  DriftStatus,
} from '@/lib/types'
import { DECISION_CATEGORIES } from '@/lib/types'
import {
  Check,
  ChevronDown,
  Copy,
  Download,
  History,
  Loader2,
  Pencil,
  Plus,
  Radar,
  RotateCcw,
  Scale,
  Trash2,
  X,
} from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Decision Log & Drift Detector — the anti-drift pair.
//
// Tab 1 "Log": the project's standing approved decisions
// (stack, data, naming, scope, UX…). What is logged here is
// injected into every Context Pack and becomes the standard
// the drift check holds AI builds against.
//
// Tab 2 "Drift check": paste the code an AI builder produced;
// every active decision gets an honest verdict with the exact
// point of contradiction and a copy-ready realign prompt.
// Checks are persisted so drift between builds is comparable.
// ============================================================

const CATEGORY_KEYS: Record<DecisionCategory, { en: string; ar: string }> = {
  architecture: { en: 'Architecture', ar: 'المعمارية' },
  stack: { en: 'Stack', ar: 'التقنيات' },
  data: { en: 'Data', ar: 'البيانات' },
  api: { en: 'API', ar: 'الواجهات' },
  ux: { en: 'UX', ar: 'التجربة' },
  scope: { en: 'Scope', ar: 'النطاق' },
  naming: { en: 'Naming', ar: 'التسمية' },
  process: { en: 'Process', ar: 'سير العمل' },
}

const DRIFT_META: Record<DriftStatus, { icon: string; key: DictKey; chip: string; bar: string }> = {
  respected: { icon: '✅', key: 'statusRespected', chip: 'bg-emerald-50 text-emerald-700 border-emerald-200', bar: 'bg-emerald-500' },
  partial: { icon: '🟡', key: 'statusPartial', chip: 'bg-amber-50 text-amber-700 border-amber-200', bar: 'bg-amber-500' },
  drift: { icon: '❌', key: 'statusDrift', chip: 'bg-red-50 text-red-700 border-red-200', bar: 'bg-red-500' },
  unknown: { icon: '⚪', key: 'statusUnknown', chip: 'bg-slate-50 text-slate-600 border-slate-200', bar: 'bg-slate-400' },
}

function alignmentTone(score: number): { text: string; bar: string } {
  if (score >= 80) return { text: 'text-emerald-600', bar: 'bg-emerald-500' }
  if (score >= 50) return { text: 'text-amber-600', bar: 'bg-amber-500' }
  return { text: 'text-red-600', bar: 'bg-red-500' }
}

// Ready-to-paste realign prompt (English scaffold — AI builders
// perform best in English; the decision content stays as-is).
function buildRealignPrompt(check: DriftCheckItem, entry?: DecisionEntry): string {
  return [
    `Approved decision ${check.code} ("${check.title}") came back ${check.status.toUpperCase()} in the current build.`,
    ``,
    `Decision: ${entry?.choice ?? check.title}`,
    entry?.alternatives ? `Rejected alternatives (do NOT switch to these): ${entry.alternatives}` : '',
    check.evidence ? `Evidence in current code: ${check.evidence}` : '',
    check.drift ? `Where it drifts: ${check.drift}` : '',
    check.realign ? `Required realignment: ${check.realign}` : '',
    ``,
    `Bring the build back in line with this decision now — follow the existing stack and file structure, do not refactor unrelated code. When done, list exactly what changed.`,
  ]
    .filter((l) => l !== '')
    .join('\n')
}

// ============================================================
// Log tab — rows
// ============================================================

function DecisionRow({
  entry,
  busy,
  onPatch,
  onDelete,
}: {
  entry: DecisionEntry
  busy: boolean
  onPatch: (entry: DecisionEntry, patch: Partial<DecisionEntry>) => void
  onDelete: (entry: DecisionEntry) => void
}) {
  const { t, lang } = useApp()
  const [open, setOpen] = useState(false)
  const [editing, setEditing] = useState(false)
  const [title, setTitle] = useState(entry.title)
  const [choice, setChoice] = useState(entry.choice)
  const [rationale, setRationale] = useState(entry.rationale ?? '')
  const [alternatives, setAlternatives] = useState(entry.alternatives ?? '')
  const retired = entry.status === 'superseded'

  function saveEdit() {
    setEditing(false)
    setOpen(false)
    onPatch(entry, {
      ...entry,
      title: title.trim() || entry.title,
      choice: choice.trim() || entry.choice,
      rationale: rationale.trim() || null,
      alternatives: alternatives.trim() || null,
    })
  }

  return (
    <div
      className={`rounded-lg border p-2.5 space-y-1.5 transition-opacity overflow-hidden ${
        retired ? 'bg-muted/30 opacity-60' : 'bg-card'
      } ${open ? 'border-primary/40' : 'border-border'}`}
    >
      <button
        type="button"
        onClick={() => setOpen((v) => !v)}
        className="w-full flex items-center gap-2.5 text-start hover:bg-muted/40 transition-colors -m-2.5 p-2.5 rounded-lg"
        aria-expanded={open}
      >
        <CodeChip code={entry.code} className="shrink-0" />
        <span className={`text-[13px] font-semibold leading-snug flex-1 min-w-0 line-clamp-1 ${retired ? 'line-through' : ''}`} dir="auto">
          {entry.title}
        </span>
        <Badge variant="outline" className={`text-[10px] shrink-0 ${retired ? 'bg-muted text-muted-foreground' : 'bg-emerald-50 text-emerald-700 border-emerald-200'}`}>
          {t(retired ? 'statusSuperseded' : 'statusActive')}
        </Badge>
        <ChevronDown className={`h-3.5 w-3.5 shrink-0 text-muted-foreground transition-transform ${open ? 'rotate-180' : ''}`} />
      </button>

      {open && !editing && (
        <div className="space-y-2 pt-1">
          <p className="text-[13px] leading-6" dir="auto">
            {entry.choice}
          </p>
          <div className="flex flex-wrap items-center gap-1.5">
            <Badge variant="outline" className="text-[10px]">
              {CATEGORY_KEYS[entry.category][lang === 'ar' ? 'ar' : 'en']}
            </Badge>
          </div>
          {entry.rationale && (
            <div className="text-xs leading-6" dir="auto">
              <span className="font-semibold text-muted-foreground">{t('whyLabel')}: </span>
              {entry.rationale}
            </div>
          )}
          {entry.alternatives && (
            <div className="text-xs leading-6" dir="auto">
              <span className="font-semibold text-muted-foreground">{t('rejectedLabel')}: </span>
              {entry.alternatives}
            </div>
          )}
          <div className="flex flex-wrap justify-end gap-1.5 pt-0.5">
            <Button
              size="sm"
              variant="outline"
              className="gap-1.5 h-7 text-[11px]"
              disabled={busy}
              onClick={() => onPatch(entry, { ...entry, status: retired ? 'active' : 'superseded' })}
            >
              {t(retired ? 'reactivateDecision' : 'retireDecision')}
            </Button>
            <Button size="sm" variant="outline" className="gap-1.5 h-7 text-[11px]" disabled={busy} onClick={() => setEditing(true)}>
              <Pencil className="h-3 w-3" />
              {t('edit')}
            </Button>
            <Button
              size="sm"
              variant="ghost"
              className="gap-1.5 h-7 text-[11px] text-red-600 hover:text-red-700"
              disabled={busy}
              onClick={() => onDelete(entry)}
            >
              <Trash2 className="h-3 w-3" />
              {t('delete')}
            </Button>
          </div>
        </div>
      )}

      {open && editing && (
        <div className="space-y-1.5 pt-1">
          <Input value={title} onChange={(e) => setTitle(e.target.value)} dir="auto" className="h-8 text-xs" maxLength={120} aria-label={t('decisionTitleLabel')} />
          <Textarea value={choice} onChange={(e) => setChoice(e.target.value)} rows={2} dir="auto" className="text-[13px] leading-6" />
          <Input value={rationale} onChange={(e) => setRationale(e.target.value)} dir="auto" className="h-8 text-xs" placeholder={t('decisionRationalePlaceholder')} aria-label={t('decisionRationaleLabel')} />
          <Input value={alternatives} onChange={(e) => setAlternatives(e.target.value)} dir="auto" className="h-8 text-xs" placeholder={t('decisionAlternativesPlaceholder')} aria-label={t('decisionAlternativesLabel')} />
          <div className="flex gap-1.5 justify-end">
            <Button
              size="sm"
              variant="ghost"
              onClick={() => {
                setEditing(false)
                setTitle(entry.title)
                setChoice(entry.choice)
                setRationale(entry.rationale ?? '')
                setAlternatives(entry.alternatives ?? '')
              }}
            >
              <X className="h-3.5 w-3.5" />
            </Button>
            <Button size="sm" onClick={saveEdit} className="gap-1">
              <Check className="h-3.5 w-3.5" />
            </Button>
          </div>
        </div>
      )}
    </div>
  )
}

// ============================================================
// Drift tab — result matrix
// ============================================================

function DriftRow({ check, entries }: { check: DriftCheckItem; entries: DecisionEntry[] }) {
  const { t } = useApp()
  const { toast } = useToast()
  const [open, setOpen] = useState(false)
  const meta = DRIFT_META[check.status]
  const entry = entries.find((e) => e.code === check.code)

  async function copyRealign() {
    await navigator.clipboard.writeText(buildRealignPrompt(check, entry))
    toast({ description: t('realignCopied') })
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
        <ChevronDown className={`h-3.5 w-3.5 shrink-0 text-muted-foreground transition-transform ${open ? 'rotate-180' : ''}`} />
      </button>
      {open && (
        <div className="border-t bg-muted/20 px-3 py-2.5 space-y-2">
          {entry && (
            <div className="text-xs leading-6" dir="auto">
              <span className="font-semibold text-muted-foreground">{t('decisionChoiceLabel')}: </span>
              {entry.choice}
            </div>
          )}
          {check.evidence && (
            <div className="text-xs leading-6" dir="auto">
              <span className="font-semibold text-muted-foreground">{t('evidenceLabel')}: </span>
              {check.evidence}
            </div>
          )}
          {check.drift && (
            <div className="text-xs leading-6 text-red-700 dark:text-red-400" dir="auto">
              <span className="font-semibold">{t('driftPointLabel')}: </span>
              {check.drift}
            </div>
          )}
          {check.realign && (
            <div className="text-xs leading-6" dir="auto">
              <span className="font-semibold text-muted-foreground">{t('realignLabel')}: </span>
              {check.realign}
            </div>
          )}
          {check.status !== 'respected' && (
            <div className="flex justify-end pt-0.5">
              <Button size="sm" variant="outline" onClick={copyRealign} className="gap-1.5 h-7 text-[11px]">
                <Copy className="h-3 w-3" />
                {t('copyRealignPrompt')}
              </Button>
            </div>
          )}
        </div>
      )}
    </div>
  )
}

function buildDriftReport(
  check: DriftCheckRunItem,
  projectTitle: string,
  t: (k: DictKey) => string
): string {
  const lines: string[] = []
  lines.push(`# ${t('decisionsTitle')} — ${projectTitle}`)
  lines.push('')
  lines.push(`- ${t('runDriftCheck')}: ${check.label ?? new Date(check.createdAt).toLocaleString()}`)
  lines.push(`- ${t('alignmentScore')}: **${check.alignment}%**`)
  lines.push(`- ${t('driftCheckedAgainst')}: ${t('againstDecisions')} (${check.result.checks.length} ${t('decisionsCount')})`)
  lines.push(`- ${check.codeChars.toLocaleString()} ${t('charsPasted')}`)
  lines.push('')
  if (check.result.summary) {
    lines.push(`## ${t('summaryLabel')}`)
    lines.push('')
    lines.push(check.result.summary)
    lines.push('')
  }
  lines.push(`## ${t('driftMatrix')}`)
  lines.push('')
  lines.push(`- ✅ ${t('statusRespected')}: ${check.counts.respected}`)
  lines.push(`- 🟡 ${t('statusPartial')}: ${check.counts.partial}`)
  lines.push(`- ❌ ${t('statusDrift')}: ${check.counts.drift}`)
  lines.push(`- ⚪ ${t('statusUnknown')}: ${check.counts.unknown}`)
  lines.push('')
  for (const c of check.result.checks) {
    const meta = DRIFT_META[c.status]
    lines.push(`### ${meta.icon} ${c.code} — ${c.title}`)
    lines.push('')
    lines.push(`*${t('statusDrift') === c.status ? t('statusDrift') : t(meta.key)}*`)
    lines.push('')
    if (c.evidence) lines.push(`- **${t('evidenceLabel')}:** ${c.evidence}`)
    if (c.drift) lines.push(`- **${t('driftPointLabel')}:** ${c.drift}`)
    if (c.realign) lines.push(`- **${t('realignLabel')}:** ${c.realign}`)
    lines.push('')
  }
  if (check.result.violations.length) {
    lines.push(`## ${t('violationsLabel')}`)
    lines.push('')
    for (const v of check.result.violations) lines.push(`- ${v}`)
    lines.push('')
  }
  if (check.result.realignments.length) {
    lines.push(`## ${t('realignmentsLabel')}`)
    lines.push('')
    for (const r of check.result.realignments) lines.push(`- ${r}`)
    lines.push('')
  }
  return lines.join('\n')
}

function DriftResultView({ check, entries, projectTitle }: { check: DriftCheckRunItem; entries: DecisionEntry[]; projectTitle: string }) {
  const { t } = useApp()
  const tone = alignmentTone(check.alignment)

  function download() {
    const md = buildDriftReport(check, projectTitle, t)
    const blob = new Blob([md], { type: 'text/markdown;charset=utf-8' })
    const url = URL.createObjectURL(blob)
    const a = document.createElement('a')
    a.href = url
    a.download = `drift-check-${check.label ? check.label.replace(/\s+/g, '-').toLowerCase() : check.id}.md`
    document.body.appendChild(a)
    a.click()
    a.remove()
    URL.revokeObjectURL(url)
  }

  return (
    <div className="space-y-3">
      {/* Alignment header */}
      <div className="rounded-xl border p-3.5 space-y-3">
        <div className="flex items-center gap-3.5">
          <div className={`text-3xl font-bold tabular-nums shrink-0 ${tone.text}`} dir="ltr">
            {check.alignment}%
          </div>
          <div className="flex-1 min-w-0 space-y-1.5">
            <div className="flex items-center justify-between gap-2">
              <span className="text-[13px] font-semibold">{t('alignmentScore')}</span>
              <span className="text-[11px] text-muted-foreground" dir="ltr">
                {check.codeChars.toLocaleString()} {t('charsPasted')} · {check.result.checks.length} {t('decisionsCount')}
              </span>
            </div>
            <div className="h-2 rounded-full bg-muted overflow-hidden" dir="ltr">
              <div className={`h-full rounded-full transition-all ${tone.bar}`} style={{ width: `${check.alignment}%` }} />
            </div>
            <div className="flex flex-wrap items-center gap-x-2.5 gap-y-1 text-[11px] text-muted-foreground">
              <span>✅ {check.counts.respected}</span>
              <span>🟡 {check.counts.partial}</span>
              <span>❌ {check.counts.drift}</span>
              <span>⚪ {check.counts.unknown}</span>
            </div>
          </div>
        </div>
        <div className="flex flex-wrap items-center gap-1.5">
          <span className="text-[11px] text-muted-foreground">{t('driftCheckedAgainst')}:</span>
          <Badge variant="outline" className="text-[10px] bg-primary/[0.06]">
            {t('againstDecisions')} · {check.result.checks.length}
          </Badge>
          {check.label && (
            <Badge variant="outline" className="text-[10px]" dir="auto">
              {check.label}
            </Badge>
          )}
        </div>
      </div>

      {/* Verdict */}
      {check.result.summary && (
        <div className="rounded-xl border border-primary/25 bg-primary/[0.03] p-3 space-y-2">
          <div className="flex items-center gap-1.5 text-[13px] font-semibold">
            <Radar className="h-3.5 w-3.5 text-primary" />
            {t('summaryLabel')}
          </div>
          <p className="text-xs leading-6" dir="auto">
            {check.result.summary}
          </p>
          {check.result.violations.length > 0 && (
            <div className="text-xs leading-6 text-red-700 dark:text-red-400" dir="auto">
              <span className="font-semibold">{t('violationsLabel')}: </span>
              {check.result.violations.join(' · ')}
            </div>
          )}
          {check.result.realignments.length > 0 && (
            <div className="text-xs leading-6" dir="auto">
              <span className="font-semibold">{t('realignmentsLabel')}: </span>
              {check.result.realignments.join(' · ')}
            </div>
          )}
        </div>
      )}

      {/* Matrix */}
      <div className="space-y-1.5">
        <div className="text-[13px] font-semibold">{t('driftMatrix')}</div>
        <div className="space-y-1.5">
          {check.result.checks.map((c) => (
            <DriftRow key={c.code} check={c} entries={entries} />
          ))}
        </div>
      </div>

      <div className="flex flex-wrap justify-end gap-1.5 pt-1">
        <Button size="sm" variant="outline" onClick={download} className="gap-1.5">
          <Download className="h-3.5 w-3.5" />
          {t('downloadReport')}
        </Button>
      </div>
    </div>
  )
}

// ============================================================
// Dialog
// ============================================================

export function DecisionsDialog({ open, onOpenChange }: { open: boolean; onOpenChange: (open: boolean) => void }) {
  const { t, lang, selectedId, detail } = useApp()
  const { toast } = useToast()

  const [tab, setTab] = useState<'log' | 'drift'>('log')

  // Log state
  const [decisions, setDecisions] = useState<DecisionEntry[]>([])
  const [loading, setLoading] = useState(false)
  const [busy, setBusy] = useState(false)
  const [newTitle, setNewTitle] = useState('')
  const [newChoice, setNewChoice] = useState('')
  const [newRationale, setNewRationale] = useState('')
  const [newAlternatives, setNewAlternatives] = useState('')
  const [newCategory, setNewCategory] = useState<DecisionCategory>('stack')

  // Drift state
  const [code, setCode] = useState('')
  const [label, setLabel] = useState('')
  const [checking, setChecking] = useState(false)
  const [check, setCheck] = useState<DriftCheckRunItem | null>(null)
  const [checks, setChecks] = useState<DriftCheckSummary[]>([])
  const [loadingChecks, setLoadingChecks] = useState(false)
  const [busyId, setBusyId] = useState<string | null>(null)

  const activeEntries = useMemo(() => decisions.filter((d) => d.status === 'active'), [decisions])

  useEffect(() => {
    if (!open || !selectedId) return
    setLoading(true)
    setLoadingChecks(true)
    fetch(`/api/ideas/${selectedId}/decisions`)
      .then((r) => r.json())
      .then((d: { decisions?: DecisionEntry[] }) => {
        if (d.decisions) setDecisions(d.decisions)
      })
      .catch(() => {})
      .finally(() => setLoading(false))
    fetch(`/api/ideas/${selectedId}/drift`)
      .then((r) => r.json())
      .then((d: { checks?: DriftCheckSummary[] }) => {
        if (d.checks) setChecks(d.checks)
      })
      .catch(() => {})
      .finally(() => setLoadingChecks(false))
  }, [open, selectedId])

  // ---------- Log actions ----------

  async function addDecision() {
    if (!selectedId) return
    const title = newTitle.trim()
    const choice = newChoice.trim()
    if (title.length < 2 || choice.length < 3) {
      toast({ description: t('decisionTooShort') })
      return
    }
    setBusy(true)
    try {
      const res = await fetch(`/api/ideas/${selectedId}/decisions`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          title,
          choice,
          rationale: newRationale.trim() || undefined,
          alternatives: newAlternatives.trim() || undefined,
          category: newCategory,
          titleAr: lang === 'ar' ? title : undefined,
        }),
      })
      const data = (await res.json()) as { decision?: DecisionEntry; error?: string }
      if (!res.ok || !data.decision) {
        toast({ description: t('toolsError'), variant: 'destructive' })
        return
      }
      setDecisions((prev) => [...prev, data.decision!])
      setNewTitle('')
      setNewChoice('')
      setNewRationale('')
      setNewAlternatives('')
      toast({ description: t('decisionAdded') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusy(false)
    }
  }

  async function patchDecision(entry: DecisionEntry, patch: Partial<DecisionEntry>) {
    if (!selectedId) return
    setBusy(true)
    try {
      const res = await fetch(`/api/ideas/${selectedId}/decisions/${entry.id}`, {
        method: 'PATCH',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(patch),
      })
      const data = (await res.json()) as { decision?: DecisionEntry; error?: string }
      if (!res.ok || !data.decision) {
        toast({ description: t('toolsError'), variant: 'destructive' })
        return
      }
      setDecisions((prev) => prev.map((d) => (d.id === entry.id ? data.decision! : d)))
      if (patch.status === 'superseded') toast({ description: t('decisionRetired') })
      else if (patch.status === 'active') toast({ description: t('decisionReactivated') })
      else toast({ description: t('decisionUpdated') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusy(false)
    }
  }

  async function removeDecision(entry: DecisionEntry) {
    if (!selectedId) return
    setBusy(true)
    try {
      const res = await fetch(`/api/ideas/${selectedId}/decisions/${entry.id}`, { method: 'DELETE' })
      if (!res.ok) {
        toast({ description: t('toolsError'), variant: 'destructive' })
        return
      }
      setDecisions((prev) => prev.filter((d) => d.id !== entry.id))
      toast({ description: t('decisionDeleted') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusy(false)
    }
  }

  // ---------- Drift actions ----------

  const canCheck = useMemo(
    () => code.trim().length >= 30 && !checking && !!selectedId && activeEntries.length > 0,
    [code, checking, selectedId, activeEntries.length]
  )

  function driftErrorText(err: string | undefined): string {
    if (err === 'CODE_TOO_SHORT') return t('codeTooShort')
    if (err === 'NOTHING_TO_CHECK') return t('driftNothingToCheck')
    return t('toolsError')
  }

  async function runCheck() {
    if (!selectedId || !canCheck) return
    setChecking(true)
    try {
      const res = await fetch(`/api/ideas/${selectedId}/drift`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ code, label, lang }),
      })
      const data = (await res.json()) as { check?: DriftCheckRunItem; error?: string }
      if (!res.ok || !data.check) {
        toast({ description: driftErrorText(data.error), variant: 'destructive' })
        return
      }
      setCheck(data.check)
      setChecks((prev) => [
        {
          id: data.check!.id,
          label: data.check!.label,
          codeChars: data.check!.codeChars,
          drifts: data.check!.drifts,
          alignment: data.check!.alignment,
          counts: data.check!.counts,
          createdAt: data.check!.createdAt,
        },
        ...prev,
      ])
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setChecking(false)
    }
  }

  async function openCheck(id: string) {
    if (!selectedId) return
    setBusyId(id)
    try {
      const res = await fetch(`/api/ideas/${selectedId}/drift?checkId=${id}`)
      const data = (await res.json()) as { check?: DriftCheckRunItem; error?: string }
      if (!res.ok || !data.check) {
        toast({ description: t('toolsError'), variant: 'destructive' })
        return
      }
      setCheck(data.check)
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusyId(null)
    }
  }

  async function removeCheck(id: string) {
    if (!selectedId) return
    setBusyId(id)
    try {
      const res = await fetch(`/api/ideas/${selectedId}/drift?checkId=${id}`, { method: 'DELETE' })
      if (!res.ok) {
        toast({ description: t('toolsError'), variant: 'destructive' })
        return
      }
      setChecks((prev) => prev.filter((c) => c.id !== id))
      if (check?.id === id) setCheck(null)
      toast({ description: t('checkDeleted') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusyId(null)
    }
  }

  const activeList = decisions.filter((d) => d.status === 'active')
  const retiredList = decisions.filter((d) => d.status === 'superseded')

  return (
    <Dialog open={open} onOpenChange={onOpenChange}>
      <DialogContent className="sm:max-w-3xl max-h-[90vh] overflow-y-auto">
        <DialogHeader>
          <DialogTitle className="flex items-center gap-2">
            <Scale className="h-4 w-4 text-primary" />
            {t('decisionsTitle')}
          </DialogTitle>
          <DialogDescription>{t('decisionsBody')}</DialogDescription>
        </DialogHeader>

        <Tabs value={tab} onValueChange={(v) => setTab(v as 'log' | 'drift')}>
          <TabsList className="w-full">
            <TabsTrigger value="log" className="flex-1 gap-1.5">
              {t('tabLog')}
              <Badge variant="secondary" className="text-[10px] px-1.5 py-0">
                {activeEntries.length}
              </Badge>
            </TabsTrigger>
            <TabsTrigger value="drift" className="flex-1 gap-1.5">
              <Radar className="h-3.5 w-3.5" />
              {t('tabDrift')}
            </TabsTrigger>
          </TabsList>

          {/* ==================== Log tab ==================== */}
          <TabsContent value="log" className="space-y-3 pt-3">
            {/* Add form */}
            <div className="rounded-xl border p-3 space-y-2.5">
              <p className="text-xs font-medium text-muted-foreground">{t('addDecisionTitle')}</p>
              <div className="flex flex-wrap gap-1.5">
                {DECISION_CATEGORIES.map((cat) => (
                  <button
                    key={cat}
                    type="button"
                    onClick={() => setNewCategory(cat)}
                    className={`rounded-full border px-2.5 py-1 text-[11px] font-medium transition-colors ${
                      newCategory === cat
                        ? 'border-primary bg-primary/10 text-primary'
                        : 'border-border text-muted-foreground hover:bg-muted/50'
                    }`}
                  >
                    {CATEGORY_KEYS[cat][lang === 'ar' ? 'ar' : 'en']}
                  </button>
                ))}
              </div>
              <div className="grid sm:grid-cols-2 gap-2">
                <Input
                  value={newTitle}
                  onChange={(e) => setNewTitle(e.target.value)}
                  placeholder={t('decisionTitlePlaceholder')}
                  aria-label={t('decisionTitleLabel')}
                  className="h-9 text-xs"
                  dir="auto"
                  maxLength={120}
                />
                <div />
                <div className="sm:col-span-2">
                  <Textarea
                    value={newChoice}
                    onChange={(e) => setNewChoice(e.target.value)}
                    placeholder={t('decisionChoicePlaceholder')}
                    aria-label={t('decisionChoiceLabel')}
                    rows={2}
                    dir="auto"
                    className="text-[13px] leading-6"
                  />
                </div>
                <Input
                  value={newRationale}
                  onChange={(e) => setNewRationale(e.target.value)}
                  placeholder={t('decisionRationalePlaceholder')}
                  aria-label={t('decisionRationaleLabel')}
                  className="h-9 text-xs"
                  dir="auto"
                  maxLength={400}
                />
                <Input
                  value={newAlternatives}
                  onChange={(e) => setNewAlternatives(e.target.value)}
                  placeholder={t('decisionAlternativesPlaceholder')}
                  aria-label={t('decisionAlternativesLabel')}
                  className="h-9 text-xs"
                  dir="auto"
                  maxLength={400}
                />
              </div>
              <div className="flex justify-end">
                <Button size="sm" onClick={addDecision} disabled={busy} className="gap-1.5">
                  <Plus className="h-3.5 w-3.5" />
                  {t('addDecision')}
                </Button>
              </div>
            </div>

            {/* Active */}
            <div className="space-y-2">
              <div className="flex items-center gap-2">
                <p className="text-xs font-semibold">{t('activeDecisions')}</p>
                <Badge variant="outline" className="text-[10px]">
                  {activeList.length}
                </Badge>
              </div>
              {loading && activeList.length === 0 ? (
                <div className="flex items-center justify-center py-4">
                  <Loader2 className="h-4 w-4 animate-spin text-muted-foreground" />
                </div>
              ) : activeList.length === 0 ? (
                <p className="rounded-lg border border-dashed p-3 text-center text-xs leading-6 text-muted-foreground">
                  {t('noDecisionEntries')}
                </p>
              ) : (
                <div className="space-y-1.5">
                  {activeList.map((entry) => (
                    <DecisionRow key={entry.id} entry={entry} busy={busy} onPatch={patchDecision} onDelete={removeDecision} />
                  ))}
                </div>
              )}
            </div>

            {/* Superseded */}
            {retiredList.length > 0 && (
              <div className="space-y-2">
                <div className="flex items-center gap-2">
                  <p className="text-xs font-semibold">{t('supersededDecisions')}</p>
                  <Badge variant="outline" className="text-[10px]">
                    {retiredList.length}
                  </Badge>
                </div>
                <div className="space-y-1.5">
                  {retiredList.map((entry) => (
                    <DecisionRow key={entry.id} entry={entry} busy={busy} onPatch={patchDecision} onDelete={removeDecision} />
                  ))}
                </div>
              </div>
            )}
          </TabsContent>

          {/* ==================== Drift tab ==================== */}
          <TabsContent value="drift" className="space-y-3 pt-3">
            {activeEntries.length === 0 ? (
              <p className="rounded-lg border border-dashed p-3 text-center text-xs leading-6 text-muted-foreground">
                {t('driftNothingToCheck')}
              </p>
            ) : (
              <>
                {/* Paste area */}
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
                    <Button size="sm" onClick={runCheck} disabled={!canCheck} className="gap-1.5">
                      {checking ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <Radar className="h-3.5 w-3.5" />}
                      {t('runDriftCheck')}
                    </Button>
                  </div>
                  <p className="text-[10px] text-muted-foreground leading-4">{t('driftHonestNote')}</p>
                </div>

                {/* Working */}
                {checking && <WorkingPanel steps={[t('drifting1'), t('drifting2'), t('drifting3')]} />}

                {/* Result */}
                {check && !checking && (
                  <div className="space-y-3">
                    <div className="flex items-center justify-between gap-2">
                      <div className="text-sm font-semibold" dir="auto">
                        {check.label ?? new Date(check.createdAt).toLocaleString()}
                      </div>
                      <Button
                        size="sm"
                        variant="ghost"
                        onClick={() => {
                          setCheck(null)
                          setCode('')
                          setLabel('')
                        }}
                        className="gap-1.5 h-7 text-[11px]"
                      >
                        <RotateCcw className="h-3 w-3" />
                        {t('newDriftCheck')}
                      </Button>
                    </div>
                    <DriftResultView check={check} entries={decisions} projectTitle={detail?.idea.title ?? ''} />
                  </div>
                )}

                {/* History */}
                {checks.length > 0 && (
                  <div className="space-y-1.5 pt-1 border-t">
                    <div className="flex items-center gap-1.5 text-[11px] font-medium uppercase tracking-wide text-muted-foreground pt-2">
                      <History className="h-3.5 w-3.5" />
                      {t('verifyHistory')} · {checks.length}
                    </div>
                    <div className="space-y-1">
                      {checks.map((c) => {
                        const active = check?.id === c.id
                        const tone = alignmentTone(c.alignment)
                        return (
                          <div
                            key={c.id}
                            className={`flex items-center gap-2 rounded-lg border px-2.5 py-1.5 ${
                              active ? 'border-primary/40 bg-primary/[0.04]' : 'border-border bg-card'
                            }`}
                          >
                            <button
                              type="button"
                              onClick={() => openCheck(c.id)}
                              className="flex flex-1 items-center gap-2 min-w-0 text-start"
                              disabled={busyId === c.id}
                            >
                              {busyId === c.id ? (
                                <Loader2 className="h-3.5 w-3.5 shrink-0 animate-spin text-muted-foreground" />
                              ) : (
                                <span className={`text-xs font-bold tabular-nums shrink-0 ${tone.text}`} dir="ltr">
                                  {c.alignment}%
                                </span>
                              )}
                              <span className="text-[12px] truncate flex-1" dir="auto">
                                {c.label ?? new Date(c.createdAt).toLocaleString()}
                              </span>
                              <span className="hidden sm:flex items-center gap-1.5 text-[10px] text-muted-foreground shrink-0" dir="ltr">
                                <span>✅{c.counts.respected}</span>
                                <span>🟡{c.counts.partial}</span>
                                <span>❌{c.counts.drift}</span>
                                <span>⚪{c.counts.unknown}</span>
                              </span>
                              <span className="text-[10px] text-muted-foreground shrink-0" dir="ltr">
                                {c.codeChars.toLocaleString()}
                              </span>
                            </button>
                            <Button
                              variant="ghost"
                              size="icon"
                              className="h-6 w-6 shrink-0 text-red-600 hover:text-red-700"
                              onClick={() => removeCheck(c.id)}
                              disabled={busyId === c.id}
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

                {loadingChecks && checks.length === 0 && (
                  <div className="flex items-center justify-center py-4">
                    <Loader2 className="h-4 w-4 animate-spin text-muted-foreground" />
                  </div>
                )}
                {!loadingChecks && checks.length === 0 && !check && !checking && (
                  <p className="text-center text-[11px] text-muted-foreground py-2">{t('noDriftChecks')}</p>
                )}
              </>
            )}
          </TabsContent>
        </Tabs>
      </DialogContent>
    </Dialog>
  )
}
