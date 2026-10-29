'use client'

import { createContext, useCallback, useContext, useEffect, useState } from 'react'
import type { ReactNode } from 'react'
import { t as translate, type DictKey, type UiLang } from '@/lib/i18n'
import type { IdeaDetail, IdeaListItem, Stage } from '@/lib/types'

// ============================================================
// App-wide client state: UI language (AR default), idea list,
// currently selected idea, and API helpers with error surfacing.
// ============================================================

export type ViewName =
  | 'understand'
  | 'discover'
  | 'features'
  | 'baseline'
  | 'requirements'
  | 'design'
  | 'planning'
  | 'readiness'
  | 'package'

export interface AppState {
  lang: UiLang
  setLang: (lang: UiLang) => void
  t: (key: DictKey) => string
  ideas: IdeaListItem[]
  refreshIdeas: () => Promise<void>
  selectedId: string | null
  selectIdea: (id: string | null) => void
  detail: IdeaDetail | null
  setDetail: (d: IdeaDetail | null) => void
  loadingDetail: boolean
  loadDetail: (id: string) => Promise<IdeaDetail | null>
  view: ViewName
  setView: (v: ViewName) => void
  // Vibe-coding handoff dialogs (openable from any stage)
  constitutionOpen: boolean
  setConstitutionOpen: (open: boolean) => void
  contextPackOpen: boolean
  setContextPackOpen: (open: boolean) => void
  verifyOpen: boolean
  setVerifyOpen: (open: boolean) => void
  decisionsOpen: boolean
  setDecisionsOpen: (open: boolean) => void
}

const AppContext = createContext<AppState | null>(null)

// Stage names and view names differ for the first two stages
const VIEW_BY_STAGE: Record<Stage, ViewName> = {
  understanding: 'understand',
  discovery: 'discover',
  features: 'features',
  baseline: 'baseline',
  requirements: 'requirements',
  design: 'design',
  planning: 'planning',
  readiness: 'readiness',
  package: 'package',
}

export function useApp(): AppState {
  const ctx = useContext(AppContext)
  if (!ctx) throw new Error('useApp must be used inside AppProvider')
  return ctx
}

export function AppProvider({ children }: { children: ReactNode }) {
  const [lang, setLangState] = useState<UiLang>('ar')
  const [ideas, setIdeas] = useState<IdeaListItem[]>([])
  const [selectedId, setSelectedId] = useState<string | null>(null)
  const [detail, setDetail] = useState<IdeaDetail | null>(null)
  const [loadingDetail, setLoadingDetail] = useState(false)
  const [view, setView] = useState<ViewName>('understand')
  const [constitutionOpen, setConstitutionOpen] = useState(false)
  const [contextPackOpen, setContextPackOpen] = useState(false)
  const [verifyOpen, setVerifyOpen] = useState(false)
  const [decisionsOpen, setDecisionsOpen] = useState(false)

  // Keep <html lang/dir> in sync with the UI language
  useEffect(() => {
    document.documentElement.lang = lang
    document.documentElement.dir = lang === 'ar' ? 'rtl' : 'ltr'
  }, [lang])

  const setLang = useCallback((next: UiLang) => setLangState(next), [])

  const t = useCallback((key: DictKey) => translate(lang, key), [lang])

  const refreshIdeas = useCallback(async () => {
    try {
      const res = await fetch('/api/ideas')
      if (!res.ok) return
      const data = (await res.json()) as { ideas: IdeaListItem[] }
      setIdeas(data.ideas ?? [])
    } catch {
      // network hiccup — keep the previous list
    }
  }, [])

  useEffect(() => {
    refreshIdeas()
  }, [refreshIdeas])

  const loadDetail = useCallback(async (id: string): Promise<IdeaDetail | null> => {
    setLoadingDetail(true)
    try {
      const res = await fetch(`/api/ideas/${id}`)
      if (!res.ok) {
        setDetail(null)
        return null
      }
      const data = (await res.json()) as IdeaDetail
      setDetail(data)
      return data
    } catch {
      setDetail(null)
      return null
    } finally {
      setLoadingDetail(false)
    }
  }, [])

  const selectIdea = useCallback(
    (id: string | null) => {
      setSelectedId(id)
      setDetail(null)
      if (id) {
        void loadDetail(id).then((loaded) => {
          if (loaded) setView(VIEW_BY_STAGE[loaded.idea.stage] ?? 'understand')
        })
      }
    },
    [loadDetail]
  )

  const value: AppState = {
    lang,
    setLang,
    t,
    ideas,
    refreshIdeas,
    selectedId,
    selectIdea,
    detail,
    setDetail,
    loadingDetail,
    loadDetail,
    view,
    setView,
    constitutionOpen,
    setConstitutionOpen,
    contextPackOpen,
    setContextPackOpen,
    verifyOpen,
    setVerifyOpen,
    decisionsOpen,
    setDecisionsOpen,
  }

  return <AppContext.Provider value={value}>{children}</AppContext.Provider>
}
