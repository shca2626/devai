package D4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: l, reason: collision with root package name */
    public static final k f1820l = new k("GRANTED", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final k f1821m = new k("DENIED", 1);

    /* renamed from: n, reason: collision with root package name */
    public static final k f1822n = new k("PERMANENTLY_DENIED", 2);

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ k[] f1823o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ F5.a f1824p;

    static {
        k[] kVarArrA = a();
        f1823o = kVarArrA;
        f1824p = F5.b.a(kVarArrA);
    }

    public k(String str, int i7) {
    }

    public static final /* synthetic */ k[] a() {
        return new k[]{f1820l, f1821m, f1822n};
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f1823o.clone();
    }
}
