package b6;

import W5.G0;
import java.util.List;
import y5.C1808c;

/* renamed from: b6.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0885u {
    public static final AbstractC0886v a(Throwable th, String str) throws Throwable {
        if (th != null) {
            throw th;
        }
        d();
        throw new C1808c();
    }

    public static /* synthetic */ AbstractC0886v b(Throwable th, String str, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            th = null;
        }
        if ((i7 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(G0 g02) {
        return g02.Y() instanceof AbstractC0886v;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final G0 e(InterfaceC0883s interfaceC0883s, List list) {
        try {
            return interfaceC0883s.b(list);
        } catch (Throwable th) {
            return a(th, interfaceC0883s.a());
        }
    }
}
