package W3;

import D3.p;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final J3.b f8966a;

    /* renamed from: b, reason: collision with root package name */
    public final p f8967b;

    /* renamed from: c, reason: collision with root package name */
    public final p f8968c;

    /* renamed from: d, reason: collision with root package name */
    public final p f8969d;

    /* renamed from: e, reason: collision with root package name */
    public final p f8970e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8971f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8972g;

    /* renamed from: h, reason: collision with root package name */
    public final int f8973h;

    /* renamed from: i, reason: collision with root package name */
    public final int f8974i;

    public c(J3.b bVar, p pVar, p pVar2, p pVar3, p pVar4) throws D3.j {
        boolean z7 = pVar == null || pVar2 == null;
        boolean z8 = pVar3 == null || pVar4 == null;
        if (z7 && z8) {
            throw D3.j.a();
        }
        if (z7) {
            pVar = new p(0.0f, pVar3.d());
            pVar2 = new p(0.0f, pVar4.d());
        } else if (z8) {
            pVar3 = new p(bVar.o() - 1, pVar.d());
            pVar4 = new p(bVar.o() - 1, pVar2.d());
        }
        this.f8966a = bVar;
        this.f8967b = pVar;
        this.f8968c = pVar2;
        this.f8969d = pVar3;
        this.f8970e = pVar4;
        this.f8971f = (int) Math.min(pVar.c(), pVar2.c());
        this.f8972g = (int) Math.max(pVar3.c(), pVar4.c());
        this.f8973h = (int) Math.min(pVar.d(), pVar3.d());
        this.f8974i = (int) Math.max(pVar2.d(), pVar4.d());
    }

    public static c j(c cVar, c cVar2) {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.f8966a, cVar.f8967b, cVar.f8968c, cVar2.f8969d, cVar2.f8970e);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public W3.c a(int r13, int r14, boolean r15) {
        /*
            r12 = this;
            D3.p r0 = r12.f8967b
            D3.p r1 = r12.f8968c
            D3.p r2 = r12.f8969d
            D3.p r3 = r12.f8970e
            if (r13 <= 0) goto L2a
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.d()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            D3.p r13 = new D3.p
            float r4 = r4.c()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L27
            r8 = r13
        L25:
            r10 = r2
            goto L2c
        L27:
            r10 = r13
            r8 = r0
            goto L2c
        L2a:
            r8 = r0
            goto L25
        L2c:
            if (r14 <= 0) goto L5d
            if (r15 == 0) goto L33
            D3.p r13 = r12.f8968c
            goto L35
        L33:
            D3.p r13 = r12.f8970e
        L35:
            float r0 = r13.d()
            int r0 = (int) r0
            int r0 = r0 + r14
            J3.b r14 = r12.f8966a
            int r14 = r14.l()
            if (r0 < r14) goto L4b
            J3.b r14 = r12.f8966a
            int r14 = r14.l()
            int r0 = r14 + (-1)
        L4b:
            D3.p r14 = new D3.p
            float r13 = r13.c()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L5a
            r9 = r14
        L58:
            r11 = r3
            goto L5f
        L5a:
            r11 = r14
            r9 = r1
            goto L5f
        L5d:
            r9 = r1
            goto L58
        L5f:
            W3.c r6 = new W3.c
            J3.b r7 = r12.f8966a
            r6.<init>(r7, r8, r9, r10, r11)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.c.a(int, int, boolean):W3.c");
    }

    public p b() {
        return this.f8968c;
    }

    public p c() {
        return this.f8970e;
    }

    public int d() {
        return this.f8972g;
    }

    public int e() {
        return this.f8974i;
    }

    public int f() {
        return this.f8971f;
    }

    public int g() {
        return this.f8973h;
    }

    public p h() {
        return this.f8967b;
    }

    public p i() {
        return this.f8969d;
    }

    public c(c cVar) {
        this.f8966a = cVar.f8966a;
        this.f8967b = cVar.f8967b;
        this.f8968c = cVar.f8968c;
        this.f8969d = cVar.f8969d;
        this.f8970e = cVar.f8970e;
        this.f8971f = cVar.f8971f;
        this.f8972g = cVar.f8972g;
        this.f8973h = cVar.f8973h;
        this.f8974i = cVar.f8974i;
    }
}
