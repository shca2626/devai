package d4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: d4.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0997g {

    /* renamed from: l, reason: collision with root package name */
    public static final EnumC0997g f15229l = new EnumC0997g("VERY_HIGH", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC0997g f15230m = new EnumC0997g("HIGH", 1);

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC0997g f15231n = new EnumC0997g("MEDIUM", 2);

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC0997g f15232o = new EnumC0997g("LOW", 3);

    /* renamed from: p, reason: collision with root package name */
    public static final EnumC0997g f15233p = new EnumC0997g("VERY_LOW", 4);

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ EnumC0997g[] f15234q;

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ F5.a f15235r;

    static {
        EnumC0997g[] enumC0997gArrA = a();
        f15234q = enumC0997gArrA;
        f15235r = F5.b.a(enumC0997gArrA);
    }

    public EnumC0997g(String str, int i7) {
    }

    public static final /* synthetic */ EnumC0997g[] a() {
        return new EnumC0997g[]{f15229l, f15230m, f15231n, f15232o, f15233p};
    }

    public static EnumC0997g valueOf(String str) {
        return (EnumC0997g) Enum.valueOf(EnumC0997g.class, str);
    }

    public static EnumC0997g[] values() {
        return (EnumC0997g[]) f15234q.clone();
    }
}
