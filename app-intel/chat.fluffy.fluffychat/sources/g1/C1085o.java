package g1;

import B0.InterfaceC0309k;
import g1.V;
import java.io.EOFException;

/* renamed from: g1.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1085o implements V {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f16131a = new byte[4096];

    @Override // g1.V
    public int b(InterfaceC0309k interfaceC0309k, int i7, boolean z7, int i8) throws EOFException {
        int i9 = interfaceC0309k.read(this.f16131a, 0, Math.min(this.f16131a.length, i7));
        if (i9 != -1) {
            return i9;
        }
        if (z7) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // g1.V
    public void f(E0.E e7, int i7, int i8) {
        e7.g0(i7);
    }

    @Override // g1.V
    public void c(B0.s sVar) {
    }

    @Override // g1.V
    public void d(long j7, int i7, int i8, int i9, V.a aVar) {
    }
}
