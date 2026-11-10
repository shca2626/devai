package r;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class c extends e {

    /* renamed from: c, reason: collision with root package name */
    public static volatile c f21642c;

    /* renamed from: d, reason: collision with root package name */
    public static final Executor f21643d = new Executor() { // from class: r.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.f().c(runnable);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    public static final Executor f21644e = new Executor() { // from class: r.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.f().a(runnable);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public e f21645a;

    /* renamed from: b, reason: collision with root package name */
    public final e f21646b;

    public c() {
        d dVar = new d();
        this.f21646b = dVar;
        this.f21645a = dVar;
    }

    public static c f() {
        if (f21642c != null) {
            return f21642c;
        }
        synchronized (c.class) {
            try {
                if (f21642c == null) {
                    f21642c = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f21642c;
    }

    @Override // r.e
    public void a(Runnable runnable) {
        this.f21645a.a(runnable);
    }

    @Override // r.e
    public boolean b() {
        return this.f21645a.b();
    }

    @Override // r.e
    public void c(Runnable runnable) {
        this.f21645a.c(runnable);
    }
}
