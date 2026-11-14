package e1;

import E0.C0335u;
import E0.InterfaceC0322g;
import e1.s;

/* renamed from: e1.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1012C {

    /* renamed from: a, reason: collision with root package name */
    public final a f15323a;

    /* renamed from: b, reason: collision with root package name */
    public final s f15324b;

    /* renamed from: g, reason: collision with root package name */
    public final t f15329g;

    /* renamed from: l, reason: collision with root package name */
    public long f15334l;

    /* renamed from: c, reason: collision with root package name */
    public final s.a f15325c = new s.a();

    /* renamed from: d, reason: collision with root package name */
    public final E0.L f15326d = new E0.L();

    /* renamed from: e, reason: collision with root package name */
    public final E0.L f15327e = new E0.L();

    /* renamed from: f, reason: collision with root package name */
    public final C0335u f15328f = new C0335u();

    /* renamed from: h, reason: collision with root package name */
    public long f15330h = -9223372036854775807L;

    /* renamed from: k, reason: collision with root package name */
    public B0.P f15333k = B0.P.f568e;

    /* renamed from: i, reason: collision with root package name */
    public long f15331i = -9223372036854775807L;

    /* renamed from: j, reason: collision with root package name */
    public long f15332j = -9223372036854775807L;

    /* renamed from: e1.C$a */
    public interface a {
        void a(B0.P p7);

        void b();

        void c(long j7, long j8, boolean z7);
    }

    public C1012C(a aVar, s sVar, t tVar) {
        this.f15323a = aVar;
        this.f15324b = sVar;
        this.f15329g = tVar;
    }

    public static Object c(E0.L l7) {
        j3.o.d(l7.k() > 0);
        while (l7.k() > 1) {
            l7.h();
        }
        return j3.o.q(l7.h());
    }

    public final void a() {
        this.f15328f.f();
        this.f15323a.b();
    }

    public void b() {
        this.f15328f.b();
        this.f15330h = -9223372036854775807L;
        this.f15331i = -9223372036854775807L;
        this.f15332j = -9223372036854775807L;
        if (this.f15327e.k() > 0) {
            this.f15334l = ((Long) c(this.f15327e)).longValue();
        }
        if (this.f15326d.k() > 0) {
            this.f15326d.a(0L, (B0.P) c(this.f15326d));
        }
    }

    public boolean d() {
        long j7 = this.f15332j;
        return j7 != -9223372036854775807L && this.f15331i == j7;
    }

    public final boolean e(long j7) {
        Long l7 = (Long) this.f15327e.i(j7);
        if (l7 == null || l7.longValue() == this.f15334l) {
            return false;
        }
        this.f15334l = l7.longValue();
        return true;
    }

    public final boolean f(long j7) {
        B0.P p7 = (B0.P) this.f15326d.i(j7);
        if (p7 == null || p7.equals(B0.P.f568e) || p7.equals(this.f15333k)) {
            return false;
        }
        this.f15333k = p7;
        return true;
    }

    public void g(long j7) {
        this.f15328f.a(j7);
        this.f15330h = j7;
        this.f15332j = -9223372036854775807L;
    }

    public void h(int i7, long j7) {
        if (this.f15328f.e()) {
            this.f15324b.j(i7);
            this.f15334l = j7;
        } else {
            E0.L l7 = this.f15327e;
            long j8 = this.f15330h;
            l7.a(j8 == -9223372036854775807L ? -4611686018427387904L : j8 + 1, Long.valueOf(j7));
        }
    }

    public void i(int i7, int i8) {
        E0.L l7 = this.f15326d;
        long j7 = this.f15330h;
        l7.a(j7 == -9223372036854775807L ? 0L : j7 + 1, new B0.P(i7, i8));
    }

    public void j(long j7, long j8) {
        while (!this.f15328f.e()) {
            long jD = this.f15328f.d();
            if (e(jD)) {
                this.f15324b.j(2);
            }
            int iC = this.f15324b.c(jD, j7, j8, this.f15334l, false, false, this.f15325c);
            if (iC != 5 && iC != 4) {
                this.f15329g.b(jD, this.f15325c.f());
            }
            if (iC == 0 || iC == 1) {
                this.f15331i = jD;
                k(iC == 0);
            } else if (iC == 2 || iC == 3) {
                this.f15331i = jD;
                a();
            } else {
                if (iC != 4) {
                    if (iC != 5) {
                        throw new IllegalStateException(String.valueOf(iC));
                    }
                    return;
                }
                this.f15331i = jD;
            }
        }
    }

    public final void k(boolean z7) {
        long jF = this.f15328f.f();
        if (f(jF)) {
            this.f15323a.a(this.f15333k);
        }
        this.f15323a.c(z7 ? InterfaceC0322g.f2159a.f() : this.f15325c.g(), jF, this.f15324b.g());
    }

    public void l() {
        if (this.f15330h == -9223372036854775807L) {
            this.f15330h = Long.MIN_VALUE;
            this.f15331i = Long.MIN_VALUE;
        }
        this.f15332j = this.f15330h;
    }
}
