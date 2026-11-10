package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* renamed from: l, reason: collision with root package name */
    public final String f10917l;

    /* renamed from: m, reason: collision with root package name */
    public final CharSequence f10918m;

    /* renamed from: n, reason: collision with root package name */
    public final CharSequence f10919n;

    /* renamed from: o, reason: collision with root package name */
    public final CharSequence f10920o;

    /* renamed from: p, reason: collision with root package name */
    public final Bitmap f10921p;

    /* renamed from: q, reason: collision with root package name */
    public final Uri f10922q;

    /* renamed from: r, reason: collision with root package name */
    public final Bundle f10923r;

    /* renamed from: s, reason: collision with root package name */
    public final Uri f10924s;

    /* renamed from: t, reason: collision with root package name */
    public MediaDescription f10925t;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.b(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i7) {
            return new MediaDescriptionCompat[i7];
        }
    }

    public static class b {
        public static MediaDescription a(MediaDescription.Builder builder) {
            return builder.build();
        }

        public static MediaDescription.Builder b() {
            return new MediaDescription.Builder();
        }

        public static CharSequence c(MediaDescription mediaDescription) {
            return mediaDescription.getDescription();
        }

        public static Bundle d(MediaDescription mediaDescription) {
            return mediaDescription.getExtras();
        }

        public static Bitmap e(MediaDescription mediaDescription) {
            return mediaDescription.getIconBitmap();
        }

        public static Uri f(MediaDescription mediaDescription) {
            return mediaDescription.getIconUri();
        }

        public static String g(MediaDescription mediaDescription) {
            return mediaDescription.getMediaId();
        }

        public static CharSequence h(MediaDescription mediaDescription) {
            return mediaDescription.getSubtitle();
        }

        public static CharSequence i(MediaDescription mediaDescription) {
            return mediaDescription.getTitle();
        }

        public static void j(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        public static void k(MediaDescription.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }

        public static void l(MediaDescription.Builder builder, Bitmap bitmap) {
            builder.setIconBitmap(bitmap);
        }

        public static void m(MediaDescription.Builder builder, Uri uri) {
            builder.setIconUri(uri);
        }

        public static void n(MediaDescription.Builder builder, String str) {
            builder.setMediaId(str);
        }

        public static void o(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        public static void p(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setTitle(charSequence);
        }
    }

    public static class c {
        public static Uri a(MediaDescription mediaDescription) {
            return mediaDescription.getMediaUri();
        }

        public static void b(MediaDescription.Builder builder, Uri uri) {
            builder.setMediaUri(uri);
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public String f10926a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f10927b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f10928c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f10929d;

        /* renamed from: e, reason: collision with root package name */
        public Bitmap f10930e;

        /* renamed from: f, reason: collision with root package name */
        public Uri f10931f;

        /* renamed from: g, reason: collision with root package name */
        public Bundle f10932g;

        /* renamed from: h, reason: collision with root package name */
        public Uri f10933h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f10926a, this.f10927b, this.f10928c, this.f10929d, this.f10930e, this.f10931f, this.f10932g, this.f10933h);
        }

        public d b(CharSequence charSequence) {
            this.f10929d = charSequence;
            return this;
        }

        public d c(Bundle bundle) {
            this.f10932g = bundle;
            return this;
        }

        public d d(Bitmap bitmap) {
            this.f10930e = bitmap;
            return this;
        }

        public d e(Uri uri) {
            this.f10931f = uri;
            return this;
        }

        public d f(String str) {
            this.f10926a = str;
            return this;
        }

        public d g(Uri uri) {
            this.f10933h = uri;
            return this;
        }

        public d h(CharSequence charSequence) {
            this.f10928c = charSequence;
            return this;
        }

        public d i(CharSequence charSequence) {
            this.f10927b = charSequence;
            return this;
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f10917l = str;
        this.f10918m = charSequence;
        this.f10919n = charSequence2;
        this.f10920o = charSequence3;
        this.f10921p = bitmap;
        this.f10922q = uri;
        this.f10923r = bundle;
        this.f10924s = uri2;
    }

    public static MediaDescriptionCompat b(Object obj) {
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        d dVar = new d();
        MediaDescription mediaDescription = (MediaDescription) obj;
        dVar.f(b.g(mediaDescription));
        dVar.i(b.i(mediaDescription));
        dVar.h(b.h(mediaDescription));
        dVar.b(b.c(mediaDescription));
        dVar.d(b.e(mediaDescription));
        dVar.e(b.f(mediaDescription));
        Bundle bundleD = b.d(mediaDescription);
        if (bundleD != null) {
            bundleD = MediaSessionCompat.b(bundleD);
        }
        Uri uri = bundleD != null ? (Uri) bundleD.getParcelable("android.support.v4.media.description.MEDIA_URI") : null;
        if (uri == null) {
            bundle = bundleD;
        } else if (!bundleD.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || bundleD.size() != 2) {
            bundleD.remove("android.support.v4.media.description.MEDIA_URI");
            bundleD.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = bundleD;
        }
        dVar.c(bundle);
        if (uri != null) {
            dVar.g(uri);
        } else {
            dVar.g(c.a(mediaDescription));
        }
        MediaDescriptionCompat mediaDescriptionCompatA = dVar.a();
        mediaDescriptionCompatA.f10925t = mediaDescription;
        return mediaDescriptionCompatA;
    }

    public Object c() {
        MediaDescription mediaDescription = this.f10925t;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        MediaDescription.Builder builderB = b.b();
        b.n(builderB, this.f10917l);
        b.p(builderB, this.f10918m);
        b.o(builderB, this.f10919n);
        b.j(builderB, this.f10920o);
        b.l(builderB, this.f10921p);
        b.m(builderB, this.f10922q);
        b.k(builderB, this.f10923r);
        c.b(builderB, this.f10924s);
        MediaDescription mediaDescriptionA = b.a(builderB);
        this.f10925t = mediaDescriptionA;
        return mediaDescriptionA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f10917l;
    }

    public String toString() {
        return ((Object) this.f10918m) + ", " + ((Object) this.f10919n) + ", " + ((Object) this.f10920o);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        ((MediaDescription) c()).writeToParcel(parcel, i7);
    }
}
