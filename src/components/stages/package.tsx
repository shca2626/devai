'use client'

import { Button } from '@/components/ui/button'
import { Alert, AlertDescription, AlertTitle } from '@/components/ui/alert'
import { useApp } from '@/components/app/context'
import { CodeChip } from '@/components/app/bits'
import type { IdeaDetail } from '@/lib/types'
import { CheckCircle2, FileJson, FileText, Lock } from 'lucide-react'

// ============================================================
// Stage 9 — The engineering package: the final deliverable.
// Locked by the readiness gate; exportable as a 6-section
// Markdown document or structured JSON with traceability.
// ============================================================

const SECTION_KEYS = [
  { n: '01', en: 'Product definition', ar: 'تعريف المنتج' },
  { n: '02', en: 'Functional analysis', ar: 'التحليل الوظيفي' },
  { n: '03', en: 'Data & API design', ar: 'تصميم البيانات والواجهات' },
  { n: '04', en: 'UI/UX specification', ar: 'مواصفة واجهة المستخدم' },
  { n: '05', en: 'Quality & operations', ar: 'الجودة والتشغيل' },
  { n: '06', en: 'Implementation plan', ar: 'خطة التنفيذ' },
]

export function PackageStage({ detail }: { detail: IdeaDetail }) {
  const { t, lang } = useApp()
  const { idea, requirements, processes, entities, apis, screens, tasks, risks, decisions } = detail
  const locked = idea.stage === 'package'

  function exportFile(format: 'md' | 'json') {
    const url = `/api/ideas/${idea.id}/package/export?format=${format}`
    const a = document.createElement('a')
    a.href = url
    a.rel = 'noopener'
    document.body.appendChild(a)
    a.click()
    a.remove()
  }

  if (!locked) {
    return (
      <div className="rounded-xl border border-dashed p-8 text-center space-y-3">
        <Lock className="h-8 w-8 text-muted-foreground mx-auto" />
        <p className="text-sm text-muted-foreground max-w-sm mx-auto leading-6">{t('lockBlocked')}</p>
      </div>
    )
  }

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
      <Alert className="border-emerald-300 bg-emerald-50/70">
        <CheckCircle2 className="h-4 w-4 text-emerald-600" />
        <AlertTitle className="text-sm font-semibold text-emerald-800">{t('packageLockedTitle')}</AlertTitle>
        <AlertDescription className="text-xs text-emerald-700 leading-6">{t('packageLockedBody')}</AlertDescription>
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
                <CheckCircle2 className="h-3.5 w-3.5 text-emerald-600 ms-auto" />
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  )
}
