package u5;

/* renamed from: u5.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1669d implements AutoCloseable {
    public C1669d(String str) {
        a(str);
    }

    public static void a(String str) {
        Y1.a.c(e(str));
    }

    public static void d(String str, int i7) {
        Y1.a.a(e(str), i7);
    }

    public static String e(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void f() {
        Y1.a.f();
    }

    public static void i(String str, int i7) {
        Y1.a.d(e(str), i7);
    }

    public static C1669d j(String str) {
        return new C1669d(str);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        f();
    }
}
