package N1;

import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;

/* loaded from: classes.dex */
public abstract class v {

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f6323a;

        /* renamed from: b, reason: collision with root package name */
        public long f6324b;

        /* renamed from: c, reason: collision with root package name */
        public int f6325c;
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f6326a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6327b;

        /* renamed from: c, reason: collision with root package name */
        public final int f6328c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f6329d;

        public c(int i7, int i8, int i9, byte[] bArr) {
            this.f6326a = i7;
            this.f6327b = i8;
            this.f6328c = i9;
            this.f6329d = bArr;
        }
    }

    public static int a(int i7) throws B0.A {
        if (i7 == 0) {
            return 768;
        }
        if (i7 == 1) {
            return 1024;
        }
        if (i7 == 2 || i7 == 3) {
            return 2048;
        }
        if (i7 == 4) {
            return 4096;
        }
        throw B0.A.e("Unsupported coreSbrFrameLengthIndex " + i7);
    }

    public static double b(int i7) throws B0.A {
        switch (i7) {
            case 14700:
            case 16000:
                return 3.0d;
            case 22050:
            case 24000:
                return 2.0d;
            case 29400:
            case 32000:
            case 58800:
            case 64000:
                return 1.5d;
            case 44100:
            case 48000:
            case 88200:
            case 96000:
                return 1.0d;
            default:
                throw B0.A.e("Unsupported sampling rate " + i7);
        }
    }

    public static int c(int i7) throws B0.A {
        switch (i7) {
            case 0:
                return 96000;
            case 1:
                return 88200;
            case 2:
                return 64000;
            case 3:
                return 48000;
            case 4:
                return 44100;
            case 5:
                return 32000;
            case 6:
                return 24000;
            case 7:
                return 22050;
            case 8:
                return 16000;
            case 9:
                return 12000;
            case 10:
                return 11025;
            case 11:
                return 8000;
            case 12:
                return 7350;
            case 13:
            case StdKeyDeserializer.TYPE_URL /* 14 */:
            default:
                throw B0.A.e("Unsupported sampling rate index " + i7);
            case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                return 57600;
            case 16:
                return 51200;
            case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                return 40000;
            case 18:
                return 38400;
            case 19:
                return 34150;
            case 20:
                return 28800;
            case 21:
                return 25600;
            case 22:
                return 20000;
            case 23:
                return 19200;
            case 24:
                return 17075;
            case 25:
                return 14400;
            case 26:
                return 12800;
            case 27:
                return 9600;
        }
    }

    public static int d(int i7) throws B0.A {
        if (i7 == 0 || i7 == 1) {
            return 0;
        }
        int i8 = 2;
        if (i7 != 2) {
            i8 = 3;
            if (i7 != 3) {
                if (i7 == 4) {
                    return 1;
                }
                throw B0.A.e("Unsupported coreSbrFrameLengthIndex " + i7);
            }
        }
        return i8;
    }

    public static boolean e(int i7) {
        return (i7 & 16777215) == 12583333;
    }

    public static int f(E0.D d7) {
        if (!d7.g()) {
            return 0;
        }
        d7.r(2);
        return d7.h(13);
    }

    public static boolean g(E0.D d7, b bVar) throws B0.A {
        d7.d();
        int iK = k(d7, 3, 8, 8);
        bVar.f6323a = iK;
        if (iK == -1) {
            return false;
        }
        long jL = l(d7, 2, 8, 32);
        bVar.f6324b = jL;
        if (jL == -1) {
            return false;
        }
        if (jL > 16) {
            throw B0.A.e("Contains sub-stream with an invalid packet label " + bVar.f6324b);
        }
        if (jL == 0) {
            int i7 = bVar.f6323a;
            if (i7 == 1) {
                throw B0.A.a("Mpegh3daConfig packet with invalid packet label 0", null);
            }
            if (i7 == 2) {
                throw B0.A.a("Mpegh3daFrame packet with invalid packet label 0", null);
            }
            if (i7 == 17) {
                throw B0.A.a("AudioTruncation packet with invalid packet label 0", null);
            }
        }
        int iK2 = k(d7, 11, 24, 24);
        bVar.f6325c = iK2;
        return iK2 != -1;
    }

    public static c h(E0.D d7) throws B0.A {
        int iH = d7.h(8);
        int iH2 = d7.h(5);
        int iH3 = iH2 == 31 ? d7.h(24) : c(iH2);
        int iH4 = d7.h(3);
        int iA = a(iH4);
        int iD = d(iH4);
        d7.r(2);
        p(d7);
        m(d7, j(d7), iD);
        byte[] bArr = null;
        if (d7.g()) {
            int iK = k(d7, 2, 4, 8) + 1;
            for (int i7 = 0; i7 < iK; i7++) {
                int iK2 = k(d7, 4, 8, 16);
                int iK3 = k(d7, 4, 8, 16);
                if (iK2 == 7) {
                    int iH5 = d7.h(4) + 1;
                    d7.r(4);
                    byte[] bArr2 = new byte[iH5];
                    for (int i8 = 0; i8 < iH5; i8++) {
                        bArr2[i8] = (byte) d7.h(8);
                    }
                    bArr = bArr2;
                } else {
                    d7.r(iK3 * 8);
                }
            }
        }
        byte[] bArr3 = bArr;
        double dB = b(iH3);
        return new c(iH, (int) (iH3 * dB), (int) (iA * dB), bArr3);
    }

    public static boolean i(E0.D d7) {
        d7.r(3);
        boolean zG = d7.g();
        if (zG) {
            d7.r(13);
        }
        return zG;
    }

    public static int j(E0.D d7) {
        int iH = d7.h(5);
        int iK = 0;
        for (int i7 = 0; i7 < iH + 1; i7++) {
            int iH2 = d7.h(3);
            iK += k(d7, 5, 8, 16) + 1;
            if ((iH2 == 0 || iH2 == 2) && d7.g()) {
                p(d7);
            }
        }
        return iK;
    }

    public static int k(E0.D d7, int i7, int i8, int i9) {
        j3.o.d(Math.max(Math.max(i7, i8), i9) <= 31);
        int i10 = (1 << i7) - 1;
        int i11 = (1 << i8) - 1;
        m3.d.a(m3.d.a(i10, i11), 1 << i9);
        if (d7.b() < i7) {
            return -1;
        }
        int iH = d7.h(i7);
        if (iH != i10) {
            return iH;
        }
        if (d7.b() < i8) {
            return -1;
        }
        int iH2 = d7.h(i8);
        int i12 = iH + iH2;
        if (iH2 != i11) {
            return i12;
        }
        if (d7.b() < i9) {
            return -1;
        }
        return i12 + d7.h(i9);
    }

    public static long l(E0.D d7, int i7, int i8, int i9) {
        j3.o.d(Math.max(Math.max(i7, i8), i9) <= 63);
        long j7 = (1 << i7) - 1;
        long j8 = (1 << i8) - 1;
        m3.e.a(m3.e.a(j7, j8), 1 << i9);
        if (d7.b() < i7) {
            return -1L;
        }
        long j9 = d7.j(i7);
        if (j9 != j7) {
            return j9;
        }
        if (d7.b() < i8) {
            return -1L;
        }
        long j10 = d7.j(i8);
        long j11 = j9 + j10;
        if (j10 != j8) {
            return j11;
        }
        if (d7.b() < i9) {
            return -1L;
        }
        return j11 + d7.j(i9);
    }

    public static void m(E0.D d7, int i7, int i8) {
        int iH;
        int iK = k(d7, 4, 8, 16) + 1;
        d7.q();
        for (int i9 = 0; i9 < iK; i9++) {
            int iH2 = d7.h(2);
            if (iH2 == 0) {
                i(d7);
                if (i8 > 0) {
                    o(d7);
                }
            } else if (iH2 == 1) {
                if (i(d7)) {
                    d7.q();
                }
                if (i8 > 0) {
                    o(d7);
                    iH = d7.h(2);
                } else {
                    iH = 0;
                }
                if (iH > 0) {
                    d7.r(6);
                    int iH3 = d7.h(2);
                    d7.r(4);
                    if (d7.g()) {
                        d7.r(5);
                    }
                    if (iH == 2 || iH == 3) {
                        d7.r(6);
                    }
                    if (iH3 == 2) {
                        d7.q();
                    }
                }
                int iFloor = ((int) Math.floor(Math.log(i7 - 1) / Math.log(2.0d))) + 1;
                int iH4 = d7.h(2);
                if (iH4 > 0 && d7.g()) {
                    d7.r(iFloor);
                }
                if (d7.g()) {
                    d7.r(iFloor);
                }
                if (i8 == 0 && iH4 == 0) {
                    d7.q();
                }
            } else if (iH2 == 3) {
                k(d7, 4, 8, 16);
                int iK2 = k(d7, 4, 8, 16);
                if (d7.g()) {
                    k(d7, 8, 16, 0);
                }
                d7.q();
                if (iK2 > 0) {
                    d7.r(iK2 * 8);
                }
            }
        }
    }

    public static void n(E0.D d7, int i7) {
        int iH;
        boolean zG = d7.g();
        int i8 = zG ? 1 : 5;
        int i9 = zG ? 7 : 5;
        int i10 = zG ? 8 : 6;
        int i11 = 0;
        while (i11 < i7) {
            if (d7.g()) {
                d7.r(7);
                iH = 0;
            } else {
                if (d7.h(2) == 3 && d7.h(i9) * i8 != 0) {
                    d7.q();
                }
                iH = d7.h(i10) * i8;
                if (iH != 0 && iH != 180) {
                    d7.q();
                }
                d7.q();
            }
            if (iH != 0 && iH != 180 && d7.g()) {
                i11++;
            }
            i11++;
        }
    }

    public static void o(E0.D d7) {
        d7.r(3);
        d7.r(8);
        boolean zG = d7.g();
        boolean zG2 = d7.g();
        if (zG) {
            d7.r(5);
        }
        if (zG2) {
            d7.r(6);
        }
    }

    public static void p(E0.D d7) {
        int iH = d7.h(2);
        if (iH == 0) {
            d7.r(6);
            return;
        }
        int iK = k(d7, 5, 8, 16) + 1;
        if (iH == 1) {
            d7.r(iK * 7);
        } else if (iH == 2) {
            n(d7, iK);
        }
    }
}
