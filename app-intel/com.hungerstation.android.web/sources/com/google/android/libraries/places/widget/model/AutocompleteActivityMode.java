package com.google.android.libraries.places.widget.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
public enum AutocompleteActivityMode implements Parcelable {
    FULLSCREEN,
    OVERLAY;

    public static final Parcelable.Creator<AutocompleteActivityMode> CREATOR = new Parcelable.Creator<AutocompleteActivityMode>() { // from class: com.google.android.libraries.places.widget.model.zza
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AutocompleteActivityMode createFromParcel(Parcel parcel) {
            return AutocompleteActivityMode.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AutocompleteActivityMode[] newArray(int i12) {
            return new AutocompleteActivityMode[i12];
        }
    };

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i12) {
        parcel.writeString(name());
    }
}
