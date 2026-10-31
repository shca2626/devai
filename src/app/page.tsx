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
import { DecisionsDialog } from '@/components/app/decisions'
import { SiteIntelDialog } from '@/components/app/site-intel'
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
  Globe,
  Languages,
  Lightbulb,
  ListChecks,
  Menu,
  MessagesSquare,
  Moon,
  Package,
  Radar,
  Scale,
  ScrollText,
  ShieldCheck,
  Sparkles,
  Sun,
} from 'lucide-react'
import { useEffect, useState } from 'react'

const EXAMPLE_IDEA =
  'أريد تطبيق يربط بين أصحاب المحلات والموردين، ويقارن الأسعار، ويخلي التاجر يطلب المنتجات من عدة موردين بسهولة.'

// Mobile tool-strip chip: compact pill, icon + label, springy on tap
const TOOL_CHIP =
  'inline-flex h-8 shrink-0 items-center gap-1.5 rounded-full border bg-card px-3 text-xs font-medium text-foreground/75 transition-all hover:border-primary/40 hover:text-foreground active:scale-95 disabled:pointer-events-none disabled:opacity-45'

function WelcomeHero({ onNewIdea, onSiteIntel }: { onNewIdea: (prefill?: string) => void; onSiteIntel: () => void }) {
  const { t, lang } = useApp()
  const steps = [
    { icon: MessagesSquare, title: t('stageUnderstanding'), desc: t('stepUnderstandDesc') },
    { icon: Lightbulb, title: t('stageDiscovery'), desc: t('stepDiscoverDesc') },
    { icon: ListChecks, title: t('stageFeatures'), desc: t('stepFeaturesDesc') },
    { icon: ShieldCheck, title: t('stageBaseline'), desc: t('stepBaselineDesc') },
  ]
  return (
    <div className="relative mx-auto max-w-3xl px-4 py-8 sm:py-16 space-y-7 sm:space-y-9">
      {/* Ambient gradient backdrop */}
      <div aria-hidden className="pointer-events-none absolute inset-0 -z-10 overflow-hidden">
        <div className="absolute -top-24 left-1/2 h-72 w-72 -translate-x-1/2 rounded-full bg-primary/15 blur-3xl" />
        <div className="absolute top-24 -end-16 h-56 w-56 rounded-full bg-violet-400/10 dark:bg-violet-500/10 blur-3xl" />
        <div className="absolute -bottom-10 -start-16 h-56 w-56 rounded-full bg-teal-400/10 dark:bg-teal-500/10 blur-3xl" />
      </div>

      <div className="text-center space-y-4">
        <div className="mx-auto flex h-16 w-16 items-center justify-center rounded-2xl bg-gradient-to-br from-primary to-violet-500 shadow-xl shadow-primary/25">
          <DraftingCompass className="h-8 w-8 text-white" />
        </div>
        <h1 className="text-2xl sm:text-4xl font-bold tracking-tight leading-tight">
          {t('welcomeTitle')}
        </h1>
        <p className="text-muted-foreground text-[13px] leading-6 sm:text-base sm:leading-7 max-w-xl mx-auto">
          {t('welcomeBody')}
        </p>
        <div className="flex flex-col sm:flex-row items-center justify-center gap-2.5 pt-2">
          <Button
            size="lg"
            onClick={() => onNewIdea()}
            className="gap-2 w-full sm:w-auto bg-gradient-to-r from-primary to-violet-500 hover:from-primary/90 hover:to-violet-500/90 shadow-lg shadow-primary/25 transition-all hover:-translate-y-0.5"
          >
            <Sparkles className="h-4 w-4" />
            {t('newIdea')}
          </Button>
          <Button
            size="lg"
            variant="outline"
            onClick={() => onNewIdea(EXAMPLE_IDEA)}
            className="w-full sm:w-auto transition-all hover:-translate-y-0.5"
          >
            {t('tryExample')}
          </Button>
          <Button
            size="lg"
            variant="ghost"
            onClick={onSiteIntel}
            className="gap-2 w-full sm:w-auto text-muted-foreground hover:text-foreground transition-all hover:-translate-y-0.5"
            aria-label={t('siteIntelTitle')}
            title={t('siteIntelBody')}
          >
            <Globe className="h-4 w-4 text-primary" />
            {t('siteIntelTitle')}
          </Button>
        </div>
      </div>

      <div className="grid gap-3 sm:grid-cols-2">
        {steps.map((step, i) => (
          <div
            key={step.title}
            className="group rounded-xl sm:rounded-2xl border bg-card p-3.5 sm:p-4 flex gap-3 transition-all hover:-translate-y-0.5 hover:shadow-md hover:border-primary/30"
          >
            <div className="flex h-9 w-9 shrink-0 items-center justify-center rounded-lg bg-gradient-to-br from-primary/15 to-violet-500/10 group-hover:from-primary/20 group-hover:to-violet-500/15 transition-colors">
              <step.icon className="h-4.5 w-4.5 text-primary" />
            </div>
            <div className="min-w-0">
              <div className="text-sm font-semibold flex items-center gap-2">
                <span className="font-mono text-[11px] text-primary/70">0{i + 1}</span>
                <span className="truncate">{step.title}</span>
              </div>
              <p className="text-xs text-muted-foreground leading-6 mt-1">{step.desc}</p>
            </div>
          </div>
        ))}
      </div>
      <p className="text-center text-[11px] text-muted-foreground" dir={lang === 'ar' ? 'rtl' : 'ltr'}>
        {translate(lang, 'appTagline')}
      </p>
    </div>
  )
}

