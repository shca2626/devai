package k3;

import j3.AbstractC1237k;
import java.util.Arrays;
import k3.N;
import k3.O;

/* loaded from: classes.dex */
public class T {

    /* renamed from: a, reason: collision with root package name */
    public transient Object[] f18879a;

    /* renamed from: b, reason: collision with root package name */
    public transient int[] f18880b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f18881c;

    /* renamed from: d, reason: collision with root package name */
    public transient int f18882d;

    /* renamed from: e, reason: collision with root package name */
    public transient int[] f18883e;

    /* renamed from: f, reason: collision with root package name */
    public transient long[] f18884f;

    /* renamed from: g, reason: collision with root package name */
    public transient float f18885g;

    /* renamed from: h, reason: collision with root package name */
    public transient int f18886h;

    public class a extends O.a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f18887a;

        /* renamed from: b, reason: collision with root package name */
        public int f18888b;

        public a(int i7) {
            this.f18887a = T.this.f18879a[i7];
            this.f18888b = i7;
        }

        @Override // k3.N.a
        public Object a() {
            return this.f18887a;
        }

        public void b() {
            int i7 = this.f18888b;
            if (i7 == -1 || i7 >= T.this.v() || !AbstractC1237k.a(this.f18887a, T.this.f18879a[this.f18888b])) {
                this.f18888b = T.this.l(this.f18887a);
            }
        }

        @Override // k3.N.a
        public int getCount() {
            b();
            int i7 = this.f18888b;
            if (i7 == -1) {
                return 0;
            }
            return T.this.f18880b[i7];
        }
    }

    public T() {
        m(3, 1.0f);
    }

    public static T a() {
        return new T();
    }

    public static T b(int i7) {
        return new T(i7);
    }

    public static int g(long j7) {
        return (int) (j7 >>> 32);
    }

    public static int i(long j7) {
        return (int) j7;
    }

    public static long[] o(int i7) {
        long[] jArr = new long[i7];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] p(int i7) {
        int[] iArr = new int[i7];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public static long w(long j7, int i7) {
        return (j7 & (-4294967296L)) | (4294967295L & i7);
    }

    public void c(int i7) {
        if (i7 > this.f18884f.length) {
            s(i7);
        }
        if (i7 >= this.f18886h) {
            u(Math.max(2, Integer.highestOneBit(i7 - 1) << 1));
        }
    }

    public int d() {
        return this.f18881c == 0 ? -1 : 0;
    }

    public int e(Object obj) {
        int iL = l(obj);
        if (iL == -1) {
            return 0;
        }
        return this.f18880b[iL];
    }

    public N.a f(int i7) {
        j3.o.o(i7, this.f18881c);
        return new a(i7);
    }

    public Object h(int i7) {
        j3.o.o(i7, this.f18881c);
        return this.f18879a[i7];
    }

    public int j(int i7) {
        j3.o.o(i7, this.f18881c);
        return this.f18880b[i7];
    }

    public final int k() {
        return this.f18883e.length - 1;
    }

    public int l(Object obj) {
        int iC = AbstractC1276s.c(obj);
        int i7 = this.f18883e[k() & iC];
        while (i7 != -1) {
            long j7 = this.f18884f[i7];
            if (g(j7) == iC && AbstractC1237k.a(obj, this.f18879a[i7])) {
                return i7;
            }
            i7 = i(j7);
        }
        return -1;
    }

    public void m(int i7, float f7) {
        j3.o.e(i7 >= 0, "Initial capacity must be non-negative");
        j3.o.e(f7 > 0.0f, "Illegal load factor");
        int iA = AbstractC1276s.a(i7, f7);
        this.f18883e = p(iA);
        this.f18885g = f7;
        this.f18879a = new Object[i7];
        this.f18880b = new int[i7];
        this.f18884f = o(i7);
        this.f18886h = Math.max(1, (int) (iA * f7));
    }

    public void n(int i7, Object obj, int i8, int i9) {
        this.f18884f[i7] = (i9 << 32) | 4294967295L;
        this.f18879a[i7] = obj;
        this.f18880b[i7] = i8;
    }

    public int q(int i7) {
        int i8 = i7 + 1;
        if (i8 < this.f18881c) {
            return i8;
        }
        return -1;
    }

    public int r(Object obj, int i7) {
        AbstractC1267i.c(i7, "count");
        long[] jArr = this.f18884f;
        Object[] objArr = this.f18879a;
        int[] iArr = this.f18880b;
        int iC = AbstractC1276s.c(obj);
        int iK = k() & iC;
        int i8 = this.f18881c;
        int[] iArr2 = this.f18883e;
        int i9 = iArr2[iK];
        if (i9 == -1) {
            iArr2[iK] = i8;
        } else {
            while (true) {
                long j7 = jArr[i9];
                if (g(j7) == iC && AbstractC1237k.a(obj, objArr[i9])) {
                    int i10 = iArr[i9];
                    iArr[i9] = i7;
                    return i10;
                }
                int i11 = i(j7);
                if (i11 == -1) {
                    jArr[i9] = w(j7, i8);
                    break;
                }
                i9 = i11;
            }
        }
        if (i8 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i12 = i8 + 1;
        t(i12);
        n(i8, obj, i7, iC);
        this.f18881c = i12;
        if (i8 >= this.f18886h) {
            u(this.f18883e.length * 2);
        }
        this.f18882d++;
        return 0;
    }

    public void s(int i7) {
        this.f18879a = Arrays.copyOf(this.f18879a, i7);
        this.f18880b = Arrays.copyOf(this.f18880b, i7);
        long[] jArr = this.f18884f;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i7);
        if (i7 > length) {
            Arrays.fill(jArrCopyOf, length, i7, -1L);
        }
        this.f18884f = jArrCopyOf;
    }

    public final void t(int i7) {
        int length = this.f18884f.length;
        if (i7 > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Integer.MAX_VALUE;
            }
            if (iMax != length) {
                s(iMax);
            }
        }
    }

    public final void u(int i7) {
        if (this.f18883e.length >= 1073741824) {
            this.f18886h = Integer.MAX_VALUE;
            return;
        }
        int i8 = ((int) (i7 * this.f18885g)) + 1;
        int[] iArrP = p(i7);
        long[] jArr = this.f18884f;
        int length = iArrP.length - 1;
        for (int i9 = 0; i9 < this.f18881c; i9++) {
            int iG = g(jArr[i9]);
            int i10 = iG & length;
            int i11 = iArrP[i10];
            iArrP[i10] = i9;
            jArr[i9] = (iG << 32) | (i11 & 4294967295L);
        }
        this.f18886h = i8;
        this.f18883e = iArrP;
    }

    public int v() {
        return this.f18881c;
    }

    public T(T t7) {
        m(t7.v(), 1.0f);
        int iD = t7.d();
        while (iD != -1) {
            r(t7.h(iD), t7.j(iD));
            iD = t7.q(iD);
        }
    }

    public T(int i7) {
        this(i7, 1.0f);
    }

    public T(int i7, float f7) {
        m(i7, f7);
    }
}
