package t4;

import M5.m;
import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
import s4.InterfaceC1611f;
import v4.C1686c;

/* loaded from: classes.dex */
public final class g implements InterfaceC1634b {

    /* renamed from: l, reason: collision with root package name */
    public final MediaFormat f22595l;

    /* renamed from: m, reason: collision with root package name */
    public final InterfaceC1633a f22596m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f22597n;

    /* renamed from: o, reason: collision with root package name */
    public final MediaCodec.BufferInfo f22598o;

    /* renamed from: p, reason: collision with root package name */
    public int f22599p;

    /* renamed from: q, reason: collision with root package name */
    public InterfaceC1611f f22600q;

    /* renamed from: r, reason: collision with root package name */
    public final int f22601r;

    /* renamed from: s, reason: collision with root package name */
    public final int f22602s;

    /* renamed from: t, reason: collision with root package name */
    public long f22603t;

    public g(C1686c c1686c, u4.f fVar, MediaFormat mediaFormat, InterfaceC1633a interfaceC1633a) {
        m.e(c1686c, "config");
        m.e(fVar, "format");
        m.e(mediaFormat, "mediaFormat");
        m.e(interfaceC1633a, "listener");
        this.f22595l = mediaFormat;
        this.f22596m = interfaceC1633a;
        this.f22598o = new MediaCodec.BufferInfo();
        this.f22599p = -1;
        this.f22600q = fVar.a(mediaFormat, c1686c.n());
        this.f22601r = mediaFormat.getInteger("x-frame-size-in-bytes");
        this.f22602s = mediaFormat.getInteger("sample-rate");
    }

    @Override // t4.InterfaceC1634b
    public void a(byte[] bArr) {
        m.e(bArr, "bytes");
        if (this.f22597n) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int iRemaining = byteBufferWrap.remaining() / this.f22601r;
            this.f22598o.offset = byteBufferWrap.position();
            this.f22598o.size = byteBufferWrap.limit();
            this.f22598o.presentationTimeUs = d();
            if (this.f22600q.a()) {
                InterfaceC1633a interfaceC1633a = this.f22596m;
                InterfaceC1611f interfaceC1611f = this.f22600q;
                int i7 = this.f22599p;
                m.b(byteBufferWrap);
                interfaceC1633a.b(interfaceC1611f.g(i7, byteBufferWrap, this.f22598o));
            } else {
                InterfaceC1611f interfaceC1611f2 = this.f22600q;
                int i8 = this.f22599p;
                m.b(byteBufferWrap);
                interfaceC1611f2.c(i8, byteBufferWrap, this.f22598o);
            }
            this.f22603t += iRemaining;
        }
    }

    @Override // t4.InterfaceC1634b
    public void b() {
        if (this.f22597n) {
            return;
        }
        this.f22599p = this.f22600q.f(this.f22595l);
        this.f22600q.start();
        this.f22597n = true;
    }

    @Override // t4.InterfaceC1634b
    public void c() {
        if (this.f22597n) {
            this.f22597n = false;
            this.f22600q.release();
        }
    }

    public final long d() {
        return (this.f22603t * 1000000) / this.f22602s;
    }
}
