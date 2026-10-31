import { NextResponse } from 'next/server'
import { buildContextPack } from '@/lib/engines/context-pack'
import type { ContextPackOptions, ContextTarget } from '@/lib/types'

type Params = { params: Promise<{ id: string }> }

const TARGETS = ['bolt', 'cursor', 'claude', 'chatgpt', 'generic']
const BOOL_KEYS = [
  'includeConstitution',
  'includeRequirements',
  'includeProcesses',
  'includeArchitecture',
  'includeDataModel',
  'includeScreens',
  'includeTasks',
  'includeQa',
  'includeRisks',
  'includeDecisions',
] as const

// POST /api/ideas/[id]/context-pack — compile the vibe-coding handoff
// brief (deterministic; merges project brief + constitution + artifacts,
// framed for the chosen target tool). Does not touch the database.
export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json()) as Partial<Record<keyof ContextPackOptions, unknown>>

    const target: ContextTarget = TARGETS.includes(String(body.target))
      ? (String(body.target) as ContextTarget)
      : 'bolt'
    const lang = body.lang === 'ar' ? 'ar' : 'en'

    const options: ContextPackOptions = {
      target,
      lang,
      includeConstitution: body.includeConstitution !== false,
      includeRequirements: body.includeRequirements !== false,
      includeProcesses: body.includeProcesses !== false,
      includeArchitecture: body.includeArchitecture !== false,
      includeDataModel: body.includeDataModel !== false,
      includeScreens: body.includeScreens !== false,
      includeTasks: body.includeTasks === true,
      includeQa: body.includeQa === true,
      includeRisks: body.includeRisks !== false,
      includeDecisions: body.includeDecisions === true,
    }

    const result = await buildContextPack(id, options)
    return NextResponse.json(result)
  } catch (error) {
    console.error('[api/ideas/[id]/context-pack POST]', error)
    const message =
      error instanceof Error && error.message === 'Idea not found'
        ? 'Idea not found.'
        : 'Failed to compile the context pack. Please try again.'
    return NextResponse.json({ error: message }, { status: 502 })
  }
}
