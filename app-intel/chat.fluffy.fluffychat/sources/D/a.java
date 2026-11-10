package D;

import D.b;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a implements b.a {

    /* renamed from: l, reason: collision with root package name */
    public static float f1410l = 0.001f;

    /* renamed from: b, reason: collision with root package name */
    public final b f1412b;

    /* renamed from: c, reason: collision with root package name */
    public final c f1413c;

    /* renamed from: a, reason: collision with root package name */
    public int f1411a = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f1414d = 8;

    /* renamed from: e, reason: collision with root package name */
    public i f1415e = null;

    /* renamed from: f, reason: collision with root package name */
    public int[] f1416f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    public int[] f1417g = new int[8];

    /* renamed from: h, reason: collision with root package name */
    public float[] f1418h = new float[8];

    /* renamed from: i, reason: collision with root package name */
    public int f1419i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f1420j = -1;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1421k = false;

    public a(b bVar, c cVar) {
        this.f1412b = bVar;
        this.f1413c = cVar;
    }

    @Override // D.b.a
    public boolean a(i iVar) {
        int i7 = this.f1419i;
        if (i7 == -1) {
            return false;
        }
        for (int i8 = 0; i7 != -1 && i8 < this.f1411a; i8++) {
            if (this.f1416f[i7] == iVar.f1499c) {
                return true;
            }
            i7 = this.f1417g[i7];
        }
        return false;
    }

    @Override // D.b.a
    public final float b(i iVar) {
        int i7 = this.f1419i;
        for (int i8 = 0; i7 != -1 && i8 < this.f1411a; i8++) {
            if (this.f1416f[i7] == iVar.f1499c) {
                return this.f1418h[i7];
            }
            i7 = this.f1417g[i7];
        }
        return 0.0f;
    }

    @Override // D.b.a
    public final float c(i iVar, boolean z7) {
        if (this.f1415e == iVar) {
            this.f1415e = null;
        }
        int i7 = this.f1419i;
        if (i7 == -1) {
            return 0.0f;
        }
        int i8 = 0;
        int i9 = -1;
        while (i7 != -1 && i8 < this.f1411a) {
            if (this.f1416f[i7] == iVar.f1499c) {
                if (i7 == this.f1419i) {
                    this.f1419i = this.f1417g[i7];
                } else {
                    int[] iArr = this.f1417g;
                    iArr[i9] = iArr[i7];
                }
                if (z7) {
                    iVar.c(this.f1412b);
                }
                iVar.f1509m--;
                this.f1411a--;
                this.f1416f[i7] = -1;
                if (this.f1421k) {
                    this.f1420j = i7;
                }
                return this.f1418h[i7];
            }
            i8++;
            i9 = i7;
            i7 = this.f1417g[i7];
        }
        return 0.0f;
    }

    @Override // D.b.a
    public final void clear() {
        int i7 = this.f1419i;
        for (int i8 = 0; i7 != -1 && i8 < this.f1411a; i8++) {
            i iVar = this.f1413c.f1431d[this.f1416f[i7]];
            if (iVar != null) {
                iVar.c(this.f1412b);
            }
            i7 = this.f1417g[i7];
        }
        this.f1419i = -1;
        this.f1420j = -1;
        this.f1421k = false;
        this.f1411a = 0;
    }

    @Override // D.b.a
    public int d() {
        return this.f1411a;
    }

    @Override // D.b.a
    public i e(int i7) {
        int i8 = this.f1419i;
        for (int i9 = 0; i8 != -1 && i9 < this.f1411a; i9++) {
            if (i9 == i7) {
                return this.f1413c.f1431d[this.f1416f[i8]];
            }
            i8 = this.f1417g[i8];
        }
        return null;
    }

    @Override // D.b.a
    public void f() {
        int i7 = this.f1419i;
        for (int i8 = 0; i7 != -1 && i8 < this.f1411a; i8++) {
            float[] fArr = this.f1418h;
            fArr[i7] = fArr[i7] * (-1.0f);
            i7 = this.f1417g[i7];
        }
    }

    @Override // D.b.a
    public float g(int i7) {
        int i8 = this.f1419i;
        for (int i9 = 0; i8 != -1 && i9 < this.f1411a; i9++) {
            if (i9 == i7) {
                return this.f1418h[i8];
            }
            i8 = this.f1417g[i8];
        }
        return 0.0f;
    }

    @Override // D.b.a
    public final void h(i iVar, float f7) {
        if (f7 == 0.0f) {
            c(iVar, true);
            return;
        }
        int i7 = this.f1419i;
        if (i7 == -1) {
            this.f1419i = 0;
            this.f1418h[0] = f7;
            this.f1416f[0] = iVar.f1499c;
            this.f1417g[0] = -1;
            iVar.f1509m++;
            iVar.a(this.f1412b);
            this.f1411a++;
            if (this.f1421k) {
                return;
            }
            int i8 = this.f1420j + 1;
            this.f1420j = i8;
            int[] iArr = this.f1416f;
            if (i8 >= iArr.length) {
                this.f1421k = true;
                this.f1420j = iArr.length - 1;
                return;
            }
            return;
        }
        int i9 = -1;
        for (int i10 = 0; i7 != -1 && i10 < this.f1411a; i10++) {
            int i11 = this.f1416f[i7];
            int i12 = iVar.f1499c;
            if (i11 == i12) {
                this.f1418h[i7] = f7;
                return;
            }
            if (i11 < i12) {
                i9 = i7;
            }
            i7 = this.f1417g[i7];
        }
        int length = this.f1420j;
        int i13 = length + 1;
        if (this.f1421k) {
            int[] iArr2 = this.f1416f;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i13;
        }
        int[] iArr3 = this.f1416f;
        if (length >= iArr3.length && this.f1411a < iArr3.length) {
            int i14 = 0;
            while (true) {
                int[] iArr4 = this.f1416f;
                if (i14 >= iArr4.length) {
                    break;
                }
                if (iArr4[i14] == -1) {
                    length = i14;
                    break;
                }
                i14++;
            }
        }
        int[] iArr5 = this.f1416f;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i15 = this.f1414d * 2;
            this.f1414d = i15;
            this.f1421k = false;
            this.f1420j = length - 1;
            this.f1418h = Arrays.copyOf(this.f1418h, i15);
            this.f1416f = Arrays.copyOf(this.f1416f, this.f1414d);
            this.f1417g = Arrays.copyOf(this.f1417g, this.f1414d);
        }
        this.f1416f[length] = iVar.f1499c;
        this.f1418h[length] = f7;
        if (i9 != -1) {
            int[] iArr6 = this.f1417g;
            iArr6[length] = iArr6[i9];
            iArr6[i9] = length;
        } else {
            this.f1417g[length] = this.f1419i;
            this.f1419i = length;
        }
        iVar.f1509m++;
        iVar.a(this.f1412b);
        int i16 = this.f1411a + 1;
        this.f1411a = i16;
        if (!this.f1421k) {
            this.f1420j++;
        }
        int[] iArr7 = this.f1416f;
        if (i16 >= iArr7.length) {
            this.f1421k = true;
        }
        if (this.f1420j >= iArr7.length) {
            this.f1421k = true;
            this.f1420j = iArr7.length - 1;
        }
    }

    @Override // D.b.a
    public float i(b bVar, boolean z7) {
        float fB = b(bVar.f1422a);
        c(bVar.f1422a, z7);
        b.a aVar = bVar.f1426e;
        int iD = aVar.d();
        for (int i7 = 0; i7 < iD; i7++) {
            i iVarE = aVar.e(i7);
            j(iVarE, aVar.b(iVarE) * fB, z7);
        }
        return fB;
    }

    @Override // D.b.a
    public void j(i iVar, float f7, boolean z7) {
        float f8 = f1410l;
        if (f7 <= (-f8) || f7 >= f8) {
            int i7 = this.f1419i;
            if (i7 == -1) {
                this.f1419i = 0;
                this.f1418h[0] = f7;
                this.f1416f[0] = iVar.f1499c;
                this.f1417g[0] = -1;
                iVar.f1509m++;
                iVar.a(this.f1412b);
                this.f1411a++;
                if (this.f1421k) {
                    return;
                }
                int i8 = this.f1420j + 1;
                this.f1420j = i8;
                int[] iArr = this.f1416f;
                if (i8 >= iArr.length) {
                    this.f1421k = true;
                    this.f1420j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i9 = -1;
            for (int i10 = 0; i7 != -1 && i10 < this.f1411a; i10++) {
                int i11 = this.f1416f[i7];
                int i12 = iVar.f1499c;
                if (i11 == i12) {
                    float[] fArr = this.f1418h;
                    float f9 = fArr[i7] + f7;
                    float f10 = f1410l;
                    if (f9 > (-f10) && f9 < f10) {
                        f9 = 0.0f;
                    }
                    fArr[i7] = f9;
                    if (f9 == 0.0f) {
                        if (i7 == this.f1419i) {
                            this.f1419i = this.f1417g[i7];
                        } else {
                            int[] iArr2 = this.f1417g;
                            iArr2[i9] = iArr2[i7];
                        }
                        if (z7) {
                            iVar.c(this.f1412b);
                        }
                        if (this.f1421k) {
                            this.f1420j = i7;
                        }
                        iVar.f1509m--;
                        this.f1411a--;
                        return;
                    }
                    return;
                }
                if (i11 < i12) {
                    i9 = i7;
                }
                i7 = this.f1417g[i7];
            }
            int length = this.f1420j;
            int i13 = length + 1;
            if (this.f1421k) {
                int[] iArr3 = this.f1416f;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i13;
            }
            int[] iArr4 = this.f1416f;
            if (length >= iArr4.length && this.f1411a < iArr4.length) {
                int i14 = 0;
                while (true) {
                    int[] iArr5 = this.f1416f;
                    if (i14 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i14] == -1) {
                        length = i14;
                        break;
                    }
                    i14++;
                }
            }
            int[] iArr6 = this.f1416f;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i15 = this.f1414d * 2;
                this.f1414d = i15;
                this.f1421k = false;
                this.f1420j = length - 1;
                this.f1418h = Arrays.copyOf(this.f1418h, i15);
                this.f1416f = Arrays.copyOf(this.f1416f, this.f1414d);
                this.f1417g = Arrays.copyOf(this.f1417g, this.f1414d);
            }
            this.f1416f[length] = iVar.f1499c;
            this.f1418h[length] = f7;
            if (i9 != -1) {
                int[] iArr7 = this.f1417g;
                iArr7[length] = iArr7[i9];
                iArr7[i9] = length;
            } else {
                this.f1417g[length] = this.f1419i;
                this.f1419i = length;
            }
            iVar.f1509m++;
            iVar.a(this.f1412b);
            this.f1411a++;
            if (!this.f1421k) {
                this.f1420j++;
            }
            int i16 = this.f1420j;
            int[] iArr8 = this.f1416f;
            if (i16 >= iArr8.length) {
                this.f1421k = true;
                this.f1420j = iArr8.length - 1;
            }
        }
    }

    @Override // D.b.a
    public void k(float f7) {
        int i7 = this.f1419i;
        for (int i8 = 0; i7 != -1 && i8 < this.f1411a; i8++) {
            float[] fArr = this.f1418h;
            fArr[i7] = fArr[i7] / f7;
            i7 = this.f1417g[i7];
        }
    }

    public String toString() {
        int i7 = this.f1419i;
        String str = "";
        for (int i8 = 0; i7 != -1 && i8 < this.f1411a; i8++) {
            str = ((str + " -> ") + this.f1418h[i7] + " : ") + this.f1413c.f1431d[this.f1416f[i7]];
            i7 = this.f1417g[i7];
        }
        return str;
    }
}
