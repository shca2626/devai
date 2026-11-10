package E;

import E.e;

/* loaded from: classes.dex */
public class a extends i {

    /* renamed from: y0, reason: collision with root package name */
    public int f1845y0 = 0;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f1846z0 = true;

    /* renamed from: A0, reason: collision with root package name */
    public int f1844A0 = 0;

    public boolean H0() {
        return this.f1846z0;
    }

    public int I0() {
        return this.f1845y0;
    }

    public int J0() {
        return this.f1844A0;
    }

    public void K0() {
        for (int i7 = 0; i7 < this.f2000x0; i7++) {
            e eVar = this.f1999w0[i7];
            int i8 = this.f1845y0;
            if (i8 == 0 || i8 == 1) {
                eVar.l0(0, true);
            } else if (i8 == 2 || i8 == 3) {
                eVar.l0(1, true);
            }
        }
    }

    public void L0(boolean z7) {
        this.f1846z0 = z7;
    }

    public void M0(int i7) {
        this.f1845y0 = i7;
    }

    public void N0(int i7) {
        this.f1844A0 = i7;
    }

    @Override // E.e
    public void f(D.d dVar) {
        d[] dVarArr;
        boolean z7;
        int i7;
        int i8;
        int i9;
        d[] dVarArr2 = this.f1897J;
        dVarArr2[0] = this.f1889B;
        dVarArr2[2] = this.f1890C;
        dVarArr2[1] = this.f1891D;
        dVarArr2[3] = this.f1892E;
        int i10 = 0;
        while (true) {
            dVarArr = this.f1897J;
            if (i10 >= dVarArr.length) {
                break;
            }
            d dVar2 = dVarArr[i10];
            dVar2.f1875g = dVar.q(dVar2);
            i10++;
        }
        int i11 = this.f1845y0;
        if (i11 < 0 || i11 >= 4) {
            return;
        }
        d dVar3 = dVarArr[i11];
        for (int i12 = 0; i12 < this.f2000x0; i12++) {
            e eVar = this.f1999w0[i12];
            if ((this.f1846z0 || eVar.g()) && ((((i8 = this.f1845y0) == 0 || i8 == 1) && eVar.w() == e.b.MATCH_CONSTRAINT && eVar.f1889B.f1872d != null && eVar.f1891D.f1872d != null) || (((i9 = this.f1845y0) == 2 || i9 == 3) && eVar.K() == e.b.MATCH_CONSTRAINT && eVar.f1890C.f1872d != null && eVar.f1892E.f1872d != null))) {
                z7 = true;
                break;
            }
        }
        z7 = false;
        boolean z8 = this.f1889B.h() || this.f1891D.h();
        boolean z9 = this.f1890C.h() || this.f1892E.h();
        int i13 = !(!z7 && (((i7 = this.f1845y0) == 0 && z8) || ((i7 == 2 && z9) || ((i7 == 1 && z8) || (i7 == 3 && z9))))) ? 4 : 5;
        for (int i14 = 0; i14 < this.f2000x0; i14++) {
            e eVar2 = this.f1999w0[i14];
            if (this.f1846z0 || eVar2.g()) {
                D.i iVarQ = dVar.q(eVar2.f1897J[this.f1845y0]);
                d[] dVarArr3 = eVar2.f1897J;
                int i15 = this.f1845y0;
                d dVar4 = dVarArr3[i15];
                dVar4.f1875g = iVarQ;
                d dVar5 = dVar4.f1872d;
                int i16 = (dVar5 == null || dVar5.f1870b != this) ? 0 : dVar4.f1873e;
                if (i15 == 0 || i15 == 2) {
                    dVar.i(dVar3.f1875g, iVarQ, this.f1844A0 - i16, z7);
                } else {
                    dVar.g(dVar3.f1875g, iVarQ, this.f1844A0 + i16, z7);
                }
                dVar.e(dVar3.f1875g, iVarQ, this.f1844A0 + i16, i13);
            }
        }
        int i17 = this.f1845y0;
        if (i17 == 0) {
            dVar.e(this.f1891D.f1875g, this.f1889B.f1875g, 0, 8);
            dVar.e(this.f1889B.f1875g, this.f1901N.f1891D.f1875g, 0, 4);
            dVar.e(this.f1889B.f1875g, this.f1901N.f1889B.f1875g, 0, 0);
            return;
        }
        if (i17 == 1) {
            dVar.e(this.f1889B.f1875g, this.f1891D.f1875g, 0, 8);
            dVar.e(this.f1889B.f1875g, this.f1901N.f1889B.f1875g, 0, 4);
            dVar.e(this.f1889B.f1875g, this.f1901N.f1891D.f1875g, 0, 0);
        } else if (i17 == 2) {
            dVar.e(this.f1892E.f1875g, this.f1890C.f1875g, 0, 8);
            dVar.e(this.f1890C.f1875g, this.f1901N.f1892E.f1875g, 0, 4);
            dVar.e(this.f1890C.f1875g, this.f1901N.f1890C.f1875g, 0, 0);
        } else if (i17 == 3) {
            dVar.e(this.f1890C.f1875g, this.f1892E.f1875g, 0, 8);
            dVar.e(this.f1890C.f1875g, this.f1901N.f1890C.f1875g, 0, 4);
            dVar.e(this.f1890C.f1875g, this.f1901N.f1892E.f1875g, 0, 0);
        }
    }

    @Override // E.e
    public boolean g() {
        return true;
    }

    @Override // E.e
    public String toString() {
        String str = "[Barrier] " + p() + " {";
        for (int i7 = 0; i7 < this.f2000x0; i7++) {
            e eVar = this.f1999w0[i7];
            if (i7 > 0) {
                str = str + ", ";
            }
            str = str + eVar.p();
        }
        return str + "}";
    }
}
