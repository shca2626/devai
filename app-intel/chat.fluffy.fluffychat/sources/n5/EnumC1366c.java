package n5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: n5.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1366c {

    /* renamed from: m, reason: collision with root package name */
    public static final a f20145m;

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1366c f20146n = new EnumC1366c("IMAGE", 0, 0);

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC1366c f20147o = new EnumC1366c("VIDEO", 1, 1);

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ EnumC1366c[] f20148p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ F5.a f20149q;

    /* renamed from: l, reason: collision with root package name */
    public final int f20150l;

    /* renamed from: n5.c$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final EnumC1366c a(int i7) {
            for (EnumC1366c enumC1366c : EnumC1366c.values()) {
                if (enumC1366c.d() == i7) {
                    return enumC1366c;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        EnumC1366c[] enumC1366cArrA = a();
        f20148p = enumC1366cArrA;
        f20149q = F5.b.a(enumC1366cArrA);
        f20145m = new a(null);
    }

    public EnumC1366c(String str, int i7, int i8) {
        this.f20150l = i8;
    }

    public static final /* synthetic */ EnumC1366c[] a() {
        return new EnumC1366c[]{f20146n, f20147o};
    }

    public static EnumC1366c valueOf(String str) {
        return (EnumC1366c) Enum.valueOf(EnumC1366c.class, str);
    }

    public static EnumC1366c[] values() {
        return (EnumC1366c[]) f20148p.clone();
    }

    public final int d() {
        return this.f20150l;
    }
}
