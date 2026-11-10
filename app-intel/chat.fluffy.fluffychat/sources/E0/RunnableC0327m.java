package E0;

import E0.AbstractC0328n;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;

/* renamed from: E0.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0327m implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f2173r = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* renamed from: l, reason: collision with root package name */
    public final Handler f2174l;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f2175m;

    /* renamed from: n, reason: collision with root package name */
    public EGLDisplay f2176n;

    /* renamed from: o, reason: collision with root package name */
    public EGLContext f2177o;

    /* renamed from: p, reason: collision with root package name */
    public EGLSurface f2178p;

    /* renamed from: q, reason: collision with root package name */
    public SurfaceTexture f2179q;

    /* renamed from: E0.m$a */
    public interface a {
    }

    public RunnableC0327m(Handler handler) {
        this(handler, null);
    }

    public static EGLConfig a(EGLDisplay eGLDisplay) throws AbstractC0328n.a {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, f2173r, 0, eGLConfigArr, 0, 1, iArr, 0);
        AbstractC0328n.b(zEglChooseConfig && iArr[0] > 0 && eGLConfigArr[0] != null, U.G("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]));
        return eGLConfigArr[0];
    }

    public static EGLContext b(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i7) throws AbstractC0328n.a {
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, i7 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        AbstractC0328n.b(eGLContextEglCreateContext != null, "eglCreateContext failed");
        return eGLContextEglCreateContext;
    }

    public static EGLSurface c(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i7) throws AbstractC0328n.a {
        EGLSurface eGLSurfaceEglCreatePbufferSurface;
        if (i7 == 1) {
            eGLSurfaceEglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i7 == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            AbstractC0328n.b(eGLSurfaceEglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
        }
        AbstractC0328n.b(EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContext), "eglMakeCurrent failed");
        return eGLSurfaceEglCreatePbufferSurface;
    }

    public static void e(int[] iArr) throws AbstractC0328n.a {
        GLES20.glGenTextures(1, iArr, 0);
        AbstractC0328n.a();
    }

    public static EGLDisplay f() throws AbstractC0328n.a {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        AbstractC0328n.b(eGLDisplayEglGetDisplay != null, "eglGetDisplay failed");
        int[] iArr = new int[2];
        AbstractC0328n.b(EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
        return eGLDisplayEglGetDisplay;
    }

    public SurfaceTexture g() {
        return (SurfaceTexture) j3.o.q(this.f2179q);
    }

    public void h(int i7) throws AbstractC0328n.a {
        EGLDisplay eGLDisplayF = f();
        this.f2176n = eGLDisplayF;
        EGLConfig eGLConfigA = a(eGLDisplayF);
        EGLContext eGLContextB = b(this.f2176n, eGLConfigA, i7);
        this.f2177o = eGLContextB;
        this.f2178p = c(this.f2176n, eGLConfigA, eGLContextB, i7);
        e(this.f2175m);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f2175m[0]);
        this.f2179q = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        this.f2174l.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.f2179q;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.f2175m, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.f2176n;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.f2176n;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f2178p;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f2176n, this.f2178p);
            }
            EGLContext eGLContext = this.f2177o;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f2176n, eGLContext);
            }
            EGL14.eglReleaseThread();
            EGLDisplay eGLDisplay3 = this.f2176n;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f2176n);
            }
            this.f2176n = null;
            this.f2177o = null;
            this.f2178p = null;
            this.f2179q = null;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f2174l.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        d();
        SurfaceTexture surfaceTexture = this.f2179q;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }

    public RunnableC0327m(Handler handler, a aVar) {
        this.f2174l = handler;
        this.f2175m = new int[1];
    }

    public final void d() {
    }
}
