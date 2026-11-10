package e1;

import android.view.Surface;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface P {

    public interface b {
        void a(long j7);

        void b();
    }

    public static final class c extends Exception {

        /* renamed from: l, reason: collision with root package name */
        public final B0.s f15366l;

        public c(Throwable th, B0.s sVar) {
            super(th);
            this.f15366l = sVar;
        }
    }

    boolean a();

    Surface b();

    void c();

    boolean d();

    void e(r rVar);

    void f();

    void g(long j7, long j8);

    void h(Surface surface, E0.F f7);

    void i(long j7);

    void j();

    void k(int i7);

    void l(float f7);

    void m();

    void n(boolean z7);

    void o(List list);

    boolean p(B0.s sVar);

    void q(boolean z7);

    boolean r(boolean z7);

    void release();

    void s(a aVar, Executor executor);

    void t();

    boolean u(long j7, b bVar);

    void v(int i7, B0.s sVar, long j7, int i8, List list);

    void w();

    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f15365a = new C0159a();

        /* renamed from: e1.P$a$a, reason: collision with other inner class name */
        public class C0159a implements a {
        }

        default void b() {
        }

        default void c() {
        }

        default void onFirstFrameRendered() {
        }

        default void a(B0.P p7) {
        }
    }
}
