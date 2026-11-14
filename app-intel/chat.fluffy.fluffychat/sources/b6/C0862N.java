package b6;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: b6.N, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0862N {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f13768b = AtomicIntegerFieldUpdater.newUpdater(C0862N.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC0863O[] f13769a;

    public final void a(InterfaceC0863O interfaceC0863O) {
        interfaceC0863O.d(this);
        InterfaceC0863O[] interfaceC0863OArrG = g();
        int iC = c();
        k(iC + 1);
        interfaceC0863OArrG[iC] = interfaceC0863O;
        interfaceC0863O.setIndex(iC);
        m(iC);
    }

    public final InterfaceC0863O b() {
        InterfaceC0863O[] interfaceC0863OArr = this.f13769a;
        if (interfaceC0863OArr != null) {
            return interfaceC0863OArr[0];
        }
        return null;
    }

    public final int c() {
        return f13768b.get(this);
    }

    public final boolean e() {
        return c() == 0;
    }

    public final InterfaceC0863O f() {
        InterfaceC0863O interfaceC0863OB;
        synchronized (this) {
            interfaceC0863OB = b();
        }
        return interfaceC0863OB;
    }

    public final InterfaceC0863O[] g() {
        InterfaceC0863O[] interfaceC0863OArr = this.f13769a;
        if (interfaceC0863OArr == null) {
            InterfaceC0863O[] interfaceC0863OArr2 = new InterfaceC0863O[4];
            this.f13769a = interfaceC0863OArr2;
            return interfaceC0863OArr2;
        }
        if (c() < interfaceC0863OArr.length) {
            return interfaceC0863OArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(interfaceC0863OArr, c() * 2);
        M5.m.d(objArrCopyOf, "copyOf(...)");
        InterfaceC0863O[] interfaceC0863OArr3 = (InterfaceC0863O[]) objArrCopyOf;
        this.f13769a = interfaceC0863OArr3;
        return interfaceC0863OArr3;
    }

    public final boolean h(InterfaceC0863O interfaceC0863O) {
        boolean z7;
        synchronized (this) {
            if (interfaceC0863O.e() == null) {
                z7 = false;
            } else {
                i(interfaceC0863O.getIndex());
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
    public final b6.InterfaceC0863O i(int r6) {
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
        throw new UnsupportedOperationException("Method not decompiled: b6.C0862N.i(int):b6.O");
    }

    public final InterfaceC0863O j() {
        InterfaceC0863O interfaceC0863OI;
        synchronized (this) {
            interfaceC0863OI = c() > 0 ? i(0) : null;
        }
        return interfaceC0863OI;
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
        throw new UnsupportedOperationException("Method not decompiled: b6.C0862N.l(int):void");
    }

    public final void m(int i7) {
        while (i7 > 0) {
            InterfaceC0863O[] interfaceC0863OArr = this.f13769a;
            M5.m.b(interfaceC0863OArr);
            int i8 = (i7 - 1) / 2;
            InterfaceC0863O interfaceC0863O = interfaceC0863OArr[i8];
            M5.m.b(interfaceC0863O);
            InterfaceC0863O interfaceC0863O2 = interfaceC0863OArr[i7];
            M5.m.b(interfaceC0863O2);
            if (((Comparable) interfaceC0863O).compareTo(interfaceC0863O2) <= 0) {
                return;
            }
            n(i7, i8);
            i7 = i8;
        }
    }

    public final void n(int i7, int i8) {
        InterfaceC0863O[] interfaceC0863OArr = this.f13769a;
        M5.m.b(interfaceC0863OArr);
        InterfaceC0863O interfaceC0863O = interfaceC0863OArr[i8];
        M5.m.b(interfaceC0863O);
        InterfaceC0863O interfaceC0863O2 = interfaceC0863OArr[i7];
        M5.m.b(interfaceC0863O2);
        interfaceC0863OArr[i7] = interfaceC0863O;
        interfaceC0863OArr[i8] = interfaceC0863O2;
        interfaceC0863O.setIndex(i7);
        interfaceC0863O2.setIndex(i8);
    }
}
