package s3;

import java.math.BigInteger;

/* renamed from: s3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1604a {
    public static byte[] a(BigInteger bigInteger) {
        if (bigInteger.signum() != -1) {
            return bigInteger.toByteArray();
        }
        throw new IllegalArgumentException("n must not be negative");
    }
}
