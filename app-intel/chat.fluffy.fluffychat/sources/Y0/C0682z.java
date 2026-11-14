package Y0;

import android.net.Uri;
import java.util.Map;

/* renamed from: Y0.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0682z implements G0.f {

    /* renamed from: a, reason: collision with root package name */
    public final G0.f f9847a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9848b;

    /* renamed from: c, reason: collision with root package name */
    public final a f9849c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f9850d;

    /* renamed from: e, reason: collision with root package name */
    public int f9851e;

    /* renamed from: Y0.z$a */
    public interface a {
        void b(E0.E e7);
    }

    public C0682z(G0.f fVar, int i7, a aVar) {
        j3.o.d(i7 > 0);
        this.f9847a = fVar;
        this.f9848b = i7;
        this.f9849c = aVar;
        this.f9850d = new byte[1];
        this.f9851e = i7;
    }

    @Override // G0.f
    public void close() {
        throw new UnsupportedOperationException();
    }

    public final boolean f() {
        if (this.f9847a.read(this.f9850d, 0, 1) == -1) {
            return false;
        }
        int i7 = (this.f9850d[0] & 255) << 4;
        if (i7 == 0) {
            return true;
        }
        byte[] bArr = new byte[i7];
        int i8 = i7;
        int i9 = 0;
        while (i8 > 0) {
            int i10 = this.f9847a.read(bArr, i9, i8);
            if (i10 == -1) {
                return false;
            }
            i9 += i10;
            i8 -= i10;
        }
        while (i7 > 0 && bArr[i7 - 1] == 0) {
            i7--;
        }
        if (i7 > 0) {
            this.f9849c.b(new E0.E(bArr, i7));
        }
        return true;
    }

    @Override // G0.f
    public void l(G0.x xVar) {
        j3.o.q(xVar);
        this.f9847a.l(xVar);
    }

    @Override // G0.f
    public Map n() {
        return this.f9847a.n();
    }

    @Override // G0.f
    public Uri r() {
        return this.f9847a.r();
    }

    @Override // B0.InterfaceC0310k
    public int read(byte[] bArr, int i7, int i8) {
        if (this.f9851e == 0) {
            if (!f()) {
                return -1;
            }
            this.f9851e = this.f9848b;
        }
        int i9 = this.f9847a.read(bArr, i7, Math.min(this.f9851e, i8));
        if (i9 != -1) {
            this.f9851e -= i9;
        }
        return i9;
    }

    @Override // G0.f
    public long s(G0.j jVar) {
        throw new UnsupportedOperationException();
    }
}
