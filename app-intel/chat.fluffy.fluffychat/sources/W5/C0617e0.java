package W5;

/* renamed from: W5.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0617e0 implements InterfaceC0630l {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0615d0 f9144a;

    public C0617e0(InterfaceC0615d0 interfaceC0615d0) {
        this.f9144a = interfaceC0615d0;
    }

    @Override // W5.InterfaceC0630l
    public void a(Throwable th) {
        this.f9144a.dispose();
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f9144a + ']';
    }
}
