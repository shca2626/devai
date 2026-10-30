'use client'

import { useCallback, useEffect, useState } from 'react'
import { Badge } from '@/components/ui/badge'
import { Button } from '@/components/ui/button'
import { Input } from '@/components/ui/input'
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from '@/components/ui/select'
import {
  AlertDialog,
  AlertDialogAction,
  AlertDialogCancel,
  AlertDialogContent,
  AlertDialogDescription,
  AlertDialogFooter,
  AlertDialogHeader,
  AlertDialogTitle,
} from '@/components/ui/alert-dialog'
import {
  ChevronLeft,
  ChevronRight,
  Database,
  KeyRound,
  Link2,
  RefreshCw,
  Search,
  Table2,
  Trash2,
} from 'lucide-react'
import { SCHEMA_MODELS, type SchemaModel } from '@/lib/admin/schema-meta'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Admin database browser — browse, search, inspect, edit and
// delete rows in ANY of the 20 Prisma models, with the full
// schema (fields + relations) visible at all times.
// ============================================================

interface TableResponse {
  model: string
  schema: SchemaModel | null
  labelField: string
  total: number
  page: number
  pageSize: number
  rows: Array<Record<string, unknown>>
}

function isDateString(v: unknown): boolean {
  return typeof v === 'string' && /^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}/.test(v)
}

function renderValue(v: unknown): string {
  if (v === null || v === undefined) return '—'
  if (typeof v === 'string') {
    if (isDateString(v)) return new Date(v).toLocaleString()
    return v.length > 140 ? `${v.slice(0, 140)}…` : v
  }
  if (typeof v === 'object') return JSON.stringify(v).slice(0, 140)
  return String(v)
}

function RowCard({
  row,
  model,
  labelField,
  onDeleted,
}: {
  row: Record<string, unknown>
  model: string
  labelField: string
  onDeleted: () => void
}) {
  const { toast } = useToast()
  const [expanded, setExpanded] = useState(false)
  const [deleting, setDeleting] = useState(false)
  const id = String(row.id ?? '')

  async function doDelete() {
    setDeleting(true)
    try {
      const res = await fetch(`/api/admin/record/${model}/${id}`, { method: 'DELETE' })
      if (!res.ok) throw new Error()
      toast({ description: 'Record deleted ✓' })
      onDeleted()
    } catch {
      toast({ description: 'Failed to delete the record.', variant: 'destructive' })
    } finally {
      setDeleting(false)
    }
  }

  return (
    <div className="rounded-lg border bg-card">
      <button
        type="button"
        className="w-full flex items-center gap-2 px-3 py-2 text-start hover:bg-muted/40 transition-colors"
        onClick={() => setExpanded(!expanded)}
      >
        <span className="font-mono text-[11px] text-muted-foreground shrink-0">{id.slice(0, 10)}…</span>
        <span className="text-[13px] font-medium truncate flex-1">{renderValue(row[labelField] ?? row.title ?? row.id)}</span>
        <ChevronRight className={`h-3.5 w-3.5 text-muted-foreground transition-transform shrink-0 ${expanded ? 'rotate-90' : ''}`} />
      </button>
      {expanded && (
        <div className="border-t bg-muted/20 px-3 py-2.5">
          <pre className="text-[11px] leading-5 font-mono whitespace-pre-wrap break-all max-h-72 overflow-y-auto nice-scroll" dir="ltr">
            {JSON.stringify(row, null, 2)}
          </pre>
          <div className="mt-2 flex justify-end">
            <Button size="sm" variant="destructive" className="gap-1.5 h-8" onClick={doDelete} disabled={deleting}>
              <Trash2 className="h-3.5 w-3.5" />
              {deleting ? 'Deleting…' : 'Delete record'}
            </Button>
          </div>
        </div>
      )}
    </div>
  )
}

