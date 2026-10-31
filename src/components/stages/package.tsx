'use client'

import { useState } from 'react'
import { Button } from '@/components/ui/button'
import { Alert, AlertDescription, AlertTitle } from '@/components/ui/alert'
import { useApp, VIEW_BY_STAGE } from '@/components/app/context'
import { CodeChip } from '@/components/app/bits'
import type { IdeaDetail } from '@/lib/types'
import { CheckCircle2, FileJson, FileText, Lock, LockOpen, Loader2, Package, ScrollText, ShieldCheck, Zap } from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Stage 9 — The engineering package: the final deliverable.
// NO LIMITS: visible and exportable at ANY stage (it exports
// whatever is confirmed so far). 7-section Markdown document
// (product → data/API with DDL + auth model → UI → quality →
// plan → developer setup) plus appendices (traceability,
// OpenAPI, glossary) or structured JSON.
// ============================================================

const SECTION_KEYS = [
  { n: '01', en: 'Product definition', ar: 'تعريف المنتج' },
  { n: '02', en: 'Functional analysis', ar: 'التحليل الوظيفي' },
  { n: '03', en: 'Data & API design (DDL, contracts, auth model)', ar: 'تصميم البيانات والواجهات (DDL، العقود، نموذج الصلاحيات)' },
  { n: '04', en: 'UI/UX specification', ar: 'مواصفة واجهة المستخدم' },
  { n: '05', en: 'Quality, standards & operations', ar: 'الجودة والمعايير والتشغيل' },
  { n: '06', en: 'Implementation plan', ar: 'خطة التنفيذ' },
  { n: '07', en: 'Developer setup & handoff (env, bootstrap)', ar: 'إعداد المطوّر والتسليم (البيئة، خطوات البدء)' },
  { n: 'A–E', en: 'Appendices: traceability, assumptions, audit, OpenAPI, glossary', ar: 'الملاحق: التتبع، الافتراضات، السجل، OpenAPI، المسرد' },
]

