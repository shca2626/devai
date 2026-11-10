package k3;

/* renamed from: k3.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1276s {
    public static int a(int i7, double d7) {
        int iMax = Math.max(i7, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax <= ((int) (d7 * iHighestOneBit))) {
            return iHighestOneBit;
        }
        int i8 = iHighestOneBit << 1;
        if (i8 > 0) {
            return i8;
        }
        return 1073741824;
    }

    public static int b(int i7) {
        return (int) (Integer.rotateLeft((int) (i7 * (-862048943)), 15) * 461845907);
    }

    public static int c(Object obj) {
        return b(obj == null ? 0 : obj.hashCode());
    }
}
