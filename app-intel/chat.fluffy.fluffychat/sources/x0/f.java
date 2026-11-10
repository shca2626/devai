package x0;

import M5.m;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import w0.AbstractC1725a;
import w0.C1726b;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final O f23447a;

    /* renamed from: b, reason: collision with root package name */
    public final N.c f23448b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC1725a f23449c;

    /* renamed from: d, reason: collision with root package name */
    public final d f23450d;

    public f(O o7, N.c cVar, AbstractC1725a abstractC1725a) {
        m.e(o7, "store");
        m.e(cVar, "factory");
        m.e(abstractC1725a, "defaultExtras");
        this.f23447a = o7;
        this.f23448b = cVar;
        this.f23449c = abstractC1725a;
        this.f23450d = new d();
    }

    public static /* synthetic */ M e(f fVar, T5.b bVar, String str, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str = h.f23451a.c(bVar);
        }
        return fVar.d(bVar, str);
    }

    public final M d(T5.b bVar, String str) {
        M mB;
        m.e(bVar, "modelClass");
        m.e(str, "key");
        synchronized (this.f23450d) {
            try {
                mB = this.f23447a.b(str);
                if (bVar.c(mB)) {
                    if (this.f23448b instanceof N.e) {
                        N.e eVar = (N.e) this.f23448b;
                        m.b(mB);
                        eVar.d(mB);
                    }
                    m.c(mB, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.internal.ViewModelProviderImpl.getViewModel");
                } else {
                    C1726b c1726b = new C1726b(this.f23449c);
                    c1726b.c(N.f12377c, str);
                    mB = g.a(this.f23448b, bVar, c1726b);
                    this.f23447a.d(str, mB);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mB;
    }
}
