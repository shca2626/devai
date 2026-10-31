'use client'

import { useState } from 'react'
import { Badge } from '@/components/ui/badge'
import { Button } from '@/components/ui/button'
import { API_DOCS } from '@/lib/admin/docs'
import { Loader2, Play } from 'lucide-react'

// ============================================================
// Admin API explorer — every endpoint of the platform, grouped,
// with method badges and a live "Try it" runner for the safe
// GET endpoints (real fetch, real JSON response).
// ============================================================

const METHOD_STYLES: Record<string, string> = {
  GET: 'bg-emerald-50 dark:bg-emerald-500/10 text-emerald-700 dark:text-emerald-300 border-emerald-200 dark:border-emerald-500/25',
  POST: 'bg-sky-50 dark:bg-sky-500/10 text-sky-700 dark:text-sky-300 border-sky-200 dark:border-sky-500/25',
  PATCH: 'bg-amber-50 dark:bg-amber-500/10 text-amber-700 dark:text-amber-300 border-amber-200 dark:border-amber-500/25',
  DELETE: 'bg-red-50 dark:bg-red-500/10 text-red-700 dark:text-red-300 border-red-200 dark:border-red-500/25',
}

function TryPanel({ path }: { path: string }) {
  const [state, setState] = useState<'idle' | 'loading' | 'done' | 'error'>('idle')
  const [result, setResult] = useState<string>('')

  async function run() {
    setState('loading')
    try {
      const res = await fetch(path)
      const text = await res.text()
      try {
        setResult(JSON.stringify(JSON.parse(text), null, 2).slice(0, 4000))
      } catch {
        setResult(text.slice(0, 4000))
      }
      setState(res.ok ? 'done' : 'error')
    } catch (e) {
      setResult(String(e))
      setState('error')
    }
  }

  return (
    <div className="mt-2 space-y-2" onClick={(e) => e.stopPropagation()}>
      <Button size="sm" variant="outline" className="h-7 gap-1.5 text-[11px]" onClick={run} disabled={state === 'loading'}>
        {state === 'loading' ? <Loader2 className="h-3 w-3 animate-spin" /> : <Play className="h-3 w-3" />}
        Try it
      </Button>
      {state !== 'idle' && state !== 'loading' && (
        <pre
          dir="ltr"
          className={`rounded-lg border p-2.5 text-[10px] leading-4 font-mono whitespace-pre-wrap break-all max-h-64 overflow-y-auto nice-scroll ${
            state === 'error' ? 'bg-red-50/60 dark:bg-red-500/10 border-red-200 dark:border-red-500/25' : 'bg-muted/40'
          }`}
        >
          {result}
        </pre>
      )}
    </div>
  )
}

export function AdminApi() {
  return (
    <div className="space-y-6">
      <div>
        <h2 className="text-sm font-semibold mb-1">API — every endpoint ({API_DOCS.reduce((n, g) => n + g.entries.length, 0)} total)</h2>
        <p className="text-xs text-muted-foreground leading-5">
          The complete backend surface: workflow, engines, tools and the admin API itself. GET endpoints can be executed
          live with “Try it”. [id] parameters need a real idea/record id.
        </p>
      </div>

      {API_DOCS.map((group) => (
        <section key={group.group} className="rounded-xl border bg-card overflow-hidden">
          <div className="border-b bg-muted/50 px-4 py-2.5 text-sm font-semibold">{group.group}</div>
          <div className="divide-y">
            {group.entries.map((e) => (
              <div key={`${e.method}-${e.path}`} className="px-4 py-2.5">
                <div className="flex items-start gap-2 flex-wrap">
                  <Badge variant="outline" className={`text-[10px] font-mono shrink-0 ${METHOD_STYLES[e.method]}`}>
                    {e.method}
                  </Badge>
                  <code className="text-[12px] font-mono break-all">{e.path}</code>
                </div>
                <p className="text-xs text-muted-foreground leading-5 mt-1">{e.desc}</p>
                {e.tryable && <TryPanel path={e.path} />}
              </div>
            ))}
          </div>
        </section>
      ))}
    </div>
  )
}
