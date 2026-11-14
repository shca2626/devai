package W5;

import b6.AbstractC0872g;
import java.lang.reflect.InvocationTargetException;
import y5.C1805a;

/* loaded from: classes.dex */
public abstract class L {
    public static final void a(C5.i iVar, Throwable th) {
        if (th instanceof Y) {
            th = ((Y) th).getCause();
        }
        try {
            K k7 = (K) iVar.a(K.f9110c);
            if (k7 != null) {
                k7.M(iVar, th);
            } else {
                AbstractC0872g.a(iVar, th);
            }
        } catch (Throwable th2) {
            AbstractC0872g.a(iVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        C1805a.a(runtimeException, th);
        return runtimeException;
    }
}
