package D4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: m, reason: collision with root package name */
    public static final a f1779m;

    /* renamed from: n, reason: collision with root package name */
    public static final e f1780n = new e("NOTHING", 0, 1);

    /* renamed from: o, reason: collision with root package name */
    public static final e f1781o = new e("ONCE", 1, 2);

    /* renamed from: p, reason: collision with root package name */
    public static final e f1782p = new e("REPEAT", 2, 3);

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ e[] f1783q;

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ F5.a f1784r;

    /* renamed from: l, reason: collision with root package name */
    public final int f1785l;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final e a(int i7) {
            e eVar;
            e[] eVarArrValues = e.values();
            int length = eVarArrValues.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    eVar = null;
                    break;
                }
                eVar = eVarArrValues[i8];
                if (eVar.d() == i7) {
                    break;
                }
                i8++;
            }
            return eVar == null ? e.f1780n : eVar;
        }

        public a() {
        }
    }

    static {
        e[] eVarArrA = a();
        f1783q = eVarArrA;
        f1784r = F5.b.a(eVarArrA);
        f1779m = new a(null);
    }

    public e(String str, int i7, int i8) {
        this.f1785l = i8;
    }

    public static final /* synthetic */ e[] a() {
        return new e[]{f1780n, f1781o, f1782p};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f1783q.clone();
    }

    public final int d() {
        return this.f1785l;
    }
}
