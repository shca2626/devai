# DevAI — AI Software Engineer

An Arabic-first, bilingual (AR/EN) web application that turns a raw product idea into a complete, verified engineering package — features, requirements, decisions, design (entities, endpoints, screens, architecture), planning, drift checks and exportable deliverables.

**No-limits mode is active:** every stage, tool and action is always available from any other stage. Nothing is locked, gated or rate-limited. Regeneration, approval and re-opening are always allowed and are recorded in the audit trail (decision log).

## Highlights

- **9-stage guided workflow** — Welcome → Understand → Discovery → Baseline → Requirements → Features → Design → Readiness → Package. In no-limits mode the stepper is a *navigator*, not a gate: every stage is reachable at any time.
- **AI engines** (`src/lib/engines/`) — context, discovery, requirements, features, design, plan, verify, consistency, drift, site-intel, context-pack, prompt-lab, express, playbook. Each engine is an AI call with structured JSON output and full prompt transparency.
- **Full decision audit trail** — every generation, approval, regeneration and override is logged per idea.
- **Bilingual UI** — Arabic (RTL) and English, with AI translation and prompt-enhance tools.
- **Site intelligence** — crawl a live site, extract claims/screens/unknowns, and fold them into the engineering package.
- **Engineering package export** — JSON + Markdown deliverables for downstream implementation.

## Admin Control Panel — `/admin`

The entire system is documented and controllable from one place:

| Section | What it shows / does |
| --- | --- |
| **Overview** | Live stats, runtime info, DB info, no-limits policy status, recent audit feed |
| **Database** | Browse, search, edit and clear all Prisma models (20 tables) + full schema reference |
| **Ideas** | Jump any idea to any stage, open it in the app, delete it |
| **Features** | The system map — what every stage and tool does |
| **API** | Every API endpoint, grouped by area, with a live try-it console |
| **Engines** | The AI layer: every engine, its prompts, and the no-limits policy |
| **Maintenance** | Export the whole DB, scoped resets |

## Tech stack

- **Next.js 16** (App Router) + **React 19** + **TypeScript**
- **Tailwind CSS 4** + **shadcn/ui** (Radix primitives)
- **Prisma ORM** + **SQLite** (`db/custom.db`, 20 models)
- **z-ai-web-dev-sdk** for LLM calls
- **Bun** runtime

## Getting started

```bash
bun install
bun run db:push      # create/sync the SQLite schema
bun run dev          # start on http://localhost:3000
```

Then open:

- `/` — the application
- `/admin` — the admin control panel

## Project layout

```
src/
  app/            # pages + ~40 API routes (ideas, playbook, admin, tools…)
  components/
    app/          # application shell (sidebar, stepper, stages glue)
    stages/       # the 9 workflow stages
    admin/        # the 7 admin panel sections
    ui/           # shadcn/ui primitives
  lib/
    engines/      # AI engines + prompts
    admin/        # admin registry, docs, schema metadata
    db.ts         # Prisma client
prisma/           # schema.prisma (20 models)
scripts/          # dev/verification scripts and E2E snapshots
```

## API surface (summary)

- `POST/GET /api/ideas` · `GET/PATCH/DELETE /api/ideas/[id]`
- `/api/ideas/[id]/{questions,next,answer,finish-discovery,baseline,requirements,features,design,plan,gate,verify,consistency,drift,impact,reinterpret,reopen,express,export,package,context-pack,site-intel}`
- `GET/POST/PATCH/DELETE /api/playbook[/draft|/[id]/use]`
- `GET/PATCH/DELETE /api/constitution[/[id]]`
- `GET/POST/PATCH/DELETE /api/features[/[id]]`
- `POST /api/tools/{enhance,translate}`
- `GET /api/admin/{overview,table/[model],record/[model]/[id],export,reset}`

Every endpoint returns structured JSON and is documented in the `/admin` → **API** section with a live try-it console.
