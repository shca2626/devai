package m3;

import java.math.RoundingMode;

/* loaded from: classes.dex */
public abstract class f {
    public static void a(boolean z7, double d7, RoundingMode roundingMode) {
        if (z7) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + d7 + " and rounding mode " + roundingMode);
    }

    public static void b(boolean z7, String str, int i7, int i8) {
        if (z7) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + i7 + ", " + i8 + ")");
    }

    public static void c(boolean z7, String str, long j7, long j8) {
        if (z7) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j7 + ", " + j8 + ")");
    }

    public static double d(String str, double d7) {
        if (d7 >= 0.0d) {
            return d7;
        }
        throw new IllegalArgumentException(str + " (" + d7 + ") must be >= 0");
    }

    public static long e(String str, long j7) {
        if (j7 >= 0) {
            return j7;
        }
        throw new IllegalArgumentException(str + " (" + j7 + ") must be >= 0");
    }

    public static int f(String str, int i7) {
        if (i7 > 0) {
            return i7;
        }
        throw new IllegalArgumentException(str + " (" + i7 + ") must be > 0");
    }

    public static void g(boolean z7) {
        if (!z7) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
