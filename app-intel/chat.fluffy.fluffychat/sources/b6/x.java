package b6;

import java.lang.reflect.InvocationTargetException;
import y5.C1806a;

/* loaded from: classes.dex */
public abstract class x {
    public static final void a(L5.l lVar, Object obj, C5.i iVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C0864Q c0864qB = b(lVar, obj, null);
        if (c0864qB != null) {
            W5.L.a(iVar, c0864qB);
        }
    }

    public static final C0864Q b(L5.l lVar, Object obj, C0864Q c0864q) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            lVar.a(obj);
            return c0864q;
        } catch (Throwable th) {
            if (c0864q != null && c0864q.getCause() != th) {
                C1806a.a(c0864q, th);
                return c0864q;
            }
            return new C0864Q("Exception in undelivered element handler for " + obj, th);
        }
    }

    public static /* synthetic */ C0864Q c(L5.l lVar, Object obj, C0864Q c0864q, int i7, Object obj2) {
        if ((i7 & 2) != 0) {
            c0864q = null;
        }
        return b(lVar, obj, c0864q);
    }
}
