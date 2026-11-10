package u;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.AbstractC0812s;
import androidx.lifecycle.M;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import u.C1639a;
import u.f;

/* loaded from: classes.dex */
public class g extends M {

    /* renamed from: b, reason: collision with root package name */
    public Executor f22663b;

    /* renamed from: c, reason: collision with root package name */
    public f.a f22664c;

    /* renamed from: d, reason: collision with root package name */
    public f.d f22665d;

    /* renamed from: e, reason: collision with root package name */
    public f.c f22666e;

    /* renamed from: f, reason: collision with root package name */
    public C1639a f22667f;

    /* renamed from: g, reason: collision with root package name */
    public h f22668g;

    /* renamed from: h, reason: collision with root package name */
    public DialogInterface.OnClickListener f22669h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f22670i;

    /* renamed from: k, reason: collision with root package name */
    public boolean f22672k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f22673l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f22674m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f22675n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f22676o;

    /* renamed from: p, reason: collision with root package name */
    public androidx.lifecycle.u f22677p;

    /* renamed from: q, reason: collision with root package name */
    public androidx.lifecycle.u f22678q;

    /* renamed from: r, reason: collision with root package name */
    public androidx.lifecycle.u f22679r;

    /* renamed from: s, reason: collision with root package name */
    public androidx.lifecycle.u f22680s;

    /* renamed from: t, reason: collision with root package name */
    public androidx.lifecycle.u f22681t;

    /* renamed from: v, reason: collision with root package name */
    public androidx.lifecycle.u f22683v;

    /* renamed from: x, reason: collision with root package name */
    public androidx.lifecycle.u f22685x;

    /* renamed from: y, reason: collision with root package name */
    public androidx.lifecycle.u f22686y;

    /* renamed from: j, reason: collision with root package name */
    public int f22671j = 0;

    /* renamed from: u, reason: collision with root package name */
    public boolean f22682u = true;

    /* renamed from: w, reason: collision with root package name */
    public int f22684w = 0;

    public class a extends f.a {
        public a() {
        }
    }

    public static final class b extends C1639a.d {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f22688a;

        public b(g gVar) {
            this.f22688a = new WeakReference(gVar);
        }

        @Override // u.C1639a.d
        public void a(int i7, CharSequence charSequence) {
            if (this.f22688a.get() == null || ((g) this.f22688a.get()).A() || !((g) this.f22688a.get()).y()) {
                return;
            }
            ((g) this.f22688a.get()).H(new u.c(i7, charSequence));
        }

        @Override // u.C1639a.d
        public void b() {
            if (this.f22688a.get() == null || !((g) this.f22688a.get()).y()) {
                return;
            }
            ((g) this.f22688a.get()).I(true);
        }

        @Override // u.C1639a.d
        public void c(f.b bVar) {
            if (this.f22688a.get() == null || !((g) this.f22688a.get()).y()) {
                return;
            }
            if (bVar.a() == -1) {
                bVar = new f.b(bVar.b(), ((g) this.f22688a.get()).s());
            }
            ((g) this.f22688a.get()).J(bVar);
        }
    }

    public static class c implements Executor {

