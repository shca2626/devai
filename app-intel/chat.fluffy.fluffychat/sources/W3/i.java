package W3;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final float[][] f8998a = (float[][]) Array.newInstance((Class<?>) Float.TYPE, V3.a.f8618b.length, 8);

    static {
        int i7;
        int i8 = 0;
        while (true) {
            int[] iArr = V3.a.f8618b;
            if (i8 >= iArr.length) {
                return;
            }
            int i9 = iArr[i8];
            int i10 = i9 & 1;
            int i11 = 0;
            while (i11 < 8) {
                float f7 = 0.0f;
                while (true) {
                    i7 = i9 & 1;
                    if (i7 == i10) {
                        f7 += 1.0f;
                        i9 >>= 1;
                    }
                }
                f8998a[i8][7 - i11] = f7 / 17.0f;
                i11++;
                i10 = i7;
            }
            i8++;
        }
    }

    public static int a(int[] iArr) {
        long j7 = 0;
        for (int i7 = 0; i7 < iArr.length; i7++) {
            for (int i8 = 0; i8 < iArr[i7]; i8++) {
                int i9 = 1;
                long j8 = j7 << 1;
                if (i7 % 2 != 0) {
                    i9 = 0;
                }
                j7 = j8 | i9;
            }
        }
        return (int) j7;
    }

    public static int b(int[] iArr) {
        int iD = K3.a.d(iArr);
        float[] fArr = new float[8];
        if (iD > 1) {
            for (int i7 = 0; i7 < 8; i7++) {
                fArr[i7] = iArr[i7] / iD;
            }
        }
        float f7 = Float.MAX_VALUE;
        int i8 = -1;
        int i9 = 0;
        while (true) {
            float[][] fArr2 = f8998a;
            if (i9 >= fArr2.length) {
                return i8;
            }
            float[] fArr3 = fArr2[i9];
            float f8 = 0.0f;
            for (int i10 = 0; i10 < 8; i10++) {
                float f9 = fArr3[i10] - fArr[i10];
                f8 += f9 * f9;
                if (f8 >= f7) {
                    break;
                }
            }
            if (f8 < f7) {
                i8 = V3.a.f8618b[i9];
                f7 = f8;
            }
            i9++;
        }
    }

    public static int c(int[] iArr) {
        int iA = a(iArr);
        if (V3.a.a(iA) == -1) {
            return -1;
        }
        return iA;
    }

    public static int d(int[] iArr) {
        int iC = c(e(iArr));
        return iC != -1 ? iC : b(iArr);
    }

    public static int[] e(int[] iArr) {
        float fD = K3.a.d(iArr);
        int[] iArr2 = new int[8];
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < 17; i9++) {
            float f7 = (fD / 34.0f) + ((i9 * fD) / 17.0f);
            int i10 = iArr[i8];
            if (i7 + i10 <= f7) {
                i7 += i10;
                i8++;
            }
            iArr2[i8] = iArr2[i8] + 1;
        }
        return iArr2;
    }
}
