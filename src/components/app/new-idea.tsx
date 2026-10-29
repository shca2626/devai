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
import { Popover, PopoverContent, PopoverTrigger } from '@/components/ui/popover'
import { Textarea } from '@/components/ui/textarea'
import { useApp } from '@/components/app/context'
import { WorkingPanel } from '@/components/app/bits'
import { isProbablyArabic } from '@/lib/json-utils'
import type { EnhancedPrompt, IdeaDetail, ProjectType, TranslationResult } from '@/lib/types'
import {
  AppWindow,
  Check,
  ChevronDown,
  Copy,
  FlaskConical,
  Globe,
  Languages,
  Loader2,
  Mic,
  MicOff,
  RefreshCw,
  Sparkles,
  X,
} from 'lucide-react'
import { useCallback, useEffect, useRef, useState } from 'react'
import { useToast } from '@/hooks/use-toast'
import { Badge } from '@/components/ui/badge'

// ============================================================
// New idea dialog — the Prompt Lab.
//
// One merged popup covering three capabilities (Bolt.new-style):
//   1. Build-target tabs .... Website / App / Prototype
//   2. Translator ........... any detected language -> AR | EN
//   3. Prompt engineer ...... raw idea -> professional build prompt
//
// Translation and enhancement are pure AI utilities — they never
// auto-commit; the user always reviews and chooses to keep results.
// Creating the idea sends text + projectType to the interpretation
// engine, which steers understanding by the chosen target.
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

