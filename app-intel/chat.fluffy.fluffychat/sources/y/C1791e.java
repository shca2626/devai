package y;

import z5.C1877k;

/* renamed from: y.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1791e {

    /* renamed from: a, reason: collision with root package name */
    public int[] f23792a;

    /* renamed from: b, reason: collision with root package name */
    public int f23793b;

    /* renamed from: c, reason: collision with root package name */
    public int f23794c;

    /* renamed from: d, reason: collision with root package name */
    public int f23795d;

    public C1791e() {
        this(0, 1, null);
    }

    public final void a(int i7) {
        int[] iArr = this.f23792a;
        int i8 = this.f23794c;
        iArr[i8] = i7;
        int i9 = this.f23795d & (i8 + 1);
        this.f23794c = i9;
        if (i9 == this.f23793b) {
            c();
        }
    }

    public final void b() {
        this.f23794c = this.f23793b;
    }

    public final void c() {
        int[] iArr = this.f23792a;
        int length = iArr.length;
        int i7 = this.f23793b;
        int i8 = length - i7;
        int i9 = length << 1;
        if (i9 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i9];
        C1877k.f(iArr, iArr2, 0, i7, length);
        C1877k.f(this.f23792a, iArr2, i8, 0, this.f23793b);
        this.f23792a = iArr2;
        this.f23793b = 0;
        this.f23794c = length;
        this.f23795d = i9 - 1;
    }

    public final boolean d() {
        return this.f23793b == this.f23794c;
    }

    public final int e() {
        int i7 = this.f23793b;
        if (i7 == this.f23794c) {
            C1792f c1792f = C1792f.f23796a;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i8 = this.f23792a[i7];
        this.f23793b = (i7 + 1) & this.f23795d;
        return i8;
    }

    public C1791e(int i7) {
        if (i7 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i7 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i7 = Integer.bitCount(i7) != 1 ? Integer.highestOneBit(i7 - 1) << 1 : i7;
        this.f23795d = i7 - 1;
        this.f23792a = new int[i7];
    }

    public /* synthetic */ C1791e(int i7, int i8, M5.g gVar) {
        this((i8 & 1) != 0 ? 8 : i7);
    }
}
