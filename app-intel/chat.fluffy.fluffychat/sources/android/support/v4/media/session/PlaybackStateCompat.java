package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* renamed from: l, reason: collision with root package name */
    public final int f10956l;

    /* renamed from: m, reason: collision with root package name */
    public final long f10957m;

    /* renamed from: n, reason: collision with root package name */
    public final long f10958n;

    /* renamed from: o, reason: collision with root package name */
    public final float f10959o;

    /* renamed from: p, reason: collision with root package name */
    public final long f10960p;

    /* renamed from: q, reason: collision with root package name */
    public final int f10961q;

    /* renamed from: r, reason: collision with root package name */
    public final CharSequence f10962r;

    /* renamed from: s, reason: collision with root package name */
    public final long f10963s;

    /* renamed from: t, reason: collision with root package name */
    public List f10964t;

    /* renamed from: u, reason: collision with root package name */
    public final long f10965u;

    /* renamed from: v, reason: collision with root package name */
    public final Bundle f10966v;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: l, reason: collision with root package name */
        public final String f10967l;

        /* renamed from: m, reason: collision with root package name */
        public final CharSequence f10968m;

        /* renamed from: n, reason: collision with root package name */
        public final int f10969n;

        /* renamed from: o, reason: collision with root package name */
        public final Bundle f10970o;

        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i7) {
                return new CustomAction[i7];
            }
        }

        public CustomAction(Parcel parcel) {
            this.f10967l = parcel.readString();
            this.f10968m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f10969n = parcel.readInt();
            this.f10970o = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f10968m) + ", mIcon=" + this.f10969n + ", mExtras=" + this.f10970o;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeString(this.f10967l);
            TextUtils.writeToParcel(this.f10968m, parcel, i7);
            parcel.writeInt(this.f10969n);
            parcel.writeBundle(this.f10970o);
        }
    }

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i7) {
            return new PlaybackStateCompat[i7];
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f10956l = parcel.readInt();
        this.f10957m = parcel.readLong();
        this.f10959o = parcel.readFloat();
        this.f10963s = parcel.readLong();
        this.f10958n = parcel.readLong();
        this.f10960p = parcel.readLong();
        this.f10962r = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f10964t = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f10965u = parcel.readLong();
        this.f10966v = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f10961q = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f10956l + ", position=" + this.f10957m + ", buffered position=" + this.f10958n + ", speed=" + this.f10959o + ", updated=" + this.f10963s + ", actions=" + this.f10960p + ", error code=" + this.f10961q + ", error message=" + this.f10962r + ", custom actions=" + this.f10964t + ", active item id=" + this.f10965u + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f10956l);
        parcel.writeLong(this.f10957m);
        parcel.writeFloat(this.f10959o);
        parcel.writeLong(this.f10963s);
        parcel.writeLong(this.f10958n);
        parcel.writeLong(this.f10960p);
        TextUtils.writeToParcel(this.f10962r, parcel, i7);
        parcel.writeTypedList(this.f10964t);
        parcel.writeLong(this.f10965u);
        parcel.writeBundle(this.f10966v);
        parcel.writeInt(this.f10961q);
    }
}
