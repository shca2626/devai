import { spawn } from 'node:child_process'
import { execFile } from 'node:child_process'
import { promises as fs } from 'node:fs'
import path from 'node:path'
import { chatJson } from '@/lib/ai'
import { db } from '@/lib/db'
import { logDecision } from '@/lib/payload'
import type { AppAnalysisItem, AppIntelData, AppPackFile } from '@/lib/types'

// ============================================================
// App Intelligence — study any Android app from a Play Store
// URL (or package name), fully automatically:
//
//   store     Play Store metadata (google-play-scraper)
//   acquire   ORIGINAL APK bundle via the reverse-engineered
//             Evozi/apkcube chain (camoufox: hold-to-verify +
//             turnstile + PoW -> R2 signed URL) — verified
//             bit-identical to the Play-sourced file (sha256)
//   deep      deep listing intel: permissions, manifest,
//             signature, VirusTotal, native ABIs, protectors
//   unpack    .apks bundle -> base.apk + splits inventory
//   decompile jadx source pass: package map, endpoints, keys
//   fingerprint  tech stack (Flutter/RN/Kotlin/Cordova),
//             Dart AOT package fingerprint, feature map
//   synthesis AI-written clone pack from collected evidence
//
// Static analysis only; nothing is ever executed on an emulator.
// ============================================================

const STAGES = ['store', 'acquire', 'deep', 'unpack', 'decompile', 'fingerprint', 'synthesis'] as const

export class AppIntelError extends Error {
  code: 'INVALID_INPUT' | 'NOT_FOUND' | 'APP_NOT_FOUND' | 'ACQUISITION_FAILED' | 'STAGE_FAILED' | 'TOOLING_MISSING'
  constructor(code: AppIntelError['code'], message: string) {
    super(message)
    this.code = code
  }
}

const PYTHON = '/home/z/.venv/bin/python3'
const ACQUIRE_SCRIPT = path.join(process.cwd(), 'scripts', 'acquire-final.py')
const JADX = path.join(process.env.HOME ?? '/home/z', 'tools', 'jadx', 'bin', 'jadx')
const WORK_ROOT = path.join(process.cwd(), '.app-intel')

const ACQUIRE_TIMEOUT_MS = 420_000
const JADX_TIMEOUT_MS = 300_000

// ------------------------------------------------------------
// input normalization — accept Play URLs, market:// links, bare ids
// ------------------------------------------------------------

const PLAY_URL_RE = /play\.google\.com\/store\/apps\/details\?id=([a-zA-Z0-9._]+)/
const MARKET_RE = /market:\/\/details\?id=([a-zA-Z0-9._]+)/
const PKG_RE = /^[a-zA-Z][a-zA-Z0-9_]*(\.[a-zA-Z0-9_]+){1,6}$/

export function normalizeInputApp(raw: string): { pkg: string; inputUrl: string } {
  const value = (raw ?? '').trim()
  if (!value) throw new AppIntelError('INVALID_INPUT', 'A Play Store URL or package name is required.')

  const play = value.match(PLAY_URL_RE)
  if (play) return { pkg: play[1], inputUrl: `https://play.google.com/store/apps/details?id=${play[1]}` }
  const market = value.match(MARKET_RE)
  if (market) return { pkg: market[1], inputUrl: `https://play.google.com/store/apps/details?id=${market[1]}` }
  if (PKG_RE.test(value)) return { pkg: value, inputUrl: `https://play.google.com/store/apps/details?id=${value}` }

  throw new AppIntelError(
    'INVALID_INPUT',
    'That does not look like a Play Store URL or an Android package name (e.g. com.example.app).'
  )
}

// ------------------------------------------------------------
// helpers
// ------------------------------------------------------------

function ev(claim: string, source: string, method: string, confidence: 'high' | 'medium' | 'low' = 'high') {
  return { claim, source, method, confidence }
}

async function run(cmd: string, args: string[], timeoutMs: number, cwd?: string): Promise<{ code: number; stdout: string; stderr: string }> {
  return new Promise((resolve) => {
    const child = spawn(cmd, args, { cwd, env: { ...process.env, HOME: process.env.HOME ?? '/home/z' } })
    let stdout = ''
    let stderr = ''
    const timer = setTimeout(() => child.kill('SIGKILL'), timeoutMs)
    child.stdout.on('data', (d) => (stdout += d.toString()))
    child.stderr.on('data', (d) => (stderr += d.toString()))
    child.on('close', (code) => {
      clearTimeout(timer)
      resolve({ code: code ?? -1, stdout, stderr })
    })
    child.on('error', () => {
      clearTimeout(timer)
      resolve({ code: -1, stdout, stderr: stderr + 'spawn failed' })
    })
  })
}

function workDir(analysisId: string) {
  return path.join(WORK_ROOT, analysisId)
}

// ------------------------------------------------------------
// stage 1 — store
// ------------------------------------------------------------

async function collectStore(pkg: string, data: AppIntelData) {
  const gplay = (await import('google-play-scraper')).default
  let app: Record<string, unknown>
  try {
    app = (await gplay.app({ appId: pkg })) as Record<string, unknown>
  } catch {
    throw new AppIntelError('APP_NOT_FOUND', `That app could not be found on Google Play (${pkg}).`)
  }

  const num = (v: unknown) => (typeof v === 'number' ? v : undefined)
  const str = (v: unknown) => (typeof v === 'string' ? v : undefined)
  const arr = (v: unknown) => (Array.isArray(v) ? (v as unknown[]) : [])

  data.store = {
    appId: pkg,
    title: str(app['title']) ?? pkg,
    developer: str(app['developer']) ?? undefined,
    genre: str(app['genre']) ?? undefined,
    contentRating: str(app['contentRating']) ?? undefined,
    version: str(app['version']) ?? undefined,
    androidVersion: str(app['androidVersionText']) ?? undefined,
    installs: str(app['installs']) ?? undefined,
    score: num(app['score']) ?? undefined,
    ratings: num(app['ratings']) ?? undefined,
    reviews: num(app['reviews']) ?? undefined,
    price: str(app['price']) ?? undefined,
    released: str(app['released']) ?? undefined,
    updated: num(app['updated']) ?? undefined,
    description: (str(app['description']) ?? '').slice(0, 4000),
    screenshots: arr(app['screenshots']).slice(0, 12).map(String),
    video: str(app['video']) ?? undefined,
  }

  data.evidence.push(
    ev(`Play Store listing: ${data.store.title}${data.store.installs ? ` — ${data.store.installs} installs` : ''}${data.store.score ? `, rating ${data.store.score.toFixed(1)}` : ''}`, 'Google Play public listing', 'google-play-scraper metadata fetch'),
    ev(`Store version: ${data.store.version ?? 'unknown'} (requires Android ${data.store.androidVersion ?? 'any'})`, 'Google Play public listing', 'google-play-scraper metadata fetch')
  )
  if (!data.store.version) data.unknowns.push('Current Play Store version not exposed in the listing.')
}

