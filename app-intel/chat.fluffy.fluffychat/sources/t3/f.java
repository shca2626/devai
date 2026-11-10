package t3;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public abstract class f {
    public static byte[] a(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, int i7) throws IllegalStateException, GeneralSecurityException {
        Mac mac = (Mac) C1631c.f22561c.a(str);
        if (i7 > mac.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        if (bArr2 == null || bArr2.length == 0) {
            mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
        } else {
            mac.init(new SecretKeySpec(bArr2, str));
        }
        byte[] bArr4 = new byte[i7];
        mac.init(new SecretKeySpec(mac.doFinal(bArr), str));
        byte[] bArrDoFinal = new byte[0];
        int i8 = 1;
        int length = 0;
        while (true) {
            mac.update(bArrDoFinal);
            mac.update(bArr3);
            mac.update((byte) i8);
            bArrDoFinal = mac.doFinal();
            if (bArrDoFinal.length + length >= i7) {
                System.arraycopy(bArrDoFinal, 0, bArr4, length, i7 - length);
                return bArr4;
            }
            System.arraycopy(bArrDoFinal, 0, bArr4, length, bArrDoFinal.length);
            length += bArrDoFinal.length;
            i8++;
        }
    }
}
