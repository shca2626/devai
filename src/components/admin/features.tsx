'use client'

import { useState } from 'react'
import { Badge } from '@/components/ui/badge'
import { STAGE_DOCS, TOOL_DOCS } from '@/lib/admin/docs'
import { ChevronDown } from 'lucide-react'

// ============================================================
// Admin features documentation — what every stage and tool of
// the platform does, which engine powers it and which API
// endpoints serve it. The map of the whole system.
// ============================================================

function StageCard({ doc }: { doc: (typeof STAGE_DOCS)[number] }) {
  const [open, setOpen] = useState(false)
  return (
    <div className="rounded-xl border bg-card overflow-hidden">
      <button
        type="button"
        className="w-full flex items-center gap-3 px-4 py-3 text-start hover:bg-muted/40 transition-colors"
        onClick={() => setOpen(!open)}
      >
        <span className="flex h-8 w-8 shrink-0 items-center justify-center rounded-lg bg-primary/10 text-sm font-bold text-primary">
          {doc.n}
        </span>
        <div className="flex-1 min-w-0">
          <div className="text-sm font-semibold">
            {doc.title}
            <span className="ms-2 text-xs font-normal text-muted-foreground font-arabic">{doc.titleAr}</span>
          </div>
          <div className="text-[11px] text-muted-foreground font-mono truncate">{doc.engine}</div>
        </div>
        <ChevronDown className={`h-4 w-4 text-muted-foreground transition-transform shrink-0 ${open ? 'rotate-180' : ''}`} />
      </button>
      {open && (
        <div className="border-t bg-muted/20 px-4 py-3 space-y-2.5">
          <p className="text-xs leading-6">{doc.what}</p>
          <div className="flex flex-wrap gap-1.5">
            {doc.apis.map((api) => (
              <code key={api} className="rounded border bg-background px-1.5 py-0.5 text-[10px] font-mono">
                {api}
              </code>
            ))}
          </div>
        </div>
      )}
    </div>
  )
}

function ToolCard({ doc }: { doc: (typeof TOOL_DOCS)[number] }) {
  const [open, setOpen] = useState(false)
  return (
    <div className="rounded-xl border bg-card overflow-hidden">
      <button
        type="button"
        className="w-full flex items-center gap-3 px-4 py-3 text-start hover:bg-muted/40 transition-colors"
        onClick={() => setOpen(!open)}
      >
        <div className="flex-1 min-w-0">
          <div className="text-sm font-semibold">{doc.name}</div>
          <p className="text-[11px] text-muted-foreground leading-5 truncate">{doc.what}</p>
        </div>
        <ChevronDown className={`h-4 w-4 text-muted-foreground transition-transform shrink-0 ${open ? 'rotate-180' : ''}`} />
      </button>
      {open && (
        <div className="border-t bg-muted/20 px-4 py-3 space-y-2.5">
          <p className="text-xs leading-6">{doc.what}</p>
          <ul className="space-y-1">
            {doc.details.map((d) => (
              <li key={d} className="text-xs leading-6 flex gap-2">
                <span className="text-primary mt-1.5 h-1 w-1 shrink-0 rounded-full bg-primary" />
                {d}
              </li>
            ))}
          </ul>
          <div className="flex flex-wrap gap-1.5">
            {doc.apis.map((api) => (
              <code key={api} className="rounded border bg-background px-1.5 py-0.5 text-[10px] font-mono">
                {api}
              </code>
            ))}
          </div>
        </div>
      )}
    </div>
  )
}

export function AdminFeatures() {
  return (
    <div className="space-y-8">
      {/* The pipeline */}
      <section className="space-y-3">
        <div>
          <h2 className="text-sm font-semibold">The 9-stage workflow (idea → engineering package)</h2>
          <p className="text-xs text-muted-foreground leading-5">
            Arabic-first, bilingual. Every stage is an AI engine + an explicit human gate. In no-limits mode all stages are
            navigable at any time and every gate passes (auto-accepting unreviewed items, logging everything).
          </p>
        </div>
        <div className="flex flex-wrap items-center gap-1.5 mb-1">
          {STAGE_DOCS.map((s, i) => (
            <span key={s.key} className="flex items-center gap-1.5">
              <Badge variant="outline" className="text-[10px] font-mono bg-background">
                {s.n}. {s.key}
              </Badge>
              {i < STAGE_DOCS.length - 1 && <span className="text-muted-foreground text-[10px]">→</span>}
            </span>
          ))}
        </div>
        <div className="space-y-2">
          {STAGE_DOCS.map((doc) => (
            <StageCard key={doc.key} doc={doc} />
          ))}
        </div>
      </section>

      {/* The tools */}
      <section className="space-y-3">
        <div>
          <h2 className="text-sm font-semibold">The 9 standalone tools (available from any stage)</h2>
          <p className="text-xs text-muted-foreground leading-5">
            Vibe-coding armor: everything that protects the handoff between this planner and the AI builders (Bolt, Cursor,
            Claude, ChatGPT…).
          </p>
        </div>
        <div className="space-y-2">
          {TOOL_DOCS.map((doc) => (
            <ToolCard key={doc.name} doc={doc} />
          ))}
        </div>
      </section>
    </div>
  )
}
