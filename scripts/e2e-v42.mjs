#!/usr/bin/env node
// E2E: full first-party chain — acquire → deep(manifest/signature) → unpack →
// jadx → fingerprint → deep intel → synthesis → pack → GitHub.
// Runs two studies: FluffyChat (expect complete, fdroid-open) and
// arkan_tailor (expect LOUD ACQUISITION_FAILED — no hollow reports).
const BASE = 'http://127.0.0.1:3000'

const sleep = (ms) => new Promise((r) => setTimeout(r, ms))

async function runStudy(input, maxMs) {
  const t0 = Date.now()
  let res = await fetch(`${BASE}/api/app-intel`, {
    method: 'POST',
    headers: { 'content-type': 'application/json' },
    body: JSON.stringify({ input, lang: 'ar' }),
  })
  let body = await res.json()
  if (!body.analysis) {
    console.log(`[${input}] START FAILED http=${res.status}`, JSON.stringify(body).slice(0, 300))
    return null
  }
  const id = body.analysis.id
  console.log(`[${input}] started id=${id} (http ${res.status})`)
  let last = -1
  for (;;) {
    if (Date.now() - t0 > maxMs) {
      console.log(`[${input}] TIMEOUT after ${maxMs / 1000}s`)
      return null
    }
    await sleep(5000)
    const r = await fetch(`${BASE}/api/app-intel?analysisId=${id}`)
    const j = await r.json()
    const a = j.analysis
    if (!a) { console.log(`[${input}] poll error`, JSON.stringify(j).slice(0, 200)); continue }
    if (a.stageDone !== last) {
      last = a.stageDone
      console.log(`[${input}] stage=${a.stageDone}/7 status=${a.status} score=${a.score} (${((Date.now() - t0) / 1000).toFixed(0)}s)`)
    }
    if (a.status === 'complete' || a.status === 'failed') {
      console.log(`\n===== ${input} FINAL: ${a.status} (score ${a.score}, ${((Date.now() - t0) / 1000).toFixed(0)}s) =====`)
      if (a.status === 'failed') {
        console.log('ERROR:', a.error)
      }
      const d = a.data || {}
      console.log('acquire.source:', d.acquire?.source, '| originality:', d.acquire?.originality, '| bytes:', d.acquire?.sizeBytes)
      console.log('unpack:', JSON.stringify(d.unpack))
      console.log('signature:', d.deep?.signature?.scheme, d.deep?.signature?.certSha256?.slice(0, 20), '|', d.deep?.signature?.certSubject?.slice(0, 60))
      console.log('permissions:', d.deep?.permissions?.length, '| targetSdk:', d.deep?.manifest?.targetSdk)
      console.log('decompile: javaFiles=', d.decompile?.javaFiles, 'endpoints=', d.decompile?.endpoints?.length)
      console.log('stack:', (d.fingerprint?.stack || []).map((s) => s.name).join(' + '))
      console.log('codebase: endpoints=', d.codebase?.endpoints?.length, 'tables=', d.codebase?.database?.tables?.length, 'apiPaths=', d.codebase?.api?.paths?.length)
      console.log('artifacts:', JSON.stringify(d.artifacts))
      console.log('unknowns:', (d.unknowns || []).slice(0, 6))
      return a
    }
  }
}

const which = process.argv[2] ?? 'all'
if (which === 'all' || which === 'fluffy') await runStudy('chat.fluffy.fluffychat', 25 * 60 * 1000)
if (which === 'all' || which === 'arkan') await runStudy('com.arkanprotailor.arkan_tailor', 8 * 60 * 1000)
