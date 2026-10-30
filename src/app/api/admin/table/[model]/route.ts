import { NextResponse } from 'next/server'
import { getAdminTable, serializeRow } from '@/lib/admin/registry'
import { SCHEMA_MODELS } from '@/lib/admin/schema-meta'

// ============================================================
// Admin table browser.
//   GET    /api/admin/table/[model]?page=1&pageSize=20&q=...
//          -> { model, schema, total, page, pageSize, rows }
//   DELETE /api/admin/table/[model]           -> clear the table
//   GET    /api/admin/table/[model]?schema=1  -> schema only
// Any of the 20 models. q searches every scalar string column.
// ============================================================

type Params = { params: Promise<{ model: string }> }

export async function GET(req: Request, { params }: Params) {
  try {
    const { model } = await params
    const table = getAdminTable(model)
    if (!table) {
      return NextResponse.json({ error: `Unknown model "${model}".` }, { status: 404 })
    }

    const url = new URL(req.url)
    const schemaOnly = url.searchParams.get('schema') === '1'
    const meta = SCHEMA_MODELS.find((m) => m.name === model)

    if (schemaOnly) {
      return NextResponse.json({ model, schema: meta ?? null })
    }

    const page = Math.max(1, Number(url.searchParams.get('page') ?? '1') || 1)
    const pageSize = Math.min(100, Math.max(1, Number(url.searchParams.get('pageSize') ?? '20') || 20))
    const q = (url.searchParams.get('q') ?? '').trim()

    // Build a search filter across all scalar String columns
    let where: Record<string, unknown> | undefined
    if (q) {
      const stringFields = table.meta.fields.filter((f) => f.type.startsWith('String')).map((f) => f.name)
      if (stringFields.length > 0) {
        where = {
          OR: stringFields.map((f) => ({ [f]: { contains: q } })),
        }
      }
    }

    const [total, rows] = await Promise.all([
      table.delegate.count({ where }),
      table.delegate.findMany({
        where,
        orderBy: [{ id: 'desc' }],
        take: pageSize,
        skip: (page - 1) * pageSize,
      }),
    ])

    return NextResponse.json({
      model,
      schema: meta ?? null,
      labelField: table.labelField,
      total,
      page,
      pageSize,
      rows: rows.map(serializeRow),
    })
  } catch (error) {
    console.error('[api/admin/table GET]', error)
    return NextResponse.json({ error: 'Failed to read the table.' }, { status: 500 })
  }
}

// Clear every row of the table (child tables cascade via FK rules).
export async function DELETE(_req: Request, { params }: Params) {
  try {
    const { model } = await params
    const table = getAdminTable(model)
    if (!table) {
      return NextResponse.json({ error: `Unknown model "${model}".` }, { status: 404 })
    }
    const result = await table.delegate.deleteMany()
    return NextResponse.json({ ok: true, model, deleted: result.count })
  } catch (error) {
    console.error('[api/admin/table DELETE]', error)
    return NextResponse.json({ error: 'Failed to clear the table.' }, { status: 500 })
  }
}
