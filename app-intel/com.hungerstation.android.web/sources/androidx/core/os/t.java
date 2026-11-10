package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import java.lang.reflect.Method;

@Deprecated
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private static long f6599a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f6600b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f6601c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f6602d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f6603e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f6599a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f6600b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f6601c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f6602d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f6603e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
