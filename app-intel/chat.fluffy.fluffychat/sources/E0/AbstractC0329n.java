package E0;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.os.Build;
import java.util.List;
import k3.AbstractC1278v;

/* renamed from: E0.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0329n {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f2180a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f2181b = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f2182c = {12445, 13120, 12344, 12344};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f2183d = {12445, 13632, 12344, 12344};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f2184e = {12344};

    /* renamed from: E0.n$a */
    public static final class a extends Exception {

        /* renamed from: l, reason: collision with root package name */
        public final AbstractC1278v f2185l;

        public a(String str) {
            this(str, AbstractC1278v.v());
        }

        public a(String str, List list) {
            super(str);
            this.f2185l = AbstractC1278v.r(list);
        }
    }

    public static void a() throws a {
        StringBuilder sb = new StringBuilder();
        AbstractC1278v.a aVar = new AbstractC1278v.a();
        boolean z7 = false;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            if (z7) {
                sb.append('\n');
            }
            String strGluErrorString = GLU.gluErrorString(iGlGetError);
            if (strGluErrorString == null) {
                strGluErrorString = "error code: 0x" + Integer.toHexString(iGlGetError);
            }
            sb.append("glError: ");
            sb.append(strGluErrorString);
            aVar.a(Integer.valueOf(iGlGetError));
            z7 = true;
        }
        if (z7) {
            throw new a(sb.toString(), aVar.k());
        }
    }

    public static void b(boolean z7, String str) throws a {
        if (!z7) {
            throw new a(str);
        }
    }

    public static EGLDisplay c() throws a {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        b(!eGLDisplayEglGetDisplay.equals(EGL14.EGL_NO_DISPLAY), "No EGL display.");
        b(EGL14.eglInitialize(eGLDisplayEglGetDisplay, new int[1], 0, new int[1], 0), "Error in eglInitialize.");
        a();
        return eGLDisplayEglGetDisplay;
    }

    public static boolean d() {
        return g("EGL_EXT_gl_colorspace_bt2020_hlg");
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 33 && g("EGL_EXT_gl_colorspace_bt2020_pq");
    }

    public static boolean f(int i7) {
        if (i7 == 6) {
            return e();
        }
        if (i7 == 7) {
            return d();
        }
        return true;
    }

    public static boolean g(String str) {
        String strEglQueryString = EGL14.eglQueryString(c(), 12373);
        return strEglQueryString != null && strEglQueryString.contains(str);
    }

    public static boolean h(Context context) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 26 && ("samsung".equals(Build.MANUFACTURER) || "XT1650".equals(Build.MODEL))) {
            return false;
        }
        if (i7 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return g("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean i() {
        return g("EGL_KHR_surfaceless_context");
    }
}
