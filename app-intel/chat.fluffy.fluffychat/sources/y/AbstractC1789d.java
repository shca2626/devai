package y;

import java.util.ConcurrentModificationException;
import z.AbstractC1825a;

/* renamed from: y.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1789d {
    public static final void a(C1787b c1787b, int i7) {
        M5.m.e(c1787b, "<this>");
        c1787b.m(new int[i7]);
        c1787b.l(new Object[i7]);
    }

    public static final int b(C1787b c1787b, int i7) {
        M5.m.e(c1787b, "<this>");
        try {
            return AbstractC1825a.a(c1787b.h(), c1787b.j(), i7);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final int c(C1787b c1787b, Object obj, int i7) {
        M5.m.e(c1787b, "<this>");
        int iJ = c1787b.j();
        if (iJ == 0) {
            return -1;
        }
        int iB = b(c1787b, i7);
        if (iB < 0 || M5.m.a(obj, c1787b.g()[iB])) {
            return iB;
        }
        int i8 = iB + 1;
        while (i8 < iJ && c1787b.h()[i8] == i7) {
            if (M5.m.a(obj, c1787b.g()[i8])) {
                return i8;
            }
            i8++;
        }
        for (int i9 = iB - 1; i9 >= 0 && c1787b.h()[i9] == i7; i9--) {
            if (M5.m.a(obj, c1787b.g()[i9])) {
                return i9;
            }
        }
        return ~i8;
    }

    public static final int d(C1787b c1787b) {
        M5.m.e(c1787b, "<this>");
        return c(c1787b, null, 0);
    }
}
