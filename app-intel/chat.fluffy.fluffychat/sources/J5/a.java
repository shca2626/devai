package J5;

import M5.m;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class a {
    public static final long a(InputStream inputStream, OutputStream outputStream, int i7) throws IOException {
        m.e(inputStream, "<this>");
        m.e(outputStream, "out");
        byte[] bArr = new byte[i7];
        int i8 = inputStream.read(bArr);
        long j7 = 0;
        while (i8 >= 0) {
            outputStream.write(bArr, 0, i8);
            j7 += i8;
            i8 = inputStream.read(bArr);
        }
        return j7;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 8192;
        }
        return a(inputStream, outputStream, i7);
    }

    public static final byte[] c(InputStream inputStream) {
        m.e(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        b(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        m.d(byteArray, "toByteArray(...)");
        return byteArray;
    }
}
