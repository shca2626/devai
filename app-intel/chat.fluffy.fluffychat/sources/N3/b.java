package N3;

import N3.e;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f6375a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f6376b;

    public b(int i7, byte[] bArr) {
        this.f6375a = i7;
        this.f6376b = bArr;
    }

    public static b[] b(byte[] bArr, e eVar) {
        e.c cVarD = eVar.d();
        e.b[] bVarArrA = cVarD.a();
        int iA = 0;
        for (e.b bVar : bVarArrA) {
            iA += bVar.a();
        }
        b[] bVarArr = new b[iA];
        int i7 = 0;
        for (e.b bVar2 : bVarArrA) {
            int i8 = 0;
            while (i8 < bVar2.a()) {
                int iB = bVar2.b();
                bVarArr[i7] = new b(iB, new byte[cVarD.b() + iB]);
                i8++;
                i7++;
            }
        }
        int length = bVarArr[0].f6376b.length - cVarD.b();
        int i9 = length - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i9; i11++) {
            int i12 = 0;
            while (i12 < i7) {
                bVarArr[i12].f6376b[i11] = bArr[i10];
                i12++;
                i10++;
            }
        }
        boolean z7 = eVar.i() == 24;
        int i13 = z7 ? 8 : i7;
        int i14 = 0;
        while (i14 < i13) {
            bVarArr[i14].f6376b[i9] = bArr[i10];
            i14++;
            i10++;
        }
        int length2 = bVarArr[0].f6376b.length;
        while (length < length2) {
            int i15 = 0;
            while (i15 < i7) {
                int i16 = z7 ? (i15 + 8) % i7 : i15;
                bVarArr[i16].f6376b[(!z7 || i16 <= 7) ? length : length - 1] = bArr[i10];
                i15++;
                i10++;
            }
            length++;
        }
        if (i10 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] a() {
        return this.f6376b;
    }

    public int c() {
        return this.f6375a;
    }
}
