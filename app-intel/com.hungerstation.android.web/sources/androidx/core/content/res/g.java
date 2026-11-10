package androidx.core.content.res;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
final class g {
    public static int[] a(int[] iArr, int i12, int i13) {
        if (i12 + 1 > iArr.length) {
            int[] iArr2 = new int[c(i12)];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            iArr = iArr2;
        }
        iArr[i12] = i13;
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.lang.Object[]] */
    public static <T> T[] b(T[] tArr, int i12, T t12) {
        if (i12 + 1 > tArr.length) {
            ?? r02 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), c(i12));
            System.arraycopy(tArr, 0, r02, 0, i12);
            tArr = r02;
        }
        tArr[i12] = t12;
        return tArr;
    }

    public static int c(int i12) {
        if (i12 <= 4) {
            return 8;
        }
        return i12 * 2;
    }
}
