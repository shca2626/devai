package androidx.datastore.preferences.protobuf;

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
/* renamed from: androidx.datastore.preferences.protobuf.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0791w {

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC0791w f12253o;

    /* renamed from: p, reason: collision with root package name */
    public static final EnumC0791w f12254p;

    /* renamed from: q, reason: collision with root package name */
    public static final EnumC0791w f12255q;

    /* renamed from: r, reason: collision with root package name */
    public static final EnumC0791w f12256r;

    /* renamed from: s, reason: collision with root package name */
    public static final EnumC0791w f12257s;

    /* renamed from: t, reason: collision with root package name */
    public static final EnumC0791w f12258t;

    /* renamed from: u, reason: collision with root package name */
    public static final EnumC0791w f12259u;

    /* renamed from: v, reason: collision with root package name */
    public static final EnumC0791w f12260v;

    /* renamed from: w, reason: collision with root package name */
    public static final EnumC0791w f12261w;

    /* renamed from: x, reason: collision with root package name */
    public static final EnumC0791w f12262x;

    /* renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ EnumC0791w[] f12263y;

    /* renamed from: l, reason: collision with root package name */
    public final Class f12264l;

    /* renamed from: m, reason: collision with root package name */
    public final Class f12265m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f12266n;

    static {
        EnumC0791w enumC0791w = new EnumC0791w("VOID", 0, Void.class, Void.class, null);
        f12253o = enumC0791w;
        Class cls = Integer.TYPE;
        EnumC0791w enumC0791w2 = new EnumC0791w("INT", 1, cls, Integer.class, 0);
        f12254p = enumC0791w2;
        EnumC0791w enumC0791w3 = new EnumC0791w("LONG", 2, Long.TYPE, Long.class, 0L);
        f12255q = enumC0791w3;
        EnumC0791w enumC0791w4 = new EnumC0791w("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f12256r = enumC0791w4;
        EnumC0791w enumC0791w5 = new EnumC0791w("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f12257s = enumC0791w5;
        EnumC0791w enumC0791w6 = new EnumC0791w("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f12258t = enumC0791w6;
        EnumC0791w enumC0791w7 = new EnumC0791w("STRING", 6, String.class, String.class, "");
        f12259u = enumC0791w7;
        EnumC0791w enumC0791w8 = new EnumC0791w("BYTE_STRING", 7, AbstractC0775f.class, AbstractC0775f.class, AbstractC0775f.f12025m);
        f12260v = enumC0791w8;
        EnumC0791w enumC0791w9 = new EnumC0791w("ENUM", 8, cls, Integer.class, null);
        f12261w = enumC0791w9;
        EnumC0791w enumC0791w10 = new EnumC0791w("MESSAGE", 9, Object.class, Object.class, null);
        f12262x = enumC0791w10;
        f12263y = new EnumC0791w[]{enumC0791w, enumC0791w2, enumC0791w3, enumC0791w4, enumC0791w5, enumC0791w6, enumC0791w7, enumC0791w8, enumC0791w9, enumC0791w10};
    }

    public EnumC0791w(String str, int i7, Class cls, Class cls2, Object obj) {
        this.f12264l = cls;
        this.f12265m = cls2;
        this.f12266n = obj;
    }

    public static EnumC0791w valueOf(String str) {
        return (EnumC0791w) Enum.valueOf(EnumC0791w.class, str);
    }

    public static EnumC0791w[] values() {
        return (EnumC0791w[]) f12263y.clone();
    }

    public Class a() {
        return this.f12265m;
    }
}
