package Y1;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f9852a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f9853b;

    /* renamed from: c, reason: collision with root package name */
    public static Method f9854c;

    /* renamed from: d, reason: collision with root package name */
    public static Method f9855d;

    public static void a(String str, int i7) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            c.a(j(str), i7);
        } else {
            b(j(str), i7);
        }
    }

    public static void b(String str, int i7) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (f9854c == null) {
                f9854c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            f9854c.invoke(null, Long.valueOf(f9852a), str, Integer.valueOf(i7));
        } catch (Exception e7) {
            g("asyncTraceBegin", e7);
        }
    }

    public static void c(String str) {
        b.a(j(str));
    }

    public static void d(String str, int i7) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            c.b(j(str), i7);
        } else {
            e(j(str), i7);
        }
    }

    public static void e(String str, int i7) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (f9855d == null) {
                f9855d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            f9855d.invoke(null, Long.valueOf(f9852a), str, Integer.valueOf(i7));
        } catch (Exception e7) {
            g("asyncTraceEnd", e7);
        }
    }

    public static void f() {
        b.b();
    }

    public static void g(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 29 ? c.c() : i();
    }

    public static boolean i() {
        try {
            if (f9853b == null) {
                f9852a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f9853b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f9853b.invoke(null, Long.valueOf(f9852a))).booleanValue();
        } catch (Exception e7) {
            g("isTagEnabled", e7);
            return false;
        }
    }

    public static String j(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }
}
