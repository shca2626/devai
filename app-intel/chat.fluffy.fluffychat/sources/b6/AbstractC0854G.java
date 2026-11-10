package b6;

/* renamed from: b6.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0854G {

    /* renamed from: a, reason: collision with root package name */
    public static final int f13763a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f13763a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
