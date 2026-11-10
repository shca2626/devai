package W5;

import b6.AbstractC0860M;
import b6.C0852E;

/* loaded from: classes.dex */
public final class S0 {

    /* renamed from: a, reason: collision with root package name */
    public static final S0 f9124a = new S0();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f9125b = AbstractC0860M.a(new C0852E("ThreadLocalEventLoop"));

    public final AbstractC0621g0 a() {
        return (AbstractC0621g0) f9125b.get();
    }

    public final AbstractC0621g0 b() {
        ThreadLocal threadLocal = f9125b;
        AbstractC0621g0 abstractC0621g0 = (AbstractC0621g0) threadLocal.get();
        if (abstractC0621g0 != null) {
            return abstractC0621g0;
        }
        AbstractC0621g0 abstractC0621g0A = AbstractC0627j0.a();
        threadLocal.set(abstractC0621g0A);
        return abstractC0621g0A;
    }

    public final void c() {
        f9125b.set(null);
    }

    public final void d(AbstractC0621g0 abstractC0621g0) {
        f9125b.set(abstractC0621g0);
    }
}
