'use client'

import { Button } from '@/components/ui/button'
import { Sheet, SheetContent, SheetTitle, SheetTrigger } from '@/components/ui/sheet'
import { Skeleton } from '@/components/ui/skeleton'
import { AppProvider, useApp } from '@/components/app/context'
import { Sidebar } from '@/components/app/sidebar'
import { NewIdeaDialog } from '@/components/app/new-idea'
import { ConstitutionDialog } from '@/components/app/constitution'
import { ContextPackDialog } from '@/components/app/context-pack'
import { PlaybookDialog } from '@/components/app/playbook'
import { VerifyDialog } from '@/components/app/verify'
import { Stepper } from '@/components/app/stepper'
import { ExpressRun } from '@/components/app/express'
import { UnderstandStage } from '@/components/stages/understand'
import { DiscoverStage } from '@/components/stages/discover'
import { FeaturesStage } from '@/components/stages/features'
import { BaselineStage } from '@/components/stages/baseline'
import { RequirementsStage } from '@/components/stages/requirements'
import { DesignStage } from '@/components/stages/design'
import { PlanningStage } from '@/components/stages/planning'
import { ReadinessStage } from '@/components/stages/readiness'
import { PackageStage } from '@/components/stages/package'
import { t as translate } from '@/lib/i18n'
import {
  BookOpen,
  Compass,
  DraftingCompass,
  FileSearch,
  Languages,
  Lightbulb,
  ListChecks,
  Menu,
  MessagesSquare,
  Package,
  ScrollText,
  ShieldCheck,
  Sparkles,
} from 'lucide-react'
import { useState } from 'react'

const EXAMPLE_IDEA =
  'أريد تطبيق يربط بين أصحاب المحلات والموردين، ويقارن الأسعار، ويخلي التاجر يطلب المنتجات من عدة موردين بسهولة.'

function WelcomeHero({ onNewIdea }: { onNewIdea: (prefill?: string) => void }) {
  const { t, lang } = useApp()
  const steps = [
    { icon: MessagesSquare, title: t('stageUnderstanding'), desc: t('stepUnderstandDesc') },
    { icon: Lightbulb, title: t('stageDiscovery'), desc: t('stepDiscoverDesc') },
    { icon: ListChecks, title: t('stageFeatures'), desc: t('stepFeaturesDesc') },
    { icon: ShieldCheck, title: t('stageBaseline'), desc: t('stepBaselineDesc') },
  ]
  return (
    <div className="mx-auto max-w-3xl px-4 py-10 sm:py-16 space-y-8">
      <div className="text-center space-y-4">
        <div className="mx-auto flex h-14 w-14 items-center justify-center rounded-2xl bg-primary/10 border border-primary/20">
          <DraftingCompass className="h-7 w-7 text-primary" />
        </div>
        <h1 className="text-2xl sm:text-3xl font-bold tracking-tight">{t('welcomeTitle')}</h1>
        <p className="text-muted-foreground text-sm sm:text-base leading-7 max-w-xl mx-auto">{t('welcomeBody')}</p>
        <div className="flex flex-col sm:flex-row items-center justify-center gap-2 pt-2">
          <Button size="lg" onClick={() => onNewIdea()} className="gap-2 w-full sm:w-auto">
            <Sparkles className="h-4 w-4" />
            {t('newIdea')}
          </Button>
          <Button size="lg" variant="outline" onClick={() => onNewIdea(EXAMPLE_IDEA)} className="w-full sm:w-auto">
            {t('tryExample')}
          </Button>
        </div>
      </div>

      <div className="grid gap-3 sm:grid-cols-2">
        {steps.map((step, i) => (
          <div key={step.title} className="rounded-xl border bg-card p-4 flex gap-3">
            <div className="flex h-9 w-9 shrink-0 items-center justify-center rounded-lg bg-primary/10">
              <step.icon className="h-4.5 w-4.5 text-primary" />
            </div>
            <div>
              <div className="text-sm font-semibold flex items-center gap-2">
                <span className="text-muted-foreground font-mono text-xs">{i + 1}</span>
                {step.title}
              </div>
              <p className="text-xs text-muted-foreground leading-6 mt-1">{step.desc}</p>
            </div>
          </div>
        ))}
      </div>
      <p className="text-center text-[11px] text-muted-foreground">
        {translate(lang, 'appTagline')}
      </p>
    </div>
  )
}

