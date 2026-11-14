package d4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: d4.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0997f {

    /* renamed from: l, reason: collision with root package name */
    public static final EnumC0997f f15225l = new EnumC0997f("H264", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC0997f f15226m = new EnumC0997f("H265", 1);

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ EnumC0997f[] f15227n;

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ F5.a f15228o;

    static {
        EnumC0997f[] enumC0997fArrA = a();
        f15227n = enumC0997fArrA;
        f15228o = F5.b.a(enumC0997fArrA);
    }

    public EnumC0997f(String str, int i7) {
    }

    public static final /* synthetic */ EnumC0997f[] a() {
        return new EnumC0997f[]{f15225l, f15226m};
    }

    public static EnumC0997f valueOf(String str) {
        return (EnumC0997f) Enum.valueOf(EnumC0997f.class, str);
    }

    public static EnumC0997f[] values() {
        return (EnumC0997f[]) f15227n.clone();
    }
}
