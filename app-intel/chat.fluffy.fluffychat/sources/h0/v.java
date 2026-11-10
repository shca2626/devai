package h0;

import java.io.File;

/* loaded from: classes.dex */
public abstract class v {
    public static final t a(File file) {
        M5.m.e(file, "file");
        String absolutePath = file.getCanonicalFile().getAbsolutePath();
        M5.m.d(absolutePath, "file.canonicalFile.absolutePath");
        return u.a(absolutePath);
    }
}
