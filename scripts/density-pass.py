#!/usr/bin/env python3
"""Density pass: cards get compact mobile padding (p-3.5) and airier
desktop padding (sm:p-5) + larger desktop corner radius (sm:rounded-2xl).
Only exact `p-4` literals are upgraded; already-responsive `p-4 sm:p-*`
stays untouched (negative lookahead)."""
import re
import pathlib

ROOT = pathlib.Path('/home/z/my-project/src/components')

# (pattern, replacement) — applied to full class strings inside className="..."
PATTERNS = [
    # plain bordered cards (with or without bg-card / bg-muted/30)
    (re.compile(r'rounded-xl border (bg-card |bg-muted/30 )?p-4(?!\s*sm:p-|[-\w])'),
     r'rounded-xl sm:rounded-2xl border \1p-3.5 sm:p-5'),
    # dashed empty-state panel in readiness
    (re.compile(r'rounded-xl border border-dashed p-8(?!\s*sm:)'),
     r'rounded-xl sm:rounded-2xl border border-dashed p-6 sm:p-8'),
]

changed = {}
for sub in ('stages', 'admin'):
    for f in sorted((ROOT / sub).glob('*.tsx')):
        text = f.read_text(encoding='utf-8')
        orig = text
        for rx, repl in PATTERNS:
            text = rx.sub(repl, text)
        if text != orig:
            f.write_text(text, encoding='utf-8')
            n = sum(1 for rx, _ in PATTERNS for _ in rx.finditer(orig))
            changed[str(f.relative_to(ROOT))] = n

for k, v in changed.items():
    print(f'{k}: {v} replacement(s)')
print(f'\n{len(changed)} files updated')
