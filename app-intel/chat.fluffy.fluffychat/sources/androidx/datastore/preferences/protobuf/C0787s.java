package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0787s implements J {

    /* renamed from: a, reason: collision with root package name */
    public static final C0787s f12233a = new C0787s();

    public static C0787s c() {
        return f12233a;
    }

    @Override // androidx.datastore.preferences.protobuf.J
    public I a(Class cls) {
        if (!AbstractC0788t.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (I) AbstractC0788t.A(cls.asSubclass(AbstractC0788t.class)).p();
        } catch (Exception e7) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e7);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.J
    public boolean b(Class cls) {
        return AbstractC0788t.class.isAssignableFrom(cls);
    }
}
