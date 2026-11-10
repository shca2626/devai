package S3;

/* loaded from: classes.dex */
public abstract class f {
    public static int a(int i7, int i8) {
        int i9 = i7 - i8;
        if (i9 > i8) {
            i9 = i8;
            i8 = i9;
        }
        int i10 = 1;
        int i11 = 1;
        while (i7 > i8) {
            i10 *= i7;
            if (i11 <= i9) {
                i10 /= i11;
                i11++;
            }
            i7--;
        }
        while (i11 <= i9) {
            i10 /= i11;
            i11++;
        }
        return i10;
    }

    public static int b(int[] iArr, int i7, boolean z7) {
        boolean z8;
        int[] iArr2 = iArr;
        int i8 = 0;
        for (int i9 : iArr2) {
            i8 += i9;
        }
        int length = iArr2.length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = length - 1;
            if (i10 >= i13) {
                return i11;
            }
            int i14 = 1 << i10;
            i12 |= i14;
            int i15 = 1;
            while (i15 < iArr2[i10]) {
                int i16 = i8 - i15;
                int i17 = length - i10;
                int i18 = i17 - 2;
                int iA = a(i16 - 1, i18);
                if (z7 && i12 == 0) {
                    int i19 = i17 - 1;
                    if (i16 - i19 >= i19) {
                        iA -= a(i16 - i17, i18);
                    }
                }
                boolean z9 = true;
                if (i17 - 1 > 1) {
                    int i20 = i16 - i18;
                    int iA2 = 0;
                    while (i20 > i7) {
                        iA2 += a((i16 - i20) - 1, i17 - 3);
                        i20--;
                        z9 = z9;
                    }
                    z8 = z9;
                    iA -= iA2 * (i13 - i10);
                } else {
                    z8 = true;
                    if (i16 > i7) {
                        iA--;
                    }
                }
                i11 += iA;
                i15++;
                i12 &= ~i14;
                iArr2 = iArr;
            }
            i8 -= i15;
            i10++;
            iArr2 = iArr;
        }
    }
}
