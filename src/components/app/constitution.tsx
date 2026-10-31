'use client'

import { useEffect, useState } from 'react'
import { Button } from '@/components/ui/button'
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog'
import { Textarea } from '@/components/ui/textarea'
import { Badge } from '@/components/ui/badge'
import { Switch } from '@/components/ui/switch'
import { useApp } from '@/components/app/context'
import type { ConstitutionCategory, ConstitutionRule } from '@/lib/types'
import { CONSTITUTION_CATEGORIES } from '@/lib/types'
import {
  Check,
  Globe2,
  Loader2,
  Pencil,
  Plus,
  ScrollText,
  Sparkles,
  Trash2,
  X,
  Zap,
} from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// AI Constitution manager — the developer's standing rules.
//
// Two scopes, one list:
//   GLOBAL  (ideaId = null)  -> applied to every project's context pack
//   PROJECT (ideaId = set)   -> applied to the selected project only
//
// Rules can be written manually or drafted by the AI from the
// project's approved context. Every rule carries an enabled flag
// so it can be silenced without being lost.
// ============================================================

const CATEGORY_KEYS: Record<ConstitutionCategory, { en: string; ar: string }> = {
  stack: { en: 'Stack', ar: 'التقنيات' },
  coding: { en: 'Coding', ar: 'البرمجة' },
  security: { en: 'Security', ar: 'الأمان' },
  design: { en: 'Design', ar: 'التصميم' },
  quality: { en: 'Quality', ar: 'الجودة' },
  workflow: { en: 'Workflow', ar: 'سير العمل' },
}

function RuleRow({
  rule,
  onToggle,
  onEdit,
  onDelete,
  busy,
}: {
  rule: ConstitutionRule
  onToggle: (rule: ConstitutionRule) => void
  onEdit: (rule: ConstitutionRule) => void
  onDelete: (rule: ConstitutionRule) => void
  busy: boolean
}) {
  const { lang } = useApp()
  const [editing, setEditing] = useState(false)
  const [draft, setDraft] = useState(rule.text)

  async function saveEdit() {
    const value = draft.trim()
    if (value.length < 5 || value === rule.text) {
      setEditing(false)
      return
    }
    setEditing(false)
    onEdit({ ...rule, text: value })
  }

  return (
    <div
      className={`rounded-lg border p-2.5 space-y-1.5 transition-opacity ${
        rule.enabled ? 'bg-card' : 'bg-muted/30 opacity-60'
      }`}
    >
      <div className="flex items-center gap-2 flex-wrap">
        <Badge variant="outline" className="text-[10px] capitalize shrink-0">
          {CATEGORY_KEYS[rule.category][lang === 'ar' ? 'ar' : 'en']}
        </Badge>
        {rule.scope === 'global' ? (
          <Badge variant="outline" className="text-[10px] shrink-0 gap-1 bg-sky-50 dark:bg-sky-500/10 text-sky-700 dark:text-sky-300 border-sky-200">
            <Globe2 className="h-2.5 w-2.5" />
            {lang === 'ar' ? 'عام' : 'Global'}
          </Badge>
        ) : (
          <Badge variant="outline" className="text-[10px] shrink-0 gap-1 bg-violet-50 dark:bg-violet-500/10 text-violet-700 dark:text-violet-300 border-violet-200">
            <Zap className="h-2.5 w-2.5" />
            {lang === 'ar' ? 'المشروع' : 'Project'}
          </Badge>
        )}
        {rule.origin === 'ai' && (
          <Badge variant="outline" className="text-[10px] shrink-0 bg-primary/10 text-primary border-primary/30">
            AI
          </Badge>
        )}
        <div className="ms-auto flex items-center gap-1.5">
          <Switch
            checked={rule.enabled}
            onCheckedChange={() => onToggle(rule)}
            disabled={busy}
            aria-label="toggle rule"
            className="scale-90"
          />
          <Button variant="ghost" size="icon" className="h-7 w-7" onClick={() => setEditing((v) => !v)} disabled={busy} aria-label="edit rule">
            <Pencil className="h-3.5 w-3.5" />
          </Button>
          <Button variant="ghost" size="icon" className="h-7 w-7 text-red-600 dark:text-red-400 hover:text-red-700 dark:hover:text-red-300" onClick={() => onDelete(rule)} disabled={busy} aria-label="delete rule">
            <Trash2 className="h-3.5 w-3.5" />
          </Button>
        </div>
      </div>
      {editing ? (
        <div className="space-y-1.5">
          <Textarea
            value={draft}
            onChange={(e) => setDraft(e.target.value)}
            rows={2}
            dir="auto"
            className="text-[13px] leading-6"
          />
          <div className="flex gap-1.5 justify-end">
            <Button size="sm" variant="ghost" onClick={() => setEditing(false)}>
              <X className="h-3.5 w-3.5" />
            </Button>
            <Button size="sm" onClick={saveEdit} className="gap-1">
              <Check className="h-3.5 w-3.5" />
            </Button>
          </div>
        </div>
      ) : (
        <p className="text-[13px] leading-6" dir="auto">
          {rule.text}
        </p>
      )}
    </div>
  )
}

