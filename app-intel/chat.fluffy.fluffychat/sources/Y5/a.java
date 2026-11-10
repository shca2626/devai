package Y5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: l, reason: collision with root package name */
    public static final a f9870l = new a("SUSPEND", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final a f9871m = new a("DROP_OLDEST", 1);

    /* renamed from: n, reason: collision with root package name */
    public static final a f9872n = new a("DROP_LATEST", 2);

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ a[] f9873o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ F5.a f9874p;

    static {
        a[] aVarArrA = a();
        f9873o = aVarArrA;
        f9874p = F5.b.a(aVarArrA);
    }

    public a(String str, int i7) {
    }

    public static final /* synthetic */ a[] a() {
        return new a[]{f9870l, f9871m, f9872n};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f9873o.clone();
    }
}
