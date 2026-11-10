package androidx.core.graphics;

import android.graphics.Path;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public final class g {

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        int f6542a;

        /* renamed from: b, reason: collision with root package name */
        boolean f6543b;

        a() {
        }
    }

    private static void a(ArrayList<b> arrayList, char c12, float[] fArr) {
        arrayList.add(new b(c12, fArr));
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i12 = 0; i12 < bVarArr.length; i12++) {
            if (bVarArr[i12].f6544a != bVarArr2[i12].f6544a || bVarArr[i12].f6545b.length != bVarArr2[i12].f6545b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i12, int i13) {
        if (i12 > i13) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i12 < 0 || i12 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i14 = i13 - i12;
        int iMin = Math.min(i14, length - i12);
        float[] fArr2 = new float[i14];
        System.arraycopy(fArr, i12, fArr2, 0, iMin);
        return fArr2;
    }

    public static b[] d(String str) {
        ArrayList arrayList = new ArrayList();
        int i12 = 1;
        int i13 = 0;
        while (i12 < str.length()) {
            int i14 = i(str, i12);
            String strTrim = str.substring(i13, i14).trim();
            if (!strTrim.isEmpty()) {
                a(arrayList, strTrim.charAt(0), h(strTrim));
            }
            i13 = i14;
            i12 = i14 + 1;
        }
        if (i12 - i13 == 1 && i13 < str.length()) {
            a(arrayList, str.charAt(i13), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[0]);
    }

    public static Path e(String str) {
        Path path = new Path();
        try {
            b.i(d(str), path);
            return path;
        } catch (RuntimeException e12) {
            throw new RuntimeException("Error in parsing " + str, e12);
        }
    }

    public static b[] f(b[] bVarArr) {
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i12 = 0; i12 < bVarArr.length; i12++) {
            bVarArr2[i12] = new b(bVarArr[i12]);
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
    private static void g(java.lang.String r8, int r9, androidx.core.graphics.g.a r10) {
        /*
            r0 = 0
            r10.f6543b = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
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
            r2 = 0
            r3 = 1
            goto L36
        L27:
            r10.f6543b = r7
        L29:
            r2 = 0
            r4 = 1
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.f6543b = r7
            goto L29
        L33:
            r2 = 0
            goto L36
        L35:
            r2 = 1
        L36:
            if (r4 == 0) goto L39
            goto L3c
        L39:
            int r1 = r1 + 1
            goto L7
        L3c:
            r10.f6542a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.g.g(java.lang.String, int, androidx.core.graphics.g$a):void");
    }

    private static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i12 = 1;
            int i13 = 0;
            while (i12 < length) {
                g(str, i12, aVar);
                int i14 = aVar.f6542a;
                if (i12 < i14) {
                    fArr[i13] = Float.parseFloat(str.substring(i12, i14));
                    i13++;
                }
                i12 = aVar.f6543b ? i14 : i14 + 1;
            }
            return c(fArr, 0, i13);
        } catch (NumberFormatException e12) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e12);
        }
    }

    private static int i(String str, int i12) {
        while (i12 < str.length()) {
            char cCharAt = str.charAt(i12);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                return i12;
            }
            i12++;
        }
        return i12;
    }

    public static void j(b[] bVarArr, Path path) {
        float[] fArr = new float[6];
        char c12 = 'm';
        for (b bVar : bVarArr) {
            b.e(path, fArr, c12, bVar.f6544a, bVar.f6545b);
            c12 = bVar.f6544a;
        }
    }

    public static void k(b[] bVarArr, b[] bVarArr2) {
        for (int i12 = 0; i12 < bVarArr2.length; i12++) {
            bVarArr[i12].f6544a = bVarArr2[i12].f6544a;
            for (int i13 = 0; i13 < bVarArr2[i12].f6545b.length; i13++) {
                bVarArr[i12].f6545b[i13] = bVarArr2[i12].f6545b[i13];
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private char f6544a;

        /* renamed from: b, reason: collision with root package name */
        private final float[] f6545b;

        b(char c12, float[] fArr) {
            this.f6544a = c12;
            this.f6545b = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void e(Path path, float[] fArr, char c12, char c13, float[] fArr2) {
            int i12;
            int i13;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            float f19;
            char c14 = c13;
            float f22 = fArr[0];
            float f23 = fArr[1];
            float f24 = fArr[2];
            float f25 = fArr[3];
            float f26 = fArr[4];
            float f27 = fArr[5];
            switch (c14) {
                case 'A':
                case 'a':
                    i12 = 7;
                    break;
                case 'C':
                case 'c':
                    i12 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i12 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i12 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i12 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f26, f27);
                    f22 = f26;
                    f24 = f22;
                    f23 = f27;
                    f25 = f23;
                    i12 = 2;
                    break;
            }
            float f28 = f22;
            float f29 = f23;
            float f32 = f26;
            float f33 = f27;
            int i14 = 0;
            char c15 = c12;
            while (i14 < fArr2.length) {
                if (c14 != 'A') {
                    if (c14 == 'C') {
                        i13 = i14;
                        int i15 = i13 + 2;
                        int i16 = i13 + 3;
                        int i17 = i13 + 4;
                        int i18 = i13 + 5;
                        path.cubicTo(fArr2[i13], fArr2[i13 + 1], fArr2[i15], fArr2[i16], fArr2[i17], fArr2[i18]);
                        f28 = fArr2[i17];
                        float f34 = fArr2[i18];
                        float f35 = fArr2[i15];
                        float f36 = fArr2[i16];
                        f29 = f34;
                        f25 = f36;
                        f24 = f35;
                    } else if (c14 == 'H') {
                        i13 = i14;
                        path.lineTo(fArr2[i13], f29);
                        f28 = fArr2[i13];
                    } else if (c14 == 'Q') {
                        i13 = i14;
                        int i19 = i13 + 1;
                        int i22 = i13 + 2;
                        int i23 = i13 + 3;
                        path.quadTo(fArr2[i13], fArr2[i19], fArr2[i22], fArr2[i23]);
                        float f37 = fArr2[i13];
                        float f38 = fArr2[i19];
                        f28 = fArr2[i22];
                        f29 = fArr2[i23];
                        f24 = f37;
                        f25 = f38;
                    } else if (c14 == 'V') {
                        i13 = i14;
                        path.lineTo(f28, fArr2[i13]);
                        f29 = fArr2[i13];
                    } else if (c14 != 'a') {
                        if (c14 != 'c') {
                            if (c14 == 'h') {
                                path.rLineTo(fArr2[i14], BitmapDescriptorFactory.HUE_RED);
                                f28 += fArr2[i14];
                            } else if (c14 != 'q') {
                                if (c14 == 'v') {
                                    path.rLineTo(BitmapDescriptorFactory.HUE_RED, fArr2[i14]);
                                    f15 = fArr2[i14];
                                } else if (c14 == 'L') {
                                    int i24 = i14 + 1;
                                    path.lineTo(fArr2[i14], fArr2[i24]);
                                    f28 = fArr2[i14];
                                    f29 = fArr2[i24];
                                } else if (c14 == 'M') {
                                    f28 = fArr2[i14];
                                    f29 = fArr2[i14 + 1];
                                    if (i14 > 0) {
                                        path.lineTo(f28, f29);
                                    } else {
                                        path.moveTo(f28, f29);
                                        i13 = i14;
                                        f33 = f29;
                                        f32 = f28;
                                    }
                                } else if (c14 == 'S') {
                                    if (c15 == 'c' || c15 == 's' || c15 == 'C' || c15 == 'S') {
                                        f28 = (f28 * 2.0f) - f24;
                                        f29 = (f29 * 2.0f) - f25;
                                    }
                                    float f39 = f29;
                                    float f42 = f28;
                                    int i25 = i14 + 1;
                                    int i26 = i14 + 2;
                                    int i27 = i14 + 3;
                                    path.cubicTo(f42, f39, fArr2[i14], fArr2[i25], fArr2[i26], fArr2[i27]);
                                    f12 = fArr2[i14];
                                    f13 = fArr2[i25];
                                    f28 = fArr2[i26];
                                    f29 = fArr2[i27];
                                    f24 = f12;
                                    f25 = f13;
                                } else if (c14 == 'T') {
                                    if (c15 == 'q' || c15 == 't' || c15 == 'Q' || c15 == 'T') {
                                        f28 = (f28 * 2.0f) - f24;
                                        f29 = (f29 * 2.0f) - f25;
                                    }
                                    int i28 = i14 + 1;
                                    path.quadTo(f28, f29, fArr2[i14], fArr2[i28]);
                                    i13 = i14;
                                    f25 = f29;
                                    f24 = f28;
                                    f28 = fArr2[i14];
                                    f29 = fArr2[i28];
                                } else if (c14 == 'l') {
                                    int i29 = i14 + 1;
                                    path.rLineTo(fArr2[i14], fArr2[i29]);
                                    f28 += fArr2[i14];
                                    f15 = fArr2[i29];
                                } else if (c14 == 'm') {
                                    float f43 = fArr2[i14];
                                    f28 += f43;
                                    float f44 = fArr2[i14 + 1];
                                    f29 += f44;
                                    if (i14 > 0) {
                                        path.rLineTo(f43, f44);
                                    } else {
                                        path.rMoveTo(f43, f44);
                                        i13 = i14;
                                        f33 = f29;
                                        f32 = f28;
                                    }
                                } else if (c14 == 's') {
                                    if (c15 == 'c' || c15 == 's' || c15 == 'C' || c15 == 'S') {
                                        float f45 = f28 - f24;
                                        f16 = f29 - f25;
                                        f17 = f45;
                                    } else {
                                        f17 = BitmapDescriptorFactory.HUE_RED;
                                        f16 = BitmapDescriptorFactory.HUE_RED;
                                    }
                                    int i32 = i14 + 1;
                                    int i33 = i14 + 2;
                                    int i34 = i14 + 3;
                                    path.rCubicTo(f17, f16, fArr2[i14], fArr2[i32], fArr2[i33], fArr2[i34]);
                                    f12 = fArr2[i14] + f28;
                                    f13 = fArr2[i32] + f29;
                                    f28 += fArr2[i33];
                                    f14 = fArr2[i34];
                                } else if (c14 == 't') {
                                    if (c15 == 'q' || c15 == 't' || c15 == 'Q' || c15 == 'T') {
                                        f18 = f28 - f24;
                                        f19 = f29 - f25;
                                    } else {
                                        f19 = BitmapDescriptorFactory.HUE_RED;
                                        f18 = BitmapDescriptorFactory.HUE_RED;
                                    }
                                    int i35 = i14 + 1;
                                    path.rQuadTo(f18, f19, fArr2[i14], fArr2[i35]);
                                    float f46 = f18 + f28;
                                    float f47 = f19 + f29;
                                    f28 += fArr2[i14];
                                    f29 += fArr2[i35];
                                    f25 = f47;
                                    f24 = f46;
                                }
                                f29 += f15;
                            } else {
                                int i36 = i14 + 1;
                                int i37 = i14 + 2;
                                int i38 = i14 + 3;
                                path.rQuadTo(fArr2[i14], fArr2[i36], fArr2[i37], fArr2[i38]);
                                f12 = fArr2[i14] + f28;
                                f13 = fArr2[i36] + f29;
                                f28 += fArr2[i37];
                                f14 = fArr2[i38];
                            }
                            i13 = i14;
                        } else {
                            int i39 = i14 + 2;
                            int i42 = i14 + 3;
                            int i43 = i14 + 4;
                            int i44 = i14 + 5;
                            path.rCubicTo(fArr2[i14], fArr2[i14 + 1], fArr2[i39], fArr2[i42], fArr2[i43], fArr2[i44]);
                            f12 = fArr2[i39] + f28;
                            f13 = fArr2[i42] + f29;
                            f28 += fArr2[i43];
                            f14 = fArr2[i44];
                        }
                        f29 += f14;
                        f24 = f12;
                        f25 = f13;
                        i13 = i14;
                    } else {
                        int i45 = i14 + 5;
                        int i46 = i14 + 6;
                        i13 = i14;
                        g(path, f28, f29, fArr2[i45] + f28, fArr2[i46] + f29, fArr2[i14], fArr2[i14 + 1], fArr2[i14 + 2], fArr2[i14 + 3] != BitmapDescriptorFactory.HUE_RED, fArr2[i14 + 4] != BitmapDescriptorFactory.HUE_RED);
                        f28 += fArr2[i45];
                        f29 += fArr2[i46];
                    }
                    i14 = i13 + i12;
                    c15 = c13;
                    c14 = c15;
                } else {
                    i13 = i14;
                    int i47 = i13 + 5;
                    int i48 = i13 + 6;
                    g(path, f28, f29, fArr2[i47], fArr2[i48], fArr2[i13], fArr2[i13 + 1], fArr2[i13 + 2], fArr2[i13 + 3] != BitmapDescriptorFactory.HUE_RED, fArr2[i13 + 4] != BitmapDescriptorFactory.HUE_RED);
                    f28 = fArr2[i47];
                    f29 = fArr2[i48];
                }
                f25 = f29;
                f24 = f28;
                i14 = i13 + i12;
                c15 = c13;
                c14 = c15;
            }
            fArr[0] = f28;
            fArr[1] = f29;
            fArr[2] = f24;
            fArr[3] = f25;
            fArr[4] = f32;
            fArr[5] = f33;
        }

        private static void f(Path path, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19, double d22) {
            double d23 = d14;
            int iCeil = (int) Math.ceil(Math.abs((d22 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d18);
            double dSin = Math.sin(d18);
            double dCos2 = Math.cos(d19);
            double dSin2 = Math.sin(d19);
            double d24 = -d23;
            double d25 = d24 * dCos;
            double d26 = d15 * dSin;
            double d27 = (d25 * dSin2) - (d26 * dCos2);
            double d28 = d24 * dSin;
            double d29 = d15 * dCos;
            double d32 = (dSin2 * d28) + (dCos2 * d29);
            double d33 = d22 / iCeil;
            double d34 = d19;
            double d35 = d32;
            double d36 = d27;
            int i12 = 0;
            double d37 = d16;
            double d38 = d17;
            while (i12 < iCeil) {
                double d39 = d34 + d33;
                double dSin3 = Math.sin(d39);
                double dCos3 = Math.cos(d39);
                double d42 = (d12 + ((d23 * dCos) * dCos3)) - (d26 * dSin3);
                double d43 = d13 + (d23 * dSin * dCos3) + (d29 * dSin3);
                double d44 = (d25 * dSin3) - (d26 * dCos3);
                double d45 = (dSin3 * d28) + (dCos3 * d29);
                double d46 = d39 - d34;
                double dTan = Math.tan(d46 / 2.0d);
                double dSin4 = (Math.sin(d46) * (Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d)) / 3.0d;
                double d47 = d37 + (d36 * dSin4);
                path.rLineTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
                path.cubicTo((float) d47, (float) (d38 + (d35 * dSin4)), (float) (d42 - (dSin4 * d44)), (float) (d43 - (dSin4 * d45)), (float) d42, (float) d43);
                i12++;
                d33 = d33;
                dSin = dSin;
                d37 = d42;
                d28 = d28;
                dCos = dCos;
                d34 = d39;
                d35 = d45;
                d36 = d44;
                iCeil = iCeil;
                d38 = d43;
                d23 = d14;
            }
        }

        private static void g(Path path, float f12, float f13, float f14, float f15, float f16, float f17, float f18, boolean z12, boolean z13) {
            double d12;
            double d13;
            double radians = Math.toRadians(f18);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d14 = f12;
            double d15 = d14 * dCos;
            double d16 = f13;
            double d17 = f16;
            double d18 = (d15 + (d16 * dSin)) / d17;
            double d19 = ((-f12) * dSin) + (d16 * dCos);
            double d22 = f17;
            double d23 = d19 / d22;
            double d24 = f15;
            double d25 = ((f14 * dCos) + (d24 * dSin)) / d17;
            double d26 = (((-f14) * dSin) + (d24 * dCos)) / d22;
            double d27 = d18 - d25;
            double d28 = d23 - d26;
            double d29 = (d18 + d25) / 2.0d;
            double d32 = (d23 + d26) / 2.0d;
            double d33 = (d27 * d27) + (d28 * d28);
            if (d33 == 0.0d) {
                return;
            }
            double d34 = (1.0d / d33) - 0.25d;
            if (d34 < 0.0d) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Points are too far apart ");
                sb2.append(d33);
                float fSqrt = (float) (Math.sqrt(d33) / 1.99999d);
                g(path, f12, f13, f14, f15, f16 * fSqrt, f17 * fSqrt, f18, z12, z13);
                return;
            }
            double dSqrt = Math.sqrt(d34);
            double d35 = d27 * dSqrt;
            double d36 = dSqrt * d28;
            if (z12 == z13) {
                d12 = d29 - d36;
                d13 = d32 + d35;
            } else {
                d12 = d29 + d36;
                d13 = d32 - d35;
            }
            double dAtan2 = Math.atan2(d23 - d13, d18 - d12);
            double dAtan22 = Math.atan2(d26 - d13, d25 - d12) - dAtan2;
            if (z13 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d37 = d12 * d17;
            double d38 = d13 * d22;
            f(path, (d37 * dCos) - (d38 * dSin), (d37 * dSin) + (d38 * dCos), d17, d22, d14, d16, radians, dAtan2, dAtan22);
        }

        @Deprecated
        public static void i(b[] bVarArr, Path path) {
            g.j(bVarArr, path);
        }

        public void h(b bVar, b bVar2, float f12) {
            this.f6544a = bVar.f6544a;
            int i12 = 0;
            while (true) {
                float[] fArr = bVar.f6545b;
                if (i12 >= fArr.length) {
                    return;
                }
                this.f6545b[i12] = (fArr[i12] * (1.0f - f12)) + (bVar2.f6545b[i12] * f12);
                i12++;
            }
        }

        b(b bVar) {
            this.f6544a = bVar.f6544a;
            float[] fArr = bVar.f6545b;
            this.f6545b = g.c(fArr, 0, fArr.length);
        }
    }
}
