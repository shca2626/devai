package W5;

import b6.AbstractC0861M;
import b6.C0853E;

/* loaded from: classes.dex */
public final class S0 {

    /* renamed from: a, reason: collision with root package name */
    public static final S0 f9124a = new S0();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f9125b = AbstractC0861M.a(new C0853E("ThreadLocalEventLoop"));

    public final AbstractC0622g0 a() {
        return (AbstractC0622g0) f9125b.get();
    }

    public final AbstractC0622g0 b() {
        ThreadLocal threadLocal = f9125b;
        AbstractC0622g0 abstractC0622g0 = (AbstractC0622g0) threadLocal.get();
        if (abstractC0622g0 != null) {
            return abstractC0622g0;
        }
        AbstractC0622g0 abstractC0622g0A = AbstractC0628j0.a();
        threadLocal.set(abstractC0622g0A);
        return abstractC0622g0A;
    }

    public final void c() {
        f9125b.set(null);
    }

    public final void d(AbstractC0622g0 abstractC0622g0) {
        f9125b.set(abstractC0622g0);
    }
}
