package N0;

import E0.U;
import N0.t;
import Y0.F;
import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public interface t {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f5921a;

        /* renamed from: b, reason: collision with root package name */
        public final F.b f5922b;

        /* renamed from: c, reason: collision with root package name */
        public final CopyOnWriteArrayList f5923c;

        /* renamed from: N0.t$a$a, reason: collision with other inner class name */
        public static final class C0055a {

            /* renamed from: a, reason: collision with root package name */
            public Handler f5924a;

            /* renamed from: b, reason: collision with root package name */
            public t f5925b;

            public C0055a(Handler handler, t tVar) {
                this.f5924a = handler;
                this.f5925b = tVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        public static /* synthetic */ void f(a aVar, t tVar, L l7) {
            tVar.E(aVar.f5921a, aVar.f5922b);
            tVar.M(aVar.f5921a, aVar.f5922b, l7);
        }

        public void g(Handler handler, t tVar) {
            j3.o.q(handler);
            j3.o.q(tVar);
            this.f5923c.add(new C0055a(handler, tVar));
        }

        public void h(final L l7) {
            Iterator it = this.f5923c.iterator();
            while (it.hasNext()) {
                C0055a c0055a = (C0055a) it.next();
                final t tVar = c0055a.f5925b;
                U.Z0(c0055a.f5924a, new Runnable() { // from class: N0.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a.f(this.f5918l, tVar, l7);
                    }
                });
            }
        }

        public void i() {
            Iterator it = this.f5923c.iterator();
            while (it.hasNext()) {
                C0055a c0055a = (C0055a) it.next();
                final t tVar = c0055a.f5925b;
                U.Z0(c0055a.f5924a, new Runnable() { // from class: N0.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a aVar = this.f5914l;
                        tVar.t0(aVar.f5921a, aVar.f5922b);
                    }
                });
            }
        }

        public void j() {
            Iterator it = this.f5923c.iterator();
            while (it.hasNext()) {
                C0055a c0055a = (C0055a) it.next();
                final t tVar = c0055a.f5925b;
                U.Z0(c0055a.f5924a, new Runnable() { // from class: N0.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a aVar = this.f5916l;
                        tVar.S(aVar.f5921a, aVar.f5922b);
                    }
                });
            }
        }

        public void k(final int i7) {
            Iterator it = this.f5923c.iterator();
            while (it.hasNext()) {
                C0055a c0055a = (C0055a) it.next();
                final t tVar = c0055a.f5925b;
                U.Z0(c0055a.f5924a, new Runnable() { // from class: N0.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a aVar = this.f5909l;
                        tVar.s0(aVar.f5921a, aVar.f5922b, i7);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            Iterator it = this.f5923c.iterator();
            while (it.hasNext()) {
                C0055a c0055a = (C0055a) it.next();
                final t tVar = c0055a.f5925b;
                U.Z0(c0055a.f5924a, new Runnable() { // from class: N0.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a aVar = this.f5906l;
                        tVar.f0(aVar.f5921a, aVar.f5922b, exc);
                    }
                });
            }
        }

        public void m() {
            Iterator it = this.f5923c.iterator();
            while (it.hasNext()) {
                C0055a c0055a = (C0055a) it.next();
                final t tVar = c0055a.f5925b;
                U.Z0(c0055a.f5924a, new Runnable() { // from class: N0.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a aVar = this.f5912l;
                        tVar.o0(aVar.f5921a, aVar.f5922b);
                    }
                });
            }
        }

        public void n(t tVar) {
            Iterator it = this.f5923c.iterator();
            while (it.hasNext()) {
                C0055a c0055a = (C0055a) it.next();
                if (c0055a.f5925b == tVar) {
                    this.f5923c.remove(c0055a);
                }
            }
        }

        public a o(int i7, F.b bVar) {
            return new a(this.f5923c, i7, bVar);
        }

        public a(CopyOnWriteArrayList copyOnWriteArrayList, int i7, F.b bVar) {
            this.f5923c = copyOnWriteArrayList;
            this.f5921a = i7;
            this.f5922b = bVar;
        }
    }

    void M(int i7, F.b bVar, L l7);

    void S(int i7, F.b bVar);

    void f0(int i7, F.b bVar, Exception exc);

    void o0(int i7, F.b bVar);

    void s0(int i7, F.b bVar, int i8);

    void t0(int i7, F.b bVar);

    default void E(int i7, F.b bVar) {
    }
}
