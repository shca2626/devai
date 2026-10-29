'use client'

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
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuTrigger,
} from '@/components/ui/dropdown-menu'
import {
  Dialog,
  DialogContent,
  DialogFooter,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog'
import { Input } from '@/components/ui/input'
import { StageBadge } from '@/components/app/bits'
import { useApp } from '@/components/app/context'
import type { IdeaListItem } from '@/lib/types'
import { cn } from '@/lib/utils'
import { AppWindow, FlaskConical, Globe, MoreHorizontal, Pencil, Plus, Search, Trash2 } from 'lucide-react'
import { useState } from 'react'

function timeAgo(iso: string, lang: 'ar' | 'en'): string {
  const diff = Date.now() - new Date(iso).getTime()
  const minutes = Math.floor(diff / 60000)
  const hours = Math.floor(minutes / 60)
  const days = Math.floor(hours / 24)
  if (lang === 'ar') {
    if (minutes < 1) return 'الآن'
    if (minutes < 60) return `قبل ${minutes} دقيقة`
    if (hours < 24) return `قبل ${hours} ساعة`
    return `قبل ${days} يوم`
  }
  if (minutes < 1) return 'just now'
  if (minutes < 60) return `${minutes}m ago`
  if (hours < 24) return `${hours}h ago`
  return `${days}d ago`
}

function IdeaRow({ idea }: { idea: IdeaListItem }) {
  const { t, lang, selectedId, selectIdea, refreshIdeas } = useApp()
  const [confirmDelete, setConfirmDelete] = useState(false)
  const [renameOpen, setRenameOpen] = useState(false)
  const [renameValue, setRenameValue] = useState(idea.title)
  const active = selectedId === idea.id

  async function doRename() {
    const value = renameValue.trim()
    if (!value) return
    await fetch(`/api/ideas/${idea.id}`, {
      method: 'PATCH',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ title: value }),
    })
    setRenameOpen(false)
    refreshIdeas()
    // refresh open detail if this idea is open
    if (active) selectIdea(idea.id)
  }

  async function doDelete() {
    await fetch(`/api/ideas/${idea.id}`, { method: 'DELETE' })
    setConfirmDelete(false)
    if (active) selectIdea(null)
    refreshIdeas()
  }

  return (
    <div
      className={cn(
        'group relative rounded-lg border p-3 cursor-pointer transition-colors',
        active
          ? 'border-primary/40 bg-primary/[0.04]'
          : 'border-transparent hover:border-border hover:bg-muted/50'
      )}
      onClick={() => selectIdea(idea.id)}
      role="button"
      tabIndex={0}
      onKeyDown={(e) => {
        if (e.key === 'Enter' || e.key === ' ') {
          e.preventDefault()
          selectIdea(idea.id)
        }
      }}
      aria-pressed={active}
    >
      <div className="flex items-start justify-between gap-2">
        <h3 className={cn('text-sm font-medium leading-snug line-clamp-2 flex-1', lang === 'ar' && 'font-arabic')}>
          {idea.title}
        </h3>
        <DropdownMenu>
          <DropdownMenuTrigger asChild>
            <Button
              variant="ghost"
              size="icon"
              className="h-7 w-7 shrink-0 opacity-0 group-hover:opacity-100 focus:opacity-100"
              onClick={(e) => e.stopPropagation()}
              aria-label="Idea menu"
            >
              <MoreHorizontal className="h-4 w-4" />
            </Button>
          </DropdownMenuTrigger>
          <DropdownMenuContent align="end" onClick={(e) => e.stopPropagation()}>
            <DropdownMenuItem
              onClick={() => {
                setRenameValue(idea.title)
                setRenameOpen(true)
              }}
            >
              <Pencil className="h-3.5 w-3.5" />
              {t('renameIdea')}
            </DropdownMenuItem>
            <DropdownMenuItem variant="destructive" onClick={() => setConfirmDelete(true)}>
              <Trash2 className="h-3.5 w-3.5" />
              {t('deleteIdea')}
            </DropdownMenuItem>
          </DropdownMenuContent>
        </DropdownMenu>
      </div>
      <div className="mt-2 flex items-center gap-2">
        <StageBadge stage={idea.stage} />
        {idea.projectType && (
          <span
            className="inline-flex items-center gap-1 rounded-full border px-1.5 py-0 text-[10px] text-muted-foreground"
            title={t(
              idea.projectType === 'website'
                ? 'typeWebsite'
                : idea.projectType === 'prototype'
                  ? 'typePrototype'
                  : 'typeApp'
            )}
          >
            {idea.projectType === 'website' ? (
              <Globe className="h-2.5 w-2.5" />
            ) : idea.projectType === 'prototype' ? (
              <FlaskConical className="h-2.5 w-2.5" />
            ) : (
              <AppWindow className="h-2.5 w-2.5" />
            )}
            {t(
              idea.projectType === 'website'
                ? 'typeWebsite'
                : idea.projectType === 'prototype'
                  ? 'typePrototype'
                  : 'typeApp'
            )}
          </span>
        )}
        <span className="text-[11px] text-muted-foreground">{timeAgo(idea.updatedAt, lang)}</span>
      </div>

      <AlertDialog open={confirmDelete} onOpenChange={setConfirmDelete}>
        <AlertDialogContent onClick={(e) => e.stopPropagation()}>
          <AlertDialogHeader>
            <AlertDialogTitle>{t('deleteConfirmTitle')}</AlertDialogTitle>
            <AlertDialogDescription>{t('deleteConfirmBody')}</AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel onClick={(e) => e.stopPropagation()}>{t('cancel')}</AlertDialogCancel>
            <AlertDialogAction
              className="bg-red-600 text-white hover:bg-red-700"
              onClick={(e) => {
                e.stopPropagation()
                doDelete()
              }}
            >
              {t('delete')}
            </AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>

      <Dialog open={renameOpen} onOpenChange={setRenameOpen}>
        <DialogContent onClick={(e) => e.stopPropagation()} className="sm:max-w-sm">
          <DialogHeader>
            <DialogTitle>{t('renameIdea')}</DialogTitle>
          </DialogHeader>
          <Input
            value={renameValue}
            onChange={(e) => setRenameValue(e.target.value)}
            onKeyDown={(e) => e.key === 'Enter' && doRename()}
            maxLength={120}
            dir={lang === 'ar' ? 'rtl' : 'ltr'}
          />
          <DialogFooter>
            <Button variant="outline" onClick={() => setRenameOpen(false)}>
              {t('cancel')}
            </Button>
            <Button onClick={doRename}>{t('save')}</Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>
    </div>
  )
}

