import { PrismaClient } from '@prisma/client'
const db = new PrismaClient()
const row = await db.appAnalysis.findUnique({ where: { id: 'cmw9st6ut0005ksvlzovvp0a1' } })
const d = JSON.parse(row.data)
console.log('unknowns:', JSON.stringify(d.unknowns, null, 1))
await db.$disconnect()