// ------------------------------------------------------------
// stage 2 — acquire (the reverse-engineered original-APK chain)
// ------------------------------------------------------------

async function collectAcquire(analysisId: string, pkg: string, data: AppIntelData) {
  let ok = false
  try {
    await fs.access(PYTHON)
    await fs.access(ACQUIRE_SCRIPT)
  } catch {
    data.unknowns.push('Acquisition tooling unavailable in this environment — analysis continues from public metadata only.')
    return
  }

  const dir = workDir(analysisId)
  await fs.mkdir(dir, { recursive: true })
  const res = await run(
    PYTHON,
    [ACQUIRE_SCRIPT, '--pkg', pkg, '--out', dir, '--timeout', '360', '--attempts', '2'],
    ACQUIRE_TIMEOUT_MS
  )

  const line = res.stdout.split('\n').map((l) => l.trim()).filter((l) => l.startsWith('ACQUIRE_RESULT ')).pop()
  if (!line) {
    data.unknowns.push('Binary acquisition did not complete (provider busy or verification unsolved) — continuing with metadata-only analysis.')
    data.evidence.push(ev('APK bundle not acquired this run', 'acquire-final.py', 'camoufox acquisition attempt (see server log)', 'low'))
    return
  }

  let payload: Record<string, unknown>
  try {
    payload = JSON.parse(line.slice('ACQUIRE_RESULT '.length))
  } catch {
    data.unknowns.push('Acquisition result could not be parsed.')
    return
  }
  if (payload['ok'] !== true) {
    data.unknowns.push('APK acquisition failed — continuing with metadata-only analysis.')
    return
  }

  ok = true
  const str = (k: string) => (typeof payload[k] === 'string' ? (payload[k] as string) : undefined)
  const numv = (k: string) => (typeof payload[k] === 'number' ? (payload[k] as number) : undefined)

  data.acquire = {
    file: str('file')!,
    sha256: str('sha256')!,
    sizeBytes: numv('sizeBytes') ?? 0,
    bundle: Array.isArray(payload['bundle']) ? (payload['bundle'] as string[]) : [],
    versionName: str('versionName'),
    versionCode: numv('versionCode'),
    apiSha256: str('apiSha256'),
    originality: (str('originality') as 'match' | 'mismatch' | 'unknown') ?? 'unknown',
  }

  const sameVersion = data.store?.version && data.acquire.versionName && data.store.version === data.acquire.versionName
  data.evidence.push(
    ev(`Original APK bundle acquired: ${data.acquire.sizeBytes} bytes, ${data.acquire.bundle.length} split files`, 'acquired .apks (sha256 ' + data.acquire.sha256.slice(0, 12) + '…)', 'reverse-engineered apkcube/Evozi chain — hold-to-verify, turnstile, proof-of-work, signed URL'),
    ev(
      `Originality: sha256 ${data.acquire.originality === 'match' ? 'matches' : data.acquire.originality === 'mismatch' ? 'DIFFERS from' : 'unverifiable against'} the provider listing for v${data.acquire.versionName ?? '?'} (${data.acquire.originality === 'match' ? 'bit-identical to the Play-sourced file' : 'check advised'})` + (sameVersion ? ' — matches current Play Store version' : ''),
      'provider listing API vs downloaded bytes',
      'sha256 comparison',
      data.acquire.originality === 'match' ? 'high' : 'medium'
    )
  )
  if (data.acquire.originality !== 'match') data.unknowns.push('Downloaded bundle could not be confirmed bit-identical to the provider listing.')
  void ok
}

// ------------------------------------------------------------
// stage 3 — deep listing intel (permissions/signature/VT/natives)
// ------------------------------------------------------------

interface ApksListingApk {
  apkId?: string
  versionName?: string
  versionCode?: number
  sha256?: string
  isLatest?: boolean
  fileSize?: number
}
interface ApksListingSecurityEntry {
  fromGooglePlay?: boolean
  versionName?: string
  verdict?: string
  scannedByVirusTotal?: boolean
  flagged?: number
  vendors?: number
  permissions?: string[]
  signature?: { scheme?: string; status?: string; certSha256?: string; certSubject?: string; match?: boolean }
  manifest?: { targetSdk?: number; compileSdk?: number; allowBackup?: boolean; packageName?: string; usesFeatures?: string[]; usesLibraries?: string[]; exportedUnguarded?: string[] }
  natives?: { abis?: string[]; libs?: string[]; protectors?: string[] }
  pairip?: boolean
}
interface ApksListing {
  apks?: ApksListingApk[]
  security?: Record<string, unknown>
  securityByApkId?: Record<string, ApksListingSecurityEntry>
  signers?: { sha256?: string; subject?: string; trusted?: boolean }[]
}

async function readListingFromAcquire(dir: string): Promise<ApksListing | null> {
  // acquire-final.py leaves listing.json (browser-captured) in the work dir
  try {
    return JSON.parse(await fs.readFile(path.join(dir, 'listing.json'), 'utf8')) as ApksListing
  } catch {
    return null
  }
}

