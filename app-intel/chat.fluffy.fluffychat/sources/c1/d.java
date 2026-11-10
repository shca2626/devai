package c1;

import G0.x;
import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public interface d {

    public interface a {

        /* renamed from: c1.d$a$a, reason: collision with other inner class name */
        public static final class C0136a {

            /* renamed from: a, reason: collision with root package name */
            public final CopyOnWriteArrayList f13869a = new CopyOnWriteArrayList();

            /* renamed from: c1.d$a$a$a, reason: collision with other inner class name */
            public static final class C0137a {

                /* renamed from: a, reason: collision with root package name */
                public final Handler f13870a;

                /* renamed from: b, reason: collision with root package name */
                public final a f13871b;

                /* renamed from: c, reason: collision with root package name */
                public boolean f13872c;

                public C0137a(Handler handler, a aVar) {
                    this.f13870a = handler;
                    this.f13871b = aVar;
                }

                public void d() {
                    this.f13872c = true;
                }
            }

            public void b(Handler handler, a aVar) {
                j3.o.q(handler);
                j3.o.q(aVar);
                d(aVar);
                this.f13869a.add(new C0137a(handler, aVar));
            }

            public void c(int i7, long j7, long j8) {
                final int i8;
                final long j9;
                final long j10;
                Iterator it = this.f13869a.iterator();
                while (it.hasNext()) {
                    final C0137a c0137a = (C0137a) it.next();
                    if (c0137a.f13872c) {
                        i8 = i7;
                        j9 = j7;
                        j10 = j8;
                    } else {
                        i8 = i7;
                        j9 = j7;
                        j10 = j8;
                        c0137a.f13870a.post(new Runnable() { // from class: c1.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                c0137a.f13871b.T(i8, j9, j10);
                            }
                        });
                    }
                    i7 = i8;
                    j7 = j9;
                    j8 = j10;
                }
            }

            public void d(a aVar) {
                Iterator it = this.f13869a.iterator();
                while (it.hasNext()) {
                    C0137a c0137a = (C0137a) it.next();
                    if (c0137a.f13871b == aVar) {
                        c0137a.d();
                        this.f13869a.remove(c0137a);
                    }
                }
            }
        }

        void T(int i7, long j7, long j8);
    }

    default long b() {
        return -9223372036854775807L;
    }

    void c(Handler handler, a aVar);

    void d(a aVar);

    x f();

    long i();
}
