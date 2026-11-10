package W3;

import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f8980a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f8981b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: c, reason: collision with root package name */
    public static final BigInteger[] f8982c;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8983a;

        static {
            int[] iArr = new int[b.values().length];
            f8983a = iArr;
            try {
                iArr[b.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8983a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8983a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8983a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8983a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8983a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f8982c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i7 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f8982c;
            if (i7 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i7] = bigIntegerArr2[i7 - 1].multiply(bigIntegerValueOf);
            i7++;
        }
    }

    public static int a(int i7, int[] iArr, int i8, J3.h hVar) throws D3.f {
        int i9;
        int i10;
        boolean z7 = false;
        while (i8 < iArr[0] && !z7) {
            while (true) {
                i9 = iArr[0];
                if (i8 >= i9 || iArr[i8] != 927) {
                    break;
                }
                hVar.f(iArr[i8 + 1]);
                i8 += 2;
            }
            if (i8 >= i9 || iArr[i8] >= 900) {
                z7 = true;
            } else {
                long j7 = 0;
                int i11 = 0;
                while (true) {
                    i10 = i8 + 1;
                    j7 = (j7 * 900) + iArr[i8];
                    i11++;
                    if (i11 >= 5 || i10 >= iArr[0] || iArr[i10] >= 900) {
                        break;
                    }
                    i8 = i10;
                }
                if (i11 != 5 || (i7 != 924 && (i10 >= iArr[0] || iArr[i10] >= 900))) {
                    i10 -= i11;
                    while (i10 < iArr[0] && !z7) {
                        int i12 = i10 + 1;
                        int i13 = iArr[i10];
                        if (i13 < 900) {
                            hVar.a((byte) i13);
                            i10 = i12;
                        } else if (i13 == 927) {
                            i10 += 2;
                            hVar.f(iArr[i12]);
                        } else {
                            z7 = true;
                        }
                    }
                } else {
                    for (int i14 = 0; i14 < 6; i14++) {
                        hVar.a((byte) (j7 >> ((5 - i14) * 8)));
                    }
                }
                i8 = i10;
            }
        }
        return i8;
    }

    public static J3.e b(int[] iArr, String str) throws D3.f {
        J3.h hVar = new J3.h(iArr.length * 2);
        int iG = g(iArr, 1, hVar);
        V3.c cVar = new V3.c();
        while (iG < iArr[0]) {
            int i7 = iG + 1;
            int i8 = iArr[iG];
            if (i8 != 913) {
                switch (i8) {
                    case 900:
                        iG = g(iArr, i7, hVar);
                        continue;
                    case 901:
                        break;
                    case 902:
                        iG = f(iArr, i7, hVar);
                        continue;
                    default:
                        switch (i8) {
                            case 922:
                            case 923:
                                throw D3.f.a();
                            case 924:
                                break;
                            case 925:
                                iG += 2;
                                continue;
                            case 926:
                                iG += 3;
                                continue;
                            case 927:
                                iG += 2;
                                hVar.f(iArr[i7]);
                                continue;
                            case 928:
                                iG = d(iArr, i7, cVar);
                                continue;
                            default:
                                iG = g(iArr, iG, hVar);
                                continue;
                        }
                }
                iG = a(i8, iArr, i7, hVar);
            } else {
                iG += 2;
                hVar.b((char) iArr[i7]);
            }
        }
        if (hVar.h() && cVar.a() == null) {
            throw D3.f.a();
        }
        J3.e eVar = new J3.e(null, hVar.toString(), null, str);
        eVar.p(cVar);
        return eVar;
    }

    public static String c(int[] iArr, int i7) throws D3.f {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i8 = 0; i8 < i7; i8++) {
            bigIntegerAdd = bigIntegerAdd.add(f8982c[(i7 - i8) - 1].multiply(BigInteger.valueOf(iArr[i8])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw D3.f.a();
    }

    public static int d(int[] iArr, int i7, V3.c cVar) throws D3.f {
        int i8;
        if (i7 + 2 > iArr[0]) {
            throw D3.f.a();
        }
        int[] iArr2 = new int[2];
        int i9 = 0;
        while (i9 < 2) {
            iArr2[i9] = iArr[i7];
            i9++;
            i7++;
        }
        String strC = c(iArr2, 2);
        if (strC.isEmpty()) {
            cVar.k(0);
        } else {
            try {
                cVar.k(Integer.parseInt(strC));
            } catch (NumberFormatException unused) {
                throw D3.f.a();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (i7 < iArr[0] && i7 < iArr.length && (i8 = iArr[i7]) != 922 && i8 != 923) {
            sb.append(String.format("%03d", Integer.valueOf(i8)));
            i7++;
        }
        if (sb.length() == 0) {
            throw D3.f.a();
        }
        cVar.e(sb.toString());
        int i10 = iArr[i7] == 923 ? i7 + 1 : -1;
        while (i7 < iArr[0]) {
            int i11 = iArr[i7];
            if (i11 == 922) {
                i7++;
                cVar.h(true);
            } else {
                if (i11 != 923) {
                    throw D3.f.a();
                }
                switch (iArr[i7 + 1]) {
                    case 0:
                        J3.h hVar = new J3.h();
                        i7 = g(iArr, i7 + 2, hVar);
                        cVar.f(hVar.toString());
                        break;
                    case 1:
                        J3.h hVar2 = new J3.h();
                        i7 = f(iArr, i7 + 2, hVar2);
                        try {
                            cVar.j(Integer.parseInt(hVar2.toString()));
                            break;
                        } catch (NumberFormatException unused2) {
                            throw D3.f.a();
                        }
                    case 2:
                        J3.h hVar3 = new J3.h();
                        i7 = f(iArr, i7 + 2, hVar3);
                        try {
                            cVar.m(Long.parseLong(hVar3.toString()));
                            break;
                        } catch (NumberFormatException unused3) {
                            throw D3.f.a();
                        }
                    case 3:
                        J3.h hVar4 = new J3.h();
                        i7 = g(iArr, i7 + 2, hVar4);
                        cVar.l(hVar4.toString());
                        break;
                    case 4:
                        J3.h hVar5 = new J3.h();
                        i7 = g(iArr, i7 + 2, hVar5);
                        cVar.c(hVar5.toString());
                        break;
                    case 5:
                        J3.h hVar6 = new J3.h();
                        i7 = f(iArr, i7 + 2, hVar6);
                        try {
                            cVar.g(Long.parseLong(hVar6.toString()));
                            break;
                        } catch (NumberFormatException unused4) {
                            throw D3.f.a();
                        }
                    case 6:
                        J3.h hVar7 = new J3.h();
                        i7 = f(iArr, i7 + 2, hVar7);
                        try {
                            cVar.d(Integer.parseInt(hVar7.toString()));
                            break;
                        } catch (NumberFormatException unused5) {
                            throw D3.f.a();
                        }
                    default:
                        throw D3.f.a();
                }
            }
        }
        if (i10 != -1) {
            int i12 = i7 - i10;
            if (cVar.b()) {
                i12--;
            }
            if (i12 > 0) {
                cVar.i(Arrays.copyOfRange(iArr, i10, i12 + i10));
            }
        }
        return i7;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0052 A[FALL_THROUGH, PHI: r3 r4
      0x0052: PHI (r3v10 W3.e$b) = 
      (r3v1 W3.e$b)
      (r3v1 W3.e$b)
      (r3v2 W3.e$b)
      (r3v1 W3.e$b)
      (r3v1 W3.e$b)
      (r3v3 W3.e$b)
      (r3v1 W3.e$b)
      (r3v1 W3.e$b)
      (r3v5 W3.e$b)
      (r3v12 W3.e$b)
     binds: [B:70:0x00dd, B:65:0x00cc, B:67:0x00d0, B:59:0x00b9, B:53:0x00a9, B:56:0x00af, B:46:0x0095, B:40:0x0083, B:42:0x0087, B:23:0x0050] A[DONT_GENERATE, DONT_INLINE]
      0x0052: PHI (r4v13 W3.e$b) = 
      (r4v1 W3.e$b)
      (r4v1 W3.e$b)
      (r4v3 W3.e$b)
      (r4v1 W3.e$b)
      (r4v1 W3.e$b)
      (r4v6 W3.e$b)
      (r4v1 W3.e$b)
      (r4v1 W3.e$b)
      (r4v9 W3.e$b)
      (r4v1 W3.e$b)
     binds: [B:70:0x00dd, B:65:0x00cc, B:67:0x00d0, B:59:0x00b9, B:53:0x00a9, B:56:0x00af, B:46:0x0095, B:40:0x0083, B:42:0x0087, B:23:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static W3.e.b e(int[] r15, int[] r16, int r17, J3.h r18, W3.e.b r19) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.e.e(int[], int[], int, J3.h, W3.e$b):W3.e$b");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x003e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0007 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int f(int[] r8, int r9, J3.h r10) {
        /*
            r0 = 15
            int[] r0 = new int[r0]
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            r4 = r8[r1]
            if (r9 >= r4) goto L47
            if (r2 != 0) goto L47
            int r5 = r9 + 1
            r6 = r8[r9]
            r7 = 1
            if (r5 != r4) goto L15
            r2 = r7
        L15:
            r4 = 900(0x384, float:1.261E-42)
            if (r6 >= r4) goto L1f
            r0[r3] = r6
            int r3 = r3 + 1
        L1d:
            r9 = r5
            goto L32
        L1f:
            if (r6 == r4) goto L31
            r4 = 901(0x385, float:1.263E-42)
            if (r6 == r4) goto L31
            r4 = 927(0x39f, float:1.299E-42)
            if (r6 == r4) goto L31
            r4 = 928(0x3a0, float:1.3E-42)
            if (r6 == r4) goto L31
            switch(r6) {
                case 922: goto L31;
                case 923: goto L31;
                case 924: goto L31;
                default: goto L30;
            }
        L30:
            goto L1d
        L31:
            r2 = r7
        L32:
            int r4 = r3 % 15
            if (r4 == 0) goto L3c
            r4 = 902(0x386, float:1.264E-42)
            if (r6 == r4) goto L3c
            if (r2 == 0) goto L7
        L3c:
            if (r3 <= 0) goto L7
            java.lang.String r3 = c(r0, r3)
            r10.d(r3)
            r3 = r1
            goto L7
        L47:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.e.f(int[], int, J3.h):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x003a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x003d. Please report as an issue. */
    public static int g(int[] iArr, int i7, J3.h hVar) throws D3.f {
        int i8 = iArr[0];
        int[] iArr2 = new int[(i8 - i7) * 2];
        int[] iArr3 = new int[(i8 - i7) * 2];
        b bVar = b.ALPHA;
        boolean z7 = false;
        int i9 = 0;
        while (i7 < iArr[0] && !z7) {
            int i10 = i7 + 1;
            int i11 = iArr[i7];
            if (i11 < 900) {
                iArr2[i9] = i11 / 30;
                iArr2[i9 + 1] = i11 % 30;
                i9 += 2;
            } else if (i11 == 913) {
                iArr2[i9] = 913;
                i7 += 2;
                iArr3[i9] = iArr[i10];
                i9++;
            } else if (i11 != 927) {
                if (i11 != 928) {
                    switch (i11) {
                        case 900:
                            iArr2[i9] = 900;
                            i9++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i11) {
                            }
                    }
                }
                z7 = true;
            } else {
                b bVarE = e(iArr2, iArr3, i9, hVar, bVar);
                i7 += 2;
                hVar.f(iArr[i10]);
                int i12 = iArr[0];
                if (i7 > i12) {
                    throw D3.f.a();
                }
                bVar = bVarE;
                iArr3 = new int[(i12 - i7) * 2];
                iArr2 = new int[(i12 - i7) * 2];
                i9 = 0;
            }
            i7 = i10;
        }
        e(iArr2, iArr3, i9, hVar, bVar);
        return i7;
    }
}
