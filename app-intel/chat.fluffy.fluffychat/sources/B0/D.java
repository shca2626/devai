package B0;

import B0.q;
import E0.U;
import android.os.Looper;
import android.view.Surface;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public interface D {

    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public static final b f343b = new a().e();

        /* renamed from: c, reason: collision with root package name */
        public static final String f344c = U.A0(0);

        /* renamed from: a, reason: collision with root package name */
        public final q f345a;

        public static final class a {

            /* renamed from: b, reason: collision with root package name */
            public static final int[] f346b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 33, 26, 34, 35, 27, 28, 29, 30, 32};

            /* renamed from: a, reason: collision with root package name */
            public final q.b f347a = new q.b();

            public a a(int i7) {
                this.f347a.a(i7);
                return this;
            }

            public a b(b bVar) {
                this.f347a.b(bVar.f345a);
                return this;
            }

            public a c(int... iArr) {
                this.f347a.c(iArr);
                return this;
            }

            public a d(int i7, boolean z7) {
                this.f347a.d(i7, z7);
                return this;
            }

            public b e() {
                return new b(this.f347a.e());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f345a.equals(((b) obj).f345a);
            }
            return false;
        }

        public int hashCode() {
            return this.f345a.hashCode();
        }

        public b(q qVar) {
            this.f345a = qVar;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final q f348a;

        public c(q qVar) {
            this.f348a = qVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.f348a.equals(((c) obj).f348a);
            }
            return false;
        }

        public int hashCode() {
            return this.f348a.hashCode();
        }
    }

    public static final class e {

        /* renamed from: k, reason: collision with root package name */
        public static final String f349k = U.A0(0);

        /* renamed from: l, reason: collision with root package name */
        public static final String f350l = U.A0(1);

        /* renamed from: m, reason: collision with root package name */
        public static final String f351m = U.A0(2);

        /* renamed from: n, reason: collision with root package name */
        public static final String f352n = U.A0(3);

        /* renamed from: o, reason: collision with root package name */
        public static final String f353o = U.A0(4);

        /* renamed from: p, reason: collision with root package name */
        public static final String f354p = U.A0(5);

        /* renamed from: q, reason: collision with root package name */
        public static final String f355q = U.A0(6);

        /* renamed from: a, reason: collision with root package name */
        public final Object f356a;

        /* renamed from: b, reason: collision with root package name */
        public final int f357b;

        /* renamed from: c, reason: collision with root package name */
        public final int f358c;

        /* renamed from: d, reason: collision with root package name */
        public final v f359d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f360e;

        /* renamed from: f, reason: collision with root package name */
        public final int f361f;

        /* renamed from: g, reason: collision with root package name */
        public final long f362g;

        /* renamed from: h, reason: collision with root package name */
        public final long f363h;

        /* renamed from: i, reason: collision with root package name */
        public final int f364i;

        /* renamed from: j, reason: collision with root package name */
        public final int f365j;

        public e(Object obj, int i7, v vVar, Object obj2, int i8, long j7, long j8, int i9, int i10) {
            j3.o.d(i7 >= 0);
            j3.o.d(i8 >= 0);
            this.f356a = obj;
            this.f357b = i7;
            this.f358c = i7;
            this.f359d = vVar;
            this.f360e = obj2;
            this.f361f = i8;
            this.f362g = j7;
            this.f363h = j8;
            this.f364i = i9;
            this.f365j = i10;
        }

        public boolean a(e eVar) {
            return this.f358c == eVar.f358c && this.f361f == eVar.f361f && this.f362g == eVar.f362g && this.f363h == eVar.f363h && this.f364i == eVar.f364i && this.f365j == eVar.f365j && Objects.equals(this.f359d, eVar.f359d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && e.class == obj.getClass()) {
                e eVar = (e) obj;
                if (a(eVar) && Objects.equals(this.f356a, eVar.f356a) && Objects.equals(this.f360e, eVar.f360e)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.f356a, Integer.valueOf(this.f358c), this.f359d, this.f360e, Integer.valueOf(this.f361f), Long.valueOf(this.f362g), Long.valueOf(this.f363h), Integer.valueOf(this.f364i), Integer.valueOf(this.f365j));
        }

        public String toString() {
            String str = "mediaItem=" + this.f358c + ", period=" + this.f361f + ", pos=" + this.f362g;
            if (this.f364i == -1) {
                return str;
            }
            return str + ", contentPos=" + this.f363h + ", adGroup=" + this.f364i + ", ad=" + this.f365j;
        }
    }

    void A(List list, boolean z7);

    void B(d dVar);

    boolean C();

    int D();

    int E();

    void F(K k7);

    void G(int i7, int i8);

    B H();

    void I(boolean z7);

    long J();

    void K(v vVar);

    boolean L();

    void M();

    int N();

    L P();

    boolean Q();

    boolean R();

    int S();

    int T();

    void U(int i7);

    void W(int i7, int i8);

    void X(int i7, int i8, int i9);

    boolean Y();

    int Z();

    void a();

    int a0();

    H b0();

    void c(C c7);

    Looper c0();

    boolean d0();

    void e();

    K e0();

    C f();

    void f0(C0300b c0300b, boolean z7);

    void g(float f7);

    long getDuration();

    void h();

    boolean h0();

    void i(long j7);

    long j();

    int k();

    long m();

    void n(Surface surface);

    boolean o();

    long p();

    void q(int i7, long j7);

    boolean r();

    void s(Surface surface);

    void stop();

    void t(boolean z7);

    void w(d dVar);

    int x();

    P y();

    void z();

    public interface d {
        default void j0() {
        }

        default void B(int i7) {
        }

        default void C(boolean z7) {
        }

        default void D(int i7) {
        }

        default void F(B b7) {
        }

        default void H(B b7) {
        }

        default void J(boolean z7) {
        }

        default void L(C0300b c0300b) {
        }

        default void O(float f7) {
        }

        default void P(b bVar) {
        }

        default void Q(int i7) {
        }

        default void V(boolean z7) {
        }

        default void W(C0312n c0312n) {
        }

        default void a(P p7) {
        }

        default void c(int i7) {
        }

        default void c0(x xVar) {
        }

        default void d(boolean z7) {
        }

        default void h0(int i7) {
        }

        default void i0(K k7) {
        }

        default void m(D0.c cVar) {
        }

        default void n0(L l7) {
        }

        default void r(List list) {
        }

        default void s(y yVar) {
        }

        default void u0(boolean z7) {
        }

        default void z(C c7) {
        }

        default void Y(D d7, c cVar) {
        }

        default void Z(int i7, boolean z7) {
        }

        default void a0(boolean z7, int i7) {
        }

        default void e0(v vVar, int i7) {
        }

        default void k0(H h7, int i7) {
        }

        default void m0(boolean z7, int i7) {
        }

        default void r0(int i7, int i8) {
        }

        default void g0(e eVar, e eVar2, int i7) {
        }
    }
}
