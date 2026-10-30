import { db } from '@/lib/db'
import { chatJson } from '@/lib/ai'
import { logDecision } from '@/lib/payload'
import { listRules } from '@/lib/engines/context-pack'
import { SITE_INTEL_STAGES } from '@/lib/types'
import type {
  SiteAnalysisItem,
  SiteAnalysisSummary,
  SiteApiSurface,
  SiteAssetInfo,
  SiteAudit,
  SiteAuditFinding,
  SiteBundles,
  SiteEndpointFound,
  SiteEntityFound,
  SiteEvidence,
  SiteIntelData,
  SiteModels,
  SitePageForm,
  SitePageInfo,
  SiteRecon,
  SiteSurface,
  SiteSynthesis,
} from '@/lib/types'

// ============================================================
// Site Intelligence — embedded REA-style web platform study.
//
// Discipline (non-negotiable, enforced in code not prompts):
//   1. STATIC ONLY — the target's code is NEVER executed. No
//      browser, no JS evaluation. Plain fetch + regex/AST-lite
//      static analysis. Analysis, not interaction.
//   2. POLITE — declared user agent, robots.txt respected,
//      350ms delay between requests, hard caps on pages and
//      asset sizes. No anti-bot evasion: if a site blocks us,
//      the study says so honestly instead of sneaking around.
//   3. EVIDENCE — every claim carries source + method +
//      confidence. What could not be determined lands in
//      unknowns, never guessed.
//   4. APP-OWNED SCORES — the completeness score is computed
//      deterministically from what was actually collected.
//
// Seven gated stages; the model only ever STRUCTURES material
// the collector already gathered. It cannot fetch, cannot
// execute, cannot invent — the per-stage tool allowlist is the
// architecture itself.
// ============================================================

export class SiteIntelError extends Error {
  code: 'INVALID_URL' | 'UNREACHABLE' | 'NOT_FOUND' | 'BLOCKED' | 'STAGE_FAILED' | 'INVALID'
  constructor(code: SiteIntelError['code'], message: string) {
    super(message)
    this.code = code
  }
}

// ---------- Constraints (the "tool belt" settings) ----------

const USER_AGENT = 'IdeaForge-SiteIntel/1.0 (static analysis; respects robots.txt)'
const FETCH_TIMEOUT_MS = 12_000
const MAX_HTML_CHARS = 600_000 // ~600KB of HTML per page is plenty for structure
const MAX_ASSET_CHARS = 1_200_000 // ~1.2MB of JS/CSS text per asset
const MAX_PAGES = 25
const MAX_JS_ASSETS = 12
const MAX_CSS_ASSETS = 6
const CRAWL_DELAY_MS = 350
const MAX_MINED_CALLS = 80
const INLINE_SCRIPT_BUDGET = 80_000 // chars of inline script text kept for API mining

// ---------- Small helpers ----------

function sleep(ms: number): Promise<void> {
  return new Promise((r) => setTimeout(r, ms))
}

