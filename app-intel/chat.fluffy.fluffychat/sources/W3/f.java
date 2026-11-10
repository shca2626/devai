package W3;

import java.util.Formatter;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final a f8991a;

    /* renamed from: b, reason: collision with root package name */
    public final g[] f8992b;

    /* renamed from: c, reason: collision with root package name */
    public c f8993c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8994d;

    public f(a aVar, c cVar) {
        this.f8991a = aVar;
        int iA = aVar.a();
        this.f8994d = iA;
        this.f8993c = cVar;
        this.f8992b = new g[iA + 2];
    }

    public static boolean b(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.g() || dVar2.a() != dVar.a()) {
            return false;
        }
        dVar.i(dVar2.c());
        return true;
    }

    public static int c(int i7, int i8, d dVar) {
        if (dVar == null || dVar.g()) {
            return i8;
        }
        if (!dVar.h(i7)) {
            return i8 + 1;
        }
        dVar.i(i7);
        return 0;
    }

    public final void a(g gVar) {
        if (gVar != null) {
            ((h) gVar).g(this.f8991a);
        }
    }

    public final int d() {
        int iF = f();
        if (iF == 0) {
            return 0;
        }
        for (int i7 = 1; i7 < this.f8994d + 1; i7++) {
            d[] dVarArrD = this.f8992b[i7].d();
            for (int i8 = 0; i8 < dVarArrD.length; i8++) {
                d dVar = dVarArrD[i8];
                if (dVar != null && !dVar.g()) {
                    e(i7, i8, dVarArrD);
                }
            }
        }
        return iF;
    }

    public final void e(int i7, int i8, d[] dVarArr) {
        d dVar = dVarArr[i8];
        d[] dVarArrD = this.f8992b[i7 - 1].d();
        g gVar = this.f8992b[i7 + 1];
        d[] dVarArrD2 = gVar != null ? gVar.d() : dVarArrD;
        d[] dVarArr2 = new d[14];
        dVarArr2[2] = dVarArrD[i8];
        dVarArr2[3] = dVarArrD2[i8];
        if (i8 > 0) {
            int i9 = i8 - 1;
            dVarArr2[0] = dVarArr[i9];
            dVarArr2[4] = dVarArrD[i9];
            dVarArr2[5] = dVarArrD2[i9];
        }
        if (i8 > 1) {
            int i10 = i8 - 2;
            dVarArr2[8] = dVarArr[i10];
            dVarArr2[10] = dVarArrD[i10];
            dVarArr2[11] = dVarArrD2[i10];
        }
        if (i8 < dVarArr.length - 1) {
            int i11 = i8 + 1;
            dVarArr2[1] = dVarArr[i11];
            dVarArr2[6] = dVarArrD[i11];
            dVarArr2[7] = dVarArrD2[i11];
        }
        if (i8 < dVarArr.length - 2) {
            int i12 = i8 + 2;
            dVarArr2[9] = dVarArr[i12];
            dVarArr2[12] = dVarArrD[i12];
            dVarArr2[13] = dVarArrD2[i12];
        }
        for (int i13 = 0; i13 < 14 && !b(dVar, dVarArr2[i13]); i13++) {
        }
    }

    public final int f() {
        g();
        return h() + i();
    }

    public final void g() {
        g[] gVarArr = this.f8992b;
        g gVar = gVarArr[0];
        if (gVar == null || gVarArr[this.f8994d + 1] == null) {
            return;
        }
        d[] dVarArrD = gVar.d();
        d[] dVarArrD2 = this.f8992b[this.f8994d + 1].d();
        for (int i7 = 0; i7 < dVarArrD.length; i7++) {
            d dVar = dVarArrD[i7];
            if (dVar != null && dVarArrD2[i7] != null && dVar.c() == dVarArrD2[i7].c()) {
                for (int i8 = 1; i8 <= this.f8994d; i8++) {
                    d dVar2 = this.f8992b[i8].d()[i7];
                    if (dVar2 != null) {
                        dVar2.i(dVarArrD[i7].c());
                        if (!dVar2.g()) {
                            this.f8992b[i8].d()[i7] = null;
                        }
                    }
                }
            }
        }
    }

    public final int h() {
        g gVar = this.f8992b[0];
        if (gVar == null) {
            return 0;
        }
        d[] dVarArrD = gVar.d();
        int i7 = 0;
        for (int i8 = 0; i8 < dVarArrD.length; i8++) {
            d dVar = dVarArrD[i8];
            if (dVar != null) {
                int iC = dVar.c();
                int iC2 = 0;
                for (int i9 = 1; i9 < this.f8994d + 1 && iC2 < 2; i9++) {
                    d dVar2 = this.f8992b[i9].d()[i8];
                    if (dVar2 != null) {
                        iC2 = c(iC, iC2, dVar2);
                        if (!dVar2.g()) {
                            i7++;
                        }
                    }
                }
            }
        }
        return i7;
    }

    public final int i() {
        g[] gVarArr = this.f8992b;
        int i7 = this.f8994d;
        if (gVarArr[i7 + 1] == null) {
            return 0;
        }
        d[] dVarArrD = gVarArr[i7 + 1].d();
        int i8 = 0;
        for (int i9 = 0; i9 < dVarArrD.length; i9++) {
            d dVar = dVarArrD[i9];
            if (dVar != null) {
                int iC = dVar.c();
                int iC2 = 0;
                for (int i10 = this.f8994d + 1; i10 > 0 && iC2 < 2; i10--) {
                    d dVar2 = this.f8992b[i10].d()[i9];
                    if (dVar2 != null) {
                        iC2 = c(iC, iC2, dVar2);
                        if (!dVar2.g()) {
                            i8++;
                        }
                    }
                }
            }
        }
        return i8;
    }

    public int j() {
        return this.f8994d;
    }

    public int k() {
        return this.f8991a.b();
    }

    public int l() {
        return this.f8991a.c();
    }

    public c m() {
        return this.f8993c;
    }

    public g n(int i7) {
        return this.f8992b[i7];
    }

    public g[] o() {
        a(this.f8992b[0]);
        a(this.f8992b[this.f8994d + 1]);
        int i7 = 928;
        while (true) {
            int iD = d();
            if (iD <= 0 || iD >= i7) {
                break;
            }
            i7 = iD;
        }
        return this.f8992b;
    }

    public void p(c cVar) {
        this.f8993c = cVar;
    }

    public void q(int i7, g gVar) {
        this.f8992b[i7] = gVar;
    }

    public String toString() {
        g[] gVarArr = this.f8992b;
        g gVar = gVarArr[0];
        if (gVar == null) {
            gVar = gVarArr[this.f8994d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i7 = 0; i7 < gVar.d().length; i7++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i7));
                for (int i8 = 0; i8 < this.f8994d + 2; i8++) {
                    g gVar2 = this.f8992b[i8];
                    if (gVar2 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        d dVar = gVar2.d()[i7];
                        if (dVar == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    formatter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
