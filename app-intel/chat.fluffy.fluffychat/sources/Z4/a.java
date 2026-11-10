package Z4;

import android.graphics.BitmapFactory;

/* loaded from: classes.dex */
public class a {
    public static void a(byte[] bArr, p pVar) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            pVar.f10351d = options.outMimeType;
            pVar.f10353f = options.outHeight;
            pVar.f10354g = options.outWidth;
        } catch (Exception e7) {
            U4.b.c("BitmapMetadataReader", "Failed to decode image for mime type", e7);
        }
    }
}
