package J3;

/* loaded from: classes.dex */
public abstract class i extends D3.b {

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f4782d = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    public byte[] f4783b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f4784c;

    public i(D3.h hVar) {
        super(hVar);
        this.f4783b = f4782d;
        this.f4784c = new int[32];
    }

    public static int g(int[] iArr) throws D3.j {
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = iArr[i10];
            if (i11 > i7) {
                i9 = i10;
                i7 = i11;
            }
            if (i11 > i8) {
                i8 = i11;
            }
        }
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < length; i14++) {
            int i15 = i14 - i9;
            int i16 = iArr[i14] * i15 * i15;
            if (i16 > i13) {
                i12 = i14;
                i13 = i16;
            }
        }
        if (i9 <= i12) {
            int i17 = i9;
            i9 = i12;
            i12 = i17;
        }
        if (i9 - i12 <= length / 16) {
            throw D3.j.a();
        }
        int i18 = i9 - 1;
        int i19 = -1;
        int i20 = i18;
        while (i18 > i12) {
            int i21 = i18 - i12;
            int i22 = i21 * i21 * (i9 - i18) * (i8 - iArr[i18]);
            if (i22 > i19) {
                i20 = i18;
                i19 = i22;
            }
            i18--;
        }
        return i20 << 3;
    }

    @Override // D3.b
    public b b() throws D3.j {
        D3.h hVarE = e();
        int iD = hVarE.d();
        int iA = hVarE.a();
        b bVar = new b(iD, iA);
        h(iD);
        int[] iArr = this.f4784c;
        for (int i7 = 1; i7 < 5; i7++) {
            byte[] bArrC = hVarE.c((iA * i7) / 5, this.f4783b);
            int i8 = (iD * 4) / 5;
            for (int i9 = iD / 5; i9 < i8; i9++) {
                int i10 = (bArrC[i9] & 255) >> 3;
                iArr[i10] = iArr[i10] + 1;
            }
        }
        int iG = g(iArr);
        byte[] bArrB = hVarE.b();
        for (int i11 = 0; i11 < iA; i11++) {
            int i12 = i11 * iD;
            for (int i13 = 0; i13 < iD; i13++) {
                if ((bArrB[i12 + i13] & 255) < iG) {
                    bVar.s(i13, i11);
                }
            }
        }
        return bVar;
    }

    @Override // D3.b
    public a c(int i7, a aVar) throws D3.j {
        D3.h hVarE = e();
        int iD = hVarE.d();
        if (aVar == null || aVar.k() < iD) {
            aVar = new a(iD);
        } else {
            aVar.a();
        }
        h(iD);
        byte[] bArrC = hVarE.c(i7, this.f4783b);
        int[] iArr = this.f4784c;
        for (int i8 = 0; i8 < iD; i8++) {
            int i9 = (bArrC[i8] & 255) >> 3;
            iArr[i9] = iArr[i9] + 1;
        }
        int iG = g(iArr);
        if (iD < 3) {
            for (int i10 = 0; i10 < iD; i10++) {
                if ((bArrC[i10] & 255) < iG) {
                    aVar.o(i10);
                }
            }
        } else {
            int i11 = bArrC[0] & 255;
            int i12 = bArrC[1] & 255;
            int i13 = 1;
            while (i13 < iD - 1) {
                int i14 = i13 + 1;
                int i15 = bArrC[i14] & 255;
                if ((((i12 * 4) - i11) - i15) / 2 < iG) {
                    aVar.o(i13);
                }
                i11 = i12;
                i13 = i14;
                i12 = i15;
            }
        }
        return aVar;
    }

    public final void h(int i7) {
        if (this.f4783b.length < i7) {
            this.f4783b = new byte[i7];
        }
        for (int i8 = 0; i8 < 32; i8++) {
            this.f4784c[i8] = 0;
        }
    }
}
