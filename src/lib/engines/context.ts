import { db } from '@/lib/db'
import { parseInterpretation, parseSummary } from '@/lib/payload'

// ============================================================
// Shared project context — every engineering engine derives
// its input from APPROVED upstream artifacts only. Confirmed
// requirements, accepted features and answered questions are
// facts; everything else stays marked as AI suggestion.
// ============================================================

export interface ProjectContext {
  title: string
  originalText: string
  interpretation: ReturnType<typeof parseInterpretation>
  summary: ReturnType<typeof parseSummary>
  qa: Array<{ area: string; question: string; answer: string }>
  acceptedFeatures: Array<{ id: string; module: string; feature: string; user: string; priority: string; rationale: string | null }>
  openAssumptions: string[]
}

export async function buildProjectContext(ideaId: string): Promise<ProjectContext | null> {
  const idea = await db.idea.findUnique({
    where: { id: ideaId },
    include: {
      questions: { where: { status: 'answered' }, orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] },
      features: { orderBy: [{ order: 'asc' }, { createdAt: 'asc' }] },
      assumptions: { where: { status: 'open' } },
    },
  })
  if (!idea) return null

  return {
    title: idea.title,
    originalText: idea.originalText,
    interpretation: parseInterpretation(idea.interpretation),
    summary: parseSummary(idea.summary),
    qa: idea.questions.map((q) => ({ area: q.area, question: q.questionEn, answer: q.answer ?? '' })),
    acceptedFeatures: idea.features
      .filter((f) => f.status === 'accepted')
      .map((f) => ({
        id: f.id,
        module: f.module,
        feature: f.feature,
        user: f.user,
        priority: f.priority,
        rationale: f.rationale,
      })),
    openAssumptions: idea.assumptions.map((a) => a.text),
  }
}

export function contextToPrompt(ctx: ProjectContext): string {
  const parts: string[] = []
  parts.push(`Project: ${ctx.title}`)
  if (ctx.interpretation) {
    parts.push(`Problem statement: ${ctx.interpretation.problemStatement}`)
    parts.push(`English interpretation: ${ctx.interpretation.englishInterpretation}`)
    if (ctx.interpretation.understood.length) parts.push(`Confirmed facts:\n- ${ctx.interpretation.understood.join('\n- ')}`)
  }
  if (ctx.summary) parts.push(`Discovery summary:\n${ctx.summary.summaryMarkdown}`)
  if (ctx.qa.length) {
    parts.push(
      `Discovery decisions (client answers — these are FACTS):\n${ctx.qa
        .map((q, i) => `${i + 1}. [${q.area}] ${q.question}\n   A: ${q.answer}`)
        .join('\n')}`
    )
  }
  if (ctx.acceptedFeatures.length) {
    parts.push(
      `Approved feature baseline (client-accepted — these are FACTS):\n${ctx.acceptedFeatures
        .map((f) => `- [${f.module}] ${f.feature} (user: ${f.user}, priority: ${f.priority})`)
        .join('\n')}`
    )
  }
  if (ctx.openAssumptions.length) {
    parts.push(`Still-open assumptions (NOT confirmed — do not treat as decided):\n- ${ctx.openAssumptions.join('\n- ')}`)
  }
  return parts.join('\n\n')
}
