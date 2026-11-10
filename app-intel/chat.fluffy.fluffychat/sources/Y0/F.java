package Y0;

import D1.s;
import J0.G1;
import android.os.Handler;

/* loaded from: classes.dex */
public interface F {

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Object f9398a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9399b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9400c;

        /* renamed from: d, reason: collision with root package name */
        public final long f9401d;

        /* renamed from: e, reason: collision with root package name */
        public final int f9402e;

        public b(Object obj) {
            this(obj, -1L);
        }

        public b a(Object obj) {
            return this.f9398a.equals(obj) ? this : new b(obj, this.f9399b, this.f9400c, this.f9401d, this.f9402e);
        }

        public boolean b() {
            return this.f9399b != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f9398a.equals(bVar.f9398a) && this.f9399b == bVar.f9399b && this.f9400c == bVar.f9400c && this.f9401d == bVar.f9401d && this.f9402e == bVar.f9402e;
        }

        public int hashCode() {
            return ((((((((527 + this.f9398a.hashCode()) * 31) + this.f9399b) * 31) + this.f9400c) * 31) + ((int) this.f9401d)) * 31) + this.f9402e;
        }

        public b(Object obj, long j7) {
            this(obj, -1, -1, j7, -1);
        }

        public b(Object obj, long j7, int i7) {
            this(obj, -1, -1, j7, i7);
        }

        public b(Object obj, int i7, int i8, long j7) {
            this(obj, i7, i8, j7, -1);
        }

        public b(Object obj, int i7, int i8, long j7, int i9) {
            this.f9398a = obj;
            this.f9399b = i7;
            this.f9400c = i8;
            this.f9401d = j7;
            this.f9402e = i9;
        }
    }

    public interface c {
        void a(F f7, B0.H h7);
    }

    void b(Handler handler, N n7);

    void c(c cVar);

    void d(c cVar);

    void e(Handler handler, N0.t tVar);

    E g(b bVar, c1.b bVar2, long j7);

    void h(c cVar);

    B0.v j();

    void k();

    default boolean m() {
        return true;
    }

    default B0.H n() {
        return null;
    }

    void o(N n7);

    void p(N0.t tVar);

    void s(E e7);

    void u(c cVar, G0.x xVar, G1 g12);

    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f9397a = O.f9430b;

        F d(B0.v vVar);

        a f(c1.k kVar);

        a g(N0.w wVar);

        default a a(s.a aVar) {
            return this;
        }

        default a b(boolean z7) {
            return this;
        }

        default a c(int i7) {
            return this;
        }

        default a e(j3.u uVar) {
            return this;
        }
    }

    default void a(B0.v vVar) {
    }
}
