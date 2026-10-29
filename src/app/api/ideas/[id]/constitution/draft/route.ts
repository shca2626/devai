import { NextResponse } from 'next/server'
import { draftConstitution } from '@/lib/engines/context-pack'

type Params = { params: Promise<{ id: string }> }

// POST /api/ideas/[id]/constitution/draft — AI drafts project-scoped
// constitution rules from the approved context (interpretation,
// features, requirements, entities, architecture, risks) and saves
// them. Never overwrites existing rules — appends only.
export async function POST(_req: Request, { params }: Params) {
  try {
    const { id } = await params
    const rules = await draftConstitution(id)
    return NextResponse.json({ rules })
  } catch (error) {
    console.error('[api/ideas/[id]/constitution/draft POST]', error)
    const message =
      error instanceof Error && error.message === 'Idea not found'
        ? 'Idea not found.'
        : 'The AI constitution service failed. Please try again.'
    return NextResponse.json({ error: message }, { status: 502 })
  }
}
