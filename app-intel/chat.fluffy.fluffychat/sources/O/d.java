package O;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class d {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f6456a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f6457b;
    }

    public static void a(ArrayList arrayList, char c7, float[] fArr) {
        arrayList.add(new b(c7, fArr));
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i7 = 0; i7 < bVarArr.length; i7++) {
            if (bVarArr[i7].f6458a != bVarArr2[i7].f6458a || bVarArr[i7].f6459b.length != bVarArr2[i7].f6459b.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] c(float[] fArr, int i7, int i8) {
        if (i7 > i8) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i7 < 0 || i7 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i9 = i8 - i7;
        int iMin = Math.min(i9, length - i7);
        float[] fArr2 = new float[i9];
        System.arraycopy(fArr, i7, fArr2, 0, iMin);
        return fArr2;
    }

    public static b[] d(String str) {
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        int i8 = 1;
        while (i8 < str.length()) {
            int iH = h(str, i8);
            String strTrim = str.substring(i7, iH).trim();
            if (!strTrim.isEmpty()) {
                a(arrayList, strTrim.charAt(0), g(strTrim));
            }
            i7 = iH;
            i8 = iH + 1;
        }
        if (i8 - i7 == 1 && i7 < str.length()) {
            a(arrayList, str.charAt(i7), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[0]);
    }

    public static b[] e(b[] bVarArr) {
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i7 = 0; i7 < bVarArr.length; i7++) {
            bVarArr2[i7] = new b(bVarArr[i7]);
        }
        return bVarArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[LOOP:0: B:3:0x0007->B:24:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(java.lang.String r8, int r9, O.d.a r10) {
        /*
            r0 = 0
            r10.f6457b = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L29
            r6 = 69
            if (r5 == r6) goto L35
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L35
            switch(r5) {
                case 44: goto L29;
                case 45: goto L2c;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L33
        L22:
            if (r3 != 0) goto L27
            r2 = r0
            r3 = r7
            goto L36
        L27:
            r10.f6457b = r7
        L29:
            r2 = r0
            r4 = r7
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.f6457b = r7
            goto L29
        L33:
            r2 = r0
            goto L36
        L35:
            r2 = r7
        L36:
            if (r4 == 0) goto L39
            goto L3c
        L39:
            int r1 = r1 + 1
            goto L7
        L3c:
            r10.f6456a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: O.d.f(java.lang.String, int, O.d$a):void");
    }

    public static float[] g(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i7 = 1;
            int i8 = 0;
            while (i7 < length) {
                f(str, i7, aVar);
                int i9 = aVar.f6456a;
                if (i7 < i9) {
                    fArr[i8] = Float.parseFloat(str.substring(i7, i9));
                    i8++;
                }
                i7 = aVar.f6457b ? i9 : i9 + 1;
            }
            return c(fArr, 0, i8);
        } catch (NumberFormatException e7) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e7);
        }
    }

    public static int h(String str, int i7) {
        while (i7 < str.length()) {
            char cCharAt = str.charAt(i7);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                break;
            }
            i7++;
        }
        return i7;
    }

    public static void i(b[] bVarArr, Path path) {
        float[] fArr = new float[6];
        char c7 = 'm';
        for (b bVar : bVarArr) {
            b.e(path, fArr, c7, bVar.f6458a, bVar.f6459b);
            c7 = bVar.f6458a;
        }
    }

    public static void j(b[] bVarArr, b[] bVarArr2) {
        for (int i7 = 0; i7 < bVarArr2.length; i7++) {
            bVarArr[i7].f6458a = bVarArr2[i7].f6458a;
            for (int i8 = 0; i8 < bVarArr2[i7].f6459b.length; i8++) {
                bVarArr[i7].f6459b[i8] = bVarArr2[i7].f6459b[i8];
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public char f6458a;

        /* renamed from: b, reason: collision with root package name */
        public final float[] f6459b;

        public b(char c7, float[] fArr) {
            this.f6458a = c7;
            this.f6459b = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void e(Path path, float[] fArr, char c7, char c8, float[] fArr2) {
            int i7;
            int i8;
            boolean z7;
            boolean z8;
            char c9;
            char c10;
            int i9;
            float f7;
            boolean z9;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            boolean z10;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            float f19;
            float f20;
            float f21;
            float f22;
            Path path2 = path;
            boolean z11 = false;
            float f23 = fArr[0];
            boolean z12 = true;
            float f24 = fArr[1];
            char c11 = 2;
            float f25 = fArr[2];
            char c12 = 3;
            float f26 = fArr[3];
            float f27 = fArr[4];
            float f28 = fArr[5];
            switch (c8) {
                case 'A':
                case 'a':
                    i7 = 7;
                    i8 = i7;
                    break;
                case 'C':
                case 'c':
                    i7 = 6;
                    i8 = i7;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i8 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i8 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i8 = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f27, f28);
                    f23 = f27;
                    f25 = f23;
                    f24 = f28;
                    f26 = f24;
                    i8 = 2;
                    break;
            }
            float f29 = f23;
            float f30 = f24;
            float f31 = f27;
            float f32 = f28;
            int i10 = 0;
            char c13 = c7;
            while (i10 < fArr2.length) {
                if (c8 == 'A') {
                    float f33 = f29;
                    float f34 = f30;
                    z7 = z11;
                    z8 = z12;
                    c9 = c11;
                    c10 = c12;
                    i9 = i10;
                    int i11 = i9 + 5;
                    float f35 = fArr2[i11];
                    int i12 = i9 + 6;
                    float f36 = fArr2[i12];
                    float f37 = fArr2[i9];
                    float f38 = fArr2[i9 + 1];
                    float f39 = fArr2[i9 + 2];
                    if (fArr2[i9 + 3] != 0.0f) {
                        f7 = 0.0f;
                        z9 = z8;
                    } else {
                        f7 = 0.0f;
                        z9 = z7;
                    }
                    g(path, f33, f34, f35, f36, f37, f38, f39, z9, fArr2[i9 + 4] != f7 ? z8 : z7);
                    f25 = fArr2[i11];
                    f29 = f25;
                    f26 = fArr2[i12];
                    f30 = f26;
                } else if (c8 == 'C') {
                    z7 = z11;
                    z8 = z12;
                    c9 = c11;
                    c10 = c12;
                    i9 = i10;
                    int i13 = i9 + 2;
                    int i14 = i9 + 3;
                    int i15 = i9 + 4;
                    int i16 = i9 + 5;
                    path2.cubicTo(fArr2[i9], fArr2[i9 + 1], fArr2[i13], fArr2[i14], fArr2[i15], fArr2[i16]);
                    float f40 = fArr2[i15];
                    float f41 = fArr2[i16];
                    float f42 = fArr2[i13];
                    float f43 = fArr2[i14];
                    f29 = f40;
                    f30 = f41;
                    f26 = f43;
                    f25 = f42;
                } else if (c8 != 'H') {
                    if (c8 != 'Q') {
                        z7 = z11;
                        if (c8 == 'V') {
                            z8 = z12;
                            c9 = c11;
                            c10 = c12;
                            i9 = i10;
                            path2.lineTo(f29, fArr2[i9]);
                            f10 = fArr2[i9];
                        } else if (c8 != 'a') {
                            if (c8 != 'c') {
                                z8 = z12;
                                if (c8 != 'h') {
                                    if (c8 != 'q') {
                                        c9 = c11;
                                        if (c8 != 'v') {
                                            if (c8 != 'L') {
                                                if (c8 != 'M') {
                                                    c10 = c12;
                                                    if (c8 == 'S') {
                                                        if (c13 == 'c' || c13 == 's' || c13 == 'C' || c13 == 'S') {
                                                            f29 = (f29 * 2.0f) - f25;
                                                            f30 = (f30 * 2.0f) - f26;
                                                        }
                                                        float f44 = f29;
                                                        float f45 = f30;
                                                        int i17 = i10 + 1;
                                                        int i18 = i10 + 2;
                                                        int i19 = i10 + 3;
                                                        path2.cubicTo(f44, f45, fArr2[i10], fArr2[i17], fArr2[i18], fArr2[i19]);
                                                        f8 = fArr2[i10];
                                                        f9 = fArr2[i17];
                                                        f29 = fArr2[i18];
                                                        f30 = fArr2[i19];
                                                        i9 = i10;
                                                    } else if (c8 == 'T') {
                                                        if (c13 == 'q' || c13 == 't' || c13 == 'Q' || c13 == 'T') {
                                                            f29 = (f29 * 2.0f) - f25;
                                                            f30 = (f30 * 2.0f) - f26;
                                                        }
                                                        int i20 = i10 + 1;
                                                        path2.quadTo(f29, f30, fArr2[i10], fArr2[i20]);
                                                        float f46 = fArr2[i10];
                                                        f10 = fArr2[i20];
                                                        f25 = f29;
                                                        f26 = f30;
                                                        i9 = i10;
                                                        f29 = f46;
                                                    } else if (c8 == 'l') {
                                                        int i21 = i10 + 1;
                                                        path2.rLineTo(fArr2[i10], fArr2[i21]);
                                                        f29 += fArr2[i10];
                                                        f16 = fArr2[i21];
                                                    } else if (c8 == 'm') {
                                                        float f47 = fArr2[i10];
                                                        f29 += f47;
                                                        float f48 = fArr2[i10 + 1];
                                                        f30 += f48;
                                                        if (i10 > 0) {
                                                            path2.rLineTo(f47, f48);
                                                        } else {
                                                            path2.rMoveTo(f47, f48);
                                                            f31 = f29;
                                                        }
                                                    } else if (c8 == 's') {
                                                        if (c13 == 'c' || c13 == 's' || c13 == 'C' || c13 == 'S') {
                                                            f19 = f30 - f26;
                                                            f20 = f29 - f25;
                                                        } else {
                                                            f20 = 0.0f;
                                                            f19 = 0.0f;
                                                        }
                                                        int i22 = i10 + 1;
                                                        int i23 = i10 + 2;
                                                        int i24 = i10 + 3;
                                                        path2.rCubicTo(f20, f19, fArr2[i10], fArr2[i22], fArr2[i23], fArr2[i24]);
                                                        f13 = fArr2[i10] + f29;
                                                        f14 = fArr2[i22] + f30;
                                                        f29 += fArr2[i23];
                                                        f15 = fArr2[i24];
                                                    } else if (c8 == 't') {
                                                        if (c13 == 'q' || c13 == 't' || c13 == 'Q' || c13 == 'T') {
                                                            f21 = f29 - f25;
                                                            f22 = f30 - f26;
                                                        } else {
                                                            f22 = 0.0f;
                                                            f21 = 0.0f;
                                                        }
                                                        int i25 = i10 + 1;
                                                        path2.rQuadTo(f21, f22, fArr2[i10], fArr2[i25]);
                                                        float f49 = f21 + f29;
                                                        float f50 = f22 + f30;
                                                        f29 += fArr2[i10];
                                                        f30 += fArr2[i25];
                                                        f26 = f50;
                                                        f25 = f49;
                                                    }
                                                } else {
                                                    c10 = c12;
                                                    f17 = fArr2[i10];
                                                    f18 = fArr2[i10 + 1];
                                                    if (i10 > 0) {
                                                        path2.lineTo(f17, f18);
                                                    } else {
                                                        path2.moveTo(f17, f18);
                                                        f29 = f17;
                                                        f31 = f29;
                                                        f30 = f18;
                                                    }
                                                }
                                                f32 = f30;
                                            } else {
                                                c10 = c12;
                                                int i26 = i10 + 1;
                                                path2.lineTo(fArr2[i10], fArr2[i26]);
                                                f17 = fArr2[i10];
                                                f18 = fArr2[i26];
                                            }
                                            f29 = f17;
                                            f30 = f18;
                                        } else {
                                            c10 = c12;
                                            path2.rLineTo(0.0f, fArr2[i10]);
                                            f16 = fArr2[i10];
                                        }
                                        f30 += f16;
                                    } else {
                                        c9 = c11;
                                        c10 = c12;
                                        int i27 = i10 + 1;
                                        int i28 = i10 + 2;
                                        int i29 = i10 + 3;
                                        path2.rQuadTo(fArr2[i10], fArr2[i27], fArr2[i28], fArr2[i29]);
                                        f13 = fArr2[i10] + f29;
                                        f14 = fArr2[i27] + f30;
                                        f29 += fArr2[i28];
                                        f15 = fArr2[i29];
                                    }
                                    f30 += f15;
                                    f25 = f13;
                                    f26 = f14;
                                } else {
                                    c9 = c11;
                                    c10 = c12;
                                    path2.rLineTo(fArr2[i10], 0.0f);
                                    f29 += fArr2[i10];
                                }
                            } else {
                                z8 = z12;
                                c9 = c11;
                                c10 = c12;
                                int i30 = i10 + 2;
                                int i31 = i10 + 3;
                                int i32 = i10 + 4;
                                int i33 = i10 + 5;
                                path2.rCubicTo(fArr2[i10], fArr2[i10 + 1], fArr2[i30], fArr2[i31], fArr2[i32], fArr2[i33]);
                                float f51 = fArr2[i30] + f29;
                                float f52 = fArr2[i31] + f30;
                                f29 += fArr2[i32];
                                f30 += fArr2[i33];
                                f25 = f51;
                                f26 = f52;
                            }
                            i9 = i10;
                        } else {
                            z8 = z12;
                            c9 = c11;
                            c10 = c12;
                            int i34 = i10 + 5;
                            float f53 = fArr2[i34] + f29;
                            int i35 = i10 + 6;
                            float f54 = fArr2[i35] + f30;
                            float f55 = fArr2[i10];
                            float f56 = fArr2[i10 + 1];
                            float f57 = fArr2[i10 + 2];
                            if (fArr2[i10 + 3] != 0.0f) {
                                f11 = 0.0f;
                                f12 = f30;
                                z10 = z8;
                            } else {
                                f11 = 0.0f;
                                f12 = f30;
                                z10 = z7;
                            }
                            i9 = i10;
                            boolean z13 = fArr2[i10 + 4] != f11 ? z8 : z7;
                            float f58 = f29;
                            g(path, f58, f12, f53, f54, f55, f56, f57, z10, z13);
                            f29 = f58 + fArr2[i34];
                            f30 = f12 + fArr2[i35];
                            f25 = f29;
                            f26 = f30;
                        }
                        f30 = f10;
                    } else {
                        z7 = z11;
                        z8 = z12;
                        c9 = c11;
                        c10 = c12;
                        i9 = i10;
                        int i36 = i9 + 1;
                        int i37 = i9 + 2;
                        int i38 = i9 + 3;
                        path2.quadTo(fArr2[i9], fArr2[i36], fArr2[i37], fArr2[i38]);
                        f8 = fArr2[i9];
                        f9 = fArr2[i36];
                        f29 = fArr2[i37];
                        f30 = fArr2[i38];
                    }
                    f25 = f8;
                    f26 = f9;
                } else {
                    z7 = z11;
                    z8 = z12;
                    c9 = c11;
                    c10 = c12;
                    i9 = i10;
                    path2.lineTo(fArr2[i9], f30);
                    f29 = fArr2[i9];
                }
                i10 = i9 + i8;
                path2 = path;
                c13 = c8;
                z11 = z7;
                z12 = z8;
                c11 = c9;
                c12 = c10;
            }
            fArr[z11 ? 1 : 0] = f29;
            fArr[z12 ? 1 : 0] = f30;
            fArr[c11] = f25;
            fArr[c12] = f26;
            fArr[4] = f31;
            fArr[5] = f32;
        }

        public static void f(Path path, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15) {
            double d16 = d9;
            int iCeil = (int) Math.ceil(Math.abs((d15 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d13);
            double dSin = Math.sin(d13);
            double dCos2 = Math.cos(d14);
            double dSin2 = Math.sin(d14);
            double d17 = -d16;
            double d18 = d17 * dCos;
            double d19 = d10 * dSin;
            double d20 = (d18 * dSin2) - (d19 * dCos2);
            double d21 = d17 * dSin;
            double d22 = d10 * dCos;
            double d23 = (dSin2 * d21) + (dCos2 * d22);
            double d24 = d15 / iCeil;
            double d25 = d23;
            double d26 = d20;
            int i7 = 0;
            double d27 = d11;
            double d28 = d12;
            double d29 = d14;
            while (i7 < iCeil) {
                double d30 = d29 + d24;
                double dSin3 = Math.sin(d30);
                double dCos3 = Math.cos(d30);
                double d31 = (d7 + ((d16 * dCos) * dCos3)) - (d19 * dSin3);
                int i8 = i7;
                double d32 = d8 + (d9 * dSin * dCos3) + (d22 * dSin3);
                double d33 = (d18 * dSin3) - (d19 * dCos3);
                double d34 = (dSin3 * d21) + (dCos3 * d22);
                double d35 = d30 - d29;
                double dTan = Math.tan(d35 / 2.0d);
                double dSin4 = (Math.sin(d35) * (Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d)) / 3.0d;
                double d36 = d27 + (d26 * dSin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d36, (float) (d28 + (d25 * dSin4)), (float) (d31 - (dSin4 * d33)), (float) (d32 - (dSin4 * d34)), (float) d31, (float) d32);
                dSin = dSin;
                d24 = d24;
                d27 = d31;
                d21 = d21;
                d29 = d30;
                d25 = d34;
                dCos = dCos;
                d16 = d9;
                d28 = d32;
                i7 = i8 + 1;
                iCeil = iCeil;
                d26 = d33;
            }
        }

        public static void g(Path path, float f7, float f8, float f9, float f10, float f11, float f12, float f13, boolean z7, boolean z8) {
            double d7;
            double d8;
            double radians = Math.toRadians(f13);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d9 = f7;
            double d10 = f8;
            double d11 = f11;
            double d12 = ((d9 * dCos) + (d10 * dSin)) / d11;
            double d13 = f12;
            double d14 = (((-f7) * dSin) + (d10 * dCos)) / d13;
            double d15 = f10;
            double d16 = ((f9 * dCos) + (d15 * dSin)) / d11;
            double d17 = (((-f9) * dSin) + (d15 * dCos)) / d13;
            double d18 = d12 - d16;
            double d19 = d14 - d17;
            double d20 = (d12 + d16) / 2.0d;
            double d21 = (d14 + d17) / 2.0d;
            double d22 = (d18 * d18) + (d19 * d19);
            if (d22 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d23 = (1.0d / d22) - 0.25d;
            if (d23 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d22);
                float fSqrt = (float) (Math.sqrt(d22) / 1.99999d);
                g(path, f7, f8, f9, f10, f11 * fSqrt, fSqrt * f12, f13, z7, z8);
                return;
            }
            double dSqrt = Math.sqrt(d23);
            double d24 = d18 * dSqrt;
            double d25 = dSqrt * d19;
            if (z7 == z8) {
                d7 = d20 - d25;
                d8 = d21 + d24;
            } else {
                d7 = d20 + d25;
                d8 = d21 - d24;
            }
            double dAtan2 = Math.atan2(d14 - d8, d12 - d7);
            double dAtan22 = Math.atan2(d17 - d8, d16 - d7) - dAtan2;
            if (z8 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d26 = d7 * d11;
            double d27 = d8 * d13;
            f(path, (d26 * dCos) - (d27 * dSin), (d26 * dSin) + (d27 * dCos), d11, d13, d9, d10, radians, dAtan2, dAtan22);
        }

        public static void h(b[] bVarArr, Path path) {
            d.i(bVarArr, path);
        }

        public b(b bVar) {
            this.f6458a = bVar.f6458a;
            float[] fArr = bVar.f6459b;
            this.f6459b = d.c(fArr, 0, fArr.length);
        }
    }
}
