package p5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class N {

    /* renamed from: m, reason: collision with root package name */
    public static final a f20976m;

    /* renamed from: n, reason: collision with root package name */
    public static final N f20977n = new N("PLATFORM_ENCODED", 0, 0);

    /* renamed from: o, reason: collision with root package name */
    public static final N f20978o = new N("JSON_ENCODED", 1, 1);

    /* renamed from: p, reason: collision with root package name */
    public static final N f20979p = new N("UNEXPECTED_STRING", 2, 2);

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ N[] f20980q;

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ F5.a f20981r;

    /* renamed from: l, reason: collision with root package name */
    public final int f20982l;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final N a(int i7) {
            for (N n7 : N.values()) {
                if (n7.d() == i7) {
                    return n7;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        N[] nArrA = a();
        f20980q = nArrA;
        f20981r = F5.b.a(nArrA);
        f20976m = new a(null);
    }

    public N(String str, int i7, int i8) {
        this.f20982l = i8;
    }

    public static final /* synthetic */ N[] a() {
        return new N[]{f20977n, f20978o, f20979p};
    }

    public static N valueOf(String str) {
        return (N) Enum.valueOf(N.class, str);
    }

    public static N[] values() {
        return (N[]) f20980q.clone();
    }

    public final int d() {
        return this.f20982l;
    }
}
