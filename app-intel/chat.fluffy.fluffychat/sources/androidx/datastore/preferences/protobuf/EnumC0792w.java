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
public final class EnumC0792w {

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC0792w f12253o;

    /* renamed from: p, reason: collision with root package name */
    public static final EnumC0792w f12254p;

    /* renamed from: q, reason: collision with root package name */
    public static final EnumC0792w f12255q;

    /* renamed from: r, reason: collision with root package name */
    public static final EnumC0792w f12256r;

    /* renamed from: s, reason: collision with root package name */
    public static final EnumC0792w f12257s;

    /* renamed from: t, reason: collision with root package name */
    public static final EnumC0792w f12258t;

    /* renamed from: u, reason: collision with root package name */
    public static final EnumC0792w f12259u;

    /* renamed from: v, reason: collision with root package name */
    public static final EnumC0792w f12260v;

    /* renamed from: w, reason: collision with root package name */
    public static final EnumC0792w f12261w;

    /* renamed from: x, reason: collision with root package name */
    public static final EnumC0792w f12262x;

    /* renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ EnumC0792w[] f12263y;

    /* renamed from: l, reason: collision with root package name */
    public final Class f12264l;

    /* renamed from: m, reason: collision with root package name */
    public final Class f12265m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f12266n;

    static {
        EnumC0792w enumC0792w = new EnumC0792w("VOID", 0, Void.class, Void.class, null);
        f12253o = enumC0792w;
        Class cls = Integer.TYPE;
        EnumC0792w enumC0792w2 = new EnumC0792w("INT", 1, cls, Integer.class, 0);
        f12254p = enumC0792w2;
        EnumC0792w enumC0792w3 = new EnumC0792w("LONG", 2, Long.TYPE, Long.class, 0L);
        f12255q = enumC0792w3;
        EnumC0792w enumC0792w4 = new EnumC0792w("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f12256r = enumC0792w4;
        EnumC0792w enumC0792w5 = new EnumC0792w("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f12257s = enumC0792w5;
        EnumC0792w enumC0792w6 = new EnumC0792w("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f12258t = enumC0792w6;
        EnumC0792w enumC0792w7 = new EnumC0792w("STRING", 6, String.class, String.class, "");
        f12259u = enumC0792w7;
        EnumC0792w enumC0792w8 = new EnumC0792w("BYTE_STRING", 7, AbstractC0776f.class, AbstractC0776f.class, AbstractC0776f.f12025m);
        f12260v = enumC0792w8;
        EnumC0792w enumC0792w9 = new EnumC0792w("ENUM", 8, cls, Integer.class, null);
        f12261w = enumC0792w9;
        EnumC0792w enumC0792w10 = new EnumC0792w("MESSAGE", 9, Object.class, Object.class, null);
        f12262x = enumC0792w10;
        f12263y = new EnumC0792w[]{enumC0792w, enumC0792w2, enumC0792w3, enumC0792w4, enumC0792w5, enumC0792w6, enumC0792w7, enumC0792w8, enumC0792w9, enumC0792w10};
    }

    public EnumC0792w(String str, int i7, Class cls, Class cls2, Object obj) {
        this.f12264l = cls;
        this.f12265m = cls2;
        this.f12266n = obj;
    }

    public static EnumC0792w valueOf(String str) {
        return (EnumC0792w) Enum.valueOf(EnumC0792w.class, str);
    }

    public static EnumC0792w[] values() {
        return (EnumC0792w[]) f12263y.clone();
    }

    public Class a() {
        return this.f12265m;
    }
}
