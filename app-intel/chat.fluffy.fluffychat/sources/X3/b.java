package X3;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final b f9288f = new b(929, 3);

    /* renamed from: a, reason: collision with root package name */
    public final int[] f9289a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f9290b;

    /* renamed from: c, reason: collision with root package name */
    public final c f9291c;

    /* renamed from: d, reason: collision with root package name */
    public final c f9292d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9293e;

    public b(int i7, int i8) {
        this.f9293e = i7;
        this.f9289a = new int[i7];
        this.f9290b = new int[i7];
        int i9 = 1;
        for (int i10 = 0; i10 < i7; i10++) {
            this.f9289a[i10] = i9;
            i9 = (i9 * i8) % i7;
        }
        for (int i11 = 0; i11 < i7 - 1; i11++) {
            this.f9290b[this.f9289a[i11]] = i11;
        }
        this.f9291c = new c(this, new int[]{0});
        this.f9292d = new c(this, new int[]{1});
    }

    public int a(int i7, int i8) {
        return (i7 + i8) % this.f9293e;
    }

    public c b(int i7, int i8) {
        if (i7 < 0) {
            throw new IllegalArgumentException();
        }
        if (i8 == 0) {
            return this.f9291c;
        }
        int[] iArr = new int[i7 + 1];
        iArr[0] = i8;
        return new c(this, iArr);
    }

    public int c(int i7) {
        return this.f9289a[i7];
    }

    public c d() {
        return this.f9292d;
    }

    public int e() {
        return this.f9293e;
    }

    public c f() {
        return this.f9291c;
    }

    public int g(int i7) {
        if (i7 != 0) {
            return this.f9289a[(this.f9293e - this.f9290b[i7]) - 1];
        }
        throw new ArithmeticException();
    }

    public int h(int i7) {
        if (i7 != 0) {
            return this.f9290b[i7];
        }
        throw new IllegalArgumentException();
    }

    public int i(int i7, int i8) {
        if (i7 == 0 || i8 == 0) {
            return 0;
        }
        int[] iArr = this.f9289a;
        int[] iArr2 = this.f9290b;
        return iArr[(iArr2[i7] + iArr2[i8]) % (this.f9293e - 1)];
    }

    public int j(int i7, int i8) {
        int i9 = this.f9293e;
        return ((i7 + i9) - i8) % i9;
    }
}
