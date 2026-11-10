package k4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public p f19102a;

    /* renamed from: b, reason: collision with root package name */
    public int f19103b;

    /* renamed from: c, reason: collision with root package name */
    public int f19104c;

    /* renamed from: d, reason: collision with root package name */
    public Rect f19105d;

    /* renamed from: e, reason: collision with root package name */
    public int f19106e = 1;

    /* renamed from: f, reason: collision with root package name */
    public boolean f19107f;

    public t(byte[] bArr, int i7, int i8, int i9, int i10) {
        this.f19102a = new p(bArr, i7, i8);
        this.f19104c = i10;
        this.f19103b = i9;
        if (i7 * i8 <= bArr.length) {
            return;
        }
        throw new IllegalArgumentException("Image data does not match the resolution. " + i7 + "x" + i8 + " > " + bArr.length);
    }

    public D3.k a() {
        p pVarA = this.f19102a.h(this.f19104c).a(this.f19105d, this.f19106e);
        return new D3.k(pVarA.b(), pVarA.d(), pVarA.c(), 0, 0, pVarA.d(), pVarA.c(), false);
    }

    public Bitmap b(Rect rect, int i7) {
        if (rect == null) {
            rect = new Rect(0, 0, this.f19102a.d(), this.f19102a.c());
        } else if (c()) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        YuvImage yuvImage = new YuvImage(this.f19102a.b(), this.f19103b, this.f19102a.d(), this.f19102a.c(), null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i7;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (this.f19104c == 0) {
            return bitmapDecodeByteArray;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(this.f19104c);
        return Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
    }

    public boolean c() {
        return this.f19104c % 180 != 0;
    }

    public void d(Rect rect) {
        this.f19105d = rect;
    }

    public void e(boolean z7) {
        this.f19107f = z7;
    }

    public D3.p f(D3.p pVar) {
        float fC = (pVar.c() * this.f19106e) + this.f19105d.left;
        float fD = (pVar.d() * this.f19106e) + this.f19105d.top;
        if (this.f19107f) {
            fC = this.f19102a.d() - fC;
        }
        return new D3.p(fC, fD);
    }
}
