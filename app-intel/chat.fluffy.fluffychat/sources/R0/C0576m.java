package R0;

import java.nio.ByteBuffer;

/* renamed from: R0.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0576m extends H0.f {

    /* renamed from: u, reason: collision with root package name */
    public long f7836u;

    /* renamed from: v, reason: collision with root package name */
    public int f7837v;

    /* renamed from: w, reason: collision with root package name */
    public int f7838w;

    public C0576m() {
        super(2);
        this.f7838w = 32;
    }

    public long A() {
        return this.f7836u;
    }

    public int B() {
        return this.f7837v;
    }

    public boolean C() {
        return this.f7837v > 0;
    }

    public void D(int i7) {
        j3.o.d(i7 > 0);
        this.f7838w = i7;
    }

    @Override // H0.f, H0.a
    public void i() {
        super.i();
        this.f7837v = 0;
    }

    public boolean x(H0.f fVar) {
        j3.o.d(!fVar.u());
        j3.o.d(!fVar.k());
        j3.o.d(!fVar.l());
        if (!y(fVar)) {
            return false;
        }
        int i7 = this.f7837v;
        this.f7837v = i7 + 1;
        if (i7 == 0) {
            this.f3332q = fVar.f3332q;
            if (fVar.n()) {
                q(1);
            }
        }
        ByteBuffer byteBuffer = fVar.f3330o;
        if (byteBuffer != null) {
            s(byteBuffer.remaining());
            this.f3330o.put(byteBuffer);
        }
        this.f7836u = fVar.f3332q;
        return true;
    }

    public final boolean y(H0.f fVar) {
        ByteBuffer byteBuffer;
        if (!C()) {
            return true;
        }
        if (this.f7837v >= this.f7838w) {
            return false;
        }
        ByteBuffer byteBuffer2 = fVar.f3330o;
        return byteBuffer2 == null || (byteBuffer = this.f3330o) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    public long z() {
        return this.f3332q;
    }
}
