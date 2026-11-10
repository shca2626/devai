package androidx.core.graphics.drawable;

import Y.h;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f11894k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f11895a;

    /* renamed from: b, reason: collision with root package name */
    public Object f11896b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f11897c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f11898d;

    /* renamed from: e, reason: collision with root package name */
    public int f11899e;

    /* renamed from: f, reason: collision with root package name */
    public int f11900f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f11901g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f11902h;

    /* renamed from: i, reason: collision with root package name */
    public String f11903i;

    /* renamed from: j, reason: collision with root package name */
    public String f11904j;

    public static class a {
        public static IconCompat a(Context context, Icon icon) {
            int iE = e(icon);
            if (iE == 2) {
                String strD = d(icon);
                try {
                    return IconCompat.o(IconCompat.s(context, strD), strD, c(icon));
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            }
            if (iE == 4) {
                return IconCompat.k(f(icon));
            }
            if (iE == 6) {
                return IconCompat.h(f(icon));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f11896b = icon;
            return iconCompat;
        }

        public static IconCompat b(Object obj) {
            h.j(obj);
            int iE = e(obj);
            if (iE == 2) {
                return IconCompat.o(null, d(obj), c(obj));
            }
            if (iE == 4) {
                return IconCompat.k(f(obj));
            }
            if (iE == 6) {
                return IconCompat.h(f(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f11896b = obj;
            return iconCompat;
        }

        public static int c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e7) {
                Log.e("IconCompat", "Unable to get icon resource", e7);
                return 0;
            } catch (NoSuchMethodException e8) {
                Log.e("IconCompat", "Unable to get icon resource", e8);
                return 0;
            } catch (InvocationTargetException e9) {
                Log.e("IconCompat", "Unable to get icon resource", e9);
                return 0;
            }
        }

        public static String d(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
            } catch (IllegalAccessException e7) {
                Log.e("IconCompat", "Unable to get icon package", e7);
                return null;
            } catch (NoSuchMethodException e8) {
                Log.e("IconCompat", "Unable to get icon package", e8);
                return null;
            } catch (InvocationTargetException e9) {
                Log.e("IconCompat", "Unable to get icon package", e9);
                return null;
            }
        }

        public static int e(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e7) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e7);
                return -1;
            } catch (NoSuchMethodException e8) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e8);
                return -1;
            } catch (InvocationTargetException e9) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e9);
                return -1;
            }
        }

        public static Uri f(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException e7) {
                Log.e("IconCompat", "Unable to get icon uri", e7);
                return null;
            } catch (NoSuchMethodException e8) {
                Log.e("IconCompat", "Unable to get icon uri", e8);
                return null;
            } catch (InvocationTargetException e9) {
                Log.e("IconCompat", "Unable to get icon uri", e9);
                return null;
            }
        }

        public static Icon g(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f11895a) {
                case -1:
                    return (Icon) iconCompat.f11896b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f11896b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.r(), iconCompat.f11899e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f11896b, iconCompat.f11899e, iconCompat.f11900f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f11896b);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT < 26) {
                        iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.f((Bitmap) iconCompat.f11896b, false));
                        break;
                    } else {
                        iconCreateWithBitmap = b.a((Bitmap) iconCompat.f11896b);
                        break;
                    }
                case 6:
                    int i7 = Build.VERSION.SDK_INT;
                    if (i7 >= 30) {
                        iconCreateWithBitmap = d.a(iconCompat.u());
                        break;
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.u());
                        }
                        InputStream inputStreamV = iconCompat.v(context);
                        if (inputStreamV == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.u());
                        }
                        if (i7 < 26) {
                            iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.f(BitmapFactory.decodeStream(inputStreamV), false));
                            break;
                        } else {
                            iconCreateWithBitmap = b.a(BitmapFactory.decodeStream(inputStreamV));
                            break;
                        }
                    }
            }
            ColorStateList colorStateList = iconCompat.f11901g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f11902h;
            if (mode != IconCompat.f11894k) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    public static class b {
        public static Icon a(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    public static class c {
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        public static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        public static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        public static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    public static class d {
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f11895a = -1;
        this.f11897c = null;
        this.f11898d = null;
        this.f11899e = 0;
        this.f11900f = 0;
        this.f11901g = null;
        this.f11902h = f11894k;
        this.f11903i = null;
    }

    public static String B(int i7) {
        switch (i7) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public static IconCompat c(Bundle bundle) {
        int i7 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i7);
        iconCompat.f11899e = bundle.getInt("int1");
        iconCompat.f11900f = bundle.getInt("int2");
        iconCompat.f11904j = bundle.getString("string1");
        if (bundle.containsKey("tint_list")) {
            iconCompat.f11901g = (ColorStateList) bundle.getParcelable("tint_list");
        }
        if (bundle.containsKey("tint_mode")) {
            iconCompat.f11902h = PorterDuff.Mode.valueOf(bundle.getString("tint_mode"));
        }
        switch (i7) {
            case -1:
            case 1:
            case 5:
                iconCompat.f11896b = bundle.getParcelable("obj");
                return iconCompat;
            case 0:
            default:
                Log.w("IconCompat", "Unknown type " + i7);
                return null;
            case 2:
            case 4:
            case 6:
                iconCompat.f11896b = bundle.getString("obj");
                return iconCompat;
            case 3:
                iconCompat.f11896b = bundle.getByteArray("obj");
                return iconCompat;
        }
    }

    public static IconCompat d(Context context, Icon icon) {
        h.j(icon);
        return a.a(context, icon);
    }

    public static IconCompat e(Icon icon) {
        return a.b(icon);
    }

    public static Bitmap f(Bitmap bitmap, boolean z7) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f7 = iMin;
        float f8 = 0.5f * f7;
        float f9 = 0.9166667f * f8;
        if (z7) {
            float f10 = 0.010416667f * f7;
            paint.setColor(0);
            paint.setShadowLayer(f10, 0.0f, f7 * 0.020833334f, 1023410176);
            canvas.drawCircle(f8, f8, f9, paint);
            paint.setShadowLayer(f10, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f8, f8, f9, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f8, f8, f9, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat g(Bitmap bitmap) {
        Y.c.c(bitmap);
        IconCompat iconCompat = new IconCompat(5);
        iconCompat.f11896b = bitmap;
        return iconCompat;
    }

    public static IconCompat h(Uri uri) {
        Y.c.c(uri);
        return i(uri.toString());
    }

    public static IconCompat i(String str) {
        Y.c.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f11896b = str;
        return iconCompat;
    }

    public static IconCompat j(Bitmap bitmap) {
        Y.c.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f11896b = bitmap;
        return iconCompat;
    }

    public static IconCompat k(Uri uri) {
        Y.c.c(uri);
        return l(uri.toString());
    }

    public static IconCompat l(String str) {
        Y.c.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f11896b = str;
        return iconCompat;
    }

    public static IconCompat m(byte[] bArr, int i7, int i8) {
        Y.c.c(bArr);
        IconCompat iconCompat = new IconCompat(3);
        iconCompat.f11896b = bArr;
        iconCompat.f11899e = i7;
        iconCompat.f11900f = i8;
        return iconCompat;
    }

    public static IconCompat n(Context context, int i7) {
        Y.c.c(context);
        return o(context.getResources(), context.getPackageName(), i7);
    }

    public static IconCompat o(Resources resources, String str, int i7) {
        Y.c.c(str);
        if (i7 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f11899e = i7;
        if (resources != null) {
            try {
                iconCompat.f11896b = resources.getResourceName(i7);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f11896b = str;
        }
        iconCompat.f11904j = str;
        return iconCompat;
    }

    public static Resources s(Context context, String str) throws PackageManager.NameNotFoundException {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e7) {
            Log.e("IconCompat", String.format("Unable to find pkg=%s for icon", str), e7);
            return null;
        }
    }

    public Icon A(Context context) {
        return a.g(this, context);
    }

    public Bitmap p() {
        int i7 = this.f11895a;
        if (i7 == -1) {
            Object obj = this.f11896b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i7 == 1) {
            return (Bitmap) this.f11896b;
        }
        if (i7 == 5) {
            return f((Bitmap) this.f11896b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int q() {
        int i7 = this.f11895a;
        if (i7 == -1) {
            return a.c(this.f11896b);
        }
        if (i7 == 2) {
            return this.f11899e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String r() {
        int i7 = this.f11895a;
        if (i7 == -1) {
            return a.d(this.f11896b);
        }
        if (i7 == 2) {
            String str = this.f11904j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f11896b).split(":", -1)[0] : this.f11904j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int t() {
        int i7 = this.f11895a;
        return i7 == -1 ? a.e(this.f11896b) : i7;
    }

    public String toString() {
        if (this.f11895a == -1) {
            return String.valueOf(this.f11896b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(B(this.f11895a));
        switch (this.f11895a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f11896b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f11896b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f11904j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(q())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f11899e);
                if (this.f11900f != 0) {
                    sb.append(" off=");
                    sb.append(this.f11900f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f11896b);
                break;
        }
        if (this.f11901g != null) {
            sb.append(" tint=");
            sb.append(this.f11901g);
        }
        if (this.f11902h != f11894k) {
            sb.append(" mode=");
            sb.append(this.f11902h);
        }
        sb.append(")");
        return sb.toString();
    }

    public Uri u() {
        int i7 = this.f11895a;
        if (i7 == -1) {
            return a.f(this.f11896b);
        }
        if (i7 == 4 || i7 == 6) {
            return Uri.parse((String) this.f11896b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream v(Context context) {
        Uri uriU = u();
        String scheme = uriU.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriU);
            } catch (Exception e7) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriU, e7);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f11896b));
        } catch (FileNotFoundException e8) {
            Log.w("IconCompat", "Unable to load image from path: " + uriU, e8);
            return null;
        }
    }

    public void w() {
        this.f11902h = PorterDuff.Mode.valueOf(this.f11903i);
        switch (this.f11895a) {
            case -1:
                Parcelable parcelable = this.f11898d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f11896b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f11898d;
                if (parcelable2 != null) {
                    this.f11896b = parcelable2;
                    return;
                }
                byte[] bArr = this.f11897c;
                this.f11896b = bArr;
                this.f11895a = 3;
                this.f11899e = 0;
                this.f11900f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f11897c, Charset.forName("UTF-16"));
                this.f11896b = str;
                if (this.f11895a == 2 && this.f11904j == null) {
                    this.f11904j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f11896b = this.f11897c;
                return;
        }
    }

    public void x(boolean z7) {
        this.f11903i = this.f11902h.name();
        switch (this.f11895a) {
            case -1:
                if (z7) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f11898d = (Parcelable) this.f11896b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z7) {
                    this.f11898d = (Parcelable) this.f11896b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f11896b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f11897c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f11897c = ((String) this.f11896b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f11897c = (byte[]) this.f11896b;
                return;
            case 4:
            case 6:
                this.f11897c = this.f11896b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public Bundle y() {
        Bundle bundle = new Bundle();
        switch (this.f11895a) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.f11896b);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.f11896b);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f11896b);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f11896b);
                break;
        }
        bundle.putInt("type", this.f11895a);
        bundle.putInt("int1", this.f11899e);
        bundle.putInt("int2", this.f11900f);
        bundle.putString("string1", this.f11904j);
        ColorStateList colorStateList = this.f11901g;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.f11902h;
        if (mode != f11894k) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    public Icon z() {
        return A(null);
    }

    public IconCompat(int i7) {
        this.f11897c = null;
        this.f11898d = null;
        this.f11899e = 0;
        this.f11900f = 0;
        this.f11901g = null;
        this.f11902h = f11894k;
        this.f11903i = null;
        this.f11895a = i7;
    }
}
