package E0;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f2019a;

    /* renamed from: b, reason: collision with root package name */
    public int f2020b;

    /* renamed from: c, reason: collision with root package name */
    public int f2021c;

    /* renamed from: d, reason: collision with root package name */
    public int f2022d;

    public D() {
        this.f2019a = U.f2098f;
    }

    public final void a() {
        int i7;
        int i8 = this.f2020b;
        j3.o.v(i8 >= 0 && (i8 < (i7 = this.f2022d) || (i8 == i7 && this.f2021c == 0)));
    }

    public int b() {
        return ((this.f2022d - this.f2020b) * 8) - this.f2021c;
    }

    public void c() {
        if (this.f2021c == 0) {
            return;
        }
        this.f2021c = 0;
        this.f2020b++;
        a();
    }

    public int d() {
        j3.o.v(this.f2021c == 0);
        return this.f2020b;
    }

    public int e() {
        return (this.f2020b * 8) + this.f2021c;
    }

    public void f(int i7, int i8) {
        if (i8 < 32) {
            i7 &= (1 << i8) - 1;
        }
        int iMin = Math.min(8 - this.f2021c, i8);
        int i9 = this.f2021c;
        int i10 = (8 - i9) - iMin;
        byte[] bArr = this.f2019a;
        int i11 = this.f2020b;
        byte b7 = (byte) (((65280 >> i9) | ((1 << i10) - 1)) & bArr[i11]);
        bArr[i11] = b7;
        int i12 = i8 - iMin;
        bArr[i11] = (byte) (b7 | ((i7 >>> i12) << i10));
        int i13 = i11 + 1;
        while (i12 > 8) {
            this.f2019a[i13] = (byte) (i7 >>> (i12 - 8));
            i12 -= 8;
            i13++;
        }
        int i14 = 8 - i12;
        byte[] bArr2 = this.f2019a;
        byte b8 = (byte) (bArr2[i13] & ((1 << i14) - 1));
        bArr2[i13] = b8;
        bArr2[i13] = (byte) (((i7 & ((1 << i12) - 1)) << i14) | b8);
        r(i8);
        a();
    }

    public boolean g() {
        boolean z7 = (this.f2019a[this.f2020b] & (128 >> this.f2021c)) != 0;
        q();
        return z7;
    }

    public int h(int i7) {
        int i8;
        if (i7 == 0) {
            return 0;
        }
        this.f2021c += i7;
        int i9 = 0;
        while (true) {
            i8 = this.f2021c;
            if (i8 <= 8) {
                break;
            }
            int i10 = i8 - 8;
            this.f2021c = i10;
            byte[] bArr = this.f2019a;
            int i11 = this.f2020b;
            this.f2020b = i11 + 1;
            i9 |= (bArr[i11] & 255) << i10;
        }
        byte[] bArr2 = this.f2019a;
        int i12 = this.f2020b;
        int i13 = ((-1) >>> (32 - i7)) & (i9 | ((bArr2[i12] & 255) >> (8 - i8)));
        if (i8 == 8) {
            this.f2021c = 0;
            this.f2020b = i12 + 1;
        }
        a();
        return i13;
    }

    public void i(byte[] bArr, int i7, int i8) {
        int i9 = (i8 >> 3) + i7;
        while (i7 < i9) {
            byte[] bArr2 = this.f2019a;
            int i10 = this.f2020b;
            int i11 = i10 + 1;
            this.f2020b = i11;
            byte b7 = bArr2[i10];
            int i12 = this.f2021c;
            byte b8 = (byte) (b7 << i12);
            bArr[i7] = b8;
            bArr[i7] = (byte) (((255 & bArr2[i11]) >> (8 - i12)) | b8);
            i7++;
        }
        int i13 = i8 & 7;
        if (i13 == 0) {
            return;
        }
        byte b9 = (byte) (bArr[i9] & (255 >> i13));
        bArr[i9] = b9;
        int i14 = this.f2021c;
        if (i14 + i13 > 8) {
            byte[] bArr3 = this.f2019a;
            int i15 = this.f2020b;
            this.f2020b = i15 + 1;
            bArr[i9] = (byte) (b9 | ((bArr3[i15] & 255) << i14));
            this.f2021c = i14 - 8;
        }
        int i16 = this.f2021c + i13;
        this.f2021c = i16;
        byte[] bArr4 = this.f2019a;
        int i17 = this.f2020b;
        bArr[i9] = (byte) (((byte) (((255 & bArr4[i17]) >> (8 - i16)) << (8 - i13))) | bArr[i9]);
        if (i16 == 8) {
            this.f2021c = 0;
            this.f2020b = i17 + 1;
        }
        a();
    }

    public long j(int i7) {
        return i7 <= 32 ? U.r1(h(i7)) : U.q1(h(i7 - 32), h(32));
    }

    public void k(byte[] bArr, int i7, int i8) {
        j3.o.v(this.f2021c == 0);
        System.arraycopy(this.f2019a, this.f2020b, bArr, i7, i8);
        this.f2020b += i8;
        a();
    }

    public String l(int i7, Charset charset) {
        byte[] bArr = new byte[i7];
        k(bArr, 0, i7);
        return new String(bArr, charset);
    }

    public void m(E e7) {
        o(e7.f(), e7.j());
        p(e7.g() * 8);
    }

    public void n(byte[] bArr) {
        o(bArr, bArr.length);
    }

    public void o(byte[] bArr, int i7) {
        this.f2019a = bArr;
        this.f2020b = 0;
        this.f2021c = 0;
        this.f2022d = i7;
    }

    public void p(int i7) {
        int i8 = i7 / 8;
        this.f2020b = i8;
        this.f2021c = i7 - (i8 * 8);
        a();
    }

    public void q() {
        int i7 = this.f2021c + 1;
        this.f2021c = i7;
        if (i7 == 8) {
            this.f2021c = 0;
            this.f2020b++;
        }
        a();
    }

    public void r(int i7) {
        int i8 = i7 / 8;
        int i9 = this.f2020b + i8;
        this.f2020b = i9;
        int i10 = this.f2021c + (i7 - (i8 * 8));
        this.f2021c = i10;
        if (i10 > 7) {
            this.f2020b = i9 + 1;
            this.f2021c = i10 - 8;
        }
        a();
    }

    public void s(int i7) {
        j3.o.v(this.f2021c == 0);
        this.f2020b += i7;
        a();
    }

    public D(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public D(byte[] bArr, int i7) {
        this.f2019a = bArr;
        this.f2022d = i7;
    }
}
