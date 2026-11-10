package E0;

import B0.C0308j;
import android.util.Pair;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k3.AbstractC1279v;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;

/* renamed from: E0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0322h {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f2160a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f2161b = {"", "A", "B", "C"};

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f2162c = Pattern.compile("^\\D?(\\d+)$");

    public static Pair A(String str, String[] strArr) throws NumberFormatException {
        if (strArr.length < 3) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int i7 = Integer.parseInt(strArr[1]);
            int i8 = Integer.parseInt(strArr[2]);
            int I6 = I(i7);
            if (I6 == -1) {
                AbstractC0332s.h("CodecSpecificDataUtil", "Unknown VP9 profile: " + i7);
                return null;
            }
            int iH = H(i8);
            if (iH != -1) {
                return new Pair(Integer.valueOf(I6), Integer.valueOf(iH));
            }
            AbstractC0332s.h("CodecSpecificDataUtil", "Unknown VP9 level: " + i8);
            return null;
        } catch (NumberFormatException unused) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    public static Integer B(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    public static boolean C(byte[] bArr, int i7) {
        if (bArr.length - i7 <= f2160a.length) {
            return false;
        }
        int i8 = 0;
        while (true) {
            byte[] bArr2 = f2160a;
            if (i8 >= bArr2.length) {
                return true;
            }
            if (bArr[i7 + i8] != bArr2[i8]) {
                return false;
            }
            i8++;
        }
    }

    public static int D(int i7) {
        int i8 = 17;
        if (i7 != 17) {
            i8 = 20;
            if (i7 != 20) {
                i8 = 23;
                if (i7 != 23) {
                    i8 = 29;
                    if (i7 != 29) {
                        i8 = 39;
                        if (i7 != 39) {
                            i8 = 42;
                            if (i7 != 42) {
                                switch (i7) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i8;
    }

    public static int[] E(byte[] bArr) {
        E e7 = new E(bArr);
        e7.f0(5);
        int iQ = e7.Q();
        e7.f0(9);
        int iQ2 = e7.Q();
        e7.f0(20);
        return new int[]{e7.U(), iQ2, iQ};
    }

    public static boolean F(List list) {
        return list.size() == 1 && ((byte[]) list.get(0)).length == 1 && ((byte[]) list.get(0))[0] == 1;
    }

    public static byte[][] G(byte[] bArr) {
        if (!C(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iO = 0;
        do {
            arrayList.add(Integer.valueOf(iO));
            iO = o(bArr, iO + f2160a.length);
        } while (iO != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i7 = 0;
        while (i7 < arrayList.size()) {
            int iIntValue = ((Integer) arrayList.get(i7)).intValue();
            int iIntValue2 = (i7 < arrayList.size() + (-1) ? ((Integer) arrayList.get(i7 + 1)).intValue() : bArr.length) - iIntValue;
            byte[] bArr3 = new byte[iIntValue2];
            System.arraycopy(bArr, iIntValue, bArr3, 0, iIntValue2);
            bArr2[i7] = bArr3;
            i7++;
        }
        return bArr2;
    }

    public static int H(int i7) {
        if (i7 == 10) {
            return 1;
        }
        if (i7 == 11) {
            return 2;
        }
        if (i7 == 20) {
            return 4;
        }
        if (i7 == 21) {
            return 8;
        }
        if (i7 == 30) {
            return 16;
        }
        if (i7 == 31) {
            return 32;
        }
        if (i7 == 40) {
            return 64;
        }
        if (i7 == 41) {
            return 128;
        }
        if (i7 == 50) {
            return 256;
        }
        if (i7 == 51) {
            return 512;
        }
        switch (i7) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    public static int I(int i7) {
        if (i7 == 0) {
            return 1;
        }
        if (i7 == 1) {
            return 2;
        }
        if (i7 != 2) {
            return i7 != 3 ? -1 : 8;
        }
        return 4;
    }

    public static int a(int i7, int i8) {
        if (i7 == 0) {
            return i8 == 0 ? 257 : -1;
        }
        if (i7 == 1) {
            if (i8 == 0) {
                return 513;
            }
            return i8 == 1 ? 514 : -1;
        }
        if (i7 != 2) {
            return -1;
        }
        if (i8 == 1) {
            return 1026;
        }
        return i8 == 2 ? 1028 : -1;
    }

    public static int b(int i7) {
        if (i7 == 0) {
            return 1;
        }
        if (i7 == 1) {
            return 2;
        }
        if (i7 == 2) {
            return 4;
        }
        if (i7 != 3) {
            return i7 != 4 ? -1 : 16;
        }
        return 8;
    }

    public static int c(int i7) {
        switch (i7) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case StdKeyDeserializer.TYPE_URL /* 14 */:
                return 16384;
            case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                return PeerConnection.PORTALLOCATOR_ENABLE_ANY_ADDRESS_PORTS;
            case 16:
                return 65536;
            case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    public static int d(int i7) {
        switch (i7) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i7) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i7) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                                return 1024;
                            default:
                                switch (i7) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i7) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return PeerConnection.PORTALLOCATOR_ENABLE_ANY_ADDRESS_PORTS;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    public static int e(int i7) {
        if (i7 == 66) {
            return 1;
        }
        if (i7 == 77) {
            return 2;
        }
        if (i7 == 88) {
            return 4;
        }
        if (i7 == 100) {
            return 8;
        }
        if (i7 == 110) {
            return 16;
        }
        if (i7 != 122) {
            return i7 != 244 ? -1 : 64;
        }
        return 32;
    }

    public static String f(byte[] bArr) {
        j3.o.g(bArr.length >= 17, "Invalid APV CSD length: %s", bArr.length);
        byte b7 = bArr[0];
        j3.o.g(b7 == 1, "Invalid APV CSD version: %s", b7);
        return U.G("apv1.apvf%d.apvl%d.apvb%d", Integer.valueOf(bArr[5]), Integer.valueOf(bArr[6]), Integer.valueOf(bArr[7]));
    }

    public static String g(int i7, int i8, int i9) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
    }

    public static List h(boolean z7) {
        return Collections.singletonList(z7 ? new byte[]{1} : new byte[]{0});
    }

    public static String i(int i7, boolean z7, int i8, int i9, int[] iArr, int i10) {
        StringBuilder sb = new StringBuilder(U.G("hvc1.%s%d.%X.%c%d", f2161b[i7], Integer.valueOf(i8), Integer.valueOf(i9), Character.valueOf(z7 ? 'H' : 'L'), Integer.valueOf(i10)));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i11 = 0; i11 < length; i11++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i11])));
        }
        return sb.toString();
    }

    public static String j(byte[] bArr) {
        E e7 = new E(bArr);
        String strG = null;
        String strN = null;
        while (e7.a() > 0 && (strG == null || strN == null)) {
            int iQ = e7.Q();
            int i7 = iQ >> 3;
            boolean z7 = (iQ & 2) != 0;
            boolean z8 = (iQ & 1) != 0;
            int iV = e7.V();
            if (i7 > 4 && i7 < 24 && z7) {
                e7.h0();
                e7.h0();
            }
            if (z8) {
                e7.g0(e7.V());
            }
            int iG = e7.g() + iV;
            if (i7 == 31) {
                e7.g0(4);
                strG = U.G("iamf.%03X.%03X", Integer.valueOf(e7.Q()), Integer.valueOf(e7.Q()));
            } else if (i7 == 0) {
                e7.h0();
                strN = e7.N(4);
                if (strN.equals("mp4a")) {
                    e7.h0();
                    e7.g0(2);
                    D d7 = new D();
                    d7.m(e7);
                    int iH = d7.h(5);
                    if (iH == 31) {
                        iH = d7.h(6) + 32;
                    }
                    strN = strN + ".40." + iH;
                }
            }
            e7.f0(iG);
        }
        if (strG == null || strN == null) {
            return null;
        }
        return strG + "." + strN;
    }

    public static byte[] k(byte[] bArr, int i7, int i8) {
        byte[] bArr2 = f2160a;
        byte[] bArr3 = new byte[bArr2.length + i8];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i7, bArr3, bArr2.length, i8);
        return bArr3;
    }

    public static AbstractC1279v l(byte b7, byte b8, byte b9, byte b10) {
        return AbstractC1279v.w(new byte[]{1, 1, b7, 2, 1, b8, 3, 1, b9, 4, 1, b10});
    }

    public static Integer m(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    public static Integer n(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    public static int o(byte[] bArr, int i7) {
        int length = bArr.length - f2160a.length;
        while (i7 <= length) {
            if (C(bArr, i7)) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static Pair p(String str, String[] strArr) {
        int iD;
        if (strArr.length != 3) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(B0.z.h(Integer.parseInt(strArr[1], 16))) && (iD = D(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair(Integer.valueOf(iD), 0);
            }
        } catch (NumberFormatException unused) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    public static Pair q(String str, String[] strArr) throws NumberFormatException {
        if (strArr.length != 4) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed AC-4 codec string: " + str);
            return null;
        }
        try {
            int i7 = Integer.parseInt(strArr[1]);
            int i8 = Integer.parseInt(strArr[2]);
            int i9 = Integer.parseInt(strArr[3]);
            int iA = a(i7, i8);
            if (iA == -1) {
                AbstractC0332s.h("CodecSpecificDataUtil", "Unknown AC-4 profile: " + i7 + "." + i8);
                return null;
            }
            int iB = b(i9);
            if (iB != -1) {
                return new Pair(Integer.valueOf(iA), Integer.valueOf(iB));
            }
            AbstractC0332s.h("CodecSpecificDataUtil", "Unknown AC-4 level: " + i9);
            return null;
        } catch (NumberFormatException unused) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed AC-4 codec string: " + str);
            return null;
        }
    }

    public static Pair r(String str, String[] strArr) throws NumberFormatException {
        int i7;
        if (strArr.length < 4) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed APV codec string: " + str);
            return null;
        }
        try {
            int i8 = Integer.parseInt(strArr[1].substring(4));
            int i9 = Integer.parseInt(strArr[2].substring(4));
            int i10 = Integer.parseInt(strArr[3].substring(4));
            if (i8 == 33) {
                i7 = 1;
            } else {
                if (i8 != 44) {
                    AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring invalid APV profile: " + i8);
                    return null;
                }
                i7 = 8192;
            }
            int i11 = (i9 / 30) * 2;
            if (i9 % 30 == 0) {
                i11--;
            }
            return new Pair(Integer.valueOf(i7), Integer.valueOf((1 << i10) | (256 << (i11 - 1))));
        } catch (NumberFormatException e7) {
            AbstractC0332s.i("CodecSpecificDataUtil", "Ignoring malformed APV codec string: " + str, e7);
            return null;
        }
    }

    public static Pair s(String str, String[] strArr, C0308j c0308j) throws NumberFormatException {
        int i7;
        if (strArr.length < 4) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        try {
            int i8 = Integer.parseInt(strArr[1]);
            int i9 = Integer.parseInt(strArr[2].substring(0, 2));
            int i10 = Integer.parseInt(strArr[3]);
            if (i8 != 0) {
                AbstractC0332s.h("CodecSpecificDataUtil", "Unknown AV1 profile: " + i8);
                return null;
            }
            if (i10 != 8 && i10 != 10) {
                AbstractC0332s.h("CodecSpecificDataUtil", "Unknown AV1 bit depth: " + i10);
                return null;
            }
            int i11 = i10 != 8 ? (c0308j == null || !(c0308j.f654d != null || (i7 = c0308j.f653c) == 7 || i7 == 6)) ? 2 : 4096 : 1;
            int iC = c(i9);
            if (iC != -1) {
                return new Pair(Integer.valueOf(i11), Integer.valueOf(iC));
            }
            AbstractC0332s.h("CodecSpecificDataUtil", "Unknown AV1 level: " + i9);
            return null;
        } catch (NumberFormatException unused) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    public static Pair t(String str, String[] strArr) throws NumberFormatException {
        int i7;
        int i8;
        if (strArr.length < 2) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i8 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i7 = Integer.parseInt(strArr[1].substring(4), 16);
            } else {
                if (strArr.length < 3) {
                    AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                int i9 = Integer.parseInt(strArr[1]);
                i7 = Integer.parseInt(strArr[2]);
                i8 = i9;
            }
            int iE = e(i8);
            if (iE == -1) {
                AbstractC0332s.h("CodecSpecificDataUtil", "Unknown AVC profile: " + i8);
                return null;
            }
            int iD = d(i7);
            if (iD != -1) {
                return new Pair(Integer.valueOf(iE), Integer.valueOf(iD));
            }
            AbstractC0332s.h("CodecSpecificDataUtil", "Unknown AVC level: " + i7);
            return null;
        } catch (NumberFormatException unused) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair u(B0.s r6) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: E0.AbstractC0322h.u(B0.s):android.util.Pair");
    }

    public static Pair v(String str, String[] strArr) {
        if (strArr.length < 3) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = f2162c.matcher(strArr[1]);
        if (!matcher.matches()) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer numN = n(strGroup);
        if (numN == null) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Unknown Dolby Vision profile string: " + strGroup);
            return null;
        }
        String str2 = strArr[2];
        Integer numM = m(str2);
        if (numM != null) {
            return new Pair(numN, numM);
        }
        AbstractC0332s.h("CodecSpecificDataUtil", "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    public static Pair w(String str, String[] strArr) throws NumberFormatException {
        Pair pair = new Pair(1, 1);
        if (strArr.length < 3) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed H263 codec string: " + str);
            return pair;
        }
        try {
            return new Pair(Integer.valueOf(Integer.parseInt(strArr[1])), Integer.valueOf(Integer.parseInt(strArr[2])));
        } catch (NumberFormatException unused) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed H263 codec string: " + str);
            return pair;
        }
    }

    public static Pair x(String str, String[] strArr, C0308j c0308j) {
        if (strArr.length < 4) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i7 = 1;
        Matcher matcher = f2162c.matcher(strArr[1]);
        if (!matcher.matches()) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        if (!"1".equals(strGroup)) {
            i7 = 6;
            if ("2".equals(strGroup)) {
                i7 = (c0308j == null || c0308j.f653c != 6) ? 2 : 4096;
            } else if (!"6".equals(strGroup)) {
                AbstractC0332s.h("CodecSpecificDataUtil", "Unknown HEVC profile string: " + strGroup);
                return null;
            }
        }
        String str2 = strArr[3];
        Integer numB = B(str2);
        if (numB != null) {
            return new Pair(Integer.valueOf(i7), numB);
        }
        AbstractC0332s.h("CodecSpecificDataUtil", "Unknown HEVC level string: " + str2);
        return null;
    }

    public static Pair y(String str, String[] strArr) {
        int i7 = 4;
        if (strArr.length < 4) {
            AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring malformed IAMF codec string: " + str);
            return null;
        }
        try {
            int i8 = 1 << (Integer.parseInt(strArr[1]) + 16);
            String str2 = strArr[3];
            str2.getClass();
            switch (str2) {
                case "Opus":
                    i7 = 1;
                    break;
                case "fLaC":
                    break;
                case "ipcm":
                    i7 = 8;
                    break;
                case "mp4a":
                    i7 = 2;
                    break;
                default:
                    AbstractC0332s.h("CodecSpecificDataUtil", "Ignoring unknown codec identifier for IAMF auxiliary profile: " + strArr[3]);
                    return null;
            }
            return new Pair(Integer.valueOf(16777216 | i8 | i7), 0);
        } catch (NumberFormatException e7) {
            AbstractC0332s.i("CodecSpecificDataUtil", "Ignoring malformed primary profile in IAMF codec string: " + strArr[1], e7);
            return null;
        }
    }

    public static Pair z(byte[] bArr) {
        boolean z7;
        E e7 = new E(bArr);
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = i8 + 3;
            if (i9 >= bArr.length) {
                z7 = false;
                break;
            }
            if (e7.T() == 1 && (bArr[i9] & 240) == 32) {
                z7 = true;
                break;
            }
            e7.f0(e7.g() - 2);
            i8++;
        }
        j3.o.e(z7, "Invalid input: VOL not found.");
        D d7 = new D(bArr);
        d7.r((i8 + 4) * 8);
        d7.r(1);
        d7.r(8);
        if (d7.g()) {
            d7.r(4);
            d7.r(3);
        }
        if (d7.h(4) == 15) {
            d7.r(8);
            d7.r(8);
        }
        if (d7.g()) {
            d7.r(2);
            d7.r(1);
            if (d7.g()) {
                d7.r(79);
            }
        }
        j3.o.e(d7.h(2) == 0, "Only supports rectangular video object layer shape.");
        j3.o.d(d7.g());
        int iH = d7.h(16);
        j3.o.d(d7.g());
        if (d7.g()) {
            j3.o.d(iH > 0);
            for (int i10 = iH - 1; i10 > 0; i10 >>= 1) {
                i7++;
            }
            d7.r(i7);
        }
        j3.o.d(d7.g());
        int iH2 = d7.h(13);
        j3.o.d(d7.g());
        int iH3 = d7.h(13);
        j3.o.d(d7.g());
        d7.r(1);
        return Pair.create(Integer.valueOf(iH2), Integer.valueOf(iH3));
    }
}
