'use client'

import { useCallback, useEffect, useState } from 'react'
import Link from 'next/link'
import { Button } from '@/components/ui/button'
import { AdminOverview, type OverviewPayload } from '@/components/admin/overview'
import { AdminDatabase } from '@/components/admin/database'
import { AdminIdeas, type AdminIdea } from '@/components/admin/ideas'
import { AdminFeatures } from '@/components/admin/features'
import { AdminApi } from '@/components/admin/api-explorer'
import { AdminEngines } from '@/components/admin/engines'
import { AdminMaintenance } from '@/components/admin/maintenance'
import { SCHEMA_MODELS } from '@/lib/admin/schema-meta'
import { cn } from '@/lib/utils'
import {
  Activity,
  ArrowLeft,
  Boxes,
  Database,
  FileCode2,
  Gauge,
  Infinity as InfinityIcon,
  Lightbulb,
  ScrollText,
  Wrench,
} from 'lucide-react'

// ============================================================
// /admin — the full control & understanding panel:
//   Overview    — live stats, runtime, DB info, audit feed
//   Database    — browse/search/clear all 20 models + schema
//   Ideas       — jump any idea to any stage, delete
//   Features    — what every stage & tool does (the system map)
//   API         — every endpoint, grouped, live try-it
//   Engines     — the AI layer + no-limits policy
//   Maintenance — export DB, scoped resets
// ============================================================

type Section = 'overview' | 'database' | 'ideas' | 'features' | 'api' | 'engines' | 'maintenance'

const NAV: Array<{ key: Section; label: string; icon: typeof Gauge }> = [
  { key: 'overview', label: 'Overview', icon: Gauge },
  { key: 'database', label: 'Database', icon: Database },
  { key: 'ideas', label: 'Ideas', icon: Lightbulb },
  { key: 'features', label: 'Features', icon: Boxes },
  { key: 'api', label: 'API', icon: FileCode2 },
  { key: 'engines', label: 'Engines', icon: Wrench },
  { key: 'maintenance', label: 'Maintenance', icon: ScrollText },
]

export default function AdminPage() {
  const [section, setSection] = useState<Section>('overview')
  const [overview, setOverview] = useState<OverviewPayload | null>(null)
  const [loading, setLoading] = useState(true)

  const loadOverview = useCallback(async () => {
    setLoading(true)
    try {
      const res = await fetch('/api/admin/overview')
      if (res.ok) {
        setOverview((await res.json()) as OverviewPayload)
      }
    } catch {
      // keep previous data
    } finally {
      setLoading(false)
    }
  }, [])

  useEffect(() => {
    loadOverview()
  }, [loadOverview])

  const ideas: AdminIdea[] = overview?.ideas ?? []
  const counts: Record<string, number> = overview?.counts ?? {}

  return (
    <div className="min-h-screen bg-muted/20" dir="ltr">
      {/* Header */}
      <header className="sticky top-0 z-40 border-b bg-background/90 backdrop-blur">
        <div className="mx-auto max-w-7xl flex h-14 items-center gap-3 px-4">
          <span className="flex h-8 w-8 items-center justify-center rounded-lg bg-primary text-primary-foreground">
            <Activity className="h-4.5 w-4.5" />
          </span>
          <div>
            <div className="text-[15px] font-bold leading-tight">Admin Control Panel</div>
            <div className="text-[10px] text-muted-foreground leading-tight">
              AI Software Engineer · full system control & documentation
            </div>
          </div>
          <span className="hidden sm:inline-flex items-center gap-1 rounded-full border border-emerald-300 dark:border-emerald-500/30 bg-emerald-50 dark:bg-emerald-500/10 px-2 py-0.5 text-[10px] font-semibold text-emerald-700">
            <InfinityIcon className="h-3 w-3" />
            NO LIMITS
          </span>
          <div className="ms-auto flex items-center gap-2">
            <span className="hidden md:inline text-[11px] text-muted-foreground tabular-nums">
              {SCHEMA_MODELS.length} models · {ideas.length} ideas
            </span>
            <Button variant="outline" size="sm" className="gap-1.5" asChild>
              <Link href="/">
                <ArrowLeft className="h-3.5 w-3.5" />
                Back to app
              </Link>
            </Button>
          </div>
        </div>
      </header>

      <div className="mx-auto max-w-7xl flex">
        {/* Sidebar */}
        <aside className="hidden lg:block w-56 shrink-0 border-e bg-background min-h-[calc(100vh-3.5rem)]">
          <nav className="p-3 space-y-1 sticky top-14">
            {NAV.map((item) => (
              <button
                key={item.key}
                type="button"
                onClick={() => setSection(item.key)}
                className={cn(
                  'w-full flex items-center gap-2.5 rounded-lg px-3 py-2 text-[13px] font-medium transition-colors text-start',
                  section === item.key
                    ? 'bg-primary text-primary-foreground'
                    : 'text-muted-foreground hover:bg-muted/60 hover:text-foreground'
                )}
              >
                <item.icon className="h-4 w-4" />
                {item.label}
              </button>
            ))}
          </nav>
        </aside>

        {/* Mobile nav */}
        <div className="lg:hidden fixed bottom-0 inset-x-0 z-40 border-t bg-background/95 backdrop-blur flex overflow-x-auto nice-scroll">
          {NAV.map((item) => (
            <button
              key={item.key}
              type="button"
              onClick={() => setSection(item.key)}
              className={cn(
                'flex flex-col items-center gap-0.5 px-3.5 py-2 text-[10px] font-medium shrink-0',
                section === item.key ? 'text-primary' : 'text-muted-foreground'
              )}
            >
              <item.icon className="h-4 w-4" />
              {item.label}
            </button>
          ))}
        </div>

        {/* Main */}
        <main className="flex-1 min-w-0 p-4 sm:p-6 pb-24 lg:pb-6">
          {section === 'overview' && <AdminOverview data={overview} loading={loading} />}
          {section === 'database' && <AdminDatabase counts={counts} />}
          {section === 'ideas' && <AdminIdeas ideas={ideas} onChanged={loadOverview} />}
          {section === 'features' && <AdminFeatures />}
          {section === 'api' && <AdminApi />}
          {section === 'engines' && <AdminEngines />}
          {section === 'maintenance' && <AdminMaintenance onDataChanged={loadOverview} />}
        </main>
      </div>
    </div>
  )
}
