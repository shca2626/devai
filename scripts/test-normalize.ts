// Unit test: shape-tolerant normalization of the verification matrix
import { normalizeChecks, computeScore } from '../src/lib/engines/verify'
import type { VerifyTarget } from '../src/lib/engines/verify'

const targets: VerifyTarget[] = [
  { kind: 'requirement', code: 'FR-001', title: 'User registration with email verification', priority: 'must', spec: 'x' },
  { kind: 'requirement', code: 'FR-002', title: 'Secure login system', priority: 'must', spec: 'x' },
  { kind: 'requirement', code: 'FR-010', title: 'Download specifications', priority: 'should', spec: 'x' },
  { kind: 'rule', code: 'RULE-1', title: 'TypeScript strict mode everywhere', priority: 'rule', spec: 'x' },
]

let failures = 0
function expect(name: string, cond: boolean, extra = '') {
  if (cond) console.log(`  PASS ${name}`)
  else {
    failures++
    console.log(`  FAIL ${name} ${extra}`)
  }
}

// 1. Standard shape
{
  const checks = normalizeChecks(
    {
      checks: [
        { code: 'FR-001', status: 'pass', evidence: 'route found', gap: '', fix: '' },
        { code: 'FR-002', status: 'partial', evidence: 'login exists', gap: 'no JWT', fix: 'add JWT' },
        { code: 'FR-010', status: 'fail', evidence: '', gap: 'absent', fix: 'add export' },
        { code: 'RULE-1', status: 'violated', evidence: 'any types', gap: 'strict off', fix: 'enable' },
      ],
    } as never,
    targets
  )
  expect('standard: FR-001 pass', checks[0].status === 'pass')
  expect('standard: FR-002 partial', checks[1].status === 'partial')
  expect('standard: FR-010 fail', checks[2].status === 'fail')
  expect('standard: violated -> fail', checks[3].status === 'fail')
  expect('standard: evidence kept', checks[0].evidence === 'route found')
}

// 2. Object-keyed map shape
{
  const checks = normalizeChecks(
    {
      checks: {
        'FR-001': { status: 'pass', evidence: 'a', gap: '', fix: '' },
        'FR-002': { status: 'fail', evidence: 'b', gap: 'c', fix: 'd' },
        'FR-010': { status: 'unknown', evidence: 'e', gap: 'f', fix: 'g' },
        'RULE-1': { status: 'pass', evidence: 'h', gap: '', fix: '' },
      },
    } as never,
    targets
  )
  expect('keyed: FR-001 pass', checks[0].status === 'pass', checks[0].status)
  expect('keyed: FR-002 fail', checks[1].status === 'fail', checks[1].status)
  expect('keyed: RULE-1 pass', checks[3].status === 'pass', checks[3].status)
}

// 3. Alternate code key + status synonym
{
  const checks = normalizeChecks(
    {
      checks: [
        { requirement: 'fr001', verdict: 'implemented', evidence: 'x', gap: '', fix: '' },
        { requirement: 'FR-2', verdict: 'missing', evidence: '', gap: 'y', fix: 'z' },
        { requirement: 'FR10', verdict: 'n/a', evidence: '', gap: '', fix: '' },
        { requirement: 'RULE-1', verdict: 'passed', evidence: 'q', gap: '', fix: '' },
      ],
    } as never,
    targets
  )
  expect('alt-key: fr001 implemented -> pass', checks[0].status === 'pass', checks[0].status)
  expect('alt-key: FR-2 missing -> fail', checks[1].status === 'fail', checks[1].status)
  expect('alt-key: FR10 n/a -> unknown', checks[2].status === 'unknown', checks[2].status)
  expect('alt-key: RULE-1 passed -> pass', checks[3].status === 'pass', checks[3].status)
}

