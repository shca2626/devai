package u2;

import M5.m;
import android.net.Uri;
import u2.b;

/* loaded from: classes.dex */
public final class e implements b {
    @Override // u2.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(String str) {
        return b.a.a(this, str);
    }

    @Override // u2.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Uri b(String str) {
        m.e(str, "data");
        Uri uri = Uri.parse(str);
        m.d(uri, "parse(this)");
        return uri;
    }
}
