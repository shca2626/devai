package N2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class b extends c {
    public b(i iVar, d dVar, long j7, int i7) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVar.f6354a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j8 = j7 + (i7 * 16);
        this.f6352a = iVar.n(byteBufferAllocate, j8);
        this.f6353b = iVar.n(byteBufferAllocate, j8 + 8);
    }
}
