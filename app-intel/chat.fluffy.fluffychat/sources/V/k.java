package V;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static long f8490a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f8491b;

    /* renamed from: c, reason: collision with root package name */
    public static Method f8492c;

    /* renamed from: d, reason: collision with root package name */
    public static Method f8493d;

    /* renamed from: e, reason: collision with root package name */
    public static Method f8494e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f8490a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f8491b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f8492c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f8493d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f8494e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e7) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e7);
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
