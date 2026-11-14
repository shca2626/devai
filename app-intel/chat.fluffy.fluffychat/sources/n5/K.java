package n5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class K {

    /* renamed from: m, reason: collision with root package name */
    public static final a f20120m;

    /* renamed from: n, reason: collision with root package name */
    public static final K f20121n = new K("REAR", 0, 0);

    /* renamed from: o, reason: collision with root package name */
    public static final K f20122o = new K("FRONT", 1, 1);

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ K[] f20123p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ F5.a f20124q;

    /* renamed from: l, reason: collision with root package name */
    public final int f20125l;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final K a(int i7) {
            for (K k7 : K.values()) {
                if (k7.d() == i7) {
                    return k7;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        K[] kArrA = a();
        f20123p = kArrA;
        f20124q = F5.b.a(kArrA);
        f20120m = new a(null);
    }

    public K(String str, int i7, int i8) {
        this.f20125l = i8;
    }

    public static final /* synthetic */ K[] a() {
        return new K[]{f20121n, f20122o};
    }

    public static K valueOf(String str) {
        return (K) Enum.valueOf(K.class, str);
    }

    public static K[] values() {
        return (K[]) f20123p.clone();
    }

    public final int d() {
        return this.f20125l;
    }
}
