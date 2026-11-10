package androidx.core.graphics;

import android.graphics.Color;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<double[]> f6508a = new ThreadLocal<>();

    public static void a(int i12, int i13, int i14, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d12 = i12 / 255.0d;
        double dPow = d12 < 0.04045d ? d12 / 12.92d : Math.pow((d12 + 0.055d) / 1.055d, 2.4d);
        double d13 = i13 / 255.0d;
        double dPow2 = d13 < 0.04045d ? d13 / 12.92d : Math.pow((d13 + 0.055d) / 1.055d, 2.4d);
        double d14 = i14 / 255.0d;
        double dPow3 = d14 < 0.04045d ? d14 / 12.92d : Math.pow((d14 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * dPow) + (0.3576d * dPow2) + (0.1805d * dPow3)) * 100.0d;
        dArr[1] = ((0.2126d * dPow) + (0.7152d * dPow2) + (0.0722d * dPow3)) * 100.0d;
        dArr[2] = ((dPow * 0.0193d) + (dPow2 * 0.1192d) + (dPow3 * 0.9505d)) * 100.0d;
    }

    public static int b(double d12, double d13, double d14) {
        double d15 = (((3.2406d * d12) + ((-1.5372d) * d13)) + ((-0.4986d) * d14)) / 100.0d;
        double d16 = ((((-0.9689d) * d12) + (1.8758d * d13)) + (0.0415d * d14)) / 100.0d;
        double d17 = (((0.0557d * d12) + ((-0.204d) * d13)) + (1.057d * d14)) / 100.0d;
        return Color.rgb(i((int) Math.round((d15 > 0.0031308d ? (Math.pow(d15, 0.4166666666666667d) * 1.055d) - 0.055d : d15 * 12.92d) * 255.0d), 0, 255), i((int) Math.round((d16 > 0.0031308d ? (Math.pow(d16, 0.4166666666666667d) * 1.055d) - 0.055d : d16 * 12.92d) * 255.0d), 0, 255), i((int) Math.round((d17 > 0.0031308d ? (Math.pow(d17, 0.4166666666666667d) * 1.055d) - 0.055d : 12.92d * d17) * 255.0d), 0, 255));
    }

    public static int c(int i12, int i13, float f12) {
        float f13 = 1.0f - f12;
        return Color.argb((int) ((Color.alpha(i12) * f13) + (Color.alpha(i13) * f12)), (int) ((Color.red(i12) * f13) + (Color.red(i13) * f12)), (int) ((Color.green(i12) * f13) + (Color.green(i13) * f12)), (int) ((Color.blue(i12) * f13) + (Color.blue(i13) * f12)));
    }

    public static double d(int i12) {
        double[] dArrJ = j();
        e(i12, dArrJ);
        return dArrJ[1] / 100.0d;
    }

    public static void e(int i12, double[] dArr) {
        a(Color.red(i12), Color.green(i12), Color.blue(i12), dArr);
    }

    private static int f(int i12, int i13) {
        return 255 - (((255 - i13) * (255 - i12)) / 255);
    }

    public static int g(int i12, int i13) {
        int iAlpha = Color.alpha(i13);
        int iAlpha2 = Color.alpha(i12);
        int iF = f(iAlpha2, iAlpha);
        return Color.argb(iF, h(Color.red(i12), iAlpha2, Color.red(i13), iAlpha, iF), h(Color.green(i12), iAlpha2, Color.green(i13), iAlpha, iF), h(Color.blue(i12), iAlpha2, Color.blue(i13), iAlpha, iF));
    }

    private static int h(int i12, int i13, int i14, int i15, int i16) {
        if (i16 == 0) {
            return 0;
        }
        return (((i12 * 255) * i13) + ((i14 * i15) * (255 - i13))) / (i16 * 255);
    }

    private static int i(int i12, int i13, int i14) {
        return i12 < i13 ? i13 : Math.min(i12, i14);
    }

    private static double[] j() {
        ThreadLocal<double[]> threadLocal = f6508a;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    public static int k(int i12, int i13) {
        if (i13 < 0 || i13 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i12 & 16777215) | (i13 << 24);
    }
}
