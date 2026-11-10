package W5;

/* loaded from: classes.dex */
public final class T0 extends J {

    /* renamed from: n, reason: collision with root package name */
    public static final T0 f9128n = new T0();

    @Override // W5.J
    public void U(C5.i iVar, Runnable runnable) {
        X0 x02 = (X0) iVar.a(X0.f9131n);
        if (x02 == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        x02.f9132m = true;
    }

    @Override // W5.J
    public boolean V(C5.i iVar) {
        return false;
    }

    @Override // W5.J
    public J W(int i7, String str) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // W5.J
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
