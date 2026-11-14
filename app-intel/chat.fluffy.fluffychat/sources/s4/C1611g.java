package s4;

import M5.m;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;

/* renamed from: s4.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1611g implements InterfaceC1610f {

    /* renamed from: a, reason: collision with root package name */
    public final String f22435a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f22436b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22437c;

    /* renamed from: d, reason: collision with root package name */
    public MediaMuxer f22438d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f22439e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f22440f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f22441g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f22442h;

    public C1611g(String str, boolean z7, int i7) {
        m.e(str, "path");
        this.f22435a = str;
        this.f22436b = z7;
        this.f22437c = i7;
    }

    @Override // s4.InterfaceC1610f
    public /* bridge */ boolean a() {
        return super.a();
    }

    @Override // s4.InterfaceC1610f
    public void b(byte[] bArr) {
        if (this.f22436b) {
            this.f22441g = true;
            this.f22442h = bArr;
        }
    }

    @Override // s4.InterfaceC1610f
    public void c(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        MediaMuxer mediaMuxer;
        m.e(byteBuffer, "byteBuffer");
        m.e(bufferInfo, "bufferInfo");
        if (!this.f22439e || this.f22440f || (mediaMuxer = this.f22438d) == null) {
            return;
        }
        mediaMuxer.writeSampleData(i7, byteBuffer, bufferInfo);
    }

    @Override // s4.InterfaceC1610f
    public boolean e(MediaFormat mediaFormat) {
        m.e(mediaFormat, "format");
        return !this.f22436b || mediaFormat.containsKey("csd-0") || this.f22441g;
    }

    @Override // s4.InterfaceC1610f
    public int f(MediaFormat mediaFormat) {
        byte[] bArr;
        m.e(mediaFormat, "mediaFormat");
        if (this.f22439e || this.f22440f) {
            return -1;
        }
        if (this.f22438d == null) {
            this.f22438d = new MediaMuxer(this.f22435a, this.f22437c);
        }
        if (this.f22436b && !mediaFormat.containsKey("csd-0") && (bArr = this.f22442h) != null) {
            mediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
        }
        MediaMuxer mediaMuxer = this.f22438d;
        m.b(mediaMuxer);
        return mediaMuxer.addTrack(mediaFormat);
    }

    @Override // s4.InterfaceC1610f
    public /* bridge */ byte[] g(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        return super.g(i7, byteBuffer, bufferInfo);
    }

    public void h() {
        if (!this.f22439e || this.f22440f) {
            return;
        }
        this.f22439e = false;
        this.f22440f = true;
        MediaMuxer mediaMuxer = this.f22438d;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
        }
    }

    @Override // s4.InterfaceC1610f
    public void release() {
        h();
        MediaMuxer mediaMuxer = this.f22438d;
        if (mediaMuxer != null) {
            mediaMuxer.release();
        }
        this.f22438d = null;
    }

    @Override // s4.InterfaceC1610f
    public void start() {
        if (this.f22439e || this.f22440f) {
            return;
        }
        this.f22439e = true;
        MediaMuxer mediaMuxer = this.f22438d;
        if (mediaMuxer != null) {
            mediaMuxer.start();
        }
    }
}
