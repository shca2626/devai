package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f6952a = a("libcore.io.Memory");

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f6953b;

    static {
        f6953b = a("org.robolectric.Robolectric") != null;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class<?> b() {
        return f6952a;
    }

    static boolean c() {
        return (f6952a == null || f6953b) ? false : true;
    }
}
