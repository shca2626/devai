package n5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: n5.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1365c {

    /* renamed from: m, reason: collision with root package name */
    public static final a f20144m;

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1365c f20145n = new EnumC1365c("IMAGE", 0, 0);

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC1365c f20146o = new EnumC1365c("VIDEO", 1, 1);

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ EnumC1365c[] f20147p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ F5.a f20148q;

    /* renamed from: l, reason: collision with root package name */
    public final int f20149l;

    /* renamed from: n5.c$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final EnumC1365c a(int i7) {
            for (EnumC1365c enumC1365c : EnumC1365c.values()) {
                if (enumC1365c.d() == i7) {
                    return enumC1365c;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        EnumC1365c[] enumC1365cArrA = a();
        f20147p = enumC1365cArrA;
        f20148q = F5.b.a(enumC1365cArrA);
        f20144m = new a(null);
    }

    public EnumC1365c(String str, int i7, int i8) {
        this.f20149l = i8;
    }

    public static final /* synthetic */ EnumC1365c[] a() {
        return new EnumC1365c[]{f20145n, f20146o};
    }

    public static EnumC1365c valueOf(String str) {
        return (EnumC1365c) Enum.valueOf(EnumC1365c.class, str);
    }

    public static EnumC1365c[] values() {
        return (EnumC1365c[]) f20147p.clone();
    }

    public final int d() {
        return this.f20149l;
    }
}
