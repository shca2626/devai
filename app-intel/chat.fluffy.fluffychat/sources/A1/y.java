package A1;

import E0.E;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public c f227a;

    /* renamed from: b, reason: collision with root package name */
    public long f228b;

    /* renamed from: c, reason: collision with root package name */
    public long f229c;

    /* renamed from: d, reason: collision with root package name */
    public long f230d;

    /* renamed from: e, reason: collision with root package name */
    public int f231e;

    /* renamed from: f, reason: collision with root package name */
    public int f232f;

    /* renamed from: l, reason: collision with root package name */
    public boolean f238l;

    /* renamed from: n, reason: collision with root package name */
    public x f240n;

    /* renamed from: p, reason: collision with root package name */
    public boolean f242p;

    /* renamed from: q, reason: collision with root package name */
    public long f243q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f244r;

    /* renamed from: g, reason: collision with root package name */
    public long[] f233g = new long[0];

    /* renamed from: h, reason: collision with root package name */
    public int[] f234h = new int[0];

    /* renamed from: i, reason: collision with root package name */
    public int[] f235i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    public long[] f236j = new long[0];

    /* renamed from: k, reason: collision with root package name */
    public boolean[] f237k = new boolean[0];

    /* renamed from: m, reason: collision with root package name */
    public boolean[] f239m = new boolean[0];

    /* renamed from: o, reason: collision with root package name */
    public final E f241o = new E();

    public void a(E e7) {
        e7.u(this.f241o.f(), 0, this.f241o.j());
        this.f241o.f0(0);
        this.f242p = false;
    }

    public void b(g1.r rVar) {
        rVar.readFully(this.f241o.f(), 0, this.f241o.j());
        this.f241o.f0(0);
        this.f242p = false;
    }

    public long c(int i7) {
        return this.f236j[i7];
    }

    public void d(int i7) {
        this.f241o.b0(i7);
        this.f238l = true;
        this.f242p = true;
    }

    public void e(int i7, int i8) {
        this.f231e = i7;
        this.f232f = i8;
        if (this.f234h.length < i7) {
            this.f233g = new long[i7];
            this.f234h = new int[i7];
        }
        if (this.f235i.length < i8) {
            int i9 = (i8 * 125) / 100;
            this.f235i = new int[i9];
            this.f236j = new long[i9];
            this.f237k = new boolean[i9];
            this.f239m = new boolean[i9];
        }
    }

    public void f() {
        this.f231e = 0;
        this.f243q = 0L;
        this.f244r = false;
        this.f238l = false;
        this.f242p = false;
        this.f240n = null;
    }

    public boolean g(int i7) {
        return this.f238l && this.f239m[i7];
    }
}
