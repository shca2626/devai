package y;

import java.util.ConcurrentModificationException;
import z.AbstractC1826a;

/* renamed from: y.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1790d {
    public static final void a(C1788b c1788b, int i7) {
        M5.m.e(c1788b, "<this>");
        c1788b.m(new int[i7]);
        c1788b.l(new Object[i7]);
    }

    public static final int b(C1788b c1788b, int i7) {
        M5.m.e(c1788b, "<this>");
        try {
            return AbstractC1826a.a(c1788b.h(), c1788b.j(), i7);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final int c(C1788b c1788b, Object obj, int i7) {
        M5.m.e(c1788b, "<this>");
        int iJ = c1788b.j();
        if (iJ == 0) {
            return -1;
        }
        int iB = b(c1788b, i7);
        if (iB < 0 || M5.m.a(obj, c1788b.g()[iB])) {
            return iB;
        }
        int i8 = iB + 1;
        while (i8 < iJ && c1788b.h()[i8] == i7) {
            if (M5.m.a(obj, c1788b.g()[i8])) {
                return i8;
            }
            i8++;
        }
        for (int i9 = iB - 1; i9 >= 0 && c1788b.h()[i9] == i7; i9--) {
            if (M5.m.a(obj, c1788b.g()[i9])) {
                return i9;
            }
        }
        return ~i8;
    }

    public static final int d(C1788b c1788b) {
        M5.m.e(c1788b, "<this>");
        return c(c1788b, null, 0);
    }
}
