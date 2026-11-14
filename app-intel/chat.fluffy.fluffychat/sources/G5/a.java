package G5;

import M5.m;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import z5.C1881l;

/* loaded from: classes.dex */
public class a {

    /* renamed from: G5.a$a, reason: collision with other inner class name */
    public static final class C0038a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0038a f3293a = new C0038a();

        /* renamed from: b, reason: collision with root package name */
        public static final Method f3294b;

        /* renamed from: c, reason: collision with root package name */
        public static final Method f3295c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            m.b(methods);
            int length = methods.length;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                method = null;
                if (i8 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i8];
                if (m.a(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    m.d(parameterTypes, "getParameterTypes(...)");
                    if (m.a(C1881l.H(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i8++;
            }
            f3294b = method2;
            int length2 = methods.length;
            while (true) {
                if (i7 >= length2) {
                    break;
                }
                Method method3 = methods[i7];
                if (m.a(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i7++;
            }
            f3295c = method;
        }
    }

    public void a(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m.e(th, "cause");
        m.e(th2, "exception");
        Method method = C0038a.f3294b;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public Q5.c b() {
        return new Q5.b();
    }
}
