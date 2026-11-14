package I0;

import B0.H;
import android.util.Pair;

/* renamed from: I0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0351a extends B0.H {

    /* renamed from: e, reason: collision with root package name */
    public final int f3910e;

    /* renamed from: f, reason: collision with root package name */
    public final Y0.g0 f3911f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3912g;

    public AbstractC0351a(boolean z7, Y0.g0 g0Var) {
        this.f3912g = z7;
        this.f3911f = g0Var;
        this.f3910e = g0Var.getLength();
    }

    public static Object v(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object w(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object y(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    public abstract int A(int i7);

    public final int B(int i7, boolean z7) {
        if (z7) {
            return this.f3911f.e(i7);
        }
        if (i7 < this.f3910e - 1) {
            return i7 + 1;
        }
        return -1;
    }

    public final int C(int i7, boolean z7) {
        if (z7) {
            return this.f3911f.d(i7);
        }
        if (i7 > 0) {
            return i7 - 1;
        }
        return -1;
    }

    public abstract B0.H D(int i7);

    @Override // B0.H
    public int a(boolean z7) {
        if (this.f3910e == 0) {
            return -1;
        }
        if (this.f3912g) {
            z7 = false;
        }
        int iC = z7 ? this.f3911f.c() : 0;
        while (D(iC).q()) {
            iC = B(iC, z7);
            if (iC == -1) {
                return -1;
            }
        }
        return A(iC) + D(iC).a(z7);
    }

    @Override // B0.H
    public final int b(Object obj) {
        int iB;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object objW = w(obj);
        Object objV = v(obj);
        int iS = s(objW);
        if (iS == -1 || (iB = D(iS).b(objV)) == -1) {
            return -1;
        }
        return z(iS) + iB;
    }

    @Override // B0.H
    public int c(boolean z7) {
        int i7 = this.f3910e;
        if (i7 == 0) {
            return -1;
        }
        if (this.f3912g) {
            z7 = false;
        }
        int iH = z7 ? this.f3911f.h() : i7 - 1;
        while (D(iH).q()) {
            iH = C(iH, z7);
            if (iH == -1) {
                return -1;
            }
        }
        return A(iH) + D(iH).c(z7);
    }

    @Override // B0.H
    public int e(int i7, int i8, boolean z7) {
        if (this.f3912g) {
            if (i8 == 1) {
                i8 = 2;
            }
            z7 = false;
        }
        int iU = u(i7);
        int iA = A(iU);
        int iE = D(iU).e(i7 - iA, i8 != 2 ? i8 : 0, z7);
        if (iE != -1) {
            return iA + iE;
        }
        int iB = B(iU, z7);
        while (iB != -1 && D(iB).q()) {
            iB = B(iB, z7);
        }
        if (iB != -1) {
            return A(iB) + D(iB).a(z7);
        }
        if (i8 == 2) {
            return a(z7);
        }
        return -1;
    }

    @Override // B0.H
    public final H.b g(int i7, H.b bVar, boolean z7) {
        int iT = t(i7);
        int iA = A(iT);
        D(iT).g(i7 - z(iT), bVar, z7);
        bVar.f386c += iA;
        if (z7) {
            bVar.f385b = y(x(iT), j3.o.q(bVar.f385b));
        }
        return bVar;
    }

    @Override // B0.H
    public final H.b h(Object obj, H.b bVar) {
        Object objW = w(obj);
        Object objV = v(obj);
        int iS = s(objW);
        int iA = A(iS);
        D(iS).h(objV, bVar);
        bVar.f386c += iA;
        bVar.f385b = obj;
        return bVar;
    }

    @Override // B0.H
    public int l(int i7, int i8, boolean z7) {
        if (this.f3912g) {
            if (i8 == 1) {
                i8 = 2;
            }
            z7 = false;
        }
        int iU = u(i7);
        int iA = A(iU);
        int iL = D(iU).l(i7 - iA, i8 != 2 ? i8 : 0, z7);
        if (iL != -1) {
            return iA + iL;
        }
        int iC = C(iU, z7);
        while (iC != -1 && D(iC).q()) {
            iC = C(iC, z7);
        }
        if (iC != -1) {
            return A(iC) + D(iC).c(z7);
        }
        if (i8 == 2) {
            return c(z7);
        }
        return -1;
    }

    @Override // B0.H
    public final Object m(int i7) {
        int iT = t(i7);
        return y(x(iT), D(iT).m(i7 - z(iT)));
    }

    @Override // B0.H
    public final H.c o(int i7, H.c cVar, long j7) {
        int iU = u(i7);
        int iA = A(iU);
        int iZ = z(iU);
        D(iU).o(i7 - iA, cVar, j7);
        Object objX = x(iU);
        if (!H.c.f397q.equals(cVar.f407a)) {
            objX = y(objX, cVar.f407a);
        }
        cVar.f407a = objX;
        cVar.f420n += iZ;
        cVar.f421o += iZ;
        return cVar;
    }

    public abstract int s(Object obj);

    public abstract int t(int i7);

    public abstract int u(int i7);

    public abstract Object x(int i7);

    public abstract int z(int i7);
}
