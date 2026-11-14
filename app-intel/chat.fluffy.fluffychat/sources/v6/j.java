package v6;

/* loaded from: classes3.dex */
public abstract class j implements A {

    /* renamed from: l, reason: collision with root package name */
    public final A f23199l;

    public j(A a7) {
        M5.m.e(a7, "delegate");
        this.f23199l = a7;
    }

    @Override // v6.A
    public B c() {
        return this.f23199l.c();
    }

    @Override // v6.A, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f23199l.close();
    }

    public final A f() {
        return this.f23199l;
    }

    @Override // v6.A
    public long k(e eVar, long j7) {
        M5.m.e(eVar, "sink");
        return this.f23199l.k(eVar, j7);
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f23199l + ')';
    }
}
