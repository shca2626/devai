package r5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class B {

    /* renamed from: m, reason: collision with root package name */
    public static final a f22176m;

    /* renamed from: n, reason: collision with root package name */
    public static final B f22177n = new B("IDLE", 0, 0);

    /* renamed from: o, reason: collision with root package name */
    public static final B f22178o = new B("BUFFERING", 1, 1);

    /* renamed from: p, reason: collision with root package name */
    public static final B f22179p = new B("READY", 2, 2);

    /* renamed from: q, reason: collision with root package name */
    public static final B f22180q = new B("ENDED", 3, 3);

    /* renamed from: r, reason: collision with root package name */
    public static final B f22181r = new B("UNKNOWN", 4, 4);

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ B[] f22182s;

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ F5.a f22183t;

    /* renamed from: l, reason: collision with root package name */
    public final int f22184l;

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
        f22182s = bArrA;
        f22183t = F5.b.a(bArrA);
        f22176m = new a(null);
    }

    public B(String str, int i7, int i8) {
        this.f22184l = i8;
    }

    public static final /* synthetic */ B[] a() {
        return new B[]{f22177n, f22178o, f22179p, f22180q, f22181r};
    }

    public static B valueOf(String str) {
        return (B) Enum.valueOf(B.class, str);
    }

    public static B[] values() {
        return (B[]) f22182s.clone();
    }

    public final int d() {
        return this.f22184l;
    }
}
