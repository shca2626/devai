package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

/* loaded from: classes.dex */
class MediaBrowserCompat$ItemReceiver extends c.b {

    /* renamed from: o, reason: collision with root package name */
    public final String f10910o;

    /* renamed from: p, reason: collision with root package name */
    public final c f10911p;

    @Override // c.b
    public void b(int i7, Bundle bundle) {
        if (bundle != null) {
            bundle = MediaSessionCompat.b(bundle);
        }
        if (i7 != 0 || bundle == null || !bundle.containsKey("media_item")) {
            this.f10911p.a(this.f10910o);
            return;
        }
        Parcelable parcelable = bundle.getParcelable("media_item");
        if (parcelable == null || (parcelable instanceof MediaBrowserCompat$MediaItem)) {
            this.f10911p.b((MediaBrowserCompat$MediaItem) parcelable);
        } else {
            this.f10911p.a(this.f10910o);
        }
    }
}
