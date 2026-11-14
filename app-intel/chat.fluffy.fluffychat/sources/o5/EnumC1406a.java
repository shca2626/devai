package o5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: o5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1406a {

    /* renamed from: m, reason: collision with root package name */
    public static final C0235a f20411m;

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1406a f20412n = new EnumC1406a("WEAK", 0, 0);

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC1406a f20413o = new EnumC1406a("STRONG", 1, 1);

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ EnumC1406a[] f20414p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ F5.a f20415q;

    /* renamed from: l, reason: collision with root package name */
    public final int f20416l;

    /* renamed from: o5.a$a, reason: collision with other inner class name */
    public static final class C0235a {
        public /* synthetic */ C0235a(M5.g gVar) {
            this();
        }

        public final EnumC1406a a(int i7) {
            for (EnumC1406a enumC1406a : EnumC1406a.values()) {
                if (enumC1406a.d() == i7) {
                    return enumC1406a;
                }
            }
            return null;
        }

        public C0235a() {
        }
    }

    static {
        EnumC1406a[] enumC1406aArrA = a();
        f20414p = enumC1406aArrA;
        f20415q = F5.b.a(enumC1406aArrA);
        f20411m = new C0235a(null);
    }

    public EnumC1406a(String str, int i7, int i8) {
        this.f20416l = i8;
    }

    public static final /* synthetic */ EnumC1406a[] a() {
        return new EnumC1406a[]{f20412n, f20413o};
    }

    public static EnumC1406a valueOf(String str) {
        return (EnumC1406a) Enum.valueOf(EnumC1406a.class, str);
    }

    public static EnumC1406a[] values() {
        return (EnumC1406a[]) f20414p.clone();
    }

    public final int d() {
        return this.f20416l;
    }
}
