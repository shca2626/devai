package f4;

import M5.g;
import M5.m;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.fasterxml.jackson.core.JsonPointer;
import g4.AbstractC1112c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import y5.C1823s;

/* renamed from: f4.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1057d implements InterfaceC1058e {

    /* renamed from: a, reason: collision with root package name */
    public final EnumC1056c f15869a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15870b;

    /* renamed from: f4.d$a */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15871a;

        static {
            int[] iArr = new int[EnumC1056c.values().length];
            try {
                iArr[EnumC1056c.f15865m.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC1056c.f15864l.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f15871a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1057d() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // f4.InterfaceC1058e
    public File a(Context context, File file, String str, boolean z7) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        String path;
        m.e(context, "context");
        m.e(file, "videoFile");
        m.e(str, "fileName");
        EnumC1056c enumC1056c = this.f15869a;
        int i7 = enumC1056c == null ? -1 : a.f15871a[enumC1056c.ordinal()];
        String str2 = i7 != 1 ? i7 != 2 ? Environment.DIRECTORY_MOVIES : Environment.DIRECTORY_PICTURES : Environment.DIRECTORY_DOWNLOADS;
        if (Build.VERSION.SDK_INT >= 29) {
            if (this.f15870b != null) {
                str2 = str2 + JsonPointer.SEPARATOR + this.f15870b;
            }
            if (!z7) {
                return new File(context.getCacheDir(), str);
            }
            m.b(str2);
            AbstractC1112c.a(context, str, str2, file);
            new File(context.getCacheDir(), str).delete();
            return new File("/storage/emulated/0/" + str2, str);
        }
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(str2);
        if (this.f15870b != null) {
            path = externalStoragePublicDirectory + JsonPointer.SEPARATOR + this.f15870b;
        } else {
            path = externalStoragePublicDirectory.getPath();
        }
        File file2 = new File(path, str);
        if (!file2.exists()) {
            try {
                File parentFile = file2.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
            } catch (IOException e7) {
                e7.printStackTrace();
            }
        }
        if (z7) {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i8 = fileInputStream.read(bArr);
                        if (i8 <= 0) {
                            break;
                        }
                        fileOutputStreamOpenFileOutput.write(bArr, 0, i8);
                    }
                    C1823s c1823s = C1823s.f24020a;
                    J5.b.a(fileInputStream, null);
                    J5.b.a(fileOutputStreamOpenFileOutput, null);
                } finally {
                }
            } finally {
            }
        }
        return file2;
    }

    public C1057d(EnumC1056c enumC1056c, String str) {
        this.f15869a = enumC1056c;
        this.f15870b = str;
    }

    public /* synthetic */ C1057d(EnumC1056c enumC1056c, String str, int i7, g gVar) {
        this((i7 & 1) != 0 ? null : enumC1056c, (i7 & 2) != 0 ? null : str);
    }
}
