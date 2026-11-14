package y4;

import java.io.File;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f24007a = new b();

    public final Object a(Object obj) {
        obj.getClass();
        return obj;
    }

    public final void b(String str) {
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (SecurityException unused) {
        }
    }

    public final Object c(Object obj, Object obj2) {
        return obj == null ? a(obj2) : obj;
    }
}
