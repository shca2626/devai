import { PrismaClient } from '@prisma/client'
const db = new PrismaClient()
const rows = await db.appAnalysis.findMany({ orderBy: { createdAt: 'desc' }, take: 3 })
for (const r of rows) {
  const d = JSON.parse(r.data)
  console.log('=== ', r.pkg, r.status, 'stage', r.stageDone, 'score', r.score)
  console.log('unknowns:', JSON.stringify(d.unknowns || [], null, 1))
  console.log('errors:', JSON.stringify((d.stages || []).filter(s => s.status === 'failed' || s.error), null, 1))
  console.log('stageLog:', JSON.stringify((d.stages || []).map(s => ({ n: s.stage ?? s.name, st: s.status })), null, 1))
}
await db.$disconnect()
