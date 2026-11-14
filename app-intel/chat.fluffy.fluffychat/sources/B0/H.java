package B0;

import B0.C0300a;
import B0.v;
import E0.U;
import android.net.Uri;
import android.util.Pair;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class H {

    /* renamed from: a, reason: collision with root package name */
    public static final H f375a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final String f376b = U.A0(0);

    /* renamed from: c, reason: collision with root package name */
    public static final String f377c = U.A0(1);

    /* renamed from: d, reason: collision with root package name */
    public static final String f378d = U.A0(2);

    public class a extends H {
        @Override // B0.H
        public int b(Object obj) {
            return -1;
        }

        @Override // B0.H
        public b g(int i7, b bVar, boolean z7) {
            throw new IndexOutOfBoundsException();
        }

        @Override // B0.H
        public int i() {
            return 0;
        }

        @Override // B0.H
        public Object m(int i7) {
            throw new IndexOutOfBoundsException();
        }

        @Override // B0.H
        public c o(int i7, c cVar, long j7) {
            throw new IndexOutOfBoundsException();
        }

        @Override // B0.H
        public int p() {
            return 0;
        }
    }

    public static final class b {

        /* renamed from: h, reason: collision with root package name */
        public static final String f379h = U.A0(0);

        /* renamed from: i, reason: collision with root package name */
        public static final String f380i = U.A0(1);

        /* renamed from: j, reason: collision with root package name */
        public static final String f381j = U.A0(2);

        /* renamed from: k, reason: collision with root package name */
        public static final String f382k = U.A0(3);

        /* renamed from: l, reason: collision with root package name */
        public static final String f383l = U.A0(4);

        /* renamed from: a, reason: collision with root package name */
        public Object f384a;

        /* renamed from: b, reason: collision with root package name */
        public Object f385b;

        /* renamed from: c, reason: collision with root package name */
        public int f386c;

        /* renamed from: d, reason: collision with root package name */
        public long f387d;

        /* renamed from: e, reason: collision with root package name */
        public long f388e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f389f;

        /* renamed from: g, reason: collision with root package name */
        public C0300a f390g = C0300a.f576g;

        public int a(int i7) {
            return this.f390g.a(i7).f601b;
        }

        public long b(int i7, int i8) {
            C0300a.C0008a c0008aA = this.f390g.a(i7);
            if (c0008aA.f601b != -1) {
                return c0008aA.f606g[i8];
            }
            return -9223372036854775807L;
        }

        public int c() {
            return this.f390g.f583b;
        }

        public int d(long j7) {
            return this.f390g.b(j7, this.f387d);
        }

        public int e(long j7) {
            return this.f390g.c(j7, this.f387d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class.equals(obj.getClass())) {
                b bVar = (b) obj;
                if (Objects.equals(this.f384a, bVar.f384a) && Objects.equals(this.f385b, bVar.f385b) && this.f386c == bVar.f386c && this.f387d == bVar.f387d && this.f388e == bVar.f388e && this.f389f == bVar.f389f && Objects.equals(this.f390g, bVar.f390g)) {
                    return true;
                }
            }
            return false;
        }

        public long f(int i7) {
            return this.f390g.a(i7).f600a;
        }

        public long g() {
            return this.f390g.f584c;
        }

        public int h(int i7, int i8) {
            C0300a.C0008a c0008aA = this.f390g.a(i7);
            if (c0008aA.f601b != -1) {
                return c0008aA.f605f[i8];
            }
            return 0;
        }

        public int hashCode() {
            Object obj = this.f384a;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f385b;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f386c) * 31;
            long j7 = this.f387d;
            int i7 = (iHashCode2 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
            long j8 = this.f388e;
            return ((((i7 + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.f389f ? 1 : 0)) * 31) + this.f390g.hashCode();
        }

        public long i(int i7) {
            return this.f390g.a(i7).f609j;
        }

        public long j() {
            return U.s1(this.f387d);
        }

        public long k() {
            return this.f387d;
        }

        public int l(int i7) {
            return this.f390g.a(i7).d();
        }

        public int m(int i7, int i8) {
            return this.f390g.a(i7).e(i8);
        }

        public long n() {
            return U.s1(this.f388e);
        }

        public long o() {
            return this.f388e;
        }

        public int p() {
            return this.f390g.f586e;
        }

        public boolean q(int i7) {
            return !this.f390g.a(i7).f();
        }

        public boolean r(int i7) {
            return i7 == c() - 1 && this.f390g.d(i7);
        }

        public boolean s(int i7) {
            return this.f390g.a(i7).f610k;
        }

        public b t(Object obj, Object obj2, int i7, long j7, long j8) {
            return u(obj, obj2, i7, j7, j8, C0300a.f576g, false);
        }

        public b u(Object obj, Object obj2, int i7, long j7, long j8, C0300a c0300a, boolean z7) {
            this.f384a = obj;
            this.f385b = obj2;
            this.f386c = i7;
            this.f387d = j7;
            this.f388e = j8;
            this.f390g = c0300a;
            this.f389f = z7;
            return this;
        }
    }

    public static final class c {

        /* renamed from: b, reason: collision with root package name */
        public Object f408b;

        /* renamed from: d, reason: collision with root package name */
        public Object f410d;

        /* renamed from: e, reason: collision with root package name */
        public long f411e;

        /* renamed from: f, reason: collision with root package name */
        public long f412f;

        /* renamed from: g, reason: collision with root package name */
        public long f413g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f414h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f415i;

        /* renamed from: j, reason: collision with root package name */
        public v.g f416j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f417k;

        /* renamed from: l, reason: collision with root package name */
        public long f418l;

        /* renamed from: m, reason: collision with root package name */
        public long f419m;

        /* renamed from: n, reason: collision with root package name */
        public int f420n;

        /* renamed from: o, reason: collision with root package name */
        public int f421o;

        /* renamed from: p, reason: collision with root package name */
        public long f422p;

        /* renamed from: q, reason: collision with root package name */
        public static final Object f397q = new Object();

        /* renamed from: r, reason: collision with root package name */
        public static final Object f398r = new Object();

        /* renamed from: s, reason: collision with root package name */
        public static final v f399s = new v.c().c("androidx.media3.common.Timeline").g(Uri.EMPTY).a();

        /* renamed from: t, reason: collision with root package name */
        public static final String f400t = U.A0(1);

        /* renamed from: u, reason: collision with root package name */
        public static final String f401u = U.A0(2);

        /* renamed from: v, reason: collision with root package name */
        public static final String f402v = U.A0(3);

        /* renamed from: w, reason: collision with root package name */
        public static final String f403w = U.A0(4);

        /* renamed from: x, reason: collision with root package name */
        public static final String f404x = U.A0(5);

        /* renamed from: y, reason: collision with root package name */
        public static final String f405y = U.A0(6);

        /* renamed from: z, reason: collision with root package name */
        public static final String f406z = U.A0(7);

        /* renamed from: A, reason: collision with root package name */
        public static final String f391A = U.A0(8);

        /* renamed from: B, reason: collision with root package name */
        public static final String f392B = U.A0(9);

        /* renamed from: C, reason: collision with root package name */
        public static final String f393C = U.A0(10);

        /* renamed from: D, reason: collision with root package name */
        public static final String f394D = U.A0(11);

        /* renamed from: E, reason: collision with root package name */
        public static final String f395E = U.A0(12);

        /* renamed from: F, reason: collision with root package name */
        public static final String f396F = U.A0(13);

        /* renamed from: a, reason: collision with root package name */
        public Object f407a = f397q;

        /* renamed from: c, reason: collision with root package name */
        public v f409c = f399s;

        public long a() {
            return U.h0(this.f413g);
        }

        public long b() {
            return U.s1(this.f418l);
        }

        public long c() {
            return this.f418l;
        }

        public long d() {
            return U.s1(this.f419m);
        }

        public long e() {
            return this.f422p;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class.equals(obj.getClass())) {
                c cVar = (c) obj;
                if (Objects.equals(this.f407a, cVar.f407a) && Objects.equals(this.f409c, cVar.f409c) && Objects.equals(this.f410d, cVar.f410d) && Objects.equals(this.f416j, cVar.f416j) && this.f411e == cVar.f411e && this.f412f == cVar.f412f && this.f413g == cVar.f413g && this.f414h == cVar.f414h && this.f415i == cVar.f415i && this.f417k == cVar.f417k && this.f418l == cVar.f418l && this.f419m == cVar.f419m && this.f420n == cVar.f420n && this.f421o == cVar.f421o && this.f422p == cVar.f422p) {
                    return true;
                }
            }
            return false;
        }

        public boolean f() {
            return this.f416j != null;
        }

        public c g(Object obj, v vVar, Object obj2, long j7, long j8, long j9, boolean z7, boolean z8, v.g gVar, long j10, long j11, int i7, int i8, long j12) {
            v.h hVar;
            this.f407a = obj;
            this.f409c = vVar != null ? vVar : f399s;
            this.f408b = (vVar == null || (hVar = vVar.f827b) == null) ? null : hVar.f929h;
            this.f410d = obj2;
            this.f411e = j7;
            this.f412f = j8;
            this.f413g = j9;
            this.f414h = z7;
            this.f415i = z8;
            this.f416j = gVar;
            this.f418l = j10;
            this.f419m = j11;
            this.f420n = i7;
            this.f421o = i8;
            this.f422p = j12;
            this.f417k = false;
            return this;
        }

        public int hashCode() {
            int iHashCode = (((217 + this.f407a.hashCode()) * 31) + this.f409c.hashCode()) * 31;
            Object obj = this.f410d;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            v.g gVar = this.f416j;
            int iHashCode3 = (iHashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
            long j7 = this.f411e;
            int i7 = (iHashCode3 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
            long j8 = this.f412f;
            int i8 = (i7 + ((int) (j8 ^ (j8 >>> 32)))) * 31;
            long j9 = this.f413g;
            int i9 = (((((((i8 + ((int) (j9 ^ (j9 >>> 32)))) * 31) + (this.f414h ? 1 : 0)) * 31) + (this.f415i ? 1 : 0)) * 31) + (this.f417k ? 1 : 0)) * 31;
            long j10 = this.f418l;
            int i10 = (i9 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.f419m;
            int i11 = (((((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.f420n) * 31) + this.f421o) * 31;
            long j12 = this.f422p;
            return i11 + ((int) (j12 ^ (j12 >>> 32)));
        }
    }

    public int a(boolean z7) {
        return q() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z7) {
        if (q()) {
            return -1;
        }
        return p() - 1;
    }

    public final int d(int i7, b bVar, c cVar, int i8, boolean z7) {
        int i9 = f(i7, bVar).f386c;
        if (n(i9, cVar).f421o != i7) {
            return i7 + 1;
        }
        int iE = e(i9, i8, z7);
        if (iE == -1) {
            return -1;
        }
        return n(iE, cVar).f420n;
    }

    public int e(int i7, int i8, boolean z7) {
        if (i8 == 0) {
            if (i7 == c(z7)) {
                return -1;
            }
            return i7 + 1;
        }
        if (i8 == 1) {
            return i7;
        }
        if (i8 == 2) {
            return i7 == c(z7) ? a(z7) : i7 + 1;
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        int iC;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H)) {
            return false;
        }
        H h7 = (H) obj;
        if (h7.p() != p() || h7.i() != i()) {
            return false;
        }
        c cVar = new c();
        b bVar = new b();
        c cVar2 = new c();
        b bVar2 = new b();
        for (int i7 = 0; i7 < p(); i7++) {
            if (!n(i7, cVar).equals(h7.n(i7, cVar2))) {
                return false;
            }
        }
        for (int i8 = 0; i8 < i(); i8++) {
            if (!g(i8, bVar, true).equals(h7.g(i8, bVar2, true))) {
                return false;
            }
        }
        int iA = a(true);
        if (iA != h7.a(true) || (iC = c(true)) != h7.c(true)) {
            return false;
        }
        while (iA != iC) {
            int iE = e(iA, 0, true);
            if (iE != h7.e(iA, 0, true)) {
                return false;
            }
            iA = iE;
        }
        return true;
    }

    public final b f(int i7, b bVar) {
        return g(i7, bVar, false);
    }

    public abstract b g(int i7, b bVar, boolean z7);

    public b h(Object obj, b bVar) {
        return g(b(obj), bVar, true);
    }

    public int hashCode() {
        c cVar = new c();
        b bVar = new b();
        int iP = 217 + p();
        for (int i7 = 0; i7 < p(); i7++) {
            iP = (iP * 31) + n(i7, cVar).hashCode();
        }
        int i8 = (iP * 31) + i();
        for (int i9 = 0; i9 < i(); i9++) {
            i8 = (i8 * 31) + g(i9, bVar, true).hashCode();
        }
        int iA = a(true);
        while (iA != -1) {
            i8 = (i8 * 31) + iA;
            iA = e(iA, 0, true);
        }
        return i8;
    }

    public abstract int i();

    public final Pair j(c cVar, b bVar, int i7, long j7) {
        return (Pair) j3.o.q(k(cVar, bVar, i7, j7, 0L));
    }

    public final Pair k(c cVar, b bVar, int i7, long j7, long j8) {
        j3.o.o(i7, p());
        o(i7, cVar, j8);
        if (j7 == -9223372036854775807L) {
            j7 = cVar.c();
            if (j7 == -9223372036854775807L) {
                return null;
            }
        }
        int i8 = cVar.f420n;
        f(i8, bVar);
        while (i8 < cVar.f421o && bVar.f388e != j7) {
            int i9 = i8 + 1;
            if (f(i9, bVar).f388e > j7) {
                break;
            }
            i8 = i9;
        }
        g(i8, bVar, true);
        long jMin = j7 - bVar.f388e;
        long j9 = bVar.f387d;
        if (j9 != -9223372036854775807L) {
            jMin = Math.min(jMin, j9 - 1);
        }
        return Pair.create(j3.o.q(bVar.f385b), Long.valueOf(Math.max(0L, jMin)));
    }

    public int l(int i7, int i8, boolean z7) {
        if (i8 == 0) {
            if (i7 == a(z7)) {
                return -1;
            }
            return i7 - 1;
        }
        if (i8 == 1) {
            return i7;
        }
        if (i8 == 2) {
            return i7 == a(z7) ? c(z7) : i7 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object m(int i7);

    public final c n(int i7, c cVar) {
        return o(i7, cVar, 0L);
    }

    public abstract c o(int i7, c cVar, long j7);

    public abstract int p();

    public final boolean q() {
        return p() == 0;
    }

    public final boolean r(int i7, b bVar, c cVar, int i8, boolean z7) {
        return d(i7, bVar, cVar, i8, z7) == -1;
    }
}
