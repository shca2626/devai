package d4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: d4.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0998g {

    /* renamed from: l, reason: collision with root package name */
    public static final EnumC0998g f15229l = new EnumC0998g("VERY_HIGH", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC0998g f15230m = new EnumC0998g("HIGH", 1);

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC0998g f15231n = new EnumC0998g("MEDIUM", 2);

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC0998g f15232o = new EnumC0998g("LOW", 3);

    /* renamed from: p, reason: collision with root package name */
    public static final EnumC0998g f15233p = new EnumC0998g("VERY_LOW", 4);

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ EnumC0998g[] f15234q;

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ F5.a f15235r;

    static {
        EnumC0998g[] enumC0998gArrA = a();
        f15234q = enumC0998gArrA;
        f15235r = F5.b.a(enumC0998gArrA);
    }

    public EnumC0998g(String str, int i7) {
    }

    public static final /* synthetic */ EnumC0998g[] a() {
        return new EnumC0998g[]{f15229l, f15230m, f15231n, f15232o, f15233p};
    }

    public static EnumC0998g valueOf(String str) {
        return (EnumC0998g) Enum.valueOf(EnumC0998g.class, str);
    }

    public static EnumC0998g[] values() {
        return (EnumC0998g[]) f15234q.clone();
    }
}
