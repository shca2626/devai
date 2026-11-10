package G0;

import E0.U;
import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public final class o extends b {

    /* renamed from: e, reason: collision with root package name */
    public RandomAccessFile f3204e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f3205f;

    /* renamed from: g, reason: collision with root package name */
    public long f3206g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3207h;

    public static class a extends g {
        public a(Throwable th, int i7) {
            super(th, i7);
        }

        public a(String str, Throwable th, int i7) {
            super(str, th, i7);
        }
    }

    public o() {
        super(false);
    }

    public static RandomAccessFile y(Uri uri) throws a {
        try {
            return new RandomAccessFile((String) j3.o.q(uri.getPath()), "r");
        } catch (FileNotFoundException e7) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new a(e7, ((e7.getCause() instanceof ErrnoException) && ((ErrnoException) e7.getCause()).errno == OsConstants.EACCES) ? 2006 : 2005);
            }
            throw new a(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e7, 1004);
        } catch (SecurityException e8) {
            throw new a(e8, 2006);
        } catch (RuntimeException e9) {
            throw new a(e9, 2000);
        }
    }

    @Override // G0.f
    public void close() {
        this.f3205f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f3204e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e7) {
                throw new a(e7, 2000);
            }
        } finally {
            this.f3204e = null;
            if (this.f3207h) {
                this.f3207h = false;
                v();
            }
        }
    }

    @Override // G0.f
    public Uri r() {
        return this.f3205f;
    }

    @Override // B0.InterfaceC0309k
    public int read(byte[] bArr, int i7, int i8) throws IOException {
        if (i8 == 0) {
            return 0;
        }
        if (this.f3206g == 0) {
            return -1;
        }
        try {
            int i9 = ((RandomAccessFile) U.i(this.f3204e)).read(bArr, i7, (int) Math.min(this.f3206g, i8));
            if (i9 > 0) {
                this.f3206g -= i9;
                u(i9);
            }
            return i9;
        } catch (IOException e7) {
            throw new a(e7, 2000);
        }
    }

    @Override // G0.f
    public long s(j jVar) throws IOException {
        Uri uri = jVar.f3143a;
        this.f3205f = uri;
        w(jVar);
        RandomAccessFile randomAccessFileY = y(uri);
        this.f3204e = randomAccessFileY;
        try {
            randomAccessFileY.seek(jVar.f3149g);
            long length = jVar.f3150h;
            if (length == -1) {
                length = this.f3204e.length() - jVar.f3149g;
            }
            this.f3206g = length;
            if (length < 0) {
                throw new a(null, null, 2008);
            }
            this.f3207h = true;
            x(jVar);
            return this.f3206g;
        } catch (IOException e7) {
            throw new a(e7, 2000);
        }
    }
}
