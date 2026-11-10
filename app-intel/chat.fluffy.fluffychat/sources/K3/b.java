package K3;

import D3.j;
import D3.p;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final J3.b f5407a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5408b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5409c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5410d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5411e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5412f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5413g;

    public b(J3.b bVar) {
        this(bVar, 10, bVar.o() / 2, bVar.l() / 2);
    }

    public final p[] a(p pVar, p pVar2, p pVar3, p pVar4) {
        float fC = pVar.c();
        float fD = pVar.d();
        float fC2 = pVar2.c();
        float fD2 = pVar2.d();
        float fC3 = pVar3.c();
        float fD3 = pVar3.d();
        float fC4 = pVar4.c();
        float fD4 = pVar4.d();
        return fC < ((float) this.f5409c) / 2.0f ? new p[]{new p(fC4 - 1.0f, fD4 + 1.0f), new p(fC2 + 1.0f, fD2 + 1.0f), new p(fC3 - 1.0f, fD3 - 1.0f), new p(fC + 1.0f, fD - 1.0f)} : new p[]{new p(fC4 + 1.0f, fD4 + 1.0f), new p(fC2 + 1.0f, fD2 - 1.0f), new p(fC3 - 1.0f, fD3 + 1.0f), new p(fC - 1.0f, fD - 1.0f)};
    }

    public final boolean b(int i7, int i8, int i9, boolean z7) {
        if (z7) {
            while (i7 <= i8) {
                if (this.f5407a.g(i7, i9)) {
                    return true;
                }
                i7++;
            }
            return false;
        }
        while (i7 <= i8) {
            if (this.f5407a.g(i9, i7)) {
                return true;
            }
            i7++;
        }
        return false;
    }

    public p[] c() throws j {
        int i7 = this.f5410d;
        int i8 = this.f5411e;
        int i9 = this.f5413g;
        int i10 = this.f5412f;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = true;
        while (z12) {
            boolean z13 = false;
            boolean zB = true;
            while (true) {
                if ((!zB && z8) || i8 >= this.f5409c) {
                    break;
                }
                zB = b(i9, i10, i8, false);
                if (zB) {
                    i8++;
                    z8 = true;
                    z13 = true;
                } else if (!z8) {
                    i8++;
                }
            }
            if (i8 < this.f5409c) {
                boolean zB2 = true;
                while (true) {
                    if ((!zB2 && z9) || i10 >= this.f5408b) {
                        break;
                    }
                    zB2 = b(i7, i8, i10, true);
                    if (zB2) {
                        i10++;
                        z9 = true;
                        z13 = true;
                    } else if (!z9) {
                        i10++;
                    }
                }
                if (i10 < this.f5408b) {
                    boolean zB3 = true;
                    while (true) {
                        if ((!zB3 && z10) || i7 < 0) {
                            break;
                        }
                        zB3 = b(i9, i10, i7, false);
                        if (zB3) {
                            i7--;
                            z10 = true;
                            z13 = true;
                        } else if (!z10) {
                            i7--;
                        }
                    }
                    if (i7 >= 0) {
                        z12 = z13;
                        boolean zB4 = true;
                        while (true) {
                            if ((!zB4 && z11) || i9 < 0) {
                                break;
                            }
                            zB4 = b(i7, i8, i9, true);
                            if (zB4) {
                                i9--;
                                z12 = true;
                                z11 = true;
                            } else if (!z11) {
                                i9--;
                            }
                        }
                        if (i9 < 0) {
                        }
                    }
                }
            }
            z7 = true;
            break;
        }
        if (z7) {
            throw j.a();
        }
        int i11 = i8 - i7;
        p pVarD = null;
        p pVarD2 = null;
        for (int i12 = 1; pVarD2 == null && i12 < i11; i12++) {
            pVarD2 = d(i7, i10 - i12, i7 + i12, i10);
        }
        if (pVarD2 == null) {
            throw j.a();
        }
        p pVarD3 = null;
        for (int i13 = 1; pVarD3 == null && i13 < i11; i13++) {
            pVarD3 = d(i7, i9 + i13, i7 + i13, i9);
        }
        if (pVarD3 == null) {
            throw j.a();
        }
        p pVarD4 = null;
        for (int i14 = 1; pVarD4 == null && i14 < i11; i14++) {
            pVarD4 = d(i8, i9 + i14, i8 - i14, i9);
        }
        if (pVarD4 == null) {
            throw j.a();
        }
        for (int i15 = 1; pVarD == null && i15 < i11; i15++) {
            pVarD = d(i8, i10 - i15, i8 - i15, i10);
        }
        if (pVarD != null) {
            return a(pVarD, pVarD2, pVarD4, pVarD3);
        }
        throw j.a();
    }

    public final p d(float f7, float f8, float f9, float f10) {
        int iC = a.c(a.a(f7, f8, f9, f10));
        float f11 = iC;
        float f12 = (f9 - f7) / f11;
        float f13 = (f10 - f8) / f11;
        for (int i7 = 0; i7 < iC; i7++) {
            float f14 = i7;
            int iC2 = a.c((f14 * f12) + f7);
            int iC3 = a.c((f14 * f13) + f8);
            if (this.f5407a.g(iC2, iC3)) {
                return new p(iC2, iC3);
            }
        }
        return null;
    }

    public b(J3.b bVar, int i7, int i8, int i9) throws j {
        this.f5407a = bVar;
        int iL = bVar.l();
        this.f5408b = iL;
        int iO = bVar.o();
        this.f5409c = iO;
        int i10 = i7 / 2;
        int i11 = i8 - i10;
        this.f5410d = i11;
        int i12 = i8 + i10;
        this.f5411e = i12;
        int i13 = i9 - i10;
        this.f5413g = i13;
        int i14 = i9 + i10;
        this.f5412f = i14;
        if (i13 < 0 || i11 < 0 || i14 >= iL || i12 >= iO) {
            throw j.a();
        }
    }
}
