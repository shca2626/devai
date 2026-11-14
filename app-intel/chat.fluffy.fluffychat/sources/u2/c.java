package u2;

import M5.m;
import android.content.Context;
import android.net.Uri;
import com.fasterxml.jackson.core.JsonPointer;

/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f22789a;

    public c(Context context) {
        m.e(context, "context");
        this.f22789a = context;
    }

    @Override // u2.b
    public /* bridge */ /* synthetic */ boolean a(Object obj) {
        return c(((Number) obj).intValue());
    }

    @Override // u2.b
    public /* bridge */ /* synthetic */ Object b(Object obj) {
        return d(((Number) obj).intValue());
    }

    public boolean c(int i7) {
        return this.f22789a.getResources().getResourceEntryName(i7) != null;
    }

    public Uri d(int i7) {
        Uri uri = Uri.parse("android.resource://" + ((Object) this.f22789a.getPackageName()) + JsonPointer.SEPARATOR + i7);
        m.d(uri, "parse(this)");
        return uri;
    }
}
