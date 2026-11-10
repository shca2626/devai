package W;

import W.h;
import W.i;
import android.graphics.Typeface;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final i.c f8889a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f8890b;

    /* renamed from: W.a$a, reason: collision with other inner class name */
    public class RunnableC0073a implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ i.c f8891l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Typeface f8892m;

        public RunnableC0073a(i.c cVar, Typeface typeface) {
            this.f8891l = cVar;
            this.f8892m = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8891l.b(this.f8892m);
        }
    }

    public class b implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ i.c f8894l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f8895m;

        public b(i.c cVar, int i7) {
            this.f8894l = cVar;
            this.f8895m = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8894l.a(this.f8895m);
        }
    }

    public a(i.c cVar, Executor executor) {
        this.f8889a = cVar;
        this.f8890b = executor;
    }

    public final void a(int i7) {
        this.f8890b.execute(new b(this.f8889a, i7));
    }

    public void b(h.e eVar) {
        if (eVar.a()) {
            c(eVar.f8925a);
        } else {
            a(eVar.f8926b);
        }
    }

    public final void c(Typeface typeface) {
        this.f8890b.execute(new RunnableC0073a(this.f8889a, typeface));
    }
}
