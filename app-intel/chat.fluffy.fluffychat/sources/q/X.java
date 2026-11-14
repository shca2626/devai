package q;

/* loaded from: classes.dex */
public class X {

    /* renamed from: a, reason: collision with root package name */
    public int f21189a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f21190b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f21191c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f21192d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public int f21193e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f21194f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f21195g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21196h = false;

    public int a() {
        return this.f21195g ? this.f21189a : this.f21190b;
    }

    public int b() {
        return this.f21189a;
    }

    public int c() {
        return this.f21190b;
    }

    public int d() {
        return this.f21195g ? this.f21190b : this.f21189a;
    }

    public void e(int i7, int i8) {
        this.f21196h = false;
        if (i7 != Integer.MIN_VALUE) {
            this.f21193e = i7;
            this.f21189a = i7;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.f21194f = i8;
            this.f21190b = i8;
        }
    }

    public void f(boolean z7) {
        if (z7 == this.f21195g) {
            return;
        }
        this.f21195g = z7;
        if (!this.f21196h) {
            this.f21189a = this.f21193e;
            this.f21190b = this.f21194f;
            return;
        }
        if (z7) {
            int i7 = this.f21192d;
            if (i7 == Integer.MIN_VALUE) {
                i7 = this.f21193e;
            }
            this.f21189a = i7;
            int i8 = this.f21191c;
            if (i8 == Integer.MIN_VALUE) {
                i8 = this.f21194f;
            }
            this.f21190b = i8;
            return;
        }
        int i9 = this.f21191c;
        if (i9 == Integer.MIN_VALUE) {
            i9 = this.f21193e;
        }
        this.f21189a = i9;
        int i10 = this.f21192d;
        if (i10 == Integer.MIN_VALUE) {
            i10 = this.f21194f;
        }
        this.f21190b = i10;
    }

    public void g(int i7, int i8) {
        this.f21191c = i7;
        this.f21192d = i8;
        this.f21196h = true;
        if (this.f21195g) {
            if (i8 != Integer.MIN_VALUE) {
                this.f21189a = i8;
            }
            if (i7 != Integer.MIN_VALUE) {
                this.f21190b = i7;
                return;
            }
            return;
        }
        if (i7 != Integer.MIN_VALUE) {
            this.f21189a = i7;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.f21190b = i8;
        }
    }
}
