#!/usr/bin/env bash
# E2E test for feature #4 — Decision Log + Drift Detector
# Usage: bash /home/z/my-project/scripts/test-decisions.sh
set -uo pipefail
BASE="http://localhost:3000"
IDEA_ID="${1:-}"
J="Content-Type: application/json"

if [ -z "$IDEA_ID" ]; then
  IDEA_ID=$(curl -s --max-time 30 "$BASE/api/ideas" | jq -r '.ideas[0].id')
fi
echo "]== Using idea: $IDEA_ID"

echo "]== 1. POST decision DEC (stack: SQLite via Prisma)"
D1=$(curl -s --max-time 30 -X POST "$BASE/api/ideas/$IDEA_ID/decisions" -H "$J" \
  -d '{"title":"Database engine","choice":"SQLite via Prisma; no other ORM may be introduced","rationale":"zero-ops local dev","alternatives":"PostgreSQL (ops overhead), MongoDB (no relations)","category":"stack","titleAr":"محرك قاعدة البيانات"}')
echo "$D1" | jq -c '{code: .decision.code, title: .decision.title, status: .decision.status, category: .decision.category}'

echo "]== 2. POST decision DEC (ux: Arabic-first RTL)"
D2=$(curl -s --max-time 30 -X POST "$BASE/api/ideas/$IDEA_ID/decisions" -H "$J" \
  -d '{"title":"Interface direction","choice":"Arabic-first RTL UI; English is secondary, never Latin-only layouts","category":"ux"}')
echo "$D2" | jq -c '{code: .decision.code, title: .decision.title, status: .decision.status}'

echo "]== 3. POST decision DEC (scope: no realtime)"
D3=$(curl -s --max-time 30 -X POST "$BASE/api/ideas/$IDEA_ID/decisions" -H "$J" \
  -d '{"title":"Realtime features","choice":"No websockets or realtime channels in v1; plain REST polling only","category":"scope"}')
echo "$D3" | jq -c '{code: .decision.code, status: .decision.status}'

echo "]== 4. GET list"
curl -s --max-time 30 "$BASE/api/ideas/$IDEA_ID/decisions" | jq -c '.decisions | map({code, status})'

echo "]== 5. PATCH retire the scope decision (id from list)"
SCOPE_ID=$(curl -s --max-time 30 "$BASE/api/ideas/$IDEA_ID/decisions" | jq -r '.decisions[] | select(.title=="Realtime features") | .id')
curl -s --max-time 30 -X PATCH "$BASE/api/ideas/$IDEA_ID/decisions/$SCOPE_ID" -H "$J" -d '{"status":"superseded"}' | jq -c '{code: .decision.code, status: .decision.status}'

echo "]== 6. PATCH reactivate it"
curl -s --max-time 30 -X PATCH "$BASE/api/ideas/$IDEA_ID/decisions/$SCOPE_ID" -H "$J" -d '{"status":"active"}' | jq -c '{code: .decision.code, status: .decision.status}'

echo "]== 7. GET drift history (expect empty or prior)"
curl -s --max-time 30 "$BASE/api/ideas/$IDEA_ID/drift" | jq -c '{count: (.checks | length)}'

echo "]== 8. POST drift check — code that VIOLATES stack (uses TypeORM+MySQL), RESPECTS rtl, VIOLATES scope (adds socket.io)"
read -r -d '' CODE <<'EOC' || true
// db.ts — data layer
import { DataSource } from 'typeorm'   // decision said Prisma!
export const AppDataSource = new DataSource({
  type: 'mysql', host: 'localhost', username: 'root',
  database: 'shop', synchronize: true,
  entities: [__dirname + '/entities/*.ts'],
})

// realtime.ts — live channel
import { Server } from 'socket.io'      // decision said REST polling only!
export function startRealtime(httpServer) {
  const io = new Server(httpServer, { cors: { origin: '*' } })
  io.on('connection', (socket) => {
    socket.emit('hello', { ok: true })
  })
  return io
}

// layout.tsx — Arabic-first RTL layout
export default function RootLayout({ children }) {
  return (
    <html lang="ar" dir="rtl">
      <body className="font-arabic antialiased">{children}</body>
    </html>
  )
}
EOC
export CODE
PAYLOAD=$(jq -n --arg code "$CODE" --arg label "E2E drift test" --arg lang "en" '{code: $code, label: $label, lang: $lang}')
CHECK=$(curl -s --max-time 240 -X POST "$BASE/api/ideas/$IDEA_ID/drift" -H "$J" -d "$PAYLOAD")
echo "$CHECK" | jq -c '{alignment: .check.alignment, drifts: .check.drifts, counts: .check.counts, statuses: (.check.result.checks | map({code, status}))}'
echo "--- summary ---"
echo "$CHECK" | jq -r '.check.result.summary'
echo "--- violations ---"
echo "$CHECK" | jq -r '.check.result.violations[]'

echo "]== 9. GET one full check by id"
CHECK_ID=$(echo "$CHECK" | jq -r '.check.id')
curl -s --max-time 30 "$BASE/api/ideas/$IDEA_ID/drift?checkId=$CHECK_ID" | jq -c '{id: .check.id, alignment: .check.alignment, checks: (.check.result.checks | length)}'

echo "]== 10. DELETE the check"
curl -s --max-time 30 -X DELETE "$BASE/api/ideas/$IDEA_ID/drift?checkId=$CHECK_ID" | jq -c .

echo "]== 11. Context Pack includes Approved decisions section?"
curl -s --max-time 120 -X POST "$BASE/api/ideas/$IDEA_ID/context-pack" -H "$J" \
  -d '{"target":"bolt","lang":"en","includeConstitution":true,"includeRequirements":true,"includeArchitecture":true,"includeDataModel":true,"includeScreens":true,"includeTasks":true,"includeRisks":true,"includeDecisions":true}' \
  | jq -r '.markdown' | grep -A6 "Approved decisions" | head -14

echo "]== 12. Cleanup test decisions (delete all created)"
for ID in $(curl -s --max-time 30 "$BASE/api/ideas/$IDEA_ID/decisions" | jq -r '.decisions[].id'); do
  curl -s --max-time 30 -X DELETE "$BASE/api/ideas/$IDEA_ID/decisions/$ID" | jq -c .
done
echo "]== DONE"
