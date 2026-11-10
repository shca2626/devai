package g1;

/* loaded from: classes.dex */
public final class X {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f15998a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15999b;

    /* renamed from: c, reason: collision with root package name */
    public int f16000c;

    /* renamed from: d, reason: collision with root package name */
    public int f16001d;

    public X(byte[] bArr) {
        this.f15998a = bArr;
        this.f15999b = bArr.length;
    }

    public final void a() {
        int i7;
        int i8 = this.f16000c;
        j3.o.v(i8 >= 0 && (i8 < (i7 = this.f15999b) || (i8 == i7 && this.f16001d == 0)));
    }

    public int b() {
        return (this.f16000c * 8) + this.f16001d;
    }

    public boolean c() {
        boolean z7 = (((this.f15998a[this.f16000c] & 255) >> this.f16001d) & 1) == 1;
        e(1);
        return z7;
    }

    public int d(int i7) {
        int i8 = this.f16000c;
        int iMin = Math.min(i7, 8 - this.f16001d);
        int i9 = i8 + 1;
        int i10 = ((this.f15998a[i8] & 255) >> this.f16001d) & (255 >> (8 - iMin));
        while (iMin < i7) {
            i10 |= (this.f15998a[i9] & 255) << iMin;
            iMin += 8;
            i9++;
        }
        int i11 = i10 & ((-1) >>> (32 - i7));
        e(i7);
        return i11;
    }

    public void e(int i7) {
        int i8 = i7 / 8;
        int i9 = this.f16000c + i8;
        this.f16000c = i9;
        int i10 = this.f16001d + (i7 - (i8 * 8));
        this.f16001d = i10;
        if (i10 > 7) {
            this.f16000c = i9 + 1;
            this.f16001d = i10 - 8;
        }
        a();
    }
}
