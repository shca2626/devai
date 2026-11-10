package l3;

import j3.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import m3.d;

/* renamed from: l3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1305b {

    /* renamed from: a, reason: collision with root package name */
    public static final OutputStream f19578a = new a();

    /* renamed from: l3.b$a */
    public class a extends OutputStream {
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i7) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            o.q(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i7, int i8) {
            o.q(bArr);
            o.u(i7, i8 + i7, bArr.length);
        }
    }

    public static byte[] a(Queue queue, int i7) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        if (bArr.length == i7) {
            return bArr;
        }
        int length = i7 - bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i7);
        while (length > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i7 - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static byte[] b(InputStream inputStream) {
        o.q(inputStream);
        return c(inputStream, new ArrayDeque(20), 0);
    }

    public static byte[] c(InputStream inputStream, Queue queue, int i7) throws IOException {
        int iMin = Math.min(8192, Math.max(128, Integer.highestOneBit(i7) * 2));
        while (i7 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i7);
            byte[] bArr = new byte[iMin2];
            queue.add(bArr);
            int i8 = 0;
            while (i8 < iMin2) {
                int i9 = inputStream.read(bArr, i8, iMin2 - i8);
                if (i9 == -1) {
                    return a(queue, i7);
                }
                i8 += i9;
                i7 += i9;
            }
            iMin = d.g(iMin, iMin < 4096 ? 4 : 2);
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
