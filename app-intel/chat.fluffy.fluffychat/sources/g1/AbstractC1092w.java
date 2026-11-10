package g1;

import E0.AbstractC0332s;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;

/* renamed from: g1.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1092w {

    /* renamed from: g1.w$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f16149a;
    }

    public static boolean a(E0.E e7, C1095z c1095z, int i7, long j7) {
        int iK = k(e7, i7);
        long j8 = c1095z.f16162j;
        return iK != -1 && (((j8 > 0L ? 1 : (j8 == 0L ? 0 : -1)) == 0 || ((j7 + ((long) iK)) > j8 ? 1 : ((j7 + ((long) iK)) == j8 ? 0 : -1)) >= 0) || iK >= c1095z.f16153a) && iK <= c1095z.f16154b;
    }

    public static boolean b(E0.E e7, int i7) {
        return e7.Q() == E0.U.x(e7.f(), i7, e7.g() - 1, 0);
    }

    public static boolean c(E0.E e7, C1095z c1095z, boolean z7, a aVar) {
        try {
            long jZ = e7.Z();
            if (!z7) {
                jZ *= c1095z.f16154b;
            }
            long j7 = c1095z.f16162j;
            if (j7 != 0 && jZ > j7) {
                return false;
            }
            aVar.f16149a = jZ;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(E0.E e7, C1095z c1095z, int i7, a aVar) {
        int iG = e7.g();
        long jS = e7.S();
        long j7 = jS >>> 16;
        if (j7 != i7) {
            return false;
        }
        return g((int) ((jS >> 4) & 15), c1095z) && f((int) ((jS >> 1) & 7), c1095z) && !(((jS & 1) > 1L ? 1 : ((jS & 1) == 1L ? 0 : -1)) == 0) && c(e7, c1095z, ((j7 & 1) > 1L ? 1 : ((j7 & 1) == 1L ? 0 : -1)) == 0, aVar) && a(e7, c1095z, (int) ((jS >> 12) & 15), aVar.f16149a) && e(e7, c1095z, (int) ((jS >> 8) & 15)) && b(e7, iG) && h(e7);
    }

    public static boolean e(E0.E e7, C1095z c1095z, int i7) {
        int i8 = c1095z.f16157e;
        if (i7 == 0) {
            return true;
        }
        if (i7 <= 11) {
            return i7 == c1095z.f16158f;
        }
        if (i7 == 12) {
            return e7.Q() * 1000 == i8;
        }
        if (i7 <= 14) {
            int iY = e7.Y();
            if (i7 == 14) {
                iY *= 10;
            }
            if (iY == i8) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(int i7, C1095z c1095z) {
        return i7 == 0 || i7 == c1095z.f16161i;
    }

    public static boolean g(int i7, C1095z c1095z) {
        return i7 <= 7 ? i7 == c1095z.f16159g - 1 : i7 <= 10 && c1095z.f16159g == 2;
    }

    public static boolean h(E0.E e7) {
        if (e7.a() == 0) {
            return true;
        }
        int iQ = e7.q();
        if ((iQ & 128) != 0) {
            return false;
        }
        int i7 = (iQ & 126) >> 1;
        if ((i7 < 2 || i7 > 7) && (i7 < 13 || i7 > 31)) {
            return true;
        }
        AbstractC0332s.f("FlacFrameReader", "Ignoring frame where first subframe has a reserved type: " + i7);
        return false;
    }

    public static boolean i(r rVar, C1095z c1095z, int i7, a aVar) {
        long jI = rVar.i();
        E0.E e7 = new E0.E(17);
        rVar.t(e7.f(), 0, 2);
        if (e7.l() != i7) {
            rVar.o();
            rVar.k((int) (jI - rVar.getPosition()));
            return false;
        }
        e7.e0(AbstractC1089t.d(rVar, e7.f(), 2, 15) + 2);
        rVar.o();
        rVar.k((int) (jI - rVar.getPosition()));
        return d(e7, c1095z, i7, aVar);
    }

    public static long j(r rVar, C1095z c1095z) throws B0.A {
        rVar.o();
        rVar.k(1);
        byte[] bArr = new byte[1];
        rVar.t(bArr, 0, 1);
        boolean z7 = (bArr[0] & 1) == 1;
        rVar.k(2);
        int i7 = z7 ? 7 : 6;
        E0.E e7 = new E0.E(i7);
        e7.e0(AbstractC1089t.d(rVar, e7.f(), 0, i7));
        rVar.o();
        a aVar = new a();
        if (c(e7, c1095z, z7, aVar)) {
            return aVar.f16149a;
        }
        throw B0.A.a(null, null);
    }

    public static int k(E0.E e7, int i7) {
        switch (i7) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i7 - 2);
            case 6:
                return e7.Q() + 1;
            case 7:
                return e7.Y() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case StdKeyDeserializer.TYPE_URL /* 14 */:
            case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                return 256 << (i7 - 8);
            default:
                return -1;
        }
    }
}
