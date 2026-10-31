#!/usr/bin/env python3
"""Rewrite the header action group in page.tsx with a responsive version:
- < md: single "Tools & panels" dropdown (all 7 tools)
- >= md: existing icon buttons (labels at xl)
- lang toggle: icon-only < sm; new idea: icon-only < sm
"""
import re

PATH = '/home/z/my-project/src/app/page.tsx'
src = open(PATH).read()

# --- 1. Replace the whole action group div (from its opening to the </div> after New Idea button) ---
start_marker = '          <div className="ms-auto flex items-center gap-1.5">\n'
start = src.index(start_marker)
# The group ends with the New Idea button followed by the group's closing </div>
end_marker = """            <Button size="sm" onClick={() => openNewIdea()} className="gap-1.5 min-h-9">
              <Sparkles className="h-3.5 w-3.5" />
              <span className="hidden sm:inline">{t('newIdea')}</span>
            </Button>
          </div>"""
end = src.index(end_marker) + len(end_marker)
old_block = src[start:end]

# Extract the existing desktop buttons verbatim (everything between the group
# opening line and the Playbook always-on button is fine to keep as-is; we
# reuse the whole inner content as the md+ cluster).
inner = old_block[len(start_marker):-len('\n          </div>')]  # strip open line & closing div

new_block = '''          <div className="ms-auto flex items-center gap-1 sm:gap-1.5 min-w-0">
            {/* Compact tools menu — small screens */}
            <div className="md:hidden">
              <DropdownMenu>
                <DropdownMenuTrigger asChild>
                  <Button
                    variant="ghost"
                    size="sm"
                    className="min-h-9 px-2.5"
                    aria-label={t('toolsMenu')}
                    title={t('toolsMenu')}
                  >
                    <Wrench className="h-4 w-4 text-primary" />
                  </Button>
                </DropdownMenuTrigger>
                <DropdownMenuContent align="end" className="w-60">
                  <DropdownMenuLabel>{t('toolsMenu')}</DropdownMenuLabel>
                  {selectedId && (
                    <DropdownMenuItem onClick={() => setContextPackOpen(true)} className="gap-2">
                      <Package className="h-4 w-4 text-primary" />
                      {t('openContextPack')}
                    </DropdownMenuItem>
                  )}
                  {selectedId && (
                    <DropdownMenuItem onClick={() => setVerifyOpen(true)} className="gap-2">
                      <FileSearch className="h-4 w-4 text-primary" />
                      {t('openVerifier')}
                    </DropdownMenuItem>
                  )}
                  {selectedId && (
                    <DropdownMenuItem onClick={() => setDecisionsOpen(true)} className="gap-2">
                      <Scale className="h-4 w-4 text-primary" />
                      {t('openDecisions')}
                    </DropdownMenuItem>
                  )}
                  {selectedId && (
                    <DropdownMenuItem onClick={() => setSiteIntelOpen(true)} className="gap-2">
                      <Radar className="h-4 w-4 text-primary" />
                      {t('openSiteIntel')}
                    </DropdownMenuItem>
                  )}
                  <DropdownMenuItem onClick={() => setPlaybookOpen(true)} className="gap-2">
                    <BookOpen className="h-4 w-4 text-primary" />
                    {t('openPlaybook')}
                  </DropdownMenuItem>
                  <DropdownMenuItem onClick={() => setConstitutionOpen(true)} className="gap-2">
                    <ScrollText className="h-4 w-4 text-primary" />
                    {t('openConstitution')}
                  </DropdownMenuItem>
                  <DropdownMenuSeparator />
                  <DropdownMenuItem asChild>
                    <a href="/admin" className="gap-2 cursor-pointer">
                      <ShieldCheck className="h-4 w-4 text-primary" />
                      Admin
                    </a>
                  </DropdownMenuItem>
                </DropdownMenuContent>
              </DropdownMenu>
            </div>

            {/* Full tool buttons — md and up */}
            <div className="hidden md:flex items-center gap-1.5">
INNERSUB
            </div>

            <Button
              variant="ghost"
              size="sm"
              onClick={() => setLang(lang === 'ar' ? 'en' : 'ar')}
              className="gap-1.5 min-h-9 px-2 sm:px-3"
              aria-label={t('langToggle')}
              title={t('langToggle')}
            >
              <Languages className="h-4 w-4" />
              <span className="hidden sm:inline text-xs font-medium">{t('langToggle')}</span>
            </Button>
            <Button size="sm" onClick={() => openNewIdea()} className="gap-1.5 min-h-9 px-2.5 sm:px-3">
              <Sparkles className="h-3.5 w-3.5" />
              <span className="hidden sm:inline">{t('newIdea')}</span>
            </Button>
          </div>'''

# Indent the inner desktop buttons by 2 extra spaces
inner_indented = '\n'.join(('  ' + line) if line.strip() else line for line in inner.rstrip('\n').split('\n'))
new_block = new_block.replace('INNERSUB', inner_indented)

src = src[:start] + new_block + src[end:]

# --- 2. Add Wrench to lucide imports if missing ---
if "  Wrench,\n} from 'lucide-react'" not in src:
    src = src.replace("  Sparkles,\n} from 'lucide-react'", "  Sparkles,\n  Wrench,\n} from 'lucide-react'")

open(PATH, 'w').write(src)
print('OK — header rewritten')
print('Wrench import present:', "Wrench," in src)
