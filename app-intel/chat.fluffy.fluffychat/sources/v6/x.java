package v6;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import z5.C1877k;

/* loaded from: classes3.dex */
public final class x extends h {

    /* renamed from: q, reason: collision with root package name */
    public final transient byte[][] f23235q;

    /* renamed from: r, reason: collision with root package name */
    public final transient int[] f23236r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(byte[][] bArr, int[] iArr) {
        super(h.f23188p.k());
        M5.m.e(bArr, "segments");
        M5.m.e(iArr, "directory");
        this.f23235q = bArr;
        this.f23236r = iArr;
    }

    @Override // v6.h
    public h A() {
        return G().A();
    }

    @Override // v6.h
    public byte[] B() {
        byte[] bArr = new byte[y()];
        int length = F().length;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < length) {
            int i10 = E()[length + i7];
            int i11 = E()[i7];
            int i12 = i11 - i8;
            C1877k.e(F()[i7], bArr, i9, i10, i10 + i12);
            i9 += i12;
            i7++;
            i8 = i11;
        }
        return bArr;
    }

    @Override // v6.h
    public void D(e eVar, int i7, int i8) {
        M5.m.e(eVar, "buffer");
        int i9 = i7 + i8;
        int iB = w6.c.b(this, i7);
        while (i7 < i9) {
            int i10 = iB == 0 ? 0 : E()[iB - 1];
            int i11 = E()[iB] - i10;
            int i12 = E()[F().length + iB];
            int iMin = Math.min(i9, i11 + i10) - i7;
            int i13 = i12 + (i7 - i10);
            v vVar = new v(F()[iB], i13, i13 + iMin, true, false);
            v vVar2 = eVar.f23178l;
            if (vVar2 == null) {
                vVar.f23229g = vVar;
                vVar.f23228f = vVar;
                eVar.f23178l = vVar;
            } else {
                M5.m.b(vVar2);
                v vVar3 = vVar2.f23229g;
                M5.m.b(vVar3);
                vVar3.c(vVar);
            }
            i7 += iMin;
            iB++;
        }
        eVar.J(eVar.size() + i8);
    }

    public final int[] E() {
        return this.f23236r;
    }

    public final byte[][] F() {
        return this.f23235q;
    }

    public final h G() {
        return new h(B());
    }

    @Override // v6.h
    public String a() {
        return G().a();
    }

    @Override // v6.h
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (hVar.y() == y() && t(0, hVar, 0, y())) {
                return true;
            }
        }
        return false;
    }

    @Override // v6.h
    public h h(String str) throws NoSuchAlgorithmException {
        M5.m.e(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = F().length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int i9 = E()[length + i7];
            int i10 = E()[i7];
            messageDigest.update(F()[i7], i9, i10 - i8);
            i7++;
            i8 = i10;
        }
        byte[] bArrDigest = messageDigest.digest();
        M5.m.d(bArrDigest, "digestBytes");
        return new h(bArrDigest);
    }

    @Override // v6.h
    public int hashCode() {
        int iL = l();
        if (iL != 0) {
            return iL;
        }
        int length = F().length;
        int i7 = 0;
        int i8 = 1;
        int i9 = 0;
        while (i7 < length) {
            int i10 = E()[length + i7];
            int i11 = E()[i7];
            byte[] bArr = F()[i7];
            int i12 = (i11 - i9) + i10;
            while (i10 < i12) {
                i8 = (i8 * 31) + bArr[i10];
                i10++;
            }
            i7++;
            i9 = i11;
        }
        v(i8);
        return i8;
    }

    @Override // v6.h
    public int m() {
        return E()[F().length - 1];
    }

    @Override // v6.h
    public String o() {
        return G().o();
    }

    @Override // v6.h
    public byte[] p() {
        return B();
    }

    @Override // v6.h
    public byte q(int i7) {
        AbstractC1720b.b(E()[F().length - 1], i7, 1L);
        int iB = w6.c.b(this, i7);
        return F()[iB][(i7 - (iB == 0 ? 0 : E()[iB - 1])) + E()[F().length + iB]];
    }

    @Override // v6.h
    public boolean t(int i7, h hVar, int i8, int i9) {
        M5.m.e(hVar, "other");
        if (i7 < 0 || i7 > y() - i9) {
            return false;
        }
        int i10 = i9 + i7;
        int iB = w6.c.b(this, i7);
        while (i7 < i10) {
            int i11 = iB == 0 ? 0 : E()[iB - 1];
            int i12 = E()[iB] - i11;
            int i13 = E()[F().length + iB];
            int iMin = Math.min(i10, i12 + i11) - i7;
            if (!hVar.u(i8, F()[iB], i13 + (i7 - i11), iMin)) {
                return false;
            }
            i8 += iMin;
            i7 += iMin;
            iB++;
        }
        return true;
    }

    @Override // v6.h
    public String toString() {
        return G().toString();
    }

    @Override // v6.h
    public boolean u(int i7, byte[] bArr, int i8, int i9) {
        M5.m.e(bArr, "other");
        if (i7 < 0 || i7 > y() - i9 || i8 < 0 || i8 > bArr.length - i9) {
            return false;
        }
        int i10 = i9 + i7;
        int iB = w6.c.b(this, i7);
        while (i7 < i10) {
            int i11 = iB == 0 ? 0 : E()[iB - 1];
            int i12 = E()[iB] - i11;
            int i13 = E()[F().length + iB];
            int iMin = Math.min(i10, i12 + i11) - i7;
            if (!AbstractC1720b.a(F()[iB], i13 + (i7 - i11), bArr, i8, iMin)) {
                return false;
            }
            i8 += iMin;
            i7 += iMin;
            iB++;
        }
        return true;
    }
}
