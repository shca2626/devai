'use client'

import { useState } from 'react'
import { Button } from '@/components/ui/button'
import { Badge } from '@/components/ui/badge'
import { Dialog, DialogContent, DialogDescription, DialogFooter, DialogHeader, DialogTitle } from '@/components/ui/dialog'
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
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from '@/components/ui/select'
import { Textarea } from '@/components/ui/textarea'
import { useApp } from '@/components/app/context'
import { CodeChip, PriorityBadge, ProvenanceBadge, ReqStatusBadge, WorkingPanel } from '@/components/app/bits'
import type { IdeaDetail, ImpactPreview, Requirement } from '@/lib/types'
import { Check, ChevronDown, ChevronUp, FileCheck2, Pencil, ShieldAlert, Users, X } from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Stage 5 — Requirements Engineering: the SRS review. Every
// requirement shows its provenance (client vs AI) and testable
// acceptance criteria. Changing a confirmed requirement after
// design exists triggers the change-impact dialog.
// ============================================================

export function RequirementsStage({ detail }: { detail: IdeaDetail }) {
  const { t, setDetail, refreshIdeas } = useApp()
  const { toast } = useToast()
  const { idea, requirements, roles } = detail
  // NO LIMITS: requirements can be generated, reviewed and approved at ANY stage
  const active = true
  const [busy, setBusy] = useState(false)
  const [filter, setFilter] = useState<string>('all')
  const [expanded, setExpanded] = useState<string | null>(null)
  const [editing, setEditing] = useState<Requirement | null>(null)
  const [impact, setImpact] = useState<ImpactPreview | null>(null)
  const [pendingAction, setPendingAction] = useState<{ id: string; body: Record<string, unknown> } | null>(null)
  const [gateOpen, setGateOpen] = useState(false)
  const [unreviewedAction, setUnreviewedAction] = useState<'accept' | 'defer' | 'reject' | null>(null)

  const unreviewed = requirements.filter((r) => r.status === 'proposed')
  const confirmed = requirements.filter((r) => r.status === 'confirmed')
  const unresolved = requirements.filter((r) => r.status === 'unresolved')

  async function call(url: string, body: Record<string, unknown>) {
    const res = await fetch(url, {
      method: url.includes('/gate') ? 'POST' : 'PATCH',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(body),
    })
    const data = await res.json()
    if (!res.ok) return { ok: false as const, data }
    setDetail(data as IdeaDetail)
    refreshIdeas()
    return { ok: true as const, data }
  }

  async function generate() {
    setBusy(true)
    const res = await fetch(`/api/ideas/${idea.id}/requirements/generate`, { method: 'POST' })
    const data = await res.json()
    setBusy(false)
    if (!res.ok) {
      toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
      return
    }
    setDetail(data as IdeaDetail)
    refreshIdeas()
  }

  async function setRequirement(id: string, body: Record<string, unknown>) {
    const result = await call(`/api/artifacts/requirement/${id}`, body)
    if (!result.ok) {
      const impact = (result.data as { impact?: ImpactPreview }).impact
      if (impact) {
        setImpact(impact)
        setPendingAction({ id, body })
        return
      }
      toast({ description: (result.data as { error?: string }).error ?? t('aiError'), variant: 'destructive' })
    }
  }

  async function applyWithImpact() {
    if (!pendingAction) return
    const result = await call(`/api/artifacts/requirement/${pendingAction.id}`, { ...pendingAction.body, confirmImpact: true })
    setImpact(null)
    setPendingAction(null)
    if (!result.ok) {
      toast({ description: (result.data as { error?: string }).error ?? t('aiError'), variant: 'destructive' })
    } else {
      toast({ description: t('applyChange') + ' ✓' })
    }
  }

  async function passGate() {
    if (!active) return
    setBusy(true)
    const result = await call(`/api/ideas/${idea.id}/gate`, {
      gate: 'requirements',
      action: 'approve',
      ...(unreviewed.length > 0 && unreviewedAction ? { unreviewedAction } : {}),
    })
    setBusy(false)
    setGateOpen(false)
    if (!result.ok) {
      toast({ description: (result.data as { error?: string }).error ?? t('aiError'), variant: 'destructive' })
    }
  }

  if (requirements.length === 0) {
    return (
      <div className="space-y-4">
        {active && (
          <>
            <div className="rounded-xl border bg-card p-4 text-sm text-muted-foreground leading-7">{t('startEngineeringBody')}</div>
            {busy ? (
              <WorkingPanel steps={[t('generatingRequirements1'), t('generatingRequirements2'), t('generatingRequirements3')]} />
            ) : (
              <Button onClick={generate} className="gap-2" size="lg">
                <FileCheck2 className="h-4 w-4" />
                {t('generateRequirements')}
              </Button>
            )}
          </>
        )}
      </div>
    )
  }

  const filtered = requirements.filter((r) => (filter === 'all' ? true : filter === 'fr' ? r.type === 'functional' : filter === 'nfr' ? r.type === 'non_functional' : r.status === filter))

  return (
    <div className="space-y-4">
      {/* Roles matrix */}
      {roles && roles.length > 0 && (
        <div className="rounded-xl border overflow-hidden">
          <div className="border-b bg-muted/50 px-4 py-2.5 text-sm font-semibold flex items-center gap-2">
            <Users className="h-4 w-4 text-primary" />
            {t('rolesMatrix')}
          </div>
          <div className="p-4 grid gap-3 sm:grid-cols-2" dir="ltr">
            {roles.map((role) => (
              <div key={role.name} className="rounded-lg border bg-card p-3">
                <div className="text-sm font-semibold">{role.name}</div>
                <p className="text-xs text-muted-foreground leading-5 mt-1">{role.description}</p>
                {role.permissions.length > 0 && (
                  <div className="flex flex-wrap gap-1 mt-2">
                    {role.permissions.map((p) => (
                      <Badge key={p} variant="outline" className="text-[10px] bg-muted/40">
                        {p}
                      </Badge>
                    ))}
                  </div>
                )}
              </div>
            ))}
          </div>
        </div>
      )}

      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center gap-2">
        <div className="text-sm font-semibold flex-1">
          {t('requirementsTitle')}
          <span className="text-muted-foreground font-normal ms-2">
            {confirmed.length} {t('statusConfirmed').toLowerCase()} · {unresolved.length} {t('statusUnresolved').toLowerCase()} · {unreviewed.length} {t('unreviewed')}
          </span>
        </div>
        {active && (
          <div className="flex flex-wrap items-center gap-2">
            <Button variant="outline" size="sm" onClick={generate} disabled={busy} className="gap-1.5">
              {t('regenerate')}
            </Button>
            <Select value={filter} onValueChange={setFilter}>
              <SelectTrigger size="sm" className="w-full sm:w-40 h-9">
                <SelectValue />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="all">{t('filterAll')}</SelectItem>
                <SelectItem value="fr">FR</SelectItem>
                <SelectItem value="nfr">NFR</SelectItem>
                <SelectItem value="confirmed">{t('statusConfirmed')}</SelectItem>
                <SelectItem value="unresolved">{t('statusUnresolved')}</SelectItem>
                <SelectItem value="proposed">{t('statusProposed')}</SelectItem>
              </SelectContent>
            </Select>
          </div>
        )}
      </div>

      {/* Requirement cards */}
      <div className="space-y-2">
        {filtered.map((r) => {
          const open = expanded === r.id
          return (
            <div key={r.id} className={`rounded-xl border bg-card p-3 sm:p-4 ${r.status === 'rejected' ? 'opacity-60' : ''}`}>
              <div className="flex items-start gap-2 flex-wrap">
                <CodeChip code={r.code} className="mt-0.5" />
                <div className="flex-1 min-w-[200px]">
                  <div className="text-sm font-medium leading-6" dir="ltr">
                    {r.status === 'rejected' ? <s>{r.title}</s> : r.title}
                    {r.titleAr && (
                      <span className="text-muted-foreground font-arabic ms-2" dir="rtl">
                        · {r.titleAr}
                      </span>
                    )}
                  </div>
                  <p className="text-xs text-muted-foreground leading-6 mt-1 line-clamp-2" dir="ltr">
                    {r.description}
                  </p>
                </div>
                <div className="flex items-center gap-1.5 flex-wrap">
                  <ProvenanceBadge provenance={r.provenance} />
                  <PriorityBadge priority={r.priority} />
                  <ReqStatusBadge status={r.status} />
                </div>
              </div>

              <button
                type="button"
                onClick={() => setExpanded(open ? null : r.id)}
                className="mt-2 text-[11px] text-primary hover:underline inline-flex items-center gap-1 min-h-9"
              >
                {open ? <ChevronUp className="h-3 w-3" /> : <ChevronDown className="h-3 w-3" />}
                {open ? t('viewLess') : t('viewMore')}
              </button>

              {open && (
                <div className="mt-1 space-y-3 border-t pt-3" dir="ltr">
                  <div>
                    <div className="text-[11px] font-semibold text-muted-foreground mb-1.5">{t('acceptanceCriteria')}</div>
                    <ul className="space-y-1">
                      {r.acceptanceCriteria.map((c, i) => (
                        <li key={i} className="text-xs leading-6 flex gap-1.5">
                          <Check className="h-3.5 w-3.5 text-emerald-600 shrink-0 mt-1" />
                          {c}
                        </li>
                      ))}
                    </ul>
                  </div>
                  {r.evidence && (
                    <div className="text-xs text-muted-foreground">
                      <span className="font-semibold">{t('evidenceLabel')}: </span>
                      {r.evidence}
                    </div>
                  )}
                </div>
              )}

              {active && r.status !== 'rejected' && (
                <div className="mt-2 flex flex-wrap gap-1.5 border-t pt-2">
                  {r.status !== 'confirmed' && (
                    <Button size="sm" variant="outline" className="gap-1 border-emerald-300 text-emerald-700 hover:bg-emerald-50" onClick={() => setRequirement(r.id, { status: 'confirmed' })}>
                      <Check className="h-3.5 w-3.5" />
                      {t('confirmReq')}
                    </Button>
                  )}
                  {r.status !== 'unresolved' && (
                    <Button size="sm" variant="outline" className="gap-1 border-amber-300 text-amber-700 hover:bg-amber-50" onClick={() => setRequirement(r.id, { status: 'unresolved' })}>
                      <ShieldAlert className="h-3.5 w-3.5" />
                      {t('markUnresolved')}
                    </Button>
                  )}
                  <Button size="sm" variant="outline" className="gap-1 border-red-200 text-red-600 hover:bg-red-50" onClick={() => setRequirement(r.id, { status: 'rejected' })}>
                    <X className="h-3.5 w-3.5" />
                    {t('reject')}
                  </Button>
                  <Button size="sm" variant="ghost" className="gap-1" onClick={() => setEditing(r)}>
                    <Pencil className="h-3.5 w-3.5" />
                    {t('edit')}
                  </Button>
                </div>
              )}
            </div>
          )
        })}
      </div>

      {/* Gate */}
      {active && (
        <div className="rounded-xl border border-primary/25 bg-primary/[0.03] p-4 space-y-3">
          {unresolved.length > 0 && (
            <p className="text-xs text-muted-foreground leading-6">ℹ {t('unresolvedNote')}</p>
          )}
          <Button className="gap-2" onClick={() => setGateOpen(true)} disabled={busy}>
            <FileCheck2 className="h-4 w-4" />
            {t('approveRequirements')}
          </Button>
        </div>
      )}

      {/* Gate dialog with unreviewed handling */}
      <AlertDialog open={gateOpen} onOpenChange={setGateOpen}>
        <AlertDialogContent>
          <AlertDialogHeader>
            <AlertDialogTitle>{t('approveRequirements')}</AlertDialogTitle>
            <AlertDialogDescription asChild>
              <div className="space-y-3">
                {unreviewed.length > 0 ? (
                  <div className="space-y-2">
                    <p>
                      {unreviewed.length} {t('unreviewedReqs')}.
                    </p>
                    <div className="flex flex-wrap gap-2">
                      <Button size="sm" variant={unreviewedAction === 'accept' ? 'default' : 'outline'} onClick={() => setUnreviewedAction('accept')}>
                        {t('bulkConfirm')}
                      </Button>
                      <Button size="sm" variant={unreviewedAction === 'defer' ? 'default' : 'outline'} onClick={() => setUnreviewedAction('defer')}>
                        {t('bulkUnresolved')}
                      </Button>
                      <Button size="sm" variant={unreviewedAction === 'reject' ? 'default' : 'outline'} onClick={() => setUnreviewedAction('reject')}>
                        {t('bulkReject')}
                      </Button>
                    </div>
                  </div>
                ) : (
                  <p>{t('confirmApproval')}</p>
                )}
              </div>
            </AlertDialogDescription>
            <AlertDialogFooter>
              <AlertDialogCancel>{t('cancel')}</AlertDialogCancel>
              <AlertDialogAction
                disabled={unreviewed.length > 0 && !unreviewedAction}
                onClick={(e) => {
                  e.preventDefault()
                  passGate()
                }}
              >
                {t('confirmApproval')}
              </AlertDialogAction>
            </AlertDialogFooter>
          </AlertDialogHeader>
        </AlertDialogContent>
      </AlertDialog>

      {/* Change impact dialog */}
      <Dialog open={!!impact} onOpenChange={(v) => !v && (setImpact(null), setPendingAction(null))}>
        <DialogContent className="max-w-lg">
          <DialogHeader>
            <DialogTitle className="flex items-center gap-2 text-base">
              <ShieldAlert className="h-4.5 w-4.5 text-amber-600" />
              {t('impactTitle')}
            </DialogTitle>
            <DialogDescription asChild>
              <div className="space-y-3">
                <p className="text-xs leading-6">{t('impactBody')}</p>
                {impact && (
                  <>
                    <div className="rounded-lg border bg-muted/30 p-2.5 flex items-center gap-2" dir="ltr">
                      <CodeChip code={impact.requirementCode} />
                      <span className="text-xs font-medium">{impact.requirementTitle}</span>
                    </div>
                    {impact.affected.length === 0 ? (
                      <p className="text-xs text-muted-foreground">{t('noDownstream')}</p>
                    ) : (
                      <div className="space-y-1.5 max-h-64 overflow-y-auto nice-scroll">
                        {impact.affected.map((a, i) => (
                          <div key={i} className="flex items-start gap-2 rounded-lg border p-2">
                            <CodeChip code={a.code} />
                            <div className="min-w-0">
                              <div className="text-xs font-medium truncate" dir="ltr">
                                {a.name}
                              </div>
                              <div className="text-[11px] text-muted-foreground leading-5">{a.why}</div>
                            </div>
                          </div>
                        ))}
                      </div>
                    )}
                  </>
                )}
              </div>
            </DialogDescription>
          </DialogHeader>
          <DialogFooter>
            <Button variant="outline" size="sm" onClick={() => (setImpact(null), setPendingAction(null))}>
              {t('cancel')}
            </Button>
            <Button size="sm" onClick={applyWithImpact} className="gap-1.5">
              <ShieldAlert className="h-3.5 w-3.5" />
              {t('applyChange')}
              {impact && impact.affected.length > 0 && ` (${impact.affected.length} ${t('affectedArtifacts')})`}
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>

      {/* Edit dialog — remounts per requirement via key so state initializes fresh */}
      {editing && (
        <EditRequirementDialog
          key={editing.id}
          requirement={editing}
          onClose={() => setEditing(null)}
          onSave={async (edits) => {
            const target = editing
            setEditing(null)
            await setRequirement(target.id, { edits })
          }}
        />
      )}
    </div>
  )
}

