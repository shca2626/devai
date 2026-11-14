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
  SiteMinedData,
  SiteModels,
  SitePageForm,
  SitePageInfo,
  SitePackFile,
  SiteRecon,
  SiteSurface,
  SiteSynthesis,
} from '@/lib/types'

// ============================================================
// Site Intelligence v2 — DEEP STATIC REVERSE ENGINEERING of a
// live web platform from a single URL.
//
// Discipline (non-negotiable, enforced in code not prompts):
//   1. PUBLIC READS ONLY — every request is an unauthenticated
//      GET (plus one standard GraphQL introspection query, which
//      is the API documenting itself). No credentials are ever
//      submitted, no forms are POSTed, nothing is created,
//      modified or deleted on the target. Login walls are mapped
//      and reported as architecture — never attempted.
//   2. NO CODE EXECUTION — the target's JavaScript is NEVER
//      executed. Bundles are downloaded and statically mined /
//      decompiled (source maps). Analysis, not interaction.
//   3. FULL DEPTH, HONEST EVIDENCE — no artificial shallow caps:
//      recursive sitemaps, pagination, well-known path probes,
//      chunk-graph discovery, source-map recovery, GraphQL
//      introspection, OpenAPI fetch, live JSON schema probes.
//      Every claim carries source + method + confidence; what
//      could not be determined lands in unknowns, never guessed.
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

const USER_AGENT =
  'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36'
const FETCH_TIMEOUT_MS = 15_000
const MAX_HTML_CHARS = 1_500_000 // 1.5MB of HTML per page
const MAX_ASSET_CHARS = 8_000_000 // 8MB of JS/CSS text per asset
const MAX_MAP_CHARS = 16_000_000 // 16MB per source map
const TOTAL_JS_BUDGET_CHARS = 110_000_000 // ~110MB of JS text per study
const MAX_PAGES = 180
const MAX_JS_ASSETS = 80
const MAX_CSS_ASSETS = 24
const CONCURRENCY = 6
const STAGGER_MS = 70
const SURFACE_TIME_BUDGET_MS = 150_000
const BUNDLES_TIME_BUDGET_MS = 150_000
const MAX_MINED_CALLS = 400
const INLINE_SCRIPT_BUDGET = 400_000 // chars of inline script text kept for API mining
const PAGINATION_PARAMS = new Set(['page', 'p', 'pg', 'offset', 'from', 'start', 'pagina'])
const MAX_PAGINATION_DEPTH = 12
const MAX_PRIVATE_CRAWL = 30 // robots-disallowed (still public) pages fetched, capped
const MAX_SITEMAPS_FETCHED = 25
const MAX_SITEMAP_URLS = 5000
const MAX_SOURCE_MAPS = 40
const MAX_MAP_TOTAL_CHARS = 80_000_000
const MAX_ENDPOINT_PROBES = 36
const MAX_RECOVERED_SAMPLE_FILES = 3

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

// ---------- HTTP layer: cookie jar + concurrency pool ----------

class CookieJar {
  private store = new Map<string, Map<string, string>>()

  private static hostKey(host: string): string {
    return host.toLowerCase().replace(/^www\./, '')
  }

  absorb(headers: Headers, host: string): void {
    let raws: string[] = []
    try {
      const anyHeaders = headers as Headers & { getSetCookie?: () => string[] }
      if (typeof anyHeaders.getSetCookie === 'function') raws = anyHeaders.getSetCookie()
    } catch {
      // undici without getSetCookie — fall through
    }
    if (raws.length === 0) {
      const single = headers.get('set-cookie')
      if (single) raws = [single]
    }
    if (raws.length === 0) return
    const key = CookieJar.hostKey(host)
    let bucket = this.store.get(key)
    if (!bucket) {
      bucket = new Map()
      this.store.set(key, bucket)
    }
    for (const raw of raws) {
      const pair = raw.split(';')[0]
      const eq = pair.indexOf('=')
      if (eq <= 0) continue
      const name = pair.slice(0, eq).trim()
      const value = pair.slice(eq + 1).trim()
      if (name && value) bucket.set(name, value)
    }
  }

  header(host: string): string | null {
    const bucket = this.store.get(CookieJar.hostKey(host))
    if (!bucket || bucket.size === 0) return null
    return [...bucket.entries()].map(([k, v]) => `${k}=${v}`).join('; ')
  }

  names(): string[] {
    const out = new Set<string>()
    for (const bucket of this.store.values()) for (const k of bucket.keys()) out.add(k)
    return [...out]
  }
}

const cookieJar = new CookieJar()

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

interface HttpOpts {
  maxChars?: number
  method?: 'GET' | 'POST'
  postBody?: string
  postContentType?: string
}

