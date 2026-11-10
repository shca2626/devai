package I0;

/* loaded from: classes.dex */
public interface E1 {

    public interface a {
        void a(D1 d12);
    }

    static int D(int i7) {
        return i7 & 24;
    }

    static int E(int i7) {
        return y(i7, 0, 0, 0);
    }

    static int N(int i7) {
        return i7 & 3584;
    }

    static int S(int i7) {
        return i7 & 7;
    }

    static int l(int i7, int i8, int i9, int i10, int i11, int i12) {
        return i7 | i8 | i9 | i10 | i11 | i12;
    }

    static int n(int i7) {
        return i7 & 384;
    }

    static boolean q(int i7, boolean z7) {
        int iS = S(i7);
        if (iS != 4) {
            return z7 && iS == 3;
        }
        return true;
    }

    static int v(int i7, int i8, int i9, int i10, int i11) {
        return l(i7, i8, i9, i10, i11, 0);
    }

    static int w(int i7) {
        return i7 & 64;
    }

    static int y(int i7, int i8, int i9, int i10) {
        return l(i7, i8, i9, 0, 128, i10);
    }

    static int z(int i7) {
        return i7 & 32;
    }

    int G();

    int b(B0.s sVar);

    String getName();

    int h();

    default void k() {
    }

    default void s(a aVar) {
    }
}
