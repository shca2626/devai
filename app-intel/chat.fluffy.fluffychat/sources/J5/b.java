package J5;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import y5.C1806a;

/* loaded from: classes.dex */
public abstract class b {
    public static final void a(Closeable closeable, Throwable th) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                C1806a.a(th, th2);
            }
        }
    }
}
