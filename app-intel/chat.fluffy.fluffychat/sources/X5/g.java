package X5;

import M5.m;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import y5.AbstractC1815j;
import y5.C1814i;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final f f9351a;
    private static volatile Choreographer choreographer;

    static {
        Object objB;
        try {
            C1814i.a aVar = C1814i.f24004m;
            objB = C1814i.b(new e(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            C1814i.a aVar2 = C1814i.f24004m;
            objB = C1814i.b(AbstractC1815j.a(th));
        }
        f9351a = (f) (C1814i.f(objB) ? null : objB);
    }

    public static final Handler a(Looper looper, boolean z7) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!z7) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            m.c(objInvoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) objInvoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
