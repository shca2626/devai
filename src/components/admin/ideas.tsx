'use client'

import { useState } from 'react'
import { Badge } from '@/components/ui/badge'
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
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from '@/components/ui/select'
import { ArrowRight, ExternalLink, Lightbulb, Trash2 } from 'lucide-react'
import { STAGES } from '@/lib/types'
import { useToast } from '@/hooks/use-toast'

export interface AdminIdea {
  id: string
  title: string
  stage: string
  updatedAt: string
  projectType: string | null
  sourceLang: string
}

// ============================================================
// Admin ideas control — jump any idea to ANY stage instantly
// (no-limits), open it in the app, or delete it entirely.
// ============================================================

export function AdminIdeas({ ideas, onChanged }: { ideas: AdminIdea[]; onChanged: () => void }) {
  const { toast } = useToast()
  const [busyId, setBusyId] = useState<string | null>(null)
  const [confirmDelete, setConfirmDelete] = useState<AdminIdea | null>(null)

  async function moveStage(idea: AdminIdea, stage: string) {
    setBusyId(idea.id)
    try {
      const res = await fetch(`/api/ideas/${idea.id}/reopen`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ to: stage, reason: `Admin panel: stage set to ${stage}` }),
      })
      const json = (await res.json()) as { error?: string }
      if (!res.ok) throw new Error(json.error)
      toast({ description: `Moved to "${stage}" ✓ (logged in the decision history)` })
      onChanged()
    } catch (e) {
      toast({ description: e instanceof Error ? e.message : 'Failed to move the idea.', variant: 'destructive' })
    } finally {
      setBusyId(null)
    }
  }

  async function doDelete(idea: AdminIdea) {
    setBusyId(idea.id)
    try {
      const res = await fetch(`/api/ideas/${idea.id}`, { method: 'DELETE' })
      if (!res.ok) throw new Error()
      toast({ description: 'Idea deleted (all child data cascaded) ✓' })
      setConfirmDelete(null)
      onChanged()
    } catch {
      toast({ description: 'Failed to delete the idea.', variant: 'destructive' })
    } finally {
      setBusyId(null)
    }
  }

  return (
    <div className="space-y-4">
      <div>
        <h2 className="text-sm font-semibold mb-1">Ideas — full stage control</h2>
        <p className="text-xs text-muted-foreground leading-5 mb-4">
          Jump any idea to any of the 9 stages instantly — forward or backward, from any current stage. The move is always
          recorded in the audit trail; nothing is lost. This is the no-limits control the workflow stepper follows.
        </p>
      </div>

      {ideas.length === 0 ? (
        <div className="rounded-xl border border-dashed p-8 text-center">
          <Lightbulb className="h-8 w-8 text-muted-foreground mx-auto mb-2" />
          <p className="text-sm text-muted-foreground">No ideas yet — create one from the main app.</p>
        </div>
      ) : (
        <div className="space-y-2">
          {ideas.map((idea) => {
            const stageIdx = STAGES.indexOf(idea.stage as (typeof STAGES)[number])
            return (
              <div key={idea.id} className="rounded-xl border bg-card p-3.5 flex flex-col lg:flex-row lg:items-center gap-3">
                <div className="flex-1 min-w-0">
                  <div className="flex items-center gap-2 flex-wrap">
                    <span className="text-sm font-semibold truncate max-w-md">{idea.title}</span>
                    <Badge variant="outline" className="text-[10px] font-mono">{idea.stage}</Badge>
                    {idea.projectType && <Badge variant="outline" className="text-[10px]">{idea.projectType}</Badge>}
                    <Badge variant="outline" className="text-[10px]">{idea.sourceLang === 'ar' ? 'العربية' : 'English'}</Badge>
                  </div>
                  <div className="mt-1.5 flex items-center gap-1.5">
                    {STAGES.map((s, i) => (
                      <span
                        key={s}
                        title={s}
                        className={`h-1.5 w-6 rounded-full ${i <= stageIdx ? 'bg-primary' : 'bg-muted'}`}
                      />
                    ))}
                    <span className="text-[10px] text-muted-foreground font-mono ms-1">
                      {stageIdx + 1}/9 · {new Date(idea.updatedAt).toLocaleDateString()}
                    </span>
                  </div>
                </div>
                <div className="flex flex-wrap items-center gap-2 shrink-0">
                  <Select value={idea.stage} onValueChange={(v) => moveStage(idea, v)} disabled={busyId === idea.id}>
                    <SelectTrigger className="h-9 w-44 text-xs">
                      <SelectValue />
                    </SelectTrigger>
                    <SelectContent>
                      {STAGES.map((s) => (
                        <SelectItem key={s} value={s} className="text-xs font-mono">
                          {s}
                        </SelectItem>
                      ))}
                    </SelectContent>
                  </Select>
                  <Button
                    size="sm"
                    variant="outline"
                    className="h-9 gap-1.5"
                    onClick={() => window.open(`/?idea=${idea.id}`, '_blank')}
                  >
                    <ExternalLink className="h-3.5 w-3.5" />
                    Open
                  </Button>
                  <Button
                    size="sm"
                    variant="destructive"
                    className="h-9 gap-1.5"
                    onClick={() => setConfirmDelete(idea)}
                    disabled={busyId === idea.id}
                  >
                    <Trash2 className="h-3.5 w-3.5" />
                    Delete
                  </Button>
                </div>
              </div>
            )
          })}
        </div>
      )}

      <AlertDialog open={confirmDelete !== null} onOpenChange={(v) => !v && setConfirmDelete(null)}>
        <AlertDialogContent>
          <AlertDialogHeader>
            <AlertDialogTitle>Delete “{confirmDelete?.title}”?</AlertDialogTitle>
            <AlertDialogDescription>
              This permanently deletes the idea AND every child row: questions, features, assumptions, decisions,
              requirements, design artifacts, tasks, risks, issues, verification runs, drift checks and site analyses.
              This cannot be undone.
            </AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel>Cancel</AlertDialogCancel>
            <AlertDialogAction
              className="bg-red-600 text-white hover:bg-red-700"
              onClick={() => confirmDelete && doDelete(confirmDelete)}
            >
              <ArrowRight className="h-3.5 w-3.5 me-1" />
              Delete permanently
            </AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>
    </div>
  )
}
