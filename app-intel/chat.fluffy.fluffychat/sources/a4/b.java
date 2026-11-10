package a4;

import a4.j;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f10781a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f10782b;

    public b(int i7, byte[] bArr) {
        this.f10781a = i7;
        this.f10782b = bArr;
    }

    public static b[] b(byte[] bArr, j jVar, f fVar) {
        if (bArr.length != jVar.h()) {
            throw new IllegalArgumentException();
        }
        j.b bVarF = jVar.f(fVar);
        j.a[] aVarArrA = bVarF.a();
        int iA = 0;
        for (j.a aVar : aVarArrA) {
            iA += aVar.a();
        }
        b[] bVarArr = new b[iA];
        int i7 = 0;
        for (j.a aVar2 : aVarArrA) {
            int i8 = 0;
            while (i8 < aVar2.a()) {
                int iB = aVar2.b();
                bVarArr[i7] = new b(iB, new byte[bVarF.b() + iB]);
                i8++;
                i7++;
            }
        }
        int length = bVarArr[0].f10782b.length;
        int i9 = iA - 1;
        while (i9 >= 0 && bVarArr[i9].f10782b.length != length) {
            i9--;
        }
        int i10 = i9 + 1;
        int iB2 = length - bVarF.b();
        int i11 = 0;
        for (int i12 = 0; i12 < iB2; i12++) {
            int i13 = 0;
            while (i13 < i7) {
                bVarArr[i13].f10782b[i12] = bArr[i11];
                i13++;
                i11++;
            }
        }
        int i14 = i10;
        while (i14 < i7) {
            bVarArr[i14].f10782b[iB2] = bArr[i11];
            i14++;
            i11++;
        }
        int length2 = bVarArr[0].f10782b.length;
        while (iB2 < length2) {
            int i15 = 0;
            while (i15 < i7) {
                bVarArr[i15].f10782b[i15 < i10 ? iB2 : iB2 + 1] = bArr[i11];
                i15++;
                i11++;
            }
            iB2++;
        }
        return bVarArr;
    }

    public byte[] a() {
        return this.f10782b;
    }

    public int c() {
        return this.f10781a;
    }
}
