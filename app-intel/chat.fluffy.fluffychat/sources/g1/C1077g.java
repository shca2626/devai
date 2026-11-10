package g1;

import g1.N;
import java.util.Arrays;

/* renamed from: g1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1077g implements N {

    /* renamed from: a, reason: collision with root package name */
    public final int f16085a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f16086b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f16087c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f16088d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f16089e;

    /* renamed from: f, reason: collision with root package name */
    public final long f16090f;

    public C1077g(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f16086b = iArr;
        this.f16087c = jArr;
        this.f16088d = jArr2;
        this.f16089e = jArr3;
        int length = iArr.length;
        this.f16085a = length;
        if (length > 0) {
            this.f16090f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f16090f = 0L;
        }
    }

    public int b(long j7) {
        return E0.U.h(this.f16089e, j7, true, true);
    }

    @Override // g1.N
    public boolean e() {
        return true;
    }

    @Override // g1.N
    public N.a g(long j7) {
        int iB = b(j7);
        O o7 = new O(this.f16089e[iB], this.f16087c[iB]);
        if (o7.f15971a >= j7 || iB == this.f16085a - 1) {
            return new N.a(o7);
        }
        int i7 = iB + 1;
        return new N.a(o7, new O(this.f16089e[i7], this.f16087c[i7]));
    }

    @Override // g1.N
    public long i() {
        return this.f16090f;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f16085a + ", sizes=" + Arrays.toString(this.f16086b) + ", offsets=" + Arrays.toString(this.f16087c) + ", timeUs=" + Arrays.toString(this.f16089e) + ", durationsUs=" + Arrays.toString(this.f16088d) + ")";
    }
}
