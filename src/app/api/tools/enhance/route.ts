import { NextResponse } from 'next/server'
import { enhancePrompt } from '@/lib/engines/prompt-lab'

// POST /api/tools/enhance — prompt-engineering pass (Bolt/Replit-style
// "Plan"): raw idea + build target (website | app | prototype) ->
// a structured, professional build prompt. Pure utility: does NOT touch
// the database; the user reviews and decides whether to use the result.
export async function POST(req: Request) {
  try {
    const body = (await req.json()) as { text?: string; projectType?: string }
    const text = (body.text ?? '').trim()
    const projectType =
      body.projectType === 'website' || body.projectType === 'app' || body.projectType === 'prototype'
        ? body.projectType
        : null

    if (text.length < 10) {
      return NextResponse.json(
        { error: 'Please describe your idea in at least a sentence or two before enhancing.' },
        { status: 400 }
      )
    }
    if (!projectType) {
      return NextResponse.json(
        { error: 'projectType must be "website", "app" or "prototype".' },
        { status: 400 }
      )
    }

    const result = await enhancePrompt(text, projectType)
    return NextResponse.json(result)
  } catch (error) {
    console.error('[api/tools/enhance POST]', error)
    return NextResponse.json(
      { error: 'The AI prompt service failed. Please try again.' },
      { status: 502 }
    )
  }
}
