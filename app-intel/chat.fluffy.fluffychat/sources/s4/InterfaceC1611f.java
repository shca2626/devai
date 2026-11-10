package s4;

import M5.m;
import android.media.MediaCodec;
import android.media.MediaFormat;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import y5.C1812g;

/* renamed from: s4.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1611f {
    default boolean a() {
        return false;
    }

    void c(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    default RandomAccessFile d(String str) throws IOException {
        m.e(str, "path");
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        randomAccessFile.setLength(0L);
        return randomAccessFile;
    }

    default boolean e(MediaFormat mediaFormat) {
        m.e(mediaFormat, "format");
        return true;
    }

    int f(MediaFormat mediaFormat);

    default byte[] g(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        m.e(byteBuffer, "byteBuffer");
        m.e(bufferInfo, "bufferInfo");
        throw new C1812g(null, 1, null);
    }

    void release();

    void start();

    default void b(byte[] bArr) {
    }
}
