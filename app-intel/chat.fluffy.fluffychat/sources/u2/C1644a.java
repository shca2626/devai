package u2;

import M5.m;
import android.net.Uri;
import java.io.File;

/* renamed from: u2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1644a implements b {
    @Override // u2.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        String strC;
        m.e(uri, "data");
        return (!m.a(uri.getScheme(), "file") || (strC = C2.e.c(uri)) == null || m.a(strC, "android_asset")) ? false : true;
    }

    @Override // u2.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public File b(Uri uri) {
        m.e(uri, "data");
        return U.b.a(uri);
    }
}
