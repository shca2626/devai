package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public abstract class l0 {

    /* renamed from: a, reason: collision with root package name */
    public static final int f12114a = c(1, 3);

    /* renamed from: b, reason: collision with root package name */
    public static final int f12115b = c(1, 4);

    /* renamed from: c, reason: collision with root package name */
    public static final int f12116c = c(2, 0);

    /* renamed from: d, reason: collision with root package name */
    public static final int f12117d = c(3, 2);

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'p' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static class b {

        /* renamed from: A, reason: collision with root package name */
        public static final b f12118A;

        /* renamed from: B, reason: collision with root package name */
        public static final b f12119B;

        /* renamed from: C, reason: collision with root package name */
        public static final b f12120C;

        /* renamed from: D, reason: collision with root package name */
        public static final b f12121D;

        /* renamed from: E, reason: collision with root package name */
        public static final b f12122E;

        /* renamed from: F, reason: collision with root package name */
        public static final /* synthetic */ b[] f12123F;

        /* renamed from: n, reason: collision with root package name */
        public static final b f12124n;

        /* renamed from: o, reason: collision with root package name */
        public static final b f12125o;

        /* renamed from: p, reason: collision with root package name */
        public static final b f12126p;

        /* renamed from: q, reason: collision with root package name */
        public static final b f12127q;

        /* renamed from: r, reason: collision with root package name */
        public static final b f12128r;

        /* renamed from: s, reason: collision with root package name */
        public static final b f12129s;

        /* renamed from: t, reason: collision with root package name */
        public static final b f12130t;

        /* renamed from: u, reason: collision with root package name */
        public static final b f12131u;

        /* renamed from: v, reason: collision with root package name */
        public static final b f12132v;

        /* renamed from: w, reason: collision with root package name */
        public static final b f12133w;

        /* renamed from: x, reason: collision with root package name */
        public static final b f12134x;

        /* renamed from: y, reason: collision with root package name */
        public static final b f12135y;

        /* renamed from: z, reason: collision with root package name */
        public static final b f12136z;

        /* renamed from: l, reason: collision with root package name */
        public final c f12137l;

        /* renamed from: m, reason: collision with root package name */
        public final int f12138m;

        public enum a extends b {
            public a(String str, int i7, c cVar, int i8) {
                super(str, i7, cVar, i8);
            }
        }

        /* renamed from: androidx.datastore.preferences.protobuf.l0$b$b, reason: collision with other inner class name */
        public enum C0104b extends b {
            public C0104b(String str, int i7, c cVar, int i8) {
                super(str, i7, cVar, i8);
            }
        }

        public enum c extends b {
            public c(String str, int i7, c cVar, int i8) {
                super(str, i7, cVar, i8);
            }
        }

        public enum d extends b {
            public d(String str, int i7, c cVar, int i8) {
                super(str, i7, cVar, i8);
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            f12124n = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            f12125o = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            f12126p = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            f12127q = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            f12128r = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            f12129s = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            f12130t = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            f12131u = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            f12132v = aVar;
            c cVar3 = c.MESSAGE;
            C0104b c0104b = new C0104b("GROUP", 9, cVar3, 3);
            f12133w = c0104b;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            f12134x = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            f12135y = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            f12136z = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            f12118A = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            f12119B = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            f12120C = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            f12121D = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            f12122E = bVar14;
            f12123F = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c0104b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f12123F.clone();
        }

        public c a() {
            return this.f12137l;
        }

        public int d() {
            return this.f12138m;
        }

        public b(String str, int i7, c cVar, int i8) {
            this.f12137l = cVar;
            this.f12138m = i8;
        }
    }

    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(AbstractC0776f.f12025m),
        ENUM(null),
        MESSAGE(null);


        /* renamed from: l, reason: collision with root package name */
        public final Object f12149l;

        c(Object obj) {
            this.f12149l = obj;
        }
    }

    public static int a(int i7) {
        return i7 >>> 3;
    }

    public static int b(int i7) {
        return i7 & 7;
    }

    public static int c(int i7, int i8) {
        return (i7 << 3) | i8;
    }
}
