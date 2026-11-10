package B0;

import E0.U;
import java.util.Arrays;

/* renamed from: B0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0308j {

    /* renamed from: h, reason: collision with root package name */
    public static final C0308j f643h = new b().d(1).c(2).e(3).a();

    /* renamed from: i, reason: collision with root package name */
    public static final C0308j f644i = new b().d(1).c(1).e(2).a();

    /* renamed from: j, reason: collision with root package name */
    public static final String f645j = U.A0(0);

    /* renamed from: k, reason: collision with root package name */
    public static final String f646k = U.A0(1);

    /* renamed from: l, reason: collision with root package name */
    public static final String f647l = U.A0(2);

    /* renamed from: m, reason: collision with root package name */
    public static final String f648m = U.A0(3);

    /* renamed from: n, reason: collision with root package name */
    public static final String f649n = U.A0(4);

    /* renamed from: o, reason: collision with root package name */
    public static final String f650o = U.A0(5);

    /* renamed from: a, reason: collision with root package name */
    public final int f651a;

    /* renamed from: b, reason: collision with root package name */
    public final int f652b;

    /* renamed from: c, reason: collision with root package name */
    public final int f653c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f654d;

    /* renamed from: e, reason: collision with root package name */
    public final int f655e;

    /* renamed from: f, reason: collision with root package name */
    public final int f656f;

    /* renamed from: g, reason: collision with root package name */
    public int f657g;

    /* renamed from: B0.j$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f658a;

        /* renamed from: b, reason: collision with root package name */
        public int f659b;

        /* renamed from: c, reason: collision with root package name */
        public int f660c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f661d;

        /* renamed from: e, reason: collision with root package name */
        public int f662e;

        /* renamed from: f, reason: collision with root package name */
        public int f663f;

        public C0308j a() {
            return new C0308j(this.f658a, this.f659b, this.f660c, this.f661d, this.f662e, this.f663f);
        }

        public b b(int i7) {
            this.f663f = i7;
            return this;
        }

        public b c(int i7) {
            this.f659b = i7;
            return this;
        }

        public b d(int i7) {
            this.f658a = i7;
            return this;
        }

        public b e(int i7) {
            this.f660c = i7;
            return this;
        }

        public b f(byte[] bArr) {
            this.f661d = bArr;
            return this;
        }

        public b g(int i7) {
            this.f662e = i7;
            return this;
        }

        public b() {
            this.f658a = -1;
            this.f659b = -1;
            this.f660c = -1;
            this.f662e = -1;
            this.f663f = -1;
        }

        public b(C0308j c0308j) {
            this.f658a = c0308j.f651a;
            this.f659b = c0308j.f652b;
            this.f660c = c0308j.f653c;
            this.f661d = c0308j.f654d;
            this.f662e = c0308j.f655e;
            this.f663f = c0308j.f656f;
        }
    }

    public static String b(int i7) {
        if (i7 == -1) {
            return "NA";
        }
        return i7 + "bit Chroma";
    }

    public static String c(int i7) {
        if (i7 == -1) {
            return "Unset color range";
        }
        if (i7 == 1) {
            return "Full range";
        }
        if (i7 == 2) {
            return "Limited range";
        }
        return "Undefined color range " + i7;
    }

    public static String d(int i7) {
        if (i7 == -1) {
            return "Unset color space";
        }
        if (i7 == 6) {
            return "BT2020";
        }
        if (i7 == 1) {
            return "BT709";
        }
        if (i7 == 2) {
            return "BT601";
        }
        return "Undefined color space " + i7;
    }

    public static String e(int i7) {
        if (i7 == -1) {
            return "Unset color transfer";
        }
        if (i7 == 10) {
            return "Gamma 2.2";
        }
        if (i7 == 1) {
            return "Linear";
        }
        if (i7 == 2) {
            return "sRGB";
        }
        if (i7 == 3) {
            return "SDR SMPTE 170M";
        }
        if (i7 == 6) {
            return "ST2084 PQ";
        }
        if (i7 == 7) {
            return "HLG";
        }
        return "Undefined color transfer " + i7;
    }

    public static boolean h(C0308j c0308j) {
        if (c0308j == null) {
            return true;
        }
        int i7 = c0308j.f651a;
        if (i7 != -1 && i7 != 1 && i7 != 2) {
            return false;
        }
        int i8 = c0308j.f652b;
        if (i8 != -1 && i8 != 2) {
            return false;
        }
        int i9 = c0308j.f653c;
        if ((i9 != -1 && i9 != 3) || c0308j.f654d != null) {
            return false;
        }
        int i10 = c0308j.f656f;
        if (i10 != -1 && i10 != 8) {
            return false;
        }
        int i11 = c0308j.f655e;
        return i11 == -1 || i11 == 8;
    }

    public static int j(int i7) {
        if (i7 == 1) {
            return 1;
        }
        if (i7 != 9) {
            return (i7 == 4 || i7 == 5 || i7 == 6 || i7 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int k(int i7) {
        if (i7 == 1) {
            return 3;
        }
        if (i7 == 4) {
            return 10;
        }
        if (i7 == 13) {
            return 2;
        }
        if (i7 == 16) {
            return 6;
        }
        if (i7 != 18) {
            return (i7 == 6 || i7 == 7) ? 3 : -1;
        }
        return 7;
    }

    public static String l(int i7) {
        if (i7 == -1) {
            return "NA";
        }
        return i7 + "bit Luma";
    }

    public b a() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0308j.class == obj.getClass()) {
            C0308j c0308j = (C0308j) obj;
            if (this.f651a == c0308j.f651a && this.f652b == c0308j.f652b && this.f653c == c0308j.f653c && Arrays.equals(this.f654d, c0308j.f654d) && this.f655e == c0308j.f655e && this.f656f == c0308j.f656f) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return (this.f655e == -1 || this.f656f == -1) ? false : true;
    }

    public boolean g() {
        return (this.f651a == -1 || this.f652b == -1 || this.f653c == -1) ? false : true;
    }

    public int hashCode() {
        if (this.f657g == 0) {
            this.f657g = ((((((((((527 + this.f651a) * 31) + this.f652b) * 31) + this.f653c) * 31) + Arrays.hashCode(this.f654d)) * 31) + this.f655e) * 31) + this.f656f;
        }
        return this.f657g;
    }

    public boolean i() {
        return f() || g();
    }

    public String m() {
        String str;
        String strG = g() ? U.G("%s/%s/%s", d(this.f651a), c(this.f652b), e(this.f653c)) : "NA/NA/NA";
        if (f()) {
            str = this.f655e + "/" + this.f656f;
        } else {
            str = "NA/NA";
        }
        return strG + "/" + str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(d(this.f651a));
        sb.append(", ");
        sb.append(c(this.f652b));
        sb.append(", ");
        sb.append(e(this.f653c));
        sb.append(", ");
        sb.append(this.f654d != null);
        sb.append(", ");
        sb.append(l(this.f655e));
        sb.append(", ");
        sb.append(b(this.f656f));
        sb.append(")");
        return sb.toString();
    }

    public C0308j(int i7, int i8, int i9, byte[] bArr, int i10, int i11) {
        this.f651a = i7;
        this.f652b = i8;
        this.f653c = i9;
        this.f654d = bArr;
        this.f655e = i10;
        this.f656f = i11;
    }
}
