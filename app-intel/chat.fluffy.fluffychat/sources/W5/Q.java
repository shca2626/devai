package W5;

import b6.C0874i;
import y5.AbstractC1814j;
import y5.C1813i;

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
        if (eVar instanceof C0874i) {
            return ((C0874i) eVar).toString();
        }
        try {
            C1813i.a aVar = C1813i.f24010m;
            objB = C1813i.b(eVar + '@' + b(eVar));
        } catch (Throwable th) {
            C1813i.a aVar2 = C1813i.f24010m;
            objB = C1813i.b(AbstractC1814j.a(th));
        }
        if (C1813i.d(objB) != null) {
            objB = eVar.getClass().getName() + '@' + b(eVar);
        }
        return (String) objB;
    }
}
