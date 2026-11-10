package R3;

import java.util.Map;

/* loaded from: classes.dex */
public final class h extends k {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f8040b = {6, 8, 10, 12, 14};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f8041c = {1, 1, 1, 1};

    /* renamed from: d, reason: collision with root package name */
    public static final int[][] f8042d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* renamed from: e, reason: collision with root package name */
    public static final int[][] f8043e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a, reason: collision with root package name */
    public int f8044a = -1;

    public static int h(int[] iArr) throws D3.j {
        int length = f8043e.length;
        float f7 = 0.38f;
        int i7 = -1;
        for (int i8 = 0; i8 < length; i8++) {
            float fE = k.e(iArr, f8043e[i8], 0.5f);
            if (fE < f7) {
                i7 = i8;
                f7 = fE;
            } else if (fE == f7) {
                i7 = -1;
            }
        }
        if (i7 >= 0) {
            return i7 % 10;
        }
        throw D3.j.a();
    }

    public static void j(J3.a aVar, int i7, int i8, StringBuilder sb) throws D3.j {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i7 < i8) {
            k.f(aVar, i7, iArr);
            for (int i9 = 0; i9 < 5; i9++) {
                int i10 = i9 * 2;
                iArr2[i9] = iArr[i10];
                iArr3[i9] = iArr[i10 + 1];
            }
            sb.append((char) (h(iArr2) + 48));
            sb.append((char) (h(iArr3) + 48));
            for (int i11 = 0; i11 < 10; i11++) {
                i7 += iArr[i11];
            }
        }
    }

    public static int[] l(J3.a aVar, int i7, int[] iArr) throws D3.j {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iK = aVar.k();
        int i8 = i7;
        boolean z7 = false;
        int i9 = 0;
        while (i7 < iK) {
            if (aVar.c(i7) != z7) {
                iArr2[i9] = iArr2[i9] + 1;
            } else {
                if (i9 != length - 1) {
                    i9++;
                } else {
                    if (k.e(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i8, i7};
                    }
                    i8 += iArr2[0] + iArr2[1];
                    int i10 = i9 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i10);
                    iArr2[i10] = 0;
                    iArr2[i9] = 0;
                    i9--;
                }
                iArr2[i9] = 1;
                z7 = !z7;
            }
            i7++;
        }
        throw D3.j.a();
    }

    public static int m(J3.a aVar) throws D3.j {
        int iK = aVar.k();
        int iG = aVar.g(0);
        if (iG != iK) {
            return iG;
        }
        throw D3.j.a();
    }

    @Override // R3.k
    public D3.n c(int i7, J3.a aVar, Map map) throws D3.j, D3.f {
        boolean z7;
        int[] iArrK = k(aVar);
        int[] iArrI = i(aVar);
        StringBuilder sb = new StringBuilder(20);
        j(aVar, iArrK[1], iArrI[0], sb);
        String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(D3.e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f8040b;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i8 >= length2) {
                z7 = false;
                break;
            }
            int i10 = iArr[i8];
            if (length == i10) {
                z7 = true;
                break;
            }
            if (i10 > i9) {
                i9 = i10;
            }
            i8++;
        }
        if (!z7 && length > i9) {
            z7 = true;
        }
        if (!z7) {
            throw D3.f.a();
        }
        float f7 = i7;
        D3.n nVar = new D3.n(string, null, new D3.p[]{new D3.p(iArrK[1], f7), new D3.p(iArrI[0], f7)}, D3.a.ITF);
        nVar.h(D3.o.SYMBOLOGY_IDENTIFIER, "]I0");
        return nVar;
    }

    public final int[] i(J3.a aVar) {
        int[] iArrL;
        aVar.n();
        try {
            int iM = m(aVar);
            try {
                iArrL = l(aVar, iM, f8042d[0]);
            } catch (D3.j unused) {
                iArrL = l(aVar, iM, f8042d[1]);
            }
            n(aVar, iArrL[0]);
            int i7 = iArrL[0];
            iArrL[0] = aVar.k() - iArrL[1];
            iArrL[1] = aVar.k() - i7;
            return iArrL;
        } finally {
            aVar.n();
        }
    }

    public final int[] k(J3.a aVar) throws D3.j {
        int[] iArrL = l(aVar, m(aVar), f8041c);
        int i7 = iArrL[1];
        int i8 = iArrL[0];
        this.f8044a = (i7 - i8) / 4;
        n(aVar, i8);
        return iArrL;
    }

    public final void n(J3.a aVar, int i7) throws D3.j {
        int iMin = Math.min(this.f8044a * 10, i7);
        for (int i8 = i7 - 1; iMin > 0 && i8 >= 0 && !aVar.c(i8); i8--) {
            iMin--;
        }
        if (iMin != 0) {
            throw D3.j.a();
        }
    }
}
