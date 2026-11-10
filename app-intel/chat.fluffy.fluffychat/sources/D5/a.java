package D5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: l, reason: collision with root package name */
    public static final a f1825l = new a("COROUTINE_SUSPENDED", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final a f1826m = new a("UNDECIDED", 1);

    /* renamed from: n, reason: collision with root package name */
    public static final a f1827n = new a("RESUMED", 2);

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ a[] f1828o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ F5.a f1829p;

    static {
        a[] aVarArrA = a();
        f1828o = aVarArrA;
        f1829p = F5.b.a(aVarArrA);
    }

    public a(String str, int i7) {
    }

    public static final /* synthetic */ a[] a() {
        return new a[]{f1825l, f1826m, f1827n};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f1828o.clone();
    }
}
