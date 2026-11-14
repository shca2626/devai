package g1;

import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import java.io.EOFException;

/* renamed from: g1.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1090t {
    public static void a(boolean z7, String str) throws B0.A {
        if (!z7) {
            throw B0.A.a(str, null);
        }
    }

    public static int b(int i7) {
        if (i7 == 20) {
            return 63750;
        }
        if (i7 == 30) {
            return 2250000;
        }
        switch (i7) {
            case 5:
                return 80000;
            case 6:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            default:
                switch (i7) {
                    case StdKeyDeserializer.TYPE_URL /* 14 */:
                        return 3062500;
                    case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                        return 8000;
                    case 16:
                        return 256000;
                    case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                        return 336000;
                    case 18:
                        return 768000;
                    default:
                        return -2147483647;
                }
        }
    }

    public static boolean c(r rVar, byte[] bArr, int i7, int i8, boolean z7) throws EOFException {
        try {
            return rVar.h(bArr, i7, i8, z7);
        } catch (EOFException e7) {
            if (z7) {
                return false;
            }
            throw e7;
        }
    }

    public static int d(r rVar, byte[] bArr, int i7, int i8) {
        int i9 = 0;
        while (i9 < i8) {
            int iM = rVar.m(bArr, i7 + i9, i8 - i9);
            if (iM == -1) {
                break;
            }
            i9 += iM;
        }
        return i9;
    }

    public static boolean e(r rVar, byte[] bArr, int i7, int i8) {
        try {
            rVar.readFully(bArr, i7, i8);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean f(r rVar, int i7) {
        try {
            rVar.p(i7);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
