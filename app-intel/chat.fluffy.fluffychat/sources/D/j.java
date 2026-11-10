package D;

import D.b;
import java.util.Arrays;

/* loaded from: classes.dex */
public class j implements b.a {

    /* renamed from: n, reason: collision with root package name */
    public static float f1517n = 0.001f;

    /* renamed from: a, reason: collision with root package name */
    public final int f1518a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f1519b = 16;

    /* renamed from: c, reason: collision with root package name */
    public int f1520c = 16;

    /* renamed from: d, reason: collision with root package name */
    public int[] f1521d = new int[16];

    /* renamed from: e, reason: collision with root package name */
    public int[] f1522e = new int[16];

    /* renamed from: f, reason: collision with root package name */
    public int[] f1523f = new int[16];

    /* renamed from: g, reason: collision with root package name */
    public float[] f1524g = new float[16];

    /* renamed from: h, reason: collision with root package name */
    public int[] f1525h = new int[16];

    /* renamed from: i, reason: collision with root package name */
    public int[] f1526i = new int[16];

    /* renamed from: j, reason: collision with root package name */
    public int f1527j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f1528k = -1;

    /* renamed from: l, reason: collision with root package name */
    public final b f1529l;

    /* renamed from: m, reason: collision with root package name */
    public final c f1530m;

    public j(b bVar, c cVar) {
        this.f1529l = bVar;
        this.f1530m = cVar;
        clear();
    }

    @Override // D.b.a
    public boolean a(i iVar) {
        return p(iVar) != -1;
    }

    @Override // D.b.a
    public float b(i iVar) {
        int iP = p(iVar);
        if (iP != -1) {
            return this.f1524g[iP];
        }
        return 0.0f;
    }

    @Override // D.b.a
    public float c(i iVar, boolean z7) {
        int iP = p(iVar);
        if (iP == -1) {
            return 0.0f;
        }
        r(iVar);
        float f7 = this.f1524g[iP];
        if (this.f1528k == iP) {
            this.f1528k = this.f1526i[iP];
        }
        this.f1523f[iP] = -1;
        int[] iArr = this.f1525h;
        int i7 = iArr[iP];
        if (i7 != -1) {
            int[] iArr2 = this.f1526i;
            iArr2[i7] = iArr2[iP];
        }
        int i8 = this.f1526i[iP];
        if (i8 != -1) {
            iArr[i8] = iArr[iP];
        }
        this.f1527j--;
        iVar.f1509m--;
        if (z7) {
            iVar.c(this.f1529l);
        }
        return f7;
    }

    @Override // D.b.a
    public void clear() {
        int i7 = this.f1527j;
        for (int i8 = 0; i8 < i7; i8++) {
            i iVarE = e(i8);
            if (iVarE != null) {
                iVarE.c(this.f1529l);
            }
        }
        for (int i9 = 0; i9 < this.f1519b; i9++) {
            this.f1523f[i9] = -1;
            this.f1522e[i9] = -1;
        }
        for (int i10 = 0; i10 < this.f1520c; i10++) {
            this.f1521d[i10] = -1;
        }
        this.f1527j = 0;
        this.f1528k = -1;
    }

    @Override // D.b.a
    public int d() {
        return this.f1527j;
    }

