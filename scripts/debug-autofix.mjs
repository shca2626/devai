// Debug the autofix engine — print the RAW model response for the current critical issue
import { PrismaClient } from '@prisma/client'
import { chatJson } from '../src/lib/ai' // may not work with path aliases; use dynamic import

const db = new PrismaClient()
const IDEA = 'cmvsk37i100bgv5rzd4x1btr4'

const issues = await db.consistencyIssue.findMany({
  where: { ideaId: IDEA, status: 'open', severity: 'critical' },
})
console.log('OPEN CRITICALS:', issues.length)
for (const i of issues) console.log(' -', i.description)

const [entities, apis] = await Promise.all([
  db.dataEntity.findMany({ where: { ideaId: IDEA } }),
  db.apiEndpoint.findMany({ where: { ideaId: IDEA } }),
])

const PROMPT = `You are the consistency auto-fix engine of an AI software engineer platform, running in EXPRESS mode: the client delegated the fixes to you.
For every critical consistency issue, propose the MINIMAL fix that makes the artifacts consistent. Prefer ADDING a missing field over removing a collected one (losing user data is worse than storing it).

Allowed operations (use ONLY these):
- {"op": "add_entity_field", "entity": "<entity name or code>", "field": {"name": "...", "type": "string", "required": true, "unique": false, "description": "..."}}
- {"op": "remove_entity_field", "entity": "<entity name or code>", "field": "<field name>"}
- {"op": "add_api_request_field", "api": "<api code like API-01>", "field": {"field": "...", "type": "string", "required": true, "notes": "..."}}
- {"op": "remove_api_request_field", "api": "<api code>", "field": "<field name>"}

If an issue cannot be fixed with these operations, return no fix for it (it will be escalated to the client).

Return STRICT JSON only:
{"fixes": [{"op": "...", "entity": "...", "api": "...", "field": {}, "issueIndex": 0, "note": "one sentence"}]}`

const issueBlock = issues.map((i, idx) => `Issue #${idx}: ${i.description}${i.affected ? ` (affected: ${i.affected})` : ''}`).join('\n')
const entityBlock = entities.map((e) => `- ${e.code} "${e.name}": fields = ${e.fields}`).join('\n')
const apiBlock = apis.map((a) => `- ${a.code} ${a.method} ${a.path}: request = ${a.request ?? '[]'}`).join('\n')

const raw = await chatJson(PROMPT, `Critical issues:\n${issueBlock}\n\nCurrent data entities:\n${entityBlock}\n\nCurrent API endpoints:\n${apiBlock}`)
console.log('\nRAW MODEL RESPONSE:')
console.log(JSON.stringify(raw, null, 2))

await db.$disconnect()
