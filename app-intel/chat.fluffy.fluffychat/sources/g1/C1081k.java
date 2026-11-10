package g1;

import B0.InterfaceC0309k;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* renamed from: g1.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1081k implements r {

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0309k f16101b;

    /* renamed from: c, reason: collision with root package name */
    public final long f16102c;

    /* renamed from: d, reason: collision with root package name */
    public long f16103d;

    /* renamed from: f, reason: collision with root package name */
    public int f16105f;

    /* renamed from: g, reason: collision with root package name */
    public int f16106g;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f16104e = new byte[65536];

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f16100a = new byte[4096];

    static {
        B0.w.a("media3.extractor");
    }

    public C1081k(InterfaceC0309k interfaceC0309k, long j7, long j8) {
        this.f16101b = interfaceC0309k;
        this.f16103d = j7;
        this.f16102c = j8;
    }

    @Override // g1.r
    public int a(int i7) throws EOFException, InterruptedIOException {
        int iX = x(i7);
        if (iX == 0) {
            byte[] bArr = this.f16100a;
            iX = w(bArr, 0, Math.min(i7, bArr.length), 0, true);
        }
        f(iX);
        return iX;
    }

    @Override // g1.r
    public boolean c(byte[] bArr, int i7, int i8, boolean z7) throws EOFException, InterruptedIOException {
        int iV = v(bArr, i7, i8);
        while (iV < i8 && iV != -1) {
            iV = w(bArr, i7, i8, iV, z7);
        }
        f(iV);
        return iV != -1;
    }

    public final void f(int i7) {
        if (i7 != -1) {
            this.f16103d += i7;
        }
    }

    @Override // g1.r
    public boolean g(int i7, boolean z7) throws EOFException, InterruptedIOException {
        int iX = x(i7);
        while (iX < i7 && iX != -1) {
            iX = w(this.f16100a, -iX, Math.min(i7, this.f16100a.length + iX), iX, z7);
        }
        f(iX);
        return iX != -1;
    }

    @Override // g1.r
    public long getLength() {
        return this.f16102c;
    }

    @Override // g1.r
    public long getPosition() {
        return this.f16103d;
    }

    @Override // g1.r
    public boolean h(byte[] bArr, int i7, int i8, boolean z7) {
        if (!q(i8, z7)) {
            return false;
        }
        System.arraycopy(this.f16104e, this.f16105f - i8, bArr, i7, i8);
        return true;
    }

    @Override // g1.r
    public long i() {
        return this.f16103d + this.f16105f;
    }

    @Override // g1.r
    public void k(int i7) throws EOFException, InterruptedIOException {
        q(i7, false);
    }

    @Override // g1.r
    public int m(byte[] bArr, int i7, int i8) throws EOFException, InterruptedIOException {
        C1081k c1081k;
        int iMin;
        u(i8);
        int i9 = this.f16106g;
        int i10 = this.f16105f;
        int i11 = i9 - i10;
        if (i11 == 0) {
            c1081k = this;
            iMin = c1081k.w(this.f16104e, i10, i8, 0, true);
            if (iMin == -1) {
                return -1;
            }
            c1081k.f16106g += iMin;
        } else {
            c1081k = this;
            iMin = Math.min(i8, i11);
        }
        System.arraycopy(c1081k.f16104e, c1081k.f16105f, bArr, i7, iMin);
        c1081k.f16105f += iMin;
        return iMin;
    }

    @Override // g1.r
    public void o() {
        this.f16105f = 0;
    }

    @Override // g1.r
    public void p(int i7) throws EOFException, InterruptedIOException {
        g(i7, false);
    }

    @Override // g1.r
    public boolean q(int i7, boolean z7) throws EOFException, InterruptedIOException {
        u(i7);
        int iW = this.f16106g - this.f16105f;
        while (iW < i7) {
            int i8 = i7;
            boolean z8 = z7;
            iW = w(this.f16104e, this.f16105f, i8, iW, z8);
            if (iW == -1) {
                return false;
            }
            this.f16106g = this.f16105f + iW;
            i7 = i8;
            z7 = z8;
        }
        this.f16105f += i7;
        return true;
    }

    @Override // g1.r, B0.InterfaceC0309k
    public int read(byte[] bArr, int i7, int i8) throws EOFException, InterruptedIOException {
        int iV = v(bArr, i7, i8);
        if (iV == 0) {
            iV = w(bArr, i7, i8, 0, true);
        }
        f(iV);
        return iV;
    }

    @Override // g1.r
    public void readFully(byte[] bArr, int i7, int i8) throws EOFException, InterruptedIOException {
        c(bArr, i7, i8, false);
    }

    @Override // g1.r
    public void t(byte[] bArr, int i7, int i8) {
        h(bArr, i7, i8, false);
    }

    public final void u(int i7) {
        int i8 = this.f16105f + i7;
        byte[] bArr = this.f16104e;
        if (i8 > bArr.length) {
            this.f16104e = Arrays.copyOf(this.f16104e, E0.U.o(bArr.length * 2, 65536 + i8, i8 + 524288));
        }
    }

    public final int v(byte[] bArr, int i7, int i8) {
        int i9 = this.f16106g;
        if (i9 == 0) {
            return 0;
        }
        int iMin = Math.min(i9, i8);
        System.arraycopy(this.f16104e, 0, bArr, i7, iMin);
        y(iMin);
        return iMin;
    }

    public final int w(byte[] bArr, int i7, int i8, int i9, boolean z7) throws EOFException, InterruptedIOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i10 = this.f16101b.read(bArr, i7 + i9, i8 - i9);
        if (i10 != -1) {
            return i9 + i10;
        }
        if (i9 == 0 && z7) {
            return -1;
        }
        throw new EOFException();
    }

    public final int x(int i7) {
        int iMin = Math.min(this.f16106g, i7);
        y(iMin);
        return iMin;
    }

    public final void y(int i7) {
        int i8 = this.f16106g - i7;
        this.f16106g = i8;
        this.f16105f = 0;
        byte[] bArr = this.f16104e;
        byte[] bArr2 = i8 < bArr.length - 524288 ? new byte[65536 + i8] : bArr;
        System.arraycopy(bArr, i7, bArr2, 0, i8);
        this.f16104e = bArr2;
    }
}
