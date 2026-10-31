import { db } from '@/lib/db'
import { parseInterpretation, parseSummary } from '@/lib/payload'

// ============================================================
// The final deliverable — the implementation-ready engineering
// package. NO LIMITS: exportable at ANY stage (exports whatever
// is confirmed so far): seven interconnected sections plus
// traceability, OpenAPI, DDL, auth model, setup guide and a
// bilingual glossary — so a frontend or fullstack developer who
// never saw the original conversation can start writing code
// from this document alone.
// ============================================================

type Params = { params: Promise<{ id: string }> }

function esc(v: string | null | undefined): string {
  return (v ?? '').replace(/\|/g, '\\|').replace(/\n/g, ' ')
}

function parse<T>(raw: string | null | undefined, fallback: T): T {
  if (!raw) return fallback
  try {
    return JSON.parse(raw) as T
  } catch {
    return fallback
  }
}

function mermaidErd(entities: Array<{ name: string; fields?: string | null; relationships: string | null }>): string {
  const sanitize = (n: string) => n.replace(/[^a-zA-Z0-9]/g, '_')
  const mmType = (t: string) => {
    const s = (t || 'string').toLowerCase().split(/[<(\s]/)[0]
    if (['integer', 'int'].includes(s)) return 'int'
    if (['decimal', 'float', 'money'].includes(s)) return 'float'
    if (['boolean', 'bool'].includes(s)) return 'boolean'
    if (['datetime', 'timestamp', 'date'].includes(s)) return 'datetime'
    if (s === 'json') return 'json'
    return 'string'
  }
  const lines = ['erDiagram']
  for (const e of entities) {
    const fields = parse<Array<{ name: string; type: string; unique?: boolean; refEntity?: string }>>(e.fields, [])
    lines.push(`  ${sanitize(e.name)} {`)
    if (fields.length) {
      for (const f of fields) {
        const key = f.refEntity ? 'FK' : f.unique ? 'UK' : ''
        lines.push(`    ${mmType(f.type)} ${snake(f.name)}${key ? ` ${key}` : ''}`)
      }
    } else {
      lines.push('    string id PK')
    }
    lines.push('  }')
  }
  const rels = entities.flatMap((e) =>
    parse<Array<{ target: string; type: string; description?: string }>>(e.relationships, []).map((r) => ({ from: e.name, ...r }))
  )
  for (const r of rels) {
    const cardinality =
      r.type.includes('many-to-many')
        ? '}o--o{'
        : r.type.includes('one-to-many')
          ? '||--o{'
          : r.type.includes('one-to-one')
            ? '||--||'
            : '||--o{'
    const label =
      (r.description ?? r.type)
        .replace(/[^a-zA-Z0-9 ]/g, '')
        .trim()
        .split(/\s+/)
        .slice(0, 3)
        .join('_') || 'relates'
    lines.push(`  ${sanitize(r.from)} ${cardinality} ${sanitize(r.target)} : "${label.slice(0, 32)}"`)
  }
  lines.push('')
  return lines.join('\n')
}

// ------------------------------------------------------------
// Developer-handoff compilers — deterministic derivations of
// everything a coder needs to bootstrap: SQL DDL, OpenAPI,
// environment variables, and the authorization matrix.
// ------------------------------------------------------------

function snake(s: string): string {
  return s
    .replace(/([a-z0-9])([A-Z])/g, '$1_$2')
    .replace(/[^a-zA-Z0-9]+/g, '_')
    .replace(/^_+|_+$/g, '')
    .toLowerCase()
}

function sqlType(t: string): string {
  const s = (t || 'string').toLowerCase().split(/[<(\s]/)[0]
  if (s.startsWith('enum')) return 'VARCHAR(64)'
  switch (s) {
    case 'text':
      return 'TEXT'
    case 'integer':
    case 'int':
      return 'INTEGER'
    case 'decimal':
    case 'float':
    case 'money':
      return 'DECIMAL(12,2)'
    case 'boolean':
    case 'bool':
      return 'BOOLEAN'
    case 'datetime':
    case 'timestamp':
    case 'date':
      return 'TIMESTAMP'
    case 'json':
    case 'jsonb':
      return 'JSONB'
    default:
      return 'VARCHAR(255)'
  }
}

function ddlForEntity(e: {
  code: string
  name: string
  nameAr: string | null
  fields: string | null
  constraints: string | null
}): string {
  const fields = parse<Array<{ name: string; type: string; required?: boolean; unique?: boolean; refEntity?: string }>>(e.fields, [])
  const table = snake(e.name)
  const cols: string[] = ['  id            VARCHAR(64)  PRIMARY KEY']
  const fks: string[] = []
  for (const f of fields) {
    const enumNote = (f.type || '').toLowerCase().startsWith('enum') ? `  -- allowed: ${(f.type || '').replace(/^enum:?\s*/i, '') || 'see data dictionary'}` : ''
    if (f.refEntity) {
      const col = `${snake(f.refEntity)}_id`
      cols.push(`  ${col.padEnd(14)} VARCHAR(64)  ${f.required === false ? '' : 'NOT NULL '}REFERENCES ${snake(f.refEntity)}(id)${enumNote}`)
      fks.push(col)
    } else {
      cols.push(`  ${snake(f.name).padEnd(14)} ${sqlType(f.type).padEnd(12)} ${f.required === false ? 'NULL' : 'NOT NULL'}${f.unique ? ' UNIQUE' : ''}${enumNote}`.trimEnd())
    }
  }
  cols.push('  created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP')
  cols.push('  updated_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP')
  const constraints = parse<string[]>(e.constraints, [])
  const out: string[] = []
  out.push(`-- ${e.code} — ${e.name}${e.nameAr ? ` (${e.nameAr})` : ''}`)
  out.push(`CREATE TABLE ${table} (`)
  out.push(cols.join(',\n'))
  out.push(');')
  for (const fk of fks) out.push(`CREATE INDEX idx_${table}_${fk} ON ${table} (${fk});`)
  for (const c of constraints) out.push(`-- constraint: ${c}`)
  out.push('')
  return out.join('\n')
}

function openApiType(t: string): string {
  const s = (t || 'string').toLowerCase()
  if (s.startsWith('array') || s === 'array') return 'array'
  if (s === 'object' || s === 'json' || s === 'jsonb') return 'object'
  if (['integer', 'int'].includes(s)) return 'integer'
  if (['decimal', 'float', 'money', 'number'].includes(s)) return 'number'
  if (['boolean', 'bool'].includes(s)) return 'boolean'
  return 'string'
}

function openApiSpec(
  title: string,
  apis: Array<{ method: string; path: string; purpose: string; auth: string | null; request: string | null; response: string | null; errors: string | null; linkedEntities: string | null }>
): string {
  const y: string[] = []
  const pad = (n: number) => '  '.repeat(n)
  y.push('openapi: 3.1.0')
  y.push('info:')
  y.push(`${pad(1)}title: ${title}`)
  y.push(`${pad(1)}version: "${new Date().toISOString().slice(0, 10)}"`)
  y.push(`${pad(1)}description: Deterministic skeleton generated from the confirmed API contracts. Complete nested schemas and pagination as you implement; section 03 of the package is the source of truth.`)
  y.push('servers:')
  y.push(`${pad(1)}- url: http://localhost:3000`)
  y.push(`${pad(2)}description: local development`)
  y.push('components:')
  y.push(`${pad(1)}securitySchemes:`)
  y.push(`${pad(2)}bearerAuth:`)
  y.push(`${pad(3)}type: http`)
  y.push(`${pad(3)}scheme: bearer`)
  y.push(`${pad(3)}bearerFormat: JWT`)
  y.push('paths:')
  for (const a of apis) {
    y.push(`${pad(1)}${a.path}:`)
    y.push(`${pad(2)}${a.method.toLowerCase()}:`)
    y.push(`${pad(3)}summary: ${a.purpose.replace(/[:"]/g, '')}`)
    y.push(`${pad(3)}operationId: ${a.method.toLowerCase()}${a.path.split('/').filter(Boolean).map((p) => p.replace(/[^a-zA-Z0-9]/g, '_')).map((p) => p.charAt(0).toUpperCase() + p.slice(1)).join('')}`)
    const tags = parse<string[]>(a.linkedEntities, [])
    if (tags.length) y.push(`${pad(3)}tags: [${tags.join(', ')}]`)
    const needsAuth = (a.auth ?? '').toLowerCase() !== 'public'
    if (needsAuth) {
      y.push(`${pad(3)}security:`)
      y.push(`${pad(4)}- bearerAuth: []`)
    }
    const pathParams = [...a.path.matchAll(/\{([^}]+)\}/g)].map((m) => m[1])
    for (const p of pathParams) {
      y.push(`${pad(3)}parameters:`)
      y.push(`${pad(4)}- name: ${p}`)
      y.push(`${pad(5)}in: path`)
      y.push(`${pad(5)}required: true`)
      y.push(`${pad(5)}schema:`)
      y.push(`${pad(6)}type: string`)
    }
    const request = parse<Array<{ field: string; type: string; required?: boolean; notes?: string }>>(a.request, [])
    if (['POST', 'PATCH', 'PUT'].includes(a.method) && request.length) {
      const req = request.filter((f) => f.required).map((f) => f.field)
      y.push(`${pad(3)}requestBody:`)
      y.push(`${pad(4)}required: true`)
      y.push(`${pad(4)}content:`)
      y.push(`${pad(5)}application/json:`)
      y.push(`${pad(6)}schema:`)
      y.push(`${pad(7)}type: object`)
      if (req.length) y.push(`${pad(7)}required: [${req.join(', ')}]`)
      y.push(`${pad(7)}properties:`)
      for (const f of request) {
        y.push(`${pad(8)}${f.field}:`)
        y.push(`${pad(9)}type: ${openApiType(f.type)}`)
        if ((f.type || '').toLowerCase().includes('datetime')) y.push(`${pad(9)}format: date-time`)
        if (f.notes) y.push(`${pad(9)}description: "${f.notes.replace(/"/g, "'")}"`)
      }
    }
    y.push(`${pad(3)}responses:`)
    const successCode = a.method === 'POST' ? '201' : a.method === 'DELETE' ? '204' : '200'
    const response = parse<Array<{ field: string; type: string; description?: string }>>(a.response, [])
    y.push(`${pad(4)}'${successCode}':`)
    if (a.method === 'DELETE') {
      y.push(`${pad(5)}description: Deleted successfully.`)
    } else {
      y.push(`${pad(5)}description: Success.`)
      if (response.length) {
        y.push(`${pad(5)}content:`)
        y.push(`${pad(6)}application/json:`)
        y.push(`${pad(7)}schema:`)
        y.push(`${pad(8)}type: object`)
        y.push(`${pad(8)}properties:`)
        for (const f of response) {
          y.push(`${pad(9)}${f.field}:`)
          y.push(`${pad(10)}type: ${openApiType(f.type)}`)
          if ((f.type || '').toLowerCase().includes('datetime')) y.push(`${pad(10)}format: date-time`)
          if (f.description) y.push(`${pad(10)}description: "${f.description.replace(/"/g, "'")}"`)
        }
      }
    }
    const errors = parse<Array<{ code: string; when: string }>>(a.errors, [])
    const byStatus = new Map<string, string[]>()
    for (const e of errors) {
      const m = e.code.match(/^(\d{3})/)
      const status = m ? m[1] : '400'
      byStatus.set(status, [...(byStatus.get(status) ?? []), `${e.code.replace(/^\d{3}\s*/, '')} — ${e.when}`])
    }
    if (!byStatus.has('401') && needsAuth) byStatus.set('401', ['UNAUTHORIZED — missing or invalid token'])
    for (const [status, descs] of [...byStatus.entries()].sort()) {
      y.push(`${pad(4)}'${status}':`)
      y.push(`${pad(5)}description: "${descs.join(' | ').replace(/"/g, "'").slice(0, 300)}"`)
    }
  }
  y.push('')
  return y.join('\n')
}

function envRows(
  integrations: Array<{ system: string; purpose: string; necessity: string }>,
  techStack: Array<{ area: string; choice: string }>
): Array<{ name: string; required: string; source: string }> {
  const rows: Array<{ name: string; required: string; source: string }> = [
    { name: 'DATABASE_URL', required: 'required', source: 'Connection string of the database chosen in the tech stack table' },
    { name: 'APP_SECRET', required: 'required', source: 'Token/session signing secret — generate with: openssl rand -hex 32' },
    { name: 'APP_URL', required: 'production', source: 'Public base URL of the deployment (used in links, emails, CORS)' },
  ]
  for (const i of integrations) {
    const slug = i.system.toUpperCase().replace(/[^A-Z0-9]+/g, '_')
    const required = /required|FR-\d+/i.test(i.necessity) ? 'required' : 'if used'
    rows.push({ name: `${slug}_API_KEY`, required, source: `Obtain from the ${i.system} provider — ${i.purpose}` })
  }
  for (const t of techStack) {
    if (/notification|sms|email|mail/i.test(t.area) && !rows.some((r) => r.name.startsWith('SMTP'))) {
      rows.push({ name: 'SMTP_URL', required: 'if used', source: `SMTP connection string for the chosen ${t.area} service (${t.choice})` })
    }
  }
  return rows
}

export async function GET(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const format = new URL(req.url).searchParams.get('format') === 'json' ? 'json' : 'md'

    const idea = await db.idea.findUnique({
      where: { id },
      include: {
        questions: { where: { status: 'answered' }, orderBy: [{ order: 'asc' }] },
        features: { orderBy: [{ order: 'asc' }] },
        assumptions: { orderBy: { createdAt: 'asc' } },
        decisions: { orderBy: { createdAt: 'asc' } },
        requirements: { orderBy: [{ order: 'asc' }] },
        processes: { orderBy: [{ order: 'asc' }] },
        entities: { orderBy: [{ order: 'asc' }] },
        apiEndpoints: { orderBy: [{ order: 'asc' }] },
        screens: { orderBy: [{ order: 'asc' }] },
        tasks: { orderBy: [{ order: 'asc' }] },
        risks: { orderBy: [{ order: 'asc' }] },
        issues: { orderBy: { createdAt: 'desc' } },
        architecture: true,
        tradeStudy: true,
        adrs: { orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] },
        threatModel: true,
        scaleReport: true,
        testCases: { orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] },
        testCoverage: true,
        edgeCases: true,
        e2eScenarios: { orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] },
      },
    })
    if (!idea) {
      return Response.json({ error: 'Idea not found' }, { status: 404 })
    }

    const interpretation = parseInterpretation(idea.interpretation)
    const summary = parseSummary(idea.summary)
    const roles = parse<Array<{ name: string; description: string; permissions: string[] }>>(idea.roles, [])
    const slug = (interpretation?.title ?? idea.title)
      .toLowerCase()
      .replace(/[^a-z0-9]+/g, '-')
      .replace(/^-|-$/g, '')
      .slice(0, 50) || 'project'

    const frs = idea.requirements.filter((r) => r.type === 'functional' && r.status === 'confirmed')
    const nfrs = idea.requirements.filter((r) => r.type === 'non_functional' && r.status === 'confirmed')
    const unresolved = idea.requirements.filter((r) => r.status === 'unresolved')
    const confirmedProcesses = idea.processes.filter((p) => p.status === 'confirmed')
    const confirmedEntities = idea.entities.filter((e) => e.status === 'confirmed')
    const confirmedApis = idea.apiEndpoints.filter((a) => a.status === 'confirmed')
    const confirmedScreens = idea.screens.filter((s) => s.status === 'confirmed')
    const confirmedTasks = idea.tasks.filter((t) => t.status === 'confirmed')
    const reviewedRisks = idea.risks.filter((r) => r.status !== 'proposed')
    const confirmedAdrs = idea.adrs.filter((a) => a.status === 'confirmed')
    const confirmedTestCases = idea.testCases.filter((c) => c.status === 'confirmed')
    const confirmedE2e = idea.e2eScenarios.filter((s) => s.status === 'confirmed')

    // Developer-handoff derivations (deterministic — no AI)
    const constitutionRules = await db.constitutionRule.findMany({
      where: { OR: [{ ideaId: id }, { ideaId: null }], enabled: true },
      orderBy: [{ ideaId: 'desc' }, { order: 'asc' }, { createdAt: 'asc' }],
    })
    const techStack = idea.architecture ? parse<Array<{ area: string; choice: string }>>(idea.architecture.techStack, []) : []
    const integrations = idea.architecture ? parse<Array<{ system: string; purpose: string; necessity: string }>>(idea.architecture.integrations, []) : []
    const environment = envRows(integrations, techStack)
    const authChoice = techStack.find((t) => /auth/i.test(t.area))?.choice ?? null
    const authEndpoints = confirmedApis.filter((a) => /auth|login|session|register|logout|token/i.test(a.path))
    const openapi = openApiSpec(idea.title, confirmedApis)
    const glossaryRows: Array<{ en: string; ar: string | null; kind: string }> = [
      ...confirmedEntities.map((e) => ({ en: e.name, ar: e.nameAr, kind: 'entity' })),
      ...confirmedProcesses.map((p) => ({ en: p.name, ar: p.nameAr, kind: 'process' })),
      ...confirmedScreens.map((s) => ({ en: s.name, ar: s.nameAr, kind: 'screen' })),
    ].filter((g) => g.ar)

    // ---------- Traceability matrix ----------
    const procLinks = new Map<string, string[]>()
    for (const p of confirmedProcesses) {
      for (const code of parse<string[]>(p.linkedRequirements, [])) {
        procLinks.set(code, [...(procLinks.get(code) ?? []), p.code])
      }
    }
    const apiLinks = new Map<string, string[]>()
    for (const a of confirmedApis) {
      for (const code of parse<string[]>(a.linkedRequirements, [])) {
        apiLinks.set(code, [...(apiLinks.get(code) ?? []), a.code])
      }
    }
    const screenLinks = new Map<string, string[]>()
    for (const s of confirmedScreens) {
      for (const code of parse<string[]>(s.linkedRequirements, [])) {
        screenLinks.set(code, [...(screenLinks.get(code) ?? []), s.code])
      }
    }
    const taskLinks = new Map<string, string[]>()
    for (const t of confirmedTasks) {
      for (const code of parse<string[]>(t.requirementCodes, [])) {
        taskLinks.set(code, [...(taskLinks.get(code) ?? []), t.code])
      }
    }

    if (format === 'json') {
      const payload = {
        product: 'AI Software Engineer — engineering package',
        exportedAt: new Date().toISOString(),
        readiness: 'locked',
        productDefinition: {
          title: idea.title,
          originalText: idea.originalText,
          interpretation,
          discoverySummary: summary,
          discoveryQA: idea.questions.map((q) => ({ area: q.area, question: q.questionEn, answer: q.answer })),
          roles,
          featureBaseline: idea.features
            .filter((f) => f.status === 'accepted')
            .map((f) => ({ module: f.module, feature: f.feature, user: f.user, priority: f.priority })),
        },
        functionalAnalysis: {
          processes: confirmedProcesses.map((p) => ({
            code: p.code,
            name: p.name,
            trigger: p.trigger,
            actors: parse<string[]>(p.actors, []),
            steps: parse<unknown[]>(p.steps, []),
            businessRules: parse<unknown[]>(p.businessRules, []),
            exceptions: parse<string[]>(p.exceptions, []),
            linkedRequirements: parse<string[]>(p.linkedRequirements, []),
          })),
        },
        dataAndApi: {
          erd: mermaidErd(confirmedEntities),
          entities: confirmedEntities.map((e) => ({
            code: e.code,
            name: e.name,
            fields: parse<unknown[]>(e.fields, []),
            relationships: parse<unknown[]>(e.relationships, []),
            constraints: parse<string[]>(e.constraints, []),
          })),
          apis: confirmedApis.map((a) => ({
            code: a.code,
            method: a.method,
            path: a.path,
            purpose: a.purpose,
            auth: a.auth,
            request: parse<unknown[]>(a.request, []),
            response: parse<unknown[]>(a.response, []),
            errors: parse<unknown[]>(a.errors, []),
            linkedRequirements: parse<string[]>(a.linkedRequirements, []),
          })),
          referenceDdl: confirmedEntities.map((e) => ddlForEntity(e)).join('\n'),
        },
        architectureLab: {
          tradeStudy:
            idea.tradeStudy && idea.tradeStudy.status === 'confirmed'
              ? {
                  recommended: idea.tradeStudy.recommended,
                  rationale: idea.tradeStudy.rationale,
                  candidates: parse<unknown[]>(idea.tradeStudy.candidates, []),
                }
              : null,
          decisionRecords: confirmedAdrs.map((a) => ({
            code: a.code,
            title: a.title,
            context: a.context,
            decision: a.decision,
            alternatives: parse<unknown[]>(a.alternatives, []),
            consequences: parse<unknown>(a.consequences, {}),
            linkedRequirements: parse<string[]>(a.linkedRequirements, []),
          })),
          threatModel:
            idea.threatModel && idea.threatModel.status === 'confirmed'
              ? {
                  summary: idea.threatModel.summary,
                  residual: idea.threatModel.residual,
                  findings: parse<unknown[]>(idea.threatModel.findings, []),
                }
              : null,
          scaleReport:
            idea.scaleReport && idea.scaleReport.status === 'confirmed'
              ? {
                  assumptions: parse<unknown[]>(idea.scaleReport.assumptions, []),
                  bottlenecks: parse<unknown[]>(idea.scaleReport.bottlenecks, []),
                  scenarios: parse<unknown[]>(idea.scaleReport.scenarios, []),
                  plan: idea.scaleReport.plan,
                }
              : null,
        },
        uiUx: confirmedScreens.map((s) => ({
          code: s.code,
          name: s.name,
          route: s.route,
          roles: parse<string[]>(s.roles, []),
          elements: parse<unknown[]>(s.elements, []),
          states: parse<Record<string, string>>(s.states, {}),
          rtlNote: s.rtlNote,
          linkedRequirements: parse<string[]>(s.linkedRequirements, []),
        })),
        qualityAndOperations: {
          nonFunctionalRequirements: nfrs.map((r) => ({ code: r.code, title: r.title, description: r.description, acceptanceCriteria: parse<string[]>(r.acceptanceCriteria, []) })),
          qaLab: {
            testCoverage:
              idea.testCoverage && idea.testCoverage.status === 'confirmed'
                ? {
                    score: idea.testCoverage.score,
                    covered: parse<unknown[]>(idea.testCoverage.covered, []),
                    uncovered: parse<unknown[]>(idea.testCoverage.uncovered, []),
                  }
                : null,
            testCases: confirmedTestCases.map((c) => ({
              code: c.code,
              title: c.title,
              level: c.level,
              kind: c.kind,
              linkedRequirement: c.linkedRequirement,
              linkedCriterion: c.linkedCriterion,
              preconditions: parse<string[]>(c.preconditions, []),
              steps: parse<string[]>(c.steps, []),
              expected: c.expected,
              priority: c.priority,
            })),
            edgeCases:
              idea.edgeCases && idea.edgeCases.status === 'confirmed'
                ? { groups: parse<unknown[]>(idea.edgeCases.groups, []), note: idea.edgeCases.note }
                : null,
            e2eScenarios: confirmedE2e.map((s) => ({
              code: s.code,
              title: s.title,
              persona: s.persona,
              given: parse<string[]>(s.given, []),
              when: parse<string[]>(s.when, []),
              then: parse<string[]>(s.then, []),
              screens: parse<string[]>(s.screens, []),
              priority: s.priority,
              linkedRequirements: parse<string[]>(s.linkedRequirements, []),
            })),
          },
          risks: reviewedRisks.map((r) => ({
            code: r.code,
            category: r.category,
            description: r.description,
            likelihood: r.likelihood,
            impact: r.impact,
            mitigation: r.mitigation,
            decision: r.status,
            basis: r.basis,
          })),
        },
        implementationPlan: confirmedTasks.map((t) => ({
          code: t.code,
          title: t.title,
          phase: t.phase,
          priority: t.priority,
          dependsOn: parse<string[]>(t.dependsOn, []),
          description: t.description,
          acceptanceCriteria: parse<string[]>(t.acceptanceCriteria, []),
          deliverable: t.deliverable,
          requirementCodes: parse<string[]>(t.requirementCodes, []),
          estimate: t.estimate,
        })),
        traceability: idea.requirements
          .filter((r) => r.status === 'confirmed')
          .map((r) => ({
            code: r.code,
            title: r.title,
            processes: procLinks.get(r.code) ?? [],
            apis: apiLinks.get(r.code) ?? [],
            screens: screenLinks.get(r.code) ?? [],
            tasks: taskLinks.get(r.code) ?? [],
          })),
        authModel: {
          mechanism: authChoice,
          tokenStrategy: 'JWT bearer tokens (Authorization: Bearer <token>) as modeled in the OpenAPI skeleton; adapt if the chosen auth stack differs',
          loginEndpoints: authEndpoints.map((a) => `${a.method} ${a.path}`),
          endpointAccess: confirmedApis.map((a) => ({ code: a.code, method: a.method, path: a.path, allowed: a.auth ?? 'any authenticated user' })),
          baselinePractices: [
            'Hash passwords with bcrypt or argon2 — never store plaintext or reversible encodings',
            'Return the same error for wrong email and wrong password (no user enumeration)',
            'Rate-limit all authentication endpoints (per IP and per account)',
            'Enforce the role from the endpoint access matrix in middleware on EVERY protected route — never only in the UI',
            'Expire tokens reasonably and provide an explicit logout/revocation path',
          ],
        },
        developerSetup: {
          environment,
          bootstrap: [
            'Create the repository with the suggested layout (section 07 of the Markdown package)',
            'Scaffold the project per the tech stack table',
            'Install dependencies for the chosen stack',
            'Create .env from the environment table — never commit secrets',
            'Create the database and apply the reference DDL through the stack migration tool',
            'Seed the first admin plus one test account per role (test-only credentials)',
            'Run the dev server and verify every confirmed screen route renders',
            'Implement Phase 1 of the plan and run the test suite (section 05)',
            'Before each merge: re-run the acceptance criteria of the touched requirements (Appendix A)',
          ],
        },
        codingStandards: constitutionRules.map((r) => ({ scope: r.ideaId === null ? 'global' : 'project', category: r.category, text: r.text })),
        openapi,
        glossary: glossaryRows,
        registers: {
          assumptions: idea.assumptions.map((a) => ({ text: a.text, kind: a.kind, status: a.status })),
          unresolvedRequirements: unresolved.map((r) => ({ code: r.code, title: r.title, evidence: r.evidence })),
          decisionHistory: idea.decisions.map((d) => ({ at: d.createdAt.toISOString(), action: d.action, detail: d.detail })),
        },
      }
      return new Response(JSON.stringify(payload, null, 2), {
        headers: {
          'Content-Type': 'application/json; charset=utf-8',
          'Content-Disposition': `attachment; filename="engineering-package-${slug}.json"`,
        },
      })
    }

    // ---------- Markdown package (English, professional) ----------
    const L: string[] = []
    L.push(`# Engineering Package — ${idea.title}`)
    L.push('')
    L.push(`> Implementation-ready specification produced by the AI Software Engineer on ${new Date().toDateString()}. Seven sections + appendices: a developer who never saw the original conversation can build the system from this document alone — data model with reference DDL, API contracts with request AND response schemas plus an OpenAPI skeleton, auth model, UI spec, test plan, and a bootstrap guide.`)
    L.push('')

    // 01 — Product Definition
    L.push('## 01 — Product Definition')
    L.push('')
    L.push('### Original idea')
    L.push('')
    L.push(`> ${idea.originalText.replace(/\n/g, '\n> ')}`)
    L.push('')
    if (interpretation) {
      L.push('### Problem statement')
      L.push('')
      L.push(interpretation.problemStatement)
      L.push('')
      L.push('### English interpretation')
      L.push('')
      L.push(interpretation.englishInterpretation)
      L.push('')
    }
    if (summary) {
      L.push('### Discovery summary')
      L.push('')
      L.push(summary.summaryMarkdown)
      L.push('')
    }
    if (roles.length) {
      L.push('### Users and roles')
      L.push('')
      L.push('| Role | Description | Key permissions |')
      L.push('| --- | --- | --- |')
      for (const r of roles) L.push(`| ${esc(r.name)} | ${esc(r.description)} | ${esc(r.permissions.join(', '))} |`)
      L.push('')
    }
    L.push('### Approved feature scope')
    L.push('')
    L.push('| Module | Feature | User | Priority |')
    L.push('| --- | --- | --- | --- |')
    for (const f of idea.features.filter((f) => f.status === 'accepted')) {
      L.push(`| ${esc(f.module)} | ${esc(f.feature)} | ${esc(f.user)} | ${f.priority} |`)
    }
    L.push('')

    // 02 — Functional Analysis
    L.push('## 02 — Functional Analysis')
    L.push('')
    L.push('### Confirmed functional requirements')
    L.push('')
    L.push('| Code | Requirement | Priority | Provenance |')
    L.push('| --- | --- | --- | --- |')
    for (const r of frs) {
      L.push(`| ${r.code} | ${esc(r.title)} | ${r.priority} | ${r.provenance === 'client' ? 'client' : 'AI-suggested, client-approved'} |`)
    }
    L.push('')
    L.push('### Business processes')
    L.push('')
    for (const p of confirmedProcesses) {
      L.push(`#### ${p.code} — ${p.name}${p.nameAr ? ` (${p.nameAr})` : ''}`)
      L.push('')
      if (p.trigger) L.push(`**Trigger:** ${p.trigger}`)
      const actors = parse<string[]>(p.actors, [])
      if (actors.length) L.push(`**Actors:** ${actors.join(', ')}`)
      L.push('')
      L.push('| # | Actor | Action | Input | Output | Decision / Exception |')
      L.push('| --- | --- | --- | --- | --- | --- |')
      for (const s of parse<Array<Record<string, string>>>(p.steps, [])) {
        L.push(
          `| ${s.n ?? ''} | ${esc(s.actor) ?? ''} | ${esc(s.action)} | ${esc(s.input) ?? '—'} | ${esc(s.output) ?? '—'} | ${esc(s.decision ?? s.exception) ?? '—'} |`
        )
      }
      L.push('')
      const rules = parse<Array<{ rule: string; linkedRequirements: string[] }>>(p.businessRules, [])
      if (rules.length) {
        L.push('**Business rules:**')
        L.push('')
        for (const b of rules) {
          L.push(`- ${b.rule}${b.linkedRequirements.length ? ` _(${b.linkedRequirements.join(', ')})_` : ''}`)
        }
        L.push('')
      }
      const exceptions = parse<string[]>(p.exceptions, [])
      if (exceptions.length) {
        L.push('**Edge / failure scenarios:**')
        L.push('')
        for (const e of exceptions) L.push(`- ${e}`)
        L.push('')
      }
    }
    if (unresolved.length) {
      L.push('### Open decisions (deliberately unresolved at lock time)')
      L.push('')
      L.push('These were NOT silently decided. They are excluded from the confirmed scope above and must be decided before the corresponding parts are implemented:')
      L.push('')
      for (const r of unresolved) L.push(`- **${r.code}** ${r.title} — ${r.evidence ?? 'needs a client decision'}`)
      L.push('')
    }

    // 03 — Data & API Design
    L.push('## 03 — Data & API Design')
    L.push('')
    L.push('### Entity-relationship diagram')
    L.push('')
    L.push('```mermaid')
    L.push(mermaidErd(confirmedEntities))
    L.push('```')
    L.push('')
    L.push('### Data dictionary')
    L.push('')
    for (const e of confirmedEntities) {
      L.push(`#### ${e.code} — ${e.name}`)
      L.push('')
      if (e.description) L.push(`${e.description}`)
      L.push('')
      L.push('| Field | Type | Required | Unique | Description |')
      L.push('| --- | --- | --- | --- | --- |')
      for (const f of parse<Array<Record<string, unknown>>>(e.fields, [])) {
        L.push(
          `| ${esc(String(f.name ?? ''))} | ${esc(String(f.type ?? ''))} | ${f.required ? 'yes' : 'no'} | ${f.unique ? 'yes' : 'no'} | ${esc(String(f.description ?? ''))}${f.refEntity ? ` (→ ${f.refEntity})` : ''} |`
        )
      }
      L.push('')
      const rels = parse<Array<{ target: string; type: string; description: string }>>(e.relationships, [])
      if (rels.length) {
        L.push(`**Relationships:** ${rels.map((r) => `${r.type} → ${r.target} (${r.description})`).join('; ')}`)
        L.push('')
      }
      const constraints = parse<string[]>(e.constraints, [])
      if (constraints.length) {
        L.push(`**Constraints:** ${constraints.join('; ')}`)
        L.push('')
      }
    }
    if (confirmedEntities.length) {
      L.push('### Reference SQL DDL')
      L.push('')
      L.push('> Deterministic translation of the data dictionary above — adapt data types to the exact database chosen in the tech stack (e.g. JSONB → JSON on MySQL, VARCHAR(64) ids → UUID if your stack generates UUIDs). Apply through the stack’s migration tool, never by hand on production.')
      L.push('')
      L.push('```sql')
      for (const e of confirmedEntities) L.push(ddlForEntity(e))
      L.push('```')
      L.push('')
    }
    L.push('### API contracts')
    L.push('')
    for (const a of confirmedApis) {
      L.push(`#### ${a.code} — ${a.method} \`${a.path}\``)
      L.push('')
      L.push(`${a.purpose}`)
      L.push('')
      L.push(`**Auth:** ${a.auth ?? 'any authenticated user'}`)
      L.push('')
      const request = parse<Array<Record<string, unknown>>>(a.request, [])
      if (request.length) {
        L.push('| Request field | Type | Required | Validation |')
        L.push('| --- | --- | --- | --- |')
        for (const f of request) {
          L.push(`| ${esc(String(f.field ?? ''))} | ${esc(String(f.type ?? ''))} | ${f.required ? 'yes' : 'no'} | ${esc(String(f.notes ?? ''))} |`)
        }
        L.push('')
      }
      const response = parse<Array<Record<string, unknown>>>(a.response, [])
      if (response.length) {
        L.push(`**Success response (${a.method === 'POST' ? '201' : a.method === 'DELETE' ? '204' : '200'}):**`)
        L.push('')
        L.push('| Response field | Type | Description |')
        L.push('| --- | --- | --- |')
        for (const f of response) {
          L.push(`| ${esc(String(f.field ?? ''))} | ${esc(String(f.type ?? ''))} | ${esc(String(f.description ?? ''))} |`)
        }
        L.push('')
      }
      const errors = parse<Array<{ code: string; when: string }>>(a.errors, [])
      if (errors.length) {
        L.push(`**Errors:** ${errors.map((e) => `\`${e.code}\` — ${e.when}`).join(' · ')}`)
        L.push('')
      }
      const linkedReqs = parse<string[]>(a.linkedRequirements, [])
      if (linkedReqs.length) L.push(`**Serves:** ${linkedReqs.join(', ')}`)
      L.push('')
    }

    // ---------- Authentication & authorization model ----------
    L.push('### Authentication & authorization model')
    L.push('')
    if (authChoice) {
      L.push(`**Mechanism (from the tech stack):** ${authChoice}.`)
      L.push('')
    }
    L.push('**Token strategy:** JWT bearer tokens (`Authorization: Bearer <token>`) as modeled in the OpenAPI skeleton (Appendix D). Adapt if the chosen auth stack mandates another flow — the access matrix below is the contract either way.')
    L.push('')
    if (authEndpoints.length) {
      L.push(`**Session endpoints:** ${authEndpoints.map((a) => `\`${a.method} ${a.path}\``).join(' · ')}`)
      L.push('')
    }
    L.push('**Endpoint access matrix — enforce server-side on every route:**')
    L.push('')
    L.push('| Endpoint | Method | Allowed |')
    L.push('| --- | --- | --- |')
    for (const a of confirmedApis) {
      L.push(`| \`${a.path}\` | ${a.method} | ${esc(a.auth ?? 'any authenticated user')} |`)
    }
    L.push('')
    L.push('**Baseline practices (non-negotiable):**')
    L.push('')
    L.push('- Hash passwords with bcrypt or argon2 — never store plaintext or reversible encodings.')
    L.push('- Return the same error for a wrong email and a wrong password (no user enumeration).')
    L.push('- Rate-limit all authentication endpoints (per IP and per account).')
    L.push('- Check the role in middleware on EVERY protected route — never only in the UI.')
    L.push('- Expire tokens reasonably and provide an explicit logout/revocation path.')
    L.push('')
    if (idea.architecture) {
      const arch = idea.architecture
      L.push('### Architecture')
      L.push('')
      const components = parse<Array<{ name: string; responsibility: string }>>(arch.components, [])
      if (components.length) {
        L.push('| Component | Responsibility |')
        L.push('| --- | --- |')
        for (const c of components) L.push(`| ${esc(c.name)} | ${esc(c.responsibility)} |`)
        L.push('')
      }
      const tech = parse<Array<{ area: string; choice: string; rationale: string; tradeOffs: string; simplestOption: boolean }>>(arch.techStack, [])
      if (tech.length) {
        L.push('| Area | Recommendation | Rationale | Trade-offs | Simplest option |')
        L.push('| --- | --- | --- | --- | --- |')
        for (const t of tech) {
          L.push(`| ${esc(t.area)} | ${esc(t.choice)} | ${esc(t.rationale)} | ${esc(t.tradeOffs)} | ${t.simplestOption ? 'yes' : 'no'} |`)
        }
        L.push('')
      }
      const integrations = parse<Array<{ system: string; purpose: string; necessity: string }>>(arch.integrations, [])
      if (integrations.length) {
        L.push(`**Integrations:** ${integrations.map((i) => `${i.system} — ${i.purpose} (${i.necessity})`).join(' · ')}`)
        L.push('')
      }
      if (arch.notes) {
        L.push(`**Notes:** ${arch.notes}`)
        L.push('')
      }
    }
    if (idea.tradeStudy && idea.tradeStudy.status === 'confirmed') {
      const ts = idea.tradeStudy
      L.push('### Architecture trade-off study')
      L.push('')
      L.push(`**Recommended: ${ts.recommended}**${ts.rationale ? ` — ${ts.rationale}` : ''}`)
      L.push('')
      const candidates = parse<Array<{ name: string; style: string; summary: string; pros: string[]; cons: string[]; cost: string; complexity: string; teamFit: string; risks: string[]; fit: string }>>(ts.candidates, [])
      L.push('| Candidate | Style | Cost | Complexity | Pros | Cons |')
      L.push('| --- | --- | --- | --- | --- | --- |')
      for (const c of candidates) {
        L.push(`| ${c.name === ts.recommended ? `**${esc(c.name)}**` : esc(c.name)} | ${esc(c.style)} | ${esc(c.cost)} | ${esc(c.complexity)} | ${c.pros.map(esc).join(' · ')} | ${c.cons.map(esc).join(' · ')} |`)
      }
      L.push('')
    }
    if (confirmedAdrs.length) {
      L.push('### Architecture decision records (ADRs)')
      L.push('')
      for (const a of confirmedAdrs) {
        L.push(`#### ${a.code} — ${a.title}`)
        L.push('')
        L.push(`**Context.** ${a.context}`)
        L.push('')
        L.push(`**Decision.** ${a.decision}`)
        L.push('')
        const alts = parse<Array<{ option: string; whyNot: string }>>(a.alternatives, [])
        if (alts.length) {
          L.push(`**Alternatives rejected:** ${alts.map((x) => `${x.option} (${x.whyNot})`).join(' · ')}`)
          L.push('')
        }
        const conseq = parse<{ positive?: string[]; negative?: string[]; risks?: string[] }>(a.consequences, {})
        const conseqParts: string[] = []
        if (conseq.positive?.length) conseqParts.push(`positive: ${conseq.positive.join(' · ')}`)
        if (conseq.negative?.length) conseqParts.push(`negative: ${conseq.negative.join(' · ')}`)
        if (conseq.risks?.length) conseqParts.push(`risks: ${conseq.risks.join(' · ')}`)
        if (conseqParts.length) {
          L.push(`**Consequences.** ${conseqParts.join(' — ')}`)
          L.push('')
        }
        const linked = parse<string[]>(a.linkedRequirements, [])
        if (linked.length) L.push(`**Serves:** ${linked.join(', ')}`)
        L.push('')
      }
    }

    // 04 — UI/UX Specification
    L.push('## 04 — UI/UX Specification')
    L.push('')
    if (confirmedScreens.length) {
      L.push('### Route map')
      L.push('')
      L.push('| Screen | Route | Roles |')
      L.push('| --- | --- | --- |')
      for (const s of confirmedScreens) {
        L.push(`| ${esc(s.name)} | \`${s.route ?? '—'}\` | ${esc(parse<string[]>(s.roles, []).join(', ') || 'all')} |`)
      }
      L.push('')
    }
    for (const s of confirmedScreens) {
      L.push(`#### ${s.code} — ${s.name}${s.nameAr ? ` (${s.nameAr})` : ''}`)
      L.push('')
      if (s.route) L.push(`**Route:** \`${s.route}\` · **Roles:** ${parse<string[]>(s.roles, []).join(', ') || 'all'}`)
      if (s.purpose) L.push(`**Purpose:** ${s.purpose}`)
      L.push('')
      const elements = parse<Array<{ element: string; behavior: string }>>(s.elements, [])
      if (elements.length) {
        L.push('| Element | Behavior |')
        L.push('| --- | --- |')
        for (const el of elements) L.push(`| ${esc(el.element)} | ${esc(el.behavior)} |`)
        L.push('')
      }
      const states = parse<{ loading?: string; empty?: string; error?: string }>(s.states, {})
      L.push(`**States** — Loading: ${states.loading ?? '—'} · Empty: ${states.empty ?? '—'} · Error: ${states.error ?? '—'}`)
      L.push('')
      if (s.rtlNote) L.push(`**RTL:** ${s.rtlNote}`)
      const linkedReqs = parse<string[]>(s.linkedRequirements, [])
      if (linkedReqs.length) L.push(`**Implements:** ${linkedReqs.join(', ')}`)
      L.push('')
    }

    // 05 — Quality & Operations
    L.push('## 05 — Quality & Operations')
    L.push('')
    if (constitutionRules.length) {
      L.push('### Coding standards (project constitution)')
      L.push('')
      L.push('Active rules the implementation must obey — global rules apply to every project, project rules were derived from this product’s approved context:')
      L.push('')
      for (const scope of ['global', 'project'] as const) {
        const group = constitutionRules.filter((r) => (r.ideaId === null ? 'global' : 'project') === scope)
        if (!group.length) continue
        L.push(`**${scope === 'global' ? 'Global' : 'Project-specific'}:**`)
        L.push('')
        for (const r of group) L.push(`- _${r.category}_ — ${esc(r.text)}`)
        L.push('')
      }
    }
    L.push('### Non-functional requirements')
    L.push('')
    L.push('| Code | Requirement | Category | Acceptance criteria |')
    L.push('| --- | --- | --- | --- |')
    for (const r of nfrs) {
      L.push(`| ${r.code} | ${esc(r.title)} | ${esc(r.category)} | ${esc(parse<string[]>(r.acceptanceCriteria, []).join(' · '))} |`)
    }
    L.push('')
    L.push('### Risk register (with mitigation decisions)')
    L.push('')
    L.push('| Code | Category | Risk | Likelihood | Impact | Mitigation | Decision | Basis |')
    L.push('| --- | --- | --- | --- | --- | --- | --- | --- |')
    for (const r of reviewedRisks) {
      L.push(`| ${r.code} | ${r.category} | ${esc(r.description)} | ${r.likelihood} | ${r.impact} | ${esc(r.mitigation)} | ${r.status} | ${r.basis === 'verified_fact' ? 'fact' : 'judgment'} |`)
    }
    L.push('')
    L.push('### Verification strategy')
    L.push('')
    L.push('Every confirmed requirement ships with testable acceptance criteria; the implementation is complete only when each passes:')
    L.push('')
    for (const r of idea.requirements.filter((x) => x.status === 'confirmed')) {
      L.push(`- **${r.code} — ${r.title}**`)
      for (const c of parse<string[]>(r.acceptanceCriteria, [])) L.push(`  - ${c}`)
    }
    L.push('')
    if (confirmedTestCases.length > 0) {
      L.push('### Test suite (confirmed cases)')
      L.push('')
      if (idea.testCoverage && idea.testCoverage.status === 'confirmed') {
        L.push(`**Acceptance-criteria coverage: ${idea.testCoverage.score}/100** (computed by the platform from the cases below).`)
        L.push('')
      }
      L.push('| Code | Case | Level | Kind | Requirement | Criterion | Priority | Expected |')
      L.push('| --- | --- | --- | --- | --- | --- | --- | --- |')
      for (const c of confirmedTestCases) {
        L.push(
          `| ${c.code} | ${esc(c.title)} | ${c.level} | ${c.kind} | ${c.linkedRequirement} | ${c.linkedCriterion ? `#${c.linkedCriterion}` : '—'} | ${c.priority} | ${esc(c.expected)} |`
        )
      }
      L.push('')
      for (const c of confirmedTestCases) {
        const steps = parse<string[]>(c.steps, [])
        const pre = parse<string[]>(c.preconditions, [])
        if (steps.length || pre.length) {
          L.push(`#### ${c.code} — ${esc(c.title)}`)
          L.push('')
          if (pre.length) {
            L.push(`**Preconditions:** ${pre.join(' · ')}`)
            L.push('')
          }
          if (steps.length) {
            steps.forEach((s, i) => L.push(`${i + 1}. ${s}`))
            L.push('')
          }
          L.push(`**Expected:** ${esc(c.expected)}`)
          L.push('')
        }
      }
    }
    if (idea.edgeCases && idea.edgeCases.status === 'confirmed') {
      L.push('### Edge case register')
      L.push('')
      if (idea.edgeCases.note) {
        L.push(`> ${esc(idea.edgeCases.note)}`)
        L.push('')
      }
      const groups = parse<Array<{ feature: string; cases: Array<{ scenario: string; category: string; risk: string; howToTest: string; linkedRequirement: string | null }> }>>(idea.edgeCases.groups, [])
      for (const g of groups) {
        L.push(`#### ${esc(g.feature)}`)
        L.push('')
        L.push('| Category | Risk | Scenario | How to test | Req |')
        L.push('| --- | --- | --- | --- | --- |')
        for (const c of g.cases) {
          L.push(`| ${esc(c.category.replace(/_/g, ' '))} | ${c.risk} | ${esc(c.scenario)} | ${esc(c.howToTest)} | ${c.linkedRequirement ?? '—'} |`)
        }
        L.push('')
      }
    }
    if (confirmedE2e.length > 0) {
      L.push('### E2E scenarios')
      L.push('')
      for (const s of confirmedE2e) {
        L.push(`#### ${s.code} — ${esc(s.title)}${s.priority === 'smoke' ? ' (smoke)' : ''}`)
        L.push('')
        L.push(`**Persona:** ${esc(s.persona)}`)
        L.push('')
        const given = parse<string[]>(s.given, [])
        const when = parse<string[]>(s.when, [])
        const then = parse<string[]>(s.then, [])
        const screens = parse<string[]>(s.screens, [])
        const linked = parse<string[]>(s.linkedRequirements, [])
        if (given.length) L.push(`- **Given** ${given.join(' · ')}`)
        if (when.length) L.push(`- **When** ${when.join(' · ')}`)
        if (then.length) L.push(`- **Then** ${then.join(' · ')}`)
        if (screens.length) L.push(`- **Screens** ${screens.join(' → ')}`)
        if (linked.length) L.push(`- **Proves** ${linked.join(', ')}`)
        L.push('')
      }
    }
    if (idea.threatModel && idea.threatModel.status === 'confirmed') {
      const tm = idea.threatModel
      L.push('### STRIDE threat model')
      L.push('')
      if (tm.summary) {
        L.push(`**Security posture.** ${tm.summary}`)
        L.push('')
      }
      const findings = parse<Array<{ category: string; threat: string; component: string; attackPath: string; likelihood: string; impact: string; risk: string; mitigation: string }>>(tm.findings, [])
      if (findings.length) {
        L.push('| STRIDE | Threat | Component | Attack path | Risk | Mitigation |')
        L.push('| --- | --- | --- | --- | --- | --- |')
        for (const f of findings) {
          L.push(`| ${f.category} | ${esc(f.threat)} | ${esc(f.component)} | ${esc(f.attackPath)} | ${f.likelihood}/${f.impact} → ${f.risk} | ${esc(f.mitigation)} |`)
        }
        L.push('')
      }
      if (tm.residual) {
        L.push(`**Residual risk.** ${tm.residual}`)
        L.push('')
      }
    }
    if (idea.scaleReport && idea.scaleReport.status === 'confirmed') {
      const sr = idea.scaleReport
      L.push('### Scale simulation (10x / 100x)')
      L.push('')
      const assumptions = parse<Array<{ assumption: string; basis: string }>>(sr.assumptions, [])
      if (assumptions.length) {
        L.push(`**Load assumptions:** ${assumptions.map((a) => `${a.assumption} (${a.basis})`).join(' · ')}`)
        L.push('')
      }
      const bottlenecks = parse<Array<{ component: string; limit: string; why: string; symptom: string; firstFix: string }>>(sr.bottlenecks, [])
      if (bottlenecks.length) {
        L.push('| # | Bottleneck | Ceiling | Why | Symptom | First fix |')
        L.push('| --- | --- | --- | --- | --- | --- |')
        bottlenecks.forEach((b, i) => {
          L.push(`| ${i + 1} | ${esc(b.component)} | ${esc(b.limit)} | ${esc(b.why)} | ${esc(b.symptom)} | ${esc(b.firstFix)} |`)
        })
        L.push('')
      }
      const scenarios = parse<Array<{ label: string; load: string; expected: string; breaks: string; actions: string[] }>>(sr.scenarios, [])
      for (const s of scenarios) {
        L.push(`#### ${s.label}`)
        L.push('')
        L.push(`**Load:** ${s.load} · **Still works:** ${s.expected} · **Breaks:** ${s.breaks}`)
        L.push('')
        if (s.actions?.length) {
          for (const [i, a] of s.actions.entries()) L.push(`${i + 1}. ${a}`)
          L.push('')
        }
      }
      if (sr.plan) {
        L.push(`**Scaling plan.** ${sr.plan}`)
        L.push('')
      }
    }

    // 06 — Implementation Plan
    L.push('## 06 — Implementation Plan')
    L.push('')
    const phases = [...new Set(confirmedTasks.map((t) => t.phase))].sort((a, b) => a - b)
    for (const phase of phases) {
      L.push(`### Phase ${phase}`)
      L.push('')
      const tasks = confirmedTasks.filter((t) => t.phase === phase)
      for (const t of tasks) {
        const deps = parse<string[]>(t.dependsOn, [])
        L.push(`#### ${t.code} — ${t.title}`)
        L.push('')
        L.push(t.description)
        L.push('')
        L.push(`**Priority:** ${t.priority} · **Estimate:** ${t.estimate ?? 'M'} · **Deliverable:** ${t.deliverable ?? '—'}${deps.length ? ` · **Depends on:** ${deps.join(', ')}` : ''}`)
        L.push('')
        const criteria = parse<string[]>(t.acceptanceCriteria, [])
        if (criteria.length) {
          L.push('**Done when:**')
          L.push('')
          for (const c of criteria) L.push(`- ${c}`)
          L.push('')
        }
        const reqs = parse<string[]>(t.requirementCodes, [])
        if (reqs.length) L.push(`**Implements:** ${reqs.join(', ')}`)
        L.push('')
      }
    }

    // 07 — Developer setup & handoff
    L.push('## 07 — Developer Setup & Handoff')
    L.push('')
    L.push('Everything needed to go from this document to a running repository. All items are derived from the confirmed artifacts above — nothing here is a guess.')
    L.push('')
    L.push('### Environment variables')
    L.push('')
    L.push('| Variable | Needed | Source / notes |')
    L.push('| --- | --- | --- |')
    for (const v of environment) {
      L.push(`| \`${v.name}\` | ${v.required} | ${esc(v.source)} |`)
    }
    L.push('')
    L.push('Create a committed `.env.example` from this table and keep the real `.env` out of version control.')
    L.push('')
    L.push('### Bootstrap sequence')
    L.push('')
    const bootstrap = [
      'Create the repository with the suggested layout below.',
      'Scaffold the project per the tech stack table in section 03 (each area → chosen technology).',
      'Install the dependencies of the chosen stack.',
      'Create `.env` from the environment table above — never commit secrets.',
      'Create the database and apply the reference DDL (section 03) through the stack’s migration tool.',
      'Seed: the first admin account, then one test account per role (see below).',
      'Run the dev server and verify every route in the section 04 route map renders in all three UI states (loading / empty / error).',
      'Implement Phase 1 of the plan (section 06); run the test suite (section 05).',
      'Before each merge: re-run the acceptance criteria of the touched requirements (Appendix A).',
    ]
    bootstrap.forEach((s, i) => L.push(`${i + 1}. ${s}`))
    L.push('')
    if (roles.length) {
      L.push('### Seed & test accounts')
      L.push('')
      L.push('| Role | Test account (dev only) | Note |')
      L.push('| --- | --- | --- |')
      for (const r of roles) {
        const slug = r.name.toLowerCase().replace(/[^a-z0-9]+/g, '.')
        L.push(`| ${esc(r.name)} | \`test.${slug || 'user'}@example.com\` | Strong random password, stored hashed — rotate or delete before production |`)
      }
      L.push('')
    }
    L.push('### Suggested repository layout')
    L.push('')
    L.push('```text')
    L.push('src/')
    L.push('  app/            # screens & routes — one entry per row of the section 04 route map')
    L.push('  components/     # shared UI components (forms, tables, states)')
    L.push('  lib/            # business logic, services, API client, auth guards')
    L.push('  db/             # schema, migrations (from the reference DDL), seed script')
    L.push('tests/')
    L.push('  unit/           # unit tests derived from section 05 test cases')
    L.push('  e2e/            # end-to-end runs of the E2E scenarios (section 05)')
    L.push('docs/')
    L.push('  engineering-package.md   # this document')
    L.push('  openapi.yaml             # Appendix D')
    L.push('.env.example               # environment table (07)')
    L.push('```')
    L.push('')
    L.push('### Definition of done')
    L.push('')
    L.push('A phase is complete only when: every task of the phase has its “Done when” criteria passing, the acceptance criteria of every requirement the phase implements (Appendix A) pass, the test cases linked to those requirements pass, and no coding-standard rule (section 05) is violated.')
    L.push('')

    // Appendix — traceability
    L.push('## Appendix A — Requirements traceability matrix')
    L.push('')
    L.push('| Requirement | Processes | APIs | Screens | Tasks |')
    L.push('| --- | --- | --- | --- | --- |')
    for (const r of idea.requirements.filter((x) => x.status === 'confirmed')) {
      L.push(
        `| ${r.code} ${esc(r.title)} | ${(procLinks.get(r.code) ?? []).join(', ') || '—'} | ${(apiLinks.get(r.code) ?? []).join(', ') || '—'} | ${(screenLinks.get(r.code) ?? []).join(', ') || '—'} | ${(taskLinks.get(r.code) ?? []).join(', ') || '—'} |`
      )
    }
    L.push('')

    // Appendix — registers
    L.push('## Appendix B — Assumption register')
    L.push('')
    if (idea.assumptions.length === 0) {
      L.push('No assumptions were tracked for this project.')
    } else {
      L.push('| Assumption | Kind | Status |')
      L.push('| --- | --- | --- |')
      for (const a of idea.assumptions) L.push(`| ${esc(a.text)} | ${a.kind} | ${a.status} |`)
    }
    L.push('')
    L.push('## Appendix C — Decision history (audit trail)')
    L.push('')
    for (const d of idea.decisions) {
      L.push(`- **${d.action}** — ${d.createdAt.toISOString().slice(0, 16).replace('T', ' ')}${d.detail ? ` — _${d.detail}_` : ''}`)
    }
    L.push('')

    // Appendix D — OpenAPI skeleton
    if (confirmedApis.length) {
      L.push('## Appendix D — OpenAPI 3.1 skeleton')
      L.push('')
      L.push('Machine-readable contract generated from section 03 — import into Swagger UI / Postman / Insomnia to mock the backend before it exists, or generate the client SDK from it. Keep it in `docs/openapi.yaml` and update it alongside the code.')
      L.push('')
      L.push('```yaml')
      L.push(openapi)
      L.push('```')
      L.push('')
    }

    // Appendix E — Bilingual glossary
    if (glossaryRows.length) {
      L.push('## Appendix E — Bilingual glossary (EN ⇄ AR)')
      L.push('')
      L.push('| English | العربية | Kind |')
      L.push('| --- | --- | --- |')
      for (const g of glossaryRows) {
        L.push(`| ${esc(g.en)} | ${esc(g.ar ?? '')} | ${g.kind} |`)
      }
      L.push('')
    }

    return new Response(L.join('\n'), {
      headers: {
        'Content-Type': 'text/markdown; charset=utf-8',
        'Content-Disposition': `attachment; filename="engineering-package-${slug}.md"`,
      },
    })
  } catch (error) {
    console.error('[api/ideas/[id]/package/export GET]', error)
    return Response.json({ error: 'Failed to export the engineering package.' }, { status: 500 })
  }
}