    @Override // D.b.a
    public i e(int i7) {
        int i8 = this.f1527j;
        if (i8 == 0) {
            return null;
        }
        int i9 = this.f1528k;
        for (int i10 = 0; i10 < i8; i10++) {
            if (i10 == i7 && i9 != -1) {
                return this.f1530m.f1431d[this.f1523f[i9]];
            }
            i9 = this.f1526i[i9];
            if (i9 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // D.b.a
    public void f() {
        int i7 = this.f1527j;
        int i8 = this.f1528k;
        for (int i9 = 0; i9 < i7; i9++) {
            float[] fArr = this.f1524g;
            fArr[i8] = fArr[i8] * (-1.0f);
            i8 = this.f1526i[i8];
            if (i8 == -1) {
                return;
            }
        }
    }

    @Override // D.b.a
    public float g(int i7) {
        int i8 = this.f1527j;
        int i9 = this.f1528k;
        for (int i10 = 0; i10 < i8; i10++) {
            if (i10 == i7) {
                return this.f1524g[i9];
            }
            i9 = this.f1526i[i9];
            if (i9 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // D.b.a
    public void h(i iVar, float f7) {
        float f8 = f1517n;
        if (f7 > (-f8) && f7 < f8) {
            c(iVar, true);
            return;
        }
        if (this.f1527j == 0) {
            m(0, iVar, f7);
            l(iVar, 0);
            this.f1528k = 0;
            return;
        }
        int iP = p(iVar);
        if (iP != -1) {
            this.f1524g[iP] = f7;
            return;
        }
        if (this.f1527j + 1 >= this.f1519b) {
            o();
        }
        int i7 = this.f1527j;
        int i8 = this.f1528k;
        int i9 = -1;
        for (int i10 = 0; i10 < i7; i10++) {
            int i11 = this.f1523f[i8];
            int i12 = iVar.f1499c;
            if (i11 == i12) {
                this.f1524g[i8] = f7;
                return;
            }
            if (i11 < i12) {
                i9 = i8;
            }
            i8 = this.f1526i[i8];
            if (i8 == -1) {
                break;
            }
        }
        q(i9, iVar, f7);
    }

    @Override // D.b.a
    public float i(b bVar, boolean z7) {
        float fB = b(bVar.f1422a);
        c(bVar.f1422a, z7);
        j jVar = (j) bVar.f1426e;
        int iD = jVar.d();
        int i7 = 0;
        int i8 = 0;
        while (i7 < iD) {
            int i9 = jVar.f1523f[i8];
            if (i9 != -1) {
                j(this.f1530m.f1431d[i9], jVar.f1524g[i8] * fB, z7);
                i7++;
            }
            i8++;
        }
        return fB;
    }

    @Override // D.b.a
    public void j(i iVar, float f7, boolean z7) {
        float f8 = f1517n;
        if (f7 <= (-f8) || f7 >= f8) {
            int iP = p(iVar);
            if (iP == -1) {
                h(iVar, f7);
                return;
            }
            float[] fArr = this.f1524g;
            float f9 = fArr[iP] + f7;
            fArr[iP] = f9;
            float f10 = f1517n;
            if (f9 <= (-f10) || f9 >= f10) {
                return;
            }
            fArr[iP] = 0.0f;
            c(iVar, z7);
        }
    }

    @Override // D.b.a
    public void k(float f7) {
        int i7 = this.f1527j;
        int i8 = this.f1528k;
        for (int i9 = 0; i9 < i7; i9++) {
            float[] fArr = this.f1524g;
            fArr[i8] = fArr[i8] / f7;
            i8 = this.f1526i[i8];
            if (i8 == -1) {
                return;
            }
        }
    }

    public final void l(i iVar, int i7) {
        int[] iArr;
        int i8 = iVar.f1499c % this.f1520c;
        int[] iArr2 = this.f1521d;
        int i9 = iArr2[i8];
        if (i9 == -1) {
            iArr2[i8] = i7;
        } else {
            while (true) {
                iArr = this.f1522e;
                int i10 = iArr[i9];
                if (i10 == -1) {
                    break;
                } else {
                    i9 = i10;
                }
            }
            iArr[i9] = i7;
        }
        this.f1522e[i7] = -1;
    }

    public final void m(int i7, i iVar, float f7) {
        this.f1523f[i7] = iVar.f1499c;
        this.f1524g[i7] = f7;
        this.f1525h[i7] = -1;
        this.f1526i[i7] = -1;
        iVar.a(this.f1529l);
        iVar.f1509m++;
        this.f1527j++;
    }

    public final int n() {
        for (int i7 = 0; i7 < this.f1519b; i7++) {
            if (this.f1523f[i7] == -1) {
                return i7;
            }
        }
        return -1;
    }

    public final void o() {
        int i7 = this.f1519b * 2;
        this.f1523f = Arrays.copyOf(this.f1523f, i7);
        this.f1524g = Arrays.copyOf(this.f1524g, i7);
        this.f1525h = Arrays.copyOf(this.f1525h, i7);
        this.f1526i = Arrays.copyOf(this.f1526i, i7);
        this.f1522e = Arrays.copyOf(this.f1522e, i7);
        for (int i8 = this.f1519b; i8 < i7; i8++) {
            this.f1523f[i8] = -1;
            this.f1522e[i8] = -1;
        }
        this.f1519b = i7;
    }

    public int p(i iVar) {
        if (this.f1527j == 0) {
            return -1;
        }
        int i7 = iVar.f1499c;
        int i8 = this.f1521d[i7 % this.f1520c];
        if (i8 == -1) {
            return -1;
        }
        if (this.f1523f[i8] == i7) {
            return i8;
        }
        do {
            i8 = this.f1522e[i8];
            if (i8 == -1) {
                break;
            }
        } while (this.f1523f[i8] != i7);
        if (i8 != -1 && this.f1523f[i8] == i7) {
            return i8;
        }
        return -1;
    }

    public final void q(int i7, i iVar, float f7) {
        int iN = n();
        m(iN, iVar, f7);
        if (i7 != -1) {
            this.f1525h[iN] = i7;
            int[] iArr = this.f1526i;
            iArr[iN] = iArr[i7];
            iArr[i7] = iN;
        } else {
            this.f1525h[iN] = -1;
            if (this.f1527j > 0) {
                this.f1526i[iN] = this.f1528k;
                this.f1528k = iN;
            } else {
                this.f1526i[iN] = -1;
            }
        }
        int i8 = this.f1526i[iN];
        if (i8 != -1) {
            this.f1525h[i8] = iN;
        }
        l(iVar, iN);
    }

    public final void r(i iVar) {
        int[] iArr;
        int i7;
        int i8 = iVar.f1499c;
        int i9 = i8 % this.f1520c;
        int[] iArr2 = this.f1521d;
        int i10 = iArr2[i9];
        if (i10 == -1) {
            return;
        }
        if (this.f1523f[i10] == i8) {
            int[] iArr3 = this.f1522e;
            iArr2[i9] = iArr3[i10];
            iArr3[i10] = -1;
            return;
        }
        while (true) {
            iArr = this.f1522e;
            i7 = iArr[i10];
            if (i7 == -1 || this.f1523f[i7] == i8) {
                break;
            } else {
                i10 = i7;
            }
        }
        if (i7 == -1 || this.f1523f[i7] != i8) {
            return;
        }
        iArr[i10] = iArr[i7];
        iArr[i7] = -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i7 = this.f1527j;
        for (int i8 = 0; i8 < i7; i8++) {
            i iVarE = e(i8);
            if (iVarE != null) {
                String str2 = str + iVarE + " = " + g(i8) + " ";
                int iP = p(iVarE);
                String str3 = str2 + "[p: ";
                String str4 = (this.f1525h[iP] != -1 ? str3 + this.f1530m.f1431d[this.f1523f[this.f1525h[iP]]] : str3 + "none") + ", n: ";
                str = (this.f1526i[iP] != -1 ? str4 + this.f1530m.f1431d[this.f1523f[this.f1526i[iP]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
