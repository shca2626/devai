package r1;

import B0.y;
import E0.E;
import j3.o;
import java.nio.ByteBuffer;
import java.util.Arrays;
import p1.d;

/* renamed from: r1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1560b extends d {
    @Override // p1.d
    public y b(p1.b bVar, ByteBuffer byteBuffer) {
        return new y(c(new E(byteBuffer.array(), byteBuffer.limit())));
    }

    public C1559a c(E e7) {
        return new C1559a((String) o.q(e7.K()), (String) o.q(e7.K()), e7.J(), e7.J(), Arrays.copyOfRange(e7.f(), e7.g(), e7.j()));
    }
}
