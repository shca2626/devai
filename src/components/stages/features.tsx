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
import {
  AlertDialog,
  AlertDialogAction,
  AlertDialogCancel,
  AlertDialogContent,
  AlertDialogDescription,
  AlertDialogFooter,
  AlertDialogHeader,
  AlertDialogTitle,
} from '@/components/ui/alert-dialog'
import { Input } from '@/components/ui/input'
import { Label } from '@/components/ui/label'
import { Textarea } from '@/components/ui/textarea'
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from '@/components/ui/select'
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from '@/components/ui/table'
import {
  Tooltip,
  TooltipContent,
  TooltipProvider,
  TooltipTrigger,
} from '@/components/ui/tooltip'
import { Alert, AlertDescription, AlertTitle } from '@/components/ui/alert'
import { Badge } from '@/components/ui/badge'
import { useApp } from '@/components/app/context'
import { PriorityBadge, StatusBadge, WorkingPanel } from '@/components/app/bits'
import type { Feature as FeatureType, IdeaDetail, Priority } from '@/lib/types'
import { PRIORITIES } from '@/lib/types'
import { cn } from '@/lib/utils'
import {
  AlertTriangle,
  Check,
  Clock,
  FileWarning,
  GitBranch,
  Pencil,
  Plus,
  Rocket,
  ShieldQuestion,
  Trash2,
  X,
} from 'lucide-react'
import { useEffect, useMemo, useState } from 'react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Stage 3 — Features: AI proposes, the user decides. Nothing is
// "accepted" until explicitly decided. The baseline approval
// gate requires an explicit choice for every unreviewed item.
// ============================================================

