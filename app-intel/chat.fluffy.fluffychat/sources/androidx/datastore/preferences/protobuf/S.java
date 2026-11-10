package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public abstract class S {

    /* renamed from: a, reason: collision with root package name */
    public static final P f11981a = c();

    /* renamed from: b, reason: collision with root package name */
    public static final P f11982b = new Q();

    public static P a() {
        return f11981a;
    }

    public static P b() {
        return f11982b;
    }

    public static P c() {
        if (V.f11988d) {
            return null;
        }
        try {
            return (P) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
