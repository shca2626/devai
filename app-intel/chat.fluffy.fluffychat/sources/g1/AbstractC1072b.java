package g1;

import B0.C0313o;
import B0.s;
import java.nio.ByteBuffer;

/* renamed from: g1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1072b {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f16024a = {1, 2, 3, 6};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f16025b = {48000, 44100, 32000};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f16026c = {24000, 22050, 16000};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f16027d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f16028e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f16029f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: g1.b$b, reason: collision with other inner class name */
    public static final class C0171b {

        /* renamed from: a, reason: collision with root package name */
        public final String f16030a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16031b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16032c;

        /* renamed from: d, reason: collision with root package name */
        public final int f16033d;

        /* renamed from: e, reason: collision with root package name */
        public final int f16034e;

        /* renamed from: f, reason: collision with root package name */
        public final int f16035f;

        /* renamed from: g, reason: collision with root package name */
        public final int f16036g;

        public C0171b(String str, int i7, int i8, int i9, int i10, int i11, int i12) {
            this.f16030a = str;
            this.f16031b = i7;
            this.f16033d = i8;
            this.f16032c = i9;
            this.f16034e = i10;
            this.f16035f = i11;
            this.f16036g = i12;
        }
    }

    public static int a(int i7, int i8, int i9) {
        return (i7 * i8) / (i9 * 32);
    }

    public static int b(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i7 = iPosition; i7 <= iLimit; i7++) {
            if ((E0.U.P(byteBuffer, i7 + 4) & (-2)) == -126718022) {
                return i7 - iPosition;
            }
        }
        return -1;
    }

    public static int c(int i7, int i8) {
        int i9 = i8 / 2;
        if (i7 < 0) {
            return -1;
        }
        int[] iArr = f16025b;
        if (i7 >= iArr.length || i8 < 0) {
            return -1;
        }
        int[] iArr2 = f16029f;
        if (i9 >= iArr2.length) {
            return -1;
        }
        int i10 = iArr[i7];
        if (i10 == 44100) {
            return (iArr2[i9] + (i8 % 2)) * 2;
        }
        int i11 = f16028e[i9];
        return i10 == 32000 ? i11 * 6 : i11 * 4;
    }

    public static B0.s d(E0.E e7, String str, String str2, C0313o c0313o) {
        E0.D d7 = new E0.D();
        d7.m(e7);
        int i7 = f16025b[d7.h(2)];
        d7.r(8);
        int i8 = f16027d[d7.h(3)];
        if (d7.h(1) != 0) {
            i8++;
        }
        int i9 = f16028e[d7.h(5)] * 1000;
        d7.c();
        e7.f0(d7.d());
        return new s.b().j0(str).y0("audio/ac3").T(i8).z0(i7).c0(c0313o).n0(str2).S(i9).t0(i9).P();
    }

    public static int e(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return f16024a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static C0171b f(E0.D d7) {
        int iC;
        int i7;
        int i8;
        int i9;
        String str;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int iE = d7.e();
        d7.r(40);
        boolean z7 = d7.h(5) > 10;
        d7.p(iE);
        int i16 = -1;
        if (z7) {
            d7.r(16);
            int iH = d7.h(2);
            if (iH == 0) {
                i16 = 0;
            } else if (iH == 1) {
                i16 = 1;
            } else if (iH == 2) {
                i16 = 2;
            }
            d7.r(3);
            iC = (d7.h(11) + 1) * 2;
            int iH2 = d7.h(2);
            if (iH2 == 3) {
                i7 = f16026c[d7.h(2)];
                i11 = 3;
                i12 = 6;
            } else {
                int iH3 = d7.h(2);
                int i17 = f16024a[iH3];
                i11 = iH3;
                i7 = f16025b[iH2];
                i12 = i17;
            }
            i9 = i12 * 256;
            int iA = a(iC, i7, i12);
            int iH4 = d7.h(3);
            boolean zG = d7.g();
            i8 = f16027d[iH4] + (zG ? 1 : 0);
            d7.r(10);
            if (d7.g()) {
                d7.r(8);
            }
            if (iH4 == 0) {
                d7.r(5);
                if (d7.g()) {
                    d7.r(8);
                }
            }
            if (i16 == 1 && d7.g()) {
                d7.r(16);
            }
            if (d7.g()) {
                if (iH4 > 2) {
                    d7.r(2);
                }
                if ((iH4 & 1) == 0 || iH4 <= 2) {
                    i14 = 6;
                } else {
                    i14 = 6;
                    d7.r(6);
                }
                if ((iH4 & 4) != 0) {
                    d7.r(i14);
                }
                if (zG && d7.g()) {
                    d7.r(5);
                }
                if (i16 == 0) {
                    if (d7.g()) {
                        i15 = 6;
                        d7.r(6);
                    } else {
                        i15 = 6;
                    }
                    if (iH4 == 0 && d7.g()) {
                        d7.r(i15);
                    }
                    if (d7.g()) {
                        d7.r(i15);
                    }
                    int iH5 = d7.h(2);
                    if (iH5 == 1) {
                        d7.r(5);
                    } else if (iH5 == 2) {
                        d7.r(12);
                    } else if (iH5 == 3) {
                        int iH6 = d7.h(5);
                        if (d7.g()) {
                            d7.r(5);
                            if (d7.g()) {
                                d7.r(4);
                            }
                            if (d7.g()) {
                                d7.r(4);
                            }
                            if (d7.g()) {
                                d7.r(4);
                            }
                            if (d7.g()) {
                                d7.r(4);
                            }
                            if (d7.g()) {
                                d7.r(4);
                            }
                            if (d7.g()) {
                                d7.r(4);
                            }
                            if (d7.g()) {
                                d7.r(4);
                            }
                            if (d7.g()) {
                                if (d7.g()) {
                                    d7.r(4);
                                }
                                if (d7.g()) {
                                    d7.r(4);
                                }
                            }
                        }
                        if (d7.g()) {
                            d7.r(5);
                            if (d7.g()) {
                                d7.r(7);
                                if (d7.g()) {
                                    d7.r(8);
                                }
                            }
                        }
                        d7.r((iH6 + 2) * 8);
                        d7.c();
                    }
                    if (iH4 < 2) {
                        if (d7.g()) {
                            d7.r(14);
                        }
                        if (iH4 == 0 && d7.g()) {
                            d7.r(14);
                        }
                    }
                    if (d7.g()) {
                        if (i11 == 0) {
                            d7.r(5);
                        } else {
                            for (int i18 = 0; i18 < i12; i18++) {
                                if (d7.g()) {
                                    d7.r(5);
                                }
                            }
                        }
                    }
                }
            }
            if (d7.g()) {
                d7.r(5);
                if (iH4 == 2) {
                    d7.r(4);
                }
                if (iH4 >= 6) {
                    d7.r(2);
                }
                if (d7.g()) {
                    d7.r(8);
                }
                if (iH4 == 0 && d7.g()) {
                    d7.r(8);
                }
                if (iH2 < 3) {
                    d7.q();
                }
            }
            if (i16 == 0 && i11 != 3) {
                d7.q();
            }
            if (i16 == 2 && (i11 == 3 || d7.g())) {
                i13 = 6;
                d7.r(6);
            } else {
                i13 = 6;
            }
            str = (d7.g() && d7.h(i13) == 1 && d7.h(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i10 = iA;
        } else {
            d7.r(32);
            int iH7 = d7.h(2);
            String str2 = iH7 == 3 ? null : "audio/ac3";
            int iH8 = d7.h(6);
            int i19 = f16028e[iH8 / 2] * 1000;
            iC = c(iH7, iH8);
            d7.r(8);
            int iH9 = d7.h(3);
            if ((iH9 & 1) != 0 && iH9 != 1) {
                d7.r(2);
            }
            if ((iH9 & 4) != 0) {
                d7.r(2);
            }
            if (iH9 == 2) {
                d7.r(2);
            }
            int[] iArr = f16025b;
            i7 = iH7 < iArr.length ? iArr[iH7] : -1;
            i8 = f16027d[iH9] + (d7.g() ? 1 : 0);
            i9 = 1536;
            str = str2;
            i10 = i19;
        }
        return new C0171b(str, i16, i8, i7, iC, i9, i10);
    }

    public static int g(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b7 = bArr[4];
        return c((b7 & 192) >> 6, b7 & 63);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static B0.s h(E0.E r7, java.lang.String r8, java.lang.String r9, B0.C0313o r10) {
        /*
            E0.D r0 = new E0.D
            r0.<init>()
            r0.m(r7)
            r1 = 13
            int r1 = r0.h(r1)
            int r1 = r1 * 1000
            r2 = 3
            r0.r(r2)
            r3 = 2
            int r3 = r0.h(r3)
            int[] r4 = g1.AbstractC1072b.f16025b
            r3 = r4[r3]
            r4 = 10
            r0.r(r4)
            int[] r4 = g1.AbstractC1072b.f16027d
            int r5 = r0.h(r2)
            r4 = r4[r5]
            r5 = 1
            int r6 = r0.h(r5)
            if (r6 == 0) goto L33
            int r4 = r4 + 1
        L33:
            r0.r(r2)
            r2 = 4
            int r2 = r0.h(r2)
            r0.r(r5)
            if (r2 <= 0) goto L4f
            r2 = 6
            r0.r(r2)
            int r2 = r0.h(r5)
            if (r2 == 0) goto L4c
            int r4 = r4 + 2
        L4c:
            r0.r(r5)
        L4f:
            int r2 = r0.b()
            r6 = 7
            if (r2 <= r6) goto L62
            r0.r(r6)
            int r2 = r0.h(r5)
            if (r2 == 0) goto L62
            java.lang.String r2 = "audio/eac3-joc"
            goto L64
        L62:
            java.lang.String r2 = "audio/eac3"
        L64:
            r0.c()
            int r0 = r0.d()
            r7.f0(r0)
            B0.s$b r7 = new B0.s$b
            r7.<init>()
            B0.s$b r7 = r7.j0(r8)
            B0.s$b r7 = r7.y0(r2)
            B0.s$b r7 = r7.T(r4)
            B0.s$b r7 = r7.z0(r3)
            B0.s$b r7 = r7.c0(r10)
            B0.s$b r7 = r7.n0(r9)
            B0.s$b r7 = r7.t0(r1)
            B0.s r7 = r7.P()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.AbstractC1072b.h(E0.E, java.lang.String, java.lang.String, B0.o):B0.s");
    }

    public static int i(ByteBuffer byteBuffer, int i7) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i7) + ((byteBuffer.get((byteBuffer.position() + i7) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int j(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b7 = bArr[7];
            if ((b7 & 254) == 186) {
                return 40 << ((bArr[(b7 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }
}
