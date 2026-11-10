package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes6.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public int f1806b;

    /* renamed from: c, reason: collision with root package name */
    public int f1807c;

    /* renamed from: d, reason: collision with root package name */
    public int f1808d;

    /* renamed from: e, reason: collision with root package name */
    public int f1809e;

    /* renamed from: f, reason: collision with root package name */
    public int f1810f;

    class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i12) {
            return new ParcelableVolumeInfo[i12];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f1806b = parcel.readInt();
        this.f1808d = parcel.readInt();
        this.f1809e = parcel.readInt();
        this.f1810f = parcel.readInt();
        this.f1807c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i12) {
        parcel.writeInt(this.f1806b);
        parcel.writeInt(this.f1808d);
        parcel.writeInt(this.f1809e);
        parcel.writeInt(this.f1810f);
        parcel.writeInt(this.f1807c);
    }
}
