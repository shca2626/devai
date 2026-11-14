package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0782l {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f12113a = c();

    public static C0783m a() {
        C0783m c0783mB = b("getEmptyRegistry");
        return c0783mB != null ? c0783mB : C0783m.f12151c;
    }

    public static final C0783m b(String str) {
        Class cls = f12113a;
        if (cls == null) {
            return null;
        }
        try {
            return (C0783m) cls.getDeclaredMethod(str, null).invoke(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Class c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
