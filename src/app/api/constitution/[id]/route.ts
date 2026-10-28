import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { listRules } from '@/lib/engines/context-pack'

type Params = { params: Promise<{ id: string }> }

// PATCH /api/constitution/[id] — edit text / category / enabled flag.
export async function PATCH(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json()) as {
      text?: string
      category?: string
      enabled?: boolean
    }

    const existing = await db.constitutionRule.findUnique({ where: { id } })
    if (!existing) {
      return NextResponse.json({ error: 'Rule not found.' }, { status: 404 })
    }

    const text = typeof body.text === 'string' ? body.text.trim() : undefined
    if (text !== undefined && text.length < 5) {
      return NextResponse.json({ error: 'Rule text is too short.' }, { status: 400 })
    }
    const category =
      typeof body.category === 'string' &&
      ['stack', 'coding', 'security', 'design', 'quality', 'workflow'].includes(body.category)
        ? body.category
        : undefined

    await db.constitutionRule.update({
      where: { id },
      data: {
        ...(text !== undefined ? { text } : {}),
        ...(category !== undefined ? { category } : {}),
        ...(typeof body.enabled === 'boolean' ? { enabled: body.enabled } : {}),
      },
    })

    const rules = await listRules(existing.ideaId)
    return NextResponse.json({ rules })
  } catch (error) {
    console.error('[api/constitution/[id] PATCH]', error)
    return NextResponse.json({ error: 'Failed to update the rule.' }, { status: 500 })
  }
}

// DELETE /api/constitution/[id]
export async function DELETE(_req: Request, { params }: Params) {
  try {
    const { id } = await params
    const existing = await db.constitutionRule.findUnique({ where: { id } })
    if (!existing) {
      return NextResponse.json({ error: 'Rule not found.' }, { status: 404 })
    }
    await db.constitutionRule.delete({ where: { id } })
    const rules = await listRules(existing.ideaId)
    return NextResponse.json({ rules })
  } catch (error) {
    console.error('[api/constitution/[id] DELETE]', error)
    return NextResponse.json({ error: 'Failed to delete the rule.' }, { status: 500 })
  }
}
