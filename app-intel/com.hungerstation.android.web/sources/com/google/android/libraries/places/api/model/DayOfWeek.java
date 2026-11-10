package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public enum DayOfWeek implements Parcelable {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    public static final Parcelable.Creator<DayOfWeek> CREATOR = new Parcelable.Creator<DayOfWeek>() { // from class: com.google.android.libraries.places.api.model.zzbb
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DayOfWeek createFromParcel(Parcel parcel) {
            return DayOfWeek.zza(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DayOfWeek[] newArray(int i12) {
            return new DayOfWeek[i12];
        }
    };

    static DayOfWeek zza(Parcel parcel) {
        return valueOf(parcel.readString());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i12) {
        parcel.writeString(name());
    }
}
