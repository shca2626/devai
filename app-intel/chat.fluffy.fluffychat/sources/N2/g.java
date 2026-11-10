package N2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class g extends d {

    /* renamed from: j, reason: collision with root package name */
    public final i f6368j;

    public g(boolean z7, i iVar) {
        this.f6354a = z7;
        this.f6368j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z7 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f6355b = iVar.j(byteBufferAllocate, 16L);
        this.f6356c = iVar.r(byteBufferAllocate, 28L);
        this.f6357d = iVar.r(byteBufferAllocate, 32L);
        this.f6358e = iVar.j(byteBufferAllocate, 42L);
        this.f6359f = iVar.j(byteBufferAllocate, 44L);
        this.f6360g = iVar.j(byteBufferAllocate, 46L);
        this.f6361h = iVar.j(byteBufferAllocate, 48L);
        this.f6362i = iVar.j(byteBufferAllocate, 50L);
    }

    @Override // N2.d
    public c a(long j7, int i7) {
        return new a(this.f6368j, this, j7, i7);
    }

    @Override // N2.d
    public e b(long j7) {
        return new j(this.f6368j, this, j7);
    }

    @Override // N2.d
    public f c(int i7) {
        return new l(this.f6368j, this, i7);
    }
}
