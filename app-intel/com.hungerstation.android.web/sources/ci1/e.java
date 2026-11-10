package ci1;

/* loaded from: classes6.dex */
public final class e {
    public static <T> void a(T t12, Class<T> cls) {
        if (t12 != null) {
            return;
        }
        throw new IllegalStateException(cls.getCanonicalName() + " must be set");
    }

    public static <T> T b(T t12) {
        t12.getClass();
        return t12;
    }

    public static <T> T c(T t12, String str) {
        if (t12 != null) {
            return t12;
        }
        throw new NullPointerException(str);
    }

    public static <T> T d(T t12, String str, Object obj) {
        if (t12 != null) {
            return t12;
        }
        if (!str.contains("%s")) {
            throw new IllegalArgumentException("errorMessageTemplate has no format specifiers");
        }
        if (str.indexOf("%s") == str.lastIndexOf("%s")) {
            throw new NullPointerException(str.replace("%s", obj instanceof Class ? ((Class) obj).getCanonicalName() : String.valueOf(obj)));
        }
        throw new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
    }

    public static <T> T e(T t12) {
        if (t12 != null) {
            return t12;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
}
