package h0;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class n implements y {

    /* renamed from: a, reason: collision with root package name */
    public final File f16749a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1117A f16750b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f16751c;

    public static final class a extends E5.d {

        /* renamed from: o, reason: collision with root package name */
        public Object f16752o;

        /* renamed from: p, reason: collision with root package name */
        public Object f16753p;

        /* renamed from: q, reason: collision with root package name */
        public /* synthetic */ Object f16754q;

        /* renamed from: s, reason: collision with root package name */
        public int f16756s;

        public a(C5.e eVar) {
            super(eVar);
        }

        @Override // E5.a
        public final Object q(Object obj) {
            this.f16754q = obj;
            this.f16756s |= Integer.MIN_VALUE;
            return n.i(n.this, this);
        }
    }

    public n(File file, InterfaceC1117A interfaceC1117A) {
        M5.m.e(file, "file");
        M5.m.e(interfaceC1117A, "serializer");
        this.f16749a = file;
        this.f16750b = interfaceC1117A;
        this.f16751c = new AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [h0.n] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object i(h0.n r7, C5.e r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof h0.n.a
            if (r0 == 0) goto L13
            r0 = r8
            h0.n$a r0 = (h0.n.a) r0
            int r1 = r0.f16756s
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f16756s = r1
            goto L18
        L13:
            h0.n$a r0 = new h0.n$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f16754q
            java.lang.Object r1 = D5.c.e()
            int r2 = r0.f16756s
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4b
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.f16752o
            java.io.Closeable r7 = (java.io.Closeable) r7
            y5.AbstractC1815j.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L9d
        L32:
            r8 = move-exception
            goto La5
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            java.lang.Object r7 = r0.f16753p
            java.io.Closeable r7 = (java.io.Closeable) r7
            java.lang.Object r2 = r0.f16752o
            h0.n r2 = (h0.n) r2
            y5.AbstractC1815j.b(r8)     // Catch: java.lang.Throwable -> L49
            goto L6b
        L49:
            r8 = move-exception
            goto L76
        L4b:
            y5.AbstractC1815j.b(r8)
            r7.f()
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L7c
            java.io.File r2 = r7.f16749a     // Catch: java.io.FileNotFoundException -> L7c
            r8.<init>(r2)     // Catch: java.io.FileNotFoundException -> L7c
            h0.A r2 = r7.f16750b     // Catch: java.lang.Throwable -> L71
            r0.f16752o = r7     // Catch: java.lang.Throwable -> L71
            r0.f16753p = r8     // Catch: java.lang.Throwable -> L71
            r0.f16756s = r4     // Catch: java.lang.Throwable -> L71
            java.lang.Object r2 = r2.c(r8, r0)     // Catch: java.lang.Throwable -> L71
            if (r2 != r1) goto L67
            goto L99
        L67:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L6b:
            J5.b.a(r7, r5)     // Catch: java.io.FileNotFoundException -> L6f
            return r8
        L6f:
            r7 = r2
            goto L7c
        L71:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L76:
            throw r8     // Catch: java.lang.Throwable -> L77
        L77:
            r4 = move-exception
            J5.b.a(r7, r8)     // Catch: java.io.FileNotFoundException -> L6f
            throw r4     // Catch: java.io.FileNotFoundException -> L6f
        L7c:
            java.io.File r8 = r7.f16749a
            boolean r8 = r8.exists()
            if (r8 == 0) goto Lab
            java.io.FileInputStream r8 = new java.io.FileInputStream
            java.io.File r2 = r7.f16749a
            r8.<init>(r2)
            h0.A r7 = r7.f16750b     // Catch: java.lang.Throwable -> La1
            r0.f16752o = r8     // Catch: java.lang.Throwable -> La1
            r0.f16753p = r5     // Catch: java.lang.Throwable -> La1
            r0.f16756s = r3     // Catch: java.lang.Throwable -> La1
            java.lang.Object r7 = r7.c(r8, r0)     // Catch: java.lang.Throwable -> La1
            if (r7 != r1) goto L9a
        L99:
            return r1
        L9a:
            r6 = r8
            r8 = r7
            r7 = r6
        L9d:
            J5.b.a(r7, r5)
            return r8
        La1:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        La5:
            throw r8     // Catch: java.lang.Throwable -> La6
        La6:
            r0 = move-exception
            J5.b.a(r7, r8)
            throw r0
        Lab:
            h0.A r7 = r7.f16750b
            java.lang.Object r7 = r7.a()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.n.i(h0.n, C5.e):java.lang.Object");
    }

    @Override // h0.y
    public Object c(C5.e eVar) {
        return i(this, eVar);
    }

    @Override // h0.InterfaceC1127c
    public void close() {
        this.f16751c.set(true);
    }

    public final void f() {
        if (this.f16751c.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    public final File g() {
        return this.f16749a;
    }

    public final InterfaceC1117A h() {
        return this.f16750b;
    }
}
