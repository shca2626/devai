package io.flutter.plugin.platform;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import io.flutter.view.TextureRegistry;

/* loaded from: classes.dex */
public class e0 implements InterfaceC1184o {

    /* renamed from: a, reason: collision with root package name */
    public final TextureRegistry.SurfaceTextureEntry f17813a;

    /* renamed from: b, reason: collision with root package name */
    public SurfaceTexture f17814b;

    /* renamed from: c, reason: collision with root package name */
    public Surface f17815c;

    /* renamed from: d, reason: collision with root package name */
    public int f17816d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f17817e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f17818f = false;

    /* renamed from: g, reason: collision with root package name */
    public final TextureRegistry.b f17819g;

    public class a implements TextureRegistry.b {
        public a() {
        }

        @Override // io.flutter.view.TextureRegistry.b
        public void onTrimMemory(int i7) {
            if (i7 != 80 || Build.VERSION.SDK_INT < 29) {
                return;
            }
            e0.this.f17818f = true;
        }
    }

    public e0(TextureRegistry.SurfaceTextureEntry surfaceTextureEntry) {
        a aVar = new a();
        this.f17819g = aVar;
        this.f17813a = surfaceTextureEntry;
        this.f17814b = surfaceTextureEntry.surfaceTexture();
        surfaceTextureEntry.setOnTrimMemoryListener(aVar);
    }

    @Override // io.flutter.plugin.platform.InterfaceC1184o
    public void a(int i7, int i8) {
        this.f17816d = i7;
        this.f17817e = i8;
        SurfaceTexture surfaceTexture = this.f17814b;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i7, i8);
        }
    }

    public Surface c() {
        return new Surface(this.f17814b);
    }

    public final void d() {
        Surface surface = this.f17815c;
        if (surface == null || this.f17818f) {
            if (surface != null) {
                surface.release();
                this.f17815c = null;
            }
            this.f17815c = c();
            this.f17818f = false;
        }
    }

    @Override // io.flutter.plugin.platform.InterfaceC1184o
    public int getHeight() {
        return this.f17817e;
    }

    @Override // io.flutter.plugin.platform.InterfaceC1184o
    public long getId() {
        return this.f17813a.id();
    }

    @Override // io.flutter.plugin.platform.InterfaceC1184o
    public Surface getSurface() {
        d();
        SurfaceTexture surfaceTexture = this.f17814b;
        if (surfaceTexture == null || surfaceTexture.isReleased()) {
            return null;
        }
        return this.f17815c;
    }

    @Override // io.flutter.plugin.platform.InterfaceC1184o
    public int getWidth() {
        return this.f17816d;
    }

    @Override // io.flutter.plugin.platform.InterfaceC1184o
    public void release() {
        this.f17814b = null;
        Surface surface = this.f17815c;
        if (surface != null) {
            surface.release();
            this.f17815c = null;
        }
    }
}
