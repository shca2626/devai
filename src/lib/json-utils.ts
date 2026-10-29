// Defensive JSON parsing — the model is instructed to return strict JSON,
// but we still guard against code fences, prose wrappers and truncation.

export function extractJson(raw: string): string {
  let text = raw.trim()
  // Strip markdown code fences
  text = text.replace(/^```(?:json)?\s*/i, '').replace(/\s*```\s*$/, '')
  // Handle both objects and top-level arrays
  const firstArr = text.indexOf('[')
  const firstObj = text.indexOf('{')
  if (firstArr !== -1 && (firstObj === -1 || firstArr < firstObj)) {
    const last = text.lastIndexOf(']')
    if (last > firstArr) return text.slice(firstArr, last + 1)
    throw new Error('No JSON array found in model response')
  }
  const first = text.indexOf('{')
  const last = text.lastIndexOf('}')
  if (first === -1 || last === -1 || last <= first) {
    throw new Error('No JSON object found in model response')
  }
  return text.slice(first, last + 1)
}

export function safeParseJson<T>(raw: string): T {
  const candidate = extractJson(raw)
  try {
    return JSON.parse(candidate) as T
  } catch {
    // Second chance: remove trailing commas before } or ]
    const cleaned = candidate.replace(/,\s*([}\]])/g, '$1')
    return JSON.parse(cleaned) as T
  }
}

export function isProbablyArabic(text: string): boolean {
  const arabicChars = (text.match(/[\u0600-\u06FF]/g) ?? []).length
  const latinChars = (text.match(/[A-Za-z]/g) ?? []).length
  return arabicChars > 0 && arabicChars >= latinChars
}