function EditRequirementDialog({
  requirement,
  onClose,
  onSave,
}: {
  requirement: Requirement | null
  onClose: () => void
  onSave: (edits: { title?: string; description?: string; acceptanceCriteria?: string[] }) => Promise<void>
}) {
  const { t } = useApp()
  const [title, setTitle] = useState(requirement?.title ?? '')
  const [description, setDescription] = useState(requirement?.description ?? '')
  const [criteria, setCriteria] = useState(requirement?.acceptanceCriteria.join('\n') ?? '')

  return (
    <Dialog open={!!requirement} onOpenChange={(v) => !v && onClose()}>
      <DialogContent className="max-w-lg">
        <DialogHeader>
          <DialogTitle className="text-base">{t('editRequirement')}</DialogTitle>
        </DialogHeader>
        <div className="space-y-3">
          <div>
            <label className="text-xs font-semibold">{t('colRequirement')}</label>
            <Textarea value={title} onChange={(e) => setTitle(e.target.value)} rows={2} className="mt-1 text-sm" dir="ltr" />
          </div>
          <div>
            <label className="text-xs font-semibold">{t('descriptionLabel')}</label>
            <Textarea value={description} onChange={(e) => setDescription(e.target.value)} rows={3} className="mt-1 text-sm" dir="ltr" />
          </div>
          <div>
            <label className="text-xs font-semibold">{t('acceptanceCriteria')} (1/سطر)</label>
            <Textarea value={criteria} onChange={(e) => setCriteria(e.target.value)} rows={4} className="mt-1 text-xs" dir="ltr" />
          </div>
        </div>
        <DialogFooter>
          <Button variant="outline" size="sm" onClick={onClose}>
            {t('cancel')}
          </Button>
          <Button
            size="sm"
            onClick={() =>
              onSave({
                title: title.trim() || undefined,
                description: description.trim() || undefined,
                acceptanceCriteria: criteria.split('\n').map((c) => c.trim()).filter(Boolean),
              })
            }
          >
            {t('save')}
          </Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  )
}
