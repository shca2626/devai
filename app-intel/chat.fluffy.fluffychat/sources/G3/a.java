package G3;

import D3.j;
import D3.p;
import L3.c;
import L3.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f3260g = {3808, 476, 2107, 1799};

    /* renamed from: a, reason: collision with root package name */
    public final J3.b f3261a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3262b;

    /* renamed from: c, reason: collision with root package name */
    public int f3263c;

    /* renamed from: d, reason: collision with root package name */
    public int f3264d;

    /* renamed from: e, reason: collision with root package name */
    public int f3265e;

    /* renamed from: f, reason: collision with root package name */
    public int f3266f;

    /* renamed from: G3.a$a, reason: collision with other inner class name */
    public static final class C0036a {

        /* renamed from: a, reason: collision with root package name */
        public final int f3267a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3268b;

        public C0036a(int i7, int i8) {
            this.f3267a = i7;
            this.f3268b = i8;
        }

        public int a() {
            return this.f3267a;
        }

        public int b() {
            return this.f3268b;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f3269a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3270b;

        public b(int i7, int i8) {
            this.f3269a = i7;
            this.f3270b = i8;
        }

        public int a() {
            return this.f3269a;
        }

        public int b() {
            return this.f3270b;
        }

        public p c() {
            return new p(this.f3269a, this.f3270b);
        }

        public String toString() {
            return "<" + this.f3269a + ' ' + this.f3270b + '>';
        }
    }

    public a(J3.b bVar) {
        this.f3261a = bVar;
    }

    public static float b(p pVar, p pVar2) {
        return K3.a.a(pVar.c(), pVar.d(), pVar2.c(), pVar2.d());
    }

    public static float c(b bVar, b bVar2) {
        return K3.a.b(bVar.a(), bVar.b(), bVar2.a(), bVar2.b());
    }

    public static p[] d(p[] pVarArr, int i7, int i8) {
        float f7 = i8 / (i7 * 2.0f);
        float fC = pVarArr[0].c() - pVarArr[2].c();
        float fD = pVarArr[0].d() - pVarArr[2].d();
        float fC2 = (pVarArr[0].c() + pVarArr[2].c()) / 2.0f;
        float fD2 = (pVarArr[0].d() + pVarArr[2].d()) / 2.0f;
        float f8 = fC * f7;
        float f9 = fD * f7;
        p pVar = new p(fC2 + f8, fD2 + f9);
        p pVar2 = new p(fC2 - f8, fD2 - f9);
        float fC3 = pVarArr[1].c() - pVarArr[3].c();
        float fD3 = pVarArr[1].d() - pVarArr[3].d();
        float fC4 = (pVarArr[1].c() + pVarArr[3].c()) / 2.0f;
        float fD4 = (pVarArr[1].d() + pVarArr[3].d()) / 2.0f;
        float f10 = fC3 * f7;
        float f11 = f7 * fD3;
        return new p[]{pVar, new p(fC4 + f10, fD4 + f11), pVar2, new p(fC4 - f10, fD4 - f11)};
    }

    public static C0036a h(long j7, boolean z7) throws j {
        int i7;
        int i8;
        if (z7) {
            i7 = 7;
            i8 = 2;
        } else {
            i7 = 10;
            i8 = 4;
        }
        int i9 = i7 - i8;
        int[] iArr = new int[i7];
        for (int i10 = i7 - 1; i10 >= 0; i10--) {
            iArr[i10] = ((int) j7) & 15;
            j7 >>= 4;
        }
        try {
            int iA = new c(L3.a.f5462k).a(iArr, i9);
            int i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                i11 = (i11 << 4) + iArr[i12];
            }
            return new C0036a(i11, iA);
        } catch (d unused) {
            throw j.a();
        }
    }

    public static int m(int[] iArr, int i7) throws j {
        int i8 = 0;
        for (int i9 : iArr) {
            i8 = (i8 << 3) + ((i9 >> (i7 - 2)) << 1) + (i9 & 1);
        }
        int i10 = ((i8 & 1) << 11) + (i8 >> 1);
        for (int i11 = 0; i11 < 4; i11++) {
            if (Integer.bitCount(f3260g[i11] ^ i10) <= 2) {
                return i11;
            }
        }
        throw j.a();
    }

    public E3.a a(boolean z7) throws j {
        p[] pVarArrF = f(k());
        if (z7) {
            p pVar = pVarArrF[0];
            pVarArrF[0] = pVarArrF[2];
            pVarArrF[2] = pVar;
        }
        int iE = e(pVarArrF);
        J3.b bVar = this.f3261a;
        int i7 = this.f3266f;
        return new E3.a(q(bVar, pVarArrF[i7 % 4], pVarArrF[(i7 + 1) % 4], pVarArrF[(i7 + 2) % 4], pVarArrF[(i7 + 3) % 4]), l(pVarArrF), this.f3262b, this.f3264d, this.f3263c, iE);
    }

    public final int e(p[] pVarArr) throws j {
        long j7;
        long j8;
        if (!o(pVarArr[0]) || !o(pVarArr[1]) || !o(pVarArr[2]) || !o(pVarArr[3])) {
            throw j.a();
        }
        int i7 = this.f3265e * 2;
        int[] iArr = {r(pVarArr[0], pVarArr[1], i7), r(pVarArr[1], pVarArr[2], i7), r(pVarArr[2], pVarArr[3], i7), r(pVarArr[3], pVarArr[0], i7)};
        this.f3266f = m(iArr, i7);
        long j9 = 0;
        for (int i8 = 0; i8 < 4; i8++) {
            int i9 = iArr[(this.f3266f + i8) % 4];
            if (this.f3262b) {
                j7 = j9 << 7;
                j8 = (i9 >> 1) & 127;
            } else {
                j7 = j9 << 10;
                j8 = ((i9 >> 2) & 992) + ((i9 >> 1) & 31);
            }
            j9 = j7 + j8;
        }
        C0036a c0036aH = h(j9, this.f3262b);
        int iA = c0036aH.a();
        if (this.f3262b) {
            this.f3263c = (iA >> 6) + 1;
            this.f3264d = (iA & 63) + 1;
        } else {
            this.f3263c = (iA >> 11) + 1;
            this.f3264d = (iA & 2047) + 1;
        }
        return c0036aH.b();
    }

    public final p[] f(b bVar) throws j {
        this.f3265e = 1;
        b bVar2 = bVar;
        b bVar3 = bVar2;
        b bVar4 = bVar3;
        boolean z7 = true;
        while (this.f3265e < 9) {
            b bVarJ = j(bVar, z7, 1, -1);
            b bVarJ2 = j(bVar2, z7, 1, 1);
            b bVarJ3 = j(bVar3, z7, -1, 1);
            b bVarJ4 = j(bVar4, z7, -1, -1);
            if (this.f3265e > 2) {
                double dC = (c(bVarJ4, bVarJ) * this.f3265e) / (c(bVar4, bVar) * (this.f3265e + 2));
                if (dC < 0.75d || dC > 1.25d || !p(bVarJ, bVarJ2, bVarJ3, bVarJ4)) {
                    break;
                }
            }
            z7 = !z7;
            this.f3265e++;
            bVar4 = bVarJ4;
            bVar = bVarJ;
            bVar2 = bVarJ2;
            bVar3 = bVarJ3;
        }
        int i7 = this.f3265e;
        if (i7 != 5 && i7 != 7) {
            throw j.a();
        }
        this.f3262b = i7 == 5;
        return d(new p[]{new p(bVar.a() + 0.5f, bVar.b() - 0.5f), new p(bVar2.a() + 0.5f, bVar2.b() + 0.5f), new p(bVar3.a() - 0.5f, bVar3.b() + 0.5f), new p(bVar4.a() - 0.5f, bVar4.b() - 0.5f)}, (r0 * 2) - 3, this.f3265e * 2);
    }

    public final int g(b bVar, b bVar2) {
        float fC = c(bVar, bVar2);
        if (fC == 0.0f) {
            return 0;
        }
        float fA = (bVar2.a() - bVar.a()) / fC;
        float fB = (bVar2.b() - bVar.b()) / fC;
        float fA2 = bVar.a();
        float fB2 = bVar.b();
        boolean zG = this.f3261a.g(bVar.a(), bVar.b());
        int iFloor = (int) Math.floor(fC);
        int i7 = 0;
        for (int i8 = 0; i8 < iFloor; i8++) {
            if (this.f3261a.g(K3.a.c(fA2), K3.a.c(fB2)) != zG) {
                i7++;
            }
            fA2 += fA;
            fB2 += fB;
        }
        float f7 = i7 / fC;
        if (f7 <= 0.1f || f7 >= 0.9f) {
            return (f7 <= 0.1f) == zG ? 1 : -1;
        }
        return 0;
    }

    public final int i() {
        if (this.f3262b) {
            return (this.f3263c * 4) + 11;
        }
        int i7 = this.f3263c;
        return (i7 * 4) + ((((i7 * 2) + 6) / 15) * 2) + 15;
    }

    public final b j(b bVar, boolean z7, int i7, int i8) {
        int iA = bVar.a() + i7;
        int iB = bVar.b();
        while (true) {
            iB += i8;
            if (!n(iA, iB) || this.f3261a.g(iA, iB) != z7) {
                break;
            }
            iA += i7;
        }
        int i9 = iA - i7;
        int i10 = iB - i8;
        while (n(i9, i10) && this.f3261a.g(i9, i10) == z7) {
            i9 += i7;
        }
        int i11 = i9 - i7;
        while (n(i11, i10) && this.f3261a.g(i11, i10) == z7) {
            i10 += i8;
        }
        return new b(i11, i10 - i8);
    }

    public final b k() {
        p pVarC;
        p pVar;
        p pVar2;
        p pVar3;
        p pVarC2;
        p pVarC3;
        p pVarC4;
        p pVarC5;
        try {
            p[] pVarArrC = new K3.b(this.f3261a).c();
            pVar2 = pVarArrC[0];
            pVar3 = pVarArrC[1];
            pVar = pVarArrC[2];
            pVarC = pVarArrC[3];
        } catch (j unused) {
            int iO = this.f3261a.o() / 2;
            int iL = this.f3261a.l() / 2;
            int i7 = iO + 7;
            int i8 = iL - 7;
            p pVarC6 = j(new b(i7, i8), false, 1, -1).c();
            int i9 = iL + 7;
            p pVarC7 = j(new b(i7, i9), false, 1, 1).c();
            int i10 = iO - 7;
            p pVarC8 = j(new b(i10, i9), false, -1, 1).c();
            pVarC = j(new b(i10, i8), false, -1, -1).c();
            pVar = pVarC8;
            pVar2 = pVarC6;
            pVar3 = pVarC7;
        }
        int iC = K3.a.c((((pVar2.c() + pVarC.c()) + pVar3.c()) + pVar.c()) / 4.0f);
        int iC2 = K3.a.c((((pVar2.d() + pVarC.d()) + pVar3.d()) + pVar.d()) / 4.0f);
        try {
            p[] pVarArrC2 = new K3.b(this.f3261a, 15, iC, iC2).c();
            pVarC2 = pVarArrC2[0];
            pVarC3 = pVarArrC2[1];
            pVarC4 = pVarArrC2[2];
            pVarC5 = pVarArrC2[3];
        } catch (j unused2) {
            int i11 = iC + 7;
            int i12 = iC2 - 7;
            pVarC2 = j(new b(i11, i12), false, 1, -1).c();
            int i13 = iC2 + 7;
            pVarC3 = j(new b(i11, i13), false, 1, 1).c();
            int i14 = iC - 7;
            pVarC4 = j(new b(i14, i13), false, -1, 1).c();
            pVarC5 = j(new b(i14, i12), false, -1, -1).c();
        }
        return new b(K3.a.c((((pVarC2.c() + pVarC5.c()) + pVarC3.c()) + pVarC4.c()) / 4.0f), K3.a.c((((pVarC2.d() + pVarC5.d()) + pVarC3.d()) + pVarC4.d()) / 4.0f));
    }

    public final p[] l(p[] pVarArr) {
        return d(pVarArr, this.f3265e * 2, i());
    }

    public final boolean n(int i7, int i8) {
        return i7 >= 0 && i7 < this.f3261a.o() && i8 >= 0 && i8 < this.f3261a.l();
    }

    public final boolean o(p pVar) {
        return n(K3.a.c(pVar.c()), K3.a.c(pVar.d()));
    }

    public final boolean p(b bVar, b bVar2, b bVar3, b bVar4) {
        b bVar5 = new b(Math.max(0, bVar.a() - 3), Math.min(this.f3261a.l() - 1, bVar.b() + 3));
        b bVar6 = new b(Math.max(0, bVar2.a() - 3), Math.max(0, bVar2.b() - 3));
        b bVar7 = new b(Math.min(this.f3261a.o() - 1, bVar3.a() + 3), Math.max(0, Math.min(this.f3261a.l() - 1, bVar3.b() - 3)));
        b bVar8 = new b(Math.min(this.f3261a.o() - 1, bVar4.a() + 3), Math.min(this.f3261a.l() - 1, bVar4.b() + 3));
        int iG = g(bVar8, bVar5);
        return iG != 0 && g(bVar5, bVar6) == iG && g(bVar6, bVar7) == iG && g(bVar7, bVar8) == iG;
    }

    public final J3.b q(J3.b bVar, p pVar, p pVar2, p pVar3, p pVar4) {
        J3.j jVarB = J3.j.b();
        int i7 = i();
        float f7 = i7 / 2.0f;
        int i8 = this.f3265e;
        float f8 = f7 - i8;
        float f9 = f7 + i8;
        return jVarB.c(bVar, i7, i7, f8, f8, f9, f8, f9, f9, f8, f9, pVar.c(), pVar.d(), pVar2.c(), pVar2.d(), pVar3.c(), pVar3.d(), pVar4.c(), pVar4.d());
    }

    public final int r(p pVar, p pVar2, int i7) {
        float fB = b(pVar, pVar2);
        float f7 = fB / i7;
        float fC = pVar.c();
        float fD = pVar.d();
        float fC2 = ((pVar2.c() - pVar.c()) * f7) / fB;
        float fD2 = (f7 * (pVar2.d() - pVar.d())) / fB;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            float f8 = i9;
            if (this.f3261a.g(K3.a.c((f8 * fC2) + fC), K3.a.c((f8 * fD2) + fD))) {
                i8 |= 1 << ((i7 - i9) - 1);
            }
        }
        return i8;
    }
}
