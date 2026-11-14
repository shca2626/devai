// remove hollow arkan_tailor analyses (scored 100/55 with no bundle ever acquired)
import { PrismaClient } from '@prisma/client'
import { rmSync } from 'node:fs'
const db = new PrismaClient()
const rows = await db.appAnalysis.findMany({ where: { pkg: 'com.arkanprotailor.arkan_tailor' }, select: { id: true, score: true } })
console.log('deleting', rows.length, 'arkan_tailor rows:', rows.map((r) => `${r.score}`).join(','))
await db.appAnalysis.deleteMany({ where: { pkg: 'com.arkanprotailor.arkan_tailor' } })
try { rmSync('app-intel/com.arkanprotailor.arkan_tailor', { recursive: true, force: true }); console.log('repo dir removed') } catch (e) { console.log(e.message) }
await db.$disconnect()
