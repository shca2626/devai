package G0;

import E0.U;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.List;

/* loaded from: classes.dex */
public final class v extends b {

    /* renamed from: e, reason: collision with root package name */
    public final Context f3219e;

    /* renamed from: f, reason: collision with root package name */
    public j f3220f;

    /* renamed from: g, reason: collision with root package name */
    public AssetFileDescriptor f3221g;

    /* renamed from: h, reason: collision with root package name */
    public InputStream f3222h;

    /* renamed from: i, reason: collision with root package name */
    public long f3223i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3224j;

    public static class a extends g {
        public a(String str) {
            super(str, null, 2000);
        }

        public a(String str, Throwable th, int i7) {
            super(str, th, i7);
        }
    }

    public v(Context context) {
        super(false);
        this.f3219e = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i7) {
        return Uri.parse("rawresource:///" + i7);
    }

    public static AssetFileDescriptor y(Context context, j jVar) throws Resources.NotFoundException, PackageManager.NameNotFoundException, a {
        Resources resourcesForApplication;
        int identifier;
        Uri uriNormalizeScheme = jVar.f3143a.normalizeScheme();
        if (TextUtils.equals("rawresource", uriNormalizeScheme.getScheme())) {
            resourcesForApplication = context.getResources();
            List<String> pathSegments = uriNormalizeScheme.getPathSegments();
            if (pathSegments.size() != 1) {
                throw new a("rawresource:// URI must have exactly one path element, found " + pathSegments.size());
            }
            identifier = z(pathSegments.get(0));
        } else {
            if (!TextUtils.equals("android.resource", uriNormalizeScheme.getScheme())) {
                throw new a("Unsupported URI scheme (" + uriNormalizeScheme.getScheme() + "). Only android.resource is supported.", null, 1004);
            }
            String strSubstring = (String) j3.o.q(uriNormalizeScheme.getPath());
            if (strSubstring.startsWith("/")) {
                strSubstring = strSubstring.substring(1);
            }
            String packageName = TextUtils.isEmpty(uriNormalizeScheme.getHost()) ? context.getPackageName() : uriNormalizeScheme.getHost();
            if (packageName.equals(context.getPackageName())) {
                resourcesForApplication = context.getResources();
            } else {
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(packageName);
                } catch (PackageManager.NameNotFoundException e7) {
                    throw new a("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e7, 2005);
                }
            }
            if (strSubstring.matches("\\d+")) {
                identifier = z(strSubstring);
            } else {
                identifier = resourcesForApplication.getIdentifier(packageName + ":" + strSubstring, "raw", null);
                if (identifier == 0) {
                    throw new a("Resource not found.", null, 2005);
                }
            }
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = resourcesForApplication.openRawResourceFd(identifier);
            if (assetFileDescriptorOpenRawResourceFd != null) {
                return assetFileDescriptorOpenRawResourceFd;
            }
            throw new a("Resource is compressed: " + uriNormalizeScheme, null, 2000);
        } catch (Resources.NotFoundException e8) {
            throw new a(null, e8, 2005);
        }
    }

    public static int z(String str) throws a {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new a("Resource identifier must be an integer.", null, 1004);
        }
    }

    @Override // G0.f
    public void close() {
        this.f3220f = null;
        try {
            try {
                InputStream inputStream = this.f3222h;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f3222h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f3221g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e7) {
                        throw new a(null, e7, 2000);
                    }
                } finally {
                    this.f3221g = null;
                    if (this.f3224j) {
                        this.f3224j = false;
                        v();
                    }
                }
            } catch (IOException e8) {
                throw new a(null, e8, 2000);
            }
        } catch (Throwable th) {
            this.f3222h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f3221g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f3221g = null;
                    if (this.f3224j) {
                        this.f3224j = false;
                        v();
                    }
                    throw th;
                } catch (IOException e9) {
                    throw new a(null, e9, 2000);
                }
            } finally {
                this.f3221g = null;
                if (this.f3224j) {
                    this.f3224j = false;
                    v();
                }
            }
        }
    }

    @Override // G0.f
    public Uri r() {
        j jVar = this.f3220f;
        if (jVar != null) {
            return jVar.f3143a;
        }
        return null;
    }

    @Override // B0.InterfaceC0309k
    public int read(byte[] bArr, int i7, int i8) throws IOException {
        if (i8 == 0) {
            return 0;
        }
        long j7 = this.f3223i;
        if (j7 == 0) {
            return -1;
        }
        if (j7 != -1) {
            try {
                i8 = (int) Math.min(j7, i8);
            } catch (IOException e7) {
                throw new a(null, e7, 2000);
            }
        }
        int i9 = ((InputStream) U.i(this.f3222h)).read(bArr, i7, i8);
        if (i9 == -1) {
            if (this.f3223i == -1) {
                return -1;
            }
            throw new a("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j8 = this.f3223i;
        if (j8 != -1) {
            this.f3223i = j8 - i9;
        }
        u(i9);
        return i9;
    }

    @Override // G0.f
    public long s(j jVar) throws g, Resources.NotFoundException, PackageManager.NameNotFoundException {
        this.f3220f = jVar;
        w(jVar);
        AssetFileDescriptor assetFileDescriptorY = y(this.f3219e, jVar);
        this.f3221g = assetFileDescriptorY;
        long length = assetFileDescriptorY.getLength();
        FileInputStream fileInputStream = new FileInputStream(this.f3221g.getFileDescriptor());
        this.f3222h = fileInputStream;
        if (length != -1) {
            try {
                if (jVar.f3149g > length) {
                    throw new a(null, null, 2008);
                }
            } catch (a e7) {
                throw e7;
            } catch (IOException e8) {
                throw new a(null, e8, 2000);
            }
        }
        long startOffset = this.f3221g.getStartOffset();
        long jSkip = fileInputStream.skip(jVar.f3149g + startOffset) - startOffset;
        if (jSkip != jVar.f3149g) {
            throw new a(null, null, 2008);
        }
        if (length == -1) {
            FileChannel channel = fileInputStream.getChannel();
            if (channel.size() == 0) {
                this.f3223i = -1L;
            } else {
                long size = channel.size() - channel.position();
                this.f3223i = size;
                if (size < 0) {
                    throw new a(null, null, 2008);
                }
            }
        } else {
            long j7 = length - jSkip;
            this.f3223i = j7;
            if (j7 < 0) {
                throw new g(2008);
            }
        }
        long jMin = jVar.f3150h;
        if (jMin != -1) {
            long j8 = this.f3223i;
            if (j8 != -1) {
                jMin = Math.min(j8, jMin);
            }
            this.f3223i = jMin;
        }
        this.f3224j = true;
        x(jVar);
        long j9 = jVar.f3150h;
        return j9 != -1 ? j9 : this.f3223i;
    }
}
