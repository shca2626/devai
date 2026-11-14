package Z4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import p0.C1435a;

/* loaded from: classes.dex */
public abstract class b {
    public static void a(byte[] bArr, p pVar) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                pVar.f10352e = new C1435a(byteArrayInputStream).i("Orientation", 1);
                byteArrayInputStream.close();
            } finally {
            }
        } catch (IOException e7) {
            U4.b.c("ExifMetadataReader", "Failed to read EXIF metadata", e7);
        }
    }
}
