package R3;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class p extends k {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f8058d = {1, 1, 1};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f8059e = {1, 1, 1, 1, 1};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f8060f = {1, 1, 1, 1, 1, 1};

    /* renamed from: g, reason: collision with root package name */
    public static final int[][] f8061g;

    /* renamed from: h, reason: collision with root package name */
    public static final int[][] f8062h;

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f8063a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    public final o f8064b = new o();

    /* renamed from: c, reason: collision with root package name */
    public final g f8065c = new g();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f8061g = iArr;
        int[][] iArr2 = new int[20][];
        f8062h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i7 = 10; i7 < 20; i7++) {
            int[] iArr3 = f8061g[i7 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i8 = 0; i8 < iArr3.length; i8++) {
                iArr4[i8] = iArr3[(iArr3.length - i8) - 1];
            }
            f8062h[i7] = iArr4;
        }
    }

    public static boolean i(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i7 = length - 1;
        return r(charSequence.subSequence(0, i7)) == Character.digit(charSequence.charAt(i7), 10);
    }

    public static int j(J3.a aVar, int[] iArr, int i7, int[][] iArr2) throws D3.j {
        k.f(aVar, i7, iArr);
        int length = iArr2.length;
        float f7 = 0.48f;
        int i8 = -1;
        for (int i9 = 0; i9 < length; i9++) {
            float fE = k.e(iArr, iArr2[i9], 0.7f);
            if (fE < f7) {
                i8 = i9;
                f7 = fE;
            }
        }
        if (i8 >= 0) {
            return i8;
        }
        throw D3.j.a();
    }

    public static int[] n(J3.a aVar, int i7, boolean z7, int[] iArr) {
        return o(aVar, i7, z7, iArr, new int[iArr.length]);
    }

    public static int[] o(J3.a aVar, int i7, boolean z7, int[] iArr, int[] iArr2) throws D3.j {
        int iK = aVar.k();
        int iH = z7 ? aVar.h(i7) : aVar.g(i7);
        int length = iArr.length;
        boolean z8 = z7;
        int i8 = 0;
        int i9 = iH;
        while (iH < iK) {
            if (aVar.c(iH) != z8) {
                iArr2[i8] = iArr2[i8] + 1;
            } else {
                if (i8 != length - 1) {
                    i8++;
                } else {
                    if (k.e(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i9, iH};
                    }
                    i9 += iArr2[0] + iArr2[1];
                    int i10 = i8 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i10);
                    iArr2[i10] = 0;
                    iArr2[i8] = 0;
                    i8--;
                }
                iArr2[i8] = 1;
                z8 = !z8;
            }
            iH++;
        }
        throw D3.j.a();
    }

    public static int[] p(J3.a aVar) throws D3.j {
        int[] iArr = new int[f8058d.length];
        int[] iArrO = null;
        boolean zL = false;
        int i7 = 0;
        while (!zL) {
            int[] iArr2 = f8058d;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrO = o(aVar, i7, false, iArr2, iArr);
            int i8 = iArrO[0];
            int i9 = iArrO[1];
            int i10 = i8 - (i9 - i8);
            if (i10 >= 0) {
                zL = aVar.l(i10, i8, false);
            }
            i7 = i9;
        }
        return iArrO;
    }

    public static int r(CharSequence charSequence) throws D3.f {
        int length = charSequence.length();
        int i7 = 0;
        for (int i8 = length - 1; i8 >= 0; i8 -= 2) {
            int iCharAt = charSequence.charAt(i8) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw D3.f.a();
            }
            i7 += iCharAt;
        }
        int i9 = i7 * 3;
        for (int i10 = length - 2; i10 >= 0; i10 -= 2) {
            int iCharAt2 = charSequence.charAt(i10) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw D3.f.a();
            }
            i9 += iCharAt2;
        }
        return (1000 - i9) % 10;
    }

    @Override // R3.k
    public D3.n c(int i7, J3.a aVar, Map map) {
        return m(i7, aVar, p(aVar), map);
    }

    public boolean h(String str) {
        return i(str);
    }

    public int[] k(J3.a aVar, int i7) {
        return n(aVar, i7, false, f8058d);
    }

    public abstract int l(J3.a aVar, int[] iArr, StringBuilder sb);

    public D3.n m(int i7, J3.a aVar, int[] iArr, Map map) throws D3.j, D3.f, D3.d {
        int length;
        String strC;
        D3.q qVar = map == null ? null : (D3.q) map.get(D3.e.NEED_RESULT_POINT_CALLBACK);
        if (qVar != null) {
            qVar.a(new D3.p((iArr[0] + iArr[1]) / 2.0f, i7));
        }
        StringBuilder sb = this.f8063a;
        sb.setLength(0);
        int iL = l(aVar, iArr, sb);
        if (qVar != null) {
            qVar.a(new D3.p(iL, i7));
        }
        int[] iArrK = k(aVar, iL);
        if (qVar != null) {
            qVar.a(new D3.p((iArrK[0] + iArrK[1]) / 2.0f, i7));
        }
        int i8 = iArrK[1];
        int i9 = (i8 - iArrK[0]) + i8;
        if (i9 >= aVar.k() || !aVar.l(i8, i9, false)) {
            throw D3.j.a();
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw D3.f.a();
        }
        if (!h(string)) {
            throw D3.d.a();
        }
        D3.a aVarQ = q();
        float f7 = i7;
        D3.n nVar = new D3.n(string, null, new D3.p[]{new D3.p((iArr[1] + iArr[0]) / 2.0f, f7), new D3.p((iArrK[1] + iArrK[0]) / 2.0f, f7)}, aVarQ);
        try {
            D3.n nVarA = this.f8064b.a(i7, aVar, iArrK[1]);
            nVar.h(D3.o.UPC_EAN_EXTENSION, nVarA.f());
            nVar.g(nVarA.d());
            nVar.a(nVarA.e());
            length = nVarA.f().length();
        } catch (D3.m unused) {
            length = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(D3.e.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            for (int i10 : iArr2) {
                if (length != i10) {
                }
            }
            throw D3.j.a();
        }
        if ((aVarQ == D3.a.EAN_13 || aVarQ == D3.a.UPC_A) && (strC = this.f8065c.c(string)) != null) {
            nVar.h(D3.o.POSSIBLE_COUNTRY, strC);
        }
        nVar.h(D3.o.SYMBOLOGY_IDENTIFIER, "]E" + (aVarQ == D3.a.EAN_8 ? 4 : 0));
        return nVar;
    }

    public abstract D3.a q();
}
