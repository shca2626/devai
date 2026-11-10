package g1;

import E0.C0333t;
import g1.N;

/* loaded from: classes.dex */
public final class I implements N {

    /* renamed from: a, reason: collision with root package name */
    public final C0333t f15948a;

    /* renamed from: b, reason: collision with root package name */
    public final C0333t f15949b;

    /* renamed from: c, reason: collision with root package name */
    public long f15950c;

    public I(long[] jArr, long[] jArr2, long j7) {
        j3.o.d(jArr.length == jArr2.length);
        int length = jArr2.length;
        if (length <= 0 || jArr2[0] <= 0) {
            this.f15948a = new C0333t(length);
            this.f15949b = new C0333t(length);
        } else {
            int i7 = length + 1;
            C0333t c0333t = new C0333t(i7);
            this.f15948a = c0333t;
            C0333t c0333t2 = new C0333t(i7);
            this.f15949b = c0333t2;
            c0333t.a(0L);
            c0333t2.a(0L);
        }
        this.f15948a.b(jArr);
        this.f15949b.b(jArr2);
        this.f15950c = j7;
    }

    public long a(long j7) {
        if (this.f15949b.d() == 0) {
            return -9223372036854775807L;
        }
        return this.f15949b.c(E0.U.e(this.f15948a, j7, true, true));
    }

    public void b(long j7, long j8) {
        if (this.f15949b.d() == 0 && j7 > 0) {
            this.f15948a.a(0L);
            this.f15949b.a(0L);
        }
        this.f15948a.a(j8);
        this.f15949b.a(j7);
    }

    @Override // g1.N
    public boolean e() {
        return this.f15949b.d() > 0;
    }

    @Override // g1.N
    public N.a g(long j7) {
        if (this.f15949b.d() == 0) {
            return new N.a(O.f15970c);
        }
        int iE = E0.U.e(this.f15949b, j7, true, true);
        O o7 = new O(this.f15949b.c(iE), this.f15948a.c(iE));
        if (o7.f15971a == j7 || iE == this.f15949b.d() - 1) {
            return new N.a(o7);
        }
        int i7 = iE + 1;
        return new N.a(o7, new O(this.f15949b.c(i7), this.f15948a.c(i7)));
    }

    @Override // g1.N
    public long i() {
        return this.f15950c;
    }

    public boolean j(long j7, long j8) {
        if (this.f15949b.d() == 0) {
            return false;
        }
        C0333t c0333t = this.f15949b;
        return j7 - c0333t.c(c0333t.d() - 1) < j8;
    }

    public void k(long j7) {
        this.f15950c = j7;
    }
}
