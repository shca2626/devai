package com.google.protobuf;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f25277a;

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?> f25278b = a("libcore.io.Memory");

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f25279c;

    static {
        f25279c = (f25277a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class<?> b() {
        return f25278b;
    }

    static boolean c() {
        return f25277a || !(f25278b == null || f25279c);
    }
}
