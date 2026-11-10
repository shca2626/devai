package A1;

import E0.U;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final w f245a;

    /* renamed from: b, reason: collision with root package name */
    public final int f246b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f247c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f248d;

    /* renamed from: e, reason: collision with root package name */
    public final int f249e;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f250f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f251g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f252h;

    /* renamed from: i, reason: collision with root package name */
    public final long f253i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f254j;

    public z(w wVar, long[] jArr, int[] iArr, int i7, long[] jArr2, int[] iArr2, int[] iArr3, boolean z7, long j7, int i8) {
        j3.o.d(iArr.length == jArr2.length);
        j3.o.d(jArr.length == jArr2.length);
        j3.o.d(iArr2.length == jArr2.length);
        this.f245a = wVar;
        this.f247c = jArr;
        this.f248d = iArr;
        this.f249e = i7;
        this.f250f = jArr2;
        this.f251g = iArr2;
        this.f252h = iArr3;
        this.f254j = z7;
        this.f253i = j7;
        this.f246b = i8;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j7) {
        int i7 = 0;
        if (this.f254j) {
            return U.h(this.f250f, j7, true, false);
        }
        int length = this.f252h.length - 1;
        int i8 = -1;
        while (i7 <= length) {
            int i9 = ((length - i7) / 2) + i7;
            if (this.f250f[this.f252h[i9]] <= j7) {
                i7 = i9 + 1;
                i8 = i9;
            } else {
                length = i9 - 1;
            }
        }
        if (i8 == -1) {
            return -1;
        }
        long j8 = this.f250f[this.f252h[i8]];
        if (j8 == j7) {
            while (i8 > 0 && this.f250f[this.f252h[i8 - 1]] == j8) {
                i8--;
            }
        }
        return this.f252h[i8];
    }

    public int b(long j7) {
        int i7 = 0;
        if (this.f254j) {
            return U.d(this.f250f, j7, true, false);
        }
        int length = this.f252h.length - 1;
        int i8 = -1;
        while (i7 <= length) {
            int i9 = ((length - i7) / 2) + i7;
            if (this.f250f[this.f252h[i9]] >= j7) {
                length = i9 - 1;
                i8 = i9;
            } else {
                i7 = i9 + 1;
            }
        }
        if (i8 == -1) {
            return -1;
        }
        long j8 = this.f250f[this.f252h[i8]];
        if (j8 == j7) {
            while (true) {
                int[] iArr = this.f252h;
                if (i8 >= iArr.length - 1) {
                    break;
                }
                int i10 = i8 + 1;
                if (this.f250f[iArr[i10]] != j8) {
                    break;
                }
                i8 = i10;
            }
        }
        return this.f252h[i8];
    }
}
