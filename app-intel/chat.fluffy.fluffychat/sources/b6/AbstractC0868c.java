package b6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: b6.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0868c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13776a = AtomicReferenceFieldUpdater.newUpdater(AbstractC0868c.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13777b = AtomicReferenceFieldUpdater.newUpdater(AbstractC0868c.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public AbstractC0868c(AbstractC0868c abstractC0868c) {
        this._prev$volatile = abstractC0868c;
    }

    public final void c() {
        f13777b.set(this, null);
    }

    public final AbstractC0868c d() {
        AbstractC0868c abstractC0868cH = h();
        while (abstractC0868cH != null && abstractC0868cH.k()) {
            abstractC0868cH = (AbstractC0868c) f13777b.get(abstractC0868cH);
        }
        return abstractC0868cH;
    }

    public final AbstractC0868c e() {
        AbstractC0868c abstractC0868cF;
        AbstractC0868c abstractC0868cF2 = f();
        M5.m.b(abstractC0868cF2);
        while (abstractC0868cF2.k() && (abstractC0868cF = abstractC0868cF2.f()) != null) {
            abstractC0868cF2 = abstractC0868cF;
        }
        return abstractC0868cF2;
    }

    public final AbstractC0868c f() {
        Object objG = g();
        if (objG == AbstractC0867b.f13775a) {
            return null;
        }
        return (AbstractC0868c) objG;
    }

    public final Object g() {
        return f13776a.get(this);
    }

    public final AbstractC0868c h() {
        return (AbstractC0868c) f13777b.get(this);
    }

    public abstract boolean k();

    public final boolean l() {
        return f() == null;
    }

    public final boolean m() {
        return A.b.a(f13776a, this, null, AbstractC0867b.f13775a);
    }

    public final void n() {
        Object obj;
        if (l()) {
            return;
        }
        while (true) {
            AbstractC0868c abstractC0868cD = d();
            AbstractC0868c abstractC0868cE = e();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13777b;
            do {
                obj = atomicReferenceFieldUpdater.get(abstractC0868cE);
            } while (!A.b.a(atomicReferenceFieldUpdater, abstractC0868cE, obj, ((AbstractC0868c) obj) == null ? null : abstractC0868cD));
            if (abstractC0868cD != null) {
                f13776a.set(abstractC0868cD, abstractC0868cE);
            }
            if (!abstractC0868cE.k() || abstractC0868cE.l()) {
                if (abstractC0868cD == null || !abstractC0868cD.k()) {
                    return;
                }
            }
        }
    }

    public final boolean o(AbstractC0868c abstractC0868c) {
        return A.b.a(f13776a, this, null, abstractC0868c);
    }
}