function IdeaView() {
  const { detail, view, loadingDetail, t } = useApp()

  if (loadingDetail && !detail) {
    return (
      <div className="space-y-4 p-4 sm:p-6">
        <Skeleton className="h-8 w-64" />
        <Skeleton className="h-40 w-full" />
        <div className="grid grid-cols-3 gap-4">
          <Skeleton className="h-28" />
          <Skeleton className="h-28" />
          <Skeleton className="h-28" />
        </div>
      </div>
    )
  }
  if (!detail) return null

  return (
    <div className="space-y-4 p-4 sm:p-6">
      <header className="space-y-3">
        <h1 className="text-lg sm:text-xl font-bold tracking-tight line-clamp-2" dir="auto">
          {detail.idea.title}
        </h1>
        <Stepper currentStage={detail.idea.stage} view={view} />
      </header>
      {detail.idea.stage !== 'package' && <ExpressRun detail={detail} />}
      <main>
        {view === 'understand' && <UnderstandStage detail={detail} />}
        {view === 'discover' && <DiscoverStage detail={detail} />}
        {view === 'features' && <FeaturesStage detail={detail} />}
        {view === 'baseline' && <BaselineStage detail={detail} />}
        {view === 'requirements' && <RequirementsStage detail={detail} />}
        {view === 'design' && <DesignStage detail={detail} />}
        {view === 'planning' && <PlanningStage detail={detail} />}
        {view === 'readiness' && <ReadinessStage detail={detail} />}
        {view === 'package' && <PackageStage detail={detail} />}
      </main>
      <p className="sr-only">{t('loading')}</p>
    </div>
  )
}

