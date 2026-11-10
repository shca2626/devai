package androidx.appcompat.widget;

/* loaded from: classes.dex */
class v0 {

    /* renamed from: a, reason: collision with root package name */
    private int f2984a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f2985b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f2986c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    private int f2987d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f2988e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f2989f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2990g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2991h = false;

    v0() {
    }

    public int a() {
        return this.f2990g ? this.f2984a : this.f2985b;
    }

    public int b() {
        return this.f2984a;
    }

    public int c() {
        return this.f2985b;
    }

    public int d() {
        return this.f2990g ? this.f2985b : this.f2984a;
    }

    public void e(int i12, int i13) {
        this.f2991h = false;
        if (i12 != Integer.MIN_VALUE) {
            this.f2988e = i12;
            this.f2984a = i12;
        }
        if (i13 != Integer.MIN_VALUE) {
            this.f2989f = i13;
            this.f2985b = i13;
        }
    }

    public void f(boolean z12) {
        if (z12 == this.f2990g) {
            return;
        }
        this.f2990g = z12;
        if (!this.f2991h) {
            this.f2984a = this.f2988e;
            this.f2985b = this.f2989f;
            return;
        }
        if (z12) {
            int i12 = this.f2987d;
            if (i12 == Integer.MIN_VALUE) {
                i12 = this.f2988e;
            }
            this.f2984a = i12;
            int i13 = this.f2986c;
            if (i13 == Integer.MIN_VALUE) {
                i13 = this.f2989f;
            }
            this.f2985b = i13;
            return;
        }
        int i14 = this.f2986c;
        if (i14 == Integer.MIN_VALUE) {
            i14 = this.f2988e;
        }
        this.f2984a = i14;
        int i15 = this.f2987d;
        if (i15 == Integer.MIN_VALUE) {
            i15 = this.f2989f;
        }
        this.f2985b = i15;
    }

    public void g(int i12, int i13) {
        this.f2986c = i12;
        this.f2987d = i13;
        this.f2991h = true;
        if (this.f2990g) {
            if (i13 != Integer.MIN_VALUE) {
                this.f2984a = i13;
            }
            if (i12 != Integer.MIN_VALUE) {
                this.f2985b = i12;
                return;
            }
            return;
        }
        if (i12 != Integer.MIN_VALUE) {
            this.f2984a = i12;
        }
        if (i13 != Integer.MIN_VALUE) {
            this.f2985b = i13;
        }
    }
}
