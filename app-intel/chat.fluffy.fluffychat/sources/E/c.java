package E;

import E.e;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public e f1847a;

    /* renamed from: b, reason: collision with root package name */
    public e f1848b;

    /* renamed from: c, reason: collision with root package name */
    public e f1849c;

    /* renamed from: d, reason: collision with root package name */
    public e f1850d;

    /* renamed from: e, reason: collision with root package name */
    public e f1851e;

    /* renamed from: f, reason: collision with root package name */
    public e f1852f;

    /* renamed from: g, reason: collision with root package name */
    public e f1853g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f1854h;

    /* renamed from: i, reason: collision with root package name */
    public int f1855i;

    /* renamed from: j, reason: collision with root package name */
    public int f1856j;

    /* renamed from: k, reason: collision with root package name */
    public float f1857k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    public int f1858l;

    /* renamed from: m, reason: collision with root package name */
    public int f1859m;

    /* renamed from: n, reason: collision with root package name */
    public int f1860n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1861o;

    /* renamed from: p, reason: collision with root package name */
    public int f1862p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1863q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1864r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1865s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1866t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1867u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1868v;

    public c(e eVar, int i7, boolean z7) {
        this.f1847a = eVar;
        this.f1862p = i7;
        this.f1863q = z7;
    }

    public static boolean c(e eVar, int i7) {
        if (eVar.M() == 8 || eVar.f1900M[i7] != e.b.MATCH_CONSTRAINT) {
            return false;
        }
        int i8 = eVar.f1940n[i7];
        return i8 == 0 || i8 == 3;
    }

    public void a() {
        if (!this.f1868v) {
            b();
        }
        this.f1868v = true;
    }

    public final void b() {
        int i7 = this.f1862p * 2;
        e eVar = this.f1847a;
        this.f1861o = true;
        e eVar2 = eVar;
        boolean z7 = false;
        while (!z7) {
            this.f1855i++;
            e[] eVarArr = eVar.f1951s0;
            int i8 = this.f1862p;
            e eVar3 = null;
            eVarArr[i8] = null;
            eVar.f1949r0[i8] = null;
            if (eVar.M() != 8) {
                this.f1858l++;
                e.b bVarQ = eVar.q(this.f1862p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarQ != bVar) {
                    this.f1859m += eVar.y(this.f1862p);
                }
                int iB = this.f1859m + eVar.f1897J[i7].b();
                this.f1859m = iB;
                int i9 = i7 + 1;
                this.f1859m = iB + eVar.f1897J[i9].b();
                int iB2 = this.f1860n + eVar.f1897J[i7].b();
                this.f1860n = iB2;
                this.f1860n = iB2 + eVar.f1897J[i9].b();
                if (this.f1848b == null) {
                    this.f1848b = eVar;
                }
                this.f1850d = eVar;
                e.b[] bVarArr = eVar.f1900M;
                int i10 = this.f1862p;
                if (bVarArr[i10] == bVar) {
                    int i11 = eVar.f1940n[i10];
                    if (i11 == 0 || i11 == 3 || i11 == 2) {
                        this.f1856j++;
                        float f7 = eVar.f1947q0[i10];
                        if (f7 > 0.0f) {
                            this.f1857k += f7;
                        }
                        if (c(eVar, i10)) {
                            if (f7 < 0.0f) {
                                this.f1864r = true;
                            } else {
                                this.f1865s = true;
                            }
                            if (this.f1854h == null) {
                                this.f1854h = new ArrayList();
                            }
                            this.f1854h.add(eVar);
                        }
                        if (this.f1852f == null) {
                            this.f1852f = eVar;
                        }
                        e eVar4 = this.f1853g;
                        if (eVar4 != null) {
                            eVar4.f1949r0[this.f1862p] = eVar;
                        }
                        this.f1853g = eVar;
                    }
                    if (this.f1862p == 0) {
                        if (eVar.f1936l != 0 || eVar.f1942o != 0 || eVar.f1944p != 0) {
                            this.f1861o = false;
                        }
                    } else if (eVar.f1938m != 0 || eVar.f1948r != 0 || eVar.f1950s != 0) {
                        this.f1861o = false;
                    }
                    if (eVar.f1904Q != 0.0f) {
                        this.f1861o = false;
                        this.f1867u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.f1951s0[this.f1862p] = eVar;
            }
            d dVar = eVar.f1897J[i7 + 1].f1872d;
            if (dVar != null) {
                e eVar5 = dVar.f1870b;
                d dVar2 = eVar5.f1897J[i7].f1872d;
                if (dVar2 != null && dVar2.f1870b == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z7 = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f1848b;
        if (eVar6 != null) {
            this.f1859m -= eVar6.f1897J[i7].b();
        }
        e eVar7 = this.f1850d;
        if (eVar7 != null) {
            this.f1859m -= eVar7.f1897J[i7 + 1].b();
        }
        this.f1849c = eVar;
        if (this.f1862p == 0 && this.f1863q) {
            this.f1851e = eVar;
        } else {
            this.f1851e = this.f1847a;
        }
        this.f1866t = this.f1865s && this.f1864r;
    }
}
