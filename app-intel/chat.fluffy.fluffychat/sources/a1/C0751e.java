package a1;

import j3.InterfaceC1232f;
import j3.o;
import java.util.ArrayList;
import java.util.List;
import k3.AbstractC1279v;
import k3.U;

/* renamed from: a1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0751e implements InterfaceC0747a {

    /* renamed from: b, reason: collision with root package name */
    public static final U f10541b = U.d().f(new InterfaceC1232f() { // from class: a1.c
        @Override // j3.InterfaceC1232f
        public final Object apply(Object obj) {
            return Long.valueOf(((D1.e) obj).f1612b);
        }
    }).a(U.d().g().f(new InterfaceC1232f() { // from class: a1.d
        @Override // j3.InterfaceC1232f
        public final Object apply(Object obj) {
            return Long.valueOf(((D1.e) obj).f1613c);
        }
    }));

    /* renamed from: a, reason: collision with root package name */
    public final List f10542a = new ArrayList();

    @Override // a1.InterfaceC0747a
    public long a(long j7) {
        int i7 = 0;
        long jMin = -9223372036854775807L;
        while (true) {
            if (i7 >= this.f10542a.size()) {
                break;
            }
            long j8 = ((D1.e) this.f10542a.get(i7)).f1612b;
            long j9 = ((D1.e) this.f10542a.get(i7)).f1614d;
            if (j7 < j8) {
                jMin = jMin == -9223372036854775807L ? j8 : Math.min(jMin, j8);
            } else {
                if (j7 < j9) {
                    jMin = jMin == -9223372036854775807L ? j9 : Math.min(jMin, j9);
                }
                i7++;
            }
        }
        if (jMin != -9223372036854775807L) {
            return jMin;
        }
        return Long.MIN_VALUE;
    }

    @Override // a1.InterfaceC0747a
    public AbstractC1279v b(long j7) {
        if (!this.f10542a.isEmpty()) {
            if (j7 >= ((D1.e) this.f10542a.get(0)).f1612b) {
                ArrayList arrayList = new ArrayList();
                for (int i7 = 0; i7 < this.f10542a.size(); i7++) {
                    D1.e eVar = (D1.e) this.f10542a.get(i7);
                    if (j7 >= eVar.f1612b && j7 < eVar.f1614d) {
                        arrayList.add(eVar);
                    }
                    if (j7 < eVar.f1612b) {
                        break;
                    }
                }
                AbstractC1279v abstractC1279vC = AbstractC1279v.C(f10541b, arrayList);
                AbstractC1279v.a aVarO = AbstractC1279v.o();
                for (int i8 = 0; i8 < abstractC1279vC.size(); i8++) {
                    aVarO.j(((D1.e) abstractC1279vC.get(i8)).f1611a);
                }
                return aVarO.k();
            }
        }
        return AbstractC1279v.v();
    }

    @Override // a1.InterfaceC0747a
    public boolean c(D1.e eVar, long j7) {
        o.d(eVar.f1612b != -9223372036854775807L);
        o.d(eVar.f1613c != -9223372036854775807L);
        boolean z7 = eVar.f1612b <= j7 && j7 < eVar.f1614d;
        for (int size = this.f10542a.size() - 1; size >= 0; size--) {
            if (eVar.f1612b >= ((D1.e) this.f10542a.get(size)).f1612b) {
                this.f10542a.add(size + 1, eVar);
                return z7;
            }
        }
        this.f10542a.add(0, eVar);
        return z7;
    }

    @Override // a1.InterfaceC0747a
    public void clear() {
        this.f10542a.clear();
    }

    @Override // a1.InterfaceC0747a
    public long d(long j7) {
        if (this.f10542a.isEmpty()) {
            return -9223372036854775807L;
        }
        if (j7 < ((D1.e) this.f10542a.get(0)).f1612b) {
            return -9223372036854775807L;
        }
        long jMax = ((D1.e) this.f10542a.get(0)).f1612b;
        for (int i7 = 0; i7 < this.f10542a.size(); i7++) {
            long j8 = ((D1.e) this.f10542a.get(i7)).f1612b;
            long j9 = ((D1.e) this.f10542a.get(i7)).f1614d;
            if (j9 > j7) {
                if (j8 > j7) {
                    break;
                }
                jMax = Math.max(jMax, j8);
            } else {
                jMax = Math.max(jMax, j9);
            }
        }
        return jMax;
    }

    @Override // a1.InterfaceC0747a
    public void e(long j7) {
        int i7 = 0;
        while (i7 < this.f10542a.size()) {
            long j8 = ((D1.e) this.f10542a.get(i7)).f1612b;
            if (j7 > j8 && j7 > ((D1.e) this.f10542a.get(i7)).f1614d) {
                this.f10542a.remove(i7);
                i7--;
            } else if (j7 < j8) {
                return;
            }
            i7++;
        }
    }
}
