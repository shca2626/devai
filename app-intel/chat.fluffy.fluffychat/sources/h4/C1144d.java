package h4;

import M5.g;
import M5.m;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: h4.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1144d {

    /* renamed from: a, reason: collision with root package name */
    public final float f16850a;

    /* renamed from: b, reason: collision with root package name */
    public final float f16851b;

    /* renamed from: c, reason: collision with root package name */
    public final float f16852c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16853d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16854e;

    /* renamed from: f, reason: collision with root package name */
    public final int f16855f;

    /* renamed from: g, reason: collision with root package name */
    public final int f16856g;

    /* renamed from: h, reason: collision with root package name */
    public FloatBuffer f16857h;

    /* renamed from: i, reason: collision with root package name */
    public final String f16858i;

    /* renamed from: j, reason: collision with root package name */
    public final String f16859j;

    /* renamed from: k, reason: collision with root package name */
    public final float[] f16860k;

    /* renamed from: l, reason: collision with root package name */
    public final float[] f16861l;

    /* renamed from: m, reason: collision with root package name */
    public int f16862m;

    /* renamed from: n, reason: collision with root package name */
    public int f16863n;

    /* renamed from: o, reason: collision with root package name */
    public int f16864o;

    /* renamed from: p, reason: collision with root package name */
    public int f16865p;

    /* renamed from: q, reason: collision with root package name */
    public int f16866q;

    /* renamed from: r, reason: collision with root package name */
    public int f16867r;

    /* renamed from: s, reason: collision with root package name */
    public int f16868s;

    /* renamed from: t, reason: collision with root package name */
    public int f16869t;

    /* renamed from: u, reason: collision with root package name */
    public int f16870u;

    public C1144d() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    public final void a(String str) {
        m.e(str, "op");
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": glError " + iGlGetError);
    }

    public final int b() {
        int iE;
        int iE2 = e(35633, this.f16858i);
        if (iE2 == 0 || (iE = e(35632, this.f16859j)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (iGlCreateProgram == 0) {
            return 0;
        }
        GLES20.glAttachShader(iGlCreateProgram, iE2);
        a("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iE);
        a("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    public final void c(SurfaceTexture surfaceTexture) {
        m.e(surfaceTexture, "st");
        a("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.f16861l);
        GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this.f16862m);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f16863n);
        this.f16857h.position(this.f16855f);
        GLES20.glVertexAttribPointer(this.f16866q, 3, 5126, false, this.f16854e, (Buffer) this.f16857h);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f16866q);
        a("glEnableVertexAttribArray maPositionHandle");
        this.f16857h.position(this.f16856g);
        GLES20.glVertexAttribPointer(this.f16867r, 2, 5126, false, this.f16854e, (Buffer) this.f16857h);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f16867r);
        a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.f16860k, 0);
        GLES20.glUniformMatrix4fv(this.f16864o, 1, false, this.f16860k, 0);
        GLES20.glUniformMatrix4fv(this.f16865p, 1, false, this.f16861l, 0);
        int i7 = this.f16868s;
        if (i7 >= 0) {
            GLES20.glUniform1f(i7, this.f16850a);
        }
        int i8 = this.f16869t;
        if (i8 >= 0) {
            GLES20.glUniform1f(i8, this.f16851b);
        }
        int i9 = this.f16870u;
        if (i9 >= 0) {
            GLES20.glUniform1f(i9, this.f16852c);
        }
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
    }

    public final int d() {
        return this.f16863n;
    }

    public final int e(int i7, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i7);
        a("glCreateShader type=" + i7);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public final void f() {
        int iB = b();
        this.f16862m = iB;
        if (iB == 0) {
            throw new RuntimeException("failed creating program");
        }
        this.f16866q = GLES20.glGetAttribLocation(iB, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.f16866q == -1) {
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        this.f16867r = GLES20.glGetAttribLocation(this.f16862m, "aTextureCoord");
        a("glGetAttribLocation aTextureCoord");
        if (this.f16867r == -1) {
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        this.f16864o = GLES20.glGetUniformLocation(this.f16862m, "uMVPMatrix");
        a("glGetUniformLocation uMVPMatrix");
        if (this.f16864o == -1) {
            throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        this.f16865p = GLES20.glGetUniformLocation(this.f16862m, "uSTMatrix");
        a("glGetUniformLocation uSTMatrix");
        if (this.f16865p == -1) {
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
        }
        this.f16868s = GLES20.glGetUniformLocation(this.f16862m, "uBrightness");
        this.f16869t = GLES20.glGetUniformLocation(this.f16862m, "uContrast");
        this.f16870u = GLES20.glGetUniformLocation(this.f16862m, "uSaturation");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i7 = iArr[0];
        this.f16863n = i7;
        GLES20.glBindTexture(36197, i7);
        a("glBindTexture mTextureID");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        a("glTexParameter");
    }

    public C1144d(float f7, float f8, float f9) {
        this.f16850a = f7;
        this.f16851b = f8;
        this.f16852c = f9;
        this.f16853d = 4;
        this.f16854e = 4 * 5;
        this.f16856g = 3;
        this.f16858i = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
        this.f16859j = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uBrightness;\nuniform float uContrast;\nuniform float uSaturation;\nvoid main() {\n  vec4 c = texture2D(sTexture, vTextureCoord);\n  vec3 rgb = c.rgb;\n  // Color adjust, CIColorControls-style order: saturation, then\n  // brightness (additive), then contrast (around 0.5 mid-grey). Identity at\n  // saturation=1, brightness=0, contrast=1, so the no-color path is a no-op.\n  float luma = dot(rgb, vec3(0.2126, 0.7152, 0.0722));\n  rgb = mix(vec3(luma), rgb, uSaturation);\n  rgb = rgb + uBrightness;\n  rgb = (rgb - 0.5) * uContrast + 0.5;\n  gl_FragColor = vec4(clamp(rgb, 0.0, 1.0), c.a);\n}\n";
        this.f16860k = new float[16];
        float[] fArr = new float[16];
        this.f16861l = fArr;
        this.f16863n = -12345;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(20 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        m.d(floatBufferAsFloatBuffer, "asFloatBuffer(...)");
        this.f16857h = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(new float[]{-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f}).position(0);
        Matrix.setIdentityM(fArr, 0);
    }

    public /* synthetic */ C1144d(float f7, float f8, float f9, int i7, g gVar) {
        this((i7 & 1) != 0 ? 0.0f : f7, (i7 & 2) != 0 ? 1.0f : f8, (i7 & 4) != 0 ? 1.0f : f9);
    }
}
