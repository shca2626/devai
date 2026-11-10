package w6;

import M5.m;
import v6.x;

/* loaded from: classes3.dex */
public abstract class c {
    public static final int a(int[] iArr, int i7, int i8, int i9) {
        m.e(iArr, "<this>");
        int i10 = i9 - 1;
        while (i8 <= i10) {
            int i11 = (i8 + i10) >>> 1;
            int i12 = iArr[i11];
            if (i12 < i7) {
                i8 = i11 + 1;
            } else {
                if (i12 <= i7) {
                    return i11;
                }
                i10 = i11 - 1;
            }
        }
        return (-i8) - 1;
    }

    public static final int b(x xVar, int i7) {
        m.e(xVar, "<this>");
        int iA = a(xVar.E(), i7 + 1, 0, xVar.F().length);
        return iA >= 0 ? iA : ~iA;
    }
}
