import { NextResponse } from 'next/server'
import { translateText } from '@/lib/engines/prompt-lab'

// POST /api/tools/translate — any detected language -> Arabic or English.
// Pure utility: does NOT touch the database; the caller decides whether
// to keep the translated text.
export async function POST(req: Request) {
  try {
    const body = (await req.json()) as { text?: string; target?: string }
    const text = (body.text ?? '').trim()
    const target = body.target === 'en' ? 'en' : body.target === 'ar' ? 'ar' : null

    if (text.length < 3) {
      return NextResponse.json({ error: 'Please provide text to translate.' }, { status: 400 })
    }
    if (!target) {
      return NextResponse.json({ error: 'Target must be "ar" or "en".' }, { status: 400 })
    }

    const result = await translateText(text, target)
    return NextResponse.json(result)
  } catch (error) {
    console.error('[api/tools/translate POST]', error)
    return NextResponse.json(
      { error: 'The AI translation service failed. Please try again.' },
      { status: 502 }
    )
  }
}
