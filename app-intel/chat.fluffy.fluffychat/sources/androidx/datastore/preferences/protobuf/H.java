package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public abstract class H {

    /* renamed from: a, reason: collision with root package name */
    public static final F f11955a = c();

    /* renamed from: b, reason: collision with root package name */
    public static final F f11956b = new G();

    public static F a() {
        return f11955a;
    }

    public static F b() {
        return f11956b;
    }

    public static F c() {
        if (V.f11988d) {
            return null;
        }
        try {
            return (F) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
