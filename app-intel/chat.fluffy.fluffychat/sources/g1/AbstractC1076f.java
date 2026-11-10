package g1;

import E0.AbstractC0332s;

/* renamed from: g1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1076f {
    public static void a(long j7, E0.E e7, V[] vArr) {
        while (true) {
            if (e7.a() <= 1) {
                return;
            }
            int iC = c(e7);
            int iC2 = c(e7);
            int iG = e7.g() + iC2;
            if (iC2 == -1 || iC2 > e7.a()) {
                AbstractC0332s.h("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iG = e7.j();
            } else if (iC == 4 && iC2 >= 8) {
                int iQ = e7.Q();
                int iY = e7.Y();
                int iZ = iY == 49 ? e7.z() : 0;
                int iQ2 = e7.Q();
                if (iY == 47) {
                    e7.g0(1);
                }
                boolean z7 = iQ == 181 && (iY == 49 || iY == 47) && iQ2 == 3;
                if (iY == 49) {
                    z7 &= iZ == 1195456820;
                }
                if (z7) {
                    b(j7, e7, vArr);
                }
            }
            e7.f0(iG);
        }
    }

    public static void b(long j7, E0.E e7, V[] vArr) {
        int iQ = e7.Q();
        if ((iQ & 64) != 0) {
            e7.g0(1);
            int i7 = (iQ & 31) * 3;
            int iG = e7.g();
            for (V v7 : vArr) {
                e7.f0(iG);
                v7.a(e7, i7);
                j3.o.v(j7 != -9223372036854775807L);
                v7.d(j7, 1, i7, 0, null);
            }
        }
    }

    public static int c(E0.E e7) {
        int i7 = 0;
        while (e7.a() != 0) {
            int iQ = e7.Q();
            i7 += iQ;
            if (iQ != 255) {
                return i7;
            }
        }
        return -1;
    }
}
