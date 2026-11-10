package E;

import E.e;
import F.b;
import java.util.Arrays;

/* loaded from: classes.dex */
public class f extends l {

    /* renamed from: B0, reason: collision with root package name */
    public D.e f1969B0;

    /* renamed from: D0, reason: collision with root package name */
    public int f1971D0;

    /* renamed from: E0, reason: collision with root package name */
    public int f1972E0;

    /* renamed from: F0, reason: collision with root package name */
    public int f1973F0;

    /* renamed from: G0, reason: collision with root package name */
    public int f1974G0;

    /* renamed from: x0, reason: collision with root package name */
    public F.b f1989x0 = new F.b(this);

    /* renamed from: y0, reason: collision with root package name */
    public F.e f1990y0 = new F.e(this);

    /* renamed from: z0, reason: collision with root package name */
    public b.InterfaceC0022b f1991z0 = null;

    /* renamed from: A0, reason: collision with root package name */
    public boolean f1968A0 = false;

    /* renamed from: C0, reason: collision with root package name */
    public D.d f1970C0 = new D.d();

    /* renamed from: H0, reason: collision with root package name */
    public int f1975H0 = 0;

    /* renamed from: I0, reason: collision with root package name */
    public int f1976I0 = 0;

    /* renamed from: J0, reason: collision with root package name */
    public c[] f1977J0 = new c[4];

    /* renamed from: K0, reason: collision with root package name */
    public c[] f1978K0 = new c[4];

    /* renamed from: L0, reason: collision with root package name */
    public boolean f1979L0 = false;

    /* renamed from: M0, reason: collision with root package name */
    public boolean f1980M0 = false;

    /* renamed from: N0, reason: collision with root package name */
    public boolean f1981N0 = false;

    /* renamed from: O0, reason: collision with root package name */
    public int f1982O0 = 0;

    /* renamed from: P0, reason: collision with root package name */
    public int f1983P0 = 0;

    /* renamed from: Q0, reason: collision with root package name */
    public int f1984Q0 = 263;

    /* renamed from: R0, reason: collision with root package name */
    public boolean f1985R0 = false;

    /* renamed from: S0, reason: collision with root package name */
    public boolean f1986S0 = false;

    /* renamed from: T0, reason: collision with root package name */
    public boolean f1987T0 = false;

    /* renamed from: U0, reason: collision with root package name */
    public int f1988U0 = 0;

