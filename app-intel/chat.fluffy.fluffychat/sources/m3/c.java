package m3;

import j3.o;

/* loaded from: classes.dex */
public abstract class c {
    public static long a(double d7) {
        o.e(b(d7), "not a normal value");
        int exponent = Math.getExponent(d7);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d7) & 4503599627370495L;
        return exponent == -1023 ? jDoubleToRawLongBits << 1 : jDoubleToRawLongBits | 4503599627370496L;
    }

    public static boolean b(double d7) {
        return Math.getExponent(d7) <= 1023;
    }

    public static boolean c(double d7) {
        return Math.getExponent(d7) >= -1022;
    }

    public static double d(double d7) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d7) & 4503599627370495L) | 4607182418800017408L);
    }
}
