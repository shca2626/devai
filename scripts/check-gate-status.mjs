// Check all design artifact statuses for the gate
import { PrismaClient } from '@prisma/client'

const db = new PrismaClient()
const id = 'cmvsk37i100bgv5rzd4x1btr4'

const [processes, entities, apis, screens, arch] = await Promise.all([
  db.processFlow.findMany({ where: { ideaId: id }, select: { status: true } }),
  db.dataEntity.findMany({ where: { ideaId: id }, select: { status: true } }),
  db.apiEndpoint.findMany({ where: { ideaId: id }, select: { status: true } }),
  db.screenSpec.findMany({ where: { ideaId: id }, select: { status: true } }),
  db.architectureDoc.findUnique({ where: { ideaId: id }, select: { status: true } }),
])

const summary = (list) => {
  const counts = {}
  for (const x of list) counts[x.status] = (counts[x.status] ?? 0) + 1
  return JSON.stringify(counts)
}

console.log('processes   :', summary(processes))
console.log('entities    :', summary(entities))
console.log('apis        :', summary(apis))
console.log('screens     :', summary(screens))
console.log('architecture:', arch?.status)

const unreviewed = (list) => list.filter((x) => x.status === 'proposed' || x.status === 'needs_revision').length
const gateBlockers = [
  unreviewed(processes) && `${unreviewed(processes)} processes unreviewed`,
  unreviewed(entities) && `${unreviewed(entities)} entities unreviewed`,
  unreviewed(apis) && `${unreviewed(apis)} apis unreviewed`,
  unreviewed(screens) && `${unreviewed(screens)} screens unreviewed`,
  arch?.status !== 'confirmed' && 'architecture not confirmed yet',
].filter(Boolean)

console.log('\nGATE BLOCKERS:', gateBlockers.length ? gateBlockers : 'NONE — gate can pass')

await db.$disconnect()
