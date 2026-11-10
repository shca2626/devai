package K3;

/* loaded from: classes.dex */
public abstract class a {
    public static float a(float f7, float f8, float f9, float f10) {
        double d7 = f7 - f9;
        double d8 = f8 - f10;
        return (float) Math.sqrt((d7 * d7) + (d8 * d8));
    }

    public static float b(int i7, int i8, int i9, int i10) {
        double d7 = i7 - i9;
        double d8 = i8 - i10;
        return (float) Math.sqrt((d7 * d7) + (d8 * d8));
    }

    public static int c(float f7) {
        return (int) (f7 + (f7 < 0.0f ? -0.5f : 0.5f));
    }

    public static int d(int[] iArr) {
        int i7 = 0;
        for (int i8 : iArr) {
            i7 += i8;
        }
        return i7;
    }
}
