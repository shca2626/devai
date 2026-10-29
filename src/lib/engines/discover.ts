import { chatJson } from '@/lib/ai'
import type { Interpretation, QuestionOption } from '@/lib/types'

// ============================================================
// Engine 2 — Interactive Product Discovery
// Acts as a senior business analyst: adaptive questions with
// honest consequences per option. The app (not the model)
// decides coverage and when discovery may finish.
// ============================================================

export interface DiscoveryQuestionDraft {
  area: string
  questionEn: string
  questionAr: string
  whyItMatters: string
  options: QuestionOption[]
}

interface QuestionsResult {
  done?: boolean
  questions?: DiscoveryQuestionDraft[]
}

interface SummaryResult {
  summaryMarkdown: string
  openRisks: string[]
  suggestedAssumptions: string[]
}

export interface AnsweredItem {
  area: string
  questionEn: string
  answer: string
}

const QUESTION_SYSTEM_PROMPT = `You are the Interactive Product Discovery engine of a software product discovery platform, acting as a senior business analyst interviewing a founder about their software idea.

You receive: the idea interpretation, the questions answered so far (with the founder's answers), and the discovery areas that still lack answers.

Discovery areas (use EXACTLY these identifiers):
- business_problem: the exact problem and why it matters
- target_users: all user types, their needs and responsibilities
- product_format: web app, mobile app, responsive web, PWA or a combination
- business_model: revenue sources, subscriptions, commissions, or other models
- user_journeys: how each user achieves their main goal
- scope: what is included and explicitly excluded
- constraints: budget, timeline, technology, hosting and integrations
- success_criteria: how the product's success will be measured
- unknowns: contradictions, risky assumptions and unanswered questions

Rules:
- NEVER re-ask something already answered. Adapt follow-ups to previous answers.
- Return 1-2 questions per call. Prioritize the critical uncovered areas listed for you.
- Each question needs 3-4 options. Options must be genuinely different directions, and each "consequence" must honestly describe what choosing it implies for the product (scope, complexity, cost, or business model) in one sentence.
- Where reasonable, include a simple/conservative option (e.g. manual process first, single role first).
- questionEn: professional English. questionAr: clear, natural Arabic (MSA that feels natural to Gulf/Levant speakers, no stiff literal translation).
- The founder can always answer in their own words — options are accelerators, not a cage.
- whyItMatters: one short sentence explaining what this question unlocks for the specification.

Return STRICT JSON only, one of:
{"done": false, "questions": [{"area": "<area id>", "questionEn": "...", "questionAr": "...", "whyItMatters": "...", "options": [{"label": "...", "consequence": "..."}]}]}
OR, when every area listed as uncovered has enough of an answer OR the remaining gaps are genuinely non-critical for an MVP-level understanding:
{"done": true}`

const SUMMARY_SYSTEM_PROMPT = `You are the Discovery Summary engine of a software product discovery platform.
Given an approved idea interpretation and a business analyst's Q&A with the founder, produce a structured summary.

Return STRICT JSON only with exactly these keys:
- "summaryMarkdown": a well-structured Markdown summary in English with these sections: ## Business problem, ## Target users, ## Product format, ## Business model, ## User journeys, ## Scope, ## Constraints, ## Success criteria. For any section with no answer yet, write one honest sentence like "Not yet answered — revisit before implementation." Be specific and reference the founder's actual answers, not generic filler.
- "openRisks": array of 2-5 short English strings naming contradictions, risky assumptions or unanswered critical points found in the Q&A.
- "suggestedAssumptions": array of 0-4 short English strings describing interpretations that remain tentative and should be confirmed later.`

function normalizeDrafts(result: QuestionsResult): DiscoveryQuestionDraft[] {
  const raw = Array.isArray(result?.questions) ? result.questions : []
  return raw
    .filter(
      (q) =>
        q &&
        typeof q.questionEn === 'string' &&
        q.questionEn.trim().length > 0 &&
        Array.isArray(q.options) &&
        q.options.length >= 2
    )
    .map((q) => ({
      area: typeof q.area === 'string' && q.area.trim() ? q.area.trim() : 'unknowns',
      questionEn: q.questionEn.trim(),
      questionAr: typeof q.questionAr === 'string' ? q.questionAr.trim() : '',
      whyItMatters: typeof q.whyItMatters === 'string' ? q.whyItMatters.trim() : '',
      options: q.options
        .filter((o) => o && typeof o.label === 'string' && o.label.trim())
        .slice(0, 4)
        .map((o) => ({
          label: o.label.trim(),
          consequence: typeof o.consequence === 'string' ? o.consequence.trim() : '',
        })),
    }))
    .filter((q) => q.options.length >= 2)
}

export async function generateQuestions(params: {
  interpretation: Interpretation
  answered: AnsweredItem[]
  uncoveredAreas: string[]
  weakAreas: string[]
}): Promise<DiscoveryQuestionDraft[]> {
  const { interpretation, answered, uncoveredAreas, weakAreas } = params
  const result = await chatJson<QuestionsResult>(
    QUESTION_SYSTEM_PROMPT,
    `Idea interpretation:\n${JSON.stringify(interpretation, null, 2)}\n\nQuestions answered so far:\n${
      answered.length
        ? answered.map((a, i) => `${i + 1}. [${a.area}] ${a.questionEn}\n   Answer: ${a.answer}`).join('\n')
        : '(none yet)'
    }\n\nAreas with NO answer yet (highest priority): ${uncoveredAreas.join(', ') || '(none)'}\nAreas that may need one deeper follow-up: ${weakAreas.join(', ') || '(none)'}\n\nGenerate the next 1-2 questions now.`
  )
  if (result?.done) return []
  return normalizeDrafts(result).slice(0, 2)
}

export async function compileDiscoverySummary(params: {
  interpretation: Interpretation
  answered: AnsweredItem[]
}): Promise<SummaryResult> {
  const { interpretation, answered } = params
  const result = await chatJson<SummaryResult>(
    SUMMARY_SYSTEM_PROMPT,
    `Idea interpretation:\n${JSON.stringify(interpretation, null, 2)}\n\nDiscovery Q&A:\n${
      answered.length
        ? answered.map((a, i) => `${i + 1}. [${a.area}] ${a.questionEn}\n   Answer: ${a.answer}`).join('\n')
        : '(no answers)'
    }`
  )
  const arr = (v: unknown): string[] =>
    Array.isArray(v) ? v.filter((x): x is string => typeof x === 'string' && x.trim().length > 0).map((s) => s.trim()) : []
  return {
    summaryMarkdown:
      typeof result?.summaryMarkdown === 'string' && result.summaryMarkdown.trim()
        ? result.summaryMarkdown.trim()
        : '_Summary unavailable._',
    openRisks: arr(result?.openRisks).slice(0, 6),
    suggestedAssumptions: arr(result?.suggestedAssumptions).slice(0, 5),
  }
}
