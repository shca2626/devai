package z4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: z4.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1858o {

    /* renamed from: l, reason: collision with root package name */
    public static final a f24172l;

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC1858o f24173m = new EnumC1858o("DELIVER", 0);

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1858o f24174n = new EnumC1858o("CANCEL", 1);

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC1858o f24175o = new EnumC1858o("FAIL", 2);

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ EnumC1858o[] f24176p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ F5.a f24177q;

    /* renamed from: z4.o$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public static /* synthetic */ EnumC1858o b(a aVar, int i7, boolean z7, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                z7 = true;
            }
            return aVar.a(i7, z7);
        }

        public final EnumC1858o a(int i7, boolean z7) {
            return (i7 == -1 && z7) ? EnumC1858o.f24173m : i7 == 0 ? EnumC1858o.f24174n : EnumC1858o.f24175o;
        }

        public a() {
        }
    }

    static {
        EnumC1858o[] enumC1858oArrA = a();
        f24176p = enumC1858oArrA;
        f24177q = F5.b.a(enumC1858oArrA);
        f24172l = new a(null);
    }

    public EnumC1858o(String str, int i7) {
    }

    public static final /* synthetic */ EnumC1858o[] a() {
        return new EnumC1858o[]{f24173m, f24174n, f24175o};
    }

    public static EnumC1858o valueOf(String str) {
        return (EnumC1858o) Enum.valueOf(EnumC1858o.class, str);
    }

    public static EnumC1858o[] values() {
        return (EnumC1858o[]) f24176p.clone();
    }
}
