package o3;

import j3.o;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class i {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final byte[] f20378a;

        static {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i7 = 0; i7 < 10; i7++) {
                bArr[i7 + 48] = (byte) i7;
            }
            for (int i8 = 0; i8 < 26; i8++) {
                byte b7 = (byte) (i8 + 10);
                bArr[i8 + 65] = b7;
                bArr[i8 + 97] = b7;
            }
            f20378a = bArr;
        }

        public static int a(char c7) {
            if (c7 < 128) {
                return f20378a[c7];
            }
            return -1;
        }
    }

    public static int a(long j7) {
        int i7 = (int) j7;
        o.i(j7 == ((long) i7), "the total number of elements (%s) in the arrays must fit in an int", j7);
        return i7;
    }

    public static long[] b(long[]... jArr) {
        long length = 0;
        for (long[] jArr2 : jArr) {
            length += jArr2.length;
        }
        long[] jArr3 = new long[a(length)];
        int length2 = 0;
        for (long[] jArr4 : jArr) {
            System.arraycopy(jArr4, 0, jArr3, length2, jArr4.length);
            length2 += jArr4.length;
        }
        return jArr3;
    }

    public static int c(long j7) {
        return (int) (j7 ^ (j7 >>> 32));
    }

    public static long d(long... jArr) {
        o.d(jArr.length > 0);
        long j7 = jArr[0];
        for (int i7 = 1; i7 < jArr.length; i7++) {
            long j8 = jArr[i7];
            if (j8 > j7) {
                j7 = j8;
            }
        }
        return j7;
    }

    public static Long e(String str, int i7) {
        if (((String) o.q(str)).isEmpty()) {
            return null;
        }
        if (i7 < 2 || i7 > 36) {
            throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + i7);
        }
        int i8 = str.charAt(0) == '-' ? 1 : 0;
        if (i8 == str.length()) {
            return null;
        }
        int i9 = i8 + 1;
        int iA = a.a(str.charAt(i8));
        if (iA < 0 || iA >= i7) {
            return null;
        }
        long j7 = -iA;
        long j8 = i7;
        long j9 = Long.MIN_VALUE / j8;
        while (i9 < str.length()) {
            int i10 = i9 + 1;
            int iA2 = a.a(str.charAt(i9));
            if (iA2 < 0 || iA2 >= i7 || j7 < j9) {
                return null;
            }
            long j10 = j7 * j8;
            long j11 = iA2;
            if (j10 < j11 - Long.MIN_VALUE) {
                return null;
            }
            j7 = j10 - j11;
            i9 = i10;
        }
        if (i8 != 0) {
            return Long.valueOf(j7);
        }
        if (j7 == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j7);
    }
}
