package y;

import z5.C1880k;

/* renamed from: y.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1790e {

    /* renamed from: a, reason: collision with root package name */
    public int[] f23798a;

    /* renamed from: b, reason: collision with root package name */
    public int f23799b;

    /* renamed from: c, reason: collision with root package name */
    public int f23800c;

    /* renamed from: d, reason: collision with root package name */
    public int f23801d;

    public C1790e() {
        this(0, 1, null);
    }

    public final void a(int i7) {
        int[] iArr = this.f23798a;
        int i8 = this.f23800c;
        iArr[i8] = i7;
        int i9 = this.f23801d & (i8 + 1);
        this.f23800c = i9;
        if (i9 == this.f23799b) {
            c();
        }
    }

    public final void b() {
        this.f23800c = this.f23799b;
    }

    public final void c() {
        int[] iArr = this.f23798a;
        int length = iArr.length;
        int i7 = this.f23799b;
        int i8 = length - i7;
        int i9 = length << 1;
        if (i9 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i9];
        C1880k.f(iArr, iArr2, 0, i7, length);
        C1880k.f(this.f23798a, iArr2, i8, 0, this.f23799b);
        this.f23798a = iArr2;
        this.f23799b = 0;
        this.f23800c = length;
        this.f23801d = i9 - 1;
    }

    public final boolean d() {
        return this.f23799b == this.f23800c;
    }

    public final int e() {
        int i7 = this.f23799b;
        if (i7 == this.f23800c) {
            C1791f c1791f = C1791f.f23802a;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i8 = this.f23798a[i7];
        this.f23799b = (i7 + 1) & this.f23801d;
        return i8;
    }

    public C1790e(int i7) {
        if (i7 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i7 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i7 = Integer.bitCount(i7) != 1 ? Integer.highestOneBit(i7 - 1) << 1 : i7;
        this.f23801d = i7 - 1;
        this.f23798a = new int[i7];
    }

    public /* synthetic */ C1790e(int i7, int i8, M5.g gVar) {
        this((i8 & 1) != 0 ? 8 : i7);
    }
}
