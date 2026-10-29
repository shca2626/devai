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
import type { PlaybookCategory, PromptTemplate } from '@/lib/types'
import { expandTemplate, templateVariables } from '@/lib/prompt-utils'
import {
  BookOpen,
  Check,
  Copy,
  Loader2,
  Pencil,
  Plus,
  Search,
  Sparkles,
  Star,
  Trash2,
  Wand2,
  X,
} from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Prompt Playbook — saved, reusable prompt templates with
// {{variables}}, organized by the recurring tasks of
// vibe-coding. Built-ins are seeded once; the user can favorite,
// copy, extend, delete their own, or draft new ones with AI.
//
// "Use in Prompt Lab" sends the expanded prompt straight into
// the New Idea dialog (translate / enhance / build pipeline).
// ============================================================

const CATEGORY_META: Record<PlaybookCategory, { en: string; ar: string }> = {
  new_feature: { en: 'New feature', ar: 'ميزة جديدة' },
  bug_fix: { en: 'Bug fix', ar: 'إصلاح خلل' },
  refactor: { en: 'Refactor', ar: 'إعادة هيكلة' },
  tests: { en: 'Tests', ar: 'اختبارات' },
  review: { en: 'Review', ar: 'مراجعة' },
  planning: { en: 'Planning', ar: 'تخطيط' },
  general: { en: 'General', ar: 'عام' },
}

const ALL_CATEGORIES = Object.keys(CATEGORY_META) as PlaybookCategory[]

function TemplateCard({
  template,
  active,
  onSelect,
}: {
  template: PromptTemplate
  active: boolean
  onSelect: () => void
}) {
  const { lang } = useApp()
  const title = (lang === 'ar' && template.titleAr) || template.title
  const description = (lang === 'ar' && template.descriptionAr) || template.description
  const vars = templateVariables(template.body)

  return (
    <button
      type="button"
      onClick={onSelect}
      className={`w-full text-start rounded-xl border p-3 space-y-1.5 transition-colors ${
        active
          ? 'border-primary bg-primary/[0.06]'
          : 'border-border bg-card hover:bg-muted/50'
      }`}
    >
      <div className="flex items-center gap-2 flex-wrap">
        <span className="text-[13px] font-semibold leading-snug flex-1 min-w-0">{title}</span>
        {template.isFavorite && <Star className="h-3.5 w-3.5 shrink-0 fill-amber-400 text-amber-400" />}
      </div>
      <p className="text-[11px] text-muted-foreground leading-5 line-clamp-2">{description}</p>
      <div className="flex items-center gap-1.5 flex-wrap pt-0.5">
        <Badge variant="outline" className="text-[10px]">
          {CATEGORY_META[template.category][lang === 'ar' ? 'ar' : 'en']}
        </Badge>
        {template.isBuiltin && (
          <Badge variant="outline" className="text-[10px] bg-primary/10 text-primary border-primary/30">
            {lang === 'ar' ? 'مدمج' : 'Built-in'}
          </Badge>
        )}
        {vars.length > 0 && (
          <Badge variant="outline" className="text-[10px] font-mono" dir="ltr">
            {vars.length} {'{}'}
          </Badge>
        )}
        {template.useCount > 0 && (
          <span className="text-[10px] text-muted-foreground ms-auto" dir="ltr">
            ×{template.useCount}
          </span>
        )}
      </div>
    </button>
  )
}

