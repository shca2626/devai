package N4;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* loaded from: classes.dex */
public class q {
    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int i7 = inputStream.read(bArr);
            if (i7 == -1) {
                outputStream.flush();
                return;
            }
            outputStream.write(bArr, 0, i7);
        }
    }

    public static String b(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf < 0 ? str : str.substring(0, iLastIndexOf);
    }

    public static String c(Context context, Uri uri) {
        String fileExtensionFromUrl;
        if (uri.getScheme().equals("content")) {
            fileExtensionFromUrl = MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
        } else {
            try {
                fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
            } catch (NullPointerException unused) {
            }
        }
        if (fileExtensionFromUrl != null && !fileExtensionFromUrl.isEmpty()) {
            return "." + i(fileExtensionFromUrl);
        }
        return null;
    }

    public static String d(Context context, Uri uri) {
        Cursor cursorG = g(context, uri);
        if (cursorG != null) {
            try {
                if (cursorG.moveToFirst() && cursorG.getColumnCount() >= 1) {
                    String strI = i(cursorG.getString(0));
                    cursorG.close();
                    return strI;
                }
            } catch (Throwable th) {
                try {
                    cursorG.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (cursorG != null) {
            cursorG.close();
        }
        return null;
    }

    public static String e(Context context, Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        try {
            File file = new File(context.getCacheDir(), UUID.nameUUIDFromBytes(uri.toString().getBytes()).toString());
            file.mkdir();
            file.deleteOnExit();
            String strD = d(context, uri);
            String strC = c(context, uri);
            if (strD == null) {
                if (strC == null) {
                    throw new IllegalStateException("No name nor extension found for file.");
                }
                strD = "file_selector" + strC;
            } else if (strC != null) {
                strD = b(strD) + strC;
            }
            File fileH = h(new File(file, strD).getPath(), file.getCanonicalPath());
            FileOutputStream fileOutputStream = new FileOutputStream(fileH);
            try {
                a(inputStreamOpenInputStream, fileOutputStream);
                String path = fileH.getPath();
                fileOutputStream.close();
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                return path;
            } finally {
            }
        } catch (Throwable th) {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static String f(Context context, Uri uri) {
        String authority = uri.getAuthority();
        if (!"com.android.externalstorage.documents".equals(authority)) {
            throw new UnsupportedOperationException("Retrieving the path from URIs with authority " + authority.toString() + " is unsupported by this plugin.");
        }
        String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
        if (strArrSplit.length < 2) {
            throw new UnsupportedOperationException("Retrieving the path of a document with an unknown storage volume or name is unsupported by this plugin.");
        }
        String str = strArrSplit[0];
        if (!str.equals("primary")) {
            throw new UnsupportedOperationException("Retrieving the path of a document from storage volume " + str + " is unsupported by this plugin.");
        }
        String str2 = strArrSplit[1];
        return Environment.getExternalStorageDirectory().getPath() + "/" + str2;
    }

    public static Cursor g(Context context, Uri uri) {
        return context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
    }

    public static File h(String str, String str2) {
        File file = new File(str);
        if (file.getCanonicalPath().startsWith(str2)) {
            return file;
        }
        throw new IllegalArgumentException("Trying to open path outside of the expected directory. File: " + file.getCanonicalPath() + " was expected to be within directory: " + str2 + ".");
    }

    public static String i(String str) {
        if (str == null) {
            return null;
        }
        String[] strArr = {"..", "/"};
        String strReplace = str.split("/")[r4.length - 1];
        for (int i7 = 0; i7 < 2; i7++) {
            strReplace = strReplace.replace(strArr[i7], "_");
        }
        return strReplace;
    }
}
