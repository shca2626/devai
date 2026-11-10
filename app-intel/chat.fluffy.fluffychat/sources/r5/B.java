package r5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class B {

    /* renamed from: m, reason: collision with root package name */
    public static final a f22170m;

    /* renamed from: n, reason: collision with root package name */
    public static final B f22171n = new B("IDLE", 0, 0);

    /* renamed from: o, reason: collision with root package name */
    public static final B f22172o = new B("BUFFERING", 1, 1);

    /* renamed from: p, reason: collision with root package name */
    public static final B f22173p = new B("READY", 2, 2);

    /* renamed from: q, reason: collision with root package name */
    public static final B f22174q = new B("ENDED", 3, 3);

    /* renamed from: r, reason: collision with root package name */
    public static final B f22175r = new B("UNKNOWN", 4, 4);

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ B[] f22176s;

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ F5.a f22177t;

    /* renamed from: l, reason: collision with root package name */
    public final int f22178l;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final B a(int i7) {
            for (B b7 : B.values()) {
                if (b7.d() == i7) {
                    return b7;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        B[] bArrA = a();
        f22176s = bArrA;
        f22177t = F5.b.a(bArrA);
        f22170m = new a(null);
    }

    public B(String str, int i7, int i8) {
        this.f22178l = i8;
    }

    public static final /* synthetic */ B[] a() {
        return new B[]{f22171n, f22172o, f22173p, f22174q, f22175r};
    }

    public static B valueOf(String str) {
        return (B) Enum.valueOf(B.class, str);
    }

    public static B[] values() {
        return (B[]) f22176s.clone();
    }

    public final int d() {
        return this.f22178l;
    }
}
