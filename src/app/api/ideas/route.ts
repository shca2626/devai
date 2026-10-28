import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { isProbablyArabic } from '@/lib/json-utils'
import { buildIdeaDetail, buildIdeaList, logDecision } from '@/lib/payload'
import { interpretIdea } from '@/lib/engines/understand'

export async function GET() {
  try {
    const ideas = await buildIdeaList()
    return NextResponse.json({ ideas })
  } catch (error) {
    console.error('[api/ideas GET]', error)
    return NextResponse.json({ error: 'Failed to load ideas' }, { status: 500 })
  }
}

export async function POST(req: Request) {
  try {
    const body = (await req.json()) as { text?: string }
    const text = (body.text ?? '').trim()
    if (text.length < 10) {
      return NextResponse.json(
        { error: 'Please describe your idea in at least a sentence or two.' },
        { status: 400 }
      )
    }
    if (text.length > 4000) {
      return NextResponse.json({ error: 'Idea text is too long (max 4000 characters).' }, { status: 400 })
    }

    const sourceLang = isProbablyArabic(text) ? 'ar' : 'en'

    // Engine 1 — bilingual understanding (real AI call)
    const interpretation = await interpretIdea(text)

    const idea = await db.idea.create({
      data: {
        title: interpretation.title,
        originalText: text,
        sourceLang,
        stage: 'understanding',
        interpretation: JSON.stringify(interpretation),
      },
    })

    // Track tentative assumptions from day one
    for (const a of interpretation.assumed) {
      await db.assumption.create({
        data: { ideaId: idea.id, text: a, kind: 'suggested', status: 'open', source: 'understanding' },
      })
    }

    await logDecision(idea.id, 'Idea submitted and interpreted', `Detected language: ${sourceLang === 'ar' ? 'Arabic' : 'English'}`, 'understanding')

    const payload = await buildIdeaDetail(idea.id)
    return NextResponse.json(payload, { status: 201 })
  } catch (error) {
    console.error('[api/ideas POST]', error)
    const message =
      error instanceof Error && error.message.includes('AI')
        ? 'The AI service could not interpret the idea. Please try again.'
        : 'Failed to create the idea. Please try again.'
    return NextResponse.json({ error: message }, { status: 502 })
  }
}
