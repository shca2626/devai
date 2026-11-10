package G0;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class w implements f {

    /* renamed from: a, reason: collision with root package name */
    public final f f3225a;

    /* renamed from: b, reason: collision with root package name */
    public long f3226b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f3227c = Uri.EMPTY;

    /* renamed from: d, reason: collision with root package name */
    public Map f3228d = Collections.EMPTY_MAP;

    public w(f fVar) {
        this.f3225a = (f) j3.o.q(fVar);
    }

    @Override // G0.f
    public void close() {
        this.f3225a.close();
    }

    public long f() {
        return this.f3226b;
    }

    @Override // G0.f
    public void l(x xVar) {
        j3.o.q(xVar);
        this.f3225a.l(xVar);
    }

    @Override // G0.f
    public Map n() {
        return this.f3225a.n();
    }

    @Override // G0.f
    public Uri r() {
        return this.f3225a.r();
    }

    @Override // B0.InterfaceC0309k
    public int read(byte[] bArr, int i7, int i8) {
        int i9 = this.f3225a.read(bArr, i7, i8);
        if (i9 != -1) {
            this.f3226b += i9;
        }
        return i9;
    }

    @Override // G0.f
    public long s(j jVar) {
        this.f3227c = jVar.f3143a;
        this.f3228d = Collections.EMPTY_MAP;
        try {
            return this.f3225a.s(jVar);
        } finally {
            Uri uriR = r();
            if (uriR != null) {
                this.f3227c = uriR;
            }
            this.f3228d = n();
        }
    }

    public Uri u() {
        return this.f3227c;
    }

    public Map v() {
        return this.f3228d;
    }

    public void w() {
        this.f3226b = 0L;
    }
}
