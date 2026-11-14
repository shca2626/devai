package D6;

import M5.m;
import android.util.Base64;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import t3.AbstractC1629b;

/* loaded from: classes3.dex */
public abstract class a {
    public static final byte[] a(String str) {
        m.e(str, "<this>");
        byte[] bArrDecode = Base64.decode(str, 11);
        m.d(bArrDecode, "decode(...)");
        return bArrDecode;
    }

    public static final String b(byte[] bArr) {
        m.e(bArr, "<this>");
        String strEncodeToString = Base64.encodeToString(bArr, 11);
        m.d(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    public static final ECPublicKey c(String str) throws InvalidKeySpecException, NoSuchAlgorithmException {
        m.e(str, "<this>");
        AbstractC1629b.a aVar = AbstractC1629b.a.NIST_P256;
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(AbstractC1629b.l(aVar, AbstractC1629b.EnumC0270b.UNCOMPRESSED, a(str)), AbstractC1629b.e(aVar)));
        m.c(publicKeyGeneratePublic, "null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
        return (ECPublicKey) publicKeyGeneratePublic;
    }

    public static final String d(ECPublicKey eCPublicKey) {
        m.e(eCPublicKey, "<this>");
        byte[] bArrN = AbstractC1629b.n(AbstractC1629b.a.NIST_P256, AbstractC1629b.EnumC0270b.UNCOMPRESSED, eCPublicKey.getW());
        m.d(bArrN, "pointEncode(...)");
        return b(bArrN);
    }
}
