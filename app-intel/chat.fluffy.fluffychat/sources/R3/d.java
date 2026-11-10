package R3;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class d extends k {

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f8030c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f8031d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f8032e;

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f8033a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    public final int[] f8034b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f8031d = iArr;
        f8032e = iArr[47];
    }

    public static void h(CharSequence charSequence) throws D3.d {
        int length = charSequence.length();
        i(charSequence, length - 2, 20);
        i(charSequence, length - 1, 15);
    }

    public static void i(CharSequence charSequence, int i7, int i8) throws D3.d {
        int iIndexOf = 0;
        int i9 = 1;
        for (int i10 = i7 - 1; i10 >= 0; i10--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i10)) * i9;
            i9++;
            if (i9 > i8) {
                i9 = 1;
            }
        }
        if (charSequence.charAt(i7) != f8030c[iIndexOf % 47]) {
            throw D3.d.a();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String j(java.lang.CharSequence r9) throws D3.f {
        /*
            int r0 = r9.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = r2
        Lb:
            if (r3 >= r0) goto Lb3
            char r4 = r9.charAt(r3)
            r5 = 97
            if (r4 < r5) goto Lac
            r5 = 100
            if (r4 > r5) goto Lac
            int r5 = r0 + (-1)
            if (r3 >= r5) goto La7
            int r3 = r3 + 1
            char r5 = r9.charAt(r3)
            r6 = 79
            r7 = 90
            r8 = 65
            switch(r4) {
                case 97: goto L97;
                case 98: goto L4e;
                case 99: goto L3d;
                case 100: goto L2f;
                default: goto L2c;
            }
        L2c:
            r4 = r2
            goto L9e
        L2f:
            if (r5 < r8) goto L38
            if (r5 > r7) goto L38
            int r5 = r5 + 32
        L35:
            char r4 = (char) r5
            goto L9e
        L38:
            D3.f r9 = D3.f.a()
            throw r9
        L3d:
            if (r5 < r8) goto L44
            if (r5 > r6) goto L44
            int r5 = r5 + (-32)
            goto L35
        L44:
            if (r5 != r7) goto L49
            r4 = 58
            goto L9e
        L49:
            D3.f r9 = D3.f.a()
            throw r9
        L4e:
            if (r5 < r8) goto L57
            r4 = 69
            if (r5 > r4) goto L57
            int r5 = r5 + (-38)
            goto L35
        L57:
            r4 = 70
            if (r5 < r4) goto L62
            r4 = 74
            if (r5 > r4) goto L62
            int r5 = r5 + (-11)
            goto L35
        L62:
            r4 = 75
            if (r5 < r4) goto L6b
            if (r5 > r6) goto L6b
            int r5 = r5 + 16
            goto L35
        L6b:
            r4 = 80
            if (r5 < r4) goto L76
            r4 = 84
            if (r5 > r4) goto L76
            int r5 = r5 + 43
            goto L35
        L76:
            r4 = 85
            if (r5 != r4) goto L7b
            goto L2c
        L7b:
            r4 = 86
            if (r5 != r4) goto L82
            r4 = 64
            goto L9e
        L82:
            r4 = 87
            if (r5 != r4) goto L89
            r4 = 96
            goto L9e
        L89:
            r4 = 88
            if (r5 < r4) goto L92
            if (r5 > r7) goto L92
            r4 = 127(0x7f, float:1.78E-43)
            goto L9e
        L92:
            D3.f r9 = D3.f.a()
            throw r9
        L97:
            if (r5 < r8) goto La2
            if (r5 > r7) goto La2
            int r5 = r5 + (-64)
            goto L35
        L9e:
            r1.append(r4)
            goto Laf
        La2:
            D3.f r9 = D3.f.a()
            throw r9
        La7:
            D3.f r9 = D3.f.a()
            throw r9
        Lac:
            r1.append(r4)
        Laf:
            int r3 = r3 + 1
            goto Lb
        Lb3:
            java.lang.String r9 = r1.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: R3.d.j(java.lang.CharSequence):java.lang.String");
    }

    private static char l(int i7) throws D3.j {
        int i8 = 0;
        while (true) {
            int[] iArr = f8031d;
            if (i8 >= iArr.length) {
                throw D3.j.a();
            }
            if (iArr[i8] == i7) {
                return f8030c[i8];
            }
            i8++;
        }
    }

    public static int m(int[] iArr) {
        int i7 = 0;
        for (int i8 : iArr) {
            i7 += i8;
        }
        int length = iArr.length;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            int iRound = Math.round((iArr[i10] * 9.0f) / i7);
            if (iRound < 1 || iRound > 4) {
                return -1;
            }
            if ((i10 & 1) == 0) {
                for (int i11 = 0; i11 < iRound; i11++) {
                    i9 = (i9 << 1) | 1;
                }
            } else {
                i9 <<= iRound;
            }
        }
        return i9;
    }

    @Override // R3.k
    public D3.n c(int i7, J3.a aVar, Map map) throws D3.j, D3.d {
        int iG = aVar.g(k(aVar)[1]);
        int iK = aVar.k();
        int[] iArr = this.f8034b;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f8033a;
        sb.setLength(0);
        while (true) {
            k.f(aVar, iG, iArr);
            int iM = m(iArr);
            if (iM < 0) {
                throw D3.j.a();
            }
            char cL = l(iM);
            sb.append(cL);
            int i8 = iG;
            for (int i9 : iArr) {
                i8 += i9;
            }
            int iG2 = aVar.g(i8);
            if (cL == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i10 = 0;
                for (int i11 : iArr) {
                    i10 += i11;
                }
                if (iG2 == iK || !aVar.c(iG2)) {
                    throw D3.j.a();
                }
                if (sb.length() < 2) {
                    throw D3.j.a();
                }
                h(sb);
                sb.setLength(sb.length() - 2);
                float f7 = i7;
                D3.n nVar = new D3.n(j(sb), null, new D3.p[]{new D3.p((r14[1] + r14[0]) / 2.0f, f7), new D3.p(iG + (i10 / 2.0f), f7)}, D3.a.CODE_93);
                nVar.h(D3.o.SYMBOLOGY_IDENTIFIER, "]G0");
                return nVar;
            }
            iG = iG2;
        }
    }

    public final int[] k(J3.a aVar) throws D3.j {
        int iK = aVar.k();
        int iG = aVar.g(0);
        Arrays.fill(this.f8034b, 0);
        int[] iArr = this.f8034b;
        int length = iArr.length;
        boolean z7 = false;
        int i7 = 0;
        int i8 = iG;
        while (iG < iK) {
            if (aVar.c(iG) != z7) {
                iArr[i7] = iArr[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (m(iArr) == f8032e) {
                        return new int[]{i8, iG};
                    }
                    i8 += iArr[0] + iArr[1];
                    int i9 = i7 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i9);
                    iArr[i9] = 0;
                    iArr[i7] = 0;
                    i7--;
                }
                iArr[i7] = 1;
                z7 = !z7;
            }
            iG++;
        }
        throw D3.j.a();
    }
}
