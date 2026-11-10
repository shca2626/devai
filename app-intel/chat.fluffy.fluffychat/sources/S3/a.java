package S3;

import D3.j;
import R3.k;

/* loaded from: classes.dex */
public abstract class a extends k {

    /* renamed from: b, reason: collision with root package name */
    public final int[] f8170b;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f8173e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f8174f;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f8169a = new int[4];

    /* renamed from: c, reason: collision with root package name */
    public final float[] f8171c = new float[4];

    /* renamed from: d, reason: collision with root package name */
    public final float[] f8172d = new float[4];

    public a() {
        int[] iArr = new int[8];
        this.f8170b = iArr;
        this.f8173e = new int[iArr.length / 2];
        this.f8174f = new int[iArr.length / 2];
    }

    public static void h(int[] iArr, float[] fArr) {
        int i7 = 0;
        float f7 = fArr[0];
        for (int i8 = 1; i8 < iArr.length; i8++) {
            float f8 = fArr[i8];
            if (f8 < f7) {
                i7 = i8;
                f7 = f8;
            }
        }
        iArr[i7] = iArr[i7] - 1;
    }

    public static void o(int[] iArr, float[] fArr) {
        int i7 = 0;
        float f7 = fArr[0];
        for (int i8 = 1; i8 < iArr.length; i8++) {
            float f8 = fArr[i8];
            if (f8 > f7) {
                i7 = i8;
                f7 = f8;
            }
        }
        iArr[i7] = iArr[i7] + 1;
    }

    public static boolean p(int[] iArr) {
        float f7 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f7 >= 0.7916667f && f7 <= 0.89285713f) {
            int i7 = Integer.MAX_VALUE;
            int i8 = Integer.MIN_VALUE;
            for (int i9 : iArr) {
                if (i9 > i8) {
                    i8 = i9;
                }
                if (i9 < i7) {
                    i7 = i9;
                }
            }
            if (i8 < i7 * 10) {
                return true;
            }
        }
        return false;
    }

    public static int q(int[] iArr, int[][] iArr2) throws j {
        for (int i7 = 0; i7 < iArr2.length; i7++) {
            if (k.e(iArr, iArr2[i7], 0.45f) < 0.2f) {
                return i7;
            }
        }
        throw j.a();
    }

    public final int[] i() {
        return this.f8170b;
    }

    public final int[] j() {
        return this.f8169a;
    }

    public final int[] k() {
        return this.f8174f;
    }

    public final float[] l() {
        return this.f8172d;
    }

    public final int[] m() {
        return this.f8173e;
    }

    public final float[] n() {
        return this.f8171c;
    }
}
