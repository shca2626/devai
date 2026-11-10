package K0;

import C0.u;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class q0 extends C0.w {

    /* renamed from: i, reason: collision with root package name */
    public static final int f5371i = Float.floatToIntBits(Float.NaN);

    public static void p(int i7, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (i7 * 4.656612875245797E-10d));
        if (iFloatToIntBits == f5371i) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // C0.w
    public u.a b(u.a aVar) throws u.c {
        int i7 = aVar.f1260c;
        if (E0.U.D0(i7) || i7 == 2) {
            return i7 != 4 ? new u.a(aVar.f1258a, aVar.f1259b, 4) : u.a.f1257e;
        }
        throw new u.c(aVar);
    }

    @Override // C0.u
    public void g(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferO;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i7 = iLimit - iPosition;
        int i8 = this.f1265b.f1260c;
        if (i8 == 2) {
            byteBufferO = o(i7 * 2);
            while (iPosition < iLimit) {
                p(((byteBuffer.get(iPosition) & 255) << 16) | ((byteBuffer.get(iPosition + 1) & 255) << 24), byteBufferO);
                iPosition += 2;
            }
        } else if (i8 == 1342177280) {
            byteBufferO = o((i7 / 3) * 4);
            while (iPosition < iLimit) {
                p(((byteBuffer.get(iPosition + 2) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferO);
                iPosition += 3;
            }
        } else if (i8 == 1610612736) {
            byteBufferO = o(i7);
            while (iPosition < iLimit) {
                p((byteBuffer.get(iPosition + 3) & 255) | ((byteBuffer.get(iPosition + 2) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferO);
                iPosition += 4;
            }
        } else if (i8 == 21) {
            byteBufferO = o((i7 / 3) * 4);
            while (iPosition < iLimit) {
                p(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferO);
                iPosition += 3;
            }
        } else {
            if (i8 != 22) {
                throw new IllegalStateException();
            }
            byteBufferO = o(i7);
            while (iPosition < iLimit) {
                p((byteBuffer.get(iPosition) & 255) | ((byteBuffer.get(iPosition + 1) & 255) << 8) | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferO);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferO.flip();
    }
}
