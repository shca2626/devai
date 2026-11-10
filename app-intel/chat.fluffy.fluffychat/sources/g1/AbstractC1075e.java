package g1;

import g1.N;

/* renamed from: g1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1075e {

    /* renamed from: a, reason: collision with root package name */
    public final a f16062a;

    /* renamed from: b, reason: collision with root package name */
    public final f f16063b;

    /* renamed from: c, reason: collision with root package name */
    public c f16064c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16065d;

    /* renamed from: g1.e$a */
    public static class a implements N {

        /* renamed from: a, reason: collision with root package name */
        public final d f16066a;

        /* renamed from: b, reason: collision with root package name */
        public final long f16067b;

        /* renamed from: c, reason: collision with root package name */
        public final long f16068c;

        /* renamed from: d, reason: collision with root package name */
        public final long f16069d;

        /* renamed from: e, reason: collision with root package name */
        public final long f16070e;

        /* renamed from: f, reason: collision with root package name */
        public final long f16071f;

        /* renamed from: g, reason: collision with root package name */
        public final long f16072g;

        public a(d dVar, long j7, long j8, long j9, long j10, long j11, long j12) {
            this.f16066a = dVar;
            this.f16067b = j7;
            this.f16068c = j8;
            this.f16069d = j9;
            this.f16070e = j10;
            this.f16071f = j11;
            this.f16072g = j12;
        }

        @Override // g1.N
        public boolean e() {
            return true;
        }

        @Override // g1.N
        public N.a g(long j7) {
            return new N.a(new O(j7, c.h(this.f16066a.a(j7), this.f16068c, this.f16069d, this.f16070e, this.f16071f, this.f16072g)));
        }

        @Override // g1.N
        public long i() {
            return this.f16067b;
        }

        public long n(long j7) {
            return this.f16066a.a(j7);
        }
    }

    /* renamed from: g1.e$c */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final long f16073a;

        /* renamed from: b, reason: collision with root package name */
        public final long f16074b;

        /* renamed from: c, reason: collision with root package name */
        public final long f16075c;

        /* renamed from: d, reason: collision with root package name */
        public long f16076d;

        /* renamed from: e, reason: collision with root package name */
        public long f16077e;

        /* renamed from: f, reason: collision with root package name */
        public long f16078f;

        /* renamed from: g, reason: collision with root package name */
        public long f16079g;

        /* renamed from: h, reason: collision with root package name */
        public long f16080h;

        public c(long j7, long j8, long j9, long j10, long j11, long j12, long j13) {
            this.f16073a = j7;
            this.f16074b = j8;
            this.f16076d = j9;
            this.f16077e = j10;
            this.f16078f = j11;
            this.f16079g = j12;
            this.f16075c = j13;
            this.f16080h = h(j8, j9, j10, j11, j12, j13);
        }

        public static long h(long j7, long j8, long j9, long j10, long j11, long j12) {
            if (j10 + 1 >= j11 || j8 + 1 >= j9) {
                return j10;
            }
            long j13 = (long) ((j7 - j8) * ((j11 - j10) / (j9 - j8)));
            return E0.U.p(((j13 + j10) - j12) - (j13 / 20), j10, j11 - 1);
        }

        public final long i() {
            return this.f16079g;
        }

        public final long j() {
            return this.f16078f;
        }

        public final long k() {
            return this.f16080h;
        }

        public final long l() {
            return this.f16073a;
        }

        public final long m() {
            return this.f16074b;
        }

        public final void n() {
            this.f16080h = h(this.f16074b, this.f16076d, this.f16077e, this.f16078f, this.f16079g, this.f16075c);
        }

        public final void o(long j7, long j8) {
            this.f16077e = j7;
            this.f16079g = j8;
            n();
        }

        public final void p(long j7, long j8) {
            this.f16076d = j7;
            this.f16078f = j8;
            n();
        }
    }

    /* renamed from: g1.e$d */
    public interface d {
        long a(long j7);
    }

    /* renamed from: g1.e$e, reason: collision with other inner class name */
    public static final class C0173e {

        /* renamed from: d, reason: collision with root package name */
        public static final C0173e f16081d = new C0173e(-3, -9223372036854775807L, -1);

        /* renamed from: a, reason: collision with root package name */
        public final int f16082a;

        /* renamed from: b, reason: collision with root package name */
        public final long f16083b;

        /* renamed from: c, reason: collision with root package name */
        public final long f16084c;

        public C0173e(int i7, long j7, long j8) {
            this.f16082a = i7;
            this.f16083b = j7;
            this.f16084c = j8;
        }

        public static C0173e d(long j7, long j8) {
            return new C0173e(-1, j7, j8);
        }

        public static C0173e e(long j7) {
            return new C0173e(0, -9223372036854775807L, j7);
        }

        public static C0173e f(long j7, long j8) {
            return new C0173e(-2, j7, j8);
        }
    }

    public AbstractC1075e(d dVar, f fVar, long j7, long j8, long j9, long j10, long j11, long j12, int i7) {
        this.f16063b = fVar;
        this.f16065d = i7;
        this.f16062a = new a(dVar, j7, j8, j9, j10, j11, j12);
    }

    public c a(long j7) {
        return new c(j7, this.f16062a.n(j7), this.f16062a.f16068c, this.f16062a.f16069d, this.f16062a.f16070e, this.f16062a.f16071f, this.f16062a.f16072g);
    }

    public final N b() {
        return this.f16062a;
    }

    public int c(r rVar, M m7) {
        while (true) {
            c cVar = (c) j3.o.q(this.f16064c);
            long j7 = cVar.j();
            long jI = cVar.i();
            long jK = cVar.k();
            if (jI - j7 <= this.f16065d) {
                e(false, j7);
                return g(rVar, j7, m7);
            }
            if (!i(rVar, jK)) {
                return g(rVar, jK, m7);
            }
            rVar.o();
            C0173e c0173eA = this.f16063b.a(rVar, cVar.m());
            int i7 = c0173eA.f16082a;
            if (i7 == -3) {
                e(false, jK);
                return g(rVar, jK, m7);
            }
            if (i7 == -2) {
                cVar.p(c0173eA.f16083b, c0173eA.f16084c);
            } else {
                if (i7 != -1) {
                    if (i7 != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    i(rVar, c0173eA.f16084c);
                    e(true, c0173eA.f16084c);
                    return g(rVar, c0173eA.f16084c, m7);
                }
                cVar.o(c0173eA.f16083b, c0173eA.f16084c);
            }
        }
    }

    public final boolean d() {
        return this.f16064c != null;
    }

    public final void e(boolean z7, long j7) {
        this.f16064c = null;
        this.f16063b.b();
        f(z7, j7);
    }

    public final int g(r rVar, long j7, M m7) {
        if (j7 == rVar.getPosition()) {
            return 0;
        }
        m7.f15965a = j7;
        return 1;
    }

    public final void h(long j7) {
        c cVar = this.f16064c;
        if (cVar == null || cVar.l() != j7) {
            this.f16064c = a(j7);
        }
    }

    public final boolean i(r rVar, long j7) {
        long position = j7 - rVar.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        rVar.p((int) position);
        return true;
    }

    /* renamed from: g1.e$f */
    public interface f {
        C0173e a(r rVar, long j7);

        default void b() {
        }
    }

    /* renamed from: g1.e$b */
    public static final class b implements d {
        @Override // g1.AbstractC1075e.d
        public long a(long j7) {
            return j7;
        }
    }

    public void f(boolean z7, long j7) {
    }
}
