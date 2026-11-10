package W5;

import y5.C1814i;

/* renamed from: W5.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0655y {
    public static final InterfaceC0651w a(InterfaceC0652w0 interfaceC0652w0) {
        return new C0653x(interfaceC0652w0);
    }

    public static /* synthetic */ InterfaceC0651w b(InterfaceC0652w0 interfaceC0652w0, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            interfaceC0652w0 = null;
        }
        return a(interfaceC0652w0);
    }

    public static final boolean c(InterfaceC0651w interfaceC0651w, Object obj) {
        Throwable thD = C1814i.d(obj);
        return thD == null ? interfaceC0651w.H(obj) : interfaceC0651w.F(thD);
    }
}
