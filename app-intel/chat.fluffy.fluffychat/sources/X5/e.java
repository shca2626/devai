package X5;

import C5.i;
import L5.l;
import M5.m;
import W5.C0613c0;
import W5.InterfaceC0632m;
import W5.W;
import W5.z0;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import y5.C1824s;

/* loaded from: classes.dex */
public final class e extends f implements W {

    /* renamed from: n, reason: collision with root package name */
    public final Handler f9347n;

    /* renamed from: o, reason: collision with root package name */
    public final String f9348o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f9349p;

    /* renamed from: q, reason: collision with root package name */
    public final e f9350q;

    public e(Handler handler, String str, boolean z7) {
        super(null);
        this.f9347n = handler;
        this.f9348o = str;
        this.f9349p = z7;
        this.f9350q = z7 ? this : new e(handler, str, true);
    }

    public static final void e0(InterfaceC0632m interfaceC0632m, e eVar) {
        interfaceC0632m.p(eVar, C1824s.f24014a);
    }

    public static final C1824s f0(e eVar, Runnable runnable, Throwable th) {
        eVar.f9347n.removeCallbacks(runnable);
        return C1824s.f24014a;
    }

    @Override // W5.W
    public void P(long j7, final InterfaceC0632m interfaceC0632m) {
        final Runnable runnable = new Runnable() { // from class: X5.c
            @Override // java.lang.Runnable
            public final void run() {
                e.e0(interfaceC0632m, this);
            }
        };
        if (this.f9347n.postDelayed(runnable, S5.e.g(j7, 4611686018427387903L))) {
            interfaceC0632m.h(new l() { // from class: X5.d
                @Override // L5.l
                public final Object a(Object obj) {
                    return e.f0(this.f9345l, runnable, (Throwable) obj);
                }
            });
        } else {
            c0(interfaceC0632m.getContext(), runnable);
        }
    }

    @Override // W5.J
    public void U(i iVar, Runnable runnable) {
        if (this.f9347n.post(runnable)) {
            return;
        }
        c0(iVar, runnable);
    }

    @Override // W5.J
    public boolean V(i iVar) {
        return (this.f9349p && m.a(Looper.myLooper(), this.f9347n.getLooper())) ? false : true;
    }

    public final void c0(i iVar, Runnable runnable) {
        z0.c(iVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        C0613c0.b().U(iVar, runnable);
    }

    @Override // W5.G0
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public e Y() {
        return this.f9350q;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return eVar.f9347n == this.f9347n && eVar.f9349p == this.f9349p;
    }

    public int hashCode() {
        return System.identityHashCode(this.f9347n) ^ (this.f9349p ? 1231 : 1237);
    }

    @Override // W5.G0, W5.J
    public String toString() {
        String strZ = Z();
        if (strZ != null) {
            return strZ;
        }
        String string = this.f9348o;
        if (string == null) {
            string = this.f9347n.toString();
        }
        if (!this.f9349p) {
            return string;
        }
        return string + ".immediate";
    }

    public /* synthetic */ e(Handler handler, String str, int i7, M5.g gVar) {
        this(handler, (i7 & 2) != 0 ? null : str);
    }

    public e(Handler handler, String str) {
        this(handler, str, false);
    }
}
