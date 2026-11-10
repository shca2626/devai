package b6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: b6.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0867c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13776a = AtomicReferenceFieldUpdater.newUpdater(AbstractC0867c.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13777b = AtomicReferenceFieldUpdater.newUpdater(AbstractC0867c.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public AbstractC0867c(AbstractC0867c abstractC0867c) {
        this._prev$volatile = abstractC0867c;
    }

    public final void c() {
        f13777b.set(this, null);
    }

    public final AbstractC0867c d() {
        AbstractC0867c abstractC0867cH = h();
        while (abstractC0867cH != null && abstractC0867cH.k()) {
            abstractC0867cH = (AbstractC0867c) f13777b.get(abstractC0867cH);
        }
        return abstractC0867cH;
    }

    public final AbstractC0867c e() {
        AbstractC0867c abstractC0867cF;
        AbstractC0867c abstractC0867cF2 = f();
        M5.m.b(abstractC0867cF2);
        while (abstractC0867cF2.k() && (abstractC0867cF = abstractC0867cF2.f()) != null) {
            abstractC0867cF2 = abstractC0867cF;
        }
        return abstractC0867cF2;
    }

    public final AbstractC0867c f() {
        Object objG = g();
        if (objG == AbstractC0866b.f13775a) {
            return null;
        }
        return (AbstractC0867c) objG;
    }

    public final Object g() {
        return f13776a.get(this);
    }

    public final AbstractC0867c h() {
        return (AbstractC0867c) f13777b.get(this);
    }

    public abstract boolean k();

    public final boolean l() {
        return f() == null;
    }

    public final boolean m() {
        return A.b.a(f13776a, this, null, AbstractC0866b.f13775a);
    }

    public final void n() {
        Object obj;
        if (l()) {
            return;
        }
        while (true) {
            AbstractC0867c abstractC0867cD = d();
            AbstractC0867c abstractC0867cE = e();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13777b;
            do {
                obj = atomicReferenceFieldUpdater.get(abstractC0867cE);
            } while (!A.b.a(atomicReferenceFieldUpdater, abstractC0867cE, obj, ((AbstractC0867c) obj) == null ? null : abstractC0867cD));
            if (abstractC0867cD != null) {
                f13776a.set(abstractC0867cD, abstractC0867cE);
            }
            if (!abstractC0867cE.k() || abstractC0867cE.l()) {
                if (abstractC0867cD == null || !abstractC0867cD.k()) {
                    return;
                }
            }
        }
    }

    public final boolean o(AbstractC0867c abstractC0867c) {
        return A.b.a(f13776a, this, null, abstractC0867c);
    }
}
