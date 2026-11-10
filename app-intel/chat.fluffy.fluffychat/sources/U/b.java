package U;

import M5.m;
import android.net.Uri;
import java.io.File;

/* loaded from: classes.dex */
public abstract class b {
    public static final File a(Uri uri) {
        if (!m.a(uri.getScheme(), "file")) {
            throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
    }
}
