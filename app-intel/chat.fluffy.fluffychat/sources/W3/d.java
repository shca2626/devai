package W3;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f8975a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8976b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8977c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8978d;

    /* renamed from: e, reason: collision with root package name */
    public int f8979e = -1;

    public d(int i7, int i8, int i9, int i10) {
        this.f8975a = i7;
        this.f8976b = i8;
        this.f8977c = i9;
        this.f8978d = i10;
    }

    public int a() {
        return this.f8977c;
    }

    public int b() {
        return this.f8976b;
    }

    public int c() {
        return this.f8979e;
    }

    public int d() {
        return this.f8975a;
    }

    public int e() {
        return this.f8978d;
    }

    public int f() {
        return this.f8976b - this.f8975a;
    }

    public boolean g() {
        return h(this.f8979e);
    }

    public boolean h(int i7) {
        return i7 != -1 && this.f8977c == (i7 % 3) * 3;
    }

    public void i(int i7) {
        this.f8979e = i7;
    }

    public void j() {
        this.f8979e = ((this.f8978d / 30) * 3) + (this.f8977c / 3);
    }

    public String toString() {
        return this.f8979e + "|" + this.f8978d;
    }
}