function decodeEntities(s: string): string {
  return s
    .replace(/&amp;/g, '&')
    .replace(/&lt;/g, '<')
    .replace(/&gt;/g, '>')
    .replace(/&quot;/g, '"')
    .replace(/&#0?39;/g, "'")
    .replace(/&nbsp;/g, ' ')
    .trim()
}

function stripTags(s: string): string {
  return decodeEntities(s.replace(/<[^>]*>/g, ' ').replace(/\s+/g, ' '))
}

export function normalizeInputUrl(raw: string): URL {
  let value = raw.trim()
  if (!value) throw new SiteIntelError('INVALID_URL', 'A URL is required.')
  if (!/^https?:\/\//i.test(value)) value = `https://${value}`
  let url: URL
  try {
    url = new URL(value)
  } catch {
    throw new SiteIntelError('INVALID_URL', 'That does not look like a valid URL.')
  }
  if (url.protocol !== 'http:' && url.protocol !== 'https:') {
    throw new SiteIntelError('INVALID_URL', 'Only http(s) URLs can be studied.')
  }
  if (url.username || url.password) {
    throw new SiteIntelError('INVALID_URL', 'URLs with embedded credentials are rejected.')
  }
  if (!url.hostname.includes('.') && !['localhost', '127.0.0.1', '0.0.0.0', '[::1]'].includes(url.hostname)) {
    throw new SiteIntelError('INVALID_URL', 'That hostname is not valid.')
  }
  url.hash = ''
  return url
}

// ---------- The one and only network primitive ----------

interface FetchedDoc {
  url: string
  finalUrl: string
  status: number
  contentType: string
  headers: Record<string, string>
  body: string
  ms: number
  truncated: boolean
}

async function politeFetch(url: string, accept: string): Promise<FetchedDoc> {
  const started = Date.now()
  const controller = new AbortController()
  const timer = setTimeout(() => controller.abort(), FETCH_TIMEOUT_MS)
  try {
    const res = await fetch(url, {
      method: 'GET',
      redirect: 'follow',
      signal: controller.signal,
      headers: {
        'User-Agent': USER_AGENT,
        Accept: accept,
        'Accept-Language': 'en,ar;q=0.8',
      },
    })
    const headers: Record<string, string> = {}
    res.headers.forEach((v, k) => {
      headers[k.toLowerCase()] = v
    })
    const contentType = res.headers.get('content-type') ?? ''
    let body = ''
    let truncated = false
    if (contentType.includes('text/') || contentType.includes('javascript') || contentType.includes('json') || contentType === '') {
      const raw = await res.text()
      if (raw.length > MAX_ASSET_CHARS) {
        body = raw.slice(0, MAX_ASSET_CHARS)
        truncated = true
      } else {
        body = raw
      }
    }
    return {
      url,
      finalUrl: res.url || url,
      status: res.status,
      contentType,
      headers,
      body,
      ms: Date.now() - started,
      truncated,
    }
  } finally {
    clearTimeout(timer)
  }
}

// ---------- robots.txt (parsed, obeyed) ----------

interface RobotsInfo {
  found: boolean
  sitemaps: string[]
  disallows: string[]
}

function parseRobots(body: string): RobotsInfo {
  const sitemaps: string[] = []
  const disallows: string[] = []
  let appliesToUs = false
  for (const rawLine of body.split(/\r?\n/)) {
    const line = rawLine.split('#')[0].trim()
    if (!line) continue
    const colon = line.indexOf(':')
    if (colon === -1) continue
    const field = line.slice(0, colon).trim().toLowerCase()
    const value = line.slice(colon + 1).trim()
    if (field === 'user-agent') {
      // We crawl as a generic declared UA — '*' groups apply to us
      appliesToUs = value === '*'
    } else if (field === 'sitemap' && value) {
      sitemaps.push(value)
    } else if (field === 'disallow' && appliesToUs && value && value !== '') {
      disallows.push(value)
    }
  }
  return { found: body.trim().length > 0, sitemaps, disallows }
}

function robotsAllows(url: URL, robots: RobotsInfo): boolean {
  for (const rule of robots.disallows) {
    const prefix = rule.replace(/\*.*$/, '')
    if (prefix && url.pathname.startsWith(prefix)) return false
  }
  return true
}

// ---------- URL triage ----------

const SKIP_EXT = /\.(png|jpe?g|gif|svg|webp|avif|ico|css|js|mjs|map|woff2?|ttf|otf|eot|mp4|webm|mov|mp3|wav|pdf|zip|gz|tgz|rar|7z|dmg|exe|apk|xml|rss|json|txt|csv|webmanifest|manifest)$/i

function isCrawlablePage(url: URL): boolean {
  if (url.protocol !== 'http:' && url.protocol !== 'https:') return false
  if (SKIP_EXT.test(url.pathname)) return false
  return true
}

function sameOrigin(a: URL, b: URL): boolean {
  return a.protocol === b.protocol && a.host === b.host
}

function toRoutePattern(pathname: string): string {
  const segments = pathname.split('/').map((seg) => {
    if (/^\d+$/.test(seg)) return ':id'
    if (/^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$/i.test(seg)) return ':uuid'
    if (/^[a-f0-9]{16,}$/i.test(seg)) return ':hash'
    if (/^[a-z][a-z0-9]*-\d+$/i.test(seg)) return ':slug'
    return seg
  })
  return segments.join('/') || '/'
}

// ---------- HTML extraction (regex, no DOM, no execution) ----------

function matchAttr(tag: string, name: string): string | null {
  const m = tag.match(new RegExp(`${name}\\s*=\\s*("([^"]*)"|'([^']*)'|([^\\s"'>]+))`, 'i'))
  if (!m) return null
  return decodeEntities(m[2] ?? m[3] ?? m[4] ?? '')
}

function extractTitle(html: string): string | null {
  const m = html.match(/<title[^>]*>([\s\S]*?)<\/title>/i)
  return m ? stripTags(m[1]).slice(0, 200) : null
}

function extractMeta(html: string, name: string): string | null {
  const re = /<meta\s[^>]*>/gi
  let tag: RegExpExecArray | null
  while ((tag = re.exec(html))) {
    const t = tag[0]
    const isMatch =
      (matchAttr(t, 'name')?.toLowerCase() === name || matchAttr(t, 'property')?.toLowerCase() === name)
    if (isMatch) {
      const content = matchAttr(t, 'content')
      if (content) return decodeEntities(content).slice(0, 400)
    }
  }
  return null
}

function extractLinks(html: string): string[] {
  const out: string[] = []
  const re = /<a\s[^>]*>/gi
  let tag: RegExpExecArray | null
  while ((tag = re.exec(html))) {
    const href = matchAttr(tag[0], 'href')
    if (href) out.push(href)
  }
  return out
}

function extractScriptSrcs(html: string): string[] {
  const out: string[] = []
  const re = /<script\s[^>]*>/gi
  let tag: RegExpExecArray | null
  while ((tag = re.exec(html))) {
    const src = matchAttr(tag[0], 'src')
    if (src) out.push(src)
  }
  return out
}

function extractStylesheetHrefs(html: string): string[] {
  const out: string[] = []
  const re = /<link\s[^>]*>/gi
  let tag: RegExpExecArray | null
  while ((tag = re.exec(html))) {
    const t = tag[0]
    const rel = (matchAttr(t, 'rel') ?? '').toLowerCase()
    if (rel.includes('stylesheet')) {
      const href = matchAttr(t, 'href')
      if (href) out.push(href)
    }
  }
  return out
}

function extractForms(html: string): SitePageForm[] {
  const forms: SitePageForm[] = []
  const re = /<form\s[^>]*>/gi
  let tag: RegExpExecArray | null
  while ((tag = re.exec(html)) && forms.length < 20) {
    forms.push({
      action: matchAttr(tag[0], 'action') ?? '',
      method: (matchAttr(tag[0], 'method') ?? 'GET').toUpperCase(),
    })
  }
  return forms
}

function extractHeadings(html: string, tag: string): string[] {
  const out: string[] = []
  const re = new RegExp(`<${tag}[^>]*>([\\s\\S]*?)</${tag}>`, 'gi')
  let m: RegExpExecArray | null
  while ((m = re.exec(html)) && out.length < 10) {
    const text = stripTags(m[1])
    if (text) out.push(text.slice(0, 160))
  }
  return out
}

function countImages(html: string): { count: number; noAlt: number } {
  let count = 0
  let noAlt = 0
  const re = /<img\s[^>]*>/gi
  let tag: RegExpExecArray | null
  while ((tag = re.exec(html))) {
    count++
    const alt = matchAttr(tag[0], 'alt')
    if (!alt) noAlt++
  }
  return { count, noAlt }
}

function extractJsonLdTypes(html: string): string[] {
  const types: string[] = []
  const re = /<script[^>]*type\s*=\s*["']application\/ld\+json["'][^>]*>([\s\S]*?)<\/script>/gi
  let m: RegExpExecArray | null
  while ((m = re.exec(html)) && types.length < 20) {
    try {
      const parsed = JSON.parse(m[1].trim()) as unknown
      const collect = (node: unknown, depth: number) => {
        if (depth > 4 || node == null || typeof node !== 'object') return
        if (Array.isArray(node)) {
          node.forEach((x) => collect(x, depth + 1))
          return
        }
        const obj = node as Record<string, unknown>
        const t = obj['@type']
        if (typeof t === 'string' && !types.includes(t)) types.push(t)
        if (Array.isArray(t)) t.forEach((x) => typeof x === 'string' && !types.includes(x) && types.push(x))
        Object.values(obj).forEach((v) => collect(v, depth + 1))
      }
      collect(parsed, 0)
    } catch {
      // malformed JSON-LD — skip
    }
  }
  return types
}

function extractCanonical(html: string): string | null {
  const re = /<link\s[^>]*rel\s*=\s*["']canonical["'][^>]*>/i
  const m = html.match(re)
  return m ? matchAttr(m[0], 'href') : null
}

function extractInlineScripts(html: string): string {
  const parts: string[] = []
  let budget = INLINE_SCRIPT_BUDGET
  const re = /<script(?![^>]*\bsrc\s*=)[^>]*>([\s\S]*?)<\/script>/gi
  let m: RegExpExecArray | null
  while ((m = re.exec(html)) && budget > 0) {
    const body = m[1]
    if (body.trim().length < 20) continue
    const slice = body.slice(0, budget)
    parts.push(slice)
    budget -= slice.length
  }
  return parts.join('\n;\n')
}

// ---------- Fingerprint tables (static, no execution) ----------

const HTML_FINGERPRINTS: { name: string; re: RegExp }[] = [
  { name: 'Next.js', re: /__NEXT_DATA__|\/_next\/static/ },
  { name: 'Nuxt', re: /__NUXT__|\/_nuxt\// },
  { name: 'React (hydrate)', re: /data-reactroot|react-dom|__reactContainer/ },
  { name: 'Vue', re: /data-v-app|vue-app|id="app"[^>]*data-v/ },
  { name: 'Angular', re: /ng-version|ng-app|angular/ },
  { name: 'Svelte/SvelteKit', re: /svelte-|__sveltekit/ },
  { name: 'Astro', re: /astro-island/ },
  { name: 'Gatsby', re: /___gatsby|gatsby-image/ },
  { name: 'Remix', re: /__remixContext|__remixManifest/ },
  { name: 'WordPress', re: /wp-content|wp-includes/ },
  { name: 'Shopify', re: /cdn\.shopify\.com|Shopify\.theme/ },
  { name: 'Wix', re: /static\.wixstatic\.com|wixapps/ },
  { name: 'Squarespace', re: /squarespace\.com|static1\.squarespace/ },
  { name: 'Webflow', re: /webflow\.js|data-wf-page/ },
  { name: 'Tailwind CSS', re: /tailwind|(?:class="[^"]*\b(?:flex|grid)\b[^"]*\bitems-\w+\b[^"]*")/ },
  { name: 'Bootstrap', re: /bootstrap(?:\.min)?\.(?:css|js)|class="[^"]*\bcol-md-/ },
  { name: 'jQuery', re: /jquery[.-]|jQuery/ },
  { name: 'Google Analytics', re: /gtag\/js|googletagmanager|analytics\.js/ },
  { name: 'Google Tag Manager', re: /googletagmanager\.com\/gtm\.js/ },
  { name: 'Meta Pixel', re: /connect\.facebook\.net.*fbevents/ },
  { name: 'Hotjar', re: /static\.hotjar\.com/ },
  { name: 'Intercom', re: /intercom(cdn|\.io)/ },
  { name: 'Stripe', re: /js\.stripe\.com/ },
  { name: 'Sentry', re: /sentry(?:-cdn)?\.io|@sentry\/browser/ },
  { name: 'Cloudflare', re: /cdn-cgi\/|cloudflare/ },
  { name: 'Vercel', re: /vercel(?:-insights)?\.(?:app|com)|vercel\.analytics/ },
  { name: 'Service Worker (PWA)', re: /serviceWorker\.register/ },
]

const BUNDLE_FINGERPRINTS: { name: string; re: RegExp }[] = [
  { name: 'React', re: /react\.dom|React\.createElement|useState|__SECRET_INTERNALS/ },
  { name: 'Next.js', re: /__NEXT_DATA__|next\/dist|next\/router|__next/ },
  { name: 'Vue', re: /createApp|vue-runtime|__v_isRef|vModelText/ },
  { name: 'Angular', re: /angular\/core|ɵɵdefineComponent/ },
  { name: 'Svelte', re: /svelte_internal|svelteComponent/ },
  { name: 'Redux', re: /redux|createStore|dispatch\(\{type:/ },
  { name: 'Zustand', re: /zustand/ },
  { name: 'React Query / TanStack Query', re: /useQuery|queryClient|tanstack/ },
  { name: 'Apollo Client', re: /ApolloClient|apollo-link|gql/ },
  { name: 'Axios', re: /axios/ },
  { name: 'Lodash', re: /lodash/ },
  { name: 'Day.js', re: /dayjs/ },
  { name: 'Moment.js', re: /moment(?:-locale)?\.js|moment\.duration/ },
  { name: 'i18next', re: /i18next|react-i18next/ },
  { name: 'Socket.IO', re: /socket\.io/ },
  { name: 'Framer Motion', re: /framer-motion|AnimatePresence/ },
  { name: 'Zod', re: /zod|z\.object\(/ },
  { name: 'Stripe.js', re: /js\.stripe\.com|Stripe\(/ },
  { name: 'Firebase SDK', re: /firebase|firebaseapp\.com/ },
  { name: 'Supabase', re: /supabase\.co|createClient/ },
  { name: 'Mapbox', re: /mapbox\.(?:gl|js)/ },
  { name: 'Chart.js', re: /chart\.js|Chart\.prototype/ },
  { name: 'D3', re: /d3\.select|d3\.scale/ },
  { name: 'Emotion', re: /emotion|makeStyle/ },
  { name: 'styled-components', re: /styled-components|styled\.div/ },
]

const SECRET_PATTERNS: { name: string; re: RegExp }[] = [
  { name: 'Google API key', re: /AIza[0-9A-Za-z_-]{35}/ },
  { name: 'Stripe secret key', re: /(sk|rk)_live_[0-9a-zA-Z]{20,}/ },
  { name: 'Stripe publishable key', re: /pk_live_[0-9a-zA-Z]{20,}/ },
  { name: 'GitHub token', re: /gh[pousr]_[0-9A-Za-z]{30,}/ },
  { name: 'AWS access key', re: /AKIA[0-9A-Z]{16}/ },
  { name: 'Slack token', re: /xox[baprs]-[0-9A-Za-z-]{10,}/ },
  { name: 'Private key block', re: /-----BEGIN (?:RSA |EC |OPENSSH )?PRIVATE KEY-----/ },
  { name: 'JWT hardcoded', re: /eyJ[A-Za-z0-9_-]{10,}\.eyJ[A-Za-z0-9_-]{10,}\.[A-Za-z0-9_-]{10,}/ },
]

// ---------- Bundle static mining ----------

function fingerprintBundles(texts: { file: string; text: string }[]): { name: string; evidence: string }[] {
  const found: { name: string; evidence: string }[] = []
  for (const { name, re } of HTML_FINGERPRINTS.concat(BUNDLE_FINGERPRINTS)) {
    for (const { file, text } of texts) {
      if (re.test(text)) {
        found.push({ name, evidence: `${name} fingerprint matched in ${file}` })
        break
      }
    }
  }
  return found
}

function mineRoutesFromBundles(texts: { file: string; text: string }[]): string[] {
  const routes = new Set<string>()
  const patterns = [
    /path:\s*["'`]([^"'`\s]{1,80})["'`]/g,
    /route\s*\(\s*["'`]([^"'`\s]{1,80})["'`]/g,
    /["'`](\/(?:api|v1|v2)\/[a-zA-Z0-9/_-]{1,60})["'`]/g,
  ]
  for (const { text } of texts) {
    for (const re of patterns) {
      let m: RegExpExecArray | null
      while ((m = re.exec(text)) && routes.size < 60) {
        const route = m[1]
        if (route.startsWith('/')) routes.add(route)
      }
    }
  }
  return [...routes].slice(0, 60)
}

function mineDesignTokens(cssTexts: string[], html: string): SiteBundles['designTokens'] {
  const all = cssTexts.join('\n')
  const colorCounts = new Map<string, number>()
  const hexRe = /#(?:[0-9a-fA-F]{3}|[0-9a-fA-F]{6})\b/g
  let m: RegExpExecArray | null
  while ((m = hexRe.exec(all))) {
    const hex = m[0].toLowerCase()
    colorCounts.set(hex, (colorCounts.get(hex) ?? 0) + 1)
  }
  const colors = [...colorCounts.entries()]
    .filter(([hex]) => !['#fff', '#ffffff', '#000', '#000000'].includes(hex))
    .map(([hex, count]) => ({ hex, count }))
    .sort((a, b) => b.count - a.count)
    .slice(0, 24)

  const fonts = new Set<string>()
  const fontRe = /font-family\s*:\s*([^;}{]{2,80})/gi
  while ((m = fontRe.exec(all)) && fonts.size < 12) {
    fonts.add(decodeEntities(m[1].trim().replace(/["']/g, '')))
  }

  const spacingVars = [...all.matchAll(/--(?:spacing|space|gap|size)[\w-]*\s*:\s*([^;{}]{1,30})/g)]
    .map((x) => x[0].trim())
    .slice(0, 20)
  const radiusVars = [...all.matchAll(/--(?:radius|rounded)[\w-]*\s*:\s*([^;{}]{1,30})/g)]
    .map((x) => x[0].trim())
    .slice(0, 12)

  const breakpoints = new Set<string>()
  const bpRe = /@media[^{]*\((?:min|max)-width\s*:\s*([^)]+)\)/g
  while ((m = bpRe.exec(all)) && breakpoints.size < 8) breakpoints.add(m[1].trim())
  // Inline styles in HTML also carry tokens (style attributes)
  if (fonts.size === 0) {
    const inlineFont = html.match(/font-family\s*:\s*([^;"'}]{2,60})/i)
    if (inlineFont) fonts.add(inlineFont[1].trim())
  }
  return {
    colors,
    fonts: [...fonts],
    spacingVars,
    radiusVars,
    breakpoints: [...breakpoints],
  }
}

interface RawApiCall {
  method: string
  url: string
  kind: 'rest' | 'graphql' | 'ws' | 'sse'
  snippet: string
  file: string
}

function templateToParam(url: string): string {
  return url.replace(/\$\{[^}]+\}/g, ':param').replace(/\s*\+\s*\w+/g, ':param')
}

function mineApiCalls(texts: { file: string; text: string }[]): RawApiCall[] {
  const calls: RawApiCall[] = []
  const seen = new Set<string>()

  const push = (call: RawApiCall) => {
    const key = `${call.kind}:${call.method}:${call.url}`
    if (seen.has(key)) return
    if (calls.length >= MAX_MINED_CALLS) return
    seen.add(key)
    calls.push(call)
  }

  for (const { file, text } of texts) {
    // fetch("…", { method: "POST" }) — method resolved from a small window after the URL
    let m: RegExpExecArray | null
    const fetchRe = /fetch\(\s*[`'"]([^`"'`\s]{3,200})[`'"]([^;]{0,140})/g
    while ((m = fetchRe.exec(text))) {
      const window = m[2]
      const methodMatch = window.match(/method\s*:\s*["']([A-Z]+)["']/)
      push({
        method: methodMatch ? methodMatch[1] : 'GET',
        url: templateToParam(m[1]),
        kind: 'rest',
        snippet: `fetch("${m[1].slice(0, 120)}"${window ? `, ${window.trim().slice(0, 80)}` : ''}`,
        file,
      })
    }
    // axios.get("…") / axios({url})
    const axiosRe = /axios\s*[.(]\s*(?:(get|post|put|patch|delete)\s*\(\s*[`'"]([^`"'`\s]{3,200})[`'"]|url\s*:\s*[`'"]([^`"'`\s]{3,200})[`'"])/gi
    while ((m = axiosRe.exec(text))) {
      push({
        method: (m[1] ?? 'GET').toUpperCase(),
        url: templateToParam(m[2] ?? m[3] ?? ''),
        kind: 'rest',
        snippet: `axios.${m[1] ?? 'request'}("${(m[2] ?? m[3] ?? '').slice(0, 120)}")`,
        file,
      })
    }
    // XHR open
    const xhrRe = /\.open\(\s*["'](GET|POST|PUT|PATCH|DELETE|HEAD)["']\s*,\s*[`'"]([^`"'`\s]{3,200})[`'"]/g
    while ((m = xhrRe.exec(text))) {
      push({
        method: m[1],
        url: templateToParam(m[2]),
        kind: 'rest',
        snippet: `.open("${m[1]}", "${m[2].slice(0, 120)}")`,
        file,
      })
    }
    // GraphQL operations
    const gqlRe = /\b(query|mutation|subscription)\s+([A-Za-z_][A-Za-z0-9_]*)\s*[({]/g
    while ((m = gqlRe.exec(text))) {
      push({
        method: 'POST',
        url: '/graphql',
        kind: 'graphql',
        snippet: `${m[1]} ${m[2]} { … }`,
        file,
      })
    }
    // WebSockets
    const wsRe = /new\s+WebSocket\(\s*[`'"]([^`"'`\s]{3,200})[`'"]/g
    while ((m = wsRe.exec(text))) {
      push({ method: 'WS', url: templateToParam(m[1]), kind: 'ws', snippet: `new WebSocket("${m[1].slice(0, 120)}")`, file })
    }
    // Server-Sent Events
    const sseRe = /new\s+EventSource\(\s*[`'"]([^`"'`\s]{3,200})[`'"]/g
    while ((m = sseRe.exec(text))) {
      push({ method: 'SSE', url: templateToParam(m[1]), kind: 'sse', snippet: `new EventSource("${m[1].slice(0, 120)}")`, file })
    }
  }
  return calls
}

function scanSecrets(texts: { file: string; text: string }[]): { pattern: string; snippet: string; file: string }[] {
  const found: { pattern: string; snippet: string; file: string }[] = []
  for (const { name, re } of SECRET_PATTERNS) {
    for (const { file, text } of texts) {
      const m = text.match(re)
      if (m) {
        found.push({
          pattern: name,
          snippet: `${m[0].slice(0, 18)}…(redacted)`,
          file,
        })
        break
      }
    }
  }
  return found
}

// ============================================================
// Stage collectors — the constrained tools. Each stage gathers
// material mechanically; the model is never let near the
// network. Anti-bot walls are reported honestly, never evaded.
// ============================================================

interface StageOutput {
  evidence: SiteEvidence[]
  unknowns: string[]
}

function detectBlocked(doc: FetchedDoc): { blocked: boolean; reason: string | null } {
  if ([403, 429, 503].includes(doc.status)) {
    return { blocked: true, reason: `HTTP ${doc.status} — the site refused our declared crawler` }
  }
  const body = doc.body.slice(0, 4000).toLowerCase()
  if (body.includes('just a moment') || body.includes('cf-browser-verification') || body.includes('attention required') || body.includes('enable javascript and cookies')) {
    return { blocked: true, reason: 'anti-bot challenge page detected (content hidden behind verification)' }
  }
  if (doc.status >= 400) {
    return { blocked: false, reason: null }
  }
  return { blocked: false, reason: null }
}

// ---------- Stage 1: recon — one page, robots, sitemap ----------

interface ReconResult extends StageOutput {
  recon: SiteRecon
}

async function collectRecon(seed: URL): Promise<ReconResult> {
  const evidence: SiteEvidence[] = []
  const unknowns: string[] = []

  let home: FetchedDoc
  try {
    home = await politeFetch(seed.toString(), 'text/html,application/xhtml+xml')
  } catch {
    throw new SiteIntelError('UNREACHABLE', 'The site could not be reached (network error or timeout).')
  }

  const html = home.body.slice(0, MAX_HTML_CHARS)
  const blockedInfo = detectBlocked(home)

  // robots.txt — best effort
  let robots: RobotsInfo = { found: false, sitemaps: [], disallows: [] }
  try {
    const robotsUrl = new URL('/robots.txt', home.finalUrl).toString()
    const robotsDoc = await politeFetch(robotsUrl, 'text/plain')
    if (robotsDoc.status === 200) robots = parseRobots(robotsDoc.body.slice(0, 100_000))
  } catch {
    unknowns.push('robots.txt could not be fetched — crawl proceeded with default politeness only')
  }

  // First sitemap — best effort, just counting reachability
  let sitemapCount = 0
  if (robots.sitemaps.length > 0) {
    try {
      const smDoc = await politeFetch(robots.sitemaps[0], 'application/xml,text/xml')
      if (smDoc.status === 200) {
        sitemapCount = Math.min((smDoc.body.match(/<loc>/g) ?? []).length, 5000)
      }
    } catch {
      unknowns.push(`declared sitemap ${robots.sitemaps[0]} could not be fetched`)
    }
  } else {
    unknowns.push('no sitemap declared in robots.txt — surface map relies on link crawling only')
  }
  if (sitemapCount === 0 && robots.sitemaps.length === 0) {
    try {
      const smDoc = await politeFetch(new URL('/sitemap.xml', home.finalUrl).toString(), 'application/xml,text/xml')
      if (smDoc.status === 200) {
        sitemapCount = Math.min((smDoc.body.match(/<loc>/g) ?? []).length, 5000)
        robots = { ...robots, sitemaps: [new URL('/sitemap.xml', home.finalUrl).toString()] }
      }
    } catch {
      // no sitemap at all — fine
    }
  }

  const title = extractTitle(html)
  const description = extractMeta(html, 'description')
  const generator = extractMeta(html, 'generator')

  const techSignals: string[] = []
  if (home.headers['server']) techSignals.push(`Server header: ${home.headers['server'].slice(0, 60)}`)
  if (home.headers['x-powered-by']) techSignals.push(`X-Powered-By: ${home.headers['x-powered-by'].slice(0, 60)}`)
  if (generator) techSignals.push(`Meta generator: ${generator.slice(0, 60)}`)
  if (home.headers['cf-ray']) techSignals.push('Cloudflare in front (cf-ray header)')

  const recon: SiteRecon = {
    finalUrl: home.finalUrl,
    httpStatus: home.status,
    redirected: home.finalUrl !== seed.toString(),
    https: home.finalUrl.startsWith('https://'),
    server: home.headers['server'] ?? null,
    poweredBy: home.headers['x-powered-by'] ?? null,
    title,
    description,
    generator,
    headers: home.headers,
    robots,
    techSignals,
    blocked: blockedInfo.blocked,
    blockedReason: blockedInfo.reason,
    fetchMs: home.ms,
  }

  evidence.push(
    {
      claim: `Homepage responded HTTP ${home.status} in ${home.ms}ms`,
      source: home.finalUrl,
      method: 'HTTP GET with declared user agent',
      confidence: 'high',
    },
    {
      claim: `robots.txt ${robots.found ? `found with ${robots.disallows.length} disallow rules` : 'not found'}`,
      source: new URL('/robots.txt', home.finalUrl).toString(),
      method: 'robots.txt parse (User-agent: * group)',
      confidence: 'high',
    }
  )
  if (title) {
    evidence.push({ claim: `Site title: ${title}`, source: home.finalUrl, method: '<title> extraction', confidence: 'high' })
  }
  if (blockedInfo.blocked) {
    unknowns.push(`The site is partially blocked to crawlers: ${blockedInfo.reason}. Deeper pages may be unavailable — the study reports what was reachable, honestly.`)
  }
  if (home.status >= 400) {
    throw new SiteIntelError('UNREACHABLE', `The site responded with HTTP ${home.status}.`)
  }

  return { recon, evidence, unknowns }
}

// ---------- Stage 2: surface — crawl pages (robots-aware) ----------

interface SurfaceResult extends StageOutput {
  surface: SiteSurface
  jsUrls: string[]
  cssUrls: string[]
  inlineScripts: string
  homeHtml: string
}

function pageFromDoc(doc: FetchedDoc, url: string): SitePageInfo {
  const html = doc.body.slice(0, MAX_HTML_CHARS)
  const imgs = countImages(html)
  const jsonLdTypes = extractJsonLdTypes(html)
  return {
    url,
    status: doc.status,
    title: extractTitle(html),
    description: extractMeta(html, 'description'),
    h1: extractHeadings(html, 'h1'),
    forms: extractForms(html),
    linkCount: extractLinks(html).length,
    imgCount: imgs.count,
    imgNoAlt: imgs.noAlt,
    hasJsonLd: jsonLdTypes.length > 0,
    jsonLdTypes,
    canonical: extractCanonical(html),
    ogTitle: extractMeta(html, 'og:title'),
  }
}

async function collectSurface(recon: SiteRecon): Promise<SurfaceResult> {
  const evidence: SiteEvidence[] = []
  const unknowns: string[] = []
  const origin = new URL(recon.finalUrl)
  const robots = recon.robots

  const queue: string[] = [origin.toString()]
  const visited = new Set<string>()
  const pages: SitePageInfo[] = []
  const patterns = new Set<string>()
  const failedPages: string[] = []
  const jsUrls: string[] = []
  const cssUrls: string[] = []
  let skippedByRobots = 0
  let inlineScripts = ''
  let homeHtml = ''

  while (queue.length > 0 && pages.length < MAX_PAGES) {
    const current = queue.shift() as string
    let normalized: string
    try {
      const u = new URL(current)
      u.hash = ''
      u.search = '' // drop query strings for crawl uniqueness
      normalized = u.toString()
    } catch {
      continue
    }
    if (visited.has(normalized)) continue
    visited.add(normalized)

    const url = new URL(normalized)
    if (!sameOrigin(url, origin) || !isCrawlablePage(url)) continue
    if (!robotsAllows(url, robots)) {
      skippedByRobots++
      continue
    }

    let doc: FetchedDoc
    try {
      await sleep(CRAWL_DELAY_MS)
      doc = await politeFetch(normalized, 'text/html,application/xhtml+xml')
    } catch {
      failedPages.push(normalized)
      continue
    }
    if (doc.status >= 400) {
      failedPages.push(normalized)
      continue
    }

    const html = doc.body.slice(0, MAX_HTML_CHARS)
    if (pages.length === 0) homeHtml = html
    pages.push(pageFromDoc(doc, normalized))
    patterns.add(toRoutePattern(url.pathname))

    // Collect assets for the bundles stage
    for (const src of extractScriptSrcs(html)) {
      try {
        const asset = new URL(src, normalized)
        if (sameOrigin(asset, origin) || /\.(?:min\.)?js$/i.test(asset.pathname)) {
          if (!jsUrls.includes(asset.toString())) jsUrls.push(asset.toString())
        }
      } catch {
        // malformed src — skip
      }
    }
    for (const href of extractStylesheetHrefs(html)) {
      try {
        const asset = new URL(href, normalized)
        if (!cssUrls.includes(asset.toString())) cssUrls.push(asset.toString())
      } catch {
        // malformed href — skip
      }
    }

    // Inline scripts feed API mining (SPAs live here)
    if (inlineScripts.length < INLINE_SCRIPT_BUDGET) {
      inlineScripts += `${extractInlineScripts(html)}\n;\n`
    }

    // Enqueue same-origin links
    for (const href of extractLinks(html)) {
      if (queue.length > 120) break
      try {
        const next = new URL(href, normalized)
        next.hash = ''
        if (!sameOrigin(next, origin)) continue
        if (!isCrawlablePage(next)) continue
        const key = next.toString()
        if (!visited.has(key) && !queue.includes(key)) queue.push(key)
      } catch {
        // skip malformed
      }
    }
  }

  // Sitemap URLs the crawler didn't reach by links (only counted, not fetched)
  let sitemapUrls = 0
  if (robots.sitemaps.length > 0) {
    try {
      const smDoc = await politeFetch(robots.sitemaps[0], 'application/xml,text/xml')
      if (smDoc.status === 200) {
        const locs = [...smDoc.body.matchAll(/<loc>\s*([^<\s]+)\s*<\/loc>/g)].map((m) => m[1])
        sitemapUrls = Math.min(locs.length, 5000)
        // Prefer sitemap order for a few extra pages if crawl was thin
        for (const loc of locs) {
          if (pages.length >= MAX_PAGES) break
          try {
            const u = new URL(loc)
            if (!sameOrigin(u, origin) || !isCrawlablePage(u)) continue
            const key = u.toString()
            if (visited.has(key)) continue
            if (!robotsAllows(u, robots)) {
              skippedByRobots++
              continue
            }
            visited.add(key)
            await sleep(CRAWL_DELAY_MS)
            const doc = await politeFetch(key, 'text/html,application/xhtml+xml')
            if (doc.status >= 400) {
              failedPages.push(key)
              continue
            }
            pages.push(pageFromDoc(doc, key))
            patterns.add(toRoutePattern(u.pathname))
          } catch {
            failedPages.push(loc)
          }
        }
      }
    } catch {
      // sitemap already best-effort in recon
    }
  }

  if (pages.length === 0) {
    throw new SiteIntelError('BLOCKED', 'No pages could be crawled — the site blocks or fails all requests.')
  }

  evidence.push(
    {
      claim: `${pages.length} pages crawled (cap ${MAX_PAGES}, ${CRAWL_DELAY_MS}ms delay, declared UA)`,
      source: origin.toString(),
      method: 'same-origin BFS link crawl + sitemap, robots.txt obeyed',
      confidence: 'high',
    },
    {
      claim: `${patterns.size} route patterns: ${[...patterns].slice(0, 10).join(', ')}${patterns.size > 10 ? '…' : ''}`,
      source: 'crawled URLs',
      method: 'path segmentation (numeric/uuid/hash segments → :id)',
      confidence: 'medium',
    }
  )
  if (skippedByRobots > 0) {
    evidence.push({
      claim: `${skippedByRobots} URLs skipped — disallowed by robots.txt`,
      source: '/robots.txt',
      method: 'robots.txt Disallow prefix match',
      confidence: 'high',
    })
  }
  if (pages.length >= MAX_PAGES) {
    unknowns.push(`Crawl stopped at the ${MAX_PAGES}-page cap — the platform likely has more routes than listed`)
  } else if (failedPages.length > 0) {
    unknowns.push(`${failedPages.length} linked pages failed to load: ${failedPages.slice(0, 5).join(', ')}`)
  }

  const surface: SiteSurface = {
    pages,
    routePatterns: [...patterns].sort(),
    sitemapUrls,
    skippedByRobots,
    failedPages: failedPages.slice(0, 20),
  }
  return { surface, evidence, unknowns, jsUrls, cssUrls, inlineScripts, homeHtml }
}

// ---------- Stage 3: bundles — static asset autopsy ----------

interface BundlesResult extends StageOutput {
  bundles: SiteBundles
  mined: SiteMinedData
}

async function collectBundles(surface: SurfaceResult, homeHtml: string): Promise<BundlesResult> {
  const evidence: SiteEvidence[] = []
  const unknowns: string[] = []
  const js: SiteAssetInfo[] = []
  const css: SiteAssetInfo[] = []
  const texts: { file: string; text: string }[] = []
  const cssTexts: string[] = []

  const jsBudget = surface.jsUrls.slice(0, MAX_JS_ASSETS)
  const cssBudget = surface.cssUrls.slice(0, MAX_CSS_ASSETS)

  for (const url of jsBudget) {
    try {
      await sleep(CRAWL_DELAY_MS)
      const doc = await politeFetch(url, '*/*')
      if (doc.status !== 200 || !doc.body) continue
      const kb = Math.round((doc.body.length / 1024) * 10) / 10
      js.push({ url, sizeKb: kb })
      texts.push({ file: url.split('/').pop() ?? url, text: doc.body })
      if (doc.truncated) unknowns.push(`${url} exceeded the 1.2MB analysis cap — analyzed first 1.2MB only`)
    } catch {
      unknowns.push(`JS asset unreachable: ${url}`)
    }
  }
  for (const url of cssBudget) {
    try {
      await sleep(CRAWL_DELAY_MS)
      const doc = await politeFetch(url, '*/*')
      if (doc.status !== 200 || !doc.body) continue
      const kb = Math.round((doc.body.length / 1024) * 10) / 10
      css.push({ url, sizeKb: kb })
      cssTexts.push(doc.body)
    } catch {
      unknowns.push(`CSS asset unreachable: ${url}`)
    }
  }

  // Inline scripts count as a pseudo-bundle for mining
  const inlineText = surface.inlineScripts.slice(0, INLINE_SCRIPT_BUDGET)
  if (inlineText.trim().length > 100) {
    texts.push({ file: '(inline <script>)', text: inlineText })
  }
  if (homeHtml.length > 0) {
    texts.push({ file: '(homepage HTML)', text: homeHtml })
  }

  const frameworks = fingerprintBundles(texts)
  const libraries = frameworks.filter((f) => BUNDLE_FINGERPRINTS.some((b) => b.name === f.name)).map((f) => f.name)
  const routesInBundles = mineRoutesFromBundles(texts)
  const designTokens = mineDesignTokens(cssTexts, homeHtml)
  const sourceMaps = texts.filter((t) => /sourceMappingURL=/.test(t.text)).map((t) => t.file)
  const apiCalls = mineApiCalls(texts)
  const secrets = scanSecrets(texts.filter((t) => t.file !== '(homepage HTML)'))

  // Rendering model — deterministic verdict from fingerprints
  let renderingModel = 'static / server-rendered HTML'
  let renderingEvidence = 'no client framework fingerprint detected in HTML or bundles'
  const hasNext = frameworks.some((f) => f.name === 'Next.js')
  const hasNuxt = frameworks.some((f) => f.name === 'Nuxt')
  const hasReact = frameworks.some((f) => f.name === 'React (hydrate)' || f.name === 'React')
  const bodyTextLen = stripTags(homeHtml.slice(0, 100_000)).length
  if (hasNext) {
    renderingModel = 'SSR/SSG hybrid (Next.js)'
    renderingEvidence = '__NEXT_DATA__ / /_next/ fingerprint present'
  } else if (hasNuxt) {
    renderingModel = 'SSR/SSG hybrid (Nuxt)'
    renderingEvidence = '__NUXT__ fingerprint present'
  } else if (hasReact || frameworks.some((f) => ['Vue', 'Angular', 'Svelte/SvelteKit'].includes(f.name))) {
    const framework = frameworks.find((f) => ['React (hydrate)', 'Vue', 'Angular', 'Svelte/SvelteKit'].includes(f.name))?.name ?? 'client framework'
    renderingModel = bodyTextLen > 400 ? 'SSR + client hydration' : 'client-side SPA'
    renderingEvidence = `${framework} fingerprint present; homepage visible text ${bodyTextLen} chars ${bodyTextLen > 400 ? '(server-rendered content present)' : '(near-empty shell → client-rendered)'}`
  }

  const totalJsKb = Math.round(js.reduce((s, a) => s + a.sizeKb, 0))
  const totalCssKb = Math.round(css.reduce((s, a) => s + a.sizeKb, 0))

  evidence.push(
    {
      claim: `${js.length} JS bundles (${totalJsKb}KB) + ${css.length} CSS files (${totalCssKb}KB) statically analyzed`,
      source: `${jsBudget.length + cssBudget.length} asset URLs from crawled HTML`,
      method: 'plain HTTP GET + static regex analysis — never executed',
      confidence: 'high',
    },
    {
      claim: `Rendering model: ${renderingModel}`,
      source: renderingEvidence,
      method: 'framework fingerprints + homepage text density heuristic',
      confidence: 'medium',
    }
  )
  if (frameworks.length > 0) {
    evidence.push({
      claim: `Technology fingerprints: ${frameworks.map((f) => f.name).slice(0, 12).join(', ')}`,
      source: 'HTML + JS bundle static signatures',
      method: 'fingerprint table (known framework/library regex signatures)',
      confidence: 'medium',
    })
  }
  if (sourceMaps.length > 0) {
    evidence.push({
      claim: `Source maps shipped to production: ${sourceMaps.join(', ')}`,
      source: 'bundle text',
      method: 'sourceMappingURL comment detection',
      confidence: 'high',
    })
  }
  if (js.length === 0) {
    unknowns.push('No JavaScript bundles were discovered or reachable — API surface and library analysis may be empty (the site may inline everything, block assets, or be fully static)')
  }
  if (secrets.length > 0) {
    evidence.push({
      claim: `${secrets.length} hardcoded secret pattern(s) found in public bundles: ${secrets.map((s) => s.pattern).join(', ')}`,
      source: 'bundle text',
      method: 'known secret format scan (values redacted)',
      confidence: 'high',
    })
  }

  const bundles: SiteBundles = {
    js,
    css,
    frameworks,
    libraries,
    routesInBundles,
    designTokens,
    sourceMaps,
    renderingModel,
    renderingEvidence,
    totalJsKb,
    totalCssKb,
  }
  const mined: SiteMinedData = {
    apiCalls: apiCalls.map((c) => ({ method: c.method, url: c.url, kind: c.kind, snippet: c.snippet, file: c.file })),
    secrets,
    inlineScriptChars: inlineText.length,
  }
  return { bundles, mined, evidence, unknowns }
}

// ============================================================
// AI structuring stages — the model only ORGANIZES material the
// collector already gathered. It cannot fetch, cannot execute,
// cannot invent: every item must trace back to a mined call, a
// crawled page or a fingerprint. Same honesty discipline as the
// Verifier and Drift Detector.
// ============================================================

const APIS_PROMPT = `You are the API Surface skill of a website study engine. You are given RAW call sites statically mined from the target site's public JavaScript (fetch/axios/XHR/GraphQL/WebSocket/EventSource patterns with their source file). Your job: structure them into a clean API surface inventory.

Rules (STRICT):
- Only use the mined call sites you are given. NEVER invent an endpoint that is not in the material — if the material is empty, return empty arrays.
- Merge duplicates (same method+path). Normalize template variables to :param.
- Ignore obviously non-API URLs (static assets, images, analytics SDKs like google-analytics, facebook, hotjar, sentry, doubleclick, CDN urls, fonts). When in doubt, keep it and say so in purpose.
- "purpose": ONE short phrase (e.g. "load product list", "submit login"). If unknowable from the snippet, write "unclear from snippet".
- "evidence": quote the exact mined snippet + file you based the entry on.
- graphqlOps: names of GraphQL operations found. websockets: the WS URLs found.
- "authPattern": ONE sentence on how auth appears to work from the snippets (header names, token patterns, cookies); "no auth signals in mined code" if none.

Return STRICT JSON only — no markdown fences — with exactly these keys:
- "endpoints": [{ "method": "GET|POST|PUT|PATCH|DELETE|WS|SSE", "path": "/api/...", "kind": "rest|graphql|ws|sse", "evidence": "snippet + file", "purpose": "one phrase" }]
- "graphqlOps": [string]
- "websockets": [string]
- "authPattern": string`

const MODELS_PROMPT = `You are the Data Model skill of a website study engine. From the material below (mined API endpoints, crawled forms with their pages, JSON-LD types, route patterns, framework libraries), infer the platform's likely DATA ENTITIES and relationships.

Rules (STRICT):
- Ground every entity in evidence: an API path (/api/users/42), a form (fields on /login), a JSON-LD type, or a route pattern (/products/:id). Name that evidence in each field's description implicitly by choosing field names that appear in the material.
- Do NOT invent fields with no basis. Fields may come from: form input names, API path segments, GraphQL operation names, JSON-LD properties you saw.
- "relations": e.g. "User 1..* Order (orders reference user ids in /api/users/:id/orders)".
- 3-10 entities typically. If material is thin, fewer entities and honest breadth.
- "markdown": a full data-models.md document — a markdown TABLE per entity (field, type, evidence) plus a relationships section. English, build-agent ready.

Return STRICT JSON only — no markdown fences — with exactly these keys:
- "entities": [{ "name": "User", "fields": ["id", "email", ...], "relations": ["User 1..* Order — basis: ..."] }]
- "markdown": "# Data models\\n..."`

const AUDIT_PROMPT = `You are the Audit skill of a website study engine. You are given MECHANICAL audit facts collected statically (security headers, cookie flags, SEO tags per page, image alt coverage, semantic landmarks, bundle weights, source maps, secret patterns). Write the four audit sections.

Rules (STRICT):
- Use ONLY the facts given. Do not run any checks of your own; do not speculate about server-side behavior you cannot see.
- Every finding names its evidence (the header, the page, the number).
- severity: "good" for solid practices, "minor"/"major"/"critical" for issues, proportionate and honest.
- Things the static study cannot see (runtime Lighthouse scores, real TLS config, backend logs) go in "notes" as explicitly out of scope — never guessed.
- findings per section: 3-7 items max, most important first.

Return STRICT JSON only — no markdown fences — with exactly these keys:
- "security": [{ "finding": "...", "severity": "critical|major|minor|good", "evidence": "..." }]
- "seo": same shape
- "a11y": same shape
- "performance": same shape
- "notes": "one short paragraph on what this static audit could not assess"`

const SYNTH_A_PROMPT = `You are the Synthesis skill of a website study engine. You are given everything the collector gathered about one target platform: recon, crawled pages, bundle fingerprints, API surface, data models, audit facts. Write two documents of the study pack.

Rules (STRICT):
- Every claim must be traceable to the material. If something is not in the material, it goes unsaid — no speculation dressed as fact.
- overview.md: what the platform IS and DOES — purpose, audience, primary user flows (grounded in crawled pages/forms), business model signals, content model. Start with a one-paragraph summary. 150-350 words.
- architecture.md: rendering model (from fingerprints), routing (route patterns), state management signals, data flow (pages -> APIs -> entities), third-party integrations (from fingerprints), and what remains unknown. 150-350 words.
- Write clean English markdown for BUILD AGENTS (they will use it to plan a replica). No filler, no marketing language.

Return STRICT JSON only — no markdown fences — with exactly these keys:
- "overview": "# Overview\\n..."
- "architecture": "# Architecture\\n..."`

const SYNTH_B_PROMPT = `You are the Synthesis skill of a website study engine. Given the collected material (crawled pages with headings/forms, bundle fingerprints, design tokens, rendering model), write two documents of the study pack.

Rules (STRICT):
- component-map.md: for each meaningful crawled route (group by route pattern), describe the page's evident UI structure — layout regions, key components implied by headings/forms/links/images (e.g. "product card grid", "search bar", "auth form"), and states where evident. Ground everything in what the crawler saw.
- tech-stack.md: a structured document: frontend (framework + evidence), styling system (tokens, frameworks), libraries detected, backend signals (API style, auth pattern), infrastructure signals (CDN, hosting hints), third-party services. End with a "Confidence" note distinguishing high-confidence detections from weak signals.
- English markdown for build agents. Terse, factual.

Return STRICT JSON only — no markdown fences — with exactly these keys:
- "componentMap": "# Component map\\n..."
- "techStack": "# Tech stack\\n..."`

// ---------- Stage 4: API surface (AI structuring of mined calls) ----------

async function structureApis(data: SiteIntelData): Promise<{ apis: SiteApiSurface; evidence: SiteEvidence[]; unknowns: string[] }> {
  const mined = data.mined
  const evidence: SiteEvidence[] = []
  const unknowns: string[] = []
  const calls = mined?.apiCalls ?? []

  if (calls.length === 0) {
    const apis: SiteApiSurface = { endpoints: [], graphqlOps: [], websockets: [], authPattern: 'no API call sites found in public code' }
    unknowns.push('No API call sites were statically found — the site may be static, may proxy through server code, or may hide calls behind obfuscated/minified patterns')
    evidence.push({
      claim: 'API surface: none found in public client code',
      source: 'JS bundles + inline scripts',
      method: 'static regex mining of fetch/axios/XHR/GraphQL/WebSocket patterns',
      confidence: 'medium',
    })
    return { apis, evidence, unknowns }
  }

  const callTable = calls
    .map((c, i) => `${i + 1}. [${c.kind}] ${c.method} ${c.url}\n   snippet: ${c.snippet.slice(0, 140)}\n   file: ${c.file}`)
    .join('\n')

  const raw = await chatJson<Record<string, unknown>>(APIS_PROMPT, `MINED CALL SITES (${calls.length}):\n\n${callTable}\n\nStructure them now.`, 2)

  const strArr = (v: unknown): string[] =>
    Array.isArray(v) ? v.filter((x): x is string => typeof x === 'string').slice(0, 40) : []
  const endpoints: SiteEndpointFound[] = Array.isArray(raw['endpoints'])
    ? (raw['endpoints'] as Record<string, unknown>[])
        .filter((e) => e && typeof e === 'object')
        .map((e) => ({
          method: typeof e['method'] === 'string' ? e['method'].toUpperCase().slice(0, 8) : 'GET',
          path: typeof e['path'] === 'string' ? e['path'].slice(0, 200) : '',
          kind: (['rest', 'graphql', 'ws', 'sse'] as const).includes(e['kind'] as never) ? (e['kind'] as SiteEndpointFound['kind']) : 'rest',
          evidence: typeof e['evidence'] === 'string' ? e['evidence'].slice(0, 240) : '',
          purpose: typeof e['purpose'] === 'string' ? e['purpose'].slice(0, 160) : '',
        }))
        .filter((e) => e.path.length > 0)
        .slice(0, 50)
    : []

  const apis: SiteApiSurface = {
    endpoints,
    graphqlOps: strArr(raw['graphqlOps']),
    websockets: strArr(raw['websockets']),
    authPattern: typeof raw['authPattern'] === 'string' ? raw['authPattern'].slice(0, 300) : '',
  }
  evidence.push({
    claim: `${endpoints.length} endpoints structured from ${calls.length} statically mined call sites`,
    source: 'JS bundles + inline scripts',
    method: 'regex mining (fetch/axios/XHR/gql/WS/SSE) + AI structuring with evidence per endpoint',
    confidence: 'medium',
  })
  if (apis.graphqlOps.length > 0) {
    evidence.push({
      claim: `GraphQL operations: ${apis.graphqlOps.slice(0, 8).join(', ')}`,
      source: 'bundle text',
      method: 'query/mutation/subscription operation-name regex',
      confidence: 'high',
    })
  }
  return { apis, evidence, unknowns }
}

// ---------- Stage 5: data models (AI inference, evidence-grounded) ----------

async function structureModels(data: SiteIntelData): Promise<{ models: SiteModels; evidence: SiteEvidence[]; unknowns: string[] }> {
  const evidence: SiteEvidence[] = []
  const unknowns: string[] = []

  const forms = (data.surface?.pages ?? [])
    .filter((p) => p.forms.length > 0)
    .map((p) => `- ${p.url}: ${p.forms.map((f) => `${f.method} ${f.action || '(self)'}`).join('; ')}`)
    .slice(0, 20)
  const jsonLd = [...new Set((data.surface?.pages ?? []).flatMap((p) => p.jsonLdTypes))].slice(0, 15)
  const endpoints = (data.apis?.endpoints ?? []).map((e) => `${e.method} ${e.path}`).slice(0, 30)
  const routes = (data.surface?.routePatterns ?? []).slice(0, 25)
  const libs = data.bundles?.libraries ?? []

  if (endpoints.length === 0 && forms.length === 0 && jsonLd.length === 0 && routes.length === 0) {
    const models: SiteModels = { markdown: '# Data models\n\nNo basis for entity inference — no forms, API routes, JSON-LD or route patterns were found.', entities: [] }
    unknowns.push('Data model could not be inferred — no forms, API endpoints, JSON-LD or resource-like routes were found')
    return { models, evidence, unknowns }
  }

  const user = [
    `API ENDPOINTS FOUND: ${endpoints.join(', ') || '(none)'}`,
    `CRAWLED FORMS: ${forms.join('\n') || '(none)'}`,
    `JSON-LD TYPES: ${jsonLd.join(', ') || '(none)'}`,
    `ROUTE PATTERNS: ${routes.join(', ') || '(none)'}`,
    `DETECTED LIBRARIES: ${libs.join(', ') || '(none)'}`,
    '',
    'Infer the data entities now. Every entity and field must be grounded in this material.',
  ].join('\n')

  const raw = await chatJson<Record<string, unknown>>(MODELS_PROMPT, user, 2)
  const entities: SiteEntityFound[] = Array.isArray(raw['entities'])
    ? (raw['entities'] as Record<string, unknown>[])
        .filter((e) => e && typeof e === 'object' && typeof e['name'] === 'string')
        .map((e) => ({
          name: String(e['name']).slice(0, 60),
          fields: Array.isArray(e['fields']) ? e['fields'].filter((f): f is string => typeof f === 'string').slice(0, 25) : [],
          relations: Array.isArray(e['relations']) ? e['relations'].filter((r): r is string => typeof r === 'string').slice(0, 10) : [],
        }))
        .slice(0, 12)
    : []
  const markdown = typeof raw['markdown'] === 'string' ? raw['markdown'] : '# Data models\n(none)'

  const models: SiteModels = { markdown, entities }
  evidence.push({
    claim: `${entities.length} data entities inferred (${entities.map((e) => e.name).slice(0, 6).join(', ')}${entities.length > 6 ? '…' : ''})`,
    source: 'API paths + forms + JSON-LD + route patterns',
    method: 'evidence-grounded AI inference — each field traces to mined material',
    confidence: 'medium',
  })
  if (entities.length === 0) {
    unknowns.push('AI structuring returned no entities — treat the data model as unknown')
  }
  return { models, evidence, unknowns }
}

// ---------- Stage 6: audit (mechanical facts + AI write-up) ----------

function collectAuditFacts(data: SiteIntelData): string {
  const lines: string[] = []
  const recon = data.recon
  const surface = data.surface
  const bundles = data.bundles
  const mined = data.mined

  if (recon) {
    const h = recon.headers
    lines.push(`SECURITY HEADERS (from ${recon.finalUrl}):`)
    lines.push(`- HTTPS: ${recon.https ? 'yes' : 'NO — plain http'}`)
    lines.push(`- HSTS (strict-transport-security): ${h['strict-transport-security'] ? `present (${h['strict-transport-security'].slice(0, 60)})` : 'MISSING'}`)
    lines.push(`- CSP (content-security-policy): ${h['content-security-policy'] ? `present (${h['content-security-policy'].length} chars)` : 'MISSING'}`)
    lines.push(`- X-Frame-Options / frame-ancestors: ${h['x-frame-options'] ?? (h['content-security-policy']?.includes('frame-ancestors') ? 'via CSP' : 'MISSING')}`)
    lines.push(`- X-Content-Type-Options: ${h['x-content-type-options'] ?? 'MISSING'}`)
    lines.push(`- Referrer-Policy: ${h['referrer-policy'] ?? 'MISSING'}`)
    lines.push(`- Permissions-Policy: ${h['permissions-policy'] ?? 'MISSING'}`)
    lines.push(`- Server header disclosure: ${recon.server ?? 'hidden'}; X-Powered-By: ${recon.poweredBy ?? 'hidden'}`)
    const setCookie = h['set-cookie'] ?? ''
    if (setCookie) {
      lines.push(`- Set-Cookie flags: Secure=${/secure/i.test(setCookie) ? 'yes' : 'NO'}, HttpOnly=${/httponly/i.test(setCookie) ? 'yes' : 'NO'}, SameSite=${/samesite/i.test(setCookie) ? 'yes' : 'NO'}`)
    } else {
      lines.push('- Set-Cookie: none on the homepage response')
    }
  }
  if (mined?.secrets.length) {
    lines.push(`- HARDCODED SECRETS IN PUBLIC BUNDLES: ${mined.secrets.map((s) => `${s.pattern} in ${s.file} (${s.snippet})`).join('; ')}`)
  } else if (bundles) {
    lines.push('- Hardcoded secret patterns in public bundles: none matched')
  }
  if (bundles) {
    lines.push(`- Source maps in production: ${bundles.sourceMaps.length > 0 ? bundles.sourceMaps.join(', ') : 'none detected'}`)
  }

  if (surface) {
    const pages = surface.pages
    const withTitle = pages.filter((p) => p.title).length
    const withDesc = pages.filter((p) => p.description).length
    const withCanonical = pages.filter((p) => p.canonical).length
    const withOg = pages.filter((p) => p.ogTitle).length
    const multiH1 = pages.filter((p) => p.h1.length > 1).length
    const noH1 = pages.filter((p) => p.h1.length === 0).length
    lines.push(``)
    lines.push(`SEO FACTS (across ${pages.length} crawled pages):`)
    lines.push(`- titles present: ${withTitle}/${pages.length}; meta descriptions: ${withDesc}/${pages.length}; canonical: ${withCanonical}/${pages.length}; og:title: ${withOg}/${pages.length}`)
    lines.push(`- pages with MULTIPLE h1: ${multiH1}; pages with NO h1: ${noH1}`)
    lines.push(`- sitemap declared: ${recon?.robots.sitemaps.length ? `yes (${recon.robots.sitemaps[0]})` : 'no'}; robots.txt: ${recon?.robots.found ? 'yes' : 'no'}`)
    lines.push(`- structured data (JSON-LD): ${pages.filter((p) => p.hasJsonLd).length}/${pages.length} pages; types: ${[...new Set(pages.flatMap((p) => p.jsonLdTypes))].slice(0, 10).join(', ') || '(none)'}`)

    const totalImgs = pages.reduce((s, p) => s + p.imgCount, 0)
    const noAlt = pages.reduce((s, p) => s + p.imgNoAlt, 0)
    lines.push(``)
    lines.push(`A11Y FACTS (static):`)
    lines.push(`- images without alt text: ${noAlt}/${totalImgs}`)
    lines.push(`- forms found: ${pages.flatMap((p) => p.forms).length} (label presence not assessable statically)`)
    lines.push(`- heading structure anomalies (multi-h1 / no-h1): ${multiH1 + noH1} pages`)
    lines.push(`- html lang attribute, landmarks, contrast: not assessable from static HTML alone`)
  }
  if (bundles) {
    lines.push(``)
    lines.push(`PERFORMANCE FACTS (static):`)
    lines.push(`- total public JS: ${bundles.totalJsKb}KB across ${bundles.js.length} files; total CSS: ${bundles.totalCssKb}KB across ${bundles.css.length} files`)
    const largest = [...bundles.js].sort((a, b) => b.sizeKb - a.sizeKb)[0]
    if (largest) lines.push(`- largest bundle: ${largest.url.split('/').pop()} at ${largest.sizeKb}KB`)
    lines.push(`- rendering model: ${bundles.renderingModel} (${bundles.renderingEvidence})`)
  }
  return lines.join('\n')
}

async function structureAudit(data: SiteIntelData): Promise<{ audit: SiteAudit; evidence: SiteEvidence[]; unknowns: string[] }> {
  const evidence: SiteEvidence[] = []
  const unknowns: string[] = []
  const facts = collectAuditFacts(data)

  const raw = await chatJson<Record<string, unknown>>(AUDIT_PROMPT, `MECHANICAL AUDIT FACTS (collected statically, no execution):\n\n${facts}\n\nWrite the four audit sections now.`, 2)

  const parseFindings = (v: unknown): SiteAuditFinding[] =>
    Array.isArray(v)
      ? (v as Record<string, unknown>[])
          .filter((f) => f && typeof f === 'object' && typeof f['finding'] === 'string')
          .map((f) => ({
            finding: String(f['finding']).slice(0, 300),
            severity: (['critical', 'major', 'minor', 'good'] as const).includes(f['severity'] as never)
              ? (f['severity'] as SiteAuditFinding['severity'])
              : 'minor',
            evidence: typeof f['evidence'] === 'string' ? f['evidence'].slice(0, 240) : '',
          }))
          .slice(0, 8)
      : []

  const audit: SiteAudit = {
    security: parseFindings(raw['security']),
    seo: parseFindings(raw['seo']),
    a11y: parseFindings(raw['a11y']),
    performance: parseFindings(raw['performance']),
    notes: typeof raw['notes'] === 'string' ? raw['notes'].slice(0, 800) : '',
  }
  evidence.push({
    claim: `Audit compiled: ${audit.security.length} security, ${audit.seo.length} SEO, ${audit.a11y.length} a11y, ${audit.performance.length} performance findings`,
    source: 'response headers + crawled pages + bundle weights',
    method: 'mechanical fact collection + AI write-up (evidence per finding)',
    confidence: 'high',
  })
  unknowns.push('Static audit scope: no JS execution, no runtime timings, no TLS scan — dynamic behavior (Lighthouse-style scores, real paint times) is out of scope')
  return { audit, evidence, unknowns }
}

// ---------- Stage 7: synthesis (AI documents + deterministic pack) ----------

async function runSynthesis(data: SiteIntelData, lang: 'ar' | 'en', constitutionLine: string): Promise<{ synthesis: SiteSynthesis; evidence: SiteEvidence[]; unknowns: string[] }> {
  const evidence: SiteEvidence[] = []
  const unknowns: string[] = []

  const digest = [
    `URL: ${data.recon?.finalUrl ?? ''} | title: ${data.recon?.title ?? ''} | rendering: ${data.bundles?.renderingModel ?? ''}`,
    `PAGES (${data.surface?.pages.length ?? 0}): ${(data.surface?.pages ?? []).slice(0, 20).map((p) => `${p.url} [h1: ${p.h1[0] ?? '—'}] [forms: ${p.forms.length}]`).join('\n  ')}`,
    `ROUTE PATTERNS: ${(data.surface?.routePatterns ?? []).join(', ')}`,
    `FRAMEWORKS/LIBRARIES: ${(data.bundles?.frameworks ?? []).map((f) => f.name).join(', ')}`,
    `API ENDPOINTS (${data.apis?.endpoints.length ?? 0}): ${(data.apis?.endpoints ?? []).slice(0, 25).map((e) => `${e.method} ${e.path}`).join(', ')}`,
    `AUTH PATTERN: ${data.apis?.authPattern ?? ''}`,
    `DATA ENTITIES: ${(data.models?.entities ?? []).map((e) => e.name).join(', ')}`,
    `DESIGN TOKENS: fonts ${(data.bundles?.designTokens.fonts ?? []).join('/')}; top colors ${(data.bundles?.designTokens.colors ?? []).slice(0, 8).map((c) => c.hex).join(' ')}`,
    `AUDIT COUNTS: security ${data.audit?.security.length ?? 0}, seo ${data.audit?.seo.length ?? 0}, a11y ${data.audit?.a11y.length ?? 0}, perf ${data.audit?.performance.length ?? 0}`,
    `TOTALS: JS ${data.bundles?.totalJsKb ?? 0}KB, CSS ${data.bundles?.totalCssKb ?? 0}KB, sitemap URLs ${data.surface?.sitemapUrls ?? 0}`,
    `KNOWN UNKNOWNS: ${(data.unknowns ?? []).slice(0, 8).join(' | ')}`,
  ].join('\n')

  const [a, b] = await Promise.all([
    chatJson<Record<string, unknown>>(
      SYNTH_A_PROMPT,
      [`UI language for any summary sentence: ${lang === 'ar' ? 'Arabic' : 'English'} (the two documents stay in English).`, constitutionLine, '', digest, '', 'Write overview.md and architecture.md now.'].join('\n'),
      2
    ),
    chatJson<Record<string, unknown>>(
      SYNTH_B_PROMPT,
      [constitutionLine, '', digest, '', 'Write component-map.md and tech-stack.md now.'].join('\n'),
      2
    ),
  ])

  const str = (v: unknown, fallback: string): string => (typeof v === 'string' && v.trim() ? v : fallback)
  const synthesis: SiteSynthesis = {
    overview: str(a['overview'], '# Overview\n(not reached)'),
    architecture: str(a['architecture'], '# Architecture\n(not reached)'),
    componentMap: str(b['componentMap'], '# Component map\n(not reached)'),
    techStack: str(b['techStack'], '# Tech stack\n(not reached)'),
    summary: '',
  }
  evidence.push({
    claim: 'Study pack documents synthesized (overview, architecture, component map, tech stack)',
    source: 'all collected stage data',
    method: 'two AI synthesis calls over the collected digest — claims restricted to collected material',
    confidence: 'medium',
  })
  return { synthesis, evidence, unknowns }
}

// ============================================================
// Pack builder + deterministic completeness score
// ============================================================

const PACK_MANIFEST_NOTE =
  'Generated by Site Intelligence — static analysis only. Every claim traces to evidence.json; what could not be determined is in unknowns.md. Use this pack as REFERENCE MATERIAL for building a replica; verify anything critical before relying on it.'

function auditToMarkdown(title: string, findings: SiteAuditFinding[]): string {
  const lines = [`# ${title}`, '']
  if (findings.length === 0) {
    lines.push('(no findings in this section)')
    return lines.join('\n')
  }
  const icon: Record<SiteAuditFinding['severity'], string> = { critical: '🔴', major: '🟠', minor: '🟡', good: '🟢' }
  for (const f of findings) {
    lines.push(`## ${icon[f.severity]} ${f.finding}`)
    lines.push('')
    if (f.evidence) lines.push(`- **Evidence:** ${f.evidence}`)
    lines.push('')
  }
  return lines.join('\n')
}

export function buildPack(item: { url: string; domain: string; stageDone: number }, data: SiteIntelData): { pack: SitePackFile[]; score: number } {
  const files: SitePackFile[] = []
  const add = (name: string, content: string) => files.push({ name, content })

  add('overview.md', data.synthesis?.overview ?? '# Overview\n(not reached — analysis stopped before synthesis)')
  add('tech-stack.md', data.synthesis?.techStack ?? `# Tech stack\n(detected fingerprints: ${(data.bundles?.frameworks ?? []).map((f) => f.name).join(', ') || 'none'})`)
  add('architecture.md', data.synthesis?.architecture ?? '# Architecture\n(not reached)')
  add('component-map.md', data.synthesis?.componentMap ?? '# Component map\n(not reached)')

  add('routes.json', JSON.stringify({ routePatterns: data.surface?.routePatterns ?? [], notes: `crawled ${data.surface?.pages.length ?? 0} pages` }, null, 2))
  add('sitemap.json', JSON.stringify({ crawledUrls: (data.surface?.pages ?? []).map((p) => p.url), sitemapDeclaredUrls: data.surface?.sitemapUrls ?? 0, skippedByRobots: data.surface?.skippedByRobots ?? 0 }, null, 2))
  add('api-surface.json', JSON.stringify({ endpoints: data.apis?.endpoints ?? [], graphqlOps: data.apis?.graphqlOps ?? [], websockets: data.apis?.websockets ?? [], authPattern: data.apis?.authPattern ?? '' }, null, 2))
  add('data-models.md', data.models?.markdown ?? '# Data models\n(not reached)')
  add('design-tokens.json', JSON.stringify(data.bundles?.designTokens ?? { colors: [], fonts: [], spacingVars: [], radiusVars: [], breakpoints: [] }, null, 2))

  add('audit/security.md', auditToMarkdown('Security audit', data.audit?.security ?? []))
  add('audit/seo.md', auditToMarkdown('SEO audit', data.audit?.seo ?? []))
  add('audit/a11y.md', auditToMarkdown('Accessibility audit', data.audit?.a11y ?? []))
  add('audit/performance.md', auditToMarkdown('Performance audit (static)', data.audit?.performance ?? []))

  add('evidence.json', JSON.stringify({ count: data.evidence.length, evidence: data.evidence }, null, 2))
  add('unknowns.md', ['# Unknowns & limitations', '', ...(data.unknowns.length > 0 ? data.unknowns.map((u) => `- ${u}`) : ['- (none recorded)'])].join('\n'))

  // Deterministic completeness score — app-owned, from what was actually collected
  const pages = data.surface?.pages.length ?? 0
  const js = data.bundles?.js.length ?? 0
  const endpoints = data.apis?.endpoints.length ?? 0
  const entities = data.models?.entities.length ?? 0
  let score =
    Math.min(pages, 20) / 20 * 25 +
    Math.min(js, 10) / 10 * 20 +
    Math.min(endpoints, 15) / 15 * 20 +
    Math.min(entities, 6) / 6 * 15 +
    (data.audit ? 10 : 0) +
    Math.min(files.length, 14) / 14 * 10
  if (data.recon?.blocked) score = Math.min(score, 40)
  score = Math.round(Math.max(0, Math.min(100, score)))

  add('manifest.json', JSON.stringify({
    target: item.url,
    domain: item.domain,
    generatedAt: new Date().toISOString(),
    stagesCompleted: item.stageDone,
    completenessScore: score,
    scoreBasis: {
      pagesCrawled: pages,
      jsBundlesAnalyzed: js,
      endpointsStructured: endpoints,
      entitiesInferred: entities,
      auditCompiled: !!data.audit,
      blockedToCrawler: data.recon?.blocked ?? false,
    },
    files: files.map((f) => f.name),
    method: 'static analysis only — no JS execution, robots.txt respected, declared user agent',
    note: PACK_MANIFEST_NOTE,
  }, null, 2))

  return { pack: files, score }
}

// ============================================================
// Serialization
// ============================================================

function parseData(raw: string): SiteIntelData {
  try {
    const v = JSON.parse(raw) as Partial<SiteIntelData>
    return {
      recon: v.recon,
      surface: v.surface,
      bundles: v.bundles,
      mined: v.mined,
      apis: v.apis,
      models: v.models,
      audit: v.audit,
      synthesis: v.synthesis,
      evidence: Array.isArray(v.evidence) ? v.evidence : [],
      unknowns: Array.isArray(v.unknowns) ? v.unknowns : [],
      pack: Array.isArray(v.pack) ? v.pack : [],
      assetJsUrls: Array.isArray(v.assetJsUrls) ? v.assetJsUrls : undefined,
      assetCssUrls: Array.isArray(v.assetCssUrls) ? v.assetCssUrls : undefined,
      inlineScriptsText: typeof v.inlineScriptsText === 'string' ? v.inlineScriptsText : undefined,
    }
  } catch {
    return { evidence: [], unknowns: [], pack: [] }
  }
}

function serialize(row: {
  id: string
  url: string
  domain: string
  status: string
  stageDone: number
  score: number
  error: string | null
  data: string
  createdAt: Date
}): SiteAnalysisItem {
  return {
    id: row.id,
    url: row.url,
    domain: row.domain,
    status: row.status === 'complete' ? 'complete' : row.status === 'failed' ? 'failed' : 'running',
    stageDone: row.stageDone,
    score: row.score,
    error: row.error,
    data: parseData(row.data),
    createdAt: row.createdAt.toISOString(),
  }
}

// ============================================================
// Orchestration — one stage per call, progress persisted
// ============================================================

async function constitutionLine(ideaId: string): Promise<string> {
  try {
    const rules = (await listRules(ideaId)).filter((r) => r.enabled)
    if (rules.length === 0) return ''
    return `DEVELOPER'S STANDING RULES (the project's constitution — where relevant to recommendations, the study must respect them):\n${rules.map((r) => `- [${r.category}] ${r.text}`).join('\n')}`
  } catch {
    return ''
  }
}

async function persist(rowId: string, data: SiteIntelData, stageDone: number, status?: 'running' | 'complete' | 'failed', error?: string | null) {
  const built = buildPack({ url: '', domain: '', stageDone }, data)
  const dataWithPack: SiteIntelData = { ...data, pack: built.pack }
  const patch: Record<string, unknown> = {
    data: JSON.stringify(dataWithPack),
    stageDone,
    score: built.score,
  }
  if (status) patch['status'] = status
  if (error !== undefined) patch['error'] = error
  await db.siteAnalysis.update({ where: { id: rowId }, data: patch })
}

export async function startSiteAnalysis(ideaId: string, rawUrl: string): Promise<SiteAnalysisItem> {
  const idea = await db.idea.findUnique({ where: { id: ideaId }, select: { id: true } })
  if (!idea) throw new SiteIntelError('NOT_FOUND', 'Idea not found')

  const seed = normalizeInputUrl(rawUrl)
  const reconResult = await collectRecon(seed)

  const data: SiteIntelData = {
    recon: reconResult.recon,
    evidence: reconResult.evidence,
    unknowns: reconResult.unknowns,
    pack: [],
  }
  const built = buildPack({ url: seed.toString(), domain: seed.hostname, stageDone: 1 }, data)
  data.pack = built.pack

  const row = await db.siteAnalysis.create({
    data: {
      ideaId,
      url: seed.toString(),
      domain: seed.hostname,
      status: 'running',
      stageDone: 1,
      score: built.score,
      data: JSON.stringify(data),
    },
  })

  await logDecision(ideaId, 'Site study started', `${seed.hostname} — recon complete (HTTP ${reconResult.recon.httpStatus}${reconResult.recon.blocked ? ', partially blocked' : ''})`)
  return serialize(row)
}

export async function advanceSiteAnalysis(ideaId: string, analysisId: string, lang: 'ar' | 'en'): Promise<SiteAnalysisItem> {
  const row = await db.siteAnalysis.findFirst({ where: { id: analysisId, ideaId } })
  if (!row) throw new SiteIntelError('NOT_FOUND', 'Analysis not found')
  if (row.status !== 'running') return serialize(row)
  if (row.stageDone >= SITE_INTEL_STAGES.length) return serialize(row)

  const data = parseData(row.data)
  const stage = SITE_INTEL_STAGES[row.stageDone]

  try {
    if (stage === 'surface') {
      if (!data.recon) throw new SiteIntelError('STAGE_FAILED', 'Recon data missing')
      const result = await collectSurface(data.recon)
      data.surface = result.surface
      // Handoff: asset URLs + inline scripts persist for the bundles stage
      data.assetJsUrls = result.jsUrls.slice(0, 30)
      data.assetCssUrls = result.cssUrls.slice(0, 15)
      data.inlineScriptsText = result.inlineScripts.slice(0, INLINE_SCRIPT_BUDGET)
      data.evidence.push(...result.evidence)
      data.unknowns.push(...result.unknowns)
      await persist(row.id, data, 2)
    } else if (stage === 'bundles') {
      if (!data.recon || !data.surface) throw new SiteIntelError('STAGE_FAILED', 'Surface data missing')
      const surfaceResult: SurfaceResult = {
        surface: data.surface,
        evidence: [],
        unknowns: [],
        jsUrls: data.assetJsUrls ?? [],
        cssUrls: data.assetCssUrls ?? [],
        inlineScripts: data.inlineScriptsText ?? '',
        homeHtml: '',
      }
      // Homepage HTML is needed for rendering-model + token context; one refetch
      try {
        const home = await politeFetch(data.recon.finalUrl, 'text/html,application/xhtml+xml')
        surfaceResult.homeHtml = home.body.slice(0, MAX_HTML_CHARS)
        if (!surfaceResult.inlineScripts) surfaceResult.inlineScripts = extractInlineScripts(surfaceResult.homeHtml)
      } catch {
        surfaceResult.homeHtml = ''
      }
      const result = await collectBundles(surfaceResult, surfaceResult.homeHtml)
      data.bundles = result.bundles
      data.mined = result.mined
      data.evidence.push(...result.evidence)
      data.unknowns.push(...result.unknowns)
      await persist(row.id, data, 3)
    } else if (stage === 'apis') {
      const result = await structureApis(data)
      data.apis = result.apis
      data.evidence.push(...result.evidence)
      data.unknowns.push(...result.unknowns)
      await persist(row.id, data, 4)
    } else if (stage === 'models') {
      const result = await structureModels(data)
      data.models = result.models
      data.evidence.push(...result.evidence)
      data.unknowns.push(...result.unknowns)
      await persist(row.id, data, 5)
    } else if (stage === 'audit') {
      const result = await structureAudit(data)
      data.audit = result.audit
      data.evidence.push(...result.evidence)
      data.unknowns.push(...result.unknowns)
      await persist(row.id, data, 6)
    } else if (stage === 'synthesis') {
      const cLine = await constitutionLine(ideaId)
      const result = await runSynthesis(data, lang, cLine)
      data.synthesis = result.synthesis
      data.evidence.push(...result.evidence)
      data.unknowns.push(...result.unknowns)
      await persist(row.id, data, 7, 'complete', null)

      const fresh = await db.siteAnalysis.findUnique({ where: { id: row.id } })
      await logDecision(
        ideaId,
        'Site study complete',
        `${row.domain} — 7/7 stages, completeness ${fresh?.score ?? 0}%, ${data.evidence.length} evidence entries, ${data.pack.length} pack files`
      )
      return serialize(fresh ?? row)
    }
  } catch (error) {
    const message = error instanceof Error ? error.message : 'unknown error'
    await persist(row.id, data, row.stageDone, 'failed', `${stage} stage failed: ${message}`)
    await logDecision(ideaId, 'Site study failed', `${row.domain} — ${stage} stage: ${message.slice(0, 140)}`)
    const fresh = await db.siteAnalysis.findUnique({ where: { id: row.id } })
    return serialize(fresh ?? row)
  }

  const fresh = await db.siteAnalysis.findUnique({ where: { id: row.id } })
  return serialize(fresh ?? row)
}

export async function getAnalysis(ideaId: string, analysisId: string): Promise<SiteAnalysisItem | null> {
  const row = await db.siteAnalysis.findFirst({ where: { id: analysisId, ideaId } })
  return row ? serialize(row) : null
}

export async function listAnalyses(ideaId: string): Promise<SiteAnalysisSummary[]> {
  const rows = await db.siteAnalysis.findMany({ where: { ideaId }, orderBy: { createdAt: 'desc' } })
  return rows.map((r) => {
    const data = parseData(r.data)
    return {
      id: r.id,
      url: r.url,
      domain: r.domain,
      status: r.status === 'complete' ? 'complete' : r.status === 'failed' ? 'failed' : 'running',
      stageDone: r.stageDone,
      score: r.score,
      pagesCrawled: data.surface?.pages.length ?? 0,
      createdAt: r.createdAt.toISOString(),
    }
  })
}

export async function deleteAnalysis(ideaId: string, analysisId: string): Promise<boolean> {
  const res = await db.siteAnalysis.deleteMany({ where: { id: analysisId, ideaId } })
  return res.count > 0
}