export function PackageStage({ detail }: { detail: IdeaDetail }) {
  const { t, lang, setDetail, refreshIdeas, setView, setContextPackOpen, setConstitutionOpen, setVerifyOpen } = useApp()
  const { toast } = useToast()
  const [reopenOpen, setReopenOpen] = useState(false)
  const [reopenReason, setReopenReason] = useState('')
  const [reopenBusy, setReopenBusy] = useState<string | null>(null)
  const { idea, requirements, processes, entities, apis, screens, tasks, risks, decisions } = detail
  const locked = idea.stage === 'package'
  async function reopen(to: 'understanding' | 'discovery' | 'features' | 'baseline' | 'requirements' | 'design' | 'planning' | 'readiness') {
    setReopenBusy(to)
    const res = await fetch(`/api/ideas/${idea.id}/reopen`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ to, reason: reopenReason }),
    })
    const data = await res.json()
    setReopenBusy(null)
    if (!res.ok) {
      toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
      return
    }
    setDetail(data as IdeaDetail)
    refreshIdeas()
    setReopenOpen(false)
    setReopenReason('')
    setView(VIEW_BY_STAGE[to])
  }

  function exportFile(format: 'md' | 'json') {
    const url = `/api/ideas/${idea.id}/package/export?format=${format}`
    const a = document.createElement('a')
    a.href = url
    a.rel = 'noopener'
    document.body.appendChild(a)
    a.click()
    a.remove()
  }

  // NO LIMITS: no locked teaser — the package view and its exports
  // are available at EVERY stage; the banner just reflects the state.

  const counts = [
    { label: 'FR / NFR', value: `${requirements.filter((r) => r.type === 'functional' && r.status === 'confirmed').length} / ${requirements.filter((r) => r.type === 'non_functional' && r.status === 'confirmed').length}` },
    { label: lang === 'ar' ? 'عمليات' : 'Processes', value: processes.filter((p) => p.status === 'confirmed').length },
    { label: lang === 'ar' ? 'كيانات' : 'Entities', value: entities.filter((e) => e.status === 'confirmed').length },
    { label: 'API', value: apis.filter((a) => a.status === 'confirmed').length },
    { label: lang === 'ar' ? 'شاشات' : 'Screens', value: screens.filter((s) => s.status === 'confirmed').length },
    { label: lang === 'ar' ? 'مهام' : 'Tasks', value: tasks.filter((tk) => tk.status === 'confirmed').length },
    { label: lang === 'ar' ? 'مخاطر' : 'Risks', value: risks.filter((r) => r.status !== 'proposed').length },
    { label: lang === 'ar' ? 'قرارات' : 'Decisions', value: decisions.length },
  ]

  return (
    <div className="space-y-4">
      <Alert className={locked ? 'border-emerald-300 dark:border-emerald-500/30 bg-emerald-50/70 dark:bg-emerald-500/10' : 'border-primary/25 bg-primary/[0.03]'}>
        {locked ? <CheckCircle2 className="h-4 w-4 text-emerald-600 dark:text-emerald-400" /> : <Lock className="h-4 w-4 text-primary" />}
        <AlertTitle className="text-sm font-semibold">{locked ? t('packageLockedTitle') : (lang === 'ar' ? 'معاينة الحزمة الهندسية' : 'Engineering package — preview')}</AlertTitle>
        <AlertDescription className="text-xs leading-6">
          {locked
            ? t('packageLockedBody')
            : lang === 'ar'
              ? 'لم تُقفل الحزمة بعد — يمكنك تصدير ما تم اعتماده حتى الآن في أي وقت (وضع بلا حدود).'
              : 'The package is not locked yet — you can export whatever is confirmed so far at any time (no-limits mode).'}
        </AlertDescription>
        <div className="mt-3 flex flex-wrap gap-2">
          <Button size="sm" onClick={() => exportFile('md')} className="gap-1.5">
            <FileText className="h-3.5 w-3.5" />
            {t('exportPackageMd')}
          </Button>
          <Button size="sm" variant="outline" onClick={() => exportFile('json')} className="gap-1.5">
            <FileJson className="h-3.5 w-3.5" />
            {t('exportPackageJson')}
          </Button>
        </div>
      </Alert>

      {/* Package contents */}
      <div className="rounded-xl border overflow-hidden">
        <div className="border-b bg-muted/50 px-4 py-2.5 text-sm font-semibold">{t('packageContents')}</div>
        <div className="p-4 space-y-4">
          <div className="grid grid-cols-2 sm:grid-cols-4 gap-2">
            {counts.map((c) => (
              <div key={c.label} className="rounded-lg border bg-card p-2.5 text-center">
                <div className="text-lg font-bold tabular-nums text-primary">{c.value}</div>
                <div className="text-[10px] text-muted-foreground mt-0.5">{c.label}</div>
              </div>
            ))}
          </div>
          <div className="space-y-1.5">
            {SECTION_KEYS.map((s) => (
              <div key={s.n} className="flex items-center gap-2.5 rounded-lg border bg-card px-3 py-2">
                <CodeChip code={s.n} />
                <span className="text-[13px] font-medium">{lang === 'ar' ? s.ar : s.en}</span>
                <CheckCircle2 className="h-3.5 w-3.5 text-emerald-600 dark:text-emerald-400 ms-auto" />
              </div>
            ))}
          </div>
        </div>
      </div>

      {/* Vibe-coding handoff — the Context Pack */}
      <div className="rounded-xl border border-primary/30 bg-primary/[0.04] p-4 space-y-3">
        <div className="flex flex-wrap items-center gap-2">
          <Zap className="h-4 w-4 text-primary" />
          <div className="text-sm font-semibold flex-1">{t('handoffTitle')}</div>
        </div>
        <p className="text-xs text-muted-foreground leading-6">{t('handoffBody')}</p>
        <div className="flex flex-wrap gap-2">
          <Button size="sm" onClick={() => setContextPackOpen(true)} className="gap-1.5">
            <Package className="h-3.5 w-3.5" />
            {t('openContextPack')}
          </Button>
          <Button size="sm" variant="outline" onClick={() => setVerifyOpen(true)} className="gap-1.5">
            <ShieldCheck className="h-3.5 w-3.5" />
            {t('verifyAiCode')}
          </Button>
          <Button size="sm" variant="outline" onClick={() => setConstitutionOpen(true)} className="gap-1.5">
            <ScrollText className="h-3.5 w-3.5" />
            {t('openConstitution')}
          </Button>
        </div>
      </div>

      {/* Reopen for changes — nothing ever restarts from zero */}
      <div className="rounded-xl border border-dashed p-4 space-y-3">
        <div className="flex flex-wrap items-center gap-2">
          <LockOpen className="h-4 w-4 text-muted-foreground" />
          <div className="text-sm font-semibold flex-1">{t('reopenTitle')}</div>
          <Button size="sm" variant="outline" onClick={() => setReopenOpen((v) => !v)}>
            {reopenOpen ? t('cancelEdits') : t('reopenTitle')}
          </Button>
        </div>
        {reopenOpen && (
          <div className="space-y-2.5">
            <p className="text-xs text-muted-foreground leading-6">{t('reopenBody')}</p>
            <textarea
              rows={2}
              value={reopenReason}
              onChange={(e) => setReopenReason(e.target.value)}
              placeholder={t('reopenReasonPlaceholder')}
              className="w-full rounded-lg border p-2.5 text-sm leading-6 outline-none focus:ring-2 focus:ring-primary/30"
            />
            <div className="flex flex-wrap gap-2">
              {([
                { key: 'understanding', label: lang === 'ar' ? '← الفهم' : 'Understanding' },
                { key: 'discovery', label: lang === 'ar' ? '← الاستكشاف' : 'Discovery' },
                { key: 'features', label: lang === 'ar' ? '← الميزات' : 'Features' },
                { key: 'baseline', label: lang === 'ar' ? '← خط الأساس' : 'Baseline' },
                { key: 'requirements', label: lang === 'ar' ? '← المتطلبات' : 'Requirements' },
                { key: 'design', label: lang === 'ar' ? '← التصميم' : 'Design' },
                { key: 'planning', label: lang === 'ar' ? '← التخطيط' : 'Planning' },
                { key: 'readiness', label: lang === 'ar' ? '← الجاهزية' : 'Readiness' },
              ] as const).map((target) => (
                <Button
                  key={target.key}
                  size="sm"
                  variant="outline"
                  className="gap-1.5"
                  onClick={() => reopen(target.key)}
                  disabled={reopenBusy !== null}
                >
                  {reopenBusy === target.key ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <LockOpen className="h-3.5 w-3.5" />}
                  {target.label}
                </Button>
              ))}
            </div>
          </div>
        )}
      </div>
    </div>
  )
}