async function collectDeep(analysisId: string, pkg: string, data: AppIntelData) {
  let listing: ApksListing | null = null
  let method = ''

  // direct API attempt (works when the provider's origin gate is open)
  try {
    const r = await fetch(`https://apkcube.com/api/apps/${encodeURIComponent(pkg)}/apks`, {
      headers: { 'Sec-Fetch-Site': 'same-origin', Referer: 'https://apkcube.com/', Accept: 'application/json' },
      signal: AbortSignal.timeout(20_000),
    })
    if (r.ok) {
      listing = (await r.json()) as ApksListing
      method = 'direct provider API'
    }
  } catch {
    /* fall through to browser-captured listing */
  }
  if (!listing) {
    listing = await readListingFromAcquire(workDir(analysisId))
    method = 'browser-captured provider API (from acquisition run)'
  }
  if (!listing) {
    data.unknowns.push('Deep listing intel (permissions, signature, VirusTotal) unavailable — provider API gated this run.')
    return
  }

  const apks = (listing.apks ?? []).slice(0, 40)
  const latest = apks.find((a) => a.isLatest) ?? apks[0]

  // per-apk security detail lives in securityByApkId[apkId]
  const byId = listing.securityByApkId ?? {}
  const sec: ApksListingSecurityEntry | undefined = latest?.apkId ? byId[String(latest.apkId)] : Object.values(byId)[0]

  const permissions = (sec?.permissions ?? []).slice(0, 200)
  const signature = sec?.signature ?? {}
  const manifest = sec?.manifest ?? {}
  const natives = sec?.natives ?? {}
  const signers = (listing.signers ?? []).slice(0, 4)

  data.deep = {
    versions: apks.map((a) => ({
      versionName: a.versionName,
      versionCode: a.versionCode,
      sha256: a.sha256,
      isLatest: a.isLatest ?? false,
      sizeBytes: a.fileSize,
    })),
    permissions,
    signature: {
      present: Boolean(signature.certSha256 || signers.length),
      scheme: signature.scheme,
      status: signature.status,
      certSha256: signature.certSha256,
      certSubject: signature.certSubject,
      signerSubjects: signers.map((s) => s.subject).filter(Boolean) as string[],
      trusted: signers.length ? signers.some((s) => s.trusted) : undefined,
    },
    virusTotal: {
      verdict: sec?.verdict,
      scannedByVirusTotal: sec?.scannedByVirusTotal,
      flagged: sec?.flagged,
      vendors: sec?.vendors,
    },
    fromGooglePlay: sec?.fromGooglePlay,
    manifest: {
      targetSdk: manifest.targetSdk,
      compileSdk: manifest.compileSdk,
      allowBackup: manifest.allowBackup,
      usesFeatures: (manifest.usesFeatures ?? []).slice(0, 40),
      exportedUnguarded: (manifest.exportedUnguarded ?? []).slice(0, 60),
    },
    natives: {
      abis: natives.abis ?? [],
      nativeLibs: natives.libs ?? [],
      protectors: natives.protectors ?? [],
    },
    pairipProtected: sec?.pairip === true,
  }

  data.evidence.push(
    ev(`${permissions.length} Android permissions requested`, method, 'provider per-apk security record'),
    ev(
      `VirusTotal: ${data.deep.virusTotal.verdict ?? 'n/a'}${data.deep.virusTotal.flagged !== undefined ? ` — ${data.deep.virusTotal.flagged}/${data.deep.virusTotal.vendors ?? '?'} engines flag` : ''}`,
      method,
      'provider VirusTotal scan record',
      'medium'
    ),
    ev(
      `Signature: ${data.deep.signature.status ?? 'present'}${data.deep.signature.certSubject ? ` (${data.deep.signature.certSubject})` : ''}${data.deep.signature.scheme ? ` via ${data.deep.signature.scheme}` : ''}`,
      method,
      'provider signature record'
    )
  )
  if (data.deep.fromGooglePlay === true) {
    data.evidence.push(ev('The provider record marks this exact file as sourced from Google Play (fromGooglePlay: true)', method, 'provider per-apk security record'))
  }
  if (data.deep.manifest.exportedUnguarded?.length) {
    data.evidence.push(ev(`${data.deep.manifest.exportedUnguarded.length} exported, unguarded manifest components (attack surface)`, method, 'provider manifest record', 'medium'))
  }
  if (!permissions.length) data.unknowns.push('Permission list not exposed by the provider this run.')
}

// ------------------------------------------------------------
// stage 4 — unpack
// ------------------------------------------------------------

async function collectUnpack(analysisId: string, pkg: string, data: AppIntelData) {
  if (!data.acquire) {
    data.unknowns.push('No acquired bundle to unpack.')
    return
  }
  const dir = workDir(analysisId)
  const apksPath = path.join(dir, `${pkg}.apks`)
  try {
    await fs.access(apksPath)
  } catch {
    data.unknowns.push('Acquired bundle file missing on disk.')
    return
  }

  // .apks is a zip; list + extract base.apk + all splits
  const res = await run('python3', ['-c', `
import json, zipfile, os, sys
src = ${JSON.stringify(apksPath)}
out = ${JSON.stringify(path.join(dir, 'unpacked'))}
os.makedirs(out, exist_ok=True)
with zipfile.ZipFile(src) as z:
    names = z.namelist()
    for n in names:
        if n.endswith('.apk') or n.endswith('.txt'):
            z.extract(n, out)
print(json.dumps({'names': names}))
`], 60_000)
  let names: string[] = data.acquire.bundle
  try {
    const parsed = JSON.parse(res.stdout.trim().split('\n').pop() ?? '{}') as { names?: string[] }
    if (parsed.names) names = parsed.names
  } catch {
    /* keep listing from acquire stage */
  }

  const baseApk = names.find((n) => n === 'base.apk')
  const splits = names.filter((n) => n.startsWith('split_'))
  const abis = Array.from(new Set(splits.map((s) => (s.match(/split_config\.([a-z0-9_]+)\.apk/)?.[1] ?? '')).filter(Boolean)))
  const langs = Array.from(new Set(splits.map((s) => (s.match(/split_config\.([a-z]{2,3})\.apk/)?.[1] ?? '')).filter((l) => l.length <= 3)))

  data.unpack = {
    baseApkPresent: Boolean(baseApk),
    splits: splits.length,
    abis: abis.filter((a) => a.includes('64') || a.includes('x86') || a === 'armeabi-v7a'),
    languages: langs,
    totalFiles: names.length,
  }

  data.evidence.push(
    ev(`Bundle unpacked: ${data.unpack.baseApkPresent ? 'base.apk present' : 'no base.apk'}, ${splits.length} config splits (ABIs: ${data.unpack.abis.join(', ') || 'n/a'}; ${langs.length} languages)`, 'acquired .apks archive', 'zip listing + extraction')
  )
  if (!data.unpack.baseApkPresent) data.unknowns.push('base.apk missing from the bundle — decompile stage will be skipped.')
}

// ------------------------------------------------------------
// stage 5 — decompile (jadx)
// ------------------------------------------------------------