        /* renamed from: l, reason: collision with root package name */
        public final Handler f22689l = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f22689l.post(runnable);
        }
    }

    public static class d implements DialogInterface.OnClickListener {

        /* renamed from: l, reason: collision with root package name */
        public final WeakReference f22690l;

        public d(g gVar) {
            this.f22690l = new WeakReference(gVar);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i7) {
            if (this.f22690l.get() != null) {
                ((g) this.f22690l.get()).X(true);
            }
        }
    }

    public static void b0(androidx.lifecycle.u uVar, Object obj) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            uVar.k(obj);
        } else {
            uVar.i(obj);
        }
    }

    public boolean A() {
        return this.f22674m;
    }

    public boolean B() {
        return this.f22675n;
    }

    public AbstractC0812s C() {
        if (this.f22683v == null) {
            this.f22683v = new androidx.lifecycle.u();
        }
        return this.f22683v;
    }

    public boolean D() {
        return this.f22682u;
    }

    public boolean E() {
        return this.f22676o;
    }

    public AbstractC0812s F() {
        if (this.f22681t == null) {
            this.f22681t = new androidx.lifecycle.u();
        }
        return this.f22681t;
    }

    public boolean G() {
        return this.f22672k;
    }

    public void H(u.c cVar) {
        if (this.f22678q == null) {
            this.f22678q = new androidx.lifecycle.u();
        }
        b0(this.f22678q, cVar);
    }

    public void I(boolean z7) {
        if (this.f22680s == null) {
            this.f22680s = new androidx.lifecycle.u();
        }
        b0(this.f22680s, Boolean.valueOf(z7));
    }

    public void J(f.b bVar) {
        if (this.f22677p == null) {
            this.f22677p = new androidx.lifecycle.u();
        }
        b0(this.f22677p, bVar);
    }

    public void K(boolean z7) {
        this.f22673l = z7;
    }

    public void L(int i7) {
        this.f22671j = i7;
    }

    public void M(f.a aVar) {
        this.f22664c = aVar;
    }

    public void N(Executor executor) {
        this.f22663b = executor;
    }

    public void O(boolean z7) {
        this.f22674m = z7;
    }

    public void P(f.c cVar) {
        this.f22666e = cVar;
    }

    public void Q(boolean z7) {
        this.f22675n = z7;
    }

    public void R(boolean z7) {
        if (this.f22683v == null) {
            this.f22683v = new androidx.lifecycle.u();
        }
        b0(this.f22683v, Boolean.valueOf(z7));
    }

    public void S(boolean z7) {
        this.f22682u = z7;
    }

    public void T(CharSequence charSequence) {
        if (this.f22686y == null) {
            this.f22686y = new androidx.lifecycle.u();
        }
        b0(this.f22686y, charSequence);
    }

    public void U(int i7) {
        this.f22684w = i7;
    }

    public void V(int i7) {
        if (this.f22685x == null) {
            this.f22685x = new androidx.lifecycle.u();
        }
        b0(this.f22685x, Integer.valueOf(i7));
    }

    public void W(boolean z7) {
        this.f22676o = z7;
    }

    public void X(boolean z7) {
        if (this.f22681t == null) {
            this.f22681t = new androidx.lifecycle.u();
        }
        b0(this.f22681t, Boolean.valueOf(z7));
    }

    public void Y(CharSequence charSequence) {
        this.f22670i = charSequence;
    }

    public void Z(f.d dVar) {
        this.f22665d = dVar;
    }

    public void a0(boolean z7) {
        this.f22672k = z7;
    }

    public int e() {
        f.d dVar = this.f22665d;
        if (dVar != null) {
            return AbstractC1640b.b(dVar, this.f22666e);
        }
        return 0;
    }

    public C1639a f() {
        if (this.f22667f == null) {
            this.f22667f = new C1639a(new b(this));
        }
        return this.f22667f;
    }

    public androidx.lifecycle.u g() {
        if (this.f22678q == null) {
            this.f22678q = new androidx.lifecycle.u();
        }
        return this.f22678q;
    }

    public AbstractC0812s h() {
        if (this.f22679r == null) {
            this.f22679r = new androidx.lifecycle.u();
        }
        return this.f22679r;
    }

    public AbstractC0812s i() {
        if (this.f22677p == null) {
            this.f22677p = new androidx.lifecycle.u();
        }
        return this.f22677p;
    }

    public int j() {
        return this.f22671j;
    }

    public h k() {
        if (this.f22668g == null) {
            this.f22668g = new h();
        }
        return this.f22668g;
    }

    public f.a l() {
        if (this.f22664c == null) {
            this.f22664c = new a();
        }
        return this.f22664c;
    }

    public Executor m() {
        Executor executor = this.f22663b;
        return executor != null ? executor : new c();
    }

    public f.c n() {
        return this.f22666e;
    }

    public CharSequence o() {
        f.d dVar = this.f22665d;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public AbstractC0812s p() {
        if (this.f22686y == null) {
            this.f22686y = new androidx.lifecycle.u();
        }
        return this.f22686y;
    }

    public int q() {
        return this.f22684w;
    }

    public AbstractC0812s r() {
        if (this.f22685x == null) {
            this.f22685x = new androidx.lifecycle.u();
        }
        return this.f22685x;
    }

    public int s() {
        int iE = e();
        return (!AbstractC1640b.d(iE) || AbstractC1640b.c(iE)) ? -1 : 2;
    }

    public DialogInterface.OnClickListener t() {
        if (this.f22669h == null) {
            this.f22669h = new d(this);
        }
        return this.f22669h;
    }

    public CharSequence u() {
        CharSequence charSequence = this.f22670i;
        if (charSequence != null) {
            return charSequence;
        }
        f.d dVar = this.f22665d;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public CharSequence v() {
        f.d dVar = this.f22665d;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public CharSequence w() {
        f.d dVar = this.f22665d;
        if (dVar != null) {
            return dVar.e();
        }
        return null;
    }

    public AbstractC0812s x() {
        if (this.f22680s == null) {
            this.f22680s = new androidx.lifecycle.u();
        }
        return this.f22680s;
    }

    public boolean y() {
        return this.f22673l;
    }

    public boolean z() {
        f.d dVar = this.f22665d;
        return dVar == null || dVar.f();
    }
}
