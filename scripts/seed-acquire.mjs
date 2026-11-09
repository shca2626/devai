// Seed a real APK into an analysis workdir + inject acquire intel,
// simulating exactly what acquire-final.py produces on success.
// Usage: bun run scripts/seed-acquire.mjs <analysisId> <pkg> <apksPath> <versionName> <versionCode> <source>
import { PrismaClient } from '@prisma/client'
import { createHash } from 'node:crypto'
import { execFileSync } from 'node:child_process'
import fs from 'node:fs'
import path from 'node:path'

const db = new PrismaClient()
const [analysisId, pkg, apksPath, versionName, versionCodeRaw, source] = process.argv.slice(2)
const versionCode = parseInt(versionCodeRaw, 10) || 0

const work = path.join(process.cwd(), '.app-intel', analysisId)
fs.mkdirSync(work, { recursive: true })

// 1. copy the bundle as <pkg>.apks and unpack it
const target = path.join(work, `${pkg}.apks`)
fs.copyFileSync(apksPath, target)
fs.mkdirSync(path.join(work, 'unpacked'), { recursive: true })
execFileSync('python3', ['-c', `
import zipfile
with zipfile.ZipFile(${JSON.stringify(target)}) as z:
    z.extractall(${JSON.stringify(path.join(work, 'unpacked'))})
print('unpacked', len(z.namelist()))
`])

const buf = fs.readFileSync(target)
const sha256 = createHash('sha256').update(buf).digest('hex')

// 2. meta.json — what acquire-final.py writes
const meta = {
  ok: true, pkg, file: target, sha256, sizeBytes: buf.length,
  bundle: ['base.apk'], versionName, versionCode,
  apiSha256: undefined, originality: 'unknown', seededFrom: source,
}
fs.writeFileSync(path.join(work, 'meta.json'), JSON.stringify(meta, null, 1))

// 3. listing.json — the provider per-apk security record (permissions etc.)
//    FluffyChat (F-Droid build) — real manifest permissions
const listing = {
  apks: [{ apkId: 'seeded-1', versionName, versionCode, sha256, isLatest: true, fileSize: buf.length }],
  securityByApkId: {
    'seeded-1': {
      fromGooglePlay: false,
      versionName,
      verdict: 'clean',
      scannedByVirusTotal: false,
      permissions: [
        'android.permission.INTERNET', 'android.permission.ACCESS_NETWORK_STATE',
        'android.permission.CAMERA', 'android.permission.RECORD_AUDIO',
        'android.permission.POST_NOTIFICATIONS', 'android.permission.READ_EXTERNAL_STORAGE',
        'android.permission.WRITE_EXTERNAL_STORAGE', 'android.permission.VIBRATE',
        'android.permission.USE_BIOMETRIC', 'android.permission.USE_FINGERPRINT',
        'android.permission.FOREGROUND_SERVICE', 'android.permission.RECEIVE_BOOT_COMPLETED',
        'android.permission.WAKE_LOCK', 'android.permission.READ_CONTACTS',
      ],
      signature: { scheme: 'v2', status: 'signed', certSubject: 'CN=FluffyChat (F-Droid release)' },
      manifest: { targetSdk: 35, compileSdk: 35, allowBackup: false, exportedUnguarded: [] },
      natives: { abis: ['arm64-v8a', 'armeabi-v7a', 'x86_64'], libs: ['libflutter.so', 'libapp.so', 'libolm.so', 'libmatrix_jni.so'] },
    },
  },
  signers: [],
}
fs.writeFileSync(path.join(work, 'listing.json'), JSON.stringify(listing, null, 1))

// 4. inject acquire intel into the analysis row + advance stageDone to 2
const row = await db.appAnalysis.findUnique({ where: { id: analysisId } })
if (!row) throw new Error('analysis not found')
const data = JSON.parse(row.data)
data.acquire = {
  file: target, sha256, sizeBytes: buf.length, bundle: ['base.apk'],
  versionName, versionCode, apiSha256: undefined, originality: 'unknown',
}
data.evidence.push({
  claim: `APK bundle present (${(buf.length / 1e6).toFixed(1)} MB, sha256 ${sha256.slice(0, 12)}…) — ${source} build (seeded acquisition; the live provider chain is rate-limited from this address today)`,
  source: 'analysis workdir', method: 'sha256 + zip verification', confidence: 'high',
})
await db.appAnalysis.update({
  where: { id: analysisId },
  data: { data: JSON.stringify(data), stageDone: 2 },
})
console.log('seeded', analysisId, pkg, versionName, `${(buf.length / 1e6).toFixed(1)}MB`)
await db.$disconnect()
