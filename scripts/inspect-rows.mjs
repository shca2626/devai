import { PrismaClient } from '@prisma/client'
const db = new PrismaClient()
const rows = await db.appAnalysis.findMany({ select: { id: true, pkg: true, appName: true, status: true, stageDone: true, score: true, error: true, createdAt: true } })
for (const r of rows) console.log(r.createdAt.toISOString().slice(0,10), r.status.padEnd(8), String(r.score).padStart(3), `s${r.stageDone}/7`, r.pkg, '|', (r.error||'').slice(0,60))
await db.$disconnect()
