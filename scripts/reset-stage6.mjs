import { PrismaClient } from '@prisma/client'
const db = new PrismaClient()
const id = process.argv[2]
const row = await db.appAnalysis.findUnique({ where: { id } })
const data = JSON.parse(row.data)
delete data.codebase
// also drop the codebase-failure unknown if present
data.unknowns = (data.unknowns || []).filter((u) => !u.includes('codebase'))
await db.appAnalysis.update({ where: { id }, data: { data: JSON.stringify(data), stageDone: 5, status: 'running' } })
console.log('reset to stage 5')
await db.$disconnect()