export function FeaturesStage({ detail }: { detail: IdeaDetail }) {
  const { t, setDetail, refreshIdeas, setView } = useApp()
  const { toast } = useToast()

  const [busy, setBusy] = useState<null | 'generate'>(null)
  const [statusFilter, setStatusFilter] = useState<string>('all')
  const [approveOpen, setApproveOpen] = useState(false)
  const [unreviewedAction, setUnreviewedAction] = useState<'accept' | 'defer' | 'reject'>('defer')
  const [approveBusy, setApproveBusy] = useState(false)
  const [addOpen, setAddOpen] = useState(false)
  const [editFeature, setEditFeature] = useState<FeatureType | null>(null)
  const [confirmRemove, setConfirmRemove] = useState<FeatureType | null>(null)

  const { idea, features } = detail
  // NO LIMITS: features can be added, edited, decided and deleted at ANY stage.
  const inStage = true

  const counts = useMemo(
    () => ({
      accepted: features.filter((f) => f.status === 'accepted').length,
      deferred: features.filter((f) => f.status === 'deferred').length,
      rejected: features.filter((f) => f.status === 'rejected').length,
      unreviewed: features.filter((f) => f.status === 'proposed' || f.status === 'needs_confirmation').length,
    }),
    [features]
  )

  const visible = useMemo(
    () =>
      statusFilter === 'all'
        ? features.filter((f) => f.status !== 'rejected')
        : features.filter((f) => f.status === statusFilter),
    [features, statusFilter]
  )

  async function generate() {
    setBusy('generate')
    try {
      const res = await fetch(`/api/ideas/${idea.id}/features/generate`, { method: 'POST' })
      const data = await res.json()
      if (!res.ok) {
        toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
        return
      }
      setDetail(data as IdeaDetail)
      refreshIdeas()
    } catch {
      toast({ description: t('aiError'), variant: 'destructive' })
    } finally {
      setBusy(null)
    }
  }

  async function patchFeature(id: string, updates: Record<string, unknown>) {
    const res = await fetch(`/api/features/${id}`, {
      method: 'PATCH',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(updates),
    })
    const data = await res.json()
    if (!res.ok) {
      toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
      return
    }
    setDetail(data as IdeaDetail)
    refreshIdeas()
  }

  async function removeFeature(id: string) {
    const res = await fetch(`/api/features/${id}`, { method: 'DELETE' })
    const data = await res.json()
    if (!res.ok) {
      toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
      return
    }
    setDetail(data as IdeaDetail)
    refreshIdeas()
  }

  async function approveBaseline() {
    setApproveBusy(true)
    try {
      const res = await fetch(`/api/ideas/${idea.id}/gate`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ gate: 'baseline', action: 'approve', unreviewedAction }),
      })
      const data = await res.json()
      if (!res.ok) {
        toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
        return
      }
      setDetail(data as IdeaDetail)
      refreshIdeas()
      setApproveOpen(false)
      setView('baseline')
    } catch {
      toast({ description: t('aiError'), variant: 'destructive' })
    } finally {
      setApproveBusy(false)
    }
  }

  // Not generated yet — CTA
  if (features.length === 0) {
    return (
      <div className="space-y-4">
        {busy === 'generate' ? (
          <WorkingPanel steps={[t('generatingFeatures1'), t('generatingFeatures2'), t('generatingFeatures3')]} />
        ) : (
          <div className="rounded-xl sm:rounded-2xl border border-dashed p-6 sm:p-8 text-center space-y-3">
            <Rocket className="h-8 w-8 text-primary mx-auto" />
            <p className="text-sm text-muted-foreground max-w-md mx-auto leading-6">{t('stepFeaturesDesc')}</p>
            <Button onClick={generate} size="lg" className="gap-1.5">
              <SparklesIcon />
              {t('generateFeatures')}
            </Button>
          </div>
        )}
      </div>
    )
  }

  return (
    <TooltipProvider delayDuration={200}>
      <div className="space-y-4">
        {/* Meta panels */}
        {idea.featuresMeta && (idea.featuresMeta.missingFeatures.length > 0 || idea.featuresMeta.dependencies.length > 0) && (
          <div className="grid gap-3 md:grid-cols-2">
            {idea.featuresMeta.missingFeatures.length > 0 && (
              <Alert className="border-amber-200 dark:border-amber-500/25 bg-amber-50/50 dark:bg-amber-500/10">
                <FileWarning className="h-4 w-4 text-amber-600 dark:text-amber-400" />
                <AlertTitle className="text-sm">{t('missingFeaturesTitle')}</AlertTitle>
                <AlertDescription>
                  <ul className="mt-1 space-y-1" dir="ltr">
                    {idea.featuresMeta.missingFeatures.map((m) => (
                      <li key={m} className="text-xs leading-5 text-amber-800 dark:text-amber-300 flex gap-1.5">
                        <span className="mt-1.5 h-1 w-1 shrink-0 rounded-full bg-amber-500" />
                        {m}
                      </li>
                    ))}
                  </ul>
                </AlertDescription>
              </Alert>
            )}
            {idea.featuresMeta.dependencies.length > 0 && (
              <Alert className="border-sky-200 dark:border-sky-500/25 bg-sky-50/50 dark:bg-sky-500/10">
                <GitBranch className="h-4 w-4 text-sky-600 dark:text-sky-400" />
                <AlertTitle className="text-sm">{t('dependenciesTitle')}</AlertTitle>
                <AlertDescription>
                  <ul className="mt-1 space-y-1" dir="ltr">
                    {idea.featuresMeta.dependencies.map((d) => (
                      <li key={d} className="text-xs leading-5 text-sky-800 dark:text-sky-300 flex gap-1.5">
                        <span className="mt-1.5 h-1 w-1 shrink-0 rounded-full bg-sky-500" />
                        {d}
                      </li>
                    ))}
                  </ul>
                </AlertDescription>
              </Alert>
            )}
          </div>
        )}
        {idea.featuresMeta?.releaseNote && (
          <div className="rounded-xl border bg-muted/30 p-3" dir="ltr">
            <div className="text-xs font-semibold text-muted-foreground mb-1">{t('releaseNoteTitle')}</div>
            <p className="text-[13px] leading-6 text-foreground/85">{idea.featuresMeta.releaseNote}</p>
          </div>
        )}

        {/* Toolbar */}
        <div className="flex flex-wrap items-center gap-2">
          <Select value={statusFilter} onValueChange={setStatusFilter}>
            <SelectTrigger className="w-[160px] h-9 text-xs" aria-label={t('colStatus')}>
              <SelectValue />
            </SelectTrigger>
            <SelectContent>
              <SelectItem value="all">{t('filterAll')}</SelectItem>
              <SelectItem value="accepted">{t('statusAccepted')}</SelectItem>
              <SelectItem value="needs_confirmation">{t('statusNeedsConfirmation')}</SelectItem>
              <SelectItem value="proposed">{t('statusProposed')}</SelectItem>
              <SelectItem value="deferred">{t('statusDeferred')}</SelectItem>
              <SelectItem value="rejected">{t('statusRejected')}</SelectItem>
            </SelectContent>
          </Select>
          {inStage && (
            <Button variant="outline" size="sm" className="gap-1.5" onClick={() => setAddOpen(true)}>
              <Plus className="h-3.5 w-3.5" />
              {t('addFeature')}
            </Button>
          )}
          <div className="ms-auto flex flex-wrap items-center gap-1.5 text-[11px]">
            <Badge variant="outline" className="bg-emerald-50 text-emerald-700 dark:text-emerald-300 border-emerald-200">
              {counts.accepted} {t('countsAccepted')}
            </Badge>
            <Badge variant="outline" className="bg-sky-50 text-sky-700 dark:text-sky-300 border-sky-200">
              {counts.deferred} {t('countsDeferred')}
            </Badge>
            <Badge variant="outline" className="bg-red-50 text-red-600 dark:text-red-400 border-red-200">
              {counts.rejected} {t('countsRejected')}
            </Badge>
            {counts.unreviewed > 0 && (
              <Badge variant="outline" className="bg-amber-50 text-amber-700 dark:text-amber-300 border-amber-200 dark:border-amber-500/25 gap-1">
                <AlertTriangle className="h-3 w-3" />
                {counts.unreviewed} {t('countsUnreviewed')}
              </Badge>
            )}
          </div>
        </div>

        {/* Feature table */}
        <div className="rounded-xl border overflow-hidden">
          <div className="overflow-x-auto nice-scroll">
            <Table>
              <TableHeader>
                <TableRow className="bg-muted/50">
                  <TableHead className="text-xs">{t('colModule')}</TableHead>
                  <TableHead className="text-xs">{t('colFeature')}</TableHead>
                  <TableHead className="text-xs">{t('colUser')}</TableHead>
                  <TableHead className="text-xs">{t('colPriority')}</TableHead>
                  <TableHead className="text-xs">{t('colStatus')}</TableHead>
                  <TableHead className="text-xs text-end">{t('colActions')}</TableHead>
                </TableRow>
              </TableHeader>
              <TableBody dir="ltr">
                {visible.map((f) => (
                  <TableRow
                    key={f.id}
                    className={cn(
                      f.status === 'needs_confirmation' && 'bg-amber-50/40 dark:bg-amber-500/10',
                      f.origin === 'user' && 'bg-emerald-50/30 dark:bg-emerald-500/10'
                    )}
                  >
                    <TableCell className="text-xs font-medium whitespace-nowrap">{f.module}</TableCell>
                    <TableCell className="max-w-[280px]">
                      <div className="text-[13px] font-medium leading-5">{f.feature}</div>
                      {f.rationale && (
                        <div className="text-[11px] text-muted-foreground leading-4 mt-0.5">{f.rationale}</div>
                      )}
                    </TableCell>
                    <TableCell className="text-xs whitespace-nowrap">{f.user}</TableCell>
                    <TableCell>
                      <PriorityBadge priority={f.priority} />
                    </TableCell>
                    <TableCell>
                      <div className="flex items-center gap-1">
                        <StatusBadge status={f.status} />
                        {f.status === 'needs_confirmation' && (
                          <Tooltip>
                            <TooltipTrigger asChild>
                              <ShieldQuestion className="h-3.5 w-3.5 text-amber-600 dark:text-amber-400" />
                            </TooltipTrigger>
                            <TooltipContent side="top" className="max-w-56 text-xs">
                              {t('needsConfirmationNote')}
                            </TooltipContent>
                          </Tooltip>
                        )}
                        {f.origin === 'user' && (
                          <Badge variant="outline" className="text-[10px] bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200">
                            {t('confirm') === 'Confirm' ? 'You' : 'أنت'}
                          </Badge>
                        )}
                      </div>
                    </TableCell>
                    <TableCell className="text-end">
                      {inStage ? (
                        <div className="flex items-center justify-end gap-0.5">
                          <Tooltip>
                            <TooltipTrigger asChild>
                              <Button
                                variant="ghost"
                                size="icon"
                                className="h-8 w-8 text-emerald-600 dark:text-emerald-400 hover:bg-emerald-50 dark:hover:bg-emerald-500/10 hover:text-emerald-700 dark:hover:text-emerald-300"
                                disabled={f.status === 'accepted'}
                                onClick={() => patchFeature(f.id, { status: 'accepted' })}
                                aria-label={t('accept')}
                              >
                                <Check className="h-4 w-4" />
                              </Button>
                            </TooltipTrigger>
                            <TooltipContent className="text-xs">{t('accept')}</TooltipContent>
                          </Tooltip>
                          <Tooltip>
                            <TooltipTrigger asChild>
                              <Button
                                variant="ghost"
                                size="icon"
                                className="h-8 w-8 text-red-600 dark:text-red-400 hover:bg-red-50 dark:hover:bg-red-500/10 hover:text-red-700 dark:hover:text-red-300"
                                disabled={f.status === 'rejected'}
                                onClick={() => patchFeature(f.id, { status: 'rejected' })}
                                aria-label={t('reject')}
                              >
                                <X className="h-4 w-4" />
                              </Button>
                            </TooltipTrigger>
                            <TooltipContent className="text-xs">{t('reject')}</TooltipContent>
                          </Tooltip>
                          <Tooltip>
                            <TooltipTrigger asChild>
                              <Button
                                variant="ghost"
                                size="icon"
                                className="h-8 w-8 text-sky-600 dark:text-sky-400 hover:bg-sky-50 dark:hover:bg-sky-500/10 hover:text-sky-700 dark:hover:text-sky-300"
                                disabled={f.status === 'deferred'}
                                onClick={() => patchFeature(f.id, { status: 'deferred' })}
                                aria-label={t('defer')}
                              >
                                <Clock className="h-4 w-4" />
                              </Button>
                            </TooltipTrigger>
                            <TooltipContent className="text-xs">{t('defer')}</TooltipContent>
                          </Tooltip>
                          <Tooltip>
                            <TooltipTrigger asChild>
                              <Button
                                variant="ghost"
                                size="icon"
                                className="h-8 w-8 hover:bg-muted"
                                onClick={() => setEditFeature(f)}
                                aria-label={t('edit')}
                              >
                                <Pencil className="h-3.5 w-3.5" />
                              </Button>
                            </TooltipTrigger>
                            <TooltipContent className="text-xs">{t('edit')}</TooltipContent>
                          </Tooltip>
                          <Tooltip>
                            <TooltipTrigger asChild>
                              <Button
                                variant="ghost"
                                size="icon"
                                className="h-8 w-8 text-muted-foreground hover:bg-red-50 dark:hover:bg-red-500/10 hover:text-red-600 dark:hover:text-red-400"
                                onClick={() => setConfirmRemove(f)}
                                aria-label={t('remove')}
                              >
                                <Trash2 className="h-3.5 w-3.5" />
                              </Button>
                            </TooltipTrigger>
                            <TooltipContent className="text-xs">{t('remove')}</TooltipContent>
                          </Tooltip>
                        </div>
                      ) : (
                        <span className="text-[11px] text-muted-foreground">—</span>
                      )}
                    </TableCell>
                  </TableRow>
                ))}
                {visible.length === 0 && (
                  <TableRow>
                    <TableCell colSpan={6} className="text-center text-xs text-muted-foreground py-6">
                      —
                    </TableCell>
                  </TableRow>
                )}
              </TableBody>
            </Table>
          </div>
        </div>

        {/* Baseline gate */}
        {inStage && (
          <div className="flex flex-col sm:flex-row items-stretch sm:items-center gap-2 rounded-xl border border-primary/25 bg-primary/[0.03] p-4">
            <div className="flex-1 text-xs text-muted-foreground leading-5">
              {counts.accepted} {t('countsAccepted')} · {counts.deferred} {t('countsDeferred')} · {counts.rejected}{' '}
              {t('countsRejected')}
              {counts.unreviewed > 0 && (
                <>
                  {' · '}
                  <span className="text-amber-700 font-medium">
                    {counts.unreviewed} {t('countsUnreviewed')}
                  </span>
                </>
              )}
            </div>
            <Button onClick={() => setApproveOpen(true)} size="lg" className="gap-1.5">
              <Check className="h-4 w-4" />
              {t('approveBaseline')}
            </Button>
          </div>
        )}

        {/* Approve dialog */}
        <Dialog open={approveOpen} onOpenChange={setApproveOpen}>
          <DialogContent className="sm:max-w-md">
            <DialogHeader>
              <DialogTitle>{t('approveBaseline')}</DialogTitle>
              <DialogDescription>
                {counts.unreviewed > 0
                  ? `${counts.unreviewed} ${t('unreviewedWarning')}`
                  : t('baselineApprovedBody')}
              </DialogDescription>
            </DialogHeader>
            {counts.unreviewed > 0 && (
              <div className="space-y-2">
                {(
                  [
                    ['accept', t('bulkAccept')],
                    ['defer', t('bulkDefer')],
                    ['reject', t('bulkReject')],
                  ] as const
                ).map(([value, label]) => (
                  <label
                    key={value}
                    className={cn(
                      'flex items-center gap-2.5 rounded-lg border p-3 cursor-pointer text-sm transition-colors',
                      unreviewedAction === value ? 'border-primary bg-primary/[0.05]' : 'hover:bg-muted/40'
                    )}
                  >
                    <input
                      type="radio"
                      name="unreviewed"
                      checked={unreviewedAction === value}
                      onChange={() => setUnreviewedAction(value)}
                      className="accent-primary"
                    />
                    {label}
                  </label>
                ))}
              </div>
            )}
            <DialogFooter>
              <Button variant="outline" onClick={() => setApproveOpen(false)}>
                {t('cancel')}
              </Button>
              <Button onClick={approveBaseline} disabled={approveBusy} className="gap-1.5">
                {approveBusy && <span className="h-3.5 w-3.5 border-2 border-current border-t-transparent rounded-full animate-spin" />}
                {t('confirmApproval')}
              </Button>
            </DialogFooter>
          </DialogContent>
        </Dialog>

        <FeatureFormDialog
          open={addOpen}
          onOpenChange={setAddOpen}
          ideaId={idea.id}
          mode="add"
          onSaved={(d) => {
            setDetail(d)
            refreshIdeas()
          }}
        />
        <FeatureFormDialog
          open={editFeature !== null}
          onOpenChange={(v) => !v && setEditFeature(null)}
          ideaId={idea.id}
          feature={editFeature ?? undefined}
          mode="edit"
          onSaved={(d) => {
            setDetail(d)
            refreshIdeas()
          }}
        />

        <AlertDialog open={confirmRemove !== null} onOpenChange={(v) => !v && setConfirmRemove(null)}>
          <AlertDialogContent>
            <AlertDialogHeader>
              <AlertDialogTitle>{t('remove')}: {confirmRemove?.feature}</AlertDialogTitle>
              <AlertDialogDescription>{t('deleteConfirmBody')}</AlertDialogDescription>
            </AlertDialogHeader>
            <AlertDialogFooter>
              <AlertDialogCancel>{t('cancel')}</AlertDialogCancel>
              <AlertDialogAction
                className="bg-red-600 text-white hover:bg-red-700"
                onClick={() => {
                  if (confirmRemove) removeFeature(confirmRemove.id)
                  setConfirmRemove(null)
                }}
              >
                {t('delete')}
              </AlertDialogAction>
            </AlertDialogFooter>
          </AlertDialogContent>
        </AlertDialog>
      </div>
    </TooltipProvider>
  )
}

