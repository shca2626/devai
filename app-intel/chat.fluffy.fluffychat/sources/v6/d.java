package v6;

import java.io.EOFException;

/* loaded from: classes3.dex */
public final class d implements y {
    @Override // v6.y
    public void A(e eVar, long j7) throws EOFException {
        M5.m.e(eVar, "source");
        eVar.skip(j7);
    }

    @Override // v6.y
    public B c() {
        return B.f23157e;
    }

    @Override // v6.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // v6.y, java.io.Flushable
    public void flush() {
    }
}