function Shell() {
  const { lang, setLang, t, selectedId, selectIdea, refreshIdeas, constitutionOpen, setConstitutionOpen, contextPackOpen, setContextPackOpen, verifyOpen, setVerifyOpen } = useApp()
  const [newIdeaOpen, setNewIdeaOpen] = useState(false)
  const [mobileNavOpen, setMobileNavOpen] = useState(false)
  const [prefill, setPrefill] = useState<string | undefined>(undefined)
  const [playbookOpen, setPlaybookOpen] = useState(false)
  const [labPrompt, setLabPrompt] = useState<string | undefined>(undefined)

  function openNewIdea(prefillText?: string) {
    setPrefill(prefillText)
    setNewIdeaOpen(true)
  }

  function sendToLab(prompt: string) {
    setLabPrompt(prompt)
    setNewIdeaOpen(true)
  }

  return (
    <div className="min-h-screen flex flex-col bg-muted/20">
      {/* Header */}
      <header className="sticky top-0 z-40 border-b bg-background/90 backdrop-blur supports-[backdrop-filter]:bg-background/75">
        <div className="flex h-14 items-center gap-2 px-3 sm:px-4">
          <Sheet open={mobileNavOpen} onOpenChange={setMobileNavOpen}>
            <SheetTrigger asChild>
              <Button variant="ghost" size="icon" className="lg:hidden" aria-label="Menu">
                <Menu className="h-5 w-5" />
              </Button>
            </SheetTrigger>
            <SheetContent side={lang === 'ar' ? 'right' : 'left'} className="p-0 w-80">
              <SheetTitle className="sr-only">{t('workspace')}</SheetTitle>
              <Sidebar
                onNewIdea={() => {
                  setMobileNavOpen(false)
                  openNewIdea()
                }}
              />
            </SheetContent>
          </Sheet>

          <button
            type="button"
            className="flex items-center gap-2 font-bold text-[15px] hover:opacity-80 transition-opacity"
            onClick={() => selectIdea(null)}
            aria-label={t('appName')}
          >
            <span className="flex h-8 w-8 items-center justify-center rounded-lg bg-primary text-primary-foreground">
              <Compass className="h-4.5 w-4.5" />
            </span>
            <span>{t('appName')}</span>
          </button>

          <span className="hidden md:inline-flex items-center rounded-full border px-2.5 py-0.5 text-[10px] text-muted-foreground font-arabic" dir="rtl">
            مساعد المخطط
          </span>

          <div className="ms-auto flex items-center gap-1.5">
            {selectedId && (
              <Button
                variant="ghost"
                size="sm"
                onClick={() => setContextPackOpen(true)}
                className="gap-1.5 min-h-9"
                aria-label={t('openContextPack')}
                title={t('openContextPack')}
              >
                <Package className="h-4 w-4 text-primary" />
                <span className="hidden xl:inline text-xs font-medium">{t('openContextPack')}</span>
              </Button>
            )}
            {selectedId && (
              <Button
                variant="ghost"
                size="sm"
                onClick={() => setVerifyOpen(true)}
                className="gap-1.5 min-h-9"
                aria-label={t('openVerifier')}
                title={t('verifierTitle')}
              >
                <FileSearch className="h-4 w-4 text-primary" />
                <span className="hidden xl:inline text-xs font-medium">{t('openVerifier')}</span>
              </Button>
            )}
            <Button
              variant="ghost"
              size="sm"
              onClick={() => setPlaybookOpen(true)}
              className="gap-1.5 min-h-9"
              aria-label={t('openPlaybook')}
              title={t('openPlaybook')}
            >
              <BookOpen className="h-4 w-4 text-primary" />
              <span className="hidden xl:inline text-xs font-medium">{t('openPlaybook')}</span>
            </Button>
            <Button
              variant="ghost"
              size="sm"
              onClick={() => setConstitutionOpen(true)}
              className="gap-1.5 min-h-9"
              aria-label={t('openConstitution')}
              title={t('openConstitution')}
            >
              <ScrollText className="h-4 w-4 text-primary" />
              <span className="hidden xl:inline text-xs font-medium">{t('openConstitution')}</span>
            </Button>
            <Button
              variant="ghost"
              size="sm"
              onClick={() => setLang(lang === 'ar' ? 'en' : 'ar')}
              className="gap-1.5 min-h-9"
              aria-label={t('langToggle')}
            >
              <Languages className="h-4 w-4" />
              <span className="text-xs font-medium">{t('langToggle')}</span>
            </Button>
            <Button size="sm" onClick={() => openNewIdea()} className="gap-1.5 min-h-9">
              <Sparkles className="h-3.5 w-3.5" />
              <span className="hidden sm:inline">{t('newIdea')}</span>
            </Button>
          </div>
        </div>
      </header>

      {/* Body */}
      <div className="flex flex-1 min-h-0">
        {/* Desktop sidebar */}
        <aside className="hidden lg:block w-72 xl:w-80 shrink-0 border-e bg-background">
          <Sidebar onNewIdea={() => openNewIdea()} />
        </aside>

        {/* Main */}
        <div className="flex-1 min-w-0">
          <div className="mx-auto max-w-4xl">
            {selectedId ? <IdeaView /> : <WelcomeHero onNewIdea={openNewIdea} />}
          </div>
        </div>
      </div>

      {/* Footer (sticky) */}
      <footer className="mt-auto border-t bg-background">
        <div className="flex flex-col sm:flex-row items-center justify-between gap-1 px-4 py-3 text-[11px] text-muted-foreground">
          <span className="font-arabic" dir="rtl">
            مساعد المهندس — لا يُبنى أي شيء على افتراض غير معتمد
          </span>
          <span dir="ltr">AI Software Engineer · من فكرة إلى حزمة هندسية جاهزة للتنفيذ · {new Date().getFullYear()}</span>
        </div>
      </footer>

      {newIdeaOpen && (
        <NewIdeaDialog
          open={newIdeaOpen}
          onOpenChange={(v) => {
            setNewIdeaOpen(v)
            if (!v) {
              setPrefill(undefined)
              setLabPrompt(undefined)
            }
          }}
          onCreated={(ideaId) => {
            refreshIdeas()
            selectIdea(ideaId)
          }}
          prefill={labPrompt ?? prefill}
        />
      )}

      <ConstitutionDialog open={constitutionOpen} onOpenChange={setConstitutionOpen} />
      <ContextPackDialog open={contextPackOpen} onOpenChange={setContextPackOpen} />
      <VerifyDialog open={verifyOpen} onOpenChange={setVerifyOpen} />
      <PlaybookDialog open={playbookOpen} onOpenChange={setPlaybookOpen} onSendToLab={sendToLab} />
    </div>
  )
}

export default function Page() {
  return (
    <AppProvider>
      <Shell />
    </AppProvider>
  )
}
