package n5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import p0.C1436a;

/* loaded from: classes.dex */
public class E {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20112a;

    /* renamed from: b, reason: collision with root package name */
    public final C1367d f20113b;

    public E(Context context, C1367d c1367d) {
        this.f20112a = context;
        this.f20113b = c1367d;
    }

    public final int a(BitmapFactory.Options options, int i7, int i8) {
        int i9 = options.outHeight;
        int i10 = options.outWidth;
        int i11 = 1;
        if (i9 <= i8 && i10 <= i7) {
            return 1;
        }
        int i12 = i9 / 2;
        int i13 = i10 / 2;
        while (i12 / i11 >= i8 && i13 / i11 >= i7) {
            i11 *= 2;
        }
        return i11;
    }

    public final Y.i b(double d7, double d8, Double d9, Double d10) {
        double d11 = d7 / d8;
        boolean z7 = false;
        boolean z8 = d9 != null;
        boolean z9 = d10 != null;
        double dMin = z8 ? Math.min(d7, Math.round(d9.doubleValue())) : d7;
        double dMin2 = z9 ? Math.min(d8, Math.round(d10.doubleValue())) : d8;
        boolean z10 = z8 && d9.doubleValue() < d7;
        if (z9 && d10.doubleValue() < d8) {
            z7 = true;
        }
        if (z10 || z7) {
            double d12 = dMin2 * d11;
            double d13 = dMin / d11;
            if (d13 > dMin2) {
                dMin = Math.round(d12);
            } else {
                dMin2 = Math.round(d13);
            }
        }
        return new Y.i((float) dMin, (float) dMin2);
    }

    public final void c(String str, String str2) throws Throwable {
        try {
            this.f20113b.a(new C1436a(str), new C1436a(str2));
        } catch (Exception e7) {
            Log.e("ImageResizer", "Error preserving Exif data on selected image: " + e7);
        }
    }

    public final File d(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        return file2;
    }

    public final File e(String str, Bitmap bitmap, int i7) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean zHasAlpha = bitmap.hasAlpha();
        if (zHasAlpha) {
            Log.d("ImageResizer", "image_picker: compressing is not supported for type PNG. Returning the image with original quality");
        }
        bitmap.compress(zHasAlpha ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, i7, byteArrayOutputStream);
        File fileD = d(this.f20112a.getCacheDir(), str);
        FileOutputStream fileOutputStreamF = f(fileD);
        fileOutputStreamF.write(byteArrayOutputStream.toByteArray());
        fileOutputStreamF.close();
        return fileD;
    }

    public final FileOutputStream f(File file) {
        return new FileOutputStream(file);
    }

    public final Bitmap g(Bitmap bitmap, int i7, int i8, boolean z7) {
        return Bitmap.createScaledBitmap(bitmap, i7, i8, z7);
    }

    public final Bitmap h(String str, BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    public Y.i i(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        h(str, options);
        return new Y.i(options.outWidth, options.outHeight);
    }

    public String j(String str, Double d7, Double d8, int i7) throws Throwable {
        Y.i iVarI = i(str);
        if (iVarI.b() == -1.0f || iVarI.a() == -1.0f) {
            return str;
        }
        if (d7 == null && d8 == null && i7 >= 100) {
            return str;
        }
        try {
            String str2 = str.split("/")[r2.length - 1];
            Y.i iVarB = b(iVarI.b(), iVarI.a(), d7, d8);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = a(options, (int) iVarB.b(), (int) iVarB.a());
            Bitmap bitmapH = h(str, options);
            if (bitmapH == null) {
                return str;
            }
            File fileK = k(bitmapH, Double.valueOf(iVarB.b()), Double.valueOf(iVarB.a()), i7, str2);
            c(str, fileK.getPath());
            return fileK.getPath();
        } catch (IOException e7) {
            throw new RuntimeException(e7);
        }
    }

    public final File k(Bitmap bitmap, Double d7, Double d8, int i7, String str) {
        return e("/scaled_" + str, g(bitmap, d7.intValue(), d8.intValue(), false), i7);
    }
}
