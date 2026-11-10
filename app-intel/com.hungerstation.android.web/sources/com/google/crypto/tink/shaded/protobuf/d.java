package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f23856a;

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?> f23857b = a("libcore.io.Memory");

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f23858c;

    static {
        f23858c = (f23856a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class<?> b() {
        return f23857b;
    }

    static boolean c() {
        return f23856a || !(f23857b == null || f23858c);
    }
}
