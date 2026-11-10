package D1;

import B0.InterfaceC0309k;
import B0.z;
import D1.s;
import E0.AbstractC0332s;
import E0.E;
import E0.InterfaceC0325k;
import E0.U;
import g1.V;
import java.io.EOFException;

/* loaded from: classes.dex */
public final class v implements V {

    /* renamed from: a, reason: collision with root package name */
    public final V f1649a;

    /* renamed from: b, reason: collision with root package name */
    public final s.a f1650b;

    /* renamed from: h, reason: collision with root package name */
    public s f1656h;

    /* renamed from: i, reason: collision with root package name */
    public B0.s f1657i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1658j;

    /* renamed from: c, reason: collision with root package name */
    public final d f1651c = new d();

    /* renamed from: e, reason: collision with root package name */
    public int f1653e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f1654f = 0;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f1655g = U.f2098f;

    /* renamed from: d, reason: collision with root package name */
    public final E f1652d = new E();

    public v(V v7, s.a aVar) {
        this.f1649a = v7;
        this.f1650b = aVar;
    }

    @Override // g1.V
    public int b(InterfaceC0309k interfaceC0309k, int i7, boolean z7, int i8) throws EOFException {
        if (this.f1656h == null) {
            return this.f1649a.b(interfaceC0309k, i7, z7, i8);
        }
        i(i7);
        int i9 = interfaceC0309k.read(this.f1655g, this.f1654f, i7);
        if (i9 != -1) {
            this.f1654f += i9;
            return i9;
        }
        if (z7) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // g1.V
    public void c(B0.s sVar) {
        j3.o.q(sVar.f759o);
        j3.o.d(z.k(sVar.f759o) == 3);
        if (!sVar.equals(this.f1657i)) {
            this.f1657i = sVar;
            this.f1656h = this.f1650b.b(sVar) ? this.f1650b.d(sVar) : null;
        }
        if (this.f1656h == null) {
            this.f1649a.c(sVar);
        } else {
            this.f1649a.c(sVar.b().y0("application/x-media3-cues").U(sVar.f759o).C0(Long.MAX_VALUE).Y(this.f1650b.c(sVar)).P());
        }
    }

    @Override // g1.V
    public void d(final long j7, final int i7, int i8, int i9, V.a aVar) {
        if (this.f1656h == null) {
            this.f1649a.d(j7, i7, i8, i9, aVar);
            return;
        }
        j3.o.e(aVar == null, "DRM on subtitles is not supported");
        int i10 = (this.f1654f - i9) - i8;
        try {
            this.f1656h.a(this.f1655g, i10, i8, s.b.b(), new InterfaceC0325k() { // from class: D1.u
                @Override // E0.InterfaceC0325k
                public final void accept(Object obj) {
                    this.f1646a.j((e) obj, j7, i7);
                }
            });
        } catch (RuntimeException e7) {
            if (!this.f1658j) {
                throw e7;
            }
            AbstractC0332s.i("SubtitleTranscodingTO", "Parsing subtitles failed, ignoring sample.", e7);
        }
        int i11 = i10 + i8;
        this.f1653e = i11;
        if (i11 == this.f1654f) {
            this.f1653e = 0;
            this.f1654f = 0;
        }
    }

    @Override // g1.V
    public void f(E e7, int i7, int i8) {
        if (this.f1656h == null) {
            this.f1649a.f(e7, i7, i8);
            return;
        }
        i(i7);
        e7.u(this.f1655g, this.f1654f, i7);
        this.f1654f += i7;
    }

    public final void i(int i7) {
        int length = this.f1655g.length;
        int i8 = this.f1654f;
        if (length - i8 >= i7) {
            return;
        }
        int i9 = i8 - this.f1653e;
        int iMax = Math.max(i9 * 2, i7 + i9);
        byte[] bArr = this.f1655g;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.f1653e, bArr2, 0, i9);
        this.f1653e = 0;
        this.f1654f = i9;
        this.f1655g = bArr2;
    }

    public final void j(e eVar, long j7, int i7) {
        j3.o.q(this.f1657i);
        byte[] bArrA = this.f1651c.a(eVar.f1611a, eVar.f1613c);
        this.f1652d.c0(bArrA);
        this.f1649a.a(this.f1652d, bArrA.length);
        long j8 = eVar.f1612b;
        if (j8 == -9223372036854775807L) {
            j3.o.v(this.f1657i.f764t == Long.MAX_VALUE);
        } else {
            long j9 = this.f1657i.f764t;
            j7 = j9 == Long.MAX_VALUE ? j7 + j8 : j8 + j9;
        }
        this.f1649a.d(j7, i7 | 1, bArrA.length, 0, null);
    }

    public void k(boolean z7) {
        this.f1658j = z7;
    }
}
