package androidx.media3.exoplayer.rtsp;

import E0.U;
import G0.x;
import G0.y;
import android.net.Uri;
import androidx.media3.exoplayer.rtsp.g;
import j3.o;
import java.io.IOException;

/* loaded from: classes.dex */
public final class l implements a {

    /* renamed from: a, reason: collision with root package name */
    public final y f12812a;

    /* renamed from: b, reason: collision with root package name */
    public l f12813b;

    public l(long j7) {
        this.f12812a = new y(2000, o3.g.e(j7));
    }

    @Override // androidx.media3.exoplayer.rtsp.a
    public String b() {
        int iD = d();
        o.v(iD != -1);
        return U.G("RTP/AVP;unicast;client_port=%d-%d", Integer.valueOf(iD), Integer.valueOf(iD + 1));
    }

    @Override // G0.f
    public void close() throws IOException {
        this.f12812a.close();
        l lVar = this.f12813b;
        if (lVar != null) {
            lVar.close();
        }
    }

    @Override // androidx.media3.exoplayer.rtsp.a
    public int d() {
        int iD = this.f12812a.d();
        if (iD == -1) {
            return -1;
        }
        return iD;
    }

    @Override // androidx.media3.exoplayer.rtsp.a
    public boolean e() {
        return true;
    }

    public void f(l lVar) {
        o.d(this != lVar);
        this.f12813b = lVar;
    }

    @Override // androidx.media3.exoplayer.rtsp.a
    public g.b j() {
        return null;
    }

    @Override // G0.f
    public void l(x xVar) {
        this.f12812a.l(xVar);
    }

    @Override // G0.f
    public Uri r() {
        return this.f12812a.r();
    }

    @Override // B0.InterfaceC0309k
    public int read(byte[] bArr, int i7, int i8) throws y.a {
        try {
            return this.f12812a.read(bArr, i7, i8);
        } catch (y.a e7) {
            if (e7.f3136l == 2002) {
                return -1;
            }
            throw e7;
        }
    }

    @Override // G0.f
    public long s(G0.j jVar) {
        return this.f12812a.s(jVar);
    }
}
