package H5;

import M5.m;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class a extends G5.a {

    /* renamed from: H5.a$a, reason: collision with other inner class name */
    public static final class C0039a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0039a f3527a = new C0039a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f3528b;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null && num2.intValue() > 0) {
                num = num2;
            }
            f3528b = num;
        }
    }

    private final boolean c(int i7) {
        Integer num = C0039a.f3528b;
        return num == null || num.intValue() >= i7;
    }

    @Override // G5.a
    public void a(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m.e(th, "cause");
        m.e(th2, "exception");
        if (c(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
