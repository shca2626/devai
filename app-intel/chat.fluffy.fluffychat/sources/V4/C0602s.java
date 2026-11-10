package V4;

import V4.AbstractC0603t;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import android.view.View;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.util.Locale;

/* renamed from: V4.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0602s extends View implements io.flutter.embedding.engine.renderer.p {

    /* renamed from: l, reason: collision with root package name */
    public ImageReader f8824l;

    /* renamed from: m, reason: collision with root package name */
    public Image f8825m;

    /* renamed from: n, reason: collision with root package name */
    public Bitmap f8826n;

    /* renamed from: o, reason: collision with root package name */
    public FlutterRenderer f8827o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f8828p;

    /* renamed from: q, reason: collision with root package name */
    public a f8829q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8830r;

    /* renamed from: V4.s$a */
    public enum a {
        background,
        overlay
    }

    public C0602s(Context context, int i7, int i8, a aVar) {
        this(context, i(i7, i8), aVar);
    }

    public static ImageReader i(int i7, int i8) {
        int i9;
        int i10;
        if (i7 <= 0) {
            k("ImageReader width must be greater than 0, but given width=%d, set width=1", Integer.valueOf(i7));
            i9 = 1;
        } else {
            i9 = i7;
        }
        if (i8 <= 0) {
            k("ImageReader height must be greater than 0, but given height=%d, set height=1", Integer.valueOf(i8));
            i10 = 1;
        } else {
            i10 = i8;
        }
        return Build.VERSION.SDK_INT >= 29 ? ImageReader.newInstance(i9, i10, 1, 3, 768L) : ImageReader.newInstance(i9, i10, 1, 3);
    }

    public static void k(String str, Object... objArr) {
        U4.b.g("FlutterImageView", String.format(Locale.US, str, objArr));
    }

    @Override // io.flutter.embedding.engine.renderer.p
    public void c(FlutterRenderer flutterRenderer) {
        if (this.f8829q.ordinal() == 0) {
            flutterRenderer.G(this.f8824l.getSurface());
        }
        setAlpha(1.0f);
        this.f8827o = flutterRenderer;
        this.f8830r = true;
    }

    @Override // io.flutter.embedding.engine.renderer.p
    public void d() {
        if (this.f8830r) {
            setAlpha(0.0f);
            f();
            this.f8826n = null;
            g();
            invalidate();
            this.f8830r = false;
        }
    }

    public boolean f() {
        if (!this.f8830r) {
            return false;
        }
        Image imageAcquireLatestImage = this.f8824l.acquireLatestImage();
        if (imageAcquireLatestImage != null) {
            g();
            this.f8825m = imageAcquireLatestImage;
            invalidate();
        }
        return imageAcquireLatestImage != null;
    }

    public final void g() {
        Image image = this.f8825m;
        if (image != null) {
            image.close();
            this.f8825m = null;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.p
    public FlutterRenderer getAttachedRenderer() {
        return this.f8827o;
    }

    public ImageReader getImageReader() {
        return this.f8824l;
    }

    public Surface getSurface() {
        return this.f8824l.getSurface();
    }

    public void h() {
        this.f8824l.close();
    }

    public final void j() {
        setAlpha(0.0f);
        this.f8828p = AbstractC0588d.a(getContext());
    }

    public void l(int i7, int i8) {
        if (this.f8827o == null) {
            return;
        }
        if (i7 == this.f8824l.getWidth() && i8 == this.f8824l.getHeight()) {
            return;
        }
        g();
        h();
        this.f8824l = i(i7, i8);
    }

    public final void m() {
        if (Build.VERSION.SDK_INT >= 29) {
            HardwareBuffer hardwareBuffer = this.f8825m.getHardwareBuffer();
            this.f8826n = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
            hardwareBuffer.close();
            return;
        }
        Image.Plane[] planes = this.f8825m.getPlanes();
        if (planes.length != 1) {
            return;
        }
        Image.Plane plane = planes[0];
        int rowStride = plane.getRowStride() / plane.getPixelStride();
        int height = this.f8825m.getHeight();
        Bitmap bitmap = this.f8826n;
        if (bitmap == null || bitmap.getWidth() != rowStride || this.f8826n.getHeight() != height) {
            this.f8826n = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
        }
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        this.f8826n.copyPixelsFromBuffer(buffer);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f8825m != null) {
            m();
        }
        Bitmap bitmap = this.f8826n;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        if (this.f8828p) {
            AbstractC0603t.a(i7, i8, new AbstractC0603t.a() { // from class: V4.r
                @Override // V4.AbstractC0603t.a
                public final void a(int i9, int i10) {
                    this.f8823a.setMeasuredDimension(i9, i10);
                }
            });
        } else {
            super.onMeasure(i7, i8);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i7, int i8, int i9, int i10) {
        if (!(i7 == this.f8824l.getWidth() && i8 == this.f8824l.getHeight()) && this.f8829q == a.background && this.f8830r) {
            l(i7, i8);
            this.f8827o.G(this.f8824l.getSurface());
        }
    }

    public C0602s(Context context, ImageReader imageReader, a aVar) {
        super(context, null);
        this.f8828p = false;
        this.f8830r = false;
        this.f8824l = imageReader;
        this.f8829q = aVar;
        j();
    }

    @Override // io.flutter.embedding.engine.renderer.p
    public void a() {
    }

    @Override // io.flutter.embedding.engine.renderer.p
    public void b() {
    }
}