export function ConstitutionDialog({
  open,
  onOpenChange,
}: {
  open: boolean
  onOpenChange: (open: boolean) => void
}) {
  const { t, lang, detail } = useApp()
  const { toast } = useToast()
  const ideaId = detail?.idea.id ?? null

  const [rules, setRules] = useState<ConstitutionRule[]>([])
  const [loading, setLoading] = useState(false)
  const [busy, setBusy] = useState(false)
  const [drafting, setDrafting] = useState(false)
  const [newText, setNewText] = useState('')
  const [newCategory, setNewCategory] = useState<ConstitutionCategory>('coding')
  const [newScope, setNewScope] = useState<'global' | 'project'>('global')

  async function load(id: string | null) {
    setLoading(true)
    try {
      const url = id ? `/api/constitution?ideaId=${id}` : '/api/constitution'
      const res = await fetch(url)
      const data = (await res.json()) as { rules?: ConstitutionRule[]; error?: string }
      if (!res.ok) {
        toast({ description: data.error ?? t('toolsError'), variant: 'destructive' })
        return
      }
      setRules(data.rules ?? [])
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setLoading(false)
    }
  }

  // Reload whenever the dialog opens or the selected idea changes
  useEffect(() => {
    if (open) void load(ideaId)
  }, [open, ideaId])

  async function addRule() {
    const value = newText.trim()
    if (value.length < 5) {
      toast({ description: t('ruleTooShort') })
      return
    }
    if (newScope === 'project' && !ideaId) return
    setBusy(true)
    try {
      const res = await fetch('/api/constitution', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ scope: newScope, ideaId: newScope === 'project' ? ideaId : undefined, category: newCategory, text: value }),
      })
      const data = (await res.json()) as { rules?: ConstitutionRule[]; error?: string }
      if (!res.ok) {
        toast({ description: data.error ?? t('toolsError'), variant: 'destructive' })
        return
      }
      setRules(data.rules ?? [])
      setNewText('')
      toast({ description: t('ruleAdded') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusy(false)
    }
  }

  async function patchRule(rule: ConstitutionRule, patch: Partial<ConstitutionRule>) {
    setBusy(true)
    try {
      const res = await fetch(`/api/constitution/${rule.id}`, {
        method: 'PATCH',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(patch),
      })
      const data = (await res.json()) as { rules?: ConstitutionRule[]; error?: string }
      if (!res.ok) {
        toast({ description: data.error ?? t('toolsError'), variant: 'destructive' })
        return
      }
      setRules(data.rules ?? [])
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusy(false)
    }
  }

  async function deleteRule(rule: ConstitutionRule) {
    setBusy(true)
    try {
      const res = await fetch(`/api/constitution/${rule.id}`, { method: 'DELETE' })
      const data = (await res.json()) as { rules?: ConstitutionRule[]; error?: string }
      if (!res.ok) {
        toast({ description: data.error ?? t('toolsError'), variant: 'destructive' })
        return
      }
      setRules(data.rules ?? [])
      toast({ description: t('ruleDeleted') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusy(false)
    }
  }

  async function aiDraft() {
    if (!ideaId) return
    setDrafting(true)
    try {
      const res = await fetch(`/api/ideas/${ideaId}/constitution/draft`, { method: 'POST' })
      const data = (await res.json()) as { rules?: ConstitutionRule[]; error?: string }
      if (!res.ok) {
        toast({ description: data.error ?? t('toolsError'), variant: 'destructive' })
        return
      }
      setRules(data.rules ?? [])
      toast({ description: t('constitutionDrafted') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setDrafting(false)
    }
  }

  const globalRules = rules.filter((r) => r.scope === 'global')
  const projectRules = rules.filter((r) => r.scope === 'project')
  const hasProjectContext =
    detail && (detail.features.length > 0 || detail.requirements.length > 0 || detail.entities.length > 0)

  return (
    <Dialog open={open} onOpenChange={onOpenChange}>
      <DialogContent className="sm:max-w-2xl max-h-[90vh] overflow-y-auto">
        <DialogHeader>
          <DialogTitle className="flex items-center gap-2">
            <ScrollText className="h-4 w-4 text-primary" />
            {t('constitutionTitle')}
          </DialogTitle>
          <DialogDescription>{t('constitutionBody')}</DialogDescription>
        </DialogHeader>

        {/* ---------- Add a rule ---------- */}
        <div className="rounded-xl border p-3 space-y-2.5">
          <p className="text-xs font-medium text-muted-foreground">{t('addRuleTitle')}</p>
          <div className="flex flex-wrap gap-1.5">
            {CONSTITUTION_CATEGORIES.map((cat) => (
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
          <Textarea
            value={newText}
            onChange={(e) => setNewText(e.target.value)}
            placeholder={t('rulePlaceholder')}
            rows={2}
            dir="auto"
            className="text-[13px]"
          />
          <div className="flex flex-wrap items-center gap-2">
            {ideaId && (
              <div className="flex items-center rounded-lg border p-0.5">
                <button
                  type="button"
                  onClick={() => setNewScope('global')}
                  className={`rounded-md px-2.5 py-1 text-[11px] font-medium ${newScope === 'global' ? 'bg-primary text-primary-foreground' : 'text-muted-foreground'}`}
                >
                  {t('scopeGlobal')}
                </button>
                <button
                  type="button"
                  onClick={() => setNewScope('project')}
                  className={`rounded-md px-2.5 py-1 text-[11px] font-medium ${newScope === 'project' ? 'bg-primary text-primary-foreground' : 'text-muted-foreground'}`}
                >
                  {t('scopeProject')}
                </button>
              </div>
            )}
            <div className="ms-auto">
              <Button size="sm" onClick={addRule} disabled={busy} className="gap-1.5">
                <Plus className="h-3.5 w-3.5" />
                {t('addRule')}
              </Button>
            </div>
          </div>
        </div>

        {/* ---------- Project rules ---------- */}
        {ideaId && (
          <div className="space-y-2">
            <div className="flex flex-wrap items-center gap-2">
              <p className="text-xs font-semibold">{t('projectRulesTitle')}</p>
              <Badge variant="outline" className="text-[10px]">{projectRules.length}</Badge>
              <div className="ms-auto">
                <Button
                  size="sm"
                  variant="outline"
                  onClick={aiDraft}
                  disabled={drafting || !hasProjectContext}
                  className="gap-1.5"
                  title={hasProjectContext ? undefined : t('needProjectContext')}
                >
                  {drafting ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <Sparkles className="h-3.5 w-3.5 text-primary" />}
                  {drafting ? t('draftingRules') : t('aiDraftRules')}
                </Button>
              </div>
            </div>
            {hasProjectContext === false && (
              <p className="text-[11px] text-muted-foreground">{t('needProjectContext')}</p>
            )}
            {loading && projectRules.length === 0 ? (
              <div className="flex items-center justify-center py-4">
                <Loader2 className="h-4 w-4 animate-spin text-muted-foreground" />
              </div>
            ) : projectRules.length === 0 ? (
              <p className="rounded-lg border border-dashed p-3 text-center text-xs text-muted-foreground">
                {t('noProjectRules')}
              </p>
            ) : (
              <div className="space-y-1.5">
                {projectRules.map((rule) => (
                  <RuleRow key={rule.id} rule={rule} onToggle={(r) => patchRule(r, { enabled: !r.enabled })} onEdit={(r) => patchRule(r, { text: r.text })} onDelete={deleteRule} busy={busy} />
                ))}
              </div>
            )}
          </div>
        )}

        {/* ---------- Global rules ---------- */}
        <div className="space-y-2">
          <div className="flex items-center gap-2">
            <p className="text-xs font-semibold">{t('globalRulesTitle')}</p>
            <Badge variant="outline" className="text-[10px]">{globalRules.length}</Badge>
          </div>
          {loading && globalRules.length === 0 ? (
            <div className="flex items-center justify-center py-4">
              <Loader2 className="h-4 w-4 animate-spin text-muted-foreground" />
            </div>
          ) : globalRules.length === 0 ? (
            <p className="rounded-lg border border-dashed p-3 text-center text-xs text-muted-foreground">
              {t('noGlobalRules')}
            </p>
          ) : (
            <div className="space-y-1.5">
              {globalRules.map((rule) => (
                <RuleRow key={rule.id} rule={rule} onToggle={(r) => patchRule(r, { enabled: !r.enabled })} onEdit={(r) => patchRule(r, { text: r.text })} onDelete={deleteRule} busy={busy} />
              ))}
            </div>
          )}
        </div>
      </DialogContent>
    </Dialog>
  )
}
