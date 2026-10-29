// Debug: run ONE chunk exactly like the engine and dump the raw model output
import ZAI from 'z-ai-web-dev-sdk'
import { safeParseJson } from '../src/lib/json-utils'
import { buildIdeaDetail } from '../src/lib/payload'
import { listRules } from '../src/lib/engines/context-pack'
import { VERIFY_CHUNK_PROMPT, buildTargets, targetsToPrompt } from '../src/lib/engines/verify'

const IDEA_ID = process.argv[2] ?? 'cmvsk37i100bgv5rzd4x1btr4'

async function main() {
  const detail = await buildIdeaDetail(IDEA_ID)
  if (!detail) throw new Error('idea not found')
  const rules = (await listRules(IDEA_ID)).filter((r) => r.enabled)
  const { targets } = buildTargets(detail, rules, 'en')
  const chunk = targets.slice(0, 10)
  console.log('chunk codes:', chunk.map((t) => t.code).join(', '))

  const code = `// app/api/auth/register/route.ts
import { NextResponse } from 'next/server'
export async function POST(req: Request) {
  const { email, password } = await req.json()
  const user = await db.user.create({ data: { email, passwordHash: await hash(password, 10) } })
  return NextResponse.json({ ok: true }, { status: 201 })
}`

  const user = [
    `UI language for your verdict texts: English.`,
    `Project: ${detail.idea.title}`,
    '',
    `ITEMS TO VERIFY (${chunk.length} in this batch — return one check object for EACH):\n\n${targetsToPrompt(chunk)}`,
    '',
    `AI-GENERATED CODE TO VERIFY (pasted by the user; it may be a partial codebase):\n"""\n${code}\n"""`,
    '',
    'Verify now. Remember: pass requires cited evidence; missing relevant files => unknown; honest verdicts only; one sentence per field.',
  ].join('\n')

  const zai = await ZAI.create()
  const completion = await zai.chat.completions.create({
    messages: [
      { role: 'assistant', content: VERIFY_CHUNK_PROMPT },
      { role: 'user', content: user },
    ],
    thinking: { type: 'disabled' },
  })
  const raw = completion.choices[0]?.message?.content ?? ''
  console.log('RAW length:', raw.length)
  console.log('=== FULL RAW ===')
  console.log(raw)
  console.log('=== END RAW ===')
  try {
    const parsed = safeParseJson<Record<string, unknown>>(raw)
    console.log('parsed keys:', Object.keys(parsed))
    const checks = parsed.checks
    console.log('typeof checks:', Array.isArray(checks) ? `array(${checks.length})` : typeof checks)
  } catch (e) {
    console.log('PARSE FAILED:', e instanceof Error ? e.message : e)
  }
}

main().then(() => process.exit(0)).catch((e) => {
  console.error('FAILED:', e)
  process.exit(1)
})
