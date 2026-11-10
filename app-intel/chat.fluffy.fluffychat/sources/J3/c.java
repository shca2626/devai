package J3;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f4731a;

    /* renamed from: b, reason: collision with root package name */
    public int f4732b;

    /* renamed from: c, reason: collision with root package name */
    public int f4733c;

    public c(byte[] bArr) {
        this.f4731a = bArr;
    }

    public int a() {
        return ((this.f4731a.length - this.f4732b) * 8) - this.f4733c;
    }

    public int b() {
        return this.f4733c;
    }

    public int c() {
        return this.f4732b;
    }

    public int d(int i7) {
        if (i7 < 1 || i7 > 32 || i7 > a()) {
            throw new IllegalArgumentException(String.valueOf(i7));
        }
        int i8 = this.f4733c;
        int i9 = 0;
        if (i8 > 0) {
            int i10 = 8 - i8;
            int iMin = Math.min(i7, i10);
            int i11 = i10 - iMin;
            byte[] bArr = this.f4731a;
            int i12 = this.f4732b;
            int i13 = (((255 >> (8 - iMin)) << i11) & bArr[i12]) >> i11;
            i7 -= iMin;
            int i14 = this.f4733c + iMin;
            this.f4733c = i14;
            if (i14 == 8) {
                this.f4733c = 0;
                this.f4732b = i12 + 1;
            }
            i9 = i13;
        }
        if (i7 > 0) {
            while (i7 >= 8) {
                int i15 = i9 << 8;
                byte[] bArr2 = this.f4731a;
                int i16 = this.f4732b;
                i9 = (bArr2[i16] & 255) | i15;
                this.f4732b = i16 + 1;
                i7 -= 8;
            }
            if (i7 > 0) {
                int i17 = 8 - i7;
                int i18 = ((((255 >> i17) << i17) & this.f4731a[this.f4732b]) >> i17) | (i9 << i7);
                this.f4733c += i7;
                return i18;
            }
        }
        return i9;
    }
}
