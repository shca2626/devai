package Z4;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class n {
    public static Bitmap a(Bitmap bitmap, int i7) {
        if (bitmap == null || !c(i7)) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        if (i7 == 2 || i7 == 7) {
            matrix.setScale(-1.0f, 1.0f, width / 2.0f, height / 2.0f);
        } else {
            if (i7 != 4 && i7 != 5) {
                return bitmap;
            }
            matrix.setScale(1.0f, -1.0f, width / 2.0f, height / 2.0f);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static byte[] b(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        byteBuffer.rewind();
        return bArr;
    }

    public static boolean c(int i7) {
        switch (i7) {
            case 1:
            case 3:
            case 6:
            case 8:
                break;
            case 2:
            case 4:
            case 5:
            case 7:
                break;
            default:
                U4.b.b("ImageUtils", "Unknown EXIF orientation: " + i7);
                break;
        }
        return false;
    }
}
