package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
class MediaBrowserCompat$SearchResultReceiver extends c.b {

    /* renamed from: o, reason: collision with root package name */
    public final String f10914o;

    /* renamed from: p, reason: collision with root package name */
    public final Bundle f10915p;

    /* renamed from: q, reason: collision with root package name */
    public final d f10916q;

    @Override // c.b
    public void b(int i7, Bundle bundle) {
        if (bundle != null) {
            bundle = MediaSessionCompat.b(bundle);
        }
        if (i7 != 0 || bundle == null || !bundle.containsKey("search_results")) {
            this.f10916q.a(this.f10914o, this.f10915p);
            return;
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
        if (parcelableArray == null) {
            this.f10916q.a(this.f10914o, this.f10915p);
            return;
        }
        ArrayList arrayList = new ArrayList(parcelableArray.length);
        for (Parcelable parcelable : parcelableArray) {
            arrayList.add((MediaBrowserCompat$MediaItem) parcelable);
        }
        this.f10916q.b(this.f10914o, this.f10915p, arrayList);
    }
}
