package A1;

import E0.E;
import v1.C1677d;

/* loaded from: classes.dex */
public abstract class u {
    public static int a(int i7, E e7, int i8) {
        if (i7 == 12) {
            return 240;
        }
        if (i7 == 13) {
            return 120;
        }
        if (i7 == 21 && e7.a() >= 8 && e7.g() + 8 <= i8) {
            int iZ = e7.z();
            int iZ2 = e7.z();
            if (iZ >= 12 && iZ2 == 1936877170) {
                return e7.R();
            }
        }
        return -2147483647;
    }

    public static B0.y b(E e7, int i7) {
        e7.g0(12);
        while (e7.g() < i7) {
            int iG = e7.g();
            int iZ = e7.z();
            if (e7.z() == 1935766900) {
                if (iZ < 16) {
                    return null;
                }
                e7.g0(4);
                int i8 = -1;
                int i9 = 0;
                for (int i10 = 0; i10 < 2; i10++) {
                    int iQ = e7.Q();
                    int iQ2 = e7.Q();
                    if (iQ == 0) {
                        i8 = iQ2;
                    } else if (iQ == 1) {
                        i9 = iQ2;
                    }
                }
                int iA = a(i8, e7, i7);
                if (iA == -2147483647) {
                    return null;
                }
                return new B0.y(new C1677d(iA, i9));
            }
            e7.f0(iG + iZ);
        }
        return null;
    }
}
