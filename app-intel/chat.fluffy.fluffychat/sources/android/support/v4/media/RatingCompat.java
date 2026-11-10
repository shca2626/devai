package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* renamed from: l, reason: collision with root package name */
    public final int f10939l;

    /* renamed from: m, reason: collision with root package name */
    public final float f10940m;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RatingCompat[] newArray(int i7) {
            return new RatingCompat[i7];
        }
    }

    public RatingCompat(int i7, float f7) {
        this.f10939l = i7;
        this.f10940m = f7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f10939l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f10939l);
        sb.append(" rating=");
        float f7 = this.f10940m;
        sb.append(f7 < 0.0f ? "unrated" : String.valueOf(f7));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f10939l);
        parcel.writeFloat(this.f10940m);
    }
}
