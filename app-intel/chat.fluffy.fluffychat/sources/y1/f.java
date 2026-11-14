package y1;

import E0.E;
import g1.r;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final E f23974a = new E(8);

    /* renamed from: b, reason: collision with root package name */
    public int f23975b;

    public final long a(r rVar) {
        int i7 = 0;
        rVar.t(this.f23974a.f(), 0, 1);
        int i8 = this.f23974a.f()[0] & 255;
        if (i8 == 0) {
            return Long.MIN_VALUE;
        }
        int i9 = 128;
        int i10 = 0;
        while ((i8 & i9) == 0) {
            i9 >>= 1;
            i10++;
        }
        int i11 = i8 & (~i9);
        rVar.t(this.f23974a.f(), 1, i10);
        while (i7 < i10) {
            i7++;
            i11 = (this.f23974a.f()[i7] & 255) + (i11 << 8);
        }
        this.f23975b += i10 + 1;
        return i11;
    }

    public boolean b(r rVar) {
        long length = rVar.getLength();
        long j7 = 1024;
        if (length != -1 && length <= 1024) {
            j7 = length;
        }
        int i7 = (int) j7;
        rVar.t(this.f23974a.f(), 0, 4);
        long jS = this.f23974a.S();
        this.f23975b = 4;
        while (jS != 440786851) {
            int i8 = this.f23975b + 1;
            this.f23975b = i8;
            if (i8 == i7) {
                return false;
            }
            rVar.t(this.f23974a.f(), 0, 1);
            jS = ((jS << 8) & (-256)) | (this.f23974a.f()[0] & 255);
        }
        long jA = a(rVar);
        long j8 = this.f23975b;
        if (jA != Long.MIN_VALUE && (length == -1 || j8 + jA < length)) {
            while (true) {
                int i9 = this.f23975b;
                long j9 = j8 + jA;
                if (i9 < j9) {
                    if (a(rVar) == Long.MIN_VALUE) {
                        return false;
                    }
                    long jA2 = a(rVar);
                    if (jA2 < 0 || jA2 > 2147483647L) {
                        break;
                    }
                    if (jA2 != 0) {
                        int i10 = (int) jA2;
                        rVar.k(i10);
                        this.f23975b += i10;
                    }
                } else if (i9 == j9) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
