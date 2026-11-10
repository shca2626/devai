package D;

import D.d;
import D.i;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class b implements d.a {

    /* renamed from: e, reason: collision with root package name */
    public a f1426e;

    /* renamed from: a, reason: collision with root package name */
    public i f1422a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f1423b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1424c = false;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f1425d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public boolean f1427f = false;

    public interface a {
        boolean a(i iVar);

        float b(i iVar);

        float c(i iVar, boolean z7);

        void clear();

        int d();

        i e(int i7);

        void f();

        float g(int i7);

        void h(i iVar, float f7);

        float i(b bVar, boolean z7);

        void j(i iVar, float f7, boolean z7);

        void k(float f7);
    }

    public b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String A() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.b.A():java.lang.String");
    }

    public void B(d dVar, i iVar, boolean z7) {
        if (iVar.f1503g) {
            this.f1423b += iVar.f1502f * this.f1426e.b(iVar);
            this.f1426e.c(iVar, z7);
            if (z7) {
                iVar.c(this);
            }
        }
    }

    public void C(b bVar, boolean z7) {
        this.f1423b += bVar.f1423b * this.f1426e.i(bVar, z7);
        if (z7) {
            bVar.f1422a.c(this);
        }
    }

    public void D(d dVar) {
        if (dVar.f1442f.length == 0) {
            return;
        }
        boolean z7 = false;
        while (!z7) {
            int iD = this.f1426e.d();
            for (int i7 = 0; i7 < iD; i7++) {
                i iVarE = this.f1426e.e(i7);
                if (iVarE.f1500d != -1 || iVarE.f1503g) {
                    this.f1425d.add(iVarE);
                }
            }
            if (this.f1425d.size() > 0) {
                ArrayList arrayList = this.f1425d;
                int size = arrayList.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj = arrayList.get(i8);
                    i8++;
                    i iVar = (i) obj;
                    if (iVar.f1503g) {
                        B(dVar, iVar, true);
                    } else {
                        C(dVar.f1442f[iVar.f1500d], true);
                    }
                }
                this.f1425d.clear();
            } else {
                z7 = true;
            }
        }
    }

    @Override // D.d.a
    public void a(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f1422a = null;
            this.f1426e.clear();
            for (int i7 = 0; i7 < bVar.f1426e.d(); i7++) {
                this.f1426e.j(bVar.f1426e.e(i7), bVar.f1426e.g(i7), true);
            }
        }
    }

    @Override // D.d.a
    public i b(d dVar, boolean[] zArr) {
        return x(zArr, null);
    }

    @Override // D.d.a
    public void c(i iVar) {
        int i7 = iVar.f1501e;
        float f7 = 1.0f;
        if (i7 != 1) {
            if (i7 == 2) {
                f7 = 1000.0f;
            } else if (i7 == 3) {
                f7 = 1000000.0f;
            } else if (i7 == 4) {
                f7 = 1.0E9f;
            } else if (i7 == 5) {
                f7 = 1.0E12f;
            }
        }
        this.f1426e.h(iVar, f7);
    }

    @Override // D.d.a
    public void clear() {
        this.f1426e.clear();
        this.f1422a = null;
        this.f1423b = 0.0f;
    }

    public b d(d dVar, int i7) {
        this.f1426e.h(dVar.o(i7, "ep"), 1.0f);
        this.f1426e.h(dVar.o(i7, "em"), -1.0f);
        return this;
    }

    public b e(i iVar, int i7) {
        this.f1426e.h(iVar, i7);
        return this;
    }

    public boolean f(d dVar) {
        boolean z7;
        i iVarG = g(dVar);
        if (iVarG == null) {
            z7 = true;
        } else {
            y(iVarG);
            z7 = false;
        }
        if (this.f1426e.d() == 0) {
            this.f1427f = true;
        }
        return z7;
    }

    public i g(d dVar) {
        int iD = this.f1426e.d();
        i iVar = null;
        float f7 = 0.0f;
        float f8 = 0.0f;
        boolean z7 = false;
        boolean z8 = false;
        i iVar2 = null;
        for (int i7 = 0; i7 < iD; i7++) {
            float fG = this.f1426e.g(i7);
            i iVarE = this.f1426e.e(i7);
            if (iVarE.f1506j == i.a.UNRESTRICTED) {
                if (iVar == null || f7 > fG) {
                    boolean zV = v(iVarE, dVar);
                    z7 = zV;
                    f7 = fG;
                    iVar = iVarE;
                } else if (!z7 && v(iVarE, dVar)) {
                    f7 = fG;
                    iVar = iVarE;
                    z7 = true;
                }
            } else if (iVar == null && fG < 0.0f) {
                if (iVar2 == null || f8 > fG) {
                    boolean zV2 = v(iVarE, dVar);
                    z8 = zV2;
                    f8 = fG;
                    iVar2 = iVarE;
                } else if (!z8 && v(iVarE, dVar)) {
                    f8 = fG;
                    iVar2 = iVarE;
                    z8 = true;
                }
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    @Override // D.d.a
    public i getKey() {
        return this.f1422a;
    }

    public b h(i iVar, i iVar2, int i7, float f7, i iVar3, i iVar4, int i8) {
        if (iVar2 == iVar3) {
            this.f1426e.h(iVar, 1.0f);
            this.f1426e.h(iVar4, 1.0f);
            this.f1426e.h(iVar2, -2.0f);
            return this;
        }
        if (f7 == 0.5f) {
            this.f1426e.h(iVar, 1.0f);
            this.f1426e.h(iVar2, -1.0f);
            this.f1426e.h(iVar3, -1.0f);
            this.f1426e.h(iVar4, 1.0f);
            if (i7 > 0 || i8 > 0) {
                this.f1423b = (-i7) + i8;
                return this;
            }
        } else {
            if (f7 <= 0.0f) {
                this.f1426e.h(iVar, -1.0f);
                this.f1426e.h(iVar2, 1.0f);
                this.f1423b = i7;
                return this;
            }
            if (f7 >= 1.0f) {
                this.f1426e.h(iVar4, -1.0f);
                this.f1426e.h(iVar3, 1.0f);
                this.f1423b = -i8;
                return this;
            }
            float f8 = 1.0f - f7;
            this.f1426e.h(iVar, f8 * 1.0f);
            this.f1426e.h(iVar2, f8 * (-1.0f));
            this.f1426e.h(iVar3, (-1.0f) * f7);
            this.f1426e.h(iVar4, 1.0f * f7);
            if (i7 > 0 || i8 > 0) {
                this.f1423b = ((-i7) * f8) + (i8 * f7);
                return this;
            }
        }
        return this;
    }

    public b i(i iVar, int i7) {
        this.f1422a = iVar;
        float f7 = i7;
        iVar.f1502f = f7;
        this.f1423b = f7;
        this.f1427f = true;
        return this;
    }

    public b j(i iVar, i iVar2, float f7) {
        this.f1426e.h(iVar, -1.0f);
        this.f1426e.h(iVar2, f7);
        return this;
    }

    public b k(i iVar, i iVar2, i iVar3, i iVar4, float f7) {
        this.f1426e.h(iVar, -1.0f);
        this.f1426e.h(iVar2, 1.0f);
        this.f1426e.h(iVar3, f7);
        this.f1426e.h(iVar4, -f7);
        return this;
    }

    public b l(float f7, float f8, float f9, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f1423b = 0.0f;
        if (f8 == 0.0f || f7 == f9) {
            this.f1426e.h(iVar, 1.0f);
            this.f1426e.h(iVar2, -1.0f);
            this.f1426e.h(iVar4, 1.0f);
            this.f1426e.h(iVar3, -1.0f);
            return this;
        }
        if (f7 == 0.0f) {
            this.f1426e.h(iVar, 1.0f);
            this.f1426e.h(iVar2, -1.0f);
            return this;
        }
        if (f9 == 0.0f) {
            this.f1426e.h(iVar3, 1.0f);
            this.f1426e.h(iVar4, -1.0f);
            return this;
        }
        float f10 = (f7 / f8) / (f9 / f8);
        this.f1426e.h(iVar, 1.0f);
        this.f1426e.h(iVar2, -1.0f);
        this.f1426e.h(iVar4, f10);
        this.f1426e.h(iVar3, -f10);
        return this;
    }

    public b m(i iVar, int i7) {
        if (i7 < 0) {
            this.f1423b = i7 * (-1);
            this.f1426e.h(iVar, 1.0f);
            return this;
        }
        this.f1423b = i7;
        this.f1426e.h(iVar, -1.0f);
        return this;
    }

    public b n(i iVar, i iVar2, int i7) {
        boolean z7 = false;
        if (i7 != 0) {
            if (i7 < 0) {
                i7 *= -1;
                z7 = true;
            }
            this.f1423b = i7;
        }
        if (z7) {
            this.f1426e.h(iVar, 1.0f);
            this.f1426e.h(iVar2, -1.0f);
            return this;
        }
        this.f1426e.h(iVar, -1.0f);
        this.f1426e.h(iVar2, 1.0f);
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i7) {
        boolean z7 = false;
        if (i7 != 0) {
            if (i7 < 0) {
                i7 *= -1;
                z7 = true;
            }
            this.f1423b = i7;
        }
        if (z7) {
            this.f1426e.h(iVar, 1.0f);
            this.f1426e.h(iVar2, -1.0f);
            this.f1426e.h(iVar3, -1.0f);
            return this;
        }
        this.f1426e.h(iVar, -1.0f);
        this.f1426e.h(iVar2, 1.0f);
        this.f1426e.h(iVar3, 1.0f);
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, int i7) {
        boolean z7 = false;
        if (i7 != 0) {
            if (i7 < 0) {
                i7 *= -1;
                z7 = true;
            }
            this.f1423b = i7;
        }
        if (z7) {
            this.f1426e.h(iVar, 1.0f);
            this.f1426e.h(iVar2, -1.0f);
            this.f1426e.h(iVar3, 1.0f);
            return this;
        }
        this.f1426e.h(iVar, -1.0f);
        this.f1426e.h(iVar2, 1.0f);
        this.f1426e.h(iVar3, -1.0f);
        return this;
    }

    public b q(i iVar, i iVar2, i iVar3, i iVar4, float f7) {
        this.f1426e.h(iVar3, 0.5f);
        this.f1426e.h(iVar4, 0.5f);
        this.f1426e.h(iVar, -0.5f);
        this.f1426e.h(iVar2, -0.5f);
        this.f1423b = -f7;
        return this;
    }

    public void r() {
        float f7 = this.f1423b;
        if (f7 < 0.0f) {
            this.f1423b = f7 * (-1.0f);
            this.f1426e.f();
        }
    }

    public boolean s() {
        i iVar = this.f1422a;
        if (iVar != null) {
            return iVar.f1506j == i.a.UNRESTRICTED || this.f1423b >= 0.0f;
        }
        return false;
    }

    public boolean t(i iVar) {
        return this.f1426e.a(iVar);
    }

    public String toString() {
        return A();
    }

    public boolean u() {
        return this.f1422a == null && this.f1423b == 0.0f && this.f1426e.d() == 0;
    }

    public final boolean v(i iVar, d dVar) {
        return iVar.f1509m <= 1;
    }

    public i w(i iVar) {
        return x(null, iVar);
    }

    public final i x(boolean[] zArr, i iVar) {
        i.a aVar;
        int iD = this.f1426e.d();
        i iVar2 = null;
        float f7 = 0.0f;
        for (int i7 = 0; i7 < iD; i7++) {
            float fG = this.f1426e.g(i7);
            if (fG < 0.0f) {
                i iVarE = this.f1426e.e(i7);
                if ((zArr == null || !zArr[iVarE.f1499c]) && iVarE != iVar && (((aVar = iVarE.f1506j) == i.a.SLACK || aVar == i.a.ERROR) && fG < f7)) {
                    f7 = fG;
                    iVar2 = iVarE;
                }
            }
        }
        return iVar2;
    }

    public void y(i iVar) {
        i iVar2 = this.f1422a;
        if (iVar2 != null) {
            this.f1426e.h(iVar2, -1.0f);
            this.f1422a = null;
        }
        float fC = this.f1426e.c(iVar, true) * (-1.0f);
        this.f1422a = iVar;
        if (fC == 1.0f) {
            return;
        }
        this.f1423b /= fC;
        this.f1426e.k(fC);
    }

    public void z() {
        this.f1422a = null;
        this.f1426e.clear();
        this.f1423b = 0.0f;
        this.f1427f = false;
    }

    public b(c cVar) {
        this.f1426e = new D.a(this, cVar);
    }
}
