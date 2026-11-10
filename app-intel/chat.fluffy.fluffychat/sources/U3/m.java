package U3;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public int f8424a = 0;

    /* renamed from: b, reason: collision with root package name */
    public a f8425b = a.NUMERIC;

    public enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public int a() {
        return this.f8424a;
    }

    public void b(int i7) {
        this.f8424a += i7;
    }

    public boolean c() {
        return this.f8425b == a.ALPHA;
    }

    public boolean d() {
        return this.f8425b == a.ISO_IEC_646;
    }

    public void e() {
        this.f8425b = a.ALPHA;
    }

    public void f() {
        this.f8425b = a.ISO_IEC_646;
    }

    public void g() {
        this.f8425b = a.NUMERIC;
    }

    public void h(int i7) {
        this.f8424a = i7;
    }
}
