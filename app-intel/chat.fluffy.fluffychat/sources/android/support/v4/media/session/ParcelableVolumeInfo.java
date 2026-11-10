package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* renamed from: l, reason: collision with root package name */
    public int f10951l;

    /* renamed from: m, reason: collision with root package name */
    public int f10952m;

    /* renamed from: n, reason: collision with root package name */
    public int f10953n;

    /* renamed from: o, reason: collision with root package name */
    public int f10954o;

    /* renamed from: p, reason: collision with root package name */
    public int f10955p;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i7) {
            return new ParcelableVolumeInfo[i7];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f10951l = parcel.readInt();
        this.f10953n = parcel.readInt();
        this.f10954o = parcel.readInt();
        this.f10955p = parcel.readInt();
        this.f10952m = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f10951l);
        parcel.writeInt(this.f10953n);
        parcel.writeInt(this.f10954o);
        parcel.writeInt(this.f10955p);
        parcel.writeInt(this.f10952m);
    }
}