const TYPE_OPTIONS: Array<{
  value: ProjectType
  icon: typeof Globe
  labelKey: 'typeWebsite' | 'typeApp' | 'typePrototype'
  hintKey: 'typeWebsiteHint' | 'typeAppHint' | 'typePrototypeHint'
}> = [
  { value: 'website', icon: Globe, labelKey: 'typeWebsite', hintKey: 'typeWebsiteHint' },
  { value: 'app', icon: AppWindow, labelKey: 'typeApp', hintKey: 'typeAppHint' },
  { value: 'prototype', icon: FlaskConical, labelKey: 'typePrototype', hintKey: 'typePrototypeHint' },
]

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
  const [projectType, setProjectType] = useState<ProjectType>('app')
  const [busy, setBusy] = useState(false)
  const [listening, setListening] = useState(false)

  // Translator state
  const [translating, setTranslating] = useState<'ar' | 'en' | null>(null)
  const [translateOpen, setTranslateOpen] = useState(false)

  // Prompt-engineer state
  const [enhanceState, setEnhanceState] = useState<'idle' | 'working' | 'result'>('idle')
  const [enhanced, setEnhanced] = useState<EnhancedPrompt | null>(null)
  const [enhancedText, setEnhancedText] = useState('')

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

  // Reset the lab whenever the dialog reopens
  useEffect(() => {
    if (open) {
      setText(prefill ?? '')
      setProjectType('app')
      setEnhanceState('idle')
      setEnhanced(null)
      setEnhancedText('')
      setTranslating(null)
    }
  }, [open, prefill])

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
      setText((prev) => (prev ? `${prev} ${transcript}` : transcript))
    }
    recognition.onend = () => setListening(false)
    recognition.onerror = () => setListening(false)
    recognitionRef.current = recognition
    recognition.start()
    setListening(true)
  }

  // ---------- Translator ----------

  async function runTranslate(target: 'ar' | 'en') {
    const value = text.trim()
    if (value.length < 3) {
      toast({ description: t('minChars') })
      return
    }
    setTranslateOpen(false)
    setTranslating(target)
    try {
      const res = await fetch('/api/tools/translate', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ text: value, target }),
      })
      const data = (await res.json()) as TranslationResult & { error?: string }
      if (!res.ok) {
        toast({ description: data.error ?? t('toolsError'), variant: 'destructive' })
        return
      }
      if (data.alreadyInTarget) {
        toast({ description: t('alreadyInTarget') })
        return
      }
      setText(data.text)
      toast({ description: t('translatedOk') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    } finally {
      setTranslating(null)
    }
  }

  // ---------- Prompt engineer ----------

  async function runEnhance() {
    const value = text.trim()
    if (value.length < 10) {
      toast({ description: t('minChars') })
      return
    }
    setEnhanceState('working')
    try {
      const res = await fetch('/api/tools/enhance', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ text: value, projectType }),
      })
      const data = (await res.json()) as EnhancedPrompt & { error?: string }
      if (!res.ok) {
        toast({ description: data.error ?? t('toolsError'), variant: 'destructive' })
        setEnhanceState('idle')
        return
      }
      setEnhanced(data)
      setEnhancedText(data.enhanced)
      setEnhanceState('result')
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
      setEnhanceState('idle')
    }
  }

  function useEnhanced() {
    const value = enhancedText.trim()
    if (value.length < 10) {
      toast({ description: t('minChars') })
      return
    }
    setText(value)
    setEnhanceState('idle')
    setEnhanced(null)
    setEnhancedText('')
  }

  async function copyEnhanced() {
    try {
      await navigator.clipboard.writeText(enhancedText)
      toast({ description: t('copiedToClipboard') })
    } catch {
      toast({ description: t('toolsError'), variant: 'destructive' })
    }
  }

  // ---------- Create the idea ----------

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
        body: JSON.stringify({ text: value, projectType }),
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
  const toolsDisabled = busy || translating !== null || enhanceState === 'working'
  const selectedType = TYPE_OPTIONS.find((o) => o.value === projectType) ?? TYPE_OPTIONS[1]

  return (
    <Dialog open={open} onOpenChange={(v) => !busy && onOpenChange(v)}>
      <DialogContent className="sm:max-w-2xl max-h-[90vh] overflow-y-auto">
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

            {/* ---------- Build-target tabs (Bolt-style) ---------- */}
            <div className="space-y-1.5">
              <p className="text-xs font-medium text-muted-foreground">{t('buildTarget')}</p>
              <div
                role="tablist"
                aria-label={t('buildTarget')}
                className="grid grid-cols-3 gap-2"
              >
                {TYPE_OPTIONS.map((option) => {
                  const active = option.value === projectType
                  const Icon = option.icon
                  return (
                    <button
                      key={option.value}
                      type="button"
                      role="tab"
                      aria-selected={active}
                      onClick={() => setProjectType(option.value)}
                      className={`flex flex-col items-center gap-1.5 rounded-xl border px-3 py-3 transition-colors ${
                        active
                          ? 'border-primary bg-primary/10 text-primary'
                          : 'border-border bg-background text-muted-foreground hover:bg-muted/50 hover:text-foreground'
                      }`}
                    >
                      <Icon className="h-5 w-5" />
                      <span className={`text-xs font-semibold ${active ? '' : ''}`}>{t(option.labelKey)}</span>
                    </button>
                  )
                })}
              </div>
              <p className="text-[11px] text-muted-foreground" aria-live="polite">
                {t(selectedType.hintKey)}
              </p>
            </div>

            {/* ---------- Idea text ---------- */}
            <div className="space-y-2">
              <Textarea
                ref={textareaRef}
                value={text}
                onChange={(e) => setText(e.target.value)}
                placeholder={t('ideaPlaceholder')}
                rows={6}
                dir="auto"
                className="resize-none text-base leading-relaxed"
                aria-label={t('ideaLabel')}
              />
              <div className="flex flex-wrap items-center justify-between gap-2">
                <div className="flex flex-wrap items-center gap-1.5">
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

                  {/* Translator — any language -> AR | EN */}
                  <Popover open={translateOpen} onOpenChange={setTranslateOpen}>
                    <PopoverTrigger asChild>
                      <Button
                        type="button"
                        variant="outline"
                        size="sm"
                        disabled={toolsDisabled || listening}
                        className="gap-1.5"
                        aria-label={t('translateLabel')}
                      >
                        {translating ? (
                          <Loader2 className="h-3.5 w-3.5 animate-spin" />
                        ) : (
                          <Languages className="h-3.5 w-3.5" />
                        )}
                        {translating ? t('translating') : t('translateLabel')}
                        <ChevronDown className="h-3 w-3 opacity-60" />
                      </Button>
                    </PopoverTrigger>
                    <PopoverContent align="start" className="w-56 p-1.5">
                      <p className="px-2 py-1.5 text-[11px] font-medium text-muted-foreground">
                        {t('translateLabel')}
                      </p>
                      <Button
                        type="button"
                        variant="ghost"
                        size="sm"
                        className="w-full justify-start gap-2"
                        onClick={() => runTranslate('ar')}
                      >
                        <Languages className="h-3.5 w-3.5 text-primary" />
                        {t('translateToArabic')}
                      </Button>
                      <Button
                        type="button"
                        variant="ghost"
                        size="sm"
                        className="w-full justify-start gap-2"
                        onClick={() => runTranslate('en')}
                      >
                        <Languages className="h-3.5 w-3.5 text-primary" />
                        {t('translateToEnglish')}
                      </Button>
                    </PopoverContent>
                  </Popover>

                  {/* Prompt engineer */}
                  <Button
                    type="button"
                    variant="outline"
                    size="sm"
                    disabled={toolsDisabled || listening}
                    onClick={runEnhance}
                    className="gap-1.5"
                    aria-label={t('enhancePrompt')}
                  >
                    {enhanceState === 'working' ? (
                      <Loader2 className="h-3.5 w-3.5 animate-spin" />
                    ) : (
                      <Sparkles className="h-3.5 w-3.5 text-primary" />
                    )}
                    {enhanceState === 'working' ? t('enhancing2') : t('enhancePrompt')}
                  </Button>
                </div>
                <span className="text-[11px] text-muted-foreground" dir="ltr">
                  {text.length.toLocaleString()} {t('charsCount')}
                </span>
              </div>
            </div>

            {/* ---------- Enhancement working panel ---------- */}
            {enhanceState === 'working' && (
              <div className="py-2">
                <WorkingPanel steps={[t('enhancing1'), t('enhancing2'), t('enhancing3')]} />
              </div>
            )}

            {/* ---------- Enhanced prompt result ---------- */}
            {enhanceState === 'result' && enhanced && (
              <div className="rounded-xl border border-primary/30 bg-primary/[0.04] p-3 space-y-3" dir="auto">
                <div className="flex flex-wrap items-center gap-2">
                  <span className="flex items-center gap-1.5 text-sm font-semibold">
                    <Sparkles className="h-4 w-4 text-primary" />
                    {t('enhancedTitle')}
                  </span>
                  <Badge
                    variant="outline"
                    className="bg-primary/10 text-primary border-primary/30 text-[11px]"
                  >
                    {enhanced.lang === 'ar' ? t('promptInArabic') : t('promptInEnglish')}
                  </Badge>
                  <Badge variant="outline" className="text-[11px]">
                    {t(selectedType.labelKey)}
                  </Badge>
                </div>

                {enhanced.improvements.length > 0 && (
                  <div className="space-y-1">
                    <p className="text-[11px] font-medium text-muted-foreground">{t('improvementsTitle')}</p>
                    <ul className="space-y-0.5">
                      {enhanced.improvements.map((improvement, i) => (
                        <li key={i} className="flex items-start gap-1.5 text-xs text-muted-foreground leading-5">
                          <Check className="mt-0.5 h-3 w-3 shrink-0 text-emerald-600" />
                          <span>{improvement}</span>
                        </li>
                      ))}
                    </ul>
                  </div>
                )}

                <Textarea
                  value={enhancedText}
                  onChange={(e) => setEnhancedText(e.target.value)}
                  rows={10}
                  dir="auto"
                  className="resize-none text-sm leading-relaxed bg-background"
                  aria-label={t('enhancedTitle')}
                />
                <div className="flex flex-wrap items-center justify-between gap-2">
                  <p className="text-[11px] text-muted-foreground">
                    {t('enhancedEditable')} · {enhancedText.length.toLocaleString()} {t('charsCount')}
                  </p>
                  <div className="flex flex-wrap items-center gap-1.5">
                    <Button type="button" variant="ghost" size="sm" onClick={copyEnhanced} className="gap-1.5">
                      <Copy className="h-3.5 w-3.5" />
                      {t('copyPrompt')}
                    </Button>
                    <Button
                      type="button"
                      variant="ghost"
                      size="sm"
                      onClick={runEnhance}
                      disabled={toolsDisabled}
                      className="gap-1.5"
                    >
                      <RefreshCw className="h-3.5 w-3.5" />
                      {t('regenerateEnhanced')}
                    </Button>
                    <Button
                      type="button"
                      variant="outline"
                      size="sm"
                      onClick={() => {
                        setEnhanceState('idle')
                        setEnhanced(null)
                        setEnhancedText('')
                      }}
                      className="gap-1.5"
                    >
                      <X className="h-3.5 w-3.5" />
                      {t('discardEnhanced')}
                    </Button>
                    <Button type="button" size="sm" onClick={useEnhanced} className="gap-1.5">
                      <Check className="h-3.5 w-3.5" />
                      {t('useEnhanced')}
                    </Button>
                  </div>
                </div>
              </div>
            )}

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