async function collectDecompile(analysisId: string, data: AppIntelData) {
  const dir = workDir(analysisId)
  const baseApk = path.join(dir, 'unpacked', 'base.apk')
  try {
    await fs.access(baseApk)
    await fs.access(JADX)
  } catch {
    data.unknowns.push('jadx pass skipped (base.apk or tooling unavailable).')
    return
  }

  const outDir = path.join(dir, 'jadx')
  await fs.mkdir(outDir, { recursive: true })
  const res = await run(JADX, ['-d', outDir, '--no-res', '-j', '4', baseApk], JADX_TIMEOUT_MS, dir)
  if (res.code !== 0 && !res.stdout.includes('finished')) {
    data.unknowns.push('jadx pass did not complete cleanly — partial results only.')
  }

  // inventory of sources
  const list = await run('python3', ['-c', `
import json, os
root = ${JSON.stringify(path.join(outDir, 'sources'))}
files = []
for dirpath, _, filenames in os.walk(root):
    for f in filenames:
        if f.endswith(('.java', '.kt')):
            files.append(os.path.relpath(os.path.join(dirpath, f), root))
print(json.dumps({'count': len(files), 'files': files[:4000]}))
`], 120_000)
  let count = 0
  let files: string[] = []
  try {
    const parsed = JSON.parse(list.stdout.trim().split('\n').pop() ?? '{}') as { count?: number; files?: string[] }
    count = parsed.count ?? 0
    files = parsed.files ?? []
  } catch {
    /* empty */
  }

  // package top-levels + endpoint/secret scan over the file list + a grep pass
  const topPkgs = new Map<string, number>()
  for (const f of files) {
    const top = f.split('/')[0]
    topPkgs.set(top, (topPkgs.get(top) ?? 0) + 1)
  }

  const grep = await run('python3', ['-c', `
import json, os, re
root = ${JSON.stringify(path.join(outDir, 'sources'))}
urls, keys, interesting = set(), set(), set()
url_re = re.compile(r'https?://[A-Za-z0-9._~:/?#@!$&*+,;=%-]{6,90}')
key_re = re.compile(r'(?i)(api[_-]?key|secret|token|password)\s*=\s*["'\\''"][A-Za-z0-9_\-]{12,}')
budget = 900000
seen = 0
for dirpath, _, filenames in os.walk(root):
    for f in filenames:
        if not f.endswith(('.java', '.kt')):
            continue
        p = os.path.join(dirpath, f)
        try:
            if seen > budget:
                break
            text = open(p, encoding='utf-8', errors='ignore').read()
            seen += len(text)
            for m in url_re.findall(text):
                u = m.rstrip('.,;)')
                host = u.split('//', 1)[1].split('/', 1)[0]
                if not host.endswith(('.google.com', '.gstatic.com', '.android.com', '.github.com', '.apache.org', '.w3.org', '.example.com', '.firebaseio.com', '.crashlytics.com', '.googleapis.com')):
                    urls.add(u)
            for m in key_re.findall(text):
                keys.add(m[:60])
        except OSError:
            pass
print(json.dumps({'urls': sorted(urls)[:160], 'keys': sorted(keys)[:40]}))
`], 120_000)
  let urls: string[] = []
  let keyPatterns: string[] = []
  try {
    const parsed = JSON.parse(grep.stdout.trim().split('\n').pop() ?? '{}') as { urls?: string[]; keys?: string[] }
    urls = parsed.urls ?? []
    keyPatterns = parsed.keys ?? []
  } catch {
    /* empty */
  }

  data.decompile = {
    javaFiles: count,
    topPackages: Array.from(topPkgs.entries()).sort((a, b) => b[1] - a[1]).slice(0, 12).map(([name, n]) => ({ name, files: n })),
    endpoints: urls.slice(0, 120),
    keyPatterns: keyPatterns.slice(0, 20),
  }

  data.evidence.push(
    ev(`jadx source pass: ${count} Java/Kotlin files across ${data.decompile.topPackages.length}+ top-level packages`, 'decompiled base.apk sources', 'jadx 1.5.2 (--no-res, 4 threads)'),
    ev(`${urls.length} non-SDK URL endpoints surfaced in code${keyPatterns.length ? `, ${keyPatterns.length} credential-like patterns` : ''}`, 'decompiled base.apk sources', 'regex scan over decompiled sources')
  )
  if (!count) data.unknowns.push('No decompilable sources — the app may be fully native/protected.')
}

// ------------------------------------------------------------
// stage 6 — fingerprint (tech stack + Dart AOT features)
// ------------------------------------------------------------

const KNOWN_DART_PACKAGES: Record<string, string> = {
  dio: 'HTTP client',
  http: 'HTTP client',
  sqflite: 'local SQLite database',
  path_provider: 'file storage',
  shared_preferences: 'key-value storage',
  firebase_messaging: 'push notifications',
  flutter_local_notifications: 'local notifications',
  url_launcher: 'external links',
  image_picker: 'photo/gallery picking',
  file_picker: 'document picking',
  camera: 'camera',
  geolocator: 'GPS location',
  google_maps_flutter: 'Google Maps',
  pdf: 'PDF generation',
  printing: 'printing / PDF',
  flutter_pdfview: 'PDF viewing',
  pretty_qr_code: 'QR codes',
  qr_flutter: 'QR codes',
  barcode_scan: 'barcode scanning',
  intl: 'localization/dates',
  flutter_secure_storage: 'encrypted storage',
  local_auth: 'biometric auth',
  google_sign_in: 'Google sign-in',
  sign_in_with_apple: 'Apple sign-in',
  flutter_svg: 'SVG rendering',
  cached_network_image: 'cached images',
  video_player: 'video playback',
  just_audio: 'audio playback',
  record: 'audio recording',
  audioplayers: 'audio playback',
  socket_io_client: 'websocket/realtime',
  web_socket_channel: 'websocket/realtime',
  provider: 'state management',
  riverpod: 'state management',
  bloc: 'state management',
  get: 'state/navigation',
  cloud_firestore: 'Cloud Firestore',
  firebase_auth: 'Firebase auth',
  firebase_storage: 'Firebase storage',
  flutter_stripe: 'Stripe payments',
  in_app_purchase: 'in-app purchases',
  google_mobile_ads: 'AdMob ads',
  facebook_audience_network: 'Facebook ads',
  flutter_tts: 'text-to-speech',
  speech_to_text: 'speech recognition',
  google_mlkit_text_recognition: 'ML Kit OCR',
  tflite_flutter: 'TensorFlow Lite ML',
  fl_chart: 'charts',
  syncfusion_flutter_charts: 'charts',
  table_calendar: 'calendar',
  flutter_ble_lib: 'Bluetooth LE',
  flutter_blue: 'Bluetooth',
  nfc_manager: 'NFC',
  whatsapp: 'WhatsApp integration',
  telephony: 'SMS/telephony',
  contacts_service: 'contacts',
  flutter_timezone: 'timezones',
  workmanager: 'background jobs',
}