function IdeaView() {
  const { detail, view, loadingDetail, t } = useApp()

  if (loadingDetail && !detail) {
    return (
      <div className="space-y-4 p-3 sm:p-6">
        <Skeleton className="shimmer h-8 w-64" />
        <Skeleton className="shimmer h-10 w-full max-w-xl" />
        <Skeleton className="shimmer h-40 w-full" />
        <div className="grid grid-cols-3 gap-4">
          <Skeleton className="shimmer h-28" />
          <Skeleton className="shimmer h-28" />
          <Skeleton className="shimmer h-28" />
        </div>
      </div>
    )
  }
  if (!detail) return null

  return (
    <div className="space-y-3.5 p-3 sm:space-y-5 sm:p-5 lg:p-6">
      <header className="space-y-2.5 sm:space-y-3">
        <h1 className="text-[17px] sm:text-xl lg:text-2xl font-bold tracking-tight line-clamp-2" dir="auto">
          {detail.idea.title}
        </h1>
        <Stepper currentStage={detail.idea.stage} view={view} />
      </header>
      {detail.idea.stage !== 'package' && <ExpressRun detail={detail} />}
      <main key={view} className="animate-in fade-in slide-in-from-bottom-2 duration-300">
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
  const { lang, setLang, t, selectedId, selectIdea, refreshIdeas, constitutionOpen, setConstitutionOpen, contextPackOpen, setContextPackOpen, verifyOpen, setVerifyOpen, decisionsOpen, setDecisionsOpen, siteIntelOpen, setSiteIntelOpen } = useApp()
  const [newIdeaOpen, setNewIdeaOpen] = useState(false)
  const [mobileNavOpen, setMobileNavOpen] = useState(false)
  const [prefill, setPrefill] = useState<string | undefined>(undefined)
  const [playbookOpen, setPlaybookOpen] = useState(false)
  const [labPrompt, setLabPrompt] = useState<string | undefined>(undefined)
  const [dark, setDark] = useState(false)

  // Sync React state with the pre-paint theme set by the inline script
  useEffect(() => {
    setDark(document.documentElement.classList.contains('dark'))
  }, [])

  function toggleTheme() {
    const next = !document.documentElement.classList.contains('dark')
    document.documentElement.classList.toggle('dark', next)
    try {
      localStorage.setItem('devai-theme', next ? 'dark' : 'light')
    } catch {
      // private mode — theme just won't persist
    }
    setDark(next)
  }

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
        <div className="flex h-12 items-center gap-2 px-3 sm:h-14 sm:px-4">
          <Sheet open={mobileNavOpen} onOpenChange={setMobileNavOpen}>
            <SheetTrigger asChild>
              <Button variant="ghost" size="icon" className="lg:hidden" aria-label="Menu">
                <Menu className="h-5 w-5" />
              </Button>
            </SheetTrigger>
            <SheetContent
              side={lang === 'ar' ? 'right' : 'left'}
              className="p-0 w-[290px] max-w-[85vw] rounded-e-2xl shadow-2xl"
            >
              <SheetTitle className="sr-only">{t('workspace')}</SheetTitle>
              <Sidebar
                onNewIdea={() => {
                  setMobileNavOpen(false)
                  openNewIdea()
                }}
                onNavigate={() => setMobileNavOpen(false)}
              />
            </SheetContent>
          </Sheet>

          <button
            type="button"
            className="flex items-center gap-2 font-bold text-[15px] hover:opacity-80 transition-opacity min-w-0"
            onClick={() => selectIdea(null)}
            aria-label={t('appName')}
          >
            <span className="flex h-8 w-8 shrink-0 items-center justify-center rounded-lg bg-gradient-to-br from-primary to-violet-500 shadow-md shadow-primary/20">
              <Compass className="h-4.5 w-4.5 text-white" />
            </span>
            <span className="hidden sm:inline truncate">{t('appName')}</span>
          </button>

          <span className="hidden lg:inline-flex items-center rounded-full border px-2.5 py-0.5 text-[10px] text-muted-foreground font-arabic" dir="rtl">
            مساعد المخطط
          </span>

          <div className="ms-auto flex items-center gap-1 sm:gap-1.5 min-w-0">
            {/* Full tool buttons — md and up */}
            <div className="hidden md:flex items-center gap-1.5">
              {selectedId && (
                <Button
                  variant="ghost"
                  size="sm"
                  onClick={() => setContextPackOpen(true)}
                  className="gap-1.5 min-h-9 px-2.5 xl:px-3"
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
                  className="gap-1.5 min-h-9 px-2.5 xl:px-3"
                  aria-label={t('openVerifier')}
                  title={t('verifierTitle')}
                >
                  <FileSearch className="h-4 w-4 text-primary" />
                  <span className="hidden xl:inline text-xs font-medium">{t('openVerifier')}</span>
                </Button>
              )}
              {selectedId && (
                <Button
                  variant="ghost"
                  size="sm"
                  onClick={() => setDecisionsOpen(true)}
                  className="gap-1.5 min-h-9 px-2.5 xl:px-3"
                  aria-label={t('openDecisions')}
                  title={t('decisionsTitle')}
                >
                  <Scale className="h-4 w-4 text-primary" />
                  <span className="hidden xl:inline text-xs font-medium">{t('openDecisions')}</span>
                </Button>
              )}
              {/* Site Intelligence — public tool, works with or without an idea */}
              <Button
                variant="ghost"
                size="sm"
                onClick={() => setSiteIntelOpen(true)}
                className="gap-1.5 min-h-9 px-2.5 xl:px-3"
                aria-label={t('openSiteIntel')}
                title={t('siteIntelTitle')}
              >
                <Radar className="h-4 w-4 text-primary" />
                <span className="hidden xl:inline text-xs font-medium">{t('openSiteIntel')}</span>
              </Button>
              <Button
                variant="ghost"
                  size="sm"
                onClick={() => setPlaybookOpen(true)}
                className="gap-1.5 min-h-9 px-2.5 xl:px-3"
                aria-label={t('openPlaybook')}
                title={t('openPlaybook')}
              >
                <BookOpen className="h-4 w-4 text-primary" />
                <span className="hidden xl:inline text-xs font-medium">{t('openPlaybook')}</span>
              </Button>
              <a
                href="/admin"
                className="inline-flex items-center gap-1.5 rounded-md px-2.5 min-h-9 text-xs font-medium text-muted-foreground hover:bg-muted/60 hover:text-foreground transition-colors"
                aria-label="Admin panel"
                title="Admin panel — full control & system documentation"
              >
                <ShieldCheck className="h-4 w-4 text-primary" />
                <span className="hidden xl:inline">Admin</span>
              </a>
              <Button
                variant="ghost"
                size="sm"
                onClick={() => setConstitutionOpen(true)}
                className="gap-1.5 min-h-9 px-2.5 xl:px-3"
                aria-label={t('openConstitution')}
                title={t('openConstitution')}
              >
                <ScrollText className="h-4 w-4 text-primary" />
                <span className="hidden xl:inline text-xs font-medium">{t('openConstitution')}</span>
              </Button>
            </div>

            <Button
              variant="ghost"
              size="sm"
              onClick={toggleTheme}
              className="gap-1.5 min-h-9 px-2 sm:px-3"
              aria-label={t('themeToggle')}
              title={t('themeToggle')}
            >
              {dark ? <Sun className="h-4 w-4" /> : <Moon className="h-4 w-4" />}
              <span className="hidden sm:inline text-xs font-medium">{t('themeToggle')}</span>
            </Button>
            <Button
              variant="ghost"
              size="sm"
              onClick={() => setLang(lang === 'ar' ? 'en' : 'ar')}
              className="gap-1.5 min-h-9 px-2 sm:px-3"
              aria-label={t('langToggle')}
              title={t('langToggle')}
            >
              <Languages className="h-4 w-4" />
              <span className="hidden sm:inline text-xs font-medium">{t('langToggle')}</span>
            </Button>
            <Button size="sm" onClick={() => openNewIdea()} className="gap-1.5 min-h-9 px-2.5 sm:px-3">
              <Sparkles className="h-3.5 w-3.5" />
              <span className="hidden sm:inline">{t('newIdea')}</span>
            </Button>
          </div>
        </div>

        {/* Mobile tool strip — every tool visible and one tap away */}
        <div className="border-t border-border/70 bg-background/60 md:hidden" role="toolbar" aria-label={t('toolsMenu')}>
          <div className="nice-scroll flex h-11 items-center gap-1.5 overflow-x-auto px-3">
            <button
              type="button"
              onClick={() => setContextPackOpen(true)}
              disabled={!selectedId}
              title={selectedId ? t('openContextPack') : t('selectIdeaFirst')}
              className={TOOL_CHIP}
            >
              <Package className="h-3.5 w-3.5 text-primary" />
              {t('openContextPack')}
            </button>
            <button
              type="button"
              onClick={() => setVerifyOpen(true)}
              disabled={!selectedId}
              title={selectedId ? t('openVerifier') : t('selectIdeaFirst')}
              className={TOOL_CHIP}
            >
              <FileSearch className="h-3.5 w-3.5 text-primary" />
              {t('openVerifier')}
            </button>
            <button
              type="button"
              onClick={() => setDecisionsOpen(true)}
              disabled={!selectedId}
              title={selectedId ? t('openDecisions') : t('selectIdeaFirst')}
              className={TOOL_CHIP}
            >
              <Scale className="h-3.5 w-3.5 text-primary" />
              {t('openDecisions')}
            </button>
            {/* Site Intelligence — public tool, no idea required */}
            <button
              type="button"
              onClick={() => setSiteIntelOpen(true)}
              title={t('siteIntelTitle')}
              className={TOOL_CHIP}
            >
              <Radar className="h-3.5 w-3.5 text-primary" />
              {t('openSiteIntel')}
            </button>
            <button
              type="button"
              onClick={() => setPlaybookOpen(true)}
              title={t('openPlaybook')}
              className={TOOL_CHIP}
            >
              <BookOpen className="h-3.5 w-3.5 text-primary" />
              {t('openPlaybook')}
            </button>
            <button
              type="button"
              onClick={() => setConstitutionOpen(true)}
              title={t('openConstitution')}
              className={TOOL_CHIP}
            >
              <ScrollText className="h-3.5 w-3.5 text-primary" />
              {t('openConstitution')}
            </button>
            <a
              href="/admin"
              className={TOOL_CHIP}
              title="Admin panel — full control & system documentation"
            >
              <ShieldCheck className="h-3.5 w-3.5 text-primary" />
              Admin
            </a>
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
            {selectedId ? <IdeaView /> : <WelcomeHero onNewIdea={openNewIdea} onSiteIntel={() => setSiteIntelOpen(true)} />}
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
      <DecisionsDialog open={decisionsOpen} onOpenChange={setDecisionsOpen} />
      <SiteIntelDialog open={siteIntelOpen} onOpenChange={setSiteIntelOpen} />
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
