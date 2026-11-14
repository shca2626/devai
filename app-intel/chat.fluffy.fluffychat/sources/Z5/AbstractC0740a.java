package Z5;

/* renamed from: Z5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0740a implements d {

    /* renamed from: Z5.a$a, reason: collision with other inner class name */
    public static final class C0090a extends E5.d {

        /* renamed from: o, reason: collision with root package name */
        public Object f10356o;

        /* renamed from: p, reason: collision with root package name */
        public Object f10357p;

        /* renamed from: q, reason: collision with root package name */
        public /* synthetic */ Object f10358q;

        /* renamed from: s, reason: collision with root package name */
        public int f10360s;

        public C0090a(C5.e eVar) {
            super(eVar);
        }

        @Override // E5.a
        public final Object q(Object obj) {
            this.f10358q = obj;
            this.f10360s |= Integer.MIN_VALUE;
            return AbstractC0740a.this.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // Z5.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(Z5.e r6, C5.e r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof Z5.AbstractC0740a.C0090a
            if (r0 == 0) goto L13
            r0 = r7
            Z5.a$a r0 = (Z5.AbstractC0740a.C0090a) r0
            int r1 = r0.f10360s
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10360s = r1
            goto L18
        L13:
            Z5.a$a r0 = new Z5.a$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f10358q
            java.lang.Object r1 = D5.c.e()
            int r2 = r0.f10360s
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.f10357p
            a6.o r6 = (a6.o) r6
            java.lang.Object r0 = r0.f10356o
            Z5.e r0 = (Z5.e) r0
            y5.AbstractC1814j.b(r7)     // Catch: java.lang.Throwable -> L31
            goto L59
        L31:
            r7 = move-exception
            goto L63
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            y5.AbstractC1814j.b(r7)
            a6.o r7 = new a6.o
            C5.i r2 = r0.getContext()
            r7.<init>(r6, r2)
            java.lang.Object r6 = E5.k.a(r6)     // Catch: java.lang.Throwable -> L5f
            r0.f10356o = r6     // Catch: java.lang.Throwable -> L5f
            r0.f10357p = r7     // Catch: java.lang.Throwable -> L5f
            r0.f10360s = r3     // Catch: java.lang.Throwable -> L5f
            java.lang.Object r6 = r5.e(r7, r0)     // Catch: java.lang.Throwable -> L5f
            if (r6 != r1) goto L58
            return r1
        L58:
            r6 = r7
        L59:
            r6.r()
            y5.s r6 = y5.C1823s.f24020a
            return r6
        L5f:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L63:
            r6.r()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: Z5.AbstractC0740a.a(Z5.e, C5.e):java.lang.Object");
    }

    public abstract Object e(e eVar, C5.e eVar2);
}
