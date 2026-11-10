package g1;

import E0.AbstractC0332s;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;

/* renamed from: g1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1071a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f16019a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f16020b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* renamed from: g1.a$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f16021a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16022b;

        /* renamed from: c, reason: collision with root package name */
        public final String f16023c;

        public b(int i7, int i8, String str) {
            this.f16021a = i7;
            this.f16022b = i8;
            this.f16023c = str;
        }
    }

    public static byte[] a(int i7, int i8) {
        int i9 = 0;
        int i10 = -1;
        int i11 = 0;
        while (true) {
            int[] iArr = f16019a;
            if (i11 >= iArr.length) {
                break;
            }
            if (i7 == iArr[i11]) {
                i10 = i11;
            }
            i11++;
        }
        int i12 = -1;
        while (true) {
            int[] iArr2 = f16020b;
            if (i9 >= iArr2.length) {
                break;
            }
            if (i8 == iArr2[i9]) {
                i12 = i9;
            }
            i9++;
        }
        if (i7 != -1 && i12 != -1) {
            return b(2, i10, i12);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i7 + ", " + i8);
    }

    public static byte[] b(int i7, int i8, int i9) {
        return new byte[]{(byte) (((i7 << 3) & 248) | ((i8 >> 1) & 7)), (byte) (((i8 << 7) & 128) | ((i9 << 3) & 120))};
    }

    public static int c(E0.D d7) {
        int iH = d7.h(5);
        return iH == 31 ? d7.h(6) + 32 : iH;
    }

    public static int d(E0.D d7) throws B0.A {
        int iH = d7.h(4);
        if (iH == 15) {
            if (d7.b() >= 24) {
                return d7.h(24);
            }
            throw B0.A.a("AAC header insufficient data", null);
        }
        if (iH < 13) {
            return f16019a[iH];
        }
        throw B0.A.a("AAC header wrong Sampling Frequency Index", null);
    }

    public static b e(E0.D d7, boolean z7) throws B0.A {
        int iC = c(d7);
        int iD = d(d7);
        int iH = d7.h(4);
        String str = "mp4a.40." + iC;
        if (iC == 5 || iC == 29) {
            iD = d(d7);
            iC = c(d7);
            if (iC == 22) {
                iH = d7.h(4);
            }
        }
        if (z7) {
            if (iC != 1 && iC != 2 && iC != 3 && iC != 4 && iC != 6 && iC != 7 && iC != 17) {
                switch (iC) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw B0.A.e("Unsupported audio object type: " + iC);
                }
            }
            g(d7, iC, iH);
            switch (iC) {
                case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iH2 = d7.h(2);
                    if (iH2 == 2 || iH2 == 3) {
                        throw B0.A.e("Unsupported epConfig: " + iH2);
                    }
            }
        }
        int i7 = f16020b[iH];
        if (i7 != -1) {
            return new b(iD, i7, str);
        }
        throw B0.A.a(null, null);
    }

    public static b f(byte[] bArr) {
        return e(new E0.D(bArr), false);
    }

    public static void g(E0.D d7, int i7, int i8) {
        if (d7.g()) {
            AbstractC0332s.h("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (d7.g()) {
            d7.r(14);
        }
        boolean zG = d7.g();
        if (i8 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i7 == 6 || i7 == 20) {
            d7.r(3);
        }
        if (zG) {
            if (i7 == 22) {
                d7.r(16);
            }
            if (i7 == 17 || i7 == 19 || i7 == 20 || i7 == 23) {
                d7.r(3);
            }
            d7.r(1);
        }
    }
}
