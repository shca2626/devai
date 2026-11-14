package m0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: m0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1319b extends C1320c {
    public static C1319b h(ByteBuffer byteBuffer) {
        return i(byteBuffer, new C1319b());
    }

    public static C1319b i(ByteBuffer byteBuffer, C1319b c1319b) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return c1319b.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public C1319b f(int i7, ByteBuffer byteBuffer) {
        g(i7, byteBuffer);
        return this;
    }

    public void g(int i7, ByteBuffer byteBuffer) {
        c(i7, byteBuffer);
    }

    public C1318a j(C1318a c1318a, int i7) {
        int iB = b(6);
        if (iB != 0) {
            return c1318a.f(a(d(iB) + (i7 * 4)), this.f19691b);
        }
        return null;
    }

    public int k() {
        int iB = b(6);
        if (iB != 0) {
            return e(iB);
        }
        return 0;
    }

    public int l() {
        int iB = b(4);
        if (iB != 0) {
            return this.f19691b.getInt(iB + this.f19690a);
        }
        return 0;
    }
}
