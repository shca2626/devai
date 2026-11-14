package v4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: v4.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1684b {

    /* renamed from: l, reason: collision with root package name */
    public static final EnumC1684b f23023l = new EnumC1684b("NONE", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC1684b f23024m = new EnumC1684b("PAUSE", 1);

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1684b f23025n = new EnumC1684b("PAUSE_RESUME", 2);

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ EnumC1684b[] f23026o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ F5.a f23027p;

    static {
        EnumC1684b[] enumC1684bArrA = a();
        f23026o = enumC1684bArrA;
        f23027p = F5.b.a(enumC1684bArrA);
    }

    public EnumC1684b(String str, int i7) {
    }

    public static final /* synthetic */ EnumC1684b[] a() {
        return new EnumC1684b[]{f23023l, f23024m, f23025n};
    }

    public static EnumC1684b valueOf(String str) {
        return (EnumC1684b) Enum.valueOf(EnumC1684b.class, str);
    }

    public static EnumC1684b[] values() {
        return (EnumC1684b[]) f23026o.clone();
    }
}
