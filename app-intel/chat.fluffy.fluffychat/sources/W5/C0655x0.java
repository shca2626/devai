package W5;

import java.util.concurrent.CancellationException;

/* renamed from: W5.x0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0655x0 extends CancellationException {

    /* renamed from: l, reason: collision with root package name */
    public final transient InterfaceC0653w0 f9182l;

    public C0655x0(String str, Throwable th, InterfaceC0653w0 interfaceC0653w0) {
        super(str);
        this.f9182l = interfaceC0653w0;
        if (th != null) {
            initCause(th);
        }
    }

    public final InterfaceC0653w0 a() {
        InterfaceC0653w0 interfaceC0653w0 = this.f9182l;
        return interfaceC0653w0 == null ? I0.f9107m : interfaceC0653w0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0655x0)) {
            return false;
        }
        C0655x0 c0655x0 = (C0655x0) obj;
        return M5.m.a(c0655x0.getMessage(), getMessage()) && M5.m.a(c0655x0.a(), a()) && M5.m.a(c0655x0.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        M5.m.b(message);
        int iHashCode = ((message.hashCode() * 31) + a().hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + a();
    }
}
