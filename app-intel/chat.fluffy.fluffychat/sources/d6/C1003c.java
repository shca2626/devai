package d6;

import W5.J;
import b6.AbstractC0877m;

/* renamed from: d6.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1003c extends f {

    /* renamed from: t, reason: collision with root package name */
    public static final C1003c f15267t = new C1003c();

    public C1003c() {
        super(j.f15279c, j.f15280d, j.f15281e, j.f15277a);
    }

    @Override // W5.J
    public J W(int i7, String str) {
        AbstractC0877m.a(i7);
        return i7 >= j.f15279c ? AbstractC0877m.b(this, str) : super.W(i7, str);
    }

    @Override // d6.f, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // W5.J
    public String toString() {
        return "Dispatchers.Default";
    }
}
