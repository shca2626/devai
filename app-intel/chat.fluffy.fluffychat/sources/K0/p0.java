package K0;

import C0.u;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class p0 extends C0.w {

    /* renamed from: i, reason: collision with root package name */
    public final float f5355i;

    /* renamed from: j, reason: collision with root package name */
    public final short f5356j;

    /* renamed from: k, reason: collision with root package name */
    public final int f5357k;

    /* renamed from: l, reason: collision with root package name */
    public final long f5358l;

    /* renamed from: m, reason: collision with root package name */
    public final long f5359m;

    /* renamed from: n, reason: collision with root package name */
    public int f5360n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5361o;

    /* renamed from: p, reason: collision with root package name */
    public int f5362p;

    /* renamed from: q, reason: collision with root package name */
    public long f5363q;

    /* renamed from: r, reason: collision with root package name */
    public int f5364r;

    /* renamed from: s, reason: collision with root package name */
    public byte[] f5365s;

    /* renamed from: t, reason: collision with root package name */
    public int f5366t;

    /* renamed from: u, reason: collision with root package name */
    public int f5367u;

    /* renamed from: v, reason: collision with root package name */
    public byte[] f5368v;

    public p0() {
        this(100000L, 0.2f, 2000000L, 10, (short) 1024);
    }

    public static void F(byte[] bArr, int i7, int i8) {
        if (i8 >= 32767) {
            bArr[i7] = -1;
            bArr[i7 + 1] = Byte.MAX_VALUE;
        } else if (i8 <= -32768) {
            bArr[i7] = 0;
            bArr[i7 + 1] = Byte.MIN_VALUE;
        } else {
            bArr[i7] = (byte) (i8 & 255);
            bArr[i7 + 1] = (byte) (i8 >> 8);
        }
    }

    public static int I(byte b7, byte b8) {
        return (b7 << 8) | (b8 & 255);
    }

    public final void A(ByteBuffer byteBuffer) {
        o(byteBuffer.remaining()).put(byteBuffer).flip();
    }

    public final void B(byte[] bArr, int i7, int i8) {
        j3.o.g(i7 % this.f5360n == 0, "byteOutput size is not aligned to frame size %s", i7);
        z(bArr, i7, i8);
        o(i7).put(bArr, 0, i7).flip();
    }

    public final void C(boolean z7) {
        int length;
        int iT;
        int i7 = this.f5367u;
        byte[] bArr = this.f5365s;
        if (i7 == bArr.length || z7) {
            if (this.f5364r == 0) {
                if (z7) {
                    D(i7, 3);
                    length = i7;
                } else {
                    j3.o.v(i7 >= bArr.length / 2);
                    length = this.f5365s.length / 2;
                    D(length, 0);
                }
                iT = length;
            } else if (z7) {
                int length2 = i7 - (bArr.length / 2);
                int length3 = (bArr.length / 2) + length2;
                int iT2 = t(length2) + (this.f5365s.length / 2);
                D(iT2, 2);
                iT = iT2;
                length = length3;
            } else {
                length = i7 - (bArr.length / 2);
                iT = t(length);
                D(iT, 1);
            }
            j3.o.y(length % this.f5360n == 0, "bytesConsumed is not aligned to frame size: %s", length);
            j3.o.v(i7 >= iT);
            this.f5367u -= length;
            int i8 = this.f5366t + length;
            this.f5366t = i8;
            this.f5366t = i8 % this.f5365s.length;
            this.f5364r = this.f5364r + (iT / this.f5360n);
            this.f5363q += (length - iT) / r2;
        }
    }

    public final void D(int i7, int i8) {
        if (i7 == 0) {
            return;
        }
        j3.o.d(this.f5367u >= i7);
        if (i8 == 2) {
            int i9 = this.f5366t;
            int i10 = this.f5367u;
            int i11 = i9 + i10;
            byte[] bArr = this.f5365s;
            if (i11 <= bArr.length) {
                System.arraycopy(bArr, (i9 + i10) - i7, this.f5368v, 0, i7);
            } else {
                int length = i10 - (bArr.length - i9);
                if (length >= i7) {
                    System.arraycopy(bArr, length - i7, this.f5368v, 0, i7);
                } else {
                    int i12 = i7 - length;
                    System.arraycopy(bArr, bArr.length - i12, this.f5368v, 0, i12);
                    System.arraycopy(this.f5365s, 0, this.f5368v, i12, length);
                }
            }
        } else {
            int i13 = this.f5366t;
            int i14 = i13 + i7;
            byte[] bArr2 = this.f5365s;
            if (i14 <= bArr2.length) {
                System.arraycopy(bArr2, i13, this.f5368v, 0, i7);
            } else {
                int length2 = bArr2.length - i13;
                System.arraycopy(bArr2, i13, this.f5368v, 0, length2);
                System.arraycopy(this.f5365s, 0, this.f5368v, length2, i7 - length2);
            }
        }
        j3.o.g(i7 % this.f5360n == 0, "sizeToOutput is not aligned to frame size: %s", i7);
        j3.o.v(this.f5366t < this.f5365s.length);
        B(this.f5368v, i7, i8);
    }

    public final void E(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.f5365s.length));
        int iV = v(byteBuffer);
        if (iV == byteBuffer.position()) {
            this.f5362p = 1;
        } else {
            byteBuffer.limit(Math.min(iV, byteBuffer.capacity()));
            A(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    public void G(boolean z7) {
        this.f5361o = z7;
    }

    public final void H(ByteBuffer byteBuffer) {
        int length;
        int i7;
        j3.o.v(this.f5366t < this.f5365s.length);
        int iLimit = byteBuffer.limit();
        int iW = w(byteBuffer);
        int iPosition = iW - byteBuffer.position();
        int i8 = this.f5366t;
        int i9 = this.f5367u;
        int i10 = i8 + i9;
        byte[] bArr = this.f5365s;
        if (i10 < bArr.length) {
            length = bArr.length - (i9 + i8);
            i7 = i8 + i9;
        } else {
            int length2 = i9 - (bArr.length - i8);
            length = i8 - length2;
            i7 = length2;
        }
        boolean z7 = iW < iLimit;
        int iMin = Math.min(iPosition, length);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.f5365s, i7, iMin);
        int i11 = this.f5367u + iMin;
        this.f5367u = i11;
        j3.o.v(i11 <= this.f5365s.length);
        boolean z8 = z7 && iPosition < length;
        C(z8);
        if (z8) {
            this.f5362p = 0;
            this.f5364r = 0;
        }
        byteBuffer.limit(iLimit);
    }

    @Override // C0.w
    public u.a b(u.a aVar) throws u.c {
        if (aVar.f1260c == 2) {
            return aVar.f1258a == -1 ? u.a.f1257e : aVar;
        }
        throw new u.c(aVar);
    }

    @Override // C0.w
    public void c() {
        if (e()) {
            this.f5360n = this.f1265b.f1259b * 2;
            int iQ = q(u(this.f5358l) / 2) * 2;
            if (this.f5365s.length != iQ) {
                this.f5365s = new byte[iQ];
                this.f5368v = new byte[iQ];
            }
        }
        this.f5362p = 0;
        this.f5363q = 0L;
        this.f5364r = 0;
        this.f5366t = 0;
        this.f5367u = 0;
    }

    @Override // C0.w, C0.u
    public boolean e() {
        return super.e() && this.f5361o;
    }

    @Override // C0.u
    public void g(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !a()) {
            int i7 = this.f5362p;
            if (i7 == 0) {
                E(byteBuffer);
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException();
                }
                H(byteBuffer);
            }
        }
    }

    @Override // C0.w
    public void m() {
        if (this.f5367u > 0) {
            C(true);
            this.f5364r = 0;
        }
    }

    @Override // C0.w
    public void n() {
        this.f5361o = false;
        byte[] bArr = E0.U.f2098f;
        this.f5365s = bArr;
        this.f5368v = bArr;
    }

    public final int p(float f7) {
        return q((int) f7);
    }

    public final int q(int i7) {
        int i8 = this.f5360n;
        return (i7 / i8) * i8;
    }

    public final int r(int i7, int i8) {
        int i9 = this.f5357k;
        return i9 + ((((100 - i9) * (i7 * 1000)) / i8) / 1000);
    }

    public final int s(int i7, int i8) {
        return (((this.f5357k - 100) * ((i7 * 1000) / i8)) / 1000) + 100;
    }

    public final int t(int i7) {
        int iU = ((u(this.f5359m) - this.f5364r) * this.f5360n) - (this.f5365s.length / 2);
        j3.o.v(iU >= 0);
        return p(Math.min((i7 * this.f5355i) + 0.5f, iU));
    }

    public final int u(long j7) {
        return (int) ((j7 * this.f1265b.f1258a) / 1000000);
    }

    public final int v(ByteBuffer byteBuffer) {
        for (int iLimit = byteBuffer.limit() - 1; iLimit >= byteBuffer.position(); iLimit -= 2) {
            if (y(byteBuffer.get(iLimit), byteBuffer.get(iLimit - 1))) {
                int i7 = this.f5360n;
                return ((iLimit / i7) * i7) + i7;
            }
        }
        return byteBuffer.position();
    }

    public final int w(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position() + 1; iPosition < byteBuffer.limit(); iPosition += 2) {
            if (y(byteBuffer.get(iPosition), byteBuffer.get(iPosition - 1))) {
                int i7 = this.f5360n;
                return i7 * (iPosition / i7);
            }
        }
        return byteBuffer.limit();
    }

    public long x() {
        return this.f5363q;
    }

    public final boolean y(byte b7, byte b8) {
        return Math.abs(I(b7, b8)) > this.f5356j;
    }

    public final void z(byte[] bArr, int i7, int i8) {
        if (i8 == 3) {
            return;
        }
        for (int i9 = 0; i9 < i7; i9 += 2) {
            F(bArr, i9, (I(bArr[i9 + 1], bArr[i9]) * (i8 == 0 ? s(i9, i7 - 1) : i8 == 2 ? r(i9, i7 - 1) : this.f5357k)) / 100);
        }
    }

    public p0(long j7, float f7, long j8, int i7, short s7) {
        boolean z7 = false;
        this.f5364r = 0;
        this.f5366t = 0;
        this.f5367u = 0;
        if (f7 >= 0.0f && f7 <= 1.0f) {
            z7 = true;
        }
        j3.o.d(z7);
        this.f5358l = j7;
        this.f5355i = f7;
        this.f5359m = j8;
        this.f5357k = i7;
        this.f5356j = s7;
        byte[] bArr = E0.U.f2098f;
        this.f5365s = bArr;
        this.f5368v = bArr;
    }
}
