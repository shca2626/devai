package W5;

import y5.AbstractC1815j;
import y5.C1814i;

/* loaded from: classes.dex */
public abstract class D {
    public static final Object a(Object obj, C5.e eVar) {
        if (!(obj instanceof B)) {
            return C1814i.b(obj);
        }
        C1814i.a aVar = C1814i.f24004m;
        return C1814i.b(AbstractC1815j.a(((B) obj).f9083a));
    }

    public static final Object b(Object obj) {
        Throwable thD = C1814i.d(obj);
        return thD == null ? obj : new B(thD, false, 2, null);
    }

    public static final Object c(Object obj, InterfaceC0632m interfaceC0632m) {
        Throwable thD = C1814i.d(obj);
        return thD == null ? obj : new B(thD, false, 2, null);
    }
}
