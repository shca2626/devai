package W5;

/* renamed from: W5.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0618e0 implements InterfaceC0631l {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0616d0 f9144a;

    public C0618e0(InterfaceC0616d0 interfaceC0616d0) {
        this.f9144a = interfaceC0616d0;
    }

    @Override // W5.InterfaceC0631l
    public void a(Throwable th) {
        this.f9144a.dispose();
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f9144a + ']';
    }
}
