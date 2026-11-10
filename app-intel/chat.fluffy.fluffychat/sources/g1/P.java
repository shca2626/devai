package g1;

import B0.s;

/* loaded from: classes.dex */
public final class P implements InterfaceC1087q {

    /* renamed from: a, reason: collision with root package name */
    public final int f15973a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15974b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15975c;

    /* renamed from: d, reason: collision with root package name */
    public int f15976d;

    /* renamed from: e, reason: collision with root package name */
    public int f15977e;

    /* renamed from: f, reason: collision with root package name */
    public InterfaceC1088s f15978f;

    /* renamed from: g, reason: collision with root package name */
    public V f15979g;

    public P(int i7, int i8, String str) {
        this.f15973a = i7;
        this.f15974b = i8;
        this.f15975c = str;
    }

    @Override // g1.InterfaceC1087q
    public void a(long j7, long j8) {
        if (j7 == 0 || this.f15977e == 1) {
            this.f15977e = 1;
            this.f15976d = 0;
        }
    }

    @Override // g1.InterfaceC1087q
    public void b(InterfaceC1088s interfaceC1088s) {
        this.f15978f = interfaceC1088s;
        g(this.f15975c);
    }

    @Override // g1.InterfaceC1087q
    public boolean d(r rVar) {
        j3.o.v((this.f15973a == -1 || this.f15974b == -1) ? false : true);
        E0.E e7 = new E0.E(this.f15974b);
        rVar.t(e7.f(), 0, this.f15974b);
        return e7.Y() == this.f15973a;
    }

    @Override // g1.InterfaceC1087q
    public int f(r rVar, M m7) {
        int i7 = this.f15977e;
        if (i7 == 1) {
            h(rVar);
            return 0;
        }
        if (i7 == 2) {
            return -1;
        }
        throw new IllegalStateException();
    }

    public final void g(String str) {
        V vE = this.f15978f.e(1024, 4);
        this.f15979g = vE;
        vE.c(new s.b().W(str).y0(str).P());
        this.f15978f.o();
        this.f15978f.w(new Q(-9223372036854775807L));
        this.f15977e = 1;
    }

    public final void h(r rVar) {
        int iG = ((V) j3.o.q(this.f15979g)).g(rVar, 1024, true);
        if (iG != -1) {
            this.f15976d += iG;
            return;
        }
        this.f15977e = 2;
        this.f15979g.d(0L, 1, this.f15976d, 0, null);
        this.f15976d = 0;
    }

    @Override // g1.InterfaceC1087q
    public void release() {
    }
}
