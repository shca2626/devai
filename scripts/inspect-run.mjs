import { PrismaClient } from '@prisma/client'
const db = new PrismaClient()
const id = process.argv[2]
const row = await db.appAnalysis.findUnique({ where: { id } })
if (!row) { console.log('not found'); process.exit(1) }
const d = JSON.parse(row.data)
console.log('===', row.pkg, row.status, 'stage', row.stageDone, 'score', row.score)
console.log('acquire:', d.acquire ? `${(d.acquire.sizeBytes/1e6).toFixed(1)}MB v${d.acquire.versionName} originality=${d.acquire.originality}` : 'MISSING')
console.log('decompile:', JSON.stringify(d.decompile ? { javaFiles: d.decompile.javaFiles, endpoints: d.decompile.endpoints.length, top: d.decompile.topPackages.slice(0,5) } : null))
console.log('fingerprint stack:', (d.fingerprint?.stack ?? []).map(s=>s.name).join(' + '))
console.log('codebase:', d.codebase ? `endpoints=${d.codebase.endpoints.length} dbEngines=${d.codebase.database.engines.map(e=>e.name)} tables=${d.codebase.database.tables.length} apiPaths=${d.codebase.api.paths.length} sync=${d.codebase.sync.signals.length}` : 'MISSING')
console.log('artifacts:', JSON.stringify(d.artifacts))
console.log('unknowns:'); (d.unknowns||[]).forEach(u => console.log('  -', u))
console.log('pack files:', d.pack.map(f=>f.name).join(', '))
await db.$disconnect()
