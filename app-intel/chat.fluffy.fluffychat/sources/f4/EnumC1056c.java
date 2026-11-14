package f4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: f4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1056c {

    /* renamed from: l, reason: collision with root package name */
    public static final EnumC1056c f15864l = new EnumC1056c("pictures", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC1056c f15865m = new EnumC1056c("downloads", 1);

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1056c f15866n = new EnumC1056c("movies", 2);

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ EnumC1056c[] f15867o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ F5.a f15868p;

    static {
        EnumC1056c[] enumC1056cArrA = a();
        f15867o = enumC1056cArrA;
        f15868p = F5.b.a(enumC1056cArrA);
    }

    public EnumC1056c(String str, int i7) {
    }

    public static final /* synthetic */ EnumC1056c[] a() {
        return new EnumC1056c[]{f15864l, f15865m, f15866n};
    }

    public static EnumC1056c valueOf(String str) {
        return (EnumC1056c) Enum.valueOf(EnumC1056c.class, str);
    }

    public static EnumC1056c[] values() {
        return (EnumC1056c[]) f15867o.clone();
    }
}
