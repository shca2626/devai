package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0785p {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC0783n f12158a = new C0784o();

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC0783n f12159b = c();

    public static AbstractC0783n a() {
        AbstractC0783n abstractC0783n = f12159b;
        if (abstractC0783n != null) {
            return abstractC0783n;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static AbstractC0783n b() {
        return f12158a;
    }

    public static AbstractC0783n c() {
        if (V.f11988d) {
            return null;
        }
        try {
            return (AbstractC0783n) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
