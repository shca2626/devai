package m0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: m0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1320b extends C1321c {
    public static C1320b h(ByteBuffer byteBuffer) {
        return i(byteBuffer, new C1320b());
    }

    public static C1320b i(ByteBuffer byteBuffer, C1320b c1320b) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return c1320b.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public C1320b f(int i7, ByteBuffer byteBuffer) {
        g(i7, byteBuffer);
        return this;
    }

    public void g(int i7, ByteBuffer byteBuffer) {
        c(i7, byteBuffer);
    }

    public C1319a j(C1319a c1319a, int i7) {
        int iB = b(6);
        if (iB != 0) {
            return c1319a.f(a(d(iB) + (i7 * 4)), this.f19692b);
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
            return this.f19692b.getInt(iB + this.f19691a);
        }
        return 0;
    }
}
