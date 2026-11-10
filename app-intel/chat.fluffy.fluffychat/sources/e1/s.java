package e1;

import E0.InterfaceC0321g;
import E0.U;
import android.content.Context;
import android.view.Surface;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final b f15544a;

    /* renamed from: b, reason: collision with root package name */
    public final u f15545b;

    /* renamed from: c, reason: collision with root package name */
    public final long f15546c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15547d;

    /* renamed from: g, reason: collision with root package name */
    public long f15550g;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15553j;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15556m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15557n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f15558o;

    /* renamed from: e, reason: collision with root package name */
    public int f15548e = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f15549f = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    public long f15551h = -9223372036854775807L;

    /* renamed from: i, reason: collision with root package name */
    public long f15552i = -9223372036854775807L;

    /* renamed from: k, reason: collision with root package name */
    public float f15554k = 1.0f;

    /* renamed from: l, reason: collision with root package name */
    public InterfaceC0321g f15555l = InterfaceC0321g.f2159a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f15559a = -9223372036854775807L;

        /* renamed from: b, reason: collision with root package name */
        public long f15560b = -9223372036854775807L;

        public long f() {
            return this.f15559a;
        }

        public long g() {
            return this.f15560b;
        }

        public final void h() {
            this.f15559a = -9223372036854775807L;
            this.f15560b = -9223372036854775807L;
        }
    }

    public interface b {
        boolean C(long j7, long j8, boolean z7);

        boolean O(long j7, long j8);

        boolean j(long j7, long j8, long j9, boolean z7, boolean z8);
    }

    public s(Context context, b bVar, long j7) {
        this.f15544a = bVar;
        this.f15546c = j7;
        this.f15545b = new u(context);
    }

    public void a() {
        if (this.f15548e == 0) {
            this.f15548e = 1;
        }
    }

    public final long b(long j7, long j8, long j9) {
        long j10 = (long) ((j9 - j7) / this.f15554k);
        return this.f15547d ? j10 - (U.P0(this.f15555l.e()) - j8) : j10;
    }

    public int c(long j7, long j8, long j9, long j10, boolean z7, boolean z8, a aVar) {
        aVar.h();
        if (this.f15547d && this.f15549f == -9223372036854775807L) {
            this.f15549f = j8;
        }
        if (this.f15551h != j7) {
            this.f15545b.f(j7);
            this.f15551h = j7;
        }
        aVar.f15559a = b(j8, j9, j7);
        if (z7 && !z8) {
            return 3;
        }
        if (!this.f15556m) {
            if (this.f15544a.j(aVar.f15559a, j8, j9, z8, true)) {
                return 4;
            }
            if (this.f15547d && aVar.f15559a < 30000) {
                return 3;
            }
            this.f15557n = true;
            return 5;
        }
        if (q(j8, aVar.f15559a, j10)) {
            return 0;
        }
        if (!this.f15547d || j8 == this.f15549f) {
            return 5;
        }
        long jF = this.f15555l.f();
        aVar.f15560b = this.f15545b.a((aVar.f15559a * 1000) + jF, j7);
        aVar.f15559a = (aVar.f15560b - jF) / 1000;
        boolean z9 = (this.f15552i == -9223372036854775807L || this.f15553j) ? false : true;
        if (this.f15544a.j(aVar.f15559a, j8, j9, z8, z9)) {
            return 4;
        }
        return this.f15544a.C(aVar.f15559a, j9, z8) ? z9 ? 3 : 2 : aVar.f15559a > 50000 ? 5 : 1;
    }

    public boolean d(boolean z7) {
        if (z7 && (this.f15548e == 3 || (!this.f15556m && this.f15557n))) {
            this.f15552i = -9223372036854775807L;
            return true;
        }
        if (this.f15552i == -9223372036854775807L) {
            return false;
        }
        if (this.f15555l.e() < this.f15552i) {
            return true;
        }
        this.f15552i = -9223372036854775807L;
        return false;
    }

    public void e(boolean z7) {
        this.f15553j = z7;
        this.f15552i = this.f15546c > 0 ? this.f15555l.e() + this.f15546c : -9223372036854775807L;
    }

    public final void f(int i7) {
        this.f15548e = Math.min(this.f15548e, i7);
    }

    public boolean g() {
        boolean z7 = this.f15548e != 3;
        this.f15548e = 3;
        this.f15550g = U.P0(this.f15555l.e());
        return z7;
    }

    public void h() {
        this.f15547d = true;
        this.f15550g = U.P0(this.f15555l.e());
        this.f15545b.i();
    }

    public void i() {
        this.f15547d = false;
        this.f15552i = -9223372036854775807L;
        this.f15545b.j();
    }

    public void j(int i7) {
        if (i7 == 0) {
            this.f15548e = 1;
        } else if (i7 == 1) {
            this.f15548e = 0;
        } else {
            if (i7 != 2) {
                throw new IllegalStateException();
            }
            f(2);
        }
        this.f15545b.h();
    }

    public void k() {
        this.f15545b.h();
        this.f15551h = -9223372036854775807L;
        this.f15549f = -9223372036854775807L;
        f(1);
        this.f15552i = -9223372036854775807L;
    }

    public void l(int i7) {
        this.f15545b.m(i7);
    }

    public void m(InterfaceC0321g interfaceC0321g) {
        this.f15555l = interfaceC0321g;
    }

    public void n(float f7) {
        this.f15545b.e(f7);
    }

    public void o(Surface surface) {
        this.f15556m = surface != null;
        this.f15557n = false;
        this.f15545b.k(surface);
        f(1);
    }

    public void p(float f7) {
        j3.o.d(f7 > 0.0f);
        if (f7 == this.f15554k) {
            return;
        }
        this.f15554k = f7;
        this.f15545b.g(f7);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(long r8, long r10, long r12) {
        /*
            r7 = this;
            long r0 = r7.f15552i
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            if (r0 == 0) goto L11
            boolean r0 = r7.f15553j
            if (r0 != 0) goto L11
            return r1
        L11:
            int r0 = r7.f15548e
            if (r0 == 0) goto L54
            r4 = 1
            if (r0 == r4) goto L53
            r5 = 2
            if (r0 == r5) goto L4d
            r12 = 3
            if (r0 != r12) goto L47
            E0.g r12 = r7.f15555l
            long r12 = r12.e()
            long r12 = E0.U.P0(r12)
            long r5 = r7.f15550g
            long r12 = r12 - r5
            boolean r0 = r7.f15547d
            if (r0 == 0) goto L46
            boolean r0 = r7.f15558o
            if (r0 != 0) goto L3d
            long r5 = r7.f15549f
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 == 0) goto L46
            int r8 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r8 == 0) goto L46
        L3d:
            e1.s$b r8 = r7.f15544a
            boolean r8 = r8.O(r10, r12)
            if (r8 == 0) goto L46
            return r4
        L46:
            return r1
        L47:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L4d:
            int r8 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r8 < 0) goto L52
            return r4
        L52:
            return r1
        L53:
            return r4
        L54:
            boolean r8 = r7.f15547d
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.s.q(long, long, long):boolean");
    }
}
