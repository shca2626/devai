package o5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: o5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1407a {

    /* renamed from: m, reason: collision with root package name */
    public static final C0235a f20412m;

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1407a f20413n = new EnumC1407a("WEAK", 0, 0);

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC1407a f20414o = new EnumC1407a("STRONG", 1, 1);

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ EnumC1407a[] f20415p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ F5.a f20416q;

    /* renamed from: l, reason: collision with root package name */
    public final int f20417l;

    /* renamed from: o5.a$a, reason: collision with other inner class name */
    public static final class C0235a {
        public /* synthetic */ C0235a(M5.g gVar) {
            this();
        }

        public final EnumC1407a a(int i7) {
            for (EnumC1407a enumC1407a : EnumC1407a.values()) {
                if (enumC1407a.d() == i7) {
                    return enumC1407a;
                }
            }
            return null;
        }

        public C0235a() {
        }
    }

    static {
        EnumC1407a[] enumC1407aArrA = a();
        f20415p = enumC1407aArrA;
        f20416q = F5.b.a(enumC1407aArrA);
        f20412m = new C0235a(null);
    }

    public EnumC1407a(String str, int i7, int i8) {
        this.f20417l = i8;
    }

    public static final /* synthetic */ EnumC1407a[] a() {
        return new EnumC1407a[]{f20413n, f20414o};
    }

    public static EnumC1407a valueOf(String str) {
        return (EnumC1407a) Enum.valueOf(EnumC1407a.class, str);
    }

    public static EnumC1407a[] values() {
        return (EnumC1407a[]) f20415p.clone();
    }

    public final int d() {
        return this.f20417l;
    }
}
