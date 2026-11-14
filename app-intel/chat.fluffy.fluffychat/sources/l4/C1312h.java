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
public final class C1312h {

    /* renamed from: n, reason: collision with root package name */
    public static final String f19616n = "h";

    /* renamed from: a, reason: collision with root package name */
    public Camera f19617a;

    /* renamed from: b, reason: collision with root package name */
    public Camera.CameraInfo f19618b;

    /* renamed from: c, reason: collision with root package name */
    public C1305a f19619c;

    /* renamed from: d, reason: collision with root package name */
    public H3.b f19620d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f19621e;

    /* renamed from: f, reason: collision with root package name */
    public String f19622f;

    /* renamed from: h, reason: collision with root package name */
    public m f19624h;

    /* renamed from: i, reason: collision with root package name */
    public s f19625i;

    /* renamed from: j, reason: collision with root package name */
    public s f19626j;

    /* renamed from: l, reason: collision with root package name */
    public Context f19628l;

    /* renamed from: g, reason: collision with root package name */
    public i f19623g = new i();

    /* renamed from: k, reason: collision with root package name */
    public int f19627k = -1;

    /* renamed from: m, reason: collision with root package name */
    public final a f19629m = new a();

    /* renamed from: l4.h$a */
    public final class a implements Camera.PreviewCallback {

        /* renamed from: a, reason: collision with root package name */
        public p f19630a;

        /* renamed from: b, reason: collision with root package name */
        public s f19631b;

        public a() {
        }

        public void a(p pVar) {
            this.f19630a = pVar;
        }

        public void b(s sVar) {
            this.f19631b = sVar;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            s sVar = this.f19631b;
            p pVar = this.f19630a;
            if (sVar == null || pVar == null) {
                Log.d(C1312h.f19616n, "Got preview callback, but no handler or resolution available");
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
                t tVar = new t(bArr, sVar.f19099l, sVar.f19100m, camera.getParameters().getPreviewFormat(), C1312h.this.f());
                if (C1312h.this.f19618b.facing == 1) {
                    tVar.e(true);
                }
                pVar.b(tVar);
            } catch (RuntimeException e7) {
                Log.e(C1312h.f19616n, "Camera preview failed", e7);
                pVar.a(e7);
            }
        }
    }

