package q;

/* loaded from: classes.dex */
public class X {

    /* renamed from: a, reason: collision with root package name */
    public int f21183a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f21184b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f21185c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f21186d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public int f21187e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f21188f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f21189g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21190h = false;

    public int a() {
        return this.f21189g ? this.f21183a : this.f21184b;
    }

    public int b() {
        return this.f21183a;
    }

    public int c() {
        return this.f21184b;
    }

    public int d() {
        return this.f21189g ? this.f21184b : this.f21183a;
    }

    public void e(int i7, int i8) {
        this.f21190h = false;
        if (i7 != Integer.MIN_VALUE) {
            this.f21187e = i7;
            this.f21183a = i7;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.f21188f = i8;
            this.f21184b = i8;
        }
    }

    public void f(boolean z7) {
        if (z7 == this.f21189g) {
            return;
        }
        this.f21189g = z7;
        if (!this.f21190h) {
            this.f21183a = this.f21187e;
            this.f21184b = this.f21188f;
            return;
        }
        if (z7) {
            int i7 = this.f21186d;
            if (i7 == Integer.MIN_VALUE) {
                i7 = this.f21187e;
            }
            this.f21183a = i7;
            int i8 = this.f21185c;
            if (i8 == Integer.MIN_VALUE) {
                i8 = this.f21188f;
            }
            this.f21184b = i8;
            return;
        }
        int i9 = this.f21185c;
        if (i9 == Integer.MIN_VALUE) {
            i9 = this.f21187e;
        }
        this.f21183a = i9;
        int i10 = this.f21186d;
        if (i10 == Integer.MIN_VALUE) {
            i10 = this.f21188f;
        }
        this.f21184b = i10;
    }

    public void g(int i7, int i8) {
        this.f21185c = i7;
        this.f21186d = i8;
        this.f21190h = true;
        if (this.f21189g) {
            if (i8 != Integer.MIN_VALUE) {
                this.f21183a = i8;
            }
            if (i7 != Integer.MIN_VALUE) {
                this.f21184b = i7;
                return;
            }
            return;
        }
        if (i7 != Integer.MIN_VALUE) {
            this.f21183a = i7;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.f21184b = i8;
        }
    }
}
