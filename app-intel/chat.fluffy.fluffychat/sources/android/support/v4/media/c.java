package android.support.v4.media;

import android.media.browse.MediaBrowser;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final MediaBrowser.ItemCallback f10941a = new a();

    public class a extends MediaBrowser.ItemCallback {
        public a() {
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onError(String str) {
            c.this.a(str);
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
            c.this.b(MediaBrowserCompat$MediaItem.b(mediaItem));
        }
    }

    public void a(String str) {
    }

    public void b(MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem) {
    }
}
