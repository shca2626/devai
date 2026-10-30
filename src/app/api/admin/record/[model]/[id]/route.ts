import { NextResponse } from 'next/server'
import { castValue, getAdminTable, serializeRow } from '@/lib/admin/registry'

// ============================================================
// Admin single-record operations.
//   PATCH  /api/admin/record/[model]/[id]  { field: value, … }
//   DELETE /api/admin/record/[model]/[id]
// Values are cast to the column's Prisma type (DateTime / Int /
// Boolean / String) using the static schema metadata. The id and
// relation columns cannot be edited through this route.
// ============================================================

type Params = { params: Promise<{ model: string; id: string }> }

export async function PATCH(req: Request, { params }: Params) {
  try {
    const { model, id } = await params
    const table = getAdminTable(model)
    if (!table) {
      return NextResponse.json({ error: `Unknown model "${model}".` }, { status: 404 })
    }

    const body = (await req.json().catch(() => ({}))) as Record<string, unknown>
    const data: Record<string, unknown> = {}
    for (const [field, value] of Object.entries(body)) {
      if (field === 'id') continue
      const meta = table.meta.fields.find((f) => f.name === field)
      if (!meta) continue // skip relations and unknown columns
      data[field] = castValue(table, field, value)
    }
    if (Object.keys(data).length === 0) {
      return NextResponse.json({ error: 'Nothing editable to update.' }, { status: 400 })
    }

    const updated = await table.delegate.update({ where: { id }, data })
    return NextResponse.json({ ok: true, record: serializeRow(updated) })
  } catch (error) {
    console.error('[api/admin/record PATCH]', error)
    return NextResponse.json({ error: 'Failed to update the record.' }, { status: 500 })
  }
}

export async function DELETE(_req: Request, { params }: Params) {
  try {
    const { model, id } = await params
    const table = getAdminTable(model)
    if (!table) {
      return NextResponse.json({ error: `Unknown model "${model}".` }, { status: 404 })
    }
    await table.delegate.delete({ where: { id } })
    return NextResponse.json({ ok: true })
  } catch (error) {
    console.error('[api/admin/record DELETE]', error)
    return NextResponse.json({ error: 'Failed to delete the record.' }, { status: 500 })
  }
}