async function httpFetch(url: string, accept: string, opts: HttpOpts = {}): Promise<FetchedDoc> {
  const started = Date.now()
  const controller = new AbortController()
  const timer = setTimeout(() => controller.abort(), FETCH_TIMEOUT_MS)
  const maxChars = opts.maxChars ?? MAX_ASSET_CHARS
  try {
    let host = ''
    try {
      host = new URL(url).host
    } catch {
      throw new SiteIntelError('INVALID_URL', `Bad fetch URL: ${url.slice(0, 120)}`)
    }
    const headers: Record<string, string> = {
      'User-Agent': USER_AGENT,
      Accept: accept,
      'Accept-Language': 'en,ar;q=0.8',
    }
    const cookie = cookieJar.header(host)
    if (cookie) headers['Cookie'] = cookie
    if (opts.method === 'POST') {
      headers['Content-Type'] = opts.postContentType ?? 'application/json'
    }
    const res = await fetch(url, {
      method: opts.method ?? 'GET',
      redirect: 'follow',
      signal: controller.signal,
      headers,
      body: opts.method === 'POST' ? opts.postBody : undefined,
    })
    try {
      cookieJar.absorb(res.headers, new URL(res.url || url).host)
    } catch {
      // cookie absorb is best-effort
    }
    const outHeaders: Record<string, string> = {}
    res.headers.forEach((v, k) => {
      outHeaders[k.toLowerCase()] = v
    })
    const contentType = res.headers.get('content-type') ?? ''
    let body = ''
    let truncated = false
    if (contentType.includes('text/') || contentType.includes('javascript') || contentType.includes('json') || contentType.includes('xml') || contentType === '') {
      const raw = await res.text()
      if (raw.length > maxChars) {
        body = raw.slice(0, maxChars)
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
      headers: outHeaders,
      body,
      ms: Date.now() - started,
      truncated,
    }
  } finally {
    clearTimeout(timer)
  }
}

async function pool<T, R>(items: T[], limit: number, fn: (item: T, index: number) => Promise<R>): Promise<R[]> {
  const results: R[] = new Array(items.length)
  let cursor = 0
  let launched = 0
  const workers: Promise<void>[] = []
  const workerCount = Math.max(1, Math.min(limit, items.length))
  for (let w = 0; w < workerCount; w++) {
    workers.push(
      (async () => {
        for (;;) {
          const i = cursor++
          if (i >= items.length) return
          const myIndex = launched++
          if (myIndex > 0) await sleep(STAGGER_MS)
          results[i] = await fn(items[i], i)
        }
      })()
    )
  }
  await Promise.all(workers)
  return results
}

// ---------- robots.txt (parsed: sitemaps + declared-private map) ----------

interface RobotsInfo {
  found: boolean
  sitemaps: string[]
  disallows: string[]
}

function parseRobots(body: string): RobotsInfo {
  const sitemaps: string[] = []
  const disallows: string[] = []
  let appliesToUs = true // we read the '*' group (and any group — robots is advisory intel here)
  for (const rawLine of body.split(/\r?\n/)) {
    const line = rawLine.split('#')[0].trim()
    if (!line) continue
    const colon = line.indexOf(':')
    if (colon === -1) continue
    const field = line.slice(0, colon).trim().toLowerCase()
    const value = line.slice(colon + 1).trim()
    if (field === 'user-agent') {
      appliesToUs = value === '*' || value.toLowerCase().includes('siteintel')
    } else if (field === 'sitemap' && value) {
      sitemaps.push(value)
    } else if (field === 'disallow' && appliesToUs && value && value !== '') {
      disallows.push(value)
    }
  }
  return { found: body.trim().length > 0, sitemaps, disallows: [...new Set(disallows)] }
}

function robotsDisallowsPath(url: URL, robots: RobotsInfo): boolean {
  for (const rule of robots.disallows) {
    const prefix = rule.replace(/\*.*$/, '')
    if (prefix && prefix !== '/' && url.pathname.startsWith(prefix)) return true
    if (rule === '/') return true
  }
  return false
}

// ---------- URL triage ----------

const SKIP_EXT = /\.(png|jpe?g|gif|svg|webp|avif|ico|css|js|mjs|map|woff2?|ttf|otf|eot|mp4|webm|mov|mp3|wav|pdf|zip|gz|tgz|rar|7z|dmg|exe|apk|xml|rss|txt|csv|webmanifest|manifest)$/i

function isCrawlablePage(url: URL): boolean {
  if (url.protocol !== 'http:' && url.protocol !== 'https:') return false
  if (SKIP_EXT.test(url.pathname)) return false
  return true
}

function sameOrigin(a: URL, b: URL): boolean {
  return a.protocol === b.protocol && a.host === b.host
}

function toRoutePattern(pathname: string, queryKeys: string[] = []): string {
  const segments = pathname.split('/').map((seg) => {
    if (/^\d+$/.test(seg)) return ':id'
    if (/^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$/i.test(seg)) return ':uuid'
    if (/^[a-f0-9]{16,}$/i.test(seg)) return ':hash'
    if (/^[a-z][a-z0-9]*-\d+$/i.test(seg)) return ':slug'
    return seg
  })
  let pattern = segments.join('/') || '/'
  const meaningfulQuery = queryKeys.filter((k) => !PAGINATION_PARAMS.has(k.toLowerCase()))
  if (meaningfulQuery.length > 0) pattern += `{?${meaningfulQuery.sort().join(',')}}`
  return pattern
}

// Canonical crawl key: drop hash; keep pagination params (bounded), drop the rest
function canonicalKey(url: URL): string {
  const u = new URL(url.toString())
  u.hash = ''
  const kept = new URLSearchParams()
  let page = 0
  for (const [k, v] of u.searchParams) {
    if (PAGINATION_PARAMS.has(k.toLowerCase()) && /^\d+$/.test(v)) {
      page = Math.max(page, parseInt(v, 10))
      kept.set(k, v)
    }
  }
  u.search = kept.toString()
  if (page > MAX_PAGINATION_DEPTH) return `${u.toString()}#cap` // never actually crawled
  return u.toString()
}

function paginationNumber(url: URL): number {
  for (const [k, v] of url.searchParams) {
    if (PAGINATION_PARAMS.has(k.toLowerCase()) && /^\d+$/.test(v)) return parseInt(v, 10)
  }
  return 0
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

// <link rel="preload/modulepreload/prefetch" as="script"|"style" href=...> — SPA chunk entry points
function extractPreloadHrefs(html: string): { js: string[]; css: string[] } {
  const js: string[] = []
  const css: string[] = []
  const re = /<link\s[^>]*>/gi
  let tag: RegExpExecArray | null
  while ((tag = re.exec(html))) {
    const t = tag[0]
    const rel = (matchAttr(t, 'rel') ?? '').toLowerCase()
    if (!rel.includes('preload') && !rel.includes('prefetch') && !rel.includes('modulepreload')) continue
    const href = matchAttr(t, 'href')
    if (!href) continue
    const as = (matchAttr(t, 'as') ?? '').toLowerCase()
    if (as === 'script' || /\.m?js$/i.test(href) || rel.includes('modulepreload')) js.push(href)
    else if (as === 'style' || /\.css$/i.test(href)) css.push(href)
  }
  return { js, css }
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
  const re = /<form\s[^>]*>([\s\S]*?)<\/form>/gi
  let m: RegExpExecArray | null
  while ((m = re.exec(html)) && forms.length < 20) {
    const open = m[0].slice(0, m[0].indexOf('>'))
    const inner = m[1]
    const fields: { name: string; type: string; required: boolean }[] = []
    const fieldRe = /<(?:input|select|textarea)\b[^>]*>/gi
    let f: RegExpExecArray | null
    while ((f = fieldRe.exec(inner)) && fields.length < 25) {
      const tagText = f[0]
      const name = matchAttr(tagText, 'name') ?? matchAttr(tagText, 'id')
      if (!name) continue
      const type = (matchAttr(tagText, 'type') ?? tagText.match(/^<(input|select|textarea)/i)?.[1] ?? 'text').toLowerCase()
      if (type === 'hidden') continue
      const required = /\brequired\b/i.test(tagText)
      fields.push({ name: name.slice(0, 60), type, required })
    }
    forms.push({
      action: matchAttr(open, 'action') ?? '',
      method: (matchAttr(open, 'method') ?? 'GET').toUpperCase(),
      fields,
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
  let budget = 120_000
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

// __NEXT_DATA__ — page, buildId and the props keys the server shipped
function extractNextData(html: string): { page: string; buildId: string; propsKeys: string[] } | null {
  const m = html.match(/<script[^>]*id=["']__NEXT_DATA__["'][^>]*>([\s\S]*?)<\/script>/i)
  if (!m) return null
  try {
    const parsed = JSON.parse(m[1].trim()) as Record<string, unknown>
    const page = typeof parsed['page'] === 'string' ? (parsed['page'] as string) : ''
    const buildId = typeof parsed['buildId'] === 'string' ? (parsed['buildId'] as string) : ''
    const props = parsed['props'] as Record<string, unknown> | undefined
    const pageProps = props && typeof props['pageProps'] === 'object' && props['pageProps'] ? (props['pageProps'] as Record<string, unknown>) : {}
    const propsKeys = Object.keys(pageProps).slice(0, 20)
    if (!page && !buildId && propsKeys.length === 0) return null
    return { page, buildId, propsKeys }
  } catch {
    return null
  }
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
  { name: 'SolidJS', re: /solid-js|_\$DX_DELEGATE/ },
  { name: 'Qwik', re: /qwik(?:-city)?|\$ Signal/ },
  { name: 'Alpine.js', re: /x-data=|alpinejs/ },
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
  { name: 'urql', re: /urql|createClient.*exchanges/ },
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
  { name: 'React Hook Form', re: /react-hook-form|useForm/ },
  { name: 'SWR', re: /useSWR|swr\/dist/ },
  { name: 'Contentful', re: /contentful|cdn\.contentful\.com/ },
  { name: 'Sanity', re: /sanity\.io|sanityClient/ },
  { name: 'Algolia', re: /algolianet|algoliasearch/ },
  { name: 'Intercom', re: /intercom/ },
  { name: 'Amplitude', re: /amplitude\.com|amplitude-js/ },
  { name: 'Segment', re: /segment\.(?:io|com)|analytics\.track/ },
  { name: 'PayPal', re: /paypal\.com|paypal\.sdk/ },
  { name: 'Recharts', re: /recharts|ResponsiveContainer/ },
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
  { name: 'Sentry DSN', re: /https:\/\/[0-9a-f]{32}@[a-z0-9.]+\/\d+/ },
  { name: 'Supabase service key', re: /sb_(?:secret|service)[0-9a-zA-Z_-]{20,}/ },
  { name: 'Firebase config (full)', re: /apiKey\s*:\s*["'][A-Za-z0-9_-]{30,}["']/ },
  { name: 'Algolia admin key', re: /ALGOLIA_ADMIN_KEY[0-9a-zA-Z]{10,}/ },
  { name: 'Mapbox token', re: /pk\.eyJ1\.[0-9A-Za-z._-]{40,}/ },
  { name: 'Twilio credentials', re: /SK[0-9a-f]{32}:[0-9A-Za-z]{32}/ },
  { name: 'npm token', re: /npm_[0-9A-Za-z]{30,}/ },
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
    /path:\s*["'`]([^"'`\s]{1,120})["'`]/g, // React Router / Vue Router route defs
    /route\s*\(\s*["'`]([^"'`\s]{1,120})["'`]/g,
    /["'`](\/(?:api|v1|v2|v3|graphql|auth|admin|api\/v[0-9])\/[a-zA-Z0-9/_-]{1,80})["'`]/g,
    /href\s*:\s*["'`](\/[a-zA-Z0-9/_-]{1,80})["'`]/g, // Next.js Link href objects
    /to\s*:\s*["'`](\/[a-zA-Z0-9/_-]{1,80})["'`]/g,
    /navigate\s*\(\s*["'`]([^"'`\s]{1,80})["'`]/g,
    /router\.(?:push|replace)\s*\(\s*["'`]([^"'`\s]{1,80})["'`]/g,
  ]
  for (const { text } of texts) {
    for (const re of patterns) {
      let m: RegExpExecArray | null
      while ((m = re.exec(text)) && routes.size < 300) {
        const route = m[1]
        if (route.startsWith('/') && !route.startsWith('//')) routes.add(route)
      }
    }
  }
  return [...routes].slice(0, 300)
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
  return url.replace(/\$\{[^}]+\}/g, ':param').replace(/\s*\+\s*\w+/g, ':param').replace(/["'`]\s*\+\s*[\w.]+/g, ':param')
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
    let m: RegExpExecArray | null
    // fetch("…", { method: "POST" }) — method resolved from a small window after the URL
    const fetchRe = /fetch\(\s*[`'"]([^`'"\s]{3,240})[`'"]([^;]{0,160})/g
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
    const axiosRe = /axios\s*[.(]\s*(?:(get|post|put|patch|delete)\s*\(\s*[`'"]([^`'"\s]{3,240})[`'"]|url\s*:\s*[`'"]([^`'"\s]{3,240})[`'"])/gi
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
    const xhrRe = /\.open\(\s*["'](GET|POST|PUT|PATCH|DELETE|HEAD)["']\s*,\s*[`'"]([^`'"\s]{3,240})[`'"]/g
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
    const wsRe = /new\s+WebSocket\(\s*[`'"]([^`'"\s]{3,240})[`'"]/g
    while ((m = wsRe.exec(text))) {
      push({ method: 'WS', url: templateToParam(m[1]), kind: 'ws', snippet: `new WebSocket("${m[1].slice(0, 120)}")`, file })
    }
    // Server-Sent Events
    const sseRe = /new\s+EventSource\(\s*[`'"]([^`'"\s]{3,240})[`'"]/g
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

// Public client config (NEXT_PUBLIC_*, injected env values) — configuration, not secrets
function mineEnvVars(texts: { file: string; text: string }[]): { key: string; value: string }[] {
  const out = new Map<string, string>()
  const patterns = [
    /NEXT_PUBLIC_([A-Z0-9_]+)\s*[:=]\s*["'`]([^"'`]{1,160})["'`]/g,
    /["'`](NEXT_PUBLIC_[A-Z0-9_]+)["'`]\s*:\s*["'`]([^"'`]{1,160})["'`]/g,
    /REACT_APP_([A-Z0-9_]+)\s*[:=]\s*["'`]([^"'`]{1,160})["'`]/g,
    /VITE_([A-Z0-9_]+)\s*[:=]\s*["'`]([^"'`]{1,160})["'`]/g,
    /(apiBaseUrl|API_BASE_URL|apiUrl|API_URL|baseUrl|BASE_URL|apiEndpoint)\s*[:=]\s*["'`](https?:\/\/[^"'`]{3,160})["'`]/g,
  ]
  for (const { text } of texts) {
    for (const re of patterns) {
      let m: RegExpExecArray | null
      while ((m = re.exec(text)) && out.size < 60) {
        if (!out.has(m[1])) out.set(m[1], m[2].slice(0, 160))
      }
    }
  }
  return [...out.entries()].map(([key, value]) => ({ key, value })).slice(0, 60)
}

// i18n string tables — internal feature names leak through translation keys
function mineI18n(texts: { file: string; text: string }[]): { keys: number; samples: string[]; locales: string[] } {
  const keys = new Set<string>()
  const locales = new Set<string>()
  // i18next resources: "en": { "translation": { "key": "value" } } and t("key")
  const resRe = /["']([a-z]{2}(?:[-_][A-Za-z]{2})?)["']\s*:\s*\{[^{}]{0,80}?\{/g
  for (const { text } of texts) {
    let m: RegExpExecArray | null
    while ((m = resRe.exec(text)) && locales.size < 24) locales.add(m[1])
    const tRe = /(?:\bi18n?\.t|\bt)\(\s*["']([a-zA-Z0-9_.:\- ]{2,60})["']/g
    while ((m = tRe.exec(text)) && keys.size < 800) {
      const k = m[1]
      if (k.includes(' ') || k.includes('.') || k.includes(':')) keys.add(k)
    }
  }
  return { keys: keys.size, samples: [...keys].slice(0, 120), locales: [...locales] }
}

function mineStorageKeys(texts: { file: string; text: string }[]): string[] {
  const keys = new Set<string>()
  for (const { text } of texts) {
    const re = /(?:localStorage|sessionStorage)\.(?:getItem|setItem|removeItem)\(\s*["'`]([^"'`]{2,80})["'`]/g
    let m: RegExpExecArray | null
    while ((m = re.exec(text)) && keys.size < 120) keys.add(m[1])
  }
  return [...keys]
}

function mineThirdPartyDomains(texts: { file: string; text: string }[]): string[] {
  const domains = new Set<string>()
  const re = /https?:\/\/([a-z0-9](?:[a-z0-9-]*[a-z0-9])?(?:\.[a-z]{2,})+)/gi
  for (const { text } of texts) {
    let m: RegExpExecArray | null
    while ((m = re.exec(text)) && domains.size < 200) domains.add(m[1].toLowerCase())
  }
  return [...domains]
}

// Chunk graph: every static chunk URL referenced in fetched JS / HTML
function extractChunkUrls(origin: URL, texts: { file: string; text: string }[]): string[] {
  const urls = new Set<string>()
  const patterns = [
    /["'`]((?:https?:\/\/[^"'`\s]+)?\/_next\/static\/(?:chunks|css|media)\/[A-Za-z0-9._/-]+?\.(?:js|css))["'`]/g,
    /["'`](static\/(?:chunks|css|media)\/[A-Za-z0-9._/-]+?\.(?:js|css))["'`]/g,
    /["'`]((?:https?:\/\/[^"'`\s]+)?\/(?:assets|js|dist|_assets|static)\/[A-Za-z0-9._-]+?\.(?:js|css))["'`]/g,
  ]
  for (const { text } of texts) {
    for (const re of patterns) {
      let m: RegExpExecArray | null
      while ((m = re.exec(text)) && urls.size < 400) {
        try {
          const raw = m[1].startsWith('http') ? m[1] : new URL(m[1], origin).toString()
          urls.add(raw)
        } catch {
          // skip malformed
        }
      }
    }
  }
  return [...urls]
}

// Next.js _buildManifest.js — the framework's own route table
function parseBuildManifestPages(text: string): string[] {
  const pages = new Set<string>()
  // routes look like: "/about":["static/chunks/..."] or keys of __BUILD_MANIFEST
  const re = /["'](\/[a-zA-Z0-9/_.:-]*)["']\s*:\s*\[/g
  let m: RegExpExecArray | null
  while ((m = re.exec(text)) && pages.size < 400) {
    const p = m[1]
    if (p.startsWith('/_next') || p.startsWith('/api/_next')) continue
    if (!/^\/[a-zA-Z0-9/_.:-]*$/.test(p)) continue
    pages.add(p)
  }
  return [...pages]
}

// ============================================================
// Deep collectors — sitemap recursion, well-known probes,
// concurrent crawl, chunk graph, source maps, live schema probes.
// ============================================================

function detectBlocked(doc: FetchedDoc): { blocked: boolean; reason: string | null } {
  if ([403, 429, 503].includes(doc.status)) {
    return { blocked: true, reason: `HTTP ${doc.status} — the site refused our client` }
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

// ---------- Sitemap: recursive index traversal ----------

async function collectSitemapUrls(origin: URL, robots: RobotsInfo): Promise<{ urls: string[]; sitemapsFetched: number }> {
  const found: string[] = []
  const seenSitemaps = new Set<string>()
  let fetched = 0

  const queue: string[] = [...robots.sitemaps]
  const guesses = ['/sitemap.xml', '/sitemap_index.xml', '/sitemap-index.xml', '/sitemap1.xml']
  for (const g of guesses) {
    try {
      queue.push(new URL(g, origin).toString())
    } catch {
      // skip
    }
  }

  while (queue.length > 0 && fetched < MAX_SITEMAPS_FETCHED && found.length < MAX_SITEMAP_URLS) {
    const current = queue.shift() as string
    if (seenSitemaps.has(current)) continue
    seenSitemaps.add(current)
    let doc: FetchedDoc
    try {
      doc = await httpFetch(current, 'application/xml,text/xml', { maxChars: 4_000_000 })
    } catch {
      continue
    }
    if (doc.status !== 200 || !doc.body.includes('<loc>')) continue
    fetched++
    const locs = [...doc.body.matchAll(/<loc>\s*([^<\s]+)\s*<\/loc>/g)].map((m) => m[1].trim())
    const isIndex = /<sitemapindex/i.test(doc.body) || doc.body.includes('<sitemap>')
    for (const loc of locs) {
      if (found.length >= MAX_SITEMAP_URLS) break
      if (isIndex && /\.xml(?:\.gz)?$/i.test(loc)) {
        if (!seenSitemaps.has(loc)) queue.push(loc)
        continue
      }
      try {
        const u = new URL(loc)
        if (sameOrigin(u, origin) && isCrawlablePage(u)) found.push(canonicalKey(u))
      } catch {
        // malformed loc
      }
    }
  }
  return { urls: [...new Set(found)], sitemapsFetched: fetched }
}

// ---------- Well-known path probes (public GET only) ----------

const PROBE_PATHS = [
  '/api',
  '/api/v1',
  '/api/v2',
  '/api/health',
  '/api/status',
  '/health',
  '/healthz',
  '/status',
  '/admin',
  '/admin/login',
  '/login',
  '/signin',
  '/signup',
  '/register',
  '/dashboard',
  '/account',
  '/graphql',
  '/graphiql',
  '/swagger',
  '/swagger.json',
  '/swagger/v1/swagger.json',
  '/openapi.json',
  '/api/openapi.json',
  '/api-docs',
  '/api/docs',
  '/docs',
  '/wp-json',
  '/actuator',
  '/manifest.json',
  '/.well-known/security.txt',
  '/.well-known/openid-configuration',
  '/humans.txt',
  '/ads.txt',
]

interface ProbeResult {
  path: string
  status: number
  note: string
  isJson: boolean
  isHtml: boolean
  openApiCandidate: boolean
}

async function probeWellKnown(origin: URL): Promise<ProbeResult[]> {
  const results: ProbeResult[] = []
  await pool(PROBE_PATHS, CONCURRENCY, async (path) => {
    const url = new URL(path, origin).toString()
    let doc: FetchedDoc
    try {
      doc = await httpFetch(url, 'text/html,application/json,*/*', { maxChars: 400_000 })
    } catch {
      return
    }
    const isJson = doc.contentType.includes('json') || /^\s*[[{]"?/.test(doc.body.slice(0, 64))
    const isHtml = doc.contentType.includes('html')
    let note = ''
    if (doc.status === 200 && isJson) {
      const looksOpenApi = /"(?:openapi|swagger)"\s*:/.test(doc.body.slice(0, 4000))
      note = looksOpenApi ? 'JSON — OpenAPI/Swagger spec' : 'JSON response'
    } else if (doc.status === 200 && isHtml) {
      const title = extractTitle(doc.body) ?? ''
      note = `HTML${title ? ` — ${title.slice(0, 60)}` : ''}`
    } else if (doc.status === 301 || doc.status === 302 || doc.status === 308) {
      note = `redirect → ${doc.headers['location']?.slice(0, 90) ?? '?'}`
    } else if (doc.status === 401 || doc.status === 403) {
      note = 'exists but gated (auth required) — mapped, not accessed'
    } else if (doc.status === 404 || doc.status === 410) {
      note = 'not found'
    } else {
      note = `status ${doc.status}`
    }
    const looksOpenApi =
      doc.status === 200 && isJson && /"(?:openapi|swagger)"\s*:/.test(doc.body.slice(0, 4000))
    results.push({ path, status: doc.status, note, isJson, isHtml, openApiCandidate: looksOpenApi })
  })
  return results.sort((a, b) => a.path.localeCompare(b.path))
}

// ---------- Stage 1: recon — entry page, robots, recursive sitemaps ----------

interface ReconResult {
  recon: SiteRecon
  evidence: SiteEvidence[]
  unknowns: string[]
  sitemapSeeds: string[]
}

async function collectRecon(seed: URL): Promise<ReconResult> {
  const evidence: SiteEvidence[] = []
  const unknowns: string[] = []

  let home: FetchedDoc
  try {
    home = await httpFetch(seed.toString(), 'text/html,application/xhtml+xml', { maxChars: MAX_HTML_CHARS })
  } catch {
    throw new SiteIntelError('UNREACHABLE', 'The site could not be reached (network error or timeout).')
  }

  const html = home.body.slice(0, MAX_HTML_CHARS)
  const blockedInfo = detectBlocked(home)

  // robots.txt — sitemaps + declared-private map (intel either way)
  let robots: RobotsInfo = { found: false, sitemaps: [], disallows: [] }
  try {
    const robotsUrl = new URL('/robots.txt', home.finalUrl).toString()
    const robotsDoc = await httpFetch(robotsUrl, 'text/plain', { maxChars: 400_000 })
    if (robotsDoc.status === 200) robots = parseRobots(robotsDoc.body.slice(0, 200_000))
  } catch {
    unknowns.push('robots.txt could not be fetched — crawl proceeded with default politeness only')
  }

  // Recursive sitemap traversal — full URL enumeration, not a count
  const origin = new URL(home.finalUrl)
  const sitemap = await collectSitemapUrls(origin, robots)
  if (sitemap.urls.length === 0) {
    unknowns.push('no sitemap URLs could be enumerated — surface map relies on link crawling only')
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
      method: 'HTTP GET with browser-grade client (cookies carried)',
      confidence: 'high',
    },
    {
      claim: `robots.txt ${robots.found ? `found — ${robots.disallows.length} disallow rules, ${robots.sitemaps.length} declared sitemaps` : 'not found'}`,
      source: new URL('/robots.txt', home.finalUrl).toString(),
      method: 'robots.txt parse (all groups read as advisory intel)',
      confidence: 'high',
    }
  )
  if (sitemap.sitemapsFetched > 0) {
    evidence.push({
      claim: `${sitemap.urls.length} URLs enumerated from ${sitemap.sitemapsFetched} sitemap document(s) (recursive index traversal)`,
      source: robots.sitemaps[0] ?? '/sitemap.xml',
      method: 'recursive sitemap-index fetch + <loc> extraction',
      confidence: 'high',
    })
  }
  if (robots.disallows.length > 0) {
    evidence.push({
      claim: `${robots.disallows.length} declared-private areas in robots.txt: ${robots.disallows.slice(0, 10).join(', ')}${robots.disallows.length > 10 ? '…' : ''}`,
      source: '/robots.txt',
      method: 'Disallow rule map (advisory file — these routes are still publicly served; recorded as private-area intel)',
      confidence: 'high',
    })
  }
  if (title) {
    evidence.push({ claim: `Site title: ${title}`, source: home.finalUrl, method: '<title> extraction', confidence: 'high' })
  }
  if (blockedInfo.blocked) {
    unknowns.push(`The site is partially blocked to clients: ${blockedInfo.reason}. Deeper pages may be unavailable — the study reports what was reachable, honestly.`)
  }
  if (home.status >= 400) {
    throw new SiteIntelError('UNREACHABLE', `The site responded with HTTP ${home.status}.`)
  }

  return { recon, evidence, unknowns, sitemapSeeds: sitemap.urls.slice(0, 1200) }
}

// ---------- Stage 2: surface — concurrent crawl, probes, pagination ----------

interface SurfaceResult {
  surface: SiteSurface
  evidence: SiteEvidence[]
  unknowns: string[]
  jsUrls: string[]
  cssUrls: string[]
  inlineScripts: string
  homeHtml: string
  openApiCandidates: string[]
}

function pageFromDoc(doc: FetchedDoc, url: string): SitePageInfo {
  const html = doc.body.slice(0, MAX_HTML_CHARS)
  const imgs = countImages(html)
  const jsonLdTypes = extractJsonLdTypes(html)
  const nextData = extractNextData(html)
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
    ...(nextData ? { nextData: { page: nextData.page, propsKeys: nextData.propsKeys } } : {}),
  }
}

async function collectSurface(recon: SiteRecon, sitemapSeeds: string[]): Promise<SurfaceResult> {
  const evidence: SiteEvidence[] = []
  const unknowns: string[] = []
  const origin = new URL(recon.finalUrl)
  const robots = recon.robots
  const startedAt = Date.now()

  const queue: string[] = [origin.toString()]
  const visited = new Set<string>()
  const pages: SitePageInfo[] = []
  const patterns = new Set<string>()
  const failedPages: string[] = []
  const jsUrls: string[] = []
  const cssUrls: string[] = []
  let inlineScripts = ''
  let homeHtml = ''
  let crawledPrivate = 0
  let timeCapHit = false
  let buildId = ''

  // Well-known probes — admin areas, API roots, docs, oidc config
  const probes = await probeWellKnown(origin)
  const openApiCandidates: string[] = []
  for (const p of probes) {
    if (p.openApiCandidate) openApiCandidates.push(new URL(p.path, origin).toString())
    if ((p.status === 200 || p.status === 301 || p.status === 302 || p.status === 308) && p.isHtml) {
      try {
        const u = new URL(p.path, origin)
        const key = canonicalKey(u)
        if (!visited.has(key)) queue.push(key)
      } catch {
        // skip
      }
    }
  }

  // Sitemap URLs join the queue after link discovery (BFS first, breadth later)
  const sitemapQueue: string[] = []
  for (const loc of sitemapSeeds) {
    if (!visited.has(loc) && !queue.includes(loc)) sitemapQueue.push(loc)
  }

  const crawlOne = async (normalized: string): Promise<void> => {
    const url = new URL(normalized)
    const privateArea = robotsDisallowsPath(url, robots)
    if (privateArea && crawledPrivate >= MAX_PRIVATE_CRAWL) return

    let doc: FetchedDoc
    try {
      doc = await httpFetch(normalized, 'text/html,application/xhtml+xml', { maxChars: MAX_HTML_CHARS })
    } catch {
      failedPages.push(normalized)
      return
    }
    if (doc.status >= 400) {
      failedPages.push(normalized)
      return
    }

    const html = doc.body.slice(0, MAX_HTML_CHARS)
    if (pages.length === 0) homeHtml = html
    pages.push(pageFromDoc(doc, normalized))
    patterns.add(toRoutePattern(url.pathname, [...url.searchParams.keys()]))
    if (privateArea) crawledPrivate++

    const nextData = extractNextData(html)
    if (nextData?.buildId) buildId = nextData.buildId

    // Collect assets for the bundles stage — script tags + preload/modulepreload
    for (const src of extractScriptSrcs(html)) {
      try {
        const asset = new URL(src, normalized)
        if (sameOrigin(asset, origin) || /\.(?:min\.)?m?js$/i.test(asset.pathname)) {
          if (!jsUrls.includes(asset.toString())) jsUrls.push(asset.toString())
        }
      } catch {
        // malformed src
      }
    }
    const preloads = extractPreloadHrefs(html)
    for (const src of preloads.js) {
      try {
        const asset = new URL(src, normalized)
        if (!jsUrls.includes(asset.toString())) jsUrls.push(asset.toString())
      } catch {
        // skip
      }
    }
    for (const href of [...extractStylesheetHrefs(html), ...preloads.css]) {
      try {
        const asset = new URL(href, normalized)
        if (!cssUrls.includes(asset.toString())) cssUrls.push(asset.toString())
      } catch {
        // skip
      }
    }

    if (inlineScripts.length < INLINE_SCRIPT_BUDGET) {
      inlineScripts += `${extractInlineScripts(html)}\n;\n`
    }

    // Enqueue same-origin links (including ?page=N pagination, bounded)
    for (const href of extractLinks(html)) {
      if (queue.length + sitemapQueue.length > 900) break
      try {
        const next = new URL(href, normalized)
        next.hash = ''
        if (!sameOrigin(next, origin)) continue
        if (!isCrawlablePage(next)) continue
        if (paginationNumber(next) > MAX_PAGINATION_DEPTH) continue
        const key = canonicalKey(next)
        if (key.endsWith('#cap')) continue
        if (!visited.has(key) && !queue.includes(key) && !sitemapQueue.includes(key)) queue.push(key)
      } catch {
        // skip malformed
      }
    }
  }

  // Concurrent BFS — pull from queue, top up from sitemap extras when links run dry
  while ((queue.length > 0 || sitemapQueue.length > 0) && pages.length < MAX_PAGES) {
    if (Date.now() - startedAt > SURFACE_TIME_BUDGET_MS) {
      timeCapHit = true
      break
    }
    const batch: string[] = []
    while (batch.length < CONCURRENCY && pages.length + batch.length < MAX_PAGES) {
      let next = queue.shift()
      if (!next) next = sitemapQueue.shift()
      if (!next) break
      let normalized: string
      try {
        const u = new URL(next)
        normalized = canonicalKey(u)
      } catch {
        continue
      }
      if (normalized.endsWith('#cap') || visited.has(normalized)) continue
      if (!sameOrigin(new URL(normalized), origin) || !isCrawlablePage(new URL(normalized))) continue
      visited.add(normalized)
      batch.push(normalized)
    }
    if (batch.length === 0) break
    await pool(batch, batch.length, crawlOne)
  }

  const sitemapUrls = sitemapSeeds.length
  evidence.push(
    {
      claim: `${pages.length} pages studied across ${patterns.size} route patterns${crawledPrivate > 0 ? ` (incl. ${crawledPrivate} robots-declared-private pages, still publicly served)` : ''}`,
      source: 'crawled URLs',
      method: `same-origin BFS + pagination follow + recursive sitemap + ${PROBE_PATHS.length} well-known path probes — concurrent, browser-grade client`,
      confidence: 'high',
    },
    {
      claim: `${patterns.size} route patterns: ${[...patterns].slice(0, 12).join(', ')}${patterns.size > 12 ? '…' : ''}`,
      source: 'crawled URLs',
      method: 'path segmentation (numeric/uuid/hash segments → :id) + meaningful query keys',
      confidence: 'medium',
    }
  )
  const gatedFindings = probes.filter((p) => p.status === 401 || p.status === 403)
  if (probes.length > 0) {
    const alive = probes.filter((p) => p.status !== 404 && p.status !== 410 && p.status !== 0)
    evidence.push({
      claim: `${alive.length}/${probes.length} well-known paths exist (admin/api/docs/oidc): ${alive.slice(0, 10).map((p) => `${p.path}(${p.status})`).join(', ')}${alive.length > 10 ? '…' : ''}`,
      source: 'well-known path probe',
      method: 'public GET on conventional platform paths; gated areas recorded, never accessed',
      confidence: 'high',
    })
  }
  if (gatedFindings.length > 0) {
    evidence.push({
      claim: `Auth-gated areas exist at: ${gatedFindings.map((p) => p.path).join(', ')} — mapped as login architecture, not accessed`,
      source: 'well-known path probe',
      method: 'HTTP 401/403 responses',
      confidence: 'high',
    })
  }
  if (timeCapHit) {
    unknowns.push(`Crawl stopped at the ${Math.round(SURFACE_TIME_BUDGET_MS / 1000)}s time budget with more URLs queued — the platform has more routes than listed`)
  } else if (pages.length >= MAX_PAGES) {
    unknowns.push(`Crawl stopped at the ${MAX_PAGES}-page cap — the platform likely has more routes than listed`)
  }
  if (failedPages.length > 0) {
    unknowns.push(`${failedPages.length} linked pages failed to load: ${failedPages.slice(0, 5).join(', ')}`)
  }

  const surface: SiteSurface = {
    pages,
    routePatterns: [...patterns].sort(),
    sitemapUrls,
    skippedByRobots: 0,
    failedPages: failedPages.slice(0, 30),
    privateAreas: robots.disallows,
    probedPaths: probes.map(({ path, status, note }) => ({ path, status, note })),
    crawledPrivate,
  }
  return { surface, evidence, unknowns, jsUrls, cssUrls, inlineScripts, homeHtml, openApiCandidates }
}

// ---------- Source maps: recovering the original frontend source ----------

interface RecoveredMap {
  mapFile: string
  sources: number
  tree: string[]
  kb: number
  recoveredText: string // concatenated sourcesContent (bounded)
  sampleFiles: { path: string; kb: number }[]
}

function treeFromSources(sources: string[], cap = 80): string[] {
  const dirs = new Set<string>()
  for (const s of sources) {
    const clean = s.replace(/^webpack:\/\//, '').replace(/^\.\//, '')
    const parts = clean.split('/')
    if (parts.length > 1) parts.pop()
    const dir = parts.join('/')
    if (dir && dir !== '.' && !dir.startsWith('node_modules')) dirs.add(dir)
    if (dirs.size >= cap) break
  }
  return [...dirs].sort()
}

async function recoverSourceMaps(jsAssets: { url: string; sizeKb: number }[], declaredMapUrls: Map<string, string | null>): Promise<{ recovered: RecoveredMap[]; sourceMapFiles: { file: string; recovered: boolean; sources: number }[]; modelDefs: { name: string; kind: string; snippet: string; file: string }[]; totalKb: number; budgetCapHit: boolean }> {
  const mapUrls = new Set<string>()
  const addMapUrl = (jsUrl: string, declared: string | null) => {
    try {
      if (declared) {
        mapUrls.add(new URL(declared, jsUrl).toString())
      } else {
        mapUrls.add(`${jsUrl}.map`)
      }
    } catch {
      // skip
    }
  }

  for (const [url, declared] of declaredMapUrls) addMapUrl(url, declared)

  const recovered: RecoveredMap[] = []
  const sourceMapFiles: { file: string; recovered: boolean; sources: number }[] = []
  const modelDefs: { name: string; kind: string; snippet: string; file: string }[] = []
  const seenDefKeys = new Set<string>()
  let totalChars = 0
  let budgetCapHit = false

  await pool([...mapUrls].slice(0, MAX_SOURCE_MAPS + 12), CONCURRENCY, async (mapUrl) => {
    if (recovered.length >= MAX_SOURCE_MAPS || totalChars >= MAX_MAP_TOTAL_CHARS) {
      budgetCapHit = true
      return
    }
    let doc: FetchedDoc
    try {
      doc = await httpFetch(mapUrl, 'application/json', { maxChars: MAX_MAP_CHARS })
    } catch {
      return
    }
    if (doc.status !== 200 || !doc.body.trimStart().startsWith('{')) return
    let parsed: { sources?: unknown; sourcesContent?: unknown }
    try {
      parsed = JSON.parse(doc.body) as { sources?: unknown; sourcesContent?: unknown }
    } catch {
      sourceMapFiles.push({ file: mapUrl.split('/').pop() ?? mapUrl, recovered: false, sources: 0 })
      return
    }
    const sources = Array.isArray(parsed.sources) ? (parsed.sources as string[]) : []
    const contents = Array.isArray(parsed.sourcesContent) ? (parsed.sourcesContent as (string | null)[]) : []
    const withContent = sources.map((s, i) => ({ path: s, code: contents[i] })).filter((x) => typeof x.code === 'string' && x.code && x.code.length > 40)
    if (sources.length === 0) {
      sourceMapFiles.push({ file: mapUrl.split('/').pop() ?? mapUrl, recovered: false, sources: 0 })
      return
    }
    let text = ''
    for (const { code } of withContent) {
      if (text.length + code.length > 2_000_000) break
      text += `${code}\n/* ==== */\n`
    }
    totalChars += text.length
    const sampleFiles = withContent
      .sort((a, b) => (b.code as string).length - (a.code as string).length)
      .slice(0, MAX_RECOVERED_SAMPLE_FILES)
      .map((x) => ({ path: x.path.replace(/^webpack:\/\//, ''), kb: Math.round(((x.code as string).length / 1024) * 10) / 10 }))
    recovered.push({
      mapFile: mapUrl.split('/').pop() ?? mapUrl,
      sources: sources.length,
      tree: treeFromSources(sources),
      kb: Math.round((text.length / 1024) * 10) / 10,
      recoveredText: text,
      sampleFiles,
    })
    sourceMapFiles.push({ file: mapUrl.split('/').pop() ?? mapUrl, recovered: withContent.length > 0, sources: sources.length })

    // Model / schema definitions hiding in original source — database intel
    const defPatterns: { kind: string; re: RegExp }[] = [
      { kind: 'prisma', re: /\bmodel\s+([A-Z][A-Za-z0-9_]*)\s*\{/g },
      { kind: 'sql', re: /CREATE\s+TABLE\s+(?:IF\s+NOT\s+EXISTS\s+)?[`"[]?([A-Za-z0-9_.]+)/gi },
      { kind: 'typeorm', re: /@Entity\(\s*[{["']?[^)]*?["'`](\w+)["'`]/g },
      { kind: 'mongoose', re: /(\w+)\s*[:=]\s*new\s+mongoose\.Schema\(/g },
      { kind: 'interface', re: /export\s+interface\s+([A-Z][A-Za-z0-9_]*)\s*\{/g },
      { kind: 'zod', re: /(?:export\s+)?(?:const|let)\s+([A-Za-z0-9_]+Schema)\s*[:=]\s*z\.object\(/g },
      { kind: 'graphql-typed', re: /(?:type|input)\s+([A-Z][A-Za-z0-9_]*)\s*\{/g },
      { kind: 'django', re: /class\s+(\w+)\s*\(\s*(?:models\.)?Model\s*\)/g },
    ]
    for (const { kind, re } of defPatterns) {
      let m: RegExpExecArray | null
      re.lastIndex = 0
      while ((m = re.exec(text)) && modelDefs.length < 60) {
        const name = m[1]
        if (name.length < 2 || name.length > 60) continue
        if (seenDefKeys.has(`${kind}:${name}`)) continue
        seenDefKeys.add(`${kind}:${name}`)
        const start = Math.max(0, m.index - 20)
        modelDefs.push({ name, kind, snippet: text.slice(start, start + 400).replace(/\s+/g, ' ').slice(0, 360), file: mapUrl.split('/').pop() ?? mapUrl })
      }
    }
  })

  const dedupDefs: { name: string; kind: string; snippet: string; file: string }[] = modelDefs.slice(0, 40)

  return { recovered, sourceMapFiles, modelDefs: dedupDefs, totalKb: Math.round(totalChars / 1024), budgetCapHit }
}

// ---------- Live schema probes: REST GET + GraphQL introspection + OpenAPI ----------

function inferJsonFields(value: unknown, prefix = '', depth = 0, out: { name: string; type: string }[] = []): { name: string; type: string }[] {
  if (out.length >= 40 || depth > 3 || value == null) return out
  if (Array.isArray(value)) {
    if (value.length > 0) inferJsonFields(value[0], prefix, depth, out)
    else if (prefix) out.push({ name: prefix, type: 'array<unknown>' })
    return out
  }
  if (typeof value === 'object') {
    const entries = Object.entries(value as Record<string, unknown>)
    if (entries.length === 0 && prefix) out.push({ name: prefix, type: 'object' })
    for (const [k, v] of entries.slice(0, 40)) {
      const name = prefix ? `${prefix}.${k}` : k
      const t =
        v === null ? 'null' :
        Array.isArray(v) ? `array<${typeof v[0] === 'object' && v[0] !== null ? 'object' : typeof (v[0] ?? 'x')}>` :
        typeof v === 'object' ? 'object' : typeof v
      if (typeof v !== 'object' || v === null) {
        out.push({ name: name.slice(0, 80), type: t })
      }
      if (typeof v === 'object' && v !== null) {
        inferJsonFields(v, name, depth + 1, out)
      }
    }
    return out
  }
  if (prefix) out.push({ name: prefix.slice(0, 80), type: typeof value })
  return out
}

function entityFromPath(pathname: string): string {
  const segs = pathname.split('/').filter((s) => s && !/^v\d+$/.test(s) && s !== 'api')
  const last = segs[segs.length - 1] ?? 'root'
  const name = last.replace(/[-_](.)/g, (_, c: string) => c.toUpperCase()).replace(/s$/, '')
  return name.charAt(0).toUpperCase() + name.slice(1) || 'Root'
}

async function probeRestEndpoints(origin: URL, calls: RawApiCall[]): Promise<{ url: string; status: number; entity: string; fields: { name: string; type: string }[]; note: string }[]> {
  const candidates: string[] = []
  const seen = new Set<string>()
  for (const c of calls) {
    if (c.kind !== 'rest' || c.method !== 'GET') continue
    let u: URL
    try {
      u = c.url.startsWith('http') ? new URL(c.url) : new URL(c.url, origin)
    } catch {
      continue
    }
    if (!sameOrigin(u, origin)) continue
    if (u.pathname.includes('.') && SKIP_EXT.test(u.pathname)) continue
    if (/:param|:id|\$|\{/.test(u.pathname)) continue // templated — cannot probe safely
    const key = u.toString()
    if (seen.has(key)) continue
    seen.add(key)
    candidates.push(key)
    if (candidates.length >= MAX_ENDPOINT_PROBES) break
  }

  const results: { url: string; status: number; entity: string; fields: { name: string; type: string }[]; note: string }[] = []
  await pool(candidates, CONCURRENCY, async (url) => {
    let doc: FetchedDoc
    try {
      doc = await httpFetch(url, 'application/json,text/plain', { maxChars: 800_000 })
    } catch {
      return
    }
    if (doc.status >= 400) {
      results.push({ url, status: doc.status, entity: entityFromPath(new URL(url).pathname), fields: [], note: doc.status === 401 || doc.status === 403 ? 'auth-gated — mapped, not accessed' : `HTTP ${doc.status}` })
      return
    }
    const body = doc.body.trim()
    if (!body.startsWith('{') && !body.startsWith('[')) {
      results.push({ url, status: doc.status, entity: entityFromPath(new URL(url).pathname), fields: [], note: `non-JSON (${doc.contentType.slice(0, 40) || 'unknown type'})` })
      return
    }
    try {
      const parsed = JSON.parse(body) as unknown
      const fields = inferJsonFields(parsed)
      results.push({
        url,
        status: doc.status,
        entity: entityFromPath(new URL(url).pathname),
        fields,
        note: fields.length > 0 ? `JSON — ${fields.length} field paths (keys+types only, no values stored)` : 'JSON — empty or scalar',
      })
    } catch {
      results.push({ url, status: doc.status, entity: entityFromPath(new URL(url).pathname), fields: [], note: 'malformed JSON' })
    }
  })
  return results
}

const GRAPHQL_INTROSPECTION_QUERY =
  '{"query":"query IntrospectionQuery { __schema { queryType { name } mutationType { name } subscriptionType { name } types { kind name fields { name } } } }"}'

async function graphqlIntrospect(endpoint: string): Promise<NonNullable<SiteMinedData['graphql']>> {
  const result: NonNullable<SiteMinedData['graphql']> = {
    endpoint,
    reachable: false,
    queries: [],
    mutations: [],
    subscriptions: [],
    types: [],
  }
  let doc: FetchedDoc
  try {
    doc = await httpFetch(endpoint, 'application/json', {
      method: 'POST',
      postBody: GRAPHQL_INTROSPECTION_QUERY,
      postContentType: 'application/json',
      maxChars: 2_000_000,
    })
  } catch {
    return result
  }
  if (doc.status !== 200) {
    result.reachable = doc.status === 405 || doc.status === 400 // endpoint exists, rejects this method/query
    return result
  }
  let body: { data?: { __schema?: Record<string, unknown> } ; errors?: unknown }
  try {
    body = JSON.parse(doc.body) as typeof body
  } catch {
    return result
  }
  const schema = body.data?.__schema
  if (!schema || typeof schema !== 'object') {
    result.reachable = true
    return result // introspection disabled — honest note upstream
  }
  result.reachable = true
  const queryName = (schema['queryType'] as { name?: string } | null)?.name
  const mutationName = (schema['mutationType'] as { name?: string } | null)?.name
  const subscriptionName = (schema['subscriptionType'] as { name?: string } | null)?.name
  const types = (schema['types'] as { kind?: string; name?: string; fields?: { name?: string }[] }[] | undefined) ?? []
  for (const t of types) {
    if (!t.name || t.name.startsWith('__')) continue
    const fields = (t.fields ?? []).map((f) => f.name ?? '').filter(Boolean).slice(0, 40)
    if (t.name === queryName) result.queries = fields
    else if (t.name === mutationName) result.mutations = fields
    else if (t.name === subscriptionName) result.subscriptions = fields
    else if (t.kind === 'OBJECT' && fields.length > 0 && result.types.length < 80) {
      result.types.push({ name: t.name, kind: t.kind ?? 'OBJECT', fields })
    }
  }
  return result
}

async function fetchOpenApi(origin: URL, candidates: string[]): Promise<NonNullable<SiteMinedData['openApi']>> {
  const tried = candidates.length > 0 ? candidates : [new URL('/openapi.json', origin).toString(), new URL('/swagger.json', origin).toString(), new URL('/api/openapi.json', origin).toString()]
  for (const url of tried) {
    let doc: FetchedDoc
    try {
      doc = await httpFetch(url, 'application/json', { maxChars: 4_000_000 })
    } catch {
      continue
    }
    if (doc.status !== 200) continue
    try {
      const parsed = JSON.parse(doc.body) as Record<string, unknown>
      const info = parsed['info'] as { title?: string; version?: string } | undefined
      const paths = parsed['paths'] as Record<string, Record<string, unknown>> | undefined
      if (!paths || typeof paths !== 'object') continue
      const entries: string[] = []
      const verbs = new Set(['get', 'post', 'put', 'patch', 'delete', 'head', 'options'])
      for (const [path, ops] of Object.entries(paths)) {
        if (!ops || typeof ops !== 'object') continue
        for (const method of Object.keys(ops)) {
          if (verbs.has(method.toLowerCase())) entries.push(`${method.toUpperCase()} ${path}`)
        }
        if (entries.length >= 500) break
      }
      return {
        url,
        title: info?.title ?? '(untitled)',
        version: info?.version ?? '',
        paths: entries,
      }
    } catch {
      continue
    }
  }
  return { url: '', title: '', version: '', paths: [] }
}

// ---------- Stage 3: bundles — full asset autopsy + decompile + live probes ----------

interface BundlesResult {
  bundles: SiteBundles
  mined: SiteMinedData
  evidence: SiteEvidence[]
  unknowns: string[]
}

interface MinerState {
  fingerprints: Map<string, string>
  routes: Set<string>
  apiCalls: RawApiCall[]
  apiCallKeys: Set<string>
  secrets: { pattern: string; snippet: string; file: string }[]
  secretKeys: Set<string>
  envVars: Map<string, string>
  i18nKeys: Set<string>
  i18nLocales: Set<string>
  storageKeys: Set<string>
  thirdParty: Set<string>
  chunkUrls: Set<string>
  buildIdCandidates: Set<string>
  cssTexts: string[]
  cssChars: number
  jsChars: number
}

function processOneText(origin: URL, file: string, text: string, state: MinerState): void {
  const single = [{ file, text }]
  for (const f of fingerprintBundles(single)) {
    if (!state.fingerprints.has(f.name)) state.fingerprints.set(f.name, f.evidence)
  }
  for (const r of mineRoutesFromBundles(single)) state.routes.add(r)
  for (const call of mineApiCalls(single)) {
    const key = `${call.kind}:${call.method}:${call.url}`
    if (state.apiCallKeys.has(key) || state.apiCalls.length >= MAX_MINED_CALLS) continue
    state.apiCallKeys.add(key)
    state.apiCalls.push(call)
  }
  for (const s of scanSecrets(single)) {
    const key = `${s.pattern}:${s.file}`
    if (state.secretKeys.has(key)) continue
    state.secretKeys.add(key)
    state.secrets.push(s)
  }
  for (const ev of mineEnvVars(single)) {
    if (!state.envVars.has(ev.key) && state.envVars.size < 60) state.envVars.set(ev.key, ev.value)
  }
  const i18n = mineI18n(single)
  for (const k of i18n.samples) state.i18nKeys.add(k)
  for (const l of i18n.locales) state.i18nLocales.add(l)
  for (const k of mineStorageKeys(single)) state.storageKeys.add(k)
  for (const d of mineThirdPartyDomains(single)) state.thirdParty.add(d)
  for (const c of extractChunkUrls(origin, single)) state.chunkUrls.add(c)
  // Next.js build id — App Router sites don't embed __NEXT_DATA__, so pull it
  // from public-path strings and runtime config inside the bundles
  const bdRe = /\/_next\/static\/(?!chunks\/|css\/|media\/)([A-Za-z0-9_-]{15,30})\//g
  let bd: RegExpExecArray | null
  while ((bd = bdRe.exec(text)) && state.buildIdCandidates.size < 5) state.buildIdCandidates.add(bd[1])
  const bd2 = text.match(/["']buildId["']\s*:\s*["']([A-Za-z0-9_-]{8,40})["']/)
  if (bd2) state.buildIdCandidates.add(bd2[1])
  state.jsChars += text.length
}

async function collectBundles(surface: SurfaceResult, homeHtml: string, openApiCandidates: string[], originUrl: string): Promise<BundlesResult> {
  const evidence: SiteEvidence[] = []
  const unknowns: string[] = []
  const origin = new URL(originUrl)
  const startedAt = Date.now()

  const js: SiteAssetInfo[] = []
  const state: MinerState = {
    fingerprints: new Map(),
    routes: new Set(),
    apiCalls: [],
    apiCallKeys: new Set(),
    secrets: [],
    secretKeys: new Set(),
    envVars: new Map(),
    i18nKeys: new Set(),
    i18nLocales: new Set(),
    storageKeys: new Set(),
    thirdParty: new Set(),
    chunkUrls: new Set(),
    buildIdCandidates: new Set(),
    cssTexts: [],
    cssChars: 0,
    jsChars: 0,
  }
  const fetchedUrls = new Set<string>()
  const declaredMapUrls = new Map<string, string | null>()
  let jsBudgetChars = TOTAL_JS_BUDGET_CHARS
  const cssAssets: SiteAssetInfo[] = []

  const fetchAndMine = async (url: string, isCss: boolean): Promise<void> => {
    if (fetchedUrls.has(url)) return
    fetchedUrls.add(url)
    let doc: FetchedDoc
    try {
      doc = await httpFetch(url, isCss ? 'text/css,*/*' : '*/*', { maxChars: MAX_ASSET_CHARS })
    } catch {
      unknowns.push(`${isCss ? 'CSS' : 'JS'} asset unreachable: ${url}`)
      return
    }
    if (doc.status !== 200 || !doc.body) return
    const kb = Math.round((doc.body.length / 1024) * 10) / 10
    const file = url.split('/').pop() ?? url
    if (isCss) {
      if (state.cssChars < 6_000_000) {
        state.cssTexts.push(doc.body)
        state.cssChars += doc.body.length
      }
      cssAssets.push({ url, sizeKb: kb })
      return
    }
    if (jsBudgetChars - doc.body.length < 0) {
      unknowns.push(`JS budget exhausted at ${js.length} assets — remaining chunks listed but not mined`)
      return
    }
    jsBudgetChars -= doc.body.length
    js.push({ url, sizeKb: kb })
    processOneText(origin, file, doc.body, state)
    const sm = doc.body.match(/[#@]\s*sourceMappingURL=(\S+)/)
    declaredMapUrls.set(url, sm ? sm[1] : null)
    if (doc.truncated) unknowns.push(`${url} exceeded the 8MB per-asset analysis cap — analyzed first 8MB only`)
  }

  // Wave 0: homepage HTML + inline scripts feed the miners (SPAs live here)
  if (homeHtml.length > 0) processOneText(origin, '(homepage HTML)', homeHtml, state)
  const inlineText = surface.inlineScripts.slice(0, INLINE_SCRIPT_BUDGET)
  if (inlineText.trim().length > 100) processOneText(origin, '(inline <script>)', inlineText, state)

  // Wave 1: script tags + preloads discovered during the crawl
  const wave1 = surface.jsUrls.slice(0, MAX_JS_ASSETS)
  await pool(wave1, CONCURRENCY, (u) => fetchAndMine(u, false))
  const cssWave = surface.cssUrls.slice(0, MAX_CSS_ASSETS)
  await pool(cssWave, CONCURRENCY, (u) => fetchAndMine(u, true))

  // Wave 2: chunk-graph traversal — chunks referenced from inside fetched bundles/HTML
  const chunkCandidates = [...state.chunkUrls]
    .filter((u) => !fetchedUrls.has(u))
    .filter((u) => {
      try {
        return sameOrigin(new URL(u), origin) || /\.(?:min\.)?m?js$/i.test(new URL(u).pathname)
      } catch {
        return false
      }
    })
    .slice(0, Math.max(0, MAX_JS_ASSETS - js.length) + 40)
  if (chunkCandidates.length > 0 && Date.now() - startedAt < BUNDLES_TIME_BUDGET_MS) {
    await pool(chunkCandidates, CONCURRENCY, (u) => {
      if (Date.now() - startedAt > BUNDLES_TIME_BUDGET_MS || js.length >= MAX_JS_ASSETS + 40) return Promise.resolve()
      return fetchAndMine(u, u.endsWith('.css'))
    })
  }

  // Next.js build manifest — the framework's own route table
  let buildId = ''
  const nextData = extractNextData(homeHtml)
  if (nextData?.buildId) buildId = nextData.buildId
  if (!buildId) {
    const m = homeHtml.match(/\/_next\/static\/([A-Za-z0-9_-]{15,30})\//)
    if (m && !['chunks', 'css', 'media'].includes(m[1])) buildId = m[1]
  }
  if (!buildId && state.buildIdCandidates.size > 0) buildId = [...state.buildIdCandidates][0]
  let buildManifestPages: string[] = []
  if (buildId) {
    for (const name of ['_buildManifest.js', '_ssgManifest.js']) {
      try {
        const manifestUrl = new URL(`/_next/static/${buildId}/${name}`, origin).toString()
        const doc = await httpFetch(manifestUrl, '*/*', { maxChars: 1_000_000 })
        if (doc.status === 200 && doc.body) {
          if (name === '_buildManifest.js') {
            buildManifestPages = parseBuildManifestPages(doc.body)
            processOneText(origin, name, doc.body, state)
          }
        }
      } catch {
        // manifest unavailable — fine
      }
    }
  }

  // Source maps — recover the ORIGINAL frontend source and mine it
  const blindCandidates = [...js].sort((a, b) => b.sizeKb - a.sizeKb).slice(0, 12)
  for (const a of blindCandidates) {
    if (!declaredMapUrls.has(a.url)) declaredMapUrls.set(a.url, null)
  }
  const declaredOnly = new Map<string, string | null>()
  for (const [url, declared] of declaredMapUrls) {
    if (declared) declaredOnly.set(url, declared)
  }
  for (const a of blindCandidates) if (!declaredOnly.has(a.url)) declaredOnly.set(a.url, null)
  const maps = await recoverSourceMaps(js, declaredOnly)
  let recoveredProcessedChars = 0
  for (const rec of maps.recovered) {
    if (recoveredProcessedChars >= 6_000_000 || Date.now() - startedAt > BUNDLES_TIME_BUDGET_MS) break
    recoveredProcessedChars += rec.recoveredText.length
    processOneText(origin, `sourcemap:${rec.mapFile}`, rec.recoveredText, state)
  }

  // Live probes: REST GET schema sampling + GraphQL introspection + OpenAPI
  const restSchemas = Date.now() - startedAt > BUNDLES_TIME_BUDGET_MS ? [] : await probeRestEndpoints(origin, state.apiCalls)
  let graphql: SiteMinedData['graphql']
  const graphqlProbeOk = (surface.surface.probedPaths ?? []).some((p) => p.path === '/graphql' && p.status === 200)
  if (graphqlProbeOk || state.apiCalls.some((c) => c.kind === 'graphql')) {
    graphql = await graphqlIntrospect(new URL('/graphql', origin).toString())
  }
  const openApi = await fetchOpenApi(origin, openApiCandidates)
  if (openApi.paths.length > 0) {
    for (const entry of openApi.paths) {
      const spaceAt = entry.indexOf(' ')
      const method = spaceAt > 0 ? entry.slice(0, spaceAt) : 'GET'
      const path = spaceAt > 0 ? entry.slice(spaceAt + 1) : entry
      const key = `rest:${method}:${path}`
      if (state.apiCallKeys.has(key) || state.apiCalls.length >= MAX_MINED_CALLS) continue
      state.apiCallKeys.add(key)
      state.apiCalls.push({ method, url: path, kind: 'rest', snippet: `OpenAPI spec entry (${openApi.url})`, file: 'openapi.json' })
    }
  }

  // Rendering model — deterministic verdict from fingerprints
  const frameworks = [...state.fingerprints.entries()].map(([name, ev]) => ({ name, evidence: ev }))
  const libraries = frameworks.filter((f) => BUNDLE_FINGERPRINTS.some((b) => b.name === f.name)).map((f) => f.name)
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
  } else if (hasReact || frameworks.some((f) => ['Vue', 'Angular', 'Svelte/SvelteKit', 'SolidJS', 'Qwik'].includes(f.name))) {
    const framework = frameworks.find((f) => ['React (hydrate)', 'Vue', 'Angular', 'Svelte/SvelteKit', 'SolidJS', 'Qwik'].includes(f.name))?.name ?? 'client framework'
    renderingModel = bodyTextLen > 400 ? 'SSR + client hydration' : 'client-side SPA'
    renderingEvidence = `${framework} fingerprint present; homepage visible text ${bodyTextLen} chars ${bodyTextLen > 400 ? '(server-rendered content present)' : '(near-empty shell → client-rendered)'}`
  }

  const totalJsKb = Math.round(js.reduce((s, a) => s + a.sizeKb, 0))
  const totalCssKb = Math.round(cssAssets.reduce((s, a) => s + a.sizeKb, 0))
  const designTokens = mineDesignTokens(state.cssTexts, homeHtml)
  const sourceMapsRecovered = maps.recovered.map((r) => ({ file: r.mapFile, sources: r.sources, tree: r.tree, kb: r.kb }))
  const recoveredSourceKb = maps.recovered.reduce((s, r) => s + r.kb, 0)

  evidence.push(
    {
      claim: `${js.length} JS assets (${totalJsKb}KB) + ${cssAssets.length} CSS files (${totalCssKb}KB) statically mined across ${state.chunkUrls.size} chunk URLs discovered`,
      source: 'asset URLs from crawled HTML + preload hints + in-bundle chunk references',
      method: 'plain HTTP GET + static mining — never executed',
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
      claim: `Technology fingerprints: ${frameworks.map((f) => f.name).slice(0, 14).join(', ')}`,
      source: 'HTML + JS bundle static signatures',
      method: 'fingerprint table (known framework/library regex signatures)',
      confidence: 'medium',
    })
  }
  if (maps.recovered.length > 0) {
    evidence.push({
      claim: `DECOMPILED FRONTEND: ${maps.recovered.length} source maps recovered — ${maps.recovered.reduce((s, r) => s + r.sources, 0)} original source files, ${recoveredSourceKb}KB of original code (e.g. ${maps.recovered[0].tree.slice(0, 6).join(', ')})`,
      source: maps.recovered.map((r) => r.mapFile).slice(0, 5).join(', '),
      method: 'sourceMap fetch + sources/sourcesContent extraction — original pre-build source tree',
      confidence: 'high',
    })
  }
  if (maps.modelDefs.length > 0) {
    evidence.push({
      claim: `${maps.modelDefs.length} model/schema definitions found in recovered source: ${maps.modelDefs.slice(0, 8).map((d) => `${d.name} (${d.kind})`).join(', ')}`,
      source: 'recovered source content',
      method: 'pattern scan (prisma model / CREATE TABLE / @Entity / mongoose.Schema / interface / zod / graphql type)',
      confidence: 'high',
    })
  }
  if (buildManifestPages.length > 0) {
    evidence.push({
      claim: `Next.js build manifest recovered — ${buildManifestPages.length} framework routes: ${buildManifestPages.slice(0, 12).join(', ')}${buildManifestPages.length > 12 ? '…' : ''}`,
      source: `/_next/static/${buildId}/_buildManifest.js`,
      method: 'public build-manifest fetch + route-table parse',
      confidence: 'high',
    })
  }
  if (restSchemas.length > 0) {
    const jsonOk = restSchemas.filter((r) => r.fields.length > 0)
    evidence.push({
      claim: `${jsonOk.length}/${restSchemas.length} public API endpoints probed returned JSON — schemas inferred for ${jsonOk.slice(0, 6).map((r) => r.entity).join(', ')}${jsonOk.length > 6 ? '…' : ''}`,
      source: 'discovered GET endpoints (public, unauthenticated)',
      method: 'live GET + recursive field/type inference — keys and types only, no values stored',
      confidence: 'high',
    })
  }
  if (graphql && graphql.reachable) {
    if (graphql.types.length > 0) {
      evidence.push({
        claim: `GraphQL schema introspected — ${graphql.queries.length} queries, ${graphql.mutations.length} mutations, ${graphql.types.length} types (${graphql.types.slice(0, 6).map((t) => t.name).join(', ')}…)`,
        source: graphql.endpoint,
        method: 'standard GraphQL introspection query (the API documenting itself)',
        confidence: 'high',
      })
    } else {
      unknowns.push('GraphQL endpoint reachable but introspection disabled — operations inferred from client code only')
    }
  }
  if (openApi.paths.length > 0) {
    evidence.push({
      claim: `OpenAPI/Swagger spec found and parsed — ${openApi.paths.length} documented operations (${openApi.title}${openApi.version ? ` v${openApi.version}` : ''})`,
      source: openApi.url,
      method: 'public spec fetch + paths×methods parse',
      confidence: 'high',
    })
  }
  if (state.envVars.size > 0) {
    evidence.push({
      claim: `${state.envVars.size} public client config values (env/API bases): ${[...state.envVars.keys()].slice(0, 8).join(', ')}`,
      source: 'bundle text + recovered source',
      method: 'NEXT_PUBLIC_*/REACT_APP_*/VITE_*/api-base pattern scan',
      confidence: 'high',
    })
  }
  if (state.i18nKeys.size >= 20) {
    evidence.push({
      claim: `i18n surface: ${state.i18nKeys.size} translation keys across ${state.i18nLocales.size} locales — internal feature names leak here (${[...state.i18nKeys].slice(0, 5).join(', ')}…)`,
      source: 'bundle i18n resources',
      method: 't("key") + resources object scan',
      confidence: 'medium',
    })
  }
  if (state.storageKeys.size > 0) {
    evidence.push({
      claim: `${state.storageKeys.size} client storage keys (localStorage/sessionStorage): ${[...state.storageKeys].slice(0, 8).join(', ')}`,
      source: 'bundle text',
      method: 'storage API call scan — client state map',
      confidence: 'high',
    })
  }
  if (js.length === 0) {
    unknowns.push('No JavaScript bundles were discovered or reachable — API surface and library analysis may be empty (the site may inline everything, block assets, or be fully static)')
  }
  if (state.secrets.length > 0) {
    evidence.push({
      claim: `${state.secrets.length} hardcoded secret pattern(s) found in public bundles: ${[...new Set(state.secrets.map((s) => s.pattern))].join(', ')}`,
      source: 'bundle text / recovered source',
      method: 'known secret format scan (values redacted)',
      confidence: 'high',
    })
  }

  const bundles: SiteBundles = {
    js,
    css: cssAssets,
    frameworks,
    libraries,
    routesInBundles: [...state.routes].slice(0, 300),
    designTokens,
    sourceMaps: [...declaredOnly.values()].filter((v): v is string => v !== null).map((v) => v.split('/').pop() ?? v),
    renderingModel,
    renderingEvidence,
    totalJsKb,
    totalCssKb,
    buildId: buildId || undefined,
    buildManifestPages,
    chunkUrlsFound: state.chunkUrls.size,
    sourceMapsRecovered,
    recoveredSourceKb,
  }
  const mined: SiteMinedData = {
    apiCalls: state.apiCalls.map((c) => ({ method: c.method, url: c.url, kind: c.kind, snippet: c.snippet, file: c.file })),
    secrets: state.secrets,
    inlineScriptChars: inlineText.length,
    envVars: [...state.envVars.entries()].map(([key, value]) => ({ key, value })),
    i18n: { keys: state.i18nKeys.size, samples: [...state.i18nKeys].slice(0, 120), locales: [...state.i18nLocales] },
    storageKeys: [...state.storageKeys],
    thirdPartyDomains: [...state.thirdParty].slice(0, 200),
    responseSchemas: restSchemas,
    ...(graphql ? { graphql } : {}),
    ...(openApi.paths.length > 0 ? { openApi } : {}),
    sourceMapFiles: maps.sourceMapFiles,
    modelDefs: maps.modelDefs,
  }
  return { bundles, mined, evidence, unknowns }
}

// ============================================================
// AI structuring stages — the model only ORGANIZES material the
// collector already gathered. It cannot fetch, cannot execute,
// cannot invent: every item must trace back to a mined call, a
// crawled page or a fingerprint.
// ============================================================

const APIS_PROMPT = `You are the API Surface skill of a deep website reverse-engineering engine. You are given RAW call sites statically mined from the target site's public JavaScript + recovered source (fetch/axios/XHR/GraphQL/WebSocket/EventSource patterns with source file), PLUS live-probed response schemas, PLUS a parsed OpenAPI spec if one was found. Structure them into a clean API surface inventory.

Rules (STRICT):
- Only use the material you are given. NEVER invent an endpoint that is not in the material — if the material is empty, return empty arrays.
- Merge duplicates (same method+path). Normalize template variables to :param.
- Ignore obviously non-API URLs (static assets, images, analytics SDKs like google-analytics, facebook, hotjar, sentry, doubleclick, CDN urls, fonts). When in doubt, keep it and say so in purpose.
- "purpose": ONE short phrase (e.g. "load product list", "submit login"). If unknowable, derive it from the path shape; write "unclear from snippet" only as a last resort.
- "evidence": quote the exact mined snippet + file, the probe result, or the OpenAPI entry you based the item on.
- graphqlOps: names of GraphQL operations found (prefer introspected queries/mutations over client-code names). websockets: the WS URLs found.
- "authPattern": ONE sentence on how auth appears to work (header names, token patterns, cookies, /api/auth/* endpoints); "no auth signals in mined code" if none. Never attempt or suggest bypassing auth.

Return STRICT JSON only — no markdown fences — with exactly these keys:
- "endpoints": [{ "method": "GET|POST|PUT|PATCH|DELETE|WS|SSE", "path": "/api/...", "kind": "rest|graphql|ws|sse", "evidence": "snippet + file", "purpose": "one phrase" }]
- "graphqlOps": [string]
- "websockets": [string]
- "authPattern": string`

const MODELS_PROMPT = `You are the Data Model skill of a deep website reverse-engineering engine. From the material below, reconstruct the platform's DATA ENTITIES, their TYPED FIELDS and relationships — the closest static approximation of its database schema.

Material you may receive:
- Live-probed response schemas (field paths + inferred types from real JSON responses)
- GraphQL introspected types (type name + field names)
- OpenAPI-documented paths
- Model/schema definitions recovered from source maps (prisma models, CREATE TABLE, @Entity, mongoose schemas, TS interfaces, zod schemas)
- Crawled forms with their input field names
- Route patterns and framework route tables

Rules (STRICT):
- Ground every entity and field in evidence from this material. Choose field names that appear in the material.
- "fields": up to 25 field names. "fieldTypes": for the same fields, best-inferred type (from response schemas / zod / TS hints); omit entries you cannot type.
- "relations": e.g. "User 1..* Order — basis: /api/users/:id/orders".
- 3-20 entities depending on material richness. Honest breadth over invention.
- "markdown": a full database-schema.md — a markdown TABLE per entity (field, type, evidence source) plus a relationships section, build-agent ready.

Return STRICT JSON only — no markdown fences — with exactly these keys:
- "entities": [{ "name": "User", "fields": ["id", "email", ...], "fieldTypes": [{ "name": "id", "type": "string" }], "relations": ["User 1..* Order — basis: ..."] }]
- "markdown": "# Database schema\\n..."`

const AUDIT_PROMPT = `You are the Audit skill of a deep website reverse-engineering engine. You are given MECHANICAL audit facts collected statically (security headers, cookie flags, well-known path probe results incl. admin/auth-gated areas, SEO tags per page, image alt coverage, bundle weights, source maps shipped, secret patterns, CORS/rate-limit headers observed). Write the four audit sections.

Rules (STRICT):
- Use ONLY the facts given. Do not run any checks of your own; do not speculate about server-side behavior you cannot see.
- Every finding names its evidence (the header, the page, the number, the probe status).
- severity: "good" for solid practices, "minor"/"major"/"critical" for issues, proportionate and honest.
- Auth-gated areas (401/403 on /admin etc.) are FINDINGS about exposure, not invitations — describe the login architecture factually.
- Things the static study cannot see (runtime scores, real TLS config, backend logs) go in "notes" as explicitly out of scope — never guessed.
- findings per section: 3-7 items max, most important first.

Return STRICT JSON only — no markdown fences — with exactly these keys:
- "security": [{ "finding": "...", "severity": "critical|major|minor|good", "evidence": "..." }]
- "seo": same shape
- "a11y": same shape
- "performance": same shape
- "notes": "one short paragraph on what this static audit could not assess"`

const SYNTH_A_PROMPT = `You are the Synthesis skill of a deep website reverse-engineering engine. You are given everything the collector gathered about one target platform: recon, crawled pages, bundle fingerprints, recovered frontend source (if any), API surface with live-probed schemas, data models, audit facts. Write two documents of the study pack.

Rules (STRICT):
- Every claim must be traceable to the material. If something is not in the material, it goes unsaid — no speculation dressed as fact.
- overview.md: what the platform IS and DOES — purpose, audience, primary user flows (grounded in crawled pages/forms), business model signals, content model. Start with a one-paragraph summary. 150-400 words.
- architecture.md: rendering model (from fingerprints), routing (route patterns + framework route table if recovered), state management signals, data flow (pages -> APIs -> entities), auth architecture (from probes + code, factual), third-party integrations, and what remains unknown. 150-400 words.
- Write clean English markdown for BUILD AGENTS (they will use it to plan a replica). No filler, no marketing language.

Return STRICT JSON only — no markdown fences — with exactly these keys:
- "overview": "# Overview\\n..."
- "architecture": "# Architecture\\n..."`

const SYNTH_B_PROMPT = `You are the Synthesis skill of a deep website reverse-engineering engine. Given the collected material (crawled pages with headings/forms/fields, bundle fingerprints, recovered source tree if any, design tokens, rendering model), write two documents of the study pack.

Rules (STRICT):
- component-map.md: for each meaningful crawled route (group by route pattern), describe the page's evident UI structure — layout regions, key components implied by headings/forms/links/images (e.g. "product card grid", "search bar", "auth form"), and states where evident. When recovered frontend source exists, use its real component/file names. Ground everything in what was collected.
- tech-stack.md: a structured document: frontend (framework + evidence), styling system (tokens, frameworks), libraries detected, backend signals (API style, auth pattern, GraphQL schema if introspected), infrastructure signals (CDN, hosting hints), third-party services. End with a "Confidence" note distinguishing high-confidence detections from weak signals.
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
      source: 'JS bundles + inline scripts + recovered source',
      method: 'static regex mining of fetch/axios/XHR/GraphQL/WebSocket patterns',
      confidence: 'medium',
    })
    return { apis, evidence, unknowns }
  }

  const callTable = calls
    .map((c, i) => `${i + 1}. [${c.kind}] ${c.method} ${c.url}\n   snippet: ${c.snippet.slice(0, 140)}\n   file: ${c.file}`)
    .join('\n')
  const schemaTable = (mined?.responseSchemas ?? [])
    .map((r) => `- GET ${r.url} → ${r.entity}: ${r.fields.slice(0, 12).map((f) => `${f.name}:${f.type}`).join(', ')}${r.fields.length > 12 ? '…' : ''} (${r.note})`)
    .join('\n')
  const gqlBlock = mined?.graphql
    ? `GRAPHQL (${mined.graphql.endpoint}, reachable=${mined.graphql.reachable}): queries=[${mined.graphql.queries.slice(0, 40).join(', ')}] mutations=[${mined.graphql.mutations.slice(0, 40).join(', ')}] types=[${mined.graphql.types.slice(0, 30).map((t) => `${t.name}(${t.fields.slice(0, 8).join('/')})`).join(', ')}]`
    : ''
  const openApiBlock = mined?.openApi?.paths.length
    ? `OPENAPI SPEC (${mined.openApi.url} — ${mined.openApi.title} v${mined.openApi.version}): ${mined.openApi.paths.slice(0, 120).join(' | ')}`
    : ''

  const raw = await chatJson<Record<string, unknown>>(
    APIS_PROMPT,
    [
      `MINED CALL SITES (${calls.length}):`,
      callTable,
      schemaTable ? `\nLIVE-PROBED SCHEMAS:\n${schemaTable}` : '',
      gqlBlock ? `\n${gqlBlock}` : '',
      openApiBlock ? `\n${openApiBlock}` : '',
      '',
      'Structure them now.',
    ].join('\n'),
    2
  )

  const strArr = (v: unknown): string[] =>
    Array.isArray(v) ? v.filter((x): x is string => typeof x === 'string').slice(0, 120) : []
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
        .slice(0, 300)
    : []

  // Introspected queries/mutations beat client-code operation names
  const graphqlOps = mined?.graphql && (mined.graphql.queries.length > 0 || mined.graphql.mutations.length > 0)
    ? [...mined.graphql.queries, ...mined.graphql.mutations].slice(0, 120)
    : strArr(raw['graphqlOps'])

  const apis: SiteApiSurface = {
    endpoints,
    graphqlOps,
    websockets: strArr(raw['websockets']),
    authPattern: typeof raw['authPattern'] === 'string' ? raw['authPattern'].slice(0, 300) : '',
  }
  evidence.push({
    claim: `${endpoints.length} endpoints structured from ${calls.length} mined call sites${mined?.responseSchemes?.length ? ` + ${mined.responseSchemes.length} live probes` : ''}${mined?.openApi?.paths.length ? ` + ${mined.openApi.paths.length} OpenAPI entries` : ''}`,
    source: 'JS bundles + inline scripts + recovered source + live probes',
    method: 'static mining + live GET probes + AI structuring with evidence per endpoint',
    confidence: 'medium',
  })
  if (apis.graphqlOps.length > 0) {
    evidence.push({
      claim: `GraphQL operations: ${apis.graphqlOps.slice(0, 8).join(', ')}`,
      source: mined?.graphql?.endpoint ?? 'bundle text',
      method: mined?.graphql ? 'schema introspection (authoritative)' : 'query/mutation operation-name regex',
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
    .map((p) => `- ${p.url}: ${p.forms.map((f) => `${f.method} ${f.action || '(self)'} [${(f.fields ?? []).map((x) => x.name).join(', ')}]`).join('; ')}`)
    .slice(0, 30)
  const jsonLd = [...new Set((data.surface?.pages ?? []).flatMap((p) => p.jsonLdTypes))].slice(0, 15)
  const endpoints = (data.apis?.endpoints ?? []).map((e) => `${e.method} ${e.path}`).slice(0, 80)
  const routes = [
    ...(data.surface?.routePatterns ?? []),
    ...(data.bundles?.buildManifestPages ?? []),
  ].slice(0, 60)
  const libs = data.bundles?.libraries ?? []
  const schemas = data.mined?.responseSchemas ?? []
  const graphql = data.mined?.graphql
  const openApi = data.mined?.openApi
  const modelDefs = data.mined?.modelDefs ?? []

  if (endpoints.length === 0 && forms.length === 0 && jsonLd.length === 0 && routes.length === 0 && schemas.length === 0 && !graphql && !openApi?.paths.length && modelDefs.length === 0) {
    const models: SiteModels = { markdown: '# Database schema\n\nNo basis for entity inference — no forms, API routes, JSON-LD, probed schemas or recovered model definitions were found.', entities: [] }
    unknowns.push('Data model could not be inferred — no forms, API endpoints, JSON-LD, probed schemas, GraphQL types or recovered model definitions were found')
    return { models, evidence, unknowns }
  }

  const schemaTable = schemas
    .map((r) => `- GET ${r.url} → entity ${r.entity}: ${r.fields.map((f) => `${f.name}:${f.type}`).join(', ')}`)
    .slice(0, 36)
    .join('\n')
  const gqlBlock = graphql?.types.length
    ? graphql.types.slice(0, 40).map((t) => `- type ${t.name}: ${t.fields.join(', ')}`).join('\n')
    : ''
  const openApiBlock = openApi?.paths.length ? openApi.paths.slice(0, 100).join('\n') : ''
  const modelDefBlock = modelDefs
    .map((d) => `- [${d.kind}] ${d.name}: ${d.snippet.slice(0, 200)}`)
    .slice(0, 40)
    .join('\n')

  const user = [
    `LIVE-PROBED RESPONSE SCHEMAS:\n${schemaTable || '(none)'}`,
    `GRAPHQL INTROSPECTED TYPES:\n${gqlBlock || '(none)'}`,
    `OPENAPI PATHS:\n${openApiBlock || '(none)'}`,
    `MODEL/SCHEMA DEFINITIONS RECOVERED FROM SOURCE:\n${modelDefBlock || '(none)'}`,
    `API ENDPOINTS FOUND: ${endpoints.join(', ') || '(none)'}`,
    `CRAWLED FORMS (with input names):\n${forms.join('\n') || '(none)'}`,
    `JSON-LD TYPES: ${jsonLd.join(', ') || '(none)'}`,
    `ROUTE PATTERNS: ${routes.join(', ') || '(none)'}`,
    `DETECTED LIBRARIES: ${libs.join(', ') || '(none)'}`,
    '',
    'Reconstruct the data entities now. Every entity and field must be grounded in this material.',
  ].join('\n')

  const raw = await chatJson<Record<string, unknown>>(MODELS_PROMPT, user, 2)
  const entities: SiteEntityFound[] = Array.isArray(raw['entities'])
    ? (raw['entities'] as Record<string, unknown>[])
        .filter((e) => e && typeof e === 'object' && typeof e['name'] === 'string')
        .map((e) => ({
          name: String(e['name']).slice(0, 60),
          fields: Array.isArray(e['fields']) ? e['fields'].filter((f): f is string => typeof f === 'string').slice(0, 25) : [],
          relations: Array.isArray(e['relations']) ? e['relations'].filter((r): r is string => typeof r === 'string').slice(0, 10) : [],
          fieldTypes: Array.isArray(e['fieldTypes'])
            ? (e['fieldTypes'] as Record<string, unknown>[])
                .filter((f) => f && typeof f === 'object' && typeof f['name'] === 'string')
                .map((f) => ({ name: String(f['name']).slice(0, 60), type: typeof f['type'] === 'string' ? f['type'].slice(0, 30) : 'unknown' }))
                .slice(0, 25)
            : undefined,
        }))
        .slice(0, 20)
    : []
  const markdown = typeof raw['markdown'] === 'string' ? raw['markdown'] : '# Database schema\n(none)'

  const models: SiteModels = { markdown, entities }
  const typedBasis = schemas.length > 0 || gqlBlock || modelDefBlock ? 'typed fields from live probes / introspection / recovered source' : 'field names only'
  evidence.push({
    claim: `${entities.length} data entities reconstructed (${entities.map((e) => e.name).slice(0, 8).join(', ')}${entities.length > 8 ? '…' : ''}) — ${typedBasis}`,
    source: 'live-probed schemas + GraphQL types + recovered model defs + forms + API paths',
    method: 'evidence-grounded AI reconstruction — each field traces to collected material',
    confidence: schemas.length > 0 || modelDefs.length > 0 || graphql?.types.length ? 'high' : 'medium',
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
    lines.push(`- CORS: ${h['access-control-allow-origin'] ?? 'no ACAO header on homepage'}`)
    lines.push(`- Server header disclosure: ${recon.server ?? 'hidden'}; X-Powered-By: ${recon.poweredBy ?? 'hidden'}`)
    const setCookie = h['set-cookie'] ?? ''
    if (setCookie) {
      lines.push(`- Set-Cookie flags: Secure=${/secure/i.test(setCookie) ? 'yes' : 'NO'}, HttpOnly=${/httponly/i.test(setCookie) ? 'yes' : 'NO'}, SameSite=${/samesite/i.test(setCookie) ? 'yes' : 'NO'}`)
    } else {
      lines.push('- Set-Cookie: none on the homepage response')
    }
    const rateLimit = Object.entries(h).filter(([k]) => k.includes('rate-limit') || k.includes('ratelimit'))
    lines.push(`- Rate-limit headers observed: ${rateLimit.length > 0 ? rateLimit.map(([k, v]) => `${k}=${v.slice(0, 30)}`).join(', ') : 'none'}`)
  }
  if (surface?.probedPaths?.length) {
    lines.push('')
    lines.push('WELL-KNOWN PATH PROBES (public GET, auth-gated recorded not accessed):')
    for (const p of surface.probedPaths) {
      lines.push(`- ${p.path} → ${p.status} (${p.note})`)
    }
  }
  if (mined?.secrets.length) {
    lines.push(`- HARDCODED SECRETS IN PUBLIC BUNDLES: ${mined.secrets.map((s) => `${s.pattern} in ${s.file}`).join('; ')}`)
  } else if (bundles) {
    lines.push('- Hardcoded secret patterns in public bundles: none matched')
  }
  if (bundles) {
    lines.push(`- Source maps shipped to production: ${bundles.sourceMapsRecovered?.length ? `${bundles.sourceMapsRecovered.length} recovered (${(bundles.recoveredSourceKb ?? 0)}KB original source exposed)` : 'none detected'}`)
  }

  if (surface) {
    const pages = surface.pages
    const withTitle = pages.filter((p) => p.title).length
    const withDesc = pages.filter((p) => p.description).length
    const withCanonical = pages.filter((p) => p.canonical).length
    const withOg = pages.filter((p) => p.ogTitle).length
    const multiH1 = pages.filter((p) => p.h1.length > 1).length
    const noH1 = pages.filter((p) => p.h1.length === 0).length
    lines.push('')
    lines.push(`SEO FACTS (across ${pages.length} crawled pages):`)
    lines.push(`- titles present: ${withTitle}/${pages.length}; meta descriptions: ${withDesc}/${pages.length}; canonical: ${withCanonical}/${pages.length}; og:title: ${withOg}/${pages.length}`)
    lines.push(`- pages with MULTIPLE h1: ${multiH1}; pages with NO h1: ${noH1}`)
    lines.push(`- sitemap URLs enumerated: ${surface.sitemapUrls}; robots.txt: ${recon?.robots.found ? 'yes' : 'no'}`)
    lines.push(`- structured data (JSON-LD): ${pages.filter((p) => p.hasJsonLd).length}/${pages.length} pages; types: ${[...new Set(pages.flatMap((p) => p.jsonLdTypes))].slice(0, 10).join(', ') || '(none)'}`)

    const totalImgs = pages.reduce((s, p) => s + p.imgCount, 0)
    const noAlt = pages.reduce((s, p) => s + p.imgNoAlt, 0)
    lines.push('')
    lines.push(`A11Y FACTS (static):`)
    lines.push(`- images without alt text: ${noAlt}/${totalImgs}`)
    lines.push(`- forms found: ${pages.flatMap((p) => p.forms).length} (label presence not assessable statically)`)
    lines.push(`- heading structure anomalies (multi-h1 / no-h1): ${multiH1 + noH1} pages`)
  }
  if (bundles) {
    lines.push('')
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
    source: 'response headers + well-known probes + crawled pages + bundle weights',
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
    `PAGES (${data.surface?.pages.length ?? 0}): ${(data.surface?.pages ?? []).slice(0, 25).map((p) => `${p.url} [h1: ${p.h1[0] ?? '—'}] [forms: ${p.forms.map((f) => (f.fields ?? []).map((x) => x.name).join('/')).join('; ')}]`).join('\n  ')}`,
    `ROUTE PATTERNS (${data.surface?.routePatterns.length ?? 0}): ${(data.surface?.routePatterns ?? []).slice(0, 40).join(', ')}`,
    `FRAMEWORK ROUTE TABLE (build manifest, ${data.bundles?.buildManifestPages?.length ?? 0}): ${(data.bundles?.buildManifestPages ?? []).slice(0, 40).join(', ')}`,
    `FRAMEWORKS/LIBRARIES: ${(data.bundles?.frameworks ?? []).map((f) => f.name).join(', ')}`,
    `RECOVERED FRONTEND SOURCE: ${data.bundles?.sourceMapsRecovered?.length ?? 0} maps, ${data.bundles?.recoveredSourceKb ?? 0}KB, trees: ${(data.bundles?.sourceMapsRecovered ?? []).slice(0, 3).flatMap((m) => m.tree.slice(0, 8)).join(' | ')}`,
    `MODEL DEFS RECOVERED: ${(data.mined?.modelDefs ?? []).slice(0, 15).map((d) => `${d.kind}:${d.name}`).join(', ')}`,
    `API ENDPOINTS (${data.apis?.endpoints.length ?? 0}): ${(data.apis?.endpoints ?? []).slice(0, 40).map((e) => `${e.method} ${e.path}`).join(', ')}`,
    `AUTH PATTERN: ${data.apis?.authPattern ?? ''}`,
    `GRAPHQL: ${data.mined?.graphql ? `${data.mined.graphql.queries.length} queries / ${data.mined.graphql.mutations.length} mutations / ${data.mined.graphql.types.length} types` : '(none found)'}`,
    `OPENAPI: ${data.mined?.openApi?.paths.length ? `${data.mined.openApi.title} — ${data.mined.openApi.paths.length} ops` : '(none found)'}`,
    `LIVE-PROBED SCHEMAS (${data.mined?.responseSchemas?.length ?? 0}): ${(data.mined?.responseSchemas ?? []).slice(0, 12).map((r) => `${r.entity}(${r.fields.slice(0, 6).map((f) => f.name).join('/')})`).join(', ')}`,
    `DATA ENTITIES: ${(data.models?.entities ?? []).map((e) => e.name).join(', ')}`,
    `PROBED WELL-KNOWN PATHS (alive): ${(data.surface?.probedPaths ?? []).filter((p) => p.status !== 404 && p.status !== 410).map((p) => `${p.path}(${p.status})`).slice(0, 20).join(', ')}`,
    `STORAGE KEYS: ${(data.mined?.storageKeys ?? []).slice(0, 12).join(', ')}`,
    `ENV/CONFIG: ${(data.mined?.envVars ?? []).slice(0, 10).map((e) => `${e.key}=${e.value}`).join(', ')}`,
    `I18N: ${data.mined?.i18n?.keys ?? 0} keys, locales ${(data.mined?.i18n?.locales ?? []).join('/')}`,
    `THIRD-PARTY DOMAINS (${data.mined?.thirdPartyDomains?.length ?? 0}): ${(data.mined?.thirdPartyDomains ?? []).slice(0, 20).join(', ')}`,
    `DESIGN TOKENS: fonts ${(data.bundles?.designTokens.fonts ?? []).join('/')}; top colors ${(data.bundles?.designTokens.colors ?? []).slice(0, 8).map((c) => c.hex).join(' ')}`,
    `AUDIT COUNTS: security ${data.audit?.security.length ?? 0}, seo ${data.audit?.seo.length ?? 0}, a11y ${data.audit?.a11y.length ?? 0}, perf ${data.audit?.performance.length ?? 0}`,
    `TOTALS: JS ${data.bundles?.totalJsKb ?? 0}KB / ${data.bundles?.js.length ?? 0} files, CSS ${data.bundles?.totalCssKb ?? 0}KB, sitemap URLs ${data.surface?.sitemapUrls ?? 0}, chunks discovered ${data.bundles?.chunkUrlsFound ?? 0}`,
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
  'Generated by Site Intelligence v2 — deep static reverse engineering. Public reads only: no credentials submitted, no forms posted, target JS never executed. Every claim traces to evidence.json; what could not be determined is in unknowns.md. Auth-gated areas are mapped as architecture, never accessed. Use this pack as REFERENCE MATERIAL for building a replica; verify anything critical before relying on it.'

function auditToMarkdown(title: string, findings: SiteAuditFinding[]): string {
  const lines = [`# ${title}`, '']
  if (findings.length === 0) {
    lines.push('(no findings in this section)')
    return lines.join('\n')
  }
  const icon: Record<SiteAuditFinding['severity'], string> = { critical: '[!]', major: '[+]', minor: '[-]', good: '[ok]' }
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
  add('database-schema.md', data.models?.markdown ?? '# Database schema\n(not reached)')

  add('routes.json', JSON.stringify({
    routePatterns: data.surface?.routePatterns ?? [],
    frameworkRouteTable: data.bundles?.buildManifestPages ?? [],
    routesInBundles: data.bundles?.routesInBundles ?? [],
    notes: `crawled ${data.surface?.pages.length ?? 0} pages; ${data.bundles?.chunkUrlsFound ?? 0} chunk URLs discovered`,
  }, null, 2))
  add('sitemap.json', JSON.stringify({
    crawledUrls: (data.surface?.pages ?? []).map((p) => p.url),
    sitemapDeclaredUrls: data.surface?.sitemapUrls ?? 0,
    privateAreasRobots: data.surface?.privateAreas ?? [],
    crawledPrivate: data.surface?.crawledPrivate ?? 0,
  }, null, 2))
  add('api-surface.json', JSON.stringify({
    endpoints: data.apis?.endpoints ?? [],
    graphqlOps: data.apis?.graphqlOps ?? [],
    websockets: data.apis?.websockets ?? [],
    authPattern: data.apis?.authPattern ?? '',
    liveProbes: data.mined?.responseSchemas ?? [],
  }, null, 2))

  // Decompiled frontend — the recovered source tree + model defs
  const recovered = data.bundles?.sourceMapsRecovered ?? []
  const decompiled = ['# Decompiled frontend (source-map recovery)', '']
  if (recovered.length === 0) {
    decompiled.push('No source maps were recovered from this platform — the frontend was analyzed as shipped (minified bundles only).')
  } else {
    decompiled.push(`${recovered.length} source maps recovered — ${data.bundles?.recoveredSourceKb ?? 0}KB of original pre-build source.`, '')
    for (const r of recovered.slice(0, 20)) {
      decompiled.push(`## ${r.file} — ${r.sources} files, ${r.kb}KB`)
      decompiled.push('```')
      decompiled.push(r.tree.slice(0, 40).join('\n'))
      decompiled.push('```')
      decompiled.push('')
    }
    const modelDefs = data.mined?.modelDefs ?? []
    if (modelDefs.length > 0) {
      decompiled.push('## Model / schema definitions found in recovered source', '')
      for (const d of modelDefs.slice(0, 25)) {
        decompiled.push(`### [${d.kind}] ${d.name} (${d.file})`, '', '```', d.snippet, '```', '')
      }
    }
  }
  add('decompiled-frontend.md', decompiled.join('\n'))
  add('source-tree.json', JSON.stringify({ maps: recovered.map((r) => ({ file: r.file, sources: r.sources, kb: r.kb, tree: r.tree })), totalKb: data.bundles?.recoveredSourceKb ?? 0 }, null, 2))

  if (data.mined?.graphql) {
    add('graphql-schema.json', JSON.stringify(data.mined.graphql, null, 2))
  }
  if (data.mined?.openApi?.paths.length) {
    add('openapi-summary.json', JSON.stringify(data.mined.openApi, null, 2))
  }
  if (data.surface?.probedPaths?.length) {
    add('surface-probes.json', JSON.stringify(data.surface.probedPaths, null, 2))
  }

  add('design-tokens.json', JSON.stringify(data.bundles?.designTokens ?? { colors: [], fonts: [], spacingVars: [], radiusVars: [], breakpoints: [] }, null, 2))
  add('client-config.json', JSON.stringify({
    envVars: data.mined?.envVars ?? [],
    storageKeys: data.mined?.storageKeys ?? [],
    i18n: data.mined?.i18n ?? { keys: 0, samples: [], locales: [] },
    thirdPartyDomains: data.mined?.thirdPartyDomains ?? [],
  }, null, 2))

  add('audit/security.md', auditToMarkdown('Security audit', data.audit?.security ?? []))
  add('audit/seo.md', auditToMarkdown('SEO audit', data.audit?.seo ?? []))
  add('audit/a11y.md', auditToMarkdown('Accessibility audit', data.audit?.a11y ?? []))
  add('audit/performance.md', auditToMarkdown('Performance audit (static)', data.audit?.performance ?? []))

  add('evidence.json', JSON.stringify({ count: data.evidence.length, evidence: data.evidence }, null, 2))
  add('unknowns.md', ['# Unknowns & limitations', '', ...(data.unknowns.length > 0 ? data.unknowns.map((u) => `- ${u}`) : ['- (none recorded)']), '', 'Auth-gated areas (login-required admin panels, dashboards, APIs) are mapped from the public surface and reported as architecture. They are not accessed, and no credentials are ever submitted.'].join('\n'))

  // Deterministic completeness score — app-owned, rewards DEPTH actually collected
  const pages = data.surface?.pages.length ?? 0
  const js = data.bundles?.js.length ?? 0
  const endpoints = data.apis?.endpoints.length ?? 0
  const entities = data.models?.entities.length ?? 0
  const routePatterns = data.surface?.routePatterns.length ?? 0
  const schemas = data.mined?.responseSchemas?.length ?? 0
  const mapsRecovered = data.bundles?.sourceMapsRecovered?.length ?? 0
  const hasGqlSchema = (data.mined?.graphql?.types.length ?? 0) > 0
  const hasOpenApi = (data.mined?.openApi?.paths.length ?? 0) > 0
  let score =
    Math.min(pages, 60) / 60 * 16 +
    Math.min(js, 40) / 40 * 12 +
    Math.min(endpoints, 60) / 60 * 16 +
    Math.min(entities, 12) / 12 * 12 +
    Math.min(routePatterns, 40) / 40 * 10 +
    Math.min(schemas, 15) / 15 * 8 +
    Math.min(mapsRecovered, 8) / 8 * 6 +
    (hasGqlSchema || hasOpenApi ? 6 : 0) +
    (data.audit ? 6 : 0) +
    Math.min(files.length, 20) / 20 * 8
  if (data.recon?.blocked) score = Math.min(score, 45)
  score = Math.round(Math.max(0, Math.min(100, score)))

  add('manifest.json', JSON.stringify({
    target: item.url,
    domain: item.domain,
    generatedAt: new Date().toISOString(),
    engine: 'site-intel v2 — deep static reverse engineering',
    stagesCompleted: item.stageDone,
    completenessScore: score,
    scoreBasis: {
      pagesCrawled: pages,
      jsBundlesAnalyzed: js,
      chunkUrlsDiscovered: data.bundles?.chunkUrlsFound ?? 0,
      endpointsStructured: endpoints,
      entitiesReconstructed: entities,
      routePatterns,
      liveProbedSchemas: schemas,
      sourceMapsRecovered: mapsRecovered,
      recoveredSourceKb: data.bundles?.recoveredSourceKb ?? 0,
      graphqlSchemaIntrospected: hasGqlSchema,
      openApiParsed: hasOpenApi,
      auditCompiled: !!data.audit,
      blockedToClient: data.recon?.blocked ?? false,
    },
    files: files.map((f) => f.name),
    method: 'deep static RE — public unauthenticated GETs + GraphQL introspection only; no credentials submitted, no forms posted, target JS never executed; source maps recovered, evidence-traced',
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
      sitemapSeeds: Array.isArray(v.sitemapSeeds) ? v.sitemapSeeds : undefined,
      openApiCandidates: Array.isArray(v.openApiCandidates) ? v.openApiCandidates : undefined,
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

async function constitutionLine(ideaId: string | null): Promise<string> {
  if (!ideaId) return '' // standalone study — no idea constitution to apply
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

export async function startSiteAnalysis(ideaId: string | null, rawUrl: string): Promise<SiteAnalysisItem> {
  // ideaId === null -> standalone workspace study, usable without any idea
  if (ideaId) {
    const idea = await db.idea.findUnique({ where: { id: ideaId }, select: { id: true } })
    if (!idea) throw new SiteIntelError('NOT_FOUND', 'Idea not found')
  }

  const seed = normalizeInputUrl(rawUrl)
  const reconResult = await collectRecon(seed)

  const data: SiteIntelData = {
    recon: reconResult.recon,
    evidence: reconResult.evidence,
    unknowns: reconResult.unknowns,
    pack: [],
    sitemapSeeds: reconResult.sitemapSeeds,
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

  if (ideaId) {
    await logDecision(ideaId, 'Site study started', `${seed.hostname} — recon complete (HTTP ${reconResult.recon.httpStatus}${reconResult.recon.blocked ? ', partially blocked' : ''}, ${reconResult.sitemapSeeds.length} sitemap URLs)`)
  }
  return serialize(row)
}

export async function advanceSiteAnalysis(ideaId: string | null, analysisId: string, lang: 'ar' | 'en'): Promise<SiteAnalysisItem> {
  const row = await db.siteAnalysis.findFirst({ where: { id: analysisId, ideaId: ideaId ?? null } })
  if (!row) throw new SiteIntelError('NOT_FOUND', 'Analysis not found')
  if (row.status !== 'running') return serialize(row)
  if (row.stageDone >= SITE_INTEL_STAGES.length) return serialize(row)

  const data = parseData(row.data)
  const stage = SITE_INTEL_STAGES[row.stageDone]

  try {
    if (stage === 'surface') {
      if (!data.recon) throw new SiteIntelError('STAGE_FAILED', 'Recon data missing')
      const result = await collectSurface(data.recon, data.sitemapSeeds ?? [])
      data.surface = result.surface
      // Handoff: asset URLs + inline scripts persist for the bundles stage
      data.assetJsUrls = result.jsUrls.slice(0, 200)
      data.assetCssUrls = result.cssUrls.slice(0, 60)
      data.inlineScriptsText = result.inlineScripts.slice(0, INLINE_SCRIPT_BUDGET)
      data.openApiCandidates = result.openApiCandidates.slice(0, 8)
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
        openApiCandidates: [],
      }
      // Homepage HTML is needed for rendering-model + token context; one refetch
      try {
        const home = await httpFetch(data.recon.finalUrl, 'text/html,application/xhtml+xml', { maxChars: MAX_HTML_CHARS })
        surfaceResult.homeHtml = home.body.slice(0, MAX_HTML_CHARS)
        if (!surfaceResult.inlineScripts) surfaceResult.inlineScripts = extractInlineScripts(surfaceResult.homeHtml)
      } catch {
        surfaceResult.homeHtml = ''
      }
      const result = await collectBundles(surfaceResult, surfaceResult.homeHtml, data.openApiCandidates ?? [], data.recon.finalUrl)
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
      if (ideaId) {
        await logDecision(
          ideaId,
          'Site study complete',
          `${row.domain} — 7/7 stages, completeness ${fresh?.score ?? 0}%, ${data.evidence.length} evidence entries, ${data.pack.length} pack files, ${data.bundles?.sourceMapsRecovered?.length ?? 0} source maps recovered, ${data.apis?.endpoints.length ?? 0} endpoints`
        )
      }
      return serialize(fresh ?? row)
    }
  } catch (error) {
    const message = error instanceof Error ? error.message : 'unknown error'
    await persist(row.id, data, row.stageDone, 'failed', `${stage} stage failed: ${message}`)
    if (ideaId) {
      await logDecision(ideaId, 'Site study failed', `${row.domain} — ${stage} stage: ${message.slice(0, 140)}`)
    }
    const fresh = await db.siteAnalysis.findUnique({ where: { id: row.id } })
    return serialize(fresh ?? row)
  }

  const fresh = await db.siteAnalysis.findUnique({ where: { id: row.id } })
  return serialize(fresh ?? row)
}

export async function getAnalysis(ideaId: string | null, analysisId: string): Promise<SiteAnalysisItem | null> {
  const row = await db.siteAnalysis.findFirst({ where: { id: analysisId, ideaId: ideaId ?? null } })
  return row ? serialize(row) : null
}

export async function listAnalyses(ideaId: string | null): Promise<SiteAnalysisSummary[]> {
  const rows = await db.siteAnalysis.findMany({ where: { ideaId: ideaId ?? null }, orderBy: { createdAt: 'desc' } })
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

export async function deleteAnalysis(ideaId: string | null, analysisId: string): Promise<boolean> {
  const res = await db.siteAnalysis.deleteMany({ where: { id: analysisId, ideaId: ideaId ?? null } })
  return res.count > 0
}
