package android.support.v4.media;

import android.annotation.SuppressLint;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new a();

    /* renamed from: l, reason: collision with root package name */
    public final int f10912l;

    /* renamed from: m, reason: collision with root package name */
    public final MediaDescriptionCompat f10913m;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaBrowserCompat$MediaItem createFromParcel(Parcel parcel) {
            return new MediaBrowserCompat$MediaItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaBrowserCompat$MediaItem[] newArray(int i7) {
            return new MediaBrowserCompat$MediaItem[i7];
        }
    }

    public MediaBrowserCompat$MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i7) {
        if (mediaDescriptionCompat == null) {
            throw new IllegalArgumentException("description cannot be null");
        }
        if (TextUtils.isEmpty(mediaDescriptionCompat.e())) {
            throw new IllegalArgumentException("description must have a non-empty media id");
        }
        this.f10912l = i7;
        this.f10913m = mediaDescriptionCompat;
    }

    public static MediaBrowserCompat$MediaItem b(Object obj) {
        if (obj == null) {
            return null;
        }
        MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) obj;
        return new MediaBrowserCompat$MediaItem(MediaDescriptionCompat.b(android.support.v4.media.a.a(mediaItem)), android.support.v4.media.a.b(mediaItem));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MediaItem{mFlags=" + this.f10912l + ", mDescription=" + this.f10913m + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f10912l);
        this.f10913m.writeToParcel(parcel, i7);
    }

    public MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.f10912l = parcel.readInt();
        this.f10913m = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }
}
