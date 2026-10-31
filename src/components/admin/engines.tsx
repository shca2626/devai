'use client'

import { ENGINE_DOCS } from '@/lib/admin/docs'
import { Cpu, FileCode2, Infinity as InfinityIcon, Zap } from 'lucide-react'

// ============================================================
// Admin engines — the complete AI/processing layer of the
// platform: what each engine file does and how the gateway is
// structured. Plus the no-limits policy summary.
// ============================================================

export function AdminEngines() {
  return (
    <div className="space-y-6">
      <div>
        <h2 className="text-sm font-semibold mb-1">Engines & AI layer ({ENGINE_DOCS.length} modules)</h2>
        <p className="text-xs text-muted-foreground leading-5">
          Every AI capability lives in a dedicated engine file under <code className="font-mono text-[11px]">src/lib/engines/</code>.
          The engines only STRUCTURE and PRODUCE artifacts — every score, gate and verification is computed
          deterministically by the application, never trusted to the model.
        </p>
      </div>

      <div className="rounded-xl border border-emerald-300 dark:border-emerald-500/30 bg-emerald-50/70 dark:bg-emerald-500/10 p-4 space-y-2">
        <div className="flex items-center gap-2 text-sm font-semibold text-emerald-800 dark:text-emerald-300">
          <InfinityIcon className="h-4 w-4" />
          No-limits policy (active)
        </div>
        <ul className="space-y-1 text-xs text-emerald-800 dark:text-emerald-300 leading-6">
          <li>• All 9 workflow stages are navigable at any time — the stepper never locks.</li>
          <li>• Every gate passes: unreviewed items are auto-accepted (or bulk-deferred/rejected by choice), missing artifacts never block, the readiness score is advisory.</li>
          <li>• Every engine can run from any stage — generate requirements before features if you want.</li>
          <li>• No minimums: idea text, answers, code length — any non-empty input is accepted.</li>
          <li>• The Express autopilot never blocks: it auto-creates missing interpretations and dismisses unfixable issues (logged).</li>
          <li>• Honest scoring is preserved: readiness/verification/drift scores stay deterministic and truthful — they advise, never block.</li>
        </ul>
      </div>

      <div className="rounded-xl border bg-card overflow-hidden">
        <div className="border-b bg-muted/50 px-4 py-2.5 flex items-center gap-2 text-sm font-semibold">
          <FileCode2 className="h-4 w-4 text-primary" />
          Engine modules
        </div>
        <div className="divide-y">
          {ENGINE_DOCS.map((e) => (
            <div key={e.file} className="px-4 py-2.5">
              <code className="text-[12px] font-mono font-semibold">{e.file}</code>
              <p className="text-xs text-muted-foreground leading-5 mt-0.5">{e.what}</p>
            </div>
          ))}
        </div>
      </div>

      <div className="rounded-xl border bg-card p-4">
        <div className="flex items-center gap-2 mb-3 text-sm font-semibold">
          <Cpu className="h-4 w-4 text-primary" />
          AI gateway architecture
        </div>
        <div className="grid gap-3 sm:grid-cols-2 text-xs leading-6">
          <div className="rounded-lg border bg-muted/30 p-3">
            <div className="font-semibold flex items-center gap-1.5 mb-1">
              <Zap className="h-3.5 w-3.5 text-amber-500" />
              src/lib/ai.ts
            </div>
            <p className="text-muted-foreground">
              One shared ZAI instance. <span className="font-mono">chatText</span> for prose,{' '}
              <span className="font-mono">chatJson</span> for JSON-first responses with automatic retries (0.8s backoff).
              Workflow rules never live here.
            </p>
          </div>
          <div className="rounded-lg border bg-muted/30 p-3">
            <div className="font-semibold mb-1">Deterministic scoring</div>
            <p className="text-muted-foreground">
              Readiness (10 weighted checks), verification coverage (0-100), drift alignment (0-100) and site-intel
              completeness (0-100) are all computed by the app from collected facts — the model can never inflate them.
            </p>
          </div>
        </div>
      </div>
    </div>
  )
}
