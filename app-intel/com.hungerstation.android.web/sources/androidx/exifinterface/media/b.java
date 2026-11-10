package androidx.exifinterface.media;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.ErrnoException;
import android.system.Os;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes7.dex */
class b {

    static class a {
        static void a(FileDescriptor fileDescriptor) throws ErrnoException {
            Os.close(fileDescriptor);
        }

        static FileDescriptor b(FileDescriptor fileDescriptor) throws ErrnoException {
            return Os.dup(fileDescriptor);
        }

        static long c(FileDescriptor fileDescriptor, long j12, int i12) throws ErrnoException {
            return Os.lseek(fileDescriptor, j12, i12);
        }
    }

    /* renamed from: androidx.exifinterface.media.b$b, reason: collision with other inner class name */
    static class C0137b {
        static void a(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(mediaDataSource);
        }
    }

    static void a(FileDescriptor fileDescriptor) {
        try {
            a.a(fileDescriptor);
        } catch (Exception unused) {
        }
    }

    static void b(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e12) {
                throw e12;
            } catch (Exception unused) {
            }
        }
    }

    static long[] c(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i12 = 0; i12 < iArr.length; i12++) {
            jArr[i12] = iArr[i12];
        }
        return jArr;
    }

    static int d(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i12 = 0;
        while (true) {
            int i13 = inputStream.read(bArr);
            if (i13 == -1) {
                return i12;
            }
            i12 += i13;
            outputStream.write(bArr, 0, i13);
        }
    }

    static void e(InputStream inputStream, OutputStream outputStream, int i12) throws IOException {
        byte[] bArr = new byte[8192];
        while (i12 > 0) {
            int iMin = Math.min(i12, 8192);
            int i13 = inputStream.read(bArr, 0, iMin);
            if (i13 != iMin) {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
            i12 -= i13;
            outputStream.write(bArr, 0, i13);
        }
    }

    static boolean f(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i12 = 0; i12 < bArr2.length; i12++) {
            if (bArr[i12] != bArr2[i12]) {
                return false;
            }
        }
        return true;
    }
}
