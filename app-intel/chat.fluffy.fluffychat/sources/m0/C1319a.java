package m0;

import java.nio.ByteBuffer;

/* renamed from: m0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1319a extends C1321c {
    public C1319a f(int i7, ByteBuffer byteBuffer) {
        g(i7, byteBuffer);
        return this;
    }

    public void g(int i7, ByteBuffer byteBuffer) {
        c(i7, byteBuffer);
    }

    public int h(int i7) {
        int iB = b(16);
        if (iB != 0) {
            return this.f19692b.getInt(d(iB) + (i7 * 4));
        }
        return 0;
    }

    public int i() {
        int iB = b(16);
        if (iB != 0) {
            return e(iB);
        }
        return 0;
    }

    public boolean j() {
        int iB = b(6);
        return (iB == 0 || this.f19692b.get(iB + this.f19691a) == 0) ? false : true;
    }

    public short k() {
        int iB = b(14);
        if (iB != 0) {
            return this.f19692b.getShort(iB + this.f19691a);
        }
        return (short) 0;
    }

    public int l() {
        int iB = b(4);
        if (iB != 0) {
            return this.f19692b.getInt(iB + this.f19691a);
        }
        return 0;
    }

    public short m() {
        int iB = b(8);
        if (iB != 0) {
            return this.f19692b.getShort(iB + this.f19691a);
        }
        return (short) 0;
    }

    public short n() {
        int iB = b(12);
        if (iB != 0) {
            return this.f19692b.getShort(iB + this.f19691a);
        }
        return (short) 0;
    }
}
