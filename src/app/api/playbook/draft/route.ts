import { NextResponse } from 'next/server'
import { draftTemplate } from '@/lib/engines/playbook'

// POST /api/playbook/draft — AI converts a short description of a
// recurring task into a reusable prompt template with variables.
export async function POST(req: Request) {
  try {
    const body = (await req.json()) as { description?: string }
    const description = (body.description ?? '').trim()
    if (description.length < 10) {
      return NextResponse.json(
        { error: 'Describe the recurring task in at least a sentence.' },
        { status: 400 }
      )
    }
    const template = await draftTemplate(description)
    return NextResponse.json({ template }, { status: 201 })
  } catch (error) {
    console.error('[api/playbook/draft POST]', error)
    return NextResponse.json(
      { error: 'The AI template service failed. Please try again.' },
      { status: 502 }
    )
  }
}
