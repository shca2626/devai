package b4;

import D3.j;
import D3.p;
import D3.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class e {

    /* renamed from: f, reason: collision with root package name */
    public static final b f13737f = new b();

    /* renamed from: a, reason: collision with root package name */
    public final J3.b f13738a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13740c;

    /* renamed from: e, reason: collision with root package name */
    public final q f13742e;

    /* renamed from: b, reason: collision with root package name */
    public final List f13739b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final int[] f13741d = new int[5];

    public static final class b implements Comparator, Serializable {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0846d c0846d, C0846d c0846d2) {
            return Float.compare(c0846d.i(), c0846d2.i());
        }
    }

    public e(J3.b bVar, q qVar) {
        this.f13738a = bVar;
        this.f13742e = qVar;
    }

    public static float a(int[] iArr, int i7) {
        return ((i7 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static void e(int[] iArr) {
        Arrays.fill(iArr, 0);
    }

    public static void f(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public static boolean i(int[] iArr) {
        int i7 = 0;
        for (int i8 = 0; i8 < 5; i8++) {
            int i9 = iArr[i8];
            if (i9 == 0) {
                return false;
            }
            i7 += i9;
        }
        if (i7 < 7) {
            return false;
        }
        float f7 = i7 / 7.0f;
        float f8 = f7 / 2.0f;
        return Math.abs(f7 - ((float) iArr[0])) < f8 && Math.abs(f7 - ((float) iArr[1])) < f8 && Math.abs((f7 * 3.0f) - ((float) iArr[2])) < 3.0f * f8 && Math.abs(f7 - ((float) iArr[3])) < f8 && Math.abs(f7 - ((float) iArr[4])) < f8;
    }

    public static boolean j(int[] iArr) {
        int i7 = 0;
        for (int i8 = 0; i8 < 5; i8++) {
            int i9 = iArr[i8];
            if (i9 == 0) {
                return false;
            }
            i7 += i9;
        }
        if (i7 < 7) {
            return false;
        }
        float f7 = i7 / 7.0f;
        float f8 = f7 / 1.333f;
        return Math.abs(f7 - ((float) iArr[0])) < f8 && Math.abs(f7 - ((float) iArr[1])) < f8 && Math.abs((f7 * 3.0f) - ((float) iArr[2])) < 3.0f * f8 && Math.abs(f7 - ((float) iArr[3])) < f8 && Math.abs(f7 - ((float) iArr[4])) < f8;
    }

    public static double o(C0846d c0846d, C0846d c0846d2) {
        double dC = c0846d.c() - c0846d2.c();
        double d7 = c0846d.d() - c0846d2.d();
        return (dC * dC) + (d7 * d7);
    }

    public final boolean b(int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int[] iArrK = k();
        int i12 = 0;
        while (i7 >= i12 && i8 >= i12 && this.f13738a.g(i8 - i12, i7 - i12)) {
            iArrK[2] = iArrK[2] + 1;
            i12++;
        }
        if (iArrK[2] == 0) {
            return false;
        }
        while (i7 >= i12 && i8 >= i12 && !this.f13738a.g(i8 - i12, i7 - i12)) {
            iArrK[1] = iArrK[1] + 1;
            i12++;
        }
        if (iArrK[1] == 0) {
            return false;
        }
        while (i7 >= i12 && i8 >= i12 && this.f13738a.g(i8 - i12, i7 - i12)) {
            iArrK[0] = iArrK[0] + 1;
            i12++;
        }
        if (iArrK[0] == 0) {
            return false;
        }
        int iL = this.f13738a.l();
        int iO = this.f13738a.o();
        int i13 = 1;
        while (true) {
            int i14 = i7 + i13;
            if (i14 >= iL || (i11 = i8 + i13) >= iO || !this.f13738a.g(i11, i14)) {
                break;
            }
            iArrK[2] = iArrK[2] + 1;
            i13++;
        }
        while (true) {
            int i15 = i7 + i13;
            if (i15 >= iL || (i10 = i8 + i13) >= iO || this.f13738a.g(i10, i15)) {
                break;
            }
            iArrK[3] = iArrK[3] + 1;
            i13++;
        }
        if (iArrK[3] == 0) {
            return false;
        }
        while (true) {
            int i16 = i7 + i13;
            if (i16 >= iL || (i9 = i8 + i13) >= iO || !this.f13738a.g(i9, i16)) {
                break;
            }
            iArrK[4] = iArrK[4] + 1;
            i13++;
        }
        if (iArrK[4] == 0) {
            return false;
        }
        return j(iArrK);
    }

    public final float c(int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        J3.b bVar = this.f13738a;
        int iO = bVar.o();
        int[] iArrK = k();
        int i14 = i7;
        while (i14 >= 0 && bVar.g(i14, i8)) {
            iArrK[2] = iArrK[2] + 1;
            i14--;
        }
        if (i14 < 0) {
            return Float.NaN;
        }
        while (i14 >= 0 && !bVar.g(i14, i8)) {
            int i15 = iArrK[1];
            if (i15 > i9) {
                break;
            }
            iArrK[1] = i15 + 1;
            i14--;
        }
        if (i14 >= 0 && iArrK[1] <= i9) {
            while (i14 >= 0 && bVar.g(i14, i8) && (i13 = iArrK[0]) <= i9) {
                iArrK[0] = i13 + 1;
                i14--;
            }
            if (iArrK[0] > i9) {
                return Float.NaN;
            }
            int i16 = i7 + 1;
            while (i16 < iO && bVar.g(i16, i8)) {
                iArrK[2] = iArrK[2] + 1;
                i16++;
            }
            if (i16 == iO) {
                return Float.NaN;
            }
            while (i16 < iO && !bVar.g(i16, i8) && (i12 = iArrK[3]) < i9) {
                iArrK[3] = i12 + 1;
                i16++;
            }
            if (i16 != iO && iArrK[3] < i9) {
                while (i16 < iO && bVar.g(i16, i8) && (i11 = iArrK[4]) < i9) {
                    iArrK[4] = i11 + 1;
                    i16++;
                }
                int i17 = iArrK[4];
                if (i17 < i9 && Math.abs(((((iArrK[0] + iArrK[1]) + iArrK[2]) + iArrK[3]) + i17) - i10) * 5 < i10 && i(iArrK)) {
                    return a(iArrK, i16);
                }
            }
        }
        return Float.NaN;
    }

    public final float d(int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        J3.b bVar = this.f13738a;
        int iL = bVar.l();
        int[] iArrK = k();
        int i14 = i7;
        while (i14 >= 0 && bVar.g(i8, i14)) {
            iArrK[2] = iArrK[2] + 1;
            i14--;
        }
        if (i14 < 0) {
            return Float.NaN;
        }
        while (i14 >= 0 && !bVar.g(i8, i14)) {
            int i15 = iArrK[1];
            if (i15 > i9) {
                break;
            }
            iArrK[1] = i15 + 1;
            i14--;
        }
        if (i14 >= 0 && iArrK[1] <= i9) {
            while (i14 >= 0 && bVar.g(i8, i14) && (i13 = iArrK[0]) <= i9) {
                iArrK[0] = i13 + 1;
                i14--;
            }
            if (iArrK[0] > i9) {
                return Float.NaN;
            }
            int i16 = i7 + 1;
            while (i16 < iL && bVar.g(i8, i16)) {
                iArrK[2] = iArrK[2] + 1;
                i16++;
            }
            if (i16 == iL) {
                return Float.NaN;
            }
            while (i16 < iL && !bVar.g(i8, i16) && (i12 = iArrK[3]) < i9) {
                iArrK[3] = i12 + 1;
                i16++;
            }
            if (i16 != iL && iArrK[3] < i9) {
                while (i16 < iL && bVar.g(i8, i16) && (i11 = iArrK[4]) < i9) {
                    iArrK[4] = i11 + 1;
                    i16++;
                }
                int i17 = iArrK[4];
                if (i17 < i9 && Math.abs(((((iArrK[0] + iArrK[1]) + iArrK[2]) + iArrK[3]) + i17) - i10) * 5 < i10 * 2 && i(iArrK)) {
                    return a(iArrK, i16);
                }
            }
        }
        return Float.NaN;
    }

    public final f g(Map map) throws j {
        boolean z7 = map != null && map.containsKey(D3.e.TRY_HARDER);
        int iL = this.f13738a.l();
        int iO = this.f13738a.o();
        int i7 = (iL * 3) / 388;
        if (i7 < 3 || z7) {
            i7 = 3;
        }
        int[] iArr = new int[5];
        int i8 = i7 - 1;
        boolean zM = false;
        while (i8 < iL && !zM) {
            e(iArr);
            int i9 = 0;
            int i10 = 0;
            while (i9 < iO) {
                if (this.f13738a.g(i9, i8)) {
                    if ((i10 & 1) == 1) {
                        i10++;
                    }
                    iArr[i10] = iArr[i10] + 1;
                } else if ((i10 & 1) != 0) {
                    iArr[i10] = iArr[i10] + 1;
                } else if (i10 != 4) {
                    i10++;
                    iArr[i10] = iArr[i10] + 1;
                } else if (i(iArr) && l(iArr, i8, i9)) {
                    if (this.f13740c) {
                        zM = m();
                    } else {
                        int iH = h();
                        int i11 = iArr[2];
                        if (iH > i11) {
                            i8 += (iH - i11) - 2;
                            i9 = iO - 1;
                        }
                    }
                    e(iArr);
                    i7 = 2;
                    i10 = 0;
                } else {
                    f(iArr);
                    i10 = 3;
                }
                i9++;
            }
            if (i(iArr) && l(iArr, i8, iO)) {
                i7 = iArr[0];
                if (this.f13740c) {
                    zM = m();
                }
            }
            i8 += i7;
        }
        C0846d[] c0846dArrN = n();
        p.e(c0846dArrN);
        return new f(c0846dArrN);
    }

    public final int h() {
        if (this.f13739b.size() <= 1) {
            return 0;
        }
        C0846d c0846d = null;
        for (C0846d c0846d2 : this.f13739b) {
            if (c0846d2.h() >= 2) {
                if (c0846d != null) {
                    this.f13740c = true;
                    return ((int) (Math.abs(c0846d.c() - c0846d2.c()) - Math.abs(c0846d.d() - c0846d2.d()))) / 2;
                }
                c0846d = c0846d2;
            }
        }
        return 0;
    }

    public final int[] k() {
        e(this.f13741d);
        return this.f13741d;
    }

    public final boolean l(int[] iArr, int i7, int i8) {
        int i9 = 0;
        int i10 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iA = (int) a(iArr, i8);
        float fD = d(i7, iA, iArr[2], i10);
        if (!Float.isNaN(fD)) {
            int i11 = (int) fD;
            float fC = c(iA, i11, iArr[2], i10);
            if (!Float.isNaN(fC) && b(i11, (int) fC)) {
                float f7 = i10 / 7.0f;
                while (true) {
                    if (i9 < this.f13739b.size()) {
                        C0846d c0846d = (C0846d) this.f13739b.get(i9);
                        if (c0846d.f(f7, fD, fC)) {
                            this.f13739b.set(i9, c0846d.g(fD, fC, f7));
                            break;
                        }
                        i9++;
                    } else {
                        C0846d c0846d2 = new C0846d(fC, fD, f7);
                        this.f13739b.add(c0846d2);
                        q qVar = this.f13742e;
                        if (qVar != null) {
                            qVar.a(c0846d2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean m() {
        int size = this.f13739b.size();
        float fAbs = 0.0f;
        int i7 = 0;
        float fI = 0.0f;
        for (C0846d c0846d : this.f13739b) {
            if (c0846d.h() >= 2) {
                i7++;
                fI += c0846d.i();
            }
        }
        if (i7 < 3) {
            return false;
        }
        float f7 = fI / size;
        Iterator it = this.f13739b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(((C0846d) it.next()).i() - f7);
        }
        return fAbs <= fI * 0.05f;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b4.C0846d[] n() throws D3.j {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.e.n():b4.d[]");
    }
}