function SparklesIcon() {
  return <span className="soft-pulse">✦</span>
}

// Add / edit feature dialog
function FeatureFormDialog({
  open,
  onOpenChange,
  ideaId,
  feature,
  mode,
  onSaved,
}: {
  open: boolean
  onOpenChange: (v: boolean) => void
  ideaId: string
  feature?: FeatureType
  mode: 'add' | 'edit'
  onSaved: (d: IdeaDetail) => void
}) {
  const { t } = useApp()
  const { toast } = useToast()
  const [form, setForm] = useState({ module: '', feature: '', user: '', priority: 'should' as Priority, rationale: '' })
  const [busy, setBusy] = useState(false)

  // Sync form whenever the dialog opens (edit) or resets (add)
  useEffect(() => {
    if (open) {
      setForm({
        module: feature?.module ?? '',
        feature: feature?.feature ?? '',
        user: feature?.user ?? '',
        priority: feature?.priority ?? 'should',
        rationale: feature?.rationale ?? '',
      })
    }
  }, [open, feature])

  async function submit() {
    if (form.feature.trim().length < 2) return
    setBusy(true)
    try {
      const res =
        mode === 'add'
          ? await fetch('/api/features', {
              method: 'POST',
              headers: { 'Content-Type': 'application/json' },
              body: JSON.stringify({ ideaId, ...form }),
            })
          : await fetch(`/api/features/${feature!.id}`, {
              method: 'PATCH',
              headers: { 'Content-Type': 'application/json' },
              body: JSON.stringify(form),
            })
      const data = await res.json()
      if (!res.ok) {
        toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
        return
      }
      onSaved(data as IdeaDetail)
      onOpenChange(false)
      if (mode === 'add') setForm({ module: '', feature: '', user: '', priority: 'should', rationale: '' })
    } catch {
      toast({ description: t('aiError'), variant: 'destructive' })
    } finally {
      setBusy(false)
    }
  }

  return (
    <Dialog open={open} onOpenChange={(v) => !busy && onOpenChange(v)}>
      <DialogContent className="sm:max-w-md">
        <DialogHeader>
          <DialogTitle>{mode === 'add' ? t('addFeature') : `${t('edit')}: ${feature?.feature}`}</DialogTitle>
        </DialogHeader>
        <div className="space-y-3">
          <div className="grid grid-cols-2 gap-3">
            <div className="space-y-1.5">
              <Label className="text-xs">{t('colModule')}</Label>
              <Input
                value={form.module}
                onChange={(e) => setForm({ ...form, module: e.target.value })}
                placeholder="Authentication"
                dir="ltr"
              />
            </div>
            <div className="space-y-1.5">
              <Label className="text-xs">{t('colUser')}</Label>
              <Input
                value={form.user}
                onChange={(e) => setForm({ ...form, user: e.target.value })}
                placeholder="Buyers"
                dir="ltr"
              />
            </div>
          </div>
          <div className="space-y-1.5">
            <Label className="text-xs">{t('colFeature')}</Label>
            <Input
              value={form.feature}
              onChange={(e) => setForm({ ...form, feature: e.target.value })}
              placeholder="Request quotations from multiple suppliers"
              dir="ltr"
            />
          </div>
          <div className="grid grid-cols-2 gap-3">
            <div className="space-y-1.5">
              <Label className="text-xs">{t('colPriority')}</Label>
              <Select value={form.priority} onValueChange={(v) => setForm({ ...form, priority: v as Priority })}>
                <SelectTrigger dir="ltr">
                  <SelectValue />
                </SelectTrigger>
                <SelectContent>
                  {PRIORITIES.map((p) => (
                    <SelectItem key={p} value={p}>
                      {p === 'must' ? t('prioMust') : p === 'should' ? t('prioShould') : t('prioCould')}
                    </SelectItem>
                  ))}
                </SelectContent>
              </Select>
            </div>
          </div>
          <div className="space-y-1.5">
            <Label className="text-xs">Rationale</Label>
            <Textarea
              value={form.rationale}
              onChange={(e) => setForm({ ...form, rationale: e.target.value })}
              rows={2}
              dir="ltr"
              maxLength={300}
              className="resize-none"
            />
          </div>
        </div>
        <DialogFooter>
          <Button variant="outline" onClick={() => onOpenChange(false)}>
            {t('cancel')}
          </Button>
          <Button onClick={submit} disabled={form.feature.trim().length < 2 || busy}>
            {mode === 'add' ? t('addFeature') : t('save')}
          </Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  )
}
