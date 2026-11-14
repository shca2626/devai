package p1;

import B0.y;
import j3.o;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class d implements InterfaceC1437a {
    @Override // p1.InterfaceC1437a
    public final y a(b bVar) {
        ByteBuffer byteBuffer = (ByteBuffer) o.q(bVar.f3330o);
        o.d(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        return b(bVar, byteBuffer);
    }

    public abstract y b(b bVar, ByteBuffer byteBuffer);
}
