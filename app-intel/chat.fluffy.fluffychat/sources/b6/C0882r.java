package b6;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: b6.r, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0882r {

    /* renamed from: e, reason: collision with root package name */
    public static final a f13802e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13803f = AtomicReferenceFieldUpdater.newUpdater(C0882r.class, Object.class, "_next$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f13804g = AtomicLongFieldUpdater.newUpdater(C0882r.class, "_state$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final C0852E f13805h = new C0852E("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f13806a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f13807b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13808c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f13809d;

    /* renamed from: b6.r$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final int a(long j7) {
            return (j7 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j7, int i7) {
            return d(j7, 1073741823L) | i7;
        }

        public final long c(long j7, int i7) {
            return d(j7, 1152921503533105152L) | (i7 << 30);
        }

        public final long d(long j7, long j8) {
            return j7 & (~j8);
        }

        public a() {
        }
    }

    /* renamed from: b6.r$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f13810a;

        public b(int i7) {
            this.f13810a = i7;
        }
    }

    public C0882r(int i7, boolean z7) {
        this.f13806a = i7;
        this.f13807b = z7;
        int i8 = i7 - 1;
        this.f13808c = i8;
        this.f13809d = new AtomicReferenceArray(i7);
        if (i8 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i7 & i8) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Object r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = i()
        L4:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L18
            b6.r$a r13 = b6.C0882r.f13802e
            int r13 = r13.a(r3)
            return r13
        L18:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r1 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r2 = 30
            long r5 = r5 >> r2
            int r9 = (int) r5
            int r10 = r12.f13808c
            int r2 = r9 + 2
            r2 = r2 & r10
            r5 = r1 & r10
            r6 = 1
            if (r2 != r5) goto L32
            return r6
        L32:
            boolean r2 = r12.f13807b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L53
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r12.f()
            r11 = r9 & r10
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L53
            int r2 = r12.f13806a
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L52
            int r9 = r9 - r1
            r1 = r9 & r5
            int r2 = r2 >> 1
            if (r1 <= r2) goto L4
        L52:
            return r6
        L53:
            int r1 = r9 + 1
            r1 = r1 & r5
            r2 = r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = i()
            b6.r$a r5 = b6.C0882r.f13802e
            long r5 = r5.c(r3, r2)
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L4
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f()
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L72:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = i()
            long r1 = r1.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L8b
            b6.r r0 = r0.l()
            b6.r r0 = r0.e(r9, r13)
            if (r0 != 0) goto L72
        L8b:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.C0882r.a(java.lang.Object):int");
    }

    public final C0882r b(long j7) {
        C0882r c0882r = new C0882r(this.f13806a * 2, this.f13807b);
        int i7 = (int) (1073741823 & j7);
        int i8 = (int) ((1152921503533105152L & j7) >> 30);
        while (true) {
            int i9 = this.f13808c;
            if ((i7 & i9) == (i9 & i8)) {
                f13804g.set(c0882r, f13802e.d(j7, 1152921504606846976L));
                return c0882r;
            }
            Object bVar = f().get(this.f13808c & i7);
            if (bVar == null) {
                bVar = new b(i7);
            }
            c0882r.f().set(c0882r.f13808c & i7, bVar);
            i7++;
        }
    }

    public final C0882r c(long j7) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13803f;
        while (true) {
            C0882r c0882r = (C0882r) atomicReferenceFieldUpdater.get(this);
            if (c0882r != null) {
                return c0882r;
            }
            A.b.a(f13803f, this, null, b(j7));
        }
    }

    public final boolean d() {
        long j7;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13804g;
        do {
            j7 = atomicLongFieldUpdater.get(this);
            if ((j7 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j7) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j7, 2305843009213693952L | j7));
        return true;
    }

    public final C0882r e(int i7, Object obj) {
        Object obj2 = f().get(this.f13808c & i7);
        if (!(obj2 instanceof b) || ((b) obj2).f13810a != i7) {
            return null;
        }
        f().set(i7 & this.f13808c, obj);
        return this;
    }

    public final /* synthetic */ AtomicReferenceArray f() {
        return this.f13809d;
    }

    public final int g() {
        long j7 = f13804g.get(this);
        return (((int) ((j7 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j7))) & 1073741823;
    }

    public final boolean j() {
        long j7 = f13804g.get(this);
        return ((int) (1073741823 & j7)) == ((int) ((j7 & 1152921503533105152L) >> 30));
    }

    public final long k() {
        long j7;
        long j8;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13804g;
        do {
            j7 = atomicLongFieldUpdater.get(this);
            if ((j7 & 1152921504606846976L) != 0) {
                return j7;
            }
            j8 = 1152921504606846976L | j7;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j7, j8));
        return j8;
    }

    public final C0882r l() {
        return c(k());
    }

    public final Object m() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13804g;
        while (true) {
            long j7 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j7) != 0) {
                return f13805h;
            }
            int i7 = (int) (1073741823 & j7);
            int i8 = this.f13808c;
            if ((((int) ((1152921503533105152L & j7) >> 30)) & i8) == (i8 & i7)) {
                return null;
            }
            Object obj = f().get(this.f13808c & i7);
            if (obj == null) {
                if (this.f13807b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i9 = (i7 + 1) & 1073741823;
                if (f13804g.compareAndSet(this, j7, f13802e.b(j7, i9))) {
                    f().set(this.f13808c & i7, null);
                    return obj;
                }
                if (this.f13807b) {
                    C0882r c0882rN = this;
                    do {
                        c0882rN = c0882rN.n(i7, i9);
                    } while (c0882rN != null);
                    return obj;
                }
            }
        }
    }

    public final C0882r n(int i7, int i8) {
        long j7;
        int i9;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13804g;
        do {
            j7 = atomicLongFieldUpdater.get(this);
            i9 = (int) (1073741823 & j7);
            if ((1152921504606846976L & j7) != 0) {
                return l();
            }
        } while (!f13804g.compareAndSet(this, j7, f13802e.b(j7, i8)));
        f().set(this.f13808c & i9, null);
        return null;
    }
}
