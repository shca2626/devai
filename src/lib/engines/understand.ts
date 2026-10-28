import { chatJson } from '@/lib/ai'
import type { Interpretation, ProjectType } from '@/lib/types'

// ============================================================
// Engine 1 — Bilingual Idea Understanding & Translation
// Interprets business intent (not literal translation),
// separates facts / open questions / tentative assumptions.
// ============================================================

const SYSTEM_PROMPT = `You are the Bilingual Idea Understanding engine of a software product discovery platform.
The user submits a raw, incomplete product idea in Arabic (any dialect, possibly mixed with English) or in English.
Your job is to interpret the BUSINESS INTENT, not to translate literally.

Return STRICT JSON only — no markdown fences, no commentary — with exactly these keys:
- "title": a short English product name (2-5 words, English only).
- "englishInterpretation": 2-4 sentences in professional English restating the intended product. Preserve the user's intent faithfully; do NOT add features that are not implied by the text.
- "problemStatement": 1-2 sentences in English describing the business problem being solved.
- "understood": array of 3-6 concise English facts that are explicitly present in or directly derivable from the idea.
- "unclear": array of 3-6 concise English questions that must be answered before the product can be specified.
- "assumed": array of 2-5 tentative English interpretations the user has NOT confirmed (e.g. implied user types, implied platform, implied business model). These will be tracked as open assumptions.

Rules:
- Never invent facts. If something is missing, it belongs in "unclear" or "assumed".
- Keep every array item short (max ~18 words).
- If the idea is very vague, still return your best interpretation, with more items in "unclear".
- Detect the dominant language of the input yourself; you do not need to mention it in the output.`

function validate(result: Interpretation): Interpretation {
  const arr = (v: unknown): string[] =>
    Array.isArray(v) ? v.filter((x): x is string => typeof x === 'string' && x.trim().length > 0).map((s) => s.trim()) : []
  const str = (v: unknown, fallback = ''): string => (typeof v === 'string' && v.trim() ? v.trim() : fallback)
  return {
    title: str(result?.title, 'Untitled idea'),
    englishInterpretation: str(result?.englishInterpretation, 'Interpretation unavailable.'),
    problemStatement: str(result?.problemStatement, 'Problem not yet stated.'),
    understood: arr(result?.understood).slice(0, 8),
    unclear: arr(result?.unclear).slice(0, 8),
    assumed: arr(result?.assumed).slice(0, 8),
  }
}

const TYPE_HINT: Record<ProjectType, string> = {
  website:
    'The user chose WEBSITE as the build target (presence site: landing/marketing/e-commerce/content site, not an internal application).',
  app: 'The user chose APP as the build target (a full-stack web application with accounts, data and workflows).',
  prototype:
    'The user chose PROTOTYPE as the build target (an interactive clickable demo with mock data — speed of demonstration over production readiness).',
}

export async function interpretIdea(rawText: string, projectType?: ProjectType | null): Promise<Interpretation> {
  const typeHint = projectType ? `\n${TYPE_HINT[projectType]}\nInterpret the idea consistently with this build target (it is a user-confirmed fact, not an assumption).` : ''
  const result = await chatJson<Interpretation>(
    SYSTEM_PROMPT,
    `Raw product idea (submit as-is, keep the original wording):\n"""\n${rawText}\n"""${typeHint}`
  )
  return validate(result)
}

export async function reinterpretIdea(
  rawText: string,
  previous: Interpretation,
  corrections: string,
  projectType?: ProjectType | null
): Promise<Interpretation> {
  const typeHint = projectType ? `\nUser-confirmed build target: ${projectType.toUpperCase()} (${TYPE_HINT[projectType].split(' (')[1]?.replace(').', '') ?? projectType}).` : ''
  const result = await chatJson<Interpretation>(
    SYSTEM_PROMPT,
    `Raw product idea:\n"""\n${rawText}\n"""\n\nPrevious interpretation (JSON):\n${JSON.stringify(previous, null, 2)}\n\nThe user reviewed the previous interpretation and gave these corrections:\n"""\n${corrections}\n"""${typeHint}\n\nProduce an UPDATED interpretation that incorporates the corrections. Keep everything that was right, fix what was wrong, and re-evaluate the understood/unclear/assumed lists accordingly. Return the same strict JSON format.`
  )
  return validate(result)
}