export function PlaybookDialog({
  open,
  onOpenChange,
  onSendToLab,
}: {
  open: boolean
  onOpenChange: (open: boolean) => void
  onSendToLab: (prompt: string) => void
}) {
  const { t, lang } = useApp()
  const { toast } = useToast()

  const [templates, setTemplates] = useState<PromptTemplate[]>([])
  const [loading, setLoading] = useState(false)
  const [query, setQuery] = useState('')
  const [category, setCategory] = useState<PlaybookCategory | 'all'>('all')
  const [selectedId, setSelectedId] = useState<string | null>(null)
  const [values, setValues] = useState<Record<string, string>>({})
  const [busy, setBusy] = useState(false)
  const [draftOpen, setDraftOpen] = useState(false)
  const [draftText, setDraftText] = useState('')
  const [drafting, setDrafting] = useState(false)
  const [newOpen, setNewOpen] = useState(false)
  const [newTitle, setNewTitle] = useState('')
  const [newBody, setNewBody] = useState('')

  useEffect(() => {
    if (!open) return
    setLoading(true)
    fetch('/api/playbook')
      .then((r) => r.json())
      .then((d: { templates?: PromptTemplate[]; error?: string }) => {
        if (d.templates) setTemplates(d.templates)
        else if (d.error) toast({ description: d.error, variant: 'destructive' })
      })
      .catch(() => toast({ description: t('toolsError'), variant: 'destructive' }))
      .finally(() => setLoading(false))
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [open])

  const selected = useMemo(
    () => templates.find((x) => x.id === selectedId) ?? null,
    [templates, selectedId]
  )
  const variables = useMemo(() => (selected ? templateVariables(selected.body) : []), [selected])
  const preview = useMemo(
    () => (selected ? expandTemplate(selected.body, values) : ''),
    [selected, values]
  )

  const filtered = useMemo(() => {
    const q = query.trim().toLowerCase()
    return templates.filter((x) => {
      if (category !== 'all' && x.category !== category) return false
      if (!q) return true
      return (
        x.title.toLowerCase().includes(q) ||
        (x.titleAr ?? '').includes(q) ||
        x.description.toLowerCase().includes(q) ||
        (x.descriptionAr ?? '').includes(q)
      )
    })
  }, [templates, query, category])

  function select(template: PromptTemplate) {
    setSelectedId(template.id === selectedId ? null : template.id)
    setValues({})
  }

  async function toggleFavorite(template: PromptTemplate) {
    setBusy(true)
    try {
      const res = await fetch(`/api/playbook/${template.id}`, {
        method: 'PATCH',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ isFavorite: !template.isFavorite }),
      })
      const data = (await res.json()) as { template?: PromptTemplate; error?: string }
      if (!res.ok || !data.template) {
        toast({ description: data.error ?? t('toolsError'), variant: 'destructive' })
        return
      }
      setTemplates((prev) => prev.map((x) => (x.id === data.template!.id ? data.template! : x)))
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusy(false)
    }
  }

  async function useTemplate(copy: boolean) {
    if (!selected) return
    setBusy(true)
    try {
      const res = await fetch(`/api/playbook/${selected.id}/use`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ values }),
      })
      const data = (await res.json()) as { prompt?: string; template?: PromptTemplate; error?: string }
      if (!res.ok || !data.prompt) {
        toast({ description: data.error ?? t('toolsError'), variant: 'destructive' })
        return
      }
      setTemplates((prev) => prev.map((x) => (x.id === data.template!.id ? data.template! : x)))
      if (copy) {
        await navigator.clipboard.writeText(data.prompt)
        toast({ description: t('copiedToClipboard') })
      } else {
        onOpenChange(false)
        onSendToLab(data.prompt)
      }
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusy(false)
    }
  }

  async function removeTemplate(template: PromptTemplate) {
    setBusy(true)
    try {
      const res = await fetch(`/api/playbook/${template.id}`, { method: 'DELETE' })
      const data = (await res.json()) as { ok?: boolean; error?: string }
      if (!res.ok) {
        toast({ description: data.error ?? t('toolsError'), variant: 'destructive' })
        return
      }
      setTemplates((prev) => prev.filter((x) => x.id !== template.id))
      if (selectedId === template.id) setSelectedId(null)
      toast({ description: t('templateDeleted') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusy(false)
    }
  }

  async function aiDraft() {
    const value = draftText.trim()
    if (value.length < 10) {
      toast({ description: t('draftTooShort') })
      return
    }
    setDrafting(true)
    try {
      const res = await fetch('/api/playbook/draft', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ description: value }),
      })
      const data = (await res.json()) as { template?: PromptTemplate; error?: string }
      if (!res.ok || !data.template) {
        toast({ description: data.error ?? t('toolsError'), variant: 'destructive' })
        return
      }
      setTemplates((prev) => [data.template!, ...prev])
      setDraftOpen(false)
      setDraftText('')
      setSelectedId(data.template.id)
      toast({ description: t('templateDrafted') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setDrafting(false)
    }
  }

  async function createTemplate() {
    const title = newTitle.trim()
    const body = newBody.trim()
    if (title.length < 3 || body.length < 20) {
      toast({ description: t('templateTooShort') })
      return
    }
    setBusy(true)
    try {
      const res = await fetch('/api/playbook', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, body, category: 'general', description: title }),
      })
      const data = (await res.json()) as { template?: PromptTemplate; error?: string }
      if (!res.ok || !data.template) {
        toast({ description: data.error ?? t('toolsError'), variant: 'destructive' })
        return
      }
      setTemplates((prev) => [data.template!, ...prev])
      setNewOpen(false)
      setNewTitle('')
      setNewBody('')
      setSelectedId(data.template.id)
      toast({ description: t('templateSaved') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setBusy(false)
    }
  }

  return (
    <Dialog open={open} onOpenChange={onOpenChange}>
      <DialogContent className="sm:max-w-3xl max-h-[90vh] overflow-y-auto">
        <DialogHeader>
          <DialogTitle className="flex items-center gap-2">
            <BookOpen className="h-4 w-4 text-primary" />
            {t('playbookTitle')}
          </DialogTitle>
          <DialogDescription>{t('playbookBody')}</DialogDescription>
        </DialogHeader>

        {/* ---------- Toolbar ---------- */}
        <div className="flex flex-wrap items-center gap-2">
          <div className="relative flex-1 min-w-40">
            <Search className="absolute start-2.5 top-1/2 h-3.5 w-3.5 -translate-y-1/2 text-muted-foreground" />
            <Input
              value={query}
              onChange={(e) => setQuery(e.target.value)}
              placeholder={t('searchTemplates')}
              className="ps-8 h-8 text-xs"
            />
          </div>
          <Button size="sm" variant="outline" onClick={() => setDraftOpen((v) => !v)} className="gap-1.5">
            <Sparkles className="h-3.5 w-3.5 text-primary" />
            {t('draftWithAi')}
          </Button>
          <Button size="sm" variant="outline" onClick={() => setNewOpen((v) => !v)} className="gap-1.5">
            <Plus className="h-3.5 w-3.5" />
            {t('newTemplate')}
          </Button>
        </div>

        {/* ---------- AI draft box ---------- */}
        {draftOpen && (
          <div className="rounded-xl border border-primary/30 bg-primary/[0.04] p-3 space-y-2">
            <Textarea
              value={draftText}
              onChange={(e) => setDraftText(e.target.value)}
              placeholder={t('draftPlaceholder')}
              rows={2}
              dir="auto"
              className="text-[13px]"
            />
            <div className="flex justify-end gap-1.5">
              <Button size="sm" variant="ghost" onClick={() => setDraftOpen(false)}>
                <X className="h-3.5 w-3.5" />
              </Button>
              <Button size="sm" onClick={aiDraft} disabled={drafting} className="gap-1.5">
                {drafting ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <Wand2 className="h-3.5 w-3.5" />}
                {drafting ? t('draftingRules') : t('draftTemplate')}
              </Button>
            </div>
          </div>
        )}

        {/* ---------- New template box ---------- */}
        {newOpen && (
          <div className="rounded-xl border p-3 space-y-2">
            <Input
              value={newTitle}
              onChange={(e) => setNewTitle(e.target.value)}
              placeholder={t('templateTitlePlaceholder')}
              className="h-8 text-xs"
              dir="auto"
            />
            <Textarea
              value={newBody}
              onChange={(e) => setNewBody(e.target.value)}
              placeholder={t('templateBodyPlaceholder')}
              rows={4}
              dir="auto"
              className="text-[13px] font-mono"
            />
            <div className="flex justify-end gap-1.5">
              <Button size="sm" variant="ghost" onClick={() => setNewOpen(false)}>
                <X className="h-3.5 w-3.5" />
              </Button>
              <Button size="sm" onClick={createTemplate} disabled={busy} className="gap-1.5">
                <Check className="h-3.5 w-3.5" />
                {t('saveTemplate')}
              </Button>
            </div>
          </div>
        )}

        {/* ---------- Category filter ---------- */}
        <div className="flex flex-wrap gap-1.5">
          <button
            type="button"
            onClick={() => setCategory('all')}
            className={`rounded-full border px-2.5 py-1 text-[11px] font-medium transition-colors ${
              category === 'all'
                ? 'border-primary bg-primary/10 text-primary'
                : 'border-border text-muted-foreground hover:bg-muted/50'
            }`}
          >
            {lang === 'ar' ? 'الكل' : 'All'}
          </button>
          {ALL_CATEGORIES.map((cat) => (
            <button
              key={cat}
              type="button"
              onClick={() => setCategory(cat)}
              className={`rounded-full border px-2.5 py-1 text-[11px] font-medium transition-colors ${
                category === cat
                  ? 'border-primary bg-primary/10 text-primary'
                  : 'border-border text-muted-foreground hover:bg-muted/50'
              }`}
            >
              {CATEGORY_META[cat][lang === 'ar' ? 'ar' : 'en']}
            </button>
          ))}
        </div>

        {/* ---------- Template list ---------- */}
        {loading && templates.length === 0 ? (
          <div className="flex items-center justify-center py-8">
            <Loader2 className="h-5 w-5 animate-spin text-muted-foreground" />
          </div>
        ) : filtered.length === 0 ? (
          <p className="rounded-lg border border-dashed p-6 text-center text-xs text-muted-foreground">
            {t('noTemplates')}
          </p>
        ) : (
          <div className="grid sm:grid-cols-2 gap-2">
            {filtered.map((template) => (
              <TemplateCard
                key={template.id}
                template={template}
                active={template.id === selectedId}
                onSelect={() => select(template)}
              />
            ))}
          </div>
        )}

        {/* ---------- Selected template detail ---------- */}
        {selected && (
          <div className="rounded-xl border border-primary/30 bg-primary/[0.04] p-3 space-y-3">
            <div className="flex flex-wrap items-center gap-2">
              <span className="text-sm font-semibold flex-1 min-w-0" dir="auto">
                {(lang === 'ar' && selected.titleAr) || selected.title}
              </span>
              <Button
                variant="ghost"
                size="icon"
                className="h-7 w-7"
                onClick={() => toggleFavorite(selected)}
                disabled={busy}
                aria-label="favorite"
              >
                <Star
                  className={`h-4 w-4 ${
                    selected.isFavorite ? 'fill-amber-400 text-amber-400' : 'text-muted-foreground'
                  }`}
                />
              </Button>
              {!selected.isBuiltin && (
                <Button
                  variant="ghost"
                  size="icon"
                  className="h-7 w-7 text-red-600 hover:text-red-700"
                  onClick={() => removeTemplate(selected)}
                  disabled={busy}
                  aria-label="delete template"
                >
                  <Trash2 className="h-3.5 w-3.5" />
                </Button>
              )}
            </div>

            {variables.length > 0 && (
              <div className="space-y-2">
                <p className="text-[11px] font-medium text-muted-foreground">{t('fillVariables')}</p>
                {variables.map((name) => (
                  <div key={name} className="flex items-start gap-2">
                    <code className="shrink-0 rounded bg-muted px-1.5 py-1 text-[10px] font-mono text-muted-foreground" dir="ltr">
                      {`{{${name}}}`}
                    </code>
                    <Textarea
                      value={values[name] ?? ''}
                      onChange={(e) => setValues((prev) => ({ ...prev, [name]: e.target.value }))}
                      placeholder={name.replace(/_/g, ' ')}
                      rows={1}
                      dir="auto"
                      className="text-[13px] min-h-8 py-1.5"
                    />
                  </div>
                ))}
              </div>
            )}

            <pre
              dir="auto"
              className="max-h-56 overflow-auto rounded-lg border bg-muted/30 p-2.5 text-[11px] leading-5 whitespace-pre-wrap nice-scroll"
            >
              {preview}
            </pre>

            <div className="flex flex-wrap justify-end gap-1.5">
              <Button size="sm" variant="outline" onClick={() => useTemplate(true)} disabled={busy} className="gap-1.5">
                <Copy className="h-3.5 w-3.5" />
                {t('copyPrompt')}
              </Button>
              <Button size="sm" onClick={() => useTemplate(false)} disabled={busy} className="gap-1.5">
                <Sparkles className="h-3.5 w-3.5" />
                {t('sendToLab')}
              </Button>
            </div>
          </div>
        )}
      </DialogContent>
    </Dialog>
  )
}
