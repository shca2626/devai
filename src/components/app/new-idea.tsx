'use client'

import { Button } from '@/components/ui/button'
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog'
import { Textarea } from '@/components/ui/textarea'
import { useApp } from '@/components/app/context'
import { WorkingPanel } from '@/components/app/bits'
import { isProbablyArabic } from '@/lib/json-utils'
import type { IdeaDetail } from '@/lib/types'
import { Mic, MicOff, Sparkles } from 'lucide-react'
import { useCallback, useEffect, useRef, useState } from 'react'
import { useToast } from '@/hooks/use-toast'
import { Badge } from '@/components/ui/badge'

// ============================================================
// New idea dialog — bilingual text input with optional voice
// dictation (Web Speech API, feature-detected). Creating an
// idea triggers the real AI interpretation.
// ============================================================

type SpeechRecognitionLike = {
  lang: string
  interimResults: boolean
  continuous: boolean
  onresult: ((event: { resultIndex: number; results: ArrayLike<ArrayLike<{ transcript: string }>> }) => void) | null
  onend: (() => void) | null
  onerror: (() => void) | null
  start: () => void
  stop: () => void
}

export function NewIdeaDialog({
  open,
  onOpenChange,
  onCreated,
  prefill,
}: {
  open: boolean
  onOpenChange: (open: boolean) => void
  onCreated: (ideaId: string) => void
  prefill?: string
}) {
  const { t, lang } = useApp()
  const { toast } = useToast()
  const [text, setText] = useState(prefill ?? '')
  const [busy, setBusy] = useState(false)
  const [listening, setListening] = useState(false)
  const recognitionRef = useRef<SpeechRecognitionLike | null>(null)
  const textareaRef = useRef<HTMLTextAreaElement | null>(null)

  const speechSupported =
    typeof window !== 'undefined' &&
    Boolean((window as unknown as { SpeechRecognition?: unknown }).SpeechRecognition ?? (window as unknown as { webkitSpeechRecognition?: unknown }).webkitSpeechRecognition)

  const stopListening = useCallback(() => {
    recognitionRef.current?.stop()
    recognitionRef.current = null
    setListening(false)
  }, [])

  // Stop any live recognition when the dialog unmounts
  useEffect(
    () => () => {
      recognitionRef.current?.stop()
      recognitionRef.current = null
    },
    []
  )

  function toggleVoice() {
    if (listening) {
      stopListening()
      return
    }
    const Ctor =
      (window as unknown as { SpeechRecognition?: new () => SpeechRecognitionLike }).SpeechRecognition ??
      (window as unknown as { webkitSpeechRecognition?: new () => SpeechRecognitionLike }).webkitSpeechRecognition
    if (!Ctor) {
      toast({ description: t('voiceUnsupported') })
      return
    }
    const recognition = new Ctor()
    recognition.lang = lang === 'ar' ? 'ar-SA' : 'en-US'
    recognition.interimResults = true
    recognition.continuous = true
    recognition.onresult = (event) => {
      let transcript = ''
      for (let i = event.resultIndex; i < event.results.length; i++) {
        transcript += event.results[i][0].transcript
      }
      setText((prev) => (prev ? `${prev} ${transcript}`.slice(0, 4000) : transcript.slice(0, 4000)))
    }
    recognition.onend = () => setListening(false)
    recognition.onerror = () => setListening(false)
    recognitionRef.current = recognition
    recognition.start()
    setListening(true)
  }

  async function submit() {
    const value = text.trim()
    if (value.length < 10) {
      toast({ description: t('minChars') })
      return
    }
    setBusy(true)
    try {
      const res = await fetch('/api/ideas', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ text: value }),
      })
      const data = (await res.json()) as IdeaDetail & { error?: string }
      if (!res.ok) {
        toast({ description: data.error ?? t('aiError'), variant: 'destructive' })
        setBusy(false)
        return
      }
      onCreated(data.idea.id)
      onOpenChange(false)
    } catch {
      toast({ description: t('aiError'), variant: 'destructive' })
      setBusy(false)
    }
  }

  const detectedArabic = text.trim().length > 8 && isProbablyArabic(text)

  return (
    <Dialog open={open} onOpenChange={(v) => !busy && onOpenChange(v)}>
      <DialogContent className="sm:max-w-xl">
        {busy ? (
          <div className="py-4">
            <WorkingPanel
              steps={[t('understanding1'), t('understanding2'), t('understanding3')]}
            />
          </div>
        ) : (
          <>
            <DialogHeader>
              <DialogTitle className="flex items-center gap-2">
                <Sparkles className="h-4 w-4 text-primary" />
                {t('ideaLabel')}
              </DialogTitle>
              <DialogDescription>{t('welcomeBody')}</DialogDescription>
            </DialogHeader>
            <div className="space-y-2">
              <Textarea
                ref={textareaRef}
                value={text}
                onChange={(e) => setText(e.target.value)}
                placeholder={t('ideaPlaceholder')}
                rows={6}
                maxLength={4000}
                dir="auto"
                className="resize-none text-base leading-relaxed"
                aria-label={t('ideaLabel')}
              />
              <div className="flex items-center justify-between">
                <div className="flex items-center gap-2">
                  {text.trim().length > 8 && (
                    <Badge
                      variant="outline"
                      className="bg-emerald-50 text-emerald-700 border-emerald-200 text-[11px]"
                    >
                      {detectedArabic ? t('arabicDetected') : t('englishDetected')}
                    </Badge>
                  )}
                  {speechSupported && (
                    <Button
                      type="button"
                      variant={listening ? 'default' : 'outline'}
                      size="sm"
                      onClick={toggleVoice}
                      className="gap-1.5"
                      aria-label={t('voiceInput')}
                    >
                      {listening ? <MicOff className="h-3.5 w-3.5" /> : <Mic className="h-3.5 w-3.5" />}
                      {listening ? t('listening') : t('voiceInput')}
                    </Button>
                  )}
                </div>
                <span className="text-[11px] text-muted-foreground">{text.length}/4000</span>
              </div>
            </div>
            <DialogFooter>
              <Button variant="outline" onClick={() => onOpenChange(false)}>
                {t('cancel')}
              </Button>
              <Button onClick={submit} disabled={text.trim().length < 10} className="gap-1.5">
                <Sparkles className="h-3.5 w-3.5" />
                {t('submitIdea')}
              </Button>
            </DialogFooter>
          </>
        )}
      </DialogContent>
    </Dialog>
  )
}
