package E0;

import java.util.Arrays;

/* renamed from: E0.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0333t {

    /* renamed from: a, reason: collision with root package name */
    public int f2209a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f2210b;

    public C0333t() {
        this(32);
    }

    public void a(long j7) {
        int i7 = this.f2209a;
        long[] jArr = this.f2210b;
        if (i7 == jArr.length) {
            this.f2210b = Arrays.copyOf(jArr, i7 * 2);
        }
        long[] jArr2 = this.f2210b;
        int i8 = this.f2209a;
        this.f2209a = i8 + 1;
        jArr2[i8] = j7;
    }

    public void b(long[] jArr) {
        int length = this.f2209a + jArr.length;
        long[] jArr2 = this.f2210b;
        if (length > jArr2.length) {
            this.f2210b = Arrays.copyOf(jArr2, Math.max(jArr2.length * 2, length));
        }
        System.arraycopy(jArr, 0, this.f2210b, this.f2209a, jArr.length);
        this.f2209a = length;
    }

    public long c(int i7) {
        if (i7 >= 0 && i7 < this.f2209a) {
            return this.f2210b[i7];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i7 + ", size is " + this.f2209a);
    }

    public int d() {
        return this.f2209a;
    }

    public C0333t(int i7) {
        this.f2210b = new long[i7];
    }
}
