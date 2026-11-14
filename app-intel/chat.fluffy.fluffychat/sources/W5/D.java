package W5;

import y5.AbstractC1814j;
import y5.C1813i;

/* loaded from: classes.dex */
public abstract class D {
    public static final Object a(Object obj, C5.e eVar) {
        if (!(obj instanceof B)) {
            return C1813i.b(obj);
        }
        C1813i.a aVar = C1813i.f24010m;
        return C1813i.b(AbstractC1814j.a(((B) obj).f9083a));
    }

    public static final Object b(Object obj) {
        Throwable thD = C1813i.d(obj);
        return thD == null ? obj : new B(thD, false, 2, null);
    }

    public static final Object c(Object obj, InterfaceC0633m interfaceC0633m) {
        Throwable thD = C1813i.d(obj);
        return thD == null ? obj : new B(thD, false, 2, null);
    }
}
