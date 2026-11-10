package v4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: v4.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1687d {

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC1687d f23041m = new EnumC1687d("PAUSE", 0, 0);

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1687d f23042n = new EnumC1687d("RECORD", 1, 1);

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC1687d f23043o = new EnumC1687d("STOP", 2, 2);

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ EnumC1687d[] f23044p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ F5.a f23045q;

    /* renamed from: l, reason: collision with root package name */
    public final int f23046l;

    static {
        EnumC1687d[] enumC1687dArrA = a();
        f23044p = enumC1687dArrA;
        f23045q = F5.b.a(enumC1687dArrA);
    }

    public EnumC1687d(String str, int i7, int i8) {
        this.f23046l = i8;
    }

    public static final /* synthetic */ EnumC1687d[] a() {
        return new EnumC1687d[]{f23041m, f23042n, f23043o};
    }

    public static EnumC1687d valueOf(String str) {
        return (EnumC1687d) Enum.valueOf(EnumC1687d.class, str);
    }

    public static EnumC1687d[] values() {
        return (EnumC1687d[]) f23044p.clone();
    }

    public final int d() {
        return this.f23046l;
    }
}
