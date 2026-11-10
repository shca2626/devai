package K0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public abstract class o0 {
    public static ByteBuffer a(ByteBuffer byteBuffer, int i7, int i8, int i9, int i10) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(byteBuffer.remaining()).order(ByteOrder.nativeOrder());
        int iPosition = byteBuffer.position();
        while (byteBuffer.hasRemaining() && i9 < i10) {
            c(byteBufferOrder, (int) ((b(byteBuffer, i7) * i9) / i10), i7);
            if (byteBuffer.position() == iPosition + i8) {
                i9++;
                iPosition = byteBuffer.position();
            }
        }
        byteBufferOrder.put(byteBuffer);
        byteBufferOrder.flip();
        return byteBufferOrder;
    }

    public static int b(ByteBuffer byteBuffer, int i7) {
        if (i7 == 2) {
            return ((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 16);
        }
        if (i7 == 3) {
            return (byteBuffer.get() & 255) << 24;
        }
        if (i7 == 4) {
            float fN = E0.U.n(byteBuffer.getFloat(), -1.0f, 1.0f);
            return fN < 0.0f ? (int) ((-fN) * (-2.1474836E9f)) : (int) (fN * 2.1474836E9f);
        }
        if (i7 == 21) {
            return ((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 8) | ((byteBuffer.get() & 255) << 16);
        }
        if (i7 == 22) {
            return ((byteBuffer.get() & 255) << 24) | (byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 8) | ((byteBuffer.get() & 255) << 16);
        }
        if (i7 == 268435456) {
            return ((byteBuffer.get() & 255) << 16) | ((byteBuffer.get() & 255) << 24);
        }
        if (i7 == 1342177280) {
            return ((byteBuffer.get() & 255) << 8) | ((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 16);
        }
        if (i7 == 1610612736) {
            return (byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 16) | ((byteBuffer.get() & 255) << 8);
        }
        throw new IllegalStateException();
    }

    public static void c(ByteBuffer byteBuffer, int i7, int i8) {
        if (i8 == 2) {
            byteBuffer.put((byte) (i7 >> 16));
            byteBuffer.put((byte) (i7 >> 24));
            return;
        }
        if (i8 == 3) {
            byteBuffer.put((byte) (i7 >> 24));
            return;
        }
        if (i8 == 4) {
            if (i7 < 0) {
                byteBuffer.putFloat((-i7) / (-2.1474836E9f));
                return;
            } else {
                byteBuffer.putFloat(i7 / 2.1474836E9f);
                return;
            }
        }
        if (i8 == 21) {
            byteBuffer.put((byte) (i7 >> 8));
            byteBuffer.put((byte) (i7 >> 16));
            byteBuffer.put((byte) (i7 >> 24));
            return;
        }
        if (i8 == 22) {
            byteBuffer.put((byte) i7);
            byteBuffer.put((byte) (i7 >> 8));
            byteBuffer.put((byte) (i7 >> 16));
            byteBuffer.put((byte) (i7 >> 24));
            return;
        }
        if (i8 == 268435456) {
            byteBuffer.put((byte) (i7 >> 24));
            byteBuffer.put((byte) (i7 >> 16));
            return;
        }
        if (i8 == 1342177280) {
            byteBuffer.put((byte) (i7 >> 24));
            byteBuffer.put((byte) (i7 >> 16));
            byteBuffer.put((byte) (i7 >> 8));
        } else {
            if (i8 != 1610612736) {
                throw new IllegalStateException();
            }
            byteBuffer.put((byte) (i7 >> 24));
            byteBuffer.put((byte) (i7 >> 16));
            byteBuffer.put((byte) (i7 >> 8));
            byteBuffer.put((byte) i7);
        }
    }
}
