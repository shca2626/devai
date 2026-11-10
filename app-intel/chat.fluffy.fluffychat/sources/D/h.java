package D;

import D.b;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
public class h extends D.b {

    /* renamed from: g, reason: collision with root package name */
    public int f1486g;

    /* renamed from: h, reason: collision with root package name */
    public i[] f1487h;

    /* renamed from: i, reason: collision with root package name */
    public i[] f1488i;

    /* renamed from: j, reason: collision with root package name */
    public int f1489j;

    /* renamed from: k, reason: collision with root package name */
    public b f1490k;

    /* renamed from: l, reason: collision with root package name */
    public c f1491l;

    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return iVar.f1499c - iVar2.f1499c;
        }
    }

    public class b implements Comparable {

        /* renamed from: l, reason: collision with root package name */
        public i f1493l;

        /* renamed from: m, reason: collision with root package name */
        public h f1494m;

        public b(h hVar) {
            this.f1494m = hVar;
        }

        public boolean a(i iVar, float f7) {
            boolean z7 = true;
            if (!this.f1493l.f1497a) {
                for (int i7 = 0; i7 < 9; i7++) {
                    float f8 = iVar.f1505i[i7];
                    if (f8 != 0.0f) {
                        float f9 = f8 * f7;
                        if (Math.abs(f9) < 1.0E-4f) {
                            f9 = 0.0f;
                        }
                        this.f1493l.f1505i[i7] = f9;
                    } else {
                        this.f1493l.f1505i[i7] = 0.0f;
                    }
                }
                return true;
            }
            for (int i8 = 0; i8 < 9; i8++) {
                float[] fArr = this.f1493l.f1505i;
                float f10 = fArr[i8] + (iVar.f1505i[i8] * f7);
                fArr[i8] = f10;
                if (Math.abs(f10) < 1.0E-4f) {
                    this.f1493l.f1505i[i8] = 0.0f;
                } else {
                    z7 = false;
                }
            }
            if (z7) {
                h.this.G(this.f1493l);
            }
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f1493l.f1499c - ((i) obj).f1499c;
        }

        public void d(i iVar) {
            this.f1493l = iVar;
        }

        public final boolean e() {
            for (int i7 = 8; i7 >= 0; i7--) {
                float f7 = this.f1493l.f1505i[i7];
                if (f7 > 0.0f) {
                    return false;
                }
                if (f7 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean f(i iVar) {
            int i7 = 8;
            while (true) {
                if (i7 < 0) {
                    break;
                }
                float f7 = iVar.f1505i[i7];
                float f8 = this.f1493l.f1505i[i7];
                if (f8 == f7) {
                    i7--;
                } else if (f8 < f7) {
                    return true;
                }
            }
            return false;
        }

        public void h() {
            Arrays.fill(this.f1493l.f1505i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f1493l != null) {
                for (int i7 = 0; i7 < 9; i7++) {
                    str = str + this.f1493l.f1505i[i7] + " ";
                }
            }
            return str + "] " + this.f1493l;
        }
    }

    public h(c cVar) {
        super(cVar);
        this.f1486g = 128;
        this.f1487h = new i[128];
        this.f1488i = new i[128];
        this.f1489j = 0;
        this.f1490k = new b(this);
        this.f1491l = cVar;
    }

    @Override // D.b
    public void C(D.b bVar, boolean z7) {
        i iVar = bVar.f1422a;
        if (iVar == null) {
            return;
        }
        b.a aVar = bVar.f1426e;
        int iD = aVar.d();
        for (int i7 = 0; i7 < iD; i7++) {
            i iVarE = aVar.e(i7);
            float fG = aVar.g(i7);
            this.f1490k.d(iVarE);
            if (this.f1490k.a(iVar, fG)) {
                F(iVarE);
            }
            this.f1423b += bVar.f1423b * fG;
        }
        G(iVar);
    }

    public final void F(i iVar) {
        int i7;
        int i8 = this.f1489j + 1;
        i[] iVarArr = this.f1487h;
        if (i8 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f1487h = iVarArr2;
            this.f1488i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f1487h;
        int i9 = this.f1489j;
        iVarArr3[i9] = iVar;
        int i10 = i9 + 1;
        this.f1489j = i10;
        if (i10 > 1 && iVarArr3[i9].f1499c > iVar.f1499c) {
            int i11 = 0;
            while (true) {
                i7 = this.f1489j;
                if (i11 >= i7) {
                    break;
                }
                this.f1488i[i11] = this.f1487h[i11];
                i11++;
            }
            Arrays.sort(this.f1488i, 0, i7, new a());
            for (int i12 = 0; i12 < this.f1489j; i12++) {
                this.f1487h[i12] = this.f1488i[i12];
            }
        }
        iVar.f1497a = true;
        iVar.a(this);
    }

    public final void G(i iVar) {
        int i7 = 0;
        while (i7 < this.f1489j) {
            if (this.f1487h[i7] == iVar) {
                while (true) {
                    int i8 = this.f1489j;
                    if (i7 >= i8 - 1) {
                        this.f1489j = i8 - 1;
                        iVar.f1497a = false;
                        return;
                    } else {
                        i[] iVarArr = this.f1487h;
                        int i9 = i7 + 1;
                        iVarArr[i7] = iVarArr[i9];
                        i7 = i9;
                    }
                }
            } else {
                i7++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    @Override // D.b, D.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public D.i b(D.d r5, boolean[] r6) {
        /*
            r4 = this;
            r5 = -1
            r0 = 0
            r1 = r5
        L3:
            int r2 = r4.f1489j
            if (r0 >= r2) goto L32
            D.i[] r2 = r4.f1487h
            r2 = r2[r0]
            int r3 = r2.f1499c
            boolean r3 = r6[r3]
            if (r3 == 0) goto L12
            goto L2f
        L12:
            D.h$b r3 = r4.f1490k
            r3.d(r2)
            if (r1 != r5) goto L22
            D.h$b r2 = r4.f1490k
            boolean r2 = r2.e()
            if (r2 == 0) goto L2f
            goto L2e
        L22:
            D.h$b r2 = r4.f1490k
            D.i[] r3 = r4.f1487h
            r3 = r3[r1]
            boolean r2 = r2.f(r3)
            if (r2 == 0) goto L2f
        L2e:
            r1 = r0
        L2f:
            int r0 = r0 + 1
            goto L3
        L32:
            if (r1 != r5) goto L36
            r5 = 0
            return r5
        L36:
            D.i[] r5 = r4.f1487h
            r5 = r5[r1]
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: D.h.b(D.d, boolean[]):D.i");
    }

    @Override // D.b, D.d.a
    public void c(i iVar) {
        this.f1490k.d(iVar);
        this.f1490k.h();
        iVar.f1505i[iVar.f1501e] = 1.0f;
        F(iVar);
    }

    @Override // D.b, D.d.a
    public void clear() {
        this.f1489j = 0;
        this.f1423b = 0.0f;
    }

    @Override // D.b
    public String toString() {
        String str = " goal -> (" + this.f1423b + ") : ";
        for (int i7 = 0; i7 < this.f1489j; i7++) {
            this.f1490k.d(this.f1487h[i7]);
            str = str + this.f1490k + " ";
        }
        return str;
    }
}
