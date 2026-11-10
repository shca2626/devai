package N2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class j extends e {
    public j(i iVar, d dVar, long j7) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f6354a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j8 = dVar.f6356c + (j7 * dVar.f6358e);
        this.f6363a = iVar.r(byteBufferAllocate, j8);
        this.f6364b = iVar.r(byteBufferAllocate, 4 + j8);
        this.f6365c = iVar.r(byteBufferAllocate, 8 + j8);
        this.f6366d = iVar.r(byteBufferAllocate, j8 + 20);
    }
}
