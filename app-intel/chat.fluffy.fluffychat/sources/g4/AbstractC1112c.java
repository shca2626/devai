package g4;

import M5.m;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import y5.C1823s;

/* renamed from: g4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1112c {
    public static final void a(Context context, String str, String str2, File file) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        m.e(context, "context");
        m.e(str, "videoFileName");
        m.e(str2, "saveLocation");
        m.e(file, "videoFile");
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", "video/mp4");
        contentValues.put("relative_path", str2);
        contentValues.put("is_pending", (Integer) 1);
        Uri contentUri = MediaStore.Video.Media.getContentUri("external_primary");
        if (m.a(str2, Environment.DIRECTORY_DOWNLOADS)) {
            contentUri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
        }
        Uri uriInsert = context.getContentResolver().insert(contentUri, contentValues);
        if (uriInsert != null) {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uriInsert, "rw");
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i7 = fileInputStream.read(bArr);
                                if (i7 <= 0) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i7);
                                }
                            }
                            C1823s c1823s = C1823s.f24020a;
                            J5.b.a(fileInputStream, null);
                            J5.b.a(fileOutputStream, null);
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        J5.b.a(parcelFileDescriptorOpenFileDescriptor, th);
                        throw th2;
                    }
                }
            }
            J5.b.a(parcelFileDescriptorOpenFileDescriptor, null);
            contentValues.clear();
            contentValues.put("is_pending", (Integer) 0);
            context.getContentResolver().update(uriInsert, contentValues, null, null);
        }
    }
}
