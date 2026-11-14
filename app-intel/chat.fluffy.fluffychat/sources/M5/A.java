package M5;

import N5.c;
import java.util.Map;
import y5.InterfaceC1806b;

/* loaded from: classes.dex */
public class A {
    public static Iterable a(Object obj) {
        if ((obj instanceof N5.a) && !(obj instanceof N5.b)) {
            l(obj, "kotlin.collections.MutableIterable");
        }
        return e(obj);
    }

    public static Map b(Object obj) {
        if ((obj instanceof N5.a) && !(obj instanceof N5.c)) {
            l(obj, "kotlin.collections.MutableMap");
        }
        return f(obj);
    }

    public static Map.Entry c(Object obj) {
        if ((obj instanceof N5.a) && !(obj instanceof c.a)) {
            l(obj, "kotlin.collections.MutableMap.MutableEntry");
        }
        return g(obj);
    }

    public static Object d(Object obj, int i7) {
        if (obj != null && !i(obj, i7)) {
            l(obj, "kotlin.jvm.functions.Function" + i7);
        }
        return obj;
    }

    public static Iterable e(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e7) {
            throw k(e7);
        }
    }

    public static Map f(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e7) {
            throw k(e7);
        }
    }

    public static Map.Entry g(Object obj) {
        try {
            return (Map.Entry) obj;
        } catch (ClassCastException e7) {
            throw k(e7);
        }
    }

    public static int h(Object obj) {
        if (obj instanceof i) {
            return ((i) obj).e();
        }
        if (obj instanceof L5.a) {
            return 0;
        }
        if (obj instanceof L5.l) {
            return 1;
        }
        if (obj instanceof L5.p) {
            return 2;
        }
        return obj instanceof L5.q ? 3 : -1;
    }

    public static boolean i(Object obj, int i7) {
        return (obj instanceof InterfaceC1806b) && h(obj) == i7;
    }

    public static Throwable j(Throwable th) {
        return m.i(th, A.class.getName());
    }

    public static ClassCastException k(ClassCastException classCastException) {
        throw ((ClassCastException) j(classCastException));
    }

    public static void l(Object obj, String str) {
        m((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void m(String str) {
        throw k(new ClassCastException(str));
    }
}
