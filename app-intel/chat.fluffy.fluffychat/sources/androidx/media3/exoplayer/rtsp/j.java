package androidx.media3.exoplayer.rtsp;

import E0.U;
import android.net.Uri;
import androidx.media3.exoplayer.rtsp.g;
import j3.o;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class j extends G0.b implements a, g.b {

    /* renamed from: e, reason: collision with root package name */
    public final LinkedBlockingQueue f12807e;

    /* renamed from: f, reason: collision with root package name */
    public final long f12808f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f12809g;

    /* renamed from: h, reason: collision with root package name */
    public int f12810h;

    public j(long j7) {
        super(true);
        this.f12808f = j7;
        this.f12807e = new LinkedBlockingQueue();
        this.f12809g = new byte[0];
        this.f12810h = -1;
    }

    @Override // androidx.media3.exoplayer.rtsp.a
    public String b() {
        o.v(this.f12810h != -1);
        return U.G("RTP/AVP/TCP;unicast;interleaved=%d-%d", Integer.valueOf(this.f12810h), Integer.valueOf(this.f12810h + 1));
    }

    @Override // G0.f
    public void close() {
    }

    @Override // androidx.media3.exoplayer.rtsp.a
    public int d() {
        return this.f12810h;
    }

    @Override // androidx.media3.exoplayer.rtsp.a
    public boolean e() {
        return false;
    }

    @Override // androidx.media3.exoplayer.rtsp.g.b
    public void f(byte[] bArr) {
        this.f12807e.add(bArr);
    }

    @Override // androidx.media3.exoplayer.rtsp.a
    public g.b j() {
        return this;
    }

    @Override // G0.f
    public Uri r() {
        return null;
    }

    @Override // B0.InterfaceC0309k
    public int read(byte[] bArr, int i7, int i8) {
        if (i8 == 0) {
            return 0;
        }
        int iMin = Math.min(i8, this.f12809g.length);
        System.arraycopy(this.f12809g, 0, bArr, i7, iMin);
        byte[] bArr2 = this.f12809g;
        this.f12809g = Arrays.copyOfRange(bArr2, iMin, bArr2.length);
        if (iMin == i8) {
            return iMin;
        }
        try {
            byte[] bArr3 = (byte[]) this.f12807e.poll(this.f12808f, TimeUnit.MILLISECONDS);
            if (bArr3 == null) {
                return -1;
            }
            int iMin2 = Math.min(i8 - iMin, bArr3.length);
            System.arraycopy(bArr3, 0, bArr, i7 + iMin, iMin2);
            if (iMin2 < bArr3.length) {
                this.f12809g = Arrays.copyOfRange(bArr3, iMin2, bArr3.length);
            }
            return iMin + iMin2;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return -1;
        }
    }

    @Override // G0.f
    public long s(G0.j jVar) {
        this.f12810h = jVar.f3143a.getPort();
        return -1L;
    }
}
