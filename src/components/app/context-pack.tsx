'use client'

import { useState } from 'react'
import { Button } from '@/components/ui/button'
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog'
import { Badge } from '@/components/ui/badge'
import { Switch } from '@/components/ui/switch'
import { useApp } from '@/components/app/context'
import type { ContextPackResult, ContextTarget } from '@/lib/types'
import {
  Bot,
  Copy,
  Download,
  FileCode2,
  Loader2,
  MessageSquare,
  Package,
  Sparkles,
  Terminal,
  Wand2,
  Zap,
} from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Context Pack generator — the one-click vibe-coding handoff.
//
// Compiles the project brief + AI constitution + engineering
// artifacts into a single Markdown file framed for the chosen
// target tool (Bolt / Cursor / Claude / ChatGPT / generic).
// Deterministic compilation: the server never lets an AI rewrite
// the spec on its way out.
// ============================================================

const TARGETS: Array<{
  value: ContextTarget
  icon: typeof Bot
  label: { en: string; ar: string }
}> = [
  { value: 'bolt', icon: Zap, label: { en: 'Bolt.new', ar: 'Bolt.new' } },
  { value: 'cursor', icon: Terminal, label: { en: 'Cursor', ar: 'Cursor' } },
  { value: 'claude', icon: Bot, label: { en: 'Claude', ar: 'Claude' } },
  { value: 'chatgpt', icon: MessageSquare, label: { en: 'ChatGPT', ar: 'ChatGPT' } },
  { value: 'generic', icon: FileCode2, label: { en: 'Generic', ar: 'عام' } },
]

const SECTION_TOGGLES = [
  { key: 'includeConstitution', label: { en: 'AI Constitution', ar: 'دستور الذكاء الاصطناعي' } },
  { key: 'includeRequirements', label: { en: 'Requirements', ar: 'المتطلبات' } },
  { key: 'includeArchitecture', label: { en: 'Architecture & stack', ar: 'المعمارية والتقنيات' } },
  { key: 'includeDataModel', label: { en: 'Data model & APIs', ar: 'نموذج البيانات والواجهات' } },
  { key: 'includeScreens', label: { en: 'Screens', ar: 'الشاشات' } },
  { key: 'includeTasks', label: { en: 'Implementation plan', ar: 'خطة التنفيذ' } },
  { key: 'includeRisks', label: { en: 'Risks', ar: 'المخاطر' } },
  { key: 'includeDecisions', label: { en: 'Decision log', ar: 'سجل القرارات' } },
] as const

type SectionKey = (typeof SECTION_TOGGLES)[number]['key']

