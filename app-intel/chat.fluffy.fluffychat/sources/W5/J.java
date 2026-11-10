package W5;

import C5.f;
import C5.i;
import W5.J;
import b6.AbstractC0877m;
import b6.C0873i;
import b6.C0876l;

/* loaded from: classes.dex */
public abstract class J extends C5.a implements C5.f {

    /* renamed from: m, reason: collision with root package name */
    public static final a f9108m = new a(null);

    public static final class a extends C5.b {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public static final J d(i.b bVar) {
            if (bVar instanceof J) {
                return (J) bVar;
            }
            return null;
        }

        public a() {
            super(C5.f.f1390a, new L5.l() { // from class: W5.I
                @Override // L5.l
                public final Object a(Object obj) {
                    return J.a.d((i.b) obj);
                }
            });
        }
    }

    public J() {
        super(C5.f.f1390a);
    }

    public static /* synthetic */ J X(J j7, int i7, String str, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: limitedParallelism");
        }
        if ((i8 & 2) != 0) {
            str = null;
        }
        return j7.W(i7, str);
    }

    @Override // C5.f
    public final C5.e B(C5.e eVar) {
        return new C0873i(this, eVar);
    }

    public abstract void U(C5.i iVar, Runnable runnable);

    public boolean V(C5.i iVar) {
        return true;
    }

    public J W(int i7, String str) {
        AbstractC0877m.a(i7);
        return new C0876l(this, i7, str);
    }

    @Override // C5.a, C5.i.b, C5.i
    public /* bridge */ i.b a(i.c cVar) {
        return f.a.a(this, cVar);
    }

    @Override // C5.a, C5.i
    public /* bridge */ C5.i o(i.c cVar) {
        return f.a.b(this, cVar);
    }

    @Override // C5.f
    public final void t(C5.e eVar) {
        M5.m.c(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((C0873i) eVar).r();
    }

    public String toString() {
        return Q.a(this) + '@' + Q.b(this);
    }
}
