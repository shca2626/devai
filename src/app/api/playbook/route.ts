import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { listTemplates, serializeTemplate } from '@/lib/engines/playbook'

// GET /api/playbook — list templates (seeds built-ins on first call).
export async function GET() {
  try {
    const templates = await listTemplates()
    return NextResponse.json({ templates })
  } catch (error) {
    console.error('[api/playbook GET]', error)
    return NextResponse.json({ error: 'Failed to load the playbook.' }, { status: 500 })
  }
}

// POST /api/playbook — create a user template.
export async function POST(req: Request) {
  try {
    const body = (await req.json()) as {
      title?: string
      titleAr?: string
      description?: string
      descriptionAr?: string
      category?: string
      body?: string
      tags?: string[]
    }
    const title = (body.title ?? '').trim()
    const templateBody = (body.body ?? '').trim()
    const category = ['new_feature', 'bug_fix', 'refactor', 'tests', 'review', 'planning', 'general'].includes(
      String(body.category)
    )
      ? String(body.category)
      : 'general'

    if (title.length < 3) {
      return NextResponse.json({ error: 'Title is too short.' }, { status: 400 })
    }
    if (templateBody.length < 20) {
      return NextResponse.json({ error: 'Template body is too short.' }, { status: 400 })
    }

    const created = await db.promptTemplate.create({
      data: {
        title: title.slice(0, 120),
        titleAr: body.titleAr?.trim() || null,
        description: (body.description ?? '').trim().slice(0, 300) || 'User template',
        descriptionAr: body.descriptionAr?.trim() || null,
        category,
        body: templateBody,
        tags: JSON.stringify(Array.isArray(body.tags) ? body.tags.filter((t) => typeof t === 'string').slice(0, 4) : []),
        isBuiltin: false,
      },
    })
    return NextResponse.json({ template: serializeTemplate(created) }, { status: 201 })
  } catch (error) {
    console.error('[api/playbook POST]', error)
    return NextResponse.json({ error: 'Failed to save the template.' }, { status: 500 })
  }
}
