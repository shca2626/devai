#!/usr/bin/env python3
"""Golden-path test for the Blueprint Assistant API (real LLM calls)."""
import json
import time
import urllib.request

BASE = 'http://localhost:3000'
IDEA_TEXT = 'أريد تطبيق يربط بين أصحاب المحلات والموردين، ويقارن الأسعار، ويخلي التاجر يطلب المنتجات من عدة موردين بسهولة.'


def call(method, path, body=None, timeout=120):
    req = urllib.request.Request(BASE + path, method=method)
    req.add_header('Content-Type', 'application/json')
    data = json.dumps(body).encode() if body is not None else None
    start = time.time()
    with urllib.request.urlopen(req, data=data, timeout=timeout) as res:
        payload = json.loads(res.read().decode())
    print(f"[{int(time.time()-start)}s] {method} {path} -> {res.status}")
    return payload


def main():
    # 1. Create idea (Engine 1)
    detail = call('POST', '/api/ideas', {'text': IDEA_TEXT})
    idea = detail['idea']
    iid = idea['id']
    interp = idea['interpretation']
    print('TITLE:', idea['title'])
    print('INTERP:', interp['englishInterpretation'][:120])
    print('FACTS:', len(interp['understood']), '| UNCLEAR:', len(interp['unclear']), '| ASSUMED:', len(interp['assumed']))
    assert len(interp['understood']) >= 2, 'expected facts'
    assert detail['assumptions'], 'expected assumptions tracked'

    # 2. Gate 1: approve interpretation -> discovery
    detail = call('POST', f'/api/ideas/{iid}/gate', {'gate': 'interpretation', 'action': 'approve'})
    assert detail['idea']['stage'] == 'discovery', detail['idea']['stage']
    print('STAGE:', detail['idea']['stage'], '| questions:', len(detail['questions']))

    # 3. Answer 6 questions (Engine 2 adaptive)
    answers_pool = [
        'نعم الموردون يتنافسون على السعر والمشتري يختار الأفضل',
        'أصحاب المحلات الصغيرة والموردون، والمشرف يدير المنصة',
        'تطبيق ويب متجاوب يكفي في البداية، لاحقا موبايل',
        'عمولة صغيرة على كل طلبية ناجحة',
        'التاجر يسجل دخول، يطلب عروض أسعار، يستلم العروض، يختار المورد ويؤكد الطلب',
        'الدفع خارج المنصة في المرحلة الأولى، الإدارة والفواتير داخلها',
    ]
    answered = 0
    while answered < 6:
        pending = [q for q in detail['questions'] if q['status'] == 'pending']
        if not pending:
            nxt = call('POST', f'/api/ideas/{iid}/questions/next', {'force': True} if answered < 6 else {})
            detail = nxt
            if nxt.get('suggestDone'):
                print('suggestDone signal at', answered, 'answers')
                if answered >= 5:
                    break
            pending = [q for q in detail['questions'] if q['status'] == 'pending']
            if not pending:
                print('No more pending questions; answered =', answered)
                break
        q = pending[0]
        ans = answers_pool[answered % len(answers_pool)]
        detail = call('POST', f'/api/ideas/{iid}/questions/answer',
                      {'questionId': q['id'], 'answer': ans, 'kind': 'custom'})
        answered += 1
        print(f"  answered [{q['area']}]: {ans[:50]}")

    assert answered >= 5, f'only {answered} answered'

    # 4. Finish discovery -> features stage
    detail = call('POST', f'/api/ideas/{iid}/finish-discovery')
    assert detail['idea']['stage'] == 'features', detail['idea']['stage']
    print('STAGE: features | summary len:', len(detail['idea']['summary']['summaryMarkdown']))
    assert '##' in detail['idea']['summary']['summaryMarkdown'], 'expected markdown sections'

    # 5. Generate features (Engine 3)
    detail = call('POST', f'/api/ideas/{iid}/features/generate')
    features = detail['features']
    print('FEATURES:', len(features))
    for f in features[:4]:
        print(f"  [{f['module']}] {f['feature']} ({f['priority']}/{f['status']})")
    assert len(features) >= 5
    assert all(f['status'] in ('proposed', 'needs_confirmation') for f in features), 'AI features must start undecided'

    # 6. Accept first two, defer one, reject one
    statuses = ['accepted', 'accepted', 'deferred', 'rejected']
    for f, s in zip(features[:4], statuses):
        detail = call('PATCH', f"/api/features/{f['id']}", {'status': s})
    counts = {s: sum(1 for x in detail['features'] if x['status'] == s) for s in statuses}
    print('DECISIONS:', counts)

    # 7. Gate 2 with bulk action for the rest
    detail = call('POST', f'/api/ideas/{iid}/gate',
                  {'gate': 'baseline', 'action': 'approve', 'unreviewedAction': 'accept'})
    assert detail['idea']['stage'] == 'baseline', detail['idea']['stage']
    print('STAGE: baseline ✓ | decisions logged:', len(detail['decisions']))

    # 8. Lock check: feature PATCH must fail now
    try:
        call('PATCH', f"/api/features/{features[0]['id']}", {'status': 'rejected'})
        print('ERROR: lock not enforced!')
        return 1
    except urllib.error.HTTPError as e:
        print('LOCK ENFORCED:', e.code)

    # 9. Export
    for fmt in ('md', 'json'):
        req = urllib.request.Request(f'{BASE}/api/ideas/{iid}/export?format={fmt}')
        with urllib.request.urlopen(req) as res:
            content = res.read().decode()
        print(f"EXPORT {fmt}: {len(content)} bytes | disposition:", res.headers.get('Content-Disposition'))

    # 10. Assumption confirm
    if detail['assumptions']:
        aid = detail['assumptions'][0]['id']
        detail = call('PATCH', f'/api/assumptions/{aid}', {'status': 'confirmed'})
        print('ASSUMPTION CONFIRMED ✓')

    print('\nALL GOLDEN PATH CHECKS PASSED — idea id:', iid)
    return 0


if __name__ == '__main__':
    raise SystemExit(main())
