package c1;

import E0.U;
import c1.b;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class g implements b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f13874a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13875b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f13876c;

    /* renamed from: d, reason: collision with root package name */
    public int f13877d;

    /* renamed from: e, reason: collision with root package name */
    public int f13878e;

    /* renamed from: f, reason: collision with root package name */
    public int f13879f;

    /* renamed from: g, reason: collision with root package name */
    public C0899a[] f13880g;

    public g(boolean z7, int i7) {
        this(z7, i7, 0);
    }

    @Override // c1.b
    public synchronized void a(C0899a c0899a) {
        C0899a[] c0899aArr = this.f13880g;
        int i7 = this.f13879f;
        this.f13879f = i7 + 1;
        c0899aArr[i7] = c0899a;
        this.f13878e--;
        notifyAll();
    }

    @Override // c1.b
    public synchronized void b(b.a aVar) {
        while (aVar != null) {
            try {
                C0899a[] c0899aArr = this.f13880g;
                int i7 = this.f13879f;
                this.f13879f = i7 + 1;
                c0899aArr[i7] = aVar.a();
                this.f13878e--;
                aVar = aVar.next();
            } catch (Throwable th) {
                throw th;
            }
        }
        notifyAll();
    }

    @Override // c1.b
    public synchronized C0899a c() {
        C0899a c0899a;
        try {
            this.f13878e++;
            int i7 = this.f13879f;
            if (i7 > 0) {
                C0899a[] c0899aArr = this.f13880g;
                int i8 = i7 - 1;
                this.f13879f = i8;
                c0899a = (C0899a) j3.o.q(c0899aArr[i8]);
                this.f13880g[this.f13879f] = null;
            } else {
                c0899a = new C0899a(new byte[this.f13875b], 0);
                int i9 = this.f13878e;
                C0899a[] c0899aArr2 = this.f13880g;
                if (i9 > c0899aArr2.length) {
                    this.f13880g = (C0899a[]) Arrays.copyOf(c0899aArr2, c0899aArr2.length * 2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return c0899a;
    }

    @Override // c1.b
    public synchronized void d() {
        try {
            int i7 = 0;
            int iMax = Math.max(0, U.k(this.f13877d, this.f13875b) - this.f13878e);
            int i8 = this.f13879f;
            if (iMax >= i8) {
                return;
            }
            if (this.f13876c != null) {
                int i9 = i8 - 1;
                while (i7 <= i9) {
                    C0899a c0899a = (C0899a) j3.o.q(this.f13880g[i7]);
                    if (c0899a.f13863a == this.f13876c) {
                        i7++;
                    } else {
                        C0899a c0899a2 = (C0899a) j3.o.q(this.f13880g[i9]);
                        if (c0899a2.f13863a != this.f13876c) {
                            i9--;
                        } else {
                            C0899a[] c0899aArr = this.f13880g;
                            c0899aArr[i7] = c0899a2;
                            c0899aArr[i9] = c0899a;
                            i9--;
                            i7++;
                        }
                    }
                }
                iMax = Math.max(iMax, i7);
                if (iMax >= this.f13879f) {
                    return;
                }
            }
            Arrays.fill(this.f13880g, iMax, this.f13879f, (Object) null);
            this.f13879f = iMax;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // c1.b
    public int e() {
        return this.f13875b;
    }

    public synchronized void f() {
        if (this.f13874a) {
            g(0);
        }
    }

    public synchronized void g(int i7) {
        boolean z7 = i7 < this.f13877d;
        this.f13877d = i7;
        if (z7) {
            d();
        }
    }

    public g(boolean z7, int i7, int i8) {
        j3.o.d(i7 > 0);
        j3.o.d(i8 >= 0);
        this.f13874a = z7;
        this.f13875b = i7;
        this.f13879f = i8;
        this.f13880g = new C0899a[i8 + 100];
        if (i8 <= 0) {
            this.f13876c = null;
            return;
        }
        this.f13876c = new byte[i8 * i7];
        for (int i9 = 0; i9 < i8; i9++) {
            this.f13880g[i9] = new C0899a(this.f13876c, i9 * i7);
        }
    }
}
