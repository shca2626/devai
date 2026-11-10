package a4;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final int[][] f10802c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: a, reason: collision with root package name */
    public final f f10803a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f10804b;

    public g(int i7) {
        this.f10803a = f.d((i7 >> 3) & 3);
        this.f10804b = (byte) (i7 & 7);
    }

    public static g a(int i7, int i8) {
        g gVarB = b(i7, i8);
        return gVarB != null ? gVarB : b(i7 ^ 21522, i8 ^ 21522);
    }

    public static g b(int i7, int i8) {
        int iE;
        int i9 = Integer.MAX_VALUE;
        int i10 = 0;
        for (int[] iArr : f10802c) {
            int i11 = iArr[0];
            if (i11 == i7 || i11 == i8) {
                return new g(iArr[1]);
            }
            int iE2 = e(i7, i11);
            if (iE2 < i9) {
                i10 = iArr[1];
                i9 = iE2;
            }
            if (i7 != i8 && (iE = e(i8, i11)) < i9) {
                i10 = iArr[1];
                i9 = iE;
            }
        }
        if (i9 <= 3) {
            return new g(i10);
        }
        return null;
    }

    public static int e(int i7, int i8) {
        return Integer.bitCount(i7 ^ i8);
    }

    public byte c() {
        return this.f10804b;
    }

    public f d() {
        return this.f10803a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f10803a == gVar.f10803a && this.f10804b == gVar.f10804b;
    }

    public int hashCode() {
        return (this.f10803a.ordinal() << 3) | this.f10804b;
    }
}
