package Q5;

import M5.m;

/* loaded from: classes.dex */
public abstract class d {
    public static final String a(Object obj, Object obj2) {
        m.e(obj, "from");
        m.e(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }

    public static final void b(int i7, int i8) {
        if (i8 <= i7) {
            throw new IllegalArgumentException(a(Integer.valueOf(i7), Integer.valueOf(i8)).toString());
        }
    }

    public static final int c(int i7) {
        return 31 - Integer.numberOfLeadingZeros(i7);
    }

    public static final int d(c cVar, S5.c cVar2) {
        m.e(cVar, "<this>");
        m.e(cVar2, "range");
        if (!cVar2.isEmpty()) {
            return cVar2.g() < Integer.MAX_VALUE ? cVar.e(cVar2.f(), cVar2.g() + 1) : cVar2.f() > Integer.MIN_VALUE ? cVar.e(cVar2.f() - 1, cVar2.g()) + 1 : cVar.c();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + cVar2);
    }

    public static final int e(int i7, int i8) {
        return (i7 >>> (32 - i8)) & ((-i8) >> 31);
    }
}
