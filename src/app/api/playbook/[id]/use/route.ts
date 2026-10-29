import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { expandTemplate, serializeTemplate } from '@/lib/engines/playbook'

type Params = { params: Promise<{ id: string }> }

// POST /api/playbook/[id]/use — record usage and return the
// expanded prompt with the caller's variable values.
export async function POST(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json()) as { values?: Record<string, string> }

    const existing = await db.promptTemplate.findUnique({ where: { id } })
    if (!existing) {
      return NextResponse.json({ error: 'Template not found.' }, { status: 404 })
    }

    await db.promptTemplate.update({ where: { id }, data: { useCount: { increment: 1 } } })
    const prompt = expandTemplate(existing.body, body.values ?? {})

    return NextResponse.json({
      prompt,
      template: serializeTemplate({ ...existing, useCount: existing.useCount + 1 }),
    })
  } catch (error) {
    console.error('[api/playbook/[id]/use POST]', error)
    return NextResponse.json({ error: 'Failed to apply the template.' }, { status: 500 })
  }
}
