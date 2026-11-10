package I0;

import E0.InterfaceC0321g;
import I0.B1;
import Y0.F;

/* loaded from: classes.dex */
public interface D1 extends B1.b {

    public interface a {
        void a();

        void b();
    }

    E1 A();

    void H(F1 f12, B0.s[] sVarArr, Y0.e0 e0Var, long j7, boolean z7, boolean z8, long j8, long j9, F.b bVar);

    Y0.e0 J();

    void K(int i7, J0.G1 g12, InterfaceC0321g interfaceC0321g);

    void L();

    long M();

    boolean P();

    default boolean Q(long j7) {
        return false;
    }

    InterfaceC0364e1 R();

    void a();

    boolean d();

    boolean e();

    void g(long j7, long j8);

    String getName();

    int getState();

    int h();

    boolean m();

    default long o(long j7, long j8) {
        if (getState() == 1) {
            return (e() || d()) ? 1000000L : 10000L;
        }
        return 10000L;
    }

    void p(B0.s[] sVarArr, Y0.e0 e0Var, long j7, long j8, F.b bVar);

    void r(B0.H h7);

    void reset();

    void start();

    void stop();

    void u();

    void x(long j7, boolean z7);

    default void release() {
    }

    default void t() {
    }

    default void B(float f7, float f8) {
    }
}