async function collectFingerprint(analysisId: string, data: AppIntelData) {
  const dir = workDir(analysisId)
  const baseApk = path.join(dir, 'unpacked', 'base.apk')
  try {
    await fs.access(baseApk)
  } catch {
    data.unknowns.push('Fingerprint skipped — no base.apk.')
    return
  }

  const res = await run('python3', ['-c', `
import json, zipfile, re, glob, os, collections
outdir = ${JSON.stringify(path.join(dir, 'unpacked'))}
out = {'nativeLibs': [], 'assets': [], 'dartPackages': {}, 'dartUrls': [], 'stringsHints': []}
# native libs live in the ABI split (split_config.arm64_v8a.apk), not base.apk
apk_files = sorted(glob.glob(os.path.join(outdir, '*.apk')))
for apk in apk_files:
    with zipfile.ZipFile(apk) as z:
        names = z.namelist()
        out['nativeLibs'] += [n for n in names if n.startswith('lib/') and n.endswith('.so')]
        if apk.endswith('base.apk'):
            out['assets'] = [n for n in names if n.startswith('assets/')][:400]
libnames = {n.rsplit('/', 1)[1] for n in out['nativeLibs']}
# Flutter Dart AOT: package fingerprints + backend URLs live in libapp.so strings
for lib in out['nativeLibs']:
    if not lib.endswith('libapp.so'):
        continue
    holder = [a for a in apk_files if lib.split('/')[1] in a or a.endswith('base.apk')]
    try:
        for apk in apk_files:
            with zipfile.ZipFile(apk) as z:
                if lib in z.namelist():
                    blob = z.read(lib)
                    txt = blob.decode('utf-8', 'ignore')
                    pkgs = collections.Counter(re.findall(r'package:([a-z0-9_]+)/', txt))
                    out['dartPackages'] = dict(pkgs.most_common(80))
                    urls = re.findall(r'https?://[A-Za-z0-9._~:/?#@!$&*+,;=%-]{6,90}', txt)
                    seen, keep = set(), []
                    for u in urls:
                        u = u.rstrip('.,;)')
                        # Dart AOT strings have no terminators: symbols bleed into
                        # URLs. Cut at obvious symbol boundaries.
                        u = re.split(r'[@]|init:|StackOverflow|GrowableList|_literal|_Scroll', u)[0]
                        host = u.split('//',1)[1].split('/',1)[0]
                        if host.endswith(('.google.com','.gstatic.com','.android.com','.github.com','.apache.org','.w3.org','.example.com','.flutter.dev','.dart.dev','.googleapis.com','.crashlytics.com','.firebaseio.com','.pub.dev','.chromium.org','.mozilla.org','.unicode.org','.openssl.org','.sqlite.org')):
                            continue
                        if u not in seen:
                            seen.add(u); keep.append(u)
                    out['dartUrls'] = keep[:120]
                    break
    except Exception as e:
        out['stringsHints'].append(f'libapp.so read failed: {e}')
    break
if 'libreactnativejni.so' in libnames or 'index.android.bundle' in {n.rsplit('/',1)[-1] for n in out['assets']}:
    out['stringsHints'].append('react-native markers present')
if any(n.startswith('assets/www/') for n in out['assets']):
    out['stringsHints'].append('cordova assets/www present')
print(json.dumps(out))
`], 90_000)

  let nativeLibs: string[] = []
  let assets: string[] = []
  let dartPackages: Record<string, number> = {}
  let dartUrls: string[] = []
  try {
    const parsed = JSON.parse(res.stdout.trim().split('\n').pop() ?? '{}') as {
      nativeLibs?: string[]; assets?: string[]; dartPackages?: Record<string, number>; dartUrls?: string[]
    }
    nativeLibs = parsed.nativeLibs ?? []
    assets = parsed.assets ?? []
    dartPackages = parsed.dartPackages ?? {}
    dartUrls = parsed.dartUrls ?? []
  } catch {
    data.unknowns.push('Fingerprint pass failed to parse.')
    return
  }

  const libnames = Array.from(new Set(nativeLibs.map((n) => n.rsplit ? n.rsplit('/', 1)[1] : n.split('/').pop()!)))
  const isFlutter = libnames.includes('libflutter.so') || Object.keys(dartPackages).length > 0
  const isReactNative = libnames.includes('libreactnativejni.so') || assets.includes('assets/index.android.bundle')
  const isCordova = assets.some((a) => a.startsWith('assets/www/'))
  const isKotlin = (data.decompile?.javaFiles ?? 0) > 0 // jadx handles both; kotlin shows as .kt or kotlin/ imports
  const protectors = data.deep?.natives.protectors ?? []

  const stack: { name: string; confidence: 'high' | 'medium'; because: string }[] = []
  if (isFlutter) stack.push({ name: 'Flutter (Dart AOT)', confidence: 'high', because: 'libflutter.so + libapp.so with Dart package strings' })
  if (isReactNative) stack.push({ name: 'React Native', confidence: 'high', because: 'libreactnativejni.so / index.android.bundle' })
  if (isCordova) stack.push({ name: 'Cordova/WebView hybrid', confidence: 'high', because: 'assets/www/ present' })
  if (!isFlutter && !isReactNative && !isCordova && (data.decompile?.javaFiles ?? 0) > 50) {
    stack.push({ name: 'Native Android (Java/Kotlin)', confidence: 'medium', because: `${data.decompile?.javaFiles} decompiled JVM sources, no cross-platform markers` })
  }
  if (isKotlin && stack.length && !isFlutter && !isReactNative) stack.push({ name: 'Kotlin stdlib', confidence: 'medium', because: 'kotlin.* packages in decompiled sources' })
  for (const p of protectors) stack.push({ name: `Protector: ${p}`, confidence: 'medium', because: 'provider listing flags' })

  const featureMap: { feature: string; package: string; refs: number }[] = []
  for (const [pkgName, refs] of Object.entries(dartPackages)) {
    const feature = KNOWN_DART_PACKAGES[pkgName]
    if (feature) featureMap.push({ feature, package: pkgName, refs })
  }
  featureMap.sort((a, b) => b.refs - a.refs)

  data.fingerprint = {
    stack,
    nativeLibs: libnames.slice(0, 40),
    dartPackages: Object.entries(dartPackages).slice(0, 60).map(([name, refs]) => ({ name, refs })),
    featureMap: featureMap.slice(0, 40),
    assetsSample: assets.slice(0, 40),
  }

  // Flutter: real backend endpoints live in the Dart AOT strings — merge them
  // into the endpoint list so the clone pack has them even when Java is bare.
  if (dartUrls.length) {
    if (!data.decompile) data.decompile = { javaFiles: 0, topPackages: [], endpoints: [], keyPatterns: [] }
    const clean = (u: string): string => {
      let s = u.split(/[@]|init:|StackOverflow|GrowableList|_literal|_Scroll/)[0].replace(/[.,;)]+$/, '')
      // Dart symbol residue: drop any path segment containing an uppercase
      // letter, and any camelCase glued onto the host
      try {
        const url = new URL(s)
        const host = url.host.replace(/([a-z])[A-Z][a-z]+.*/, '$1')
        const segs = url.pathname.split('/').filter((p) => p && !/[A-Z]/.test(p))
        return `${url.protocol}//${host}${segs.length ? '/' + segs.join('/') : ''}`
      } catch {
        return ''
      }
    }
    const merged = [...data.decompile.endpoints, ...dartUrls].map(clean).filter((u) => /^https?:\/\/[a-z0-9.-]{4,}/i.test(u))
    // keep the SHORTEST url per host+first path segment
    const byKey = new Map<string, string>()
    for (const u of merged) {
      try {
        const url = new URL(u)
        const first = url.pathname.split('/').filter(Boolean)[0]
        const key = url.host + (first ? '/' + first : '')
        const prev = byKey.get(key)
        if (!prev || u.length < prev.length) byKey.set(key, u)
      } catch {
        /* skip malformed */
      }
    }
    data.decompile.endpoints = Array.from(byKey.values()).slice(0, 160)
    data.evidence.push(ev(`${dartUrls.length} backend URLs surfaced from Dart AOT strings (Flutter logic layer)`, 'acquired bundle (libapp.so)', 'URL regex over Dart AOT string table'))
  }

  data.evidence.push(
    ev(`Tech stack: ${stack.map((s) => s.name).join(' + ') || 'undetermined'}`, 'acquired bundle (lib/, assets/) + decompiled sources', 'native library + asset markers, Dart AOT string fingerprint'),
    featureMap.length
      ? ev(`${featureMap.length} mapped features from package fingerprint (top: ${featureMap.slice(0, 5).map((f) => f.feature).join(', ')})`, 'libapp.so Dart AOT strings', 'package:* name extraction + curated feature dictionary')
      : ev('No curated Dart packages matched (native or non-Flutter app)', 'libapp.so scan', 'package:* extraction')
  )
}

