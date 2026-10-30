'use client'

import { Badge } from '@/components/ui/badge'
import { Progress } from '@/components/ui/progress'
import { ScrollArea } from '@/components/ui/scroll-area'
import {
  Activity,
  CheckCircle2,
  Cpu,
  Database,
  Gauge,
  HardDrive,
  Infinity as InfinityIcon,
  Languages,
  Zap,
} from 'lucide-react'
import { STAGES } from '@/lib/types'

export interface OverviewPayload {
  ok: boolean
  counts: Record<string, number>
  byStage: Record<string, string | number>
  ideas: Array<{ id: string; title: string; stage: string; updatedAt: string; projectType: string | null; sourceLang: string }>
  recentActivity: Array<{ id: string; ideaId: string; action: string; detail: string | null; stage: string | null; createdAt: string }>
  totals: {
    ideas: number
    verificationRuns: number
    driftChecks: number
    siteAnalyses: number
    builtinPlaybooks: number
    globalConstitutionRules: number
  }
  database: { provider: string; path: string | null; sizeBytes: number | null; models: number }
  runtime: {
    nodeVersion: string
    environment: string
    platform: string
    uptimeSeconds: number
    memoryMb: number
    timestamp: string
  }
  ai: { gateway: string; modelConfigured: boolean }
  limits: string
}

function formatBytes(bytes: number | null): string {
  if (bytes === null) return '—'
  if (bytes < 1024) return `${bytes} B`
  if (bytes < 1024 * 1024) return `${(bytes / 1024).toFixed(1)} KB`
  return `${(bytes / 1024 / 1024).toFixed(2)} MB`
}

function formatUptime(seconds: number): string {
  const d = Math.floor(seconds / 86400)
  const h = Math.floor((seconds % 86400) / 3600)
  const m = Math.floor((seconds % 3600) / 60)
  if (d > 0) return `${d}d ${h}h`
  if (h > 0) return `${h}h ${m}m`
  return `${m}m`
}

