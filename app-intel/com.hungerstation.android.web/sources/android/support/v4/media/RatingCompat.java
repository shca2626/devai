package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes6.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    private final int f1790b;

    /* renamed from: c, reason: collision with root package name */
    private final float f1791c;

    class a implements Parcelable.Creator<RatingCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RatingCompat[] newArray(int i12) {
            return new RatingCompat[i12];
        }
    }

    RatingCompat(int i12, float f12) {
        this.f1790b = i12;
        this.f1791c = f12;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f1790b;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Rating:style=");
        sb2.append(this.f1790b);
        sb2.append(" rating=");
        float f12 = this.f1791c;
        sb2.append(f12 < BitmapDescriptorFactory.HUE_RED ? "unrated" : String.valueOf(f12));
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i12) {
        parcel.writeInt(this.f1790b);
        parcel.writeFloat(this.f1791c);
    }
}