    public C1312h(Context context) {
        this.f19628l = context;
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
        int iC = this.f19624h.c();
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
        Camera.CameraInfo cameraInfo = this.f19618b;
        int i8 = cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i7) % 360)) % 360 : ((cameraInfo.orientation - i7) + 360) % 360;
        Log.i(f19616n, "Camera Display Orientation: " + i8);
        return i8;
    }

    public void d() {
        Camera camera = this.f19617a;
        if (camera != null) {
            camera.release();
            this.f19617a = null;
        }
    }

    public void e() {
        if (this.f19617a == null) {
            throw new RuntimeException("Camera not open");
        }
        r();
    }

    public int f() {
        return this.f19627k;
    }

    public final Camera.Parameters g() {
        Camera.Parameters parameters = this.f19617a.getParameters();
        String str = this.f19622f;
        if (str == null) {
            this.f19622f = parameters.flatten();
            return parameters;
        }
        parameters.unflatten(str);
        return parameters;
    }

    public s h() {
        if (this.f19626j == null) {
            return null;
        }
        return j() ? this.f19626j.d() : this.f19626j;
    }

    public boolean j() {
        int i7 = this.f19627k;
        if (i7 != -1) {
            return i7 % 180 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public boolean k() {
        String flashMode;
        Camera.Parameters parameters = this.f19617a.getParameters();
        return (parameters == null || (flashMode = parameters.getFlashMode()) == null || (!"on".equals(flashMode) && !"torch".equals(flashMode))) ? false : true;
    }

    public void l() {
        Camera cameraB = I3.a.b(this.f19623g.b());
        this.f19617a = cameraB;
        if (cameraB == null) {
            throw new RuntimeException("Failed to open camera");
        }
        int iA = I3.a.a(this.f19623g.b());
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.f19618b = cameraInfo;
        Camera.getCameraInfo(iA, cameraInfo);
    }

    public void m(p pVar) {
        Camera camera = this.f19617a;
        if (camera == null || !this.f19621e) {
            return;
        }
        this.f19629m.a(pVar);
        camera.setOneShotPreviewCallback(this.f19629m);
    }

    public final void n(int i7) {
        this.f19617a.setDisplayOrientation(i7);
    }

    public void o(i iVar) {
        this.f19623g = iVar;
    }

    public final void p(boolean z7) {
        Camera.Parameters parametersG = g();
        if (parametersG == null) {
            Log.w(f19616n, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str = f19616n;
        Log.i(str, "Initial camera parameters: " + parametersG.flatten());
        if (z7) {
            Log.w(str, "In camera config safe mode -- most settings will not be honored");
        }
        AbstractC1307c.g(parametersG, this.f19623g.a(), z7);
        if (!z7) {
            AbstractC1307c.k(parametersG, false);
            if (this.f19623g.h()) {
                AbstractC1307c.i(parametersG);
            }
            if (this.f19623g.e()) {
                AbstractC1307c.c(parametersG);
            }
            if (this.f19623g.g()) {
                AbstractC1307c.l(parametersG);
                AbstractC1307c.h(parametersG);
                AbstractC1307c.j(parametersG);
            }
        }
        List listI = i(parametersG);
        if (listI.size() == 0) {
            this.f19625i = null;
        } else {
            s sVarA = this.f19624h.a(listI, j());
            this.f19625i = sVarA;
            parametersG.setPreviewSize(sVarA.f19099l, sVarA.f19100m);
        }
        if (Build.DEVICE.equals("glass-1")) {
            AbstractC1307c.e(parametersG);
        }
        Log.i(str, "Final camera parameters: " + parametersG.flatten());
        this.f19617a.setParameters(parametersG);
    }

    public void q(m mVar) {
        this.f19624h = mVar;
    }

    public final void r() {
        try {
            int iC = c();
            this.f19627k = iC;
            n(iC);
        } catch (Exception unused) {
            Log.w(f19616n, "Failed to set rotation.");
        }
        try {
            p(false);
        } catch (Exception unused2) {
            try {
                p(true);
            } catch (Exception unused3) {
                Log.w(f19616n, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.f19617a.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.f19626j = this.f19625i;
        } else {
            this.f19626j = new s(previewSize.width, previewSize.height);
        }
        this.f19629m.b(this.f19626j);
    }

    public void s(j jVar) throws IOException {
        jVar.a(this.f19617a);
    }

    public void t(boolean z7) {
        if (this.f19617a != null) {
            try {
                if (z7 != k()) {
                    C1305a c1305a = this.f19619c;
                    if (c1305a != null) {
                        c1305a.j();
                    }
                    Camera.Parameters parameters = this.f19617a.getParameters();
                    AbstractC1307c.k(parameters, z7);
                    if (this.f19623g.f()) {
                        AbstractC1307c.d(parameters, z7);
                    }
                    this.f19617a.setParameters(parameters);
                    C1305a c1305a2 = this.f19619c;
                    if (c1305a2 != null) {
                        c1305a2.i();
                    }
                }
            } catch (RuntimeException e7) {
                Log.e(f19616n, "Failed to set torch", e7);
            }
        }
    }

    public void u() {
        Camera camera = this.f19617a;
        if (camera == null || this.f19621e) {
            return;
        }
        camera.startPreview();
        this.f19621e = true;
        this.f19619c = new C1305a(this.f19617a, this.f19623g);
        H3.b bVar = new H3.b(this.f19628l, this, this.f19623g);
        this.f19620d = bVar;
        bVar.c();
    }

    public void v() {
        C1305a c1305a = this.f19619c;
        if (c1305a != null) {
            c1305a.j();
            this.f19619c = null;
        }
        H3.b bVar = this.f19620d;
        if (bVar != null) {
            bVar.d();
            this.f19620d = null;
        }
        Camera camera = this.f19617a;
        if (camera == null || !this.f19621e) {
            return;
        }
        camera.stopPreview();
        this.f19629m.a(null);
        this.f19621e = false;
    }
}
