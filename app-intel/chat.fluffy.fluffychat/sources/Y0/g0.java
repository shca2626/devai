package Y0;

import java.util.Arrays;
import java.util.Random;

/* loaded from: classes.dex */
public interface g0 {

    public static class a implements g0 {

        /* renamed from: a, reason: collision with root package name */
        public final Random f9666a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f9667b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f9668c;

        public a(int i7) {
            this(i7, new Random());
        }

        public static int[] j(int i7, Random random) {
            int[] iArr = new int[i7];
            int i8 = 0;
            while (i8 < i7) {
                int i9 = i8 + 1;
                int iNextInt = random.nextInt(i9);
                iArr[i8] = iArr[iNextInt];
                iArr[iNextInt] = i8;
                i8 = i9;
            }
            return iArr;
        }

        @Override // Y0.g0
        public g0 a(int i7, int i8) {
            int i9 = i8 - i7;
            int[] iArr = new int[this.f9667b.length - i9];
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int[] iArr2 = this.f9667b;
                if (i10 >= iArr2.length) {
                    return new a(iArr, new Random(this.f9666a.nextLong()));
                }
                int i12 = iArr2[i10];
                if (i12 < i7 || i12 >= i8) {
                    int i13 = i10 - i11;
                    if (i12 >= i7) {
                        i12 -= i9;
                    }
                    iArr[i13] = i12;
                } else {
                    i11++;
                }
                i10++;
            }
        }

        @Override // Y0.g0
        public int c() {
            int[] iArr = this.f9667b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // Y0.g0
        public int d(int i7) {
            int i8 = this.f9668c[i7] - 1;
            if (i8 >= 0) {
                return this.f9667b[i8];
            }
            return -1;
        }

        @Override // Y0.g0
        public int e(int i7) {
            int i8 = this.f9668c[i7] + 1;
            int[] iArr = this.f9667b;
            if (i8 < iArr.length) {
                return iArr[i8];
            }
            return -1;
        }

        @Override // Y0.g0
        public g0 f(int i7, int i8) {
            int[] iArr = new int[i8];
            int[] iArr2 = new int[i8];
            int i9 = 0;
            int i10 = 0;
            while (i10 < i8) {
                iArr[i10] = this.f9666a.nextInt(this.f9667b.length + 1);
                int i11 = i10 + 1;
                int iNextInt = this.f9666a.nextInt(i11);
                iArr2[i10] = iArr2[iNextInt];
                iArr2[iNextInt] = i10 + i7;
                i10 = i11;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f9667b.length + i8];
            int i12 = 0;
            int i13 = 0;
            while (true) {
                int[] iArr4 = this.f9667b;
                if (i9 >= iArr4.length + i8) {
                    return new a(iArr3, new Random(this.f9666a.nextLong()));
                }
                if (i12 >= i8 || i13 != iArr[i12]) {
                    int i14 = i13 + 1;
                    int i15 = iArr4[i13];
                    iArr3[i9] = i15;
                    if (i15 >= i7) {
                        iArr3[i9] = i15 + i8;
                    }
                    i13 = i14;
                } else {
                    iArr3[i9] = iArr2[i12];
                    i12++;
                }
                i9++;
            }
        }

        @Override // Y0.g0
        public int getLength() {
            return this.f9667b.length;
        }

        @Override // Y0.g0
        public int h() {
            int[] iArr = this.f9667b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // Y0.g0
        public g0 i() {
            return new a(0, new Random(this.f9666a.nextLong()));
        }

        public a(int[] iArr, long j7) {
            this(Arrays.copyOf(iArr, iArr.length), new Random(j7));
        }

        public a(int i7, Random random) {
            this(j(i7, random), random);
        }

        public a(int[] iArr, Random random) {
            this.f9667b = iArr;
            this.f9666a = random;
            this.f9668c = new int[iArr.length];
            for (int i7 = 0; i7 < iArr.length; i7++) {
                this.f9668c[iArr[i7]] = i7;
            }
        }
    }

    g0 a(int i7, int i8);

    default g0 b(int i7, int i8) {
        return i().f(0, i7);
    }

    int c();

    int d(int i7);

    int e(int i7);

    g0 f(int i7, int i8);

    int getLength();

    int h();

    g0 i();

    default g0 g(int i7, int i8, int i9) {
        return this;
    }
}
