package K0;

import C0.u;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class r0 extends C0.w {

    /* renamed from: i, reason: collision with root package name */
    public int f5374i;

    /* renamed from: j, reason: collision with root package name */
    public int f5375j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5376k;

    /* renamed from: l, reason: collision with root package name */
    public int f5377l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f5378m = E0.U.f2098f;

    /* renamed from: n, reason: collision with root package name */
    public int f5379n;

    /* renamed from: o, reason: collision with root package name */
    public long f5380o;

    @Override // C0.w
    public u.a b(u.a aVar) throws u.c {
        if (!E0.U.E0(aVar.f1260c)) {
            throw new u.c(aVar);
        }
        this.f5376k = true;
        return (this.f5374i == 0 && this.f5375j == 0) ? u.a.f1257e : aVar;
    }

    @Override // C0.w
    public void c() {
        if (this.f5376k) {
            this.f5376k = false;
            int i7 = this.f5375j;
            int i8 = this.f1265b.f1261d;
            this.f5378m = new byte[i7 * i8];
            this.f5377l = this.f5374i * i8;
        }
        this.f5379n = 0;
    }

    @Override // C0.w, C0.u
    public boolean d() {
        return super.d() && this.f5379n == 0;
    }

    @Override // C0.w, C0.u
    public ByteBuffer f() {
        int i7;
        if (super.d() && (i7 = this.f5379n) > 0) {
            o(i7).put(this.f5378m, 0, this.f5379n).flip();
            this.f5379n = 0;
        }
        return super.f();
    }

    @Override // C0.u
    public void g(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i7 = iLimit - iPosition;
        if (i7 == 0) {
            return;
        }
        int iMin = Math.min(i7, this.f5377l);
        this.f5380o += iMin / this.f1265b.f1261d;
        this.f5377l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.f5377l > 0) {
            return;
        }
        int i8 = i7 - iMin;
        int length = (this.f5379n + i8) - this.f5378m.length;
        ByteBuffer byteBufferO = o(length);
        int iO = E0.U.o(length, 0, this.f5379n);
        byteBufferO.put(this.f5378m, 0, iO);
        int iO2 = E0.U.o(length - iO, 0, i8);
        byteBuffer.limit(byteBuffer.position() + iO2);
        byteBufferO.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i9 = i8 - iO2;
        int i10 = this.f5379n - iO;
        this.f5379n = i10;
        byte[] bArr = this.f5378m;
        System.arraycopy(bArr, iO, bArr, 0, i10);
        byteBuffer.get(this.f5378m, this.f5379n, i9);
        this.f5379n += i9;
        byteBufferO.flip();
    }

    @Override // C0.u
    public long k(long j7) {
        return Math.max(0L, j7 - E0.U.c1(this.f5375j + this.f5374i, this.f1265b.f1258a));
    }

    @Override // C0.w
    public void m() {
        if (this.f5376k) {
            if (this.f5379n > 0) {
                this.f5380o += r0 / this.f1265b.f1261d;
            }
            this.f5379n = 0;
        }
    }

    @Override // C0.w
    public void n() {
        this.f5378m = E0.U.f2098f;
    }

    public long p() {
        return this.f5380o;
    }

    public void q() {
        this.f5380o = 0L;
    }

    public void r(int i7, int i8) {
        this.f5374i = i7;
        this.f5375j = i8;
    }
}
