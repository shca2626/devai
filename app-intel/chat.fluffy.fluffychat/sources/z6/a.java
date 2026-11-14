package z6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: l, reason: collision with root package name */
    public static final a f24205l = new a("INTERNAL_ERROR", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final a f24206m = new a("NETWORK", 1);

    /* renamed from: n, reason: collision with root package name */
    public static final a f24207n = new a("ACTION_REQUIRED", 2);

    /* renamed from: o, reason: collision with root package name */
    public static final a f24208o = new a("VAPID_REQUIRED", 3);

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ a[] f24209p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ F5.a f24210q;

    static {
        a[] aVarArrA = a();
        f24209p = aVarArrA;
        f24210q = F5.b.a(aVarArrA);
    }

    public a(String str, int i7) {
    }

    public static final /* synthetic */ a[] a() {
        return new a[]{f24205l, f24206m, f24207n, f24208o};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f24209p.clone();
    }
}
