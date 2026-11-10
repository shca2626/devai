package v6;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* loaded from: classes3.dex */
public interface g extends A, ReadableByteChannel {
    String D();

    byte[] I(long j7);

    void O(long j7);

    long S();

    InputStream T();

    e b();

    long g(y yVar);

    h h(long j7);

    e l();

    boolean m();

    g peek();

    long q();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    short readShort();

    String s(long j7);

    void skip(long j7);

    boolean z(long j7);
}
