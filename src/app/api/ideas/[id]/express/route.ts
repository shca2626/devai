import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail } from '@/lib/payload'
import { runExpressStep } from '@/lib/express'

// ============================================================
// Express autopilot — performs ONE unit of work per call and
// returns the fresh project state. The UI drives the loop and
// renders live progress; the user can stop at any moment.
// Delegated decisions are logged and reversible — the package
// can be reopened and any artifact edited later.
// ============================================================

type Params = { params: Promise<{ id: string }> }

export const maxDuration = 300

export async function POST(_req: Request, { params }: Params) {
  try {
    const { id } = await params
    const idea = await db.idea.findUnique({ where: { id }, select: { id: true } })
    if (!idea) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }

    const express = await runExpressStep(id)
    const detail = await buildIdeaDetail(id)

    return NextResponse.json({ express, detail })
  } catch (error) {
    console.error('[api/ideas/[id]/express POST]', error)
    return NextResponse.json(
      { error: 'The express autopilot failed on this step. You can retry or continue manually.' },
      { status: 502 }
    )
  }
}
