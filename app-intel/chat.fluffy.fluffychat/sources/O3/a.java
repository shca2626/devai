package O3;

import D3.p;
import J3.b;
import J3.g;
import J3.j;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f7297a;

    /* renamed from: b, reason: collision with root package name */
    public final K3.b f7298b;

    public a(b bVar) {
        this.f7297a = bVar;
        this.f7298b = new K3.b(bVar);
    }

    public static p f(p pVar, float f7, float f8) {
        float fC = pVar.c();
        float fD = pVar.d();
        return new p(fC < f7 ? fC - 1.0f : fC + 1.0f, fD < f8 ? fD - 1.0f : fD + 1.0f);
    }

    public static b g(b bVar, p pVar, p pVar2, p pVar3, p pVar4, int i7, int i8) {
        float f7 = i7 - 0.5f;
        float f8 = i8 - 0.5f;
        return j.b().c(bVar, i7, i8, 0.5f, 0.5f, f7, 0.5f, f7, f8, 0.5f, f8, pVar.c(), pVar.d(), pVar4.c(), pVar4.d(), pVar3.c(), pVar3.d(), pVar2.c(), pVar2.d());
    }

    public static p h(p pVar, p pVar2, int i7) {
        float f7 = i7 + 1;
        return new p(pVar.c() + ((pVar2.c() - pVar.c()) / f7), pVar.d() + ((pVar2.d() - pVar.d()) / f7));
    }

    public final p a(p[] pVarArr) {
        p pVar = pVarArr[0];
        p pVar2 = pVarArr[1];
        p pVar3 = pVarArr[2];
        p pVar4 = pVarArr[3];
        int iJ = j(pVar, pVar4);
        p pVarH = h(pVar, pVar2, (j(pVar2, pVar4) + 1) * 4);
        p pVarH2 = h(pVar3, pVar2, (iJ + 1) * 4);
        int iJ2 = j(pVarH, pVar4);
        int iJ3 = j(pVarH2, pVar4);
        float f7 = iJ2 + 1;
        p pVar5 = new p(pVar4.c() + ((pVar3.c() - pVar2.c()) / f7), pVar4.d() + ((pVar3.d() - pVar2.d()) / f7));
        float f8 = iJ3 + 1;
        p pVar6 = new p(pVar4.c() + ((pVar.c() - pVar2.c()) / f8), pVar4.d() + ((pVar.d() - pVar2.d()) / f8));
        if (e(pVar5)) {
            if (!e(pVar6) || j(pVarH, pVar5) + j(pVarH2, pVar5) > j(pVarH, pVar6) + j(pVarH2, pVar6)) {
                return pVar5;
            }
        } else if (!e(pVar6)) {
            return null;
        }
        return pVar6;
    }

    public g b() throws D3.j {
        int iMax;
        p[] pVarArrD = d(c(this.f7298b.c()));
        p pVarA = a(pVarArrD);
        pVarArrD[3] = pVarA;
        if (pVarA == null) {
            throw D3.j.a();
        }
        p[] pVarArrI = i(pVarArrD);
        p pVar = pVarArrI[0];
        p pVar2 = pVarArrI[1];
        p pVar3 = pVarArrI[2];
        p pVar4 = pVarArrI[3];
        int iJ = j(pVar, pVar4);
        int i7 = iJ + 1;
        int iJ2 = j(pVar3, pVar4);
        int i8 = iJ2 + 1;
        if ((i7 & 1) == 1) {
            i7 = iJ + 2;
        }
        if ((i8 & 1) == 1) {
            i8 = iJ2 + 2;
        }
        if (i7 * 4 >= i8 * 6 || i8 * 4 >= i7 * 6) {
            iMax = i7;
        } else {
            iMax = Math.max(i7, i8);
            i8 = iMax;
        }
        return new g(g(this.f7297a, pVar, pVar2, pVar3, pVar4, iMax, i8), new p[]{pVar, pVar2, pVar3, pVar4});
    }

    public final p[] c(p[] pVarArr) {
        p pVar = pVarArr[0];
        p pVar2 = pVarArr[1];
        p pVar3 = pVarArr[3];
        p pVar4 = pVarArr[2];
        int iJ = j(pVar, pVar2);
        int iJ2 = j(pVar2, pVar3);
        int iJ3 = j(pVar3, pVar4);
        int iJ4 = j(pVar4, pVar);
        p[] pVarArr2 = {pVar4, pVar, pVar2, pVar3};
        if (iJ > iJ2) {
            pVarArr2[0] = pVar;
            pVarArr2[1] = pVar2;
            pVarArr2[2] = pVar3;
            pVarArr2[3] = pVar4;
            iJ = iJ2;
        }
        if (iJ > iJ3) {
            pVarArr2[0] = pVar2;
            pVarArr2[1] = pVar3;
            pVarArr2[2] = pVar4;
            pVarArr2[3] = pVar;
        } else {
            iJ3 = iJ;
        }
        if (iJ3 > iJ4) {
            pVarArr2[0] = pVar3;
            pVarArr2[1] = pVar4;
            pVarArr2[2] = pVar;
            pVarArr2[3] = pVar2;
        }
        return pVarArr2;
    }

    public final p[] d(p[] pVarArr) {
        p pVar = pVarArr[0];
        p pVar2 = pVarArr[1];
        p pVar3 = pVarArr[2];
        p pVar4 = pVarArr[3];
        int iJ = (j(pVar, pVar4) + 1) * 4;
        if (j(h(pVar2, pVar3, iJ), pVar) < j(h(pVar3, pVar2, iJ), pVar4)) {
            pVarArr[0] = pVar;
            pVarArr[1] = pVar2;
            pVarArr[2] = pVar3;
            pVarArr[3] = pVar4;
            return pVarArr;
        }
        pVarArr[0] = pVar2;
        pVarArr[1] = pVar3;
        pVarArr[2] = pVar4;
        pVarArr[3] = pVar;
        return pVarArr;
    }

    public final boolean e(p pVar) {
        return pVar.c() >= 0.0f && pVar.c() <= ((float) (this.f7297a.o() - 1)) && pVar.d() > 0.0f && pVar.d() <= ((float) (this.f7297a.l() - 1));
    }

    public final p[] i(p[] pVarArr) {
        p pVar = pVarArr[0];
        p pVar2 = pVarArr[1];
        p pVar3 = pVarArr[2];
        p pVar4 = pVarArr[3];
        int iJ = j(pVar, pVar4) + 1;
        p pVarH = h(pVar, pVar2, (j(pVar3, pVar4) + 1) * 4);
        p pVarH2 = h(pVar3, pVar2, iJ * 4);
        int iJ2 = j(pVarH, pVar4);
        int i7 = iJ2 + 1;
        int iJ3 = j(pVarH2, pVar4);
        int i8 = iJ3 + 1;
        if ((i7 & 1) == 1) {
            i7 = iJ2 + 2;
        }
        if ((i8 & 1) == 1) {
            i8 = iJ3 + 2;
        }
        float fC = (((pVar.c() + pVar2.c()) + pVar3.c()) + pVar4.c()) / 4.0f;
        float fD = (((pVar.d() + pVar2.d()) + pVar3.d()) + pVar4.d()) / 4.0f;
        p pVarF = f(pVar, fC, fD);
        p pVarF2 = f(pVar2, fC, fD);
        p pVarF3 = f(pVar3, fC, fD);
        p pVarF4 = f(pVar4, fC, fD);
        int i9 = i8 * 4;
        int i10 = i7 * 4;
        return new p[]{h(h(pVarF, pVarF2, i9), pVarF4, i10), h(h(pVarF2, pVarF, i9), pVarF3, i10), h(h(pVarF3, pVarF4, i9), pVarF2, i10), h(h(pVarF4, pVarF3, i9), pVarF, i10)};
    }

    public final int j(p pVar, p pVar2) {
        int iC = (int) pVar.c();
        int iD = (int) pVar.d();
        int iC2 = (int) pVar2.c();
        int iMin = Math.min(this.f7297a.l() - 1, (int) pVar2.d());
        int i7 = 0;
        boolean z7 = Math.abs(iMin - iD) > Math.abs(iC2 - iC);
        if (z7) {
            iD = iC;
            iC = iD;
            iMin = iC2;
            iC2 = iMin;
        }
        int iAbs = Math.abs(iC2 - iC);
        int iAbs2 = Math.abs(iMin - iD);
        int i8 = (-iAbs) / 2;
        int i9 = iD < iMin ? 1 : -1;
        int i10 = iC >= iC2 ? -1 : 1;
        boolean zG = this.f7297a.g(z7 ? iD : iC, z7 ? iC : iD);
        while (iC != iC2) {
            boolean zG2 = this.f7297a.g(z7 ? iD : iC, z7 ? iC : iD);
            if (zG2 != zG) {
                i7++;
                zG = zG2;
            }
            i8 += iAbs2;
            if (i8 > 0) {
                if (iD == iMin) {
                    return i7;
                }
                iD += i9;
                i8 -= iAbs;
            }
            iC += i10;
        }
        return i7;
    }
}
