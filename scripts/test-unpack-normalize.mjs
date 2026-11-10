// Integration test — the FluffyChat bug class: providers sometimes ship a
// single-file bundle (one apk named after the app, NO base.apk entry) or a
// raw apk. The unpack stage must normalize both to base.apk.
// Creates a synthetic bundle + a stage-3 DB row, then advances via the REAL
// API route and checks the engine's unpack result.
import { PrismaClient } from '@prisma/client'
import { execSync } from 'node:child_process'
import fs from 'node:fs'
import path from 'node:path'

const db = new PrismaClient()
const PKG = 'com.test.singleapk'
const cases = [
  { name: 'solo-apk', entries: { 'singleapk.apk': 'PK-fake-apk-content', 'toc.pb': 'x' } },
  { name: 'raw-apk', entries: { 'AndroidManifest.xml': '<manifest/>', 'classes.dex': 'dex' } },
]

for (const c of cases) {
  // 1. workdir with the synthetic bundle
  const row = await db.appAnalysis.create({
    data: {
      ideaId: null,
      inputUrl: `https://play.google.com/store/apps/details?id=${PKG}`,
      pkg: PKG,
      appName: `Test ${c.name}`,
      status: 'running',
      stageDone: 3, // next stage = unpack
      score: 20,
      data: JSON.stringify({
        evidence: [], unknowns: [], pack: [],
        acquire: {
          file: `/tmp/${c.name}.apks`,
          sha256: 'a'.repeat(64),
          sizeBytes: 1024,
          bundle: Object.keys(c.entries),
          versionName: '1.0',
          versionCode: 1,
          apiSha256: 'a'.repeat(64),
          originality: 'match',
        },
      }),
    },
  })
  const dir = path.join(process.cwd(), '.app-intel', row.id)
  fs.mkdirSync(path.join(dir, 'unpacked'), { recursive: true })
  // build the zip via python (zipfile) — pass entries via temp file, no quoting hell
  const tmpJson = `/tmp/entries-${c.name}.json`
  fs.writeFileSync(tmpJson, JSON.stringify(c.entries))
  execSync(
    `/home/z/.venv/bin/python3 -c "import zipfile, json; entries = json.load(open('${tmpJson}')); z = zipfile.ZipFile('${dir}/${PKG}.apks', 'w'); [z.writestr(n, c) for n, c in entries.items()]; z.close()"`
  )

  // 2. advance one stage via the real API (unpack)
  const res = await fetch('http://localhost:3000/api/app-intel', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ analysisId: row.id, lang: 'ar' }),
  })
  const out = await res.json()
  const unpack = out.analysis?.data?.unpack
  const baseOnDisk = fs.existsSync(path.join(dir, 'unpacked', 'base.apk'))
  console.log(`[${c.name}] http=${res.status} baseApkPresent=${unpack?.baseApkPresent} baseOnDisk=${baseOnDisk} splits=${unpack?.splits}`)

  // cleanup row + workdir (keep the DB clean)
  await db.appAnalysis.delete({ where: { id: row.id } })
  fs.rmSync(dir, { recursive: true, force: true })
}
await db.$disconnect()
