package v6;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes3.dex */
public interface y extends Closeable, Flushable {
    void A(e eVar, long j7);

    B c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();
}
