package r5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class D {

    /* renamed from: m, reason: collision with root package name */
    public static final a f22185m;

    /* renamed from: n, reason: collision with root package name */
    public static final D f22186n = new D("DASH", 0, 0);

    /* renamed from: o, reason: collision with root package name */
    public static final D f22187o = new D("HLS", 1, 1);

    /* renamed from: p, reason: collision with root package name */
    public static final D f22188p = new D("SS", 2, 2);

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ D[] f22189q;

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ F5.a f22190r;

    /* renamed from: l, reason: collision with root package name */
    public final int f22191l;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final D a(int i7) {
            for (D d7 : D.values()) {
                if (d7.d() == i7) {
                    return d7;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        D[] dArrA = a();
        f22189q = dArrA;
        f22190r = F5.b.a(dArrA);
        f22185m = new a(null);
    }

    public D(String str, int i7, int i8) {
        this.f22191l = i8;
    }

    public static final /* synthetic */ D[] a() {
        return new D[]{f22186n, f22187o, f22188p};
    }

    public static D valueOf(String str) {
        return (D) Enum.valueOf(D.class, str);
    }

    public static D[] values() {
        return (D[]) f22189q.clone();
    }

    public final int d() {
        return this.f22191l;
    }
}
