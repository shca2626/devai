package q3;

import t3.AbstractC1629a;
import t3.f;

/* renamed from: q3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1497c {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return f.a("HMACSHA256", bArr, bArr2, AbstractC1495a.f21412c, 16);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        return f.a("HMACSHA256", bArr, bArr2, AbstractC1629a.a(AbstractC1495a.f21411b, bArr3, bArr4), 32);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        return f.a("HMACSHA256", bArr, bArr2, AbstractC1495a.f21413d, 12);
    }
}
