'use client'

import { useState } from 'react'
import { Button } from '@/components/ui/button'
import { Badge } from '@/components/ui/badge'
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs'
import { useApp } from '@/components/app/context'
import { CodeChip, ReviewBadge, WorkingPanel } from '@/components/app/bits'
import { ArchitectLab } from '@/components/stages/architect-lab'
import type { IdeaDetail } from '@/lib/types'
import type { DictKey } from '@/lib/i18n'
import {
  Boxes,
  Check,
  ChevronDown,
  ChevronUp,
  Database,
  GitBranch,
  Landmark,
  LayoutTemplate,
  Loader2,
  MessageSquareWarning,
  Pencil,
  Plus,
  Server,
  Workflow,
  X,
} from 'lucide-react'
import { Input } from '@/components/ui/input'
import { Checkbox } from '@/components/ui/checkbox'
import { useToast } from '@/hooks/use-toast'

// ============================================================
// Stage 6 — System design: five engines (processes, data, API,
// screens, architecture) turn confirmed requirements into the
// system specification. Each artifact set is reviewed item by
// item; rejected artifacts are never a dead end — they can be
// regenerated, optionally with client feedback the engine must
// address. Only confirmed decisions are protected.
// ============================================================

type Kind = 'processes' | 'entities' | 'apis' | 'screens' | 'architecture'

const GENERATE_KEYS: Record<Kind, { label: DictKey; steps: [DictKey, DictKey] }> = {
  processes: { label: 'generateProcesses', steps: ['genProcesses1', 'genProcesses2'] },
  entities: { label: 'generateEntities', steps: ['genEntities1', 'genEntities2'] },
  apis: { label: 'generateApis', steps: ['genApis1', 'genApis2'] },
  screens: { label: 'generateScreens', steps: ['genScreens1', 'genScreens2'] },
  architecture: { label: 'generateArchitecture', steps: ['genArch1', 'genArch2'] },
}

