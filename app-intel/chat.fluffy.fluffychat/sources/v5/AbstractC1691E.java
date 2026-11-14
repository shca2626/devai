package v5;

import java.util.List;

/* renamed from: v5.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1691E {
    public static final float[] d(List list, float[] fArr, int i7) {
        int i8;
        float fSqrt;
        List list2 = list;
        int i9 = i7;
        float[] fArr2 = new float[i9];
        if (!list2.isEmpty()) {
            int i10 = 0;
            int i11 = 0;
            while (i11 < i9) {
                float f7 = i9;
                int iJ = S5.e.j(((int) Math.rint(((list2.size() / r7) * i11) / f7)) * 2, i10, list2.size() - 1);
                float size = list2.size() / 2;
                int i12 = i11 + 1;
                int iJ2 = S5.e.j(((int) Math.rint((size * i12) / f7)) * 2, i10, list2.size() - 1);
                S5.a aVarN = S5.e.n(S5.e.o(iJ, iJ2), 2);
                int iF = aVarN.f();
                int iG = aVarN.g();
                int iH = aVarN.h();
                if ((iH > 0 && iF <= iG) || (iH < 0 && iG <= iF)) {
                    fSqrt = 0.0f;
                    while (true) {
                        i8 = i11;
                        fSqrt += (float) Math.sqrt(Math.pow(((Number) list2.get(iF)).floatValue(), 2.0d) + Math.pow(((Number) list2.get(iF + 1)).floatValue(), 2.0d));
                        if (iF == iG) {
                            break;
                        }
                        iF += iH;
                        list2 = list;
                        i11 = i8;
                    }
                } else {
                    i8 = i11;
                    fSqrt = 0.0f;
                }
                int i13 = iJ2 - iJ;
                float f8 = i13 != 0 ? fSqrt / i13 : 0.0f;
                float f9 = fArr[i8];
                float f10 = f9 + (f8 - (f9 / 1.0f));
                fArr[i8] = f10;
                fArr2[i8] = (S5.e.i(f10, 0.1f, 8.0f) - 0.1f) / 7.9f;
                i10 = 0;
                list2 = list;
                i9 = i7;
                i11 = i12;
            }
        }
        return fArr2;
    }

    public static final float[] e(float[] fArr) {
        float[] fArr2 = new float[fArr.length];
        int length = fArr.length / 2;
        int length2 = fArr.length;
        int i7 = length;
        for (int i8 = 0; i8 < length2; i8++) {
            float f7 = fArr[i8];
            if (i8 % 2 == 0) {
                fArr2[i7] = f7;
                i7++;
            } else {
                length--;
                fArr2[length] = f7;
            }
        }
        return fArr2;
    }

    public static final float f(float f7) {
        if (f7 < 0.5d) {
            return 4 * f7 * f7 * f7;
        }
        return 1 - (((float) Math.pow((f7 * r1) - r1, 3)) / 2);
    }

    public static final float g(float f7, float f8, float f9) {
        return f7 + ((f8 - f7) * f(f9));
    }
}
