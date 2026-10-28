import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { previewImpact } from '@/lib/impact'

// ============================================================
// Change impact preview — read-only. Asks "what breaks if this
// requirement changes?" BEFORE anything is applied.
// ============================================================

type Params = { params: Promise<{ id: string }> }

export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json().catch(() => ({}))) as { requirementId?: string; change?: string }
    if (!body.requirementId) {
      return NextResponse.json({ error: 'requirementId is required.' }, { status: 400 })
    }
    const preview = await previewImpact(id, body.requirementId, body.change ?? 'planned change')
    if (!preview) {
      return NextResponse.json({ error: 'Requirement not found.' }, { status: 404 })
    }
    return NextResponse.json(preview)
  } catch (error) {
    console.error('[api/ideas/[id]/impact POST]', error)
    return NextResponse.json({ error: 'Failed to analyze the impact.' }, { status: 500 })
  }
}
