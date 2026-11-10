package K0;

import C0.u;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class e0 extends C0.w {

    /* renamed from: i, reason: collision with root package name */
    public int[] f5140i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f5141j;

    @Override // C0.w
    public u.a b(u.a aVar) throws u.c {
        int[] iArr = this.f5140i;
        if (iArr == null) {
            return u.a.f1257e;
        }
        if (!E0.U.E0(aVar.f1260c)) {
            throw new u.c(aVar);
        }
        boolean z7 = aVar.f1259b != iArr.length;
        int i7 = 0;
        while (i7 < iArr.length) {
            int i8 = iArr[i7];
            if (i8 >= aVar.f1259b) {
                throw new u.c("Channel map (" + Arrays.toString(iArr) + ") trying to access non-existent input channel.", aVar);
            }
            z7 |= i8 != i7;
            i7++;
        }
        return z7 ? new u.a(aVar.f1258a, iArr.length, aVar.f1260c) : u.a.f1257e;
    }

    @Override // C0.w
    public void c() {
        this.f5141j = this.f5140i;
    }

    @Override // C0.u
    public void g(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) j3.o.q(this.f5141j);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferO = o(((iLimit - iPosition) / this.f1265b.f1261d) * this.f1266c.f1261d);
        while (iPosition < iLimit) {
            for (int i7 : iArr) {
                int iQ = (E0.U.Q(this.f1265b.f1260c) * i7) + iPosition;
                int i8 = this.f1265b.f1260c;
                if (i8 == 2) {
                    byteBufferO.putShort(byteBuffer.getShort(iQ));
                } else if (i8 == 3) {
                    byteBufferO.put(byteBuffer.get(iQ));
                } else if (i8 == 4) {
                    byteBufferO.putFloat(byteBuffer.getFloat(iQ));
                } else if (i8 == 21) {
                    E0.U.a1(byteBufferO, E0.U.d0(byteBuffer, iQ));
                } else {
                    if (i8 != 22) {
                        if (i8 != 268435456) {
                            if (i8 != 1342177280) {
                                if (i8 != 1610612736) {
                                    throw new IllegalStateException("Unexpected encoding: " + this.f1265b.f1260c);
                                }
                            }
                            E0.U.a1(byteBufferO, E0.U.d0(byteBuffer, iQ));
                        }
                        byteBufferO.putShort(byteBuffer.getShort(iQ));
                    }
                    byteBufferO.putInt(byteBuffer.getInt(iQ));
                }
            }
            iPosition += this.f1265b.f1261d;
        }
        byteBuffer.position(iLimit);
        byteBufferO.flip();
    }

    @Override // C0.w
    public void n() {
        this.f5141j = null;
        this.f5140i = null;
    }

    public void p(int[] iArr) {
        this.f5140i = iArr;
    }
}
