package W5;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: W5.u0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0649u0 extends B0 {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9177q = AtomicIntegerFieldUpdater.newUpdater(C0649u0.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile;

    /* renamed from: p, reason: collision with root package name */
    public final L5.l f9178p;

    public C0649u0(L5.l lVar) {
        this.f9178p = lVar;
    }

    @Override // W5.B0
    public boolean v() {
        return true;
    }

    @Override // W5.B0
    public void w(Throwable th) {
        if (f9177q.compareAndSet(this, 0, 1)) {
            this.f9178p.a(th);
        }
    }
}
