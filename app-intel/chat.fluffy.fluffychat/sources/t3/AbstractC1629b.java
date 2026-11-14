package t3;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.KeyAgreement;
import s3.AbstractC1603a;
import s3.AbstractC1604b;

/* renamed from: t3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1629b {

    /* renamed from: t3.b$a */
    public enum a {
        NIST_P256,
        NIST_P384,
        NIST_P521
    }

    /* renamed from: t3.b$b, reason: collision with other inner class name */
    public enum EnumC0270b {
        UNCOMPRESSED,
        COMPRESSED,
        DO_NOT_USE_CRUNCHY_UNCOMPRESSED
    }

    public static byte[] a(ECPrivateKey eCPrivateKey, ECPoint eCPoint) throws IllegalStateException, GeneralSecurityException {
        AbstractC1604b.a(eCPoint, eCPrivateKey.getParams().getCurve());
        PublicKey publicKeyGeneratePublic = ((KeyFactory) C1630c.f22572h.a("EC")).generatePublic(new ECPublicKeySpec(eCPoint, eCPrivateKey.getParams()));
        KeyAgreement keyAgreement = (KeyAgreement) C1630c.f22570f.a("ECDH");
        keyAgreement.init(eCPrivateKey);
        try {
            keyAgreement.doPhase(publicKeyGeneratePublic, true);
            byte[] bArrGenerateSecret = keyAgreement.generateSecret();
            o(bArrGenerateSecret, eCPrivateKey);
            return bArrGenerateSecret;
        } catch (IllegalStateException e7) {
            throw new GeneralSecurityException(e7);
        }
    }

    public static BigInteger b(BigInteger bigInteger, boolean z7, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger bigIntegerF = f(ellipticCurve);
        BigInteger bigIntegerJ = j(bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(bigIntegerF), bigIntegerF);
        return z7 != bigIntegerJ.testBit(0) ? bigIntegerF.subtract(bigIntegerJ).mod(bigIntegerF) : bigIntegerJ;
    }

    public static int c(EllipticCurve ellipticCurve) {
        return f(ellipticCurve).subtract(BigInteger.ONE).bitLength();
    }

    public static int d(EllipticCurve ellipticCurve) {
        return (c(ellipticCurve) + 7) / 8;
    }

    public static ECParameterSpec e(a aVar) throws NoSuchAlgorithmException {
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            return g();
        }
        if (iOrdinal == 1) {
            return h();
        }
        if (iOrdinal == 2) {
            return i();
        }
        throw new NoSuchAlgorithmException("curve not implemented:" + String.valueOf(aVar));
    }

    public static BigInteger f(EllipticCurve ellipticCurve) {
        return AbstractC1604b.b(ellipticCurve);
    }

    public static ECParameterSpec g() {
        return AbstractC1604b.f22415a;
    }

    public static ECParameterSpec h() {
        return AbstractC1604b.f22416b;
    }

    public static ECParameterSpec i() {
        return AbstractC1604b.f22417c;
    }

    public static BigInteger j(BigInteger bigInteger, BigInteger bigInteger2) throws GeneralSecurityException {
        BigInteger bigIntegerModPow;
        if (bigInteger2.signum() != 1) {
            throw new InvalidAlgorithmParameterException("p must be positive");
        }
        BigInteger bigIntegerMod = bigInteger.mod(bigInteger2);
        BigInteger bigInteger3 = BigInteger.ZERO;
        if (bigIntegerMod.equals(bigInteger3)) {
            return bigInteger3;
        }
        int i7 = 0;
        if (bigInteger2.testBit(0) && bigInteger2.testBit(1)) {
            bigIntegerModPow = bigIntegerMod.modPow(bigInteger2.add(BigInteger.ONE).shiftRight(2), bigInteger2);
        } else if (!bigInteger2.testBit(0) || bigInteger2.testBit(1)) {
            bigIntegerModPow = null;
        } else {
            BigInteger bigIntegerAdd = BigInteger.ONE;
            BigInteger bigIntegerShiftRight = bigInteger2.subtract(bigIntegerAdd).shiftRight(1);
            while (true) {
                BigInteger bigIntegerMod2 = bigIntegerAdd.multiply(bigIntegerAdd).subtract(bigIntegerMod).mod(bigInteger2);
                if (bigIntegerMod2.equals(BigInteger.ZERO)) {
                    return bigIntegerAdd;
                }
                BigInteger bigIntegerModPow2 = bigIntegerMod2.modPow(bigIntegerShiftRight, bigInteger2);
                BigInteger bigIntegerMod3 = BigInteger.ONE;
                if (bigIntegerModPow2.add(bigIntegerMod3).equals(bigInteger2)) {
                    BigInteger bigIntegerShiftRight2 = bigInteger2.add(bigIntegerMod3).shiftRight(1);
                    BigInteger bigIntegerMod4 = bigIntegerAdd;
                    for (int iBitLength = bigIntegerShiftRight2.bitLength() - 2; iBitLength >= 0; iBitLength--) {
                        BigInteger bigIntegerMultiply = bigIntegerMod4.multiply(bigIntegerMod3);
                        bigIntegerMod4 = bigIntegerMod4.multiply(bigIntegerMod4).add(bigIntegerMod3.multiply(bigIntegerMod3).mod(bigInteger2).multiply(bigIntegerMod2)).mod(bigInteger2);
                        BigInteger bigIntegerMod5 = bigIntegerMultiply.add(bigIntegerMultiply).mod(bigInteger2);
                        if (bigIntegerShiftRight2.testBit(iBitLength)) {
                            BigInteger bigIntegerMod6 = bigIntegerMod4.multiply(bigIntegerAdd).add(bigIntegerMod5.multiply(bigIntegerMod2)).mod(bigInteger2);
                            bigIntegerMod3 = bigIntegerAdd.multiply(bigIntegerMod5).add(bigIntegerMod4).mod(bigInteger2);
                            bigIntegerMod4 = bigIntegerMod6;
                        } else {
                            bigIntegerMod3 = bigIntegerMod5;
                        }
                    }
                    bigIntegerModPow = bigIntegerMod4;
                } else {
                    if (!bigIntegerModPow2.equals(bigIntegerMod3)) {
                        throw new InvalidAlgorithmParameterException("p is not prime");
                    }
                    bigIntegerAdd = bigIntegerAdd.add(bigIntegerMod3);
                    i7++;
                    if (i7 == 128 && !bigInteger2.isProbablePrime(80)) {
                        throw new InvalidAlgorithmParameterException("p is not prime");
                    }
                }
            }
        }
        if (bigIntegerModPow == null || bigIntegerModPow.multiply(bigIntegerModPow).mod(bigInteger2).compareTo(bigIntegerMod) == 0) {
            return bigIntegerModPow;
        }
        throw new GeneralSecurityException("Could not find a modular square root");
    }

    public static ECPoint k(EllipticCurve ellipticCurve, EnumC0270b enumC0270b, byte[] bArr) throws GeneralSecurityException {
        int iD = d(ellipticCurve);
        int iOrdinal = enumC0270b.ordinal();
        boolean z7 = false;
        if (iOrdinal == 0) {
            if (bArr.length != (iD * 2) + 1) {
                throw new GeneralSecurityException("invalid point size");
            }
            if (bArr[0] != 4) {
                throw new GeneralSecurityException("invalid point format");
            }
            int i7 = iD + 1;
            ECPoint eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i7)), new BigInteger(1, Arrays.copyOfRange(bArr, i7, bArr.length)));
            AbstractC1604b.a(eCPoint, ellipticCurve);
            return eCPoint;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                if (bArr.length != iD * 2) {
                    throw new GeneralSecurityException("invalid point size");
                }
                ECPoint eCPoint2 = new ECPoint(new BigInteger(1, Arrays.copyOf(bArr, iD)), new BigInteger(1, Arrays.copyOfRange(bArr, iD, bArr.length)));
                AbstractC1604b.a(eCPoint2, ellipticCurve);
                return eCPoint2;
            }
            throw new GeneralSecurityException("invalid format:" + String.valueOf(enumC0270b));
        }
        BigInteger bigIntegerF = f(ellipticCurve);
        if (bArr.length != iD + 1) {
            throw new GeneralSecurityException("compressed point has wrong length");
        }
        byte b7 = bArr[0];
        if (b7 != 2) {
            if (b7 != 3) {
                throw new GeneralSecurityException("invalid format");
            }
            z7 = true;
        }
        BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, bArr.length));
        if (bigInteger.signum() == -1 || bigInteger.compareTo(bigIntegerF) >= 0) {
            throw new GeneralSecurityException("x is out of range");
        }
        return new ECPoint(bigInteger, b(bigInteger, z7, ellipticCurve));
    }

    public static ECPoint l(a aVar, EnumC0270b enumC0270b, byte[] bArr) {
        return k(e(aVar).getCurve(), enumC0270b, bArr);
    }

    public static byte[] m(EllipticCurve ellipticCurve, EnumC0270b enumC0270b, ECPoint eCPoint) throws GeneralSecurityException {
        AbstractC1604b.a(eCPoint, ellipticCurve);
        int iD = d(ellipticCurve);
        int iOrdinal = enumC0270b.ordinal();
        if (iOrdinal == 0) {
            int i7 = (iD * 2) + 1;
            byte[] bArr = new byte[i7];
            byte[] bArrA = AbstractC1603a.a(eCPoint.getAffineX());
            byte[] bArrA2 = AbstractC1603a.a(eCPoint.getAffineY());
            System.arraycopy(bArrA2, 0, bArr, i7 - bArrA2.length, bArrA2.length);
            System.arraycopy(bArrA, 0, bArr, (iD + 1) - bArrA.length, bArrA.length);
            bArr[0] = 4;
            return bArr;
        }
        if (iOrdinal == 1) {
            int i8 = iD + 1;
            byte[] bArr2 = new byte[i8];
            byte[] bArrA3 = AbstractC1603a.a(eCPoint.getAffineX());
            System.arraycopy(bArrA3, 0, bArr2, i8 - bArrA3.length, bArrA3.length);
            bArr2[0] = (byte) (eCPoint.getAffineY().testBit(0) ? 3 : 2);
            return bArr2;
        }
        if (iOrdinal != 2) {
            throw new GeneralSecurityException("invalid format:" + String.valueOf(enumC0270b));
        }
        int i9 = iD * 2;
        byte[] bArr3 = new byte[i9];
        byte[] bArrA4 = AbstractC1603a.a(eCPoint.getAffineX());
        if (bArrA4.length > iD) {
            bArrA4 = Arrays.copyOfRange(bArrA4, bArrA4.length - iD, bArrA4.length);
        }
        byte[] bArrA5 = AbstractC1603a.a(eCPoint.getAffineY());
        if (bArrA5.length > iD) {
            bArrA5 = Arrays.copyOfRange(bArrA5, bArrA5.length - iD, bArrA5.length);
        }
        System.arraycopy(bArrA5, 0, bArr3, i9 - bArrA5.length, bArrA5.length);
        System.arraycopy(bArrA4, 0, bArr3, iD - bArrA4.length, bArrA4.length);
        return bArr3;
    }

    public static byte[] n(a aVar, EnumC0270b enumC0270b, ECPoint eCPoint) {
        return m(e(aVar).getCurve(), enumC0270b, eCPoint);
    }

    public static void o(byte[] bArr, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        EllipticCurve curve = eCPrivateKey.getParams().getCurve();
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.signum() == -1 || bigInteger.compareTo(f(curve)) >= 0) {
            throw new GeneralSecurityException("shared secret is out of range");
        }
        b(bigInteger, true, curve);
    }
}
