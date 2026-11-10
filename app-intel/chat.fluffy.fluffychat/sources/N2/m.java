package N2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class m extends f {
    public m(i iVar, d dVar, int i7) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVar.f6354a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f6367a = iVar.r(byteBufferAllocate, dVar.f6357d + (i7 * dVar.f6360g) + 44);
    }
}
