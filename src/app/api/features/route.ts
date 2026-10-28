import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail, logDecision } from '@/lib/payload'
import { PRIORITIES } from '@/lib/types'

// Add a feature manually — user-added features count as
// ACCEPTED decisions from the start (the user is the source).
export async function POST(req: Request) {
  try {
    const body = (await req.json()) as {
      ideaId?: string
      module?: string
      feature?: string
      user?: string
      priority?: string
      rationale?: string
    }

    const ideaId = (body.ideaId ?? '').trim()
    const feature = (body.feature ?? '').trim()
    if (!ideaId || !feature) {
      return NextResponse.json({ error: 'Feature name is required.' }, { status: 400 })
    }

    const idea = await db.idea.findUnique({ where: { id: ideaId } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }
    if (idea.stage !== 'features') {
      return NextResponse.json(
        { error: 'Features can only be added during the features stage.' },
        { status: 409 }
      )
    }

    const priority = PRIORITIES.includes(body.priority as never) ? body.priority! : 'should'
    const count = await db.feature.count({ where: { ideaId } })

    await db.feature.create({
      data: {
        ideaId,
        module: (body.module ?? 'General').trim().slice(0, 60) || 'General',
        feature: feature.slice(0, 160),
        user: (body.user ?? 'All users').trim().slice(0, 60) || 'All users',
        priority,
        status: 'accepted',
        rationale: (body.rationale ?? '').trim().slice(0, 300) || null,
        origin: 'user',
        order: count,
      },
    })

    await logDecision(ideaId, 'Feature added by user', feature.slice(0, 200), 'features')
    const payload = await buildIdeaDetail(ideaId)
    return NextResponse.json(payload, { status: 201 })
  } catch (error) {
    console.error('[api/features POST]', error)
    return NextResponse.json({ error: 'Failed to add the feature.' }, { status: 500 })
  }
}
