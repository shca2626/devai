package Y3;

import D3.c;
import D3.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f9862a = {0, 4, 1, 5};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f9863b = {6, 2, 7, 3};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f9864c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f9865d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f9866e = {0, 180, 270, 90};

    public static J3.b a(J3.b bVar, int i7) {
        if (i7 % 360 == 0) {
            return bVar;
        }
        J3.b bVarClone = bVar.clone();
        bVarClone.p(i7);
        return bVarClone;
    }

    public static void b(p[] pVarArr, p[] pVarArr2, int[] iArr) {
        for (int i7 = 0; i7 < iArr.length; i7++) {
            pVarArr[iArr[i7]] = pVarArr2[i7];
        }
    }

    public static b c(c cVar, Map map, boolean z7) {
        J3.b bVarA = cVar.a();
        for (int i7 : f9866e) {
            J3.b bVarA2 = a(bVarA, i7);
            List listD = d(z7, bVarA2);
            if (!listD.isEmpty()) {
                return new b(bVarA2, listD, i7);
            }
        }
        return new b(bVarA, new ArrayList(), 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r4 != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        r3 = r0.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        if (r4 >= r3) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        r7 = r0.get(r4);
        r4 = r4 + 1;
        r7 = (D3.p[]) r7;
        r8 = r7[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r8 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        r2 = (int) java.lang.Math.max(r2, r8.d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        r7 = r7[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r7 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        r2 = java.lang.Math.max(r2, (int) r7.d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List d(boolean r9, J3.b r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = r1
            r3 = r2
        L8:
            r4 = r3
        L9:
            int r5 = r10.l()
            if (r2 >= r5) goto L79
            D3.p[] r3 = g(r10, r2, r3)
            r5 = r3[r1]
            r6 = 1
            if (r5 != 0) goto L4f
            r5 = 3
            r7 = r3[r5]
            if (r7 != 0) goto L4f
            if (r4 != 0) goto L20
            goto L79
        L20:
            int r3 = r0.size()
            r4 = r1
        L25:
            if (r4 >= r3) goto L4b
            java.lang.Object r7 = r0.get(r4)
            int r4 = r4 + 1
            D3.p[] r7 = (D3.p[]) r7
            r8 = r7[r6]
            if (r8 == 0) goto L3d
            float r2 = (float) r2
            float r8 = r8.d()
            float r2 = java.lang.Math.max(r2, r8)
            int r2 = (int) r2
        L3d:
            r7 = r7[r5]
            if (r7 == 0) goto L25
            float r7 = r7.d()
            int r7 = (int) r7
            int r2 = java.lang.Math.max(r2, r7)
            goto L25
        L4b:
            int r2 = r2 + 5
            r3 = r1
            goto L8
        L4f:
            r0.add(r3)
            if (r9 != 0) goto L55
            goto L79
        L55:
            r2 = 2
            r4 = r3[r2]
            if (r4 == 0) goto L68
            float r4 = r4.c()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.d()
        L65:
            int r2 = (int) r2
            r3 = r4
            goto L77
        L68:
            r2 = 4
            r4 = r3[r2]
            float r4 = r4.c()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.d()
            goto L65
        L77:
            r4 = r6
            goto L9
        L79:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Y3.a.d(boolean, J3.b):java.util.List");
    }

    public static int[] e(J3.b bVar, int i7, int i8, int i9, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i10 = 0;
        while (bVar.g(i7, i8) && i7 > 0) {
            int i11 = i10 + 1;
            if (i10 >= 3) {
                break;
            }
            i7--;
            i10 = i11;
        }
        int length = iArr.length;
        int i12 = i7;
        int i13 = 0;
        boolean z7 = false;
        while (i7 < i9) {
            if (bVar.g(i7, i8) != z7) {
                iArr2[i13] = iArr2[i13] + 1;
            } else {
                if (i13 != length - 1) {
                    i13++;
                } else {
                    if (h(iArr2, iArr) < 0.42f) {
                        return new int[]{i12, i7};
                    }
                    i12 += iArr2[0] + iArr2[1];
                    int i14 = i13 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i14);
                    iArr2[i14] = 0;
                    iArr2[i13] = 0;
                    i13--;
                }
                iArr2[i13] = 1;
                z7 = !z7;
            }
            i7++;
        }
        if (i13 != length - 1 || h(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i12, i7 - 1};
    }

    public static p[] f(J3.b bVar, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        int i12;
        boolean z7;
        int[] iArrE;
        p[] pVarArr = new p[4];
        int[] iArr2 = iArr;
        int[] iArr3 = new int[iArr2.length];
        int i13 = i9;
        while (true) {
            if (i13 >= i7) {
                i12 = i13;
                z7 = false;
                break;
            }
            int[] iArrE2 = e(bVar, i10, i13, i8, iArr2, iArr3);
            if (iArrE2 != null) {
                int[] iArr4 = iArrE2;
                while (true) {
                    i12 = i13;
                    if (i12 <= 0 || (iArrE = e(bVar, i10, i12 - 1, i8, iArr, iArr3)) == null) {
                        break;
                    }
                    iArr4 = iArrE;
                }
                float f7 = i12;
                pVarArr[0] = new p(iArr4[0], f7);
                pVarArr[1] = new p(iArr4[1], f7);
                z7 = true;
            } else {
                i13 += 5;
                iArr2 = iArr;
            }
        }
        int i14 = i12 + 1;
        if (z7) {
            int[] iArr5 = {(int) pVarArr[0].c(), (int) pVarArr[1].c()};
            int i15 = i14;
            int i16 = 0;
            while (i15 < i7) {
                int[] iArrE3 = e(bVar, iArr5[0], i15, i8, iArr, iArr3);
                if (iArrE3 != null && Math.abs(iArr5[0] - iArrE3[0]) < 5 && Math.abs(iArr5[1] - iArrE3[1]) < 5) {
                    iArr5 = iArrE3;
                    i16 = 0;
                } else {
                    if (i16 > 25) {
                        break;
                    }
                    i16++;
                }
                i15++;
            }
            i14 = i15 - (i16 + 1);
            float f8 = i14;
            pVarArr[2] = new p(iArr5[0], f8);
            pVarArr[3] = new p(iArr5[1], f8);
        }
        if (i14 - i12 < i11) {
            Arrays.fill(pVarArr, (Object) null);
        }
        return pVarArr;
    }

    public static p[] g(J3.b bVar, int i7, int i8) {
        int iL = bVar.l();
        int iO = bVar.o();
        p[] pVarArr = new p[8];
        int i9 = i7;
        int i10 = i8;
        b(pVarArr, f(bVar, iL, iO, i9, i10, 10, f9864c), f9862a);
        p pVar = pVarArr[4];
        if (pVar != null) {
            int iC = (int) pVar.c();
            int iD = (int) pVarArr[4].d();
            iMax = pVarArr[5] != null ? (int) Math.max((((int) r8.d()) - iD) * 0.5f, 10.0f) : 10;
            i9 = iD;
            i10 = iC;
        }
        b(pVarArr, f(bVar, iL, iO, i9, i10, iMax, f9865d), f9863b);
        return pVarArr;
    }

    public static float h(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            i7 += iArr[i9];
            i8 += iArr2[i9];
        }
        if (i7 < i8) {
            return Float.POSITIVE_INFINITY;
        }
        float f7 = i7;
        float f8 = f7 / i8;
        float f9 = 0.8f * f8;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < length; i10++) {
            float f11 = iArr2[i10] * f8;
            float f12 = iArr[i10];
            float f13 = f12 > f11 ? f12 - f11 : f11 - f12;
            if (f13 > f9) {
                return Float.POSITIVE_INFINITY;
            }
            f10 += f13;
        }
        return f10 / f7;
    }
}
