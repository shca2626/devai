package q3;

import t3.AbstractC1628a;
import t3.f;

/* renamed from: q3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1496c {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return f.a("HMACSHA256", bArr, bArr2, AbstractC1494a.f21418c, 16);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        return f.a("HMACSHA256", bArr, bArr2, AbstractC1628a.a(AbstractC1494a.f21417b, bArr3, bArr4), 32);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        return f.a("HMACSHA256", bArr, bArr2, AbstractC1494a.f21419d, 12);
    }
}
