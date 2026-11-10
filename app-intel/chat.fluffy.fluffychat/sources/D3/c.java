package D3;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final b f1714a;

    /* renamed from: b, reason: collision with root package name */
    public J3.b f1715b;

    public c(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f1714a = bVar;
    }

    public J3.b a() {
        if (this.f1715b == null) {
            this.f1715b = this.f1714a.b();
        }
        return this.f1715b;
    }

    public J3.a b(int i7, J3.a aVar) {
        return this.f1714a.c(i7, aVar);
    }

    public int c() {
        return this.f1714a.d();
    }

    public int d() {
        return this.f1714a.f();
    }

    public boolean e() {
        return this.f1714a.e().f();
    }

    public c f() {
        return new c(this.f1714a.a(this.f1714a.e().g()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (j unused) {
            return "";
        }
    }
}
