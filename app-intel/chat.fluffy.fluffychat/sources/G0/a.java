package G0;

import E0.U;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: e, reason: collision with root package name */
    public final AssetManager f3117e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f3118f;

    /* renamed from: g, reason: collision with root package name */
    public InputStream f3119g;

    /* renamed from: h, reason: collision with root package name */
    public long f3120h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3121i;

    /* renamed from: G0.a$a, reason: collision with other inner class name */
    public static final class C0034a extends g {
        public C0034a(Throwable th, int i7) {
            super(th, i7);
        }
    }

    public a(Context context) {
        super(false);
        this.f3117e = context.getAssets();
    }

    @Override // G0.f
    public void close() {
        this.f3118f = null;
        try {
            try {
                InputStream inputStream = this.f3119g;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e7) {
                throw new C0034a(e7, 2000);
            }
        } finally {
            this.f3119g = null;
            if (this.f3121i) {
                this.f3121i = false;
                v();
            }
        }
    }

    @Override // G0.f
    public Uri r() {
        return this.f3118f;
    }

    @Override // B0.InterfaceC0309k
    public int read(byte[] bArr, int i7, int i8) throws IOException {
        if (i8 == 0) {
            return 0;
        }
        long j7 = this.f3120h;
        if (j7 == 0) {
            return -1;
        }
        if (j7 != -1) {
            try {
                i8 = (int) Math.min(j7, i8);
            } catch (IOException e7) {
                throw new C0034a(e7, 2000);
            }
        }
        int i9 = ((InputStream) U.i(this.f3119g)).read(bArr, i7, i8);
        if (i9 == -1) {
            return -1;
        }
        long j8 = this.f3120h;
        if (j8 != -1) {
            this.f3120h = j8 - i9;
        }
        u(i9);
        return i9;
    }

    @Override // G0.f
    public long s(j jVar) throws IOException {
        try {
            Uri uri = jVar.f3143a;
            this.f3118f = uri;
            String strSubstring = (String) j3.o.q(uri.getPath());
            if (strSubstring.startsWith("/android_asset/")) {
                strSubstring = strSubstring.substring(15);
            } else if (strSubstring.startsWith("/")) {
                strSubstring = strSubstring.substring(1);
            }
            w(jVar);
            InputStream inputStreamOpen = this.f3117e.open(strSubstring, 1);
            this.f3119g = inputStreamOpen;
            if (inputStreamOpen.skip(jVar.f3149g) < jVar.f3149g) {
                throw new C0034a(null, 2008);
            }
            long j7 = jVar.f3150h;
            if (j7 != -1) {
                this.f3120h = j7;
            } else {
                long jAvailable = this.f3119g.available();
                this.f3120h = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.f3120h = -1L;
                }
            }
            this.f3121i = true;
            x(jVar);
            return this.f3120h;
        } catch (C0034a e7) {
            throw e7;
        } catch (IOException e8) {
            throw new C0034a(e8, e8 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }
}