// ------------------------------------------------------------
// stage 7 — synthesis (AI clone pack)
// ------------------------------------------------------------

async function runSynthesis(pkg: string, data: AppIntelData, lang: 'ar' | 'en'): Promise<void> {
  const digest = [
    `APP: ${data.store?.title ?? pkg} (${pkg}) by ${data.store?.developer ?? '?'} — ${data.store?.installs ?? '?'} installs, rating ${data.store?.score ?? '?'}`,
    `GENRE: ${data.store?.genre ?? '?'} | CONTENT: ${data.store?.contentRating ?? '?'}`,
    `DESCRIPTION (truncated): ${(data.store?.description ?? '').slice(0, 1200)}`,
    `VERSIONS: ${(data.deep?.versions ?? []).slice(0, 6).map((v) => `${v.versionName}(${v.versionCode})${v.isLatest ? '*' : ''}`).join(', ')} | acquired: ${data.acquire?.versionName ?? 'none'} (sha256 ${data.acquire?.originality ?? 'n/a'})`,
    `PERMISSIONS (${data.deep?.permissions.length ?? 0}): ${(data.deep?.permissions ?? []).slice(0, 60).join(', ')}`,
    `FROM_GOOGLE_PLAY: ${data.deep?.fromGooglePlay ?? 'unknown'} | SIGNATURE: ${data.deep?.signature.status ?? '?'} ${data.deep?.signature.certSubject ?? ''} | VT: ${data.deep?.virusTotal.verdict ?? '?'} ${data.deep?.virusTotal.flagged ?? '?'}/${data.deep?.virusTotal.vendors ?? '?'} | targetSdk: ${data.deep?.manifest?.targetSdk ?? '?'}`,
    `STACK: ${(data.fingerprint?.stack ?? []).map((s) => `${s.name} (${s.because})`).join(' | ')}`,
    `FEATURE MAP: ${(data.fingerprint?.featureMap ?? []).slice(0, 30).map((f) => `${f.feature} [${f.package} x${f.refs}]`).join(' | ')}`,
    `ENDPOINTS (${data.decompile?.endpoints.length ?? 0}): ${(data.decompile?.endpoints ?? []).slice(0, 40).join(' | ')}`,
    `KEY PATTERNS: ${(data.decompile?.keyPatterns ?? []).slice(0, 10).join(' | ')}`,
    `CODE MAP: ${(data.decompile?.topPackages ?? []).map((p) => `${p.name}:${p.files}`).join(', ')} (total ${data.decompile?.javaFiles ?? 0} files)`,
    `NATIVE LIBS: ${(data.fingerprint?.nativeLibs ?? []).join(', ')}`,
    `SPLITS: ${data.unpack?.splits ?? 0} | ABIs: ${(data.unpack?.abis ?? []).join(',')} | langs: ${(data.unpack?.languages ?? []).join(',')}`,
    `VT: ${JSON.stringify(data.deep?.virusTotal ?? {})}`,
    `UNKNOWNNS: ${data.unknowns.slice(0, 10).join(' | ')}`,
  ].join('\n')

  const langLine = lang === 'ar' ? 'Arabic' : 'English'
  const result = await chatJson<Record<string, unknown>>(
    [
      'You are a senior mobile architect writing a CLONE PACK for a development team that will rebuild this app from scratch.',
      'Base every statement strictly on the collected evidence digest — no invented features, no invented numbers.',
      'Answer with STRICT JSON: {"overview": markdown, "features": markdown, "architecture": markdown, "clonePlan": markdown}.',
      'Each markdown document: concise, heading + bullets, max ~35 lines. The overview must end with one sentence in the UI language the user asked for.',
      `UI language for that final sentence: ${langLine}. All documents otherwise in English.`,
    ].join('\n'),
    digest,
    2
  )

  const str = (k: string, fb: string) => (typeof result[k] === 'string' && (result[k] as string).trim() ? (result[k] as string) : fb)
  data.synthesis = {
    overview: str('overview', '# Overview\n(synthesis unavailable)'),
    features: str('features', '# Features\n(synthesis unavailable)'),
    architecture: str('architecture', '# Architecture\n(synthesis unavailable)'),
    clonePlan: str('clonePlan', '# Clone plan\n(synthesis unavailable)'),
  }
  data.evidence.push(ev('AI clone pack written (overview, features, architecture, clone plan)', 'all collected stage data', 'one structured AI call restricted to the evidence digest', 'medium'))
}

// ------------------------------------------------------------
// pack + score (deterministic)
// ------------------------------------------------------------

