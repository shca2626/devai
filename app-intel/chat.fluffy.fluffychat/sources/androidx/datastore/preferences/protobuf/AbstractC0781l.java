package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0781l {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f12113a = c();

    public static C0782m a() {
        C0782m c0782mB = b("getEmptyRegistry");
        return c0782mB != null ? c0782mB : C0782m.f12151c;
    }

    public static final C0782m b(String str) {
        Class cls = f12113a;
        if (cls == null) {
            return null;
        }
        try {
            return (C0782m) cls.getDeclaredMethod(str, null).invoke(null, null);
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
