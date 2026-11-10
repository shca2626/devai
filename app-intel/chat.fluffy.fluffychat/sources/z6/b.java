package z6;

/* loaded from: classes3.dex */
public abstract class b {
    public static final a a(String str) {
        a aVarValueOf;
        if (str != null) {
            try {
                aVarValueOf = a.valueOf(str);
            } catch (IllegalArgumentException unused) {
                aVarValueOf = a.f24179l;
            }
            if (aVarValueOf != null) {
                return aVarValueOf;
            }
        }
        return a.f24179l;
    }
}
