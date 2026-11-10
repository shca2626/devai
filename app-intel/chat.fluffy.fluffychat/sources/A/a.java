package A;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class a implements p3.b {

    /* renamed from: o, reason: collision with root package name */
    public static final boolean f1o = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: p, reason: collision with root package name */
    public static final Logger f2p = Logger.getLogger(a.class.getName());

    /* renamed from: q, reason: collision with root package name */
    public static final b f3q;

    /* renamed from: r, reason: collision with root package name */
    public static final Object f4r;

    /* renamed from: l, reason: collision with root package name */
    public volatile Object f5l;

    /* renamed from: m, reason: collision with root package name */
    public volatile e f6m;

    /* renamed from: n, reason: collision with root package name */
    public volatile h f7n;

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(a aVar, e eVar, e eVar2);

        public abstract boolean b(a aVar, Object obj, Object obj2);

        public abstract boolean c(a aVar, h hVar, h hVar2);

        public abstract void d(h hVar, h hVar2);

        public abstract void e(h hVar, Thread thread);
    }

    public static final class c {

        /* renamed from: c, reason: collision with root package name */
        public static final c f8c;

        /* renamed from: d, reason: collision with root package name */
        public static final c f9d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f10a;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f11b;

        static {
            if (a.f1o) {
                f9d = null;
                f8c = null;
            } else {
                f9d = new c(false, null);
                f8c = new c(true, null);
            }
        }

        public c(boolean z7, Throwable th) {
            this.f10a = z7;
            this.f11b = th;
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f12a;
    }

    public static final class e {

        /* renamed from: d, reason: collision with root package name */
        public static final e f13d = new e(null, null);

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f14a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f15b;

        /* renamed from: c, reason: collision with root package name */
        public e f16c;

        public e(Runnable runnable, Executor executor) {
            this.f14a = runnable;
            this.f15b = executor;
        }
    }

    public static final class f extends b {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f17a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f18b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f19c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f20d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f21e;

        public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f17a = atomicReferenceFieldUpdater;
            this.f18b = atomicReferenceFieldUpdater2;
            this.f19c = atomicReferenceFieldUpdater3;
            this.f20d = atomicReferenceFieldUpdater4;
            this.f21e = atomicReferenceFieldUpdater5;
        }

        @Override // A.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            return A.b.a(this.f20d, aVar, eVar, eVar2);
        }

        @Override // A.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            return A.b.a(this.f21e, aVar, obj, obj2);
        }

        @Override // A.a.b
        public boolean c(a aVar, h hVar, h hVar2) {
            return A.b.a(this.f19c, aVar, hVar, hVar2);
        }

        @Override // A.a.b
        public void d(h hVar, h hVar2) {
            this.f18b.lazySet(hVar, hVar2);
        }

        @Override // A.a.b
        public void e(h hVar, Thread thread) {
            this.f17a.lazySet(hVar, thread);
        }
    }

    public static final class g extends b {
        public g() {
            super();
        }

        @Override // A.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f6m != eVar) {
                        return false;
                    }
                    aVar.f6m = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // A.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                try {
                    if (aVar.f5l != obj) {
                        return false;
                    }
                    aVar.f5l = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // A.a.b
        public boolean c(a aVar, h hVar, h hVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f7n != hVar) {
                        return false;
                    }
                    aVar.f7n = hVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // A.a.b
        public void d(h hVar, h hVar2) {
            hVar.f24b = hVar2;
        }

        @Override // A.a.b
        public void e(h hVar, Thread thread) {
            hVar.f23a = thread;
        }
    }

    public static final class h {

        /* renamed from: c, reason: collision with root package name */
        public static final h f22c = new h(false);

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f23a;

        /* renamed from: b, reason: collision with root package name */
        public volatile h f24b;

        public h(boolean z7) {
        }

        public void a(h hVar) {
            a.f3q.d(this, hVar);
        }

        public void b() {
            Thread thread = this.f23a;
            if (thread != null) {
                this.f23a = null;
                LockSupport.unpark(thread);
            }
        }

        public h() {
            a.f3q.e(this, Thread.currentThread());
        }
    }

    static {
        b gVar;
        try {
            gVar = new f(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "n"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "m"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "l"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f3q = gVar;
        if (th != null) {
            f2p.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f4r = new Object();
    }

    public static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static void e(a aVar) {
        aVar.k();
        aVar.b();
        e eVarD = aVar.d(null);
        while (eVarD != null) {
            e eVar = eVarD.f16c;
            f(eVarD.f14a, eVarD.f15b);
            eVarD = eVar;
        }
    }

    public static void f(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e7) {
            f2p.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e7);
        }
    }

    public static Object h(Future future) {
        Object obj;
        boolean z7 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void a(StringBuilder sb) {
        try {
            Object objH = h(this);
            sb.append("SUCCESS, result=[");
            sb.append(n(objH));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e7) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e7.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e8) {
            sb.append("FAILURE, cause=[");
            sb.append(e8.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z7) {
        Object obj = this.f5l;
        if (obj == null) {
            if (f3q.b(this, obj, f1o ? new c(z7, new CancellationException("Future.cancel() was called.")) : z7 ? c.f8c : c.f9d)) {
                if (z7) {
                    i();
                }
                e(this);
                return true;
            }
        }
        return false;
    }

    public final e d(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f6m;
        } while (!f3q.a(this, eVar2, e.f13d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f16c;
            eVar4.f16c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    public final Object g(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f11b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f12a);
        }
        if (obj == f4r) {
            return null;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j7, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j7);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f5l;
        if (obj != null) {
            return g(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f7n;
            if (hVar != h.f22c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f3q.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                l(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f5l;
                            if (obj2 != null) {
                                return g(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        l(hVar2);
                    } else {
                        hVar = this.f7n;
                    }
                } while (hVar != h.f22c);
            }
            return g(this.f5l);
        }
        while (nanos > 0) {
            Object obj3 = this.f5l;
            if (obj3 != null) {
                return g(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j7 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j8 = -nanos;
            long jConvert = timeUnit.convert(j8, TimeUnit.NANOSECONDS);
            long nanos2 = j8 - timeUnit.toNanos(jConvert);
            boolean z7 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z7) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z7) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f5l instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f5l != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String j() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void k() {
        h hVar;
        do {
            hVar = this.f7n;
        } while (!f3q.c(this, hVar, h.f22c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f24b;
        }
    }

    public final void l(h hVar) {
        hVar.f23a = null;
        while (true) {
            h hVar2 = this.f7n;
            if (hVar2 == h.f22c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f24b;
                if (hVar2.f23a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f24b = hVar4;
                    if (hVar3.f23a == null) {
                        break;
                    }
                } else if (!f3q.c(this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    public boolean m(Object obj) {
        if (obj == null) {
            obj = f4r;
        }
        if (!f3q.b(this, null, obj)) {
            return false;
        }
        e(this);
        return true;
    }

    public final String n(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public String toString() {
        String strJ;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strJ = j();
            } catch (RuntimeException e7) {
                strJ = "Exception thrown from implementation: " + e7.getClass();
            }
            if (strJ != null && !strJ.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strJ);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void b() {
    }

    public void i() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f5l;
            if (obj2 != null) {
                return g(obj2);
            }
            h hVar = this.f7n;
            if (hVar != h.f22c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f3q.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f5l;
                            } else {
                                l(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!(obj != null));
                        return g(obj);
                    }
                    hVar = this.f7n;
                } while (hVar != h.f22c);
            }
            return g(this.f5l);
        }
        throw new InterruptedException();
    }
}
