package W5;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class r extends B {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9172c = AtomicIntegerFieldUpdater.newUpdater(r.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public r(C5.e eVar, Throwable th, boolean z7) {
        if (th == null) {
            th = new CancellationException("Continuation " + eVar + " was cancelled normally");
        }
        super(th, z7);
    }

    public final boolean e() {
        return f9172c.compareAndSet(this, 0, 1);
    }
}
