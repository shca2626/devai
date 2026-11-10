package y5;

import java.util.Collection;

/* renamed from: y5.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1819n implements Collection, N5.a {
    public static byte[] f(int i7) {
        return g(new byte[i7]);
    }

    public static byte[] g(byte[] bArr) {
        M5.m.e(bArr, "storage");
        return bArr;
    }

    public static final byte h(byte[] bArr, int i7) {
        return AbstractC1818m.a(bArr[i7]);
    }

    public static int i(byte[] bArr) {
        return bArr.length;
    }

    public static final void j(byte[] bArr, int i7, byte b7) {
        bArr[i7] = b7;
    }
}
