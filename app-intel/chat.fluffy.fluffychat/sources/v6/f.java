package v6;

import java.nio.channels.WritableByteChannel;

/* loaded from: classes3.dex */
public interface f extends y, WritableByteChannel {
    f Q(long j7);

    e b();

    @Override // v6.y, java.io.Flushable
    void flush();

    f p();

    f v(String str);

    f w(long j7);

    f write(byte[] bArr);

    f write(byte[] bArr, int i7, int i8);

    f writeByte(int i7);

    f writeInt(int i7);

    f writeShort(int i7);
}
