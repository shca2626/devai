// Verify the regenerated architecture respects the client feedback
import { PrismaClient } from '@prisma/client'

const db = new PrismaClient()
const arch = await db.architectureDoc.findUnique({
  where: { ideaId: 'cmvsk37i100bgv5rzd4x1btr4' },
})

console.log('STATUS:', arch?.status)
const stack = JSON.parse(arch?.techStack ?? '[]')
console.log('\nTECH STACK:')
for (const t of stack) {
  console.log(`  [${t.area}]`.padEnd(18), t.choice)
}
console.log('\nNOTES:', String(arch?.notes ?? '').slice(0, 300))

const dbChoice = stack.find((t) => String(t.area).toLowerCase().includes('database'))
const sqliteUsed = JSON.stringify(stack).toLowerCase().includes('sqlite')
const postgresGone = !JSON.stringify(stack).toLowerCase().includes('postgres')
console.log('\n=== VERDICT ===')
console.log('database area  :', dbChoice?.choice)
console.log('SQLite present :', sqliteUsed)
console.log('PostgreSQL gone:', postgresGone)

await db.$disconnect()
