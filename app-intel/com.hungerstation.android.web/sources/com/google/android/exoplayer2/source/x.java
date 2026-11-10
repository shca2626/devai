package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

/* loaded from: classes8.dex */
public interface x {

    public static class a implements x {

        /* renamed from: a, reason: collision with root package name */
        private final Random f21564a;

        /* renamed from: b, reason: collision with root package name */
        private final int[] f21565b;

        /* renamed from: c, reason: collision with root package name */
        private final int[] f21566c;

        public a(int i12) {
            this(i12, new Random());
        }

        private static int[] i(int i12, Random random) {
            int[] iArr = new int[i12];
            int i13 = 0;
            while (i13 < i12) {
                int i14 = i13 + 1;
                int iNextInt = random.nextInt(i14);
                iArr[i13] = iArr[iNextInt];
                iArr[iNextInt] = i13;
                i13 = i14;
            }
            return iArr;
        }

        @Override // com.google.android.exoplayer2.source.x
        public int a() {
            return this.f21565b.length;
        }

        @Override // com.google.android.exoplayer2.source.x
        public x b(int i12, int i13) {
            int i14 = i13 - i12;
            int[] iArr = new int[this.f21565b.length - i14];
            int i15 = 0;
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.f21565b;
                if (i15 >= iArr2.length) {
                    return new a(iArr, new Random(this.f21564a.nextLong()));
                }
                int i17 = iArr2[i15];
                if (i17 < i12 || i17 >= i13) {
                    int i18 = i15 - i16;
                    if (i17 >= i12) {
                        i17 -= i14;
                    }
                    iArr[i18] = i17;
                } else {
                    i16++;
                }
                i15++;
            }
        }

        @Override // com.google.android.exoplayer2.source.x
        public int c(int i12) {
            int i13 = this.f21566c[i12] - 1;
            if (i13 >= 0) {
                return this.f21565b[i13];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.x
        public int d(int i12) {
            int i13 = this.f21566c[i12] + 1;
            int[] iArr = this.f21565b;
            if (i13 < iArr.length) {
                return iArr[i13];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.x
        public int e() {
            int[] iArr = this.f21565b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.x
        public x f() {
            return new a(0, new Random(this.f21564a.nextLong()));
        }

        @Override // com.google.android.exoplayer2.source.x
        public int g() {
            int[] iArr = this.f21565b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.x
        public x h(int i12, int i13) {
            int[] iArr = new int[i13];
            int[] iArr2 = new int[i13];
            int i14 = 0;
            int i15 = 0;
            while (i15 < i13) {
                iArr[i15] = this.f21564a.nextInt(this.f21565b.length + 1);
                int i16 = i15 + 1;
                int iNextInt = this.f21564a.nextInt(i16);
                iArr2[i15] = iArr2[iNextInt];
                iArr2[iNextInt] = i15 + i12;
                i15 = i16;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f21565b.length + i13];
            int i17 = 0;
            int i18 = 0;
            while (true) {
                int[] iArr4 = this.f21565b;
                if (i14 >= iArr4.length + i13) {
                    return new a(iArr3, new Random(this.f21564a.nextLong()));
                }
                if (i17 >= i13 || i18 != iArr[i17]) {
                    int i19 = i18 + 1;
                    int i22 = iArr4[i18];
                    iArr3[i14] = i22;
                    if (i22 >= i12) {
                        iArr3[i14] = i22 + i13;
                    }
                    i18 = i19;
                } else {
                    iArr3[i14] = iArr2[i17];
                    i17++;
                }
                i14++;
            }
        }

        public a(int[] iArr, long j12) {
            this(Arrays.copyOf(iArr, iArr.length), new Random(j12));
        }

        private a(int i12, Random random) {
            this(i(i12, random), random);
        }

        private a(int[] iArr, Random random) {
            this.f21565b = iArr;
            this.f21564a = random;
            this.f21566c = new int[iArr.length];
            for (int i12 = 0; i12 < iArr.length; i12++) {
                this.f21566c[iArr[i12]] = i12;
            }
        }
    }

    int a();

    x b(int i12, int i13);

    int c(int i12);

    int d(int i12);

    int e();

    x f();

    int g();

    x h(int i12, int i13);
}
