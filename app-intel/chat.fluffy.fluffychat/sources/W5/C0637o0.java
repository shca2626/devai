package W5;

import b6.AbstractC0865a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: W5.o0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0637o0 extends AbstractC0635n0 implements W {

    /* renamed from: o, reason: collision with root package name */
    public final Executor f9169o;

    public C0637o0(Executor executor) {
        this.f9169o = executor;
        AbstractC0865a.a(Z());
    }

    @Override // W5.W
    public void P(long j7, InterfaceC0632m interfaceC0632m) {
        long j8;
        Executor executorZ = Z();
        ScheduledFuture scheduledFutureA0 = null;
        ScheduledExecutorService scheduledExecutorService = executorZ instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorZ : null;
        if (scheduledExecutorService != null) {
            j8 = j7;
            scheduledFutureA0 = a0(scheduledExecutorService, new N0(this, interfaceC0632m), interfaceC0632m.getContext(), j8);
        } else {
            j8 = j7;
        }
        if (scheduledFutureA0 != null) {
            AbstractC0640q.c(interfaceC0632m, new C0628k(scheduledFutureA0));
        } else {
            S.f9122t.P(j8, interfaceC0632m);
        }
    }

    @Override // W5.J
    public void U(C5.i iVar, Runnable runnable) {
        Runnable runnableH;
        try {
            Executor executorZ = Z();
            AbstractC0610b abstractC0610b = AbstractC0612c.f9137a;
            if (abstractC0610b == null || (runnableH = abstractC0610b.h(runnable)) == null) {
                runnableH = runnable;
            }
            executorZ.execute(runnableH);
        } catch (RejectedExecutionException e7) {
            AbstractC0610b abstractC0610b2 = AbstractC0612c.f9137a;
            if (abstractC0610b2 != null) {
                abstractC0610b2.e();
            }
            Y(iVar, e7);
            C0613c0.b().U(iVar, runnable);
        }
    }

    public final void Y(C5.i iVar, RejectedExecutionException rejectedExecutionException) {
        z0.c(iVar, AbstractC0631l0.a("The task was rejected", rejectedExecutionException));
    }

    public Executor Z() {
        return this.f9169o;
    }

    public final ScheduledFuture a0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, C5.i iVar, long j7) {
        try {
            return scheduledExecutorService.schedule(runnable, j7, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e7) {
            Y(iVar, e7);
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorZ = Z();
        ExecutorService executorService = executorZ instanceof ExecutorService ? (ExecutorService) executorZ : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0637o0) && ((C0637o0) obj).Z() == Z();
    }

    public int hashCode() {
        return System.identityHashCode(Z());
    }

    @Override // W5.J
    public String toString() {
        return Z().toString();
    }
}
