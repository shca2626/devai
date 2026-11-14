package n5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class M {

    /* renamed from: m, reason: collision with root package name */
    public static final a f20129m;

    /* renamed from: n, reason: collision with root package name */
    public static final M f20130n = new M("CAMERA", 0, 0);

    /* renamed from: o, reason: collision with root package name */
    public static final M f20131o = new M("GALLERY", 1, 1);

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ M[] f20132p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ F5.a f20133q;

    /* renamed from: l, reason: collision with root package name */
    public final int f20134l;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final M a(int i7) {
            for (M m7 : M.values()) {
                if (m7.d() == i7) {
                    return m7;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        M[] mArrA = a();
        f20132p = mArrA;
        f20133q = F5.b.a(mArrA);
        f20129m = new a(null);
    }

    public M(String str, int i7, int i8) {
        this.f20134l = i8;
    }

    public static final /* synthetic */ M[] a() {
        return new M[]{f20130n, f20131o};
    }

    public static M valueOf(String str) {
        return (M) Enum.valueOf(M.class, str);
    }

    public static M[] values() {
        return (M[]) f20132p.clone();
    }

    public final int d() {
        return this.f20134l;
    }
}
