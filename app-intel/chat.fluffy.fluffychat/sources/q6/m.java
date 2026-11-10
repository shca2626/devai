package q6;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public int f21639a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f21640b = new int[10];

    public void a() {
        this.f21639a = 0;
        Arrays.fill(this.f21640b, 0);
    }

    public int b(int i7) {
        return this.f21640b[i7];
    }

    public int c() {
        if ((this.f21639a & 2) != 0) {
            return this.f21640b[1];
        }
        return -1;
    }

    public int d() {
        if ((this.f21639a & 128) != 0) {
            return this.f21640b[7];
        }
        return 65535;
    }

    public int e(int i7) {
        return (this.f21639a & 16) != 0 ? this.f21640b[4] : i7;
    }

    public int f(int i7) {
        return (this.f21639a & 32) != 0 ? this.f21640b[5] : i7;
    }

    public boolean g(int i7) {
        return ((1 << i7) & this.f21639a) != 0;
    }

    public void h(m mVar) {
        for (int i7 = 0; i7 < 10; i7++) {
            if (mVar.g(i7)) {
                i(i7, mVar.b(i7));
            }
        }
    }

    public m i(int i7, int i8) {
        if (i7 >= 0) {
            int[] iArr = this.f21640b;
            if (i7 < iArr.length) {
                this.f21639a = (1 << i7) | this.f21639a;
                iArr[i7] = i8;
            }
        }
        return this;
    }

    public int j() {
        return Integer.bitCount(this.f21639a);
    }
}
