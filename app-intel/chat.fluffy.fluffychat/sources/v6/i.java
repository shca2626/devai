package v6;

/* loaded from: classes3.dex */
public abstract class i implements y {

    /* renamed from: l, reason: collision with root package name */
    public final y f23192l;

    public i(y yVar) {
        M5.m.e(yVar, "delegate");
        this.f23192l = yVar;
    }

    @Override // v6.y
    public void A(e eVar, long j7) {
        M5.m.e(eVar, "source");
        this.f23192l.A(eVar, j7);
    }

    @Override // v6.y
    public B c() {
        return this.f23192l.c();
    }

    @Override // v6.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f23192l.close();
    }

    @Override // v6.y, java.io.Flushable
    public void flush() {
        this.f23192l.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f23192l + ')';
    }
}