// 4. Stringified JSON array
{
  const checks = normalizeChecks(
    {
      result: JSON.stringify([
        { code: 'FR-001', status: 'pass', evidence: 'x', gap: '', fix: '' },
        { code: 'FR-002', status: 'pass', evidence: 'x', gap: '', fix: '' },
        { code: 'FR-010', status: 'pass', evidence: 'x', gap: '', fix: '' },
        { code: 'RULE-1', status: 'fail', evidence: 'x', gap: 'y', fix: 'z' },
      ]),
    } as never,
    targets
  )
  expect('stringified: FR-001 pass', checks[0].status === 'pass', checks[0].status)
  expect('stringified: RULE-1 fail', checks[3].status === 'fail', checks[3].status)
}

// 5. Missing item -> unknown synthesized (honesty)
{
  const checks = normalizeChecks(
    { checks: [{ code: 'FR-001', status: 'pass', evidence: 'x', gap: '', fix: '' }] } as never,
    targets
  )
  expect('missing: FR-002 unknown', checks[1].status === 'unknown')
  expect('missing: RULE-1 unknown', checks[3].status === 'unknown')
}

// 6. Title fallback when code absent
{
  const checks = normalizeChecks(
    {
      checks: [
        { title: 'User registration with email verification', status: 'pass', evidence: 'x', gap: '', fix: '' },
        { title: 'Secure login system', status: 'fail', evidence: '', gap: 'g', fix: 'f' },
        { code: 'FR-010', status: 'unknown', evidence: '', gap: '', fix: '' },
        { code: 'RULE-1', status: 'unknown', evidence: '', gap: '', fix: '' },
      ],
    } as never,
    targets
  )
  expect('title: FR-001 pass', checks[0].status === 'pass', checks[0].status)
  expect('title: FR-002 fail', checks[1].status === 'fail', checks[1].status)
}

// 7. Deterministic score
{
  const score = computeScore([
    { kind: 'requirement', code: 'A', title: 'a', priority: 'must', status: 'pass', evidence: '', gap: '', fix: '' },
    { kind: 'requirement', code: 'B', title: 'b', priority: 'must', status: 'partial', evidence: '', gap: '', fix: '' },
    { kind: 'requirement', code: 'C', title: 'c', priority: 'must', status: 'fail', evidence: '', gap: '', fix: '' },
  ])
  // (3 + 1.5 + 0) / 9 = 50
  expect('score: 50%', score === 50, String(score))
}

// 8. Model pasted the full item heading into "code" (real failure mode)
{
  const checks = normalizeChecks(
    {
      checks: [
        { code: 'FR-001 (MUST) — Requirement\nTitle: User registration with email verification\n[Functional] users register', status: 'partial', evidence: 'route found', gap: 'no verify email', fix: 'add it' },
        { code: 'FR-002 (MUST) — Requirement\nTitle: Secure login system', status: 'fail', evidence: 'none', gap: 'absent', fix: 'add login' },
        { code: 'FR-010 (SHOULD) — Requirement\nTitle: Download specifications', status: 'unknown', evidence: '', gap: 'files absent', fix: '' },
        { code: 'RULE-1 (RULE) — Constitution rule\nTypeScript strict mode everywhere', status: 'pass', evidence: 'strict on', gap: '', fix: '' },
      ],
    } as never,
    targets
  )
  expect('heading-in-code: FR-001 partial', checks[0].status === 'partial', checks[0].status)
  expect('heading-in-code: FR-002 fail', checks[1].status === 'fail', checks[1].status)
  expect('heading-in-code: FR-010 unknown', checks[2].status === 'unknown', checks[2].status)
  expect('heading-in-code: RULE-1 pass', checks[3].status === 'pass', checks[3].status)
  expect('heading-in-code: evidence kept', checks[0].evidence === 'route found', checks[0].evidence)
}

console.log(failures === 0 ? '\nALL NORMALIZATION TESTS PASSED' : `\n${failures} FAILURES`)
process.exit(failures === 0 ? 0 : 1)
