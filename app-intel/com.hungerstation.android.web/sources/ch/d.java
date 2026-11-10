package ch;

import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;

/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static int f17188a = 1000000;

    /* renamed from: b, reason: collision with root package name */
    private static int f17189b = 1000000000;

    /* renamed from: c, reason: collision with root package name */
    private static long f17190c = 10000000000L;

    /* renamed from: d, reason: collision with root package name */
    private static long f17191d = 1000;

    /* renamed from: e, reason: collision with root package name */
    private static long f17192e = -2147483648L;

    /* renamed from: f, reason: collision with root package name */
    private static long f17193f = 2147483647L;

    /* renamed from: g, reason: collision with root package name */
    static final String f17194g = String.valueOf(Long.MIN_VALUE);

    /* renamed from: h, reason: collision with root package name */
    static final char[] f17195h = new char[4000];

    /* renamed from: i, reason: collision with root package name */
    static final char[] f17196i = new char[4000];

    /* renamed from: j, reason: collision with root package name */
    static final byte[] f17197j;

    /* renamed from: k, reason: collision with root package name */
    static final String[] f17198k;

    /* renamed from: l, reason: collision with root package name */
    static final String[] f17199l;

    static {
        int i12 = 0;
        int i13 = 0;
        while (i12 < 10) {
            char c12 = (char) (i12 + 48);
            char c13 = i12 == 0 ? (char) 0 : c12;
            int i14 = 0;
            while (i14 < 10) {
                char c14 = (char) (i14 + 48);
                char c15 = (i12 == 0 && i14 == 0) ? (char) 0 : c14;
                for (int i15 = 0; i15 < 10; i15++) {
                    char c16 = (char) (i15 + 48);
                    char[] cArr = f17195h;
                    cArr[i13] = c13;
                    int i16 = i13 + 1;
                    cArr[i16] = c15;
                    int i17 = i13 + 2;
                    cArr[i17] = c16;
                    char[] cArr2 = f17196i;
                    cArr2[i13] = c12;
                    cArr2[i16] = c14;
                    cArr2[i17] = c16;
                    i13 += 4;
                }
                i14++;
            }
            i12++;
        }
        f17197j = new byte[4000];
        for (int i18 = 0; i18 < 4000; i18++) {
            f17197j[i18] = (byte) f17196i[i18];
        }
        f17198k = new String[]{ExpiryDateConstantsKt.EXPIRY_DATE_PREFIX_ZERO, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        f17199l = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    private static int a(long j12) {
        int i12 = 10;
        for (long j13 = f17190c; j12 >= j13 && i12 != 19; j13 = (j13 << 1) + (j13 << 3)) {
            i12++;
        }
        return i12;
    }

    private static int b(int i12, char[] cArr, int i13) {
        int i14 = i12 << 2;
        char[] cArr2 = f17196i;
        cArr[i13] = cArr2[i14];
        int i15 = i13 + 2;
        cArr[i13 + 1] = cArr2[i14 + 1];
        int i16 = i13 + 3;
        cArr[i15] = cArr2[i14 + 2];
        return i16;
    }

    private static int c(int i12, char[] cArr, int i13) {
        int i14 = i12 << 2;
        char[] cArr2 = f17195h;
        int i15 = i14 + 1;
        char c12 = cArr2[i14];
        if (c12 != 0) {
            cArr[i13] = c12;
            i13++;
        }
        int i16 = i14 + 2;
        char c13 = cArr2[i15];
        if (c13 != 0) {
            cArr[i13] = c13;
            i13++;
        }
        int i17 = i13 + 1;
        cArr[i13] = cArr2[i16];
        return i17;
    }

    public static int d(int i12, char[] cArr, int i13) {
        int i14;
        if (i12 < 0) {
            if (i12 == Integer.MIN_VALUE) {
                return e(i12, cArr, i13);
            }
            cArr[i13] = '-';
            i12 = -i12;
            i13++;
        }
        if (i12 < f17188a) {
            if (i12 >= 1000) {
                int i15 = i12 / 1000;
                return b(i12 - (i15 * 1000), cArr, c(i15, cArr, i13));
            }
            if (i12 >= 10) {
                return c(i12, cArr, i13);
            }
            int i16 = i13 + 1;
            cArr[i13] = (char) (i12 + 48);
            return i16;
        }
        int i17 = f17189b;
        boolean z12 = i12 >= i17;
        if (z12) {
            i12 -= i17;
            if (i12 >= i17) {
                i12 -= i17;
                i14 = i13 + 1;
                cArr[i13] = '2';
            } else {
                i14 = i13 + 1;
                cArr[i13] = ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK;
            }
            i13 = i14;
        }
        int i18 = i12 / 1000;
        int i19 = i18 / 1000;
        return b(i12 - (i18 * 1000), cArr, b(i18 - (i19 * 1000), cArr, z12 ? b(i19, cArr, i13) : c(i19, cArr, i13)));
    }

    public static int e(long j12, char[] cArr, int i12) {
        if (j12 < 0) {
            if (j12 > f17192e) {
                return d((int) j12, cArr, i12);
            }
            if (j12 == Long.MIN_VALUE) {
                String str = f17194g;
                int length = str.length();
                str.getChars(0, length, cArr, i12);
                return i12 + length;
            }
            cArr[i12] = '-';
            j12 = -j12;
            i12++;
        } else if (j12 <= f17193f) {
            return d((int) j12, cArr, i12);
        }
        int iA = a(j12) + i12;
        int i13 = iA;
        while (j12 > f17193f) {
            i13 -= 3;
            long j13 = f17191d;
            long j14 = j12 / j13;
            b((int) (j12 - (j13 * j14)), cArr, i13);
            j12 = j14;
        }
        int i14 = (int) j12;
        while (i14 >= 1000) {
            i13 -= 3;
            int i15 = i14 / 1000;
            b(i14 - (i15 * 1000), cArr, i13);
            i14 = i15;
        }
        c(i14, cArr, i12);
        return iA;
    }
}
