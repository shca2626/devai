package W5;

import b6.C0881p;

/* loaded from: classes.dex */
public abstract class B0 extends C0881p implements InterfaceC0616d0, InterfaceC0645s0 {

    /* renamed from: o, reason: collision with root package name */
    public C0 f9084o;

    @Override // W5.InterfaceC0645s0
    public H0 b() {
        return null;
    }

    @Override // W5.InterfaceC0616d0
    public void dispose() {
        u().E0(this);
    }

    @Override // W5.InterfaceC0645s0
    public boolean e() {
        return true;
    }

    @Override // b6.C0881p
    public String toString() {
        return Q.a(this) + '@' + Q.b(this) + "[job@" + Q.b(u()) + ']';
    }

    public final C0 u() {
        C0 c02 = this.f9084o;
        if (c02 != null) {
            return c02;
        }
        M5.m.o("job");
        return null;
    }

    public abstract boolean v();

    public abstract void w(Throwable th);

    public final void x(C0 c02) {
        this.f9084o = c02;
    }
}
