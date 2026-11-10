package io.flutter.plugin.platform;

import android.view.Surface;
import io.flutter.view.TextureRegistry;

/* loaded from: classes.dex */
public class c0 implements InterfaceC1183o {

    /* renamed from: a, reason: collision with root package name */
    public TextureRegistry.SurfaceProducer f17812a;

    public c0(TextureRegistry.SurfaceProducer surfaceProducer) {
        this.f17812a = surfaceProducer;
    }

    @Override // io.flutter.plugin.platform.InterfaceC1183o
    public void a(int i7, int i8) {
        this.f17812a.setSize(i7, i8);
    }

    @Override // io.flutter.plugin.platform.InterfaceC1183o
    public int getHeight() {
        return this.f17812a.getHeight();
    }

    @Override // io.flutter.plugin.platform.InterfaceC1183o
    public long getId() {
        return this.f17812a.id();
    }

    @Override // io.flutter.plugin.platform.InterfaceC1183o
    public Surface getSurface() {
        return this.f17812a.getSurface();
    }

    @Override // io.flutter.plugin.platform.InterfaceC1183o
    public int getWidth() {
        return this.f17812a.getWidth();
    }

    @Override // io.flutter.plugin.platform.InterfaceC1183o
    public void release() {
        this.f17812a.release();
        this.f17812a = null;
    }

    @Override // io.flutter.plugin.platform.InterfaceC1183o
    public void scheduleFrame() {
        this.f17812a.scheduleFrame();
    }
}
