package N4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: m, reason: collision with root package name */
    public static final a f6435m;

    /* renamed from: n, reason: collision with root package name */
    public static final n f6436n = new n("SECURITY_EXCEPTION", 0, 0);

    /* renamed from: o, reason: collision with root package name */
    public static final n f6437o = new n("IO_EXCEPTION", 1, 1);

    /* renamed from: p, reason: collision with root package name */
    public static final n f6438p = new n("ILLEGAL_ARGUMENT_EXCEPTION", 2, 2);

    /* renamed from: q, reason: collision with root package name */
    public static final n f6439q = new n("ILLEGAL_STATE_EXCEPTION", 3, 3);

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ n[] f6440r;

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ F5.a f6441s;

    /* renamed from: l, reason: collision with root package name */
    public final int f6442l;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final n a(int i7) {
            for (n nVar : n.values()) {
                if (nVar.d() == i7) {
                    return nVar;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        n[] nVarArrA = a();
        f6440r = nVarArrA;
        f6441s = F5.b.a(nVarArrA);
        f6435m = new a(null);
    }

    public n(String str, int i7, int i8) {
        this.f6442l = i8;
    }

    public static final /* synthetic */ n[] a() {
        return new n[]{f6436n, f6437o, f6438p, f6439q};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f6440r.clone();
    }

    public final int d() {
        return this.f6442l;
    }
}
