package t4;

import M5.m;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import s4.InterfaceC1611f;
import v4.C1686c;

/* loaded from: classes.dex */
public final class f extends HandlerThread implements InterfaceC1634b {

    /* renamed from: A, reason: collision with root package name */
    public volatile Semaphore f22575A;

    /* renamed from: B, reason: collision with root package name */
    public volatile boolean f22576B;

    /* renamed from: l, reason: collision with root package name */
    public final C1686c f22577l;

    /* renamed from: m, reason: collision with root package name */
    public final u4.f f22578m;

    /* renamed from: n, reason: collision with root package name */
    public final MediaFormat f22579n;

    /* renamed from: o, reason: collision with root package name */
    public final InterfaceC1633a f22580o;

    /* renamed from: p, reason: collision with root package name */
    public final String f22581p;

    /* renamed from: q, reason: collision with root package name */
    public Handler f22582q;

    /* renamed from: r, reason: collision with root package name */
    public MediaCodec f22583r;

    /* renamed from: s, reason: collision with root package name */
    public InterfaceC1611f f22584s;

    /* renamed from: t, reason: collision with root package name */
    public final LinkedList f22585t;

    /* renamed from: u, reason: collision with root package name */
    public float f22586u;

    /* renamed from: v, reason: collision with root package name */
    public long f22587v;

    /* renamed from: w, reason: collision with root package name */
    public int f22588w;

    /* renamed from: x, reason: collision with root package name */
    public int f22589x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f22590y;

    /* renamed from: z, reason: collision with root package name */
    public MediaFormat f22591z;

