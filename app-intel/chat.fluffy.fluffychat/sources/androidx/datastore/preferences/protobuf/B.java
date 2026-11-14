package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public abstract class B {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC0795z f11940a = c();

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC0795z f11941b = new A();

    public static InterfaceC0795z a() {
        return f11940a;
    }

    public static InterfaceC0795z b() {
        return f11941b;
    }

    public static InterfaceC0795z c() {
        if (V.f11988d) {
            return null;
        }
        try {
            return (InterfaceC0795z) Class.forName("androidx.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