    @Override // E.e
    public void F0(boolean z7, boolean z8) {
        super.F0(z7, z8);
        int size = this.f2015w0.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((e) this.f2015w0.get(i7)).F0(z7, z8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01cb A[PHI: r0 r12
      0x01cb: PHI (r0v26 boolean) = (r0v25 boolean), (r0v28 boolean), (r0v28 boolean), (r0v28 boolean) binds: [B:69:0x0190, B:77:0x01b3, B:78:0x01b5, B:80:0x01bb] A[DONT_GENERATE, DONT_INLINE]
      0x01cb: PHI (r12v5 boolean) = (r12v4 boolean), (r12v7 boolean), (r12v7 boolean), (r12v7 boolean) binds: [B:69:0x0190, B:77:0x01b3, B:78:0x01b5, B:80:0x01bb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    @Override // E.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void H0() {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: E.f.H0():void");
    }

    public void K0(e eVar, int i7) {
        if (i7 == 0) {
            M0(eVar);
        } else if (i7 == 1) {
            N0(eVar);
        }
    }

    public boolean L0(D.d dVar) {
        f(dVar);
        int size = this.f2015w0.size();
        boolean z7 = false;
        for (int i7 = 0; i7 < size; i7++) {
            e eVar = (e) this.f2015w0.get(i7);
            eVar.l0(0, false);
            eVar.l0(1, false);
            if (eVar instanceof a) {
                z7 = true;
            }
        }
        if (z7) {
            for (int i8 = 0; i8 < size; i8++) {
                e eVar2 = (e) this.f2015w0.get(i8);
                if (eVar2 instanceof a) {
                    ((a) eVar2).K0();
                }
            }
        }
        for (int i9 = 0; i9 < size; i9++) {
            e eVar3 = (e) this.f2015w0.get(i9);
            if (eVar3.e()) {
                eVar3.f(dVar);
            }
        }
        for (int i10 = 0; i10 < size; i10++) {
            e eVar4 = (e) this.f2015w0.get(i10);
            if (eVar4 instanceof f) {
                e.b[] bVarArr = eVar4.f1900M;
                e.b bVar = bVarArr[0];
                e.b bVar2 = bVarArr[1];
                e.b bVar3 = e.b.WRAP_CONTENT;
                if (bVar == bVar3) {
                    eVar4.i0(e.b.FIXED);
                }
                if (bVar2 == bVar3) {
                    eVar4.x0(e.b.FIXED);
                }
                eVar4.f(dVar);
                if (bVar == bVar3) {
                    eVar4.i0(bVar);
                }
                if (bVar2 == bVar3) {
                    eVar4.x0(bVar2);
                }
            } else {
                j.a(this, dVar, eVar4);
                if (!eVar4.e()) {
                    eVar4.f(dVar);
                }
            }
        }
        if (this.f1975H0 > 0) {
            b.a(this, dVar, 0);
        }
        if (this.f1976I0 > 0) {
            b.a(this, dVar, 1);
        }
        return true;
    }

    public final void M0(e eVar) {
        int i7 = this.f1975H0 + 1;
        c[] cVarArr = this.f1978K0;
        if (i7 >= cVarArr.length) {
            this.f1978K0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f1978K0[this.f1975H0] = new c(eVar, 0, W0());
        this.f1975H0++;
    }

    public final void N0(e eVar) {
        int i7 = this.f1976I0 + 1;
        c[] cVarArr = this.f1977J0;
        if (i7 >= cVarArr.length) {
            this.f1977J0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f1977J0[this.f1976I0] = new c(eVar, 1, W0());
        this.f1976I0++;
    }

    public boolean O0(boolean z7) {
        return this.f1990y0.f(z7);
    }

    public boolean P0(boolean z7) {
        return this.f1990y0.g(z7);
    }

    public boolean Q0(boolean z7, int i7) {
        return this.f1990y0.h(z7, i7);
    }

    public b.InterfaceC0022b R0() {
        return this.f1991z0;
    }

    public int S0() {
        return this.f1984Q0;
    }

    public void T0() {
        this.f1990y0.j();
    }

    public void U0() {
        this.f1990y0.k();
    }

    public boolean V0() {
        return this.f1987T0;
    }

    @Override // E.l, E.e
    public void W() {
        this.f1970C0.D();
        this.f1971D0 = 0;
        this.f1973F0 = 0;
        this.f1972E0 = 0;
        this.f1974G0 = 0;
        this.f1985R0 = false;
        super.W();
    }

    public boolean W0() {
        return this.f1968A0;
    }

    public boolean X0() {
        return this.f1986S0;
    }

    public long Y0(int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f1971D0 = i14;
        this.f1972E0 = i15;
        return this.f1989x0.d(this, i7, i14, i15, i8, i9, i10, i11, i12, i13);
    }

    public boolean Z0(int i7) {
        return (this.f1984Q0 & i7) == i7;
    }

    public final void a1() {
        this.f1975H0 = 0;
        this.f1976I0 = 0;
    }

    public void b1(b.InterfaceC0022b interfaceC0022b) {
        this.f1991z0 = interfaceC0022b;
        this.f1990y0.n(interfaceC0022b);
    }

    public void c1(int i7) {
        this.f1984Q0 = i7;
        D.d.f1434s = j.b(i7, 256);
    }

    public void d1(boolean z7) {
        this.f1968A0 = z7;
    }

    public void e1(D.d dVar, boolean[] zArr) {
        zArr[2] = false;
        G0(dVar);
        int size = this.f2015w0.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((e) this.f2015w0.get(i7)).G0(dVar);
        }
    }

    public void f1() {
        this.f1989x0.e(this);
    }
}
