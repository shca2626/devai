package D1;

import E0.InterfaceC0325k;
import java.util.List;

/* loaded from: classes.dex */
public abstract class i {
    public static int a(k kVar, long j7) {
        if (j7 == -9223372036854775807L) {
            return 0;
        }
        int iA = kVar.a(j7);
        if (iA == -1) {
            iA = kVar.f();
        }
        return (iA <= 0 || kVar.d(iA + (-1)) != j7) ? iA : iA - 1;
    }

    public static void b(k kVar, int i7, InterfaceC0325k interfaceC0325k) {
        long jD = kVar.d(i7);
        List listE = kVar.e(jD);
        if (listE.isEmpty()) {
            return;
        }
        if (i7 == kVar.f() - 1) {
            throw new IllegalStateException();
        }
        long jD2 = kVar.d(i7 + 1) - kVar.d(i7);
        if (jD2 > 0) {
            interfaceC0325k.accept(new e(listE, jD, jD2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(D1.k r11, D1.s.b r12, E0.InterfaceC0325k r13) {
        /*
            long r0 = r12.f1640a
            int r0 = a(r11, r0)
            long r1 = r12.f1640a
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L3a
            int r1 = r11.f()
            if (r0 >= r1) goto L3a
            long r3 = r12.f1640a
            java.util.List r6 = r11.e(r3)
            long r3 = r11.d(r0)
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L3a
            long r7 = r12.f1640a
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 >= 0) goto L3a
            D1.e r5 = new D1.e
            long r9 = r3 - r7
            r5.<init>(r6, r7, r9)
            r13.accept(r5)
            r1 = 1
            goto L3b
        L3a:
            r1 = r2
        L3b:
            r3 = r0
        L3c:
            int r4 = r11.f()
            if (r3 >= r4) goto L48
            b(r11, r3, r13)
            int r3 = r3 + 1
            goto L3c
        L48:
            boolean r3 = r12.f1641b
            if (r3 == 0) goto L74
            if (r1 == 0) goto L50
            int r0 = r0 + (-1)
        L50:
            if (r2 >= r0) goto L58
            b(r11, r2, r13)
            int r2 = r2 + 1
            goto L50
        L58:
            if (r1 == 0) goto L74
            D1.e r3 = new D1.e
            long r1 = r12.f1640a
            java.util.List r4 = r11.e(r1)
            long r5 = r11.d(r0)
            long r1 = r12.f1640a
            long r11 = r11.d(r0)
            long r7 = r1 - r11
            r3.<init>(r4, r5, r7)
            r13.accept(r3)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: D1.i.c(D1.k, D1.s$b, E0.k):void");
    }
}
