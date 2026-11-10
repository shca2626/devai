package com.google.firebase.messaging;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* loaded from: classes8.dex */
final class b {
    private static byte[] a(Queue<byte[]> queue, int i12) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArrRemove = queue.remove();
        if (bArrRemove.length == i12) {
            return bArrRemove;
        }
        int length = i12 - bArrRemove.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArrRemove, i12);
        while (length > 0) {
            byte[] bArrRemove2 = queue.remove();
            int iMin = Math.min(length, bArrRemove2.length);
            System.arraycopy(bArrRemove2, 0, bArrCopyOf, i12 - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static InputStream b(InputStream inputStream, long j12) {
        return new a(inputStream, j12);
    }

    private static int c(long j12) {
        if (j12 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j12 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j12;
    }

    public static byte[] d(InputStream inputStream) throws IOException {
        return e(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] e(InputStream inputStream, Queue<byte[]> queue, int i12) throws IOException {
        int iMin = Math.min(8192, Math.max(UserVerificationMethods.USER_VERIFY_PATTERN, Integer.highestOneBit(i12) * 2));
        while (i12 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i12);
            byte[] bArr = new byte[iMin2];
            queue.add(bArr);
            int i13 = 0;
            while (i13 < iMin2) {
                int i14 = inputStream.read(bArr, i13, iMin2 - i13);
                if (i14 == -1) {
                    return a(queue, i12);
                }
                i13 += i14;
                i12 += i14;
            }
            iMin = c(iMin * (iMin < 4096 ? 4 : 2));
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static final class a extends FilterInputStream {

        /* renamed from: b, reason: collision with root package name */
        private long f24325b;

        /* renamed from: c, reason: collision with root package name */
        private long f24326c;

        a(InputStream inputStream, long j12) {
            super(inputStream);
            this.f24326c = -1L;
            this.f24325b = j12;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.f24325b);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i12) {
            ((FilterInputStream) this).in.mark(i12);
            this.f24326c = this.f24325b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.f24325b == 0) {
                return -1;
            }
            int i12 = ((FilterInputStream) this).in.read();
            if (i12 != -1) {
                this.f24325b--;
            }
            return i12;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f24326c == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f24325b = this.f24326c;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j12) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(Math.min(j12, this.f24325b));
            this.f24325b -= jSkip;
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i12, int i13) throws IOException {
            long j12 = this.f24325b;
            if (j12 == 0) {
                return -1;
            }
            int i14 = ((FilterInputStream) this).in.read(bArr, i12, (int) Math.min(i13, j12));
            if (i14 != -1) {
                this.f24325b -= i14;
            }
            return i14;
        }
    }
}
