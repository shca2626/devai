package J3;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class k extends i {

    /* renamed from: e, reason: collision with root package name */
    public b f4786e;

    public k(D3.h hVar) {
        super(hVar);
    }

    public static int[][] i(byte[] bArr, int i7, int i8, int i9, int i10) {
        int i11 = 8;
        int i12 = i10 - 8;
        int i13 = i9 - 8;
        char c7 = 2;
        boolean z7 = true;
        int i14 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i8, i7);
        int i15 = 0;
        while (i15 < i8) {
            int i16 = i15 << 3;
            if (i16 > i12) {
                i16 = i12;
            }
            int i17 = i14;
            while (i17 < i7) {
                int i18 = i17 << 3;
                if (i18 > i13) {
                    i18 = i13;
                }
                int i19 = (i16 * i9) + i18;
                char c8 = c7;
                boolean z8 = z7;
                int i20 = i14;
                int i21 = i20;
                int i22 = i21;
                int i23 = 255;
                while (i20 < i11) {
                    int i24 = i14;
                    int i25 = i22;
                    while (i24 < i11) {
                        int i26 = bArr[i19 + i24] & 255;
                        i21 += i26;
                        if (i26 < i23) {
                            i23 = i26;
                        }
                        if (i26 > i25) {
                            i25 = i26;
                        }
                        i24++;
                        i11 = 8;
                    }
                    if (i25 - i23 > 24) {
                        while (true) {
                            i20++;
                            i19 += i9;
                            if (i20 < 8) {
                                int i27 = 0;
                                for (int i28 = 8; i27 < i28; i28 = 8) {
                                    i21 += bArr[i19 + i27] & 255;
                                    i27++;
                                }
                            }
                        }
                    }
                    i20++;
                    i19 += i9;
                    i22 = i25;
                    i11 = 8;
                    i14 = 0;
                }
                int i29 = i21 >> 6;
                if (i22 - i23 <= 24) {
                    i29 = i23 / 2;
                    if (i15 > 0 && i17 > 0) {
                        int[] iArr2 = iArr[i15 - 1];
                        int i30 = i17 - 1;
                        int i31 = ((iArr2[i17] + (iArr[i15][i30] * 2)) + iArr2[i30]) / 4;
                        if (i23 < i31) {
                            i29 = i31;
                        }
                    }
                }
                iArr[i15][i17] = i29;
                i17++;
                c7 = c8;
                z7 = z8;
                i11 = 8;
                i14 = 0;
            }
            i15++;
            i11 = 8;
            i14 = 0;
        }
        return iArr;
    }

    public static void j(byte[] bArr, int i7, int i8, int i9, int i10, int[][] iArr, b bVar) {
        int i11 = i10 - 8;
        int i12 = i9 - 8;
        for (int i13 = 0; i13 < i8; i13++) {
            int i14 = i13 << 3;
            int i15 = i14 > i11 ? i11 : i14;
            int iK = k(i13, i8 - 3);
            for (int i16 = 0; i16 < i7; i16++) {
                int i17 = i16 << 3;
                int i18 = i17 > i12 ? i12 : i17;
                int iK2 = k(i16, i7 - 3);
                int i19 = 0;
                for (int i20 = -2; i20 <= 2; i20++) {
                    int[] iArr2 = iArr[iK + i20];
                    i19 += iArr2[iK2 - 2] + iArr2[iK2 - 1] + iArr2[iK2] + iArr2[iK2 + 1] + iArr2[2 + iK2];
                }
                l(bArr, i18, i15, i19 / 25, i9, bVar);
            }
        }
    }

    public static int k(int i7, int i8) {
        if (i7 < 2) {
            return 2;
        }
        return Math.min(i7, i8);
    }

    public static void l(byte[] bArr, int i7, int i8, int i9, int i10, b bVar) {
        int i11 = (i8 * i10) + i7;
        int i12 = 0;
        while (i12 < 8) {
            for (int i13 = 0; i13 < 8; i13++) {
                if ((bArr[i11 + i13] & 255) <= i9) {
                    bVar.s(i7 + i13, i8 + i12);
                }
            }
            i12++;
            i11 += i10;
        }
    }

    @Override // D3.b
    public D3.b a(D3.h hVar) {
        return new k(hVar);
    }

    @Override // J3.i, D3.b
    public b b() {
        b bVar = this.f4786e;
        if (bVar != null) {
            return bVar;
        }
        D3.h hVarE = e();
        int iD = hVarE.d();
        int iA = hVarE.a();
        if (iD < 40 || iA < 40) {
            this.f4786e = super.b();
        } else {
            byte[] bArrB = hVarE.b();
            int i7 = iD >> 3;
            if ((iD & 7) != 0) {
                i7++;
            }
            int i8 = i7;
            int i9 = iA >> 3;
            if ((iA & 7) != 0) {
                i9++;
            }
            int i10 = i9;
            int[][] iArrI = i(bArrB, i8, i10, iD, iA);
            b bVar2 = new b(iD, iA);
            j(bArrB, i8, i10, iD, iA, iArrI, bVar2);
            this.f4786e = bVar2;
        }
        return this.f4786e;
    }
}
