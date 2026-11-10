package g1;

import B0.s;
import java.util.Collections;
import java.util.List;

/* renamed from: g1.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1095z {

    /* renamed from: a, reason: collision with root package name */
    public final int f16153a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16154b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16155c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16156d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16157e;

    /* renamed from: f, reason: collision with root package name */
    public final int f16158f;

    /* renamed from: g, reason: collision with root package name */
    public final int f16159g;

    /* renamed from: h, reason: collision with root package name */
    public final int f16160h;

    /* renamed from: i, reason: collision with root package name */
    public final int f16161i;

    /* renamed from: j, reason: collision with root package name */
    public final long f16162j;

    /* renamed from: k, reason: collision with root package name */
    public final a f16163k;

    /* renamed from: l, reason: collision with root package name */
    public final B0.y f16164l;

    /* renamed from: g1.z$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f16165a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f16166b;

        public a(long[] jArr, long[] jArr2) {
            this.f16165a = jArr;
            this.f16166b = jArr2;
        }
    }

    public C1095z(byte[] bArr, int i7) {
        E0.D d7 = new E0.D(bArr);
        d7.p(i7 * 8);
        this.f16153a = d7.h(16);
        this.f16154b = d7.h(16);
        this.f16155c = d7.h(24);
        this.f16156d = d7.h(24);
        int iH = d7.h(20);
        this.f16157e = iH;
        this.f16158f = j(iH);
        this.f16159g = d7.h(3) + 1;
        int iH2 = d7.h(5) + 1;
        this.f16160h = iH2;
        this.f16161i = e(iH2);
        this.f16162j = d7.j(36);
        this.f16163k = null;
        this.f16164l = null;
    }

    public static int e(int i7) {
        if (i7 == 8) {
            return 1;
        }
        if (i7 == 12) {
            return 2;
        }
        if (i7 == 16) {
            return 4;
        }
        if (i7 == 20) {
            return 5;
        }
        if (i7 != 24) {
            return i7 != 32 ? -1 : 7;
        }
        return 6;
    }

    public static int j(int i7) {
        switch (i7) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public C1095z a(List list) {
        return new C1095z(this.f16153a, this.f16154b, this.f16155c, this.f16156d, this.f16157e, this.f16159g, this.f16160h, this.f16162j, this.f16163k, h(new B0.y(list)));
    }

    public C1095z b(a aVar) {
        return new C1095z(this.f16153a, this.f16154b, this.f16155c, this.f16156d, this.f16157e, this.f16159g, this.f16160h, this.f16162j, aVar, this.f16164l);
    }

    public C1095z c(List list) {
        return new C1095z(this.f16153a, this.f16154b, this.f16155c, this.f16156d, this.f16157e, this.f16159g, this.f16160h, this.f16162j, this.f16163k, h(Y.d(list)));
    }

    public long d() {
        long j7;
        long j8;
        int i7 = this.f16156d;
        if (i7 > 0) {
            j7 = (i7 + this.f16155c) / 2;
            j8 = 1;
        } else {
            int i8 = this.f16153a;
            j7 = ((((i8 != this.f16154b || i8 <= 0) ? 4096L : i8) * this.f16159g) * this.f16160h) / 8;
            j8 = 64;
        }
        return j7 + j8;
    }

    public long f() {
        long j7 = this.f16162j;
        if (j7 == 0) {
            return -9223372036854775807L;
        }
        return (j7 * 1000000) / this.f16157e;
    }

    public B0.s g(byte[] bArr, B0.y yVar) {
        bArr[4] = Byte.MIN_VALUE;
        int i7 = this.f16156d;
        if (i7 <= 0) {
            i7 = -1;
        }
        return new s.b().y0("audio/flac").o0(i7).T(this.f16159g).z0(this.f16157e).s0(E0.U.i0(this.f16160h)).k0(Collections.singletonList(bArr)).r0(h(yVar)).P();
    }

    public B0.y h(B0.y yVar) {
        B0.y yVar2 = this.f16164l;
        return yVar2 == null ? yVar : yVar2.b(yVar);
    }

    public long i(long j7) {
        return E0.U.p((j7 * this.f16157e) / 1000000, 0L, this.f16162j - 1);
    }

    public C1095z(int i7, int i8, int i9, int i10, int i11, int i12, int i13, long j7, a aVar, B0.y yVar) {
        this.f16153a = i7;
        this.f16154b = i8;
        this.f16155c = i9;
        this.f16156d = i10;
        this.f16157e = i11;
        this.f16158f = j(i11);
        this.f16159g = i12;
        this.f16160h = i13;
        this.f16161i = e(i13);
        this.f16162j = j7;
        this.f16163k = aVar;
        this.f16164l = yVar;
    }
}
