package s4;

import M5.m;
import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
import z5.C1877k;
import z5.C1878l;

/* renamed from: s4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1606a implements InterfaceC1611f {

    /* renamed from: a, reason: collision with root package name */
    public final int f22416a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22417b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22418c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f22420e;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f22419d = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000};

    /* renamed from: f, reason: collision with root package name */
    public int f22421f = -1;

    public C1606a(int i7, int i8, int i9) {
        this.f22416a = i7;
        this.f22417b = i8;
        this.f22418c = i9;
    }

    @Override // s4.InterfaceC1611f
    public boolean a() {
        return true;
    }

    @Override // s4.InterfaceC1611f
    public /* bridge */ void b(byte[] bArr) {
        super.b(bArr);
    }

    @Override // s4.InterfaceC1611f
    public void c(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        m.e(byteBuffer, "byteBuffer");
        m.e(bufferInfo, "bufferInfo");
        if (!this.f22420e) {
            throw new IllegalStateException("Container not started");
        }
        int i8 = this.f22421f;
        if (i8 < 0) {
            throw new IllegalStateException("No track has been added");
        }
        if (i8 == i7) {
            return;
        }
        throw new IllegalStateException("Invalid track: " + i7);
    }

    @Override // s4.InterfaceC1611f
    public /* bridge */ boolean e(MediaFormat mediaFormat) {
        return super.e(mediaFormat);
    }

    @Override // s4.InterfaceC1611f
    public int f(MediaFormat mediaFormat) {
        m.e(mediaFormat, "mediaFormat");
        if (this.f22420e) {
            throw new IllegalStateException("Container already started");
        }
        if (this.f22421f >= 0) {
            throw new IllegalStateException("Track already added");
        }
        this.f22421f = 0;
        return 0;
    }

    @Override // s4.InterfaceC1611f
    public byte[] g(int i7, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        m.e(byteBuffer, "byteBuffer");
        m.e(bufferInfo, "bufferInfo");
        int iRemaining = byteBuffer.remaining();
        byte[] bArrH = h(iRemaining);
        byte[] bArr = new byte[iRemaining];
        byteBuffer.get(bArr, 0, iRemaining);
        return C1877k.p(bArrH, bArr);
    }

    public final byte[] h(int i7) {
        int i8 = i7 + 7;
        int i9 = ((this.f22418c - 1) << 6) + (i(this.f22416a) << 2);
        int i10 = this.f22417b;
        return new byte[]{-1, -7, (byte) (i9 + (i10 >> 2)), (byte) (((i10 & 3) << 6) + (i8 >> 11)), (byte) ((i8 & 2047) >> 3), (byte) (((i8 & 7) << 5) + 31), -4};
    }

    public final int i(int i7) {
        return C1878l.B(this.f22419d, i7);
    }

    public void j() {
        if (!this.f22420e) {
            throw new IllegalStateException("Container not started");
        }
        this.f22420e = false;
    }

    @Override // s4.InterfaceC1611f
    public void release() {
        if (this.f22420e) {
            j();
        }
    }

    @Override // s4.InterfaceC1611f
    public void start() {
        if (this.f22420e) {
            throw new IllegalStateException("Container already started");
        }
        this.f22420e = true;
    }
}
