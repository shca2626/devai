package E0;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;

/* renamed from: E0.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0332s {

    /* renamed from: b, reason: collision with root package name */
    public static int f2205b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f2206c = true;

    /* renamed from: a, reason: collision with root package name */
    public static final Object f2204a = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static a f2207d = a.f2208a;

    /* renamed from: E0.s$a */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f2208a = new C0018a();

        /* renamed from: E0.s$a$a, reason: collision with other inner class name */
        public class C0018a implements a {
            @Override // E0.AbstractC0332s.a
            public void a(String str, String str2, Throwable th) {
                Log.e(str, AbstractC0332s.a(str2, th));
            }

            @Override // E0.AbstractC0332s.a
            public void b(String str, String str2, Throwable th) {
                Log.w(str, AbstractC0332s.a(str2, th));
            }

            @Override // E0.AbstractC0332s.a
            public void c(String str, String str2, Throwable th) {
                Log.d(str, AbstractC0332s.a(str2, th));
            }

            @Override // E0.AbstractC0332s.a
            public void d(String str, String str2, Throwable th) {
                Log.i(str, AbstractC0332s.a(str2, th));
            }
        }

        void a(String str, String str2, Throwable th);

        void b(String str, String str2, Throwable th);

        void c(String str, String str2, Throwable th);

        void d(String str, String str2, Throwable th);
    }

    public static String a(String str, Throwable th) {
        String strE = e(th);
        if (TextUtils.isEmpty(strE)) {
            return str;
        }
        return str + "\n  " + strE.replace("\n", "\n  ") + '\n';
    }

    public static void b(String str, String str2) {
        synchronized (f2204a) {
            try {
                if (f2205b == 0) {
                    f2207d.c(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(String str, String str2) {
        synchronized (f2204a) {
            try {
                if (f2205b <= 3) {
                    f2207d.a(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void d(String str, String str2, Throwable th) {
        synchronized (f2204a) {
            try {
                if (f2205b <= 3) {
                    f2207d.a(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static String e(Throwable th) {
        if (th == null) {
            return null;
        }
        synchronized (f2204a) {
            try {
                if (g(th)) {
                    return "UnknownHostException (no network)";
                }
                if (f2206c) {
                    return Log.getStackTraceString(th).trim().replace("\t", "    ");
                }
                return th.getMessage();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void f(String str, String str2) {
        synchronized (f2204a) {
            try {
                if (f2205b <= 1) {
                    f2207d.d(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean g(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void h(String str, String str2) {
        synchronized (f2204a) {
            try {
                if (f2205b <= 2) {
                    f2207d.b(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void i(String str, String str2, Throwable th) {
        synchronized (f2204a) {
            try {
                if (f2205b <= 2) {
                    f2207d.b(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
