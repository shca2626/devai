package N2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class h extends d {

    /* renamed from: j, reason: collision with root package name */
    public final i f6369j;

    public h(boolean z7, i iVar) {
        this.f6354a = z7;
        this.f6369j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z7 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f6355b = iVar.j(byteBufferAllocate, 16L);
        this.f6356c = iVar.n(byteBufferAllocate, 32L);
        this.f6357d = iVar.n(byteBufferAllocate, 40L);
        this.f6358e = iVar.j(byteBufferAllocate, 54L);
        this.f6359f = iVar.j(byteBufferAllocate, 56L);
        this.f6360g = iVar.j(byteBufferAllocate, 58L);
        this.f6361h = iVar.j(byteBufferAllocate, 60L);
        this.f6362i = iVar.j(byteBufferAllocate, 62L);
    }

    @Override // N2.d
    public c a(long j7, int i7) {
        return new b(this.f6369j, this, j7, i7);
    }

    @Override // N2.d
    public e b(long j7) {
        return new k(this.f6369j, this, j7);
    }

    @Override // N2.d
    public f c(int i7) {
        return new m(this.f6369j, this, i7);
    }
}
