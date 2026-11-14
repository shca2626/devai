package W5;

import y5.C1813i;

/* renamed from: W5.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0656y {
    public static final InterfaceC0652w a(InterfaceC0653w0 interfaceC0653w0) {
        return new C0654x(interfaceC0653w0);
    }

    public static /* synthetic */ InterfaceC0652w b(InterfaceC0653w0 interfaceC0653w0, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            interfaceC0653w0 = null;
        }
        return a(interfaceC0653w0);
    }

    public static final boolean c(InterfaceC0652w interfaceC0652w, Object obj) {
        Throwable thD = C1813i.d(obj);
        return thD == null ? interfaceC0652w.H(obj) : interfaceC0652w.F(thD);
    }
}