export function buildPack(item: { pkg: string; appName?: string | null; stageDone: number }, data: AppIntelData): { pack: AppPackFile[]; score: number } {
  const pkg = item.pkg
  const files: AppPackFile[] = []
  const push = (name: string, content: string) => files.push({ name, content: content.trim() })

  if (data.store) {
    const s = data.store
    push(
      'store-listing.md',
      [
        `# Store listing — ${s.title} (${pkg})`,
        '',
        `- Developer: ${s.developer ?? '—'}`,
        `- Genre: ${s.genre ?? '—'} | Content rating: ${s.contentRating ?? '—'}`,
        `- Installs: ${s.installs ?? '—'} | Rating: ${s.score ?? '—'} (${s.ratings ?? '—'} ratings)`,
        `- Current version: ${s.version ?? '—'} (Android ${s.androidVersion ?? 'any'})`,
        `- Released: ${s.released ?? '—'}${s.updated ? ` | Updated: ${new Date(s.updated * 1000).toISOString().slice(0, 10)}` : ''}`,
        `- Screenshots: ${s.screenshots.length}`,
        '',
        '## Description',
        '',
        s.description || '(empty)',
      ].join('\n')
    )
  }
  if (data.deep) {
    push(
      'permissions-and-security.md',
      [
        `# Permissions & security — ${pkg}`,
        '',
        `## Permissions (${data.deep.permissions.length})`,
        '',
        ...(data.deep.permissions.length ? data.deep.permissions.map((p) => `- \`${p}\``) : ['- (not exposed)']),
        '',
        `## Signature`,
        `- Present: ${data.deep.signature.present ? 'yes' : 'unknown'}` +
          (data.deep.signature.status ? ` | status: ${data.deep.signature.status}` : '') +
          (data.deep.signature.scheme ? ` | scheme: ${data.deep.signature.scheme}` : ''),
        ...(data.deep.signature.certSubject ? [`- Certificate: ${data.deep.signature.certSubject}`] : []),
        ...(data.deep.signature.certSha256 ? [`- Cert sha256: \`${data.deep.signature.certSha256}\``] : []),
        ...(data.deep.signature.signerSubjects?.length ? [`- Known signers: ${data.deep.signature.signerSubjects.join(' | ')}`] : []),
        ...(data.deep.fromGooglePlay !== undefined ? [`- Provider marks this file as **sourced from Google Play**: ${data.deep.fromGooglePlay ? 'yes' : 'no'}`] : []),
        '',
        `## VirusTotal`,
        `- Verdict: ${data.deep.virusTotal.verdict ?? 'n/a'}${data.deep.virusTotal.flagged !== undefined ? ` (${data.deep.virusTotal.flagged}/${data.deep.virusTotal.vendors ?? '?'} engines)` : ''}`,
        ...(data.deep.manifest?.targetSdk ? ['', `## Manifest`, `- targetSdk ${data.deep.manifest.targetSdk}${data.deep.manifest.compileSdk ? ` | compileSdk ${data.deep.manifest.compileSdk}` : ''}`] : []),
        ...(data.deep.manifest?.exportedUnguarded?.length ? [`- Exported unguarded components (${data.deep.manifest.exportedUnguarded.length}): ${data.deep.manifest.exportedUnguarded.slice(0, 20).join(', ')}`] : []),
        '',
        `## Versions tracked by the provider (${data.deep.versions.length})`,
        ...(data.deep.versions.slice(0, 15).map((v) => `- ${v.versionName} (${v.versionCode})${v.isLatest ? ' — latest' : ''}${v.sha256 ? ` — sha256 ${v.sha256.slice(0, 16)}…` : ''}`)),
        '',
        `## Native / protectors`,
        `- ABIs: ${data.deep.natives.abis.join(', ') || 'n/a'}`,
        `- Native libs: ${data.deep.natives.nativeLibs.join(', ') || 'n/a'}`,
        `- Protectors: ${data.deep.natives.protectors.join(', ') || 'none detected'}`,
      ].join('\n')
    )
  }
  if (data.acquire) {
    push(
      'original-apk.md',
      [
        `# Original APK acquisition — ${pkg}`,
        '',
        `- Acquired: ${data.acquire.sizeBytes} bytes (${(data.acquire.sizeBytes / 1e6).toFixed(2)} MB), ${data.acquire.bundle.length} bundle entries`,
        `- Version: ${data.acquire.versionName ?? '?'} (${data.acquire.versionCode ?? '?'})`,
        `- sha256: \`${data.acquire.sha256}\``,
        `- Originality vs provider listing: **${data.acquire.originality}**`,
        '',
        'Acquired through the reverse-engineered provider chain (hold-to-verify + turnstile + proof-of-work),',
        'the same pipeline the public APK-downloader services use to fetch originals from Google Play.',
      ].join('\n')
    )
  }
  if (data.fingerprint) {
    push(
      'tech-stack.md',
      [
        `# Tech stack — ${pkg}`,
        '',
        ...(data.fingerprint.stack.map((s) => `- **${s.name}** — ${s.because} (${s.confidence})`) || ['- undetermined']),
        '',
        `## Native libraries`,
        ...(data.fingerprint.nativeLibs.length ? data.fingerprint.nativeLibs.map((l) => `- \`${l}\``) : ['- (none)']),
        '',
        `## Dart packages (top 30 of ${data.fingerprint.dartPackages.length})`,
        ...(data.fingerprint.dartPackages.slice(0, 30).map((p) => `- ${p.name} ×${p.refs}`) || ['- (not Flutter)']),
      ].join('\n')
    )
    if (data.fingerprint.featureMap.length) {
      push(
        'feature-map.md',
        [
          `# Feature map — ${pkg}`,
          '',
          'Mapped from package fingerprints in the compiled app (ref count = string occurrences):',
          '',
          ...data.fingerprint.featureMap.map((f) => `- ${f.feature} — \`${f.package}\` ×${f.refs}`),
        ].join('\n')
      )
    }
  }
  if (data.decompile) {
    push(
      'code-map.md',
      [
        `# Code map — ${pkg}`,
        '',
        `- Decompiled Java/Kotlin files: ${data.decompile.javaFiles}`,
        '',
        '## Top-level packages',
        ...(data.decompile.topPackages.map((p) => `- \`${p.name}\` — ${p.files} files`) || ['- (none)']),
        '',
        `## Non-SDK endpoints (${data.decompile.endpoints.length})`,
        ...(data.decompile.endpoints.slice(0, 80).map((u) => `- ${u}`) || ['- (none found)']),
        ...(data.decompile.keyPatterns.length ? ['', '## Credential-like patterns (audit carefully)', ...data.decompile.keyPatterns.map((k) => `- ${k}`)] : []),
      ].join('\n')
    )
  }
  if (data.synthesis) {
    push('clone-pack/overview.md', data.synthesis.overview)
    push('clone-pack/features.md', data.synthesis.features)
    push('clone-pack/architecture.md', data.synthesis.architecture)
    push('clone-pack/clone-plan.md', data.synthesis.clonePlan)
  }

  // deterministic score: stage coverage + richness
  let score = Math.round((item.stageDone / STAGES.length) * 55)
  if (data.store?.description) score += 5
  if (data.acquire?.originality === 'match') score += 10
  if ((data.deep?.permissions.length ?? 0) > 5) score += 5
  if ((data.fingerprint?.featureMap.length ?? 0) > 5) score += 10
  if ((data.decompile?.endpoints.length ?? 0) > 3) score += 5
  if (data.decompile?.javaFiles) score += 5
  if (data.synthesis?.overview.includes('#')) score += 5
  return { pack: files, score: Math.min(100, score) }
}

// ------------------------------------------------------------
// persistence (same pattern as site-intel)
// ------------------------------------------------------------

