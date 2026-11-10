package s4;

import M5.m;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.system.ErrnoException;
import android.system.Os;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import y5.AbstractC1815j;
import y5.C1814i;
import y5.C1824s;

/* renamed from: s4.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1613h implements InterfaceC1611f {

    /* renamed from: a, reason: collision with root package name */
    public final String f22437a;

    /* renamed from: b, reason: collision with root package name */
    public RandomAccessFile f22438b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f22439c;

    /* renamed from: d, reason: collision with root package name */
    public int f22440d = -1;

    public C1613h(String str) {
        this.f22437a = str;
        if (str != null) {
            this.f22438b = d(str);
        }
    }

    @Override // s4.InterfaceC1611f
    public boolean a() {
        return this.f22437a == null;
    }

    @Override // s4.InterfaceC1611f
    public /* bridge */ void b(byte[] bArr) {
        super.b(bArr);
    }

    @Override // s4.InterfaceC1611f
    public void c(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) throws ErrnoException, InterruptedIOException {
        m.e(byteBuffer, "byteBuffer");
        m.e(bufferInfo, "bufferInfo");
        if (!this.f22439c) {
            throw new IllegalStateException("Container not started");
        }
        int i8 = this.f22440d;
        if (i8 < 0) {
            throw new IllegalStateException("No track has been added");
        }
        if (i8 != i7) {
            throw new IllegalStateException("Invalid track: " + i7);
        }
        RandomAccessFile randomAccessFile = this.f22438b;
        if (randomAccessFile != null) {
            m.b(randomAccessFile);
            Os.write(randomAccessFile.getFD(), byteBuffer);
        }
    }

    @Override // s4.InterfaceC1611f
    public /* bridge */ RandomAccessFile d(String str) {
        return super.d(str);
    }

    @Override // s4.InterfaceC1611f
    public /* bridge */ boolean e(MediaFormat mediaFormat) {
        return super.e(mediaFormat);
    }

    @Override // s4.InterfaceC1611f
    public int f(MediaFormat mediaFormat) {
        m.e(mediaFormat, "mediaFormat");
        if (this.f22439c) {
            throw new IllegalStateException("Container already started");
        }
        if (this.f22440d >= 0) {
            throw new IllegalStateException("Track already added");
        }
        this.f22440d = 0;
        return 0;
    }

    @Override // s4.InterfaceC1611f
    public byte[] g(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        m.e(byteBuffer, "byteBuffer");
        m.e(bufferInfo, "bufferInfo");
        int i8 = bufferInfo.size;
        byte[] bArr = new byte[i8];
        byteBuffer.get(bArr, bufferInfo.offset, i8);
        return bArr;
    }

    public void h() throws IOException {
        if (!this.f22439c) {
            throw new IllegalStateException("Container not started");
        }
        this.f22439c = false;
        RandomAccessFile randomAccessFile = this.f22438b;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    @Override // s4.InterfaceC1611f
    public void release() throws IOException {
        Object objB;
        C1824s c1824s;
        if (this.f22439c) {
            h();
            return;
        }
        try {
            C1814i.a aVar = C1814i.f24004m;
            RandomAccessFile randomAccessFile = this.f22438b;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                c1824s = C1824s.f24014a;
            } else {
                c1824s = null;
            }
            objB = C1814i.b(c1824s);
        } catch (Throwable th) {
            C1814i.a aVar2 = C1814i.f24004m;
            objB = C1814i.b(AbstractC1815j.a(th));
        }
        C1814i.a(objB);
    }

    @Override // s4.InterfaceC1611f
    public void start() {
        if (this.f22439c) {
            throw new IllegalStateException("Container already started");
        }
        this.f22439c = true;
    }
}
