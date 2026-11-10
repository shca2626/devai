package D;

import D.i;
import E.d;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class d {

    /* renamed from: q, reason: collision with root package name */
    public static int f1432q = 1000;

    /* renamed from: r, reason: collision with root package name */
    public static e f1433r = null;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f1434s = true;

    /* renamed from: t, reason: collision with root package name */
    public static long f1435t;

    /* renamed from: u, reason: collision with root package name */
    public static long f1436u;

    /* renamed from: c, reason: collision with root package name */
    public a f1439c;

    /* renamed from: f, reason: collision with root package name */
    public D.b[] f1442f;

    /* renamed from: m, reason: collision with root package name */
    public final c f1449m;

    /* renamed from: p, reason: collision with root package name */
    public a f1452p;

    /* renamed from: a, reason: collision with root package name */
    public int f1437a = 0;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f1438b = null;

    /* renamed from: d, reason: collision with root package name */
    public int f1440d = 32;

    /* renamed from: e, reason: collision with root package name */
    public int f1441e = 32;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1443g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1444h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean[] f1445i = new boolean[32];

    /* renamed from: j, reason: collision with root package name */
    public int f1446j = 1;

    /* renamed from: k, reason: collision with root package name */
    public int f1447k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f1448l = 32;

    /* renamed from: n, reason: collision with root package name */
    public i[] f1450n = new i[f1432q];

    /* renamed from: o, reason: collision with root package name */
    public int f1451o = 0;

    public interface a {
        void a(a aVar);

        i b(d dVar, boolean[] zArr);

        void c(i iVar);

        void clear();

        i getKey();
    }

    public class b extends D.b {
        public b(c cVar) {
            this.f1426e = new j(this, cVar);
        }
    }

    public d() {
        this.f1442f = null;
        this.f1442f = new D.b[32];
        C();
        c cVar = new c();
        this.f1449m = cVar;
        this.f1439c = new h(cVar);
        if (f1434s) {
            this.f1452p = new b(cVar);
        } else {
            this.f1452p = new D.b(cVar);
        }
    }

    public static D.b s(d dVar, i iVar, i iVar2, float f7) {
        return dVar.r().j(iVar, iVar2, f7);
    }

    public static e w() {
        return f1433r;
    }

    public void A(a aVar) {
        e eVar = f1433r;
        if (eVar != null) {
            eVar.f1477t++;
            eVar.f1478u = Math.max(eVar.f1478u, this.f1446j);
            e eVar2 = f1433r;
            eVar2.f1479v = Math.max(eVar2.f1479v, this.f1447k);
        }
        u(aVar);
        B(aVar, false);
        n();
    }

    public final int B(a aVar, boolean z7) {
        e eVar = f1433r;
        if (eVar != null) {
            eVar.f1465h++;
        }
        for (int i7 = 0; i7 < this.f1446j; i7++) {
            this.f1445i[i7] = false;
        }
        boolean z8 = false;
        int i8 = 0;
        while (!z8) {
            e eVar2 = f1433r;
            if (eVar2 != null) {
                eVar2.f1466i++;
            }
            i8++;
            if (i8 < this.f1446j * 2) {
                if (aVar.getKey() != null) {
                    this.f1445i[aVar.getKey().f1499c] = true;
                }
                i iVarB = aVar.b(this, this.f1445i);
                if (iVarB != null) {
                    boolean[] zArr = this.f1445i;
                    int i9 = iVarB.f1499c;
                    if (!zArr[i9]) {
                        zArr[i9] = true;
                    }
                }
                if (iVarB != null) {
                    float f7 = Float.MAX_VALUE;
                    int i10 = -1;
                    for (int i11 = 0; i11 < this.f1447k; i11++) {
                        D.b bVar = this.f1442f[i11];
                        if (bVar.f1422a.f1506j != i.a.UNRESTRICTED && !bVar.f1427f && bVar.t(iVarB)) {
                            float fB = bVar.f1426e.b(iVarB);
                            if (fB < 0.0f) {
                                float f8 = (-bVar.f1423b) / fB;
                                if (f8 < f7) {
                                    i10 = i11;
                                    f7 = f8;
                                }
                            }
                        }
                    }
                    if (i10 > -1) {
                        D.b bVar2 = this.f1442f[i10];
                        bVar2.f1422a.f1500d = -1;
                        e eVar3 = f1433r;
                        if (eVar3 != null) {
                            eVar3.f1467j++;
                        }
                        bVar2.y(iVarB);
                        i iVar = bVar2.f1422a;
                        iVar.f1500d = i10;
                        iVar.g(bVar2);
                    }
                } else {
                    z8 = true;
                }
            }
            return i8;
        }
        return i8;
    }

    public final void C() {
        int i7 = 0;
        if (f1434s) {
            while (true) {
                D.b[] bVarArr = this.f1442f;
                if (i7 >= bVarArr.length) {
                    return;
                }
                D.b bVar = bVarArr[i7];
                if (bVar != null) {
                    this.f1449m.f1428a.a(bVar);
                }
                this.f1442f[i7] = null;
                i7++;
            }
        } else {
            while (true) {
                D.b[] bVarArr2 = this.f1442f;
                if (i7 >= bVarArr2.length) {
                    return;
                }
                D.b bVar2 = bVarArr2[i7];
                if (bVar2 != null) {
                    this.f1449m.f1429b.a(bVar2);
                }
                this.f1442f[i7] = null;
                i7++;
            }
        }
    }

    public void D() {
        c cVar;
        int i7 = 0;
        while (true) {
            cVar = this.f1449m;
            i[] iVarArr = cVar.f1431d;
            if (i7 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i7];
            if (iVar != null) {
                iVar.d();
            }
            i7++;
        }
        cVar.f1430c.c(this.f1450n, this.f1451o);
        this.f1451o = 0;
        Arrays.fill(this.f1449m.f1431d, (Object) null);
        HashMap map = this.f1438b;
        if (map != null) {
            map.clear();
        }
        this.f1437a = 0;
        this.f1439c.clear();
        this.f1446j = 1;
        for (int i8 = 0; i8 < this.f1447k; i8++) {
            this.f1442f[i8].f1424c = false;
        }
        C();
        this.f1447k = 0;
        if (f1434s) {
            this.f1452p = new b(this.f1449m);
        } else {
            this.f1452p = new D.b(this.f1449m);
        }
    }

    public final i a(i.a aVar, String str) {
        i iVar = (i) this.f1449m.f1430c.b();
        if (iVar == null) {
            iVar = new i(aVar, str);
            iVar.f(aVar, str);
        } else {
            iVar.d();
            iVar.f(aVar, str);
        }
        int i7 = this.f1451o;
        int i8 = f1432q;
        if (i7 >= i8) {
            int i9 = i8 * 2;
            f1432q = i9;
            this.f1450n = (i[]) Arrays.copyOf(this.f1450n, i9);
        }
        i[] iVarArr = this.f1450n;
        int i10 = this.f1451o;
        this.f1451o = i10 + 1;
        iVarArr[i10] = iVar;
        return iVar;
    }

    public void b(E.e eVar, E.e eVar2, float f7, int i7) {
        d.b bVar = d.b.LEFT;
        i iVarQ = q(eVar.k(bVar));
        d.b bVar2 = d.b.TOP;
        i iVarQ2 = q(eVar.k(bVar2));
        d.b bVar3 = d.b.RIGHT;
        i iVarQ3 = q(eVar.k(bVar3));
        d.b bVar4 = d.b.BOTTOM;
        i iVarQ4 = q(eVar.k(bVar4));
        i iVarQ5 = q(eVar2.k(bVar));
        i iVarQ6 = q(eVar2.k(bVar2));
        i iVarQ7 = q(eVar2.k(bVar3));
        i iVarQ8 = q(eVar2.k(bVar4));
        D.b bVarR = r();
        double d7 = f7;
        double d8 = i7;
        bVarR.q(iVarQ2, iVarQ4, iVarQ6, iVarQ8, (float) (Math.sin(d7) * d8));
        d(bVarR);
        D.b bVarR2 = r();
        bVarR2.q(iVarQ, iVarQ3, iVarQ5, iVarQ7, (float) (Math.cos(d7) * d8));
        d(bVarR2);
    }

    public void c(i iVar, i iVar2, int i7, float f7, i iVar3, i iVar4, int i8, int i9) {
        D.b bVarR = r();
        bVarR.h(iVar, iVar2, i7, f7, iVar3, iVar4, i8);
        if (i9 != 8) {
            bVarR.d(this, i9);
        }
        d(bVarR);
    }

    public void d(D.b bVar) {
        i iVarW;
        if (bVar == null) {
            return;
        }
        e eVar = f1433r;
        if (eVar != null) {
            eVar.f1463f++;
            if (bVar.f1427f) {
                eVar.f1464g++;
            }
        }
        boolean z7 = true;
        if (this.f1447k + 1 >= this.f1448l || this.f1446j + 1 >= this.f1441e) {
            y();
        }
        boolean z8 = false;
        if (!bVar.f1427f) {
            bVar.D(this);
            if (bVar.u()) {
                return;
            }
            bVar.r();
            if (bVar.f(this)) {
                i iVarP = p();
                bVar.f1422a = iVarP;
                l(bVar);
                this.f1452p.a(bVar);
                B(this.f1452p, true);
                if (iVarP.f1500d == -1) {
                    if (bVar.f1422a == iVarP && (iVarW = bVar.w(iVarP)) != null) {
                        e eVar2 = f1433r;
                        if (eVar2 != null) {
                            eVar2.f1467j++;
                        }
                        bVar.y(iVarW);
                    }
                    if (!bVar.f1427f) {
                        bVar.f1422a.g(bVar);
                    }
                    this.f1447k--;
                }
            } else {
                z7 = false;
            }
            if (!bVar.s()) {
                return;
            } else {
                z8 = z7;
            }
        }
        if (z8) {
            return;
        }
        l(bVar);
    }

    public D.b e(i iVar, i iVar2, int i7, int i8) {
        if (i8 == 8 && iVar2.f1503g && iVar.f1500d == -1) {
            iVar.e(this, iVar2.f1502f + i7);
            return null;
        }
        D.b bVarR = r();
        bVarR.n(iVar, iVar2, i7);
        if (i8 != 8) {
            bVarR.d(this, i8);
        }
        d(bVarR);
        return bVarR;
    }

    public void f(i iVar, int i7) {
        int i8 = iVar.f1500d;
        if (i8 == -1) {
            iVar.e(this, i7);
            return;
        }
        if (i8 == -1) {
            D.b bVarR = r();
            bVarR.i(iVar, i7);
            d(bVarR);
            return;
        }
        D.b bVar = this.f1442f[i8];
        if (bVar.f1427f) {
            bVar.f1423b = i7;
            return;
        }
        if (bVar.f1426e.d() == 0) {
            bVar.f1427f = true;
            bVar.f1423b = i7;
        } else {
            D.b bVarR2 = r();
            bVarR2.m(iVar, i7);
            d(bVarR2);
        }
    }

    public void g(i iVar, i iVar2, int i7, boolean z7) {
        D.b bVarR = r();
        i iVarT = t();
        iVarT.f1501e = 0;
        bVarR.o(iVar, iVar2, iVarT, i7);
        d(bVarR);
    }

    public void h(i iVar, i iVar2, int i7, int i8) {
        D.b bVarR = r();
        i iVarT = t();
        iVarT.f1501e = 0;
        bVarR.o(iVar, iVar2, iVarT, i7);
        if (i8 != 8) {
            m(bVarR, (int) (bVarR.f1426e.b(iVarT) * (-1.0f)), i8);
        }
        d(bVarR);
    }

    public void i(i iVar, i iVar2, int i7, boolean z7) {
        D.b bVarR = r();
        i iVarT = t();
        iVarT.f1501e = 0;
        bVarR.p(iVar, iVar2, iVarT, i7);
        d(bVarR);
    }

    public void j(i iVar, i iVar2, int i7, int i8) {
        D.b bVarR = r();
        i iVarT = t();
        iVarT.f1501e = 0;
        bVarR.p(iVar, iVar2, iVarT, i7);
        if (i8 != 8) {
            m(bVarR, (int) (bVarR.f1426e.b(iVarT) * (-1.0f)), i8);
        }
        d(bVarR);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f7, int i7) {
        D.b bVarR = r();
        bVarR.k(iVar, iVar2, iVar3, iVar4, f7);
        if (i7 != 8) {
            bVarR.d(this, i7);
        }
        d(bVarR);
    }

    public final void l(D.b bVar) {
        if (f1434s) {
            D.b bVar2 = this.f1442f[this.f1447k];
            if (bVar2 != null) {
                this.f1449m.f1428a.a(bVar2);
            }
        } else {
            D.b bVar3 = this.f1442f[this.f1447k];
            if (bVar3 != null) {
                this.f1449m.f1429b.a(bVar3);
            }
        }
        D.b[] bVarArr = this.f1442f;
        int i7 = this.f1447k;
        bVarArr[i7] = bVar;
        i iVar = bVar.f1422a;
        iVar.f1500d = i7;
        this.f1447k = i7 + 1;
        iVar.g(bVar);
    }

    public void m(D.b bVar, int i7, int i8) {
        bVar.e(o(i8, null), i7);
    }

    public final void n() {
        for (int i7 = 0; i7 < this.f1447k; i7++) {
            D.b bVar = this.f1442f[i7];
            bVar.f1422a.f1502f = bVar.f1423b;
        }
    }

    public i o(int i7, String str) {
        e eVar = f1433r;
        if (eVar != null) {
            eVar.f1469l++;
        }
        if (this.f1446j + 1 >= this.f1441e) {
            y();
        }
        i iVarA = a(i.a.ERROR, str);
        int i8 = this.f1437a + 1;
        this.f1437a = i8;
        this.f1446j++;
        iVarA.f1499c = i8;
        iVarA.f1501e = i7;
        this.f1449m.f1431d[i8] = iVarA;
        this.f1439c.c(iVarA);
        return iVarA;
    }

    public i p() {
        e eVar = f1433r;
        if (eVar != null) {
            eVar.f1471n++;
        }
        if (this.f1446j + 1 >= this.f1441e) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i7 = this.f1437a + 1;
        this.f1437a = i7;
        this.f1446j++;
        iVarA.f1499c = i7;
        this.f1449m.f1431d[i7] = iVarA;
        return iVarA;
    }

    public i q(Object obj) {
        i iVarE = null;
        if (obj == null) {
            return null;
        }
        if (this.f1446j + 1 >= this.f1441e) {
            y();
        }
        if (obj instanceof E.d) {
            E.d dVar = (E.d) obj;
            iVarE = dVar.e();
            if (iVarE == null) {
                dVar.l(this.f1449m);
                iVarE = dVar.e();
            }
            int i7 = iVarE.f1499c;
            if (i7 != -1 && i7 <= this.f1437a && this.f1449m.f1431d[i7] != null) {
                return iVarE;
            }
            if (i7 != -1) {
                iVarE.d();
            }
            int i8 = this.f1437a + 1;
            this.f1437a = i8;
            this.f1446j++;
            iVarE.f1499c = i8;
            iVarE.f1506j = i.a.UNRESTRICTED;
            this.f1449m.f1431d[i8] = iVarE;
        }
        return iVarE;
    }

    public D.b r() {
        D.b bVar;
        if (f1434s) {
            bVar = (D.b) this.f1449m.f1428a.b();
            if (bVar == null) {
                bVar = new b(this.f1449m);
                f1436u++;
            } else {
                bVar.z();
            }
        } else {
            bVar = (D.b) this.f1449m.f1429b.b();
            if (bVar == null) {
                bVar = new D.b(this.f1449m);
                f1435t++;
            } else {
                bVar.z();
            }
        }
        i.b();
        return bVar;
    }

    public i t() {
        e eVar = f1433r;
        if (eVar != null) {
            eVar.f1470m++;
        }
        if (this.f1446j + 1 >= this.f1441e) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i7 = this.f1437a + 1;
        this.f1437a = i7;
        this.f1446j++;
        iVarA.f1499c = i7;
        this.f1449m.f1431d[i7] = iVarA;
        return iVarA;
    }

    public final int u(a aVar) {
        long j7;
        for (int i7 = 0; i7 < this.f1447k; i7++) {
            D.b bVar = this.f1442f[i7];
            if (bVar.f1422a.f1506j != i.a.UNRESTRICTED) {
                float f7 = 0.0f;
                if (bVar.f1423b < 0.0f) {
                    boolean z7 = false;
                    int i8 = 0;
                    while (!z7) {
                        e eVar = f1433r;
                        long j8 = 1;
                        if (eVar != null) {
                            eVar.f1468k++;
                        }
                        i8++;
                        float f8 = Float.MAX_VALUE;
                        int i9 = -1;
                        int i10 = -1;
                        int i11 = 0;
                        int i12 = 0;
                        while (true) {
                            int i13 = 1;
                            if (i11 >= this.f1447k) {
                                break;
                            }
                            D.b bVar2 = this.f1442f[i11];
                            if (bVar2.f1422a.f1506j != i.a.UNRESTRICTED && !bVar2.f1427f && bVar2.f1423b < f7) {
                                while (i13 < this.f1446j) {
                                    i iVar = this.f1449m.f1431d[i13];
                                    float fB = bVar2.f1426e.b(iVar);
                                    if (fB <= f7) {
                                        j7 = j8;
                                    } else {
                                        j7 = j8;
                                        for (int i14 = 0; i14 < 9; i14++) {
                                            float f9 = iVar.f1504h[i14] / fB;
                                            if ((f9 < f8 && i14 == i12) || i14 > i12) {
                                                i12 = i14;
                                                f8 = f9;
                                                i9 = i11;
                                                i10 = i13;
                                            }
                                        }
                                    }
                                    i13++;
                                    j8 = j7;
                                    f7 = 0.0f;
                                }
                            }
                            i11++;
                            j8 = j8;
                            f7 = 0.0f;
                        }
                        long j9 = j8;
                        if (i9 != -1) {
                            D.b bVar3 = this.f1442f[i9];
                            bVar3.f1422a.f1500d = -1;
                            e eVar2 = f1433r;
                            if (eVar2 != null) {
                                eVar2.f1467j += j9;
                            }
                            bVar3.y(this.f1449m.f1431d[i10]);
                            i iVar2 = bVar3.f1422a;
                            iVar2.f1500d = i9;
                            iVar2.g(bVar3);
                        } else {
                            z7 = true;
                        }
                        if (i8 > this.f1446j / 2) {
                            z7 = true;
                        }
                        f7 = 0.0f;
                    }
                    return i8;
                }
            }
        }
        return 0;
    }

    public c v() {
        return this.f1449m;
    }

    public int x(Object obj) {
        i iVarE = ((E.d) obj).e();
        if (iVarE != null) {
            return (int) (iVarE.f1502f + 0.5f);
        }
        return 0;
    }

    public final void y() {
        int i7 = this.f1440d * 2;
        this.f1440d = i7;
        this.f1442f = (D.b[]) Arrays.copyOf(this.f1442f, i7);
        c cVar = this.f1449m;
        cVar.f1431d = (i[]) Arrays.copyOf(cVar.f1431d, this.f1440d);
        int i8 = this.f1440d;
        this.f1445i = new boolean[i8];
        this.f1441e = i8;
        this.f1448l = i8;
        e eVar = f1433r;
        if (eVar != null) {
            eVar.f1461d++;
            eVar.f1472o = Math.max(eVar.f1472o, i8);
            e eVar2 = f1433r;
            eVar2.f1482y = eVar2.f1472o;
        }
    }

    public void z() {
        e eVar = f1433r;
        if (eVar != null) {
            eVar.f1462e++;
        }
        if (!this.f1443g && !this.f1444h) {
            A(this.f1439c);
            return;
        }
        if (eVar != null) {
            eVar.f1474q++;
        }
        for (int i7 = 0; i7 < this.f1447k; i7++) {
            if (!this.f1442f[i7].f1427f) {
                A(this.f1439c);
                return;
            }
        }
        e eVar2 = f1433r;
        if (eVar2 != null) {
            eVar2.f1473p++;
        }
        n();
    }
}
