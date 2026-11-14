package y;

import y5.C1823s;
import z.C1826b;
import z.C1827c;

/* renamed from: y.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1795j {

    /* renamed from: a, reason: collision with root package name */
    public int f23811a;

    /* renamed from: b, reason: collision with root package name */
    public final C1827c f23812b;

    /* renamed from: c, reason: collision with root package name */
    public final C1826b f23813c;

    /* renamed from: d, reason: collision with root package name */
    public int f23814d;

    /* renamed from: e, reason: collision with root package name */
    public int f23815e;

    /* renamed from: f, reason: collision with root package name */
    public int f23816f;

    /* renamed from: g, reason: collision with root package name */
    public int f23817g;

    /* renamed from: h, reason: collision with root package name */
    public int f23818h;

    /* renamed from: i, reason: collision with root package name */
    public int f23819i;

    public C1795j(int i7) {
        this.f23811a = i7;
        if (i7 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f23812b = new C1827c(0, 0.75f);
        this.f23813c = new C1826b();
    }

    public Object a(Object obj) {
        M5.m.e(obj, "key");
        return null;
    }

    public void b(boolean z7, Object obj, Object obj2, Object obj3) {
        M5.m.e(obj, "key");
        M5.m.e(obj2, "oldValue");
    }

    public final Object c(Object obj) {
        Object objD;
        M5.m.e(obj, "key");
        synchronized (this.f23813c) {
            Object objA = this.f23812b.a(obj);
            if (objA != null) {
                this.f23818h++;
                return objA;
            }
            this.f23819i++;
            Object objA2 = a(obj);
            if (objA2 == null) {
                return null;
            }
            synchronized (this.f23813c) {
                try {
                    this.f23816f++;
                    objD = this.f23812b.d(obj, objA2);
                    if (objD != null) {
                        this.f23812b.d(obj, objD);
                    } else {
                        this.f23814d += g(obj, objA2);
                        C1823s c1823s = C1823s.f24020a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (objD != null) {
                b(false, obj, objA2, objD);
                return objD;
            }
            j(this.f23811a);
            return objA2;
        }
    }

    public final int d() {
        int i7;
        synchronized (this.f23813c) {
            i7 = this.f23811a;
        }
        return i7;
    }

    public final Object e(Object obj, Object obj2) {
        Object objD;
        M5.m.e(obj, "key");
        M5.m.e(obj2, "value");
        synchronized (this.f23813c) {
            try {
                this.f23815e++;
                this.f23814d += g(obj, obj2);
                objD = this.f23812b.d(obj, obj2);
                if (objD != null) {
                    this.f23814d -= g(obj, objD);
                }
                C1823s c1823s = C1823s.f24020a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objD != null) {
            b(false, obj, objD, obj2);
        }
        j(this.f23811a);
        return objD;
    }

    public final Object f(Object obj) {
        Object objE;
        M5.m.e(obj, "key");
        synchronized (this.f23813c) {
            try {
                objE = this.f23812b.e(obj);
                if (objE != null) {
                    this.f23814d -= g(obj, objE);
                }
                C1823s c1823s = C1823s.f24020a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objE != null) {
            b(false, obj, objE, null);
        }
        return objE;
    }

    public final int g(Object obj, Object obj2) {
        int i7 = i(obj, obj2);
        if (i7 >= 0) {
            return i7;
        }
        throw new IllegalStateException(("Negative size: " + obj + '=' + obj2).toString());
    }

    public final int h() {
        int i7;
        synchronized (this.f23813c) {
            i7 = this.f23814d;
        }
        return i7;
    }

    public int i(Object obj, Object obj2) {
        M5.m.e(obj, "key");
        M5.m.e(obj2, "value");
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j(int r6) {
        /*
            r5 = this;
        L0:
            z.b r0 = r5.f23813c
            monitor-enter(r0)
            int r1 = r5.f23814d     // Catch: java.lang.Throwable -> L14
            if (r1 < 0) goto L57
            z.c r1 = r5.f23812b     // Catch: java.lang.Throwable -> L14
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L16
            int r1 = r5.f23814d     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L57
            goto L16
        L14:
            r6 = move-exception
            goto L5f
        L16:
            int r1 = r5.f23814d     // Catch: java.lang.Throwable -> L14
            if (r1 <= r6) goto L55
            z.c r1 = r5.f23812b     // Catch: java.lang.Throwable -> L14
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L23
            goto L55
        L23:
            z.c r1 = r5.f23812b     // Catch: java.lang.Throwable -> L14
            java.util.Set r1 = r1.b()     // Catch: java.lang.Throwable -> L14
            java.lang.Object r1 = z5.C1892w.F(r1)     // Catch: java.lang.Throwable -> L14
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L33
            monitor-exit(r0)
            return
        L33:
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L14
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L14
            z.c r3 = r5.f23812b     // Catch: java.lang.Throwable -> L14
            r3.e(r2)     // Catch: java.lang.Throwable -> L14
            int r3 = r5.f23814d     // Catch: java.lang.Throwable -> L14
            int r4 = r5.g(r2, r1)     // Catch: java.lang.Throwable -> L14
            int r3 = r3 - r4
            r5.f23814d = r3     // Catch: java.lang.Throwable -> L14
            int r3 = r5.f23817g     // Catch: java.lang.Throwable -> L14
            r4 = 1
            int r3 = r3 + r4
            r5.f23817g = r3     // Catch: java.lang.Throwable -> L14
            monitor-exit(r0)
            r0 = 0
            r5.b(r4, r2, r1, r0)
            goto L0
        L55:
            monitor-exit(r0)
            return
        L57:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L14
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L14
            throw r1     // Catch: java.lang.Throwable -> L14
        L5f:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: y.C1795j.j(int):void");
    }

    public String toString() {
        String str;
        synchronized (this.f23813c) {
            try {
                int i7 = this.f23818h;
                int i8 = this.f23819i + i7;
                str = "LruCache[maxSize=" + this.f23811a + ",hits=" + this.f23818h + ",misses=" + this.f23819i + ",hitRate=" + (i8 != 0 ? (i7 * 100) / i8 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
