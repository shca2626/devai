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
import y5.AbstractC1814j;
import y5.C1813i;
import y5.C1823s;

/* renamed from: s4.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1612h implements InterfaceC1610f {

    /* renamed from: a, reason: collision with root package name */
    public final String f22443a;

    /* renamed from: b, reason: collision with root package name */
    public RandomAccessFile f22444b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f22445c;

    /* renamed from: d, reason: collision with root package name */
    public int f22446d = -1;

    public C1612h(String str) {
        this.f22443a = str;
        if (str != null) {
            this.f22444b = d(str);
        }
    }

    @Override // s4.InterfaceC1610f
    public boolean a() {
        return this.f22443a == null;
    }

    @Override // s4.InterfaceC1610f
    public /* bridge */ void b(byte[] bArr) {
        super.b(bArr);
    }

    @Override // s4.InterfaceC1610f
    public void c(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) throws ErrnoException, InterruptedIOException {
        m.e(byteBuffer, "byteBuffer");
        m.e(bufferInfo, "bufferInfo");
        if (!this.f22445c) {
            throw new IllegalStateException("Container not started");
        }
        int i8 = this.f22446d;
        if (i8 < 0) {
            throw new IllegalStateException("No track has been added");
        }
        if (i8 != i7) {
            throw new IllegalStateException("Invalid track: " + i7);
        }
        RandomAccessFile randomAccessFile = this.f22444b;
        if (randomAccessFile != null) {
            m.b(randomAccessFile);
            Os.write(randomAccessFile.getFD(), byteBuffer);
        }
    }

    @Override // s4.InterfaceC1610f
    public /* bridge */ RandomAccessFile d(String str) {
        return super.d(str);
    }

    @Override // s4.InterfaceC1610f
    public /* bridge */ boolean e(MediaFormat mediaFormat) {
        return super.e(mediaFormat);
    }

    @Override // s4.InterfaceC1610f
    public int f(MediaFormat mediaFormat) {
        m.e(mediaFormat, "mediaFormat");
        if (this.f22445c) {
            throw new IllegalStateException("Container already started");
        }
        if (this.f22446d >= 0) {
            throw new IllegalStateException("Track already added");
        }
        this.f22446d = 0;
        return 0;
    }

    @Override // s4.InterfaceC1610f
    public byte[] g(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        m.e(byteBuffer, "byteBuffer");
        m.e(bufferInfo, "bufferInfo");
        int i8 = bufferInfo.size;
        byte[] bArr = new byte[i8];
        byteBuffer.get(bArr, bufferInfo.offset, i8);
        return bArr;
    }

    public void h() throws IOException {
        if (!this.f22445c) {
            throw new IllegalStateException("Container not started");
        }
        this.f22445c = false;
        RandomAccessFile randomAccessFile = this.f22444b;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    @Override // s4.InterfaceC1610f
    public void release() throws IOException {
        Object objB;
        C1823s c1823s;
        if (this.f22445c) {
            h();
            return;
        }
        try {
            C1813i.a aVar = C1813i.f24010m;
            RandomAccessFile randomAccessFile = this.f22444b;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                c1823s = C1823s.f24020a;
            } else {
                c1823s = null;
            }
            objB = C1813i.b(c1823s);
        } catch (Throwable th) {
            C1813i.a aVar2 = C1813i.f24010m;
            objB = C1813i.b(AbstractC1814j.a(th));
        }
        C1813i.a(objB);
    }

    @Override // s4.InterfaceC1610f
    public void start() {
        if (this.f22445c) {
            throw new IllegalStateException("Container already started");
        }
        this.f22445c = true;
    }
}
