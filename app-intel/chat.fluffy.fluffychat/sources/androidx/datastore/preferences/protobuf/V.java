package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class V {

    /* renamed from: c, reason: collision with root package name */
    public static final V f11987c = new V();

    /* renamed from: d, reason: collision with root package name */
    public static boolean f11988d = false;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f11990b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final a0 f11989a = new C();

    public static V a() {
        return f11987c;
    }

    public Z b(Class cls, Z z7) {
        AbstractC0789u.b(cls, "messageType");
        AbstractC0789u.b(z7, "schema");
        return (Z) this.f11990b.putIfAbsent(cls, z7);
    }

    public Z c(Class cls) {
        Z zB;
        AbstractC0789u.b(cls, "messageType");
        Z zA = (Z) this.f11990b.get(cls);
        return (zA != null || (zB = b(cls, (zA = this.f11989a.a(cls)))) == null) ? zA : zB;
    }

    public Z d(Object obj) {
        return c(obj.getClass());
    }
}
