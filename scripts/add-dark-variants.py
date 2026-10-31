#!/usr/bin/env python3
"""Add dark: variants to hardcoded tailwind color tints across components. (v2)

Handles tokens inside quoted JSX strings ('bg-teal-50 text-teal-700 …') and is
idempotent — safe to re-run.
"""
import re, pathlib

ROOT = pathlib.Path('/home/z/my-project/src')
TARGETS = list((ROOT / 'components' / 'stages').glob('*.tsx')) + \
          list((ROOT / 'components' / 'app').glob('*.tsx')) + \
          list((ROOT / 'components' / 'admin').glob('*.tsx')) + \
          [ROOT / 'app' / 'page.tsx', ROOT / 'app' / 'admin' / 'page.tsx']

FAMILIES = 'teal|amber|emerald|red|sky|violet|slate|rose|green|indigo|orange|blue'
TOK = re.compile(rf'^((?:[a-z0-9\[\]\-]+:)*)((bg|text|border)-({FAMILIES})-(\d{{2,3}})(?:/\d{{1,3}})?)$')

def dark_twin(prefix, prop, family, shade):
    n = int(shade)
    if prop == 'bg':
        if n <= 50:   a = f'{family}-500/10'
        elif n <= 100: a = f'{family}-500/15'
        elif n <= 200: a = f'{family}-500/20'
        else: return None
    elif prop == 'text':
        if n <= 500: return None
        a = f'{family}-300' if n >= 700 else f'{family}-400'
    else:
        a = f'{family}-500/25' if n <= 200 else f'{family}-500/30'
    return f'dark:{prefix}{prop}-{a}'

changed, added = [], 0
for path in TARGETS:
    src = path.read_text()
    out, touched = [], False
    for line in src.split('\n'):
        if re.search(rf'\b(?:bg|text|border)-(?:{FAMILIES})-\d', line):
            toks = line.split(' ')
            for i, tok in enumerate(toks):
                lead = ''
                core = tok
                while core and core[0] in '\'"`':
                    lead += core[0]; core = core[1:]
                trail = ''
                while core and core[-1] in '\'",`':
                    trail = core[-1] + trail; core = core[:-1]
                m = TOK.match(core)
                if not m:
                    continue
                twin = dark_twin(m.group(1), m.group(3), m.group(4), m.group(5))
                if twin and twin not in line:
                    toks[i] = lead + core + ' ' + twin + trail
                    line = ' '.join(toks)
                    added += 1; touched = True
            line = ' '.join(toks) if isinstance(line, list) else line
        out.append(line)
    if touched:
        path.write_text('\n'.join(out))
        changed.append(path.name)

print(f'{len(changed)} files, +{added} dark twins')
