package d4;

import y5.C1811f;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: d4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0991a {

    /* renamed from: l, reason: collision with root package name */
    public static final EnumC0991a f15175l = new EnumC0991a("PERMISSION", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC0991a f15176m = new EnumC0991a("UNSUPPORTED", 1);

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC0991a f15177n = new EnumC0991a("NOT_FOUND", 2);

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC0991a f15178o = new EnumC0991a("UNKNOWN", 3);

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ EnumC0991a[] f15179p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ F5.a f15180q;

    /* renamed from: d4.a$a, reason: collision with other inner class name */
    public static final /* synthetic */ class C0155a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15181a;

        static {
            int[] iArr = new int[EnumC0991a.values().length];
            try {
                iArr[EnumC0991a.f15175l.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC0991a.f15176m.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC0991a.f15177n.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC0991a.f15178o.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f15181a = iArr;
        }
    }

    static {
        EnumC0991a[] enumC0991aArrA = a();
        f15179p = enumC0991aArrA;
        f15180q = F5.b.a(enumC0991aArrA);
    }

    public EnumC0991a(String str, int i7) {
    }

    public static final /* synthetic */ EnumC0991a[] a() {
        return new EnumC0991a[]{f15175l, f15176m, f15177n, f15178o};
    }

    public static EnumC0991a valueOf(String str) {
        return (EnumC0991a) Enum.valueOf(EnumC0991a.class, str);
    }

    public static EnumC0991a[] values() {
        return (EnumC0991a[]) f15179p.clone();
    }

    public final String d() {
        int i7 = C0155a.f15181a[ordinal()];
        if (i7 == 1) {
            return "permission";
        }
        if (i7 == 2) {
            return "unsupported";
        }
        if (i7 == 3) {
            return "notFound";
        }
        if (i7 == 4) {
            return "unknown";
        }
        throw new C1811f();
    }
}
