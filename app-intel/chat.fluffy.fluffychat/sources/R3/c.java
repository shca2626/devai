package R3;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class c extends k {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f8025e = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};

    /* renamed from: a, reason: collision with root package name */
    public final boolean f8026a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8027b;

    /* renamed from: c, reason: collision with root package name */
    public final StringBuilder f8028c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f8029d;

    public c() {
        this(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String h(java.lang.CharSequence r12) throws D3.f {
        /*
            int r0 = r12.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = r2
        Lb:
            if (r3 >= r0) goto Lbf
            char r4 = r12.charAt(r3)
            r5 = 47
            r6 = 37
            r7 = 36
            r8 = 43
            if (r4 == r8) goto L27
            if (r4 == r7) goto L27
            if (r4 == r6) goto L27
            if (r4 != r5) goto L22
            goto L27
        L22:
            r1.append(r4)
            goto Lb6
        L27:
            int r3 = r3 + 1
            char r9 = r12.charAt(r3)
            r10 = 90
            r11 = 65
            if (r4 == r7) goto Lac
            r7 = 79
            if (r4 == r6) goto L5e
            if (r4 == r8) goto L52
            if (r4 == r5) goto L3e
        L3b:
            r4 = r2
            goto Lb3
        L3e:
            if (r9 < r11) goto L47
            if (r9 > r7) goto L47
            int r9 = r9 + (-32)
        L44:
            char r4 = (char) r9
            goto Lb3
        L47:
            if (r9 != r10) goto L4d
            r4 = 58
            goto Lb3
        L4d:
            D3.f r12 = D3.f.a()
            throw r12
        L52:
            if (r9 < r11) goto L59
            if (r9 > r10) goto L59
            int r9 = r9 + 32
            goto L44
        L59:
            D3.f r12 = D3.f.a()
            throw r12
        L5e:
            if (r9 < r11) goto L67
            r4 = 69
            if (r9 > r4) goto L67
            int r9 = r9 + (-38)
            goto L44
        L67:
            r4 = 70
            if (r9 < r4) goto L72
            r4 = 74
            if (r9 > r4) goto L72
            int r9 = r9 + (-11)
            goto L44
        L72:
            r4 = 75
            if (r9 < r4) goto L7b
            if (r9 > r7) goto L7b
            int r9 = r9 + 16
            goto L44
        L7b:
            r4 = 80
            if (r9 < r4) goto L86
            r4 = 84
            if (r9 > r4) goto L86
            int r9 = r9 + 43
            goto L44
        L86:
            r4 = 85
            if (r9 != r4) goto L8b
            goto L3b
        L8b:
            r4 = 86
            if (r9 != r4) goto L92
            r4 = 64
            goto Lb3
        L92:
            r4 = 87
            if (r9 != r4) goto L99
            r4 = 96
            goto Lb3
        L99:
            r4 = 88
            if (r9 == r4) goto La9
            r4 = 89
            if (r9 == r4) goto La9
            if (r9 != r10) goto La4
            goto La9
        La4:
            D3.f r12 = D3.f.a()
            throw r12
        La9:
            r4 = 127(0x7f, float:1.78E-43)
            goto Lb3
        Lac:
            if (r9 < r11) goto Lba
            if (r9 > r10) goto Lba
            int r9 = r9 + (-64)
            goto L44
        Lb3:
            r1.append(r4)
        Lb6:
            int r3 = r3 + 1
            goto Lb
        Lba:
            D3.f r12 = D3.f.a()
            throw r12
        Lbf:
            java.lang.String r12 = r1.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: R3.c.h(java.lang.CharSequence):java.lang.String");
    }

    public static int[] i(J3.a aVar, int[] iArr) throws D3.j {
        int iK = aVar.k();
        int iG = aVar.g(0);
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
                    if (k(iArr) == 148 && aVar.l(Math.max(0, i8 - ((iG - i8) / 2)), i8, false)) {
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

    public static char j(int i7) throws D3.j {
        int i8 = 0;
        while (true) {
            int[] iArr = f8025e;
            if (i8 >= iArr.length) {
                if (i7 == 148) {
                    return '*';
                }
                throw D3.j.a();
            }
            if (iArr[i8] == i7) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i8);
            }
            i8++;
        }
    }

    public static int k(int[] iArr) {
        int length = iArr.length;
        int i7 = 0;
        while (true) {
            int i8 = Integer.MAX_VALUE;
            for (int i9 : iArr) {
                if (i9 < i8 && i9 > i7) {
                    i8 = i9;
                }
            }
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < length; i13++) {
                int i14 = iArr[i13];
                if (i14 > i8) {
                    i11 |= 1 << ((length - 1) - i13);
                    i10++;
                    i12 += i14;
                }
            }
            if (i10 == 3) {
                for (int i15 = 0; i15 < length && i10 > 0; i15++) {
                    int i16 = iArr[i15];
                    if (i16 > i8) {
                        i10--;
                        if (i16 * 2 >= i12) {
                            return -1;
                        }
                    }
                }
                return i11;
            }
            if (i10 <= 3) {
                return -1;
            }
            i7 = i8;
        }
    }

    @Override // R3.k
    public D3.n c(int i7, J3.a aVar, Map map) throws D3.j, D3.d {
        int[] iArr = this.f8029d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f8028c;
        sb.setLength(0);
        int iG = aVar.g(i(aVar, iArr)[1]);
        int iK = aVar.k();
        while (true) {
            k.f(aVar, iG, iArr);
            int iK2 = k(iArr);
            if (iK2 < 0) {
                throw D3.j.a();
            }
            char cJ = j(iK2);
            sb.append(cJ);
            int i8 = iG;
            for (int i9 : iArr) {
                i8 += i9;
            }
            int iG2 = aVar.g(i8);
            if (cJ == '*') {
                sb.setLength(sb.length() - 1);
                int i10 = 0;
                for (int i11 : iArr) {
                    i10 += i11;
                }
                int i12 = (iG2 - iG) - i10;
                if (iG2 != iK && i12 * 2 < i10) {
                    throw D3.j.a();
                }
                if (this.f8026a) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i13 = 0; i13 < length; i13++) {
                        iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f8028c.charAt(i13));
                    }
                    if (sb.charAt(length) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                        throw D3.d.a();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw D3.j.a();
                }
                float f7 = i7;
                D3.n nVar = new D3.n(this.f8027b ? h(sb) : sb.toString(), null, new D3.p[]{new D3.p((r2[1] + r2[0]) / 2.0f, f7), new D3.p(iG + (i10 / 2.0f), f7)}, D3.a.CODE_39);
                nVar.h(D3.o.SYMBOLOGY_IDENTIFIER, "]A0");
                return nVar;
            }
            iG = iG2;
        }
    }

    public c(boolean z7) {
        this(z7, false);
    }

    public c(boolean z7, boolean z8) {
        this.f8026a = z7;
        this.f8027b = z8;
        this.f8028c = new StringBuilder(20);
        this.f8029d = new int[9];
    }
}
