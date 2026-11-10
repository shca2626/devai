import { PrismaClient } from '@prisma/client'
const db = new PrismaClient()
const r = await db.appAnalysis.deleteMany({ where: { pkg: 'com.test.singleapk' } })
console.log('deleted test rows:', r.count)
console.log('remaining:', await db.appAnalysis.count())
await db.$disconnect()
