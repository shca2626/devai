import { PrismaClient } from '@prisma/client'
const db = new PrismaClient()
// remove the stuck test rows (status=running, stale) — keep complete ones
const stale = await db.appAnalysis.findMany({ where: { status: 'running' }, select: { id: true, pkg: true, stageDone: true, createdAt: true } })
for (const s of stale) console.log('deleting', s.pkg, 'stage', s.stageDone, s.id)
await db.appAnalysis.deleteMany({ where: { status: 'running' } })
console.log('remaining:', await db.appAnalysis.count())
await db.$disconnect()
