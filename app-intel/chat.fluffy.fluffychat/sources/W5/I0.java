package W5;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class I0 extends C5.a implements InterfaceC0653w0 {

    /* renamed from: m, reason: collision with root package name */
    public static final I0 f9107m = new I0();

    public I0() {
        super(InterfaceC0653w0.f9180d);
    }

    @Override // W5.InterfaceC0653w0
    public InterfaceC0616d0 E(boolean z7, boolean z8, L5.l lVar) {
        return J0.f9109l;
    }

    @Override // W5.InterfaceC0653w0
    public InterfaceC0616d0 N(L5.l lVar) {
        return J0.f9109l;
    }

    @Override // W5.InterfaceC0653w0
    public boolean e() {
        return true;
    }

    @Override // W5.InterfaceC0653w0
    public InterfaceC0646t j(InterfaceC0650v interfaceC0650v) {
        return J0.f9109l;
    }

    @Override // W5.InterfaceC0653w0
    public CancellationException r() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // W5.InterfaceC0653w0
    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    @Override // W5.InterfaceC0653w0
    public void d(CancellationException cancellationException) {
    }
}
