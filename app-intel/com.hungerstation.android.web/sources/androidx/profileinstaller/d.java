package androidx.profileinstaller;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* loaded from: classes7.dex */
class d {
    static int a(int i12) {
        return ((i12 + 7) & (-8)) / 8;
    }

    static byte[] b(byte[] bArr) throws IOException {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th2) {
            deflater.end();
            throw th2;
        }
    }

    static RuntimeException c(String str) {
        return new IllegalStateException(str);
    }

    static byte[] d(InputStream inputStream, int i12) throws IOException {
        byte[] bArr = new byte[i12];
        int i13 = 0;
        while (i13 < i12) {
            int i14 = inputStream.read(bArr, i13, i12 - i13);
            if (i14 < 0) {
                throw c("Not enough bytes to read: " + i12);
            }
            i13 += i14;
        }
        return bArr;
    }

    static byte[] e(InputStream inputStream, int i12, int i13) throws IOException {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i13];
            byte[] bArr2 = new byte[2048];
            int i14 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i14 < i12) {
                int i15 = inputStream.read(bArr2);
                if (i15 < 0) {
                    throw c("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i12 + " bytes");
                }
                inflater.setInput(bArr2, 0, i15);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i13 - iInflate);
                    i14 += i15;
                } catch (DataFormatException e12) {
                    throw c(e12.getMessage());
                }
            }
            if (i14 == i12) {
                if (inflater.finished()) {
                    return bArr;
                }
                throw c("Inflater did not finish");
            }
            throw c("Didn't read enough bytes during decompression. expected=" + i12 + " actual=" + i14);
        } finally {
            inflater.end();
        }
    }

    static String f(InputStream inputStream, int i12) throws IOException {
        return new String(d(inputStream, i12), StandardCharsets.UTF_8);
    }

    static long g(InputStream inputStream, int i12) throws IOException {
        byte[] bArrD = d(inputStream, i12);
        long j12 = 0;
        for (int i13 = 0; i13 < i12; i13++) {
            j12 += (bArrD[i13] & 255) << (i13 * 8);
        }
        return j12;
    }

    static int h(InputStream inputStream) throws IOException {
        return (int) g(inputStream, 2);
    }

    static long i(InputStream inputStream) throws IOException {
        return g(inputStream, 4);
    }

    static int j(InputStream inputStream) throws IOException {
        return (int) g(inputStream, 1);
    }

    static int k(String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    static void l(InputStream inputStream, OutputStream outputStream, FileLock fileLock) throws IOException {
        if (fileLock == null || !fileLock.isValid()) {
            throw new IOException("Unable to acquire a lock on the underlying file channel.");
        }
        byte[] bArr = new byte[UserVerificationMethods.USER_VERIFY_NONE];
        while (true) {
            int i12 = inputStream.read(bArr);
            if (i12 <= 0) {
                return;
            } else {
                outputStream.write(bArr, 0, i12);
            }
        }
    }

    static void m(OutputStream outputStream, byte[] bArr) throws IOException {
        q(outputStream, bArr.length);
        byte[] bArrB = b(bArr);
        q(outputStream, bArrB.length);
        outputStream.write(bArrB);
    }

    static void n(OutputStream outputStream, String str) throws IOException {
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    static void o(OutputStream outputStream, long j12, int i12) throws IOException {
        byte[] bArr = new byte[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[i13] = (byte) ((j12 >> (i13 * 8)) & 255);
        }
        outputStream.write(bArr);
    }

    static void p(OutputStream outputStream, int i12) throws IOException {
        o(outputStream, i12, 2);
    }

    static void q(OutputStream outputStream, long j12) throws IOException {
        o(outputStream, j12, 4);
    }

    static void r(OutputStream outputStream, int i12) throws IOException {
        o(outputStream, i12, 1);
    }
}