export function AdminOverview({ data, loading }: { data: OverviewPayload | null; loading: boolean }) {
  if (loading || !data) {
    return <div className="p-8 text-center text-sm text-muted-foreground">Loading overview…</div>
  }

  const stageCounts = STAGES.map((s) => Number(data.byStage[s] ?? 0))
  const maxStage = Math.max(1, ...stageCounts)

  return (
    <div className="space-y-6">
      {/* No-limits banner */}
      <div className="rounded-xl border border-emerald-300 bg-emerald-50/70 p-4 flex flex-col sm:flex-row items-start gap-3">
        <InfinityIcon className="h-5 w-5 text-emerald-600 mt-0.5" />
        <div className="flex-1">
          <div className="text-sm font-semibold text-emerald-800">No-limits mode is ACTIVE</div>
          <p className="text-xs text-emerald-700 leading-6 mt-1">{data.limits}</p>
        </div>
      </div>

      {/* Stat cards */}
      <div className="grid gap-3 grid-cols-2 lg:grid-cols-4">
        {[
          { label: 'Ideas', value: data.totals.ideas, icon: Database, color: 'text-primary' },
          { label: 'Verification runs', value: data.totals.verificationRuns, icon: CheckCircle2, color: 'text-emerald-600' },
          { label: 'Drift checks', value: data.totals.driftChecks, icon: Activity, color: 'text-amber-600' },
          { label: 'Site analyses', value: data.totals.siteAnalyses, icon: HardDrive, color: 'text-sky-600' },
        ].map((s) => (
          <div key={s.label} className="rounded-xl border bg-card p-4">
            <div className="flex items-center justify-between">
              <span className="text-[11px] font-medium uppercase tracking-wide text-muted-foreground">{s.label}</span>
              <s.icon className={`h-4 w-4 ${s.color}`} />
            </div>
            <div className="mt-2 text-3xl font-bold tabular-nums">{s.value}</div>
          </div>
        ))}
      </div>

      <div className="grid gap-6 lg:grid-cols-2">
        {/* Ideas by stage */}
        <div className="rounded-xl border bg-card p-4">
          <div className="flex items-center gap-2 mb-4">
            <Gauge className="h-4 w-4 text-primary" />
            <h3 className="text-sm font-semibold">Ideas by workflow stage</h3>
          </div>
          <div className="space-y-2.5">
            {STAGES.map((stage, i) => (
              <div key={stage} className="flex items-center gap-3">
                <span className="w-28 shrink-0 text-xs font-mono text-muted-foreground">{stage}</span>
                <Progress value={(stageCounts[i] / maxStage) * 100} className="h-2 flex-1" />
                <span className="w-8 text-end text-xs font-semibold tabular-nums">{stageCounts[i]}</span>
              </div>
            ))}
          </div>
          <div className="mt-4 flex flex-wrap gap-1.5 border-t pt-3">
            <Badge variant="outline" className="text-[10px]">{data.totals.builtinPlaybooks} builtin playbooks</Badge>
            <Badge variant="outline" className="text-[10px]">{data.totals.globalConstitutionRules} global rules</Badge>
          </div>
        </div>

        {/* System info */}
        <div className="space-y-6">
          <div className="rounded-xl border bg-card p-4">
            <div className="flex items-center gap-2 mb-3">
              <Database className="h-4 w-4 text-primary" />
              <h3 className="text-sm font-semibold">Database</h3>
            </div>
            <dl className="grid grid-cols-2 gap-x-4 gap-y-2 text-xs">
              <dt className="text-muted-foreground">Provider</dt>
              <dd className="font-mono">{data.database.provider}</dd>
              <dt className="text-muted-foreground">Models</dt>
              <dd className="font-mono">{data.database.models}</dd>
              <dt className="text-muted-foreground">File size</dt>
              <dd className="font-mono">{formatBytes(data.database.sizeBytes)}</dd>
              <dt className="text-muted-foreground">Path</dt>
              <dd className="font-mono col-span-1 truncate" title={data.database.path ?? ''}>{data.database.path ?? '—'}</dd>
            </dl>
          </div>

          <div className="rounded-xl border bg-card p-4">
            <div className="flex items-center gap-2 mb-3">
              <Cpu className="h-4 w-4 text-primary" />
              <h3 className="text-sm font-semibold">Runtime & AI</h3>
            </div>
            <dl className="grid grid-cols-2 gap-x-4 gap-y-2 text-xs">
              <dt className="text-muted-foreground">Node</dt>
              <dd className="font-mono">{data.runtime.nodeVersion}</dd>
              <dt className="text-muted-foreground">Environment</dt>
              <dd className="font-mono">{data.runtime.environment}</dd>
              <dt className="text-muted-foreground">Platform</dt>
              <dd className="font-mono">{data.runtime.platform}</dd>
              <dt className="text-muted-foreground">Uptime</dt>
              <dd className="font-mono">{formatUptime(data.runtime.uptimeSeconds)}</dd>
              <dt className="text-muted-foreground">Memory (RSS)</dt>
              <dd className="font-mono">{data.runtime.memoryMb} MB</dd>
              <dt className="text-muted-foreground">AI gateway</dt>
              <dd className="font-mono flex items-center gap-1">
                <Zap className="h-3 w-3 text-amber-500" />
                {data.ai.modelConfigured ? 'ready' : 'not configured'}
              </dd>
              <dt className="text-muted-foreground">Languages</dt>
              <dd className="font-mono flex items-center gap-1"><Languages className="h-3 w-3" /> ar + en</dd>
            </dl>
          </div>
        </div>
      </div>

      {/* Recent activity */}
      <div className="rounded-xl border bg-card overflow-hidden">
        <div className="border-b bg-muted/50 px-4 py-2.5 text-sm font-semibold flex items-center gap-2">
          <Activity className="h-4 w-4 text-primary" />
          Latest activity (audit trail, newest first)
        </div>
        {data.recentActivity.length === 0 ? (
          <p className="px-4 py-6 text-center text-sm text-muted-foreground">No activity yet.</p>
        ) : (
          <ScrollArea className="max-h-80">
            <div className="divide-y">
              {data.recentActivity.map((a) => (
                <div key={a.id} className="px-4 py-2.5">
                  <div className="flex items-center gap-2 flex-wrap">
                    <span className="text-[13px] font-medium">{a.action}</span>
                    {a.stage && <Badge variant="outline" className="text-[9px] font-mono">{a.stage}</Badge>}
                    <span className="ms-auto text-[10px] text-muted-foreground font-mono">
                      {new Date(a.createdAt).toLocaleString()}
                    </span>
                  </div>
                  {a.detail && <p className="text-xs text-muted-foreground leading-5 mt-0.5 line-clamp-2">{a.detail}</p>}
                </div>
              ))}
            </div>
          </ScrollArea>
        )}
      </div>
    </div>
  )
}
