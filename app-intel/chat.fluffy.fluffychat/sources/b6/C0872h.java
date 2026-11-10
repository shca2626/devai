package b6;

/* renamed from: b6.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0872h extends RuntimeException {

    /* renamed from: l, reason: collision with root package name */
    public final transient C5.i f13780l;

    public C0872h(C5.i iVar) {
        this.f13780l = iVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return String.valueOf(this.f13780l);
    }
}
