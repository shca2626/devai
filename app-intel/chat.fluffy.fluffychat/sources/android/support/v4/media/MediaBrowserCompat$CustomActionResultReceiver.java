package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;

/* loaded from: classes.dex */
class MediaBrowserCompat$CustomActionResultReceiver extends c.b {

    /* renamed from: o, reason: collision with root package name */
    public final String f10907o;

    /* renamed from: p, reason: collision with root package name */
    public final Bundle f10908p;

    /* renamed from: q, reason: collision with root package name */
    public final b f10909q;

    @Override // c.b
    public void b(int i7, Bundle bundle) {
        if (this.f10909q == null) {
            return;
        }
        MediaSessionCompat.a(bundle);
        if (i7 == -1) {
            this.f10909q.a(this.f10907o, this.f10908p, bundle);
            return;
        }
        if (i7 == 0) {
            this.f10909q.c(this.f10907o, this.f10908p, bundle);
            return;
        }
        if (i7 == 1) {
            this.f10909q.b(this.f10907o, this.f10908p, bundle);
            return;
        }
        Log.w("MediaBrowserCompat", "Unknown result code: " + i7 + " (extras=" + this.f10908p + ", resultData=" + bundle + ")");
    }
}
