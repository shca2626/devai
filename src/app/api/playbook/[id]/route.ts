import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { serializeTemplate } from '@/lib/engines/playbook'

type Params = { params: Promise<{ id: string }> }

// PATCH /api/playbook/[id] — edit template / toggle favorite.
// Built-in templates can only be favorited (not edited or deleted)
// — the user can copy them into their own template instead.
export async function PATCH(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json()) as {
      title?: string
      description?: string
      category?: string
      body?: string
      isFavorite?: boolean
    }

    const existing = await db.promptTemplate.findUnique({ where: { id } })
    if (!existing) {
      return NextResponse.json({ error: 'Template not found.' }, { status: 404 })
    }

    if (existing.isBuiltin) {
      if (typeof body.isFavorite === 'boolean') {
        await db.promptTemplate.update({ where: { id }, data: { isFavorite: body.isFavorite } })
      }
    } else {
      const title = typeof body.title === 'string' ? body.title.trim() : undefined
      if (title !== undefined && title.length < 3) {
        return NextResponse.json({ error: 'Title is too short.' }, { status: 400 })
      }
      const templateBody = typeof body.body === 'string' ? body.body.trim() : undefined
      if (templateBody !== undefined && templateBody.length < 20) {
        return NextResponse.json({ error: 'Template body is too short.' }, { status: 400 })
      }
      const category =
        typeof body.category === 'string' &&
        ['new_feature', 'bug_fix', 'refactor', 'tests', 'review', 'planning', 'general'].includes(body.category)
          ? body.category
          : undefined

      await db.promptTemplate.update({
        where: { id },
        data: {
          ...(title !== undefined ? { title: title.slice(0, 120) } : {}),
          ...(typeof body.description === 'string' ? { description: body.description.trim().slice(0, 300) } : {}),
          ...(category !== undefined ? { category } : {}),
          ...(templateBody !== undefined ? { body: templateBody } : {}),
          ...(typeof body.isFavorite === 'boolean' ? { isFavorite: body.isFavorite } : {}),
        },
      })
    }

    const updated = await db.promptTemplate.findUnique({ where: { id } })
    return NextResponse.json({ template: updated ? serializeTemplate(updated) : null })
  } catch (error) {
    console.error('[api/playbook/[id] PATCH]', error)
    return NextResponse.json({ error: 'Failed to update the template.' }, { status: 500 })
  }
}

// DELETE /api/playbook/[id] — user templates only.
export async function DELETE(_req: Request, { params }: Params) {
  try {
    const { id } = await params
    const existing = await db.promptTemplate.findUnique({ where: { id } })
    if (!existing) {
      return NextResponse.json({ error: 'Template not found.' }, { status: 404 })
    }
    if (existing.isBuiltin) {
      return NextResponse.json({ error: 'Built-in templates cannot be deleted.' }, { status: 400 })
    }
    await db.promptTemplate.delete({ where: { id } })
    return NextResponse.json({ ok: true })
  } catch (error) {
    console.error('[api/playbook/[id] DELETE]', error)
    return NextResponse.json({ error: 'Failed to delete the template.' }, { status: 500 })
  }
}
