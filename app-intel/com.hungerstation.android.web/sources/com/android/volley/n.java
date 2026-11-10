package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes7.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static String f18257a = "Volley";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f18258b = Log.isLoggable("Volley", 2);

    /* renamed from: c, reason: collision with root package name */
    private static final String f18259c = n.class.getName();

    static class a {

        /* renamed from: c, reason: collision with root package name */
        public static final boolean f18260c = n.f18258b;

        /* renamed from: a, reason: collision with root package name */
        private final List<C0359a> f18261a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private boolean f18262b = false;

        /* renamed from: com.android.volley.n$a$a, reason: collision with other inner class name */
        private static class C0359a {

            /* renamed from: a, reason: collision with root package name */
            public final String f18263a;

            /* renamed from: b, reason: collision with root package name */
            public final long f18264b;

            /* renamed from: c, reason: collision with root package name */
            public final long f18265c;

            public C0359a(String str, long j12, long j13) {
                this.f18263a = str;
                this.f18264b = j12;
                this.f18265c = j13;
            }
        }

        a() {
        }

        private long c() {
            if (this.f18261a.size() == 0) {
                return 0L;
            }
            return this.f18261a.get(r2.size() - 1).f18265c - this.f18261a.get(0).f18265c;
        }

        public synchronized void a(String str, long j12) {
            if (this.f18262b) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f18261a.add(new C0359a(str, j12, SystemClock.elapsedRealtime()));
        }

        public synchronized void b(String str) {
            this.f18262b = true;
            long jC = c();
            if (jC <= 0) {
                return;
            }
            long j12 = this.f18261a.get(0).f18265c;
            n.b("(%-4d ms) %s", Long.valueOf(jC), str);
            for (C0359a c0359a : this.f18261a) {
                long j13 = c0359a.f18265c;
                n.b("(+%-4d) [%2d] %s", Long.valueOf(j13 - j12), Long.valueOf(c0359a.f18264b), c0359a.f18263a);
                j12 = j13;
            }
        }

        protected void finalize() throws Throwable {
            if (this.f18262b) {
                return;
            }
            b("Request on the loose");
            n.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    private static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i12 = 2;
        while (true) {
            if (i12 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i12].getClassName().equals(f18259c)) {
                String className = stackTrace[i12].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + "." + stackTrace[i12].getMethodName();
                break;
            }
            i12++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void b(String str, Object... objArr) {
        a(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        a(str, objArr);
    }

    public static void d(Throwable th2, String str, Object... objArr) {
        a(str, objArr);
    }

    public static void e(String str, Object... objArr) {
        if (f18258b) {
            a(str, objArr);
        }
    }

    public static void f(String str, Object... objArr) {
        Log.wtf(f18257a, a(str, objArr));
    }
}
