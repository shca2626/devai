package a6;

import Z5.w;
import java.util.Arrays;
import y5.C1814i;
import y5.C1824s;

/* renamed from: a6.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0768b {

    /* renamed from: l, reason: collision with root package name */
    public d[] f10852l;

    /* renamed from: m, reason: collision with root package name */
    public int f10853m;

    /* renamed from: n, reason: collision with root package name */
    public int f10854n;

    /* renamed from: o, reason: collision with root package name */
    public u f10855o;

    public final d h() {
        d dVarI;
        u uVar;
        synchronized (this) {
            try {
                d[] dVarArrJ = this.f10852l;
                if (dVarArrJ == null) {
                    dVarArrJ = j(2);
                    this.f10852l = dVarArrJ;
                } else if (this.f10853m >= dVarArrJ.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(dVarArrJ, dVarArrJ.length * 2);
                    M5.m.d(objArrCopyOf, "copyOf(...)");
                    this.f10852l = (d[]) objArrCopyOf;
                    dVarArrJ = (d[]) objArrCopyOf;
                }
                int i7 = this.f10854n;
                do {
                    dVarI = dVarArrJ[i7];
                    if (dVarI == null) {
                        dVarI = i();
                        dVarArrJ[i7] = dVarI;
                    }
                    i7++;
                    if (i7 >= dVarArrJ.length) {
                        i7 = 0;
                    }
                    M5.m.c(dVarI, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!dVarI.a(this));
                this.f10854n = i7;
                this.f10853m++;
                uVar = this.f10855o;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (uVar != null) {
            uVar.b0(1);
        }
        return dVarI;
    }

    public abstract d i();

    public abstract d[] j(int i7);

    public final w k() {
        u uVar;
        synchronized (this) {
            uVar = this.f10855o;
            if (uVar == null) {
                uVar = new u(this.f10853m);
                this.f10855o = uVar;
            }
        }
        return uVar;
    }

    public final void l(d dVar) {
        u uVar;
        int i7;
        C5.e[] eVarArrB;
        synchronized (this) {
            try {
                int i8 = this.f10853m - 1;
                this.f10853m = i8;
                uVar = this.f10855o;
                if (i8 == 0) {
                    this.f10854n = 0;
                }
                M5.m.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                eVarArrB = dVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (C5.e eVar : eVarArrB) {
            if (eVar != null) {
                C1814i.a aVar = C1814i.f24004m;
                eVar.resumeWith(C1814i.b(C1824s.f24014a));
            }
        }
        if (uVar != null) {
            uVar.b0(-1);
        }
    }

    public final int m() {
        return this.f10853m;
    }

    public final d[] n() {
        return this.f10852l;
    }
}
