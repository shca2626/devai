'use client'

import { useState } from 'react'
import { Button } from '@/components/ui/button'
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
import { Download, Loader2, Trash2 } from 'lucide-react'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Admin maintenance — export the full database and wipe data
// by scope, with explicit confirmations.
// ============================================================

const RESET_SCOPES = [
  {
    key: 'ideas',
    title: 'Delete all ideas',
    desc: 'Every idea + all cascading children: questions, features, assumptions, decisions, requirements, processes, entities, APIs, screens, tasks, risks, issues, architecture, verification runs, decision entries, drift checks, site analyses.',
  },
  {
    key: 'runs',
    title: 'Delete all runs (verify / drift / site)',
    desc: 'VerificationRun, DriftCheck and SiteAnalysis rows. Ideas and artifacts are kept.',
  },
  {
    key: 'playbooks',
    title: 'Delete all prompt templates',
    desc: 'Every PromptTemplate row, including the built-in ones (they are NOT reseeded automatically).',
  },
  {
    key: 'constitution',
    title: 'Delete all constitution rules',
    desc: 'Every ConstitutionRule row — global and per-project.',
  },
  {
    key: 'all',
    title: 'Wipe EVERYTHING',
    desc: 'All 20 tables, every row. The database becomes empty. Export first if you need the data.',
  },
] as const

export function AdminMaintenance({ onDataChanged }: { onDataChanged: () => void }) {
  const { toast } = useToast()
  const [confirm, setConfirm] = useState<(typeof RESET_SCOPES)[number] | null>(null)
  const [busy, setBusy] = useState(false)

  async function doReset(scope: (typeof RESET_SCOPES)[number]) {
    setBusy(true)
    try {
      const res = await fetch('/api/admin/reset', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ scope: scope.key }),
      })
      const json = (await res.json()) as { ok?: boolean; deleted?: Record<string, number>; error?: string }
      if (!res.ok) throw new Error(json.error)
      const total = Object.values(json.deleted ?? {}).reduce((a, b) => a + b, 0)
      toast({ description: `${scope.title}: ${total} row(s) deleted ✓` })
      setConfirm(null)
      onDataChanged()
    } catch (e) {
      toast({ description: e instanceof Error ? e.message : 'Reset failed.', variant: 'destructive' })
    } finally {
      setBusy(false)
    }
  }

  return (
    <div className="space-y-6">
      {/* Export */}
      <section className="rounded-xl sm:rounded-2xl border bg-card p-3.5 sm:p-5">
        <h2 className="text-sm font-semibold mb-1">Export</h2>
        <p className="text-xs text-muted-foreground leading-5 mb-3">
          Download the complete database as one JSON file — every model, every row, with a summary header. Perfect for
          backup or inspection.
        </p>
        <Button asChild className="gap-2">
          <a href="/api/admin/export" download>
            <Download className="h-4 w-4" />
            Download full database (JSON)
          </a>
        </Button>
      </section>

      {/* Danger zone */}
      <section className="rounded-xl border border-red-200 dark:border-red-500/25 bg-red-50/30 dark:bg-red-500/10 p-4">
        <h2 className="text-sm font-semibold text-red-800 dark:text-red-300 mb-1 flex items-center gap-2">
          <Trash2 className="h-4 w-4" />
          Danger zone — data deletion
        </h2>
        <p className="text-xs text-red-700/80 dark:text-red-300 leading-5 mb-4">
          These operations permanently delete data. They cannot be undone. Child rows cascade automatically.
        </p>
        <div className="space-y-2">
          {RESET_SCOPES.map((scope) => (
            <div
              key={scope.key}
              className="rounded-lg border border-red-200 dark:border-red-500/25 bg-background p-3 flex flex-col sm:flex-row sm:items-center gap-2.5"
            >
              <div className="flex-1">
                <div className="text-[13px] font-semibold">{scope.title}</div>
                <p className="text-[11px] text-muted-foreground leading-5 mt-0.5">{scope.desc}</p>
              </div>
              <Button
                size="sm"
                variant="destructive"
                className="shrink-0"
                onClick={() => setConfirm(scope)}
              >
                Delete
              </Button>
            </div>
          ))}
        </div>
      </section>

      <AlertDialog open={confirm !== null} onOpenChange={(v) => !v && setConfirm(null)}>
        <AlertDialogContent>
          <AlertDialogHeader>
            <AlertDialogTitle>{confirm?.title}?</AlertDialogTitle>
            <AlertDialogDescription>{confirm?.desc} This action is permanent.</AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel>Cancel</AlertDialogCancel>
            <AlertDialogAction
              className="bg-red-600 text-white hover:bg-red-700"
              onClick={() => confirm && doReset(confirm)}
              disabled={busy}
            >
              {busy ? (
                <>
                  <Loader2 className="h-3.5 w-3.5 me-1.5 animate-spin" />
                  Deleting…
                </>
              ) : (
                'Yes, delete permanently'
              )}
            </AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>
    </div>
  )
}
