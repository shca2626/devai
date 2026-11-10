package F0;

import j3.o;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f2584a;

    /* renamed from: b, reason: collision with root package name */
    public int f2585b;

    /* renamed from: c, reason: collision with root package name */
    public int f2586c;

    /* renamed from: d, reason: collision with root package name */
    public int f2587d;

    public j(byte[] bArr, int i7, int i8) {
        j(bArr, i7, i8);
    }

    public final void a() {
        int i7;
        int i8 = this.f2586c;
        o.v(i8 >= 0 && (i8 < (i7 = this.f2585b) || (i8 == i7 && this.f2587d == 0)));
    }

    public void b() {
        int i7 = this.f2587d;
        if (i7 > 0) {
            m(8 - i7);
        }
    }

    public boolean c(int i7) {
        int i8 = this.f2586c;
        int i9 = i7 / 8;
        int i10 = i8 + i9;
        int i11 = (this.f2587d + i7) - (i9 * 8);
        if (i11 > 7) {
            i10++;
            i11 -= 8;
        }
        while (true) {
            i8++;
            if (i8 > i10 || i10 >= this.f2585b) {
                break;
            }
            if (k(i8)) {
                i10++;
                i8 += 2;
            }
        }
        int i12 = this.f2585b;
        if (i10 >= i12) {
            return i10 == i12 && i11 == 0;
        }
        return true;
    }

    public boolean d() {
        int i7 = this.f2586c;
        int i8 = this.f2587d;
        int i9 = 0;
        while (this.f2586c < this.f2585b && !e()) {
            i9++;
        }
        boolean z7 = this.f2586c == this.f2585b;
        this.f2586c = i7;
        this.f2587d = i8;
        return !z7 && c((i9 * 2) + 1);
    }

    public boolean e() {
        boolean z7 = (this.f2584a[this.f2586c] & (128 >> this.f2587d)) != 0;
        l();
        return z7;
    }

    public int f(int i7) {
        int i8;
        this.f2587d += i7;
        int i9 = 0;
        while (true) {
            i8 = this.f2587d;
            if (i8 <= 8) {
                break;
            }
            int i10 = i8 - 8;
            this.f2587d = i10;
            byte[] bArr = this.f2584a;
            int i11 = this.f2586c;
            i9 |= (bArr[i11] & 255) << i10;
            if (!k(i11 + 1)) {
                i = 1;
            }
            this.f2586c = i11 + i;
        }
        byte[] bArr2 = this.f2584a;
        int i12 = this.f2586c;
        int i13 = ((-1) >>> (32 - i7)) & (i9 | ((bArr2[i12] & 255) >> (8 - i8)));
        if (i8 == 8) {
            this.f2587d = 0;
            this.f2586c = i12 + (k(i12 + 1) ? 2 : 1);
        }
        a();
        return i13;
    }

    public final int g() {
        int i7 = 0;
        while (!e()) {
            i7++;
        }
        return ((1 << i7) - 1) + (i7 > 0 ? f(i7) : 0);
    }

    public int h() {
        int iG = g();
        return (iG % 2 == 0 ? -1 : 1) * ((iG + 1) / 2);
    }

    public int i() {
        return g();
    }

    public void j(byte[] bArr, int i7, int i8) {
        this.f2584a = bArr;
        this.f2586c = i7;
        this.f2585b = i8;
        this.f2587d = 0;
        a();
    }

    public final boolean k(int i7) {
        if (2 > i7 || i7 >= this.f2585b) {
            return false;
        }
        byte[] bArr = this.f2584a;
        return bArr[i7] == 3 && bArr[i7 + (-2)] == 0 && bArr[i7 - 1] == 0;
    }

    public void l() {
        int i7 = this.f2587d + 1;
        this.f2587d = i7;
        if (i7 == 8) {
            this.f2587d = 0;
            int i8 = this.f2586c;
            this.f2586c = i8 + (k(i8 + 1) ? 2 : 1);
        }
        a();
    }

    public void m(int i7) {
        int i8 = this.f2586c;
        int i9 = i7 / 8;
        int i10 = i8 + i9;
        this.f2586c = i10;
        int i11 = this.f2587d + (i7 - (i9 * 8));
        this.f2587d = i11;
        if (i11 > 7) {
            this.f2586c = i10 + 1;
            this.f2587d = i11 - 8;
        }
        while (true) {
            i8++;
            if (i8 > this.f2586c) {
                a();
                return;
            } else if (k(i8)) {
                this.f2586c++;
                i8 += 2;
            }
        }
    }
}
