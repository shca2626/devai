package s4;

import M5.m;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;

/* renamed from: s4.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1612g implements InterfaceC1611f {

    /* renamed from: a, reason: collision with root package name */
    public final String f22429a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f22430b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22431c;

    /* renamed from: d, reason: collision with root package name */
    public MediaMuxer f22432d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f22433e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f22434f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f22435g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f22436h;

    public C1612g(String str, boolean z7, int i7) {
        m.e(str, "path");
        this.f22429a = str;
        this.f22430b = z7;
        this.f22431c = i7;
    }

    @Override // s4.InterfaceC1611f
    public /* bridge */ boolean a() {
        return super.a();
    }

    @Override // s4.InterfaceC1611f
    public void b(byte[] bArr) {
        if (this.f22430b) {
            this.f22435g = true;
            this.f22436h = bArr;
        }
    }

    @Override // s4.InterfaceC1611f
    public void c(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        MediaMuxer mediaMuxer;
        m.e(byteBuffer, "byteBuffer");
        m.e(bufferInfo, "bufferInfo");
        if (!this.f22433e || this.f22434f || (mediaMuxer = this.f22432d) == null) {
            return;
        }
        mediaMuxer.writeSampleData(i7, byteBuffer, bufferInfo);
    }

    @Override // s4.InterfaceC1611f
    public boolean e(MediaFormat mediaFormat) {
        m.e(mediaFormat, "format");
        return !this.f22430b || mediaFormat.containsKey("csd-0") || this.f22435g;
    }

    @Override // s4.InterfaceC1611f
    public int f(MediaFormat mediaFormat) {
        byte[] bArr;
        m.e(mediaFormat, "mediaFormat");
        if (this.f22433e || this.f22434f) {
            return -1;
        }
        if (this.f22432d == null) {
            this.f22432d = new MediaMuxer(this.f22429a, this.f22431c);
        }
        if (this.f22430b && !mediaFormat.containsKey("csd-0") && (bArr = this.f22436h) != null) {
            mediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
        }
        MediaMuxer mediaMuxer = this.f22432d;
        m.b(mediaMuxer);
        return mediaMuxer.addTrack(mediaFormat);
    }

    @Override // s4.InterfaceC1611f
    public /* bridge */ byte[] g(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        return super.g(i7, byteBuffer, bufferInfo);
    }

    public void h() {
        if (!this.f22433e || this.f22434f) {
            return;
        }
        this.f22433e = false;
        this.f22434f = true;
        MediaMuxer mediaMuxer = this.f22432d;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
        }
    }

    @Override // s4.InterfaceC1611f
    public void release() {
        h();
        MediaMuxer mediaMuxer = this.f22432d;
        if (mediaMuxer != null) {
            mediaMuxer.release();
        }
        this.f22432d = null;
    }

    @Override // s4.InterfaceC1611f
    public void start() {
        if (this.f22433e || this.f22434f) {
            return;
        }
        this.f22433e = true;
        MediaMuxer mediaMuxer = this.f22432d;
        if (mediaMuxer != null) {
            mediaMuxer.start();
        }
    }
}
