package androidx.media3.exoplayer.rtsp;

import androidx.media3.exoplayer.rtsp.a;
import java.io.IOException;

/* loaded from: classes.dex */
public final class m implements a.InterfaceC0114a {

    /* renamed from: a, reason: collision with root package name */
    public final long f12814a;

    public m(long j7) {
        this.f12814a = j7;
    }

    @Override // androidx.media3.exoplayer.rtsp.a.InterfaceC0114a
    public a a(int i7) throws IOException {
        l lVar = new l(this.f12814a);
        l lVar2 = new l(this.f12814a);
        try {
            lVar.s(U0.h.a(0));
            int iD = lVar.d();
            boolean z7 = iD % 2 == 0;
            lVar2.s(U0.h.a(z7 ? iD + 1 : iD - 1));
            if (z7) {
                lVar.f(lVar2);
                return lVar;
            }
            lVar2.f(lVar);
            return lVar2;
        } catch (IOException e7) {
            G0.i.a(lVar);
            G0.i.a(lVar2);
            throw e7;
        }
    }

    @Override // androidx.media3.exoplayer.rtsp.a.InterfaceC0114a
    public a.InterfaceC0114a b() {
        return new k(this.f12814a);
    }
}
