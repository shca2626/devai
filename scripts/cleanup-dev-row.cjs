// One-off: dedupe evidence + drop stale claims on the dev-test analysis row.
const { PrismaClient } = require('@prisma/client')
const db = new PrismaClient()

const STALE = [
  '0 Android permissions requested',
  'VirusTotal: n/a',
  'Tech stack: Native Android (Java/Kotlin) + Kotlin stdlib',
  'No curated Dart packages matched (native or non-Flutter app)',
  '0 non-SDK URL endpoints surfaced in code',
]

async function main() {
  const row = await db.appAnalysis.findUnique({ where: { id: 'cmw8g1ev20003pmi0ookg606f' } })
  if (!row) throw new Error('not found')
  const data = JSON.parse(row.data)
  const seen = new Set()
  const before = data.evidence.length
  data.evidence = data.evidence.filter((e) => {
    if (STALE.includes(e.claim) || seen.has(e.claim)) return false
    seen.add(e.claim)
    return true
  })
  data.unknowns = Array.from(new Set(data.unknowns)).filter((u) => !u.includes('Permission list not exposed'))
  console.log('evidence:', before, '->', data.evidence.length)
  await db.appAnalysis.update({
    where: { id: row.id },
    data: { data: JSON.stringify(data) },
  })
  console.log('cleaned')
}

main().then(() => db.$disconnect())
