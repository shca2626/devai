package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public abstract class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f12061a = 100;

    public abstract void a(Object obj, int i7, int i8);

    public abstract void b(Object obj, int i7, long j7);

    public abstract void c(Object obj, int i7, Object obj2);

    public abstract void d(Object obj, int i7, AbstractC0775f abstractC0775f);

    public abstract void e(Object obj, int i7, long j7);

    public abstract Object f(Object obj);

    public abstract Object g(Object obj);

    public abstract int h(Object obj);

    public abstract int i(Object obj);

    public abstract void j(Object obj);

    public abstract Object k(Object obj, Object obj2);

    public final void l(Object obj, Y y7, int i7) {
        while (y7.z() != Integer.MAX_VALUE && m(obj, y7, i7)) {
        }
    }

    public final boolean m(Object obj, Y y7, int i7) throws C0790v {
        int iT = y7.t();
        int iA = l0.a(iT);
        int iB = l0.b(iT);
        if (iB == 0) {
            e(obj, iA, y7.L());
            return true;
        }
        if (iB == 1) {
            b(obj, iA, y7.c());
            return true;
        }
        if (iB == 2) {
            d(obj, iA, y7.C());
            return true;
        }
        if (iB != 3) {
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw C0790v.e();
            }
            a(obj, iA, y7.g());
            return true;
        }
        Object objN = n();
        int iC = l0.c(iA, 4);
        int i8 = i7 + 1;
        if (i8 >= f12061a) {
            throw C0790v.i();
        }
        l(objN, y7, i8);
        if (iC != y7.t()) {
            throw C0790v.b();
        }
        c(obj, iA, r(objN));
        return true;
    }

    public abstract Object n();

    public abstract void o(Object obj, Object obj2);

    public abstract void p(Object obj, Object obj2);

    public abstract boolean q(Y y7);

    public abstract Object r(Object obj);

    public abstract void s(Object obj, m0 m0Var);

    public abstract void t(Object obj, m0 m0Var);
}
