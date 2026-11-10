package W5;

import b6.C0873i;
import y5.AbstractC1815j;
import y5.C1814i;

/* loaded from: classes.dex */
public abstract class Q {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(C5.e eVar) {
        Object objB;
        if (eVar instanceof C0873i) {
            return ((C0873i) eVar).toString();
        }
        try {
            C1814i.a aVar = C1814i.f24004m;
            objB = C1814i.b(eVar + '@' + b(eVar));
        } catch (Throwable th) {
            C1814i.a aVar2 = C1814i.f24004m;
            objB = C1814i.b(AbstractC1815j.a(th));
        }
        if (C1814i.d(objB) != null) {
            objB = eVar.getClass().getName() + '@' + b(eVar);
        }
        return (String) objB;
    }
}
