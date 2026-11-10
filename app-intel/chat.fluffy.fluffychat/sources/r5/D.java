package r5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class D {

    /* renamed from: m, reason: collision with root package name */
    public static final a f22179m;

    /* renamed from: n, reason: collision with root package name */
    public static final D f22180n = new D("DASH", 0, 0);

    /* renamed from: o, reason: collision with root package name */
    public static final D f22181o = new D("HLS", 1, 1);

    /* renamed from: p, reason: collision with root package name */
    public static final D f22182p = new D("SS", 2, 2);

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ D[] f22183q;

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ F5.a f22184r;

    /* renamed from: l, reason: collision with root package name */
    public final int f22185l;

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
        f22183q = dArrA;
        f22184r = F5.b.a(dArrA);
        f22179m = new a(null);
    }

    public D(String str, int i7, int i8) {
        this.f22185l = i8;
    }

    public static final /* synthetic */ D[] a() {
        return new D[]{f22180n, f22181o, f22182p};
    }

    public static D valueOf(String str) {
        return (D) Enum.valueOf(D.class, str);
    }

    public static D[] values() {
        return (D[]) f22183q.clone();
    }

    public final int d() {
        return this.f22185l;
    }
}
