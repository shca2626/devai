package v4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: v4.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1686d {

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC1686d f23047m = new EnumC1686d("PAUSE", 0, 0);

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1686d f23048n = new EnumC1686d("RECORD", 1, 1);

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC1686d f23049o = new EnumC1686d("STOP", 2, 2);

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ EnumC1686d[] f23050p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ F5.a f23051q;

    /* renamed from: l, reason: collision with root package name */
    public final int f23052l;

    static {
        EnumC1686d[] enumC1686dArrA = a();
        f23050p = enumC1686dArrA;
        f23051q = F5.b.a(enumC1686dArrA);
    }

    public EnumC1686d(String str, int i7, int i8) {
        this.f23052l = i8;
    }

    public static final /* synthetic */ EnumC1686d[] a() {
        return new EnumC1686d[]{f23047m, f23048n, f23049o};
    }

    public static EnumC1686d valueOf(String str) {
        return (EnumC1686d) Enum.valueOf(EnumC1686d.class, str);
    }

    public static EnumC1686d[] values() {
        return (EnumC1686d[]) f23050p.clone();
    }

    public final int d() {
        return this.f23052l;
    }
}
