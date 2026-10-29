import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { listRules } from '@/lib/engines/context-pack'

// GET /api/constitution?ideaId=xxx — list constitution rules.
// Without ideaId: global rules only. With ideaId: global + project rules.
export async function GET(req: Request) {
  try {
    const url = new URL(req.url)
    const ideaId = url.searchParams.get('ideaId')
    const rules = await listRules(ideaId)
    return NextResponse.json({ rules })
  } catch (error) {
    console.error('[api/constitution GET]', error)
    return NextResponse.json({ error: 'Failed to load constitution rules.' }, { status: 500 })
  }
}

// POST /api/constitution — add a rule (global or project-scoped).
export async function POST(req: Request) {
  try {
    const body = (await req.json()) as {
      scope?: 'global' | 'project'
      ideaId?: string
      category?: string
      text?: string
    }
    const text = (body.text ?? '').trim()
    const category = ['stack', 'coding', 'security', 'design', 'quality', 'workflow'].includes(
      String(body.category)
    )
      ? String(body.category)
      : null
    const scope = body.scope === 'project' ? 'project' : 'global'

    if (text.length < 5) {
      return NextResponse.json({ error: 'Rule text is too short.' }, { status: 400 })
    }
    if (!category) {
      return NextResponse.json(
        { error: 'Category must be stack | coding | security | design | quality | workflow.' },
        { status: 400 }
      )
    }
    if (scope === 'project' && !body.ideaId) {
      return NextResponse.json({ error: 'Project rules require an ideaId.' }, { status: 400 })
    }
    if (scope === 'project') {
      const idea = await db.idea.findUnique({ where: { id: body.ideaId! } })
      if (!idea) return NextResponse.json({ error: 'Idea not found.' }, { status: 404 })
    }

    const where = scope === 'project' ? { ideaId: body.ideaId! } : { ideaId: null }
    const order = await db.constitutionRule.count({ where })

    await db.constitutionRule.create({
      data: {
        ideaId: scope === 'project' ? body.ideaId! : null,
        category,
        text,
        origin: 'user',
        enabled: true,
        order,
      },
    })

    const rules = await listRules(scope === 'project' ? body.ideaId! : null)
    return NextResponse.json({ rules }, { status: 201 })
  } catch (error) {
    console.error('[api/constitution POST]', error)
    return NextResponse.json({ error: 'Failed to add the rule.' }, { status: 500 })
  }
}
