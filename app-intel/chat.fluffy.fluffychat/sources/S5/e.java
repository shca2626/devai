package S5;

import M5.m;
import S5.a;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class e extends d {
    public static int b(int i7, int i8) {
        return i7 < i8 ? i8 : i7;
    }

    public static long c(long j7, long j8) {
        return j7 < j8 ? j8 : j7;
    }

    public static double d(double d7, double d8) {
        return d7 > d8 ? d8 : d7;
    }

    public static float e(float f7, float f8) {
        return f7 > f8 ? f8 : f7;
    }

    public static int f(int i7, int i8) {
        return i7 > i8 ? i8 : i7;
    }

    public static long g(long j7, long j8) {
        return j7 > j8 ? j8 : j7;
    }

    public static double h(double d7, double d8, double d9) {
        if (d8 <= d9) {
            return d7 < d8 ? d8 : d7 > d9 ? d9 : d7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d9 + " is less than minimum " + d8 + '.');
    }

    public static float i(float f7, float f8, float f9) {
        if (f8 <= f9) {
            return f7 < f8 ? f8 : f7 > f9 ? f9 : f7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f9 + " is less than minimum " + f8 + '.');
    }

    public static int j(int i7, int i8, int i9) {
        if (i8 <= i9) {
            return i7 < i8 ? i8 : i7 > i9 ? i9 : i7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i9 + " is less than minimum " + i8 + '.');
    }

    public static long k(long j7, long j8, long j9) {
        if (j8 <= j9) {
            return j7 < j8 ? j8 : j7 > j9 ? j9 : j7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j9 + " is less than minimum " + j8 + '.');
    }

    public static a l(int i7, int i8) {
        return a.f8204o.a(i7, i8, -1);
    }

    public static int m(c cVar, Q5.c cVar2) {
        m.e(cVar, "<this>");
        m.e(cVar2, "random");
        try {
            return Q5.d.d(cVar2, cVar);
        } catch (IllegalArgumentException e7) {
            throw new NoSuchElementException(e7.getMessage());
        }
    }

    public static a n(a aVar, int i7) {
        m.e(aVar, "<this>");
        d.a(i7 > 0, Integer.valueOf(i7));
        a.C0067a c0067a = a.f8204o;
        int iF = aVar.f();
        int iG = aVar.g();
        if (aVar.h() <= 0) {
            i7 = -i7;
        }
        return c0067a.a(iF, iG, i7);
    }

    public static c o(int i7, int i8) {
        return i8 <= Integer.MIN_VALUE ? c.f8212p.a() : new c(i7, i8 - 1);
    }
}