export function Sidebar({ onNewIdea }: { onNewIdea: () => void }) {
  const { t, ideas } = useApp()
  const [query, setQuery] = useState('')

  const filtered = ideas.filter((i) => i.title.toLowerCase().includes(query.toLowerCase()))

  return (
    <div className="flex h-full flex-col gap-3 p-3">
      <Button onClick={onNewIdea} className="w-full gap-2" size="lg">
        <Plus className="h-4 w-4" />
        {t('newIdea')}
      </Button>
      <div className="relative">
        <Search className="absolute start-2.5 top-1/2 h-4 w-4 -translate-y-1/2 text-muted-foreground" />
        <Input
          value={query}
          onChange={(e) => setQuery(e.target.value)}
          placeholder="…"
          className="ps-8 h-9 bg-muted/50"
          aria-label={t('workspace')}
        />
      </div>
      <div className="px-1 text-[11px] font-medium uppercase tracking-wide text-muted-foreground">
        {t('workspace')} · {ideas.length} {t('ideasCount')}
      </div>
      <div className="flex-1 min-h-0 overflow-y-auto nice-scroll flex flex-col gap-1 pe-0.5">
        {filtered.length === 0 ? (
          <p className="px-3 py-6 text-center text-xs text-muted-foreground">{t('noIdeas')}</p>
        ) : (
          filtered.map((idea) => <IdeaRow key={idea.id} idea={idea} />)
        )}
      </div>
    </div>
  )
}
