package d6;

import M5.w;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f15284b = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "lastScheduledTask$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f15285c = AtomicIntegerFieldUpdater.newUpdater(l.class, "producerIndex$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f15286d = AtomicIntegerFieldUpdater.newUpdater(l.class, "consumerIndex$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f15287e = AtomicIntegerFieldUpdater.newUpdater(l.class, "blockingTasksInBuffer$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f15288a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final h a(h hVar, boolean z7) {
        if (z7) {
            return b(hVar);
        }
        h hVar2 = (h) f15284b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return b(hVar2);
    }

    public final h b(h hVar) {
        if (e() == 127) {
            return hVar;
        }
        if (hVar.f15275m) {
            f15287e.incrementAndGet(this);
        }
        int i7 = f15285c.get(this) & 127;
        while (this.f15288a.get(i7) != null) {
            Thread.yield();
        }
        this.f15288a.lazySet(i7, hVar);
        f15285c.incrementAndGet(this);
        return null;
    }

    public final void c(h hVar) {
        if (hVar == null || !hVar.f15275m) {
            return;
        }
        f15287e.decrementAndGet(this);
    }

    public final int e() {
        return f15285c.get(this) - f15286d.get(this);
    }

    public final int i() {
        return f15284b.get(this) != null ? e() + 1 : e();
    }

    public final void j(C1004d c1004d) {
        h hVar = (h) f15284b.getAndSet(this, null);
        if (hVar != null) {
            c1004d.a(hVar);
        }
        while (n(c1004d)) {
        }
    }

    public final h k() {
        h hVar = (h) f15284b.getAndSet(this, null);
        return hVar == null ? m() : hVar;
    }

    public final h l() {
        return o(true);
    }

    public final h m() {
        h hVar;
        while (true) {
            int i7 = f15286d.get(this);
            if (i7 - f15285c.get(this) == 0) {
                return null;
            }
            int i8 = i7 & 127;
            if (f15286d.compareAndSet(this, i7, i7 + 1) && (hVar = (h) this.f15288a.getAndSet(i8, null)) != null) {
                c(hVar);
                return hVar;
            }
        }
    }

    public final boolean n(C1004d c1004d) {
        h hVarM = m();
        if (hVarM == null) {
            return false;
        }
        c1004d.a(hVarM);
        return true;
    }

    public final h o(boolean z7) {
        h hVar;
        do {
            hVar = (h) f15284b.get(this);
            if (hVar == null || hVar.f15275m != z7) {
                int i7 = f15286d.get(this);
                int i8 = f15285c.get(this);
                while (i7 != i8) {
                    if (z7 && f15287e.get(this) == 0) {
                        return null;
                    }
                    i8--;
                    h hVarQ = q(i8, z7);
                    if (hVarQ != null) {
                        return hVarQ;
                    }
                }
                return null;
            }
        } while (!A.b.a(f15284b, this, hVar, null));
        return hVar;
    }

    public final h p(boolean z7) {
        int i7 = f15286d.get(this);
        int i8 = f15285c.get(this);
        while (i7 != i8) {
            if (z7 && f15287e.get(this) == 0) {
                return null;
            }
            int i9 = i7 + 1;
            h hVarQ = q(i7, z7);
            if (hVarQ != null) {
                return hVarQ;
            }
            i7 = i9;
        }
        return null;
    }

    public final h q(int i7, boolean z7) {
        int i8 = i7 & 127;
        h hVar = (h) this.f15288a.get(i8);
        if (hVar == null || hVar.f15275m != z7 || !Y5.l.a(this.f15288a, i8, hVar, null)) {
            return null;
        }
        if (z7) {
            f15287e.decrementAndGet(this);
        }
        return hVar;
    }

    public final long r(int i7, w wVar) {
        h hVarP;
        if (i7 == 3) {
            hVarP = m();
        } else {
            hVarP = p(i7 == 1);
        }
        if (hVarP == null) {
            return s(i7, wVar);
        }
        wVar.f5723l = hVarP;
        return -1L;
    }

    public final long s(int i7, w wVar) {
        h hVar;
        do {
            hVar = (h) f15284b.get(this);
            if (hVar == null) {
                return -2L;
            }
            if (((hVar.f15275m ? 1 : 2) & i7) == 0) {
                return -2L;
            }
            long jA = j.f15282f.a() - hVar.f15274l;
            long j7 = j.f15278b;
            if (jA < j7) {
                return j7 - jA;
            }
        } while (!A.b.a(f15284b, this, hVar, null));
        wVar.f5723l = hVar;
        return -1L;
    }
}
