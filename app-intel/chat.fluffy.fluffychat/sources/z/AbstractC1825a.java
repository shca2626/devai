package z;

import M5.m;

/* renamed from: z.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1825a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f24030a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f24031b = new long[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Object[] f24032c = new Object[0];

    public static final int a(int[] iArr, int i7, int i8) {
        m.e(iArr, "array");
        int i9 = i7 - 1;
        int i10 = 0;
        while (i10 <= i9) {
            int i11 = (i10 + i9) >>> 1;
            int i12 = iArr[i11];
            if (i12 < i8) {
                i10 = i11 + 1;
            } else {
                if (i12 <= i8) {
                    return i11;
                }
                i9 = i11 - 1;
            }
        }
        return ~i10;
    }

    public static final int b(long[] jArr, int i7, long j7) {
        m.e(jArr, "array");
        int i8 = i7 - 1;
        int i9 = 0;
        while (i9 <= i8) {
            int i10 = (i9 + i8) >>> 1;
            long j8 = jArr[i10];
            if (j8 < j7) {
                i9 = i10 + 1;
            } else {
                if (j8 <= j7) {
                    return i10;
                }
                i8 = i10 - 1;
            }
        }
        return ~i9;
    }

    public static final boolean c(Object obj, Object obj2) {
        return m.a(obj, obj2);
    }

    public static final int d(int i7) {
        for (int i8 = 4; i8 < 32; i8++) {
            int i9 = (1 << i8) - 12;
            if (i7 <= i9) {
                return i9;
            }
        }
        return i7;
    }

    public static final int e(int i7) {
        return d(i7 * 4) / 4;
    }

    public static final int f(int i7) {
        return d(i7 * 8) / 8;
    }
}
