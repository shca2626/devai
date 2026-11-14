package h4;

import M5.m;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import org.webrtc.EglBase;

/* renamed from: h4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1141a {

    /* renamed from: a, reason: collision with root package name */
    public final int f16825a = EglBase.EGL_RECORDABLE_ANDROID;

    /* renamed from: b, reason: collision with root package name */
    public final int f16826b = 4;

    /* renamed from: c, reason: collision with root package name */
    public EGLDisplay f16827c;

    /* renamed from: d, reason: collision with root package name */
    public EGLContext f16828d;

    /* renamed from: e, reason: collision with root package name */
    public EGLSurface f16829e;

    /* renamed from: f, reason: collision with root package name */
    public Surface f16830f;

    public C1141a(Surface surface) {
        surface.getClass();
        this.f16830f = surface;
        b();
    }

    public final void a() {
        boolean z7 = false;
        while (EGL14.eglGetError() != 12288) {
            z7 = true;
        }
        if (z7) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    public final void b() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.f16827c = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            this.f16827c = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f16827c, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, this.f16826b, this.f16825a, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.f16828d = EGL14.eglCreateContext(this.f16827c, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        a();
        if (this.f16828d == null) {
            throw new RuntimeException("null context");
        }
        this.f16829e = EGL14.eglCreateWindowSurface(this.f16827c, eGLConfigArr[0], this.f16830f, new int[]{12344}, 0);
        a();
        if (this.f16829e == null) {
            throw new RuntimeException("surface was null");
        }
    }

    public final void c() {
        EGLDisplay eGLDisplay = this.f16827c;
        EGLSurface eGLSurface = this.f16829e;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f16828d)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public final void d() {
        if (m.a(EGL14.eglGetCurrentContext(), this.f16828d)) {
            EGLDisplay eGLDisplay = this.f16827c;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.f16827c, this.f16829e);
        EGL14.eglDestroyContext(this.f16827c, this.f16828d);
        Surface surface = this.f16830f;
        if (surface != null) {
            surface.release();
        }
        this.f16827c = null;
        this.f16828d = null;
        this.f16829e = null;
        this.f16830f = null;
    }

    public final void e(long j7) {
        EGLExt.eglPresentationTimeANDROID(this.f16827c, this.f16829e, j7);
    }

    public final boolean f() {
        return EGL14.eglSwapBuffers(this.f16827c, this.f16829e);
    }
}
