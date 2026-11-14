package b1;

import B0.H;
import B0.I;
import E0.AbstractC0333s;
import Y0.F;
import java.util.List;

/* loaded from: classes.dex */
public interface y extends InterfaceC0826C {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final I f13703a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f13704b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13705c;

        public a(I i7, int... iArr) {
            this(i7, iArr, 0);
        }

        public a(I i7, int[] iArr, int i8) {
            if (iArr.length == 0) {
                AbstractC0333s.d("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.f13703a = i7;
            this.f13704b = iArr;
            this.f13705c = i8;
        }
    }

    public interface b {
        y[] a(a[] aVarArr, c1.d dVar, F.b bVar, H h7);
    }

    void a();

    boolean b(int i7, long j7);

    int d();

    default boolean e(long j7, Z0.f fVar, List list) {
        return false;
    }

    void f(boolean z7);

    void h();

    int j(long j7, List list);

    int k();

    B0.s m();

    int n();

    boolean o(int i7, long j7);

    void p(long j7, long j8, long j9, List list, Z0.o[] oVarArr);

    void q(float f7);

    Object r();

    default void s() {
    }

    default void t() {
    }
}
