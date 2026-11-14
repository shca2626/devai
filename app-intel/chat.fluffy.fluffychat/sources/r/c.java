package r;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class c extends e {

    /* renamed from: c, reason: collision with root package name */
    public static volatile c f21648c;

    /* renamed from: d, reason: collision with root package name */
    public static final Executor f21649d = new Executor() { // from class: r.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.f().c(runnable);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    public static final Executor f21650e = new Executor() { // from class: r.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.f().a(runnable);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public e f21651a;

    /* renamed from: b, reason: collision with root package name */
    public final e f21652b;

    public c() {
        d dVar = new d();
        this.f21652b = dVar;
        this.f21651a = dVar;
    }

    public static c f() {
        if (f21648c != null) {
            return f21648c;
        }
        synchronized (c.class) {
            try {
                if (f21648c == null) {
                    f21648c = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f21648c;
    }

    @Override // r.e
    public void a(Runnable runnable) {
        this.f21651a.a(runnable);
    }

    @Override // r.e
    public boolean b() {
        return this.f21651a.b();
    }

    @Override // r.e
    public void c(Runnable runnable) {
        this.f21651a.c(runnable);
    }
}
