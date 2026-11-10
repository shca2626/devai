package m3;

import j3.o;
import java.math.RoundingMode;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f19744a = {19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f19745b = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /* renamed from: c, reason: collision with root package name */
    public static final long[] f19746c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};

    /* renamed from: d, reason: collision with root package name */
    public static final long[] f19747d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f19748e = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f19749f = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};

    /* renamed from: g, reason: collision with root package name */
    public static final long[][] f19750g = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19751a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f19751a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19751a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19751a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19751a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19751a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19751a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19751a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19751a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static long a(long j7, long j8) {
        long j9 = j7 + j8;
        f.c(((j7 ^ j8) < 0) | ((j7 ^ j9) >= 0), "checkedAdd", j7, j8);
        return j9;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static long b(long j7, long j8, RoundingMode roundingMode) {
        o.q(roundingMode);
        long j9 = j7 / j8;
        long j10 = j7 - (j8 * j9);
        if (j10 == 0) {
            return j9;
        }
        int i7 = ((int) ((j7 ^ j8) >> 63)) | 1;
        switch (a.f19751a[roundingMode.ordinal()]) {
            case 1:
                f.g(j10 == 0);
                return j9;
            case 2:
                return j9;
            case 3:
                if (i7 >= 0) {
                    return j9;
                }
                return j9 + i7;
            case 4:
                return j9 + i7;
            case 5:
                if (i7 <= 0) {
                    return j9;
                }
                return j9 + i7;
            case 6:
            case 7:
            case 8:
                long jAbs = Math.abs(j10);
                long jAbs2 = jAbs - (Math.abs(j8) - jAbs);
                if (jAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP && (roundingMode != RoundingMode.HALF_EVEN || (1 & j9) == 0)) {
                        return j9;
                    }
                } else if (jAbs2 <= 0) {
                    return j9;
                }
                return j9 + i7;
            default:
                throw new AssertionError();
        }
    }

    public static long c(long j7, long j8) {
        f.e("a", j7);
        f.e("b", j8);
        if (j7 == 0) {
            return j8;
        }
        if (j8 == 0) {
            return j7;
        }
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j7);
        long jNumberOfTrailingZeros = j7 >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j8);
        long j9 = j8 >> iNumberOfTrailingZeros2;
        while (jNumberOfTrailingZeros != j9) {
            long j10 = jNumberOfTrailingZeros - j9;
            long j11 = (j10 >> 63) & j10;
            long j12 = (j10 - j11) - j11;
            j9 += j11;
            jNumberOfTrailingZeros = j12 >> Long.numberOfTrailingZeros(j12);
        }
        return jNumberOfTrailingZeros << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros2);
    }

    public static long d(long j7, long j8) {
        long j9 = j7 + j8;
        return (((j8 ^ j7) > 0L ? 1 : ((j8 ^ j7) == 0L ? 0 : -1)) < 0) | ((j7 ^ j9) >= 0) ? j9 : ((j9 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    public static long e(long j7, long j8) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j7) + Long.numberOfLeadingZeros(~j7) + Long.numberOfLeadingZeros(j8) + Long.numberOfLeadingZeros(~j8);
        if (iNumberOfLeadingZeros > 65) {
            return j7 * j8;
        }
        long j9 = ((j7 ^ j8) >>> 63) + Long.MAX_VALUE;
        if (!((iNumberOfLeadingZeros < 64) | ((j8 == Long.MIN_VALUE) & (j7 < 0)))) {
            long j10 = j7 * j8;
            if (j7 == 0 || j10 / j7 == j8) {
                return j10;
            }
        }
        return j9;
    }

    public static long f(long j7, long j8) {
        long j9 = j7 - j8;
        return (((j8 ^ j7) > 0L ? 1 : ((j8 ^ j7) == 0L ? 0 : -1)) >= 0) | ((j7 ^ j9) >= 0) ? j9 : ((j9 >>> 63) ^ 1) + Long.MAX_VALUE;
    }
}
