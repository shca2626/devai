package m3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/* renamed from: m3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1330a {

    /* renamed from: a, reason: collision with root package name */
    public static final BigInteger f19731a = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);

    /* renamed from: b, reason: collision with root package name */
    public static final double f19732b = Math.log(10.0d);

    /* renamed from: c, reason: collision with root package name */
    public static final double f19733c = Math.log(2.0d);

    public static BigInteger a(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        return new BigDecimal(bigInteger).divide(new BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }
}
