package W5;

/* loaded from: classes.dex */
public final class Y extends Exception {

    /* renamed from: l, reason: collision with root package name */
    public final Throwable f9133l;

    public Y(Throwable th, J j7, C5.i iVar) {
        super("Coroutine dispatcher " + j7 + " threw an exception, context = " + iVar, th);
        this.f9133l = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f9133l;
    }
}
