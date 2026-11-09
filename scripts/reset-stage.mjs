import { PrismaClient } from '@prisma/client'
const db = new PrismaClient()
const [id, stage] = process.argv.slice(2)
const row = await db.appAnalysis.findUnique({ where: { id } })
const data = JSON.parse(row.data)
delete data.unpack
await db.appAnalysis.update({ where: { id }, data: { data: JSON.stringify(data), stageDone: parseInt(stage, 10), status: 'running' } })
console.log('reset to stage', stage)
await db.$disconnect()
