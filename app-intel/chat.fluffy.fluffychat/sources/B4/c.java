package B4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: l, reason: collision with root package name */
    public static final c f1140l = new c("DEVELOPER", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final c f1141m = new c("SYSTEM", 1);

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ c[] f1142n;

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ F5.a f1143o;

    static {
        c[] cVarArrA = a();
        f1142n = cVarArrA;
        f1143o = F5.b.a(cVarArrA);
    }

    public c(String str, int i7) {
    }

    public static final /* synthetic */ c[] a() {
        return new c[]{f1140l, f1141m};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f1142n.clone();
    }
}
