package b6;

import java.lang.reflect.InvocationTargetException;
import y5.C1805a;

/* loaded from: classes.dex */
public abstract class x {
    public static final void a(L5.l lVar, Object obj, C5.i iVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C0865Q c0865qB = b(lVar, obj, null);
        if (c0865qB != null) {
            W5.L.a(iVar, c0865qB);
        }
    }

    public static final C0865Q b(L5.l lVar, Object obj, C0865Q c0865q) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            lVar.a(obj);
            return c0865q;
        } catch (Throwable th) {
            if (c0865q != null && c0865q.getCause() != th) {
                C1805a.a(c0865q, th);
                return c0865q;
            }
            return new C0865Q("Exception in undelivered element handler for " + obj, th);
        }
    }

    public static /* synthetic */ C0865Q c(L5.l lVar, Object obj, C0865Q c0865q, int i7, Object obj2) {
        if ((i7 & 2) != 0) {
            c0865q = null;
        }
        return b(lVar, obj, c0865q);
    }
}
