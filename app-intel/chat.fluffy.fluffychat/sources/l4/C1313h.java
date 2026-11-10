package l4;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import k4.s;
import k4.t;

/* renamed from: l4.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1313h {

    /* renamed from: n, reason: collision with root package name */
    public static final String f19617n = "h";

    /* renamed from: a, reason: collision with root package name */
    public Camera f19618a;

    /* renamed from: b, reason: collision with root package name */
    public Camera.CameraInfo f19619b;

    /* renamed from: c, reason: collision with root package name */
    public C1306a f19620c;

    /* renamed from: d, reason: collision with root package name */
    public H3.b f19621d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f19622e;

    /* renamed from: f, reason: collision with root package name */
    public String f19623f;

    /* renamed from: h, reason: collision with root package name */
    public m f19625h;

    /* renamed from: i, reason: collision with root package name */
    public s f19626i;

    /* renamed from: j, reason: collision with root package name */
    public s f19627j;

    /* renamed from: l, reason: collision with root package name */
    public Context f19629l;

    /* renamed from: g, reason: collision with root package name */
    public i f19624g = new i();

    /* renamed from: k, reason: collision with root package name */
    public int f19628k = -1;

    /* renamed from: m, reason: collision with root package name */
    public final a f19630m = new a();

    /* renamed from: l4.h$a */
    public final class a implements Camera.PreviewCallback {

        /* renamed from: a, reason: collision with root package name */
        public p f19631a;

        /* renamed from: b, reason: collision with root package name */
        public s f19632b;

        public a() {
        }

        public void a(p pVar) {
            this.f19631a = pVar;
        }

        public void b(s sVar) {
            this.f19632b = sVar;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            s sVar = this.f19632b;
            p pVar = this.f19631a;
            if (sVar == null || pVar == null) {
                Log.d(C1313h.f19617n, "Got preview callback, but no handler or resolution available");
                if (pVar != null) {
                    pVar.a(new Exception("No resolution available"));
                    return;
                }
                return;
            }
            try {
                if (bArr == null) {
                    throw new NullPointerException("No preview data received");
                }
                t tVar = new t(bArr, sVar.f19100l, sVar.f19101m, camera.getParameters().getPreviewFormat(), C1313h.this.f());
                if (C1313h.this.f19619b.facing == 1) {
                    tVar.e(true);
                }
                pVar.b(tVar);
            } catch (RuntimeException e7) {
                Log.e(C1313h.f19617n, "Camera preview failed", e7);
                pVar.a(e7);
            }
        }
    }

    public C1313h(Context context) {
        this.f19629l = context;
    }

    public static List i(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                new s(previewSize.width, previewSize.height);
                arrayList.add(new s(previewSize.width, previewSize.height));
                return arrayList;
            }
        } else {
            for (Camera.Size size : supportedPreviewSizes) {
                arrayList.add(new s(size.width, size.height));
            }
        }
        return arrayList;
    }

    public final int c() {
        int iC = this.f19625h.c();
        int i7 = 0;
        if (iC != 0) {
            if (iC == 1) {
                i7 = 90;
            } else if (iC == 2) {
                i7 = 180;
            } else if (iC == 3) {
                i7 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = this.f19619b;
        int i8 = cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i7) % 360)) % 360 : ((cameraInfo.orientation - i7) + 360) % 360;
        Log.i(f19617n, "Camera Display Orientation: " + i8);
        return i8;
    }

    public void d() {
        Camera camera = this.f19618a;
        if (camera != null) {
            camera.release();
            this.f19618a = null;
        }
    }

    public void e() {
        if (this.f19618a == null) {
            throw new RuntimeException("Camera not open");
        }
        r();
    }

    public int f() {
        return this.f19628k;
    }

    public final Camera.Parameters g() {
        Camera.Parameters parameters = this.f19618a.getParameters();
        String str = this.f19623f;
        if (str == null) {
            this.f19623f = parameters.flatten();
            return parameters;
        }
        parameters.unflatten(str);
        return parameters;
    }

    public s h() {
        if (this.f19627j == null) {
            return null;
        }
        return j() ? this.f19627j.d() : this.f19627j;
    }

    public boolean j() {
        int i7 = this.f19628k;
        if (i7 != -1) {
            return i7 % 180 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public boolean k() {
        String flashMode;
        Camera.Parameters parameters = this.f19618a.getParameters();
        return (parameters == null || (flashMode = parameters.getFlashMode()) == null || (!"on".equals(flashMode) && !"torch".equals(flashMode))) ? false : true;
    }

    public void l() {
        Camera cameraB = I3.a.b(this.f19624g.b());
        this.f19618a = cameraB;
        if (cameraB == null) {
            throw new RuntimeException("Failed to open camera");
        }
        int iA = I3.a.a(this.f19624g.b());
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.f19619b = cameraInfo;
        Camera.getCameraInfo(iA, cameraInfo);
    }

    public void m(p pVar) {
        Camera camera = this.f19618a;
        if (camera == null || !this.f19622e) {
            return;
        }
        this.f19630m.a(pVar);
        camera.setOneShotPreviewCallback(this.f19630m);
    }

    public final void n(int i7) {
        this.f19618a.setDisplayOrientation(i7);
    }

    public void o(i iVar) {
        this.f19624g = iVar;
    }

    public final void p(boolean z7) {
        Camera.Parameters parametersG = g();
        if (parametersG == null) {
            Log.w(f19617n, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str = f19617n;
        Log.i(str, "Initial camera parameters: " + parametersG.flatten());
        if (z7) {
            Log.w(str, "In camera config safe mode -- most settings will not be honored");
        }
        AbstractC1308c.g(parametersG, this.f19624g.a(), z7);
        if (!z7) {
            AbstractC1308c.k(parametersG, false);
            if (this.f19624g.h()) {
                AbstractC1308c.i(parametersG);
            }
            if (this.f19624g.e()) {
                AbstractC1308c.c(parametersG);
            }
            if (this.f19624g.g()) {
                AbstractC1308c.l(parametersG);
                AbstractC1308c.h(parametersG);
                AbstractC1308c.j(parametersG);
            }
        }
        List listI = i(parametersG);
        if (listI.size() == 0) {
            this.f19626i = null;
        } else {
            s sVarA = this.f19625h.a(listI, j());
            this.f19626i = sVarA;
            parametersG.setPreviewSize(sVarA.f19100l, sVarA.f19101m);
        }
        if (Build.DEVICE.equals("glass-1")) {
            AbstractC1308c.e(parametersG);
        }
        Log.i(str, "Final camera parameters: " + parametersG.flatten());
        this.f19618a.setParameters(parametersG);
    }

    public void q(m mVar) {
        this.f19625h = mVar;
    }

    public final void r() {
        try {
            int iC = c();
            this.f19628k = iC;
            n(iC);
        } catch (Exception unused) {
            Log.w(f19617n, "Failed to set rotation.");
        }
        try {
            p(false);
        } catch (Exception unused2) {
            try {
                p(true);
            } catch (Exception unused3) {
                Log.w(f19617n, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.f19618a.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.f19627j = this.f19626i;
        } else {
            this.f19627j = new s(previewSize.width, previewSize.height);
        }
        this.f19630m.b(this.f19627j);
    }

    public void s(j jVar) throws IOException {
        jVar.a(this.f19618a);
    }

    public void t(boolean z7) {
        if (this.f19618a != null) {
            try {
                if (z7 != k()) {
                    C1306a c1306a = this.f19620c;
                    if (c1306a != null) {
                        c1306a.j();
                    }
                    Camera.Parameters parameters = this.f19618a.getParameters();
                    AbstractC1308c.k(parameters, z7);
                    if (this.f19624g.f()) {
                        AbstractC1308c.d(parameters, z7);
                    }
                    this.f19618a.setParameters(parameters);
                    C1306a c1306a2 = this.f19620c;
                    if (c1306a2 != null) {
                        c1306a2.i();
                    }
                }
            } catch (RuntimeException e7) {
                Log.e(f19617n, "Failed to set torch", e7);
            }
        }
    }

    public void u() {
        Camera camera = this.f19618a;
        if (camera == null || this.f19622e) {
            return;
        }
        camera.startPreview();
        this.f19622e = true;
        this.f19620c = new C1306a(this.f19618a, this.f19624g);
        H3.b bVar = new H3.b(this.f19629l, this, this.f19624g);
        this.f19621d = bVar;
        bVar.c();
    }

    public void v() {
        C1306a c1306a = this.f19620c;
        if (c1306a != null) {
            c1306a.j();
            this.f19620c = null;
        }
        H3.b bVar = this.f19621d;
        if (bVar != null) {
            bVar.d();
            this.f19621d = null;
        }
        Camera camera = this.f19618a;
        if (camera == null || !this.f19622e) {
            return;
        }
        camera.stopPreview();
        this.f19630m.a(null);
        this.f19622e = false;
    }
}
