package a1;

import java.util.ArrayList;
import k3.AbstractC1278v;
import k3.D;

/* renamed from: a1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0753f implements InterfaceC0748a {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10543a = new ArrayList();

    @Override // a1.InterfaceC0748a
    public long a(long j7) {
        if (this.f10543a.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j7 < ((D1.e) this.f10543a.get(0)).f1612b) {
            return ((D1.e) this.f10543a.get(0)).f1612b;
        }
        for (int i7 = 1; i7 < this.f10543a.size(); i7++) {
            D1.e eVar = (D1.e) this.f10543a.get(i7);
            if (j7 < eVar.f1612b) {
                long j8 = ((D1.e) this.f10543a.get(i7 - 1)).f1614d;
                return (j8 == -9223372036854775807L || j8 <= j7 || j8 >= eVar.f1612b) ? eVar.f1612b : j8;
            }
        }
        long j9 = ((D1.e) D.d(this.f10543a)).f1614d;
        if (j9 == -9223372036854775807L || j7 >= j9) {
            return Long.MIN_VALUE;
        }
        return j9;
    }

    @Override // a1.InterfaceC0748a
    public AbstractC1278v b(long j7) {
        int iF = f(j7);
        if (iF == 0) {
            return AbstractC1278v.v();
        }
        D1.e eVar = (D1.e) this.f10543a.get(iF - 1);
        long j8 = eVar.f1614d;
        return (j8 == -9223372036854775807L || j7 < j8) ? eVar.f1611a : AbstractC1278v.v();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // a1.InterfaceC0748a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(D1.e r10, long r11) {
        /*
            r9 = this;
            long r0 = r10.f1612b
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r4 = 1
            if (r0 == 0) goto Lf
            r0 = r4
            goto L10
        Lf:
            r0 = r1
        L10:
            j3.o.d(r0)
            long r5 = r10.f1612b
            int r0 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r0 > 0) goto L25
            long r5 = r10.f1614d
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 == 0) goto L23
            int r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r0 >= 0) goto L25
        L23:
            r0 = r4
            goto L26
        L25:
            r0 = r1
        L26:
            java.util.ArrayList r2 = r9.f10543a
            int r2 = r2.size()
            int r2 = r2 - r4
        L2d:
            if (r2 < 0) goto L58
            long r5 = r10.f1612b
            java.util.ArrayList r3 = r9.f10543a
            java.lang.Object r3 = r3.get(r2)
            D1.e r3 = (D1.e) r3
            long r7 = r3.f1612b
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 < 0) goto L46
            java.util.ArrayList r11 = r9.f10543a
            int r2 = r2 + r4
            r11.add(r2, r10)
            return r0
        L46:
            java.util.ArrayList r3 = r9.f10543a
            java.lang.Object r3 = r3.get(r2)
            D1.e r3 = (D1.e) r3
            long r5 = r3.f1612b
            int r3 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r3 > 0) goto L55
            r0 = r1
        L55:
            int r2 = r2 + (-1)
            goto L2d
        L58:
            java.util.ArrayList r11 = r9.f10543a
            r11.add(r1, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.C0753f.c(D1.e, long):boolean");
    }

    @Override // a1.InterfaceC0748a
    public void clear() {
        this.f10543a.clear();
    }

    @Override // a1.InterfaceC0748a
    public long d(long j7) {
        if (this.f10543a.isEmpty() || j7 < ((D1.e) this.f10543a.get(0)).f1612b) {
            return -9223372036854775807L;
        }
        for (int i7 = 1; i7 < this.f10543a.size(); i7++) {
            long j8 = ((D1.e) this.f10543a.get(i7)).f1612b;
            if (j7 == j8) {
                return j8;
            }
            if (j7 < j8) {
                D1.e eVar = (D1.e) this.f10543a.get(i7 - 1);
                long j9 = eVar.f1614d;
                return (j9 == -9223372036854775807L || j9 > j7) ? eVar.f1612b : j9;
            }
        }
        D1.e eVar2 = (D1.e) D.d(this.f10543a);
        long j10 = eVar2.f1614d;
        return (j10 == -9223372036854775807L || j7 < j10) ? eVar2.f1612b : j10;
    }

    @Override // a1.InterfaceC0748a
    public void e(long j7) {
        int iF = f(j7);
        if (iF == 0) {
            return;
        }
        long j8 = ((D1.e) this.f10543a.get(iF - 1)).f1614d;
        if (j8 == -9223372036854775807L || j8 >= j7) {
            iF--;
        }
        this.f10543a.subList(0, iF).clear();
    }

    public final int f(long j7) {
        for (int i7 = 0; i7 < this.f10543a.size(); i7++) {
            if (j7 < ((D1.e) this.f10543a.get(i7)).f1612b) {
                return i7;
            }
        }
        return this.f10543a.size();
    }
}
