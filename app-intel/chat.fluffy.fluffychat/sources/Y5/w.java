package Y5;

/* loaded from: classes.dex */
public interface w {
    static /* synthetic */ boolean g(w wVar, Throwable th, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
        if ((i7 & 1) != 0) {
            th = null;
        }
        return wVar.k(th);
    }

    boolean k(Throwable th);

    void m(L5.l lVar);

    Object q(Object obj);

    boolean v();

    Object w(Object obj, C5.e eVar);
}