export function ContextPackDialog({
  open,
  onOpenChange,
}: {
  open: boolean
  onOpenChange: (open: boolean) => void
}) {
  const { t, lang, detail } = useApp()
  const { toast } = useToast()
  const ideaId = detail?.idea.id ?? null
  const ideaTitle = detail?.idea.title ?? 'project'

  const [target, setTarget] = useState<ContextTarget>('bolt')
  const [packLang, setPackLang] = useState<'en' | 'ar'>('en')
  const [sections, setSections] = useState<Record<SectionKey, boolean>>({
    includeConstitution: true,
    includeRequirements: true,
    includeArchitecture: true,
    includeDataModel: true,
    includeScreens: true,
    includeTasks: false,
    includeRisks: true,
    includeDecisions: false,
  })
  const [generating, setGenerating] = useState(false)
  const [result, setResult] = useState<ContextPackResult | null>(null)

  async function generate() {
    if (!ideaId) return
    setGenerating(true)
    try {
      const res = await fetch(`/api/ideas/${ideaId}/context-pack`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ target, lang: packLang, ...sections }),
      })
      const data = (await res.json()) as ContextPackResult & { error?: string }
      if (!res.ok) {
        toast({ description: data.error ?? t('toolsError'), variant: 'destructive' })
        return
      }
      setResult(data)
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setGenerating(false)
    }
  }

  async function copyPack() {
    if (!result) return
    try {
      await navigator.clipboard.writeText(result.markdown)
      toast({ description: t('copiedToClipboard') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    }
  }

  function downloadPack() {
    if (!result) return
    const blob = new Blob([result.markdown], { type: 'text/markdown;charset=utf-8' })
    const url = URL.createObjectURL(blob)
    const a = document.createElement('a')
    a.href = url
    a.download = `context-pack-${ideaTitle.toLowerCase().replace(/[^a-z0-9\u0600-\u06FF]+/g, '-').slice(0, 40) || 'project'}.md`
    document.body.appendChild(a)
    a.click()
    a.remove()
    URL.revokeObjectURL(url)
  }

  return (
    <Dialog open={open} onOpenChange={onOpenChange}>
      <DialogContent className="sm:max-w-2xl max-h-[90vh] overflow-y-auto">
        <DialogHeader>
          <DialogTitle className="flex items-center gap-2">
            <Package className="h-4 w-4 text-primary" />
            {t('contextPackTitle')}
          </DialogTitle>
          <DialogDescription>{t('contextPackBody')}</DialogDescription>
        </DialogHeader>

        {/* ---------- Target tool ---------- */}
        <div className="space-y-1.5">
          <p className="text-xs font-medium text-muted-foreground">{t('packTarget')}</p>
          <div className="grid grid-cols-3 sm:grid-cols-5 gap-1.5">
            {TARGETS.map((option) => {
              const active = option.value === target
              const Icon = option.icon
              return (
                <button
                  key={option.value}
                  type="button"
                  onClick={() => setTarget(option.value)}
                  className={`flex flex-col items-center gap-1 rounded-xl border px-2 py-2.5 transition-colors ${
                    active
                      ? 'border-primary bg-primary/10 text-primary'
                      : 'border-border bg-background text-muted-foreground hover:bg-muted/50 hover:text-foreground'
                  }`}
                >
                  <Icon className="h-4 w-4" />
                  <span className="text-[10px] font-semibold">{option.label[lang === 'ar' ? 'ar' : 'en']}</span>
                </button>
              )
            })}
          </div>
        </div>

        {/* ---------- Pack language ---------- */}
        <div className="flex items-center gap-2">
          <p className="text-xs font-medium text-muted-foreground">{t('packLanguage')}</p>
          <div className="flex items-center rounded-lg border p-0.5">
            <button
              type="button"
              onClick={() => setPackLang('en')}
              className={`rounded-md px-2.5 py-1 text-[11px] font-medium ${packLang === 'en' ? 'bg-primary text-primary-foreground' : 'text-muted-foreground'}`}
            >
              English
            </button>
            <button
              type="button"
              onClick={() => setPackLang('ar')}
              className={`rounded-md px-2.5 py-1 text-[11px] font-medium ${packLang === 'ar' ? 'bg-primary text-primary-foreground' : 'text-muted-foreground'}`}
            >
              العربية
            </button>
          </div>
        </div>

        {/* ---------- Sections ---------- */}
        <div className="space-y-1.5">
          <p className="text-xs font-medium text-muted-foreground">{t('packSections')}</p>
          <div className="grid sm:grid-cols-2 gap-x-4 gap-y-1 rounded-xl border p-3">
            {SECTION_TOGGLES.map((s) => (
              <label key={s.key} className="flex items-center gap-2 py-0.5 cursor-pointer">
                <Switch
                  checked={sections[s.key]}
                  onCheckedChange={(v) => setSections((prev) => ({ ...prev, [s.key]: v }))}
                  className="scale-90"
                />
                <span className="text-xs">{s.label[lang === 'ar' ? 'ar' : 'en']}</span>
              </label>
            ))}
          </div>
        </div>

        <Button onClick={generate} disabled={generating || !ideaId} className="gap-1.5">
          {generating ? <Loader2 className="h-4 w-4 animate-spin" /> : <Wand2 className="h-4 w-4" />}
          {generating ? t('generatingPack') : t('generatePack')}
        </Button>

        {/* ---------- Result ---------- */}
        {result && (
          <div className="space-y-2">
            <div className="flex flex-wrap items-center gap-1.5">
              <Badge variant="outline" className="text-[10px] bg-emerald-50 text-emerald-700 border-emerald-200">
                {result.stats.words.toLocaleString()} {t('wordsCount')}
              </Badge>
              <Badge variant="outline" className="text-[10px]">
                {result.stats.sections} {t('sectionsCount')}
              </Badge>
              <Badge variant="outline" className="text-[10px]">
                {result.stats.rulesApplied} {t('rulesApplied')}
              </Badge>
              <div className="ms-auto flex gap-1.5">
                <Button size="sm" variant="outline" onClick={copyPack} className="gap-1.5">
                  <Copy className="h-3.5 w-3.5" />
                  {t('copyPrompt')}
                </Button>
                <Button size="sm" variant="outline" onClick={downloadPack} className="gap-1.5">
                  <Download className="h-3.5 w-3.5" />
                  {t('downloadMd')}
                </Button>
              </div>
            </div>
            <pre
              dir={packLang === 'ar' ? 'rtl' : 'ltr'}
              className="max-h-[45vh] overflow-auto rounded-xl border bg-muted/30 p-3 text-[11px] leading-5 whitespace-pre-wrap nice-scroll"
            >
              {result.markdown}
            </pre>
          </div>
        )}
      </DialogContent>
    </Dialog>
  )
}