function parseData(raw: string): AppIntelData {
  try {
    const parsed = JSON.parse(raw) as Partial<AppIntelData>
    return {
      store: parsed.store,
      acquire: parsed.acquire,
      deep: parsed.deep,
      unpack: parsed.unpack,
      decompile: parsed.decompile,
      fingerprint: parsed.fingerprint,
      synthesis: parsed.synthesis,
      evidence: parsed.evidence ?? [],
      unknowns: parsed.unknowns ?? [],
      pack: parsed.pack ?? [],
    }
  } catch {
    return { evidence: [], unknowns: [], pack: [] }
  }
}

function serialize(row: {
  id: string; inputUrl: string; pkg: string; appName: string | null; status: string
  stageDone: number; score: number; error: string | null; data: string
  createdAt: Date
}): AppAnalysisItem {
  return {
    id: row.id,
    inputUrl: row.inputUrl,
    pkg: row.pkg,
    appName: row.appName ?? undefined,
    status: row.status as AppAnalysisItem['status'],
    stageDone: row.stageDone,
    score: row.score,
    error: row.error,
    data: parseData(row.data),
    createdAt: row.createdAt.toISOString(),
  }
}

async function persist(rowId: string, data: AppIntelData, stageDone: number, status?: 'running' | 'complete' | 'failed', error?: string | null) {
  const pkgRow = await db.appAnalysis.findUnique({ where: { id: rowId }, select: { pkg: true, appName: true } })
  // stages are idempotent on retry: collapse duplicate evidence claims
  const seen = new Set<string>()
  data.evidence = data.evidence.filter((e) => {
    if (seen.has(e.claim)) return false
    seen.add(e.claim)
    return true
  })
  const built = buildPack({ pkg: pkgRow?.pkg ?? '', appName: pkgRow?.appName, stageDone }, data)
  const dataWithPack: AppIntelData = { ...data, pack: built.pack }
  const patch: Record<string, unknown> = {
    data: JSON.stringify(dataWithPack),
    stageDone,
    score: built.score,
  }
  if (status) patch['status'] = status
  if (error !== undefined) patch['error'] = error
  await db.appAnalysis.update({ where: { id: rowId }, data: patch })
}

// ------------------------------------------------------------
// public API (mirrors site-intel)
// ------------------------------------------------------------

export async function startAppAnalysis(ideaId: string | null, rawInput: string): Promise<AppAnalysisItem> {
  if (ideaId) {
    const idea = await db.idea.findUnique({ where: { id: ideaId }, select: { id: true } })
    if (!idea) throw new AppIntelError('NOT_FOUND', 'Idea not found')
  }

  const seed = normalizeInputApp(rawInput)
  const data: AppIntelData = { evidence: [], unknowns: [], pack: [] }
  await collectStore(seed.pkg, data)
  const built = buildPack({ pkg: seed.pkg, stageDone: 1 }, data)
  data.pack = built.pack

  const row = await db.appAnalysis.create({
    data: {
      ideaId,
      inputUrl: seed.inputUrl,
      pkg: seed.pkg,
      appName: data.store?.title ?? null,
      status: 'running',
      stageDone: 1,
      score: built.score,
      data: JSON.stringify(data),
    },
  })

  if (ideaId) {
    await logDecision(ideaId, 'App study started', `${seed.pkg} — store recon complete (${data.store?.version ?? 'version unknown'})`)
  }
  return serialize(row)
}

export async function advanceAppAnalysis(ideaId: string | null, analysisId: string, lang: 'ar' | 'en'): Promise<AppAnalysisItem> {
  const row = await db.appAnalysis.findFirst({ where: { id: analysisId, ideaId: ideaId ?? null } })
  if (!row) throw new AppIntelError('NOT_FOUND', 'Analysis not found')
  if (row.status !== 'running') return serialize(row)
  if (row.stageDone >= STAGES.length) return serialize(row)

  const data = parseData(row.data)
  const stage = STAGES[row.stageDone]

  try {
    if (stage === 'acquire') {
      await collectAcquire(row.id, row.pkg, data)
      await persist(row.id, data, 2)
    } else if (stage === 'deep') {
      await collectDeep(row.id, row.pkg, data)
      await persist(row.id, data, 3)
    } else if (stage === 'unpack') {
      await collectUnpack(row.id, row.pkg, data)
      await persist(row.id, data, 4)
    } else if (stage === 'decompile') {
      await collectDecompile(row.id, data)
      await persist(row.id, data, 5)
    } else if (stage === 'fingerprint') {
      await collectFingerprint(row.id, data)
      await persist(row.id, data, 6)
    } else if (stage === 'synthesis') {
      await runSynthesis(row.pkg, data, lang)
      await persist(row.id, data, 7, 'complete')
      if (ideaId) {
        await logDecision(ideaId, 'App study complete', `${row.pkg} — clone pack ready (score ${row.score})`)
      }
    }
  } catch (error) {
    const message = error instanceof Error ? error.message : 'unknown error'
    await persist(row.id, data, row.stageDone, 'failed', message)
    if (error instanceof AppIntelError) throw error
    throw new AppIntelError('STAGE_FAILED', `Stage "${stage}" failed: ${message}`)
  }

  const fresh = await db.appAnalysis.findUnique({ where: { id: row.id } })
  return serialize(fresh!)
}

export async function getAppAnalysis(ideaId: string | null, analysisId: string): Promise<AppAnalysisItem | null> {
  const row = await db.appAnalysis.findFirst({ where: { id: analysisId, ideaId: ideaId ?? null } })
  return row ? serialize(row) : null
}

export async function listAppAnalyses(ideaId: string | null): Promise<AppAnalysisSummary[]> {
  const rows = await db.appAnalysis.findMany({
    where: { ideaId: ideaId ?? null },
    orderBy: { createdAt: 'desc' },
    take: 30,
    select: { id: true, pkg: true, appName: true, status: true, stageDone: true, score: true, createdAt: true },
  })
  return rows.map((r) => ({
    id: r.id,
    pkg: r.pkg,
    appName: r.appName ?? undefined,
    status: r.status as AppAnalysisSummary['status'],
    stageDone: r.stageDone,
    score: r.score,
    createdAt: r.createdAt.toISOString(),
  }))
}

export async function deleteAppAnalysis(ideaId: string | null, analysisId: string): Promise<boolean> {
  const row = await db.appAnalysis.findFirst({ where: { id: analysisId, ideaId: ideaId ?? null }, select: { id: true } })
  if (!row) return false
  await db.appAnalysis.delete({ where: { id: analysisId } })
  await fs.rm(workDir(analysisId), { recursive: true, force: true }).catch(() => undefined)
  return true
}

export const APP_INTEL_STAGES = STAGES
export { execFile }
