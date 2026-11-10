package a4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: l, reason: collision with root package name */
    public static final c f10783l = new a("DATA_MASK_000", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final c f10784m = new c("DATA_MASK_001", 1) { // from class: a4.c.b
        {
            a aVar = null;
        }

        @Override // a4.c
        public boolean d(int i7, int i8) {
            return (i7 & 1) == 0;
        }
    };

    /* renamed from: n, reason: collision with root package name */
    public static final c f10785n = new c("DATA_MASK_010", 2) { // from class: a4.c.c
        {
            a aVar = null;
        }

        @Override // a4.c
        public boolean d(int i7, int i8) {
            return i8 % 3 == 0;
        }
    };

    /* renamed from: o, reason: collision with root package name */
    public static final c f10786o = new c("DATA_MASK_011", 3) { // from class: a4.c.d
        {
            a aVar = null;
        }

        @Override // a4.c
        public boolean d(int i7, int i8) {
            return (i7 + i8) % 3 == 0;
        }
    };

    /* renamed from: p, reason: collision with root package name */
    public static final c f10787p = new c("DATA_MASK_100", 4) { // from class: a4.c.e
        {
            a aVar = null;
        }

        @Override // a4.c
        public boolean d(int i7, int i8) {
            return (((i7 / 2) + (i8 / 3)) & 1) == 0;
        }
    };

    /* renamed from: q, reason: collision with root package name */
    public static final c f10788q = new c("DATA_MASK_101", 5) { // from class: a4.c.f
        {
            a aVar = null;
        }

        @Override // a4.c
        public boolean d(int i7, int i8) {
            return (i7 * i8) % 6 == 0;
        }
    };

    /* renamed from: r, reason: collision with root package name */
    public static final c f10789r = new c("DATA_MASK_110", 6) { // from class: a4.c.g
        {
            a aVar = null;
        }

        @Override // a4.c
        public boolean d(int i7, int i8) {
            return (i7 * i8) % 6 < 3;
        }
    };

    /* renamed from: s, reason: collision with root package name */
    public static final c f10790s = new c("DATA_MASK_111", 7) { // from class: a4.c.h
        {
            a aVar = null;
        }

        @Override // a4.c
        public boolean d(int i7, int i8) {
            return (((i7 + i8) + ((i7 * i8) % 3)) & 1) == 0;
        }
    };

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ c[] f10791t = a();

    public enum a extends c {
        public a(String str, int i7) {
            super(str, i7, null);
        }

        @Override // a4.c
        public boolean d(int i7, int i8) {
            return ((i7 + i8) & 1) == 0;
        }
    }

    public c(String str, int i7) {
    }

    public static /* synthetic */ c[] a() {
        return new c[]{f10783l, f10784m, f10785n, f10786o, f10787p, f10788q, f10789r, f10790s};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f10791t.clone();
    }

    public abstract boolean d(int i7, int i8);

    public final void e(J3.b bVar, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            for (int i9 = 0; i9 < i7; i9++) {
                if (d(i8, i9)) {
                    bVar.f(i9, i8);
                }
            }
        }
    }

    public /* synthetic */ c(String str, int i7, a aVar) {
        this(str, i7);
    }
}
