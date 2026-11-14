package b6;

import W5.K0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: b6.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0850B extends AbstractC0868c implements K0 {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f13757d = AtomicIntegerFieldUpdater.newUpdater(AbstractC0850B.class, "cleanedAndPointers$volatile");

    /* renamed from: c, reason: collision with root package name */
    public final long f13758c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public AbstractC0850B(long j7, AbstractC0850B abstractC0850B, int i7) {
        super(abstractC0850B);
        this.f13758c = j7;
        this.cleanedAndPointers$volatile = i7 << 16;
    }

    @Override // b6.AbstractC0868c
    public boolean k() {
        return f13757d.get(this) == r() && !l();
    }

    public final boolean p() {
        return f13757d.addAndGet(this, -65536) == r() && !l();
    }

    public abstract int r();

    public abstract void s(int i7, Throwable th, C5.i iVar);

    public final void t() {
        if (f13757d.incrementAndGet(this) == r()) {
            n();
        }
    }

    public final boolean u() {
        int i7;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f13757d;
        do {
            i7 = atomicIntegerFieldUpdater.get(this);
            if (i7 == r() && !l()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i7, 65536 + i7));
        return true;
    }
}
