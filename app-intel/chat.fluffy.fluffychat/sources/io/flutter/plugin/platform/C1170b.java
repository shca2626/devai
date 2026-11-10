package io.flutter.plugin.platform;

import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.view.TextureRegistry;

/* renamed from: io.flutter.plugin.platform.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1170b implements InterfaceC1183o {

    /* renamed from: a, reason: collision with root package name */
    public TextureRegistry.ImageTextureEntry f17802a;

    /* renamed from: b, reason: collision with root package name */
    public ImageReader f17803b;

    /* renamed from: c, reason: collision with root package name */
    public int f17804c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f17805d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f17806e = new Handler();

    /* renamed from: f, reason: collision with root package name */
    public final ImageReader.OnImageAvailableListener f17807f = new a();

    /* renamed from: io.flutter.plugin.platform.b$a */
    public class a implements ImageReader.OnImageAvailableListener {
        public a() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image imageAcquireLatestImage;
            try {
                imageAcquireLatestImage = imageReader.acquireLatestImage();
            } catch (IllegalStateException e7) {
                U4.b.b("ImageReaderPlatformViewRenderTarget", "onImageAvailable acquireLatestImage failed: " + e7);
                imageAcquireLatestImage = null;
            }
            if (imageAcquireLatestImage == null) {
                return;
            }
            C1170b.this.f17802a.pushImage(imageAcquireLatestImage);
        }
    }

    public C1170b(TextureRegistry.ImageTextureEntry imageTextureEntry) {
        if (Build.VERSION.SDK_INT < 29) {
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }
        this.f17802a = imageTextureEntry;
    }

    @Override // io.flutter.plugin.platform.InterfaceC1183o
    public void a(int i7, int i8) {
        if (this.f17803b != null && this.f17804c == i7 && this.f17805d == i8) {
            return;
        }
        c();
        this.f17804c = i7;
        this.f17805d = i8;
        this.f17803b = d();
    }

    public final void c() {
        if (this.f17803b != null) {
            this.f17802a.pushImage(null);
            this.f17803b.close();
            this.f17803b = null;
        }
    }

    public ImageReader d() {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 33) {
            return f();
        }
        if (i7 >= 29) {
            return e();
        }
        throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
    }

    public ImageReader e() {
        ImageReader imageReaderNewInstance = ImageReader.newInstance(this.f17804c, this.f17805d, 34, 4, 256L);
        imageReaderNewInstance.setOnImageAvailableListener(this.f17807f, this.f17806e);
        return imageReaderNewInstance;
    }

    public ImageReader f() {
        io.flutter.embedding.engine.renderer.i.a();
        ImageReader.Builder builderA = io.flutter.embedding.engine.renderer.h.a(this.f17804c, this.f17805d);
        builderA.setMaxImages(4);
        builderA.setImageFormat(34);
        builderA.setUsage(256L);
        ImageReader imageReaderBuild = builderA.build();
        imageReaderBuild.setOnImageAvailableListener(this.f17807f, this.f17806e);
        return imageReaderBuild;
    }

    @Override // io.flutter.plugin.platform.InterfaceC1183o
    public int getHeight() {
        return this.f17805d;
    }

    @Override // io.flutter.plugin.platform.InterfaceC1183o
    public long getId() {
        return this.f17802a.id();
    }

    @Override // io.flutter.plugin.platform.InterfaceC1183o
    public Surface getSurface() {
        return this.f17803b.getSurface();
    }

    @Override // io.flutter.plugin.platform.InterfaceC1183o
    public int getWidth() {
        return this.f17804c;
    }

    @Override // io.flutter.plugin.platform.InterfaceC1183o
    public void release() {
        c();
        this.f17802a = null;
    }
}
