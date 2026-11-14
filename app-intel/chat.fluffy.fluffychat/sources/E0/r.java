package E0;

import B0.q;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0322g f2190a;

    /* renamed from: b, reason: collision with root package name */
    public final Thread f2191b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0330o f2192c;

    /* renamed from: d, reason: collision with root package name */
    public final b f2193d;

    /* renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArraySet f2194e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque f2195f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque f2196g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f2197h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2198i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2199j;

    public interface a {
        void a(Object obj);
    }

    public interface b {
        void a(Object obj, B0.q qVar);
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final Object f2200a;

        /* renamed from: b, reason: collision with root package name */
        public q.b f2201b = new q.b();

        /* renamed from: c, reason: collision with root package name */
        public boolean f2202c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2203d;

        public c(Object obj) {
            this.f2200a = obj;
        }

        public void b(int i7, a aVar) {
            if (this.f2203d) {
                return;
            }
            if (i7 != -1) {
                this.f2201b.a(i7);
            }
            this.f2202c = true;
            aVar.a(this.f2200a);
        }

        public void c(b bVar) {
            if (this.f2203d || !this.f2202c) {
                return;
            }
            B0.q qVarE = this.f2201b.e();
            this.f2201b = new q.b();
            this.f2202c = false;
            bVar.a(this.f2200a, qVarE);
        }

        public final void d(b bVar) {
            this.f2203d = true;
            if (bVar == null || !this.f2202c) {
                return;
            }
            this.f2202c = false;
            bVar.a(this.f2200a, this.f2201b.e());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f2200a.equals(((c) obj).f2200a);
        }

        public int hashCode() {
            return this.f2200a.hashCode();
        }
    }

    public r(Looper looper) {
        this(looper.getThread());
    }

    public static /* synthetic */ void a(CopyOnWriteArraySet copyOnWriteArraySet, int i7, a aVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).b(i7, aVar);
        }
    }

    public void c(Object obj) {
        j3.o.q(obj);
        synchronized (this.f2197h) {
            try {
                if (this.f2198i) {
                    return;
                }
                this.f2194e.add(new c(obj));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public r d(Looper looper, InterfaceC0322g interfaceC0322g, b bVar) {
        j3.o.v(interfaceC0322g != null || bVar == null);
        return new r(this.f2194e, looper, looper.getThread(), interfaceC0322g, bVar, this.f2199j);
    }

    public void e() {
        m();
        if (this.f2196g.isEmpty()) {
            return;
        }
        if (this.f2193d != null && !((InterfaceC0330o) j3.o.q(this.f2192c)).e(1)) {
            InterfaceC0330o interfaceC0330o = this.f2192c;
            interfaceC0330o.j(interfaceC0330o.d(1));
        }
        boolean zIsEmpty = this.f2195f.isEmpty();
        this.f2195f.addAll(this.f2196g);
        this.f2196g.clear();
        if (zIsEmpty) {
            while (!this.f2195f.isEmpty()) {
                ((Runnable) this.f2195f.peekFirst()).run();
                this.f2195f.removeFirst();
            }
        }
    }

    public final boolean f(Message message) {
        b bVar = (b) j3.o.q(this.f2193d);
        Iterator it = this.f2194e.iterator();
        while (it.hasNext()) {
            ((c) it.next()).c(bVar);
            if (((InterfaceC0330o) j3.o.q(this.f2192c)).e(1)) {
                break;
            }
        }
        return true;
    }

    public void g(final int i7, final a aVar) {
        m();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f2194e);
        this.f2196g.add(new Runnable() { // from class: E0.q
            @Override // java.lang.Runnable
            public final void run() {
                r.a(copyOnWriteArraySet, i7, aVar);
            }
        });
    }

    public void h() {
        m();
        synchronized (this.f2197h) {
            this.f2198i = true;
        }
        Iterator it = this.f2194e.iterator();
        while (it.hasNext()) {
            ((c) it.next()).d(this.f2193d);
        }
        this.f2194e.clear();
    }

    public void i(Object obj) {
        m();
        Iterator it = this.f2194e.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.f2200a.equals(obj)) {
                cVar.d(this.f2193d);
                this.f2194e.remove(cVar);
            }
        }
    }

    public void j(int i7, a aVar) {
        g(i7, aVar);
        e();
    }

    public void k(a aVar) {
        j(-1, aVar);
    }

    public void l(boolean z7) {
        this.f2199j = z7;
    }

    public final void m() {
        if (this.f2199j) {
            j3.o.v(Thread.currentThread() == this.f2191b);
        }
    }

    public r(Thread thread) {
        this(new CopyOnWriteArraySet(), null, thread, null, null, true);
    }

    public r(Looper looper, InterfaceC0322g interfaceC0322g, b bVar) {
        this(new CopyOnWriteArraySet(), looper, looper.getThread(), interfaceC0322g, bVar, true);
    }

    public r(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, Thread thread, InterfaceC0322g interfaceC0322g, b bVar, boolean z7) {
        this.f2190a = interfaceC0322g;
        this.f2191b = thread;
        this.f2194e = copyOnWriteArraySet;
        this.f2193d = bVar;
        this.f2197h = new Object();
        this.f2195f = new ArrayDeque();
        this.f2196g = new ArrayDeque();
        if (looper != null && interfaceC0322g != null && bVar != null) {
            this.f2192c = interfaceC0322g.c(looper, new Handler.Callback() { // from class: E0.p
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return this.f2186l.f(message);
                }
            });
        } else {
            this.f2192c = null;
        }
        this.f2199j = z7;
    }
}
