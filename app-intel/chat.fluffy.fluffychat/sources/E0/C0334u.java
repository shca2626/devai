package E0;

import java.util.NoSuchElementException;

/* renamed from: E0.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0334u {

    /* renamed from: a, reason: collision with root package name */
    public int f2211a;

    /* renamed from: b, reason: collision with root package name */
    public int f2212b;

    /* renamed from: c, reason: collision with root package name */
    public int f2213c;

    /* renamed from: d, reason: collision with root package name */
    public long[] f2214d;

    /* renamed from: e, reason: collision with root package name */
    public int f2215e;

    public C0334u() {
        this(16);
    }

    public void a(long j7) {
        if (this.f2213c == this.f2214d.length) {
            c();
        }
        int i7 = (this.f2212b + 1) & this.f2215e;
        this.f2212b = i7;
        this.f2214d[i7] = j7;
        this.f2213c++;
    }

    public void b() {
        this.f2211a = 0;
        this.f2212b = -1;
        this.f2213c = 0;
    }

    public final void c() {
        long[] jArr = this.f2214d;
        int length = jArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        long[] jArr2 = new long[length];
        int length2 = jArr.length;
        int i7 = this.f2211a;
        int i8 = length2 - i7;
        System.arraycopy(jArr, i7, jArr2, 0, i8);
        System.arraycopy(this.f2214d, 0, jArr2, i8, i7);
        this.f2211a = 0;
        this.f2212b = this.f2213c - 1;
        this.f2214d = jArr2;
        this.f2215e = jArr2.length - 1;
    }

    public long d() {
        if (this.f2213c != 0) {
            return this.f2214d[this.f2211a];
        }
        throw new NoSuchElementException();
    }

    public boolean e() {
        return this.f2213c == 0;
    }

    public long f() {
        int i7 = this.f2213c;
        if (i7 == 0) {
            throw new NoSuchElementException();
        }
        long[] jArr = this.f2214d;
        int i8 = this.f2211a;
        long j7 = jArr[i8];
        this.f2211a = this.f2215e & (i8 + 1);
        this.f2213c = i7 - 1;
        return j7;
    }

    public C0334u(int i7) {
        j3.o.d(i7 >= 0 && i7 <= 1073741824);
        i7 = i7 == 0 ? 1 : i7;
        i7 = Integer.bitCount(i7) != 1 ? Integer.highestOneBit(i7 - 1) << 1 : i7;
        this.f2211a = 0;
        this.f2212b = -1;
        this.f2213c = 0;
        long[] jArr = new long[i7];
        this.f2214d = jArr;
        this.f2215e = jArr.length - 1;
    }
}