    public final class a extends MediaCodec.Callback {
        public a() {
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            m.e(mediaCodec, "codec");
            m.e(codecException, "e");
            f.this.s(codecException);
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(MediaCodec mediaCodec, int i7) throws MediaCodec.CryptoException {
            m.e(mediaCodec, "codec");
            f.this.f22588w = i7;
            f.this.t();
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(MediaCodec mediaCodec, int i7, MediaCodec.BufferInfo bufferInfo) {
            m.e(mediaCodec, "codec");
            m.e(bufferInfo, "info");
            f.this.u(mediaCodec, i7, bufferInfo);
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            m.e(mediaCodec, "codec");
            m.e(mediaFormat, "format");
            if (f.this.f22590y) {
                return;
            }
            f.this.f22591z = mediaFormat;
            f.this.y();
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f22593a;

        /* renamed from: b, reason: collision with root package name */
        public int f22594b;

        public b(byte[] bArr) {
            m.e(bArr, "bytes");
            this.f22593a = bArr;
        }

        public final byte[] a() {
            return this.f22593a;
        }

        public final int b() {
            return this.f22594b;
        }

        public final boolean c() {
            return this.f22594b >= this.f22593a.length;
        }

        public final int d() {
            return this.f22593a.length - this.f22594b;
        }

        public final void e(int i7) {
            this.f22594b = i7;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(C1686c c1686c, u4.f fVar, MediaFormat mediaFormat, InterfaceC1633a interfaceC1633a, String str) {
        super("MediaCodecEncoder Thread");
        m.e(c1686c, "config");
        m.e(fVar, "format");
        m.e(mediaFormat, "mediaFormat");
        m.e(interfaceC1633a, "listener");
        m.e(str, "codecName");
        this.f22577l = c1686c;
        this.f22578m = fVar;
        this.f22579n = mediaFormat;
        this.f22580o = interfaceC1633a;
        this.f22581p = str;
        this.f22585t = new LinkedList();
        this.f22588w = -1;
    }

    public static final void o(f fVar, b bVar) throws MediaCodec.CryptoException {
        fVar.f22585t.add(bVar);
        if (fVar.f22588w >= 0) {
            fVar.t();
        }
    }

    public static final void v(f fVar) throws IOException {
        fVar.q();
    }

    public static final void x(f fVar) throws MediaCodec.CryptoException {
        if (fVar.f22588w >= 0) {
            fVar.t();
        }
    }

    @Override // t4.InterfaceC1634b
    public void a(byte[] bArr) {
        m.e(bArr, "bytes");
        if (this.f22576B) {
            return;
        }
        final b bVar = new b(bArr);
        Handler handler = this.f22582q;
        if (handler != null) {
            handler.post(new Runnable() { // from class: t4.c
                @Override // java.lang.Runnable
                public final void run() throws MediaCodec.CryptoException {
                    f.o(this.f22571l, bVar);
                }
            });
        }
    }

    @Override // t4.InterfaceC1634b
    public void b() {
        start();
        Handler handler = new Handler(getLooper());
        this.f22582q = handler;
        handler.post(new Runnable() { // from class: t4.d
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                f.v(this.f22573l);
            }
        });
    }

    @Override // t4.InterfaceC1634b
    public void c() {
        if (this.f22576B) {
            return;
        }
        this.f22576B = true;
        Semaphore semaphore = new Semaphore(0);
        this.f22575A = semaphore;
        Handler handler = this.f22582q;
        if (handler != null) {
            handler.post(new Runnable() { // from class: t4.e
                @Override // java.lang.Runnable
                public final void run() throws MediaCodec.CryptoException {
                    f.x(this.f22574l);
                }
            });
        }
        try {
            semaphore.acquire();
        } finally {
            quitSafely();
        }
    }

    public final void n() {
        this.f22586u = (16 / 8.0f) * this.f22579n.getInteger("sample-rate") * this.f22579n.getInteger("channel-count") * 1.0E-6f;
    }

    public final long p(long j7) {
        return (long) (j7 / this.f22586u);
    }

    public final void q() throws IOException {
        MediaCodec mediaCodecCreateByCodecName;
        Exception e7;
        n();
        try {
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(this.f22581p);
        } catch (Exception e8) {
            mediaCodecCreateByCodecName = null;
            e7 = e8;
        }
        try {
            mediaCodecCreateByCodecName.setCallback(new a(), new Handler(getLooper()));
            mediaCodecCreateByCodecName.configure(this.f22579n, (Surface) null, (MediaCrypto) null, 1);
            mediaCodecCreateByCodecName.start();
            InterfaceC1611f interfaceC1611fA = this.f22578m.a(this.f22579n, this.f22577l.n());
            this.f22583r = mediaCodecCreateByCodecName;
            this.f22584s = interfaceC1611fA;
        } catch (Exception e9) {
            e7 = e9;
            if (mediaCodecCreateByCodecName != null) {
                mediaCodecCreateByCodecName.release();
            }
            s(e7);
        }
    }

    public final void r(MediaCodec mediaCodec, int i7, MediaCodec.BufferInfo bufferInfo, InterfaceC1611f interfaceC1611f) {
        byte[] bArr;
        ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i7);
        if (outputBuffer != null) {
            outputBuffer.position(bufferInfo.offset);
            outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
            bArr = new byte[bufferInfo.size];
            outputBuffer.get(bArr);
        } else {
            bArr = null;
        }
        interfaceC1611f.b(bArr);
        y();
    }

    public final void s(Exception exc) {
        this.f22576B = true;
        w();
        this.f22580o.a(exc);
    }

    public final void t() throws MediaCodec.CryptoException {
        MediaCodec mediaCodec = this.f22583r;
        if (mediaCodec == null) {
            return;
        }
        try {
            b bVar = (b) this.f22585t.peekFirst();
            if (bVar == null) {
                if (this.f22575A != null) {
                    mediaCodec.queueInputBuffer(this.f22588w, 0, 0, p(this.f22587v), 4);
                    this.f22588w = -1;
                    return;
                }
                return;
            }
            ByteBuffer inputBuffer = mediaCodec.getInputBuffer(this.f22588w);
            m.b(inputBuffer);
            int iMin = Math.min(inputBuffer.capacity(), bVar.d());
            long jP = p(this.f22587v);
            inputBuffer.put(bVar.a(), bVar.b(), iMin);
            mediaCodec.queueInputBuffer(this.f22588w, 0, iMin, jP, 0);
            this.f22587v += iMin;
            bVar.e(bVar.b() + iMin);
            if (bVar.c()) {
                this.f22585t.pop();
            }
            this.f22588w = -1;
        } catch (Exception e7) {
            s(e7);
        }
    }

    public final void u(MediaCodec mediaCodec, int i7, MediaCodec.BufferInfo bufferInfo) {
        try {
            InterfaceC1611f interfaceC1611f = this.f22584s;
            if (interfaceC1611f != null && bufferInfo.size != 0) {
                if ((bufferInfo.flags & 2) != 0) {
                    r(mediaCodec, i7, bufferInfo, interfaceC1611f);
                } else {
                    ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i7);
                    if (outputBuffer != null && this.f22590y) {
                        if (interfaceC1611f.a()) {
                            this.f22580o.b(interfaceC1611f.g(this.f22589x, outputBuffer, bufferInfo));
                        } else {
                            interfaceC1611f.c(this.f22589x, outputBuffer, bufferInfo);
                        }
                    }
                }
            }
            mediaCodec.releaseOutputBuffer(i7, false);
            if ((bufferInfo.flags & 4) != 0) {
                w();
            }
        } catch (Exception e7) {
            s(e7);
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void w() {
        try {
            MediaCodec mediaCodec = this.f22583r;
            if (mediaCodec != null) {
                mediaCodec.stop();
            }
            MediaCodec mediaCodec2 = this.f22583r;
            if (mediaCodec2 != null) {
                mediaCodec2.release();
            }
            this.f22583r = null;
            InterfaceC1611f interfaceC1611f = this.f22584s;
            if (interfaceC1611f != null) {
                interfaceC1611f.release();
            }
            this.f22584s = null;
            Semaphore semaphore = this.f22575A;
            if (semaphore != null) {
                semaphore.release();
            }
            this.f22575A = null;
        } catch (Throwable th) {
            MediaCodec mediaCodec3 = this.f22583r;
            if (mediaCodec3 != null) {
                mediaCodec3.release();
            }
            this.f22583r = null;
            throw th;
        }
    }

    public final void y() {
        InterfaceC1611f interfaceC1611f;
        MediaFormat mediaFormat;
        if (this.f22590y || (interfaceC1611f = this.f22584s) == null || (mediaFormat = this.f22591z) == null || !interfaceC1611f.e(mediaFormat)) {
            return;
        }
        this.f22590y = true;
        this.f22589x = interfaceC1611f.f(mediaFormat);
        interfaceC1611f.start();
        Log.d("MediaCodecEncoder", "Container setup done: " + mediaFormat);
    }
}
