package v5;

import java.util.Arrays;

/* renamed from: v5.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1697f {

    /* renamed from: a, reason: collision with root package name */
    public static final C1697f f23090a = new C1697f();

    /* renamed from: v5.f$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final short[] f23091a;

        /* renamed from: b, reason: collision with root package name */
        public final int f23092b;

        public a(short[] sArr, int i7) {
            M5.m.e(sArr, "samples");
            this.f23091a = sArr;
            this.f23092b = i7;
        }

        public final int a() {
            return this.f23092b;
        }

        public final short[] b() {
            return this.f23091a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return M5.m.a(this.f23091a, aVar.f23091a) && this.f23092b == aVar.f23092b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f23091a) * 31) + Integer.hashCode(this.f23092b);
        }

        public String toString() {
            return "ResampleResult(samples=" + Arrays.toString(this.f23091a) + ", frameCount=" + this.f23092b + ')';
        }
    }

    public final short[] a(short[] sArr, int i7, int i8, int i9, int i10, int i11) {
        short[] sArr2 = new short[i8 * i11];
        double d7 = i9 / i10;
        int i12 = 0;
        while (i12 < i8) {
            int i13 = (int) (i12 * d7);
            int i14 = i12 + 1;
            int iF = S5.e.f((int) (i14 * d7), i7);
            int i15 = 0;
            while (i15 < i11) {
                long j7 = 0;
                int i16 = i13;
                while (i16 < iF) {
                    j7 += sArr[(i16 * i11) + i15];
                    i16++;
                    i12 = i12;
                }
                int i17 = i12;
                int i18 = iF - i13;
                sArr2[(i17 * i11) + i15] = i18 > 0 ? (short) S5.e.j((int) (j7 / i18), -32768, 32767) : (short) 0;
                i15++;
                i12 = i17;
            }
            i12 = i14;
        }
        return sArr2;
    }

    public final a b(short[] sArr, int i7, int i8, int i9, int i10) {
        M5.m.e(sArr, "src");
        if (i8 == i9 || i7 <= 0 || i10 <= 0) {
            return new a(sArr, i7);
        }
        int i11 = (int) ((i7 * i9) / i8);
        if (i11 <= 0) {
            return new a(new short[0], 0);
        }
        return new a(i9 > i8 ? c(sArr, i7, i11, i10) : a(sArr, i7, i11, i8, i9, i10), i11);
    }

    public final short[] c(short[] sArr, int i7, int i8, int i9) {
        short[] sArr2 = new short[i8 * i9];
        if (i7 <= 1) {
            for (int i10 = 0; i10 < i8; i10++) {
                for (int i11 = 0; i11 < i9; i11++) {
                    sArr2[(i10 * i9) + i11] = sArr[i11];
                }
            }
        } else {
            double d7 = i7 / i8;
            for (int i12 = 0; i12 < i8; i12++) {
                double d8 = i12 * d7;
                int iF = S5.e.f((int) d8, i7 - 2);
                float f7 = (float) (d8 - iF);
                for (int i13 = 0; i13 < i9; i13++) {
                    sArr2[(i12 * i9) + i13] = (short) S5.e.j((int) (sArr[(iF * i9) + i13] + ((sArr[((iF + 1) * i9) + i13] - r11) * f7)), -32768, 32767);
                }
            }
        }
        return sArr2;
    }
}
