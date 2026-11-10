package O5;

/* loaded from: classes.dex */
public class b extends a {
    public static int a(double d7) {
        if (Double.isNaN(d7)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d7 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d7 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d7);
    }
}
