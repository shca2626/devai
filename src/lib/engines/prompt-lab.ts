import { chatJson } from '@/lib/ai'
import type { EnhancedPrompt, ProjectType, TranslationResult } from '@/lib/types'

// ============================================================
// Prompt Lab — two embedded AI skills used inside the idea dialog:
//
//   1. translateText  : any detected language -> Arabic or English
//   2. enhancePrompt  : raw idea text -> a professional, structured
//                       build prompt (Bolt/Replit-style "Plan" pass),
//                       steered by the Website / App / Prototype tab.
//
// Both return STRICT JSON. Workflow rules live here; the UI only
// decides how results are offered to the user (never auto-committed).
// ============================================================

// ---------- Shared project-type briefings ----------

const TYPE_BRIEFING: Record<ProjectType, string> = {
  website: `PROJECT TYPE = WEBSITE (presence site: landing page, marketing site, portfolio, content/news site, or e-commerce storefront).
Steer the prompt toward: page structure & information architecture, visual identity & branding, responsive design (mobile-first), SEO essentials, performance, contact/lead forms, CMS-driven content when relevant, and e-commerce flows (catalog, cart, checkout) if commerce is implied.
Keep it a WEBSITE, not an application: avoid inventing complex user accounts or internal dashboards unless clearly implied.`,
  app: `PROJECT TYPE = APP (full-stack web application).
Steer the prompt toward: user authentication & roles, persistent data (database entities), core CRUD workflows, dashboards & analytics views, search/filtering, notifications, third-party integrations, API design, and admin capabilities.
Assume a full-stack architecture (frontend + backend + database) and make the core user journeys concrete.`,
  prototype: `PROJECT TYPE = PROTOTYPE (interactive clickable prototype / MVP demo).
Steer the prompt toward: the key user journeys to demonstrate, the screens and navigation flow, realistic mock data, interaction states (loading, empty, error), and what the demo must convince stakeholders of.
Deliberately DESCOPE: no real auth backend, no production database — mock everything, optimize for speed of demonstration and visual/UX clarity.`,
}

// ---------- 1. Translation skill ----------

const TRANSLATE_PROMPT = `You are the Translation skill of a bilingual (Arabic/English) software product discovery platform.
The user submits text in ANY language (Arabic dialects, English, French, Turkish, Urdu, Hindi, Chinese, Russian, Spanish, etc. — including mixed-language text) and asks for a translation into Arabic or English.

Return STRICT JSON only — no markdown fences, no commentary — with exactly these keys:
- "text": the translated text.
- "detectedLanguage": the dominant source language, as an English name (e.g. "Arabic", "English", "French", "Turkish").
- "alreadyInTarget": true if the submitted text is already (≥90%) in the target language.

Translation rules:
- Translate MEANING, not words. Produce natural, fluent output a native speaker would write.
- Target Arabic: use clean Modern Standard Arabic (فصحى مبسطة) understandable across dialects. Keep well-known technical terms in English inside the Arabic text (e.g. "API", "Dashboard", "Login") when that is the common convention.
- Target English: use professional, neutral English.
- Preserve the original tone, intent, and level of detail. Never add, drop, or "improve" content — translation only.
- Preserve structure: paragraphs, line breaks, and lists must survive the translation.
- If the text mixes languages, translate everything into the target language.
- If the text is already in the target language, set "alreadyInTarget" to true and still return the text (lightly normalized spacing only, wording unchanged).`

export async function translateText(rawText: string, target: 'ar' | 'en'): Promise<TranslationResult> {
  const result = await chatJson<TranslationResult>(
    TRANSLATE_PROMPT,
    `Target language: ${target === 'ar' ? 'Arabic (العربية)' : 'English'}\n\nText to translate (submit as-is):\n"""\n${rawText}\n"""`
  )
  const str = (v: unknown): string => (typeof v === 'string' ? v.trim() : '')
  const text = str(result?.text)
  if (!text) throw new Error('Translation skill returned empty text')
  return {
    text,
    detectedLanguage: str(result?.detectedLanguage) || 'unknown',
    alreadyInTarget: Boolean(result?.alreadyInTarget),
  }
}

// ---------- 2. Prompt-engineering skill ----------

const ENHANCE_PROMPT = `You are the Prompt Engineering skill of a software product discovery platform — an expert technical prompt writer, in the style of the "Plan" feature of Bolt.new / Replit Agent.
The user submits a raw, rough, incomplete product idea (often colloquial, sometimes a single sentence) and selected one build target: Website, App, or Prototype.
Your job: rewrite the idea into a PROFESSIONAL, WELL-STRUCTURED BUILD PROMPT that any AI app builder (Bolt, Replit, Lovable, v0, Cursor — or a human developer) could execute directly.

Return STRICT JSON only — no markdown fences, no commentary — with exactly these keys:
- "lang": "ar" if the input idea is mainly Arabic, otherwise "en".
- "enhanced": the full enhanced prompt, written in the SAME language as the user's idea (Arabic input -> Arabic prompt with English technical terms where conventional; English input -> English prompt).
- "improvements": 3-6 short bullets (same language as "enhanced") summarizing what you improved, e.g. "أضاف تحديد الجمهور المستهدف" / "Added measurable acceptance criteria".

Structure of the "enhanced" prompt — use these sections with short bold-style headers (use the SAME language as the prompt itself for headers):
1. One-line product concept.
2. The problem being solved.
3. Target users.
4. Core features — a prioritized list (essential / important / nice-to-have).
5. Main pages or screens.
6. Suggested tech stack (full-stack: frontend, backend, database — concrete and modern).
7. Design & UX direction.
8. Constraints, non-goals, and out-of-scope items.
9. Acceptance criteria — what "done" looks like.

Hard rules:
- NEVER invent facts about the user's business, numbers, or branding. Where details are missing, phrase reasonable suggestions explicitly as suggestions (e.g. "مقترح: ..." / "Suggested: ...") so the user can edit them.
- Stay faithful to the original intent — this is an enhancement of THEIR idea, not a new product.
- Respect the PROJECT TYPE briefing below (Website / App / Prototype each steer scope, features, and tech stack differently).
- Make the enhanced prompt proportional to the input: for a short idea aim for 250-600 words; for a long, detailed input, preserve EVERY substantive detail the user provided — the enhanced prompt may be as long as needed (never drop or compress user-given requirements to stay short). Concrete and specific beats generic.
- The output must read as a ready-to-paste build prompt, not as a conversation.`

export async function enhancePrompt(rawText: string, projectType: ProjectType): Promise<EnhancedPrompt> {
  const result = await chatJson<EnhancedPrompt>(
    ENHANCE_PROMPT,
    `${TYPE_BRIEFING[projectType]}\n\nRaw idea from the user (submit as-is, keep the original meaning):\n"""\n${rawText}\n"""\n\nProduce the enhanced build prompt in the same language as this idea.`
  )
  const str = (v: unknown): string => (typeof v === 'string' ? v.trim() : '')
  const enhanced = str(result?.enhanced)
  if (enhanced.length < 60) throw new Error('Prompt skill returned an unusable prompt')
  const improvements = Array.isArray(result?.improvements)
    ? result.improvements.filter((x): x is string => typeof x === 'string' && x.trim().length > 0).map((s) => s.trim()).slice(0, 6)
    : []
  return {
    enhanced,
    improvements,
    lang: result?.lang === 'ar' ? 'ar' : 'en',
  }
}
