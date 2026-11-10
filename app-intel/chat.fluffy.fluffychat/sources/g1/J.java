package g1;

/* loaded from: classes.dex */
public abstract class J {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f15951a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f15952b = {44100, 48000, 32000};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f15953c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f15954d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f15955e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f15956f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f15957g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f15958a;

        /* renamed from: b, reason: collision with root package name */
        public String f15959b;

        /* renamed from: c, reason: collision with root package name */
        public int f15960c;

        /* renamed from: d, reason: collision with root package name */
        public int f15961d;

        /* renamed from: e, reason: collision with root package name */
        public int f15962e;

        /* renamed from: f, reason: collision with root package name */
        public int f15963f;

        /* renamed from: g, reason: collision with root package name */
        public int f15964g;

        public a() {
        }

        public boolean a(int i7) {
            int i8;
            int i9;
            int i10;
            int i11;
            if (!J.l(i7) || (i8 = (i7 >>> 19) & 3) == 1 || (i9 = (i7 >>> 17) & 3) == 0 || (i10 = (i7 >>> 12) & 15) == 0 || i10 == 15 || (i11 = (i7 >>> 10) & 3) == 3) {
                return false;
            }
            this.f15958a = i8;
            this.f15959b = J.f15951a[3 - i9];
            int i12 = J.f15952b[i11];
            this.f15961d = i12;
            if (i8 == 2) {
                this.f15961d = i12 / 2;
            } else if (i8 == 0) {
                this.f15961d = i12 / 4;
            }
            int i13 = (i7 >>> 9) & 1;
            this.f15964g = J.k(i8, i9);
            if (i9 == 3) {
                int i14 = i8 == 3 ? J.f15953c[i10 - 1] : J.f15954d[i10 - 1];
                this.f15963f = i14;
                this.f15960c = (((i14 * 12) / this.f15961d) + i13) * 4;
            } else {
                if (i8 == 3) {
                    int i15 = i9 == 2 ? J.f15955e[i10 - 1] : J.f15956f[i10 - 1];
                    this.f15963f = i15;
                    this.f15960c = ((i15 * 144) / this.f15961d) + i13;
                } else {
                    int i16 = J.f15957g[i10 - 1];
                    this.f15963f = i16;
                    this.f15960c = (((i9 == 1 ? 72 : 144) * i16) / this.f15961d) + i13;
                }
            }
            this.f15962e = ((i7 >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }

        public a(a aVar) {
            this.f15958a = aVar.f15958a;
            this.f15959b = aVar.f15959b;
            this.f15960c = aVar.f15960c;
            this.f15961d = aVar.f15961d;
            this.f15962e = aVar.f15962e;
            this.f15963f = aVar.f15963f;
            this.f15964g = aVar.f15964g;
        }
    }

    public static int j(int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        if (!l(i7) || (i8 = (i7 >>> 19) & 3) == 1 || (i9 = (i7 >>> 17) & 3) == 0 || (i10 = (i7 >>> 12) & 15) == 0 || i10 == 15 || (i11 = (i7 >>> 10) & 3) == 3) {
            return -1;
        }
        int i12 = f15952b[i11];
        if (i8 == 2) {
            i12 /= 2;
        } else if (i8 == 0) {
            i12 /= 4;
        }
        int i13 = (i7 >>> 9) & 1;
        if (i9 == 3) {
            return ((((i8 == 3 ? f15953c[i10 - 1] : f15954d[i10 - 1]) * 12) / i12) + i13) * 4;
        }
        int i14 = i8 == 3 ? i9 == 2 ? f15955e[i10 - 1] : f15956f[i10 - 1] : f15957g[i10 - 1];
        if (i8 == 3) {
            return ((i14 * 144) / i12) + i13;
        }
        return (((i9 == 1 ? 72 : 144) * i14) / i12) + i13;
    }

    public static int k(int i7, int i8) {
        if (i8 == 1) {
            return i7 == 3 ? 1152 : 576;
        }
        if (i8 == 2) {
            return 1152;
        }
        if (i8 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }

    public static boolean l(int i7) {
        return (i7 & (-2097152)) == -2097152;
    }

    public static int m(int i7) {
        int i8;
        int i9;
        if (!l(i7) || (i8 = (i7 >>> 19) & 3) == 1 || (i9 = (i7 >>> 17) & 3) == 0) {
            return -1;
        }
        int i10 = (i7 >>> 12) & 15;
        int i11 = (i7 >>> 10) & 3;
        if (i10 == 0 || i10 == 15 || i11 == 3) {
            return -1;
        }
        return k(i8, i9);
    }
}