export function AdminDatabase({ counts }: { counts: Record<string, number> }) {
  const { toast } = useToast()
  const [model, setModel] = useState<string>('Idea')
  const [data, setData] = useState<TableResponse | null>(null)
  const [loading, setLoading] = useState(false)
  const [page, setPage] = useState(1)
  const [query, setQuery] = useState('')
  const [searchInput, setSearchInput] = useState('')
  const [confirmClear, setConfirmClear] = useState(false)
  const [clearing, setClearing] = useState(false)

  const schema = SCHEMA_MODELS.find((m) => m.name === model)

  const load = useCallback(async () => {
    setLoading(true)
    try {
      const params = new URLSearchParams({ page: String(page), pageSize: '20' })
      if (query) params.set('q', query)
      const res = await fetch(`/api/admin/table/${model}?${params.toString()}`)
      const json = (await res.json()) as TableResponse & { error?: string }
      if (!res.ok) {
        toast({ description: json.error ?? 'Failed to load the table.', variant: 'destructive' })
        setData(null)
        return
      }
      setData(json)
    } catch {
      toast({ description: 'Failed to load the table.', variant: 'destructive' })
    } finally {
      setLoading(false)
    }
  }, [model, page, query, toast])

  useEffect(() => {
    load()
  }, [load])

  function selectModel(name: string) {
    setModel(name)
    setPage(1)
    setQuery('')
    setSearchInput('')
  }

  async function clearTable() {
    setClearing(true)
    try {
      const res = await fetch(`/api/admin/table/${model}`, { method: 'DELETE' })
      const json = (await res.json()) as { ok?: boolean; deleted?: number; error?: string }
      if (!res.ok) throw new Error(json.error)
      toast({ description: `Cleared ${json.deleted ?? 0} row(s) from ${model} ✓` })
      setConfirmClear(false)
      load()
    } catch {
      toast({ description: 'Failed to clear the table.', variant: 'destructive' })
    } finally {
      setClearing(false)
    }
  }

  const totalPages = data ? Math.max(1, Math.ceil(data.total / data.pageSize)) : 1

  return (
    <div className="space-y-5">
      {/* Model grid */}
      <div>
        <h2 className="text-sm font-semibold mb-1">Database — 20 models (SQLite + Prisma)</h2>
        <p className="text-xs text-muted-foreground leading-5 mb-3">
          Click a table to browse its rows, schema and relations. Every table can be searched, cleared, and its records inspected as JSON or deleted.
        </p>
        <div className="grid gap-2 grid-cols-2 sm:grid-cols-3 lg:grid-cols-5">
          {SCHEMA_MODELS.map((m) => (
            <button
              key={m.name}
              type="button"
              onClick={() => selectModel(m.name)}
              className={`rounded-lg border p-2.5 text-start transition-colors ${
                model === m.name ? 'border-primary bg-primary/[0.06]' : 'bg-card hover:bg-muted/50'
              }`}
            >
              <div className="flex items-center justify-between gap-1">
                <span className="text-[12px] font-semibold truncate">{m.name}</span>
                <span className="text-[11px] font-mono text-muted-foreground tabular-nums">{counts[m.name] ?? 0}</span>
              </div>
            </button>
          ))}
        </div>
      </div>

      {/* Schema of the selected model */}
      {schema && (
        <div className="rounded-xl border bg-card overflow-hidden">
          <div className="border-b bg-muted/50 px-4 py-2.5 flex items-center gap-2">
            <Table2 className="h-4 w-4 text-primary" />
            <span className="text-sm font-semibold">{schema.name}</span>
            <span className="text-xs text-muted-foreground">schema</span>
          </div>
          <div className="p-4 grid gap-4 lg:grid-cols-2">
            <div>
              <p className="text-xs text-muted-foreground leading-6 mb-3">{schema.description}</p>
              <div className="space-y-1">
                {schema.fields.map((f) => (
                  <div key={f.name} className="flex items-center gap-2 text-[11px] font-mono">
                    {f.id ? (
                      <KeyRound className="h-3 w-3 text-amber-500 shrink-0" />
                    ) : (
                      <span className="h-3 w-3 shrink-0 rounded-sm bg-muted" />
                    )}
                    <span className="font-semibold w-40 truncate">{f.name}</span>
                    <span className="text-muted-foreground">{f.type}</span>
                    {f.unique && <Badge variant="outline" className="text-[9px] px-1">unique</Badge>}
                    {f.json && <Badge variant="outline" className="text-[9px] px-1">JSON</Badge>}
                    {f.hasDefault && <Badge variant="outline" className="text-[9px] px-1">default</Badge>}
                  </div>
                ))}
              </div>
            </div>
            <div>
              <div className="text-[11px] font-semibold uppercase tracking-wide text-muted-foreground mb-2 flex items-center gap-1.5">
                <Link2 className="h-3.5 w-3.5" />
                Relations ({schema.relations.length})
              </div>
              <div className="space-y-1">
                {schema.relations.length === 0 ? (
                  <p className="text-xs text-muted-foreground">No relations — standalone table.</p>
                ) : (
                  schema.relations.map((r) => (
                    <div key={r.name} className="flex items-center gap-2 text-[11px] font-mono">
                      <span className="font-semibold w-40 truncate">{r.name}</span>
                      <span className="text-muted-foreground">→ {r.type}</span>
                    </div>
                  ))
                )}
              </div>
            </div>
          </div>
        </div>
      )}

      {/* Row browser */}
      <div className="rounded-xl border bg-card overflow-hidden">
        <div className="border-b bg-muted/50 px-4 py-2.5 flex flex-wrap items-center gap-2">
          <Database className="h-4 w-4 text-primary" />
          <span className="text-sm font-semibold">{model}</span>
          <Badge variant="outline" className="text-[10px] tabular-nums">{data?.total ?? counts[model] ?? 0} rows</Badge>
          <div className="ms-auto flex flex-wrap items-center gap-2">
            <div className="relative">
              <Search className="absolute start-2.5 top-1/2 h-3.5 w-3.5 -translate-y-1/2 text-muted-foreground" />
              <Input
                value={searchInput}
                onChange={(e) => setSearchInput(e.target.value)}
                onKeyDown={(e) => {
                  if (e.key === 'Enter') {
                    setPage(1)
                    setQuery(searchInput)
                  }
                }}
                placeholder="Search text columns…"
                className="h-8 ps-8 w-44 text-xs"
              />
            </div>
            <Button
              size="sm"
              variant="outline"
              className="h-8 gap-1.5"
              onClick={() => {
                setPage(1)
                setQuery(searchInput)
              }}
            >
              Search
            </Button>
            <Select value={String(page)} onValueChange={(v) => setPage(Number(v))}>
              <SelectTrigger className="h-8 w-auto text-xs gap-1">
                <SelectValue />
              </SelectTrigger>
              <SelectContent>
                {Array.from({ length: Math.min(totalPages, 50) }, (_, i) => i + 1).map((p) => (
                  <SelectItem key={p} value={String(p)} className="text-xs">
                    Page {p}
                  </SelectItem>
                ))}
              </SelectContent>
            </Select>
            <Button size="sm" variant="outline" className="h-8 gap-1" onClick={() => load()} disabled={loading}>
              <RefreshCw className={`h-3.5 w-3.5 ${loading ? 'animate-spin' : ''}`} />
              Refresh
            </Button>
            <Button
              size="sm"
              variant="destructive"
              className="h-8 gap-1.5"
              onClick={() => setConfirmClear(true)}
              disabled={(data?.total ?? 0) === 0}
            >
              <Trash2 className="h-3.5 w-3.5" />
              Clear table
            </Button>
          </div>
        </div>

        <div className="p-3 space-y-2">
          {loading && !data ? (
            <p className="py-8 text-center text-sm text-muted-foreground">Loading rows…</p>
          ) : !data || data.rows.length === 0 ? (
            <p className="py-8 text-center text-sm text-muted-foreground">
              No rows{query ? ` matching "${query}"` : ''} in {model}.
            </p>
          ) : (
            data.rows.map((row) => (
              <RowCard
                key={String(row.id)}
                row={row}
                model={model}
                labelField={data.labelField}
                onDeleted={() => {
                  load()
                }}
              />
            ))
          )}
        </div>

        {/* Pagination */}
        {data && data.total > data.pageSize && (
          <div className="border-t px-4 py-2.5 flex items-center justify-between">
            <span className="text-xs text-muted-foreground">
              Page {data.page} of {totalPages} · {data.total} rows · {data.pageSize}/page
            </span>
            <div className="flex gap-1.5">
              <Button size="sm" variant="outline" className="h-8 gap-1" disabled={page <= 1} onClick={() => setPage(page - 1)}>
                <ChevronLeft className="h-3.5 w-3.5" />
                Prev
              </Button>
              <Button size="sm" variant="outline" className="h-8 gap-1" disabled={page >= totalPages} onClick={() => setPage(page + 1)}>
                Next
                <ChevronRight className="h-3.5 w-3.5" />
              </Button>
            </div>
          </div>
        )}
      </div>

      {/* Clear-table confirmation */}
      <AlertDialog open={confirmClear} onOpenChange={setConfirmClear}>
        <AlertDialogContent>
          <AlertDialogHeader>
            <AlertDialogTitle>Clear every row of {model}?</AlertDialogTitle>
            <AlertDialogDescription>
              This permanently deletes all {data?.total ?? 0} row(s) from the <span className="font-mono">{model}</span> table.
              {model === 'Idea' && ' Deleting ideas also cascades to all their questions, features, requirements, artifacts and history.'}
              This cannot be undone.
            </AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel>Cancel</AlertDialogCancel>
            <AlertDialogAction className="bg-red-600 text-white hover:bg-red-700" onClick={clearTable} disabled={clearing}>
              {clearing ? 'Clearing…' : `Delete all ${data?.total ?? 0} rows`}
            </AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>
    </div>
  )
}
