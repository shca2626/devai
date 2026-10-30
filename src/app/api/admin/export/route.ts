import { db } from '@/lib/db'
import { listAdminTables, serializeRow } from '@/lib/admin/registry'

// ============================================================
// GET /api/admin/export — full database dump as a downloadable
// JSON file (every model, every row, serialized ISO dates).
// ============================================================

export async function GET() {
  try {
    const tables = listAdminTables()
    const dump: Record<string, unknown[]> = {}
    for (const t of tables) {
      const rows = await t.delegate.findMany({ orderBy: [{ id: 'asc' }] })
      dump[t.name] = rows.map(serializeRow)
    }

    const summary = Object.fromEntries(
      Object.entries(dump).map(([k, v]) => [k, v.length])
    )

    const payload = {
      exportedAt: new Date().toISOString(),
      database: 'sqlite',
      summary,
      data: dump,
    }

    return new Response(JSON.stringify(payload, null, 2), {
      headers: {
        'Content-Type': 'application/json',
        'Content-Disposition': `attachment; filename="ai-engineer-db-export-${Date.now()}.json"`,
      },
    })
  } catch (error) {
    console.error('[api/admin/export GET]', error)
    return Response.json({ error: 'Failed to export the database.' }, { status: 500 })
  }
}
