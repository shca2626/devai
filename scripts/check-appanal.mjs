import { PrismaClient } from '@prisma/client'
const db = new PrismaClient()
const rows = await db.appAnalysis.findMany({ orderBy: { createdAt: 'desc' }, take: 5 })
console.log('total rows fetched:', rows.length)
for (const r of rows) {
  let d = {}
  try { d = JSON.parse(r.data) } catch {}
  const ev = d.evidence || d.stages?.evidence || []
  console.log(JSON.stringify({ pkg: r.pkg, appName: r.appName, status: r.status, stageDone: r.stageDone, score: r.score, evidenceCount: Array.isArray(ev) ? ev.length : 'n/a', pack: !!d.pack, createdAt: r.createdAt }))
}
await db.$disconnect()
