package L;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class c extends ContentProvider {

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f5415p = {"_display_name", "_size"};

    /* renamed from: q, reason: collision with root package name */
    public static final File f5416q = new File("/");

    /* renamed from: r, reason: collision with root package name */
    public static final HashMap f5417r = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public final Object f5418l;

    /* renamed from: m, reason: collision with root package name */
    public final int f5419m;

    /* renamed from: n, reason: collision with root package name */
    public String f5420n;

    /* renamed from: o, reason: collision with root package name */
    public a f5421o;

    public interface a {
        File a(Uri uri);

        Uri b(File file);
    }

    public static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        public final String f5422a;

        /* renamed from: b, reason: collision with root package name */
        public final HashMap f5423b = new HashMap();

        public b(String str) {
            this.f5422a = str;
        }

        @Override // L.c.a
        public File a(Uri uri) throws IOException {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            if (iIndexOf == -1) {
                throw new IllegalArgumentException("Unable to find path from root: " + uri);
            }
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = (File) this.f5423b.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (d(canonicalFile.getPath(), file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }

        @Override // L.c.a
        public Uri b(File file) throws IOException {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry entry = null;
                for (Map.Entry entry2 : this.f5423b.entrySet()) {
                    String path = ((File) entry2.getValue()).getPath();
                    if (d(canonicalPath, path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = ((File) entry.getValue()).getPath();
                return new Uri.Builder().scheme("content").authority(this.f5422a).encodedPath(Uri.encode((String) entry.getKey()) + JsonPointer.SEPARATOR + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        public void c(String str, File file) throws IOException {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.f5423b.put(str, file.getCanonicalFile());
            } catch (IOException e7) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e7);
            }
        }

        public final boolean d(String str, String str2) {
            return c.k(str).startsWith(c.k(str2) + JsonPointer.SEPARATOR);
        }
    }

    public c() {
        this(0);
    }

    public static File b(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    public static Object[] c(Object[] objArr, int i7) {
        Object[] objArr2 = new Object[i7];
        System.arraycopy(objArr, 0, objArr2, 0, i7);
        return objArr2;
    }

    public static String[] d(String[] strArr, int i7) {
        String[] strArr2 = new String[i7];
        System.arraycopy(strArr, 0, strArr2, 0, i7);
        return strArr2;
    }

    public static XmlResourceParser e(Context context, String str, ProviderInfo providerInfo, int i7) {
        if (providerInfo == null) {
            throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
        }
        if (providerInfo.metaData == null && i7 != 0) {
            Bundle bundle = new Bundle(1);
            providerInfo.metaData = bundle;
            bundle.putInt("android.support.FILE_PROVIDER_PATHS", i7);
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData != null) {
            return xmlResourceParserLoadXmlMetaData;
        }
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }

    public static a g(Context context, String str, int i7) {
        a aVarJ;
        HashMap map = f5417r;
        synchronized (map) {
            try {
                aVarJ = (a) map.get(str);
                if (aVarJ == null) {
                    try {
                        try {
                            aVarJ = j(context, str, i7);
                            map.put(str, aVarJ);
                        } catch (IOException e7) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e7);
                        }
                    } catch (XmlPullParserException e8) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e8);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVarJ;
    }

    public static Uri h(Context context, String str, File file) {
        return g(context, str, 0).b(file);
    }

    public static int i(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    public static a j(Context context, String str, int i7) throws XmlPullParserException, IOException {
        b bVar = new b(str);
        XmlResourceParser xmlResourceParserE = e(context, str, context.getPackageManager().resolveContentProvider(str, 128), i7);
        while (true) {
            int next = xmlResourceParserE.next();
            if (next == 1) {
                return bVar;
            }
            if (next == 2) {
                String name = xmlResourceParserE.getName();
                File externalStorageDirectory = null;
                String attributeValue = xmlResourceParserE.getAttributeValue(null, "name");
                String attributeValue2 = xmlResourceParserE.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    externalStorageDirectory = f5416q;
                } else if ("files-path".equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] fileArrF = L.b.f(context, null);
                    if (fileArrF.length > 0) {
                        externalStorageDirectory = fileArrF[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] fileArrE = L.b.e(context);
                    if (fileArrE.length > 0) {
                        externalStorageDirectory = fileArrE[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] externalMediaDirs = context.getExternalMediaDirs();
                    if (externalMediaDirs.length > 0) {
                        externalStorageDirectory = externalMediaDirs[0];
                    }
                }
                if (externalStorageDirectory != null) {
                    bVar.c(attributeValue, b(externalStorageDirectory, attributeValue2));
                }
            }
        }
    }

    public static String k(String str) {
        return (str.length() <= 0 || str.charAt(str.length() + (-1)) != '/') ? str : str.substring(0, str.length() - 1);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        String str = providerInfo.authority;
        if (str == null || str.trim().isEmpty()) {
            throw new SecurityException("Provider must have a non-empty authority");
        }
        String str2 = providerInfo.authority.split(";")[0];
        synchronized (this.f5418l) {
            this.f5420n = str2;
        }
        HashMap map = f5417r;
        synchronized (map) {
            map.remove(str2);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return f().a(uri).delete() ? 1 : 0;
    }

    public final a f() {
        a aVar;
        synchronized (this.f5418l) {
            try {
                Y.c.d(this.f5420n, "mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
                if (this.f5421o == null) {
                    this.f5421o = g(getContext(), this.f5420n, this.f5419m);
                }
                aVar = this.f5421o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileA = f().a(uri);
        int iLastIndexOf = fileA.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileA.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public String getTypeAnonymous(Uri uri) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(f().a(uri), i(str));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i7;
        File fileA = f().a(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = f5415p;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i8 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i8] = "_display_name";
                i7 = i8 + 1;
                objArr[i8] = queryParameter == null ? fileA.getName() : queryParameter;
            } else if ("_size".equals(str3)) {
                strArr3[i8] = "_size";
                i7 = i8 + 1;
                objArr[i8] = Long.valueOf(fileA.length());
            }
            i8 = i7;
        }
        String[] strArrD = d(strArr3, i8);
        Object[] objArrC = c(objArr, i8);
        MatrixCursor matrixCursor = new MatrixCursor(strArrD, 1);
        matrixCursor.addRow(objArrC);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public c(int i7) {
        this.f5418l = new Object();
        this.f5419m = i7;
    }
}
