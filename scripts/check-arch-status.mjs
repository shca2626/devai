// Query ideas + architecture status to find the user's stuck project
import { PrismaClient } from '@prisma/client'

const db = new PrismaClient()

const ideas = await db.idea.findMany({
  orderBy: { updatedAt: 'desc' },
  take: 8,
  select: { id: true, title: true, stage: true },
})
console.log('=== IDEAS ===')
for (const i of ideas) console.log(`${i.stage.padEnd(14)} ${String(i.title).slice(0, 50).padEnd(52)} ${i.id}`)

console.log('\n=== ARCHITECTURE DOCS ===')
const archs = await db.architectureDoc.findMany({
  select: { ideaId: true, status: true, techStack: true },
})
for (const a of archs) {
  const ts = String(a.techStack ?? '').slice(0, 160)
  console.log(`${a.status.padEnd(12)} idea=${a.ideaId}\n             techStack=${ts}...`)
}

await db.$disconnect()
