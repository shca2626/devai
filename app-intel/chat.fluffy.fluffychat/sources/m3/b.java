package m3;

import java.math.RoundingMode;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final double f19734a = Math.log(2.0d);

    /* renamed from: b, reason: collision with root package name */
    public static final double[] f19735b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19736a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f19736a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19736a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19736a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19736a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19736a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19736a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19736a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19736a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static boolean a(double d7, double d8, double d9) {
        f.d("tolerance", d9);
        if (Math.copySign(d7 - d8, 1.0d) <= d9 || d7 == d8) {
            return true;
        }
        return Double.isNaN(d7) && Double.isNaN(d8);
    }

    public static boolean b(double d7) {
        if (c.b(d7)) {
            return d7 == 0.0d || 52 - Long.numberOfTrailingZeros(c.a(d7)) <= Math.getExponent(d7);
        }
        return false;
    }

    public static boolean c(double d7) {
        if (d7 > 0.0d && c.b(d7)) {
            long jA = c.a(d7);
            if ((jA & (jA - 1)) == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int d(double r5, java.math.RoundingMode r7) {
        /*
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L10
            boolean r0 = m3.c.b(r5)
            if (r0 == 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            java.lang.String r3 = "x must be positive and finite"
            j3.o.e(r0, r3)
            int r0 = java.lang.Math.getExponent(r5)
            boolean r3 = m3.c.c(r5)
            if (r3 != 0) goto L2a
            r0 = 4841369599423283200(0x4330000000000000, double:4.503599627370496E15)
            double r5 = r5 * r0
            int r5 = d(r5, r7)
            int r5 = r5 + (-52)
            return r5
        L2a:
            int[] r3 = m3.b.a.f19736a
            int r7 = r7.ordinal()
            r7 = r3[r7]
            switch(r7) {
                case 1: goto L61;
                case 2: goto L68;
                case 3: goto L5a;
                case 4: goto L52;
                case 5: goto L48;
                case 6: goto L3b;
                case 7: goto L3b;
                case 8: goto L3b;
                default: goto L35;
            }
        L35:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L3b:
            double r5 = m3.c.d(r5)
            double r5 = r5 * r5
            r3 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 <= 0) goto L68
            r1 = r2
            goto L68
        L48:
            if (r0 < 0) goto L4b
            r1 = r2
        L4b:
            boolean r5 = c(r5)
        L4f:
            r5 = r5 ^ r2
            r1 = r1 & r5
            goto L68
        L52:
            if (r0 >= 0) goto L55
            r1 = r2
        L55:
            boolean r5 = c(r5)
            goto L4f
        L5a:
            boolean r5 = c(r5)
            r1 = r5 ^ 1
            goto L68
        L61:
            boolean r5 = c(r5)
            m3.f.g(r5)
        L68:
            if (r1 == 0) goto L6b
            int r0 = r0 + r2
        L6b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.b.d(double, java.math.RoundingMode):int");
    }

    public static double e(double d7, RoundingMode roundingMode) {
        if (!c.b(d7)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (a.f19736a[roundingMode.ordinal()]) {
            case 1:
                f.g(b(d7));
                return d7;
            case 2:
                return (d7 >= 0.0d || b(d7)) ? d7 : ((long) d7) - 1;
            case 3:
                return (d7 <= 0.0d || b(d7)) ? d7 : ((long) d7) + 1;
            case 4:
                return d7;
            case 5:
                if (b(d7)) {
                    return d7;
                }
                return ((long) d7) + (d7 > 0.0d ? 1 : -1);
            case 6:
                return Math.rint(d7);
            case 7:
                double dRint = Math.rint(d7);
                return Math.abs(d7 - dRint) == 0.5d ? d7 + Math.copySign(0.5d, d7) : dRint;
            case 8:
                double dRint2 = Math.rint(d7);
                return Math.abs(d7 - dRint2) == 0.5d ? d7 : dRint2;
            default:
                throw new AssertionError();
        }
    }

    public static long f(double d7, RoundingMode roundingMode) {
        double dE = e(d7, roundingMode);
        f.a(((-9.223372036854776E18d) - dE < 1.0d) & (dE < 9.223372036854776E18d), d7, roundingMode);
        return (long) dE;
    }
}
