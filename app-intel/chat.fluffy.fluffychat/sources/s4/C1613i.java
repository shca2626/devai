package s4;

import M5.m;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import y5.AbstractC1814j;
import y5.C1812h;
import y5.C1813i;
import y5.C1823s;

/* renamed from: s4.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1613i implements InterfaceC1610f {

    /* renamed from: g, reason: collision with root package name */
    public static final a f22447g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    public static final String f22448h = C1613i.class.getSimpleName();

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f22449i = {82, 73, 70, 70};

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f22450j = {87, 65, 86, 69};

    /* renamed from: k, reason: collision with root package name */
    public static final byte[] f22451k = {102, 109, 116, 32};

    /* renamed from: l, reason: collision with root package name */
    public static final byte[] f22452l = {100, 97, 116, 97};

    /* renamed from: a, reason: collision with root package name */
    public final int f22453a;

    /* renamed from: b, reason: collision with root package name */
    public final RandomAccessFile f22454b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f22455c;

    /* renamed from: d, reason: collision with root package name */
    public int f22456d;

    /* renamed from: e, reason: collision with root package name */
    public int f22457e;

    /* renamed from: f, reason: collision with root package name */
    public int f22458f;

    /* renamed from: s4.i$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public C1613i(String str, int i7) {
        m.e(str, "path");
        this.f22453a = i7;
        this.f22454b = d(str);
        this.f22456d = -1;
    }

    @Override // s4.InterfaceC1610f
    public /* bridge */ boolean a() {
        return super.a();
    }

    @Override // s4.InterfaceC1610f
    public /* bridge */ void b(byte[] bArr) {
        super.b(bArr);
    }

    @Override // s4.InterfaceC1610f
    public void c(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) throws ErrnoException, InterruptedIOException {
        m.e(byteBuffer, "byteBuffer");
        m.e(bufferInfo, "bufferInfo");
        if (!this.f22455c) {
            throw new IllegalStateException("Container not started");
        }
        int i8 = this.f22456d;
        if (i8 < 0) {
            throw new IllegalStateException("No track has been added");
        }
        if (i8 == i7) {
            Os.write(this.f22454b.getFD(), byteBuffer);
            return;
        }
        throw new IllegalStateException("Invalid track: " + i7);
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
        if (this.f22455c) {
            throw new IllegalStateException("Container already started");
        }
        if (this.f22456d >= 0) {
            throw new IllegalStateException("Track already added");
        }
        this.f22456d = 0;
        this.f22457e = mediaFormat.getInteger("channel-count");
        this.f22458f = mediaFormat.getInteger("sample-rate");
        return this.f22456d;
    }

    @Override // s4.InterfaceC1610f
    public /* bridge */ byte[] g(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        return super.g(i7, byteBuffer, bufferInfo);
    }

    public final ByteBuffer h(long j7) {
        C1812h c1812h;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(44);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (j7 > 4294967251L) {
            Log.w(f22448h, "File is oversized! WAV files can only fit in 4GB max.");
            c1812h = new C1812h(4294967287L, 4294967251L);
        } else {
            c1812h = new C1812h(Long.valueOf(j7 - 8), Long.valueOf(j7 - 44));
        }
        long jLongValue = ((Number) c1812h.a()).longValue();
        long jLongValue2 = ((Number) c1812h.b()).longValue();
        byteBufferAllocate.put(f22449i);
        byteBufferAllocate.put(i(jLongValue));
        byteBufferAllocate.put(f22450j);
        byteBufferAllocate.put(f22451k);
        byteBufferAllocate.putInt(16);
        byteBufferAllocate.putShort((short) 1);
        byteBufferAllocate.putShort((short) this.f22457e);
        byteBufferAllocate.putInt(this.f22458f);
        byteBufferAllocate.putInt(this.f22458f * this.f22453a);
        byteBufferAllocate.putShort((short) this.f22453a);
        byteBufferAllocate.putShort((short) ((this.f22453a / this.f22457e) * 8));
        byteBufferAllocate.put(f22452l);
        byteBufferAllocate.put(i(jLongValue2));
        byteBufferAllocate.flip();
        m.d(byteBufferAllocate, "apply(...)");
        return byteBufferAllocate;
    }

    public final byte[] i(long j7) {
        return new byte[]{(byte) (j7 & 255), (byte) ((j7 >> 8) & 255), (byte) ((j7 >> 16) & 255), (byte) ((j7 >> 24) & 255)};
    }

    public void j() throws IOException, ErrnoException {
        if (!this.f22455c) {
            throw new IllegalStateException("Container not started");
        }
        this.f22455c = false;
        if (this.f22456d >= 0) {
            ByteBuffer byteBufferH = h(Os.lseek(this.f22454b.getFD(), 0L, OsConstants.SEEK_CUR));
            Os.lseek(this.f22454b.getFD(), 0L, OsConstants.SEEK_SET);
            Os.write(this.f22454b.getFD(), byteBufferH);
        }
        this.f22454b.close();
    }

    @Override // s4.InterfaceC1610f
    public void release() throws IOException, ErrnoException {
        Object objB;
        if (this.f22455c) {
            j();
            return;
        }
        try {
            C1813i.a aVar = C1813i.f24010m;
            this.f22454b.close();
            objB = C1813i.b(C1823s.f24020a);
        } catch (Throwable th) {
            C1813i.a aVar2 = C1813i.f24010m;
            objB = C1813i.b(AbstractC1814j.a(th));
        }
        C1813i.a(objB);
    }

    @Override // s4.InterfaceC1610f
    public void start() throws ErrnoException {
        if (this.f22455c) {
            throw new IllegalStateException("Container already started");
        }
        Os.ftruncate(this.f22454b.getFD(), 0L);
        Os.lseek(this.f22454b.getFD(), 44L, OsConstants.SEEK_SET);
        this.f22455c = true;
    }
}
