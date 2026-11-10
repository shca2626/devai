package I5;

import Q5.c;

/* loaded from: classes.dex */
public class a extends H5.a {

    /* renamed from: I5.a$a, reason: collision with other inner class name */
    public static final class C0042a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0042a f4290a = new C0042a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f4291b;

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
            f4291b = num;
        }
    }

    @Override // G5.a
    public c b() {
        return c(34) ? new R5.a() : super.b();
    }

    public final boolean c(int i7) {
        Integer num = C0042a.f4291b;
        return num == null || num.intValue() >= i7;
    }
}
