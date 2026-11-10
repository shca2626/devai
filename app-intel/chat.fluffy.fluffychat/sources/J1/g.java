package J1;

import android.text.Layout;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public String f4698a;

    /* renamed from: b, reason: collision with root package name */
    public int f4699b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4700c;

    /* renamed from: d, reason: collision with root package name */
    public int f4701d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4702e;

    /* renamed from: k, reason: collision with root package name */
    public float f4708k;

    /* renamed from: l, reason: collision with root package name */
    public String f4709l;

    /* renamed from: o, reason: collision with root package name */
    public Layout.Alignment f4712o;

    /* renamed from: p, reason: collision with root package name */
    public Layout.Alignment f4713p;

    /* renamed from: r, reason: collision with root package name */
    public b f4715r;

    /* renamed from: t, reason: collision with root package name */
    public String f4717t;

    /* renamed from: u, reason: collision with root package name */
    public String f4718u;

    /* renamed from: f, reason: collision with root package name */
    public int f4703f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f4704g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f4705h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f4706i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f4707j = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f4710m = -1;

    /* renamed from: n, reason: collision with root package name */
    public int f4711n = -1;

    /* renamed from: q, reason: collision with root package name */
    public int f4714q = -1;

    /* renamed from: s, reason: collision with root package name */
    public float f4716s = Float.MAX_VALUE;

    public g A(String str) {
        this.f4698a = str;
        return this;
    }

    public g B(float f7) {
        this.f4708k = f7;
        return this;
    }

    public g C(int i7) {
        this.f4707j = i7;
        return this;
    }

    public g D(String str) {
        this.f4709l = str;
        return this;
    }

    public g E(boolean z7) {
        this.f4706i = z7 ? 1 : 0;
        return this;
    }

    public g F(boolean z7) {
        this.f4703f = z7 ? 1 : 0;
        return this;
    }

    public g G(Layout.Alignment alignment) {
        this.f4713p = alignment;
        return this;
    }

    public g H(String str) {
        this.f4717t = str;
        return this;
    }

    public g I(int i7) {
        this.f4711n = i7;
        return this;
    }

    public g J(int i7) {
        this.f4710m = i7;
        return this;
    }

    public g K(float f7) {
        this.f4716s = f7;
        return this;
    }

    public g L(Layout.Alignment alignment) {
        this.f4712o = alignment;
        return this;
    }

    public g M(boolean z7) {
        this.f4714q = z7 ? 1 : 0;
        return this;
    }

    public g N(b bVar) {
        this.f4715r = bVar;
        return this;
    }

    public g O(boolean z7) {
        this.f4704g = z7 ? 1 : 0;
        return this;
    }

    public g a(g gVar) {
        return t(gVar, true);
    }

    public int b() {
        if (this.f4702e) {
            return this.f4701d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public String c() {
        return this.f4718u;
    }

    public int d() {
        if (this.f4700c) {
            return this.f4699b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String e() {
        return this.f4698a;
    }

    public float f() {
        return this.f4708k;
    }

    public int g() {
        return this.f4707j;
    }

    public String h() {
        return this.f4709l;
    }

    public Layout.Alignment i() {
        return this.f4713p;
    }

    public String j() {
        return this.f4717t;
    }

    public int k() {
        return this.f4711n;
    }

    public int l() {
        return this.f4710m;
    }

    public float m() {
        return this.f4716s;
    }

    public int n() {
        int i7 = this.f4705h;
        if (i7 == -1 && this.f4706i == -1) {
            return -1;
        }
        return (i7 == 1 ? 1 : 0) | (this.f4706i == 1 ? 2 : 0);
    }

    public Layout.Alignment o() {
        return this.f4712o;
    }

    public boolean p() {
        return this.f4714q == 1;
    }

    public b q() {
        return this.f4715r;
    }

    public boolean r() {
        return this.f4702e;
    }

    public boolean s() {
        return this.f4700c;
    }

    public final g t(g gVar, boolean z7) {
        int i7;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.f4700c && gVar.f4700c) {
                z(gVar.f4699b);
            }
            if (this.f4705h == -1) {
                this.f4705h = gVar.f4705h;
            }
            if (this.f4706i == -1) {
                this.f4706i = gVar.f4706i;
            }
            if (this.f4698a == null && (str = gVar.f4698a) != null) {
                this.f4698a = str;
            }
            if (this.f4703f == -1) {
                this.f4703f = gVar.f4703f;
            }
            if (this.f4704g == -1) {
                this.f4704g = gVar.f4704g;
            }
            if (this.f4711n == -1) {
                this.f4711n = gVar.f4711n;
            }
            if (this.f4712o == null && (alignment2 = gVar.f4712o) != null) {
                this.f4712o = alignment2;
            }
            if (this.f4713p == null && (alignment = gVar.f4713p) != null) {
                this.f4713p = alignment;
            }
            if (this.f4714q == -1) {
                this.f4714q = gVar.f4714q;
            }
            if (this.f4707j == -1) {
                this.f4707j = gVar.f4707j;
                this.f4708k = gVar.f4708k;
            }
            if (this.f4715r == null) {
                this.f4715r = gVar.f4715r;
            }
            if (this.f4716s == Float.MAX_VALUE) {
                this.f4716s = gVar.f4716s;
            }
            if (this.f4717t == null) {
                this.f4717t = gVar.f4717t;
            }
            if (this.f4718u == null) {
                this.f4718u = gVar.f4718u;
            }
            if (z7 && !this.f4702e && gVar.f4702e) {
                w(gVar.f4701d);
            }
            if (z7 && this.f4710m == -1 && (i7 = gVar.f4710m) != -1) {
                this.f4710m = i7;
            }
        }
        return this;
    }

    public boolean u() {
        return this.f4703f == 1;
    }

    public boolean v() {
        return this.f4704g == 1;
    }

    public g w(int i7) {
        this.f4701d = i7;
        this.f4702e = true;
        return this;
    }

    public g x(boolean z7) {
        this.f4705h = z7 ? 1 : 0;
        return this;
    }

    public g y(String str) {
        this.f4718u = str;
        return this;
    }

    public g z(int i7) {
        this.f4699b = i7;
        this.f4700c = true;
        return this;
    }
}
