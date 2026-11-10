package S3;

import D3.j;
import D3.n;
import D3.o;
import D3.p;
import D3.q;
import R3.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f8182i = {1, 10, 34, 70, 126};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f8183j = {4, 20, 48, 81};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f8184k = {0, 161, 961, 2015, 2715};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f8185l = {0, 336, 1036, 1516};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f8186m = {8, 6, 4, 3, 1};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f8187n = {2, 4, 6, 8};

    /* renamed from: o, reason: collision with root package name */
    public static final int[][] f8188o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* renamed from: g, reason: collision with root package name */
    public final List f8189g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final List f8190h = new ArrayList();

    public static void r(Collection collection, d dVar) {
        if (dVar == null) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            if (dVar2.b() == dVar.b()) {
                dVar2.e();
                return;
            }
        }
        collection.add(dVar);
    }

    public static boolean t(d dVar, d dVar2) {
        int iA = (dVar.a() + (dVar2.a() * 16)) % 79;
        int iC = (dVar.d().c() * 9) + dVar2.d().c();
        if (iC > 72) {
            iC--;
        }
        if (iC > 8) {
            iC--;
        }
        return iA == iC;
    }

    public static n u(d dVar, d dVar2) {
        String strValueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i7 = 0;
        for (int i8 = 0; i8 < 13; i8++) {
            int iCharAt = sb.charAt(i8) - '0';
            if ((i8 & 1) == 0) {
                iCharAt *= 3;
            }
            i7 += iCharAt;
        }
        int i9 = 10 - (i7 % 10);
        if (i9 == 10) {
            i9 = 0;
        }
        sb.append(i9);
        p[] pVarArrA = dVar.d().a();
        p[] pVarArrA2 = dVar2.d().a();
        n nVar = new n(sb.toString(), null, new p[]{pVarArrA[0], pVarArrA[1], pVarArrA2[0], pVarArrA2[1]}, D3.a.RSS_14);
        nVar.h(o.SYMBOLOGY_IDENTIFIER, "]e0");
        return nVar;
    }

    @Override // R3.k
    public n c(int i7, J3.a aVar, Map map) throws j {
        r(this.f8189g, w(aVar, false, i7, map));
        aVar.n();
        r(this.f8190h, w(aVar, true, i7, map));
        aVar.n();
        for (d dVar : this.f8189g) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f8190h) {
                    if (dVar2.c() > 1 && t(dVar, dVar2)) {
                        return u(dVar, dVar2);
                    }
                }
            }
        }
        throw j.a();
    }

    @Override // R3.k, D3.l
    public void reset() {
        this.f8189g.clear();
        this.f8190h.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a A[PHI: r6 r7
      0x002a: PHI (r6v5 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x002a: PHI (r7v5 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[PHI: r6 r7
      0x002d: PHI (r6v4 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x002d: PHI (r7v4 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(boolean r10, int r11) throws D3.j {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S3.e.s(boolean, int):void");
    }

    public final b v(J3.a aVar, c cVar, boolean z7) throws j {
        int[] iArrI = i();
        Arrays.fill(iArrI, 0);
        if (z7) {
            k.g(aVar, cVar.b()[0], iArrI);
        } else {
            k.f(aVar, cVar.b()[1], iArrI);
            int i7 = 0;
            for (int length = iArrI.length - 1; i7 < length; length--) {
                int i8 = iArrI[i7];
                iArrI[i7] = iArrI[length];
                iArrI[length] = i8;
                i7++;
            }
        }
        int i9 = z7 ? 16 : 15;
        float fD = K3.a.d(iArrI) / i9;
        int[] iArrM = m();
        int[] iArrK = k();
        float[] fArrN = n();
        float[] fArrL = l();
        for (int i10 = 0; i10 < iArrI.length; i10++) {
            float f7 = iArrI[i10] / fD;
            int i11 = (int) (0.5f + f7);
            if (i11 < 1) {
                i11 = 1;
            } else if (i11 > 8) {
                i11 = 8;
            }
            int i12 = i10 / 2;
            if ((i10 & 1) == 0) {
                iArrM[i12] = i11;
                fArrN[i12] = f7 - i11;
            } else {
                iArrK[i12] = i11;
                fArrL[i12] = f7 - i11;
            }
        }
        s(z7, i9);
        int i13 = 0;
        int i14 = 0;
        for (int length2 = iArrM.length - 1; length2 >= 0; length2--) {
            int i15 = iArrM[length2];
            i13 = (i13 * 9) + i15;
            i14 += i15;
        }
        int i16 = 0;
        int i17 = 0;
        for (int length3 = iArrK.length - 1; length3 >= 0; length3--) {
            int i18 = iArrK[length3];
            i16 = (i16 * 9) + i18;
            i17 += i18;
        }
        int i19 = i13 + (i16 * 3);
        if (!z7) {
            if ((i17 & 1) != 0 || i17 > 10 || i17 < 4) {
                throw j.a();
            }
            int i20 = (10 - i17) / 2;
            int i21 = f8187n[i20];
            return new b((f.b(iArrK, 9 - i21, false) * f8183j[i20]) + f.b(iArrM, i21, true) + f8185l[i20], i19);
        }
        if ((i14 & 1) != 0 || i14 > 12 || i14 < 4) {
            throw j.a();
        }
        int i22 = (12 - i14) / 2;
        int i23 = f8186m[i22];
        return new b((f.b(iArrM, i23, false) * f8182i[i22]) + f.b(iArrK, 9 - i23, true) + f8184k[i22], i19);
    }

    public final d w(J3.a aVar, boolean z7, int i7, Map map) {
        try {
            c cVarY = y(aVar, i7, z7, x(aVar, z7));
            q qVar = map == null ? null : (q) map.get(D3.e.NEED_RESULT_POINT_CALLBACK);
            if (qVar != null) {
                int[] iArrB = cVarY.b();
                float fK = ((iArrB[0] + iArrB[1]) - 1) / 2.0f;
                if (z7) {
                    fK = (aVar.k() - 1) - fK;
                }
                qVar.a(new p(fK, i7));
            }
            b bVarV = v(aVar, cVarY, true);
            b bVarV2 = v(aVar, cVarY, false);
            return new d((bVarV.b() * 1597) + bVarV2.b(), bVarV.a() + (bVarV2.a() * 4), cVarY);
        } catch (j unused) {
            return null;
        }
    }

    public final int[] x(J3.a aVar, boolean z7) throws j {
        int[] iArrJ = j();
        iArrJ[0] = 0;
        iArrJ[1] = 0;
        iArrJ[2] = 0;
        iArrJ[3] = 0;
        int iK = aVar.k();
        int i7 = 0;
        boolean z8 = false;
        while (i7 < iK) {
            z8 = !aVar.c(i7);
            if (z7 == z8) {
                break;
            }
            i7++;
        }
        int i8 = 0;
        int i9 = i7;
        while (i7 < iK) {
            if (aVar.c(i7) != z8) {
                iArrJ[i8] = iArrJ[i8] + 1;
            } else {
                if (i8 != 3) {
                    i8++;
                } else {
                    if (a.p(iArrJ)) {
                        return new int[]{i9, i7};
                    }
                    i9 += iArrJ[0] + iArrJ[1];
                    iArrJ[0] = iArrJ[2];
                    iArrJ[1] = iArrJ[3];
                    iArrJ[2] = 0;
                    iArrJ[3] = 0;
                    i8--;
                }
                iArrJ[i8] = 1;
                z8 = !z8;
            }
            i7++;
        }
        throw j.a();
    }

    public final c y(J3.a aVar, int i7, boolean z7, int[] iArr) throws j {
        int i8;
        boolean zC = aVar.c(iArr[0]);
        int i9 = iArr[0] - 1;
        while (i9 >= 0 && zC != aVar.c(i9)) {
            i9--;
        }
        int i10 = i9 + 1;
        int i11 = iArr[0] - i10;
        int[] iArrJ = j();
        System.arraycopy(iArrJ, 0, iArrJ, 1, iArrJ.length - 1);
        iArrJ[0] = i11;
        int iQ = a.q(iArrJ, f8188o);
        int iK = iArr[1];
        if (z7) {
            int iK2 = (aVar.k() - 1) - i10;
            iK = (aVar.k() - 1) - iK;
            i8 = iK2;
        } else {
            i8 = i10;
        }
        return new c(iQ, new int[]{i10, iArr[1]}, i8, iK, i7);
    }
}
