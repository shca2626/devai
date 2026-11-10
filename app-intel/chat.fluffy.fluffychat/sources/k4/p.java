package k4;

import android.graphics.Rect;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f19092a;

    /* renamed from: b, reason: collision with root package name */
    public int f19093b;

    /* renamed from: c, reason: collision with root package name */
    public int f19094c;

    public p(byte[] bArr, int i7, int i8) {
        this.f19092a = bArr;
        this.f19093b = i7;
        this.f19094c = i8;
    }

    public static byte[] e(byte[] bArr, int i7, int i8) {
        int i9 = i7 * i8;
        byte[] bArr2 = new byte[i9];
        int i10 = i9 - 1;
        for (int i11 = 0; i11 < i9; i11++) {
            bArr2[i10] = bArr[i11];
            i10--;
        }
        return bArr2;
    }

    public static byte[] f(byte[] bArr, int i7, int i8) {
        int i9 = i7 * i8;
        byte[] bArr2 = new byte[i9];
        int i10 = i9 - 1;
        for (int i11 = 0; i11 < i7; i11++) {
            for (int i12 = i8 - 1; i12 >= 0; i12--) {
                bArr2[i10] = bArr[(i12 * i7) + i11];
                i10--;
            }
        }
        return bArr2;
    }

    public static byte[] g(byte[] bArr, int i7, int i8) {
        byte[] bArr2 = new byte[i7 * i8];
        int i9 = 0;
        for (int i10 = 0; i10 < i7; i10++) {
            for (int i11 = i8 - 1; i11 >= 0; i11--) {
                bArr2[i9] = bArr[(i11 * i7) + i10];
                i9++;
            }
        }
        return bArr2;
    }

    public p a(Rect rect, int i7) {
        int iWidth = rect.width() / i7;
        int iHeight = rect.height() / i7;
        int i8 = rect.top;
        byte[] bArr = new byte[iWidth * iHeight];
        if (i7 == 1) {
            int i9 = (i8 * this.f19093b) + rect.left;
            for (int i10 = 0; i10 < iHeight; i10++) {
                System.arraycopy(this.f19092a, i9, bArr, i10 * iWidth, iWidth);
                i9 += this.f19093b;
            }
        } else {
            int i11 = (i8 * this.f19093b) + rect.left;
            for (int i12 = 0; i12 < iHeight; i12++) {
                int i13 = i12 * iWidth;
                int i14 = i11;
                for (int i15 = 0; i15 < iWidth; i15++) {
                    bArr[i13] = this.f19092a[i14];
                    i14 += i7;
                    i13++;
                }
                i11 += this.f19093b * i7;
            }
        }
        return new p(bArr, iWidth, iHeight);
    }

    public byte[] b() {
        return this.f19092a;
    }

    public int c() {
        return this.f19094c;
    }

    public int d() {
        return this.f19093b;
    }

    public p h(int i7) {
        return i7 != 90 ? i7 != 180 ? i7 != 270 ? this : new p(f(this.f19092a, this.f19093b, this.f19094c), this.f19094c, this.f19093b) : new p(e(this.f19092a, this.f19093b, this.f19094c), this.f19093b, this.f19094c) : new p(g(this.f19092a, this.f19093b, this.f19094c), this.f19094c, this.f19093b);
    }
}
