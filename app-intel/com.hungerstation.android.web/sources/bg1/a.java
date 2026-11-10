package bg1;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f13788a = 5;

    public static void a(Exception exc) {
        if (d()) {
            exc.printStackTrace();
        }
    }

    public static void b(Object obj) {
        if (d()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c());
            sb2.append(String.valueOf(obj));
            StringBuilder sb3 = new StringBuilder();
            sb3.append(c());
            sb3.append(String.valueOf(obj));
        }
    }

    private static String c() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        String className = stackTrace[2].getClassName();
        int lineNumber = stackTrace[2].getLineNumber();
        return className.substring(className.lastIndexOf(46) + 1) + ": " + methodName + "() [" + lineNumber + "] - ";
    }

    public static boolean d() {
        return f13788a > 0;
    }

    public static boolean e() {
        return f13788a > 4;
    }

    public static void f(Object obj) {
        if (e()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c());
            sb2.append(String.valueOf(obj));
        }
    }
}
