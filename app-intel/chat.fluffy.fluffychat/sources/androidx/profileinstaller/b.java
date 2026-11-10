package androidx.profileinstaller;

import S1.j;
import S1.k;
import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final AssetManager f12968a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f12969b;

    /* renamed from: c, reason: collision with root package name */
    public final c.InterfaceC0120c f12970c;

    /* renamed from: e, reason: collision with root package name */
    public final File f12972e;

    /* renamed from: f, reason: collision with root package name */
    public final String f12973f;

    /* renamed from: g, reason: collision with root package name */
    public final String f12974g;

    /* renamed from: h, reason: collision with root package name */
    public final String f12975h;

    /* renamed from: j, reason: collision with root package name */
    public S1.b[] f12977j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f12978k;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12976i = false;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f12971d = d();

    public b(AssetManager assetManager, Executor executor, c.InterfaceC0120c interfaceC0120c, String str, String str2, String str3, File file) {
        this.f12968a = assetManager;
        this.f12969b = executor;
        this.f12970c = interfaceC0120c;
        this.f12973f = str;
        this.f12974g = str2;
        this.f12975h = str3;
        this.f12972e = file;
    }

    public static byte[] d() {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 31) {
            return k.f8158a;
        }
        switch (i7) {
            case 24:
            case 25:
                return k.f8162e;
            case 26:
                return k.f8161d;
            case 27:
                return k.f8160c;
            case 28:
            case 29:
            case 30:
                return k.f8159b;
            default:
                return null;
        }
    }

    public static boolean j() {
        int i7 = Build.VERSION.SDK_INT;
        return i7 >= 31 || i7 == 24 || i7 == 25;
    }

    public final b b(S1.b[] bVarArr, byte[] bArr) throws IOException {
        InputStream inputStreamG;
        try {
            inputStreamG = g(this.f12968a, this.f12975h);
        } catch (FileNotFoundException e7) {
            this.f12970c.b(9, e7);
        } catch (IOException e8) {
            this.f12970c.b(7, e8);
        } catch (IllegalStateException e9) {
            this.f12977j = null;
            this.f12970c.b(8, e9);
        }
        if (inputStreamG == null) {
            if (inputStreamG != null) {
                inputStreamG.close();
            }
            return null;
        }
        try {
            this.f12977j = j.r(inputStreamG, j.p(inputStreamG, j.f8157b), bArr, bVarArr);
            inputStreamG.close();
            return this;
        } catch (Throwable th) {
            try {
                inputStreamG.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void c() {
        if (!this.f12976i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    public boolean e() {
        if (this.f12971d == null) {
            k(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f12972e.exists()) {
            try {
                if (!this.f12972e.createNewFile()) {
                    k(4, null);
                    return false;
                }
            } catch (IOException unused) {
                k(4, null);
                return false;
            }
        } else if (!this.f12972e.canWrite()) {
            k(4, null);
            return false;
        }
        this.f12976i = true;
        return true;
    }

    public final InputStream f(AssetManager assetManager) {
        try {
            return g(assetManager, this.f12974g);
        } catch (FileNotFoundException e7) {
            this.f12970c.b(6, e7);
            return null;
        } catch (IOException e8) {
            this.f12970c.b(7, e8);
            return null;
        }
    }

    public final InputStream g(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e7) {
            String message = e7.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f12970c.a(5, null);
            }
            return null;
        }
    }

    public b h() {
        b bVarB;
        c();
        if (this.f12971d != null) {
            InputStream inputStreamF = f(this.f12968a);
            if (inputStreamF != null) {
                this.f12977j = i(inputStreamF);
            }
            S1.b[] bVarArr = this.f12977j;
            if (bVarArr != null && j() && (bVarB = b(bVarArr, this.f12971d)) != null) {
                return bVarB;
            }
        }
        return this;
    }

    public final S1.b[] i(InputStream inputStream) throws IOException {
        try {
            try {
                try {
                    S1.b[] bVarArrX = j.x(inputStream, j.p(inputStream, j.f8156a), this.f12973f);
                    try {
                        inputStream.close();
                        return bVarArrX;
                    } catch (IOException e7) {
                        this.f12970c.b(7, e7);
                        return bVarArrX;
                    }
                } catch (IllegalStateException e8) {
                    this.f12970c.b(8, e8);
                    return null;
                }
            } catch (IOException e9) {
                this.f12970c.b(7, e9);
                return null;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e10) {
                this.f12970c.b(7, e10);
            }
        }
    }

    public final void k(final int i7, final Object obj) {
        this.f12969b.execute(new Runnable() { // from class: S1.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f8130l.f12970c.b(i7, obj);
            }
        });
    }

    public b l() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        S1.b[] bVarArr = this.f12977j;
        byte[] bArr = this.f12971d;
        if (bVarArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    j.F(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e7) {
                this.f12970c.b(7, e7);
            } catch (IllegalStateException e8) {
                this.f12970c.b(8, e8);
            }
            if (!j.C(byteArrayOutputStream, bArr, bVarArr)) {
                this.f12970c.b(5, null);
                this.f12977j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f12978k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f12977j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean m() {
        byte[] bArr = this.f12978k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f12972e);
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        try {
                            FileLock fileLockTryLock = channel.tryLock();
                            try {
                                S1.c.l(byteArrayInputStream, fileOutputStream, fileLockTryLock);
                                k(1, null);
                                if (fileLockTryLock != null) {
                                    fileLockTryLock.close();
                                }
                                channel.close();
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                                return true;
                            } finally {
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                k(6, e7);
                return false;
            } catch (IOException e8) {
                k(7, e8);
                return false;
            }
        } finally {
            this.f12978k = null;
            this.f12977j = null;
        }
    }
}
