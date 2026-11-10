package E5;

/* loaded from: classes.dex */
public final class c implements C5.e {

    /* renamed from: l, reason: collision with root package name */
    public static final c f2374l = new c();

    @Override // C5.e
    public C5.i getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // C5.e
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
