// Check the real API endpoints and User entity state
import { PrismaClient } from '@prisma/client'
const db = new PrismaClient()
const IDEA = 'cmvsk37i100bgv5rzd4x1btr4'

const apis = await db.apiEndpoint.findMany({ where: { ideaId: IDEA }, orderBy: { order: 'asc' } })
console.log('=== API ENDPOINTS ===')
for (const a of apis) {
  const req = JSON.parse(a.request ?? '[]')
  console.log(`${a.code} ${a.method} ${a.path} [${a.status}] -> fields: ${req.map((r) => r.field).join(', ') || '(none)'}`)
}

const user = await db.dataEntity.findFirst({ where: { ideaId: IDEA, name: 'User' } })
if (user) {
  console.log('\n=== USER ENTITY ===')
  console.log('fields:', user.fields)
}

const decisions = await db.decision.findMany({ where: { ideaId: IDEA }, orderBy: { createdAt: 'desc' }, take: 14 })
console.log('\n=== LAST DECISIONS ===')
for (const d of decisions) console.log(`- ${d.action}${d.detail ? ' :: ' + String(d.detail).slice(0, 110) : ''}`)

await db.$disconnect()
