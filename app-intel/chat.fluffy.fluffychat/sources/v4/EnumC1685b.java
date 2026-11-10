package v4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: v4.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1685b {

    /* renamed from: l, reason: collision with root package name */
    public static final EnumC1685b f23017l = new EnumC1685b("NONE", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC1685b f23018m = new EnumC1685b("PAUSE", 1);

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1685b f23019n = new EnumC1685b("PAUSE_RESUME", 2);

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ EnumC1685b[] f23020o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ F5.a f23021p;

    static {
        EnumC1685b[] enumC1685bArrA = a();
        f23020o = enumC1685bArrA;
        f23021p = F5.b.a(enumC1685bArrA);
    }

    public EnumC1685b(String str, int i7) {
    }

    public static final /* synthetic */ EnumC1685b[] a() {
        return new EnumC1685b[]{f23017l, f23018m, f23019n};
    }

    public static EnumC1685b valueOf(String str) {
        return (EnumC1685b) Enum.valueOf(EnumC1685b.class, str);
    }

    public static EnumC1685b[] values() {
        return (EnumC1685b[]) f23020o.clone();
    }
}
