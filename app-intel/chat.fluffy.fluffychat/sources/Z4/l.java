package Z4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class l extends k {
    public l() {
        super(null);
    }

    @Override // Z4.k, Z4.d
    public Bitmap a(ByteBuffer byteBuffer, p pVar) {
        Bitmap bitmapA = super.a(byteBuffer, pVar);
        return bitmapA != null ? bitmapA : c(byteBuffer, pVar);
    }

    public Bitmap c(ByteBuffer byteBuffer, p pVar) {
        byte[] bArrB = n.b(byteBuffer);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrB, 0, bArrB.length, options);
        if (pVar.f10350c == 0) {
            return n.a(bitmapDecodeByteArray, pVar.f10352e);
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(pVar.f10350c);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, true);
        bitmapDecodeByteArray.recycle();
        return n.a(bitmapCreateBitmap, pVar.f10352e);
    }
}
