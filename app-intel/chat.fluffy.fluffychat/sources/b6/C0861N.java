package b6;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: b6.N, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0861N {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f13768b = AtomicIntegerFieldUpdater.newUpdater(C0861N.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC0862O[] f13769a;

    public final void a(InterfaceC0862O interfaceC0862O) {
        interfaceC0862O.d(this);
        InterfaceC0862O[] interfaceC0862OArrG = g();
        int iC = c();
        k(iC + 1);
        interfaceC0862OArrG[iC] = interfaceC0862O;
        interfaceC0862O.setIndex(iC);
        m(iC);
    }

    public final InterfaceC0862O b() {
        InterfaceC0862O[] interfaceC0862OArr = this.f13769a;
        if (interfaceC0862OArr != null) {
            return interfaceC0862OArr[0];
        }
        return null;
    }

    public final int c() {
        return f13768b.get(this);
    }

    public final boolean e() {
        return c() == 0;
    }

    public final InterfaceC0862O f() {
        InterfaceC0862O interfaceC0862OB;
        synchronized (this) {
            interfaceC0862OB = b();
        }
        return interfaceC0862OB;
    }

    public final InterfaceC0862O[] g() {
        InterfaceC0862O[] interfaceC0862OArr = this.f13769a;
        if (interfaceC0862OArr == null) {
            InterfaceC0862O[] interfaceC0862OArr2 = new InterfaceC0862O[4];
            this.f13769a = interfaceC0862OArr2;
            return interfaceC0862OArr2;
        }
        if (c() < interfaceC0862OArr.length) {
            return interfaceC0862OArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(interfaceC0862OArr, c() * 2);
        M5.m.d(objArrCopyOf, "copyOf(...)");
        InterfaceC0862O[] interfaceC0862OArr3 = (InterfaceC0862O[]) objArrCopyOf;
        this.f13769a = interfaceC0862OArr3;
        return interfaceC0862OArr3;
    }

    public final boolean h(InterfaceC0862O interfaceC0862O) {
        boolean z7;
        synchronized (this) {
            if (interfaceC0862O.e() == null) {
                z7 = false;
            } else {
                i(interfaceC0862O.getIndex());
                z7 = true;
            }
        }
        return z7;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b6.InterfaceC0862O i(int r6) {
        /*
            r5 = this;
            b6.O[] r0 = r5.f13769a
            M5.m.b(r0)
            int r1 = r5.c()
            r2 = -1
            int r1 = r1 + r2
            r5.k(r1)
            int r1 = r5.c()
            if (r6 >= r1) goto L3d
            int r1 = r5.c()
            r5.n(r6, r1)
            int r1 = r6 + (-1)
            int r1 = r1 / 2
            if (r6 <= 0) goto L3a
            r3 = r0[r6]
            M5.m.b(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r0[r1]
            M5.m.b(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L3a
            r5.n(r6, r1)
            r5.m(r1)
            goto L3d
        L3a:
            r5.l(r6)
        L3d:
            int r6 = r5.c()
            r6 = r0[r6]
            M5.m.b(r6)
            r1 = 0
            r6.d(r1)
            r6.setIndex(r2)
            int r2 = r5.c()
            r0[r2] = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.C0861N.i(int):b6.O");
    }

    public final InterfaceC0862O j() {
        InterfaceC0862O interfaceC0862OI;
        synchronized (this) {
            interfaceC0862OI = c() > 0 ? i(0) : null;
        }
        return interfaceC0862OI;
    }

    public final void k(int i7) {
        f13768b.set(this, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.c()
            if (r1 < r2) goto Lb
            goto L3e
        Lb:
            b6.O[] r2 = r5.f13769a
            M5.m.b(r2)
            int r0 = r0 + 2
            int r3 = r5.c()
            if (r0 >= r3) goto L2b
            r3 = r2[r0]
            M5.m.b(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            M5.m.b(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L2b
            goto L2c
        L2b:
            r0 = r1
        L2c:
            r1 = r2[r6]
            M5.m.b(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            M5.m.b(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L3f
        L3e:
            return
        L3f:
            r5.n(r6, r0)
            r6 = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.C0861N.l(int):void");
    }

    public final void m(int i7) {
        while (i7 > 0) {
            InterfaceC0862O[] interfaceC0862OArr = this.f13769a;
            M5.m.b(interfaceC0862OArr);
            int i8 = (i7 - 1) / 2;
            InterfaceC0862O interfaceC0862O = interfaceC0862OArr[i8];
            M5.m.b(interfaceC0862O);
            InterfaceC0862O interfaceC0862O2 = interfaceC0862OArr[i7];
            M5.m.b(interfaceC0862O2);
            if (((Comparable) interfaceC0862O).compareTo(interfaceC0862O2) <= 0) {
                return;
            }
            n(i7, i8);
            i7 = i8;
        }
    }

    public final void n(int i7, int i8) {
        InterfaceC0862O[] interfaceC0862OArr = this.f13769a;
        M5.m.b(interfaceC0862OArr);
        InterfaceC0862O interfaceC0862O = interfaceC0862OArr[i8];
        M5.m.b(interfaceC0862O);
        InterfaceC0862O interfaceC0862O2 = interfaceC0862OArr[i7];
        M5.m.b(interfaceC0862O2);
        interfaceC0862OArr[i7] = interfaceC0862O;
        interfaceC0862OArr[i8] = interfaceC0862O2;
        interfaceC0862O.setIndex(i7);
        interfaceC0862O2.setIndex(i8);
    }
}
