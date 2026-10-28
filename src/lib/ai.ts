import ZAI from 'z-ai-web-dev-sdk'
import { safeParseJson } from '@/lib/json-utils'

// Shared model gateway: single initialized instance, retried calls,
// JSON-first responses. All workflow rules live in the app, never here.

let zaiPromise: Promise<Awaited<ReturnType<typeof ZAI.create>>> | null = null

function getZAI() {
  if (!zaiPromise) {
    zaiPromise = ZAI.create()
  }
  return zaiPromise
}

export async function chatText(system: string, user: string): Promise<string> {
  const zai = await getZAI()
  const completion = await zai.chat.completions.create({
    messages: [
      { role: 'assistant', content: system },
      { role: 'user', content: user },
    ],
    thinking: { type: 'disabled' },
  })
  const content = completion.choices[0]?.message?.content ?? ''
  if (!content.trim()) {
    throw new Error('Empty response from AI service')
  }
  return content
}

export async function chatJson<T>(system: string, user: string, retries = 1): Promise<T> {
  let lastError: unknown = null
  for (let attempt = 0; attempt <= retries; attempt++) {
    try {
      const raw = await chatText(system, user)
      return safeParseJson<T>(raw)
    } catch (error) {
      lastError = error
      if (attempt < retries) {
        await new Promise((r) => setTimeout(r, 800 * (attempt + 1)))
      }
    }
  }
  throw new Error(
    `AI returned an unreadable response: ${lastError instanceof Error ? lastError.message : 'unknown error'}`
  )
}