export function DesignStage({ detail }: { detail: IdeaDetail }) {
  const { t, setDetail, refreshIdeas } = useApp()
  const { toast } = useToast()
  const { idea, processes, entities, apis, screens, architecture } = detail
  // NO LIMITS: design artifacts can be generated, reviewed and approved at ANY stage
  const active = true
  const [busyKind, setBusyKind] = useState<Kind | null>(null)
  const [busyGate, setBusyGate] = useState(false)
  const [expanded, setExpanded] = useState<string | null>(null)
  const [tab, setTab] = useState('processes')
  const [feedback, setFeedback] = useState<Record<Kind, string>>({
    processes: '',
    entities: '',
    apis: '',
    screens: '',
    architecture: '',
  })
  const [editingArch, setEditingArch] = useState(false)
  const [draftStack, setDraftStack] = useState<Array<{ area: string; choice: string; rationale: string; tradeOffs: string; simplestOption: boolean }>>([])
  const [draftNotes, setDraftNotes] = useState('')

  async function generate(kind: Kind, kindFeedback?: string) {
    setBusyKind(kind)
    const res = await fetch(`/api/ideas/${idea.id}/design/generate`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ kind, feedback: kindFeedback }),
    })
    const data = await res.json()
    setBusyKind(null)
    if (!res.ok) {
      toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
      return
    }
    setFeedback((f) => ({ ...f, [kind]: '' }))
    setDetail(data as IdeaDetail)
    refreshIdeas()
  }

  function startEditArch() {
    if (!architecture) return
    setDraftStack(architecture.techStack.map((s) => ({ ...s })))
    setDraftNotes(architecture.notes ?? '')
    setEditingArch(true)
  }

  async function saveArchEdits() {
    if (!architecture) return
    setBusyKind('architecture')
    const res = await fetch(`/api/artifacts/architecture/${architecture.id}`, {
      method: 'PATCH',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ edits: { techStack: draftStack, notes: draftNotes } }),
    })
    const data = await res.json()
    setBusyKind(null)
    if (!res.ok) {
      toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
      return
    }
    setEditingArch(false)
    setDetail(data as IdeaDetail)
    refreshIdeas()
    toast({ description: t('archEditedNeedsReconfirm') })
  }

  async function review(kind: string, id: string, status: string) {
    const res = await fetch(`/api/artifacts/${kind}/${id}`, {
      method: 'PATCH',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ status }),
    })
    const data = await res.json()
    if (!res.ok) {
      toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
      return
    }
    setDetail(data as IdeaDetail)
    refreshIdeas()
  }

  async function confirmAll(kind: Kind) {
    setBusyKind(kind)
    const list =
      kind === 'processes' ? processes : kind === 'entities' ? entities : kind === 'apis' ? apis : kind === 'screens' ? screens : []
    const artifactKind = kind === 'processes' ? 'process' : kind === 'entities' ? 'entity' : kind === 'apis' ? 'api' : 'screen'
    for (const item of list) {
      if (item.status === 'proposed' || item.status === 'needs_revision') {
        const res = await fetch(`/api/artifacts/${artifactKind}/${item.id}`, {
          method: 'PATCH',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({ status: 'confirmed' }),
        })
        if (res.ok) setDetail((await res.json()) as IdeaDetail)
      }
    }
    setBusyKind(null)
    refreshIdeas()
  }

  async function passGate() {
    setBusyGate(true)
    const res = await fetch(`/api/ideas/${idea.id}/gate`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ gate: 'design', action: 'approve' }),
    })
    const data = await res.json()
    setBusyGate(false)
    if (!res.ok) {
      toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
      return
    }
    setDetail(data as IdeaDetail)
    refreshIdeas()
  }

  // NO LIMITS: no locked teaser — the stage renders its generate
  // bars and full content at ANY stage, even when empty.

  return (
    <div className="space-y-4">
      <p className="text-xs text-muted-foreground leading-6">{t('designIntro')}</p>

      <Tabs value={tab} onValueChange={setTab}>
        <TabsList className="w-full justify-start overflow-x-auto nice-scroll h-auto p-1">
          <TabsTrigger value="processes" className="gap-1.5 text-xs">
            <Workflow className="h-3.5 w-3.5" />
            {t('tabProcesses')} ({processes.length})
          </TabsTrigger>
          <TabsTrigger value="entities" className="gap-1.5 text-xs">
            <Database className="h-3.5 w-3.5" />
            {t('tabData')} ({entities.length})
          </TabsTrigger>
          <TabsTrigger value="apis" className="gap-1.5 text-xs">
            <Server className="h-3.5 w-3.5" />
            {t('tabApis')} ({apis.length})
          </TabsTrigger>
          <TabsTrigger value="screens" className="gap-1.5 text-xs">
            <LayoutTemplate className="h-3.5 w-3.5" />
            {t('tabScreens')} ({screens.length})
          </TabsTrigger>
          <TabsTrigger value="architecture" className="gap-1.5 text-xs">
            <Boxes className="h-3.5 w-3.5" />
            {t('tabArchitecture')}
          </TabsTrigger>
          <TabsTrigger value="architect" className="gap-1.5 text-xs">
            <Landmark className="h-3.5 w-3.5" />
            {t('tabArchitectLab')}
          </TabsTrigger>
        </TabsList>

        {/* ---------- Processes ---------- */}
        <TabsContent value="processes" className="mt-3 space-y-3">
          <GenerateBar kind="processes" count={processes.length} unreviewed={processes.filter((p) => p.status === 'proposed' || p.status === 'needs_revision').length} rejected={processes.filter((p) => p.status === 'rejected').length} active={active} busy={busyKind === 'processes'} t={t} onGenerate={() => generate('processes', feedback.processes)} onConfirmAll={() => confirmAll('processes')} />
          <FeedbackPanel
            active={active && processes.length > 0}
            busy={busyKind === 'processes'}
            value={feedback.processes}
            onChange={(v) => setFeedback((f) => ({ ...f, processes: v }))}
            t={t}
            onRun={() => generate('processes', feedback.processes)}
          />
          {processes.map((p) => (
            <div key={p.id} className={`rounded-xl border bg-card p-3 sm:p-4 ${p.status === 'rejected' ? 'opacity-60' : ''}`}>
              <div className="flex items-start gap-2 flex-wrap">
                <CodeChip code={p.code} className="mt-0.5" />
                <div className="flex-1 min-w-[200px]">
                  <div className="text-sm font-medium" dir="ltr">
                    {p.name}
                    {p.nameAr && <span className="text-muted-foreground font-arabic ms-2" dir="rtl">· {p.nameAr}</span>}
                  </div>
                  {p.trigger && <p className="text-xs text-muted-foreground mt-0.5" dir="ltr">⚡ {p.trigger}</p>}
                  <div className="flex flex-wrap gap-1 mt-1.5">
                    {p.actors.map((a) => (
                      <Badge key={a} variant="outline" className="text-[10px] bg-muted/40">{a}</Badge>
                    ))}
                    {p.linkedRequirements.map((c) => <CodeChip key={c} code={c} />)}
                  </div>
                </div>
                <ReviewBadge status={p.status} />
              </div>
              {expanded === p.id && (
                <div className="mt-3 border-t pt-3 space-y-3" dir="ltr">
                  <div className="overflow-x-auto nice-scroll">
                    <table className="w-full text-xs">
                      <thead>
                        <tr className="text-muted-foreground border-b">
                          <th className="py-1.5 text-start font-medium pe-2">#</th>
                          <th className="py-1.5 text-start font-medium pe-2">Actor</th>
                          <th className="py-1.5 text-start font-medium pe-2">Action</th>
                          <th className="py-1.5 text-start font-medium pe-2">Decision / Exception</th>
                        </tr>
                      </thead>
                      <tbody>
                        {p.steps.map((s) => (
                          <tr key={s.n} className="border-b last:border-0 align-top">
                            <td className="py-1.5 pe-2 font-mono text-muted-foreground">{s.n}</td>
                            <td className="py-1.5 pe-2 whitespace-nowrap">{s.actor}</td>
                            <td className="py-1.5 pe-2">{s.action}{s.input ? <span className="text-muted-foreground"> (in: {s.input})</span> : ''}{s.output ? <span className="text-muted-foreground"> (out: {s.output})</span> : ''}</td>
                            <td className="py-1.5 text-muted-foreground">{s.decision ?? s.exception ?? '—'}</td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  </div>
                  {p.businessRules.length > 0 && (
                    <div>
                      <div className="text-[11px] font-semibold text-muted-foreground mb-1">{t('businessRules')}</div>
                      <ul className="space-y-1">
                        {p.businessRules.map((b, i) => (
                          <li key={i} className="text-xs leading-6 flex gap-1.5 flex-wrap">
                            <GitBranch className="h-3.5 w-3.5 text-primary shrink-0 mt-1" />
                            <span>
                              {b.rule}
                              {b.linkedRequirements.length > 0 && <span className="ms-1">{b.linkedRequirements.map((c) => <CodeChip key={c} code={c} className="ms-1" />)}</span>}
                            </span>
                          </li>
                        ))}
                      </ul>
                    </div>
                  )}
                  {p.exceptions.length > 0 && (
                    <div>
                      <div className="text-[11px] font-semibold text-muted-foreground mb-1">{t('exceptionsTitle')}</div>
                      <ul className="space-y-0.5">
                        {p.exceptions.map((e, i) => (
                          <li key={i} className="text-xs leading-6 text-muted-foreground">• {e}</li>
                        ))}
                      </ul>
                    </div>
                  )}
                </div>
              )}
              <Expand id={p.id} expanded={expanded} setExpanded={setExpanded} t={t} />
              <ReviewActions kind="process" id={p.id} status={p.status} active={active} t={t} onReview={review} />
            </div>
          ))}
        </TabsContent>

        {/* ---------- Entities ---------- */}
        <TabsContent value="entities" className="mt-3 space-y-3">
          <GenerateBar kind="entities" count={entities.length} unreviewed={entities.filter((e) => e.status === 'proposed' || e.status === 'needs_revision').length} rejected={entities.filter((e) => e.status === 'rejected').length} active={active} busy={busyKind === 'entities'} t={t} onGenerate={() => generate('entities', feedback.entities)} onConfirmAll={() => confirmAll('entities')} />
          <FeedbackPanel
            active={active && entities.length > 0}
            busy={busyKind === 'entities'}
            value={feedback.entities}
            onChange={(v) => setFeedback((f) => ({ ...f, entities: v }))}
            t={t}
            onRun={() => generate('entities', feedback.entities)}
          />
          {entities.map((e) => (
            <div key={e.id} className={`rounded-xl border bg-card p-3 sm:p-4 ${e.status === 'rejected' ? 'opacity-60' : ''}`}>
              <div className="flex items-start gap-2 flex-wrap">
                <CodeChip code={e.code} className="mt-0.5" />
                <div className="flex-1 min-w-[200px]">
                  <div className="text-sm font-medium" dir="ltr">
                    {e.name}
                    {e.nameAr && <span className="text-muted-foreground font-arabic ms-2" dir="rtl">· {e.nameAr}</span>}
                  </div>
                  {e.description && <p className="text-xs text-muted-foreground mt-0.5 line-clamp-2" dir="ltr">{e.description}</p>}
                  <div className="text-[11px] text-muted-foreground mt-1">{e.fields.length} {t('fieldsTitle').toLowerCase()}</div>
                </div>
                <ReviewBadge status={e.status} />
              </div>
              {expanded === e.id && (
                <div className="mt-3 border-t pt-3 space-y-3" dir="ltr">
                  <div className="overflow-x-auto nice-scroll">
                    <table className="w-full text-xs">
                      <thead>
                        <tr className="text-muted-foreground border-b">
                          <th className="py-1.5 text-start font-medium pe-2">Field</th>
                          <th className="py-1.5 text-start font-medium pe-2">Type</th>
                          <th className="py-1.5 text-start font-medium pe-2">R</th>
                          <th className="py-1.5 text-start font-medium pe-2">U</th>
                          <th className="py-1.5 text-start font-medium">Description</th>
                        </tr>
                      </thead>
                      <tbody>
                        {e.fields.map((f) => (
                          <tr key={f.name} className="border-b last:border-0">
                            <td className="py-1.5 pe-2 font-mono">{f.name}</td>
                            <td className="py-1.5 pe-2 text-muted-foreground">{f.type}</td>
                            <td className="py-1.5 pe-2">{f.required ? '✓' : ''}</td>
                            <td className="py-1.5 pe-2">{f.unique ? '✓' : ''}</td>
                            <td className="py-1.5 text-muted-foreground">{f.description}{f.refEntity ? <span className="text-primary"> → {f.refEntity}</span> : ''}</td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  </div>
                  {e.relationships.length > 0 && (
                    <div className="text-xs text-muted-foreground">
                      <span className="font-semibold text-foreground">{t('relationshipsTitle')}: </span>
                      {e.relationships.map((r, i) => (
                        <span key={i}>{i > 0 && ' · '}{r.type} → {r.target} <span className="text-muted-foreground/70">({r.description})</span></span>
                      ))}
                    </div>
                  )}
                  {e.constraints.length > 0 && (
                    <div className="text-xs">
                      <span className="font-semibold">{t('constraintsTitle')}: </span>
                      <span className="text-muted-foreground">{e.constraints.join(' · ')}</span>
                    </div>
                  )}
                </div>
              )}
              <Expand id={e.id} expanded={expanded} setExpanded={setExpanded} t={t} />
              <ReviewActions kind="entity" id={e.id} status={e.status} active={active} t={t} onReview={review} />
            </div>
          ))}
        </TabsContent>

        {/* ---------- APIs ---------- */}
        <TabsContent value="apis" className="mt-3 space-y-3">
          <GenerateBar kind="apis" count={apis.length} unreviewed={apis.filter((a) => a.status === 'proposed' || a.status === 'needs_revision').length} rejected={apis.filter((a) => a.status === 'rejected').length} active={active} busy={busyKind === 'apis'} t={t} onGenerate={() => generate('apis', feedback.apis)} onConfirmAll={() => confirmAll('apis')} />
          <FeedbackPanel
            active={active && apis.length > 0}
            busy={busyKind === 'apis'}
            value={feedback.apis}
            onChange={(v) => setFeedback((f) => ({ ...f, apis: v }))}
            t={t}
            onRun={() => generate('apis', feedback.apis)}
          />
          {apis.map((a) => (
            <div key={a.id} className={`rounded-xl border bg-card p-3 sm:p-4 ${a.status === 'rejected' ? 'opacity-60' : ''}`}>
              <div className="flex items-start gap-2 flex-wrap">
                <CodeChip code={a.code} className="mt-0.5" />
                <div className="flex-1 min-w-[200px]">
                  <div className="text-sm font-mono font-medium" dir="ltr">
                    <Badge className={`me-1.5 text-[10px] ${a.method === 'GET' ? 'bg-teal-600' : a.method === 'POST' ? 'bg-primary' : a.method === 'DELETE' ? 'bg-red-500' : 'bg-amber-500'}`}>
                      {a.method}
                    </Badge>
                    {a.path}
                  </div>
                  <p className="text-xs text-muted-foreground mt-1 line-clamp-2" dir="ltr">
                    {a.auth && <span className="font-semibold">{a.auth}: </span>}
                    {a.purpose}
                  </p>
                  <div className="flex flex-wrap gap-1 mt-1.5">
                    {a.linkedRequirements.map((c) => <CodeChip key={c} code={c} />)}
                    {a.linkedEntities.map((c) => <CodeChip key={c} code={c} className="bg-teal-50 border-teal-200 dark:border-teal-500/25 text-teal-700 dark:text-teal-300" />)}
                  </div>
                </div>
                <ReviewBadge status={a.status} />
              </div>
              {expanded === a.id && (
                <div className="mt-3 border-t pt-3 space-y-3" dir="ltr">
                  {a.request.length > 0 && (
                    <div>
                      <div className="text-[11px] font-semibold text-muted-foreground mb-1">{t('requestFields')}</div>
                      <div className="overflow-x-auto nice-scroll">
                        <table className="w-full text-xs">
                          <thead>
                            <tr className="text-muted-foreground border-b">
                              <th className="py-1.5 text-start font-medium pe-2">Field</th>
                              <th className="py-1.5 text-start font-medium pe-2">Type</th>
                              <th className="py-1.5 text-start font-medium">Validation</th>
                            </tr>
                          </thead>
                          <tbody>
                            {a.request.map((f) => (
                              <tr key={f.field} className="border-b last:border-0">
                                <td className="py-1.5 pe-2 font-mono">{f.field}{f.required ? <span className="text-red-500">*</span> : ''}</td>
                                <td className="py-1.5 pe-2 text-muted-foreground">{f.type}</td>
                                <td className="py-1.5 text-muted-foreground">{f.notes}</td>
                              </tr>
                            ))}
                          </tbody>
                        </table>
                      </div>
                    </div>
                  )}
                  {a.response.length > 0 && (
                    <div>
                      <div className="text-[11px] font-semibold text-muted-foreground mb-1">{t('responseFields')}</div>
                      <div className="overflow-x-auto nice-scroll">
                        <table className="w-full text-xs">
                          <thead>
                            <tr className="text-muted-foreground border-b">
                              <th className="py-1.5 text-start font-medium pe-2">Field</th>
                              <th className="py-1.5 text-start font-medium pe-2">Type</th>
                              <th className="py-1.5 text-start font-medium">Description</th>
                            </tr>
                          </thead>
                          <tbody>
                            {a.response.map((f) => (
                              <tr key={f.field} className="border-b last:border-0">
                                <td className="py-1.5 pe-2 font-mono text-emerald-700">{f.field}</td>
                                <td className="py-1.5 pe-2 text-muted-foreground">{f.type}</td>
                                <td className="py-1.5 text-muted-foreground">{f.description}</td>
                              </tr>
                            ))}
                          </tbody>
                        </table>
                      </div>
                    </div>
                  )}
                  {a.errors.length > 0 && (
                    <div className="text-xs">
                      <span className="font-semibold">{t('errorCodes')}: </span>
                      {a.errors.map((e, i) => (
                        <span key={i}>{i > 0 && ' · '}<code className="bg-muted/60 rounded px-1 py-0.5 font-mono text-[10px]">{e.code}</code> {e.when}</span>
                      ))}
                    </div>
                  )}
                </div>
              )}
              <Expand id={a.id} expanded={expanded} setExpanded={setExpanded} t={t} />
              <ReviewActions kind="api" id={a.id} status={a.status} active={active} t={t} onReview={review} />
            </div>
          ))}
        </TabsContent>

        {/* ---------- Screens ---------- */}
        <TabsContent value="screens" className="mt-3 space-y-3">
          <GenerateBar kind="screens" count={screens.length} unreviewed={screens.filter((s) => s.status === 'proposed' || s.status === 'needs_revision').length} rejected={screens.filter((s) => s.status === 'rejected').length} active={active} busy={busyKind === 'screens'} t={t} onGenerate={() => generate('screens', feedback.screens)} onConfirmAll={() => confirmAll('screens')} />
          <FeedbackPanel
            active={active && screens.length > 0}
            busy={busyKind === 'screens'}
            value={feedback.screens}
            onChange={(v) => setFeedback((f) => ({ ...f, screens: v }))}
            t={t}
            onRun={() => generate('screens', feedback.screens)}
          />
          {screens.map((s) => (
            <div key={s.id} className={`rounded-xl border bg-card p-3 sm:p-4 ${s.status === 'rejected' ? 'opacity-60' : ''}`}>
              <div className="flex items-start gap-2 flex-wrap">
                <CodeChip code={s.code} className="mt-0.5" />
                <div className="flex-1 min-w-[200px]">
                  <div className="text-sm font-medium" dir="ltr">
                    {s.name}
                    {s.nameAr && <span className="text-muted-foreground font-arabic ms-2" dir="rtl">· {s.nameAr}</span>}
                  </div>
                  {s.route && <code className="text-[11px] text-muted-foreground font-mono" dir="ltr">{s.route}</code>}
                  <div className="flex flex-wrap gap-1 mt-1.5">
                    {s.roles.map((r) => (
                      <Badge key={r} variant="outline" className="text-[10px] bg-muted/40">{r}</Badge>
                    ))}
                    {s.linkedRequirements.map((c) => <CodeChip key={c} code={c} />)}
                  </div>
                </div>
                <ReviewBadge status={s.status} />
              </div>
              {expanded === s.id && (
                <div className="mt-3 border-t pt-3 space-y-3" dir="ltr">
                  {s.purpose && <p className="text-xs text-muted-foreground leading-6">{s.purpose}</p>}
                  {s.elements.length > 0 && (
                    <div>
                      <div className="text-[11px] font-semibold text-muted-foreground mb-1">{t('colFeature')}</div>
                      <ul className="space-y-1">
                        {s.elements.map((el, i) => (
                          <li key={i} className="text-xs leading-6">• <span className="font-medium">{el.element}</span> — <span className="text-muted-foreground">{el.behavior}</span></li>
                        ))}
                      </ul>
                    </div>
                  )}
                  <div className="text-xs text-muted-foreground">
                    <span className="font-semibold text-foreground">{t('statesTitle')}: </span>
                    ⏳ {s.states.loading} · ◻ {s.states.empty} · ⚠ {s.states.error}
                  </div>
                  {s.rtlNote && (
                    <div className="text-xs text-muted-foreground">
                      <span className="font-semibold text-foreground">{t('rtlConsideration')}: </span>
                      {s.rtlNote}
                    </div>
                  )}
                </div>
              )}
              <Expand id={s.id} expanded={expanded} setExpanded={setExpanded} t={t} />
              <ReviewActions kind="screen" id={s.id} status={s.status} active={active} t={t} onReview={review} />
            </div>
          ))}
        </TabsContent>

        {/* ---------- Architecture ---------- */}
        <TabsContent value="architecture" className="mt-3 space-y-3">
          <GenerateBar
            kind="architecture"
            count={architecture ? 1 : 0}
            unreviewed={architecture && architecture.status !== 'confirmed' ? 1 : 0}
            rejected={architecture?.status === 'rejected' ? 1 : 0}
            active={active}
            busy={busyKind === 'architecture'}
            t={t}
            onGenerate={() => generate('architecture', feedback.architecture)}
            onConfirmAll={null}
          />
          <FeedbackPanel
            active={active && !!architecture}
            busy={busyKind === 'architecture'}
            value={feedback.architecture}
            onChange={(v) => setFeedback((f) => ({ ...f, architecture: v }))}
            t={t}
            onRun={() => generate('architecture', feedback.architecture)}
            notice={architecture?.status === 'rejected' ? t('rejectedArchNotice') : undefined}
          />
          {busyKind === 'architecture' && !editingArch && (
            <WorkingPanel steps={[t('genArch1'), t('genArch2')]} />
          )}
          {architecture && (
            <div className={`rounded-xl border bg-card p-3 sm:p-4 ${architecture.status === 'rejected' ? 'opacity-60' : ''}`}>
              <div className="flex items-start gap-2 flex-wrap">
                <Boxes className="h-4.5 w-4.5 text-primary mt-0.5" />
                <div className="text-sm font-semibold flex-1">{t('tabArchitecture')}</div>
                {active && !editingArch && (
                  <Button size="sm" variant="outline" className="gap-1.5" onClick={startEditArch}>
                    <Pencil className="h-3.5 w-3.5" />
                    {t('editArchitecture')}
                  </Button>
                )}
                <ReviewBadge status={architecture.status} />
              </div>

              {editingArch ? (
                <div className="mt-3 space-y-3" dir="ltr">
                  <div className="space-y-2">
                    {draftStack.map((row, i) => (
                      <div key={i} className="rounded-lg border p-2.5 space-y-2 bg-muted/20">
                        <div className="flex flex-wrap gap-2">
                          <Input
                            value={row.area}
                            onChange={(e) => setDraftStack((s) => s.map((r, j) => (j === i ? { ...r, area: e.target.value } : r)))}
                            placeholder="area"
                            className="h-8 text-xs font-medium w-32"
                          />
                          <Input
                            value={row.choice}
                            onChange={(e) => setDraftStack((s) => s.map((r, j) => (j === i ? { ...r, choice: e.target.value } : r)))}
                            placeholder="choice"
                            className="h-8 text-xs flex-1 min-w-[160px]"
                          />
                          <label className="flex items-center gap-1.5 text-[11px] text-muted-foreground px-1">
                            <Checkbox
                              checked={row.simplestOption}
                              onCheckedChange={(v) => setDraftStack((s) => s.map((r, j) => (j === i ? { ...r, simplestOption: v === true } : r)))}
                            />
                            {t('simplestOption')}
                          </label>
                          <Button
                            size="icon"
                            variant="ghost"
                            className="h-7 w-7 text-red-500"
                            aria-label="remove"
                            onClick={() => setDraftStack((s) => s.filter((_, j) => j !== i))}
                          >
                            <X className="h-3.5 w-3.5" />
                          </Button>
                        </div>
                        <div className="grid sm:grid-cols-2 gap-2">
                          <Input
                            value={row.rationale}
                            onChange={(e) => setDraftStack((s) => s.map((r, j) => (j === i ? { ...r, rationale: e.target.value } : r)))}
                            placeholder="rationale"
                            className="h-8 text-xs"
                          />
                          <Input
                            value={row.tradeOffs}
                            onChange={(e) => setDraftStack((s) => s.map((r, j) => (j === i ? { ...r, tradeOffs: e.target.value } : r)))}
                            placeholder="trade-offs"
                            className="h-8 text-xs"
                          />
                        </div>
                      </div>
                    ))}
                  </div>
                  <div className="flex flex-wrap gap-2">
                    <Button
                      size="sm"
                      variant="outline"
                      onClick={() => setDraftStack((s) => [...s, { area: '', choice: '', rationale: '', tradeOffs: '', simplestOption: false }])}
                    >
                      <Plus className="h-3.5 w-3.5 me-1" />
                      {t('addTechRow')}
                    </Button>
                    <div className="flex-1" />
                    <Button size="sm" variant="outline" onClick={() => setEditingArch(false)}>
                      {t('cancelEdits')}
                    </Button>
                    <Button size="sm" className="gap-1.5" onClick={saveArchEdits} disabled={busyKind === 'architecture'}>
                      {busyKind === 'architecture' ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <Check className="h-3.5 w-3.5" />}
                      {t('saveEdits')}
                    </Button>
                  </div>
                  <div>
                    <textarea
                      rows={3}
                      value={draftNotes}
                      onChange={(e) => setDraftNotes(e.target.value)}
                      placeholder={t('architectureNotes')}
                      className="w-full rounded-lg border p-2.5 text-xs leading-6 outline-none focus:ring-2 focus:ring-primary/30"
                    />
                  </div>
                </div>
              ) : (
                <div className="mt-3 space-y-3" dir="ltr">
                  {architecture.components.length > 0 && (
                    <div className="flex flex-wrap gap-1.5">
                      {architecture.components.map((c) => (
                        <Badge key={c.name} variant="outline" className="text-[10px] bg-muted/40 max-w-[260px] whitespace-normal h-auto py-1" title={c.responsibility}>
                          {c.name}
                        </Badge>
                      ))}
                    </div>
                  )}
                  <div className="overflow-x-auto nice-scroll">
                    <table className="w-full text-xs">
                      <thead>
                        <tr className="text-muted-foreground border-b">
                          <th className="py-1.5 text-start font-medium pe-2">Area</th>
                          <th className="py-1.5 text-start font-medium pe-2">Choice</th>
                          <th className="py-1.5 text-start font-medium pe-2">Rationale</th>
                          <th className="py-1.5 text-start font-medium">Trade-offs</th>
                        </tr>
                      </thead>
                      <tbody>
                        {architecture.techStack.map((tech) => (
                          <tr key={tech.area} className="border-b last:border-0 align-top">
                            <td className="py-1.5 pe-2 font-medium whitespace-nowrap">
                              {tech.area}
                              {tech.simplestOption && <Badge variant="outline" className="ms-1 text-[9px] bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200 dark:border-emerald-500/25 whitespace-nowrap">{t('simplestOption')}</Badge>}
                            </td>
                            <td className="py-1.5 pe-2">{tech.choice}</td>
                            <td className="py-1.5 pe-2 text-muted-foreground">{tech.rationale}</td>
                            <td className="py-1.5 text-muted-foreground">{tech.tradeOffs}</td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  </div>
                  {architecture.integrations.length > 0 && (
                    <div className="text-xs text-muted-foreground">
                      {architecture.integrations.map((i, idx) => (
                        <span key={idx}>{idx > 0 && ' · '}<span className="font-medium text-foreground">{i.system}</span> — {i.purpose} <span className="text-muted-foreground/70">({i.necessity})</span></span>
                      ))}
                    </div>
                  )}
                  {architecture.notes && <p className="text-xs leading-6 text-muted-foreground bg-muted/30 rounded-lg p-3">{architecture.notes}</p>}
                </div>
              )}
              <ReviewActions kind="architecture" id={architecture.id} status={architecture.status} active={active} t={t} onReview={review} />
            </div>
          )}
        </TabsContent>

        {/* ---------- Architect Lab (trade-offs · ADRs · STRIDE · scale) ---------- */}
        <TabsContent value="architect" className="mt-3">
          <ArchitectLab detail={detail} />
        </TabsContent>
      </Tabs>

      {/* Gate */}
      {active && (
        <div className="rounded-xl border border-primary/25 bg-primary/[0.03] p-4">
          <Button className="gap-2" onClick={passGate} disabled={busyGate}>
            <Check className="h-4 w-4" />
            {t('approveDesign')}
          </Button>
        </div>
      )}
    </div>
  )
}

// ---------- Module-level shared pieces (no components inside render) ----------

function FeedbackPanel({
  active,
  busy,
  value,
  onChange,
  t,
  onRun,
  notice,
}: {
  active: boolean
  busy: boolean
  value: string
  onChange: (v: string) => void
  t: (key: Parameters<ReturnType<typeof useApp>['t']>[0]) => string
  onRun: () => void
  notice?: string
}) {
  if (!active) return null
  return (
    <details className="rounded-xl border border-amber-300/70 dark:border-amber-500/30 bg-amber-50/60">
      <summary className="flex cursor-pointer items-center gap-2 px-3.5 py-2.5 text-xs font-semibold text-amber-900 dark:text-amber-300 min-h-11">
        <MessageSquareWarning className="h-4 w-4 text-amber-600 dark:text-amber-400" />
        {t('feedbackLabel')}
      </summary>
      <div className="px-3.5 pb-3.5 space-y-2.5">
        {notice && <p className="text-xs text-amber-900 dark:text-amber-300 leading-6">{notice}</p>}
        <p className="text-[11px] text-amber-800 dark:text-amber-300 leading-5">{t('feedbackForTab')}</p>
        <textarea
          rows={2}
          value={value}
          onChange={(ev) => onChange(ev.target.value)}
          placeholder={t('feedbackPlaceholder')}
          className="w-full rounded-lg border border-amber-300 dark:border-amber-500/30 bg-white dark:bg-transparent p-2.5 text-sm leading-6 outline-none focus:ring-2 focus:ring-amber-400/40"
        />
        <div className="flex flex-wrap items-center gap-2">
          <Button size="sm" className="gap-1.5" onClick={onRun} disabled={busy}>
            {busy ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <MessageSquareWarning className="h-3.5 w-3.5" />}
            {t('regenerateWithFeedback')}
          </Button>
          <span className="text-[11px] text-amber-800 dark:text-amber-300">{t('regenReplacesRejected')}</span>
        </div>
      </div>
    </details>
  )
}

function GenerateBar({
  kind,
  count,
  unreviewed,
  rejected,
  active,
  busy,
  t,
  onGenerate,
  onConfirmAll,
}: {
  kind: Kind
  count: number
  unreviewed: number
  rejected: number
  active: boolean
  busy: boolean
  t: (key: Parameters<ReturnType<typeof useApp>['t']>[0]) => string
  onGenerate: () => void
  onConfirmAll: (() => void) | null
}) {
  return (
    <div className="flex flex-wrap items-center gap-2">
      {busy ? (
        <WorkingPanel steps={[t(GENERATE_KEYS[kind].steps[0]), t(GENERATE_KEYS[kind].steps[1])]} className="flex-1" />
      ) : (
        <>
          {active && (
            <>
              <Button size="sm" onClick={onGenerate} className="gap-1.5">
                {count === 0 ? t(GENERATE_KEYS[kind].label) : t('regenerate')}
              </Button>
              {count > 0 && unreviewed > 0 && onConfirmAll && (
                <Button size="sm" variant="outline" onClick={onConfirmAll}>
                  {t('confirmAllKind')} ({unreviewed})
                </Button>
              )}
            </>
          )}
          <span className="text-xs text-muted-foreground">
            {count} · {unreviewed} {t('unreviewed')}
            {rejected > 0 && <span> · {rejected} {t('rejectedShort')}</span>}
          </span>
        </>
      )}
    </div>
  )
}

function ReviewActions({
  kind,
  id,
  status,
  active,
  t,
  onReview,
}: {
  kind: string
  id: string
  status: string
  active: boolean
  t: (key: Parameters<ReturnType<typeof useApp>['t']>[0]) => string
  onReview: (kind: string, id: string, status: string) => void
}) {
  // needs_revision items stay decidable even after the stage advanced —
  // change-impact control must never become a dead end.
  const decidable = active || status === 'needs_revision'
  if (!decidable || status === 'rejected') return null
  return (
    <div className="mt-2 flex gap-1.5 border-t pt-2">
      {status !== 'confirmed' && (
        <Button size="sm" variant="outline" className="gap-1 border-emerald-300 dark:border-emerald-500/30 text-emerald-700 dark:text-emerald-300 hover:bg-emerald-50 dark:hover:bg-emerald-500/10" onClick={() => onReview(kind, id, 'confirmed')}>
          <Check className="h-3.5 w-3.5" />
          {t('confirmArtifact')}
        </Button>
      )}
      {status !== 'rejected' && (
        <Button size="sm" variant="outline" className="gap-1 border-red-200 dark:border-red-500/25 text-red-600 dark:text-red-400 hover:bg-red-50 dark:hover:bg-red-500/10" onClick={() => onReview(kind, id, 'rejected')}>
          <X className="h-3.5 w-3.5" />
          {t('rejectArtifact')}
        </Button>
      )}
    </div>
  )
}

function Expand({
  id,
  expanded,
  setExpanded,
  t,
}: {
  id: string
  expanded: string | null
  setExpanded: (v: string | null) => void
  t: (key: Parameters<ReturnType<typeof useApp>['t']>[0]) => string
}) {
  const open = expanded === id
  return (
    <button type="button" onClick={() => setExpanded(open ? null : id)} className="mt-1 text-[11px] text-primary hover:underline inline-flex items-center gap-1 min-h-9">
      {open ? <ChevronUp className="h-3 w-3" /> : <ChevronDown className="h-3 w-3" />}
      {open ? t('viewLess') : t('viewMore')}
    </button>
  )
}
