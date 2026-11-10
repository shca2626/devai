package f4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: f4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1055c {

    /* renamed from: l, reason: collision with root package name */
    public static final EnumC1055c f15864l = new EnumC1055c("pictures", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC1055c f15865m = new EnumC1055c("downloads", 1);

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1055c f15866n = new EnumC1055c("movies", 2);

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ EnumC1055c[] f15867o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ F5.a f15868p;

    static {
        EnumC1055c[] enumC1055cArrA = a();
        f15867o = enumC1055cArrA;
        f15868p = F5.b.a(enumC1055cArrA);
    }

    public EnumC1055c(String str, int i7) {
    }

    public static final /* synthetic */ EnumC1055c[] a() {
        return new EnumC1055c[]{f15864l, f15865m, f15866n};
    }

    public static EnumC1055c valueOf(String str) {
        return (EnumC1055c) Enum.valueOf(EnumC1055c.class, str);
    }

    public static EnumC1055c[] values() {
        return (EnumC1055c[]) f15867o.clone();
    }
}
