import { NextResponse } from 'next/server'
import { db } from '@/lib/db'
import { buildIdeaDetail } from '@/lib/payload'

type Params = { params: Promise<{ id: string }> }

export async function GET(_req: Request, { params }: Params) {
  try {
    const { id } = await params
    const payload = await buildIdeaDetail(id)
    if (!payload) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/ideas/[id] GET]', error)
    return NextResponse.json({ error: 'Failed to load the idea' }, { status: 500 })
  }
}

export async function PATCH(req: Request, { params }: Params) {
  try {
    const { id } = await params
    const body = (await req.json()) as { title?: string }
    const title = (body.title ?? '').trim()
    if (!title) {
      return NextResponse.json({ error: 'Title cannot be empty' }, { status: 400 })
    }
    const existing = await db.idea.findUnique({ where: { id } })
    if (!existing) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }
    await db.idea.update({ where: { id }, data: { title: title.slice(0, 120) } })
    const payload = await buildIdeaDetail(id)
    return NextResponse.json(payload)
  } catch (error) {
    console.error('[api/ideas/[id] PATCH]', error)
    return NextResponse.json({ error: 'Failed to rename the idea' }, { status: 500 })
  }
}

export async function DELETE(_req: Request, { params }: Params) {
  try {
    const { id } = await params
    const existing = await db.idea.findUnique({ where: { id } })
    if (!existing) {
      return NextResponse.json({ error: 'Idea not found' }, { status: 404 })
    }
    await db.idea.delete({ where: { id } })
    return NextResponse.json({ ok: true })
  } catch (error) {
    console.error('[api/ideas/[id] DELETE]', error)
    return NextResponse.json({ error: 'Failed to delete the idea' }, { status: 500 })
  }
}
