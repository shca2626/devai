package F3;

import D3.f;
import J3.e;
import L3.d;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f2711b = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f2712c = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f2713d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f2714e = {"FLG(n)", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f2715f = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: g, reason: collision with root package name */
    public static final Charset f2716g = StandardCharsets.ISO_8859_1;

    /* renamed from: a, reason: collision with root package name */
    public E3.a f2717a;

    /* renamed from: F3.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0025a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2718a;

        static {
            int[] iArr = new int[c.values().length];
            f2718a = iArr;
            try {
                iArr[c.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2718a[c.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2718a[c.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2718a[c.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2718a[c.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean[] f2719a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2720b;

        /* renamed from: c, reason: collision with root package name */
        public final int f2721c;

        public b(boolean[] zArr, int i7, int i8) {
            this.f2719a = zArr;
            this.f2720b = i7;
            this.f2721c = i8;
        }
    }

    public enum c {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i7 = 0; i7 < length; i7++) {
            bArr[i7] = h(zArr, i7 * 8);
        }
        return bArr;
    }

    public static String e(c cVar, int i7) {
        int i8 = C0025a.f2718a[cVar.ordinal()];
        if (i8 == 1) {
            return f2711b[i7];
        }
        if (i8 == 2) {
            return f2712c[i7];
        }
        if (i8 == 3) {
            return f2713d[i7];
        }
        if (i8 == 4) {
            return f2714e[i7];
        }
        if (i8 == 5) {
            return f2715f[i7];
        }
        throw new IllegalStateException("Bad table");
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b7, code lost:
    
        throw D3.f.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String f(boolean[] r14) throws D3.f {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F3.a.f(boolean[]):java.lang.String");
    }

    public static c g(char c7) {
        return c7 != 'B' ? c7 != 'D' ? c7 != 'P' ? c7 != 'L' ? c7 != 'M' ? c.UPPER : c.MIXED : c.LOWER : c.PUNCT : c.DIGIT : c.BINARY;
    }

    public static byte h(boolean[] zArr, int i7) {
        int length = zArr.length - i7;
        return (byte) (length >= 8 ? i(zArr, i7, 8) : i(zArr, i7, length) << (8 - length));
    }

    public static int i(boolean[] zArr, int i7, int i8) {
        int i9 = 0;
        for (int i10 = i7; i10 < i7 + i8; i10++) {
            i9 <<= 1;
            if (zArr[i10]) {
                i9 |= 1;
            }
        }
        return i9;
    }

    public static int j(int i7, boolean z7) {
        return ((z7 ? 88 : 112) + (i7 * 16)) * i7;
    }

    public final b b(boolean[] zArr) throws f {
        int i7;
        L3.a aVar;
        if (this.f2717a.e() <= 2) {
            aVar = L3.a.f5461j;
            i7 = 6;
        } else {
            i7 = 8;
            if (this.f2717a.e() <= 8) {
                aVar = L3.a.f5465n;
            } else if (this.f2717a.e() <= 22) {
                aVar = L3.a.f5460i;
                i7 = 10;
            } else {
                aVar = L3.a.f5459h;
                i7 = 12;
            }
        }
        int iD = this.f2717a.d();
        int length = zArr.length / i7;
        if (length < iD) {
            throw f.a();
        }
        int length2 = zArr.length % i7;
        int[] iArr = new int[length];
        int i8 = 0;
        while (i8 < length) {
            iArr[i8] = i(zArr, length2, i7);
            i8++;
            length2 += i7;
        }
        try {
            L3.c cVar = new L3.c(aVar);
            int i9 = length - iD;
            int iA = cVar.a(iArr, i9);
            int i10 = 1 << i7;
            int i11 = i10 - 1;
            int i12 = 0;
            for (int i13 = 0; i13 < iD; i13++) {
                int i14 = iArr[i13];
                if (i14 == 0 || i14 == i11) {
                    throw f.a();
                }
                if (i14 == 1 || i14 == i10 - 2) {
                    i12++;
                }
            }
            boolean[] zArr2 = new boolean[(iD * i7) - i12];
            int i15 = 0;
            for (int i16 = 0; i16 < iD; i16++) {
                int i17 = iArr[i16];
                if (i17 == 1 || i17 == i10 - 2) {
                    Arrays.fill(zArr2, i15, (i15 + i7) - 1, i17 > 1);
                    i15 += i7 - 1;
                } else {
                    int i18 = i7 - 1;
                    while (i18 >= 0) {
                        int i19 = i15 + 1;
                        zArr2[i15] = (i17 & (1 << i18)) != 0;
                        i18--;
                        i15 = i19;
                    }
                }
            }
            return new b(zArr2, iA, (i9 * 100) / length);
        } catch (d e7) {
            throw f.b(e7);
        }
    }

    public e c(E3.a aVar) throws f {
        this.f2717a = aVar;
        b bVarB = b(d(aVar.a()));
        e eVar = new e(a(bVarB.f2719a), f(bVarB.f2719a), null, String.format("%d%%", Integer.valueOf(bVarB.f2721c)));
        eVar.o(bVarB.f2719a.length);
        eVar.n(Integer.valueOf(bVarB.f2720b));
        return eVar;
    }

    public final boolean[] d(J3.b bVar) {
        boolean zF = this.f2717a.f();
        int iE = this.f2717a.e();
        int i7 = (zF ? 11 : 14) + (iE * 4);
        int[] iArr = new int[i7];
        boolean[] zArr = new boolean[j(iE, zF)];
        int i8 = 2;
        if (zF) {
            for (int i9 = 0; i9 < i7; i9++) {
                iArr[i9] = i9;
            }
        } else {
            int i10 = i7 / 2;
            int i11 = ((i7 + 1) + (((i10 - 1) / 15) * 2)) / 2;
            for (int i12 = 0; i12 < i10; i12++) {
                iArr[(i10 - i12) - 1] = (i11 - r12) - 1;
                iArr[i10 + i12] = (i12 / 15) + i12 + i11 + 1;
            }
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < iE) {
            int i15 = ((iE - i13) * 4) + (zF ? 9 : 12);
            int i16 = i13 * 2;
            int i17 = (i7 - 1) - i16;
            int i18 = 0;
            while (i18 < i15) {
                int i19 = i18 * 2;
                int i20 = 0;
                while (i20 < i8) {
                    int i21 = i16 + i20;
                    int i22 = i16 + i18;
                    zArr[i14 + i19 + i20] = bVar.g(iArr[i21], iArr[i22]);
                    int i23 = i17 - i20;
                    zArr[(i15 * 2) + i14 + i19 + i20] = bVar.g(iArr[i22], iArr[i23]);
                    int i24 = iArr[i23];
                    int i25 = i17 - i18;
                    zArr[(i15 * 4) + i14 + i19 + i20] = bVar.g(i24, iArr[i25]);
                    zArr[(i15 * 6) + i14 + i19 + i20] = bVar.g(iArr[i25], iArr[i21]);
                    i20++;
                    i8 = 2;
                }
                i18++;
                i8 = 2;
            }
            i14 += i15 * 8;
            i13++;
            i8 = 2;
        }
        return zArr;
    }
}
