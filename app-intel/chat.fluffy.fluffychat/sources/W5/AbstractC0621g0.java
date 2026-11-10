package W5;

import b6.AbstractC0877m;
import z5.C1874h;

/* renamed from: W5.g0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0621g0 extends J {

    /* renamed from: n, reason: collision with root package name */
    public long f9147n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f9148o;

    /* renamed from: p, reason: collision with root package name */
    public C1874h f9149p;

    public static /* synthetic */ void Z(AbstractC0621g0 abstractC0621g0, boolean z7, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        abstractC0621g0.Y(z7);
    }

    public static /* synthetic */ void e0(AbstractC0621g0 abstractC0621g0, boolean z7, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        abstractC0621g0.d0(z7);
    }

    @Override // W5.J
    public final J W(int i7, String str) {
        AbstractC0877m.a(i7);
        return AbstractC0877m.b(this, str);
    }

    public final void Y(boolean z7) {
        long jA0 = this.f9147n - a0(z7);
        this.f9147n = jA0;
        if (jA0 <= 0 && this.f9148o) {
            shutdown();
        }
    }

    public final long a0(boolean z7) {
        return z7 ? 4294967296L : 1L;
    }

    public final void b0(AbstractC0609a0 abstractC0609a0) {
        C1874h c1874h = this.f9149p;
        if (c1874h == null) {
            c1874h = new C1874h();
            this.f9149p = c1874h;
        }
        c1874h.addLast(abstractC0609a0);
    }

    public long c0() {
        C1874h c1874h = this.f9149p;
        return (c1874h == null || c1874h.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void d0(boolean z7) {
        this.f9147n += a0(z7);
        if (z7) {
            return;
        }
        this.f9148o = true;
    }

    public final boolean f0() {
        return this.f9147n >= a0(true);
    }

    public final boolean g0() {
        C1874h c1874h = this.f9149p;
        if (c1874h != null) {
            return c1874h.isEmpty();
        }
        return true;
    }

    public long h0() {
        return !i0() ? Long.MAX_VALUE : 0L;
    }

    public final boolean i0() {
        AbstractC0609a0 abstractC0609a0;
        C1874h c1874h = this.f9149p;
        if (c1874h == null || (abstractC0609a0 = (AbstractC0609a0) c1874h.q()) == null) {
            return false;
        }
        abstractC0609a0.run();
        return true;
    }

    public void shutdown() {
    }
}
