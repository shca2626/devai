package o5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: E, reason: collision with root package name */
    public static final /* synthetic */ d[] f20428E;

    /* renamed from: F, reason: collision with root package name */
    public static final /* synthetic */ F5.a f20429F;

    /* renamed from: m, reason: collision with root package name */
    public static final a f20430m;

    /* renamed from: l, reason: collision with root package name */
    public final int f20444l;

    /* renamed from: n, reason: collision with root package name */
    public static final d f20431n = new d("SUCCESS", 0, 0);

    /* renamed from: o, reason: collision with root package name */
    public static final d f20432o = new d("NEGATIVE_BUTTON", 1, 1);

    /* renamed from: p, reason: collision with root package name */
    public static final d f20433p = new d("USER_CANCELED", 2, 2);

    /* renamed from: q, reason: collision with root package name */
    public static final d f20434q = new d("SYSTEM_CANCELED", 3, 3);

    /* renamed from: r, reason: collision with root package name */
    public static final d f20435r = new d("TIMEOUT", 4, 4);

    /* renamed from: s, reason: collision with root package name */
    public static final d f20436s = new d("ALREADY_IN_PROGRESS", 5, 5);

    /* renamed from: t, reason: collision with root package name */
    public static final d f20437t = new d("NO_ACTIVITY", 6, 6);

    /* renamed from: u, reason: collision with root package name */
    public static final d f20438u = new d("NOT_FRAGMENT_ACTIVITY", 7, 7);

    /* renamed from: v, reason: collision with root package name */
    public static final d f20439v = new d("NO_CREDENTIALS", 8, 8);

    /* renamed from: w, reason: collision with root package name */
    public static final d f20440w = new d("NO_HARDWARE", 9, 9);

    /* renamed from: x, reason: collision with root package name */
    public static final d f20441x = new d("HARDWARE_UNAVAILABLE", 10, 10);

    /* renamed from: y, reason: collision with root package name */
    public static final d f20442y = new d("NOT_ENROLLED", 11, 11);

    /* renamed from: z, reason: collision with root package name */
    public static final d f20443z = new d("LOCKED_OUT_TEMPORARILY", 12, 12);

    /* renamed from: A, reason: collision with root package name */
    public static final d f20424A = new d("LOCKED_OUT_PERMANENTLY", 13, 13);

    /* renamed from: B, reason: collision with root package name */
    public static final d f20425B = new d("NO_SPACE", 14, 14);

    /* renamed from: C, reason: collision with root package name */
    public static final d f20426C = new d("SECURITY_UPDATE_REQUIRED", 15, 15);

    /* renamed from: D, reason: collision with root package name */
    public static final d f20427D = new d("UNKNOWN_ERROR", 16, 16);

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final d a(int i7) {
            for (d dVar : d.values()) {
                if (dVar.d() == i7) {
                    return dVar;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        d[] dVarArrA = a();
        f20428E = dVarArrA;
        f20429F = F5.b.a(dVarArrA);
        f20430m = new a(null);
    }

    public d(String str, int i7, int i8) {
        this.f20444l = i8;
    }

    public static final /* synthetic */ d[] a() {
        return new d[]{f20431n, f20432o, f20433p, f20434q, f20435r, f20436s, f20437t, f20438u, f20439v, f20440w, f20441x, f20442y, f20443z, f20424A, f20425B, f20426C, f20427D};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f20428E.clone();
    }

    public final int d() {
        return this.f20444l;
    }
}
