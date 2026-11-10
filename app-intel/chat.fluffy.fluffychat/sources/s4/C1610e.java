package s4;

import M5.m;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import y5.AbstractC1815j;
import y5.AbstractC1818m;
import y5.AbstractC1819n;
import y5.AbstractC1820o;
import y5.AbstractC1821p;
import y5.C1814i;
import y5.C1824s;

/* renamed from: s4.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1610e implements InterfaceC1611f {

    /* renamed from: f, reason: collision with root package name */
    public static final a f22422f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f22423g = {102, 76, 97, 67};

    /* renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f22424a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f22425b;

    /* renamed from: c, reason: collision with root package name */
    public long f22426c;

    /* renamed from: d, reason: collision with root package name */
    public int f22427d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f22428e;

    /* renamed from: s4.e$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public C1610e(String str) {
        m.e(str, "path");
        this.f22424a = d(str);
        this.f22426c = -1L;
        this.f22427d = -1;
    }

    @Override // s4.InterfaceC1611f
    public /* bridge */ boolean a() {
        return super.a();
    }

    @Override // s4.InterfaceC1611f
    public void b(byte[] bArr) throws ErrnoException, InterruptedIOException {
        if (bArr == null) {
            return;
        }
        if (this.f22425b) {
            Os.write(this.f22424a.getFD(), ByteBuffer.wrap(bArr));
        } else {
            this.f22428e = bArr;
        }
    }

    @Override // s4.InterfaceC1611f
    public void c(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) throws Exception {
        m.e(byteBuffer, "byteBuffer");
        m.e(bufferInfo, "bufferInfo");
        if (!this.f22425b) {
            throw new Exception("Container not started");
        }
        int i8 = this.f22427d;
        if (i8 < 0) {
            throw new Exception("No track has been added");
        }
        if (i8 == i7) {
            Os.write(this.f22424a.getFD(), byteBuffer);
            this.f22426c = bufferInfo.presentationTimeUs;
        } else {
            throw new Exception("Invalid track: " + i7);
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
    public int f(MediaFormat mediaFormat) throws Exception {
        m.e(mediaFormat, "mediaFormat");
        if (this.f22425b) {
            throw new Exception("Container already started");
        }
        if (this.f22427d >= 0) {
            throw new Exception("Track already added");
        }
        this.f22427d = 0;
        return 0;
    }

    @Override // s4.InterfaceC1611f
    public /* bridge */ byte[] g(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        return super.g(i7, byteBuffer, bufferInfo);
    }

    public final void h() throws IOException, ErrnoException {
        FileDescriptor fd = this.f22424a.getFD();
        int i7 = OsConstants.SEEK_SET;
        Os.lseek(fd, 0L, i7);
        byte[] bArrF = AbstractC1819n.f(42);
        if (Os.read(this.f22424a.getFD(), bArrF, 0, AbstractC1819n.i(bArrF)) != AbstractC1819n.i(bArrF)) {
            throw new IOException("EOF reached when reading FLAC headers");
        }
        if (!m.a(ByteBuffer.wrap(bArrF, 0, 4), ByteBuffer.wrap(f22423g))) {
            throw new IOException("FLAC magic not found");
        }
        if (AbstractC1818m.a((byte) (AbstractC1819n.h(bArrF, 4) & Byte.MAX_VALUE)) != AbstractC1818m.a((byte) 0)) {
            throw new IOException("First metadata block is not STREAMINFO");
        }
        if (Integer.compare(AbstractC1820o.a(AbstractC1820o.a(AbstractC1820o.a(AbstractC1820o.a(AbstractC1819n.h(bArrF, 5) & 255) << 16) | AbstractC1820o.a(AbstractC1820o.a(AbstractC1819n.h(bArrF, 6) & 255) << 8)) | AbstractC1820o.a(AbstractC1819n.h(bArrF, 7) & 255)) ^ Integer.MIN_VALUE, 34 ^ Integer.MIN_VALUE) < 0) {
            throw new IOException("STREAMINFO block is too small");
        }
        long jA = AbstractC1608c.a(AbstractC1821p.a(AbstractC1821p.a(this.f22426c) * AbstractC1821p.a(AbstractC1820o.a(AbstractC1820o.a(AbstractC1820o.a(AbstractC1819n.h(bArrF, 20) & 255) >>> 4) | AbstractC1820o.a(AbstractC1820o.a(AbstractC1820o.a(AbstractC1819n.h(bArrF, 18) & 255) << 12) | AbstractC1820o.a(AbstractC1820o.a(AbstractC1819n.h(bArrF, 19) & 255) << 4))) & 4294967295L)), 1000000L);
        if (Long.compare(jA ^ Long.MIN_VALUE, AbstractC1821p.a(137438953472L) ^ Long.MIN_VALUE) >= 0) {
            throw new IOException("Frame count cannot be represented in FLAC: " + AbstractC1821p.d(jA));
        }
        AbstractC1819n.j(bArrF, 21, AbstractC1818m.a((byte) (AbstractC1818m.a((byte) (AbstractC1819n.h(bArrF, 21) & (-16))) | AbstractC1818m.a((byte) AbstractC1821p.a(AbstractC1821p.a(jA >>> 32) & 15)))));
        AbstractC1819n.j(bArrF, 22, AbstractC1818m.a((byte) AbstractC1821p.a(AbstractC1821p.a(jA >>> 24) & 255)));
        AbstractC1819n.j(bArrF, 23, AbstractC1818m.a((byte) AbstractC1821p.a(AbstractC1821p.a(jA >>> 16) & 255)));
        AbstractC1819n.j(bArrF, 24, AbstractC1818m.a((byte) AbstractC1821p.a(AbstractC1821p.a(jA >>> 8) & 255)));
        AbstractC1819n.j(bArrF, 25, AbstractC1818m.a((byte) AbstractC1821p.a(jA & 255)));
        Os.lseek(this.f22424a.getFD(), 21L, i7);
        if (Os.write(this.f22424a.getFD(), bArrF, 21, 5) != 5) {
            throw new IOException("EOF reached when writing frame count");
        }
    }

    public void i() throws Exception {
        if (!this.f22425b) {
            throw new Exception("Container not started");
        }
        this.f22425b = false;
        if (this.f22426c >= 0) {
            h();
        }
        this.f22424a.close();
    }

    @Override // s4.InterfaceC1611f
    public void release() throws Exception {
        Object objB;
        if (this.f22425b) {
            i();
            return;
        }
        try {
            C1814i.a aVar = C1814i.f24004m;
            this.f22424a.close();
            objB = C1814i.b(C1824s.f24014a);
        } catch (Throwable th) {
            C1814i.a aVar2 = C1814i.f24004m;
            objB = C1814i.b(AbstractC1815j.a(th));
        }
        C1814i.a(objB);
    }

    @Override // s4.InterfaceC1611f
    public void start() throws Exception {
        if (this.f22425b) {
            throw new Exception("Container already started");
        }
        Os.lseek(this.f22424a.getFD(), 0L, OsConstants.SEEK_SET);
        Os.ftruncate(this.f22424a.getFD(), 0L);
        byte[] bArr = this.f22428e;
        if (bArr != null) {
            Os.write(this.f22424a.getFD(), ByteBuffer.wrap(bArr));
            this.f22428e = null;
        }
        this.f22425b = true;
    }
}
