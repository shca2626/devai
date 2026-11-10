package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0773d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f12021a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f12022b = a("libcore.io.Memory");

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f12023c;

    static {
        f12023c = (f12021a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class b() {
        return f12022b;
    }

    public static boolean c() {
        if (f12021a) {
            return true;
        }
        return (f12022b == null || f12023c) ? false : true;
    }
}
