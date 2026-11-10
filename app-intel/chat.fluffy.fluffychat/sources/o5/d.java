package o5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: E, reason: collision with root package name */
    public static final /* synthetic */ d[] f20429E;

    /* renamed from: F, reason: collision with root package name */
    public static final /* synthetic */ F5.a f20430F;

    /* renamed from: m, reason: collision with root package name */
    public static final a f20431m;

    /* renamed from: l, reason: collision with root package name */
    public final int f20445l;

    /* renamed from: n, reason: collision with root package name */
    public static final d f20432n = new d("SUCCESS", 0, 0);

    /* renamed from: o, reason: collision with root package name */
    public static final d f20433o = new d("NEGATIVE_BUTTON", 1, 1);

    /* renamed from: p, reason: collision with root package name */
    public static final d f20434p = new d("USER_CANCELED", 2, 2);

    /* renamed from: q, reason: collision with root package name */
    public static final d f20435q = new d("SYSTEM_CANCELED", 3, 3);

    /* renamed from: r, reason: collision with root package name */
    public static final d f20436r = new d("TIMEOUT", 4, 4);

    /* renamed from: s, reason: collision with root package name */
    public static final d f20437s = new d("ALREADY_IN_PROGRESS", 5, 5);

    /* renamed from: t, reason: collision with root package name */
    public static final d f20438t = new d("NO_ACTIVITY", 6, 6);

    /* renamed from: u, reason: collision with root package name */
    public static final d f20439u = new d("NOT_FRAGMENT_ACTIVITY", 7, 7);

    /* renamed from: v, reason: collision with root package name */
    public static final d f20440v = new d("NO_CREDENTIALS", 8, 8);

    /* renamed from: w, reason: collision with root package name */
    public static final d f20441w = new d("NO_HARDWARE", 9, 9);

    /* renamed from: x, reason: collision with root package name */
    public static final d f20442x = new d("HARDWARE_UNAVAILABLE", 10, 10);

    /* renamed from: y, reason: collision with root package name */
    public static final d f20443y = new d("NOT_ENROLLED", 11, 11);

    /* renamed from: z, reason: collision with root package name */
    public static final d f20444z = new d("LOCKED_OUT_TEMPORARILY", 12, 12);

    /* renamed from: A, reason: collision with root package name */
    public static final d f20425A = new d("LOCKED_OUT_PERMANENTLY", 13, 13);

    /* renamed from: B, reason: collision with root package name */
    public static final d f20426B = new d("NO_SPACE", 14, 14);

    /* renamed from: C, reason: collision with root package name */
    public static final d f20427C = new d("SECURITY_UPDATE_REQUIRED", 15, 15);

    /* renamed from: D, reason: collision with root package name */
    public static final d f20428D = new d("UNKNOWN_ERROR", 16, 16);

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
        f20429E = dVarArrA;
        f20430F = F5.b.a(dVarArrA);
        f20431m = new a(null);
    }

    public d(String str, int i7, int i8) {
        this.f20445l = i8;
    }

    public static final /* synthetic */ d[] a() {
        return new d[]{f20432n, f20433o, f20434p, f20435q, f20436r, f20437s, f20438t, f20439u, f20440v, f20441w, f20442x, f20443y, f20444z, f20425A, f20426B, f20427C, f20428D};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f20429E.clone();
    }

    public final int d() {
        return this.f20445l;
    }
}
