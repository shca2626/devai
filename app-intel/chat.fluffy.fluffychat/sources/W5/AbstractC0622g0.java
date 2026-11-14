package W5;

import b6.AbstractC0878m;
import z5.C1877h;

/* renamed from: W5.g0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0622g0 extends J {

    /* renamed from: n, reason: collision with root package name */
    public long f9147n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f9148o;

    /* renamed from: p, reason: collision with root package name */
    public C1877h f9149p;

    public static /* synthetic */ void Z(AbstractC0622g0 abstractC0622g0, boolean z7, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        abstractC0622g0.Y(z7);
    }

    public static /* synthetic */ void e0(AbstractC0622g0 abstractC0622g0, boolean z7, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        abstractC0622g0.d0(z7);
    }

    @Override // W5.J
    public final J W(int i7, String str) {
        AbstractC0878m.a(i7);
        return AbstractC0878m.b(this, str);
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

    public final void b0(AbstractC0610a0 abstractC0610a0) {
        C1877h c1877h = this.f9149p;
        if (c1877h == null) {
            c1877h = new C1877h();
            this.f9149p = c1877h;
        }
        c1877h.addLast(abstractC0610a0);
    }

    public long c0() {
        C1877h c1877h = this.f9149p;
        return (c1877h == null || c1877h.isEmpty()) ? Long.MAX_VALUE : 0L;
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
        C1877h c1877h = this.f9149p;
        if (c1877h != null) {
            return c1877h.isEmpty();
        }
        return true;
    }

    public long h0() {
        return !i0() ? Long.MAX_VALUE : 0L;
    }

    public final boolean i0() {
        AbstractC0610a0 abstractC0610a0;
        C1877h c1877h = this.f9149p;
        if (c1877h == null || (abstractC0610a0 = (AbstractC0610a0) c1877h.q()) == null) {
            return false;
        }
        abstractC0610a0.run();
        return true;
    }

    public void shutdown() {
    }
}
