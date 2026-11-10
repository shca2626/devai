import { PrismaClient } from '@prisma/client'
const db = new PrismaClient()
const rows = await db.appAnalysis.findMany({ orderBy: { createdAt: 'desc' }, take: 3 })
for (const r of rows) {
  const d = JSON.parse(r.data || '{}')
  console.log(`${r.createdAt.toISOString()} ${r.id} ${r.pkg} ${r.status} ${r.stageDone}/7 score=${r.score} acquired=${!!d.acquire}`)
}
await db.$disconnect()
