package E0;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class L {

    /* renamed from: a, reason: collision with root package name */
    public long[] f2083a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f2084b;

    /* renamed from: c, reason: collision with root package name */
    public int f2085c;

    /* renamed from: d, reason: collision with root package name */
    public int f2086d;

    public L() {
        this(10);
    }

    public static Object[] f(int i7) {
        return new Object[i7];
    }

    public synchronized void a(long j7, Object obj) {
        d(j7);
        e();
        b(j7, obj);
    }

    public final void b(long j7, Object obj) {
        int i7 = this.f2085c;
        int i8 = this.f2086d;
        Object[] objArr = this.f2084b;
        int length = (i7 + i8) % objArr.length;
        this.f2083a[length] = j7;
        objArr[length] = obj;
        this.f2086d = i8 + 1;
    }

    public synchronized void c() {
        this.f2085c = 0;
        this.f2086d = 0;
        Arrays.fill(this.f2084b, (Object) null);
    }

    public final void d(long j7) {
        if (this.f2086d > 0) {
            if (j7 <= this.f2083a[((this.f2085c + r0) - 1) % this.f2084b.length]) {
                c();
            }
        }
    }

    public final void e() {
        int length = this.f2084b.length;
        if (this.f2086d < length) {
            return;
        }
        int i7 = length * 2;
        long[] jArr = new long[i7];
        Object[] objArrF = f(i7);
        int i8 = this.f2085c;
        int i9 = length - i8;
        System.arraycopy(this.f2083a, i8, jArr, 0, i9);
        System.arraycopy(this.f2084b, this.f2085c, objArrF, 0, i9);
        int i10 = this.f2085c;
        if (i10 > 0) {
            System.arraycopy(this.f2083a, 0, jArr, i9, i10);
            System.arraycopy(this.f2084b, 0, objArrF, i9, this.f2085c);
        }
        this.f2083a = jArr;
        this.f2084b = objArrF;
        this.f2085c = 0;
    }

    public final Object g(long j7, boolean z7) {
        Object objJ = null;
        long j8 = Long.MAX_VALUE;
        while (this.f2086d > 0) {
            long j9 = j7 - this.f2083a[this.f2085c];
            if (j9 < 0 && (z7 || (-j9) >= j8)) {
                break;
            }
            objJ = j();
            j8 = j9;
        }
        return objJ;
    }

    public synchronized Object h() {
        return this.f2086d == 0 ? null : j();
    }

    public synchronized Object i(long j7) {
        return g(j7, true);
    }

    public final Object j() {
        j3.o.v(this.f2086d > 0);
        Object[] objArr = this.f2084b;
        int i7 = this.f2085c;
        Object obj = objArr[i7];
        objArr[i7] = null;
        this.f2085c = (i7 + 1) % objArr.length;
        this.f2086d--;
        return obj;
    }

    public synchronized int k() {
        return this.f2086d;
    }

    public L(int i7) {
        this.f2083a = new long[i7];
        this.f2084b = f(i7);
    }
}
