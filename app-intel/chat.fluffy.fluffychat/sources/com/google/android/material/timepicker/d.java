package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: l, reason: collision with root package name */
    public final com.google.android.material.timepicker.a f14791l;

    /* renamed from: m, reason: collision with root package name */
    public final com.google.android.material.timepicker.a f14792m;

    /* renamed from: n, reason: collision with root package name */
    public final int f14793n;

    /* renamed from: o, reason: collision with root package name */
    public int f14794o;

    /* renamed from: p, reason: collision with root package name */
    public int f14795p;

    /* renamed from: q, reason: collision with root package name */
    public int f14796q;

    /* renamed from: r, reason: collision with root package name */
    public int f14797r;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i7) {
            return new d[i7];
        }
    }

    public d() {
        this(0);
    }

    public static String b(Resources resources, CharSequence charSequence) {
        return c(resources, charSequence, "%02d");
    }

    public static String c(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    public static int e(int i7) {
        return i7 >= 12 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f14794o == dVar.f14794o && this.f14795p == dVar.f14795p && this.f14793n == dVar.f14793n && this.f14796q == dVar.f14796q;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f14793n), Integer.valueOf(this.f14794o), Integer.valueOf(this.f14795p), Integer.valueOf(this.f14796q)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f14794o);
        parcel.writeInt(this.f14795p);
        parcel.writeInt(this.f14796q);
        parcel.writeInt(this.f14793n);
    }

    public d(int i7) {
        this(0, 0, 10, i7);
    }

    public d(int i7, int i8, int i9, int i10) {
        this.f14794o = i7;
        this.f14795p = i8;
        this.f14796q = i9;
        this.f14793n = i10;
        this.f14797r = e(i7);
        this.f14791l = new com.google.android.material.timepicker.a(59);
        this.f14792m = new com.google.android.material.timepicker.a(i10 == 1 ? 24 : 12);
    }

    public d(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
