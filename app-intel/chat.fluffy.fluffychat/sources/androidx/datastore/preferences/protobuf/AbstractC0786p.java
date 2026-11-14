package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0786p {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC0784n f12158a = new C0785o();

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC0784n f12159b = c();

    public static AbstractC0784n a() {
        AbstractC0784n abstractC0784n = f12159b;
        if (abstractC0784n != null) {
            return abstractC0784n;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static AbstractC0784n b() {
        return f12158a;
    }

    public static AbstractC0784n c() {
        if (V.f11988d) {
            return null;
        }
        try {
            return (AbstractC0784n) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
