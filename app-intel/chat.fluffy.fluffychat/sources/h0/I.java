package h0;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class I extends OutputStream {

    /* renamed from: l, reason: collision with root package name */
    public final FileOutputStream f16570l;

    public I(FileOutputStream fileOutputStream) {
        M5.m.e(fileOutputStream, "fileOutputStream");
        this.f16570l = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f16570l.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i7) throws IOException {
        this.f16570l.write(i7);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        M5.m.e(bArr, "b");
        this.f16570l.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i7, int i8) throws IOException {
        M5.m.e(bArr, "bytes");
        this.f16570l.write(bArr, i7, i8);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
