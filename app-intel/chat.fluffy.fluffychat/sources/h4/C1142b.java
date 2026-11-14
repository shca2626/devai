package h4;

import M5.g;
import M5.m;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import y5.C1823s;

/* renamed from: h4.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1142b implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: l, reason: collision with root package name */
    public final float f16831l;

    /* renamed from: m, reason: collision with root package name */
    public final float f16832m;

    /* renamed from: n, reason: collision with root package name */
    public final float f16833n;

    /* renamed from: o, reason: collision with root package name */
    public SurfaceTexture f16834o;

    /* renamed from: p, reason: collision with root package name */
    public Surface f16835p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f16836q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f16837r;

    /* renamed from: s, reason: collision with root package name */
    public C1144d f16838s;

    public C1142b() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    public final void a() {
        synchronized (this.f16836q) {
            while (!this.f16837r) {
                try {
                    this.f16836q.wait(2500);
                    if (!this.f16837r) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e7) {
                    throw new RuntimeException(e7);
                }
            }
            this.f16837r = false;
            C1823s c1823s = C1823s.f24020a;
        }
        C1144d c1144d = this.f16838s;
        if (c1144d != null) {
            c1144d.a("before updateTexImage");
        }
        SurfaceTexture surfaceTexture = this.f16834o;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }

    public final void b() {
        C1144d c1144d = this.f16838s;
        if (c1144d != null) {
            SurfaceTexture surfaceTexture = this.f16834o;
            m.b(surfaceTexture);
            c1144d.c(surfaceTexture);
        }
    }

    public final Surface c() {
        return this.f16835p;
    }

    public final void d() {
        Surface surface = this.f16835p;
        if (surface != null) {
            surface.release();
        }
        this.f16838s = null;
        this.f16835p = null;
        this.f16834o = null;
    }

    public final void e() {
        C1144d c1144d = new C1144d(this.f16831l, this.f16832m, this.f16833n);
        this.f16838s = c1144d;
        c1144d.f();
        SurfaceTexture surfaceTexture = new SurfaceTexture(c1144d.d());
        this.f16834o = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f16835p = new Surface(this.f16834o);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f16836q) {
            if (this.f16837r) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.f16837r = true;
            this.f16836q.notifyAll();
            C1823s c1823s = C1823s.f24020a;
        }
    }

    public C1142b(float f7, float f8, float f9) {
        this.f16831l = f7;
        this.f16832m = f8;
        this.f16833n = f9;
        this.f16836q = new Object();
        e();
    }

    public /* synthetic */ C1142b(float f7, float f8, float f9, int i7, g gVar) {
        this((i7 & 1) != 0 ? 0.0f : f7, (i7 & 2) != 0 ? 1.0f : f8, (i7 & 4) != 0 ? 1.0f : f9);
    }
}
