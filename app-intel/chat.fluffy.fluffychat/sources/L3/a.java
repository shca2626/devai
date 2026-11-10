package L3;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f5459h = new a(4201, 4096, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final a f5460i = new a(1033, 1024, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final a f5461j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f5462k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f5463l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f5464m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f5465n;

    /* renamed from: o, reason: collision with root package name */
    public static final a f5466o;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f5467a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f5468b;

    /* renamed from: c, reason: collision with root package name */
    public final b f5469c;

    /* renamed from: d, reason: collision with root package name */
    public final b f5470d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5471e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5472f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5473g;

    static {
        a aVar = new a(67, 64, 1);
        f5461j = aVar;
        f5462k = new a(19, 16, 1);
        f5463l = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f5464m = aVar2;
        f5465n = aVar2;
        f5466o = aVar;
    }

    public a(int i7, int i8, int i9) {
        this.f5472f = i7;
        this.f5471e = i8;
        this.f5473g = i9;
        this.f5467a = new int[i8];
        this.f5468b = new int[i8];
        int i10 = 1;
        for (int i11 = 0; i11 < i8; i11++) {
            this.f5467a[i11] = i10;
            i10 *= 2;
            if (i10 >= i8) {
                i10 = (i10 ^ i7) & (i8 - 1);
            }
        }
        for (int i12 = 0; i12 < i8 - 1; i12++) {
            this.f5468b[this.f5467a[i12]] = i12;
        }
        this.f5469c = new b(this, new int[]{0});
        this.f5470d = new b(this, new int[]{1});
    }

    public static int a(int i7, int i8) {
        return i7 ^ i8;
    }

    public b b(int i7, int i8) {
        if (i7 < 0) {
            throw new IllegalArgumentException();
        }
        if (i8 == 0) {
            return this.f5469c;
        }
        int[] iArr = new int[i7 + 1];
        iArr[0] = i8;
        return new b(this, iArr);
    }

    public int c(int i7) {
        return this.f5467a[i7];
    }

    public int d() {
        return this.f5473g;
    }

    public b e() {
        return this.f5470d;
    }

    public int f() {
        return this.f5471e;
    }

    public b g() {
        return this.f5469c;
    }

    public int h(int i7) {
        if (i7 != 0) {
            return this.f5467a[(this.f5471e - this.f5468b[i7]) - 1];
        }
        throw new ArithmeticException();
    }

    public int i(int i7) {
        if (i7 != 0) {
            return this.f5468b[i7];
        }
        throw new IllegalArgumentException();
    }

    public int j(int i7, int i8) {
        if (i7 == 0 || i8 == 0) {
            return 0;
        }
        int[] iArr = this.f5467a;
        int[] iArr2 = this.f5468b;
        return iArr[(iArr2[i7] + iArr2[i8]) % (this.f5471e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f5472f) + ',' + this.f5471e + ')';
    }
}
