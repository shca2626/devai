package g5;

import h5.C1145a;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public a f16327a;

    /* renamed from: b, reason: collision with root package name */
    public a f16328b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16329c;

    /* renamed from: d, reason: collision with root package name */
    public final C1145a f16330d;

    public enum a {
        DETACHED,
        RESUMED,
        INACTIVE,
        HIDDEN,
        PAUSED
    }

    public g(X4.a aVar) {
        this(new C1145a(aVar, "flutter/lifecycle", h5.q.f16913b));
    }

    public void a() {
        g(this.f16327a, true);
    }

    public void b() {
        g(a.DETACHED, this.f16329c);
    }

    public void c() {
        g(a.INACTIVE, this.f16329c);
    }

    public void d() {
        g(a.PAUSED, this.f16329c);
    }

    public void e() {
        g(a.RESUMED, this.f16329c);
    }

    public void f() {
        g(this.f16327a, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(g5.g.a r3, boolean r4) {
        /*
            r2 = this;
            g5.g$a r0 = r2.f16327a
            if (r0 != r3) goto L9
            boolean r1 = r2.f16329c
            if (r4 != r1) goto L9
            goto L35
        L9:
            if (r3 != 0) goto L10
            if (r0 != 0) goto L10
            r2.f16329c = r4
            return
        L10:
            int r0 = r3.ordinal()
            if (r0 == 0) goto L2c
            r1 = 1
            if (r0 == r1) goto L24
            r1 = 2
            if (r0 == r1) goto L2c
            r1 = 3
            if (r0 == r1) goto L2c
            r1 = 4
            if (r0 == r1) goto L2c
            r0 = 0
            goto L2d
        L24:
            if (r4 == 0) goto L29
            g5.g$a r0 = g5.g.a.RESUMED
            goto L2d
        L29:
            g5.g$a r0 = g5.g.a.INACTIVE
            goto L2d
        L2c:
            r0 = r3
        L2d:
            r2.f16327a = r3
            r2.f16329c = r4
            g5.g$a r3 = r2.f16328b
            if (r0 != r3) goto L36
        L35:
            return
        L36:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "AppLifecycleState."
            r3.append(r4)
            java.lang.String r4 = r0.name()
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r4 = r4.toLowerCase(r1)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "Sending "
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = " message."
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String r1 = "LifecycleChannel"
            U4.b.f(r1, r4)
            h5.a r4 = r2.f16330d
            r4.c(r3)
            r2.f16328b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.g.g(g5.g$a, boolean):void");
    }

    public g(C1145a c1145a) {
        this.f16327a = null;
        this.f16328b = null;
        this.f16329c = true;
        this.f16330d = c1145a;
    }
}
