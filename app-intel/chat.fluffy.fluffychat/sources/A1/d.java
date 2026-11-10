package A1;

import E0.U;

/* loaded from: classes.dex */
public abstract class d {

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f82a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f83b;

        /* renamed from: c, reason: collision with root package name */
        public final int f84c;

        /* renamed from: d, reason: collision with root package name */
        public final long[] f85d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f86e;

        /* renamed from: f, reason: collision with root package name */
        public final long f87f;

        /* renamed from: g, reason: collision with root package name */
        public final long f88g;

        public b(long[] jArr, int[] iArr, int i7, long[] jArr2, int[] iArr2, long j7, long j8) {
            this.f82a = jArr;
            this.f83b = iArr;
            this.f84c = i7;
            this.f85d = jArr2;
            this.f86e = iArr2;
            this.f87f = j7;
            this.f88g = j8;
        }
    }

    public static b a(int i7, long[] jArr, int[] iArr, long j7) {
        int[] iArr2 = iArr;
        int i8 = 8192 / i7;
        int i9 = 0;
        int iK = 0;
        for (int i10 : iArr2) {
            iK += U.k(i10, i8);
        }
        long[] jArr2 = new long[iK];
        int[] iArr3 = new int[iK];
        long[] jArr3 = new long[iK];
        int[] iArr4 = new int[iK];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int iMax = 0;
        while (i9 < iArr2.length) {
            int i14 = iArr2[i9];
            long j8 = jArr[i9];
            while (i14 > 0) {
                int iMin = Math.min(i8, i14);
                jArr2[i13] = j8;
                int i15 = i7 * iMin;
                iArr3[i13] = i15;
                i12 += i15;
                iMax = Math.max(iMax, i15);
                jArr3[i13] = i11 * j7;
                iArr4[i13] = 1;
                j8 += iArr3[i13];
                i11 += iMin;
                i14 -= iMin;
                i13++;
                i8 = i8;
            }
            i9++;
            iArr2 = iArr;
        }
        return new b(jArr2, iArr3, iMax, jArr3, iArr4, j7 * i11, i12);
    }
}
